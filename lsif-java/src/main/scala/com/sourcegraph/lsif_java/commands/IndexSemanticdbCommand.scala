package com.sourcegraph.lsif_java.commands

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.TimeUnit

import scala.jdk.CollectionConverters._

import com.sourcegraph.io.AbsolutePath
import com.sourcegraph.lsif_java.BuildInfo
import com.sourcegraph.lsif_java.buildtools.ClasspathEntry
import com.sourcegraph.lsif_protobuf.LsifProtobuf
import com.sourcegraph.lsif_protocol.LsifToolInfo
import com.sourcegraph.lsif_semanticdb.ConsoleLsifSemanticdbReporter
import com.sourcegraph.lsif_semanticdb.LsifOutputFormat
import com.sourcegraph.lsif_semanticdb.LsifSemanticdb
import com.sourcegraph.lsif_semanticdb.LsifSemanticdbOptions
import com.sourcegraph.lsif_semanticdb.LsifTextDocument
import moped.annotations._
import moped.cli.Application
import moped.cli.Command
import moped.cli.CommandParser
import moped.reporters.Reporter
import ujson.Arr
import ujson.Obj

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
  def isProtobufFormat: Boolean =
    IndexSemanticdbCommand.isProtobufFormat(output)
  def absoluteTargetroots: List[Path] =
    targetroot.map(AbsolutePath.of(_, app.env.workingDirectory))
  def run(): Int = {
    val reporter = new ConsoleLsifSemanticdbReporter(app)
    val format =
      if (isProtobufFormat)
        LsifOutputFormat.PROTOBUF
      else
        LsifOutputFormat.JSON
    val packages =
      absoluteTargetroots
        .iterator
        .flatMap(ClasspathEntry.fromTargetroot)
        .distinct
        .toList
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
        parallel,
        packages.map(_.toPackageInformation).asJava,
        buildKind,
        IndexSemanticdbCommand
          .protobufTextDocuments(targetroot, sourceroot, app.reporter)
          .asJava
      )
    LsifSemanticdb.run(options)
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
  def isJsonFormat(path: Path): Boolean =
    path.getFileName.toString.endsWith(".lsif")
  def isProtobufFormat(path: Path): Boolean =
    path.getFileName.toString.endsWith(".lsif-protobuf")
  val default = IndexSemanticdbCommand()
  implicit val parser = CommandParser.derive(default)

  def protobufTextDocuments(
      targetroots: List[Path],
      sourceroot: Path,
      reporter: Reporter
  ): List[LsifTextDocument] = {
    for {
      root <- targetroots
      protobufDirectory = root.resolve("protobuf")
      file <- Option(protobufDirectory.toFile().listFiles()).toList.flatten
      if file.getName().endsWith(".protobuf-command.txt")
      protocOptions = Files.readAllLines(file.toPath()).asScala.toList
      protobuf = new LsifProtobuf(sourceroot, protocOptions, reporter)
      document <- protobuf.textDocuments().getDocumentsList().asScala
    } yield new LsifTextDocument(file.toPath, document, sourceroot)
  }
}
