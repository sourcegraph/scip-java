package com.sourcegraph.semanticdb_javac;

/**
 * Helpers for emitting SCIP symbol strings from the compiler plugin.
 *
 * <p>Because the compiler plugin does not know the final Maven coordinates ({@code
 * groupId:artifactId:version}) at compile time, it emits global symbols using a sentinel
 * placeholder scheme that is rewritten by the aggregator to its final form:
 *
 * <pre>
 *   ". . . . " + &lt;semanticdb-style descriptor path&gt;
 *     ->  "scip-java maven &lt;groupId&gt; &lt;artifactId&gt; &lt;version&gt; &lt;descriptor path&gt;"
 * </pre>
 *
 * <p>Local symbols are emitted using the canonical SCIP {@code "local N"} form (with the space) and
 * are <strong>not</strong> rewritten by the aggregator.
 */
public final class ScipSymbols {

  /**
   * Prefix marking a global symbol whose package coordinates must be filled in by the aggregator.
   * The trailing space matches the SCIP grammar requirement of separating the scheme from the
   * package fields.
   */
  public static final String PLACEHOLDER_PREFIX = ". . . . ";

  private ScipSymbols() {}

  /**
   * Converts a SemanticDB-style symbol string (as produced by {@link GlobalSymbolsCache} and {@link
   * LocalSymbolsCache}) into the SCIP symbol form expected by the aggregator.
   *
   * <ul>
   *   <li>Empty strings stay empty.
   *   <li>Local symbols of the form {@code "local42"} become {@code "local 42"}.
   *   <li>Everything else is prefixed with {@link #PLACEHOLDER_PREFIX}.
   * </ul>
   */
  public static String fromSemanticdbSymbol(String symbol) {
    if (symbol == null || symbol.isEmpty()) return "";
    if (SemanticdbSymbols.isLocal(symbol)) {
      return "local " + symbol.substring("local".length());
    }
    return PLACEHOLDER_PREFIX + symbol;
  }
}
