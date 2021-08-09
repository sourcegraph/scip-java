package com.sourcegraph.io

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

import scala.util.Using.Releasable

class AutoDeletedFile private (
    val path: Path,
    val oldContent: Option[Array[Byte]]
)

object AutoDeletedFile {
  def fromPath(path: Path, newContent: String): AutoDeletedFile = {
    val oldContent =
      if (Files.isRegularFile(path))
        Some(Files.readAllBytes(path))
      else
        None
    Files.createDirectories(path.getParent)
    Files.write(
      path,
      newContent.getBytes(StandardCharsets.UTF_8),
      StandardOpenOption.CREATE,
      StandardOpenOption.TRUNCATE_EXISTING
    )
    new AutoDeletedFile(path, oldContent)
  }
  implicit val releasableAutoDeletedFile: Releasable[AutoDeletedFile] = {
    file =>
      file.oldContent match {
        case Some(oldBytes) =>
          Files.write(
            file.path,
            oldBytes,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
          )
        case None =>
          Files.deleteIfExists(file.path)
      }
  }
}
