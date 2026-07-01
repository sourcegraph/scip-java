package org.scip_code.scip_java.shared;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.scip_code.scip.Document;
import org.scip_code.scip.Index;

/** Serializes a single SCIP {@link Document} as a singleton {@link Index} on disk. */
public final class ScipShardWriter {
  private ScipShardWriter() {}

  /**
   * Wraps {@code document} in a singleton {@link Index} message (no {@code Metadata}) and writes it
   * to {@code output}, creating parent directories as needed. The aggregator owns the per-index
   * metadata, so per-source shards intentionally omit it.
   */
  public static void writeShard(Path output, Document document) throws IOException {
    byte[] bytes = Index.newBuilder().addDocuments(document).build().toByteArray();
    Files.createDirectories(output.getParent());
    Files.write(output, bytes);
  }
}
