package com.sourcegraph.scip_java.buildtools

import java.io.File
import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.Paths

import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._
import scala.util.control.NonFatal

import com.sourcegraph.io.AbsolutePath
import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.BuildInfo
import com.sourcegraph.scip_java.Embedded
import com.sourcegraph.scip_java.buildtools.ScipBuildTool.Config
import com.sourcegraph.scip_java.commands.IndexCommand
import moped.json.DecodingContext
import moped.json.ErrorResult
import moped.json.Result
import moped.json.ValueResult
import moped.parsers.JsonParser
import moped.reporters.Diagnostic
import moped.reporters.Input
import os.CommandResult
import os.ProcessOutput.Readlines
import os.SubprocessException

/**
 * Internal worker dispatched by the Bazel aspect (`scip_java.bzl`).
 *
 * The aspect writes one JSON file per Java target and invokes
 * `scip-java index --scip-config <file>` against each one. That entry-point
 * is the only caller of this class; it is not part of the user-facing
 * build-tool surface.
 *
 * The expected JSON shape is:
 *
 * {{{
 *   {
 *     "javaHome": "/path/to/jdk",
 *     "classpath": [...],
 *     "sourceFiles": [...],
 *     "javacOptions": [...],
 *     "jvmOptions": [...],
 *     "processors": [...],
 *     "processorpath": [...],
 *     "bootclasspath": [...],
 *     "reportWarningOnEmptyIndex": false
 *   }
 * }}}
 */
class ScipBuildTool(index: IndexCommand) {

  private val targetroot: Path =
    index.finalTargetroot(Paths.get("target"))

  def run(): Int = {
    BuildTool.generateScipFromTargetroot(generateSemanticdb(), targetroot, index)
  }

  private def generateSemanticdb(): CommandResult =
    parsedConfig match {
      case ValueResult(config) =>
        try compileJavaFiles(config)
        catch {
          case NonFatal(e) =>
            e.printStackTrace(index.app.out)
            CommandResult(Nil, 1, Nil)
        }
      case ErrorResult(error) =>
        error.all.foreach(d => index.app.error(d.message))
        CommandResult(Nil, 1, Nil)
    }

  private def parsedConfig: Result[Config] =
    index.scipConfig.filter(Files.isRegularFile(_)) match {
      case None =>
        ErrorResult(
          Diagnostic.error(
            s"no --scip-config file found at '${index.scipConfig.map(_.toString).getOrElse("")}'"
          )
        )
      case Some(configFile) =>
        JsonParser
          .parse(Input.path(configFile))
          .flatMap(json =>
            Config
              .codec
              .decode(DecodingContext(json).withFatalUnknownFields(true))
          )
    }

  private def compileJavaFiles(config: Config): CommandResult = {
    val sourceroot = index.workingDirectory
    if (!Files.isDirectory(sourceroot)) {
      throw new NoSuchFileException(sourceroot.toString)
    }

    val javaHome = config.javaHome.getOrElse(
      throw new IllegalArgumentException(
        "missing required field `javaHome` in scip-config file"
      )
    )

    val javaFiles = config
      .sourceFiles
      .map(p => AbsolutePath.of(Paths.get(p), sourceroot))
      .filter(p => Files.isRegularFile(p) && p.toString.endsWith(".java"))

    if (javaFiles.isEmpty) {
      if (config.reportWarningOnEmptyIndex) {
        index.app.warning("doing nothing, no Java sources found")
      }
      return CommandResult(Nil, 0, Nil)
    }

    val tmp = Files.createTempDirectory("scip-java")
    try {
      Files.createDirectories(targetroot)
      val semanticdbJar = Embedded.semanticdbJar(tmp)

      val classpath =
        semanticdbJar.toString +:
          config.classpath.map(p => AbsolutePath.of(Paths.get(p), sourceroot).toString)

      val arguments = ListBuffer.empty[String]
      arguments += "-encoding"
      arguments += "utf8"
      arguments += "-nowarn"
      arguments += "-d"
      arguments += createDir(tmp, "d")
      arguments += "-s"
      arguments += createDir(tmp, "s")
      arguments += "-h"
      arguments += createDir(tmp, "h")
      arguments += "-classpath"
      arguments += classpath.mkString(File.pathSeparator)
      arguments += s"-Xplugin:semanticdb -targetroot:$targetroot -sourceroot:$sourceroot"

      if (config.processorpath.nonEmpty) {
        val resolved = semanticdbJar.toString ::
          config.processorpath.flatMap(guessBazelJar).map(_.toString)
        arguments += "-processorpath"
        arguments += resolved.mkString(File.pathSeparator)
      }

      val processors = config.processors.filterNot(ScipBuildTool.IgnoredAnnotationProcessors)
      if (processors.nonEmpty) {
        arguments += "-processor"
        arguments += processors.mkString(",")
      }

      arguments ++= fixJavacOptions(config.javacOptions)
      arguments ++= javaFiles.map(_.toString)

      val argsfile = targetroot.resolve("javacopts.txt")
      Files.write(argsfile, arguments.map(a => "\"" + a + "\"").asJava)

      if (javaFiles.size > 1) {
        index.app.reporter.info(f"Compiling ${javaFiles.size}%,.0f Java sources")
      }

      val javac = Paths.get(javaHome, "bin", "javac")
      index.app.reporter.info(s"$$ $javac @$argsfile")
      val pipe = Readlines(line => index.app.reporter.info(line))
      val result = os
        .proc(
          javac.toString,
          s"@$argsfile",
          BuildInfo.javacModuleOptions,
          config.jvmOptions.map("-J" + _)
        )
        .call(stdout = pipe, stderr = pipe, cwd = os.Path(sourceroot), check = false)

      val isSemanticdbGenerated = Files.isDirectory(targetroot.resolve("META-INF"))
      if (result.exitCode != 0 && !isSemanticdbGenerated) {
        index.app.reporter.log(Diagnostic.exception(SubprocessException(result)))
        CommandResult(Nil, 1, Nil)
      } else {
        if (result.exitCode != 0) {
          index
            .app
            .reporter
            .info(
              "Some SemanticDB files got generated even if there were compile errors. " +
                "In most cases, this means that scip-java managed to index everything " +
                "except the locations that had compile errors and you can ignore the compile errors."
            )
        }
        CommandResult(Nil, 0, Nil)
      }
    } finally {
      if (index.cleanup) {
        Files.walkFileTree(tmp, new DeleteVisitor)
      }
    }
  }

