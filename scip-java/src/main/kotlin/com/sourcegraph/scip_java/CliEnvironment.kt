package com.sourcegraph.scip_java

import com.sourcegraph.io.AbsolutePath
import java.io.PrintStream
import java.nio.file.Path

/**
 * Captures the per-invocation environment of a scip-java CLI run.
 *
 * Tests inject a custom environment to redirect stdout/stderr into a
 * byte buffer, point the working directory at a temporary fixture
 * directory, and so on.
 */
data class CliEnvironment(
    val workingDirectory: Path = AbsolutePath.systemWorkingDirectory(),
    val environmentVariables: Map<String, String> = System.getenv(),
    val standardOutput: PrintStream = System.out,
    val standardError: PrintStream = System.err,
    val isProgressBarEnabled: Boolean = System.console() != null,
) {
    fun withWorkingDirectory(cwd: Path): CliEnvironment = copy(workingDirectory = cwd)

    fun withStandardOutput(out: PrintStream): CliEnvironment = copy(standardOutput = out)

    fun withStandardError(err: PrintStream): CliEnvironment = copy(standardError = err)

    fun withEnvironmentVariables(vars: Map<String, String>): CliEnvironment =
        copy(environmentVariables = vars)
}
