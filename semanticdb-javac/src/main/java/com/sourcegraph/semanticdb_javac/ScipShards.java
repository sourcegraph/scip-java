package com.sourcegraph.semanticdb_javac;

import org.scip_code.scip.Document;
import org.scip_code.scip.Index;
import org.scip_code.scip.Relationship;
import org.scip_code.scip.SymbolInformation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Pure merge helpers for SCIP shards produced by the compiler plugin.
 *
 * <p>Each source file produces a self-contained {@link Index} shard containing a single {@link
 * Document}. When the compiler runs multiple analyze rounds for the same source (e.g. during
 * annotation processing), the freshly built shard is merged with the one already on disk by
 * combining their document lists and deduplicating occurrences, symbols and relationships.
 */
public final class ScipShards {

  private ScipShards() {}

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
    LinkedHashMap<String, SymbolInformation> bySymbol = new LinkedHashMap<>();
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
    LinkedHashMap<Relationship, Relationship> rels = new LinkedHashMap<>();
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
