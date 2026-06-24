package com.sourcegraph.scip_java.commands

import com.sourcegraph.scip_aggregator.ScipAggregator
import com.sourcegraph.scip_aggregator.ScipAggregatorOptions
import com.sourcegraph.scip_java.ScipJava
import com.sourcegraph.scip_java.ScipJavaApp
import com.sourcegraph.scip_java.buildtools.ClasspathEntry
import java.nio.file.Path
import org.scip_code.scip.ToolInfo

/**
 * Logic backing the `aggregate` command, factored out so build tools can aggregate their targetroot
 * shards into a single SCIP index in-process without going through clikt.
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
                ToolInfo.newBuilder().setName("scip-java").setVersion(ScipJava.version).build(),
                parallel,
                packages.map { it.toPackageInformation() },
                emitInverseRelationships,
                allowEmptyIndex,
                allowExportingGlobalSymbolsFromDirectoryEntries,
            )
        ScipAggregator.run(options)
        // The one seam where accumulated reporter errors become an exit code:
        // the scip-aggregator library reports errors instead of throwing.
        if (!app.reporter.hasErrors()) {
            app.info(options.output.toString())
        }
        return app.reporter.exitCode()
    }
}
