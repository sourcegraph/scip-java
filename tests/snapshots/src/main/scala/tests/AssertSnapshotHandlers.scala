package tests

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path

import munit.FailException
import munit.FunSuite
import munit.Location

/**
 * Helper class to create test suite from a snapshot generator.
 */
trait AssertSnapshotHandlers {
  self: FunSuite =>

  class AssertSnapshotHandler extends SnapshotHandler {
    override def onSnapshotTest(
        context: SnapshotContext,
        expectFile: Path,
        obtainedOutput: () => String
    ): Unit = {
      val relativePath = context.expectDirectory.relativize(expectFile)
      self.test(relativePath.toString) {
        if (Files.isRegularFile(expectFile)) {
          val expected =
            new String(Files.readAllBytes(expectFile), StandardCharsets.UTF_8)
          self.assertNoDiff(obtainedOutput(), expected)
        } else {
          throw new FailException(
            s"no snapshot file. To fix this problem, execute the command 'sbt snapshots/run'",
            cause = null,
            isStackTracesEnabled = false,
            location = Location.empty
          )
        }
      }
    }
  }
}
