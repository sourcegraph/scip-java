package tests

object SemanticdbJavacSnapshotGenerator
    extends AggregateSnapshotGenerator(
      List(
        new LibrarySnapshotGenerator(),
        new MinimizedSnapshotSemanticdbGenerator(),
        new MinimizedSnapshotScipGenerator(),
        new MinimizedSnapshotLsifGenerator(),
        new ScipGraphSnapshotGenerator()
      )
    )
