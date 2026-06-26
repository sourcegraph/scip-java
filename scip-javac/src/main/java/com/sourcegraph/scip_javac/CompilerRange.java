package com.sourcegraph.scip_javac;

/**
 * Describes how to convert a compiler position into SCIP Range.
 *
 * <p>A Java compiler position has tree parts: "start", "point" and "end".
 *
 * <pre>
 *     public static void main(String[] args) { }
 *     ^ start
 *                        ^ point (aka. "preferred position")
 *                                              ^ end
 * </pre>
 *
 * A SCIP range has four parts: "startLine", "startCharacter", "endLine", "endCharacter".
 */
public enum CompilerRange {
  /** Map the compiler start/end positions to SCIP start/end positions. */
  FROM_START_TO_END,

  /**
   * Map the compiler point position to SCIP end and use (point - symbol name length) for the SCIP
   * start position.
   */
  FROM_END_TO_SYMBOL_NAME,

  /**
   * Map the compiler point position to SCIP start and use (point + symbol name length) for the SCIP
   * end position.
   */
  FROM_POINT_TO_SYMBOL_NAME,

  /**
   * Map the compiler (point + 1) position to SCIP start and use (point + symbol name length + 1)
   * for the SCIP end position.
   */
  FROM_POINT_TO_SYMBOL_NAME_PLUS_ONE,

  /**
   * Use text search to find the start of the symbol name and use (found start + symbol name length)
   * for the SCIP end position.
   */
  FROM_TEXT_SEARCH,

  /**
   * Use text search to find the start of the symbol name, using the point position as the starting
   * search offset and using (found start + symbol name length) for the SCIP end position.
   */
  FROM_POINT_WITH_TEXT_SEARCH,

  /**
   * Use text search to find the start of the symbol name, searching from the end instead of the
   * start.
   */
  FROM_END_WITH_TEXT_SEARCH;

  public boolean isFromPoint() {
    return switch (this) {
      case FROM_POINT_TO_SYMBOL_NAME,
          FROM_POINT_TO_SYMBOL_NAME_PLUS_ONE,
          FROM_POINT_WITH_TEXT_SEARCH ->
          true;
      default -> false;
    };
  }

  public boolean isFromEndPoint() {
    return switch (this) {
      case FROM_END_TO_SYMBOL_NAME, FROM_END_WITH_TEXT_SEARCH -> true;
      default -> false;
    };
  }

  public boolean isFromTextSearch() {
    return switch (this) {
      case FROM_TEXT_SEARCH, FROM_END_WITH_TEXT_SEARCH, FROM_POINT_WITH_TEXT_SEARCH -> true;
      default -> false;
    };
  }

  public boolean isPlusOne() {
    return switch (this) {
      case FROM_POINT_TO_SYMBOL_NAME_PLUS_ONE -> true;
      default -> false;
    };
  }

  public boolean isFromEnd() {
    return this == CompilerRange.FROM_END_WITH_TEXT_SEARCH;
  }
}
