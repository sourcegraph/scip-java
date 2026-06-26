package tests;

/**
 * Regenerates all snapshot goldens (invoked by {@code gradle :scip-snapshots:saveSnapshots}).
 * Snapshot cases are supplied via {@code -Dsnapshot.*} system properties by the Gradle build.
 */
public final class SaveSnapshots {
  private SaveSnapshots() {}

  public static void main(String[] args) {
    // Keep regenerated goldens stable across the supported JDK matrix by pinning the JDK version
    // embedded in stdlib SCIP symbols. "11" is a historical, deterministic label (not a supported
    // runtime); it only needs to match the `-Dscip.jdk.version` set on the test JVM in Gradle.
    System.setProperty("scip.jdk.version", "11");
    MinimizedSnapshotScipGenerator generator = new MinimizedSnapshotScipGenerator();
    for (MinimizedSnapshotScipGenerator.SnapshotCase snapshotCase :
        MinimizedSnapshotScipGenerator.snapshotCases()) {
      SnapshotContext context = snapshotCase.context();
      SaveSnapshotHandler handler = new SaveSnapshotHandler();
      generator.onTargetroot(
          context,
          handler,
          snapshotCase.targetroot,
          snapshotCase.aggregateNoEmitInverseRelationships);
      handler.onFinished(context);
    }
  }
}
