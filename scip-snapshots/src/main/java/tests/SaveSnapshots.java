package tests;

/**
 * Regenerates all snapshot goldens (invoked by {@code gradle :scip-snapshots:saveSnapshots}).
 * Snapshot cases are supplied via {@code -Dsnapshot.*} system properties by the Gradle build.
 */
public final class SaveSnapshots {
  private SaveSnapshots() {}

  public static void main(String[] args) {
    // Each snapshot case pins the JDK version embedded in stdlib SCIP symbols,
    // keeping regenerated goldens stable across the supported JDK matrix.
    MinimizedSnapshotScipGenerator generator = new MinimizedSnapshotScipGenerator();
    for (MinimizedSnapshotScipGenerator.SnapshotCase snapshotCase :
        MinimizedSnapshotScipGenerator.snapshotCases()) {
      SnapshotContext context = snapshotCase.context();
      SaveSnapshotHandler handler = new SaveSnapshotHandler();
      generator.run(snapshotCase, handler);
      handler.onFinished(context);
    }
  }
}
