package tests

import java.nio.file.Files
import java.nio.file.StandardOpenOption

class GradleBuildToolSuite extends BaseBuildToolSuite {

  def gradleVersion(version: String = ""): List[String] = {
    createEmptyBuildScript()
    if (version.isEmpty || version == "latest")
      List("gradle", "wrapper")
    else
      List("gradle", "wrapper", "--gradle-version", version)
  }

  def createEmptyBuildScript(): Unit = {
    val script = workingDirectory.resolve("build.gradle")
    Files.createDirectories(script.getParent)
    Files.write(
      script,
      Array.emptyByteArray,
      StandardOpenOption.TRUNCATE_EXISTING,
      StandardOpenOption.CREATE
    )
  }

  List("latest" -> "implementation", "4.0" -> "compile").foreach {
    case (version, config) =>
      checkBuild(
        s"basic-$version",
        s"""|/build.gradle
            |apply plugin: 'java'
            |repositories {
            |  mavenCentral()
            |}
            |dependencies {
            |  $config 'junit:junit:4.13.1'
            |}
            |/src/main/java/Example.java
            |import org.junit.Assert;
            |public class Example {}
            |/src/test/java/ExampleSuite.java
            |public class ExampleSuite {}
            |""".stripMargin,
        expectedSemanticdbFiles = 2,
        expectedPackages =
          """|maven:junit:junit:4.13.1
             |maven:org.hamcrest:hamcrest-core:1.3
             |""".stripMargin,
        initCommand = {
          gradleVersion(version)
        }
      )
  }

  List("3.3", "2.2.1").foreach { version =>
    checkBuild(
      s"legacy-$version",
      s"""|/build.gradle
          |apply plugin: 'java'
          |/src/main/java/Example.java
          |public class Example {}
          |/src/test/java/ExampleSuite.java
          |public class ExampleSuite {}
          |""".stripMargin,
      expectedSemanticdbFiles = 2,
      initCommand = gradleVersion(version)
      // NOTE(olafur): no packages because we use more modern APIs.
    )
  }

  checkBuild(
    "toolchains-latest",
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
    "toolchains-6.7",
    """|/build.gradle
       |apply plugin: 'java'
       |java {
       |  toolchain {
       |    languageVersion = JavaLanguageVersion.of(8)
       |  }
       |}
       |/src/main/java/Example.java
       |public class Example {}
       |""".stripMargin,
    expectedError =
      """|info: /workingDirectory/gradlew --init-script /cache/java-toolchains.gradle lsifDetectJavaToolchains
         |error: lsif-java does not support Gradle 6.7 when used together with Java toolchains. To fix this problem, upgrade to Gradle version 6.8 or newer and try again.
         |""".stripMargin,
    initCommand = gradleVersion("6.7")
  )

  checkBuild(
    "toolchains-6.8",
    """|/build.gradle
       |apply plugin: 'java'
       |java {
       |  toolchain {
       |    languageVersion = JavaLanguageVersion.of(8)
       |  }
       |}
       |/src/main/java/Example.java
       |public class Example {}
       |""".stripMargin,
    expectedSemanticdbFiles = 1,
    initCommand = gradleVersion("6.8")
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
