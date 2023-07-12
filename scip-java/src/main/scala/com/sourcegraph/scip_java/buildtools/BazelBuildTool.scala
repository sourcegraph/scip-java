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

  override def generateScip(): Int = {
    this.generateAspectFile() match {
      case None =>
        1
      case Some(aspectLabel) =>
        val buildCommand = ListBuffer.empty[String]
        buildCommand += "bazel"
        buildCommand += "build"
        buildCommand += "--noshow_progress"
        buildCommand += "--sandbox_debug"

        val targetSpecs = ListBuffer.empty[String]
        if (index.buildCommand.isEmpty) {
          targetSpecs += "//..."
        } else {
          targetSpecs ++= index.buildCommand
        }
        buildCommand ++= targetSpecs

        buildCommand += "--aspects"
        buildCommand += s"$aspectLabel%scip_java_aspect"
        buildCommand += "--output_groups=scip"
        buildCommand += s"--define=sourceroot=${index.workingDirectory}"

        val javaHome = index
          .app
          .env
          .environmentVariables
          .getOrElse("JAVA_HOME", "")
        if (javaHome.isEmpty) {
          index
            .app
            .error(
              "environment variable JAVA_HOME is not set. " +
                "To fix this problem run `export JAVA_HOME=/path/to/java` and run scip-java index again."
            )
          return 1
        }
        buildCommand += s"--define=java_home=$javaHome"

        val scipJavaBinary = index.bazelScipJavaBinary.getOrElse("")
        if (scipJavaBinary.isEmpty) {
          index
            .app
            .error(
              "the flag --bazel-scip-java-binary is required to index Bazel codebases. To fix this problem, run scip-java index again with the flag --scip-java-binary=/path/to/scip-java"
            )
          return 1
        }
        buildCommand += s"--define=scip_java_binary=$scipJavaBinary"

        val sandbox = new SandboxCommandExtractor(index.app)
        index.app.info(buildCommand.mkString(" "))
        val commandResult = index
          .app
          .process(buildCommand.toList)
          .call(check = false, stderr = Readlines(sandbox))
        if (commandResult.exitCode != 0) {
          // Automatically run the sandbox command to help the user debug the problem.
          index
            .app
            .process("bash", "-c", sandbox.commandLines().mkString("\n"))
            .call(check = false, stdout = os.Inherit, stderr = os.Inherit)
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
          return commandResult.exitCode
        }
        // Final step after running the aspect: aggregate all the generated `*.scip` files into a single index.scip file.
        // We have to do this step outside of Bazel because Bazel does not allow actions to generate outputs outside
        // of the bazel-out directory. Ideally, we should be able to implement the aggregation step inside Bazel
        // and only copy the resulting index.scip file into the root of the workspace. However, to begin with, we
        // walk the bazel-bin/ directory to concatenate the `*.scip` files even if this is not the idiomatic way to
        // do it (in general, scanning the bazel-bin/ directory is a big no no).
        Files.deleteIfExists(index.finalOutput)
        Files.createDirectories(index.finalOutput.getParent)
        val scipPattern = FileSystems.getDefault.getPathMatcher("glob:**.scip")
        val binDirectory = Files
          .readSymbolicLink(index.workingDirectory.resolve("bazel-bin"))
        Files.walkFileTree(
          binDirectory,
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
        0
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
    def command(): List[String] = List("bash", "-c", lines.mkString("\n"))
    override def apply(line: String): Unit = {
      if (
        !isSandboxCommandPrinting && line.startsWith("ERROR:") &&
        line.endsWith("error executing command ")
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
          "path $aspectPath already exists and is not a file. To fix this problem, remove this path and try again."
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
