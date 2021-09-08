package com.sourcegraph.semanticdb_javac;

import com.sun.source.tree.*;
import com.sun.source.util.Trees;

import javax.lang.model.element.Element;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.sourcegraph.semanticdb_javac.SemanticdbBuilders.*;
import static com.sourcegraph.semanticdb_javac.SemanticdbTypeVisitor.ARRAY_SYMBOL;

public class SemanticdbTrees {
  public SemanticdbTrees(
      GlobalSymbolsCache globals,
      LocalSymbolsCache locals,
      String semanticdbUri,
      Trees trees,
      Types types,
      CompilationUnitTree compilationUnitTree) {
    this.globals = globals;
    this.locals = locals;
    this.semanticdbUri = semanticdbUri;
    this.compilationUnitTree = compilationUnitTree;
    this.trees = trees;
    this.types = types;
  }

  private final CompilationUnitTree compilationUnitTree;
  private final Trees trees;
  private final Types types;
  private final GlobalSymbolsCache globals;
  private final LocalSymbolsCache locals;
  private final String semanticdbUri;

  public List<Semanticdb.AnnotationTree> annotations(Tree node) {
    if (!(node instanceof ClassTree)
        && !(node instanceof VariableTree)
        && !(node instanceof MethodTree)) return null;

    List<Semanticdb.AnnotationTree> annotations = new ArrayList<>();

    ModifiersTree mods;
    if (node instanceof ClassTree) {
      mods = ((ClassTree) node).getModifiers();
    } else if (node instanceof MethodTree) {
      mods = ((MethodTree) node).getModifiers();
    } else {
      mods = ((VariableTree) node).getModifiers();
    }

    for (AnnotationTree annotation : mods.getAnnotations()) {
      annotations.add(annotationBuilder(annotation));
    }

    return annotations;
  }

  private Semanticdb.AnnotationTree annotationBuilder(AnnotationTree annotation) {
    ArrayList<Semanticdb.Tree> params = new ArrayList<>(annotation.getArguments().size());

    for (ExpressionTree param : annotation.getArguments()) {
      // anecdotally not always JCAssign in some situations when a compilation unit can't resolve
      // symbols fully
      if (param instanceof AssignmentTree) {
        AssignmentTree assign = (AssignmentTree) param;
        ExpressionTree assignValue = assign.getExpression();

        Element identElement = elementForTree(assign.getVariable());
        String symbol = globals.semanticdbSymbol(identElement, locals);
        params.add(tree(assignTree(tree(idTree(symbol)), annotationParameter(assignValue))));
      } else {
        params.add(annotationParameter(param));
      }
    }

    Semanticdb.Type type =
        new SemanticdbTypeVisitor(globals, locals, types).semanticdbType(typeForTree(annotation));
    return annotationTree(type, params);
  }

  private Semanticdb.Tree annotationParameter(ExpressionTree expr) {
    if (expr instanceof MemberSelectTree) {
      MemberSelectTree rhs = (MemberSelectTree) expr;

      return tree(
          selectTree(
              tree(
                  idTree(
                      globals.semanticdbSymbol(elementForTree(rhs).getEnclosingElement(), locals))),
              idTree(globals.semanticdbSymbol(elementForTree(rhs), locals))));
    } else if (expr instanceof NewArrayTree) {
      NewArrayTree rhs = (NewArrayTree) expr;
      return tree(
          applyTree(
              tree(idTree(ARRAY_SYMBOL)),
              rhs.getInitializers().stream()
                  .map(this::annotationParameter)
                  .collect(Collectors.toList())));
    } else if (expr instanceof LiteralTree) {
      // Literals can either be a primitive or String
      LiteralTree rhs = (LiteralTree) expr;

      if (typeForTree(rhs) instanceof PrimitiveType) {
        PrimitiveType type = (PrimitiveType) typeForTree(rhs);
        System.err.println("KIND IS " + type.getKind());
        switch (type.getKind()) {
          case BOOLEAN:
            return tree(literalTree(booleanConst(((Boolean) rhs.getValue()))));
          case INT:
            return tree(literalTree(intConst((Integer) rhs.getValue())));
          case LONG:
            return tree(literalTree(longConst((Long) rhs.getValue())));
          case CHAR:
            return tree(literalTree(charConst((Character.forDigit((Integer) rhs.getValue(), 10)))));
          case FLOAT:
            return tree(literalTree(floatConst((Float) rhs.getValue())));
          case DOUBLE:
            return tree(literalTree(doubleConst((Double) rhs.getValue())));
        }
      } else if (typeForTree(rhs) instanceof DeclaredType) {
        if (rhs.getValue() instanceof String) {
          return tree(literalTree(stringConst((String) rhs.getValue())));
        } else {
          throw new IllegalStateException(
              semanticdbUri
                  + ": annotation parameter rhs was of unexpected class type "
                  + rhs.getValue().getClass()
                  + "\n"
                  + rhs.getValue());
        }
      } /*else if (typeForTree(rhs) instanceof Type.UnknownType) {
          return tree(literalTree(stringConst("UNRESOLVED"))); TODO
        }*/ else {
        throw new IllegalStateException(
            semanticdbUri
                + ": annotation parameter rhs was of unexpected type "
                + typeForTree(rhs).getClass()
                + "\n"
                + typeForTree(rhs)
                + " "
                + rhs);
      }
    } else if (expr instanceof AnnotationTree) {
      return tree(annotationBuilder((AnnotationTree) expr));
    } else if (expr instanceof IdentifierTree) {
      return tree(idTree(globals.semanticdbSymbol(elementForTree(expr), locals)));
    } else if (expr instanceof BinaryTree) {
      BinaryTree binExpr = (BinaryTree) expr;
      return tree(
          binopTree(
              annotationParameter(binExpr.getLeftOperand()),
              semanticdbBinaryOperator(expr.getKind()),
              annotationParameter(binExpr.getRightOperand())));
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

  private Element elementForTree(Tree tree) {
    return trees.getElement(trees.getPath(compilationUnitTree, tree));
  }

  private TypeMirror typeForTree(Tree tree) {
    return trees.getTypeMirror(trees.getPath(compilationUnitTree, tree));
  }
}
