import com.sourcegraph.buildlogic.cleanDirectoryBeforeRunning
import com.sourcegraph.buildlogic.shadowJarArtifact
import com.sourcegraph.buildlogic.useScipJavac

plugins {
    id("scip.java-library")
}

val javacShadowJar = shadowJarArtifact(":scip-javac", "javacShadowJar")

dependencies {
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}

val annotationProcessorClasspath = configurations.named("annotationProcessor")
val scipTargetroot = layout.buildDirectory.dir("scip-targetroot")
val sourceroot = rootProject.rootDir.absolutePath
val targetroot = scipTargetroot.get().asFile.absolutePath

tasks.named<JavaCompile>("compileJava") {
    useScipJavac(rootDir, javacShadowJar, scipTargetroot)
    options.annotationProcessorPath = annotationProcessorClasspath.get().plus(javacShadowJar)
    options.compilerArgs.add(
        "-Xplugin:scip -text:on -verbose -sourceroot:$sourceroot " +
            "-targetroot:$targetroot -randomtimestamp=${System.nanoTime()}"
    )
    cleanDirectoryBeforeRunning(scipTargetroot)
}
