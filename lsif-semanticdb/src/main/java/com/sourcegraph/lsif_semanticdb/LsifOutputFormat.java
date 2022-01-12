package com.sourcegraph.lsif_semanticdb;

/**
 * Whether to generate dump.lsif (JSON) or dump.lsif-protobuf (Protobuf).
 *
 * <p>The Protobuf format is experimental and currently only exists as a proof-of-concept.
 */
public enum LsifOutputFormat {
  GRAPH_NDJSON,
  GRAPH_PROTOBUF,
  TYPED_PROTOBUF,
  TYPED_NDJSON,
  UNKNOWN;

  public boolean isTyped() {
    return this == TYPED_NDJSON || this == TYPED_PROTOBUF;
  }

  public boolean isNewlineDelimitedJSON() {
    return this == GRAPH_NDJSON || this == TYPED_NDJSON;
  }

  public static LsifOutputFormat fromFilename(String name) {
    if (name.endsWith(".lsif")) return GRAPH_NDJSON;
    if (name.endsWith(".lsif-protobuf")) return GRAPH_PROTOBUF;
    if (name.endsWith(".lsif-typed")) return TYPED_PROTOBUF;
    if (name.endsWith(".lsif-typed.ndjson")) return TYPED_NDJSON;
    return UNKNOWN;
  }
}
