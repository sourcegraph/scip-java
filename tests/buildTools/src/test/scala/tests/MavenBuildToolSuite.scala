package tests

import scala.meta.internal.io.InputStreamIO

class MavenBuildToolSuite extends BaseBuildToolSuite {
  override def tags = List(SkipWindows)

  def pomXml =
    new String(
      InputStreamIO
        .readBytes(this.getClass.getResourceAsStream("/example-maven-pom.xml"))
    )

  checkBuild(
    "basic",
    s"""|/pom.xml
        |$pomXml
        |/src/main/java/com/Example.java
        |package com;
        |public class Example {}
        |/src/test/java/com/ExampleSuite.java
        |package com;
        |public class ExampleSuite {}
        |""".stripMargin,
    2,
    expectedPackages =
      """|maven:junit:junit:4.11
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
