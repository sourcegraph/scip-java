package tests

import java.nio.file.Files
import java.nio.file.StandardOpenOption
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

private const val GRADLE_VERSION = "8.10"

// Gradle 8.10 runs on JDK 8 through 21.
// See https://docs.gradle.org/current/userguide/compatibility.html
private const val GRADLE_MAX_JDK = 21

class GradleBuildToolTest : BuildToolHarness() {

    private fun checkGradleBuild(
        name: String,
        setup: String,
        expectedScipFiles: Int = 0,
        expectedPackages: String = "",
        extraArguments: List<String> = emptyList(),
    ): DynamicTest =
        checkBuild(
            "$name-gradle-$GRADLE_VERSION",
            setup,
            expectedScipFiles = expectedScipFiles,
            expectedPackages = expectedPackages,
            extraArguments = extraArguments,
            initCommand = { workingDirectory ->
                // Gradle needs a build script present to generate the wrapper;
                // the real one is laid down afterwards by FileLayout.
                val script = workingDirectory.resolve("build.gradle")
                Files.createDirectories(script.parent)
                Files.write(
                    script,
                    ByteArray(0),
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.CREATE,
                )
                listOf("gradle", "wrapper", "--gradle-version", GRADLE_VERSION)
            },
            maxJdk = GRADLE_MAX_JDK,
        )

