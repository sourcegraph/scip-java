/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.sourcegraph.gradle.semanticdb

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.component.ModuleComponentIdentifier
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.scala.ScalaCompile
import java.lang.Runtime.Version

/**
 * A simple 'hello world' plugin.
 */
class SemanticdbGradlePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val exports = arrayOf(
                "--add-exports",
                "jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
                "--add-exports",
                "jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
                "--add-exports",
                "jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
                "--add-exports",
                "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
                "--add-exports",
                "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
        )

        val semanticdbJavacVersion = System.getProperties().getOrDefault("semanticdb.javac.version", "0.8.16")

        project.repositories.add(project.repositories.mavenCentral())
        project.dependencies.add("compileOnly", "com.sourcegraph:semanticdb-javac:$semanticdbJavacVersion")
        project.dependencies.add("testCompileOnly", "com.sourcegraph:semanticdb-javac:$semanticdbJavacVersion")



        val targetRoot = project.rootDir.resolve("semanticdb-targetroot")
        val sourceRoot = project.rootDir

        project.tasks.withType(JavaCompile::class.java).configureEach { task ->

            task.doFirst {
                println("Performing some setup before any other plugins are applied...")
                val metadata = task.javaCompiler.get().metadata
                if (!metadata.javaRuntimeVersion.startsWith("1.8")) {

                    val version = Version.parse(metadata.javaRuntimeVersion)
                    if (version.feature() >= 17) {
                        if (task.options.forkOptions.jvmArgs != null) {
                            task.options.forkOptions.jvmArgs!!.addAll(exports)
                        } else {
                            task.options.forkOptions.jvmArgs = exports.toList()
                        }
                    }
                }
                task.options.fork(emptyMap())
                task.options.compilerArgs.add("-Xplugin:semanticdb -targetroot:$targetRoot -sourceroot:$sourceRoot")
            }
        }

        project.tasks.withType(ScalaCompile::class.java).configureEach { task ->

            val scalaCompileOptions = task.scalaCompileOptions


            val scalaVersion = findScalaVersion(project)
            val semanticdbVersion = "4.5.13" // TODO: pick up from system properties
            val semanticdbScalacDependency = "org.scalameta:semanticdb-scalac_$scalaVersion:$semanticdbVersion"
            val semanticdbScalac = project.configurations.detachedConfiguration(project.dependencies.create(semanticdbScalacDependency)).files.toList()[0]

            // We use mutable List here to cover both Gradle 7.3.x and 8.x
            // see https://github.com/gradle/gradle/issues/23193 for details
            val args = mutableListOf("-Xplugin:$semanticdbScalac",
                    "-P:semanticdb:sourceroot:$sourceRoot",
                    "-P:semanticdb:targetroot:$targetRoot",
                    "-P:semanticdb:exclude:(src/play/twirl|src/play/routes)", // Ignore autogenerated Playframework files
                    "-P:semanticdb:failures:warning",
                    "-Xplugin-require:semanticdb")

            if (scalaCompileOptions.additionalParameters == null) scalaCompileOptions.additionalParameters = args
            else
                scalaCompileOptions.additionalParameters.addAll(args)
        }

    }


    private fun findScalaVersion(project: Project): String? {
        for (conf in project.configurations) {

            if (conf.isCanBeResolved && conf.name != "zinc") {

                for (artif in conf.incoming.artifactView { view -> view.lenient(true) }.artifacts) {

                    val id = artif.id.componentIdentifier
                    if (id is ModuleComponentIdentifier && id.group == "org.scala-lang" && id.module == "scala-library") {
                        return id.version
                    }
                }
            }
        }

        return null
    }

}