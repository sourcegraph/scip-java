package tests

import java.nio.file.Files

import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath
import scala.meta.io.RelativePath

import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocument
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocuments

case class SemanticdbFile(
    sourceroot: AbsolutePath,
    relativePath: RelativePath,
    sourceDirectory: AbsolutePath,
    targetroot: AbsolutePath
) {
  def javaPath: AbsolutePath = sourceroot.resolve(relativePath)
  def semanticdbPath: AbsolutePath =
    targetroot
      .resolve("META-INF")
      .resolve("semanticdb")
      .resolve(relativePath.toString() + ".semanticdb")
  def textDocument: TextDocument = {
    val docs = TextDocuments.parseFrom(Files.readAllBytes(semanticdbPath.toNIO))
    if (docs.getDocumentsCount == 0)
      TextDocument.newBuilder().build()
    else
      docs.getDocuments(0)
  }
}

object SemanticdbFile {
  def fromDirectory(
      sourceDirectory: AbsolutePath,
      sourceroot: AbsolutePath,
      targetroot: AbsolutePath
  ): Seq[SemanticdbFile] = {
    FileIO
      .listAllFilesRecursively(sourceDirectory)
      .map { file =>
        SemanticdbFile(
          sourceroot,
          file.toRelative(sourceroot),
          sourceDirectory,
          targetroot
        )
      }
  }
}
