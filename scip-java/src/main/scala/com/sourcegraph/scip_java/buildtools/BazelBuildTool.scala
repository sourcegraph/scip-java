package com.sourcegraph.scip_java.buildtools

import java.nio.charset.StandardCharsets
import java.nio.file.FileSystems
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.StandardOpenOption
import java.nio.file.attribute.BasicFileAttributes

import scala.collection.mutable.ListBuffer

import com.sourcegraph.io.AbsolutePath
import com.sourcegraph.scip_java.Embedded
import com.sourcegraph.scip_java.commands.IndexCommand
import moped.cli.Application
import os.ProcessOutput.Readlines

class BazelBuildTool(index: IndexCommand) extends BuildTool("Bazel", index) {

  override def isHidden: Boolean = true

  override def usedInCurrentDirectory(): Boolean = {
    Files.isRegularFile(index.workingDirectory.resolve("WORKSPACE"))
  }

  private def targetSpecs =
    if (index.buildCommand.isEmpty)
      List("//...")
    else
      index.buildCommand

  override def generateScip(): Int = {
    val aspectLabel = this.generateAspectFile().getOrElse("")
    if (aspectLabel.isEmpty) {
      return 1
    }

    val scipJavaBinary = index.bazelScipJavaBinary.getOrElse("")
    if (scipJavaBinary.isEmpty) {
      index
        .app
        .error(
          "the flag --bazel-scip-java-binary is required to index Bazel codebases. To fix this problem, run scip-java index again with the flag --scip-java-binary=/path/to/scip-java"
        )
      return 1
    }

    val javaHome = index.app.env.environmentVariables.getOrElse("JAVA_HOME", "")
    if (javaHome.isEmpty) {
      index
        .app
        .error(
          "environment variable JAVA_HOME is not set. " +
            "To fix this problem run `export JAVA_HOME=/path/to/java` and run scip-java index again."
        )
      return 1
    }

    val buildCommand =
      List(
        "bazel",
        "build",
        "--noshow_progress",
        // The local strategy is required for now because we write SemanticDB and SCIP files
        // to the provided targetroot directory.
        "--spawn_strategy=local",
        "--aspects",
        s"$aspectLabel%scip_java_aspect",
        "--output_groups=scip",
        s"--define=sourceroot=${index.workingDirectory}",
        s"--define=java_home=$javaHome",
        s"--define=scip_java_binary=$scipJavaBinary"
      ) ++ targetSpecs

    val buildExitCode = runBazelBuild(buildCommand)
    if (buildExitCode != 0) {
      buildExitCode
    } else {
      aggregateScipFiles()
      0
    }
  }

  private def runBazelBuild(buildCommand: List[String]): Int = {
    val sandbox = new SandboxCommandExtractor(index.app)
    index.app.info(buildCommand.mkString(" "))
    val commandResult = index
      .app
      .process(buildCommand)
      .call(check = false, stderr = Readlines(sandbox))
    if (commandResult.exitCode != 0) {
      if (index.bazelAutorunSandboxCommand && sandbox.commandLines().nonEmpty) {
        index
          .app
          .info(
            "Automatically re-running sandbox command to help debug the problem."
          )
        index
          .app
          .process("bash", "-c", sandbox.commandLines().mkString("\n"))
          .call(check = false, stdout = os.Inherit, stderr = os.Inherit)
      }
      index
        .app
        .error(
          s"""To reproduce the failed Bazel command without scip-java, run the following command:
             |
             |  bazel build ${targetSpecs.mkString(" ")}
             |
             |To narrow the set of targets to index or pass additional flags to Bazel, include extra arguments index after -- like below:
             |
             |  scip-java index --bazel-scip-java-binary=... -- //custom/target --sandbox_debug
             |""".stripMargin
        )
      commandResult.exitCode
    } else {
      0
    }
  }

