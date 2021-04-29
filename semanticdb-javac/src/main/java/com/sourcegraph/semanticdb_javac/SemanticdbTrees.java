package com.sourcegraph.semanticdb_javac;

import com.sun.source.tree.Tree;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.sourcegraph.semanticdb_javac.SemanticdbBuilders.*;
import static com.sourcegraph.semanticdb_javac.SemanticdbTypeVisitor.ARRAY_SYMBOL;

public class SemanticdbTrees {
  public SemanticdbTrees(
      GlobalSymbolsCache globals, LocalSymbolsCache locals, String semanticdbUri) {
    this.globals = globals;
    this.locals = locals;
    this.semanticdbUri = semanticdbUri;
  }

  private final GlobalSymbolsCache globals;
  private final LocalSymbolsCache locals;
  private final String semanticdbUri;

  public List<Semanticdb.AnnotationTree> annotations(JCTree node) {
    if (!(node instanceof JCTree.JCClassDecl)
        && !(node instanceof JCTree.JCVariableDecl)
        && !(node instanceof JCTree.JCMethodDecl)) return null;

    List<Semanticdb.AnnotationTree> annotations = new ArrayList<>();

    JCTree.JCModifiers mods;
    if (node instanceof JCTree.JCClassDecl) {
      mods = ((JCTree.JCClassDecl) node).getModifiers();
    } else if (node instanceof JCTree.JCMethodDecl) {
      mods = ((JCTree.JCMethodDecl) node).getModifiers();
    } else {
      mods = ((JCTree.JCVariableDecl) node).getModifiers();
    }

    for (JCTree.JCAnnotation annotation : mods.getAnnotations()) {
      annotations.add(annotationBuilder(annotation));
    }

    return annotations;
  }

  private Semanticdb.AnnotationTree annotationBuilder(JCTree.JCAnnotation annotation) {
    ArrayList<Semanticdb.Tree> params = new ArrayList<>(annotation.args.size());

    for (JCTree.JCExpression param : annotation.args) {
      // anecdotally not always JCAssign in some situations when a compilation unit can't resolve
      // symbols fully
      if (param instanceof JCTree.JCAssign) {
        JCTree.JCAssign assign = (JCTree.JCAssign) param;
        JCTree.JCExpression assignValue = assign.rhs;

        String symbol = globals.semanticdbSymbol(((JCTree.JCIdent) assign.lhs).sym, locals);
        params.add(tree(assignTree(tree(idTree(symbol)), annotationParameter(assignValue))));
      } else {
        params.add(annotationParameter(param));
      }
    }

    Semanticdb.Type type =
        new SemanticdbTypeVisitor(globals, locals).semanticdbType(annotation.type);
    return annotationTree(type, params);
  }

