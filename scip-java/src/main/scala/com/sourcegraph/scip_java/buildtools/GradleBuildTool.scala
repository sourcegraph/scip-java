package com.sourcegraph.scip_java.buildtools

import java.nio.charset.StandardCharsets
import java.nio.file._

import scala.collection.mutable.ListBuffer
import scala.util.Properties
import scala.util.Try

import com.sourcegraph.io.DeleteVisitor
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
    gradleFiles.exists(name =>
      Files.isRegularFile(index.workingDirectory.resolve(name))
    )
  }

  override def generateScip(): Int = {
    val gradleResult = generateSemanticdb()
    if (gradleResult.exitCode == 0) {
      reportMissingSemanticdbOutput()
    }
    BuildTool.generateScipFromTargetroot(gradleResult, targetroot, index)
  }

  /**
   * Diagnose the case where Gradle finished successfully but our SemanticDB
   * compiler plugin never produced any `.semanticdb` files. This used to be
   * silently rescued by a `-javaagent` fallback; now it surfaces as a clear
   * error pointing at the two known causes.
   */
  private def reportMissingSemanticdbOutput(): Unit = {
    if (containsFileWithSuffix(targetroot, ".semanticdb"))
      return
    if (!containsFileWithSuffix(index.workingDirectory, ".class"))
      // Project produced no compiled JVM output — nothing to index, stay quiet.
      return
    index
      .app
      .reporter
      .error(
        s"""scip-java: Gradle finished successfully but produced no SemanticDB output in $targetroot.
           |
           |This means our SemanticDB compiler plugin was not attached to one or more JavaCompile tasks. Two known causes:
           |
           |  1. The 'compileOnly' configuration was already resolved before our init script ran.
           |     Check the Gradle output above for warnings of the form:
           |       "scip-java: failed to attach SemanticDB compiler plugin to project '<name>'"
           |     Workaround: apply the SemanticDB plugin earlier (e.g. via a settings plugin),
           |     or restructure the build so that 'compileOnly' is not resolved at evaluation time.
           |
           |  2. Another Gradle plugin is replacing the compiler arguments we add (rather than appending).
           |     Verify with:  ./gradlew compileJava --info | grep -- '-Xplugin:semanticdb'
           |     If '-Xplugin:semanticdb' is missing from the printed javac command, another plugin
           |     is overwriting JavaCompile.options.compilerArgs.
           |""".stripMargin
      )
  }

  private def containsFileWithSuffix(root: Path, suffix: String): Boolean =
    Files.isDirectory(root) &&
      Try {
        val stream = Files.find(
          root,
          Integer.MAX_VALUE,
          (p, attrs) =>
            attrs.isRegularFile && p.getFileName.toString.endsWith(suffix)
        )
        try stream.findFirst().isPresent
        finally stream.close()
      }.getOrElse(false)

  def targetroot: Path = index.finalTargetroot(defaultTargetroot)

  private def defaultTargetroot: Path = Paths.get(
    "build",
    "semanticdb-targetroot"
  )
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
    Embedded
      .reportUnexpectedJavacErrors(index.app.reporter, tmp)
      .getOrElse(result)
  }

  private def scipJavaDependencies = "scipJavaDependencies"

  private def initScript(tmp: Path): Path = {
    val pluginpath = Embedded.semanticdbJar(tmp)
    val gradlePluginPath = Embedded.gradlePluginJar(tmp)
    val semanticdbKotlincPath = Embedded.semanticdbKotlincJar(tmp)
    val dependenciesPath = targetroot.resolve("dependencies.txt")
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
         |   project.ext["semanticdbTarget"] = "$targetroot"
         |   project.ext["javacPluginJar"] = "$pluginpath"
         |   project.ext["dependenciesOut"] = "$dependenciesPath"
         |   project.ext["semanticdbKotlincJar"] = "$semanticdbKotlincPath"
         |   apply plugin: SemanticdbGradlePlugin
         | }
      """.stripMargin.trim

    Files.write(
      tmp.resolve("init-script.gradle"),
      script.getBytes(StandardCharsets.UTF_8)
    )
  }

}
