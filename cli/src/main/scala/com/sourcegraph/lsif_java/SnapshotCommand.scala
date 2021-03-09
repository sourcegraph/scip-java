package com.sourcegraph.lsif_java

import java.nio.charset.StandardCharsets
import java.nio.file.FileSystems
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes

import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._

import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocument
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocuments
import moped.annotations.CommandName
import moped.annotations.Description
import moped.annotations.ExampleUsage
import moped.annotations.Inline
import moped.annotations.PositionalArguments
import moped.annotations.Usage
import moped.cli.Application
import moped.cli.Command
import moped.cli.CommandParser

@Description(
  "Generates annotated snapshots for each SemanticDB file in the given target roots."
)
@Usage("lsif-java snapshot [OPTIONS ...] [POSITIONAL ARGUMENTS ...]")
@ExampleUsage(
  "lsif-java snapshot --output=generated/ my/targetroo1 my/targetroot2"
)
@CommandName("snapshot")
case class SnapshotCommand(
    @PositionalArguments
    @Description(
      "List of directories containing SemanticDB files"
    ) targetroot: List[Path] = Nil,
    @Description("Output directory for the annotated snapshots") output: Path =
      Paths.get("generated"),
    @Inline() app: Application = Application.default
) extends Command {
  def sourceroot: Path = app.env.workingDirectory

  override def run(): Int = {
    val semanticdbPattern = FileSystems
      .getDefault
      .getPathMatcher("glob:**.semanticdb")
    Files.walkFileTree(output, new DeleteVisitor())
    Files.createDirectories(output)
    val semanticdbFiles = ListBuffer.empty[TextDocument]

    targetroot.foreach { root =>
      Files.walkFileTree(
        root,
        new SimpleFileVisitor[Path] {
          override def visitFile(
              file: Path,
              attrs: BasicFileAttributes
          ): FileVisitResult = {
            if (semanticdbPattern.matches(file)) {
              val docs = TextDocuments.parseFrom(Files.readAllBytes(file))
              docs
                .getDocumentsList
                .asScala
                .foreach { doc =>
                  val sourcepath = sourceroot.resolve(doc.getUri)
                  val source =
                    new String(
                      Files.readAllBytes(sourcepath),
                      StandardCharsets.UTF_8
                    )
                  semanticdbFiles +=
                    TextDocument.newBuilder(doc).setText(source).build()
                }
            }
            super.visitFile(file, attrs)
          }
        }
      )
    }

    semanticdbFiles.foreach { doc =>
      val document = SemanticdbPrinters.printTextDocument(doc)
      val snapshotOutput = output.resolve(doc.getUri)
      Files.createDirectories(snapshotOutput.getParent)
      Files.write(snapshotOutput, document.getBytes(StandardCharsets.UTF_8))
    }

    0
  }
}

object SnapshotCommand {
  implicit val parser = CommandParser.derive(SnapshotCommand())
}
