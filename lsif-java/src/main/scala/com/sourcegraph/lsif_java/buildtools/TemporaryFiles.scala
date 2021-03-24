package com.sourcegraph.lsif_java.buildtools

import java.nio.file.Files
import java.nio.file.Path

import com.sourcegraph.io.DeleteVisitor

object TemporaryFiles {
  def withDirectory[T](cleanup: Boolean)(fn: Path => T): T = {
    val tmp = Files.createTempDirectory("lsif-java")
    try fn(tmp)
    finally {
      if (cleanup) {
        Files.walkFileTree(tmp, new DeleteVisitor())
      }
    }
  }
}
