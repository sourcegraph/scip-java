package com.sourcegraph.semanticdb_javac;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.LineMap;
import com.sun.source.util.TreePath;
import com.sun.source.util.Trees;

import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sourcegraph.semanticdb_javac.Debugging.pprint;

public class RangeFinder {
  public static Optional<Semanticdb.Range> findRange(
      TreePath path,
      Trees trees,
      CompilationUnitTree root,
      Element element,
      int startPos,
      String source,
      boolean fromEnd) {
    LineMap lineMap = root.getLineMap();
    Name name = element.getSimpleName();
    if (name.contentEquals("<init>")) name = element.getEnclosingElement().getSimpleName();

    int endPos = (int) trees.getSourcePositions().getEndPosition(root, path.getLeaf());
    // false for anonymous classes
    if (name.length() != 0) {
      startPos = findNameIn(name, fromEnd ? endPos : startPos, source, fromEnd);
      endPos = startPos + name.length();
    }

    if (endPos == -1 || startPos == -1) {
      return Optional.empty();
    }

    Semanticdb.Range range =
        Semanticdb.Range.newBuilder()
            .setStartLine((int) lineMap.getLineNumber(startPos) - 1)
            .setStartCharacter((int) lineMap.getColumnNumber(startPos) - 1)
            .setEndLine((int) lineMap.getLineNumber(endPos) - 1)
            .setEndCharacter((int) lineMap.getColumnNumber(endPos) - 1)
            .build();
    return Optional.of(range);
  }

  private static int findNameIn(CharSequence name, int start, String source, boolean fromEnd) {
    if (source.equals("")) return -1;

    int offset;
    if (fromEnd) offset = source.lastIndexOf(name.toString(), start);
    else offset = source.indexOf(name.toString(), start);
    if (offset > -1) {
      return offset;
    }
    return -1;
  }
}