  private Semanticdb.Tree annotationParameter(JCTree.JCExpression expr) {
    if (expr instanceof JCTree.JCFieldAccess) {
      JCTree.JCFieldAccess rhs = (JCTree.JCFieldAccess) expr;

      return tree(
          selectTree(
              tree(idTree(globals.semanticdbSymbol(rhs.sym.owner, locals))),
              idTree(globals.semanticdbSymbol(rhs.sym, locals))));
    } else if (expr instanceof JCTree.JCNewArray) {
      JCTree.JCNewArray rhs = (JCTree.JCNewArray) expr;
      return tree(
          applyTree(
              tree(idTree(ARRAY_SYMBOL)),
              rhs.elems.stream().map(this::annotationParameter).collect(Collectors.toList())));
    } else if (expr instanceof JCTree.JCLiteral) {
      // Literals can either be a primitive or String
      JCTree.JCLiteral rhs = (JCTree.JCLiteral) expr;

      if (rhs.type instanceof Type.JCPrimitiveType) {
        Type.JCPrimitiveType type = (Type.JCPrimitiveType) rhs.type;
        switch (type.getKind()) {
          case BOOLEAN:
            return tree(literalTree(booleanConst(((Integer) rhs.value) == 1)));
          case BYTE:
            return tree(literalTree(byteConst((Byte) rhs.value)));
          case SHORT:
            return tree(literalTree(shortConst((Short) rhs.value)));
          case INT:
            return tree(literalTree(intConst((Integer) rhs.value)));
          case LONG:
            return tree(literalTree(longConst((Long) rhs.value)));
          case CHAR:
            return tree(literalTree(charConst((Character.forDigit((Integer) rhs.value, 10)))));
          case FLOAT:
            return tree(literalTree(floatConst((Float) rhs.value)));
          case DOUBLE:
            return tree(literalTree(doubleConst((Double) rhs.value)));
        }
      } else if (rhs.type instanceof Type.ClassType) {
        if (rhs.value instanceof String) {
          return tree(literalTree(stringConst((String) rhs.value)));
        } else {
          throw new IllegalStateException(
              semanticdbUri
                  + ": annotation parameter rhs was of unexpected class type "
                  + rhs.value.getClass()
                  + "\n"
                  + rhs.value);
        }
      } else if (rhs.type instanceof Type.UnknownType) {
        return tree(literalTree(stringConst("UNRESOLVED")));
      } else {
        throw new IllegalStateException(
            semanticdbUri
                + ": annotation parameter rhs was of unexpected type "
                + rhs.type.getClass()
                + "\n"
                + rhs.type
                + " "
                + rhs);
      }
    } else if (expr instanceof JCTree.JCAnnotation) {
      return tree(annotationBuilder((JCTree.JCAnnotation) expr));
    } else if (expr instanceof JCTree.JCIdent) {
      return tree(idTree(globals.semanticdbSymbol(((JCTree.JCIdent) expr).sym, locals)));
    } else if (expr instanceof JCTree.JCBinary) {
      JCTree.JCBinary binExpr = (JCTree.JCBinary) expr;
      return tree(
          binopTree(
              annotationParameter(binExpr.lhs),
              semanticdbBinaryOperator(expr.getKind()),
              annotationParameter(binExpr.rhs)));
    }

    throw new IllegalArgumentException(
        semanticdbUri
            + ": annotation parameter rhs was of unexpected tree node type "
            + expr.getClass()
            + "\n"
            + expr);
  }

  private Semanticdb.BinaryOperator semanticdbBinaryOperator(Tree.Kind kind) {
    switch (kind) {
      case PLUS:
        return Semanticdb.BinaryOperator.PLUS;
      case MINUS:
        return Semanticdb.BinaryOperator.MINUS;
      case MULTIPLY:
        return Semanticdb.BinaryOperator.MULTIPLY;
      case DIVIDE:
        return Semanticdb.BinaryOperator.DIVIDE;
      case REMAINDER:
        return Semanticdb.BinaryOperator.REMAINDER;
      case LESS_THAN:
        return Semanticdb.BinaryOperator.LESS_THAN;
      case GREATER_THAN:
        return Semanticdb.BinaryOperator.GREATER_THAN;
      case LEFT_SHIFT:
        return Semanticdb.BinaryOperator.SHIFT_LEFT;
      case RIGHT_SHIFT:
        return Semanticdb.BinaryOperator.SHIFT_RIGHT;
      case UNSIGNED_RIGHT_SHIFT:
        return Semanticdb.BinaryOperator.SHIFT_RIGHT_UNSIGNED;
      case EQUAL_TO:
        return Semanticdb.BinaryOperator.EQUAL_TO;
      case NOT_EQUAL_TO:
        return Semanticdb.BinaryOperator.NOT_EQUAL_TO;
      case LESS_THAN_EQUAL:
        return Semanticdb.BinaryOperator.LESS_THAN_EQUAL;
      case GREATER_THAN_EQUAL:
        return Semanticdb.BinaryOperator.GREATER_THAN_EQUAL;
      case CONDITIONAL_AND:
        return Semanticdb.BinaryOperator.CONDITIONAL_AND;
      case CONDITIONAL_OR:
        return Semanticdb.BinaryOperator.CONDITIONAL_OR;
      case AND:
        return Semanticdb.BinaryOperator.AND;
      case OR:
        return Semanticdb.BinaryOperator.OR;
      case XOR:
        return Semanticdb.BinaryOperator.XOR;
      default:
        throw new IllegalStateException(
            semanticdbUri + ": unexpected binary expression operator kind " + kind);
    }
  }
}
