package com.sourcegraph.lsif_java.buildtools

import java.nio.charset.StandardCharsets
import java.nio.file._

import scala.collection.mutable.ListBuffer
import scala.util.Properties

import com.sourcegraph.lsif_java.Embedded
import com.sourcegraph.lsif_java.commands.IndexCommand
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
      buildCommand += lsifJavaDependencies

      val result = index.process(buildCommand.toList: _*)
      printDebugLogs(tmp)
      Embedded
        .reportUnexpectedJavacErrors(index.app.reporter, tmp)
        .getOrElse(result)
    }
  }

  private def lsifJavaDependencies = "lsifJavaDependencies"

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
    val dependenciesPath = targetroot.resolve("dependencies.txt")
    Files.deleteIfExists(dependenciesPath)
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
          |  task $lsifJavaDependencies {
          |    def depsOut = java.nio.file.Paths.get('$dependenciesPath')
          |    doLast {
          |      tasks.withType(JavaCompile) {
          |        try {
          |          configurations.each { config ->
          |              def artifactType = org.gradle.api.attributes.Attribute.of("artifactType", String.class)
          |              def attributeType = "jar"
          |              if (config.canBeResolved) {
          |                def artifacts = config.incoming.artifactView { view ->
          |                  view.lenient = true
          |                  view.attributes { container ->
          |                    container.attribute(artifactType, attributeType)
          |                  }
          |                }.artifacts
          |                def lines = artifacts.collect {
          |                    def id = it.id.componentIdentifier
          |                    return "$$id.group\t$$id.module\t$$id.version\t$$it.file"
          |                }
          |                java.nio.file.Files.write(
          |                    depsOut,
          |                    lines.unique(false),
          |                    java.nio.file.StandardOpenOption.APPEND,
          |                    java.nio.file.StandardOpenOption.CREATE)
          |              }
          |          }
          |        } catch (Exception e) {
          |          // Ignore errors.
          |        }
          |      }
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
