import com.sourcegraph.buildlogic.JavacInternals
import com.sourcegraph.buildlogic.scipKotlincPluginArgs
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

val sourceroot = rootProject.rootDir.absolutePath
val targetroot = scipTargetroot.get().asFile.absolutePath

tasks.named<KotlinCompile>("compileKotlin") {
    // Bind to a local so the doFirst action captures the provider, not the
    // surrounding script object (which the configuration cache cannot serialize).
    val targetrootDir = scipTargetroot
    inputs.files(kotlincShadowJar)
    outputs.dir(targetrootDir)
    compilerOptions.freeCompilerArgs.addAll(scipKotlincPluginArgs(kotlincShadowJar.elements, sourceroot, targetroot))
    doFirst {
        targetrootDir.get().asFile.deleteRecursively()
        targetrootDir.get().asFile.mkdirs()
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
