package com.sourcegraph.semanticdb_kotlinc

/**
 * Minimal role enum used by the direct-to-SCIP visitor and builder. Mirrors the subset of
 * `Semanticdb.SymbolOccurrence.Role` that the Kotlin plug-in needs after the SemanticDB protobuf
 * dependency has been removed.
 */
enum class ScipRole {
    DEFINITION,
    REFERENCE
}
