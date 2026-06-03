package com.sourcegraph.semanticdb_kotlinc

/**
 * Wraps descriptor strings into SCIP symbol strings: globals are prefixed with [PLACEHOLDER_PREFIX]
 * (rewritten to `scip-java maven <g> <a> <v> <descriptor>` once coordinates are known), locals use
 * the canonical `local N` form and pass through unchanged. Mirrors the Java `ScipSymbols` helper.
 */
object ScipSymbols {

    const val PLACEHOLDER_PREFIX: String = ". . . . "

    fun format(symbol: Symbol): String {
        if (symbol == Symbol.NONE) return ""
        val raw = symbol.toString()
        if (symbol.isLocal()) {
            return "local " + raw.substring("local".length)
        }
        return PLACEHOLDER_PREFIX + raw
    }
}
