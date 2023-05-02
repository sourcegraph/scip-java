package com.sourcegraph.scip_semanticdb;

import com.sourcegraph.lsif_protocol.LsifToolInfo;
import java.nio.file.Path;
import java.util.List;

/** Configuration options to tweak the scip-semanticdb command. */
public class ScipSemanticdbOptions {

  public final List<Path> targetroots;
  public final Path output;
  public final Path sourceroot;
  public final ScipSemanticdbReporter reporter;
  public final LsifToolInfo toolInfo;
  public final String language;
  public final ScipOutputFormat format;
  public final boolean parallel;
  public final List<MavenPackage> packages;
  public final String buildKind;
  public final boolean emitInverseRelationships;

  public ScipSemanticdbOptions(
      List<Path> targetroots,
      Path output,
      Path sourceroot,
      ScipSemanticdbReporter reporter,
      LsifToolInfo toolInfo,
      String language,
      ScipOutputFormat format,
      boolean parallel,
      List<MavenPackage> packages,
      String buildKind,
      boolean emitInverseRelationships) {
    this.targetroots = targetroots;
    this.output = output;
    this.sourceroot = sourceroot;
    this.reporter = reporter;
    this.toolInfo = toolInfo;
    this.language = language;
    this.format = format;
    this.parallel = parallel;
    this.packages = packages;
    this.buildKind = buildKind;
    this.emitInverseRelationships = emitInverseRelationships;
  }
}
