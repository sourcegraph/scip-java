package com.sourcegraph.scip_java.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
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
import java.nio.file.Path
import java.nio.file.Paths

/** `scip-java aggregate`: aggregates per-source SCIP shards into a single SCIP index file. */
class AggregateCommand : CliktCommand(name = "aggregate") {

    override fun help(context: Context) =
        "Aggregates per-source SCIP shards into a single SCIP index file."

    private val app: ScipJavaApp by requireObject()

    private val output: Path by
        option("--output", help = "The name of the output file.")
            .path()
            .default(Paths.get("index.scip"))

    private val parallel: Boolean by
        option(
                "--parallel",
                "--no-parallel",
                help = "Whether to process the SCIP shards in parallel.",
            )
            .flag("--no-parallel", default = true)

    private val emitInverseRelationships: Boolean by
        option(
                "--emit-inverse-relationships",
                "--no-emit-inverse-relationships",
                help =
                    "Whether to emit parent->child relationships for 'Find references' and 'Find implementations'. " +
                        "This flag exists as a workaround for https://github.com/sourcegraph/sourcegraph/issues/50927",
            )
            .flag("--no-emit-inverse-relationships", default = true)

    private val targetrootOption: List<Path> by
        option("--targetroot", help = "Directories that contain SCIP shards.").path().multiple()

    private val targetrootArgs: List<Path> by argument().path().multiple()

    private val allowEmptyIndex: Boolean by
        option(
                "--allow-empty-index",
                help =
                    "If true, don't report an error when no documents have been indexed. " +
                        "The resulting SCIP index will silently be empty instead.",
            )
            .flag()

    private val allowExportingGlobalSymbolsFromDirectoryEntries: Boolean by
        option(
                "--allow-exporting-global-symbols-from-directory-entries",
                "--no-allow-exporting-global-symbols-from-directory-entries",
                help =
                    "Determines how to index symbols that are compiled to classfiles inside directories.",
            )
            .flag("--no-allow-exporting-global-symbols-from-directory-entries", default = true)

    override fun run() {
        val exit =
            AggregateRunner.run(
                output = output,
                targetroots = targetrootOption + targetrootArgs,
                app = app,
                parallel = parallel,
                emitInverseRelationships = emitInverseRelationships,
                allowEmptyIndex = allowEmptyIndex,
                allowExportingGlobalSymbolsFromDirectoryEntries =
                    allowExportingGlobalSymbolsFromDirectoryEntries,
            )
        if (exit != 0) throw ProgramResult(exit)
    }
}
