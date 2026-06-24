import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import com.google.protobuf.gradle.ProtobufExtension
import com.google.protobuf.gradle.proto
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.distribution.DistributionContainer
import org.gradle.api.plugins.JavaApplication
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.Sync
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.javadoc.Javadoc
import org.gradle.api.tasks.testing.Test
import org.gradle.external.javadoc.StandardJavadocDocletOptions
import org.gradle.language.jvm.tasks.ProcessResources
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.protobuf) apply false
    alias(libs.plugins.shadow) apply false
    alias(libs.plugins.vanniktech.maven.publish) apply false
}

val javacJvmOptions =
    listOf(
        "--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
        "--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
        "--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
        "--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
        "--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
    )
val catalog = libs
val protobufVersion = catalog.versions.protobuf.asProvider().get()
val repositoryUrl = "https://github.com/sourcegraph/scip-java"

allprojects {
    group = "com.sourcegraph"
    version = providers.gradleProperty("releaseVersion").orElse("0.0.0-SNAPSHOT").get()
}

subprojects {
    // Several modules also have Bazel `BUILD` files. On the default macOS
    // case-insensitive filesystem, Gradle's default `build/` directory collides
    // with those files, so keep Gradle outputs under the already-ignored target/.
    if (file("BUILD").isFile) {
        layout.buildDirectory.set(layout.projectDirectory.dir("target/gradle"))
    }

    plugins.withType<JavaPlugin> {
        extensions.configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        tasks.withType<JavaCompile>().configureEach {
            options.encoding = "UTF-8"
            options.release.set(11)
        }

        tasks.withType<Javadoc>().configureEach {
            options.encoding = "UTF-8"
            (options as StandardJavadocDocletOptions).addStringOption("Xdoclint:none", "-quiet")
        }

        tasks.withType<Test>().configureEach {
            useJUnitPlatform()
            testLogging {
                events("failed", "skipped")
            }
        }
    }

    plugins.withId("org.jetbrains.kotlin.jvm") {
        tasks.withType<KotlinCompile>().configureEach {
            compilerOptions.jvmTarget.set(JvmTarget.JVM_11)
        }
    }
}

fun Project.configureMavenPublishing() {
    apply(plugin = "com.vanniktech.maven.publish")

    extensions.configure<MavenPublishBaseExtension>("mavenPublishing") {
        publishToMavenCentral()
        signAllPublications()

        pom {
            name.set(project.name)
            description.set(project.description ?: project.name)
            url.set(repositoryUrl)
            licenses {
                license {
                    name.set("Apache-2.0")
                    url.set("http://www.apache.org/licenses/LICENSE-2.0")
                }
            }
            developers {
                developer {
                    id.set("sourcegraph")
                    name.set("Sourcegraph")
                }
            }
            scm {
                connection.set("scm:git:$repositoryUrl.git")
                developerConnection.set("scm:git:ssh://git@github.com/sourcegraph/scip-java.git")
                url.set(repositoryUrl)
            }
        }
    }
}

project(":scip-shared") {
    apply(plugin = "java-library")
    description = "Shared SCIP utilities used by scip-java compiler plugins"

    dependencies {
        "api"(catalog.scip.java.bindings)
    }

    configureMavenPublishing()
}

project(":scip-javac") {
    apply(plugin = "java-library")
    apply(plugin = "com.github.johnrengelman.shadow")
    description = "A javac plugin to emit SCIP information"

    dependencies {
        "api"(project(":scip-shared"))
        "testImplementation"(catalog.junit.jupiter.api)
        "testRuntimeOnly"(catalog.junit.jupiter.engine)
        "testRuntimeOnly"(catalog.junit.platform.launcher)
    }

    tasks.named<JavaCompile>("compileJava") {
        options.isDebug = true
        val emptyProcessorPath = layout.buildDirectory.dir("empty-processorpath")
        options.annotationProcessorPath = files(emptyProcessorPath)
        doFirst {
            emptyProcessorPath.get().asFile.mkdirs()
        }
    }

    tasks.named<Test>("test") {
        jvmArgs(javacJvmOptions)
    }

    tasks.named<ShadowJar>("shadowJar") {
        mergeServiceFiles()
        exclude("javax/**", "com/sun/**", "sun/**", "META-INF/versions/9/module-info.class")
        relocate("com.google", "com.sourcegraph.shaded.com.google")
        relocate("google", "com.sourcegraph.shaded.google")
        relocate("org.relaxng", "com.sourcegraph.shaded.relaxng")
        relocate("com.sourcegraph", "com.sourcegraph.shaded.com.sourcegraph") {
            exclude("com.sourcegraph.scip_javac.ScipPlugin")
            exclude("com.sourcegraph.scip_javac.InjectScipOptions")
        }
    }

    configureMavenPublishing()
}

