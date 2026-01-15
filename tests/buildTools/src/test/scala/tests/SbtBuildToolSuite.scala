package tests

import tests.Tool.SBT112

abstract class SbtBuildToolSuite(sbt: Tool.SBT) extends BaseBuildToolSuite {

  import Tool._

  for {
    scala <- List(Scala2_11, Scala2_13, Scala_LTS, Scala_Next)
  } yield {
    checkBuild(
      s"basic-${sbt.name}-${scala.name}",
      s"""|/build.sbt
          |scalaVersion := "${scala.version}"
          |libraryDependencies += "junit" % "junit" % "4.13.2"
          |/project/build.properties
          |sbt.version=${sbt.version}
          |/src/main/java/example/ExampleJava.java
          |package example;
          |import org.junit.Assert;
          |public class ExampleJava {}
          |/src/main/scala/example/ExampleScala.scala
          |package example
          |import org.junit.Assert
          |class ExampleScala()
          |/src/test/java/example/ExampleJavaSuite.java
          |package example;
          |public class ExampleJavaSuite {}
          |/src/test/scala/example/ExampleaSuite.scala
          |package example
          |class ExampleSuite() {}
          |""".stripMargin,
      expectedSemanticdbFiles = 4,
      targetRoot = Some("target"),
      tools = List(scala, sbt)
    )
  }

  checkBuild(
    s"custom-sbt-command-${sbt.name}",
    s"""|/build.sbt
        |lazy val bla = project.in(file("bla"))
        |lazy val blaJS = project.in(file("bla-js")).enablePlugins(ScalaJSPlugin)
        |/project/plugins.sbt
        |addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.14.0")
        |/project/build.properties
        |sbt.version=${sbt.version}
        |/bla/src/main/scala/example/ExampleScala.scala
        |package example
        |class ExampleScala()
        |/bla-js/src/main/scala/example/ExampleScala.scala
        |package example
        |class ExampleScala!!!() // this file is intentionally broken
        |""".stripMargin,
    expectedSemanticdbFiles = 1,
    extraArguments = List("--", "bla/compile"),
    targetRoot = Some("bla/target"),
    tools = List(sbt)
  )
}

import Tool._

class Sbt_112_BuildToolSuite extends SbtBuildToolSuite(SBT112)
