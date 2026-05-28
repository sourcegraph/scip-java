package com.sourcegraph.semanticdb_kotlinc

import org.scip_code.scip.Document
import org.scip_code.scip.Index
import java.nio.file.Files
import java.nio.file.Path

/**
 * Writes per-source SCIP shards produced by the Kotlin compiler plug-in.
 *
 * Each Kotlin source file produces a self-contained [Index] shard containing a single
 * [Document]. Unlike the javac equivalent, kotlinc compiles each source file once per round
 * and we delete stale shards on [delete] before re-emitting, so the writer is a straightforward
 * overwrite — no merge step is necessary.
 */
internal object ScipShardWriter {

    /** Writes the given [shard] to [output], creating parent directories as needed. */
    fun write(output: Path, shard: Index) {
        Files.createDirectories(output.parent)
        Files.write(output, shard.toByteArray())
    }

    /** Removes a previously emitted shard at [output], if any. */
    fun delete(output: Path) {
        Files.deleteIfExists(output)
    }
}
