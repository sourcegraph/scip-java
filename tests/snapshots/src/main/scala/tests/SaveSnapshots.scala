package tests

object SaveSnapshots {
  def main(args: Array[String]): Unit = {
    val context = SnapshotContext(
      tests.snapshots.BuildInfo.snapshotDirectory.toPath
    )
    val handler = new SaveSnapshotHandler
    new MinimizedSnapshotScipGenerator().run(context, handler)
    handler.onFinished(context)
  }
}
