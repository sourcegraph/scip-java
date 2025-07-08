package tests

import scala.meta.internal.io.InputStreamIO

class MavenBuildToolSuite extends BaseBuildToolSuite {
  override def tags = List(SkipWindows)

  lazy val pomXml =
    new String(
      InputStreamIO.readBytes(
        this.getClass.getResourceAsStream("/example-maven-pom.xml")
      )
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
