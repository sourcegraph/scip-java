package tests

object SaveSnapshots {
  def main(args: Array[String]): Unit = {
    val expectDirectory = tests.snapshots.BuildInfo.snapshotDirectory.toPath
    new MinimizedSnapshotScipGenerator()
      .run(SnapshotContext(expectDirectory), new SaveSnapshotHandler)
  }
}
