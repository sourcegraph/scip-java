package com.sourcegraph.scip;

import org.scip_code.scip.MultiLineRange;
import org.scip_code.scip.Occurrence;
import org.scip_code.scip.SingleLineRange;

/** Helpers for creating and reading typed SCIP occurrence ranges. */
public final class ScipRanges {
  private ScipRanges() {}

  public static Range singleLineRange(int line, int startCharacter, int endCharacter) {
    return new Range(line, startCharacter, line, endCharacter);
  }

  public static Range range(int startLine, int startCharacter, int endLine, int endCharacter) {
    return new Range(startLine, startCharacter, endLine, endCharacter);
  }

  public static Range range(Occurrence occurrence) {
    switch (occurrence.getTypedRangeCase()) {
      case SINGLE_LINE_RANGE:
        return Range.from(occurrence.getSingleLineRange());
      case MULTI_LINE_RANGE:
        return Range.from(occurrence.getMultiLineRange());
      case TYPEDRANGE_NOT_SET:
        throw new IllegalArgumentException("expected SCIP 0.9 typed occurrence range");
    }
    throw new IllegalArgumentException("expected SCIP 0.9 typed occurrence range");
  }

  public static int rangeStartLine(Occurrence occurrence) {
    return range(occurrence).startLine();
  }

  public static int rangeStartCharacter(Occurrence occurrence) {
    return range(occurrence).startCharacter();
  }

  public record Range(int startLine, int startCharacter, int endLine, int endCharacter) {
    private static Range from(SingleLineRange range) {
      return new Range(
          range.getLine(), range.getStartCharacter(), range.getLine(), range.getEndCharacter());
    }

    private static Range from(MultiLineRange range) {
      return new Range(
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
}
