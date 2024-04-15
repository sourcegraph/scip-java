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
    val script = workingDirectory.resolve("build.gradle")
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
    val testName = title.withName(title.name + s"-${gradle.name}")

    checkBuild(
      if (gradleVersions.contains(gradle))
        testName
      else
        testName.ignore,
      setup,
      expectedSemanticdbFiles = expectedSemanticdbFiles,
      expectedPackages = expectedPackages,
      initCommand = gradleVersion(gradle.version),
      extraArguments = extraArguments,
      tools = tools :+ gradle
    )
  }
}
