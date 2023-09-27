package tests

abstract class SbtBuildToolSuite(val sbtVersion: String)
    extends BaseBuildToolSuite {
  val scala2Versions = List("2.11.9", "2.12.18", "2.13.11")
  val scala3Versions = List("3.3.1")

  (scala2Versions ++ scala3Versions).foreach { scalaVersion =>
    checkBuild(
      s"basic-sbt=$sbtVersion-scala=$scalaVersion",
      s"""|/build.sbt
          |scalaVersion := "$scalaVersion"
          |libraryDependencies += "junit" % "junit" % "4.13.2"
          |/project/build.properties
          |sbt.version=$sbtVersion
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
      targetRoot = Some("target")
    )
  }
}

class Sbt_1_BuildToolSuite extends SbtBuildToolSuite("1.5.2") {
  checkBuild(
    s"custom-sbt-command=$sbtVersion",
    s"""|/build.sbt
        |lazy val bla = project.in(file("bla"))
        |lazy val blaJS = project.in(file("bla-js")).enablePlugins(ScalaJSPlugin)
        |/project/plugins.sbt
        |addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.14.0")
        |/project/build.properties
        |sbt.version=$sbtVersion
        |/bla/src/main/scala/example/ExampleScala.scala
        |package example
        |class ExampleScala()
        |/bla-js/src/main/scala/example/ExampleScala.scala
        |package example
        |class ExampleScala!!!() // this file is intentionally broken
        |""".stripMargin,
    expectedSemanticdbFiles = 1,
    extraArguments = List("--", "bla/compile"),
    targetRoot = Some("bla/target")
  )
}
