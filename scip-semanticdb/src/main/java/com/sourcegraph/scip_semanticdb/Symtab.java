package com.sourcegraph.scip_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb;

import java.util.HashMap;

public class Symtab {
  public final HashMap<String, Semanticdb.SymbolInformation> symbols = new HashMap<>();

  public Symtab(Semanticdb.TextDocument document) {
    for (Semanticdb.SymbolInformation symbolInformation : document.getSymbolsList()) {
      symbols.put(symbolInformation.getSymbol(), symbolInformation);
    }
  }

  public Symtab withHardlinks(Semanticdb.Scope scope) {
    Symtab hardlinkSymtab = new Symtab(Semanticdb.TextDocument.getDefaultInstance());
    hardlinkSymtab.symbols.putAll(this.symbols);
    for (int i = 0; i < scope.getHardlinksCount(); i++) {
      Semanticdb.SymbolInformation info = scope.getHardlinks(i);
      hardlinkSymtab.symbols.put(info.getSymbol(), info);
    }
    return hardlinkSymtab;
  }
}
