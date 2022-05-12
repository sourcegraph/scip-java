package com.sourcegraph.scip_java.buildtools

import java.nio.file.Files
import java.nio.file.Path

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.commands.IndexCommand

object TemporaryFiles {
  def withDirectory[T](index: IndexCommand)(fn: Path => T): T = {
    index.temporaryDirectory match {
      case Some(tmp) =>
        fn(tmp)
      case None =>
        val tmp = Files.createTempDirectory("scip-java")
        try fn(tmp)
        finally {
          if (index.cleanup) {
            Files.walkFileTree(tmp, new DeleteVisitor())
          }
        }
    }
  }
}
