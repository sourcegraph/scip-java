package tests

import java.nio.file.Files
import java.nio.file.StandardOpenOption

import munit.TestOptions

abstract class GradleBuildToolSuiteBase(gradle: Tool.Gradle)
    extends BaseBuildToolSuite {

  def gradleVersion(version: String): List[String] = {
    createEmptyBuildScript()
    List("gradle", "wrapper", "--gradle-version", version)
  }

  def createEmptyBuildScript(): Unit = {
    // We're using settings.gradle instead of build.gradle because it's enough for
    // gradle to create a wrapper, and doesn't conflict if the test case uses build.gradle.kts.
    // Turns out gradle produces a very confusing error message if you have both build.gradle and build.gradle.kts
    val script = workingDirectory.resolve("settings.gradle")
    Files.createDirectories(script.getParent)
    Files.write(
      script,
      Array.emptyByteArray,
      StandardOpenOption.TRUNCATE_EXISTING,
      StandardOpenOption.CREATE
    )
  }

  def checkGradleBuild(
      title: TestOptions,
      setup: String,
      expectedSemanticdbFiles: Int = 0,
      expectedPackages: String = "",
      extraArguments: List[String] = Nil,
      gradleVersions: List[Tool.Gradle] = Nil,
      tools: List[Tool] = Nil
  ) = {
    if (gradleVersions.contains(gradle)) {
      val testName = title.withName(title.name + s"-${gradle.name}")

      checkBuild(
        testName,
        setup,
        expectedSemanticdbFiles = expectedSemanticdbFiles,
        expectedPackages = expectedPackages,
        initCommand = gradleVersion(gradle.version),
        extraArguments = extraArguments,
        tools = tools :+ gradle
      )
    }
  }
}
