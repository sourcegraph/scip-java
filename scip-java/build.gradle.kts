import com.sourcegraph.buildlogic.JavacInternals
import com.sourcegraph.buildlogic.shadowJarArtifact

plugins {
    id("scip.java-base")
    id("scip.kotlin-jvm")
    application
    id("scip.maven-publish")
}

description = "Java and Kotlin indexer for SCIP"

val javacShadowJar = shadowJarArtifact(":scip-javac", "javacShadowJar")
val gradlePluginShadowJar = shadowJarArtifact(":scip-gradle-plugin", "gradlePluginShadowJar")
val kotlincShadowJar = shadowJarArtifact(":scip-kotlinc", "kotlincShadowJar")

dependencies {
    implementation(project(":scip-aggregator"))
    implementation(libs.clikt.jvm)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.compiler.embeddable)
    implementation(libs.kotlin.scripting.common)
    implementation(libs.kotlin.scripting.jvm)
    implementation(libs.kotlin.scripting.dependencies)
    implementation(libs.kotlin.scripting.dependencies.maven)
    implementation(libs.kotlinx.serialization.json.jvm)

    testImplementation(libs.kotlin.test)
    testImplementation(libs.kotlin.test.junit5)
}

tasks.named<Test>("test") {
    jvmArgs(JavacInternals.jvmOptions(rootDir))
    systemProperty("scip.jdk.version", "11")
}

application {
    mainClass.set("com.sourcegraph.scip_java.ScipJava")
}

val generateEmbeddedResources = tasks.register<Sync>("generateEmbeddedResources") {
    from(javacShadowJar) {
        rename { "scip-plugin.jar" }
    }
    from(gradlePluginShadowJar) {
        rename { "gradle-plugin.jar" }
    }
    from(kotlincShadowJar) {
        rename { "scip-kotlinc.jar" }
    }
    into(layout.buildDirectory.dir("generated/resources/embedded"))
}

tasks.named<ProcessResources>("processResources") {
    from(JavacInternals.propertiesFile(rootDir))
    from(generateEmbeddedResources)
}

tasks.named<Jar>("jar") {
    manifest {
        attributes("Implementation-Version" to project.version)
    }
}

val generateDistributionVersion = tasks.register("generateDistributionVersion") {
    val output = layout.buildDirectory.file("generated/distribution/VERSION")
    val version = project.version.toString()
    inputs.property("version", version)
    outputs.file(output)
    doLast {
        val file = output.get().asFile
        file.parentFile.mkdirs()
        file.writeText("version:=$version\n")
    }
}

// Emit the javac --add-exports flags as a ready-to-use, space-separated string
// so the Docker wrapper script can read them with a plain `cat`, keeping
// gradle/javac-internals.properties the single source of truth.
val generateJavacJvmOptions = tasks.register("generateJavacJvmOptions") {
    val output = layout.buildDirectory.file("generated/distribution/javac-jvm-options")
    val options = JavacInternals.jvmOptions(rootDir).joinToString(" ")
    inputs.property("options", options)
    outputs.file(output)
    doLast {
        val file = output.get().asFile
        file.parentFile.mkdirs()
        file.writeText("$options\n")
    }
}

distributions {
    named("main") {
        contents {
            from(generateDistributionVersion)
            from(generateJavacJvmOptions)
        }
    }
}
