package tests

import java.nio.charset.StandardCharsets
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.atomic.AtomicInteger

import scala.util.Properties

import scala.meta.inputs.Input
import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.lsif_java.Dependencies
import com.sourcegraph.lsif_java.SemanticdbPrinters
import com.sourcegraph.lsif_java.LsifJava
import java.nio.file.SimpleFileVisitor
import java.nio.file.FileVisitResult
import java.nio.file.attribute.BasicFileAttributes
import java.io.PrintStream
import java.io.ByteArrayOutputStream
import moped.reporters.ConsoleReporter

class LibrarySnapshotGenerator extends SnapshotGenerator {
  val scalaPattern = FileSystems.getDefault.getPathMatcher("glob:**.scala")
  val javaPattern = FileSystems.getDefault.getPathMatcher("glob:**.java")
  private case class IndexMetrics(occurrenceCount: Int, linesOfCode: Int)
  def runLsifJava(arguments: List[String]): Unit = {
    val baos = new ByteArrayOutputStream
    val exitCode = LsifJava
      .app
      .withReporter(ConsoleReporter(new PrintStream(baos)))
      .withEnv(
        LsifJava
          .app
          .env
          .withStandardOutput(new PrintStream(baos))
          .withStandardError(new PrintStream(baos))
          .withExit(i => throw new RuntimeException(i.toString()))
      )
      .run(arguments)
    if (exitCode != 0) {
      throw new RuntimeException(baos.toString())
    }
  }

  override def run(context: SnapshotContext, handler: SnapshotHandler): Unit = {
    val gen = new Gen(context, handler)
    gen.checkLibrary(
      "com.airbnb.android:epoxy:4.3.1"
      // isIncluded = jar => jar.contains("epoxy")
    )
    // gen.checkLibrary("org.jetbrains.kotlin:kotlin-allopen:1.4.32")
    gen.checkLibrary(
      "com.lihaoyi:ujson_2.13:1.4.0",
      provided = List(
        s"org.scala-lang:scala-library:${Properties.versionNumberString}"
      )
    )
  }

  private class Gen(context: SnapshotContext, handler: SnapshotHandler) {
    def checkLibrary(name: String, provided: List[String] = Nil): Unit = {
      println(s"indexing library '$name'")
      val providedArguments = provided.flatMap(p => List("--provided", p))
      val targetroot = Files.createTempDirectory("semanticdb-javac")
      val snapshotDir = Files.createTempDirectory("semanticdb-javac")
      runLsifJava(
        List(
          "index-dependency",
          "--snapshot",
          "--dependency",
          name,
          "--output",
          snapshotDir.toString()
        ) ++ providedArguments
      )
      val root = snapshotDir.toFile().listFiles().head.toPath()
      Files.walkFileTree(
        root,
        new SimpleFileVisitor[Path] {
          override def visitFile(
              file: Path,
              attrs: BasicFileAttributes
          ): FileVisitResult = {
            val print =
              new String(Files.readAllBytes(file), StandardCharsets.UTF_8)
            val out = context.expectDirectory.resolve(root.relativize(file))
            handler.onSnapshotTest(context, out, () => print)
            super.visitFile(file, attrs)
          }
        }
      )
      // Files.walkFileTree(indexDir, new DeleteVisitor())
      // Files.walkFileTree(snapshotDir, new DeleteVisitor())
      // val deps = Dependencies.resolveDependencies(name :: provided)
      // val counter = new AtomicInteger()

      // val compiler =
      //   new TestCompiler(
      //     deps.classpathSyntax,
      //     javacOptions = List("-Xlint:none"),
      //     scalacOptions = Nil,
      //     targetroot
      //   )
      // val timer = new Timer()
      // val toIndex = deps.sources.filter(p => isIncluded(p.getFileName.toString))
      // toIndex.foreach { source =>
      //   val metrics = compileSourcesJar(source, compiler)
      //   val i = counter.incrementAndGet()
      //   val message =
      //     f"$i%3s/${toIndex.size} jars; $timer%6s; " +
      //       f"${metrics.occurrenceCount}%,.0f occurrences; " +
      //       f"${metrics.linesOfCode}%,.0f loc; " + f"${source.getFileName}"
      //   println(message)
      // }
    }

    private def compileSourcesJar(
        source: Path,
        compiler: TestCompiler
    ): IndexMetrics = {
      var occurrenceCount, linesOfCode = 0
      FileIO
        .withJarFileSystem(AbsolutePath(source), create = false, close = true) {
          root =>
            val inputs =
              FileIO
                .listAllFilesRecursively(root)
                .iterator
                .filter(file =>
                  javaPattern.matches(file.toNIO) ||
                    scalaPattern.matches(file.toNIO)
                )
                .map { file =>
                  val relpath = file.toRelative(root).toString()
                  val text = FileIO.slurp(file, StandardCharsets.UTF_8)
                  linesOfCode += text.linesIterator.size
                  Input.VirtualFile(relpath, text)
                }
                .toArray

            val result = compiler.compileSemanticdb(inputs)
            result
              .textDocuments
              .getDocumentsList
              .forEach { textDocument =>
                occurrenceCount += textDocument.getOccurrencesCount
                val print = SemanticdbPrinters.printTextDocument(textDocument)
                val out = context.expectDirectory.resolve(textDocument.getUri)
                handler.onSnapshotTest(context, out, () => print)
              }
        }
      IndexMetrics(occurrenceCount, linesOfCode)
    }
  }
}
