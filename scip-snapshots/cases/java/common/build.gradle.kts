import org.scip_code.scip_java.buildlogic.cleanDirectoryBeforeRunning
import org.scip_code.scip_java.buildlogic.publishDirectoryArtifact
import org.scip_code.scip_java.buildlogic.shadowJarArtifact
import org.scip_code.scip_java.buildlogic.useScipJavac

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

publishDirectoryArtifact("scipTargetrootElements", scipTargetroot, tasks.named("classes"))
