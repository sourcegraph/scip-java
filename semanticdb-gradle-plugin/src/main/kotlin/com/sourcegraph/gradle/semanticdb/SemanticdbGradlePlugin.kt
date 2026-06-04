package com.sourcegraph.gradle.semanticdb

import com.sourcegraph.scip_java.GradlePluginBuildInfo
import java.io.File
import java.lang.reflect.Method
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import org.gradle.api.Action
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.compile.JavaCompile

class SemanticdbGradlePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.afterEvaluate(
            Action<Project> { p ->
                p.repositories.add(p.repositories.mavenCentral())
                p.repositories.add(p.repositories.mavenLocal())

                val extra = p.extensions.extraProperties
                val extraProperties: Map<String, Any?> = extra.properties

                val targetRoot: Any =
                    extraProperties["semanticdbTarget"] ?: p.buildDir

                val javacPluginVersion = GradlePluginBuildInfo.version
                val javacPluginJar = extraProperties["javacPluginJar"] as String?

                val javacPluginDep: Any =
                    if (javacPluginJar != null)
                        p.files(javacPluginJar)
                    // We fall back to the javac plugin published to Maven if no jar
                    // is specified. The JAR would usually be provided by auto-indexer.
                    else
                        "com.sourcegraph:semanticdb-javac:$javacPluginVersion"

                val sourceRoot = p.rootDir
                val tasks = p.tasks

                // List of compilation commands that we need to trigger to index
                // all the sources in the project we care about. This list is
                // built progressively as we check for java and kotlin plugins.
                val triggers = mutableListOf<String>()

                if (p.plugins.hasPlugin("java")) {
                    triggers += "compileJava"
                    triggers += "compileTestJava"

                    val hasAnnotationPath =
                        try {
                            val apConfig =
                                p.configurations.getByName("annotationProcessor")
                            apConfig.isCanBeResolved &&
                                apConfig.dependencies.size > 0
                        } catch (_: Exception) {
                            false
                        }

                    val compilerPluginAdded =
                        try {
                            p.dependencies.add("compileOnly", javacPluginDep)

                            if (hasAnnotationPath) {
                                p.dependencies
                                    .add("annotationProcessor", javacPluginDep)
                            }

                            p.dependencies.add("testCompileOnly", javacPluginDep)

                            true
                        } catch (exc: Exception) {
                            // The `compileOnly` configuration has likely already been
                            // resolved by another plugin or buildscript, so we can no
                            // longer add new dependencies to it. The project will be
                            // skipped (no SemanticDB output) and the post-build check
                            // in `GradleBuildTool` will surface a clearer error.
                            Logging.warn(
                                "scip-java: failed to attach SemanticDB compiler " +
                                    "plugin to project '${p.name}' " +
                                    "(${exc.javaClass.simpleName}: ${exc.message}). " +
                                    "This subproject will not be indexed."
                            )
                            false
                        }

                    p.tasks
                        .withType(JavaCompile::class.java)
                        .configureEach(
                            Action<JavaCompile> { task ->
                                // Add --add-exports JVM args so our compiler plugin
                                // can access javac internals. Required on JDK 17+
                                // (JEP 403), no-op on 11-16.
                                val forkOptions = task.options.forkOptions
                                val jvmArgs =
                                    GradlePluginBuildInfo
                                        .javacModuleOptions
                                        .map { it.removePrefix("-J") }
                                val existing = forkOptions.jvmArgs
                                if (existing == null) {
                                    forkOptions.jvmArgs = jvmArgs
                                } else {
                                    existing.addAll(jvmArgs)
                                }

                                task.options.isFork = true
                                task.options.isIncremental = false

                                if (compilerPluginAdded) {
                                    val args = task.options.compilerArgs

                                    // It's important we don't add the plugin
                                    // configuration more than once, as javac
                                    // considers that an error.
                                    if (args.none {
                                            it.startsWith("-Xplugin:semanticdb")
                                        }
                                    ) {
                                        args.add(
                                            // We add this to ensure that the sources
                                            // are _always_ recompiled, so that Gradle
                                            // doesn't cache any state.
                                            // TODO: before this plugin is published to
                                            // Maven Central, we will need to revert
                                            // this change - as it can have detrimental
                                            // effect on people's builds.
                                            "-Xplugin:semanticdb " +
                                                "-targetroot:$targetRoot " +
                                                "-sourceroot:$sourceRoot " +
                                                "-randomtimestamp=${System.nanoTime()}"
                                        )
                                    }
                                }
                            }
                        )
                }

                val isKotlinMultiplatform =
                    p.plugins.any { it.javaClass.name.contains("KotlinMultiplatform") }

                if (p.plugins.hasPlugin("kotlin") || isKotlinMultiplatform) {
                    if (isKotlinMultiplatform) {
                        triggers += "compileKotlinJvm"
                        triggers += "compileTestKotlinJvm"
                    } else {
                        triggers += "compileKotlin"
                        triggers += "compileTestKotlin"
                    }

                    p.tasks.configureEach(
                        Action<Task> { task ->
                            if (task.javaClass.simpleName.contains("KotlinCompile")) {
                                configureKotlinCompileTask(
                                    task = task,
                                    sourceRoot = sourceRoot,
                                    targetRoot = targetRoot,
                                    extraProperties = extraProperties
                                )
                            }
                        }
                    )
                }

                tasks.create(
                    "scipCompileAll",
                    Action<Task> { task ->
                        triggers.forEach { trigger ->
                            task.dependsOn(tasks.getByName(trigger))
                        }
                    }
                )

                tasks.create("scipPrintDependencies", WriteDependencies::class.java)
            }
        )
    }

    private fun configureKotlinCompileTask(
        task: Task,
        sourceRoot: File,
        targetRoot: Any,
        extraProperties: Map<String, Any?>
    ) {
        // Do not reference org.jetbrains.kotlin.gradle.tasks.KotlinCompile here.
        //
        // This plugin is loaded from a Gradle init script with only the assembled
        // gradle-plugin.jar on the initscript classpath. The target build may or
        // may not have the Kotlin Gradle Plugin loaded by Gradle's plugin
        // classloader. A direct symbolic reference to KotlinCompile can cause
        // NoClassDefFoundError when this plugin class is loaded.
        //
        // Instead, reflect on the actual task instance Gradle gives us. This
        // mirrors the structural-typing approach the previous Scala implementation
        // used (see SemanticdbGradlePlugin.scala, lines 162-179).
        val kotlinOptions = task.invokeNoArg("getKotlinOptions")
        val getFreeCompilerArgs = kotlinOptions.findNoArgMethod("getFreeCompilerArgs")
        val setFreeCompilerArgs = kotlinOptions.findOneArgMethod("setFreeCompilerArgs")

        @Suppress("UNCHECKED_CAST")
        val existingArgs = getFreeCompilerArgs.invoke(kotlinOptions) as List<String>

        // The semanticdb-kotlinc compiler plugin is built and shipped together
        // with the scip-java CLI. The CLI's init script writes the absolute path
        // of the embedded jar into the `semanticdbKotlincJar` extra property, so
        // we no longer need to resolve a separately-published artifact at
        // apply-time.
        val semanticdbKotlinc =
            (extraProperties["semanticdbKotlincJar"] as String?)
                ?: throw IllegalStateException(
                    "semanticdbKotlincJar extra property must be set by the " +
                        "scip-java init script when indexing Kotlin sources"
                )

        val newArgs = ArrayList<String>(existingArgs.size + 5)
        newArgs.addAll(existingArgs)
        newArgs.addAll(
            listOf(
                "-Xplugin=$semanticdbKotlinc",
                "-P",
                "plugin:semanticdb-kotlinc:sourceroot=$sourceRoot",
                "-P",
                "plugin:semanticdb-kotlinc:targetroot=$targetRoot"
            )
        )

        setFreeCompilerArgs.invoke(kotlinOptions, newArgs)
    }

    private fun Any.invokeNoArg(name: String): Any =
        findNoArgMethod(name).invoke(this)

    private fun Any.findNoArgMethod(name: String): Method =
        javaClass.methods.firstOrNull {
            it.name == name && it.parameterCount == 0
        } ?: throw NoSuchMethodException("${javaClass.name}.$name()")

    private fun Any.findOneArgMethod(name: String): Method =
        javaClass.methods.firstOrNull {
            it.name == name && it.parameterCount == 1
        } ?: throw NoSuchMethodException("${javaClass.name}.$name(<arg>)")
}