  /** Strips javac options that would break SemanticDB indexing. */
  private def fixJavacOptions(options: List[String]): List[String] =
    options match {
      case "--release" :: _ :: rest =>
        // --release is incompatible with explicit -source/-target, which
        // some Bazel targets configure simultaneously. Skip it because it
        // is not required for indexing.
        fixJavacOptions(rest)
      case option :: rest =>
        val isIgnored =
          option.startsWith("-Xep") || // ErrorProne, fails the build
            option.startsWith("-Xplugin:semanticdb") || // Redundant SemanticDB
            option.startsWith("-XD")
        if (isIgnored) fixJavacOptions(rest) else option :: fixJavacOptions(rest)
      case Nil =>
        Nil
    }

  // HACK(olafurpg): I haven't figured out a reliable way to get annotation processor jars
  // on the processorpath. The Bazel aspect sometimes says a NAME.jar file is on the
  // processorpath when it doesn't exist but processed_NAME.jar or header_NAME.jar exists.
  private def guessBazelJar(pathString: String): Option[Path] = {
    val workingDirectory = index.workingDirectory
    var path = AbsolutePath.of(Paths.get(pathString), workingDirectory)
    if (Files.isRegularFile(path)) return Some(path)

    if (!pathString.startsWith("bazel-bin") && !pathString.startsWith("bazel-out")) {
      path = AbsolutePath.of(Paths.get("bazel-bin", pathString), workingDirectory)
      if (Files.isRegularFile(path)) return Some(path)
    }

    val processed = path.resolveSibling("processed_" + path.getFileName.toString)
    if (Files.isRegularFile(processed)) return Some(processed)

    val header = path.resolveSibling("header_" + path.getFileName.toString)
    if (Files.isRegularFile(header)) return Some(header)

    index.app.warning("annotation processor jar does not exist: " + path)
    None
  }

  private def createDir(tmp: Path, name: String): String =
    Files.createDirectory(tmp.resolve(name)).toString
}

object ScipBuildTool {
  val IgnoredAnnotationProcessors: Set[String] = Set(
    "org.openjdk.jmh.generators.BenchmarkProcessor"
  )

  /** Gets parsed from --scip-config files written by the Bazel aspect. */
  private case class Config(
      reportWarningOnEmptyIndex: Boolean = true,
      javaHome: Option[String] = None,
      sourceFiles: List[String] = Nil,
      classpath: List[String] = Nil,
      bootclasspath: List[String] = Nil,
      processorpath: List[String] = Nil,
      processors: List[String] = Nil,
      javacOptions: List[String] = Nil,
      jvmOptions: List[String] = Nil
  )
  private object Config {
    implicit lazy val codec = moped.macros.deriveCodec(Config())
  }
}
