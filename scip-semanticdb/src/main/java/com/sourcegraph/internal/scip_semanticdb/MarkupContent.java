package com.sourcegraph.internal.scip_semanticdb;

import com.sourcegraph.internal.lsif_protocol.MarkupKind;

public class MarkupContent {
  public final String value;
  public final MarkupKind kind;

  public MarkupContent(MarkupKind kind, String value) {
    this.value = value;
    this.kind = kind;
  }
}
