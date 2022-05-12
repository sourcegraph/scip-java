package tests

import com.sourcegraph.scip_java.{BuildInfo => V}

class ScipBuildToolSuite extends BaseBuildToolSuite {
  override def tags = List(SkipWindows)
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
