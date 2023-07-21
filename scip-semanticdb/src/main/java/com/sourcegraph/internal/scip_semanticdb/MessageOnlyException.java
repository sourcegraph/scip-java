package com.sourcegraph.internal.scip_semanticdb;

/**
 * Exception that doesn't fill out the stack trace, it only prints out the message.
 *
 * <p>Use this exception if you want prettier console output without stack trace noise.
 */
public class MessageOnlyException extends Throwable {
  public MessageOnlyException(String message) {
    super(message);
  }

  @Override
  public synchronized Throwable fillInStackTrace() {
    return this;
  }
}
