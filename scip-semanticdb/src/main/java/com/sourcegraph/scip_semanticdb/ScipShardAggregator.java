package com.sourcegraph.scip_semanticdb;

import com.google.protobuf.CodedInputStream;
import org.scip_code.scip.Document;
import org.scip_code.scip.Index;
import org.scip_code.scip.Metadata;
import org.scip_code.scip.Occurrence;
import org.scip_code.scip.ProtocolVersion;
import org.scip_code.scip.Relationship;
import org.scip_code.scip.SymbolInformation;
import org.scip_code.scip.TextEncoding;
import org.scip_code.scip.ToolInfo;

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
 * Aggregates per-source {@code *.scip} shards into a single {@link Index}.
 *
 * <p>Steps:
 *
 * <ol>
 *   <li>Walk all targetroots for {@code *.scip} shards (and {@code *.jar} files containing them).
 *   <li>Parse each shard into a {@link Index} containing exactly one {@link Document}.
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
    LinkedHashMap<String, Document.Builder> merged = new LinkedHashMap<>();
    InverseReferenceRelationships inverse = new InverseReferenceRelationships();

    for (Path shard : shards) {
      try {
        for (Index shardIndex : parseShard(shard)) {
          for (Document doc : shardIndex.getDocumentsList()) {
            Document rewritten = rewriteDocument(doc);
            inverse.observe(rewritten);
            Document.Builder existing = merged.get(rewritten.getRelativePath());
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

    for (Document.Builder doc : merged.values()) {
      Document withInverse = inverse.applyTo(doc.build());
      writer.emitTyped(Index.newBuilder().addDocuments(withInverse).build());
    }

    options.reporter.endProcessing();
  }

  // --- shard parsing -------------------------------------------------------

  private static final PathMatcher JAR_PATTERN =
      FileSystems.getDefault().getPathMatcher("glob:**.jar");

  private List<Index> parseShard(Path shardPath) throws IOException {
    if (JAR_PATTERN.matches(shardPath)) {
      List<Index> out = new ArrayList<>();
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

  private static Index parseBytes(byte[] bytes) throws IOException {
    CodedInputStream in = CodedInputStream.newInstance(bytes);
    in.setRecursionLimit(1000);
    return Index.parseFrom(in);
  }

  // --- rewriting -----------------------------------------------------------

  private Document rewriteDocument(Document doc) {
    Document.Builder builder = doc.toBuilder().clearOccurrences().clearSymbols();
    for (Occurrence occ : doc.getOccurrencesList()) {
      builder.addOccurrences(occ.toBuilder().setSymbol(rewriter.rewrite(occ.getSymbol())).build());
    }
    for (SymbolInformation info : doc.getSymbolsList()) {
      builder.addSymbols(rewriteSymbol(info));
    }
    return builder.build();
  }

  private SymbolInformation rewriteSymbol(SymbolInformation info) {
    SymbolInformation.Builder builder = info.toBuilder();
    builder.setSymbol(rewriter.rewrite(info.getSymbol()));
    if (!info.getEnclosingSymbol().isEmpty()) {
      builder.setEnclosingSymbol(rewriter.rewrite(info.getEnclosingSymbol()));
    }
    builder.clearRelationships();
    for (Relationship rel : info.getRelationshipsList()) {
      builder.addRelationships(
          rel.toBuilder().setSymbol(rewriter.rewrite(rel.getSymbol())).build());
    }
    return builder.build();
  }

  private void mergeInto(Document.Builder target, Document fresh) {
    target.addAllOccurrences(fresh.getOccurrencesList());
    target.addAllSymbols(fresh.getSymbolsList());
  }

  // --- metadata ------------------------------------------------------------

  private Index metadata() {
    return Index.newBuilder()
        .setMetadata(
            Metadata.newBuilder()
                .setVersion(ProtocolVersion.UnspecifiedProtocolVersion)
                .setProjectRoot(options.sourceroot.toUri().toString())
                .setTextDocumentEncoding(TextEncoding.UTF8)
                .setToolInfo(
                    ToolInfo.newBuilder()
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

    void observe(Document doc) {
      if (!enabled) return;
      for (SymbolInformation info : doc.getSymbolsList()) {
        if (info.getSymbol().isEmpty() || SymbolRewriter.isLocal(info.getSymbol())) continue;
        if (!supportsReferenceRelationship(info)) continue;
        for (Relationship rel : info.getRelationshipsList()) {
          if (!rel.getIsImplementation()) continue;
          if (rel.getSymbol().isEmpty() || SymbolRewriter.isLocal(rel.getSymbol())) continue;
          map.computeIfAbsent(rel.getSymbol(), k -> new ArrayList<>()).add(info.getSymbol());
        }
      }
    }

    Document applyTo(Document doc) {
      if (!enabled || map.isEmpty()) return doc;
      Document.Builder builder = doc.toBuilder().clearSymbols();
      for (SymbolInformation info : doc.getSymbolsList()) {
        List<String> overriders = map.get(info.getSymbol());
        if (overriders == null || overriders.isEmpty()) {
          builder.addSymbols(info);
          continue;
        }
        SymbolInformation.Builder s = info.toBuilder();
        for (String overrider : overriders) {
          s.addRelationships(
              Relationship.newBuilder()
                  .setSymbol(overrider)
                  .setIsImplementation(true)
                  .setIsReference(true));
        }
        builder.addSymbols(s.build());
      }
      return builder.build();
    }
  }

  private static boolean supportsReferenceRelationship(SymbolInformation info) {
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
  Stream<Document> documentsFromShards(List<Index> shards) {
    return shards.stream().flatMap(s -> s.getDocumentsList().stream()).map(this::rewriteDocument);
  }

  @SuppressWarnings("unused")
  Stream<Document> documentsFromShardsCollected(List<Index> shards) {
    return documentsFromShards(shards).collect(Collectors.toList()).stream();
  }
}
