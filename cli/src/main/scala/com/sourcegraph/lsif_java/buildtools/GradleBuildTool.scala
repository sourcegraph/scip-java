package com.sourcegraph.lsif_java.buildtools

import java.nio.charset.StandardCharsets
import java.nio.file._

import scala.collection.mutable.ListBuffer
import scala.util.Properties

import com.sourcegraph.lsif_java.IndexCommand
import os.CommandResult

class GradleBuildTool(index: IndexCommand) extends BuildTool("Gradle", index) {

  override def defaultTargetroot: Path =
    Paths.get("build", "semanticdb-targetroot")

  override def usedInCurrentDirectory(): Boolean = {
    Files.isRegularFile(index.workingDirectory.resolve("settings.gradle")) ||
    Files.isRegularFile(index.workingDirectory.resolve("gradlew")) ||
    Files.isRegularFile(index.workingDirectory.resolve("build.gradle")) ||
    Files.isRegularFile(index.workingDirectory.resolve("build.gradle.kts"))
  }

  override def generateSemanticdb(): CommandResult = {
    val gradleWrapper: Path = index
      .workingDirectory
      .resolve(
        if (Properties.isWin)
          "gradlew.bat"
        else
          "gradlew"
      )
    val gradleCommand: String =
      if (Files.isRegularFile(gradleWrapper))
        gradleWrapper.toString
      else
        "gradle"

    TemporaryFiles.withDirectory(index.cleanup) { tmp =>
      val toolchains = GradleJavaToolchains
        .fromWorkspace(this, index, gradleCommand, tmp)
      val script = initScript(toolchains, tmp).toString

      val buildCommand = ListBuffer.empty[String]
      buildCommand ++=
        List(
          gradleCommand,
          "--init-script",
          script,
          "-Porg.gradle.java.installations.auto-detect=false",
          "-Porg.gradle.java.installations.auto-download=false",
          s"-Porg.gradle.java.installations.paths=${toolchains.paths()}",
          s"--no-daemon"
        )
      buildCommand ++= index.finalBuildCommand(List("clean", "compileTestJava"))

      val result = index.process(buildCommand.toList: _*)
      printDebugLogs(tmp)
      result
    }
  }

  private def printDebugLogs(tmp: Path): Unit = {
    val path = GradleJavaCompiler.debugPath(tmp)
    if (index.verbose && Files.isRegularFile(path)) {
      Files
        .readAllLines(path)
        .forEach { line =>
          index.app.info(line)
        }
    }
  }

  private def initScript(toolchains: GradleJavaToolchains, tmp: Path): Path = {
    val executable =
      toolchains.executableJavacPath() match {
        case Some(path) =>
          s"options.forkOptions.executable = '$path'"
        case None =>
          ""
      }
    val script =
      s"""|allprojects {
          |  gradle.projectsEvaluated {
          |    boolean isJavaEnabled = project.plugins.any {
          |       it.getClass().getName().endsWith("org.gradle.api.plugins.JavaPlugin")
          |    }
          |    if (!isJavaEnabled) return
          |    tasks.withType(JavaCompile) {
          |      options.fork = true
          |      options.incremental = false
          |      $executable
          |    }
          |  }
          |}
    """.stripMargin
    Files.write(
      tmp.resolve("init-script.gradle"),
      script.getBytes(StandardCharsets.UTF_8)
    )
  }

}
