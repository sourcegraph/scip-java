package com.sourcegraph.io

import java.io.IOException
import java.nio.file.FileAlreadyExistsException
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes

class CopyVisitor(source: Path, destination: Path)
    extends SimpleFileVisitor[Path] {
  override def preVisitDirectory(
      t: Path,
      basicFileAttributes: BasicFileAttributes
  ): FileVisitResult = {
    try {
      Files.createDirectory(destination.resolve(source.relativize(t)))
    } catch {
      case _: NoSuchFileException =>
        return super.preVisitDirectory(t, basicFileAttributes)
      case _: FileAlreadyExistsException =>
        return super.preVisitDirectory(t, basicFileAttributes)
    }
    super.preVisitDirectory(t, basicFileAttributes)
  }

  override def visitFile(
      t: Path,
      basicFileAttributes: BasicFileAttributes
  ): FileVisitResult = {
    val destPath = destination.resolve(source.relativize(t))
    try {
      Files.copy(t, destPath)
    } catch {
      case _: NoSuchFileException =>
        return super.visitFile(t, basicFileAttributes)
    }
    super.visitFile(t, basicFileAttributes)
  }

  override def visitFileFailed(t: Path, e: IOException): FileVisitResult =
    FileVisitResult.CONTINUE
}
