package com.sourcegraph.semanticdb_javac;

import com.sun.tools.javac.tree.EndPosTable;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Position;

/** A fallback implementation of EndPosTable when it's missing from the compiler. */
public final class EmptyEndPosTable implements EndPosTable {

  @Override
  public int getEndPos(JCTree tree) {
    return Position.NOPOS;
  }

  @Override
  public void storeEnd(JCTree tree, int endpos) {}

  @Override
  public int replaceTree(JCTree oldtree, JCTree newtree) {
    return Position.NOPOS;
  }
}
