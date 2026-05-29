package com.sourcegraph.semanticdb_javac;

import java.util.Arrays;
import java.util.List;

/**
 * Lightweight value type for source ranges produced by {@link ScipVisitor}.
 *
 * <p>Coordinates are zero-based and follow the SCIP convention (line + character, end-exclusive
 * character). Convertible directly to SCIP's {@code repeated int32 range} representation via {@link
 * #asScipRange()}.
 */
final class ScipRange {
  final int startLine;
  final int startCharacter;
  final int endLine;
  final int endCharacter;

  ScipRange(int startLine, int startCharacter, int endLine, int endCharacter) {
    this.startLine = startLine;
    this.startCharacter = startCharacter;
    this.endLine = endLine;
    this.endCharacter = endCharacter;
  }

  /** Returns a copy with adjusted start/end characters (used to correct for tab-expansion). */
  ScipRange withCharacters(int startCharacter, int endCharacter) {
    return new ScipRange(startLine, startCharacter, endLine, endCharacter);
  }

  /**
   * Encodes the range using SCIP's compact {@code repeated int32 range} layout: 3 ints when the
   * range fits on a single line, 4 ints otherwise.
   */
  List<Integer> asScipRange() {
    if (startLine == endLine) {
      return Arrays.asList(startLine, startCharacter, endCharacter);
    }
    return Arrays.asList(startLine, startCharacter, endLine, endCharacter);
  }
}
