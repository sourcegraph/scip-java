package com.sourcegraph.scip_semanticdb;

/** Whether to generate index.scip (Protobuf) or index.scip.ndjson (newline-delimited JSON). */
public enum ScipOutputFormat {
  TYPED_PROTOBUF,
  TYPED_NDJSON,
  UNKNOWN;

  public boolean isNewlineDelimitedJSON() {
    return this == TYPED_NDJSON;
  }

  public static ScipOutputFormat fromFilename(String name) {
    if (name.endsWith(".scip")) return TYPED_PROTOBUF;
    if (name.endsWith(".scip.ndjson")) return TYPED_NDJSON;
    return UNKNOWN;
  }
}
