package com.sourcegraph.scip_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb.Range;

/**
 * Comparator that sorts SemanticDB ranges by appearance in the document.
 *
 * <p>We can't guarantee ordering of SymbolOccurrence in SemanticDB payloads so it's good to sort
 * them before processing.
 */
public class RangeComparator implements java.util.Comparator<Range> {

  @Override
  public int compare(Range r1, Range r2) {
    int byStartLine = Integer.compare(r1.getStartLine(), r2.getStartLine());
    if (byStartLine != 0) {
      return byStartLine;
    }
    int byStartCharacter = Integer.compare(r1.getStartCharacter(), r2.getStartCharacter());
    if (byStartCharacter != 0) {
      return byStartCharacter;
    }
    int byEndLine = Integer.compare(r1.getEndLine(), r2.getEndLine());
    if (byEndLine != 0) {
      return byEndLine;
    }
    return Integer.compare(r1.getEndCharacter(), r2.getEndCharacter());
  }
}
