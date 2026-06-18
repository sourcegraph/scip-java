package com.sourcegraph.scip_javac;

import com.sun.source.tree.AnnotationTree;
import com.sun.source.tree.AssignmentTree;
import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ClassTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.IdentifierTree;
import com.sun.source.tree.LiteralTree;
import com.sun.source.tree.MemberSelectTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.ModifiersTree;
import com.sun.source.tree.NewArrayTree;
import com.sun.source.tree.NewClassTree;
import com.sun.source.tree.ParenthesizedTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TypeCastTree;
import com.sun.source.tree.UnaryTree;
import com.sun.source.tree.VariableTree;
import com.sun.source.util.TreePath;
import com.sun.source.util.Trees;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.IntersectionType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.SimpleTypeVisitor8;

/**
 * Renders the {@code signature_documentation} text for a Java declaration directly from javac
 * {@link Element}s and {@link Tree}s.
 *
 * <p>This is the Java-language path of the old {@code SignatureFormatter}, ported onto javac's
 * element / type / tree API so the compiler plugin no longer has to first marshal everything into
 * SCIP proto messages. Output is intentionally byte-identical with the previous output so existing
 * golden snapshots continue to match.
 */
final class ScipJavaSignatureFormatter {
  private static final String UNRESOLVED = "unresolved_type";

  private final Trees trees;
  private final CompilationUnitTree compilationUnit;

  ScipJavaSignatureFormatter(Trees trees, CompilationUnitTree compilationUnit) {
    this.trees = trees;
    this.compilationUnit = compilationUnit;
  }

  /**
   * Returns the signature text for {@code sym}, or {@code ""} when {@code sym} has no signature.
   */
  String format(Element sym, Tree declTree) {
    if (sym instanceof TypeElement) {
      return formatClass((TypeElement) sym, declTree);
    } else if (sym instanceof ExecutableElement) {
      return formatMethod((ExecutableElement) sym, declTree);
    } else if (sym instanceof VariableElement) {
      return formatVariable((VariableElement) sym, declTree);
    } else if (sym instanceof TypeParameterElement) {
      return formatTypeParameter((TypeParameterElement) sym);
    }
    return "";
  }

  // -------- Class / interface / annotation / enum --------

  private String formatClass(TypeElement sym, Tree declTree) {
    StringBuilder s = new StringBuilder();
    boolean isAnnotation = sym.getKind() == ElementKind.ANNOTATION_TYPE;
    boolean isEnum = sym.getKind() == ElementKind.ENUM;
    boolean isInterface = sym.getKind() == ElementKind.INTERFACE || isAnnotation;

    printKeywordln(s, formatAnnotations(declTree));
    printKeyword(s, formatAccess(sym));
    if (!isEnum && !isAnnotation && !isInterface) printKeyword(s, formatModifiers(sym));

    switch (sym.getKind()) {
      case CLASS:
        printKeyword(s, "class");
        break;
      case ENUM:
        printKeyword(s, "enum");
        break;
      case ANNOTATION_TYPE:
        printKeyword(s, "@interface");
        break;
      case INTERFACE:
        printKeyword(s, "interface");
        break;
      default:
        break;
    }
    s.append(sym.getSimpleName());

    List<? extends TypeParameterElement> typeParameters = sym.getTypeParameters();
    if (!typeParameters.isEmpty()) {
      s.append(
          typeParameters.stream()
              .map(this::formatTypeParameter)
              .collect(Collectors.joining(", ", "<", ">")));
    }

    List<TypeMirror> nonSynthetic = new ArrayList<>();
    boolean hasNonRedundantParent = false;
    boolean firstParent = true;
    for (TypeMirror parent : superTypes(sym)) {
      if (firstParent) {
        hasNonRedundantParent = !isJavaLangObject(parent);
        firstParent = false;
      }
      if (isJavaLangObject(parent)) continue;
      if (isEnumParent(parent)) continue;
      if (isAnnotationParent(parent)) continue;
      nonSynthetic.add(parent);
    }
    if (nonSynthetic.isEmpty()) return s.toString();

    // Mirror SignatureFormatter's Java extends/implements logic.
    switch (sym.getKind()) {
      case CLASS:
      case ENUM:
        if (isEnum || !hasNonRedundantParent) {
          printKeyword(s, " implements");
          s.append(nonSynthetic.stream().map(this::formatType).collect(Collectors.joining(", ")));
        } else {
          printKeyword(s, " extends");
          s.append(formatType(nonSynthetic.get(0)));
          String supers =
              nonSynthetic.stream().skip(1).map(this::formatType).collect(Collectors.joining(", "));
          if (!supers.isEmpty()) {
            printKeyword(s, " implements");
            s.append(supers);
          }
        }
        break;
      case INTERFACE:
      case ANNOTATION_TYPE:
        printKeyword(s, " extends");
        s.append(nonSynthetic.stream().map(this::formatType).collect(Collectors.joining(", ")));
        break;
      default:
        break;
    }
    return s.toString();
  }

