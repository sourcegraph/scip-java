package tests

import java.nio.file.FileSystems
import java.nio.file.Path

import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath

import com.sourcegraph.lsif_java.LsifJava
import moped.testkit.DeleteVisitor
import moped.testkit.FileLayout
import moped.testkit.MopedSuite
import munit.TestOptions

abstract class BaseBuildToolSuite extends MopedSuite(LsifJava.app) {
  override def environmentVariables: Map[String, String] = sys.env

  // NOTE(olafur): workaround for https://github.com/scalameta/moped/issues/18
  override val temporaryDirectory: DirectoryFixture =
    new DirectoryFixture {
      private val path = BuildInfo.temporaryDirectory.toPath
      override def apply(): Path = path
      override def beforeAll(): Unit = {}
      override def afterEach(context: AfterEach): Unit = {
        DeleteVisitor.deleteRecursively(path)
      }
    }

  private val semanticdbPattern = FileSystems
    .getDefault
    .getPathMatcher("glob:**.semanticdb")

  def checkBuild(
      options: TestOptions,
      original: String,
      expected: Int,
      extraArguments: List[String] = Nil
  ): Unit = {
    test(options) {
      FileLayout.fromString(original, root = workingDirectory)
      val targetroot = workingDirectory.resolve("targetroot")
      val arguments =
        List("--targetroot", targetroot.toString) ++ extraArguments
      val exit = app().run(arguments)
      assertEquals(exit, 0, clues(app.capturedOutput))
      val semanticdbFiles = FileIO
        .listAllFilesRecursively(AbsolutePath(targetroot))
        .filter(p => semanticdbPattern.matches(p.toNIO))
      if (semanticdbFiles.length != expected) {
        fail(
          s"Expected $expected SemanticDB file(s) to be generated.",
          clues(semanticdbFiles)
        )
      }
    }
  }

}
