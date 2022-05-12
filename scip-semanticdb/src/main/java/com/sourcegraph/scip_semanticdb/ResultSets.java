package com.sourcegraph.scip_semanticdb;

import com.sourcegraph.semanticdb_javac.SemanticdbSymbols;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

/** Utility to deal with the creation of result sets. */
public class ResultSets implements Function<String, ResultIds> {

  private final ScipWriter writer;
  private final Map<String, ResultIds> globals;
  private final HashMap<String, ResultIds> locals;
  private final Set<String> exportedSymbols;
  private final Set<String> localDefinitions;
  private final PackageTable packages;
  private final boolean isJdkRepo;

  public ResultSets(
      ScipWriter writer,
      Map<String, ResultIds> globals,
      Set<String> exportedSymbols,
      Set<String> localDefinitions,
      PackageTable packages,
      ScipSemanticdbOptions options) {
    this.writer = writer;
    this.globals = globals;
    this.exportedSymbols = exportedSymbols;
    this.localDefinitions = localDefinitions;
    this.packages = packages;
    this.isJdkRepo = options.buildKind.equals("jdk");
    locals = new HashMap<>();
  }

  public ResultIds getOrInsertResultSet(String symbol) {
    boolean isLocal = SemanticdbSymbols.isLocal(symbol);
    Map<String, ResultIds> cache = isLocal ? locals : globals;
    return cache.computeIfAbsent(symbol, this);
  }

  @Override
  public ResultIds apply(String symbol) {
    boolean isExportedSymbol = exportedSymbols.contains(symbol);
    boolean hasDefinitionResult = isExportedSymbol || localDefinitions.contains(symbol);
    int resultSet = writer.emitResultSet();

    // Moniker
    Optional<Package> pkg = packages.packageForSymbol(symbol);
    if (pkg.isPresent() && pkg.get() instanceof JdkPackage && !isJdkRepo) {
      // Never export monikers for the JDK repo unless we're indexing the JDK repo.
      // Some Maven packages contain sources that redefine symbols like `java/lang/String#`
      // even if the the jar files don't contain `java/lang/String.class`. For example,
      // see the package com.google.gwt:gwt-user:2.9.0.
      // Related issue: https://github.com/sourcegraph/sourcegraph/issues/21058
      isExportedSymbol = false;
    }
    int monikerId = writer.emitMonikerVertex(symbol, hasDefinitionResult);
    writer.emitMonikerEdge(resultSet, monikerId);
    if (pkg.isPresent()) {
      packages.writeMonikerPackage(monikerId, pkg.get());
    }

    int definitionId = hasDefinitionResult ? writer.emitDefinitionResult(resultSet) : -1;

    return new ResultIds(resultSet, definitionId, writer.emitReferenceResult(resultSet));
  }
}
