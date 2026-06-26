package tests;

/**
 * Regenerates all snapshot goldens (invoked by {@code gradle :scip-snapshots:saveSnapshots}).
 * Snapshot cases are supplied via {@code -Dsnapshot.*} system properties by the Gradle build.
 */
public final class SaveSnapshots {
  private SaveSnapshots() {}

  public static void main(String[] args) {
    // The JDK version embedded in stdlib SCIP symbols is pinned via the
    // `-Dscip.jdk.version` flag that the Gradle `saveSnapshots` task passes in,
    // keeping regenerated goldens stable across the supported JDK matrix.
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
