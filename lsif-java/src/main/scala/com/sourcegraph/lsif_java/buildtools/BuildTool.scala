package com.sourcegraph.lsif_java.buildtools

import java.nio.file.Files
import java.nio.file.Path

import com.sourcegraph.lsif_java.commands.IndexCommand
import com.sourcegraph.lsif_java.commands.IndexSemanticdbCommand
import os.CommandResult

/**
 * A build tool such as Gradle, Maven or Bazel.
 */
abstract class BuildTool(val name: String, index: IndexCommand) {
  def isHidden: Boolean = false
  final def sourceroot: Path = index.workingDirectory
  def usedInCurrentDirectory(): Boolean
  def generateLsif(): Int
}

object BuildTool {
  def all(index: IndexCommand): List[BuildTool] =
    List(
      new GradleBuildTool(index),
      new MavenBuildTool(index),
      new LsifBuildTool(index),
      new SbtBuildTool(index)
    )
  def allNames: String =
    all(IndexCommand()).filterNot(_.isHidden).map(_.name).mkString(", ")

  def generateLsifFromTargetroot(
      generateSemanticdbResult: CommandResult,
      targetroot: Path,
      index: IndexCommand,
      buildKind: String = ""
  ): Int = {
    if (!Files.isDirectory(targetroot)) {
      generateSemanticdbResult.exitCode
    } else if (index.app.reporter.hasErrors()) {
      index.app.reporter.exitCode()
    } else if (generateSemanticdbResult.exitCode != 0) {
      generateSemanticdbResult.exitCode
    } else {
      IndexSemanticdbCommand(
        output = index.finalOutput,
        targetroot = List(targetroot),
        packagehub = index.packagehub,
        buildKind = buildKind,
        app = index.app
      ).run()
    }
  }
}
