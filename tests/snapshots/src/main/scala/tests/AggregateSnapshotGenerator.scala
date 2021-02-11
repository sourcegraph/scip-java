package tests

class AggregateSnapshotGenerator(underlying: List[SnapshotGenerator])
    extends SnapshotGenerator {
  override def run(context: SnapshotContext, handler: SnapshotHandler): Unit = {
    underlying.foreach { generator =>
      generator.run(context, handler.withoutFinishedEvent)
    }
    handler.onFinished(context)
  }
}
