package com.sourcegraph.lsif_java.commands

import java.nio.file.Path
import java.nio.file.Paths

import scala.jdk.CollectionConverters._

import com.sourcegraph.io.AbsolutePath
import com.sourcegraph.lsif_java.BuildInfo
import com.sourcegraph.lsif_protocol.LsifToolInfo
import com.sourcegraph.lsif_semanticdb.ConsoleLsifSemanticdbReporter
import com.sourcegraph.lsif_semanticdb.LsifOutputFormat
import com.sourcegraph.lsif_semanticdb.LsifSemanticdb
import com.sourcegraph.lsif_semanticdb.LsifSemanticdbOptions
import moped.annotations._
import moped.cli.Application
import moped.cli.Command
import moped.cli.CommandParser

@Description("Converts SemanticDB files into a single LSIF index file.")
@Usage("lsif-java index-semanticdb [OPTIONS ...] [POSITIONAL ARGUMENTS ...]")
@ExampleUsage(
  "lsif-java index-semanticdb --out=myindex.lsif my/targetroot1 my/targetroot2"
)
@CommandName("index-semanticdb")
final case class IndexSemanticdbCommand(
    @Description("The name of the output file.") output: Path = Paths
      .get("dump.lsif"),
    @Description(
      "Whether to process the SemanticDB files in parallel"
    ) parallel: Boolean = true,
    @Description("Directories that contain SemanticDB files.")
    @PositionalArguments() targetroot: List[Path] = Nil,
    @Inline() app: Application = Application.default
) extends Command {
  def sourceroot: Path = AbsolutePath.of(app.env.workingDirectory)
  def isProtobufFormat: Boolean =
    IndexSemanticdbCommand.isProtobufFormat(output)
  def run(): Int = {
    val reporter = new ConsoleLsifSemanticdbReporter(app)
    val format =
      if (isProtobufFormat)
        LsifOutputFormat.PROTOBUF
      else
        LsifOutputFormat.JSON
    val options =
      new LsifSemanticdbOptions(
        targetroot.map(ts => AbsolutePath.of(ts, sourceroot)).asJava,
        AbsolutePath.of(output, sourceroot),
        sourceroot,
        reporter,
        LsifToolInfo
          .newBuilder()
          .setName("lsif-java")
          .setVersion(BuildInfo.version)
          .build(),
        "java",
        format,
        parallel
      )
    LsifSemanticdb.run(options)
    if (!app.reporter.hasErrors()) {
      app.info(options.output.toString)
    }
    app.reporter.exitCode()
  }
}

object IndexSemanticdbCommand {
  def isJsonFormat(path: Path): Boolean =
    path.getFileName.toString.endsWith(".lsif")
  def isProtobufFormat(path: Path): Boolean =
    path.getFileName.toString.endsWith(".lsif-protobuf")
  val default = IndexSemanticdbCommand()
  implicit val parser = CommandParser.derive(default)
}
