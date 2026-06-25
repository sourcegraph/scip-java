package tests;

/**
 * Regenerates all snapshot goldens (invoked by {@code mvn -pl scip-snapshots -am -DskipTests
 * -PsaveSnapshots verify}). Snapshot cases are supplied via {@code -Dsnapshot.*} system properties
 * by the Maven build.
 */
public final class SaveSnapshots {
  private SaveSnapshots() {}

  public static void main(String[] args) {
    // Keep regenerated goldens stable across JDK 11/17/21 by pinning the JDK version embedded in
    // stdlib SCIP symbols. Matches the `-Dscip.jdk.version=11` set on the test JVM in Gradle.
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
