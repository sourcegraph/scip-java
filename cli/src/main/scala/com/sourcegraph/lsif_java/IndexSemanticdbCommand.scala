package com.sourcegraph.lsif_java

import moped.cli.Command
import java.nio.file.Path
import moped.annotations.Description
import moped.annotations.PositionalArguments
import moped.annotations.ExampleUsage
import moped.annotations.Usage
import moped.annotations.Inline
import moped.cli.Application
import scala.collection.mutable.ListBuffer
import os.Shellable
import os.Inherit
import moped.cli.CommandParser
import moped.annotations.CommandName

@Description("Converts SemanticDB files into a single LSIF index file.")
@Usage("lsif-java index-semanticdb [OPTIONS ...] [POSITIONAL ARGUMENTS ...]")
@ExampleUsage(
  "lsif-java index-semanticdb --out=myindex.lsif my/targetroot1 my/targetroot2"
)
@CommandName("index-semanticdb")
final case class IndexSemanticdbCommand(
    @Description(
      "The name of the output file. Defaults to 'dump.lsif'"
    ) out: Option[Path] = None,
    @Description(
      "SemanticDB file paths or directories that contain SemanticDB files."
    )
    @PositionalArguments() directories: List[Path] = Nil,
    @Inline() app: Application = Application.default
) extends Command {
  def run(): Int = {
    val arguments = ListBuffer.empty[String]
    arguments += "lsif-semanticdb"
    out.foreach { dir =>
      arguments += s"--out=$dir"
    }
    directories.foreach { dir =>
      arguments += s"--semanticdbDir=$dir"
    }
    app.info(arguments.mkString(" "))
    app
      .process(Shellable(arguments.toList))
      .call(check = false, stderr = Inherit, stdout = Inherit)
      .exitCode
  }
}

object IndexSemanticdbCommand {
  val default = IndexSemanticdbCommand()
  implicit val parser = CommandParser.derive(default)
}
