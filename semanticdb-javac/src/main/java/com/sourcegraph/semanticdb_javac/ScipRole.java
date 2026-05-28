package com.sourcegraph.semanticdb_javac;

/**
 * Minimal role enum used by {@link ScipVisitor} when emitting SCIP occurrences. Mirrors the subset
 * of {@code Semanticdb.SymbolOccurrence.Role} that the direct-to-SCIP visitor cares about.
 */
enum ScipRole {
  DEFINITION,
  REFERENCE,
  SYNTHETIC_DEFINITION
}
