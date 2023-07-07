package com.sourcegraph.scip_semanticdb;

public class MessageOnlyException extends Throwable {
  public MessageOnlyException(String message) {
    super(message);
  }

  @Override
  public synchronized Throwable fillInStackTrace() {
    return this;
  }
}
