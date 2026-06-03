package com.sourcegraph.semanticdb_kotlinc

/**
 * Converts SemanticDB-style symbol strings into the placeholder SCIP form expected by the
 * aggregator: globals are prefixed with [PLACEHOLDER_PREFIX] (rewritten to
 * `scip-java maven <g> <a> <v> <descriptor>` once coordinates are known), locals use the canonical
 * `local N` form and pass through unchanged. Mirrors the Java `ScipSymbols` helper.
 */
object ScipSymbols {

    const val PLACEHOLDER_PREFIX: String = ". . . . "

    fun fromSemanticdbSymbol(symbol: String?): String {
        if (symbol.isNullOrEmpty()) return ""
        if (symbol.startsWith("local")) {
            return "local " + symbol.substring("local".length)
        }
        return PLACEHOLDER_PREFIX + symbol
    }

    fun fromSemanticdbSymbol(symbol: Symbol): String = fromSemanticdbSymbol(symbol.toString())
}
