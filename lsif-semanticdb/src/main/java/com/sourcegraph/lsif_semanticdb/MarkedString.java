package com.sourcegraph.lsif_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb;

public class MarkedString {
  public final String value;
  public final Semanticdb.Language language;

  public MarkedString(Semanticdb.Language language, String value) {
    this.value = value;
    this.language = language;
  }
}
