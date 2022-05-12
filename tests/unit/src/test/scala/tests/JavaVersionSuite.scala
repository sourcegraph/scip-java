package tests

import com.sourcegraph.scip_semanticdb.JavaVersion
import munit.FunSuite
import munit.TestOptions

class JavaVersionSuite extends FunSuite {
  def checkVersion(original: TestOptions, expected: String): Unit = {
    test(original) {
      val obtained = new JavaVersion(original.name)
      assertNoDiff(obtained.pkg.version, expected)
    }
  }

  checkVersion("1.8.0_272", "8")
  checkVersion("11.0.9", "11")

}
