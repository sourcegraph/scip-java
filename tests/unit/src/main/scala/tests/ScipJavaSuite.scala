package tests

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path

import scala.jdk.CollectionConverters._

import com.sourcegraph.scip_java.CliEnvironment
import com.sourcegraph.scip_java.ScipJavaApp
import munit.FunSuite
import munit.Location
import munit.TestOptions
import munit.internal.console.AnsiColors

/**
 * Test base class that boots a [[ScipJavaApp]] with stdout/stderr redirected
 * into an in-memory buffer (exposed via [[ApplicationFixture#capturedOutput]])
 * and a fresh per-test working/cache directory layout.
 *
 * Mirrors the surface area of `moped.testkit.MopedSuite` that the test suites
 * in this repository actually use, without requiring the Scala-only moped
 * runtime.
 */
abstract class ScipJavaSuite(applicationToTest: ScipJavaApp) extends FunSuite {

  val temporaryDirectory: DirectoryFixture = new DirectoryFixture

  def createTempDirectory(): Path = Files.createTempDirectory("scip-java")

  def workingDirectory: Path = temporaryDirectory().resolve("workingDirectory")

  def cacheDirectory: Path = temporaryDirectory().resolve("cache")

  def environmentVariables: Map[String, String] = Map.empty[String, String]

  val app = new ApplicationFixture(applicationToTest)

  class DirectoryFixture extends Fixture[Path]("Directory") {
    private var path: Path = _
    def apply(): Path = path
    override def beforeAll(): Unit = {
      path = createTempDirectory()
    }
    override def afterEach(context: AfterEach): Unit = {
      os.remove.all(os.Path(path))
    }
  }

  class ApplicationFixture(applicationToTest: ScipJavaApp)
      extends Fixture[ScipJavaApp]("Application") {
    private val out = new ByteArrayOutputStream
    private val ps =
      new PrintStream(
        out, /* autoFlush = */ true,
        StandardCharsets.UTF_8.name()
      )

    // NOTE: every invocation gets its own freshly-instrumented [[ScipJavaApp]]
    // (all of them writing into the shared `out` buffer of this fixture) so
    // that suites running in parallel never clobber each other's redirected
    // stdout/stderr. This mirrors `moped.testkit`'s per-invocation app model.
    def apply(): ScipJavaApp = {
      val app = new ScipJavaApp()
      app.setEnv(
        new CliEnvironment(
          workingDirectory,
          environmentVariables.asJava,
          ps,
          ps,
          /* isProgressBarEnabled = */ false
        )
      )
      app
    }

    /** Run the CLI with the given Scala-list arguments. */
    def run(args: List[String]): Int = apply().run(args.asJava)

    def reset(): Unit = out.reset()

    def capturedRawOutput: String = out.toString(StandardCharsets.UTF_8.name())

    def capturedOutput: String = AnsiColors.filterAnsi(capturedRawOutput)

    override def beforeEach(context: BeforeEach): Unit = {
      Files.createDirectories(workingDirectory)
      reset()
    }
  }

  override def munitFixtures: Seq[Fixture[_]] =
    super.munitFixtures ++ List(temporaryDirectory, app)

  def checkErrorOutput(
      name: TestOptions,
      arguments: List[String],
      expectedOutput: String,
      workingDirectoryLayout: String = ""
  )(implicit loc: Location): Unit = {
    checkOutput(
      name,
      arguments,
      expectedOutput,
      expectedExit = 1,
      workingDirectoryLayout = workingDirectoryLayout
    )
  }

  def checkOutput(
      name: TestOptions,
      arguments: => List[String],
      expectedOutput: String,
      expectedExit: Int = 0,
      workingDirectoryLayout: String = ""
  )(implicit loc: Location): Unit = {
    test(name) {
      if (workingDirectoryLayout.nonEmpty) {
        FileLayout.fromString(workingDirectoryLayout, workingDirectory)
      }
      val exit = app.run(arguments)
      assertEquals(exit, expectedExit, clues(app.capturedOutput))
      assertNoDiff(app.capturedOutput, expectedOutput)
    }
  }

  override def assertNoDiff(obtained: String, expected: String, clue: => Any)(
      implicit loc: Location
  ): Unit = {
    val sanitized = obtained.replace(temporaryDirectory().toString(), "")
    // Workaround for https://github.com/scalameta/munit/issues/179
    super.assertNoDiff(
      if (sanitized == "\n")
        ""
      else
        sanitized,
      expected,
      clue
    )
  }
}
