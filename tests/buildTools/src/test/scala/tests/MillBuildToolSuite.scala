package tests

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.nio.file.attribute.PosixFilePermission

import scala.jdk.CollectionConverters._

import tests.Tool._

class MillBuildToolSuite extends BaseBuildToolSuite {

  def setupMill(millVersion: String) = {
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
    List("./mill", s"--mill-version", millVersion, "--version")
  }

  def scalaLibrary(scalaVersion: String) =
    if (scalaVersion.startsWith("3"))
      List(
        "maven:org.scala-lang:scala-library:2.13.16",
        s"maven:org.scala-lang:scala3-library_3:$scalaVersion"
      ).mkString("\n")
    else if (scalaVersion.startsWith("2.13"))
      s"maven:org.scala-lang:scala-library:$scalaVersion"
    else
      "idn fail, we don't cover this scala version"

  def scalaBinaryVersion(scalaVersion: String) =
    if (scalaVersion.startsWith("3"))
      "3"
    else if (scalaVersion.startsWith("2.13"))
      "2.13"
    else
      "idn fail, we don't cover this scala version"

  for {
    mill <- List(Mill)
    scala <- List(Scala2_13, Scala_LTS, Scala_Next)
  } yield {

    checkBuild(
      s"minimal-${mill.name}-${scala.name}",
      s"""|/.mill-version
          |${mill.version}
          |/build.sc
          |import mill._, scalalib._
          |object minimal extends ScalaModule {
          |  def scalaVersion = "${scala.version}"
          |  object test extends ScalaModuleTests with TestModule.Munit {
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
        s"""|maven:junit:junit:4.13.2
            |maven:org.hamcrest:hamcrest-core:1.3
            |${scalaLibrary(scala.version)}
            |maven:org.scala-sbt:test-interface:1.0
            |maven:org.scalameta:junit-interface:1.0.0-M6
            |maven:org.scalameta:munit_${scalaBinaryVersion(
             scala.version
           )}:1.0.0-M6
            |""".stripMargin,
      initCommand = setupMill(mill.version),
      targetRoot = Some("out/io/kipp/mill/scip/Scip/generate.dest"),
      tools = List(mill, scala)
    )
  }

  checkBuild(
    "java-module",
    s"""|/.mill-version
        |${Mill.version}
        |/build.sc
        |import mill._, scalalib._
        |object minimal extends JavaModule
        |/minimal/src/ScipOutputFormat.java
        |package minimal;
        |public enum ScipOutputFormat {
        |  GRAPH_NDJSON,
        |  GRAPH_PROTOBUF,
        |  TYPED_PROTOBUF,
        |  TYPED_NDJSON,
        |  UNKNOWN;
        |}
        |""".stripMargin,
    expectedSemanticdbFiles = 1,
    initCommand = setupMill(Mill.version),
    targetRoot = Some("out/io/kipp/mill/scip/Scip/generate.dest"),
    tools = List(Mill)
  )

  checkBuild(
    "output",
    s"""|/.mill-version
        |${Mill.version}
        |/build.sc
        |import mill._, scalalib._
        |object minimal extends ScalaModule {
        |  def scalaVersion = "3.3.3"
        |}
        |/minimal/src/Main.scala
        |package minimal
        |@main def hello = ()
        |""".stripMargin,
    expectedSemanticdbFiles = 1,
    initCommand = setupMill(Mill.version),
    targetRoot = Some("out/io/kipp/mill/scip/Scip/generate.dest"),
    extraArguments = List("--output", "dump.scip"),
    tools = List(Mill)
  )
}
