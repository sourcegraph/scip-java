package tests

import com.sourcegraph.scip_java.{BuildInfo => V}

class ScipBuildToolSuite extends BaseBuildToolSuite {
  override def tags = List(SkipWindows)

  test("COURSIER_CREDENTIALS and COURSIER_REPOSITORIES are respected") {
    import java.net.http._
    val client = HttpClient
      .newBuilder()
      .connectTimeout(java.time.Duration.ofSeconds(2))
      .build();

    val cli = sys.env.getOrElse("SCIP_JAVA_CLI", fail("wwaaaa"))

    val Username = "hello"
    val Password = "world"

    val (requests, _) = PasswordProtectedServer(Username, Password).runWith {
      run =>
        val env = Map(
          "COURSIER_REPOSITORIES" -> run.address.toString(),
          "COURSIER_CREDENTIALS" -> s"localhost $Username:$Password"
        )

        val tmp = os.temp.dir(prefix = "scip-java")
        os.write(
          tmp / "lsif-java.json",
          // We use non-existent library to make sure caches are never used
          s"""   {"dependencies": ["bla.bla.nonexistent-library:junit:4.13.1"]}  """
            .trim
        )
        os.write(
          tmp / "foo" / "Example.java",
          "package foo;\npublic class Example{}",
          createFolders = true
        )

        val result = os
          .proc(cli, "index", "--build-tool=scip")
          .call(cwd = tmp, env = env, check = false)

        os.remove.all(tmp)

        assertNotEquals(result.exitCode, 0)
    }

    assert(
      requests.nonEmpty,
      "No requests were sent to the local server - suggesting that COURSIER_REPOSITORIES is not respected by ScipBuildTool"
    )

    assert(
      clue(requests)
        .filter { r =>
          r.simpleHeaders.contains("Authorization")
        }
        .nonEmpty,
      "No requests with Authorization header were sent to local server - suggesting that COURSIER_CREDENTIALS is not respected"
    )

    requests.flatMap(_.simpleHeaders.get("Authorization")).distinct match {
      case List(value) =>
        assertEquals(clue(value), "Basic " + base64("hello:world"))
      case other =>
        fail(
          s"Multiple credential variations were passed to local server: $other"
        )
    }

  }

  private def base64(str: String) =
    new String(java.util.Base64.getEncoder().encode(str.getBytes))

  checkBuild(
    "basic",
    """|/lsif-java.json
       |{"dependencies": ["junit:junit:4.13.1"]}
       |/foo/Example.java
       |package foo;
       |import org.junit.Assert;
       |public class Example {}
       |/foo/Example2.java
       |package foo;
       |public class Example2 {}
       |""".stripMargin,
    expectedSemanticdbFiles = 2,
    expectedPackages =
      """|maven:junit:junit:4.13.1
         |maven:org.hamcrest:hamcrest-core:1.3
         |""".stripMargin
  )

  case class ScalaCombination(
      binaryVersion: String,
      fullVersion: String,
      standardLibraryVersion: String
  )

  List(
    ScalaCombination("2.11", V.scala211, V.scala211),
    ScalaCombination("2.12", V.scala212, V.scala212),
    ScalaCombination("2.13", V.scala213, V.scala213),
    ScalaCombination("3", V.scala3, V.scala213)
  ).foreach { scala =>
    checkBuild(
      s"scala-${scala.fullVersion}",
      s"""|/lsif-java.json
          |{"dependencies": ["com.lihaoyi:geny_${scala.binaryVersion}:0.6.10"]}
          |/foo/Example.scala
          |package foo
          |object Example {
          |  val gen = geny.Generator(1, 2, 3)
          |}
          |/foo/JavaExample.java
          |package foo;
          |public class JavaExample {
          |  public static final geny.Generator gen = geny.Generator(1, 2, 3);
          |}
          |""".stripMargin,
      expectedSemanticdbFiles = 2,
      expectedPackages =
        s"""|maven:com.lihaoyi:geny_${scala.binaryVersion}:0.6.10
            |maven:org.scala-lang:scala-library:${scala.standardLibraryVersion}
            |""".stripMargin
    )
  }
}
