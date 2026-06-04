package com.sourcegraph.scip_java.buildtools

import java.nio.file.Files
import java.nio.file.Path

import com.sourcegraph.scip_java.commands.IndexCommand
import os.CommandResult

/**
 * A build tool such as Gradle, Maven or Bazel.
 */
abstract class BuildTool(val name: String, index: IndexCommand) {
  def isHidden: Boolean = false
  final def sourceroot: Path = index.workingDirectory
  def usedInCurrentDirectory(): Boolean
  def generateScip(): Int
}

object BuildTool {
  def all(index: IndexCommand): List[BuildTool] =
    // We don't support Bazel for auto-indexing, but if it's
    // detected, we should at least give a meaningful error message
    autoOrdered(index) :+ new BazelBuildTool(index)

  def autoOrdered(index: IndexCommand): List[BuildTool] = List(
    // The order in this list is important -
    // first detected build tool will be used in `auto` mode
    // Bazel is missing because it isn't supported by auto-indexing

    // first as it indicates user's intent to use SCIP auto-indexing
    new ScipBuildTool(index),
    // Maven first, then Gradle
    // To match the order indicated in IntelliJ Java developer survey 2022:
    // https://www.jetbrains.com/lp/devecosystem-2022/java/#which-build-systems-do-you-regularly-use-if-any-
    new MavenBuildTool(index),
    new GradleBuildTool(index)
  )
  def allNames: String = all(IndexCommand())
    .filterNot(_.isHidden)
    .map(_.name)
    .mkString(", ")

  def generateScipFromTargetroot(
      generateScipResult: CommandResult,
      targetroot: Path,
      index: IndexCommand
  ): Int = {
    if (!Files.isDirectory(targetroot)) {
      generateScipResult.exitCode
    } else if (index.app.reporter.hasErrors()) {
      index.app.reporter.exitCode()
    } else if (generateScipResult.exitCode != 0) {
      generateScipResult.exitCode
    } else {
      index
        .indexScip
        .copy(
          output = index.finalOutput,
          targetroot = List(targetroot),
          app = index.app
        )
        .run()
    }
  }
}