project(":scip-kotlinc") {
    apply(plugin = "java-library")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.github.johnrengelman.shadow")
    description = "A kotlinc plugin to emit SCIP information"

    dependencies {
        "implementation"(project(":scip-shared"))
        "implementation"(catalog.scip.kotlin.bindings)
        "compileOnly"(catalog.kotlin.stdlib)
        "compileOnly"(catalog.kotlin.compiler.embeddable)

        "testImplementation"(catalog.kotlin.compiler.embeddable)
        "testImplementation"(catalog.kotlin.test)
        "testImplementation"(catalog.kotlin.test.junit5)
        "testImplementation"(catalog.kotlin.reflect)
        "testImplementation"(catalog.kotest.assertions.core)
        "testImplementation"(catalog.kctfork.core)
        "testRuntimeOnly"(catalog.junit.jupiter.engine)
        "testRuntimeOnly"(catalog.junit.platform.launcher)
    }

    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions.freeCompilerArgs.addAll("-Xinline-classes", "-Xcontext-parameters")
    }

    tasks.named<Test>("test") {
        jvmArgs("-Xmx2g")
    }

    tasks.named<ShadowJar>("shadowJar") {
        mergeServiceFiles()
        relocate("com.intellij", "org.jetbrains.kotlin.com.intellij")
    }

    configureMavenPublishing()
}

project(":scip-gradle-plugin") {
    apply(plugin = "java-library")
    apply(plugin = "com.github.johnrengelman.shadow")

    dependencies {
        "compileOnly"(catalog.gradle.api)
        "compileOnly"(catalog.gradle.test.kit)
    }
}

project(":scip-maven-plugin") {
    apply(plugin = "java-library")
    description = "A Maven plugin that exports dependency metadata for scip-java"

    dependencies {
        "implementation"(catalog.maven.plugin.api)
        "implementation"(catalog.maven.project)
        "compileOnly"(catalog.maven.plugin.annotations)
    }

    tasks.named<ProcessResources>("processResources") {
        exclude("META-INF/maven/plugin.template.xml")
        from("src/main/resources/META-INF/maven/plugin.template.xml") {
            into("META-INF/maven")
            rename { "plugin.xml" }
            filter { line: String -> line.replace("@VERSION@", project.version.toString()) }
        }
        inputs.property("version", project.version.toString())
    }

    configureMavenPublishing()
}

project(":scip-aggregator") {
    apply(plugin = "java-library")
    apply(plugin = "com.google.protobuf")
    description = "Aggregates compiler-plugin SCIP shards into a single SCIP index"

    dependencies {
        "api"(catalog.scip.java.bindings)
        "implementation"(project(":scip-shared"))
        "testImplementation"(catalog.junit.jupiter.api)
        "testRuntimeOnly"(catalog.junit.jupiter.engine)
        "testRuntimeOnly"(catalog.junit.platform.launcher)
    }

    extensions.configure<ProtobufExtension>("protobuf") {
        protoc {
            artifact = "com.google.protobuf:protoc:$protobufVersion"
        }
    }

    extensions.configure<SourceSetContainer> {
        named("main") {
            proto {
                srcDir("src/main/protobuf")
            }
        }
    }

    configureMavenPublishing()
}

