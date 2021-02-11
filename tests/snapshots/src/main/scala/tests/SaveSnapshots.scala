package tests

object SaveSnapshots {
  def main(args: Array[String]): Unit = {
    val expectDirectory = tests.snapshots.BuildInfo.snapshotDirectory.toPath
    SemanticdbJavacSnapshotGenerator
      .run(SnapshotContext(expectDirectory), new SaveSnapshotHandler)
  }
}
