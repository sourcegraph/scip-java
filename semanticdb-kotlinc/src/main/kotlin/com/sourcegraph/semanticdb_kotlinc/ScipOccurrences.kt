package com.sourcegraph.semanticdb_kotlinc

import org.scip_code.scip.Occurrence

/**
 * Accumulator that deduplicates SCIP [Occurrence] entries by their `(symbol, range, roles)` key.
 * Variants that differ only in whether `enclosing_range` is set are collapsed, preferring the one
 * that carries the enclosing range. Mirrors the Java `ScipOccurrences` accumulator used by the
 * javac plug-in.
 */
internal class ScipOccurrences {

    private val out = LinkedHashMap<Key, Occurrence>()

    /** Adds [occ], collapsing it into any existing entry with the same [Key]. */
    fun add(occ: Occurrence) {
        val key = Key.of(occ)
        val existing = out[key]
        if (existing == null) {
            out[key] = occ
            return
        }
        if (existing.enclosingRangeCount == 0 && occ.enclosingRangeCount > 0) {
            out[key] = occ
        }
    }

    /** Returns the deduplicated occurrences in insertion order. */
    fun values(): Collection<Occurrence> = out.values

    private data class Key(val symbol: String, val range: List<Int>, val roles: Int) {
        companion object {
            fun of(occ: Occurrence): Key =
                Key(occ.symbol, occ.rangeList.toList(), occ.symbolRoles)
        }
    }
}
