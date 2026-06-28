import com.sourcegraph.buildlogic.cleanDirectoryBeforeRunning
import com.sourcegraph.buildlogic.publishDirectoryArtifact
import com.sourcegraph.buildlogic.shadowJarArtifact
import com.sourcegraph.buildlogic.useScipJavac

plugins {
    id("scip.java-library")
}

val javacShadowJar = shadowJarArtifact(":scip-javac", "javacShadowJar")

val minimumJavaFeature = 25
val currentJavaFeature = JavaVersion.current().majorVersion.toInt()
val scipTargetroot = layout.buildDirectory.dir("scip-targetroot")
val sourceroot = rootProject.rootDir.absolutePath
val targetroot = scipTargetroot.get().asFile.absolutePath

tasks.named<JavaCompile>("compileJava") {
    enabled = currentJavaFeature >= minimumJavaFeature
    options.release.set(25)
    options.compilerArgs.add("--enable-preview")
    useScipJavac(rootDir, javacShadowJar, scipTargetroot)
    options.compilerArgs.add(
        "-Xplugin:scip -text:on -verbose -sourceroot:$sourceroot " +
            "-targetroot:$targetroot -randomtimestamp=${System.nanoTime()}"
    )
    cleanDirectoryBeforeRunning(scipTargetroot)
}

publishDirectoryArtifact("scipTargetrootElements", scipTargetroot, tasks.named("classes"))
