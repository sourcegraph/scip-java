package com.sourcegraph.lsif_semanticdb;

public class LsifProcessingException extends Throwable {

  public LsifProcessingException(LsifTextDocument doc, Throwable cause) {
    super(doc.semanticdbPath.toString(), cause);
  }

  @Override
  public Throwable fillInStackTrace() {
    return this;
  }
}
