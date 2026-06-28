import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import com.sourcegraph.buildlogic.JavacInternals

plugins {
    id("scip.java-library")
    id("scip.shadow-producer")
    id("scip.maven-publish")
}

description = "A javac plugin to emit SCIP information"

dependencies {
    api(project(":scip-shared"))
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
    jvmArgs(JavacInternals.jvmOptions(rootDir))
}

tasks.named<ShadowJar>("shadowJar") {
    mergeServiceFiles()
    relocate("com.google", "com.sourcegraph.shaded.com.google")
    relocate("google", "com.sourcegraph.shaded.google")
    relocate("com.sourcegraph", "com.sourcegraph.shaded.com.sourcegraph") {
        exclude("com.sourcegraph.scip_javac.ScipPlugin")
        exclude("com.sourcegraph.scip_javac.InjectScipOptions")
    }
}
