import com.sourcegraph.buildlogic.JavacInternals

plugins {
    id("scip.java-library")
}

dependencies {
    implementation(project(":scip-java"))
    implementation(libs.scip.java.bindings)
}

// The snapshot goldens are produced by compiling the sibling "case" projects
// with the scip compiler plugins. Force those projects to be configured first
// so their `classes` tasks and target-root outputs are resolvable here.
val javaCase = evaluationDependsOn(":scip-snapshots-java-common")
val kotlinCase = evaluationDependsOn(":scip-snapshots-kotlin-common")
val javaCaseClasses = javaCase.tasks.named("classes")
val kotlinCaseClasses = kotlinCase.tasks.named("classes")
val javaTargetroot = javaCase.layout.buildDirectory.dir("scip-targetroot")
val kotlinTargetroot = kotlinCase.layout.buildDirectory.dir("scip-targetroot")
val snapshotProperties =
    mapOf(
        "snapshot.sourceroot" to rootProject.rootDir.absolutePath,
        "snapshot.cases" to "java-common,kotlin-common",
        "snapshot.case.java-common.expectDir" to
            rootProject.layout.projectDirectory.dir("scip-snapshots/expected/java/common").asFile.absolutePath,
        "snapshot.case.java-common.targetroot" to javaTargetroot.get().asFile.absolutePath,
        "snapshot.case.kotlin-common.expectDir" to
            rootProject.layout.projectDirectory.dir("scip-snapshots/expected/kotlin/common").asFile.absolutePath,
        "snapshot.case.kotlin-common.targetroot" to kotlinTargetroot.get().asFile.absolutePath,
        "snapshot.case.kotlin-common.aggregateNoEmitInverseRelationships" to "true",
        "scip.jdk.version" to "17",
    )

tasks.named<Test>("test") {
    dependsOn(javaCaseClasses, kotlinCaseClasses)
    jvmArgs(JavacInternals.jvmOptions(rootDir))
    systemProperties(snapshotProperties)
}

tasks.register<JavaExec>("saveSnapshots") {
    group = "verification"
    description = "Regenerates Java and Kotlin SCIP snapshot goldens."
    dependsOn(tasks.named("classes"), javaCaseClasses, kotlinCaseClasses)
    val sourceSets = project.extensions.getByType<SourceSetContainer>()
    classpath = sourceSets.named("main").get().runtimeClasspath
    mainClass.set("tests.SaveSnapshots")
    jvmArgs(JavacInternals.jvmOptions(rootDir))
    systemProperties(snapshotProperties)
}
