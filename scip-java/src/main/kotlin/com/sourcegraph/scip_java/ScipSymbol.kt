package com.sourcegraph.scip_java

import com.sourcegraph.scip.ScipSymbols
import com.sourcegraph.scip_aggregator.SymbolDescriptor

/**
 * Validates that a string is a syntactically valid SCIP symbol.
 *
 * The snapshot printer uses this to fail fast when an index contains a symbol
 * that doesn't parse. The parsed structure isn't needed by any caller, so only
 * the throw-on-invalid behaviour is kept.
 */
object ScipSymbol {
    fun parseOrThrowExceptionIfInvalid(scipSymbol: String) {
        if (scipSymbol.startsWith("local ")) return
        val parts = scipSymbol.split(" ", limit = 5)
        require(parts.size == 5) { "Invalid scip symbol: $scipSymbol" }
        var current = parts[4]
        while (true) {
            val descriptor = SymbolDescriptor.parseFromSymbol(current)
            if (descriptor.owner == ScipSymbols.ROOT_PACKAGE) return
            current = descriptor.owner
        }
    }
}
