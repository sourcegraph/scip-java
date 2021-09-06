package com.sourcegraph.lsif_java.buildtools

import java.io.File
import java.io.IOException
import java.net.URLClassLoader
import java.nio.file.FileSystems
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.StandardOpenOption
import java.nio.file.attribute.BasicFileAttributes
import java.util
import java.util.Collections
import java.util.Optional
import java.util.ServiceLoader
import java.util.concurrent.TimeUnit

import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._
import scala.util.Failure
import scala.util.Success
import scala.util.Try
import scala.util.control.NonFatal

import scala.meta.pc.PresentationCompiler
import scala.meta.pc.PresentationCompilerConfig

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.lsif_java.BuildInfo
import com.sourcegraph.lsif_java.Dependencies
import com.sourcegraph.lsif_java.Embedded
import com.sourcegraph.lsif_java.commands.IndexCommand
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocument
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocuments
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
import os.SubprocessException

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

  private val javaPattern = FileSystems
    .getDefault
    .getPathMatcher("glob:**.java")
  private val scalaPattern = FileSystems
    .getDefault
    .getPathMatcher("glob:**.scala")
  private val allPatterns = FileSystems
    .getDefault
    .getPathMatcher("glob:**.{java,scala}")
  private val moduleInfo = Paths.get("module-info.java")

  override def usedInCurrentDirectory(): Boolean =
    Files.isRegularFile(configFile)
  override def isHidden: Boolean = true
  override def generateLsif(): Int = {
    BuildTool.generateLsifFromTargetroot(
      generateSemanticdb(),
      index.finalTargetroot(defaultTargetroot),
      index,
      buildKind
    )
  }

  private def targetroot: Path = index.finalTargetroot(defaultTargetroot)
  private def defaultTargetroot: Path = Paths.get("target")
  private def configFile =
    index.workingDirectory.resolve(LsifBuildTool.ConfigFileName)
  private def buildKind: String = parsedConfig.fold(_.kind, _ => "")
  private def generateSemanticdb(): CommandResult = {
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
    val sourceroot = index.workingDirectory
    if (!Files.isDirectory(sourceroot)) {
      throw new NoSuchFileException(sourceroot.toString)
    }
    val allSourceFiles = collectAllSourceFiles(sourceroot)
    val javaFiles = allSourceFiles.filter(path => javaPattern.matches(path))
    val scalaFiles = allSourceFiles.filter(path => scalaPattern.matches(path))
    if (javaFiles.isEmpty && scalaFiles.isEmpty) {
      index
        .app
        .warning(
          s"doing nothing, no files matching pattern '$sourceroot/**.{java,scala}'"
        )
      return CommandResult(0, Nil)
    }
    val errors = ListBuffer.empty[Try[Unit]]
    compileJavaFiles(tmp, deps, config, javaFiles)
      .recover(e => errors.addOne(Failure(e)))
    compileScalaFiles(deps, scalaFiles).recover(e => errors.addOne(Failure(e)))
    if (index.cleanup) {
      Files.walkFileTree(tmp, new DeleteVisitor)
    }
    val isSemanticdbGenerated = Files
      .isDirectory(targetroot.resolve("META-INF"))
    if (errors.nonEmpty && !isSemanticdbGenerated) {
      CommandResult(1, Nil)
    } else {
      if (errors.nonEmpty && isSemanticdbGenerated) {
        index
          .app
          .reporter
          .info(
            "Some SemanticDB files got generated even if there were compile errors. " +
              "In most cases, this means that lsif-java managed to index everything " +
              "except the locations that had compile errors and you can ignore the compile errors." +
              errors.mkString("\n")
          )
      }
      CommandResult(0, Nil)
    }
  }

  private def compileScalaFiles(
      deps: Dependencies,
      allScalaFiles: List[Path]
  ): Try[Unit] =
    Try {
      if (allScalaFiles.nonEmpty)
        withScalaPresentationCompiler(deps) { compiler =>
          allScalaFiles.foreach { path =>
            try compileScalaFile(compiler, path)
            catch {
              case NonFatal(e) =>
                // We want to try and index as much as possible so we don't fail the entire
                // compilation even if a single file fails to compile.
                index.app.reporter.log(Diagnostic.exception(e))
            }
          }
        }
    }

  private def compileScalaFile(
      compiler: PresentationCompiler,
      path: Path
  ): Unit = {
    val input = Input.path(path)
    val textDocument = TextDocument
      .parseFrom(compiler.semanticdbTextDocument(path.toUri, input.text).get())
      .toBuilder
      .setUri(sourceroot.relativize(path).iterator().asScala.mkString("/"))
    val textDocuments = TextDocuments
      .newBuilder()
      .addDocuments(textDocument)
      .build()
    val relpath = sourceroot
      .relativize(path)
      .resolveSibling(path.getFileName.toString + ".semanticdb")
    val out = targetroot
      .resolve("META-INF")
      .resolve("semanticdb")
      .resolve(relpath)
    Files.createDirectories(out.getParent)
    Files.write(
      out,
      textDocuments.toByteArray,
      StandardOpenOption.TRUNCATE_EXISTING,
      StandardOpenOption.CREATE
    )
  }

  private def withScalaPresentationCompiler[T](
      deps: Dependencies
  )(fn: PresentationCompiler => T): T = {
    val scalaVersion = deps
      .classpath
      .headOption
      .flatMap(jar => ScalaVersion.inferFromJar(jar))
      .getOrElse {
        throw new IllegalArgumentException(
          s"failed to infer the Scala version from the dependencies: " +
            pprint.PPrinter.BlackWhite.tokenize(deps.classpath).mkString
        )
      }
    val mtags = Dependencies.resolveDependencies(
      List(s"org.scalameta:mtags_${scalaVersion}:${BuildInfo.mtagsVersion}")
    )
    val scalaLibrary = mtags
      .classpath
      .filter(_.getFileName.toString.contains("scala-library"))
    val parent = new ScalaCompilerClassLoader(this.getClass.getClassLoader)

    val jars = mtags.classpath.map(_.toUri.toURL).toArray
    val classloader = new URLClassLoader(jars, parent)
    val compilers = ServiceLoader
      .load(classOf[PresentationCompiler], classloader)
      .iterator()
    if (compilers.hasNext) {
      val classpath = deps.classpath ++ scalaLibrary
      val argsfile = targetroot.resolve("javacopts.txt")
      Files.createDirectories(argsfile.getParent)
      Files.write(
        argsfile,
        List("-classpath", classpath.mkString(File.pathSeparator)).asJava,
        StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING
      )
      val compiler = compilers
        .next()
        .newInstance("lsif-java", classpath.asJava, List[String]().asJava)
        .withConfiguration(
          new PresentationCompilerConfig {
            override def parameterHintsCommand(): Optional[String] =
              Optional.empty()
            override def completionCommand(): Optional[String] =
              Optional.empty()
            override def symbolPrefixes(): util.Map[String, String] =
              Collections.emptyMap()
            override def isDefaultSymbolPrefixes: Boolean = false
            override def overrideDefFormat()
                : PresentationCompilerConfig.OverrideDefFormat =
              PresentationCompilerConfig.OverrideDefFormat.Ascii
            override def isCompletionItemDetailEnabled: Boolean = false
            override def isStripMarginOnTypeFormattingEnabled: Boolean = false
            override def isCompletionItemDocumentationEnabled: Boolean = false
            override def isHoverDocumentationEnabled: Boolean = false
            override def snippetAutoIndent(): Boolean = false
            override def isSignatureHelpDocumentationEnabled: Boolean = false
            override def isCompletionSnippetsEnabled: Boolean = false
            override def timeoutDelay(): Long = 0
            override def timeoutUnit(): TimeUnit = TimeUnit.SECONDS
            override def semanticdbCompilerOptions(): util.List[String] =
              Collections.emptyList()
          }
        )
      try {
        fn(compiler)
      } finally {
        compiler.shutdown()
      }
    } else {
      throw new IllegalArgumentException(
        s"failed to load mtags presentation compiler for Scala version $scalaVersion"
      )
    }
  }

  private def compileJavaFiles(
      tmp: Path,
      deps: Dependencies,
      config: Config,
      allJavaFiles: List[Path]
  ): Try[Unit] = {
    val (moduleInfos, javaFiles) = allJavaFiles
      .partition(_.endsWith(moduleInfo))
    if (javaFiles.isEmpty)
      return Success(())
    val semanticdbJar = Embedded.semanticdbJar(tmp)
    val coursier = Embedded.coursier(tmp)
    val actualClasspath = deps.classpath :+ semanticdbJar
    val argsfile = targetroot.resolve("javacopts.txt")
    val arguments = ListBuffer.empty[String]
    arguments += "-encoding"
    arguments += "utf8"
    arguments += "-nowarn"
    arguments += "-d"
    arguments += generatedDir(tmp, "d")
    arguments += "-s"
    arguments += generatedDir(tmp, "s")
    arguments += "-h"
    arguments += generatedDir(tmp, "h")
    arguments += "-classpath"
    arguments += actualClasspath.mkString(File.pathSeparator)
    arguments +=
      s"-Xplugin:semanticdb -targetroot:$targetroot -sourceroot:$sourceroot"
    if (config.kind == "jdk" && moduleInfos.nonEmpty) {
      moduleInfos.foreach { module =>
        arguments += "--module"
        arguments += module.getParent.getFileName.toString
      }
      arguments += "--module-source-path"
      arguments += sourceroot.toString
    } else {
      arguments ++= javaFiles.map(_.toString)
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
    if (result.exitCode == 0)
      Success(())
    else
      Failure(SubprocessException(result))
  }

  private def clean(): Unit = {
    Files.walkFileTree(targetroot, new DeleteVisitor)
  }

  /** Recursively collects all Java files in the working directory */
  private def collectAllSourceFiles(dir: Path): List[Path] = {
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
          if (allPatterns.matches(file)) {
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

  private def generatedDir(tmp: Path, name: String): String = {
    Files.createDirectory(tmp.resolve(name)).toString()
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
      kind: String = ""
  )
  private object Config {
    implicit lazy val codec = moped.macros.deriveCodec(Config())
  }

}

object LsifBuildTool {
  val ConfigFileName = "lsif-java.json"
}
