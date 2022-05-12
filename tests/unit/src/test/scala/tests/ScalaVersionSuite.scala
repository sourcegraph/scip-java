package tests

import java.nio.file.Paths

import com.sourcegraph.scip_java.buildtools.ScalaVersion
import com.sourcegraph.scip_java.{BuildInfo => V}
import munit.FunSuite
import munit.TestOptions

class ScalaVersionSuite extends FunSuite {
  def checkNone(original: TestOptions): Unit = {
    test(original) {
      assertEquals(ScalaVersion.inferFromJar(Paths.get(original.name)), None)
    }
  }
  def check(original: TestOptions, expected: String): Unit = {
    test(original) {
      val Some(obtained) = ScalaVersion.inferFromJar(Paths.get(original.name))
      assertNoDiff(obtained, expected)
    }
  }

  checkNone("junit-4.13.2")
  checkNone("scala-library-2.10.1.jar")
  check("scala-library-2.11.1.jar", V.scala211)
  check("scala-library-2.12.1.jar", V.scala212)
  check("scala-compiler-2.13.1.jar", V.scala213)
  check("scala-reflect-2.13.1.jar", V.scala213)
  check("scala-library-2.13.1.jar", V.scala213)
  check("scalap-2.13.1.jar", V.scala213)
  checkNone("scala-library-2.14.1.jar")

  check("geny_2.11-0.10.5.jar", V.scala211)
  check("geny_2.12-0.10.5.jar", V.scala212)
  check("geny_2.13-0.10.5.jar", V.scala213)
  check("geny_3-0.10.5.jar", V.scala3)

}
