package tests

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets
import java.nio.file.FileSystems
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes

import scala.util.Properties

import com.sourcegraph.scip_java.ScipJava
import moped.reporters.ConsoleReporter

class LibrarySnapshotGenerator extends SnapshotGenerator {
  val scalaPattern = FileSystems.getDefault.getPathMatcher("glob:**.scala")
  val javaPattern = FileSystems.getDefault.getPathMatcher("glob:**.java")
  def runScipJava(arguments: List[String]): Unit = {
    val baos = new ByteArrayOutputStream
    val exitCode = ScipJava
      .app
      .withReporter(ConsoleReporter(new PrintStream(baos)))
      .withEnv(
        ScipJava
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
    gen.checkLibrary("com.airbnb.android:epoxy:4.3.1")
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
      val snapshotDir = Files.createTempDirectory("semanticdb-javac")
      runScipJava(
        List(
          "index-dependency",
          "--no-cleanup",
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
    }
  }
}
