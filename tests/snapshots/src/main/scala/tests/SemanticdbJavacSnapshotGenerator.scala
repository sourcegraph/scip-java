package tests

object SemanticdbJavacSnapshotGenerator
    extends AggregateSnapshotGenerator(
      List(new LibrarySnapshotGenerator(), new MinimizedSnapshotScipGenerator())
    )
