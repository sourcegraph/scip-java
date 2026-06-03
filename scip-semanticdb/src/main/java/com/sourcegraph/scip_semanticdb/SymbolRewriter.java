package com.sourcegraph.scip_semanticdb;

/**
 * Rewrites placeholder SCIP global symbols ({@link #PLACEHOLDER_PREFIX}) emitted by the compiler
 * plug-ins into their final {@code "scip-java"} form by resolving Maven coordinates via {@link
 * PackageTable}. Local symbols are passed through unchanged.
 */
public final class SymbolRewriter {

  public static final String PLACEHOLDER_PREFIX = ". . . . ";
  public static final String SCIP_JAVA_SCHEME = "scip-java";

  private final PackageTable packages;

  public SymbolRewriter(PackageTable packages) {
    this.packages = packages;
  }

  public static boolean isPlaceholderGlobal(String symbol) {
    return symbol != null && symbol.startsWith(PLACEHOLDER_PREFIX);
  }

  public static boolean isLocal(String symbol) {
    return symbol != null && symbol.startsWith("local ");
  }

  public String rewrite(String symbol) {
    if (symbol == null || symbol.isEmpty()) return symbol;
    if (isLocal(symbol)) return symbol;
    if (!isPlaceholderGlobal(symbol)) return symbol;

    String descriptor = symbol.substring(PLACEHOLDER_PREFIX.length());
    Package pkg = packages.packageForSymbol(descriptor).orElse(Package.EMPTY);
    return SCIP_JAVA_SCHEME + " " + pkg.scipTypedEncoding() + " " + descriptor;
  }
}
