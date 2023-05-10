package com.sourcegraph.scip_java.buildtools

import java.nio.file.Files
import java.nio.file.Path

import com.sourcegraph.scip_java.commands.IndexCommand
import com.sourcegraph.scip_java.commands.IndexSemanticdbCommand
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

  def autoOrdered(index: IndexCommand): List[BuildTool] =
    List(
      // The order in this list is important -
      // first detected build tool will be used in `auto` mode
      // Bazel is missing because it isn't supported by auto-indexing

      // first as it indicates user's intent to use SCIP auto-indexing
      new ScipBuildTool(index),
      // Maven first, then Gradle, then SBT
      // To match the order indicated in IntelliJ Java and Scala developer surveys 2022:
      // 1. https://www.jetbrains.com/lp/devecosystem-2022/java/#which-build-systems-do-you-regularly-use-if-any-
      // 2. https://www.jetbrains.com/lp/devecosystem-2022/scala/#which-build-systems-do-you-regularly-use-if-any-
      new MavenBuildTool(index),
      new GradleBuildTool(index),
      new SbtBuildTool(index),
      new MillBuildTool(index)
    )
  def allNames: String =
    all(IndexCommand()).filterNot(_.isHidden).map(_.name).mkString(", ")

  def generateScipFromTargetroot(
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
