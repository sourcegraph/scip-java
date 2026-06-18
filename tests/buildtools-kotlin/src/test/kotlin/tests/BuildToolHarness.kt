package tests

import com.sourcegraph.scip_java.CliEnvironment
import com.sourcegraph.scip_java.ScipJavaApp
import com.sourcegraph.scip_java.buildtools.ClasspathEntry
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.fail
import org.junit.jupiter.api.Assumptions.assumeTrue
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest

/** Minimum major version of the JVM on PATH required to run these tests. */
private const val MIN_EXTERNAL_JDK = 11

private val ANSI = Regex("\u001B\\[[;\\d]*m")

private fun stripAnsi(s: String): String = ANSI.replace(s, "")

/** Run an external command, inheriting stdio. Throws if it exits non-zero. */
internal fun exec(command: List<String>, cwd: Path) {
    val exit = ProcessBuilder(command).directory(cwd.toFile()).inheritIO().start().waitFor()
    check(exit == 0) { "Command failed ($exit): ${command.joinToString(" ")}" }
}

/** Run an external command and return its combined stdout/stderr. */
private fun execOutput(command: List<String>, cwd: Path): String {
    val process =
        ProcessBuilder(command).directory(cwd.toFile()).redirectErrorStream(true).start()
    val output = process.inputStream.readBytes().toString(StandardCharsets.UTF_8)
    val exit = process.waitFor()
    check(exit == 0) { "Command failed ($exit): ${command.joinToString(" ")}\n$output" }
    return output
}

/**
 * Major version of the JVM that `java` on PATH resolves to. Compiled and
 * executed as a subprocess because the test JVM may differ from PATH.
 */
internal val externalJavaVersion: Int by lazy {
    val tmp = Files.createTempDirectory("PrintJavaVersion")
    try {
        Files.writeString(
            tmp.resolve("PrintJavaVersion.java"),
            """
            public class PrintJavaVersion {
              public static void main(String[] args) {
                System.out.print(Runtime.version().feature());
              }
            }
            """.trimIndent(),
        )
        exec(listOf("javac", "PrintJavaVersion.java"), tmp)
        execOutput(listOf("java", "PrintJavaVersion"), tmp).trim().toInt()
    } finally {
        tmp.toFile().deleteRecursively()
    }
}

/**
 * Base class for build-tool integration tests. Each `check*` helper returns a
 * JUnit 5 [DynamicTest]; suites expose them from a `@TestFactory` method.
 */
abstract class BuildToolHarness {

    /** Run `scip-java` in-process with stdout/stderr redirected into a buffer. */
    private fun runScipJava(
        workingDirectory: Path,
        arguments: List<String>,
    ): Pair<Int, String> {
        val buffer = ByteArrayOutputStream()
        val stream = PrintStream(buffer, true, StandardCharsets.UTF_8.name())
        val app = ScipJavaApp()
        app.env =
            CliEnvironment(
                workingDirectory = workingDirectory,
                standardOutput = stream,
                standardError = stream,
            )
        val exit = app.run(arguments)
        return exit to stripAnsi(buffer.toString(StandardCharsets.UTF_8.name()))
    }

    private fun listScipShards(targetroot: Path): List<Path> {
        if (!Files.isDirectory(targetroot)) return emptyList()
        Files.walk(targetroot).use { stream ->
            return stream
                .filter { it.toString().endsWith(".scip") }
                .collect(Collectors.toList())
        }
    }

    /** Compare two strings ignoring trailing whitespace. */
    protected fun assertNoDiff(obtained: String, expected: String) {
        if (obtained.trimEnd() != expected.trimEnd()) {
            fail(
                "diff:\n--- obtained ---\n${obtained.trimEnd()}\n" +
                    "--- expected ---\n${expected.trimEnd()}",
            )
        }
    }

    protected fun checkBuild(
        name: String,
        original: String,
        expectedScipFiles: Int = 0,
        extraArguments: List<String> = emptyList(),
        expectedError: ((String) -> Unit)? = null,
        expectedPackages: String = "",
        initCommand: () -> List<String> = { emptyList() },
        prepare: (Path) -> Unit = {},
        targetRoot: String? = null,
        maxJdk: Int? = null,
    ): DynamicTest =
        dynamicTest(name) {
            val supported =
                externalJavaVersion >= MIN_EXTERNAL_JDK &&
                    (maxJdk == null || externalJavaVersion <= maxJdk)
            assumeTrue(
                supported,
                "Test $name ignored: external JDK $externalJavaVersion outside range " +
                    "[$MIN_EXTERNAL_JDK, ${maxJdk ?: "infinity"}]",
            )

            val base = Files.createTempDirectory("buildtools")
            try {
                val workingDirectory = Files.createDirectories(base.resolve("workingDirectory"))
                val cacheDirectory = Files.createDirectories(base.resolve("cache"))

                val init = initCommand()
                if (init.isNotEmpty()) exec(init, workingDirectory)

                FileLayout.fromString(original, workingDirectory)
                prepare(workingDirectory)

                val targetroot = workingDirectory.resolve(targetRoot ?: "targetroot")
                val arguments =
                    listOf(
                        "index",
                        "--temporary-directory",
                        cacheDirectory.toString(),
                        "--targetroot",
                        targetroot.toString(),
                    ) + extraArguments

                val (exit, output) = runScipJava(workingDirectory, arguments)

                if (expectedError != null) {
                    assertNotEquals(0, exit, "expected failure, output:\n$output")
                    expectedError(output)
                } else {
                    assertEquals(0, exit, "expected success, output:\n$output")
                }

                val shards = listScipShards(targetroot)
                if (shards.size != expectedScipFiles) {
                    fail(
                        "Expected $expectedScipFiles SCIP shard(s), got ${shards.size}: " +
                            "$shards\noutput:\n$output",
                    )
                }

                if (expectedPackages.isNotEmpty()) {
                    val obtained =
                        ClasspathEntry.fromTargetroot(targetroot, workingDirectory)
                            .map { it.mavenCoordinate() }
                            .sorted()
                            .distinct()
                            .joinToString("\n")
                    assertNoDiff(obtained, expectedPackages)
                }
            } finally {
                base.toFile().deleteRecursively()
            }
        }

    protected fun checkErrorOutput(
        name: String,
        arguments: List<String>,
        expectedOutput: String,
        workingDirectoryLayout: String = "",
    ): DynamicTest =
        dynamicTest(name) {
            val base = Files.createTempDirectory("buildtools")
            try {
                val workingDirectory = Files.createDirectories(base.resolve("workingDirectory"))
                if (workingDirectoryLayout.isNotEmpty()) {
                    FileLayout.fromString(workingDirectoryLayout, workingDirectory)
                }
                val (exit, rawOutput) = runScipJava(workingDirectory, arguments)
                val output = rawOutput.replace(base.toString(), "")
                assertEquals(1, exit, "output:\n$output")
                assertNoDiff(output, expectedOutput)
            } finally {
                base.toFile().deleteRecursively()
            }
        }
}
