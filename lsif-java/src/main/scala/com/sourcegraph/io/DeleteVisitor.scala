package com.sourcegraph.io

import java.io.IOException
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes

class DeleteVisitor(deleteFile: Path => Boolean = _ => true)
    extends SimpleFileVisitor[Path] {
  override def preVisitDirectory(
      dir: Path,
      attrs: BasicFileAttributes
  ): FileVisitResult = {
    if (!deleteFile(dir))
      FileVisitResult.SKIP_SUBTREE
    else
      super.preVisitDirectory(dir, attrs)
  }
  override def visitFile(
      file: Path,
      attrs: BasicFileAttributes
  ): FileVisitResult = {
    if (deleteFile(file)) {
      Files.deleteIfExists(file)
    }
    super.visitFile(file, attrs)
  }

  override def postVisitDirectory(
      dir: Path,
      exc: IOException
  ): FileVisitResult = {
    val ls = Files.list(dir)
    try {
      if (!ls.iterator().hasNext) {
        Files.deleteIfExists(dir)
      }
    } finally {
      ls.close()
    }
    super.postVisitDirectory(dir, exc)
  }

  override def visitFileFailed(
      file: Path,
      exc: IOException
  ): FileVisitResult = {
    FileVisitResult.CONTINUE
  }

}
