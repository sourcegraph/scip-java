package com.sourcegraph.scip_semanticdb;

/**
 * Rewrites placeholder SCIP global symbols emitted by the compiler plugin into their final form.
 *
 * <p>The compiler plugin does not know the Maven coordinates ({@code groupId:artifactId:version})
 * of the source it is compiling, so it emits global symbols with the sentinel prefix {@code ". . .
 * . "}. The aggregator resolves the appropriate coordinates via {@link PackageTable} and rewrites
 * those symbols to the final {@code "scip-java"} scheme.
 *
 * <p>{@code local N} symbols are passed through unchanged.
 */
public final class SymbolRewriter {

  /**
   * Sentinel prefix used by the compiler plugin for global symbols whose coordinates are not yet
   * known.
   */
  public static final String PLACEHOLDER_PREFIX = ". . . . ";

  /** SCIP scheme used for symbols produced by scip-java. */
  public static final String SCIP_JAVA_SCHEME = "scip-java";

  private final PackageTable packages;

  public SymbolRewriter(PackageTable packages) {
    this.packages = packages;
  }

  /**
   * Returns {@code true} if {@code symbol} is a placeholder global emitted by the compiler plugin.
   */
  public static boolean isPlaceholderGlobal(String symbol) {
    return symbol != null && symbol.startsWith(PLACEHOLDER_PREFIX);
  }

  /**
   * Returns {@code true} if {@code symbol} is a SCIP local symbol of the form {@code "local N"}.
   */
  public static boolean isLocal(String symbol) {
    return symbol != null && symbol.startsWith("local ");
  }

  /**
   * Rewrites a placeholder global symbol into its final form using the appropriate package
   * coordinates from {@link PackageTable}. Local symbols and already-rewritten symbols are returned
   * unchanged.
   */
  public String rewrite(String symbol) {
    if (symbol == null || symbol.isEmpty()) return symbol;
    if (isLocal(symbol)) return symbol;
    if (!isPlaceholderGlobal(symbol)) return symbol;

    String descriptor = symbol.substring(PLACEHOLDER_PREFIX.length());
    Package pkg = packages.packageForSymbol(descriptor).orElse(Package.EMPTY);
    return SCIP_JAVA_SCHEME + " " + pkg.scipTypedEncoding() + " " + descriptor;
  }
}
