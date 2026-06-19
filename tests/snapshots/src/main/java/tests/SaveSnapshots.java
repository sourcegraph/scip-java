package tests;

/**
 * Regenerates the Java snapshot goldens (invoked by {@code sbt snapshots/run}). The expected-output
 * directory is supplied via the {@code -Dsnapshot.expectDir} system property by the sbt build.
 */
public final class SaveSnapshots {
  private SaveSnapshots() {}

  public static void main(String[] args) {
    // Keep regenerated goldens stable across JDK 11/17/21 by pinning the JDK version embedded in
    // stdlib SCIP symbols. Matches the `-Dscip.jdk.version=11` set on the test JVM in build.sbt.
    System.setProperty("scip.jdk.version", "11");
    SnapshotContext context =
        new SnapshotContext(
            MinimizedSnapshotScipGenerator.requiredPathProperty("snapshot.expectDir"));
    SaveSnapshotHandler handler = new SaveSnapshotHandler();
    new MinimizedSnapshotScipGenerator().run(context, handler);
    handler.onFinished(context);
  }
}
