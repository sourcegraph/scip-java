package com.sourcegraph.scip_java

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

import com.sourcegraph.scip_java.BuildInfo
import moped.reporters.Reporter
import os.CommandResult

object Embedded {

  def scipJar(tmpDir: Path): Path = copyFile(tmpDir, "scip-plugin.jar")

  def gradlePluginJar(tmpDir: Path): Path = copyFile(
    tmpDir,
    "gradle-plugin.jar"
  )

  def scipKotlincJar(tmpDir: Path): Path = copyFile(tmpDir, "scip-kotlinc.jar")

  private def javacErrorpath(tmp: Path) = tmp.resolve("errorpath.txt")

  def customJavac(sourceroot: Path, targetroot: Path, tmp: Path): Path = {
    val bin = tmp.resolve("bin")
    val javac = bin.resolve("javac")
    val java = bin.resolve("java")
    val pluginpath = Embedded.scipJar(tmp)
    val errorpath = javacErrorpath(tmp)
    val javacopts = targetroot.resolve("javacopts.txt")
    Files.createDirectories(targetroot)
    Files.createDirectories(bin)
    Files.write(
      java,
      """#!/usr/bin/env bash
        |java "$@"
        |""".stripMargin.getBytes(StandardCharsets.UTF_8)
    )
    val newJavacopts = tmp.resolve("javac_newarguments")
    // --add-exports flags required to access internal javac APIs from our
    // SCIP plugin. Always set; Java 11+ is the supported baseline.
    val javacModuleOptions = BuildInfo.javacModuleOptions.mkString(" ")
    val injectScipArguments = List[String](
      "java",
      s"-Dscip.errorpath=$errorpath",
      s"-Dscip.pluginpath=$pluginpath",
      s"-Dscip.sourceroot=$sourceroot",
      s"-Dscip.targetroot=$targetroot",
      s"-Dscip.output=$$NEW_JAVAC_OPTS",
      s"-Dscip.old-output=$javacopts",
      s"-classpath $pluginpath",
      "com.sourcegraph.scip_javac.InjectScipOptions",
      """"$@""""
    ).mkString(" ")
    val script =
      s"""#!/usr/bin/env bash
         |set -eu
         |LAUNCHER_ARGS=()
         |NEW_JAVAC_OPTS="$newJavacopts-$$RANDOM"
         |for arg in "$$@"; do
         |  if [[ $$arg == -J* ]]; then
         |    LAUNCHER_ARGS+=("$$arg")
         |  fi
         |done
         |$injectScipArguments
         |if [ $${#LAUNCHER_ARGS[@]} -eq 0 ]; then
         |  javac $javacModuleOptions "@$$NEW_JAVAC_OPTS"
         |else
         |  javac $javacModuleOptions "@$$NEW_JAVAC_OPTS" "$${LAUNCHER_ARGS[@]}"
         |fi
         |""".stripMargin
    Files.write(javac, script.getBytes(StandardCharsets.UTF_8))
    javac.toFile.setExecutable(true)
    java.toFile.setExecutable(true)
    javac
  }

  /**
   * The custom javac wrapper reports errors to a specific file if unexpected
   * errors happen. The javac wrapper gets invoked by builds tools like
   * Gradle/Maven, which hide the actual errors from the script because they
   * assume the standard output is from javac. This file is used a side-channel
   * to avoid relying on the error reporting from Gradle/Maven.
   */
  def reportUnexpectedJavacErrors(
      reporter: Reporter,
      tmp: Path
  ): Option[CommandResult] = {
    val errorpath = javacErrorpath(tmp)
    if (Files.isRegularFile(errorpath)) {
      reporter.error("unexpected javac compile errors")
      Files
        .readAllLines(errorpath)
        .forEach { line =>
          reporter.error(line)
        }
      Some(CommandResult(Nil, 1, Nil))
    } else {
      None
    }
  }

  /**
   * Returns the string contents of the scip_java.bzl file on disk.
   */
  def bazelAspectFile(tmpDir: Path): String = {
    // We could in theory load the resource straight into a string but it was
    // easier to copy it to a file and read it from there.
    val tmpFile = copyFile(tmpDir, "scip-java/scip_java.bzl")
    val contents =
      new String(Files.readAllBytes(tmpFile), StandardCharsets.UTF_8)
    Files.deleteIfExists(tmpFile)
    contents
  }

  private def copyFile(tmpDir: Path, filename: String): Path = {
    val in = this.getClass.getResourceAsStream(s"/$filename")
    val out = tmpDir.resolve(filename)
    Files.createDirectories(out.getParent())
    try Files.copy(in, out, StandardCopyOption.REPLACE_EXISTING)
    finally in.close()
    out
  }
}