  /** Mirrors {@code Types.directSupertypes} (which we don't carry directly). */
  private List<? extends TypeMirror> superTypes(TypeElement sym) {
    List<TypeMirror> parents = new ArrayList<>();
    TypeMirror superClass = sym.getSuperclass();
    if (superClass != null && !(superClass instanceof NoType)) {
      parents.add(superClass);
    }
    parents.addAll(sym.getInterfaces());
    return parents;
  }

  // -------- Method / constructor --------

  private String formatMethod(ExecutableElement sym, Tree declTree) {
    StringBuilder s = new StringBuilder();
    printKeywordln(s, formatAnnotations(declTree));
    printKeyword(s, formatAccess(sym));
    printKeyword(s, formatModifiers(sym));

    List<? extends TypeParameterElement> typeParameters = sym.getTypeParameters();
    if (!typeParameters.isEmpty()) {
      printKeyword(
          s,
          typeParameters.stream()
              .map(this::formatTypeParameter)
              .collect(Collectors.joining(", ", "<", ">")));
    }

    if (sym.getKind() == ElementKind.CONSTRUCTOR) {
      Element owner = sym.getEnclosingElement();
      if (owner != null) s.append(owner.getSimpleName());
    } else {
      printKeyword(s, formatType(sym.getReturnType()));
      s.append(sym.getSimpleName());
    }

    s.append(
        sym.getParameters().stream()
            .map(this::formatParameter)
            .collect(Collectors.joining(", ", "(", ")")));

    List<? extends TypeMirror> thrown = sym.getThrownTypes();
    if (!thrown.isEmpty()) {
      printKeyword(s, " throws");
      s.append(thrown.stream().map(this::formatType).collect(Collectors.joining(", ")));
    }
    return s.toString();
  }

  /** {@code <type> <name>} parameter form (no leading annotations or modifiers). */
  private String formatParameter(VariableElement param) {
    return formatType(param.asType()) + " " + param.getSimpleName();
  }

  // -------- Field / parameter --------

  private String formatVariable(VariableElement sym, Tree declTree) {
    StringBuilder s = new StringBuilder();
    printKeywordln(s, formatAnnotations(declTree));

    if (isEnumConstant(sym)) {
      Element owner = sym.getEnclosingElement();
      List<VariableElement> constants = new ArrayList<>();
      for (Element e : owner.getEnclosedElements()) {
        if (e.getKind() == ElementKind.ENUM_CONSTANT) constants.add((VariableElement) e);
      }
      int ordinal = constants.indexOf(sym);
      s.append(owner.getSimpleName()).append('.');
      s.append(sym.getSimpleName());
      String args = enumConstantArgs(declTree);
      if (!args.isEmpty()) s.append('(').append(args).append(')');
      s.append(" /* ordinal ").append(ordinal).append(" */");
      return s.toString();
    }

    printKeyword(s, formatAccess(sym));
    printKeyword(s, formatModifiers(sym));
    printKeyword(s, formatType(sym.asType()));
    s.append(sym.getSimpleName());
    return s.toString();
  }

  // -------- Type parameter --------

