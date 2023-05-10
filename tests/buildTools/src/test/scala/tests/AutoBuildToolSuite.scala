package tests

class AutoBuildToolSuite extends BaseBuildToolSuite {
  checkErrorOutput(
    "no-tools-found",
    List("index", "--build-tool", "auto"),
    expectedOutput =
      """error: Build tool mode set to `auto`, but no supported build tools were detected""",
    workingDirectoryLayout = ""
  )
}
