package tests

import java.nio.file.Path

abstract class SnapshotHandler {
  def onSnapshotTest(
      context: SnapshotContext,
      expectFile: Path,
      obtainedOutput: () => String
  ): Unit = ()
  def onFinished(context: SnapshotContext): Unit = ()
}
