import com.sourcegraph.buildlogic.JavacInternals
import com.sourcegraph.buildlogic.shadowJarArtifact
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("scip.java-library")
    id("scip.kotlin-jvm")
}

val javacShadowJar = shadowJarArtifact(":scip-javac", "javacShadowJar")
val kotlincShadowJar = shadowJarArtifact(":scip-kotlinc", "kotlincShadowJar")

dependencies {
    implementation(libs.kotlin.stdlib)
}

val scipTargetroot = layout.buildDirectory.dir("scip-targetroot")

val kotlincPluginArgs = kotlincShadowJar.elements.map { locations ->
    val pluginPath = locations.single().asFile.absolutePath
    listOf(
        "-Xplugin=$pluginPath",
        "-P",
        "plugin:scip-kotlinc:sourceroot=${rootProject.rootDir.absolutePath}",
        "-P",
        "plugin:scip-kotlinc:targetroot=${scipTargetroot.get().asFile.absolutePath}",
    )
}

tasks.named<KotlinCompile>("compileKotlin") {
    inputs.files(kotlincShadowJar)
    outputs.dir(scipTargetroot)
    compilerOptions.freeCompilerArgs.addAll(kotlincPluginArgs)
    doFirst {
        scipTargetroot.get().asFile.deleteRecursively()
        scipTargetroot.get().asFile.mkdirs()
    }
}

tasks.named<JavaCompile>("compileJava") {
    classpath = classpath.plus(javacShadowJar)
    options.annotationProcessorPath = javacShadowJar
    outputs.dir(scipTargetroot)
    options.isFork = true
    options.forkOptions.jvmArgs = (options.forkOptions.jvmArgs ?: emptyList()) + JavacInternals.jvmOptions(rootDir)
    options.compilerArgs.add(
        "-Xplugin:scip -sourceroot:${rootProject.rootDir.absolutePath} " +
            "-targetroot:${scipTargetroot.get().asFile.absolutePath}"
    )
}
