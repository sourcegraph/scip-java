package com.sourcegraph.scip_java.buildtools

import java.io.File
import java.io.FileOutputStream
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
import java.util.jar.JarFile

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer
import scala.concurrent.Await
import scala.concurrent.ExecutionContext
import scala.concurrent.duration.Duration
import scala.jdk.CollectionConverters._
import scala.language.postfixOps
import scala.util.Failure
import scala.util.Success
import scala.util.Try
import scala.util.control.NonFatal

import scala.meta.pc.PresentationCompiler
import scala.meta.pc.PresentationCompilerConfig

import com.sourcegraph.io.AbsolutePath
import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.BuildInfo
import com.sourcegraph.scip_java.Dependencies
import com.sourcegraph.scip_java.Embedded
import com.sourcegraph.scip_java.commands.IndexCommand
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocument
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocuments
import coursier.jvm.JvmIndex
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
import org.jetbrains.kotlin.cli.common.arguments.K2JVMCompilerArguments
import org.jetbrains.kotlin.cli.common.arguments.ParseCommandLineArgumentsKt.parseCommandLineArguments
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSourceLocation
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.cli.common.messages.MessageRenderer
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import org.jetbrains.kotlin.config.Services
import os.CommandResult
import os.ProcessOutput.Readlines
import os.SubprocessException