  private def aggregateScipFiles(): Unit = {
    // Final step after running the aspect: aggregate all the generated `*.scip` files into a single index.scip file.
    // We have to do this step outside of Bazel because Bazel does not allow actions to generate outputs outside
    // of the bazel-out directory. Ideally, we should be able to implement the aggregation step inside Bazel
    // and only copy the resulting index.scip file into the root of the workspace. However, to begin with, we
    // walk the bazel-bin/ directory to concatenate the `*.scip` files even if this is not the idiomatic way to
    // do it (in general, scanning the bazel-bin/ directory is a big no no).
    Files.deleteIfExists(index.finalOutput)
    Files.createDirectories(index.finalOutput.getParent)
    val scipPattern = FileSystems.getDefault.getPathMatcher("glob:**.scip")
    val bazelOut = index.workingDirectory.resolve("bazel-out")
    if (!Files.exists(bazelOut)) {
      index
        .app
        .error(
          s"doing nothing, the directory $bazelOut does not exist. " +
            s"The most likely cause for this problem is that there are no Java targets in this Bazel workspace. " +
            s"Please report an issue to the scip-java issue tracker if the command `bazel query 'kind(java_*, //...)'` returns non-empty output."
        )
    } else {
      val bazelOutLink = Files.readSymbolicLink(bazelOut)
      Files.walkFileTree(
        bazelOutLink,
        new SimpleFileVisitor[Path] {
          override def visitFile(
              file: Path,
              attrs: BasicFileAttributes
          ): FileVisitResult = {
            if (scipPattern.matches(file)) {
              val bytes = Files.readAllBytes(file)
              Files.write(
                index.finalOutput,
                bytes,
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE
              )
            }
            super.visitFile(file, attrs)
          }
        }
      )
    }
  }

  /**
   * Callback to `os.ProcessOutput.Readlines` that processes the stderr output
   * of a running Bazel process and extract the sandbox command. When the
   * --sandbox_debug flag is enabled, Bazel prints out the sandbox command that
   * failed but it doesn't show the stdout/stderr of that command. This
   * extractor captures the command so that we can automatically re-run the
   * command to print out the stdout/stderr.
   */
  private class SandboxCommandExtractor(app: Application)
      extends (String => Unit) {
    private var isSandboxCommandPrinting = false
    private val lines = ListBuffer.empty[String]
    def commandLines(): List[String] = lines.toList
    override def apply(line: String): Unit = {
      if (
        !isSandboxCommandPrinting && line.startsWith("ERROR:") &&
        line.contains("error executing command")
      ) {
        isSandboxCommandPrinting = true
      } else if (isSandboxCommandPrinting && !line.startsWith("  ")) {
        isSandboxCommandPrinting = false
      } else if (isSandboxCommandPrinting) {
        lines += line
      }
      app.env.standardError.println(line)
    }
  }

  /**
   * Reads the scip_java.bzl file from resources and writes it to the
   * aspect/scip_java.bzl file inside the Bazel workspace.
   */
  private def generateAspectFile(): Option[String] = {
    val aspectPath = AbsolutePath.of(index.bazelAspect, index.workingDirectory)
    val aspectContents =
      TemporaryFiles.withDirectory(index) { tmp =>
        Embedded.bazelAspectFile(tmp)
      }
    if (index.bazelOverwriteAspectFile || !Files.exists(aspectPath)) {
      Files.deleteIfExists(aspectPath)
      Files.createDirectories(aspectPath.getParent)
      Files.write(aspectPath, aspectContents.getBytes(StandardCharsets.UTF_8))
    } else if (Files.isRegularFile(aspectPath)) {
      val existingContents = new String(Files.readAllBytes(aspectPath))
      if (existingContents != aspectContents) {
        index
          .app
          .reporter
          .error(
            s"Outdated Bazel aspect file found at $aspectPath. To fix this problem, either run again with the flag --bazel-overwrite-aspect-file or update the contents of the file to the following:\n\n$aspectContents\n\n"
          )
        return None
      }
    } else if (Files.exists(aspectPath)) {
      index
        .app
        .reporter
        .error(
          s"path $aspectPath already exists and is not a file. To fix this problem, remove this path and try again."
        )
      return None
    }

    Some(aspectLabel(aspectPath))
  }

  /**
   * Returns the target name (aka. "label") to reference the given path.
   */
  private def aspectLabel(aspectPath: Path): String = {
    var parent = aspectPath.getParent
    while (parent.startsWith(index.workingDirectory)) {
      if (Files.isRegularFile(parent.resolve("BUILD"))) {
        val path = index.workingDirectory.relativize(parent)
        val name = parent.relativize(aspectPath)
        return s"//$path:$name"
      }
      parent = parent.getParent
    }
    Files.createFile(aspectPath.resolveSibling("BUILD"))
    index.workingDirectory.relativize(aspectPath).toString
  }
}
