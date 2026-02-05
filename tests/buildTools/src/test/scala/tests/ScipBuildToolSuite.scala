package tests

import com.sourcegraph.scip_java.{BuildInfo => V}
import moped.testkit.FileLayout

class ScipBuildToolSuite extends BaseBuildToolSuite {
  override def tags = List(SkipWindows)

  test("respect-coursier-jvm-index") {

    val (requests, _) = TracingServer.run { run =>
      val env = Map(
        "COURSIER_JVM_INDEX" -> s"${run.address.toString}/index.json"
      )

      val tmp = FileLayout.fromString(
        """
          |/lsif-java.json
          |{"dependencies": ["junit:junit:4.13.1"],"jvm": "17"}
          |/src/main/java/Example.java
          |package foo;\npublic class Example{}
        """.stripMargin
      )

      val result = os
        .proc(scipJavaCli(), "index", "--build-tool=scip")
        .call(cwd = os.Path(tmp), env = env, check = false)

      assertNotEquals(result.exitCode, 0)
    }

    assert(
      requests.nonEmpty,
      "No requests were sent to the local server - suggesting that COURSIER_JVM_INDEX is not respected by ScipBuildTool"
    )

    assert(
      clue(requests)
        .collectFirst {
          case req if req.url.getPath() == "/index.json" =>
            req
        }
        .nonEmpty,
      "No requests were sent to the local server - suggesting that COURSIER_JVM_INDEX is not respected by ScipBuildTool"
    )
  }

  test("respect-coursier-credentials-and-repositories") {

    val Username = "hello"
    val Password = "world"

    val (requests, _) =
      TracingServer.runWithAuth(Username, Password) { run =>
        val env = Map(
          "COURSIER_REPOSITORIES" -> run.address.toString(),
          "COURSIER_CREDENTIALS" -> s"localhost $Username:$Password"
        )

        val tmp = FileLayout.fromString(
          """
            |/lsif-java.json
            |{"dependencies": ["bla.bla.nonexistent-library:junit:4.13.1"]}
            |/src/main/java/Example.java
            |package foo;\npublic class Example{}
        """.stripMargin
        )

        val result = os
          .proc(scipJavaCli(), "index", "--build-tool=scip")
          .call(cwd = os.Path(tmp), env = env, check = false)

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

  private def scipJavaCli() = sys
    .env
    .getOrElse(
      "SCIP_JAVA_CLI",
      fail(
        "SCIP_JAVA_CLI env variable is not set, perhaps the build is misconfigured"
      )
    )

  checkBuild(
    "jvm-args", {
      // In this test we verify that JVM args and Javac options are passed
      // correctly.
      // Lombok modules need to be passed with -J prefix, and javacOptions should
      // be passed unchanged
      // For this test to work the lombok version HAS to be relatively old,
      // so that it requires all these opens.
      // The list is taken from here: https://github.com/projectlombok/lombok/issues/2681#issuecomment-748616687
      val lombokModules = """
        --add-opens=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED
        --add-opens=jdk.compiler/com.sun.tools.javac.comp=ALL-UNNAMED
        --add-opens=jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED
        --add-opens=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED
        --add-opens=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED
        --add-opens=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED
        --add-opens=jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED
        --add-opens=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED
        --add-opens=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED
        --add-opens=jdk.compiler/com.sun.tools.javac.jvm=ALL-UNNAMED
        """.trim.split("\n").map(_.trim).mkString("\"", "\", \"", "\"")

      s"""|/lsif-java.json
          |{"jvmOptions": [$lombokModules], "javacOptions": ["--add-exports=java.base/sun.util=ALL-UNNAMED"], "dependencies": ["org.projectlombok:lombok:1.18.16"]}
          |/foo/Example.java
          |package foo;
          |import sun.util.BuddhistCalendar;
          |public class Example extends BuddhistCalendar {
          |  public static void hello() {
          |    BuddhistCalendar calendar = new BuddhistCalendar();
          |  }
          |}
          |""".stripMargin
    },
    expectedSemanticdbFiles = 1,
    // somehow it seems the actual compilation error from javac
    // does not stop semanticdb-javac from producing the file.
    // we explicitly disable this lenient mode so that if there
    // are any compilation errors, it will be reflected in failed
    // CLI command.
    extraArguments = List("--strict-compilation")
  )

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
    ScalaCombination("2.13", V.scala213, V.scala213),
    // The Scala 2.13 version of the build and the Scala 2.13 version of
    // Scala 3's standard library are not necessarily aligned
    ScalaCombination("3", V.scala3, "2.13.12")
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
