package com.sourcegraph.scip_semanticdb;

/** Utility to deal with a group of IDs for a result set, definition result and reference result. */
public class ResultIds {
  public final int resultSet;
  public final int definitionResult;
  public final int referenceResult;

  public ResultIds(int resultSet, int definitionResult, int referenceResult) {
    this.resultSet = resultSet;
    this.definitionResult = definitionResult;
    this.referenceResult = referenceResult;
  }

  public boolean isDefinitionDefined() {
    return definitionResult > 0;
  }
}
