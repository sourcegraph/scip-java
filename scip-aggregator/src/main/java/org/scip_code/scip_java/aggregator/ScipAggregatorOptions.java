package org.scip_code.scip_java.aggregator;

import java.nio.file.Path;
import java.util.List;
import org.scip_code.scip.ToolInfo;

/** Configuration options to tweak the scip-aggregator command. */
public record ScipAggregatorOptions(
    List<Path> targetroots,
    Path output,
    Path sourceroot,
    ScipAggregatorReporter reporter,
    ToolInfo toolInfo,
    boolean parallel,
    List<MavenPackage> packages,
    boolean emitInverseRelationships,
    boolean allowEmptyIndex,
    boolean allowExportingGlobalSymbolsFromDirectoryEntries) {}
