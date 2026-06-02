package com.sourcegraph.semanticdb_kotlinc

/**
 * Helpers for emitting SCIP symbol strings from the Kotlin compiler plug-in.
 *
 * Mirrors the Java `ScipSymbols` helper. Because the compiler plug-in does not know the final
 * Maven coordinates (`groupId:artifactId:version`) at compile time, it emits global symbols using
 * a sentinel placeholder scheme that is rewritten by the aggregator to its final form:
 *
 *   `. . . . ` + <semanticdb-style descriptor path>
 *      ->  "scip-java maven <groupId> <artifactId> <version> <descriptor path>"
 *
 * Local symbols are emitted using the canonical SCIP `local N` form (with the space) and are NOT
 * rewritten by the aggregator.
 */
object ScipSymbols {

    /**
     * Prefix marking a global symbol whose package coordinates must be filled in by the aggregator.
     * The trailing space matches the SCIP grammar requirement of separating the scheme from the
     * package fields.
     */
    const val PLACEHOLDER_PREFIX: String = ". . . . "

    /**
     * Converts a SemanticDB-style [Symbol] into the SCIP symbol form expected by the aggregator.
     *
     *   - [Symbol.NONE] becomes the empty string.
     *   - Local symbols of the form `local42` become `local 42`.
     *   - Everything else is prefixed with [PLACEHOLDER_PREFIX].
     */
    fun fromSemanticdbSymbol(symbol: Symbol): String {
        if (symbol == Symbol.NONE) return ""
        val raw = symbol.toString()
        if (symbol.isLocal()) {
            return "local " + raw.substring("local".length)
        }
        return PLACEHOLDER_PREFIX + raw
    }
}
