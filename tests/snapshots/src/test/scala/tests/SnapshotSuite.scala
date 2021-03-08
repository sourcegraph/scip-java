package tests

import munit.FunSuite

abstract class SnapshotSuite(generator: SnapshotGenerator)
    extends FunSuite
    with AssertSnapshotHandlers {
  generator.run(
    SnapshotContext(tests.snapshots.BuildInfo.snapshotDirectory.toPath),
    new AssertSnapshotHandler
  )
}

class LibrarySnapshotSuite extends SnapshotSuite(new LibrarySnapshotGenerator)

class MinimizedSnapshotSuite
    extends SnapshotSuite(new MinimizedSnapshotGenerator)

class MinimizedLsifSnapshotSuite
    extends SnapshotSuite(new MinimizedLsifSnapshotGenerator)

class LsifGraphSnapshotSuite
    extends SnapshotSuite(new LsifGraphSnapshotGenerator)
