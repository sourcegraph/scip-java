package com.sourcegraph.scip_java.commands

import java.net.URI
import java.nio.charset.StandardCharsets
import java.nio.file._
import java.nio.file.attribute.BasicFileAttributes

import scala.jdk.CollectionConverters._

import com.sourcegraph.Scip
import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.ScipPrinters
import moped.annotations._
import moped.cli.Application
import moped.cli.Command
import moped.cli.CommandParser

@Description(
  "Generates annotated snapshots for each `*.scip` file in the given target roots."
)
@Usage("scip-java snapshot [OPTIONS ...] [POSITIONAL ARGUMENTS ...]")
@ExampleUsage(
  "scip-java snapshot --output=generated/ my/targetroo1 my/targetroot2"
)
@CommandName("snapshot")
case class SnapshotCommand(
    @PositionalArguments
    @Description("List of directories containing SCIP files") targetroot: List[
      Path
    ] = Nil,
    @Description("Output directory for the annotated snapshots") output: Path =
      Paths.get("generated"),
    cleanup: Boolean = true,
    @Inline() app: Application = Application.default
) extends Command {
  def sourceroot: Path = app.env.workingDirectory

  override def run(): Int = {
    val scipPattern = FileSystems.getDefault.getPathMatcher("glob:**.scip")
    if (cleanup) {
      Files.walkFileTree(output, new DeleteVisitor())
    }
    Files.createDirectories(output)
    var foundScipFile = false
    targetroot.foreach { root =>
      Files.walkFileTree(
        root,
        new SimpleFileVisitor[Path] {
          override def visitFile(
              file: Path,
              attrs: BasicFileAttributes
          ): FileVisitResult = {
            if (scipPattern.matches(file)) {
              foundScipFile = true
              val index = Scip.Index.parseFrom(Files.readAllBytes(file))
              val root = URI.create(index.getMetadata.getProjectRoot)
              index
                .getDocumentsList
                .asScala
                .foreach { doc =>
                  val sourcepath = Paths.get(root.resolve(doc.getRelativePath))
                  val source =
                    new String(
                      Files.readAllBytes(sourcepath),
                      StandardCharsets.UTF_8
                    )
                  val document = ScipPrinters
                    .printTextDocument(doc, source, CommentSyntax.default)
                  val snapshotOutput = output.resolve(doc.getRelativePath)
                  Files.createDirectories(snapshotOutput.getParent)
                  Files.write(
                    snapshotOutput,
                    document.getBytes(StandardCharsets.UTF_8)
                  )
                }
            }
            super.visitFile(file, attrs)
          }
        }
      )
    }
    if (foundScipFile) {
      0
    } else {
      app.error(
        s"no SCIP files found. To fix this problem, make sure that one of the directories " +
          s"in ${targetroot.mkString(", ")} contains a `*.scip` file."
      )
      1
    }
  }
}

object SnapshotCommand {
  implicit val parser = CommandParser.derive(SnapshotCommand())
}
