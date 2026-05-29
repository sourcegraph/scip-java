package tests

import munit.FunSuite

class MinimizedSnapshotScipSuite extends FunSuite with AssertSnapshotHandlers {
  new MinimizedSnapshotScipGenerator().run(
    SnapshotContext(tests.snapshots.BuildInfo.snapshotDirectory.toPath),
    new AssertSnapshotHandler
  )
}
