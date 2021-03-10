package com.sourcegraph.semanticdb_javac;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.LineMap;
import com.sun.source.util.TreePath;
import com.sun.source.util.Trees;

import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RangeFinder {
  public static Optional<Semanticdb.Range> findRange(
      TreePath path, Trees trees, CompilationUnitTree root, Element element, int startPos) {
    LineMap lineMap = root.getLineMap();
    Name name = element.getSimpleName();
    if (name.contentEquals("<init>")) name = element.getEnclosingElement().getSimpleName();

    int endPos = (int) trees.getSourcePositions().getEndPosition(root, path.getLeaf());
    // false for anonymous classes
    if (name.length() != 0) {
      startPos = findNameIn(root, name, startPos, endPos);
      endPos = startPos + name.length();
    }

    if (endPos == -1) {
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

  private static int findNameIn(CompilationUnitTree root, CharSequence name, int start, int end) {
    String contents;
    try {
      contents = root.getSourceFile().getCharContent(true).toString();
    } catch (IOException e) {
      return -1;
    }

    if (end == -1) {
      end = contents.length();
    }

    Matcher matcher = Pattern.compile("\\b" + name + "\\b").matcher(contents);
    matcher.region(start, end);
    if (matcher.find()) {
      return matcher.start();
    } else {
      return -1;
    }
  }
}
