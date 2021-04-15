package tests

import munit.IgnoreSuite

// FIXME: disabled because of https://github.com/sourcegraph/lsif-java/issues/164
@IgnoreSuite
class GradleBuildToolSuite extends BaseBuildToolSuite {

  checkBuild(
    "basic",
    """|/build.gradle
       |apply plugin: 'java'
       |repositories { mavenCentral() }
       |dependencies { implementation "junit:junit:4.13.1" }
       |/src/main/java/Example.java
       |import org.junit.Assert;
       |public class Example {}
       |/src/test/java/ExampleSuite.java
       |public class ExampleSuite {}
       |""".stripMargin,
    expectedSemanticdbFiles = 2,
    expectedPackages =
      """|maven:junit:junit:4.11
         |maven:org.hamcrest:hamcrest-core:1.3
         |""".stripMargin
  )

  checkBuild(
    "toolchains",
    """|/build.gradle
       |apply plugin: 'java'
       |java {
       |  toolchain {
       |    languageVersion = JavaLanguageVersion.of(8)
       |  }
       |}
       |repositories { mavenCentral() }
       |dependencies { implementation "junit:junit:4.13.1" }
       |/src/main/java/Example.java
       |public class Example {}
       |/src/test/java/ExampleSuite.java
       |public class ExampleSuite {}
       |""".stripMargin,
    2
  )

  checkBuild(
    "explicit",
    """|/build.gradle
       |apply plugin: 'java'
       |/src/main/java/Example.java
       |public class Example {}
       |/src/test/java/ExampleSuite.java
       |public class ExampleSuite {}
       |/pom.xml
       |<hello/>
       |""".stripMargin,
    2,
    extraArguments = List("--build-tool", "gradle")
  )

  checkBuild(
    "build-command",
    """|/build.gradle
       |apply plugin: 'java'
       |/src/main/java/Example.java
       |public class Example {}
       |/src/test/java/ExampleSuite.java
       |public class ExampleSuite {}
       |""".stripMargin,
    1,
    extraArguments = List("--", "compileJava")
  )
}
