package tests

import tests.GradleBuildToolSuite._

class Gradle_8_BuildToolSuite extends GradleBuildToolSuite(List(Gradle8))
class Gradle_7_BuildToolSuite extends GradleBuildToolSuite(List(Gradle7))
class Gradle_6_BuildToolSuite extends GradleBuildToolSuite(List(Gradle67))
class Gradle_5_BuildToolSuite extends GradleBuildToolSuite(List(Gradle5))

object GradleBuildToolSuite {
  val Gradle8 = "8.1.1"
  val Gradle7 = "7.6.1"
  val Gradle67 = "6.7" // Introduced toolchains
  val Gradle5 = "5.6.4"
}

abstract class GradleBuildToolSuite(allGradle: List[String])
    extends GradleBuildToolSuiteBase(allGradle) {
  val allJava = List("8", "11", "17")

  checkGradleBuild(
    "annotation-path",
    """|/build.gradle
       |plugins {
       |    id 'java'
       |}
       |repositories {
       |    // Use Maven Central for resolving dependencies.
       |    mavenCentral()
       |}
       |dependencies {
       |  compileOnly 'org.immutables:value:2.9.2'
       |  annotationProcessor 'org.immutables:value:2.9.2'
       |}
       |/src/main/java/WorkflowOptions.java
       |package test;
       |import org.immutables.value.Value;
       |import java.util.Optional;
       |@Value.Immutable
       |public abstract class WorkflowOptions {
       |    public abstract Optional<String> getWorkflowIdReusePolicy();
       |}
    """.stripMargin,
    /*
    An immutable version will be generated along with the original class:
    - build/generated/sources/annotationProcessor/java/main/test/ImmutableWorkflowOptions.java.semanticdb
    - /META-INF/semanticdb/src/main/java/WorkflowOptions.java.semanticdb
     */
    expectedSemanticdbFiles = 2,
    gradleVersions = List(Gradle8, Gradle7, Gradle67)
  )

  // This is the most basic test for Java/Scala support
  // We run it for an extended list of Gradle versions
  checkGradleBuild(
    "basic",
    """|/build.gradle
       |plugins {
       |    // Apply the application plugin to add support for building a CLI application in Java.
       |    id 'application'
       |    id 'java'
       |    id 'scala'
       |}

       |repositories {
       |    // Use Maven Central for resolving dependencies.
       |    mavenCentral()
       |}

       |dependencies {
       |    // This dependency is used by the application.
       |    implementation 'com.google.guava:guava:31.1-jre'
       |    implementation 'org.scala-lang:scala-library:2.13.8'
       |    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
       |    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
       |}

       |test {
       |    useJUnitPlatform()
       |}
       |/src/main/java/App.java
       | package gradle.sample.project;
       | public class App {
       |     public String getGreeting() {
       |         return "Hello World!";
       |     }
       |     public static void main(String[] args) {
       |         System.out.println(new App().getGreeting());
       |     }
       | }
       |/src/test/java/AppTest.java
       | package gradle.sample.project;
       | import org.junit.jupiter.api.Test;
       | import static org.junit.jupiter.api.Assertions.assertEquals;
       | import static org.junit.jupiter.api.Assertions.assertNotNull;
       | public class AppTest {
       |     @Test public void appHasAGreeting() {
       |         App classUnderTest = new App();
       |         assertNotNull("app should have a greeting", classUnderTest.getGreeting());
       |     }
       | }
       |/src/main/scala/Howdy.scala
       |case class Howdy(a: Int)
       |""".stripMargin,
    expectedSemanticdbFiles = 3,
    // Only add this test on Gradle 5 in the gradle 6 suite
    gradleVersions = List(Gradle8, Gradle7, Gradle67, Gradle5)
  )

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
      expectedSemanticdbFiles = 1,
      gradleVersions = List(Gradle8, Gradle7, Gradle67)
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
    extraArguments = List("--build-tool", "gradle"),
    gradleVersions = List(Gradle8, Gradle7, Gradle67)
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
    extraArguments = List("--", "compileJava"),
    gradleVersions = List(Gradle8, Gradle7, Gradle67)
  )

  checkGradleBuild(
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
    gradleVersions = List(Gradle67)
  )

  checkGradleBuild(
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
    expectedSemanticdbFiles = 2,
    gradleVersions = List(Gradle67)
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
    expectedSemanticdbFiles = 4,
    gradleVersions = List(Gradle8, Gradle7, Gradle67)
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
         |""".stripMargin,
    gradleVersions = List(Gradle8, Gradle7, Gradle67)
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
