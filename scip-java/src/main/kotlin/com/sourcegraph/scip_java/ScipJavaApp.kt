package com.sourcegraph.scip_java

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.CliktError
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.PrintHelpMessage
import com.github.ajalt.clikt.core.PrintMessage
import com.github.ajalt.clikt.core.ProgramResult
import com.github.ajalt.clikt.core.UsageError
import com.github.ajalt.clikt.core.findOrSetObject
import com.github.ajalt.clikt.core.parse
import com.github.ajalt.clikt.core.subcommands
import com.sourcegraph.scip_java.buildtools.ProcessResult
import com.sourcegraph.scip_java.buildtools.ProcessRunner
import com.sourcegraph.scip_java.commands.IndexCommand
import com.sourcegraph.scip_java.commands.AggregateCommand
import com.sourcegraph.scip_java.commands.SnapshotCommand
import java.io.PrintStream
import java.nio.file.Paths

/**
 * Stateful, mutable container for the scip-java CLI runtime. Tests inject
 * a fresh environment (with redirected stdout/stderr, a temp working
 * directory, etc.) before invoking [run].
 *
 * Each invocation of [run] builds a fresh root clikt command tree so option
 * state from a previous run never leaks into the next one.
 */
class ScipJavaApp {

    var env: CliEnvironment = CliEnvironment()
        set(value) {
            field = value
            // Rebind the reporter so subsequent writes hit the new
            // PrintStreams. Test harnesses swap [env] between invocations.
            currentReporter = CliReporter(value)
        }

    private var currentReporter: CliReporter = CliReporter(env)

    val reporter: CliReporter
        get() = currentReporter

    val out: PrintStream
        get() = env.standardOutput

    val err: PrintStream
        get() = env.standardError

    fun info(message: String) = reporter.info(message)

    fun warning(message: String) = reporter.warning(message)

    fun error(message: String) = reporter.error(message)

    /**
     * Spawn an external process using the current working directory.
     * Stdout and stderr are streamed to the env's PrintStreams line-by-line.
     */
    fun runProcess(
        command: List<String>,
        env: Map<String, String> = emptyMap(),
    ): ProcessResult {
        val syntax = command.joinToString(" ") { if (' ' in it) "'$it'" else it }
        this.env.standardOutput.println("$ $syntax")
        return ProcessRunner.run(
            command,
            cwd = this.env.workingDirectory,
            env = env,
            onStdout = { this.env.standardOutput.println(it) },
            onStderr = { this.env.standardError.println(it) },
        )
    }

    fun run(args: List<String>): Int {
        reporter.reset()
        val processedArgs = applyGlobalCwd(rewriteNestedOptions(args))
        val root = RootCommand(this)
        root.subcommands(IndexCommand(), AggregateCommand(), SnapshotCommand())
        return try {
            root.parse(processedArgs)
            reporter.exitCode()
        } catch (e: PrintHelpMessage) {
            env.standardOutput.println(root.getFormattedHelp(e))
            e.statusCode
        } catch (e: PrintMessage) {
            env.standardOutput.println(e.message)
            e.statusCode
        } catch (e: ProgramResult) {
            e.statusCode
        } catch (e: UsageError) {
            env.standardError.println(root.getFormattedHelp(e))
            e.statusCode
        } catch (e: CliktError) {
            e.message?.let { env.standardError.println(it) }
            e.statusCode
        }
    }

    /** Terminate the JVM with the exit code returned by [run]. */
    fun runAndExitIfNonZero(args: List<String>) {
        val exit = run(args)
        if (exit != 0) kotlin.system.exitProcess(exit)
    }

    /**
     * The previous moped CLI accepted nested subcommand options written as
     * `--aggregate.<flag>` on `scip-java index` (e.g. the Bazel aspect
     * passes `--aggregate.allow-empty-index`). clikt forbids `.` in
     * option names, so we rewrite the dotted prefix to a `-` separator to match
     * the options declared on [IndexCommand]. Tokens after a `--` separator are
     * left untouched.
     */
    private fun rewriteNestedOptions(args: List<String>): List<String> {
        var sawDoubleDash = false
        return args.map { arg ->
            when {
                sawDoubleDash -> arg
                arg == "--" -> {
                    sawDoubleDash = true
                    arg
                }
                arg.startsWith("--aggregate.") ->
                    "--aggregate-" + arg.removePrefix("--aggregate.")
                else -> arg
            }
        }
    }

    /**
     * `--cwd` is a global flag that, unlike a regular clikt parent option, may
     * appear in any position (including after the subcommand name), mirroring
     * the previous moped-based CLI where `--cwd` was an application-level
     * parameter. We extract it here before handing the remaining arguments to
     * clikt, and apply it to the working directory. Tokens after a `--`
     * separator are passed through untouched so a trailing build command can
     * legitimately contain `--cwd`.
     */
    private fun applyGlobalCwd(args: List<String>): List<String> {
        val result = ArrayList<String>(args.size)
        var cwd: String? = null
        var sawDoubleDash = false
        var i = 0
        while (i < args.size) {
            val arg = args[i]
            when {
                sawDoubleDash -> {
                    result.add(arg)
                    i += 1
                }
                arg == "--" -> {
                    sawDoubleDash = true
                    result.add(arg)
                    i += 1
                }
                arg == "--cwd" && i + 1 < args.size -> {
                    cwd = args[i + 1]
                    i += 2
                }
                arg.startsWith("--cwd=") -> {
                    cwd = arg.removePrefix("--cwd=")
                    i += 1
                }
                else -> {
                    result.add(arg)
                    i += 1
                }
            }
        }
        cwd?.let { env = env.withWorkingDirectory(Paths.get(it).toAbsolutePath()) }
        return result
    }

    /**
     * Root clikt command that plumbs the parent [ScipJavaApp] into the
     * clikt context so subcommands can pick it up via
     * `currentContext.findObject`.
     */
    private class RootCommand(val app: ScipJavaApp) : CliktCommand(name = "scip-java") {

        override fun help(context: Context) =
            "scip-java: index Java/Kotlin codebases into SCIP."

        private val sharedApp by findOrSetObject { app }

        override fun run() {
            // Touch sharedApp so the context object is set even when no subcommand uses it.
            @Suppress("UNUSED_VARIABLE") val ignored = sharedApp
        }
    }
}
