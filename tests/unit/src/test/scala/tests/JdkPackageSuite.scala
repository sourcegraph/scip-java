package tests

import com.sourcegraph.scip_semanticdb.JdkPackage
import munit.FunSuite
import munit.TestOptions

class JdkPackageSuite extends FunSuite {
  def checkVersion(original: TestOptions, expected: String): Unit = {
    test(original) {
      val obtained = JdkPackage.parse(original.name)
      assertNoDiff(obtained.version, expected)
    }
  }

  checkVersion("11.0.9", "11")
  checkVersion("17.0.5", "17")

}
