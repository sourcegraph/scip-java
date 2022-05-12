package com.sourcegraph.scip_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb.*;

public abstract class SemanticdbTreeVisitor {
  public void visitTree(Tree tree) {
    if (tree.hasApplyTree()) {
      this.visitApplyTree(tree.getApplyTree());
    } else if (tree.hasFunctionTree()) {
      this.visitFunctionTree(tree.getFunctionTree());
    } else if (tree.hasIdTree()) {
      this.visitIdTree(tree.getIdTree());
    } else if (tree.hasLiteralTree()) {
      this.visitLiteralTree(tree.getLiteralTree());
    } else if (tree.hasMacroExpansionTree()) {
      this.visitMacroExpansionTree(tree.getMacroExpansionTree());
    } else if (tree.hasOriginalTree()) {
      this.visitOriginalTree(tree.getOriginalTree());
    } else if (tree.hasSelectTree()) {
      this.visitSelectTree(tree.getSelectTree());
    } else if (tree.hasTypeApplyTree()) {
      this.visitTypeApplyTree(tree.getTypeApplyTree());
    } else if (tree.hasAnnotationTree()) {
      this.visitAnnotationTree(tree.getAnnotationTree());
    } else if (tree.hasAssignTree()) {
      this.visitAssignTree(tree.getAssignTree());
    } else if (tree.hasBinopTree()) {
      this.visitBinaryOperatorTree(tree.getBinopTree());
    }
  }

  void visitApplyTree(ApplyTree tree) {
    visitTree(tree.getFunction());
    for (Tree argument : tree.getArgumentsList()) {
      visitTree(argument);
    }
  }

  void visitFunctionTree(FunctionTree tree) {
    for (IdTree parameter : tree.getParametersList()) {
      visitIdTree(parameter);
    }
    visitTree(tree.getBody());
  }

  void visitIdTree(IdTree tree) {}

  void visitLiteralTree(LiteralTree tree) {}

  void visitMacroExpansionTree(MacroExpansionTree tree) {
    visitTree(tree.getBeforeExpansion());
  }

  void visitOriginalTree(OriginalTree tree) {}

  void visitSelectTree(SelectTree tree) {
    visitTree(tree.getQualifier());
    visitIdTree(tree.getId());
  }

  void visitTypeApplyTree(TypeApplyTree tree) {
    visitTree(tree.getFunction());
  }

  void visitAnnotationTree(AnnotationTree tree) {
    for (Tree parameter : tree.getParametersList()) {
      visitTree(parameter);
    }
  }

  void visitAssignTree(AssignTree tree) {
    visitTree(tree.getLhs());
    visitTree(tree.getRhs());
  }

  void visitBinaryOperatorTree(BinaryOperatorTree tree) {
    visitTree(tree.getLhs());
    visitTree(tree.getRhs());
  }
}
