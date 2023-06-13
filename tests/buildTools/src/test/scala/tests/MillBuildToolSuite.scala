package tests

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.nio.file.attribute.PosixFilePermission

import scala.jdk.CollectionConverters._

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
        "maven:org.scala-lang:scala-library:2.13.8",
        "maven:org.scala-lang:scala3-library_3:3.1.3"
      ).mkString("\n")
    else if (scalaVersion.startsWith("2.13"))
      "maven:org.scala-lang:scala-library:2.13.8"
    else if (scalaVersion.startsWith("2.12"))
      "maven:org.scala-lang:scala-library:2.12.16"
    else
      "idn fail, we don't cover this scala version"

  def scalaBinaryVersion(scalaVersion: String) =
    if (scalaVersion.startsWith("3"))
      "3"
    else if (scalaVersion.startsWith("2.13"))
      "2.13"
    else if (scalaVersion.startsWith("2.12"))
      "2.12"
    else
      "idn fail, we don't cover this scala version"

  val supportedMillVersions = List("0.10.6", "0.11.0")
  val supportedScalaVersion = List("2.12.16", "2.13.8", "3.1.3")

  val testGroupings =
    for {
      millVersion <- supportedMillVersions
      scalaVersion <- supportedScalaVersion
    } yield (millVersion, scalaVersion)

  testGroupings.foreach { case (millVersion, scalaVersion) =>
    checkBuild(
      s"minimal-${millVersion}-${scalaVersion}",
      s"""|/.mill-version
          |${millVersion}
          |/build.sc
          |import mill._, scalalib._
          |object minimal extends ScalaModule {
          |  def scalaVersion = "${scalaVersion}"
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
            |${scalaLibrary(scalaVersion)}
            |maven:org.scala-sbt:test-interface:1.0
            |maven:org.scalameta:junit-interface:1.0.0-M6
            |maven:org.scalameta:munit_${scalaBinaryVersion(scalaVersion)}:1.0.0-M6
            |""".stripMargin,
      initCommand = setupMill(millVersion),
      targetRoot = Some("out/io/kipp/mill/scip/Scip/generate.dest")
    )
  }

  checkBuild(
    "java-module",
    s"""|/.mill-version
        |0.10.7
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
    initCommand = setupMill("0.10.7"),
    targetRoot = Some("out/io/kipp/mill/scip/Scip/generate.dest")
  )

  checkBuild(
    "lsif-output",
    s"""|/.mill-version
        |0.10.7
        |/build.sc
        |import mill._, scalalib._
        |object minimal extends ScalaModule {
        |  def scalaVersion = "3.1.3"
        |}
        |/minimal/src/Main.scala
        |package minimal
        |@main def hello = ()
        |""".stripMargin,
    expectedSemanticdbFiles = 1,
    initCommand = setupMill("0.10.7"),
    targetRoot = Some("out/io/kipp/mill/scip/Scip/generate.dest"),
    extraArguments = List("--output", "dump.lsif")
  )
}
