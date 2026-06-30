package com.sourcegraph.scip;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.scip_code.scip.Document;
import org.scip_code.scip.Occurrence;
import org.scip_code.scip.SymbolInformation;

/**
 * Accumulator for SCIP {@link Occurrence}/{@link SymbolInformation} that assembles a final SCIP
 * {@link Document}.
 *
 * <p>First emission wins: occurrences are deduplicated by {@code (range, symbol, roles)}, symbols
 * by {@code symbol}; occurrences are sorted by start position. Contains no compiler-API
 * dependencies.
 */
public final class ScipDocumentBuilder {
  private static final Comparator<Occurrence> OCCURRENCE_ORDER =
      Comparator.<Occurrence>comparingInt(ScipRanges::rangeStartLine)
          .thenComparingInt(ScipRanges::rangeStartCharacter);

  private final Map<OccurrenceKey, Occurrence> occurrences = new LinkedHashMap<>();
  private final Map<String, SymbolInformation> symbols = new LinkedHashMap<>();

  public void addOccurrence(Occurrence occurrence) {
    if (occurrence.getSymbol().isEmpty()) return;
    occurrences.putIfAbsent(new OccurrenceKey(occurrence), occurrence);
  }

  public void addSymbol(SymbolInformation symbol) {
    if (symbol.getSymbol().isEmpty()) return;
    symbols.putIfAbsent(symbol.getSymbol(), symbol);
  }

  public Document build(String language, String relativePath, String text) {
    List<Occurrence> sortedOccurrences = new ArrayList<>(occurrences.values());
    sortedOccurrences.sort(OCCURRENCE_ORDER);
    return Document.newBuilder()
        .setLanguage(language)
        .setRelativePath(relativePath)
        .setText(text == null ? "" : text)
        .addAllOccurrences(sortedOccurrences)
        .addAllSymbols(symbols.values())
        .build();
  }

  private static final class OccurrenceKey {
    private final ScipRanges.Range range;
    private final String symbol;
    private final int roles;

    OccurrenceKey(Occurrence occurrence) {
      this.range = ScipRanges.range(occurrence);
      this.symbol = occurrence.getSymbol();
      this.roles = occurrence.getSymbolRoles();
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      if (!(other instanceof OccurrenceKey that)) return false;
      return roles == that.roles
          && Objects.equals(range, that.range)
          && Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
      return Objects.hash(range, symbol, roles);
    }
  }
}
