package tests

import java.nio.file.Files
import java.nio.file.StandardOpenOption
import munit.TestOptions
import GradleBuildToolSuite._

class LegacyGradleBuiltToolSuite
    extends GradleBuildToolSuiteBase(List("3.3", "2.2.1")) {
  checkGradleBuild(
    "legacy".tag(Java8Only),
    s"""|/build.gradle
        |apply plugin: 'java'
        |/src/main/java/Example.java
        |public class Example {}
        |/src/test/java/ExampleSuite.java
        |public class ExampleSuite {}
        |""".stripMargin,
    expectedSemanticdbFiles = 2,
    gradleVersions = allGradle
    // NOTE(olafur): no packages because we use more modern APIs.
  )

}

