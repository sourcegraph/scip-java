package tests

import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path

import scala.util.Properties

import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath

import com.sourcegraph.scip_java.ScipJava
import com.sourcegraph.scip_java.buildtools.ClasspathEntry
import moped.testkit.DeleteVisitor
import moped.testkit.FileLayout
import moped.testkit.MopedSuite
import munit.Tag
import munit.TestOptions
import os.Shellable

object Java8Only extends munit.Tag("Java8Only")

abstract class BaseBuildToolSuite extends MopedSuite(ScipJava.app) {
  self =>
  override def environmentVariables: Map[String, String] = sys.env

  def tags = List.empty[Tag]

  override def munitTestTransforms: List[TestTransform] =
    super.munitTestTransforms ++
      List(
        new TestTransform(
          "Java8Only",
          t =>
            if (Properties.isJavaAtLeast(9) && t.tags(Java8Only))
              t.tag(munit.Ignore)
            else
              t
        ),
        new TestTransform(
          "SkipWindows",
          t =>
            if (Properties.isWin && t.tags(SkipWindows))
              t.tag(munit.Ignore)
            else
              t
        )
      )

  // NOTE(olafur): workaround for https://github.com/scalameta/moped/issues/18
  override val temporaryDirectory: DirectoryFixture =
    new DirectoryFixture {
      private val path = BuildInfo
        .temporaryDirectory
        .toPath
        .resolve(self.getClass().getSimpleName())

      override def apply(): Path = {
        Files.createDirectories(path)
        path
      }
      override def beforeEach(context: BeforeEach): Unit = {
        DeleteVisitor.deleteRecursively(path)
      }
    }

  private val semanticdbPattern = FileSystems
    .getDefault
    .getPathMatcher("glob:**.semanticdb")

  def checkBuild(
      options: TestOptions,
      original: String,
      expectedSemanticdbFiles: Int = 0,
      extraArguments: List[String] = Nil,
      expectedError: Option[String => Unit] = None,
      expectedPackages: String = "",
      initCommand: => List[String] = Nil,
      targetRoot: Option[String] = None,
      tools: List[Tool] = Nil
  ): Unit = {
    val minJDK = Tool.minimumSupportedJdk(tools)
    val maxJDK = Tool.maximumSupportedJdk(tools).getOrElse(Int.MaxValue)
    val externalJDKVersion = BaseBuildToolSuite.externalJavaVersion

    val shouldBeIgnored =
      minJDK > externalJDKVersion || externalJDKVersion > maxJDK

    val opts = options.withTags(options.tags ++ tags)

    test(
      if (shouldBeIgnored)
        opts.ignore
      else
        opts
    ) {
      if (initCommand.nonEmpty) {
        os.proc(Shellable(initCommand)).call(os.Path(workingDirectory))
      }

      FileLayout.fromString(original, root = workingDirectory)

      val targetroot = workingDirectory
        .resolve(targetRoot.getOrElse("targetroot"))

      val arguments =
        List[String](
          "index",
          "--temporary-directory",
          Files.createDirectories(cacheDirectory).toString,
          "--targetroot",
          targetroot.toString
        ) ++ extraArguments
      val exit = app().run(arguments)
      if (extraArguments.contains("--verbose")) {
        println(app.capturedOutput)
      }
      expectedError match {
        case Some(fn) =>
          assert(clue(exit) != 0, clues(app.capturedOutput))
          fn(app.capturedOutput)
        case None =>
          assertEquals(exit, 0, clues(app.capturedOutput))
      }
      val semanticdbFiles =
        if (!Files.isDirectory(targetroot))
          Nil
        else
          FileIO
            .listAllFilesRecursively(AbsolutePath(targetroot))
            .filter(p => semanticdbPattern.matches(p.toNIO))
      if (semanticdbFiles.length != expectedSemanticdbFiles) {
        fail(
          s"Expected $expectedSemanticdbFiles SemanticDB file(s) to be generated.",
          clues(semanticdbFiles, app.capturedOutput)
        )
      }
      if (expectedPackages.nonEmpty) {
        val obtainedPackages = ClasspathEntry
          .fromTargetroot(targetroot, workingDirectory)
          .map(_.toPackageHubId)
          .sorted
          .distinct
          .mkString("\n")
        assertNoDiff(obtainedPackages, expectedPackages)
      }
    }
  }

}

object BaseBuildToolSuite {
  lazy val externalJavaVersion: Int = {
    val tmpDir = os.temp.dir()
    var version = Option.empty[String]
    try {
      os.write(tmpDir / "PrintJavaVersion.java", PrintJavaVersion)

      os.proc("javac", "PrintJavaVersion.java").call(cwd = tmpDir)

      version = Some(
        os.proc("java", "PrintJavaVersion").call(cwd = tmpDir).out.text()
      )
    } finally {
      os.remove.all(tmpDir)
    }

    version
      .map(parseJavaVersion)
      .getOrElse(sys.error("Failed to detect external JDK version"))
  }

  private def parseJavaVersion(raw: String) = {
    val prop = raw.takeWhile(c => c.isDigit || c == '.')

    val segments = prop.split("\\.").toList

    segments match {
      // Java 1.6 - 1.8
      case "1" :: lessThan8 :: _ :: Nil =>
        lessThan8.toInt
      // Java 17.0.1, 11.0.20.1, ..
      case modern :: _ :: _ :: rest =>
        modern.toInt
      // Java 12
      case modern :: Nil =>
        modern.toInt
      case other =>
        sys.error(
          s"Cannot process [java.version] property, unknown format: [$raw]"
        )
    }
  }

  private val PrintJavaVersion = """
      public class PrintJavaVersion {
        public static void main(String[] args) {
          System.out.print(System.getProperty("java.version"));
        }
      }

  """
}
