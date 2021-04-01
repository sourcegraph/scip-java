package com.sourcegraph.lsif_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb;

import java.util.HashMap;

public class Symtab {
  public final HashMap<String, Semanticdb.SymbolInformation> symbols = new HashMap<>();

  public Symtab(Semanticdb.TextDocument document) {
    for (Semanticdb.SymbolInformation symbolInformation : document.getSymbolsList()) {
      symbols.put(symbolInformation.getSymbol(), symbolInformation);
    }
  }
}
