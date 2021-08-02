package tests

import java.nio.file.Files
import java.nio.file.Paths

import scala.meta.inputs.Input

import munit.FunSuite

class JavacClassesDirectorySuite extends FunSuite with TempDirectories {
  val sourceroot = new DirectoryFixture()

  override def munitFixtures: Seq[Fixture[_]] =
    super.munitFixtures ++ List(sourceroot)

  test("targetroot:javac-classes-directory") {
    val compiler =
      new TestCompiler(
        classpath = TestCompiler.PROCESSOR_PATH,
        javacOptions = Nil,
        scalacOptions = Nil,
        targetroot = sourceroot(),
        sourceroot = sourceroot()
      )
    val compileResult = compiler.compile(
      List(
        Input.VirtualFile(
          "example/Example.java",
          """package example;
            |public class Example{}""".stripMargin
        )
      ),
      List(
        s"-Xplugin:semanticdb -sourceroot:${sourceroot()} -targetroot:javac-classes-directory",
        "-d",
        sourceroot().toString
      )
    )
    assert(clue(compileResult).isSuccess)
    val semanticdbPath = Paths
      .get("META-INF")
      .resolve("semanticdb")
      .resolve("example")
      .resolve("Example.java.semanticdb")
    assert(Files.isRegularFile(clue(sourceroot().resolve(semanticdbPath))))
  }

}
