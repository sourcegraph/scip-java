package tests

import java.nio.file.Files
import kotlin.test.assertTrue
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class ScipBuildToolTest : BuildToolHarness() {

    @TestFactory
    fun tests(): List<DynamicTest> =
        listOf(
            checkBuild(
                "rejects-dependencies-field",
                """
                |/lsif-java.json
                |{"dependencies": ["junit:junit:4.13.1"]}
                |/foo/Example.java
                |package foo;
                |public class Example {}
                |""".trimMargin(),
                expectedError = { output ->
                    assertTrue(
                        output.contains(
                            "scip-java no longer resolves Maven coordinates from " +
                                "the 'dependencies' field",
                        ),
                        "output: $output",
                    )
                },
            ),
            checkBuild(
                "compiles-with-empty-classpath",
                """
                |/lsif-java.json
                |{}
                |/foo/Example.java
                |package foo;
                |public class Example {}
                |/foo/Example2.java
                |package foo;
                |public class Example2 {}
                |""".trimMargin(),
                expectedScipFiles = 2,
            ),
            checkBuild(
                "compiles-with-classpath",
                """
                |/lsif-java.json
                |{"classpath": ["lib-classes"]}
                |/foo/Example.java
                |package foo;
                |import bar.Greeter;
                |public class Example {
                |  public String hello() { return new Greeter().greet(); }
                |}
                |""".trimMargin(),
                expectedScipFiles = 1,
                prepare = { workingDirectory ->
                    val libSrcDir = Files.createTempDirectory("scip-classpath-lib")
                    val libSrc = libSrcDir.resolve("bar").resolve("Greeter.java")
                    Files.createDirectories(libSrc.parent)
                    Files.writeString(
                        libSrc,
                        """
                        |package bar;
                        |public class Greeter {
                        |  public String greet() { return "hi"; }
                        |}
                        |""".trimMargin(),
                    )
                    val libClasses = workingDirectory.resolve("lib-classes")
                    Files.createDirectories(libClasses)
                    exec(
                        listOf("javac", "-d", libClasses.toString(), libSrc.toString()),
                        libSrcDir,
                    )
                },
            ),
        )
}
