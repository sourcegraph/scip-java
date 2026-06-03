package com.sourcegraph.semanticdb_javac;

import org.scip_code.scip.Occurrence;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * Accumulator that deduplicates SCIP {@link Occurrence} entries by {@code (symbol, range, roles)}.
 * Variants differing only in whether {@code enclosing_range} is set are collapsed, preferring the
 * one that carries it.
 */
final class ScipOccurrences {

  private final LinkedHashMap<Key, Occurrence> out = new LinkedHashMap<>();

  void add(Occurrence occ) {
    Key key = Key.of(occ);
    Occurrence existing = out.get(key);
    if (existing == null) {
      out.put(key, occ);
      return;
    }
    if (existing.getEnclosingRangeCount() == 0 && occ.getEnclosingRangeCount() > 0) {
      out.put(key, occ);
    }
  }

  void addAll(Iterable<Occurrence> occs) {
    for (Occurrence occ : occs) add(occ);
  }

  Collection<Occurrence> values() {
    return out.values();
  }

  private static final class Key {
    final String symbol;
    final List<Integer> range;
    final int roles;

    private Key(String symbol, List<Integer> range, int roles) {
      this.symbol = symbol;
      this.range = range;
      this.roles = roles;
    }

    static Key of(Occurrence occ) {
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