  private String formatTypeParameter(TypeParameterElement sym) {
    StringBuilder s = new StringBuilder();
    s.append(sym.getSimpleName());
    List<? extends TypeMirror> bounds = sym.getBounds();
    // javac surfaces `T extends Object` as `bounds = [Object]`; treat it as no bound.
    if (bounds.size() == 1 && isJavaLangObject(bounds.get(0))) return s.toString();
    if (!bounds.isEmpty()) {
      printKeyword(s, " extends");
      s.append(bounds.stream().map(this::formatType).collect(Collectors.joining(" & ")));
    }
    return s.toString();
  }

  // -------- Type rendering --------

  private String formatType(TypeMirror tpe) {
    if (tpe == null) return UNRESOLVED;
    String result = tpe.accept(typeVisitor, null);
    return result == null ? UNRESOLVED : result;
  }

  private final SimpleTypeVisitor8<String, Void> typeVisitor =
      new SimpleTypeVisitor8<String, Void>() {
        @Override
        public String visitDeclared(DeclaredType t, Void unused) {
          StringBuilder b = new StringBuilder();
          Element elem = t.asElement();
          b.append(elem == null ? UNRESOLVED : elem.getSimpleName());
          List<? extends TypeMirror> args = t.getTypeArguments();
          if (!args.isEmpty()) {
            b.append(
                args.stream()
                    .map(ScipJavaSignatureFormatter.this::formatType)
                    .collect(Collectors.joining(", ", "<", ">")));
          }
          return b.toString();
        }

        @Override
        public String visitArray(ArrayType t, Void unused) {
          return formatType(t.getComponentType()) + "[]";
        }

        @Override
        public String visitPrimitive(PrimitiveType t, Void unused) {
          return primitiveName(t.getKind());
        }

        @Override
        public String visitTypeVariable(TypeVariable t, Void unused) {
          Element elem = t.asElement();
          return elem == null ? UNRESOLVED : elem.getSimpleName().toString();
        }

        @Override
        public String visitIntersection(IntersectionType t, Void unused) {
          return t.getBounds().stream()
              .map(ScipJavaSignatureFormatter.this::formatType)
              .collect(Collectors.joining(" & "));
        }

        @Override
        public String visitWildcard(WildcardType t, Void unused) {
          if (t.getExtendsBound() != null) return "? extends " + formatType(t.getExtendsBound());
          if (t.getSuperBound() != null) return "? super " + formatType(t.getSuperBound());
          return "?";
        }

        @Override
        public String visitNoType(NoType t, Void unused) {
          return primitiveName(t.getKind());
        }
      };

  private static String primitiveName(TypeKind kind) {
    switch (kind) {
      case BOOLEAN:
        return "boolean";
      case BYTE:
        return "byte";
      case SHORT:
        return "short";
      case INT:
        return "int";
      case LONG:
        return "long";
      case CHAR:
        return "char";
      case FLOAT:
        return "float";
      case DOUBLE:
        return "double";
      case VOID:
        return "void";
      default:
        return UNRESOLVED;
    }
  }

  // -------- Access / modifiers --------

  private static String formatAccess(Element sym) {
    for (Modifier m : sym.getModifiers()) {
      if (m == Modifier.PRIVATE) return "private";
      if (m == Modifier.PUBLIC) return "public";
      if (m == Modifier.PROTECTED) return "protected";
    }
    return "";
  }

  /** Mirrors {@code SignatureFormatter.formatModifiers} for the Java path. */
  private static String formatModifiers(Element sym) {
    boolean isStatic = sym.getModifiers().contains(Modifier.STATIC);
    boolean isFinal = sym.getModifiers().contains(Modifier.FINAL);
    boolean isAbstract = sym.getModifiers().contains(Modifier.ABSTRACT);
    boolean isDefault = sym.getModifiers().contains(Modifier.DEFAULT);
    // Default interface methods get both ABSTRACT and DEFAULT set; drop ABSTRACT.
    if (isAbstract && isDefault) isAbstract = false;

    List<String> mods = new ArrayList<>();
    if (isAbstract) mods.add("abstract");
    if (isDefault) mods.add("default");
    if (isStatic) mods.add("static");
    if (isFinal) mods.add("final");
    return String.join(" ", mods);
  }

  // -------- Annotations --------

