package tests

import java.nio.file.Files
import java.nio.file.StandardOpenOption

import munit.TestOptions

class GradleBuildToolSuite extends BaseBuildToolSuite {

  val Gradle8 = "8.1.1"
  val Gradle7 = "7.6.1"
  val Gradle67 = "6.7"

  val allGradle = List(Gradle8, Gradle7, Gradle67)
  val allJava = List("8", "11", "17")

  def gradleVersion(version: String): List[String] = {
    createEmptyBuildScript()
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

  def checkGradleBuild(
      title: TestOptions,
      setup: String,
      gradleVersions: List[String] = allGradle,
      expectedSemanticdbFiles: Int = 0,
      expectedPackages: String = "",
      extraArguments: List[String] = Nil
  ) = {
    gradleVersions.foreach { gradleV =>
      {
        val testName = title.withName(title.name + s"-gradle$gradleV")
        checkBuild(
          if (gradleV.startsWith("6."))
            testName.tag(Java8_Or_11)
          else
            testName,
          setup,
          expectedSemanticdbFiles = expectedSemanticdbFiles,
          expectedPackages = expectedPackages,
          initCommand = gradleVersion(gradleV),
          extraArguments = extraArguments
        )
      }
    }
  }

  List("latest" -> "implementation", "4.0" -> "compile").foreach {
    case (version, config) =>
      checkBuild(
        if (version == "latest")
          "basic-latest"
        else
          s"basic-$version".tag(Java8Only),
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
      s"legacy-$version".tag(Java8Only),
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

  allJava.foreach { java =>
    checkGradleBuild(
      if (java == "8")
        s"toolchains-$java".tag(Java8Only)
      else
        s"toolchains-$java",
      s"""|/build.gradle
          |apply plugin: 'java'
          |java {
          |  toolchain {
          |    languageVersion = JavaLanguageVersion.of($java)
          |  }
          |}
          |/src/main/java/Example.java
          |public class Example {}
          |""".stripMargin,
      expectedSemanticdbFiles = 1
    )
  }

  checkGradleBuild(
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
    expectedSemanticdbFiles = 2,
    extraArguments = List("--build-tool", "gradle")
  )

  checkGradleBuild(
    "build-command",
    """|/build.gradle
       |apply plugin: 'java'
       |/src/main/java/Example.java
       |public class Example {}
       |/src/test/java/ExampleSuite.java
       |public class ExampleSuite {}
       |""".stripMargin,
    expectedSemanticdbFiles = 1,
    extraArguments = List("--", "compileJava")
  )

  checkBuild(
    "playframework".tag(Java8Only),
    """|/build.gradle
       |plugins {
       |  id 'org.gradle.playframework' version '0.11'
       |  id 'idea'
       |}
       |
       |play {
       |  platform {
       |    playVersion = '2.6.7'
       |    scalaVersion = '2.12'
       |    javaVersion = JavaVersion.VERSION_1_8
       |  }
       |  injectedRoutesGenerator = true
       |}
       |dependencies {
       |  implementation "com.typesafe.play:play-guice_2.12:2.6.7"
       |}
       |
       |repositories {
       |  mavenCentral()
       |  maven {
       |    name "lightbend-maven-releases"
       |    url "https://repo.lightbend.com/lightbend/maven-release"
       |  }
       |  ivy {
       |    name "lightbend-ivy-release"
       |    url "https://repo.lightbend.com/lightbend/ivy-releases"
       |    layout "ivy"
       |  }
       |}
       |/app/controllers/HomeController.java
       |package controllers;
       |import play.mvc.*;
       |import views.html.*;
       |public class HomeController extends Controller {
       |    public Result index() {
       |        return ok(index.render("Your new application is ready."));
       |    }
       |}
       |/app/views/index.scala.html
       |@(message: String)
       |<h1>@message</h1>
       |/conf/routes
       |GET / controllers.HomeController.index
       |""".stripMargin,
    expectedSemanticdbFiles =
      2, // Two files because `conf/routes` generates a Java file.
    initCommand = gradleVersion("6.8")
  )

  checkBuild(
    "checkerframework".tag(Java8Only),
    """|/build.gradle
       |plugins {
       |    id 'java'
       |    id 'org.checkerframework' version '0.5.24'
       |}
       |repositories {
       |    mavenCentral()
       |}
       |java {
       |  toolchain {
       |    languageVersion = JavaLanguageVersion.of(8)
       |  }
       |}
       |/src/main/java/foo/Example.java
       |package foo;
       |public class Example {}
       |/src/test/java/foo/ExampleSuite.java
       |package foo;
       |public class ExampleSuite {}
       |""".stripMargin,
    2,
    initCommand = gradleVersion("6.8.3")
  )

  checkGradleBuild(
    s"scala",
    """|/build.gradle
       |plugins {
       |    id 'scala'
       |}
       |repositories {
       |    mavenCentral()
       |}
       |dependencies {
       |  implementation 'org.scala-lang:scala-library:2.12.12'
       |}
       |/src/main/java/foo/JExample.java
       |package foo;
       |public class JExample {}
       |/src/main/scala/foo/Example.scala
       |package foo
       |object Example {}
       |/src/test/java/foo/JExampleSuite.java
       |package foo;
       |public class JExampleSuite {}
       |/src/test/scala/foo/ExampleSuite.scala
       |package foo
       |class ExampleSuite {}
       |""".stripMargin,
    expectedSemanticdbFiles = 4
  )

  checkGradleBuild(
    "kotlin",
    """|/build.gradle
       |plugins {
       |    id 'org.jetbrains.kotlin.jvm' version '1.5.31'
       |}
       |repositories {
       |    mavenCentral()
       |}
       |/src/main/java/foo/JExample.java
       |package foo;
       |public class JExample {}
       |/src/main/kotlin/foo/Example.kt
       |package foo
       |object Example {}
       |/src/test/java/foo/JExampleSuite.java
       |package foo;
       |public class JExampleSuite {}
       |/src/test/kotlin/foo/ExampleSuite.kt
       |package foo
       |class ExampleSuite {}
       |""".stripMargin,
    expectedSemanticdbFiles = 4,
    gradleVersions = List(Gradle67, Gradle7)
  )

  checkGradleBuild(
    "implementation-deps",
    """|/settings.gradle
       |rootProject.name = 'marklogic-examples'
       |include('app')
       |/app/build.gradle
       |plugins {
       |    id 'java-library'
       |}
       |repositories {
       |    mavenCentral()
       |}
       |dependencies {
       |    implementation 'com.marklogic:marklogic-client-api:6.1.0'
       |}
       |/app/src/main/java/foo/Methods.java
       |package foo;
       |import com.marklogic.client.admin.MethodType;
       |public class Methods {
       |  MethodType foo;
       |}
       |""".stripMargin,
    expectedSemanticdbFiles = 1,
    expectedPackages =
      """|maven:com.fasterxml.jackson.core:jackson-annotations:2.14.1
         |maven:com.fasterxml.jackson.core:jackson-core:2.14.1
         |maven:com.fasterxml.jackson.core:jackson-databind:2.14.1
         |maven:com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.14.1
         |maven:com.marklogic:marklogic-client-api:6.1.0
         |maven:com.squareup.okhttp3:logging-interceptor:4.10.0
         |maven:com.squareup.okhttp3:okhttp:4.10.0
         |maven:com.squareup.okio:okio-jvm:3.0.0
         |maven:com.sun.mail:javax.mail:1.6.2
         |maven:io.github.rburgst:okhttp-digest:2.7
         |maven:javax.activation:activation:1.1
         |maven:javax.ws.rs:javax.ws.rs-api:2.1.1
         |maven:org.jetbrains.kotlin:kotlin-stdlib-common:1.6.20
         |maven:org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.6.10
         |maven:org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10
         |maven:org.jetbrains.kotlin:kotlin-stdlib:1.6.20
         |maven:org.jetbrains:annotations:13.0
         |maven:org.slf4j:slf4j-api:1.7.36
         |""".stripMargin
  )

  List("8", "11").foreach { java =>
    checkGradleBuild(
      s"kotlin-jvm-toolchains-jdk$java",
      s"""|/build.gradle
          |plugins {
          |    id 'java'
          |    id 'org.jetbrains.kotlin.jvm' version '1.5.31'
          |}
          |java {
          |  toolchain {
          |    languageVersion = JavaLanguageVersion.of($java)
          |  }
          |}
          |repositories { mavenCentral() }
          |/src/main/kotlin/foo/Example.kt
          |package foo
          |object Example {}
          |""".stripMargin,
      expectedSemanticdbFiles = 1,
      // Older Kotlin gradle plugins don't support Gradle 8:
      // https://youtrack.jetbrains.com/issue/KT-55704/Cannot-use-TaskAction-annotation-on-method-AbstractKotlinCompile.execute-error-while-using-Gradle-8.0-rc-with-KGP-1.5.32
      gradleVersions = List(Gradle67, Gradle7)
    )
  }

  List("jvm()" -> 2, "jvm { withJava() }" -> 4).foreach {
    case (jvmSettings, expectedSemanticdbFiles) =>
      checkGradleBuild(
        s"kotlin-multiplatform-$jvmSettings",
        s"""|/build.gradle
            |plugins {
            |    id 'org.jetbrains.kotlin.multiplatform' version '1.5.31'
            |}
            |repositories {
            |    mavenCentral()
            |}
            |kotlin {
            |  ${jvmSettings}
            |  sourceSets {
            |    jvmTest {
            |      dependencies {
            |        implementation kotlin("test-junit")
            |      }
            |    }
            |  }
            |}
            |/gradle.properties
            |kotlin.mpp.stability.nowarn=true
            |/src/jvmMain/java/foo/ExampleJ.java
            |package foo;
            |public class ExampleJ {} // ignored by multiplatform
            |/src/jvmMain/kotlin/foo/Example.kt
            |package foo
            |object Example {}
            |/src/jvmTest/java/foo/ExampleJSuite.java
            |package foo;
            |class ExampleJSuite {} // ignored by multiplatform
            |/src/commonTest/kotlin/foo/ExampleJvmSuite.kt
            |package foo
            |class ExampleJvmSuite {}
            |""".stripMargin,
        expectedSemanticdbFiles = expectedSemanticdbFiles,
        // Older Kotlin gradle plugins don't support Gradle 8:
        // https://youtrack.jetbrains.com/issue/KT-55704/Cannot-use-TaskAction-annotation-on-method-AbstractKotlinCompile.execute-error-while-using-Gradle-8.0-rc-with-KGP-1.5.32
        gradleVersions = List(Gradle67, Gradle7)
      )
  }
}
