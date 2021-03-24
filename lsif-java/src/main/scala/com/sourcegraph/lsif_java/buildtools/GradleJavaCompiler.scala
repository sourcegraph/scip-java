package com.sourcegraph.lsif_java.buildtools

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

import scala.collection.mutable.ListBuffer

import com.sourcegraph.lsif_java.Embedded
import com.sourcegraph.lsif_java.commands.IndexCommand

/**
 * Metadata about the Java compiler that is used by a Gradle build.
 *
 * @see
 *   https://docs.gradle.org/current/javadoc/org/gradle/jvm/toolchain/JavaCompiler.html
 */
case class GradleJavaCompiler(languageVersion: String, javacPath: Path) {

  def createForwardingToolchain(
      index: IndexCommand,
      tmp: Path,
      targetroot: Path,
      pluginPath: Path
  ): Path = {
    val home = tmp.resolve(s"1.$languageVersion")
    val javac = Embedded.customJavac(index.workingDirectory, targetroot, tmp)
    val agent = Embedded.agentJar(tmp)
    val debugPath = GradleJavaCompiler.debugPath(tmp)

    createBinaries(home, javac, agent, index, targetroot, pluginPath, debugPath)
    createBinaries(
      home.resolve("Contents").resolve("Home"),
      javac,
      agent,
      index,
      targetroot,
      pluginPath,
      debugPath
    ) // for macOS
    home
  }

  private def createBinaries(
      dir: Path,
      javac: Path,
      agent: Path,
      index: IndexCommand,
      targetroot: Path,
      pluginPath: Path,
      debugPath: Path
  ): Unit = {
    Files.createDirectories(dir.resolve("bin"))
    val javaBinary = javacPath.resolveSibling("java")
    val javaCommand = ListBuffer[String](
      javaBinary.toString,
      s"-javaagent:$agent",
      s"-Dsemanticdb.pluginpath=${pluginPath}",
      s"-Dsemanticdb.targetroot=${targetroot}",
      s"-Dsemanticdb.sourceroot=${index.workingDirectory}"
    )
    if (index.verbose) {
      javaCommand += s"-Dsemanticdb.debugpath=${debugPath}"
    }
    javaCommand += """"$@""""
    Files
      .write(
        dir.resolve("bin").resolve("java"),
        s"""#!/usr/bin/env bash
           |set -eu
           |echo $$@ >> ${dir.resolve("java_arguments")}
           |${javaCommand.mkString(" ")}
           |""".stripMargin.getBytes(StandardCharsets.UTF_8)
      )
      .toFile
      .setExecutable(true)
    Files
      .copy(
        javac,
        dir.resolve("bin").resolve("javac"),
        StandardCopyOption.REPLACE_EXISTING
      )
      .toFile
      .setExecutable(true)
  }
}
object GradleJavaCompiler {

  /**
   * Path to a file that is used to log debugging information from the
   * SemanticDB Java Agent.
   */
  def debugPath(tmp: Path): Path = tmp.resolve("debugpath.txt")

  /**
   * Parses a single space-separated line into a GradleJavaCompiler instance.
   *
   * Example input: "8 /path/javac"
   *
   * Example output: `Some(GradleJavaCompiler("8", * /path/javac))`
   */
  def fromLine(line: String): Option[GradleJavaCompiler] =
    line.split(' ') match {
      case Array(version, path) =>
        Some(GradleJavaCompiler(version, Paths.get(path)))
      case _ =>
        None
    }

}
