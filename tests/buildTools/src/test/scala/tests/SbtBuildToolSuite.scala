package tests

abstract class SbtBuildToolSuite(sbtVersion: String)
    extends BaseBuildToolSuite {
  List("2.11.9", "2.12.18", "2.13.11", "3.3.0").foreach { scalaVersion =>
    checkBuild(
      s"basic-sbt=$sbtVersion-scala=$scalaVersion",
      s"""|/build.sbt
          |scalaVersion := "$scalaVersion"
          |libraryDependencies += "junit" % "junit" % "4.13.2"
          |/project/build.properties
          |sbt.version=1.5.2
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

class Sbt_1_BuildToolSuite extends SbtBuildToolSuite("1.5.2")
class Sbt_013_BuildToolSuite extends SbtBuildToolSuite("0.13.17")