project(":scip-java") {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "application")
    description = "Java and Kotlin indexer for SCIP"

    dependencies {
        "implementation"(project(":scip-aggregator"))
        "implementation"(catalog.clikt.jvm)
        "implementation"(catalog.kotlin.stdlib)
        "implementation"(catalog.kotlin.compiler.embeddable)
        "implementation"(catalog.kotlin.scripting.common)
        "implementation"(catalog.kotlin.scripting.jvm)
        "implementation"(catalog.kotlin.scripting.dependencies)
        "implementation"(catalog.kotlin.scripting.dependencies.maven)
        "implementation"(catalog.kotlinx.serialization.json.jvm)

        "testImplementation"(catalog.kotlin.test)
        "testImplementation"(catalog.kotlin.test.junit5)
        "testRuntimeOnly"(catalog.junit.jupiter.engine)
        "testRuntimeOnly"(catalog.junit.platform.launcher)
    }

    tasks.named<Test>("test") {
        jvmArgs(javacJvmOptions)
        systemProperty("scip.jdk.version", "11")
    }

    extensions.configure<JavaApplication> {
        mainClass.set("com.sourcegraph.scip_java.ScipJava")
    }

    val generateEmbeddedResources = tasks.register<Sync>("generateEmbeddedResources") {
        val javacShadow = project(":scip-javac").tasks.named<ShadowJar>("shadowJar")
        val gradleShadow = project(":scip-gradle-plugin").tasks.named<ShadowJar>("shadowJar")
        val kotlincShadow = project(":scip-kotlinc").tasks.named<ShadowJar>("shadowJar")

        from(javacShadow.flatMap { it.archiveFile }) {
            rename { "scip-plugin.jar" }
        }
        from(gradleShadow.flatMap { it.archiveFile }) {
            rename { "gradle-plugin.jar" }
        }
        from(kotlincShadow.flatMap { it.archiveFile }) {
            rename { "scip-kotlinc.jar" }
        }
        into(layout.buildDirectory.dir("generated/resources/embedded"))
        inputs.property("version", project.version.toString())
        doLast {
            destinationDir.resolve("scip-java.properties").writeText("version=${project.version}\n")
        }
    }

    tasks.named<ProcessResources>("processResources") {
        from(generateEmbeddedResources)
    }

    val generateDistributionVersion = tasks.register("generateDistributionVersion") {
        val output = layout.buildDirectory.file("generated/distribution/VERSION")
        inputs.property("version", project.version.toString())
        outputs.file(output)
        doLast {
            val file = output.get().asFile
            file.parentFile.mkdirs()
            file.writeText("version:=${project.version}\n")
        }
    }

    extensions.configure<DistributionContainer> {
        named("main") {
            contents {
                from(generateDistributionVersion)
            }
        }
    }

    configureMavenPublishing()
}

project(":scip-snapshots-java-common") {
    apply(plugin = "java-library")

    dependencies {
        "compileOnly"(catalog.lombok)
        "annotationProcessor"(catalog.lombok)
    }

    val annotationProcessorClasspath = configurations.named("annotationProcessor")

    tasks.named<JavaCompile>("compileJava") {
        val javacShadow = project(":scip-javac").tasks.named<ShadowJar>("shadowJar")
        val scipTargetroot = layout.buildDirectory.dir("scip-targetroot")
        dependsOn(javacShadow)
        classpath = classpath.plus(files(javacShadow.flatMap { it.archiveFile }))
        options.annotationProcessorPath =
            annotationProcessorClasspath.get().plus(files(javacShadow.flatMap { it.archiveFile }))
        outputs.dir(scipTargetroot)
        options.isFork = true
        options.forkOptions.jvmArgs = (options.forkOptions.jvmArgs ?: emptyList()) + javacJvmOptions
        options.compilerArgs.add(
            "-Xplugin:scip -text:on -verbose -sourceroot:${rootProject.rootDir.absolutePath} " +
                "-targetroot:${scipTargetroot.get().asFile.absolutePath} -randomtimestamp=${System.nanoTime()}"
        )
        doFirst {
            scipTargetroot.get().asFile.deleteRecursively()
            scipTargetroot.get().asFile.mkdirs()
        }
    }
}

