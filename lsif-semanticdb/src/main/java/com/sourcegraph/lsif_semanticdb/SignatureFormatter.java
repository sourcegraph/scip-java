package com.sourcegraph.lsif_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb.*;

public class SignatureFormatter {
  private final StringBuilder s = new StringBuilder();
  private final SymbolInformation symbolInformation;
  private final Symtab symtab;

  public SignatureFormatter(SymbolInformation symbolInformation, Symtab symtab) {
    this.symbolInformation = symbolInformation;
    this.symtab = symtab;
  }

  public String formatSymbol() {
    return s.toString();
  }

}
