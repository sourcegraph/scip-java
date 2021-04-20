package tests

import java.io.File

import scala.jdk.CollectionConverters._

import munit.FunSuite
import munit.TestOptions

class GradleJavaCompilerArgumentsBuilderSuite extends FunSuite {
  val targetroot = System.getProperty("semanticdb.targetroot")
  val sourceroot = System.getProperty("semanticdb.sourceroot")
  val pluginpath = System.getProperty("semanticdb.pluginpath")
  val Xplugin =
    s"-Xplugin:semanticdb -sourceroot:$sourceroot -targetroot:$targetroot"
  def check(
      options: TestOptions,
      original: List[String],
      expected: List[String]
  ): Unit = {
    test(options) {
      val obtained =
        new GradleJavaCompilerArgumentsBuilder(original).build().asScala.toList
      assertEquals(obtained, expected)
    }
  }

  check(
    "basic",
    List("-Arandom"),
    List("-Arandom", "-classpath", pluginpath, Xplugin)
  )

  check(
    "only-classpath",
    List("-classpath", "a.jar"),
    List(
      "-classpath",
      List(pluginpath, "a.jar").mkString(File.pathSeparator),
      Xplugin
    )
  )

  check(
    "only-processorpath",
    List("-processorpath", "a.jar"),
    List(
      "-processorpath",
      List(pluginpath, "a.jar").mkString(File.pathSeparator),
      Xplugin
    )
  )

  check(
    "classpath-and-processorpath",
    List("-classpath", "a.jar", "-processorpath", "b.jar"),
    List(
      "-classpath",
      List(pluginpath, "a.jar").mkString(File.pathSeparator),
      "-processorpath",
      List(pluginpath, "b.jar").mkString(File.pathSeparator),
      Xplugin
    )
  )

}
