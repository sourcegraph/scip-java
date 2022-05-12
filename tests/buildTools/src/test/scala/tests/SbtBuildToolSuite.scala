package tests

import munit.IgnoreSuite

// Ignored because the sbt-sourcegraph plugin adds the -build-tool:sbt flag, which
// is yet not supported by any stable release of scip-java. We can un-ignore this
// test suite after the next release.
@IgnoreSuite
class SbtBuildToolSuite extends BaseBuildToolSuite {
  List("1.5.2", "0.13.17").foreach { version =>
    checkBuild(
      s"basic-$version",
      s"""|/build.sbt
          |scalaVersion := "2.11.9"
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
          |public class ExampleSuite {}
          |/src/test/scala/example/ExampleScalaSuite.java
          |package example
          |class ExampleSuite() {}
          |""".stripMargin,
      expectedSemanticdbFiles = 4,
      expectedPackages =
        """|maven:junit:junit:4.13.1
           |""".stripMargin
    )
  }

}
