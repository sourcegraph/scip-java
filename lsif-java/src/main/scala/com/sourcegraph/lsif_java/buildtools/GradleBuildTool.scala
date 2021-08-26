package com.sourcegraph.lsif_java.buildtools

import java.nio.charset.StandardCharsets
import java.nio.file._

import scala.collection.mutable.ListBuffer
import scala.util.Properties

import com.sourcegraph.lsif_java.Embedded
import com.sourcegraph.lsif_java.commands.IndexCommand
import os.CommandResult

class GradleBuildTool(index: IndexCommand) extends BuildTool("Gradle", index) {

  override def usedInCurrentDirectory(): Boolean = {
    Files.isRegularFile(index.workingDirectory.resolve("settings.gradle")) ||
    Files.isRegularFile(index.workingDirectory.resolve("gradlew")) ||
    Files.isRegularFile(index.workingDirectory.resolve("build.gradle")) ||
    Files.isRegularFile(index.workingDirectory.resolve("build.gradle.kts"))
  }

  override def generateLsif(): Int = {
    BuildTool
      .generateLsifFromTargetroot(generateSemanticdb(), targetroot, index)
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
      if (Files.isRegularFile(gradleWrapper))
        gradleWrapper.toString
      else
        "gradle"

    TemporaryFiles.withDirectory(index) { tmp =>
      val toolchains = GradleJavaToolchains
        .fromWorkspace(this, index, gradleCommand, tmp)
      toolchains.gradleVersion match {
        case Some(gradleVersion)
            if gradleVersion.startsWith("6.7") &&
              toolchains.toolchains.nonEmpty =>
          index
            .app
            .error(
              "lsif-java does not support Gradle 6.7 when used together with Java toolchains. " +
                "To fix this problem, upgrade to Gradle version 6.8 or newer and try again."
            )
          CommandResult(1, Nil)
        case _ =>
          runCompileCommand(toolchains)
      }
    }
  }

  private def runCompileCommand(
      toolchains: GradleJavaToolchains
  ): CommandResult = {
    val script = initScript(toolchains, toolchains.tmp).toString
    val buildCommand = ListBuffer.empty[String]
    buildCommand += toolchains.gradleCommand
    buildCommand += s"--no-daemon"
    buildCommand += "--init-script"
    buildCommand += script
    if (toolchains.toolchains.nonEmpty) {
      buildCommand += "-Porg.gradle.java.installations.auto-detect=false"
      buildCommand += "-Porg.gradle.java.installations.auto-download=false"
      buildCommand +=
        s"-Porg.gradle.java.installations.paths=${toolchains.paths()}"
    }
    buildCommand ++= index.finalBuildCommand(List("clean", "compileTestJava"))
    buildCommand += lsifJavaDependencies

    val result = index.process(buildCommand, env = Map("TERM" -> "dumb"))
    printDebugLogs(toolchains.tmp)
    Embedded
      .reportUnexpectedJavacErrors(index.app.reporter, toolchains.tmp)
      .getOrElse(result)
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

    val agentpath = Embedded.agentJar(tmp)
    val pluginpath = Embedded.semanticdbJar(tmp)
    val dependenciesPath = targetroot.resolve("dependencies.txt")
    Files.deleteIfExists(dependenciesPath)
    val script =
      s"""|allprojects {
          |  gradle.projectsEvaluated {
          |    boolean isJavaEnabled = project.plugins.any {
          |       it.getClass().getName().endsWith("org.gradle.api.plugins.JavaPlugin")
          |    }
          |    boolean isScalaEnabled = project.plugins.any {
          |       it.getClass().getName().endsWith("org.gradle.api.plugins.scala.ScalaPlugin")
          |    }
          |    if (isJavaEnabled) {
          |      tasks.withType(JavaCompile) {
          |        options.fork = true
          |        options.incremental = false
          |        $executable
          |      }
          |    }
          |    if (isScalaEnabled) {
          |      // The Scala plugin runs Zinc, an incremental compiler, in a separate daemon process.
          |      // Zinc invokes the Java compiler directly to compile mixed Java/Scala projects
          |      // instead of respecting the `JavaCompile` fork options from the Gradle Java plugin.
          |      // By enabling the SemanticDB Java agent on the Zinc daemon process, we manage
          |      // to configure Zinc to use the semanticdb-javac compiler plugin for Java compilation.
          |      tasks.withType(ScalaCompile) {
          |        scalaCompileOptions.forkOptions.with {
          |          jvmArgs << '-javaagent:$agentpath'
          |          jvmArgs << '-Dsemanticdb.pluginpath=$pluginpath'
          |          jvmArgs << '-Dsemanticdb.sourceroot=$sourceroot'
          |          jvmArgs << '-Dsemanticdb.targetroot=$targetroot'
          |        }
          |      }
          |    }
          |  }
          |  task $lsifJavaDependencies {
          |    def depsOut = java.nio.file.Paths.get('$dependenciesPath')
          |    doLast {
          |      java.nio.file.Files.createDirectories(depsOut.getParent())
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
