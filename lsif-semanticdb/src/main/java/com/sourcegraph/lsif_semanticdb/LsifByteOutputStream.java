package com.sourcegraph.lsif_semanticdb;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

/** Wrapper around a ByteArrayOutputStream and OutputStreamWriter. */
public class LsifByteOutputStream {
  public final ByteArrayOutputStream output;
  public final OutputStreamWriter writer;

  public LsifByteOutputStream() {
    this.output = new ByteArrayOutputStream();
    this.writer = new OutputStreamWriter(output);
  }
}
