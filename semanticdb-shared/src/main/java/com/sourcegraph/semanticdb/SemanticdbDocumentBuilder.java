package com.sourcegraph.semanticdb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Accumulator for the {@link Semanticdb.SymbolOccurrence} and {@link Semanticdb.SymbolInformation}
 * payloads produced by a single SemanticDB-emitting compiler plugin, and assembler for the final
 * {@link Semanticdb.TextDocument}.
 *
 * <p>The builder enforces the canonical SemanticDB output policy shared by every producer in this
 * repository:
 *
 * <ul>
 *   <li>exact-duplicate {@link Semanticdb.SymbolOccurrence}s and {@link
 *       Semanticdb.SymbolInformation}s are suppressed,
 *   <li>occurrences are sorted by {@code (startLine, startCharacter)} before being written to the
 *       assembled {@link Semanticdb.TextDocument},
 *   <li>the assembled document is stamped with {@link Semanticdb.Schema#SEMANTICDB4} and the
 *       caller-supplied {@link Semanticdb.Language}.
 * </ul>
 *
 * <p>Compiler-specific concerns (AST traversal, symbol resolution, range computation, text/MD5
 * acquisition, language selection) stay in the plugins; this class is intentionally protobuf-only
 * and contains no compiler-API dependencies.
 */
public final class SemanticdbDocumentBuilder {
  private static final Comparator<Semanticdb.SymbolOccurrence> OCCURRENCE_ORDER =
      Comparator.<Semanticdb.SymbolOccurrence>comparingInt(o -> o.getRange().getStartLine())
          .thenComparingInt(o -> o.getRange().getStartCharacter());

  private final List<Semanticdb.SymbolOccurrence> occurrences = new ArrayList<>();
  private final List<Semanticdb.SymbolInformation> symbols = new ArrayList<>();
  private final Set<Semanticdb.SymbolOccurrence> seenOccurrences = new HashSet<>();
  private final Set<Semanticdb.SymbolInformation> seenSymbols = new HashSet<>();

  /** Adds an occurrence to the document, suppressing exact duplicates. */
  public void addOccurrence(Semanticdb.SymbolOccurrence occurrence) {
    if (seenOccurrences.add(occurrence)) {
      occurrences.add(occurrence);
    }
  }

  /** Adds a symbol information entry to the document, suppressing exact duplicates. */
  public void addSymbol(Semanticdb.SymbolInformation symbol) {
    if (seenSymbols.add(symbol)) {
      symbols.add(symbol);
    }
  }

  /**
   * Assembles a {@link Semanticdb.TextDocument} carrying the accumulated occurrences (sorted by
   * range) and symbol informations.
   */
  public Semanticdb.TextDocument build(
      Semanticdb.Language language, String uri, String text, String md5) {
    occurrences.sort(OCCURRENCE_ORDER);
    return Semanticdb.TextDocument.newBuilder()
        .setSchema(Semanticdb.Schema.SEMANTICDB4)
        .setLanguage(language)
        .setUri(uri)
        .setText(text)
        .setMd5(md5)
        .addAllOccurrences(occurrences)
        .addAllSymbols(symbols)
        .build();
  }
}
