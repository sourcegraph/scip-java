import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.scip_code.scip_java.buildlogic.JavacInternals

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
    relocate("com.google", "org.scip_code.scip_java.shaded.com.google")
    relocate("google", "org.scip_code.scip_java.shaded.google")
    relocate("org.scip_code.scip_java", "org.scip_code.scip_java.shaded.org.scip_code.scip_java") {
        exclude("org.scip_code.scip_java.javac.ScipPlugin")
        exclude("org.scip_code.scip_java.javac.InjectScipOptions")
    }
}
