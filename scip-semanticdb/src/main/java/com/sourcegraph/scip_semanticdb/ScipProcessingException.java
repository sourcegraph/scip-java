package com.sourcegraph.scip_semanticdb;

public class ScipProcessingException extends Throwable {

  public ScipProcessingException(ScipTextDocument doc, Throwable cause) {
    super(doc.semanticdbPath.toString(), cause);
  }

  @Override
  public Throwable fillInStackTrace() {
    return this;
  }
}
