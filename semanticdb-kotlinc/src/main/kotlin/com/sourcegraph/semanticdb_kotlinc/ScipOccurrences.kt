package com.sourcegraph.semanticdb_kotlinc

import com.sourcegraph.Scip

/**
 * Helpers for deduplicating SCIP [Scip.Occurrence] entries by their `(symbol, range, roles)` key.
 *
 * Variants that differ only in whether `enclosing_range` is set are collapsed, preferring the one
 * that carries the enclosing range. Mirrors the Java `ScipOccurrences` helper used by the javac
 * plug-in.
 */
internal object ScipOccurrences {

    /** Returns a new list with duplicate occurrences collapsed in insertion order. */
    fun deduplicate(occurrences: List<Scip.Occurrence>): List<Scip.Occurrence> {
        val out = LinkedHashMap<Key, Scip.Occurrence>()
        for (occ in occurrences) put(out, occ)
        return out.values.toList()
    }

    /** Inserts [occ] into [out], collapsing duplicates by [Key]. */
    fun put(out: LinkedHashMap<Key, Scip.Occurrence>, occ: Scip.Occurrence) {
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

    data class Key(val symbol: String, val range: List<Int>, val roles: Int) {
        companion object {
            fun of(occ: Scip.Occurrence): Key =
                Key(occ.symbol, occ.rangeList.toList(), occ.symbolRoles)
        }
    }
}
