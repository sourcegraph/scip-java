import org.scip_code.scip_java.buildlogic.JavacInternals
import org.scip_code.scip_java.buildlogic.projectArtifact

plugins {
    id("scip.java-library")
}

dependencies {
    implementation(project(":scip-java"))
    implementation(libs.scip.java.bindings)
}

data class SnapshotCaseInput(
    val id: String,
    val producerPath: String,
    val minimumJavaFeature: Int = 0,
) {
    val targetrootProperty: String = "snapshot.case.$id.targetroot"
    val targetrootName: String = "${id.replace("-", "")}Targetroot"
}

val snapshotCaseInputs =
    listOf(
        SnapshotCaseInput("java-common", ":scip-snapshots-java-common"),
        SnapshotCaseInput("java-25", ":scip-snapshots-java-25", minimumJavaFeature = 25),
        SnapshotCaseInput("kotlin-common", ":scip-snapshots-kotlin-common"),
    )

// The snapshot goldens are produced by compiling the sibling "case" projects with the scip compiler
// plugins; each publishes its target-root directory as the `scipTargetrootElements` artifact.
val currentJavaFeature = JavaVersion.current().majorVersion.toInt()
val enabledSnapshotCaseInputs =
    snapshotCaseInputs.filter { currentJavaFeature >= it.minimumJavaFeature }
val snapshotTargetroots =
    enabledSnapshotCaseInputs.associateWith { snapshotCase ->
        projectArtifact(snapshotCase.producerPath, "scipTargetrootElements", snapshotCase.targetrootName)
    }
// The case list, expected-golden layout and per-case indexing flags are fixed test metadata defined
// in MinimizedSnapshotScipGenerator; the build only supplies the build-time paths it owns.
val snapshotProperties =
    mutableMapOf(
            "snapshot.sourceroot" to rootProject.rootDir.absolutePath,
            "snapshot.case.ids" to snapshotCaseInputs.joinToString(",") { it.id },
            "snapshot.enabledCases" to enabledSnapshotCaseInputs.joinToString(",") { it.id },
        )
        .apply {
            snapshotTargetroots.forEach { (snapshotCase, targetroot) ->
                put(snapshotCase.targetrootProperty, targetroot.singleFile.absolutePath)
            }
        }

tasks.named<Test>("test") {
    inputs.files(snapshotTargetroots.values)
    jvmArgs(JavacInternals.jvmOptions(rootDir))
    systemProperties(snapshotProperties)
}

tasks.register<JavaExec>("saveSnapshots") {
    group = "verification"
    description = "Regenerates Java and Kotlin SCIP snapshot goldens."
    inputs.files(snapshotTargetroots.values)
    val sourceSets = project.extensions.getByType<SourceSetContainer>()
    classpath = sourceSets.named("main").get().runtimeClasspath
    mainClass.set("tests.SaveSnapshots")
    jvmArgs(JavacInternals.jvmOptions(rootDir))
    systemProperties(snapshotProperties)
}
