package com.sourcegraph.scip_java.buildtools

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

import scala.jdk.CollectionConverters._
import scala.util.Properties

import com.sourcegraph.scip_java.BuildInfo
import com.sourcegraph.scip_java.commands.IndexCommand

class MillBuildTool(index: IndexCommand) extends BuildTool("mill", index) {

  override def usedInCurrentDirectory(): Boolean =
    Files.isRegularFile(index.workingDirectory.resolve("build.sc"))

  override def generateScip(): Int =
    millVersion() match {
      case Some(version) if isSupportedMillVersion(version) =>
        unconditionallyGenerateScip()
      case Some(version) =>
        failFast(
          s"Unsupported Mill version '${version}'. " +
            s"To fix this problem, upgrade Mill to at least ${minimalMillVersion} and try again."
        )
      case None =>
        failFast(
          s"No Mill version detected. " +
            s"To fix this problem, run the following command and try again: " +
            s"echo '${minimalMillVersion}' >> .mill-version"
        )
    }

  private def failFast(message: String): Int = {
    index.app.error(message)
    1
  }

  private val rawOutput = index.output.toString

  private def unconditionallyGenerateScip(): Int = {
    val millWrapper: Path = index
      .workingDirectory
      .resolve(
        if (Properties.isWin)
          "millw.bat"
        else
          "millw"
      )
    val localMill =
      Files.isRegularFile(millFile) && Files.isExecutable(millFile)
    val command: String =
      if (Files.isRegularFile(millWrapper) && Files.isExecutable(millWrapper))
        millWrapper.toString
      else if (localMill) {
        "./mill"
      } else {
        "mill"
      }

    val millProcess = index.process(
      List(
        command,
        "--no-server",
        "--import",
        s"ivy:io.chris-kipp::mill-scip::${BuildInfo.millScipVersion}",
        "io.kipp.mill.scip.Scip/generate",
        "--output",
        rawOutput
      )
    )
    val scipFile = index
      .workingDirectory
      .resolve("out")
      .resolve("io")
      .resolve("kipp")
      .resolve("mill")
      .resolve("scip")
      .resolve("Scip")
      .resolve("generate.dest")
      .resolve(rawOutput)

    if (millProcess.exitCode == 0 && Files.isRegularFile(scipFile)) {
      val output = index.workingDirectory.resolve(rawOutput)
      Files.copy(scipFile, output, StandardCopyOption.REPLACE_EXISTING)
      index.app.info(output.toString)
    }
    millProcess.exitCode
  }

  private lazy val minimalMillVersion = BuildInfo.minimalMillVersion

  private lazy val millFile = index.workingDirectory.resolve("mill")

  private def isSupportedMillVersion(version: String): Boolean =
    if (version.startsWith("0.1"))
      true
    else
      false

  /**
   * Try to grab the Mill version from the .mill-version file. If not found we
   * fall back to the mill file which could be the official mill launcher or the
   * millw launcher renamed as mill, both which will have a DEFAULT_MILL_VERSION
   * line.
   */
  private def millVersion(): Option[String] = {
    val millVersionFile = index.workingDirectory.resolve(".mill-version")
    if (Files.isRegularFile(millVersionFile)) {
      Files.readAllLines(millVersionFile).asScala.headOption
    } else if (Files.isRegularFile(millFile)) {
      Files
        .readAllLines(millFile)
        .asScala
        .find(_.startsWith("DEFAULT_MILL_VERSION"))
        .map(line => line.dropWhile(!_.isDigit))
    } else {
      None
    }
  }
}