project(":scip-snapshots-kotlin-common") {
    apply(plugin = "java-library")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        "implementation"(catalog.kotlin.stdlib)
    }

    val scipTargetroot = layout.buildDirectory.dir("scip-targetroot")
    val javacShadow = project(":scip-javac").tasks.named<ShadowJar>("shadowJar")
    val kotlincShadow = project(":scip-kotlinc").tasks.named<ShadowJar>("shadowJar")

    tasks.named<KotlinCompile>("compileKotlin") {
        dependsOn(kotlincShadow)
        inputs.file(kotlincShadow.flatMap { it.archiveFile })
        outputs.dir(scipTargetroot)
        compilerOptions.freeCompilerArgs.addAll(
            "-Xplugin=${kotlincShadow.flatMap { it.archiveFile }.get().asFile.absolutePath}",
            "-P",
            "plugin:scip-kotlinc:sourceroot=${rootProject.rootDir.absolutePath}",
            "-P",
            "plugin:scip-kotlinc:targetroot=${scipTargetroot.get().asFile.absolutePath}",
        )
        doFirst {
            scipTargetroot.get().asFile.deleteRecursively()
            scipTargetroot.get().asFile.mkdirs()
        }
    }

    tasks.named<JavaCompile>("compileJava") {
        dependsOn(javacShadow)
        classpath = classpath.plus(files(javacShadow.flatMap { it.archiveFile }))
        options.annotationProcessorPath = files(javacShadow.flatMap { it.archiveFile })
        outputs.dir(scipTargetroot)
        options.isFork = true
        options.forkOptions.jvmArgs = (options.forkOptions.jvmArgs ?: emptyList()) + javacJvmOptions
        options.compilerArgs.add(
            "-Xplugin:scip -sourceroot:${rootProject.rootDir.absolutePath} " +
                "-targetroot:${scipTargetroot.get().asFile.absolutePath}"
        )
    }
}

project(":scip-snapshots") {
    apply(plugin = "java-library")

    dependencies {
        "implementation"(project(":scip-java"))
        "implementation"(catalog.scip.java.bindings)
        "testImplementation"(catalog.junit.jupiter.api)
        "testRuntimeOnly"(catalog.junit.jupiter.engine)
        "testRuntimeOnly"(catalog.junit.platform.launcher)
    }

    val javaCase = project(":scip-snapshots-java-common")
    val kotlinCase = project(":scip-snapshots-kotlin-common")
    val javaCaseClasses = javaCase.tasks.named("classes")
    val kotlinCaseClasses = kotlinCase.tasks.named("classes")
    val javaTargetroot = javaCase.layout.buildDirectory.dir("scip-targetroot")
    val kotlinTargetroot = kotlinCase.layout.buildDirectory.dir("scip-targetroot")
    val snapshotProperties =
        mapOf(
            "snapshot.sourceroot" to rootProject.rootDir.absolutePath,
            "snapshot.cases" to "java-common,kotlin-common",
            "snapshot.case.java-common.expectDir" to
                rootProject.layout.projectDirectory.dir("scip-snapshots/expected/java/common").asFile.absolutePath,
            "snapshot.case.java-common.targetroot" to javaTargetroot.get().asFile.absolutePath,
            "snapshot.case.kotlin-common.expectDir" to
                rootProject.layout.projectDirectory.dir("scip-snapshots/expected/kotlin/common").asFile.absolutePath,
            "snapshot.case.kotlin-common.targetroot" to kotlinTargetroot.get().asFile.absolutePath,
            "snapshot.case.kotlin-common.aggregateNoEmitInverseRelationships" to "true",
            "scip.jdk.version" to "11",
        )

    tasks.named<Test>("test") {
        dependsOn(javaCaseClasses, kotlinCaseClasses)
        jvmArgs(javacJvmOptions)
        systemProperties(snapshotProperties)
    }

    tasks.register<JavaExec>("saveSnapshots") {
        group = "verification"
        description = "Regenerates Java and Kotlin SCIP snapshot goldens."
        dependsOn(tasks.named("classes"), javaCaseClasses, kotlinCaseClasses)
        val sourceSets = project.extensions.getByType<SourceSetContainer>()
        classpath = sourceSets.named("main").get().runtimeClasspath
        mainClass.set("tests.SaveSnapshots")
        jvmArgs(javacJvmOptions)
        systemProperties(snapshotProperties)
    }
}

tasks.register("saveSnapshots") {
    group = "verification"
    description = "Regenerates all SCIP snapshot goldens."
    dependsOn(":scip-snapshots:saveSnapshots")
}