  private String formatAnnotations(Tree declTree) {
    ModifiersTree mods = modifiers(declTree);
    if (mods == null) return "";
    List<? extends AnnotationTree> annotations = mods.getAnnotations();
    if (annotations.isEmpty()) return "";
    return annotations.stream().map(this::formatAnnotation).collect(Collectors.joining("\n"));
  }

  private static ModifiersTree modifiers(Tree tree) {
    if (tree instanceof ClassTree) return ((ClassTree) tree).getModifiers();
    if (tree instanceof MethodTree) return ((MethodTree) tree).getModifiers();
    if (tree instanceof VariableTree) return ((VariableTree) tree).getModifiers();
    return null;
  }

  private String formatAnnotation(AnnotationTree annotation) {
    StringBuilder b = new StringBuilder();
    b.append('@');
    b.append(formatAnnotationType(annotation));

    List<? extends ExpressionTree> args = annotation.getArguments();
    if (args.size() == 1) {
      b.append('(');
      ExpressionTree first = args.get(0);
      // `@Foo(value = X)` collapses to `@Foo(X)`, per JLS 9.7.3.
      if (first instanceof AssignmentTree) {
        AssignmentTree assign = (AssignmentTree) first;
        if (isValueIdentifier(assign.getVariable())) {
          b.append(formatExpression(assign.getExpression()));
        } else {
          b.append(formatExpression(first));
        }
      } else {
        b.append(formatExpression(first));
      }
      b.append(')');
    } else if (args.size() > 1) {
      b.append(
          args.stream().map(this::formatExpression).collect(Collectors.joining(", ", "(", ")")));
    }
    return b.toString();
  }

  private String formatAnnotationType(AnnotationTree annotation) {
    Element elem = elementOf(annotation.getAnnotationType());
    if (elem != null) return elem.getSimpleName().toString();
    return annotation.getAnnotationType().toString();
  }

  private static boolean isValueIdentifier(ExpressionTree tree) {
    return tree instanceof IdentifierTree
        && "value".contentEquals(((IdentifierTree) tree).getName());
  }

  private String formatExpression(ExpressionTree expr) {
    if (expr instanceof LiteralTree) return formatLiteral(((LiteralTree) expr).getValue());
    if (expr instanceof IdentifierTree) return ((IdentifierTree) expr).getName().toString();
    if (expr instanceof MemberSelectTree) {
      MemberSelectTree select = (MemberSelectTree) expr;
      return formatExpression(select.getExpression()) + "." + select.getIdentifier();
    }
    if (expr instanceof NewArrayTree) {
      List<? extends ExpressionTree> inits = ((NewArrayTree) expr).getInitializers();
      if (inits == null) inits = Collections.emptyList();
      return inits.stream().map(this::formatExpression).collect(Collectors.joining(", ", "{", "}"));
    }
    if (expr instanceof AnnotationTree) return formatAnnotation((AnnotationTree) expr);
    if (expr instanceof AssignmentTree) {
      AssignmentTree assign = (AssignmentTree) expr;
      return formatExpression(assign.getVariable())
          + " = "
          + formatExpression(assign.getExpression());
    }
    if (expr instanceof BinaryTree) {
      BinaryTree bin = (BinaryTree) expr;
      return formatExpression(bin.getLeftOperand())
          + " "
          + binaryOperator(bin.getKind())
          + " "
          + formatExpression(bin.getRightOperand());
    }
    if (expr instanceof UnaryTree) {
      UnaryTree un = (UnaryTree) expr;
      return unaryOperator(un.getKind(), formatExpression(un.getExpression()));
    }
    if (expr instanceof ParenthesizedTree) {
      return formatExpression(((ParenthesizedTree) expr).getExpression());
    }
    if (expr instanceof TypeCastTree) {
      TypeCastTree cast = (TypeCastTree) expr;
      TypeMirror type = typeOf(cast.getType());
      String typeText = type != null ? formatType(type) : cast.getType().toString();
      return "(" + typeText + ") " + formatExpression(cast.getExpression());
    }
    return expr.toString();
  }

  private static String formatLiteral(Object value) {
    if (value == null) return "null";
    if (value instanceof String) return "\"" + value + "\"";
    if (value instanceof Character) return "'" + value + "'";
    if (value instanceof Float) return value + "f";
    return value.toString();
  }

