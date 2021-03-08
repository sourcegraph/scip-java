package com.sourcegraph.lsif_semanticdb;

/**
 * Whether to generate dump.lsif (JSON) or dump.lsif-protobuf (Protobuf).
 *
 * <p>The Protobuf format is experimental and currently only exists as a proof-of-concept.
 */
public enum LsifOutputFormat {
  JSON,
  PROTOBUF
}
