package com.sourcegraph.semanticdb_kotlinc

import org.scip_code.scip.Document
import org.scip_code.scip.Index
import java.nio.file.Files
import java.nio.file.Path

/**
 * Writes per-source SCIP shards from the kotlinc plug-in. Kotlin compiles each source once per
 * round and stale shards are removed via [delete], so no merge step is needed.
 */
internal object ScipShardWriter {

    fun write(output: Path, shard: Index) {
        Files.createDirectories(output.parent)
        Files.write(output, shard.toByteArray())
    }

    fun delete(output: Path) {
        Files.deleteIfExists(output)
    }
}
