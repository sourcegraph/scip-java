package com.sourcegraph.lsif_semanticdb;

import com.sourcegraph.lsif_protocol.LsifToolInfo;
import com.sourcegraph.semanticdb_javac.Semanticdb;

import java.nio.file.Path;
import java.util.List;

/** Configuration options to tweak the lsif-semanticdb command. */
public class LsifSemanticdbOptions {

  public final List<Path> targetroots;
  public final Path output;
  public final Path sourceroot;
  public final LsifSemanticdbReporter reporter;
  public final LsifToolInfo toolInfo;
  public final String language;
  public final LsifOutputFormat format;
  public final boolean parallel;
  public final List<MavenPackage> packages;
  public final String buildKind;
  public final List<LsifTextDocument> protobufTextDocuments;

  public LsifSemanticdbOptions(
      List<Path> targetroots,
      Path output,
      Path sourceroot,
      LsifSemanticdbReporter reporter,
      LsifToolInfo toolInfo,
      String language,
      LsifOutputFormat format,
      boolean parallel,
      List<MavenPackage> packages,
      String buildKind,
      List<LsifTextDocument> protobufTextDocuments) {
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
    this.protobufTextDocuments = protobufTextDocuments;
  }
}
