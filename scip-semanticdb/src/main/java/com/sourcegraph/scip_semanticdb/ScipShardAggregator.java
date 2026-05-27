package com.sourcegraph.scip_semanticdb;

import com.google.protobuf.CodedInputStream;
import com.sourcegraph.Scip;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Aggregates per-source {@code *.scip} shards into a single {@link Scip.Index}.
 *
 * <p>Steps:
 *
 * <ol>
 *   <li>Walk all targetroots for {@code *.scip} shards (and {@code *.jar} files containing them).
 *   <li>Parse each shard into a {@link Scip.Index} containing exactly one {@link Scip.Document}.
 *   <li>Rewrite placeholder global symbols ({@code ". . . . "} prefix) into the final {@code
 *       "scip-java maven g a v ..."} form via {@link SymbolRewriter}.
 *   <li>Deduplicate documents by {@code relative_path}, merging occurrences/symbols.
 *   <li>Compute inverse {@code is_implementation+is_reference} relationships across the project.
 *   <li>Emit the metadata block and all documents through {@link ScipWriter}.
 * </ol>
 */
public final class ScipShardAggregator {

  private final ScipWriter writer;
  private final ScipSemanticdbOptions options;
  private final SymbolRewriter rewriter;

  public ScipShardAggregator(
      ScipWriter writer, ScipSemanticdbOptions options, SymbolRewriter rewriter) {
    this.writer = writer;
    this.options = options;
    this.rewriter = rewriter;
  }

  public static void run(ScipSemanticdbOptions options) throws IOException {
    try (ScipWriter writer = new ScipWriter(options)) {
      PackageTable packages = new PackageTable(options);
      SymbolRewriter rewriter = new SymbolRewriter(packages);
      new ScipShardAggregator(writer, options, rewriter).run();
      writer.build();
    }
  }

  private void run() throws IOException {
    List<Path> shards = ScipShardWalker.findScipShards(options);
    Collections.sort(shards);
    if (options.reporter.hasErrors()) return;
    if (shards.isEmpty() && !options.allowEmptyIndex) {
      options.reporter.error(
          "No SCIP shard files found. "
              + "This typically means that `scip-java` is unable to automatically "
              + "index this codebase. If you are using Gradle or Maven, please report an issue to "
              + "https://github.com/sourcegraph/scip-java and include steps to reproduce. "
              + "If you are using a different build tool, make sure that you have followed all "
              + "of the steps from https://sourcegraph.github.io/scip-java/docs/manual-configuration.html");
      return;
    }
    options.reporter.startProcessing(shards.size());
    writer.emitTyped(metadata());

    // Deduplicate documents by relative_path. We rewrite symbols as we go so all merging happens
    // on final-form strings.
    LinkedHashMap<String, Scip.Document.Builder> merged = new LinkedHashMap<>();
    InverseReferenceRelationships inverse = new InverseReferenceRelationships();

    for (Path shard : shards) {
      try {
        for (Scip.Index shardIndex : parseShard(shard)) {
          for (Scip.Document doc : shardIndex.getDocumentsList()) {
            Scip.Document rewritten = rewriteDocument(doc);
            inverse.observe(rewritten);
            Scip.Document.Builder existing = merged.get(rewritten.getRelativePath());
            if (existing == null) {
              merged.put(rewritten.getRelativePath(), rewritten.toBuilder());
            } else {
              mergeInto(existing, rewritten);
            }
          }
        }
      } catch (IOException e) {
        options.reporter.error("invalid SCIP shard: " + shard);
        options.reporter.error(e);
      }
      options.reporter.processedOneItem();
    }

    for (Scip.Document.Builder doc : merged.values()) {
      Scip.Document withInverse = inverse.applyTo(doc.build());
      writer.emitTyped(Scip.Index.newBuilder().addDocuments(withInverse).build());
    }

    options.reporter.endProcessing();
  }

  // --- shard parsing -------------------------------------------------------

  private static final PathMatcher JAR_PATTERN =
      FileSystems.getDefault().getPathMatcher("glob:**.jar");

