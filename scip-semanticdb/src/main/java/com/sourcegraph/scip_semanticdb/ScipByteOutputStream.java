package com.sourcegraph.scip_semanticdb;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

/** Wrapper around a ByteArrayOutputStream and OutputStreamWriter. */
public class ScipByteOutputStream {
  public final ByteArrayOutputStream output;
  public final OutputStreamWriter writer;

  public ScipByteOutputStream() {
    this.output = new ByteArrayOutputStream();
    this.writer = new OutputStreamWriter(output);
  }
}
