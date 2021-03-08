package tests

object SemanticdbJavacSnapshotGenerator
    extends AggregateSnapshotGenerator(
      List(
        new LibrarySnapshotGenerator(),
        new MinimizedSnapshotGenerator(),
        new MinimizedLsifSnapshotGenerator(),
        new LsifGraphSnapshotGenerator()
      )
    )
