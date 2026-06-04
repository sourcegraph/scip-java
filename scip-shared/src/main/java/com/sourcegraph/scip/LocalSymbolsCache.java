package com.sourcegraph.scip;

import java.util.Map;
import java.util.function.IntFunction;

/** Per-file cache mapping compiler symbols to monotonically numbered SCIP local symbols. */
public final class LocalSymbolsCache<K, V> {
  private final Map<K, V> symbols;
  private final IntFunction<V> factory;
  private int counter = 0;

  public LocalSymbolsCache(Map<K, V> backing, IntFunction<V> factory) {
    this.symbols = backing;
    this.factory = factory;
  }

  public V get(K key) {
    return symbols.get(key);
  }

  public V put(K key) {
    V value = factory.apply(counter++);
    symbols.put(key, value);
    return value;
  }

  public int getSize() {
    return symbols.size();
  }
}
