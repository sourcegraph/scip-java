package com.sourcegraph.semanticdb_javac;

import java.util.Arrays;
import java.util.List;

/**
 * Zero-based source range produced by {@link ScipVisitor}, convertible to SCIP's compact {@code
 * repeated int32 range} via {@link #asScipRange()}.
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

  /** Returns a copy with adjusted start/end characters (used to correct tab-expansion). */
  ScipRange withCharacters(int startCharacter, int endCharacter) {
    return new ScipRange(startLine, startCharacter, endLine, endCharacter);
  }

  /** 3 ints when the range fits on one line, 4 ints otherwise. */
  List<Integer> asScipRange() {
    if (startLine == endLine) {
      return Arrays.asList(startLine, startCharacter, endCharacter);
    }
    return Arrays.asList(startLine, startCharacter, endLine, endCharacter);
  }
}
