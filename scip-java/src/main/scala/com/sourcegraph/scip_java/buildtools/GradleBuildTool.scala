package com.sourcegraph.scip_java.buildtools

import java.nio.charset.StandardCharsets
import java.nio.file._

import scala.collection.mutable.ListBuffer
import scala.util.Properties

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.BuildInfo
import com.sourcegraph.scip_java.Embedded
import com.sourcegraph.scip_java.commands.IndexCommand
import os.CommandResult

class GradleBuildTool(index: IndexCommand) extends BuildTool("Gradle", index) {

  override def usedInCurrentDirectory(): Boolean = {
    val gradleFiles = List(
      "settings.gradle",
      "gradlew",
      "build.gradle",
      "build.gradle.kts"
    )
    gradleFiles
      .exists(name => Files.isRegularFile(index.workingDirectory.resolve(name)))
  }

  override def generateScip(): Int = {
    BuildTool
      .generateScipFromTargetroot(generateSemanticdb(), targetroot, index)
  }

  def targetroot: Path = index.finalTargetroot(defaultTargetroot)

  private def defaultTargetroot: Path =
    Paths.get("build", "semanticdb-targetroot")
  private def generateSemanticdb(): CommandResult = {
    val gradleWrapper: Path = index
      .workingDirectory
      .resolve(
        if (Properties.isWin)
          "gradlew.bat"
        else
          "gradlew"
      )
    val gradleCommand: String =
      if (
        Files.isRegularFile(gradleWrapper) && Files.isExecutable(gradleWrapper)
      )
        gradleWrapper.toString
      else
        "gradle"

    TemporaryFiles.withDirectory(index) { tmp =>
      runCompileCommand(tmp, gradleCommand)
    }
  }

  private def runCompileCommand(
      // toolchains: GradleJavaToolchains,
      tmp: Path,
      gradleCommand: String
  ): CommandResult = {
    val script = initScript(tmp).toString
    val buildCommand = ListBuffer.empty[String]
    buildCommand += gradleCommand
    buildCommand += "--no-daemon"
    buildCommand += "--init-script"
    buildCommand += script
    buildCommand += "-Pkotlin.compiler.execution.strategy=in-process"
    buildCommand += s"-Dsemanticdb.targetroot=$targetroot"
    buildCommand ++=
      index.finalBuildCommand(
        List("clean", "scipPrintDependencies", "scipCompileAll")
      )

    Files.walkFileTree(targetroot, new DeleteVisitor())
    val result = index.process(buildCommand, env = Map("TERM" -> "dumb"))
    printDebugLogs(tmp)
    Embedded
      .reportUnexpectedJavacErrors(index.app.reporter, tmp)
      .getOrElse(result)
  }

  private def scipJavaDependencies = "scipJavaDependencies"

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

  private def initScript(tmp: Path): Path = {
    val agentpath = Embedded.agentJar(tmp)
    val pluginpath = Embedded.semanticdbJar(tmp)
    val gradlePluginPath = Embedded.gradlePluginJar(tmp)
    val dependenciesPath = targetroot.resolve("dependencies.txt")
    val kotlinSemanticdbVersion = BuildInfo.semanticdbKotlincVersion
    Files.deleteIfExists(dependenciesPath)

    val script =
      s"""
         | initscript {
         |     dependencies{ 
         |         classpath(files("${gradlePluginPath}"))
         |     }
         | }
         |
         | import com.sourcegraph.gradle.semanticdb.SemanticdbGradlePlugin
         |
         | allprojects {
         |   project.extra["semanticdbTarget"] = "$targetroot"
         |   project.extra["javacPluginJar"] = "$pluginpath"
         |   project.extra["dependenciesOut"] = "$dependenciesPath"
         |   project.extra["javacAgentPath"] = "$agentpath"
         |   apply<SemanticdbGradlePlugin>()
         | }
      """.stripMargin.trim

    Files.write(
      tmp.resolve("init-script.gradle.kts"),
      script.getBytes(StandardCharsets.UTF_8)
    )
  }

  def semanticdbScalacGroovySyntax(): String =
    BuildInfo
      .semanticdbScalacVersions
      .removed(
        "2.12.3"
      ) // Not supported because the last semanticdb-scalac_2.12.3 release doesn't support the option -P:semanticdb:targetroot:PATH.
      .map { case (key, value) =>
        s"'$key':'$value'"
      }.mkString("[", ", ", "]")

}
