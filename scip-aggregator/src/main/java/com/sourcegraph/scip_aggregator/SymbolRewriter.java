package com.sourcegraph.scip_aggregator;

import com.sourcegraph.scip.ScipSymbols;

/**
 * Rewrites bare descriptor symbols emitted by the compiler plugins (e.g. {@code
 * _root_/com/example/Foo#}) into fully-qualified SCIP symbols (e.g. {@code scip-java maven
 * com.example:my-lib 1.0 _root_/com/example/Foo#}) by looking up the descriptor's owning package in
 * a {@link PackageTable}.
 *
 * <p>Local symbols (those starting with {@code "local "}) are passed through unchanged.
 */
final class SymbolRewriter {
  private final PackageTable packages;

  SymbolRewriter(PackageTable packages) {
    this.packages = packages;
  }

  /** Rewrites {@code symbol}, or returns {@code symbol} unchanged when no rewriting applies. */
  String rewrite(String symbol) {
    if (symbol == null || symbol.isEmpty()) return symbol;
    if (ScipSymbols.isLocal(symbol)) return symbol;
    Package pkg = packages.packageForSymbol(symbol).orElse(Package.EMPTY);
    return "scip-java " + pkg.scipTypedEncoding() + " " + symbol;
  }
}
