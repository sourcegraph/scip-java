package com.sourcegraph.scip;

import org.scip_code.scip.MultiLineRange;
import org.scip_code.scip.Occurrence;
import org.scip_code.scip.SingleLineRange;

/** A normalized source range that can be serialized to SCIP's typed range oneofs. */
public record ScipRange(int startLine, int startCharacter, int endLine, int endCharacter) {

  public static ScipRange singleLine(int line, int startCharacter, int endCharacter) {
    return new ScipRange(line, startCharacter, line, endCharacter);
  }

  public static ScipRange range(int startLine, int startCharacter, int endLine, int endCharacter) {
    return new ScipRange(startLine, startCharacter, endLine, endCharacter);
  }

  public static ScipRange from(Occurrence occurrence) {
    switch (occurrence.getTypedRangeCase()) {
      case SINGLE_LINE_RANGE:
        return from(occurrence.getSingleLineRange());
      case MULTI_LINE_RANGE:
        return from(occurrence.getMultiLineRange());
      case TYPEDRANGE_NOT_SET:
        throw new IllegalArgumentException("expected SCIP 0.9 typed occurrence range");
    }
    throw new IllegalArgumentException("expected SCIP 0.9 typed occurrence range");
  }

  private static ScipRange from(SingleLineRange range) {
    return new ScipRange(
        range.getLine(), range.getStartCharacter(), range.getLine(), range.getEndCharacter());
  }

  private static ScipRange from(MultiLineRange range) {
    return new ScipRange(
        range.getStartLine(),
        range.getStartCharacter(),
        range.getEndLine(),
        range.getEndCharacter());
  }

  public boolean isSingleLine() {
    return startLine == endLine;
  }

  public SingleLineRange toSingleLineRange() {
    if (!isSingleLine()) throw new IllegalStateException("expected single-line range");
    return SingleLineRange.newBuilder()
        .setLine(startLine)
        .setStartCharacter(startCharacter)
        .setEndCharacter(endCharacter)
        .build();
  }

  public MultiLineRange toMultiLineRange() {
    if (isSingleLine()) throw new IllegalStateException("expected multi-line range");
    return MultiLineRange.newBuilder()
        .setStartLine(startLine)
        .setStartCharacter(startCharacter)
        .setEndLine(endLine)
        .setEndCharacter(endCharacter)
        .build();
  }
}
