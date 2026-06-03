package com.sourcegraph.semanticdb_javac;

import org.scip_code.scip.Document;
import org.scip_code.scip.Index;
import org.scip_code.scip.Relationship;
import org.scip_code.scip.SymbolInformation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

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

  /** Merges two shards: documents sharing a {@code relative_path} are dedup-merged. */
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

    // External symbols: last writer wins to keep the most recent data.
    LinkedHashMap<String, SymbolInformation> externals = new LinkedHashMap<>();
    for (SymbolInformation s : a.getExternalSymbolsList()) externals.put(s.getSymbol(), s);
    for (SymbolInformation s : b.getExternalSymbolsList()) externals.put(s.getSymbol(), s);
    builder.addAllExternalSymbols(externals.values());

    return builder.build();
  }

  private static Document mergeDocuments(Document a, Document b) {
    // b.toBuilder() carries forward the most recent language/relative_path/text/encoding.
    Document.Builder builder = b.toBuilder().clearOccurrences().clearSymbols();

    ScipOccurrences occurrences = new ScipOccurrences();
    occurrences.addAll(a.getOccurrencesList());
    occurrences.addAll(b.getOccurrencesList());
    builder.addAllOccurrences(occurrences.values());

    // Dedup symbols by symbol string; merge relationships and documentation.
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
    // Dedup relationships by structural equality; preserve insertion order.
    LinkedHashSet<Relationship> rels = new LinkedHashSet<>(a.getRelationshipsList());
    rels.addAll(b.getRelationshipsList());
    builder.clearRelationships().addAllRelationships(rels);

    // Dedup documentation; preserve insertion order.
    List<String> docs = new ArrayList<>(a.getDocumentationList());
    for (String d : b.getDocumentationList()) {
      if (!docs.contains(d)) docs.add(d);
    }
    builder.clearDocumentation().addAllDocumentation(docs);

    return builder.build();
  }
}
