package com.sourcegraph.lsif_semanticdb;

/**
 * API to hook into the event stream of the lsif-semanticdb command.
 *
 * <p>The lsif-semanticdb command doesn't fail fast on the first error. Clients are expected to
 * handle errors through the <code>error</code> method.
 */
public abstract class LsifSemanticdbReporter {
  public void error(Throwable e) {}

  public void startProcessing(int taskSize) {}

  public void processedOneItem() {}

  public void endProcessing() {}

  public boolean hasErrors() {
    return false;
  }
}
