package tests

object SaveSnapshots {
  def main(args: Array[String]): Unit = {
    // Keep regenerated goldens stable across JDK 11/17/21 by pinning the
    // JDK version embedded in stdlib SCIP symbols. Matches the
    // `-Dscip.jdk.version=11` set on the test JVM in build.sbt.
    System.setProperty("scip.jdk.version", "11")
    val context = SnapshotContext(
      tests.snapshots.BuildInfo.snapshotDirectory.toPath
    )
    val handler = new SaveSnapshotHandler
    new MinimizedSnapshotScipGenerator().run(context, handler)
    handler.onFinished(context)
  }
}
