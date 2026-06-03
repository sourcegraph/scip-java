package com.sourcegraph.semanticdb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** Shared helper for serializing a single SemanticDB {@link Semanticdb.TextDocument} to disk. */
public final class SemanticdbWriter {
  private SemanticdbWriter() {}

  /**
   * Wraps {@code document} in a singleton {@link Semanticdb.TextDocuments} message and writes it to
   * {@code output}, creating parent directories as needed.
   */
  public static void writeTextDocument(Path output, Semanticdb.TextDocument document)
      throws IOException {
    byte[] bytes =
        Semanticdb.TextDocuments.newBuilder().addDocuments(document).build().toByteArray();
    Files.createDirectories(output.getParent());
    Files.write(output, bytes);
  }
}
