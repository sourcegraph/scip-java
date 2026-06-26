import com.sourcegraph.buildlogic.JavacInternals
import com.sourcegraph.buildlogic.projectArtifact

plugins {
    id("scip.java-library")
}

dependencies {
    implementation(project(":scip-java"))
    implementation(libs.scip.java.bindings)
}

// The snapshot goldens are produced by compiling the sibling "case" projects with the scip compiler
// plugins; each publishes its target-root directory as the `scipTargetrootElements` artifact.
val javaTargetroot = projectArtifact(":scip-snapshots-java-common", "scipTargetrootElements", "javaTargetroot")
val kotlinTargetroot = projectArtifact(":scip-snapshots-kotlin-common", "scipTargetrootElements", "kotlinTargetroot")
val snapshotProperties =
    mapOf(
        "snapshot.sourceroot" to rootProject.rootDir.absolutePath,
        "snapshot.cases" to "java-common,kotlin-common",
        "snapshot.case.java-common.expectDir" to
            rootProject.layout.projectDirectory.dir("scip-snapshots/expected/java/common").asFile.absolutePath,
        "snapshot.case.java-common.targetroot" to javaTargetroot.singleFile.absolutePath,
        "snapshot.case.kotlin-common.expectDir" to
            rootProject.layout.projectDirectory.dir("scip-snapshots/expected/kotlin/common").asFile.absolutePath,
        "snapshot.case.kotlin-common.targetroot" to kotlinTargetroot.singleFile.absolutePath,
        "snapshot.case.kotlin-common.aggregateNoEmitInverseRelationships" to "true",
        "scip.jdk.version" to "17",
    )

tasks.named<Test>("test") {
    inputs.files(javaTargetroot, kotlinTargetroot)
    jvmArgs(JavacInternals.jvmOptions(rootDir))
    systemProperties(snapshotProperties)
}

tasks.register<JavaExec>("saveSnapshots") {
    group = "verification"
    description = "Regenerates Java and Kotlin SCIP snapshot goldens."
    dependsOn(tasks.named("classes"))
    inputs.files(javaTargetroot, kotlinTargetroot)
    val sourceSets = project.extensions.getByType<SourceSetContainer>()
    classpath = sourceSets.named("main").get().runtimeClasspath
    mainClass.set("tests.SaveSnapshots")
    jvmArgs(JavacInternals.jvmOptions(rootDir))
    systemProperties(snapshotProperties)
}