  private static String binaryOperator(Tree.Kind kind) {
    switch (kind) {
      case PLUS:
        return "+";
      case MINUS:
        return "-";
      case MULTIPLY:
        return "*";
      case DIVIDE:
        return "/";
      case REMAINDER:
        return "%";
      case GREATER_THAN:
        return ">";
      case LESS_THAN:
        return "<";
      case AND:
        return "&";
      case XOR:
        return "^";
      case OR:
        return "|";
      case CONDITIONAL_AND:
        return "&&";
      case CONDITIONAL_OR:
        return "||";
      case LEFT_SHIFT:
        return "<<";
      case RIGHT_SHIFT:
        return ">>";
      case UNSIGNED_RIGHT_SHIFT:
        return ">>>";
      case EQUAL_TO:
        return "==";
      case NOT_EQUAL_TO:
        return "!=";
      case GREATER_THAN_EQUAL:
        return ">=";
      case LESS_THAN_EQUAL:
        return "<=";
      default:
        throw new IllegalArgumentException("unexpected binary operator " + kind);
    }
  }

  private static String unaryOperator(Tree.Kind kind, String value) {
    switch (kind) {
      case UNARY_MINUS:
      // The old SignatureFormatter.formatUnaryOperation rendered UNARY_PLUS as "-value".
      // Preserve that behavior to keep snapshots stable.
      case UNARY_PLUS:
        return "-" + value;
      case POSTFIX_INCREMENT:
        return value + "++";
      case POSTFIX_DECREMENT:
        return value + "--";
      case PREFIX_INCREMENT:
        return "++" + value;
      case PREFIX_DECREMENT:
        return "--" + value;
      case BITWISE_COMPLEMENT:
        return "~" + value;
      case LOGICAL_COMPLEMENT:
        return "!" + value;
      default:
        throw new IllegalArgumentException("unexpected unary operator " + kind);
    }
  }

  // -------- Helpers --------

  private static void printKeyword(StringBuilder s, String keyword) {
    if (keyword.isEmpty()) return;
    s.append(keyword).append(' ');
  }

  private static void printKeywordln(StringBuilder s, String keyword) {
    if (keyword.isEmpty()) return;
    s.append(keyword).append('\n');
  }

  private static boolean isEnumConstant(Element sym) {
    if (sym.getKind() != ElementKind.ENUM_CONSTANT) return false;
    Element owner = sym.getEnclosingElement();
    return owner != null && owner.getKind() == ElementKind.ENUM;
  }

  /**
   * Renders the constructor arguments of an enum constant declaration ("A", 420), or {@code ""} if
   * the initializer is not a {@code new EnumType(...)} expression or carries no arguments.
   */
  private static String enumConstantArgs(Tree declTree) {
    if (!(declTree instanceof VariableTree)) return "";
    ExpressionTree initializer = ((VariableTree) declTree).getInitializer();
    if (!(initializer instanceof NewClassTree)) return "";
    return ((NewClassTree) initializer)
        .getArguments().stream().map(Object::toString).collect(Collectors.joining(", "));
  }

  private static boolean isEnumParent(TypeMirror parent) {
    return isQualified(parent, "java.lang.Enum");
  }

  private static boolean isAnnotationParent(TypeMirror parent) {
    return isQualified(parent, "java.lang.annotation.Annotation");
  }

  private static boolean isJavaLangObject(TypeMirror tpe) {
    return isQualified(tpe, "java.lang.Object");
  }

  private static boolean isQualified(TypeMirror tpe, String qualifiedName) {
    if (!(tpe instanceof DeclaredType)) return false;
    Element elem = ((DeclaredType) tpe).asElement();
    return elem instanceof TypeElement
        && qualifiedName.contentEquals(((TypeElement) elem).getQualifiedName());
  }

  private Element elementOf(Tree tree) {
    TreePath path = trees.getPath(compilationUnit, tree);
    return path == null ? null : trees.getElement(path);
  }

  private TypeMirror typeOf(Tree tree) {
    TreePath path = trees.getPath(compilationUnit, tree);
    return path == null ? null : trees.getTypeMirror(path);
  }
}
