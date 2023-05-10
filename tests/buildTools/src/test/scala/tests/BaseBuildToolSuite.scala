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
      private val path = BuildInfo.temporaryDirectory.toPath
      override def apply(): Path = path
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
      targetRoot: Option[String] = None
  ): Unit = {
    test(options.withTags(options.tags ++ tags)) {
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
          .fromTargetroot(targetroot)
          .map(_.toPackageHubId)
          .sorted
          .distinct
          .mkString("\n")
        assertNoDiff(obtainedPackages, expectedPackages)
      }
    }
  }

}
