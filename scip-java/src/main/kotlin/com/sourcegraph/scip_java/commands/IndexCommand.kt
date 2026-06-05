package com.sourcegraph.scip_java.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.ProgramResult
import com.github.ajalt.clikt.core.requireObject
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.multiple
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.multiple
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.path
import com.sourcegraph.scip_java.ScipJavaApp
import com.sourcegraph.scip_java.buildtools.BuildTool
import com.sourcegraph.scip_java.buildtools.ScipBuildTool
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.math.abs
import kotlin.math.min

/**
 * `scip-java index`: detects a build tool in the current working directory
 * and shells out to it (Maven/Gradle/Bazel/scip-java.json) to produce a
 * SCIP index in `index.scip`.
 *
 * The public API surface (in particular all the fields read by the
 * per-build-tool implementations) mirrors the old Scala `IndexCommand`
 * so the per-build-tool logic ports straight over.
 */
class IndexCommand : CliktCommand(name = "index") {

    override fun help(context: com.github.ajalt.clikt.core.Context): String =
        "Automatically generate an SCIP index in the current working directory."

    /**
     * Resolved from the clikt context (set by the root command) at run-time.
     * Build-tool helpers that construct an `IndexCommand` outside of a clikt
     * parse flow can assign [app] directly via [withApp].
     */
    private val sharedApp by requireObject<ScipJavaApp>()
    private var explicitApp: ScipJavaApp? = null

    val app: ScipJavaApp
        get() = explicitApp ?: runCatching { sharedApp }.getOrElse {
            // No clikt context (e.g. someone constructed `IndexCommand()` to
            // enumerate build tool names). Fall back to a fresh app so calls
            // that only touch `.name` / `.isHidden` don't crash.
            ScipJavaApp().also { explicitApp = it }
        }

    fun withApp(app: ScipJavaApp): IndexCommand {
        explicitApp = app
        return this
    }

    val output: Path by option(
        "--output",
        help = "The path where to generate the SCIP index.",
    ).path().default(Paths.get("index.scip"))

    val targetroot: Path? by option(
        "--targetroot",
        help =
            "The directory where to generate SCIP files. Defaults to a build-specific path. " +
                "For example, the default value for Gradle is 'build/scip-targetroot' " +
                "and for Maven it's 'target/scip-targetroot'.",
    ).path()

    val buildTool: String? by option(
        "--build-tool",
        help =
            "Explicitly specify which build tool to use. By default, the build tool is automatically detected. " +
                "Use this flag if the automatic build tool detection is not working correctly.",
        metavar = "Gradle",
    )

    val cleanup: Boolean by option(
        "--cleanup",
        "--no-cleanup",
        help = "Whether to remove generated temporary files on exit.",
    ).flag("--no-cleanup", default = true)

    val temporaryDirectory: Path? by option(
        "--temporary-directory",
        hidden = true,
    ).path()

    val scipIgnoredJavacOptionPrefixes: List<String> by option(
        "--scip-ignored-javac-option-prefixes",
        help =
            "List of Java compiler option prefixes that should be excluded from compilation during indexing. " +
                "This flag is only used when indexing via scip-java.json files or Bazel.",
    ).multiple()

    val scipIgnoredAnnotationProcessors: List<String> by option(
        "--scip-ignored-annotation-processors",
        help =
            "List of fully qualified annotation processors that should be ignored when indexing a codebase. " +
                "This flag is only used when indexing via scip-java.json files or Bazel.",
    ).multiple()

    val scipConfig: Path? by option(
        "--scip-config",
        help = "Path to a scip-java.json file with build configuration. By default, the path scip-java.json is used.",
    ).path()

    val bazelScipJavaBinary: String? by option(
        "--bazel-scip-java-binary",
        help = "Optional path to a `scip-java` binary. Required to index a Bazel codebase.",
    )

    val bazelAspect: Path by option(
        "--bazel-aspect",
        help = "Relative path to a Bazel aspect file with an aspect named 'scip_java_aspect'.",
    ).path().default(Paths.get("aspects/scip_java.bzl"))

    val bazelOverwriteAspectFile: Boolean by option(
        "--bazel-overwrite-aspect-file",
        help = "If true, overwrites the existing Bazel aspect file (if any).",
    ).flag()

    val bazelAutorunSandboxCommand: Boolean by option(
        "--bazel-autorun-sandbox-command",
        "--no-bazel-autorun-sandbox-command",
        help =
            "If true, automatically tries to extract the printed out sandbox command " +
                "and re-run the command to reveal the underlying problem.",
    ).flag("--no-bazel-autorun-sandbox-command", default = true)

    val strictCompilation: Boolean by option(
        "--strict-compilation",
        hidden = true,
        help = "Fail command invocation if compiler produces any errors.",
    ).flag()

    val buildCommand: List<String> by argument(
        help = "Optional. The build command to use to compile all sources. Defaults to a build-specific command.",
    ).multiple()

    // Forwarded options for the embedded `aggregate` step. The previous
    // moped CLI exposed the nested `aggregate` command's flags on
    // `scip-java index` using the `--aggregate.<flag>` naming (e.g. the
    // Bazel aspect passes `--aggregate.allow-empty-index`). clikt forbids
    // `.` in option names, so these are registered with a `-` separator and the
    // dotted form is rewritten to it during argument preprocessing
    // (ScipJavaApp.run). Consumed by BuildTool.generateScipFromTargetroot.
    val aggregateParallel: Boolean by option(
        "--aggregate-parallel",
        "--aggregate-no-parallel",
        hidden = true,
    ).flag("--aggregate-no-parallel", default = true)

