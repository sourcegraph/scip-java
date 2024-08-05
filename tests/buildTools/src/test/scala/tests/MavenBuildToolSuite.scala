package tests

import scala.meta.internal.io.InputStreamIO

class MavenBuildToolSuite extends BaseBuildToolSuite {
  override def tags = List(SkipWindows)

  lazy val pomXml =
    new String(
      InputStreamIO
        .readBytes(this.getClass.getResourceAsStream("/example-maven-pom.xml"))
    )

  checkBuild(
    options = "basic",
    original =
      s"""
         |/pom.xml
         |$pomXml
         |/src/main/java/com/Example.java
         |package com;
         |public class Example {}
         |/src/test/java/com/ExampleSuite.java
         |package com;
         |public class ExampleSuite {}
         |""".stripMargin,
    expectedSemanticdbFiles = 2,
    expectedPackages =
      """|maven:com.sourcegraph:example:1.0-SNAPSHOT
         |maven:junit:junit:4.11
         |maven:org.hamcrest:hamcrest-core:1.3
         |""".stripMargin
  )

  // TODO: find more of a core location to move this to
  checkBuild(
    options = "annotation-parameters",
    original =
      s"""
         |/pom.xml
         |$pomXml
         |/src/main/java/com/Foo.java
         |public interface Foo {
         |    @Bar(-1d)
         |    double value();
         |}
         |/src/main/java/com/Bar.java
         |@interface Bar {
         |    double value();
         |}
         |""".stripMargin,
    expectedSemanticdbFiles = 2
  )

  checkBuild(
    "build-command",
    s"""|/pom.xml
        |$pomXml
        |/src/main/java/com/Example.java
        |package com;
        |public class Example {}
        |/src/test/java/com/ExampleSuite.java
        |package com;
        |public class ExampleSuite {}
        |""".stripMargin,
    1,
    extraArguments = List("--", "compile")
  )

}
