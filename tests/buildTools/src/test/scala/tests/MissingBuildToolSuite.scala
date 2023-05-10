package tests

class MissingBuildToolSuite extends BaseBuildToolSuite {

  checkErrorOutput(
    "basic",
    List("index"),
    expectedOutput =
      s"""|error: No build tool detected in workspace '${java.io.File.separator}workingDirectory'. At the moment, the only supported build tools are: Maven, Gradle, sbt, mill.
          |""".stripMargin,
    workingDirectoryLayout = ""
  )

  checkErrorOutput(
    "ambiguous",
    List("index"),
    expectedOutput =
      """|error: Multiple build tools detected: Maven, Gradle. To fix this problem, use the '--build-tool=BUILD_TOOL_NAME' flag to specify which build tool to run.
         |""".stripMargin,
    workingDirectoryLayout =
      """|/pom.xml
         |<hello/>
         |/build.gradle
         |def foo= 42
         |""".stripMargin
  )

  checkErrorOutput(
    "no-matching-explicit",
    List("index", "--build-tool", "Gradle"),
    expectedOutput =
      """|error: Automatically detected the build tool(s) Maven but none of them match the explicitly provided flag '--build-tool=Gradle'. To fix this problem, run again with the --build-tool flag set to one of the detected build tools.
         |""".stripMargin,
    workingDirectoryLayout =
      """|/pom.xml
         |<hello/>
         |""".stripMargin
  )

  checkErrorOutput(
    "levenshtein",
    List("index", "--build-tool", "Mave"),
    expectedOutput =
      """|error: Automatically detected the build tool(s) Maven but none of them match the explicitly provided flag '--build-tool=Mave'. Did you mean --build-tool=Maven?
         |""".stripMargin,
    workingDirectoryLayout =
      """|/pom.xml
         |<hello/>
         |""".stripMargin
  )
}
