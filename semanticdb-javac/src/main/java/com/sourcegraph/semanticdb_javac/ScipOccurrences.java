package com.sourcegraph.semanticdb_javac;

import com.sourcegraph.Scip;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * Helpers for deduplicating SCIP {@link Scip.Occurrence} entries by their {@code (symbol, range,
 * roles)} key. Variants that differ only in whether {@code enclosing_range} is set are collapsed,
 * preferring the one that carries the enclosing range.
 */
final class ScipOccurrences {

  private ScipOccurrences() {}

  /** Returns a new list with duplicate occurrences collapsed in insertion order. */
  static List<Scip.Occurrence> deduplicate(List<Scip.Occurrence> occurrences) {
    LinkedHashMap<Key, Scip.Occurrence> out = new LinkedHashMap<>();
    for (Scip.Occurrence occ : occurrences) put(out, occ);
    return new ArrayList<>(out.values());
  }

  /** Inserts {@code occ} into {@code out}, collapsing duplicates by {@link Key}. */
  static void put(LinkedHashMap<Key, Scip.Occurrence> out, Scip.Occurrence occ) {
    Key key = Key.of(occ);
    Scip.Occurrence existing = out.get(key);
    if (existing == null) {
      out.put(key, occ);
      return;
    }
    if (existing.getEnclosingRangeCount() == 0 && occ.getEnclosingRangeCount() > 0) {
      out.put(key, occ);
    }
  }

  static final class Key {
    final String symbol;
    final List<Integer> range;
    final int roles;

    private Key(String symbol, List<Integer> range, int roles) {
      this.symbol = symbol;
      this.range = range;
      this.roles = roles;
    }

    static Key of(Scip.Occurrence occ) {
      return new Key(occ.getSymbol(), occ.getRangeList(), occ.getSymbolRoles());
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof Key)) return false;
      Key other = (Key) o;
      return roles == other.roles && symbol.equals(other.symbol) && range.equals(other.range);
    }

    @Override
    public int hashCode() {
      return Objects.hash(symbol, range, roles);
    }
  }
}
