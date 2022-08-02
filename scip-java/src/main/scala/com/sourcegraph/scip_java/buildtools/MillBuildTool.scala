package com.sourcegraph.scip_java.buildtools

import java.nio.file.Files
import java.nio.file.StandardCopyOption

import scala.jdk.CollectionConverters._

import com.sourcegraph.scip_java.commands.IndexCommand
import com.sourcegraph.scip_java.BuildInfo

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

  private def unconditionallyGenerateScip(): Int = {
    val localMill = Files.isRegularFile(millFile)
    val command =
      if (localMill) {
        "./mill"
      } else {
        "mill"
      }
    val millProcess = index.process(
      List(
        command,
        "--import",
        s"ivy:io.chris-kipp::mill-scip::${BuildInfo.millScipVersion}",
        "io.kipp.mill.scip.Scip/generate"
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
      .resolve("index.scip")

    if (millProcess.exitCode == 0 && Files.isRegularFile(scipFile)) {
      val output = index.workingDirectory.resolve("index.scip")
      Files.copy(scipFile, output, StandardCopyOption.REPLACE_EXISTING)
      index.app.info(output.toString)
    }
    millProcess.exitCode
  }

  private lazy val minimalMillVersion = BuildInfo.minimalMillVersion

  private lazy val millFile = index.workingDirectory.resolve("mill")

  private def isSupportedMillVersion(version: String): Boolean = {
    // Only supported in > 0.10.3 atm and we are on the 0.10x series. This will
    // have to be updated in the future problably to just make sure it doesn't
    // start with anything lower than 0.10.3
    if (
      version.startsWith("0.10") &&
      (version != "0.10.0" || version != "0.10.1" || version != "0.10.2")
    )
      true
    else
      false
  }

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
