package com.sourcegraph.semanticdb_javac;

import com.sourcegraph.semanticdb.SemanticdbSymbols;

/**
 * Converts SemanticDB-style symbol strings into the placeholder SCIP form expected by the
 * aggregator. The compiler plug-in doesn't know the final Maven coordinates, so globals are
 * prefixed with {@link #PLACEHOLDER_PREFIX} and the aggregator rewrites them into {@code "scip-java
 * maven <g> <a> <v> <descriptor>"}. Locals use the canonical {@code "local N"} form and pass
 * through unchanged.
 */
public final class ScipSymbols {

  public static final String PLACEHOLDER_PREFIX = ". . . . ";

  private ScipSymbols() {}

  public static String fromSemanticdbSymbol(String symbol) {
    if (symbol == null || symbol.isEmpty()) return "";
    if (SemanticdbSymbols.isLocal(symbol)) {
      return "local " + symbol.substring("local".length());
    }
    return PLACEHOLDER_PREFIX + symbol;
  }
}
