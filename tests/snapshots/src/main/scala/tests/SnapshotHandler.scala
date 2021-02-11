package tests

import java.nio.file.Path

abstract class SnapshotHandler {
  self =>
  def onSnapshotTest(
      context: SnapshotContext,
      expectFile: Path,
      obtainedOutput: () => String
  ): Unit = ()
  def onFinished(context: SnapshotContext): Unit = ()
  final def withoutFinishedEvent: SnapshotHandler =
    new SnapshotHandler {
      override def onFinished(context: SnapshotContext): Unit = () // Do nothing
      override def onSnapshotTest(
          context: SnapshotContext,
          expectFile: Path,
          obtainedOutput: () => String
      ): Unit = {
        self.onSnapshotTest(context, expectFile, obtainedOutput)
      }
    }
}
