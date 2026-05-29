package tests

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.ConcurrentLinkedDeque

import scala.jdk.CollectionConverters._

import com.sourcegraph.io.DeleteVisitor

class SaveSnapshotHandler extends SnapshotHandler {
  private val writtenTests = new ConcurrentLinkedDeque[Path]()
  override def onSnapshotTest(
      context: SnapshotContext,
      expectFile: Path,
      obtainedOutput: () => String
  ): Unit = {
    Files.createDirectories(expectFile.getParent)
    Files.write(expectFile, obtainedOutput().getBytes(StandardCharsets.UTF_8))
    writtenTests.add(expectFile)
  }

  override def onFinished(context: SnapshotContext): Unit = {
    if (!Files.exists(context.expectDirectory)) {
      return
    }
    val isWritten = writtenTests.asScala.toSet
    Files.walkFileTree(
      context.expectDirectory,
      new DeleteVisitor(deleteFile = file => !isWritten.contains(file))
    )
  }

}
