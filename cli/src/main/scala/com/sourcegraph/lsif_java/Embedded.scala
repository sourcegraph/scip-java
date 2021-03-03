package com.sourcegraph.lsif_java
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

object Embedded {

  def semanticdbJar(tmpDir: Path): Path =
    copyFile(tmpDir, "semanticdb-plugin.jar")

  def agentJar(tmpDir: Path): Path = copyFile(tmpDir, "semanticdb-agent.jar")

  def customJavac(sourceroot: Path, targetroot: Path, tmp: Path): Path = {
    val javac = tmp.resolve("javac")
    val pluginpath = Embedded.semanticdbJar(tmp)
    val oldArguments = tmp.resolve("javac_oldarguments")
    val newArguments = tmp.resolve("javac_newarguments")
    val launcherArgs = tmp.resolve("javac_launcherarguments")
    val injectSemanticdbArguments = List[String](
      "java",
      s"-Dsemanticdb.pluginpath=$pluginpath",
      s"-Dsemanticdb.sourceroot=$sourceroot",
      s"-Dsemanticdb.targetroot=$targetroot",
      s"-Dsemanticdb.output=$newArguments",
      s"-Dsemanticdb.old-output=$oldArguments",
      s"-classpath $pluginpath",
      "com.sourcegraph.semanticdb_javac.InjectSemanticdbOptions",
      """"$@""""
    ).mkString(" ")
    val script =
      s"""#!/usr/bin/env bash
         |set -eu
         |LAUNCHER_ARGS=()
         |echo $$@ >> $launcherArgs
         |for arg in "$$@"; do
         |  if [[ $$arg == -J* ]]; then
         |    LAUNCHER_ARGS+=("$$arg")
         |  fi
         |done
         |$injectSemanticdbArguments
         |if [ $${#LAUNCHER_ARGS[@]} -eq 0 ]; then
         |  javac "@$newArguments"
         |else
         |  javac "@$newArguments" "$${LAUNCHER_ARGS[@]}"
         |fi
         |""".stripMargin
    Files.write(javac, script.getBytes(StandardCharsets.UTF_8))
    javac.toFile.setExecutable(true)
    javac
  }

  private def copyFile(tmpDir: Path, filename: String): Path = {
    val in = this.getClass.getResourceAsStream(s"/$filename")
    val out = tmpDir.resolve(filename)
    try Files.copy(in, out, StandardCopyOption.REPLACE_EXISTING)
    finally in.close()
    out
  }
}
