package com.sourcegraph.scip_aggregator;

import java.nio.file.Path;
import java.util.List;
import org.scip_code.scip.ToolInfo;

/** Configuration options to tweak the scip-aggregator command. */
public class ScipAggregatorOptions {

  public final List<Path> targetroots;
  public final Path output;
  public final Path sourceroot;
  public final ScipAggregatorReporter reporter;
  public final ToolInfo toolInfo;
  public final boolean parallel;
  public final List<MavenPackage> packages;
  public final boolean emitInverseRelationships;
  public final boolean allowEmptyIndex;
  public final boolean allowExportingGlobalSymbolsFromDirectoryEntries;

  public ScipAggregatorOptions(
      List<Path> targetroots,
      Path output,
      Path sourceroot,
      ScipAggregatorReporter reporter,
      ToolInfo toolInfo,
      boolean parallel,
      List<MavenPackage> packages,
      boolean emitInverseRelationships,
      boolean allowEmptyIndex,
      boolean allowExportingGlobalSymbolsFromDirectoryEntries) {
    this.targetroots = targetroots;
    this.output = output;
    this.sourceroot = sourceroot;
    this.reporter = reporter;
    this.toolInfo = toolInfo;
    this.parallel = parallel;
    this.packages = packages;
    this.emitInverseRelationships = emitInverseRelationships;
    this.allowEmptyIndex = allowEmptyIndex;
    this.allowExportingGlobalSymbolsFromDirectoryEntries =
        allowExportingGlobalSymbolsFromDirectoryEntries;
  }
}