    val aggregateEmitInverseRelationships: Boolean by option(
        "--aggregate-emit-inverse-relationships",
        "--aggregate-no-emit-inverse-relationships",
        hidden = true,
    ).flag("--aggregate-no-emit-inverse-relationships", default = true)

    val aggregateAllowEmptyIndex: Boolean by option(
        "--aggregate-allow-empty-index",
        hidden = true,
    ).flag()

    val aggregateAllowExportingGlobalSymbolsFromDirectoryEntries: Boolean by option(
        "--aggregate-allow-exporting-global-symbols-from-directory-entries",
        "--aggregate-no-allow-exporting-global-symbols-from-directory-entries",
        hidden = true,
    ).flag(
        "--aggregate-no-allow-exporting-global-symbols-from-directory-entries",
        default = true,
    )

    val workingDirectory: Path
        get() = app.env.workingDirectory.toAbsolutePath()

    fun finalTargetroot(default: Path): Path =
        workingDirectory.resolve(targetroot ?: default)

    val finalOutput: Path
        get() = workingDirectory.resolve(output)

    fun finalBuildCommand(default: List<String>): List<String> =
        if (buildCommand.isEmpty()) default else buildCommand

    override fun run() {
        val exit = doRun()
        if (exit != 0) throw ProgramResult(exit)
    }

    fun doRun(): Int {
        val allBuildTools = BuildTool.all(this)
        val usedBuildTools = allBuildTools.filter { it.usedInCurrentDirectory() }
        val matchingBuildTools =
            usedBuildTools.filter { tool ->
                val name = buildTool
                name == null || tool.name.compareTo(name, ignoreCase = true) == 0
            }

        val name = buildTool
        if (name != null && name.equals("auto", ignoreCase = true)) {
            return runAutoBuildTool()
        }

        return when (matchingBuildTools.size) {
            0 -> unknownBuildTool(buildTool, usedBuildTools)
            1 -> matchingBuildTools[0].generateScip()
            else -> {
                val first = matchingBuildTools[0]
                if (first is ScipBuildTool && scipConfig != null) {
                    first.generateScip()
                } else {
                    val names = matchingBuildTools.joinToString(", ") { it.name }
                    app.error(
                        "Multiple build tools detected: $names. " +
                            "To fix this problem, use the '--build-tool=BUILD_TOOL_NAME' flag to specify which build tool to run.",
                    )
                    1
                }
            }
        }
    }

    private fun unknownBuildTool(explicit: String?, usedBuildTools: List<BuildTool>): Int {
        if (explicit != null && usedBuildTools.isNotEmpty()) {
            val toFix =
                closestCandidate(explicit, usedBuildTools.map { it.name })
                    ?.let { "Did you mean --build-tool=$it?" }
                    ?: "To fix this problem, run again with the --build-tool flag set to one of the detected build tools."
            val autoDetected = usedBuildTools.joinToString(", ") { it.name }
            app.error(
                "Automatically detected the build tool(s) $autoDetected but none of them match the explicitly provided flag '--build-tool=$explicit'. " +
                    toFix,
            )
        } else {
            if (Files.isDirectory(workingDirectory)) {
                app.error(
                    "No build tool detected in workspace '$workingDirectory'. " +
                        "At the moment, the only supported build tools are: ${BuildTool.allNames()}.",
                )
            } else {
                val cause =
                    if (Files.exists(workingDirectory)) "Workspace '$workingDirectory' is not a directory"
                    else "The directory '$workingDirectory' does not exist"
                app.error("$cause. To fix this problem, make sure the working directory is an actual directory.")
            }
        }
        return 1
    }

    private fun runAutoBuildTool(): Int {
        val usedInOrder = BuildTool.autoOrdered(this).filter { it.usedInCurrentDirectory() }
        if (usedInOrder.isEmpty()) {
            app.error("Build tool mode set to `auto`, but no supported build tools were detected")
            return 1
        }
        val first = usedInOrder.first()
        val rest = usedInOrder.drop(1)
        val restMessage =
            if (rest.isEmpty()) ""
            else rest.joinToString(
                ", ",
                prefix = ", other tools that were detected:  [",
                postfix = "]",
            ) { it.name }
        app.info("Auto mode: `${first.name}` will be used in this workspace$restMessage")
        return first.generateScip()
    }

    /**
     * Port of `moped.internal.reporters.Levenshtein.closestCandidate`. Returns
     * the nearest candidate only when it is "close enough" (normalized edit
     * distance ratio below 0.4); otherwise no suggestion is offered.
     */
    private fun closestCandidate(query: String, candidates: List<String>): String? {
        if (candidates.isEmpty()) return null
        val candidate = candidates.minByOrNull { levenshtein(query, it) } ?: return null
        val minDifference = abs(query.length - candidate.length)
        val difference = levenshtein(candidate, query).toDouble() - minDifference
        val ratio = difference / min(query.length, candidate.length)
        return if (ratio < 0.4) candidate else null
    }

    /**
     * Port of `moped.internal.reporters.Levenshtein.distance`: the raw
     * Levenshtein edit distance minus the absolute length difference of the
     * two strings.
     */
    private fun levenshtein(s1: String, s2: String): Int {
        val m = s1.length
        val n = s2.length
        val dist = Array(n + 1) { j -> IntArray(m + 1) { i -> if (j == 0) i else if (i == 0) j else 0 } }
        for (j in 1..n) {
            for (i in 1..m) {
                dist[j][i] =
                    if (s2[j - 1] == s1[i - 1]) dist[j - 1][i - 1]
                    else min(dist[j - 1][i], min(dist[j][i - 1], dist[j - 1][i - 1])) + 1
            }
        }
        return dist[n][m] - abs(m - n)
    }
}
