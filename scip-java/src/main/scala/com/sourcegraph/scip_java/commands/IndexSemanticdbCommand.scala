package com.sourcegraph.scip_java.commands

import java.nio.file.Path
import java.nio.file.Paths

import scala.jdk.CollectionConverters._

import com.sourcegraph.io.AbsolutePath
import com.sourcegraph.scip_java.BuildInfo
import com.sourcegraph.scip_java.buildtools.ClasspathEntry
import com.sourcegraph.scip_semanticdb.ConsoleScipSemanticdbReporter
import com.sourcegraph.scip_semanticdb.ScipSemanticdb
import com.sourcegraph.scip_semanticdb.ScipSemanticdbOptions
import moped.annotations._
import moped.cli.Application
import moped.cli.Command
import moped.cli.CommandParser
import org.scip_code.scip.ToolInfo

@Description("Converts SemanticDB files into a single SCIP index file.")
@Usage("scip-java index-semanticdb [OPTIONS ...] [POSITIONAL ARGUMENTS ...]")
@ExampleUsage(
  "scip-java index-semanticdb --out=myindex.scip my/targetroot1 my/targetroot2"
)
@CommandName("index-semanticdb")
final case class IndexSemanticdbCommand(
    @Description("The name of the output file.")
    output: Path = Paths.get("index.scip"),
    @Description("Whether to process the SemanticDB files in parallel")
    parallel: Boolean = true,
    @Description(
      "Whether to infer the location of SemanticDB files based as produced by Bazel"
    )
    bazel: Boolean = true,
    @Description(
      "Whether to emit parent->child relationships for 'Find references' and 'Find implementations'. " +
        "This flag exists as a workaround for the issue https://github.com/sourcegraph/sourcegraph/issues/50927"
    )
    emitInverseRelationships: Boolean = true,
    @Description("Directories that contain SemanticDB files.")
    @PositionalArguments()
    targetroot: List[Path] = Nil,
    @Description(
      "If true, don't report an error when no documents have been indexed. " +
        "The resulting SCIP index will silently be empty instead."
    )
    allowEmptyIndex: Boolean = false,
    @Description(
      "Determines how to index symbols that are compiled to classfiles inside directories. " +
        "If true, symbols inside directory entries are allowed to be publicly visible outside of the generated SCIP index. " +
        "If false, symbols inside directory entries are only visible inside the generated SCIP index. " +
        "The practical consequences of making this flag false is that cross-index (or cross-repository) navigation does not work between " +
        "Maven->Maven or Gradle->Gradle projects because those build tools compile sources to classfiles inside directories."
    )
    allowExportingGlobalSymbolsFromDirectoryEntries: Boolean = true,
    @Inline()
    app: Application = Application.default
) extends Command {
  def sourceroot: Path = AbsolutePath.of(app.env.workingDirectory)
  def absoluteTargetroots: List[Path] =
    if (targetroot.isEmpty)
      List(sourceroot)
    else
      targetroot.map(AbsolutePath.of(_, sourceroot))

  def run(): Int = {
    val reporter = new ConsoleScipSemanticdbReporter(app)
    val packages =
      absoluteTargetroots
        .iterator
        .flatMap(targetroot =>
          ClasspathEntry.fromTargetroot(targetroot, sourceroot)
        )
        .distinct
        .toList
    val options =
      new ScipSemanticdbOptions(
        absoluteTargetroots.asJava,
        AbsolutePath.of(output, sourceroot),
        sourceroot,
        reporter,
        ToolInfo
          .newBuilder()
          .setName("scip-java")
          .setVersion(BuildInfo.version)
          .build(),
        parallel,
        packages.map(_.toPackageInformation).asJava,
        emitInverseRelationships,
        allowEmptyIndex,
        allowExportingGlobalSymbolsFromDirectoryEntries
      )
    ScipSemanticdb.run(options)
    if (!app.reporter.hasErrors()) {
      app.info(options.output.toString)
    }
    app.reporter.exitCode()
  }
}

object IndexSemanticdbCommand {
  val default = IndexSemanticdbCommand()
  implicit val parser = CommandParser.derive(default)
}
