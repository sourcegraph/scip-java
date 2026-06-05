package com.sourcegraph.scip_java

import com.sourcegraph.scip.ScipSymbols
import com.sourcegraph.scip_aggregator.SymbolDescriptor

sealed class ScipSymbol {
    companion object {
        fun parseOrThrowExceptionIfInvalid(scipSymbol: String): ScipSymbol {
            if (scipSymbol.startsWith("local ")) {
                return LocalScipSymbol(scipSymbol.removePrefix("local "))
            }
            val parts = scipSymbol.split(" ", limit = 5)
            require(parts.size == 5) { "Invalid scip symbol: $scipSymbol" }
            val (scheme, packageManager, packageName, packageVersion, descriptor) = parts
            return GlobalScipSymbol(
                scheme,
                packageManager,
                packageName,
                packageVersion,
                parseDescriptors(descriptor),
            )
        }

        private fun parseDescriptors(scipSymbol: String): List<SymbolDescriptor> {
            val result = mutableListOf<SymbolDescriptor>()
            var current = scipSymbol
            while (true) {
                val descriptor = SymbolDescriptor.parseFromSymbol(current)
                if (descriptor.owner == ScipSymbols.ROOT_PACKAGE) return result
                result += descriptor
                current = descriptor.owner
            }
        }
    }
}

data class LocalScipSymbol(val identifier: String) : ScipSymbol()

data class GlobalScipSymbol(
    val scheme: String,
    val packageManager: String,
    val packageName: String,
    val packageVersion: String,
    val descriptors: List<SymbolDescriptor>,
) : ScipSymbol()
