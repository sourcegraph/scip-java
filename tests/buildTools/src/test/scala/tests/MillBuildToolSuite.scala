package tests

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.nio.file.attribute.PosixFilePermission

import scala.jdk.CollectionConverters._

class MillBuildToolSuite extends BaseBuildToolSuite {

  def setupMill() = {
    val mill = workingDirectory.resolve("mill")
    val resource = getClass().getResource("/mill")
    val in = Paths.get(resource.toURI)

    Files.createDirectories(mill.getParent)
    Files.copy(in, mill, StandardCopyOption.REPLACE_EXISTING)
    Files.setPosixFilePermissions(
      mill,
      Set(
        PosixFilePermission.OWNER_READ,
        PosixFilePermission.OWNER_WRITE,
        PosixFilePermission.OWNER_EXECUTE
      ).asJava
    )
    List("./mill", "--version")
  }

  List("0.10.0").foreach { version =>
    checkBuild(
      s"minimal",
      s"""|/.mill-version
          |${version}
          |/build.sc
          |import mill._, scalalib._
          |object minimal extends ScalaModule {
          |  def scalaVersion = "2.13.8"
          |  object test extends Tests with TestModule.Munit {
          |    def ivyDeps = Agg(ivy"org.scalameta::munit:1.0.0-M6")
          | }
          |}
          |/minimal/src/Main.scala
          |package minimal
          |object Main extends App
          |/minimal/test/src/MainSuite.scala
          |package minimal
          |class MainSpec extends munit.FunSuite {
          |  test("numbers") {
          |    assertEquals(1, 1)
          |  }
          |}
          |""".stripMargin,
      expectedSemanticdbFiles = 2,
      expectedPackages =
        """|maven:junit:junit:4.13.2
           |maven:org.hamcrest:hamcrest-core:1.3
           |maven:org.scala-lang:scala-library:2.13.8
           |maven:org.scala-sbt:test-interface:1.0
           |maven:org.scalameta:junit-interface:1.0.0-M6
           |maven:org.scalameta:munit_2.13:1.0.0-M6
           |""".stripMargin,
      initCommand = setupMill(),
      targetRoot = Some("out/io/kipp/mill/scip/Scip/generate.dest")
    )
  }
}
