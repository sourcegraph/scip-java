package tests

import java.nio.file.FileSystems
import java.nio.file.Path
import java.nio.file.Paths

import scala.util.Properties

import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath

import com.sourcegraph.lsif_java.LsifJava
import moped.testkit.FileLayout
import moped.testkit.MopedSuite
import munit.TestOptions

abstract class BaseBuildToolSuite extends MopedSuite(LsifJava.app) {
  override def environmentVariables: Map[String, String] = sys.env
  override def workingDirectory: Path = {
    val dir = super.workingDirectory
    if (Properties.isMac && dir.toString.startsWith("/var")) {
      Paths.get(s"/private/$dir")
    } else {
      dir
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