/**
 * A custom build tool that is specifically made for scip-java.
 *
 * The purpose of this build tool is to SCIP index the source code inside
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
class ScipBuildTool(index: IndexCommand) extends BuildTool("SCIP", index) {

  private val javaPattern = FileSystems
    .getDefault
    .getPathMatcher("glob:**.java")
  private val scalaPattern = FileSystems
    .getDefault
    .getPathMatcher("glob:**.scala")
  private val kotlinPattern = FileSystems
    .getDefault
    .getPathMatcher("glob:**.kt")
  private val allPatterns = FileSystems
    .getDefault
    .getPathMatcher("glob:**.{java,scala,kt}")
  private val moduleInfo = Paths.get("module-info.java")

  override def usedInCurrentDirectory(): Boolean =
    configFiles.exists(path => Files.isRegularFile(path))
  override def isHidden: Boolean = true
  override def generateScip(): Int = {
    BuildTool.generateScipFromTargetroot(
      generateSemanticdb(),
      index.finalTargetroot(defaultTargetroot),
      index,
      buildKind
    )
  }

  private def targetroot: Path = index.finalTargetroot(defaultTargetroot)
  private def defaultTargetroot: Path = Paths.get("target")
  private def configFiles =
    index.scipConfig.toList ++
      ScipBuildTool
        .ConfigFileNames
        .map(name => index.workingDirectory.resolve(name))
  private def buildKind: String = parsedConfig.fold(_.kind, _ => "")
  private def generateSemanticdb(): CommandResult = {
    parsedConfig match {
      case ValueResult(value) =>
        if (index.cleanup) {
          clean()
        }
        try {
          compile(value)
        } catch {
          case NonFatal(e) =>
            e.printStackTrace(index.app.out)
            CommandResult(Nil, 1, Nil)
        }
      case ErrorResult(error) =>
        error
          .all
          .foreach { d =>
            index.app.error(d.message)
          }
        CommandResult(Nil, 1, Nil)
    }
  }

  /** Parses the lsif-java.json file into a Config object. */
  private def parsedConfig: Result[Config] = {
    configFiles.find(path => Files.isRegularFile(path)) match {
      case None =>
        ErrorResult(
          Diagnostic.error(
            s"no config file found. To fix this problem, create a config file in the path '${configFiles.head}'"
          )
        )
      case Some(configFile) =>
        val input = Input.path(configFile)
        JsonParser
          .parse(input)
          .flatMap(json =>
            Config
              .codec
              .decode(DecodingContext(json).withFatalUnknownFields(true))
          )
    }
  }

  /**
   * Resolves dependencies and shells out to "javac" to compile the sources with
   * the SemanticDB compiler plugin enabled.
   */
  private def compile(config: Config): CommandResult = {
    val tmp = Files.createTempDirectory("scip-java")
    Files.createDirectories(tmp)
    Files.createDirectories(targetroot)
    val deps = Dependencies.resolveDependencies(config.dependencies.map(_.repr))
    val sourceroot = index.workingDirectory
    if (!Files.isDirectory(sourceroot)) {
      throw new NoSuchFileException(sourceroot.toString)
    }
    val allSourceFiles = collectAllSourceFiles(config, sourceroot)
    val javaFiles = allSourceFiles.filter(javaPattern.matches)
    val scalaFiles = allSourceFiles.filter(scalaPattern.matches)
    val kotlinFiles = allSourceFiles.filter(kotlinPattern.matches)
    if (javaFiles.isEmpty && scalaFiles.isEmpty && kotlinFiles.isEmpty) {
      if (config.reportWarningOnEmptyIndex) {
        index
          .app
          .warning(
            s"doing nothing, no files matching pattern '$sourceroot/**.{java,scala,kt}'"
          )
      }
      return CommandResult(Nil, 0, Nil)
    }

    val compileAttempts = ListBuffer.empty[Try[Unit]]
    compileAttempts += compileJavaFiles(tmp, deps, config, javaFiles)
    compileAttempts += compileScalaFiles(deps, scalaFiles, tmp)
    compileAttempts += compileKotlinFiles(deps, config, kotlinFiles)
    val errors = compileAttempts.collect { case Failure(exception) =>
      exception
    }

    if (index.cleanup) {
      Files.walkFileTree(tmp, new DeleteVisitor)
    }
    val isSemanticdbGenerated = Files
      .isDirectory(targetroot.resolve("META-INF"))
    if (
      errors.nonEmpty && (index.strictCompilation || !isSemanticdbGenerated)
    ) {
      errors.foreach { error =>
        index.app.reporter.log(Diagnostic.exception(error))
      }
      CommandResult(Nil, 1, Nil)
    } else {
      if (errors.nonEmpty && isSemanticdbGenerated) {
        index
          .app
          .reporter
          .info(
            "Some SemanticDB files got generated even if there were compile errors. " +
              "In most cases, this means that scip-java managed to index everything " +
              "except the locations that had compile errors and you can ignore the compile errors."
          )
        errors.foreach { error =>
          index.app.reporter.info(error.getMessage())
        }
      }
      CommandResult(Nil, 0, Nil)
    }
  }

  private def compileKotlinFiles(
      deps: Dependencies,
      config: Config,
      allKotlinFiles: List[Path]
  ): Try[Unit] = {
    if (allKotlinFiles.isEmpty || config.dependencies.isEmpty)
      return Success()
    val filesPaths = allKotlinFiles.map(_.toString)

    val plugin =
      Dependencies
        .resolveDependencies(
          List(
            s"com.sourcegraph:semanticdb-kotlinc:${BuildInfo.semanticdbKotlincVersion}"
          ),
          transitive = false
        )
        .classpath
        .head

    val self = config.dependencies.head
    val commonKotlinFiles: List[Path] =
      Dependencies
        .kotlinMPPCommon(self.groupId, self.artifactId, self.version) match {
        case Some(common) =>
          val outdir = Files.createTempDirectory("scipjava-kotlin")
          val file = common.toFile
          val basename = file
            .getName
            .substring(0, file.getName.lastIndexOf("."))
          val newFiles = ListBuffer[Path]()
          val jar = new JarFile(file)
          val enu = jar.entries
          while (enu.hasMoreElements) {
            val entry = enu.nextElement
            val entryPath =
              if (entry.getName.startsWith(basename))
                entry.getName.substring(basename.length)
              else
                entry.getName

            if (entry.isDirectory) {
              new File(outdir.toString, entryPath).mkdirs
            } else if (entry.getName.endsWith(".kt")) {
              val newFile = new File(outdir.toString, entryPath)
              newFiles.addOne(newFile.toPath)
              val istream = jar.getInputStream(entry)
              val ostream = new FileOutputStream(newFile)
              Iterator
                .continually(istream.read)
                .takeWhile(-1 !=)
                .foreach(ostream.write)
              ostream.close()
              istream.close()
            }
          }
          newFiles.toList
        case None =>
          List[Path]()
      }

    val kargs: K2JVMCompilerArguments = new K2JVMCompilerArguments()
    val args = ListBuffer[String](
      "-nowarn",
      "-no-reflect",
      "-no-stdlib",
      "-Xmulti-platform",
      "-Xno-check-actual",
      "-Xopt-in=kotlin.RequiresOptIn",
      "-Xopt-in=kotlin.ExperimentalUnsignedTypes",
      "-Xopt-in=kotlin.ExperimentalStdlibApi",
      "-Xopt-in=kotlin.ExperimentalMultiplatform",
      "-Xopt-in=kotlin.contracts.ExperimentalContracts",
      "-Xallow-kotlin-package",
      s"-Xplugin=$plugin",
      "-P",
      s"plugin:semanticdb-kotlinc:sourceroot=$sourceroot",
      "-P",
      s"plugin:semanticdb-kotlinc:targetroot=$targetroot",
      "-classpath",
      deps.classpathSyntax
    )

    if (commonKotlinFiles.nonEmpty) {
      args +=
        s"-Xcommon-sources=${commonKotlinFiles.map(_.toAbsolutePath.toString).mkString(",")}"
    }

    args ++= filesPaths ++ commonKotlinFiles.map(_.toAbsolutePath.toString)

    parseCommandLineArguments(args.asJava, kargs, false)

    val exit = new K2JVMCompiler().exec(
      new MessageCollector {
        private val errors = new util.LinkedList[String]
        override def clear(): Unit = errors.clear()

        override def hasErrors: Boolean = !errors.isEmpty

        override def report(
            compilerMessageSeverity: CompilerMessageSeverity,
            s: String,
            compilerMessageSourceLocation: CompilerMessageSourceLocation
        ): Unit = {
          if (
            s.endsWith("without a body must be abstract") ||
            s.endsWith("must have a body")
          )
            return // we get these when indexing the stdlib, no other solution found yet
          val msg = MessageRenderer
            .PLAIN_FULL_PATHS
            .render(compilerMessageSeverity, s, compilerMessageSourceLocation)
          index.app.reporter.debug(msg)
          errors.push(msg)
        }
      },
      Services.EMPTY,
      kargs
    )
    if (exit.getCode == 0)
      Success(())
    else
      Failure(new Exception(exit.toString))
  }

  private def compileScalaFiles(
      deps: Dependencies,
      allScalaFiles: List[Path],
      tmp: Path
  ): Try[Unit] =
    Try {
      if (deps.dependencies.nonEmpty && allScalaFiles.nonEmpty)
        withScalaPresentationCompiler(deps, tmp) { compiler =>
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

  private def withScalaPresentationCompiler[T](deps: Dependencies, tmp: Path)(
      fn: PresentationCompiler => T
  ): T = {
    val scalaVersion = deps
      .classpath
      .iterator
      .flatMap(jar => ScalaVersion.inferFromJar(jar))
      .nextOption()
      .getOrElse {
        throw new IllegalArgumentException(
          s"failed to infer the Scala version from the dependencies: " +
            pprint.PPrinter.BlackWhite.tokenize(deps.classpath).mkString +
            s"\n\nTo fix this, consider adding 'org.scala-lang:scala-library:${BuildInfo.scalaVersion}' to the list of dependencies."
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
        .newInstance("scip-java", classpath.asJava, List[String]().asJava)
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
    val actualClasspath = ArrayBuffer.empty[String]
    actualClasspath += semanticdbJar.toString
    actualClasspath ++=
      config
        .classpath
        .map(path =>
          AbsolutePath.of(Paths.get(path), index.workingDirectory).toString
        )
    actualClasspath ++= deps.classpath.map(_.toString)
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
    if (actualClasspath.nonEmpty) {
      arguments += "-classpath"
      arguments += actualClasspath.mkString(File.pathSeparator)
    }
    arguments +=
      s"-Xplugin:semanticdb -targetroot:$targetroot -sourceroot:$sourceroot"
    if (config.processorpath.nonEmpty) {
      arguments += "-processorpath"
      val processorpath =
        semanticdbJar.toString ::
          config
            .processorpath
            .flatMap(path => guessBazelJar(path, index.workingDirectory))
            .map(_.toString)
      arguments += processorpath.mkString(File.pathSeparator)
    }
    val isIgnoredAnnotationProcessor =
      ScipBuildTool.isIgnoredAnnotationProcessor ++
        index.scipIgnoredAnnotationProcessors
    val processors = config.processors.filterNot(isIgnoredAnnotationProcessor)
    if (processors.nonEmpty) {
      arguments += "-processor"
      arguments += processors.mkString(",")
    }
    arguments ++= fixJavacOptions(config.javacOptions)
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
    val javac = javacPath(config, tmp)
    index.app.reporter.info(s"$$ $javac @$argsfile")
    val javacModuleOptions: Seq[String] =
      if (config.jvm != "8")
        BuildInfo.javacModuleOptions
      else
        Nil

    val jvmOptions = config.jvmOptions.map("-J" + _)

    val result = os
      .proc(javac.toString, s"@$argsfile", javacModuleOptions, jvmOptions)
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

  private def fixJavacOptions(options: List[String]): List[String] =
    options match {
      case "--release" :: _ :: rest =>
        // Skip --release because it's not strictly needed for indexing,
        // and it fails the build if -source/-target are also provided.
        // In real-world testing, there were some builds that defined
        // both -source/-target and --release even if javac rejects
        // this combination of flags (because --release implies -source/-target).
        // It could be that the Java rules have built-in support to automatically
        // exclude duplicate -source/-target/--release flags.
        fixJavacOptions(rest)
      case option :: rest =>
        val isIgnored =
          option.startsWith("-Xep") || // ErrorProne flag, which fails the build
            option.startsWith("-Xplugin:semanticdb") || // Redundant SemanticDB
            option.startsWith("-XD") || // unsure what this one does
            index // User-provided flag
              .scipIgnoredJavacOptionPrefixes
              .exists(prefix => option.startsWith(prefix))

        if (isIgnored)
          fixJavacOptions(rest)
        else
          option :: fixJavacOptions(rest)
      case Nil =>
        Nil
    }

  private def javacPath(config: Config, tmp: Path): Path = {
    config.javaHome match {
      case Some(home) =>
        Paths.get(home, "bin", "javac")
      case None =>
        javacPathViaCoursier(config.jvm, tmp)
    }
  }

  private def javacPathViaCoursier(jvmVersion: String, tmp: Path): Path = {
    import _root_.coursier.jvm._

    val jvmChannel = index
      .app
      .env
      .environmentVariables
      .get("COURSIER_JVM_INDEX")
      .map { idx =>
        JvmChannel
          .parse(idx)
          .fold(
            msg =>
              throw new RuntimeException(
                s"Malformed COURSIER_JVM_INDEX environment variable variable: $msg"
              ),
            identity
          )
      }

    val home = JavaHome().withCache(
      JvmCache()
        .withIndexChannel(
          repositories = Seq.empty,
          indexChannel = jvmChannel
            .getOrElse(JvmChannel.url(JvmIndex.defaultIndexUrl))
        )
        .withArchitecture(jvmArchitecture(jvmVersion))
    )

    val javaExecutable = Await.result(
      home.javaBin(jvmVersion).value(ExecutionContext.global),
      Duration.Inf
    )

    javaExecutable
      .getParent()
      .resolve {
        if (scala.util.Properties.isWin)
          "javac.exe"
        else
          "javac"
      }

  }

  private def jvmArchitecture(jvm: String): String =
    if (
      // Hack only for local development on ARM64 Mac OS X
      // won't affect any other system
      scala.util.Properties.isMac && sys.props("os.arch") == "aarch64" &&
      (jvm.startsWith("8") || jvm.startsWith("1.8"))
    )
      "amd64"
    else
      JvmIndex.defaultArchitecture()

  def defaultCoursierJVMArchitecture: String =
    sys.props("os.arch") match {
      case "x86_64" =>
        "amd64"
      case x =>
        x
    }

  private def clean(): Unit = {
    Files.walkFileTree(targetroot, new DeleteVisitor)
  }

  /** Recursively collects all Java files in the working directory */
  private def collectAllSourceFiles(config: Config, dir: Path): List[Path] = {
    if (config.sourceFiles.nonEmpty) {
      return config
        .sourceFiles
        .map(path => AbsolutePath.of(Paths.get(path), dir))
        .filter(path => Files.isRegularFile(path))
    }
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

  // HACK(olafurpg): I haven't figured out a reliable way to get annotation processor jars on the processorpath.
  // The Bazel aspect sometimes says a NAME.jar file is on the processorpath when it doesn't exist but processed_NAME.jar or header_NAME.jar exists.
  // The long-term solution is figuring out how to get the exact same processorpath as Bazel uses for compilation.
  private def guessBazelJar(
      pathString: String,
      workingDirectory: Path
  ): Option[Path] = {
    var path = AbsolutePath.of(Paths.get(pathString), workingDirectory)
    if (Files.isRegularFile(path))
      return Some(path)

    // In some cases, the bazel-out/ prefix is missing from the path that Bazel gives us.
    if (
      !pathString.startsWith("bazel-bin") && !pathString.startsWith("bazel-out")
    ) {
      path = AbsolutePath
        .of(Paths.get("bazel-bin", pathString), workingDirectory)

      if (Files.isRegularFile(path))
        return Some(path)
    }

    val processed = path
      .resolveSibling("processed_" + path.getFileName.toString)
    if (Files.isRegularFile(processed))
      return Some(processed)

    val header = path.resolveSibling("header_" + path.getFileName.toString)
    if (Files.isRegularFile(header))
      return Some(header)

    index.app.warning("annotation processor jar does not exist: " + path)
    None
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
      reportWarningOnEmptyIndex: Boolean = true,
      javaHome: Option[String] = None,
      dependencies: List[Dependency] = Nil,
      sourceFiles: List[String] = Nil,
      classpath: List[String] = Nil,
      bootclasspath: List[String] = Nil,
      processorpath: List[String] = Nil,
      processors: List[String] = Nil,
      javacOptions: List[String] = Nil,
      jvmOptions: List[String] = Nil,
      jvm: String = "17",
      kind: String = ""
  )
  private object Config {
    implicit lazy val codec = moped.macros.deriveCodec(Config())
  }

}

object ScipBuildTool {
  // This file is named "lsif-java.json" instead of "scip-java.json" in order to
  // preserve compatibility with "JVM dependencies" repos
  // (https://docs.sourcegraph.com/integration/jvm). If we rename to
  // "scip-java.json" then the git commit SHAs of these repos changes and old
  // canonical URLs will become 404 links. The lsif-java.json file is not
  // supposed to be written by end-users anyways. It's mostly an implementation
  // default for how we support cross-repo navigation with scip-java.
  val ConfigFileNames = List("scip-java.json", "lsif-java.json")
  val isIgnoredAnnotationProcessor = Set(
    "org.openjdk.jmh.generators.BenchmarkProcessor"
  )
}
