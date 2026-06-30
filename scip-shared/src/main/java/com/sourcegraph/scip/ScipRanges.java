package com.sourcegraph.scip;

import org.scip_code.scip.MultiLineRange;
import org.scip_code.scip.Occurrence;
import org.scip_code.scip.SingleLineRange;

/** Helpers for reading and writing SCIP occurrence ranges. */
public final class ScipRanges {
  private ScipRanges() {}

  public static Range singleLineRange(int line, int startCharacter, int endCharacter) {
    return new Range(line, startCharacter, line, endCharacter);
  }

  public static Range range(int startLine, int startCharacter, int endLine, int endCharacter) {
    return new Range(startLine, startCharacter, endLine, endCharacter);
  }

  /** Sets the typed {@code range} oneof on {@code builder}. */
  public static Occurrence.Builder setRange(Occurrence.Builder builder, Range range) {
    clearRange(builder);
    if (range.isSingleLine()) {
      builder.setSingleLineRange(range.toSingleLineRange());
    } else {
      builder.setMultiLineRange(range.toMultiLineRange());
    }
    return builder;
  }

  /** Sets the typed {@code enclosing_range} oneof on {@code builder}. */
  public static Occurrence.Builder setEnclosingRange(Occurrence.Builder builder, Range range) {
    clearEnclosingRange(builder);
    if (range.isSingleLine()) {
      builder.setSingleLineEnclosingRange(range.toSingleLineRange());
    } else {
      builder.setMultiLineEnclosingRange(range.toMultiLineRange());
    }
    return builder;
  }

  /** Copies the preferred range encoding from {@code source} to {@code target}. */
  public static Occurrence.Builder copyRange(Occurrence source, Occurrence.Builder target) {
    clearRange(target);
    switch (source.getTypedRangeCase()) {
      case SINGLE_LINE_RANGE:
        target.setSingleLineRange(source.getSingleLineRange());
        return target;
      case MULTI_LINE_RANGE:
        target.setMultiLineRange(source.getMultiLineRange());
        return target;
      case TYPEDRANGE_NOT_SET:
        throw new IllegalArgumentException("expected SCIP 0.9 typed occurrence range");
    }
    throw new IllegalArgumentException("expected SCIP 0.9 typed occurrence range");
  }

  /** Copies the preferred enclosing range encoding from {@code source} to {@code target}. */
  public static Occurrence.Builder copyEnclosingRange(
      Occurrence source, Occurrence.Builder target) {
    clearEnclosingRange(target);
    switch (source.getTypedEnclosingRangeCase()) {
      case SINGLE_LINE_ENCLOSING_RANGE:
        target.setSingleLineEnclosingRange(source.getSingleLineEnclosingRange());
        return target;
      case MULTI_LINE_ENCLOSING_RANGE:
        target.setMultiLineEnclosingRange(source.getMultiLineEnclosingRange());
        return target;
      case TYPEDENCLOSINGRANGE_NOT_SET:
        return target;
    }
    return target;
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

  private static void clearRange(Occurrence.Builder builder) {
    builder.clearSingleLineRange();
    builder.clearMultiLineRange();
  }

  private static void clearEnclosingRange(Occurrence.Builder builder) {
    builder.clearSingleLineEnclosingRange();
    builder.clearMultiLineEnclosingRange();
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

    private boolean isSingleLine() {
      return startLine == endLine;
    }

    private SingleLineRange toSingleLineRange() {
      return SingleLineRange.newBuilder()
          .setLine(startLine)
          .setStartCharacter(startCharacter)
          .setEndCharacter(endCharacter)
          .build();
    }

    private MultiLineRange toMultiLineRange() {
      return MultiLineRange.newBuilder()
          .setStartLine(startLine)
          .setStartCharacter(startCharacter)
          .setEndLine(endLine)
          .setEndCharacter(endCharacter)
          .build();
    }
  }
}