open class WriteDependencies : DefaultTask() {
    @TaskAction
    fun printResolvedDependencies() {
        val depsOut =
            project.extensions.extraProperties.properties["dependenciesOut"]
                ?.toString()
                ?.let { Paths.get(it) }

        depsOut?.parent?.let { Files.createDirectories(it) }

        val deps = mutableListOf<String>()
        val projectName = project.name
        val projectPath =
            project.path.replace(Regex("[^a-z0-9A-Z_-]"), "_")
        val dependenciesPath =
            depsOut?.let { path ->
                val filename = path.fileName
                if (filename.endsWith("dependencies.txt")) {
                    path.parent.resolve("$projectPath.$filename")
                } else {
                    path
                }
            }

        // List the project itself as a dependency so that we can assign project
        // name/version to symbols that are defined in this project.
        //
        // The code below is roughly equivalent to the following with Groovy:
        //   deps += "$publication.groupId $publication.artifactId $publication.version $sourceSets.main.output.classesDirectory"

        val crossRepoBanner =
            """
            |This will not prevent a SCIP index from being created, but the symbols 
            |extracted from this project won't be available for cross-repository navigation,
            |as this project doesn't define any Maven coordinates by which it can be referred back to.
            |See here for more details: https://sourcegraph.github.io/scip-java/docs/manual-configuration.html#step-5-optional-enable-cross-repository-navigation
            """

        try {
            val publications =
                project.extensions
                    .findByType(PublishingExtension::class.java)!!
                    .publications
                    .withType(MavenPublication::class.java)

            publications.forEach { publication ->
                try {
                    val main =
                        project.extensions
                            .getByType(SourceSetContainer::class.java)
                            .getByName("main")

                    main.output
                        .classesDirs
                        .files
                        .map { it.absolutePath }
                        .sorted()
                        .take(1)
                        .forEach { classesDirectory ->
                            deps +=
                                listOf(
                                    publication.groupId,
                                    publication.artifactId,
                                    publication.version,
                                    classesDirectory
                                ).joinToString("\t")
                        }
                } catch (exception: Exception) {
                    val publicationName =
                        listOf(
                            publication.groupId,
                            publication.artifactId,
                            publication.version
                        ).joinToString(":")

                    Logging.warn(
                        """
                        |Failed to extract `main` source set from publication `$publicationName` in project `$projectName``. 
                                $crossRepoBanner
                        |Here's the raw error message:
                        |  "${exception.message}"
                        |Continuing without cross-repository support.
                        """.trimMargin().trim()
                    )
                }
            }
        } catch (exception: Exception) {
            Logging.warn(
                """
                |Failed to extract Maven publication from the project `$projectName`. 
                    $crossRepoBanner
                |Here's the raw error message (${exception.javaClass}):
                |  "${exception.message}"
                |Continuing without cross-repository support.
                """.trimMargin().trim()
            )
        }

        project.configurations.forEach { conf ->
            if (conf.isCanBeResolved) {
                try {
                    val resolved = conf.resolvedConfiguration
                    resolved.resolvedArtifacts.forEach { artifact ->
                        val id = artifact.moduleVersion.id
                        deps +=
                            listOf(
                                id.group,
                                id.name,
                                id.version,
                                artifact.file.absolutePath
                            ).joinToString("\t")
                    }
                } catch (exc: Exception) {
                    println(
                        "Skipping configuration '${conf.name}' due to resolution failure: ${exc.message}"
                    )
                }
            }
        }

        val dependencies = deps.distinct()

        if (dependenciesPath == null) {
            dependencies.forEach { println(it) }
        } else {
            Files.write(
                dependenciesPath,
                dependencies,
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE
            )
        }
    }
}

private object Logging {
    fun info(vararg msg: Any?) {
        System.err.println(
            "[INFO] [scip-java.gradle] ${msg.joinToString(" ")}"
        )
    }

    fun warn(vararg msg: Any?) {
        System.err.println(
            "[WARNING] [scip-java.gradle] ${msg.joinToString(" ")}"
        )
    }
}
