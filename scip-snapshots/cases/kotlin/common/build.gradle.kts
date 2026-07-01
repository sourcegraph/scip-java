import org.scip_code.scip_java.buildlogic.cleanDirectoryBeforeRunning
import org.scip_code.scip_java.buildlogic.publishDirectoryArtifact
import org.scip_code.scip_java.buildlogic.scipKotlincPluginArgs
import org.scip_code.scip_java.buildlogic.shadowJarArtifact
import org.scip_code.scip_java.buildlogic.useScipJavac
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
val sourceroot = rootProject.rootDir.absolutePath
val targetroot = scipTargetroot.get().asFile.absolutePath

tasks.named<KotlinCompile>("compileKotlin") {
    inputs.files(kotlincShadowJar)
    outputs.dir(scipTargetroot)
    compilerOptions.freeCompilerArgs.addAll(scipKotlincPluginArgs(kotlincShadowJar.elements, sourceroot, targetroot))
    cleanDirectoryBeforeRunning(scipTargetroot)
}

tasks.named<JavaCompile>("compileJava") {
    useScipJavac(rootDir, javacShadowJar, scipTargetroot)
    options.annotationProcessorPath = javacShadowJar
    options.compilerArgs.add("-Xplugin:scip -sourceroot:$sourceroot -targetroot:$targetroot")
}

publishDirectoryArtifact("scipTargetrootElements", scipTargetroot, tasks.named("classes"))