    @TestFactory
    fun tests(): List<DynamicTest> =
        buildList {
            add(
                checkGradleBuild(
                    "annotation-path",
                    """
                    |/build.gradle
                    |plugins {
                    |    id 'java'
                    |}
                    |repositories {
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
                    |""".trimMargin(),
                    // An immutable version is generated alongside the original class,
                    // so two SCIP shards are produced.
                    expectedScipFiles = 2,
                ),
            )
            add(
                checkGradleBuild(
                    "build-with-Werror",
                    """
                    |/build.gradle
                    |plugins {
                    |    id 'java-library'
                    |}
                    |repositories {
                    |    mavenCentral()
                    |}
                    |dependencies {
                    |  compileOnly 'org.immutables:value:2.9.2'
                    |  annotationProcessor 'org.immutables:value:2.9.2'
                    |}
                    |compileJava {
                    | options.compilerArgs << "-Werror"
                    |}
                    |/src/main/java/main/bla/ExampleClass.java
                    |package test;
                    |import org.immutables.value.Value;
                    |import java.util.Optional;
                    |@Value.Immutable
                    |public abstract class ExampleClass {
                    |    public abstract Optional<String> getWorkflowIdReusePolicy();
                    |}
                    |""".trimMargin(),
                    expectedScipFiles = 2,
                ),
            )
            add(
                checkGradleBuild(
                    "publishing",
                    """
                    |/build.gradle
                    |plugins {
                    |    id 'java'
                    |    id 'maven-publish'
                    |}
                    |repositories {
                    |    mavenCentral()
                    |}
                    |publishing {
                    |    publications {
                    |        maven(MavenPublication) {
                    |            groupId = 'com.sourcegraph'
                    |            artifactId = 'example-library'
                    |            version = '1.1'
                    |        }
                    |    }
                    |}
                    |/src/main/java/test/ExampleClass.java
                    |package test;
                    |public abstract class ExampleClass {}
                    |""".trimMargin(),
                    expectedScipFiles = 1,
                    expectedPackages = "maven:com.sourcegraph:example-library:1.1",
                ),
            )
            add(
                checkGradleBuild(
                    "basic",
                    """
                    |/build.gradle
                    |plugins {
                    |    id 'application'
                    |    id 'java'
                    |}
                    |repositories {
                    |    mavenCentral()
                    |}
                    |dependencies {
                    |    implementation 'com.google.guava:guava:31.1-jre'
                    |    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
                    |    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
                    |}
                    |test {
                    |    useJUnitPlatform()
                    |}
                    |/src/main/java/App.java
                    |package gradle.sample.project;
                    |public class App {
                    |    public String getGreeting() {
                    |        return "Hello World!";
                    |    }
                    |    public static void main(String[] args) {
                    |        System.out.println(new App().getGreeting());
                    |    }
                    |}
                    |/src/test/java/AppTest.java
                    |package gradle.sample.project;
                    |import org.junit.jupiter.api.Test;
                    |import static org.junit.jupiter.api.Assertions.assertNotNull;
                    |public class AppTest {
                    |    @Test public void appHasAGreeting() {
                    |        App classUnderTest = new App();
                    |        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
                    |    }
                    |}
                    |""".trimMargin(),
                    expectedScipFiles = 2,
                ),
            )
            for (java in listOf(11, 17, 21)) {
                add(
                    checkGradleBuild(
                        "toolchains-$java",
                        """
                        |/build.gradle
                        |apply plugin: 'java'
                        |java {
                        |  toolchain {
                        |    languageVersion = JavaLanguageVersion.of($java)
                        |  }
                        |}
                        |/src/main/java/Example.java
                        |public class Example {}
                        |""".trimMargin(),
                        expectedScipFiles = 1,
                    ),
                )
            }
            add(
                checkGradleBuild(
                    "protobuf-generator",
                    """
                    |/build.gradle
                    |plugins {
                    |  id "java"
                    |  id "com.google.protobuf" version "0.9.4"
                    |}
                    |dependencies {
                    |  implementation 'com.google.protobuf:protobuf-javalite:3.8.0'
                    |}
                    |protobuf {
                    |  protoc {
                    |    artifact = 'com.google.protobuf:protoc:3.23.4'
                    |  }
                    |  generateProtoTasks {
                    |    all().configureEach { task ->
                    |      task.builtins {
                    |        java {
                    |          option "lite"
                    |        }
                    |      }
                    |    }
                    |  }
                    |}
                    |/src/main/proto/message.proto
                    |syntax = "proto3";
                    |message SearchRequest {
                    |  string query = 1;
                    |  int32 page_number = 2;
                    |  int32 results_per_page = 3;
                    |}
                    |/src/main/java/Example.java
                    |public class Example {}
                    |""".trimMargin(),
                    expectedScipFiles = 2,
                ),
            )
            add(
                checkGradleBuild(
                    "explicit",
                    """
                    |/build.gradle
                    |apply plugin: 'java'
                    |/src/main/java/Example.java
                    |public class Example {}
                    |/src/test/java/ExampleSuite.java
                    |public class ExampleSuite {}
                    |/pom.xml
                    |<hello/>
                    |""".trimMargin(),
                    expectedScipFiles = 2,
                    extraArguments = listOf("--build-tool", "gradle"),
                ),
            )
            add(
                checkGradleBuild(
                    "build-command",
                    """
                    |/build.gradle
                    |apply plugin: 'java'
                    |/src/main/java/Example.java
                    |public class Example {}
                    |/src/test/java/ExampleSuite.java
                    |public class ExampleSuite {}
                    |""".trimMargin(),
                    expectedScipFiles = 1,
                    extraArguments = listOf("--", "compileJava"),
                ),
            )
            add(
                checkGradleBuild(
                    "kotlin2",
                    """
                    |/build.gradle
                    |plugins {
                    |    id 'org.jetbrains.kotlin.jvm' version '2.2.0'
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
                    |""".trimMargin(),
                    expectedScipFiles = 4,
                ),
            )
            add(
                checkGradleBuild(
                    "implementation-deps",
                    """
                    |/settings.gradle
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
                    |""".trimMargin(),
                    expectedScipFiles = 1,
                    expectedPackages =
                        """
                        |maven:com.fasterxml.jackson.core:jackson-annotations:2.14.1
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
                        |""".trimMargin(),
                ),
            )
            for (java in listOf(11, 17)) {
                add(
                    checkGradleBuild(
                        "kotlin-jvm-toolchains-jdk$java",
                        """
                        |/build.gradle
                        |plugins {
                        |    id 'java'
                        |    id 'org.jetbrains.kotlin.jvm' version '2.2.0'
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
                        |""".trimMargin(),
                        expectedScipFiles = 1,
                    ),
                )
            }
            // Regression test: projects that lazily register custom source sets (e.g.
            // intTest) with a Java toolchain used to fail because the eager `.all {}`
            // API finalized the javaCompiler property before Gradle finished
            // configuring the task.
            add(
                checkGradleBuild(
                    "lazy-sourceset-with-toolchain",
                    """
                    |/build.gradle
                    |plugins {
                    |    id 'java'
                    |}
                    |java {
                    |  toolchain {
                    |    languageVersion = JavaLanguageVersion.of(11)
                    |  }
                    |}
                    |sourceSets {
                    |  intTest {
                    |    compileClasspath += sourceSets.main.output
                    |    runtimeClasspath += sourceSets.main.output
                    |  }
                    |}
                    |configurations {
                    |  intTestImplementation.extendsFrom implementation
                    |}
                    |/src/main/java/Example.java
                    |public class Example {}
                    |/src/intTest/java/ExampleIntTest.java
                    |public class ExampleIntTest {}
                    |""".trimMargin(),
                    expectedScipFiles = 1,
                ),
            )
        }
}
