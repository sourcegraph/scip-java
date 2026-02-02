package com.sourcegraph.scip_semanticdb;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/** Low-level methods to write raw SCIP bytes into the output stream. */
public class ScipOutputStream {
  private final ScipOutputFormat format;
  private final OutputStream out;
  private final ConcurrentLinkedDeque<byte[]> buffer;
  private final AtomicBoolean isFlushing;
  private static final byte[] NEWLINE = "\n".getBytes(StandardCharsets.UTF_8);

  public ScipOutputStream(ScipOutputFormat format, OutputStream out) {
    this.format = format;
    this.out = out;
    this.buffer = new ConcurrentLinkedDeque<>();
    this.isFlushing = new AtomicBoolean(false);
  }

  public void write(byte[] bytes) {
    if (bytes.length == 0) return;
    buffer.add(bytes);
  }

  public void flush() throws IOException {
    if (isFlushing.compareAndSet(false, true)) {
      byte[] bytes = buffer.poll();
      while (bytes != null) {
        out.write(bytes);
        if (format.isNewlineDelimitedJSON()) {
          out.write(NEWLINE);
        }
        bytes = buffer.poll();
      }
      out.flush();
      isFlushing.set(false);
    }
  }
}
