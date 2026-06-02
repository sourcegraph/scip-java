package com.sourcegraph.semanticdb_javac;

import org.scip_code.scip.Document;
import org.scip_code.scip.Index;
import org.scip_code.scip.Occurrence;
import org.scip_code.scip.Relationship;
import org.scip_code.scip.SymbolInformation;

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
 * <p>Each source file produces a self-contained {@link Index} shard containing a single {@link
 * Document}. When a shard already exists on disk (e.g. during annotation processing rounds), the
 * new document is merged into the existing one, deduplicating occurrences, symbols and
 * relationships.
 */
public final class ScipShardWriter {

  private ScipShardWriter() {}

  /**
   * Writes the given {@code shard} to {@code output}, creating parent directories as needed. If
   * {@code output} already exists, the existing shard is parsed and merged with the new one.
   */
  public static void writeOrMerge(Path output, Index shard) throws IOException {
    Files.createDirectories(output.getParent());
    if (Files.exists(output)) {
      Index existing;
      try (InputStream is = Files.newInputStream(output)) {
        existing = Index.parseFrom(is);
      }
      shard = merge(existing, shard);
    }
    Files.write(output, shard.toByteArray());
  }

  /**
   * Merges two SCIP shards by combining their document lists. Documents that share a {@code
   * relative_path} have their occurrences, symbols and external symbols deduplicated.
   */
  static Index merge(Index a, Index b) {
    Index.Builder builder = Index.newBuilder();
    if (b.hasMetadata()) {
      builder.setMetadata(b.getMetadata());
    } else if (a.hasMetadata()) {
      builder.setMetadata(a.getMetadata());
    }

    LinkedHashMap<String, Document> byPath = new LinkedHashMap<>();
    for (Document doc : a.getDocumentsList()) {
      byPath.put(doc.getRelativePath(), doc);
    }
    for (Document doc : b.getDocumentsList()) {
      Document existing = byPath.get(doc.getRelativePath());
      if (existing == null) {
        byPath.put(doc.getRelativePath(), doc);
      } else {
        byPath.put(doc.getRelativePath(), mergeDocuments(existing, doc));
      }
    }
    builder.addAllDocuments(byPath.values());

    // External symbols: deduplicate by symbol string. Last writer wins to keep latest data.
    LinkedHashMap<String, SymbolInformation> externals = new LinkedHashMap<>();
    for (SymbolInformation s : a.getExternalSymbolsList()) externals.put(s.getSymbol(), s);
    for (SymbolInformation s : b.getExternalSymbolsList()) externals.put(s.getSymbol(), s);
    builder.addAllExternalSymbols(externals.values());

    return builder.build();
  }

  private static Document mergeDocuments(Document a, Document b) {
    Document.Builder builder = b.toBuilder().clearOccurrences().clearSymbols();
    // Use the most recent metadata for language/relative_path/text/encoding which already
    // come from b via toBuilder().

    // Deduplicate occurrences by (range, symbol, roles). Variants that differ only in
    // enclosing_range get collapsed, preferring the one that carries the enclosing range.
    ScipOccurrences occurrences = new ScipOccurrences();
    occurrences.addAll(a.getOccurrencesList());
    occurrences.addAll(b.getOccurrencesList());
    builder.addAllOccurrences(occurrences.values());

    // Deduplicate symbols by symbol string; merge relationships and documentation.
    Map<String, SymbolInformation> bySymbol = new LinkedHashMap<>();
    for (SymbolInformation info : a.getSymbolsList()) bySymbol.put(info.getSymbol(), info);
    for (SymbolInformation info : b.getSymbolsList()) {
      SymbolInformation existing = bySymbol.get(info.getSymbol());
      bySymbol.put(info.getSymbol(), existing == null ? info : mergeSymbol(existing, info));
    }
    builder.addAllSymbols(bySymbol.values());

    return builder.build();
  }

  private static SymbolInformation mergeSymbol(SymbolInformation a, SymbolInformation b) {
    SymbolInformation.Builder builder = b.toBuilder();
    // Merge relationships, deduplicating by structural equality with deterministic ordering.
    Map<Relationship, Relationship> rels = new LinkedHashMap<>();
    for (Relationship r : a.getRelationshipsList()) rels.put(r, r);
    for (Relationship r : b.getRelationshipsList()) rels.put(r, r);
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