  private List<Scip.Index> parseShard(Path shardPath) throws IOException {
    if (JAR_PATTERN.matches(shardPath)) {
      List<Scip.Index> out = new ArrayList<>();
      try (JarFile jar = new JarFile(shardPath.toFile())) {
        Enumeration<JarEntry> entries = jar.entries();
        while (entries.hasMoreElements()) {
          JarEntry entry = entries.nextElement();
          if (entry.getName().endsWith(".scip")) {
            try (InputStream is = jar.getInputStream(entry)) {
              byte[] bytes = InputStreamBytes.readAll(is);
              out.add(parseBytes(bytes));
            }
          }
        }
      }
      return out;
    }
    return Collections.singletonList(parseBytes(Files.readAllBytes(shardPath)));
  }

  private static Scip.Index parseBytes(byte[] bytes) throws IOException {
    CodedInputStream in = CodedInputStream.newInstance(bytes);
    in.setRecursionLimit(1000);
    return Scip.Index.parseFrom(in);
  }

  // --- rewriting -----------------------------------------------------------

  private Scip.Document rewriteDocument(Scip.Document doc) {
    Scip.Document.Builder builder = doc.toBuilder().clearOccurrences().clearSymbols();
    for (Scip.Occurrence occ : doc.getOccurrencesList()) {
      builder.addOccurrences(occ.toBuilder().setSymbol(rewriter.rewrite(occ.getSymbol())).build());
    }
    for (Scip.SymbolInformation info : doc.getSymbolsList()) {
      builder.addSymbols(rewriteSymbol(info));
    }
    return builder.build();
  }

  private Scip.SymbolInformation rewriteSymbol(Scip.SymbolInformation info) {
    Scip.SymbolInformation.Builder builder = info.toBuilder();
    builder.setSymbol(rewriter.rewrite(info.getSymbol()));
    if (!info.getEnclosingSymbol().isEmpty()) {
      builder.setEnclosingSymbol(rewriter.rewrite(info.getEnclosingSymbol()));
    }
    builder.clearRelationships();
    for (Scip.Relationship rel : info.getRelationshipsList()) {
      builder.addRelationships(
          rel.toBuilder().setSymbol(rewriter.rewrite(rel.getSymbol())).build());
    }
    return builder.build();
  }

  private void mergeInto(Scip.Document.Builder target, Scip.Document fresh) {
    // Deduplicate occurrences by (range, symbol, roles) so that shards produced by repeated
    // compilation rounds (or by multiple targetroots) don't introduce duplicate entries.
    // Variants that differ only by enclosing_range are collapsed, preferring the one that has it.
    LinkedHashMap<OccurrenceKey, Scip.Occurrence> occurrences = new LinkedHashMap<>();
    for (Scip.Occurrence occ : target.getOccurrencesList()) putOccurrence(occurrences, occ);
    for (Scip.Occurrence occ : fresh.getOccurrencesList()) putOccurrence(occurrences, occ);
    target.clearOccurrences().addAllOccurrences(occurrences.values());

    // Deduplicate symbols by symbol string; merge relationships of duplicates.
    LinkedHashMap<String, Scip.SymbolInformation> bySymbol = new LinkedHashMap<>();
    for (Scip.SymbolInformation info : target.getSymbolsList()) {
      bySymbol.put(info.getSymbol(), info);
    }
    for (Scip.SymbolInformation info : fresh.getSymbolsList()) {
      Scip.SymbolInformation existing = bySymbol.get(info.getSymbol());
      bySymbol.put(info.getSymbol(), existing == null ? info : mergeSymbol(existing, info));
    }
    target.clearSymbols().addAllSymbols(bySymbol.values());
  }

  private static void putOccurrence(
      LinkedHashMap<OccurrenceKey, Scip.Occurrence> out, Scip.Occurrence occ) {
    OccurrenceKey key = OccurrenceKey.of(occ);
    Scip.Occurrence existing = out.get(key);
    if (existing == null) {
      out.put(key, occ);
      return;
    }
    if (existing.getEnclosingRangeCount() == 0 && occ.getEnclosingRangeCount() > 0) {
      out.put(key, occ);
    }
  }

  private static final class OccurrenceKey {
    final String symbol;
    final java.util.List<Integer> range;
    final int roles;

    OccurrenceKey(String symbol, java.util.List<Integer> range, int roles) {
      this.symbol = symbol;
      this.range = range;
      this.roles = roles;
    }

