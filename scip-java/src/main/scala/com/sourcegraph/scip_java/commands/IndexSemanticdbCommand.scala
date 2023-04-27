package com.sourcegraph.scip_java.commands

import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.TimeUnit

import scala.jdk.CollectionConverters._

import com.sourcegraph.io.AbsolutePath
import com.sourcegraph.lsif_protocol.LsifToolInfo
import com.sourcegraph.scip_java.BuildInfo
import com.sourcegraph.scip_java.buildtools.ClasspathEntry
import com.sourcegraph.scip_semanticdb.ConsoleScipSemanticdbReporter
import com.sourcegraph.scip_semanticdb.ScipOutputFormat
import com.sourcegraph.scip_semanticdb.ScipSemanticdb
import com.sourcegraph.scip_semanticdb.ScipSemanticdbOptions
import moped.annotations._
import moped.cli.Application
import moped.cli.Command
import moped.cli.CommandParser
import ujson.Arr
import ujson.Obj

@Description("Converts SemanticDB files into a single SCIP index file.")
@Usage("scip-java index-semanticdb [OPTIONS ...] [POSITIONAL ARGUMENTS ...]")
@ExampleUsage(
  "scip-java index-semanticdb --out=myindex.scip my/targetroot1 my/targetroot2"
)
@CommandName("index-semanticdb")
final case class IndexSemanticdbCommand(
    @Description("The name of the output file.") output: Path = Paths
      .get("index.scip"),
    @Description(
      "Whether to process the SemanticDB files in parallel"
    ) parallel: Boolean = true,
    @Description(
      "Whether to infer the location of SemanticDB files based as produced by Bazel"
    ) bazel: Boolean = true,
    @Description(
      "Whether to emit parent->child relationships for 'Find references' and 'Find implementations'. " +
        "This flag exists as a workaround for the issue https://github.com/sourcegraph/sourcegraph/issues/50927"
    ) emitInverseRelationships: Boolean = true,
    @Description("URL to a PackageHub instance")
    @Hidden
    packagehub: Option[String] = None,
    @Description("Directories that contain SemanticDB files.")
    @PositionalArguments() targetroot: List[Path] = Nil,
    @Description(
      "The kind of this build, one of: empty string, jdk, maven"
    ) buildKind: String = "",
    @Inline() app: Application = Application.default
) extends Command {
  def sourceroot: Path = AbsolutePath.of(app.env.workingDirectory)
  def absoluteTargetroots: List[Path] =
    if (targetroot.isEmpty)
      List(sourceroot)
    else
      targetroot.map(AbsolutePath.of(_, sourceroot))

  def run(): Int = {
    val reporter = new ConsoleScipSemanticdbReporter(app)
    val outputFilename = output.getFileName.toString
    val format = ScipOutputFormat.fromFilename(outputFilename)
    if (format == ScipOutputFormat.UNKNOWN) {
      app.error(
        s"unknown output format for filename '$outputFilename'. " +
          s"Supported file extension are `*.scip`, `*scip '"
      )
      return 1
    }
    val packages =
      absoluteTargetroots
        .iterator
        .flatMap(ClasspathEntry.fromTargetroot)
        .distinct
        .toList
    val options =
      new ScipSemanticdbOptions(
        absoluteTargetroots.asJava,
        AbsolutePath.of(output, sourceroot),
        sourceroot,
        reporter,
        LsifToolInfo
          .newBuilder()
          .setName("scip-java")
          .setVersion(BuildInfo.version)
          .build(),
        "java",
        format,
        parallel,
        packages.map(_.toPackageInformation).asJava,
        buildKind,
        emitInverseRelationships
      )
    ScipSemanticdb.run(options)
    postPackages(packages)
    if (!app.reporter.hasErrors()) {
      app.info(options.output.toString)
    }
    app.reporter.exitCode()
  }

  /**
   * If the PackageHub URL is configured, sends an HTTP POST request to register
   * the packages that are used in this codebase.
   *
   * PackageHub is a prototype implementation of this proposal
   * https://docs.google.com/document/d/1ZcZbPLZX0vblcTI_xb5VtO_49b_9tR5lOWSLoVEBm2A/edit#
   */
  private def postPackages(packages: List[ClasspathEntry]): Unit = {
    if (packages.isEmpty)
      return
    packagehub.foreach { url =>
      val json = Obj("packages" -> Arr.from(packages.map(_.toPackageHubId)))
      app.info(s"Posting ${packages.length} package(s) to PackageHub URL $url")
      val response = requests.post(
        s"$url/packagehub/packages",
        headers = Seq("Content-Type" -> "application/json"),
        data = json,
        chunkedUpload = false,
        readTimeout = TimeUnit.MINUTES.toMillis(1).toInt
      )
      val responseJson = ujson.read(response)
      for {
        errors <- responseJson.obj.get("errors").toList
        error <- errors.arr
      } {
        app.warning(error.str)
      }
    }
  }
}

object IndexSemanticdbCommand {
  val default = IndexSemanticdbCommand()
  implicit val parser = CommandParser.derive(default)
}
