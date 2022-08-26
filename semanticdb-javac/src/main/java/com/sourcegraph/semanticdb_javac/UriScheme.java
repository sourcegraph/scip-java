package com.sourcegraph.semanticdb_javac;

public enum UriScheme {
  DEFAULT,
  /** @deprecated Use ZINC instead */
  @Deprecated
  SBT,
  BAZEL,
  ZINC
}
