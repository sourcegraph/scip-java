package tests

class MillBuildToolSuite extends BaseBuildToolSuite {
  checkBuild(
    s"minimal",
    s"""|/.mill-version
        |0.10.5
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
      """|maven:munit:munit:1.0.0-M6
         |""".stripMargin
  )
}
