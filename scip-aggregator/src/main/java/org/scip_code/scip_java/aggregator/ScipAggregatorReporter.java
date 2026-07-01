package org.scip_code.scip_java.aggregator;

/**
 * API to hook into the event stream of the scip-aggregator command.
 *
 * <p>The scip-aggregator command doesn't fail fast on the first error. Clients are expected to
 * handle errors through the <code>error</code> method.
 */
public abstract class ScipAggregatorReporter {
  public void error(Throwable e) {}

  public void error(String message) {
    error(new MessageOnlyException(message));
  }

  public void warning(String message) {}

  public void startProcessing(int taskSize) {}

  public void processedOneItem() {}

  public void endProcessing() {}

  public boolean hasErrors() {
    return false;
  }
}
