import com.sourcegraph.buildlogic.JavacInternals
import com.sourcegraph.buildlogic.shadowJarArtifact

plugins {
    id("scip.java-library")
}

val javacShadowJar = shadowJarArtifact(":scip-javac", "javacShadowJar")

dependencies {
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}

val annotationProcessorClasspath = configurations.named("annotationProcessor")

tasks.named<JavaCompile>("compileJava") {
    val scipTargetroot = layout.buildDirectory.dir("scip-targetroot")
    classpath = classpath.plus(javacShadowJar)
    options.annotationProcessorPath = annotationProcessorClasspath.get().plus(javacShadowJar)
    outputs.dir(scipTargetroot)
    options.isFork = true
    options.forkOptions.jvmArgs = (options.forkOptions.jvmArgs ?: emptyList()) + JavacInternals.jvmOptions(rootDir)
    options.compilerArgs.add(
        "-Xplugin:scip -text:on -verbose -sourceroot:${rootProject.rootDir.absolutePath} " +
            "-targetroot:${scipTargetroot.get().asFile.absolutePath} -randomtimestamp=${System.nanoTime()}"
    )
    doFirst {
        scipTargetroot.get().asFile.deleteRecursively()
        scipTargetroot.get().asFile.mkdirs()
    }
}
