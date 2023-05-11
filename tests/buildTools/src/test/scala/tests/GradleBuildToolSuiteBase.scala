package tests

import java.nio.file.Files
import java.nio.file.StandardOpenOption

import munit.TestOptions

abstract class GradleBuildToolSuiteBase(val allGradle: List[String])
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
      gradleVersions: List[String],
      expectedSemanticdbFiles: Int = 0,
      expectedPackages: String = "",
      extraArguments: List[String] = Nil
  ) = {
    gradleVersions
      .filter(allGradle.contains(_))
      .foreach { gradleV =>
        {
          val testName = title.withName(title.name + s"-gradle$gradleV")
          checkBuild(
            if (gradleV.startsWith("6.") || gradleV.startsWith("5."))
              testName.tag(Java8Only)
            else
              testName,
            setup,
            expectedSemanticdbFiles = expectedSemanticdbFiles,
            expectedPackages = expectedPackages,
            initCommand = gradleVersion(gradleV),
            extraArguments = extraArguments
          )
        }
      }
  }
}
