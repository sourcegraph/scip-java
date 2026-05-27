package com.sourcegraph.semanticdb_javac;

import com.sourcegraph.Scip;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Writes and merges per-source SCIP shards produced by the compiler plugin.
 *
 * <p>Each source file produces a self-contained {@link Scip.Index} shard containing a single {@link
 * Scip.Document}. When a shard already exists on disk (e.g. during annotation processing rounds),
 * the new document is merged into the existing one, deduplicating occurrences, symbols and
 * relationships.
 */
public final class ScipShardWriter {

  private ScipShardWriter() {}

  /**
   * Writes the given {@code shard} to {@code output}, creating parent directories as needed. If
   * {@code output} already exists, the existing shard is parsed and merged with the new one.
   */
  public static void writeOrMerge(Path output, Scip.Index shard) throws IOException {
    Files.createDirectories(output.getParent());
    if (Files.exists(output)) {
      Scip.Index existing;
      try (InputStream is = Files.newInputStream(output)) {
        existing = Scip.Index.parseFrom(is);
      }
      shard = merge(existing, shard);
    }
    Files.write(output, shard.toByteArray());
  }

  /**
   * Merges two SCIP shards by combining their document lists. Documents that share a {@code
   * relative_path} have their occurrences, symbols and external symbols deduplicated.
   */
  static Scip.Index merge(Scip.Index a, Scip.Index b) {
    Scip.Index.Builder builder = Scip.Index.newBuilder();
    if (b.hasMetadata()) {
      builder.setMetadata(b.getMetadata());
    } else if (a.hasMetadata()) {
      builder.setMetadata(a.getMetadata());
    }

    LinkedHashMap<String, Scip.Document> byPath = new LinkedHashMap<>();
    for (Scip.Document doc : a.getDocumentsList()) {
      byPath.put(doc.getRelativePath(), doc);
    }
    for (Scip.Document doc : b.getDocumentsList()) {
      Scip.Document existing = byPath.get(doc.getRelativePath());
      if (existing == null) {
        byPath.put(doc.getRelativePath(), doc);
      } else {
        byPath.put(doc.getRelativePath(), mergeDocuments(existing, doc));
      }
    }
    builder.addAllDocuments(byPath.values());

    // External symbols: deduplicate by symbol string. Last writer wins to keep latest data.
    LinkedHashMap<String, Scip.SymbolInformation> externals = new LinkedHashMap<>();
    for (Scip.SymbolInformation s : a.getExternalSymbolsList()) externals.put(s.getSymbol(), s);
    for (Scip.SymbolInformation s : b.getExternalSymbolsList()) externals.put(s.getSymbol(), s);
    builder.addAllExternalSymbols(externals.values());

    return builder.build();
  }

  private static Scip.Document mergeDocuments(Scip.Document a, Scip.Document b) {
    Scip.Document.Builder builder = b.toBuilder().clearOccurrences().clearSymbols();
    // Use the most recent metadata for language/relative_path/text/encoding which already
    // come from b via toBuilder().

    // Deduplicate occurrences by (range, symbol, roles). Variants that differ only in
    // enclosing_range get collapsed, preferring the one that carries the enclosing range.
    LinkedHashMap<ScipOccurrences.Key, Scip.Occurrence> occurrences = new LinkedHashMap<>();
    for (Scip.Occurrence occ : a.getOccurrencesList()) ScipOccurrences.put(occurrences, occ);
    for (Scip.Occurrence occ : b.getOccurrencesList()) ScipOccurrences.put(occurrences, occ);
    builder.addAllOccurrences(occurrences.values());

    // Deduplicate symbols by symbol string; merge relationships and documentation.
    Map<String, Scip.SymbolInformation> bySymbol = new LinkedHashMap<>();
    for (Scip.SymbolInformation info : a.getSymbolsList()) bySymbol.put(info.getSymbol(), info);
    for (Scip.SymbolInformation info : b.getSymbolsList()) {
      Scip.SymbolInformation existing = bySymbol.get(info.getSymbol());
      bySymbol.put(info.getSymbol(), existing == null ? info : mergeSymbol(existing, info));
    }
    builder.addAllSymbols(bySymbol.values());

    return builder.build();
  }

  private static Scip.SymbolInformation mergeSymbol(
      Scip.SymbolInformation a, Scip.SymbolInformation b) {
    Scip.SymbolInformation.Builder builder = b.toBuilder();
    // Merge relationships, deduplicating by structural equality with deterministic ordering.
    Map<Scip.Relationship, Scip.Relationship> rels = new LinkedHashMap<>();
    for (Scip.Relationship r : a.getRelationshipsList()) rels.put(r, r);
    for (Scip.Relationship r : b.getRelationshipsList()) rels.put(r, r);
    builder.clearRelationships().addAllRelationships(rels.values());

    // Merge documentation, preserving order and avoiding duplicates.
    List<String> docs = new ArrayList<>(a.getDocumentationList());
    for (String d : b.getDocumentationList()) {
      if (!docs.contains(d)) docs.add(d);
    }
    builder.clearDocumentation().addAllDocumentation(docs);

    return builder.build();
  }
}
