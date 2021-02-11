package tests

trait SnapshotGenerator {
  def run(context: SnapshotContext, handler: SnapshotHandler): Unit
}
