package com.sourcegraph.scip_java.buildtools

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import scala.collection.mutable.ListBuffer

import com.sourcegraph.scip_java.Embedded
import com.sourcegraph.scip_java.commands.IndexCommand
import os.CommandResult

class MavenBuildTool(index: IndexCommand) extends BuildTool("Maven", index) {

  override def usedInCurrentDirectory(): Boolean =
    Files.isRegularFile(index.workingDirectory.resolve("pom.xml"))

  override def generateScip(): Int = {
    BuildTool.generateScipFromTargetroot(
      generateSemanticdb(),
      index.finalTargetroot(defaultTargetroot),
      index
    )
  }

  private def defaultTargetroot: Path =
    Paths.get("target", "semanticdb-targetroot")

  private def generateSemanticdb(): CommandResult = {
    TemporaryFiles.withDirectory(index) { tmp =>
      val mvnw = index.workingDirectory.resolve("mvnw")
      val mavenScript =
        if (Files.isRegularFile(mvnw) && Files.isExecutable(mvnw))
          mvnw.toString
        else {
          "mvn"
        }
      val start = System.nanoTime()
      val buildCommand = ListBuffer.empty[String]
      val executable = Embedded.customJavac(
        index.workingDirectory,
        index.finalTargetroot(defaultTargetroot),
        tmp,
        GradleJavaToolchains.isJavaAtLeast(SystemJavaVersion.detect(), "11")
      )
      buildCommand ++=
        List(
          mavenScript,
          s"-Dmaven.compiler.useIncrementalCompilation=false",
          // NOTE(olafur) the square/javapoet repo sets compilerId to 'javac-with-javac', which appears to
          // override the '-Dmaven.compiler.executable' setting.. Forcing the compilerId to 'javac' fixes the
          // issue for this repo.
          s"-Dmaven.compiler.compilerId=javac",
          s"-Dmaven.compiler.executable=$executable",
          s"-Dmaven.compiler.fork=true"
        )
      buildCommand ++=
        index.finalBuildCommand(
          List(
            s"--batch-mode",
            s"clean",
            // Default to the "verify" command, as recommended by the official docs
            // https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#usual-command-line-calls
            "verify",
            "-DskipTests"
          )
        )

      val exit = index.process(buildCommand)
      Embedded
        .reportUnexpectedJavacErrors(index.app.reporter, tmp)
        .getOrElse(exit)
    }
  }
}