    static OccurrenceKey of(Scip.Occurrence occ) {
      return new OccurrenceKey(occ.getSymbol(), occ.getRangeList(), occ.getSymbolRoles());
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof OccurrenceKey)) return false;
      OccurrenceKey other = (OccurrenceKey) o;
      return roles == other.roles && symbol.equals(other.symbol) && range.equals(other.range);
    }

    @Override
    public int hashCode() {
      return java.util.Objects.hash(symbol, range, roles);
    }
  }

  private static Scip.SymbolInformation mergeSymbol(
      Scip.SymbolInformation a, Scip.SymbolInformation b) {
    Scip.SymbolInformation.Builder builder = b.toBuilder();
    LinkedHashMap<Scip.Relationship, Scip.Relationship> rels = new LinkedHashMap<>();
    for (Scip.Relationship r : a.getRelationshipsList()) rels.put(r, r);
    for (Scip.Relationship r : b.getRelationshipsList()) rels.put(r, r);
    builder.clearRelationships().addAllRelationships(rels.values());
    return builder.build();
  }

  // --- metadata ------------------------------------------------------------

  private Scip.Index metadata() {
    return Scip.Index.newBuilder()
        .setMetadata(
            Scip.Metadata.newBuilder()
                .setVersion(Scip.ProtocolVersion.UnspecifiedProtocolVersion)
                .setProjectRoot(options.sourceroot.toUri().toString())
                .setTextDocumentEncoding(Scip.TextEncoding.UTF8)
                .setToolInfo(
                    Scip.ToolInfo.newBuilder()
                        .setName(options.toolInfo.getName())
                        .setVersion(options.toolInfo.getVersion())
                        .addAllArguments(options.toolInfo.getArgumentsList())))
        .build();
  }

  // --- inverse relationships ----------------------------------------------

  /**
   * Collects symbols that override or implement other symbols, indexed by the overridden symbol.
   * When a final document is emitted, the per-symbol entries are augmented with {@code
   * is_implementation && is_reference} relationships pointing back to overriders.
   */
  private final class InverseReferenceRelationships {

    private final Map<String, List<String>> map = new LinkedHashMap<>();
    private final boolean enabled = options.emitInverseRelationships;

    void observe(Scip.Document doc) {
      if (!enabled) return;
      for (Scip.SymbolInformation info : doc.getSymbolsList()) {
        if (info.getSymbol().isEmpty() || SymbolRewriter.isLocal(info.getSymbol())) continue;
        if (!supportsReferenceRelationship(info)) continue;
        for (Scip.Relationship rel : info.getRelationshipsList()) {
          if (!rel.getIsImplementation()) continue;
          if (rel.getSymbol().isEmpty() || SymbolRewriter.isLocal(rel.getSymbol())) continue;
          map.computeIfAbsent(rel.getSymbol(), k -> new ArrayList<>()).add(info.getSymbol());
        }
      }
    }

    Scip.Document applyTo(Scip.Document doc) {
      if (!enabled || map.isEmpty()) return doc;
      Scip.Document.Builder builder = doc.toBuilder().clearSymbols();
      for (Scip.SymbolInformation info : doc.getSymbolsList()) {
        List<String> overriders = map.get(info.getSymbol());
        if (overriders == null || overriders.isEmpty()) {
          builder.addSymbols(info);
          continue;
        }
        Scip.SymbolInformation.Builder s = info.toBuilder();
        for (String overrider : overriders) {
          s.addRelationships(
              Scip.Relationship.newBuilder()
                  .setSymbol(overrider)
                  .setIsImplementation(true)
                  .setIsReference(true));
        }
        builder.addSymbols(s.build());
      }
      return builder.build();
    }
  }

  private static boolean supportsReferenceRelationship(Scip.SymbolInformation info) {
    switch (info.getKind()) {
      case Interface:
      case Type:
      case Class:
      case Object:
      case PackageObject:
        return false;
      default:
        return true;
    }
  }

  // Make the existing flatten-style call available for callers that already have shards in memory.
  @SuppressWarnings("unused")
  Stream<Scip.Document> documentsFromShards(List<Scip.Index> shards) {
    return shards.stream().flatMap(s -> s.getDocumentsList().stream()).map(this::rewriteDocument);
  }

  @SuppressWarnings("unused")
  Stream<Scip.Document> documentsFromShardsCollected(List<Scip.Index> shards) {
    return documentsFromShards(shards).collect(Collectors.toList()).stream();
  }
}
