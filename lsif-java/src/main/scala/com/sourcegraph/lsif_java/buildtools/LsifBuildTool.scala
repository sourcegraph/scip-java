package com.sourcegraph.lsif_java.buildtools

import java.io.File
import java.io.IOException
import java.nio.file.FileSystems
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes

import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._
import scala.util.control.NonFatal

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.lsif_java.Dependencies
import com.sourcegraph.lsif_java.Embedded
import com.sourcegraph.lsif_java.commands.IndexCommand
import moped.json.DecodingContext
import moped.json.ErrorResult
import moped.json.JsonCodec
import moped.json.JsonElement
import moped.json.JsonString
import moped.json.Result
import moped.json.ValueResult
import moped.macros.ClassShape
import moped.parsers.JsonParser
import moped.reporters.Diagnostic
import moped.reporters.Input
import os.CommandResult
import os.ProcessOutput.Readlines

/**
 * A custom build tool that is specifically made for lsif-java.
 *
 * The purpose of this build tool is to LSIF index the source code inside
 * `*-sources.jar` files of Maven dependencies. Builds are written in a JSON
 * file with the following format:
 *
 * {{{
 *   {
 *     "dependencies": ["junit:junit:4.13.1"],
 *     "jvm": "8"
 *   }
 * }}}
 */
class LsifBuildTool(index: IndexCommand) extends BuildTool("LSIF", index) {

  protected def defaultTargetroot: Path = Paths.get("target")
  private def configFile = index.workingDirectory.resolve("lsif-java.json")
  def usedInCurrentDirectory(): Boolean = Files.isRegularFile(configFile)
  override def indexJdk(): Boolean = parsedConfig.getOrElse(Config()).indexJdk
  override def isHidden: Boolean = true
  def generateSemanticdb(): CommandResult = {
    parsedConfig match {
      case ValueResult(value) =>
        clean()
        try {
          compile(value)
        } catch {
          case NonFatal(e) =>
            e.printStackTrace(index.app.out)
            CommandResult(1, Nil)
        }
      case ErrorResult(error) =>
        error
          .all
          .foreach { d =>
            index.app.error(d.message)
          }
        CommandResult(1, Nil)
    }
  }

  /** Parses the lsif-java.json file into a Config object. */
  private def parsedConfig: Result[Config] = {
    val input = Input.path(configFile)
    JsonParser
      .parse(input)
      .flatMap(json =>
        Config.codec.decode(DecodingContext(json).withFatalUnknownFields(true))
      )
  }

  /**
   * Resolves dependencies and shells out to "javac" to compile the sources with
   * the SemanticDB compiler plugin enabled.
   */
  private def compile(config: Config): CommandResult = {
    val tmp = Files.createTempDirectory("lsif-java")
    Files.createDirectories(tmp)
    Files.createDirectories(targetroot)
    val deps = Dependencies.resolveDependencies(config.dependencies.map(_.repr))
    val semanticdbJar = Embedded.semanticdbJar(tmp)
    val coursier = Embedded.coursier(tmp)
    val actualClasspath = deps.classpath :+ semanticdbJar
    val argsfile = targetroot.resolve("javacopts.txt")
    val sourceroot = index.workingDirectory
    if (!Files.isDirectory(sourceroot)) {
      throw new NoSuchFileException(sourceroot.toString())
    }
    val allJavaFiles = collectAllJavaFiles(sourceroot)
    val javaFiles = allJavaFiles
      .filterNot(_.endsWith(moduleInfo))
      .map(_.toString())
    val moduleInfos = allJavaFiles.filter(_.endsWith(moduleInfo))
    if (javaFiles.isEmpty) {
      index
        .app
        .warning(
          s"doing nothing, no files matching pattern '$sourceroot/**.java'"
        )
      return CommandResult(0, Nil)
    }
    def generatedDir(name: String): String = {
      Files.createDirectory(tmp.resolve(name)).toString()
    }
    val arguments = ListBuffer.empty[String]
    arguments += "-encoding"
    arguments += "utf8"
    arguments += "-nowarn"
    arguments += "-d"
    arguments += generatedDir("d")
    arguments += "-s"
    arguments += generatedDir("s")
    arguments += "-h"
    arguments += generatedDir("h")
    arguments += "-classpath"
    arguments += actualClasspath.mkString(File.pathSeparator)
    arguments +=
      s"-Xplugin:semanticdb -targetroot:$targetroot -sourceroot:$sourceroot"
    if (!config.indexJdk && moduleInfos.nonEmpty) {
      moduleInfos.foreach { module =>
        arguments += "--module"
        arguments += module.getParent.getFileName.toString
      }
      arguments += "--module-source-path"
      arguments += sourceroot.toString
    } else {
      arguments ++= javaFiles
    }
    val quotedArguments = arguments.map(a => "\"" + a + "\"")
    Files.write(argsfile, quotedArguments.asJava)
    if (javaFiles.size > 1) {
      index.app.reporter.info(f"Compiling ${javaFiles.size}%,.0f Java sources")
    }
    val pipe = Readlines(line => {
      index.app.reporter.info(line)
    })
    val javac = Paths.get(
      os.proc(coursier.toString, "java-home", "--jvm", config.jvm)
        .call()
        .out
        .trim(),
      "bin",
      "javac"
    )
    index.app.reporter.info(s"$$ $javac @$argsfile")
    val result = os
      .proc(javac.toString, s"@$argsfile")
      .call(
        stdout = pipe,
        stderr = pipe,
        cwd = os.Path(sourceroot),
        check = false
      )
    if (index.cleanup) {
      Files.walkFileTree(tmp, new DeleteVisitor)
    }
    val isSemanticdbGenerated = Files
      .isDirectory(targetroot.resolve("META-INF"))
    if (result.exitCode != 0 && !isSemanticdbGenerated) {
      result
    } else {
      if (isSemanticdbGenerated) {
        index
          .app
          .reporter
          .info(
            "Some SemanticDB files got generated even if there were compile errors. " +
              "In most cases, this means that lsif-java managed to index everything " +
              "except the locations that had compile errors and you can ignore the compile errors."
          )
      }
      CommandResult(0, Nil)
    }
  }

