package tests

import java.net.URI
import java.nio.file.Files
import java.nio.file.StandardOpenOption

import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath
import scala.meta.io.RelativePath

import com.sourcegraph.lsif_java.commands.IndexSemanticdbCommand
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocument
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocuments
import moped.reporters.ConsoleReporter

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
  def fromProtobuf(
      sourceDirectory: AbsolutePath,
      sourceroot: AbsolutePath,
      targetroot: AbsolutePath
  ): Seq[SemanticdbFile] = {
    IndexSemanticdbCommand
      .protobufTextDocuments(
        List(targetroot.toNIO),
        sourceroot.toNIO,
        ConsoleReporter(System.out)
      )
      .map { doc =>
        val relativePath = AbsolutePath
          .fromAbsoluteUri(URI.create(doc.semanticdb.getUri()))
          .toRelative(sourceroot)
        val semanticdbPath = targetroot
          .resolve("META-INF")
          .resolve("semanticdb")
          .resolve(relativePath.toURI(false).toString + ".semanticdb")
        val bytes = TextDocuments
          .newBuilder()
          .addDocuments(doc.semanticdb)
          .build()
          .toByteArray()
        Files.createDirectories(semanticdbPath.toNIO.getParent())
        Files.write(
          semanticdbPath.toNIO,
          bytes,
          StandardOpenOption.TRUNCATE_EXISTING,
          StandardOpenOption.CREATE
        )
        SemanticdbFile(sourceroot, relativePath, sourceDirectory, targetroot)
      }
  }
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
