package com.sourcegraph.scip_java.buildtools

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

import scala.collection.mutable.ListBuffer

import com.sourcegraph.scip_java.Embedded
import com.sourcegraph.scip_java.commands.IndexCommand

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
    val javac = Embedded.customJavac(
      index.workingDirectory,
      targetroot,
      tmp,
      GradleJavaToolchains.isJavaAtLeast(languageVersion, "17")
    )
    val agent = Embedded.agentJar(tmp)
    val debugPath = GradleJavaCompiler.debugPath(tmp)
    val javacopts = targetroot.resolve("javacopts.txt")
    Files.createDirectories(javacopts.getParent)

    createBinaries(
      dir = home,
      javac = javac,
      agent = agent,
      index = index,
      javacopts = javacopts,
      targetroot = targetroot,
      pluginPath = pluginPath,
      debugPath = debugPath
    )
    createBinaries(
      dir = home.resolve("Contents").resolve("Home"),
      javac = javac,
      agent = agent,
      index = index,
      javacopts = javacopts,
      targetroot = targetroot,
      pluginPath = pluginPath,
      debugPath = debugPath
    ) // for macOS
    home
  }

  private def createBinaries(
      dir: Path,
      javac: Path,
      agent: Path,
      index: IndexCommand,
      javacopts: Path,
      targetroot: Path,
      pluginPath: Path,
      debugPath: Path
  ): Unit = {
    Files.createDirectories(dir.resolve("bin"))
    val javaBinary = javacPath.resolveSibling("java")
    val javaCommand = ListBuffer[String](
      javaBinary.toString,
      s"-javaagent:$agent",
      s"-Dsemanticdb.javacopts=$javacopts",
      s"-Dsemanticdb.pluginpath=$pluginPath",
      s"-Dsemanticdb.targetroot=$targetroot",
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

    val copyFiles =
      (source: Path, destination: Path) => {
        Files
          .walk(source)
          .forEach(t => {
            val destPath = destination.resolve(source.relativize(t))
            try {
              Files.copy(t, destPath)
            } catch {
              case _: NoSuchFileException =>
                return
            }
          })
      }

    // For compile{Test}Kotlin when using jvm toolchains, we need to have access
    // to JDK internals found in <java-installation-path>/lib in JDK 9+,
    // as well as <java-installation-path>/jre/lib in JDK <=8, else we get
    // "no class roots are found in the JDK path" from the compile{Test}Kotlin tasks.
    // https://docs.oracle.com/en/java/javase/12/migrate/index.html#JSMIG-GUID-A78CC891-701D-4549-AA4E-B8DD90228B4B
    val javaHome = javacPath.getParent.getParent
    val libPath = dir.resolve("lib")
    val javacLibPath = javaHome.resolve("lib")
    copyFiles(javacLibPath, libPath)

    if (languageVersion == "8") {
      val jreLibPath = dir.resolve("jre").resolve("lib")
      Files.createDirectories(jreLibPath.getParent)
      val javacJreLibPath = javaHome.resolve("jre").resolve("lib")

      copyFiles(javacJreLibPath, jreLibPath)
    }
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
   * Example input: "8 /javacLibPath/javac"
   *
   * Example output: `Some(GradleJavaCompiler("8", * /javacLibPath/javac))`
   */
  def fromLine(line: String): Option[GradleJavaCompiler] =
    line.split(' ') match {
      case Array(version, path) =>
        Some(GradleJavaCompiler(version, Paths.get(path)))
      case _ =>
        None
    }

}
