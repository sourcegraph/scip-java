package com.sourcegraph.scip_semanticdb;

/**
 * API to hook into the event stream of the scip-semanticdb command.
 *
 * <p>The scip-semanticdb command doesn't fail fast on the first error. Clients are expected to
 * handle errors through the <code>error</code> method.
 */
public abstract class ScipSemanticdbReporter {
  public void error(Throwable e) {}

  public void error(String message) {
    error(new RuntimeException(message));
  }

  public void startProcessing(int taskSize) {}

  public void processedOneItem() {}

  public void endProcessing() {}

  public boolean hasErrors() {
    return false;
  }
}
