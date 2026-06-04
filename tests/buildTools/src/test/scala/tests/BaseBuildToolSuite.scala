package tests

import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path

import scala.jdk.CollectionConverters._
import scala.util.Properties

import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath

import com.sourcegraph.io.DeleteVisitor
import com.sourcegraph.scip_java.ScipJava
import com.sourcegraph.scip_java.buildtools.ClasspathEntry
import munit.Tag
import munit.TestOptions
import os.Shellable

abstract class BaseBuildToolSuite extends ScipJavaSuite(ScipJava.app) {
  self =>
  override def environmentVariables: Map[String, String] = sys.env

  def tags = List.empty[Tag]

  override def munitTestTransforms: List[TestTransform] =
    super.munitTestTransforms ++
      List(
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

  private val scipShardPattern = FileSystems
    .getDefault
    .getPathMatcher("glob:**.scip")

  def checkBuild(
      options: TestOptions,
      original: String,
      expectedScipFiles: Int = 0,
      extraArguments: List[String] = Nil,
      expectedError: Option[String => Unit] = None,
      expectedPackages: String = "",
      initCommand: => List[String] = Nil,
      prepare: () => Unit = () => (),
      targetRoot: Option[String] = None,
      tools: List[Tool] = Nil
  ): Unit = {
    val minJDK = Tool.minimumSupportedJdk(tools)
    val maxJDK = Tool.maximumSupportedJdk(tools).getOrElse(Int.MaxValue)
    val externalJDKVersion = BaseBuildToolSuite.externalJavaVersion

    val JDKSupported =
      externalJDKVersion >= minJDK && externalJDKVersion <= maxJDK

    val ignoreMsg =
      s"Test ${options
          .name} was ignored because the external JDK version doesn't match the toolset requirements: " +
        s"Tools: $tools, min JDK = $minJDK, max JDK = $maxJDK, detected JDK = $externalJDKVersion"

    test(options.withTags(options.tags ++ tags)) {
      // Unfortunately, MUnit doesn't seem to handle the ignore messages the
      // way we'd want: https://github.com/scalameta/munit/issues/549#issuecomment-2056751821
      // So instead, to give some indication that the test was actually ignored,
      // we print this message
      if (!JDKSupported)
        System.err.println(ignoreMsg)

      assume(JDKSupported, ignoreMsg)

      if (initCommand.nonEmpty) {
        os.proc(Shellable(initCommand)).call(os.Path(workingDirectory))
      }

      FileLayout.fromString(original, root = workingDirectory)

      prepare()

      val targetroot = workingDirectory.resolve(
        targetRoot.getOrElse("targetroot")
      )

      val arguments =
        List[String](
          "index",
          "--temporary-directory",
          Files.createDirectories(cacheDirectory).toString,
          "--targetroot",
          targetroot.toString
        ) ++ extraArguments
      val exit = app.run(arguments)
      expectedError match {
        case Some(fn) =>
          assert(clue(exit) != 0, clues(app.capturedOutput))
          fn(app.capturedOutput)
        case None =>
          assertEquals(exit, 0, clues(app.capturedOutput))
      }
      val scipShardFiles =
        if (!Files.isDirectory(targetroot))
          Nil
        else
          FileIO
            .listAllFilesRecursively(AbsolutePath(targetroot))
            .filter(p => scipShardPattern.matches(p.toNIO))
      if (scipShardFiles.length != expectedScipFiles) {
        fail(
          s"Expected $expectedScipFiles SCIP shard(s) to be generated.",
          clues(scipShardFiles, app.capturedOutput)
        )
      }
      if (expectedPackages.nonEmpty) {
        val obtainedPackages = ClasspathEntry
          .fromTargetroot(targetroot, workingDirectory)
          .asScala
          .map(_.mavenCoordinate())
          .sorted
          .distinct
          .mkString("\n")
        assertNoDiff(obtainedPackages, expectedPackages)
      }
    }
  }

}

object BaseBuildToolSuite {
  // Major version of the JVM that `java` on PATH resolves to. Compiled and
  // executed as a subprocess because the test JVM may differ from PATH.
  lazy val externalJavaVersion: Int = {
    val tmpDir = os.temp.dir()
    try {
      os.write(tmpDir / "PrintJavaVersion.java", PrintJavaVersion)
      os.proc("javac", "PrintJavaVersion.java").call(cwd = tmpDir)
      os.proc("java", "PrintJavaVersion")
        .call(cwd = tmpDir)
        .out
        .text()
        .trim
        .toInt
    } finally {
      os.remove.all(tmpDir)
    }
  }

  private val PrintJavaVersion = """
      public class PrintJavaVersion {
        public static void main(String[] args) {
          System.out.print(Runtime.version().feature());
        }
      }
  """
}
