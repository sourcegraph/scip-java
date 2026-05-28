package tests

object SemanticdbJavacSnapshotGenerator
    extends AggregateSnapshotGenerator(
      List(new MinimizedSnapshotScipGenerator())
    )
