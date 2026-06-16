package com.sourcegraph.scip_java.commands

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
        val sourceroot = app.env.workingDirectory.toAbsolutePath()
        val absoluteTargetroots =
            if (targetroots.isEmpty()) listOf(sourceroot)
            else targetroots.map { sourceroot.resolve(it) }
        val absoluteOutput = sourceroot.resolve(output)

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
                app.reporter,
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
        // The single seam where the reporter's accumulated error state becomes an
        // exit code: the scip-aggregator library reports errors (and checks
        // hasErrors() internally) rather than throwing, so the returned code is
        // turned into a ProgramResult by the calling command.
        if (!app.reporter.hasErrors()) {
            app.info(options.output.toString())
        }
        return app.reporter.exitCode()
    }
}
