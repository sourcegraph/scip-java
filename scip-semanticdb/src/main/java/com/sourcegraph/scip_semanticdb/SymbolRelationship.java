package com.sourcegraph.scip_semanticdb;

public class SymbolRelationship {
  public final String from;
  public final String to;

  public SymbolRelationship(String from, String to) {
    this.from = from;
    this.to = to;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }
}
