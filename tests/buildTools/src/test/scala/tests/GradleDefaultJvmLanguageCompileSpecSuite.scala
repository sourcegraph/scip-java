package tests

import scala.jdk.CollectionConverters._

import munit.FunSuite
import munit.TestOptions

class GradleDefaultJvmLanguageCompileSpecSuite extends FunSuite {
  val pluginpath = System.getProperty("semanticdb.pluginpath")
  def check(
      options: TestOptions,
      original: List[String],
      expected: List[String]
  ): Unit = {
    test(options) {
      val obtained =
        new GradleDefaultJvmLanguageCompileSpec(original)
          .getCompileClasspath
          .asScala
          .map(_.toString)
          .toList
      assertEquals(obtained, expected)
    }
  }

  check("empty", List(), List(pluginpath))
  check("non-empty", List("foo"), List("foo", pluginpath))

}
