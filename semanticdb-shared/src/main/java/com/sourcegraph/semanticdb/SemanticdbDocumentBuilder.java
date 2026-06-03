package com.sourcegraph.semanticdb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Accumulator for the {@link Semanticdb.SymbolOccurrence} and {@link Semanticdb.SymbolInformation}
 * payloads produced by a SemanticDB-emitting compiler plugin, and assembler for the final {@link
 * Semanticdb.TextDocument}.
 *
 * <p>The builder enforces the canonical SemanticDB output policy shared by every producer in this
 * repository:
 *
 * <ul>
 *   <li>occurrences are deduplicated by {@code (range, symbol, role)} — additional fields like
 *       {@code enclosing_range} are not part of identity, so a later emission that happens to lose
 *       the enclosing range does not introduce a "duplicate" occurrence,
 *   <li>{@link Semanticdb.SymbolInformation}s are deduplicated by {@code symbol},
 *   <li>in both cases the first emission wins, which lets multi-pass producers (e.g. the javac
 *       plugin, which scans the same compilation unit on every {@code ANALYZE} round and where only
 *       the first round has complete position information for already-attributed types) accumulate
 *       across rounds without losing data,
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

  private final Map<OccurrenceKey, Semanticdb.SymbolOccurrence> occurrences = new LinkedHashMap<>();
  private final Map<String, Semanticdb.SymbolInformation> symbols = new LinkedHashMap<>();

  /**
   * Adds an occurrence, keeping the first emission for any given {@code (range, symbol, role)}
   * triple.
   */
  public void addOccurrence(Semanticdb.SymbolOccurrence occurrence) {
    occurrences.putIfAbsent(new OccurrenceKey(occurrence), occurrence);
  }

  /** Adds a symbol information entry, keeping the first emission per {@code symbol}. */
  public void addSymbol(Semanticdb.SymbolInformation symbol) {
    symbols.putIfAbsent(symbol.getSymbol(), symbol);
  }

  /**
   * Assembles a {@link Semanticdb.TextDocument} carrying the accumulated occurrences (sorted by
   * range) and symbol informations.
   */
  public Semanticdb.TextDocument build(
      Semanticdb.Language language, String uri, String text, String md5) {
    List<Semanticdb.SymbolOccurrence> sortedOccurrences = new ArrayList<>(occurrences.values());
    sortedOccurrences.sort(OCCURRENCE_ORDER);
    return Semanticdb.TextDocument.newBuilder()
        .setSchema(Semanticdb.Schema.SEMANTICDB4)
        .setLanguage(language)
        .setUri(uri)
        .setText(text)
        .setMd5(md5)
        .addAllOccurrences(sortedOccurrences)
        .addAllSymbols(symbols.values())
        .build();
  }

  private static final class OccurrenceKey {
    private final Semanticdb.Range range;
    private final String symbol;
    private final Semanticdb.SymbolOccurrence.Role role;

    OccurrenceKey(Semanticdb.SymbolOccurrence occurrence) {
      this.range = occurrence.hasRange() ? occurrence.getRange() : null;
      this.symbol = occurrence.getSymbol();
      this.role = occurrence.getRole();
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      if (!(other instanceof OccurrenceKey)) return false;
      OccurrenceKey that = (OccurrenceKey) other;
      return role == that.role
          && Objects.equals(range, that.range)
          && Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
      return Objects.hash(range, symbol, role);
    }
  }
}
