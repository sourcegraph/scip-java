package com.sourcegraph.scip_java.buildtools

import java.nio.file.Files

import com.sourcegraph.scip_java.commands.IndexCommand

class BazelBuildTool(index: IndexCommand) extends BuildTool("Bazel", index) {

  override def isHidden: Boolean = true

  override def usedInCurrentDirectory(): Boolean = {
    Files.isRegularFile(index.workingDirectory.resolve("WORKSPACE"))
  }

  override def generateScip(): Int = {
    index
      .app
      .reporter
      .error(
        "The `scip-java index` command does not work with Bazel builds because Bazel " +
          "requires custom configuration to be added to WORKSPACE and BUILD files. " +
          "The scip-java repository contains an example WORKSPACE file to demonstrate " +
          "how to use scip-java with Bazel https://github.com/sourcegraph/scip-java/blob/main/examples/bazel-example/WORKSPACE"
      )
    1
  }
}
