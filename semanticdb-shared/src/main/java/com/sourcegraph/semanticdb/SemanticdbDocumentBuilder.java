package com.sourcegraph.semanticdb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Accumulator for {@link Semanticdb.SymbolOccurrence}/{@link Semanticdb.SymbolInformation} that
 * assembles a final {@link Semanticdb.TextDocument}. First emission wins: occurrences are
 * deduplicated by {@code (range, symbol, role)}, symbols by {@code symbol}; occurrences are sorted
 * by start position. Contains no compiler-API dependencies.
 */
public final class SemanticdbDocumentBuilder {
  private static final Comparator<Semanticdb.SymbolOccurrence> OCCURRENCE_ORDER =
      Comparator.<Semanticdb.SymbolOccurrence>comparingInt(o -> o.getRange().getStartLine())
          .thenComparingInt(o -> o.getRange().getStartCharacter());

  private final Map<OccurrenceKey, Semanticdb.SymbolOccurrence> occurrences = new LinkedHashMap<>();
  private final Map<String, Semanticdb.SymbolInformation> symbols = new LinkedHashMap<>();

  public void addOccurrence(Semanticdb.SymbolOccurrence occurrence) {
    occurrences.putIfAbsent(new OccurrenceKey(occurrence), occurrence);
  }

  public void addSymbol(Semanticdb.SymbolInformation symbol) {
    symbols.putIfAbsent(symbol.getSymbol(), symbol);
  }

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
