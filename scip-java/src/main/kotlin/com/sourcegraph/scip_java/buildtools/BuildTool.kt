package com.sourcegraph.scip_java.buildtools

import com.sourcegraph.scip_java.commands.AggregateRunner
import com.sourcegraph.scip_java.commands.IndexCommand
import java.nio.file.Files
import java.nio.file.Path

/** A build tool such as Gradle, Maven or Bazel. */
abstract class BuildTool(val name: String, protected val index: IndexCommand) {
    open val isHidden: Boolean = false

    val sourceroot: Path
        get() = index.workingDirectory

    abstract fun usedInCurrentDirectory(): Boolean

    abstract fun generateScip(): Int

    companion object {
        fun all(index: IndexCommand): List<BuildTool> =
            // We don't support Bazel for auto-indexing, but if it's
            // detected, we should at least give a meaningful error message.
            autoOrdered(index) + BazelBuildTool(index)

        fun autoOrdered(index: IndexCommand): List<BuildTool> =
            // The order in this list is important - first detected build
            // tool will be used in `auto` mode. Bazel is missing because
            // it isn't supported by auto-indexing.
            listOf(
                ScipBuildTool(index),
                MavenBuildTool(index),
                GradleBuildTool(index),
            )

        fun allNames(): String =
            all(IndexCommand()).filterNot { it.isHidden }.joinToString(", ") { it.name }

        /**
         * After the wrapped build tool finished invoking `javac`/`kotlinc`,
         * convert the resulting SCIP targetroot into a SCIP index.
         */
        fun generateScipFromTargetroot(
            generateScipResult: ProcessResult,
            targetroot: Path,
            index: IndexCommand,
        ): Int {
            if (!Files.isDirectory(targetroot)) return generateScipResult.exitCode
            if (index.app.reporter.hasErrors()) return index.app.reporter.exitCode()
            if (generateScipResult.exitCode != 0) return generateScipResult.exitCode
            return AggregateRunner.run(
                output = index.finalOutput,
                targetroots = listOf(targetroot),
                app = index.app,
                parallel = index.aggregateParallel,
                emitInverseRelationships = index.aggregateEmitInverseRelationships,
                allowEmptyIndex = index.aggregateAllowEmptyIndex,
                allowExportingGlobalSymbolsFromDirectoryEntries =
                    index.aggregateAllowExportingGlobalSymbolsFromDirectoryEntries,
            )
        }
    }
}
