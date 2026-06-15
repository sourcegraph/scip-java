package tests

import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import java.util.concurrent.ConcurrentLinkedDeque

import scala.jdk.CollectionConverters._

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
      new SimpleFileVisitor[Path] {
        override def visitFile(
            file: Path,
            attrs: BasicFileAttributes
        ): FileVisitResult = {
          if (!isWritten.contains(file))
            Files.deleteIfExists(file)
          FileVisitResult.CONTINUE
        }
        override def postVisitDirectory(
            dir: Path,
            exc: IOException
        ): FileVisitResult = {
          val entries = Files.list(dir)
          val isEmpty =
            try !entries.iterator().hasNext()
            finally entries.close()
          if (isEmpty)
            Files.deleteIfExists(dir)
          FileVisitResult.CONTINUE
        }
      }
    )
  }

}
