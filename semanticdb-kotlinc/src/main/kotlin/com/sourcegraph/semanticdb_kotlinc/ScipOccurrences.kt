package com.sourcegraph.semanticdb_kotlinc

import org.scip_code.scip.Occurrence

/**
 * Accumulator that deduplicates SCIP [Occurrence] entries by `(symbol, range, roles)`. Variants
 * differing only in whether `enclosing_range` is set are collapsed, preferring the one that
 * carries it. Mirrors the Java `ScipOccurrences` accumulator.
 */
internal class ScipOccurrences {

    private val out = LinkedHashMap<Key, Occurrence>()

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

    fun values(): Collection<Occurrence> = out.values

    private data class Key(val symbol: String, val range: List<Int>, val roles: Int) {
        companion object {
            fun of(occ: Occurrence): Key =
                Key(occ.symbol, occ.rangeList.toList(), occ.symbolRoles)
        }
    }
}
