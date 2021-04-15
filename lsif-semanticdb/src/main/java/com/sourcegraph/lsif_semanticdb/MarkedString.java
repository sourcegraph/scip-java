package com.sourcegraph.lsif_semanticdb;

public class MarkedString {
  public final String value;
  public final String language;

  public MarkedString(String language, String value) {
    this.value = value;
    this.language = language;
  }
}
