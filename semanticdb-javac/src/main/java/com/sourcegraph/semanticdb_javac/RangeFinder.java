package com.sourcegraph.semanticdb_javac;

import javax.tools.Diagnostic;

import java.util.Optional;

public class RangeFinder {
  public static class StartEndRange {
    public int start;
    public int end;

    StartEndRange(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  /**
   * Searches {@code source} for {@code name} starting at {@code start}. If the name cannot be found
   * and {@code fallback} is not {@link Diagnostic#NOPOS}, returns a range anchored at {@code
   * fallback}; otherwise returns {@link Optional#empty()}.
   */
  public static Optional<StartEndRange> findRange(
      String name, int start, int fallback, String source) {
    if (source.length() == 0) return Optional.empty();
    int startPos = findNameFromStart(name, start, fallback, source);
    if (startPos == -1) return Optional.empty();
    return Optional.of(new StartEndRange(startPos, startPos + name.length()));
  }

  private static int findNameFromStart(String name, int start, int fallback, String source) {
    if (start >= source.length()) return -1;
    int offset = source.indexOf(name, start);
    if (offset == -1 && fallback != Diagnostic.NOPOS) return fallback;
    if (offset == -1) return -1;
    int end = offset + name.length();
    // found name in wrong word? e.g. finding `"A"` in `A("A")`
    if (offset > 0 && Character.isJavaIdentifierPart(source.charAt(offset - 1)))
      return findNameFromStart(name, end + 1, fallback, source);
    if (end < source.length() && Character.isJavaIdentifierPart(source.charAt(end)))
      return findNameFromStart(name, end + 1, fallback, source);
    return offset;
  }
}
