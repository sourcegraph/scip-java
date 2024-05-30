package com.sourcegraph.scip_java.buildtools

import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.util.Properties

import scala.util.Using

import com.sourcegraph.io.AutoDeletedFile
import com.sourcegraph.scip_java.BuildInfo
import com.sourcegraph.scip_java.commands.IndexCommand

class SbtBuildTool(index: IndexCommand) extends BuildTool("sbt", index) {
  override def usedInCurrentDirectory(): Boolean = {
    Files.isRegularFile(index.workingDirectory.resolve("build.sbt")) ||
    sbtVersion().isDefined
  }

  override def generateScip(): Int = {
    sbtVersion() match {
      case Some(version) =>
        if (isSupportedSbtVersion(version)) {
          unconditionallyGenerateScip()
        } else {
          failFast(
            s"Unsupported sbt version '$version'. " +
              s"To fix this problem, upgrade to sbt ${BuildInfo.sbtVersion} and try again."
          )
        }
      case None =>
        failFast(
          s"No sbt version detected. " +
            s"To fix this problem, run the following command and try again: " +
            s"echo 'sbt.version=${BuildInfo.sbtVersion}' >> project/build.properties"
        )
    }
  }

  private def failFast(message: String): Int = {
    index.app.error(message)
    1
  }

  private def unconditionallyGenerateScip(): Int =
    Using.resource(sourcegraphSbtPluginFile()) { _ =>
      val buildCommand = index.finalBuildCommand(List("sourcegraphScip"))

      val sourcegraphScip = index
        .process(List("sbt", "sourcegraphEnable") ++ buildCommand)

      val inputDump = index
        .workingDirectory
        .resolve("target")
        .resolve("sbt-sourcegraph")
        .resolve("index.scip")

      if (sourcegraphScip.exitCode == 0 && Files.isRegularFile(inputDump)) {
        val outputDump = index.workingDirectory.resolve(index.output)
        Files.copy(inputDump, outputDump, StandardCopyOption.REPLACE_EXISTING)
        index.app.info(outputDump.toString)
      }
      sourcegraphScip.exitCode
    }

  private def isSupportedSbtVersion(version: String): Boolean = {
    SbtBuildTool.isSupportedSbtVersion(version) match {
      case Left(message) =>
        index.app.error(message)
        false
      case Right(value) =>
        value
    }
  }

  private def sbtVersion(): Option[String] = {
    val buildProperties = index
      .workingDirectory
      .resolve("project")
      .resolve("build.properties")
    if (Files.isRegularFile(buildProperties)) {
      val props = new Properties()
      val in = Files.newInputStream(buildProperties)
      try props.load(in)
      finally in.close()
      Option(props.getProperty("sbt.version"))
    } else {
      None
    }
  }

  private def sourcegraphSbtPluginFile(): AutoDeletedFile = {
    val addSbtPluginFile = index
      .workingDirectory
      .resolve("project")
      .resolve("sourcegraph_generated.sbt")
    val version = BuildInfo.sbtSourcegraphVersion
    AutoDeletedFile.fromPath(
      addSbtPluginFile,
      s"""addSbtPlugin("com.sourcegraph" % "sbt-sourcegraph" % "$version")
         |""".stripMargin
    )
  }
}

object SbtBuildTool {
  def isSupportedSbtVersion(version: String): Either[String, Boolean] = {
    SbtVersionParser.versionSegments(version) match {
      case major :: minor :: patch :: _ =>
        Right {
          (major == 0 && minor == 13 && patch >= 17) ||
          (major == 1 && minor >= 2)
        }

      case _ =>
        Left(
          s"Failed to parse SBT version: [$version]. Only SBT 0.13.17+ or SBT 1.2+ are supported"
        )

    }
  }
}

object SbtVersionParser {
  def versionSegments(raw: String) =
    raw
      .takeWhile(c => c.isDigit || c == '.')
      .split("\\.", 3)
      .toList
      .flatMap(_.toIntOption)
}
