package com.sourcegraph.scip_java.commands

import com.sourcegraph.io.AbsolutePath
import com.sourcegraph.scip_aggregator.ConsoleScipAggregatorReporter
import com.sourcegraph.scip_aggregator.ScipAggregator
import com.sourcegraph.scip_aggregator.ScipAggregatorOptions
import com.sourcegraph.scip_java.BuildInfo
import com.sourcegraph.scip_java.ScipJavaApp
import com.sourcegraph.scip_java.buildtools.ClasspathEntry
import java.nio.file.Path
import org.scip_code.scip.ToolInfo

/**
 * Pure logic backing the `aggregate` command.
 *
 * `IndexCommand` shells out to a build tool that drops SCIP shards
 * under a targetroot directory, then calls into this runner to aggregate
 * those shards into a single SCIP index file. The separation makes it
 * possible to invoke the runner directly from in-process callers
 * (build tools) without going through clikt.
 */
object AggregateRunner {
    fun run(
        output: Path,
        targetroots: List<Path>,
        app: ScipJavaApp,
        parallel: Boolean,
        emitInverseRelationships: Boolean,
        allowEmptyIndex: Boolean,
        allowExportingGlobalSymbolsFromDirectoryEntries: Boolean,
    ): Int {
        val sourceroot = AbsolutePath.of(app.env.workingDirectory)
        val absoluteTargetroots =
            if (targetroots.isEmpty()) listOf(sourceroot)
            else targetroots.map { AbsolutePath.of(it, sourceroot) }
        val absoluteOutput = AbsolutePath.of(output, sourceroot)

        val reporter = ConsoleScipAggregatorReporter(app.reporter)
        val packages =
            absoluteTargetroots
                .asSequence()
                .flatMap { ClasspathEntry.fromTargetroot(it, sourceroot).asSequence() }
                .distinct()
                .toList()

        val options =
            ScipAggregatorOptions(
                absoluteTargetroots,
                absoluteOutput,
                sourceroot,
                reporter,
                ToolInfo.newBuilder()
                    .setName("scip-java")
                    .setVersion(BuildInfo.version)
                    .build(),
                parallel,
                packages.map { it.toPackageInformation() },
                emitInverseRelationships,
                allowEmptyIndex,
                allowExportingGlobalSymbolsFromDirectoryEntries,
            )
        ScipAggregator.run(options)
        if (!app.reporter.hasErrors()) {
            app.info(options.output.toString())
        }
        return app.reporter.exitCode()
    }
}
