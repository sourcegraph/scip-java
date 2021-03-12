package tests

import scala.meta.inputs.Input

import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocument
import munit.FunSuite
import munit.TestOptions

class GeneratedConstructorSuite extends FunSuite with TempDirectories {
  val targetroot = new DirectoryFixture()

  override def munitFixtures: Seq[Fixture[_]] =
    super.munitFixtures ++ List(targetroot)

  def doSomething(
      options: TestOptions,
      original: String,
      fn: (TextDocument, List[String]) => Unit,
      qualifiedClassName: String = "example.Test"
  )(implicit loc: munit.Location): Unit = {
    test(options) {
      val groups = "<<([0-9a-zA-Z]+)>>".r
      val compiler = new TestCompiler(targetroot())
      val trimmedText = groups.replaceAllIn(original, "$1")
      val relativePath = qualifiedClassName.replace('.', '/') + ".java"
      val input = Input.VirtualFile(relativePath, trimmedText)

    }
  }
}