  private def clean(): Unit = {
    Files.walkFileTree(targetroot, new DeleteVisitor)
  }
  val moduleInfo = Paths.get("module-info.java")

  /** Recursively collects all Java files in the working directory */
  private def collectAllJavaFiles(dir: Path): List[Path] = {
    val javaPattern = FileSystems.getDefault.getPathMatcher("glob:**.java")
    val buf = ListBuffer.empty[Path]
    Files.walkFileTree(
      dir,
      new SimpleFileVisitor[Path] {
        override def preVisitDirectory(
            dir: Path,
            attrs: BasicFileAttributes
        ): FileVisitResult = {
          if (dir == targetroot)
            FileVisitResult.SKIP_SUBTREE
          else
            FileVisitResult.CONTINUE
        }
        override def visitFile(
            file: Path,
            attrs: BasicFileAttributes
        ): FileVisitResult = {
          if (javaPattern.matches(file)) {
            buf += file
          }
          FileVisitResult.CONTINUE
        }
        override def visitFileFailed(
            file: Path,
            exc: IOException
        ): FileVisitResult = FileVisitResult.CONTINUE
      }
    )
    buf.toList
  }

  /**
   * Gets parsed from "junit:junit:4.13.1" strings inside lsif-java.json files.
   */
  private case class Dependency(
      groupId: String = "",
      artifactId: String = "",
      version: String = ""
  ) {
    def repr: String = s"$groupId:$artifactId:$version"
  }
  private object Dependency {
    def unapply(syntax: String): Option[Dependency] =
      syntax match {
        case s"$groupId:$artifactId:$version" =>
          Some(
            Dependency(
              groupId = groupId,
              artifactId = artifactId,
              version = version
            )
          )
        case _ =>
          None
      }
    val automatic = moped.macros.deriveCodec(Dependency())
    implicit lazy val codec =
      new JsonCodec[Dependency] {
        def decode(context: DecodingContext): Result[Dependency] =
          context.json match {
            case JsonString(value) =>
              value match {
                case Dependency(x) =>
                  ValueResult(x)
                case other =>
                  ErrorResult(
                    Diagnostic.error(
                      s"expected format 'GROUP_ID:ARTIFACT_ID:VERSION', obtained $other"
                    )
                  )
              }
            case _ =>
              automatic.decode(context)
          }
        def encode(value: Dependency): JsonElement = automatic.encode(value)
        def shape: ClassShape = automatic.shape
      }
  }

  /** Gets parsed from lsif-java.json files. */
  private case class Config(
      dependencies: List[Dependency] = Nil,
      jvm: String = "8",
      indexJdk: Boolean = true
  )
  private object Config {
    implicit lazy val codec = moped.macros.deriveCodec(Config())
  }

}
