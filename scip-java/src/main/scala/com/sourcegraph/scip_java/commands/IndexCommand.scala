package com.sourcegraph.scip_java.commands

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.sourcegraph.io.AbsolutePath
import com.sourcegraph.scip_java.buildtools.BuildTool
import fansi.Color
import moped.annotations._
import moped.cli.Application
import moped.cli.Command
import moped.cli.CommandParser
import moped.internal.reporters.Levenshtein
import os.CommandResult
import os.ProcessOutput
import os.Shellable

@Description(
  "Automatically generate an SCIP index in the current working directory."
)
@Usage("scip-java index [OPTIONS ...] -- [TRAILING_ARGUMENTS ...]")
@ExampleUsage(
  """|# Running the `index` command with no flags should work most of the time.
     |$ scip-java index""".stripMargin
)
case class IndexCommand(
    @Description("The path where to generate the SCIP index.") output: Path =
      Paths.get("index.scip"),
    @Description(
      "The directory where to generate SemanticDB files. " +
        "Defaults to a build-specific path. " +
        "For example, the default value for Gradle is 'build/semanticdb-targetroot' and for Maven it's 'target/semanticdb-targetroot'"
    ) targetroot: Option[Path] = None,
    @Description(
      "Whether to enable the -verbose flag in the SemanticDB compiler plugin."
    ) verbose: Boolean = false,
    @Description(
      "Whether to enable the -text:on flag in the SemanticDB compiler plugin."
    ) text: Boolean = false,
    @Description(
      "Explicitly specify which build tool to use. " +
        "By default, the build tool is automatically detected. " +
        "Use this flag if the automatic build tool detection is not working correctly."
    )
    @ExampleValue("Gradle") buildTool: Option[String] = None,
    @Description(
      "Whether to remove generated temporary files on exit."
    ) cleanup: Boolean = true,
    @Description("URL to a PackageHub instance")
    @Hidden // Hidden because it's not supposed to be used yet by normal users.
    packagehub: Option[String] = None,
    @Hidden // Hidden because it's only used for testing purposes
    temporaryDirectory: Option[Path] = None,
    @Description(
      "Optional. The build command to use to compile all sources. " +
        "Defaults to a build-specific command. For example, the default command for Maven command is 'clean verify -DskipTests'." +
        "To override the default, pass in the build command after a double dash: 'scip-java index -- compile test:compile'"
    )
    @TrailingArguments() buildCommand: List[String] = Nil,
    @Inline
    app: Application = Application.default
) extends Command {

  def process(
      shellable: Shellable,
      env: Map[String, String] = Map.empty
  ): CommandResult = {
    val commandSyntax = shellable
      .value
      .map { line =>
        if (line.contains(" "))
          s"""'$line'"""
        else
          line
      }
      .mkString("$ ", " ", "")
    app.out.println(Color.DarkGray(commandSyntax))
    app
      .process(shellable)
      .call(
        check = false,
        stdout = ProcessOutput.Readlines(line => app.out.println(line)),
        stderr = ProcessOutput.Readlines(line => app.err.println(line)),
        cwd = workingDirectory,
        env = env
      )
  }

  def textFlag: String =
    if (text)
      "-text:on"
    else
      ""
  def verboseFlag: String =
    if (verbose)
      "-verbose:on"
    else
      ""

  def workingDirectory: Path = AbsolutePath.of(app.env.workingDirectory)
  def finalTargetroot(default: Path): Path =
    AbsolutePath.of(targetroot.getOrElse(default), workingDirectory)
  def finalOutput: Path = AbsolutePath.of(output, workingDirectory)
  def finalBuildCommand(default: List[String]): List[String] =
    if (buildCommand.isEmpty)
      default
    else
      buildCommand

  override def run(): Int = {
    val allBuildTools = BuildTool.all(this)
    val usedBuildTools = allBuildTools.filter(_.usedInCurrentDirectory())
    val matchingBuildTools = usedBuildTools.filter(tool =>
      buildTool match {
        case Some(explicitName) =>
          tool.name.compareToIgnoreCase(explicitName) == 0
        case None =>
          true
      }
    )

    buildTool match {
      case Some(auto) if auto.equalsIgnoreCase("auto") =>
        runAutoBuildTool()
      case _ =>
        matchingBuildTools match {
          case Nil =>
            unknownBuildTool(buildTool, usedBuildTools)
          case tool :: Nil =>
            tool.generateScip()
          case many =>
            val names = many.map(_.name).mkString(", ")
            app.error(
              s"Multiple build tools detected: $names. " +
                s"To fix this problem, use the '--build-tool=BUILD_TOOL_NAME' flag to specify which build tool to run."
            )
            1
        }
    }
  }

  private def unknownBuildTool(
      buildTool: Option[String],
      usedBuildTools: List[BuildTool]
  ): Int = {
    buildTool match {
      case Some(explicit) if usedBuildTools.nonEmpty =>
        val toFix =
          Levenshtein
            .closestCandidate(explicit, usedBuildTools.map(_.name)) match {
            case Some(closest) =>
              s"Did you mean --build-tool=$closest?"
            case None =>
              "To fix this problem, run again with the --build-tool flag set to one of the detected build tools."
          }
        val autoDetected = usedBuildTools.map(_.name).mkString(", ")
        app.error(
          s"Automatically detected the build tool(s) $autoDetected but none of them match the explicitly provided flag '--build-tool=$explicit'. " +
            toFix
        )
      case _ =>
        if (Files.isDirectory(workingDirectory)) {
          app.error(
            s"No build tool detected in workspace '$workingDirectory'. " +
              s"At the moment, the only supported build tools are: ${BuildTool.allNames}."
          )
        } else {
          val cause =
            if (Files.exists(workingDirectory)) {
              s"Workspace '$workingDirectory' is not a directory"
            } else {
              s"The directory '$workingDirectory' does not exist"
            }
          app.error(
            cause +
              s". To fix this problem, make sure the working directory is an actual directory."
          )
        }
    }

    1
  }

  private def runAutoBuildTool(): Int = {
    val usedInOrder = BuildTool
      .autoOrdered(this)
      .filter(_.usedInCurrentDirectory())

    usedInOrder match {
      case Nil =>
        app.error(
          "Build tool mode set to `auto`, but no supported build tools were detected"
        )
        1
      case first :: rest =>
        val restMessage = rest
          .map(_.name)
          .mkString(", other tools that were detected:  [", ", ", "]")

        app.info(
          s"Auto mode: `${first.name}` will be used in this workspace${restMessage}"
        )

        first.generateScip()
    }
  }

}

object IndexCommand {
  val default: IndexCommand = IndexCommand()
  implicit val parser: CommandParser[IndexCommand] = CommandParser
    .derive(default)
}
