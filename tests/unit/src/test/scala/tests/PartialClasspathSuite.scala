package tests

import java.nio.file.Files
import javax.tools.StandardLocation
import javax.tools.ToolProvider

import scala.jdk.CollectionConverters._
import scala.meta.Input

import munit.FunSuite

/**
 * Regression test for https://github.com/sourcegraph/scip-java/issues/861.
 *
 * When semanticdb-javac encounters a CompletionFailure (e.g. a missing anonymous inner
 * class from a Scala-compiled JAR), reportException() was calling reporter.error() which
 * uses Diagnostic.Kind.ERROR — causing javac to exit non-zero and fail the build.
 *
 * The fix changes reportException() to use reporter.warning() (Kind.WARNING) so the build
 * always succeeds, with partial semanticdb output and a warning in the compiler output.
 */
class PartialClasspathSuite extends FunSuite with TempDirectories {

  val targetroot = new DirectoryFixture()

  override def munitFixtures: Seq[Fixture[_]] =
    super.munitFixtures ++ List(targetroot)

  /**
   * Builds an incomplete classpath directory that will trigger a CompletionFailure inside
   * semanticdb-javac's override-resolution logic.
   *
   * SemanticdbVisitor.semanticdbOverrides() walks the supertype chain and calls
   * superElement.getEnclosedElements(), which forces javac to complete ALL enclosed types —
   * including inner/anonymous classes. This mirrors the production failure in bdc-catalogs
   * where DataType$1 (a Scala-compiled anonymous inner class) was not on the Java classpath.
   *
   * Setup:
   *   - B has an inner class B.Inner (generates B$Inner.class) and a method doSomething()
   *   - A extends B and overrides doSomething()
   *   - B$Inner.class is deleted after compilation
   *
   * When semanticdb processes a class that extends A and overrides doSomething(), it walks:
   *   UsesA → A.getEnclosedElements() → B.getEnclosedElements() → tries to complete B$Inner
   *   → CompletionFailure: class file for pkg.B$Inner not found
   */
  private def buildIncompleteClasspath(): java.nio.file.Path = {
    val classDir = Files.createTempDirectory("partial-classpath-classes")
    val srcDir   = Files.createTempDirectory("partial-classpath-sources")
    Files.createDirectories(classDir.resolve("pkg"))
    Files.createDirectories(srcDir.resolve("pkg"))

    // B has an inner class (B$Inner.class will be generated) and an overridable method.
    Files.writeString(
      srcDir.resolve("pkg/B.java"),
      """|package pkg;
         |public class B {
         |  public static class Inner {}
         |  public void doSomething() {}
         |}
         |""".stripMargin
    )
    // A extends B and overrides the method so the override chain goes through B.
    Files.writeString(
      srcDir.resolve("pkg/A.java"),
      """|package pkg;
         |public class A extends B {
         |  @Override public void doSomething() {}
         |}
         |""".stripMargin
    )

    val javac = ToolProvider.getSystemJavaCompiler
    val fm    = javac.getStandardFileManager(null, null, null)
    fm.setLocation(StandardLocation.CLASS_OUTPUT, List(classDir.toFile).asJava)
    val units = fm.getJavaFileObjects(
      srcDir.resolve("pkg/B.java").toFile,
      srcDir.resolve("pkg/A.java").toFile
    )
    javac.getTask(null, fm, null, null, null, units).call()
    fm.close()

    // Delete B$Inner.class — simulates anonymous/inner class from Scala compilation
    // that is not on the Java classpath (e.g. DataType$1 in Apache Spark).
    Files.delete(classDir.resolve("pkg/B$Inner.class"))

    classDir
  }

  /**
   * Triggers an IOException inside writeSemanticdb() by pre-creating the semanticdb output
   * directory path as a regular file. When semanticdb-javac tries to call
   * Files.createDirectories() on a path that already exists as a file, it throws
   * FileAlreadyExistsException (a subtype of IOException). This IOException is caught by the
   * writeSemanticdb() catch block, which calls reportException() → reporter.warning().
   *
   * This tests the core invariant: any internal exception in semanticdb-javac must surface as a
   * compiler warning (not error), so the build always succeeds with partial output.
   *
   * Note: The original test used a missing inner class (B$Inner.class) to trigger
   * CompletionFailure. That approach no longer works on Java 21+ because javac handles
   * missing inner class files gracefully without throwing to user-facing plugin code.
   */
  private def buildTargetrootWithBlockedOutputDir(): java.nio.file.Path = {
    val tr = Files.createTempDirectory("semanticdb-javac-blocked")
    // The output path for "example/UsesA.java" is:
    //   tr/META-INF/semanticdb/example/UsesA.java.semanticdb
    // We create tr/META-INF/semanticdb/example as a regular FILE (not a dir).
    // When SemanticdbTaskListener calls Files.createDirectories(output.getParent()),
    // it finds a file at "example" and throws FileAlreadyExistsException.
    val semanticdbBase = tr.resolve("META-INF").resolve("semanticdb")
    Files.createDirectories(semanticdbBase)
    Files.createFile(semanticdbBase.resolve("example")) // regular file, blocks dir creation
    tr
  }

  test("compilation succeeds with warning when semanticdb-javac encounters an internal exception") {
    // Use a targetroot where the output directory path is blocked (a file exists where a
    // directory is needed). This reliably triggers an IOException in writeSemanticdb(),
    // regardless of JDK version.
    val blockedTargetroot = buildTargetrootWithBlockedOutputDir()

    val compiler = new TestCompiler(
      classpath     = TestCompiler.PROCESSOR_PATH,
      javacOptions  = Nil,
      scalacOptions = Nil,
      targetroot    = blockedTargetroot
    )

    val result = compiler.compileSemanticdb(List(
      Input.VirtualFile(
        "example/UsesA.java",
        """|package example;
           |public class UsesA {
           |  public void doSomething() {}
           |}
           |""".stripMargin
      )
    ))

    // The build must succeed — semanticdb-javac errors must never fail compilation.
    assert(result.isSuccess, s"Expected build success but got:\n${result.stdout}")

    // The IOException must surface as a warning, not an error.
    assert(
      result.stdout.contains("warning:"),
      s"Expected a warning in compiler output but got:\n${result.stdout}"
    )
    assert(
      !result.stdout.contains("\nerror:"),
      s"Expected no errors in compiler output but got:\n${result.stdout}"
    )
  }

  test("semanticdb files are still produced for healthy files when another file triggers an exception") {
    val incompleteClasspath = buildIncompleteClasspath()

    val compiler = new TestCompiler(
      classpath     = incompleteClasspath.toString,
      javacOptions  = Nil,
      scalacOptions = Nil,
      targetroot    = targetroot()
    )

    val result = compiler.compileSemanticdb(List(
      Input.VirtualFile(
        "example/UsesA.java",
        """|package example;
           |import pkg.A;
           |public class UsesA extends A {
           |  @Override public void doSomething() {}
           |}
           |""".stripMargin
      ),
      Input.VirtualFile(
        "example/Healthy.java",
        """|package example;
           |public class Healthy {
           |  public String hello() { return "hello"; }
           |}
           |""".stripMargin
      )
    ))

    assert(result.isSuccess, s"Expected build success but got:\n${result.stdout}")

    // The healthy file must still produce a semanticdb document.
    val docs = result.textDocuments.getDocumentsList.asScala
    assert(
      docs.exists(_.getUri.contains("Healthy.java")),
      s"Expected semanticdb output for Healthy.java, got URIs: ${docs.map(_.getUri).mkString(", ")}"
    )
  }
}
