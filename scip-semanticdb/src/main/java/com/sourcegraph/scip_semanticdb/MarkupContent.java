package com.sourcegraph.scip_semanticdb;

import com.sourcegraph.lsif_protocol.MarkupKind;

public class MarkupContent {
  public final String value;
  public final MarkupKind kind;

  public MarkupContent(MarkupKind kind, String value) {
    this.value = value;
    this.kind = kind;
  }
}
