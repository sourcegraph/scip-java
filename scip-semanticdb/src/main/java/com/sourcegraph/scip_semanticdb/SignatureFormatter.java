package com.sourcegraph.scip_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation.Property;
import com.sourcegraph.semanticdb_javac.Semanticdb.*;

import com.sourcegraph.semanticdb_javac.SemanticdbSymbols;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.sourcegraph.semanticdb_javac.SemanticdbBuilders.typeRef;

public class SignatureFormatter {
  private static final Type OBJECT_TYPE_REF = typeRef("java/lang/Object#");
  private static final Type PRODUCT_TYPE_REF = typeRef("scala/Product#");
  private static final Type SCALA_SERIALIZABLE_TYPE_REF = typeRef("scala/package.Serializable#");
  private static final Type JAVA_SERIALIZABLE_TYPE_REF = typeRef("java/util/Serializable#");
  private static final Type SCALA_ANY_TYPE_REF = typeRef("scala/Any#");
  private static final Type SCALA_ANYREF_TYPE_REF = typeRef("scala/AnyRef#");

  private static final Type WILDCARD_TYPE_REF = typeRef("local_wildcard");

  private static final Type NOTHING_SYMBOL = typeRef("scala/Nothing#");
  private static final String FUNCTION_SYMBOL_PREFIX = "scala/Function";
  // Special case scala/Function object to not conflict with Function1 for example
  private static final String FUNCTION_OBJECT = "scala/Function.";
  private static final String TUPLE_SYMBOL_PREFIX = "scala/Tuple";
  private static final String ARRAY_SYMBOL = "scala/Array#";
  private static final String ENUM_SYMBOL = "java/lang/Enum#";
  private static final String ANNOTATION_SYMBOL = "java/lang/annotation/Annotation#";
  private static final Set<Type> REDUNDANT_CLASS_PARENTS = new HashSet<>();
  private static final Set<Type> CASE_CLASS_PARENTS = new HashSet<>();

  {
    REDUNDANT_CLASS_PARENTS.add(OBJECT_TYPE_REF);
    REDUNDANT_CLASS_PARENTS.add(SCALA_ANY_TYPE_REF);
    REDUNDANT_CLASS_PARENTS.add(SCALA_ANYREF_TYPE_REF);

    CASE_CLASS_PARENTS.add(PRODUCT_TYPE_REF);
    CASE_CLASS_PARENTS.add(SCALA_SERIALIZABLE_TYPE_REF);
    CASE_CLASS_PARENTS.add(JAVA_SERIALIZABLE_TYPE_REF);
  }

  private final StringBuilder s = new StringBuilder();
  private final SymbolInformation symbolInformation;
  private final Symtab symtab;
  private final boolean isScala;

  public SignatureFormatter(SymbolInformation symbolInformation, Symtab symtab) {
    this.symbolInformation = symbolInformation;
    this.symtab = symtab;
    this.isScala = symbolInformation.getLanguage() == Language.SCALA;
  }

  public String formatSymbol() {
    try {
      return formatSymbolUnsafe();
    } catch (Exception e) {
      throw new SignatureFormatterException(symbolInformation, e);
    }
  }

  private String formatSymbolUnsafe() {
    Signature signature = symbolInformation.getSignature();
    if (signature.hasClassSignature()) {
      formatClassSignature(signature.getClassSignature());
    } else if (signature.hasMethodSignature()) {
      formatMethodSignature(signature.getMethodSignature());
    } else if (signature.hasValueSignature()) {
      formatValueSignature(signature.getValueSignature());
    } else if (signature.hasTypeSignature()) {
      formatTypeParameterSignature(signature.getTypeSignature());
    }
    return s.toString();
  }

  private void formatClassSignature(ClassSignature classSignature) {
    boolean isAnnotation =
        classSignature.getParentsList().stream()
            .anyMatch(t -> t.getTypeRef().getSymbol().equals(ANNOTATION_SYMBOL));

    boolean isEnum = has(Property.ENUM);
    boolean isInterface = symbolInformation.getKind() == SymbolInformation.Kind.INTERFACE;

    printKeywordln(formatAnnotations());

    printKeyword(formatAccess());
    if (!isEnum && !isAnnotation && !isInterface) printKeyword(formatModifiers());

    switch (symbolInformation.getKind()) {
      case CLASS:
        if (isEnum) {
          printKeyword("enum");
        } else {
          printKeyword("class");
        }
        break;
      case INTERFACE:
        if (isAnnotation) {
          printKeyword("@interface");
          break;
        }
        printKeyword("interface");
        break;
      case OBJECT:
        printKeyword("object");
        break;
      case TRAIT:
        printKeyword("trait");
        break;
      case PACKAGE_OBJECT:
        printKeyword("package object");
        break;
      default:
        break;
    }
    s.append(symbolInformation.getDisplayName());
    if (symbolInformation.getKind() == SymbolInformation.Kind.CLASS && has(Property.CASE)) {
      primaryConstructor(classSignature)
          .ifPresent(
              constructorSignature ->
                  formatScalaParameterList(constructorSignature.getParameterListsList()));
    }

    List<SymbolInformation> typeParameters = getSymlinks(classSignature.getTypeParameters());
    if (!typeParameters.isEmpty()) {
      s.append(
          typeParameters.stream()
              .map(this::formatTypeParameter)
              .collect(Collectors.joining(", ", isScala ? "[" : "<", isScala ? "]" : ">")));
    }

    boolean hasNonRedundantParent =
        classSignature.getParentsList().size() > 0
            && !REDUNDANT_CLASS_PARENTS.contains(classSignature.getParentsList().get(0));

    boolean isCaseClass =
        isScala
            && symbolInformation.getKind() == SymbolInformation.Kind.CLASS
            && has(Property.CASE);

    List<Type> nonSyntheticParents =
        classSignature.getParentsList().stream()
            .filter(parent -> !REDUNDANT_CLASS_PARENTS.contains(parent))
            .filter(parent -> !parent.getTypeRef().getSymbol().equals(ENUM_SYMBOL))
            .filter(parent -> isCaseClass && !CASE_CLASS_PARENTS.contains(parent))
            .filter(parent -> !parent.getTypeRef().getSymbol().equals(ANNOTATION_SYMBOL))
            .collect(Collectors.toList());

    if (nonSyntheticParents.isEmpty()) return;

    if (isScala) {
      printKeyword(" extends");
      s.append(
          nonSyntheticParents.stream().map(this::formatType).collect(Collectors.joining(" with ")));
      return;
    }

    // Determine which parents from ClassSignature.parents are classes or interfaces so we know to
    // use
    // 'extends' or 'implements'.
    // The logic is as follows:
    // 1. If the symbol has type CLASS, there will always be at least 1 parent. For enums, this is
    //    java/lang/Enum#, otherwise it is java/lang/Object# if no superclass is specified.
    //    Therefore, if the parents list contains java/lang/Object# type or the symbol is an enum,
    //    then no superclass was defined and all parents are interfaces and we must print
    // 'implements'
    //    followed by all superinterfaces.
    //    Else if it is not an enum and the list of non-synthetic parents is non empty, a superclass
    //    was specified and we must print it with the 'extends' keyword prefixed, followed by
    //    'implements' and all superinterfaces, if any.
    // 2. If the symbol has type INTERFACE, then any defined parents must also be interfaces, so if
    //    the list of non-synthetic parents is not empty, print 'implements' and all
    // superinterfaces.
    switch (symbolInformation.getKind()) {
      case CLASS:
        // if no superclass or is an enum, every non synthetic parent is an interface
        if (isEnum || !hasNonRedundantParent) {
          printKeyword(" implements");

          String superInterfaces =
              nonSyntheticParents.stream().map(this::formatType).collect(Collectors.joining(", "));
          s.append(superInterfaces);
        } else {
          // else if has a superclass and is not an enum
          printKeyword(" extends");
          s.append(formatType(nonSyntheticParents.get(0)));

          String superInterfaces =
              nonSyntheticParents.stream()
                  .skip(1)
                  .map(this::formatType)
                  .collect(Collectors.joining(", "));
          if (!superInterfaces.isEmpty()) {
            printKeyword(" implements");
            s.append(superInterfaces);
          }
        }
        break;
      case INTERFACE:
        // can only extend other interfaces
        printKeyword(" extends");

        String superInterfaces =
            nonSyntheticParents.stream().map(this::formatType).collect(Collectors.joining(", "));
        s.append(superInterfaces);
    }
  }

  private void formatMethodSignature(MethodSignature methodSignature) {
    if (isScala) {
      formatScalaMethodSignature(methodSignature);
      return;
    }

    printKeywordln(formatAnnotations());
    printKeyword(formatAccess());
    printKeyword(formatModifiers());

    List<SymbolInformation> typeParameters = getSymlinks(methodSignature.getTypeParameters());
    if (!typeParameters.isEmpty()) {
      printKeyword(
          typeParameters.stream()
              .map(this::formatTypeParameter)
              .collect(Collectors.joining(", ", "<", ">")));
    }

    if (symbolInformation.getKind() == SymbolInformation.Kind.CONSTRUCTOR) {
      String owner = SymbolDescriptor.parseFromSymbol(symbolInformation.getSymbol()).owner;
      // Fix for https://github.com/sourcegraph/scip-java/issues/150
      if (!owner.equals(SemanticdbSymbols.NONE)) {
        s.append(SymbolDescriptor.parseFromSymbol(owner).descriptor.name);
      }
    } else {
      printKeyword(formatType(methodSignature.getReturnType()));
      s.append(symbolInformation.getDisplayName());
    }

    s.append(
        methodSignature.getParameterListsList().stream()
            .flatMap((params) -> getSymlinks(params).stream())
            .map(this::formatTermParameter)
            .collect(Collectors.joining(", ", "(", ")")));

    if (!methodSignature.getThrowsList().isEmpty()) {
      printKeyword(" throws");
      s.append(
          methodSignature.getThrowsList().stream()
              .map(this::formatType)
              .collect(Collectors.joining(", ")));
    }
  }

  private String formatTermParameter(SymbolInformation info) {
    if (info == null) return "";
    if (isScala) {
      return info.getDisplayName()
          + ": "
          + formatType(info.getSignature().getValueSignature().getTpe());
    }
    return formatType(info.getSignature().getValueSignature().getTpe())
        + " "
        + info.getDisplayName();
  }

  private void formatScalaMethodSignature(MethodSignature methodSignature) {
    printKeywordln(formatAnnotations());
    printKeyword(formatAccess());
    printKeyword(formatModifiers());
    if (has(Property.VAL)) {
      printKeyword("val");
    } else if (has(Property.VAR)) {
      printKeyword("var");
    } else {
      printKeyword("def");
    }
    s.append(
        symbolInformation.getKind() == SymbolInformation.Kind.CONSTRUCTOR
            ? "this"
            : symbolInformation.getDisplayName());
    formatScalaParameterList(methodSignature.getParameterListsList());
    if (symbolInformation.getKind() != SymbolInformation.Kind.CONSTRUCTOR) {
      printKeyword(":");
      s.append(this.formatType(methodSignature.getReturnType()));
    }
  }

  private Optional<MethodSignature> primaryConstructor(ClassSignature classSignature) {
    Symtab scopeSymtab = symtab.withHardlinks(classSignature.getDeclarations());
    int n = classSignature.getDeclarations().getSymlinksCount();
    for (int i = 0; i < n; i++) {
      String symlink = classSignature.getDeclarations().getSymlinks(i);
      SymbolInformation info = scopeSymtab.symbols.get(symlink);
      if (info != null
          && info.getKind() == SymbolInformation.Kind.CONSTRUCTOR
          && has(Property.PRIMARY, info)
          && info.hasSignature()
          && info.getSignature().hasMethodSignature()) {
        return Optional.of(info.getSignature().getMethodSignature());
      }
    }
    return Optional.empty();
  }

  private void formatScalaParameterList(List<Scope> parameterList) {
    for (Scope scope : parameterList) {
      List<SymbolInformation> infos =
          scope.getHardlinksCount() > 0 ? scope.getHardlinksList() : getSymlinks(scope);
      s.append(
          infos.stream()
              .map(this::formatTermParameter)
              .collect(Collectors.joining(", ", "(", ")")));
    }
  }

  private void formatValueSignature(ValueSignature valueSignature) {
    printKeywordln(formatAnnotations());
    if (isEnumConstant()) {
      String ownerSym = SymbolDescriptor.parseFromSymbol(symbolInformation.getSymbol()).owner;
      SymbolInformation ownerInfo = symtab.symbols.get(ownerSym);
      List<SymbolInformation> enumConstants =
          getSymlinks(ownerInfo.getSignature().getClassSignature().getDeclarations()).stream()
              .filter(Objects::nonNull)
              .filter(this::isEnumConstant)
              .collect(Collectors.toList());
      int ordinal = enumConstants.indexOf(symbolInformation);
      s.append(ownerInfo.getDisplayName()).append('.');
      s.append(this.symbolInformation.getDisplayName());
      s.append(" /* ordinal ").append(ordinal).append(" */");
    } else {
      printKeyword(formatAccess());
      printKeyword(formatModifiers());
      if (isScala) {
        s.append(symbolInformation.getDisplayName());
        printKeyword(":");
        printKeyword(formatType(valueSignature.getTpe()));
      } else {
        printKeyword(formatType(valueSignature.getTpe()));
        s.append(symbolInformation.getDisplayName());
      }
    }
  }

  private void formatTypeParameterSignature(TypeSignature typeSignature) {
    if (isScala && symbolInformation.getKind() == SymbolInformation.Kind.TYPE) {
      printKeyword("type");
    }
    s.append(symbolInformation.getDisplayName());
    if (typeSignature.hasLowerBound()
        && (!isScala || !typeSignature.getLowerBound().equals(NOTHING_SYMBOL))) {
      printKeyword(isScala ? " >:" : " super");
      s.append(formatType(typeSignature.getLowerBound()));
    }
    if (typeSignature.hasUpperBound()
        && !typeSignature.getUpperBound().equals(isScala ? SCALA_ANY_TYPE_REF : OBJECT_TYPE_REF)) {
      printKeyword(isScala ? " <:" : " extends");
      s.append(formatType(typeSignature.getUpperBound()));
    }
  }

  /**
   * Transforms symlinks from a Scope into a List of SymbolInformation's looked up in the Symtab.
   */
  private List<SymbolInformation> getSymlinks(Scope scope) {
    ArrayList<SymbolInformation> symlinks = new ArrayList<>();
    for (int i = 0; i < scope.getSymlinksCount(); i++) {
      SymbolInformation info = symtab.symbols.get(scope.getSymlinks(i));
      if (info != null) {
        symlinks.add(info);
      }
    }
    return symlinks;
  }

  /**
   * Formats one of a method's/class's type parameter symbols through recursion from the
   * SymbolInformation extracted from the Symtab. This works by the signature being a TypeSignature.
   */
  private String formatTypeParameter(SymbolInformation typeInfo) {
    return new SignatureFormatter(typeInfo, symtab).formatSymbol();
  }

  private String formatTypeArguments(List<Type> typeArguments) {
    if (typeArguments.isEmpty()) return "";

    return typeArguments.stream()
        .map(this::formatType)
        .collect(Collectors.joining(", ", isScala ? "[" : "<", isScala ? "]" : ">"));
  }

  private String formatAnnotations() {
    return formatAnnotations(symbolInformation);
  }

  private String formatAnnotations(SymbolInformation symInfo) {
    return symInfo.getAnnotationsList().stream()
        .map(this::formatAnnotation)
        .collect(Collectors.joining("\n"));
  }

  private String formatAnnotation(AnnotationTree annotation) {
    StringBuilder b = new StringBuilder();
    b.append('@');
    b.append(formatType(annotation.getTpe()));

    if (annotation.getParametersCount() == 1) {
      b.append('(');

      Tree parameter = annotation.getParameters(0);
      // if only 1 parameter, and its LHS is named 'value', we can omit the 'value = '
      // https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html#jls-9.7.3
      AssignTree firstParam = parameter.getAssignTree();
      if (parameter.hasAssignTree()
          && SymbolDescriptor.parseFromSymbol(firstParam.getLhs().getIdTree().getSymbol())
              .descriptor
              .name
              .equals("value")) {
        b.append(formatTree(firstParam.getRhs()));
      } else {
        b.append(formatTree(parameter));
      }

      b.append(')');
    } else if (annotation.getParametersCount() > 1) {
      b.append('(');
      String parameter =
          annotation.getParametersList().stream()
              .map(this::formatTree)
              .collect(Collectors.joining(", "));
      b.append(parameter);
      b.append(')');
    }

    return b.toString();
  }

  private String formatTree(Tree tree) {
    if (tree.hasIdTree()) {
      return SymbolDescriptor.parseFromSymbol(tree.getIdTree().getSymbol()).descriptor.name;
    } else if (tree.hasLiteralTree()) {
      return formatConstant(tree.getLiteralTree().getConstant());
    } else if (tree.hasSelectTree()) {
      return formatTree(tree.getSelectTree().getQualifier())
          + "."
          + SymbolDescriptor.parseFromSymbol(tree.getSelectTree().getId().getSymbol())
              .descriptor
              .name;
    } else if (tree.hasAnnotationTree()) {
      return formatAnnotation(tree.getAnnotationTree());
    } else if (tree.hasApplyTree()) {
      if (tree.getApplyTree().getFunction().hasIdTree()
          && tree.getApplyTree().getFunction().getIdTree().getSymbol().equals(ARRAY_SYMBOL)) {
        return tree.getApplyTree().getArgumentsList().stream()
            .map(this::formatTree)
            .collect(Collectors.joining(", ", "{", "}"));
      } else {
        throw new IllegalArgumentException(
            "unexpected apply tree function " + tree.getApplyTree().getFunction());
      }
    } else if (tree.hasBinopTree()) {
      return formatTree(tree.getBinopTree().getLhs())
          + " "
          + formatBinaryOperator(tree.getBinopTree().getOp())
          + " "
          + formatTree(tree.getBinopTree().getRhs());
    } else if (tree.hasAssignTree()) {
      return formatTree(tree.getAssignTree().getLhs())
          + " = "
          + formatTree(tree.getAssignTree().getRhs());
    }

    throw new IllegalArgumentException("tree was of unexpected type " + tree);
  }

  private String formatConstant(Constant constant) {
    if (constant.hasUnitConstant()) {
      return isScala ? "()" : "scala.Unit()";
    } else if (constant.hasBooleanConstant()) {
      return Boolean.toString(constant.getBooleanConstant().getValue());
    } else if (constant.hasByteConstant()) {
      return Integer.toString(constant.getByteConstant().getValue());
    } else if (constant.hasShortConstant()) {
      return Integer.toString(constant.getShortConstant().getValue());
    } else if (constant.hasCharConstant()) {
      return String.format("'%s'", (char) constant.getCharConstant().getValue());
    } else if (constant.hasIntConstant()) {
      return Integer.toString(constant.getIntConstant().getValue());
    } else if (constant.hasLongConstant()) {
      return Long.toString(constant.getLongConstant().getValue());
    } else if (constant.hasFloatConstant()) {
      return Float.toString(constant.getFloatConstant().getValue()) + 'f';
    } else if (constant.hasDoubleConstant()) {
      return Double.toString(constant.getDoubleConstant().getValue());
    } else if (constant.hasStringConstant()) {
      return '"' + constant.getStringConstant().getValue() + '"';
    } else if (constant.hasNullConstant()) {
      return "null";
    }
    throw new IllegalArgumentException("constant was not of known type " + constant);
  }

  private String formatBinaryOperator(BinaryOperator op) {
    switch (op) {
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
      case SHIFT_LEFT:
        return "<<";
      case SHIFT_RIGHT:
        return ">>";
      case SHIFT_RIGHT_UNSIGNED:
        return ">>>";
      case EQUAL_TO:
        return "==";
      case NOT_EQUAL_TO:
        return "!=";
      case GREATER_THAN_EQUAL:
        return ">=";
      case LESS_THAN_EQUAL:
        return "<=";
      case UNRECOGNIZED:
        throw new IllegalArgumentException("unexpected binary operator " + op);
    }
    return null;
  }

  private String formatType(Type type) {
    StringBuilder b = new StringBuilder();
    if (type.hasTypeRef()) {
      TypeRef typeRef = type.getTypeRef();
      if (typeRef.getSymbol().equals(ARRAY_SYMBOL)) {
        if (isScala) {
          b.append("Array[");
          b.append(formatType(typeRef.getTypeArguments(0)));
          b.append("]");
        } else {
          b.append(formatType(typeRef.getTypeArguments(0)));
          b.append("[]");
        }
      } else if (isScala
          && typeRef.getSymbol().startsWith(FUNCTION_SYMBOL_PREFIX)
          && typeRef.getTypeArgumentsCount() > 0
          && !typeRef.getSymbol().startsWith(FUNCTION_OBJECT)) {
        int n = typeRef.getTypeArgumentsCount() - 1;
        if (n == 0) {
          // Special-case for Function1[A, B]: don't wrap `A`  in parenthesis like this `(A) => B`
          s.append(formatType(typeRef.getTypeArguments(0)));
        } else {
          b.append(
              typeRef.getTypeArgumentsList().stream()
                  .limit(Math.max(0, n))
                  .map(this::formatType)
                  .collect(Collectors.joining(", ", "(", ")")));
        }
        b.append(" => ");
        b.append(formatType(typeRef.getTypeArguments(n)));
      } else if (isScala && typeRef.getSymbol().startsWith(TUPLE_SYMBOL_PREFIX)) {
        b.append(
            typeRef.getTypeArgumentsList().stream()
                .map(this::formatType)
                .collect(Collectors.joining(", ", "(", ")")));
      } else {
        b.append(symbolDisplayName(typeRef.getSymbol()));
        b.append(formatTypeArguments(typeRef.getTypeArgumentsList()));
      }
    } else if (type.hasSingleType()) {
      SingleType tpe = type.getSingleType();
      if (tpe.hasPrefix()) {
        b.append(formatType(tpe.getPrefix()));
      }
      SymbolInformation info = symtab.symbols.get(tpe.getSymbol());
      if (info != null) {
        b.append(info.getDisplayName()).append(".type");
      }
    } else if (type.hasThisType()) {
      b.append("this.type");
    } else if (type.hasSuperType()) {
      SuperType tpe = type.getSuperType();
      if (tpe.hasPrefix()) {
        b.append(formatType(tpe.getPrefix())).append(".");
      }
      b.append("super");
    } else if (type.hasConstantType()) {
      b.append(this.formatConstant(type.getConstantType().getConstant()));
    } else if (type.hasIntersectionType()) {
      b.append(
          type.getIntersectionType().getTypesList().stream()
              .map(this::formatType)
              .collect(Collectors.joining(isScala ? " with " : " & ")));
    } else if (type.hasUnionType()) {
      b.append(
          type.getIntersectionType().getTypesList().stream()
              .map(this::formatType)
              .collect(Collectors.joining(" | ")));
    } else if (type.hasStructuralType()) {
      StructuralType tpe = type.getStructuralType();
      int n = tpe.getDeclarations().getHardlinksCount();
      if (n == 0) {
        b.append(" {}");
      } else {
        b.append(formatType(tpe.getTpe())).append(" {");
        Symtab hardlinkSymtab = symtab.withHardlinks(tpe.getDeclarations());
        for (int i = 0; i < n; i++) {
          SymbolInformation info = tpe.getDeclarations().getHardlinks(i);
          if (i > 0) {
            b.append(";");
          }
          b.append(" ").append(new SignatureFormatter(info, hardlinkSymtab).formatSymbol());
        }
        b.append(" }");
      }
    } else if (type.hasExistentialType()) {
      AtomicInteger hardlinkStep = new AtomicInteger();
      TypeRef typeRef = type.getExistentialType().getTpe().getTypeRef();
      b.append(symbolDisplayName(type.getExistentialType().getTpe().getTypeRef().getSymbol()));
      b.append(
          typeRef.getTypeArgumentsList().stream()
              .map(
                  (typeArg) -> {
                    // if hardlink (aka wildcard) we need to reach into declarations at index
                    // hardlinkStep
                    if (typeArg.equals(WILDCARD_TYPE_REF)) {
                      SymbolInformation hardlink =
                          type.getExistentialType()
                              .getDeclarations()
                              .getHardlinks(hardlinkStep.getAndIncrement());
                      return symbolDisplayName(hardlink.getSymbol())
                          + new SignatureFormatter(hardlink, symtab).formatSymbol();
                    }
                    // else for symlink we can use the usual path
                    return formatType(typeArg);
                  })
              .collect(Collectors.joining(", ", isScala ? "[" : "<", isScala ? "[" : ">")));
    } else if (type.hasByNameType()) {
      b.append("=> ").append(formatType(type.getByNameType().getTpe()));
    } else if (type.hasRepeatedType()) {
      b.append(formatType(type.getRepeatedType().getTpe())).append("*");
    }

    return b.toString().trim();
  }

  private String formatAccess() {
    Access access = symbolInformation.getAccess();
    if (access.hasPrivateAccess()) {
      return "private";
    } else if (!isScala && access.hasPublicAccess()) {
      return "public";
    } else if (access.hasProtectedAccess()) {
      return "protected";
    } else if (isScala && access.hasPrivateThisAccess()) {
      return "private[this]";
    } else if (isScala && access.hasPrivateWithinAccess()) {
      String name =
          SymbolDescriptor.parseFromSymbol(access.getPrivateWithinAccess().getSymbol())
              .descriptor
              .name;
      return String.format("protected[%s]", name);
    }
    return "";
  }

  // https://checkstyle.sourceforge.io/config_modifier.html#ModifierOrder
  private String formatModifiers() {
    ArrayList<String> modifiers = new ArrayList<>();
    if (has(Property.ABSTRACT)) {
      if (isScala && symbolInformation.getKind() != SymbolInformation.Kind.CLASS) {
      } else {
        modifiers.add("abstract");
      }
    }
    if (has(Property.DEFAULT)) modifiers.add("default");
    if (has(Property.STATIC)) modifiers.add("static");
    if (has(Property.FINAL)) {
      if (symbolInformation.getKind() != SymbolInformation.Kind.OBJECT
          && symbolInformation.getKind() != SymbolInformation.Kind.PACKAGE_OBJECT) {
        modifiers.add("final");
      }
    }
    if (has(Property.IMPLICIT)) modifiers.add("implicit");
    if (has(Property.SEALED)) modifiers.add("sealed");
    if (has(Property.CASE)) modifiers.add("case");
    return String.join(" ", modifiers);
  }

  private void printKeyword(String keyword) {
    if (keyword.isEmpty()) return;
    s.append(keyword).append(' ');
  }

  private void printKeywordln(String keyword) {
    if (keyword.isEmpty()) return;
    s.append(keyword).append('\n');
  }

  private boolean isEnumConstant(SymbolInformation symInfo) {
    if (!(has(Property.ENUM, symInfo)
        && has(Property.FINAL, symInfo)
        && has(Property.STATIC, symInfo)
        && symInfo.getAccess().hasPublicAccess())) {
      return false;
    }
    SymbolInformation owner =
        symtab.symbols.get(SymbolDescriptor.parseFromSymbol(symInfo.getSymbol()).owner);
    if (owner == null) return false;
    return owner.getKind() == SymbolInformation.Kind.CLASS && has(Property.ENUM, owner);
  }

  private boolean isEnumConstant() {
    return isEnumConstant(symbolInformation);
  }

  private boolean has(Property property, SymbolInformation symInfo) {
    return (symInfo.getProperties() & property.getNumber()) > 0;
  }

  private boolean has(Property property) {
    return has(property, symbolInformation);
  }

  /**
   * Transforms a SemanticDB symbol string into its Java identifier display string. As SemanticDB
   * uses Scala "primitive" types for Java primitives (but not for Java boxing primitive wrappers),
   * we check for those first before attempting to decode a SemanticDB symbol.
   */
  public String symbolDisplayName(String symbol) {
    if (isScala) {
      return symbolScalaDisplayName(symbol);
    }
    return symbolJavaDisplayName(symbol);
  }

  private String symbolScalaDisplayName(String symbol) {
    if ("local_wildcard".equals(symbol)) {
      return "*";
    }
    return SymbolDescriptor.parseFromSymbol(symbol).descriptor.name;
  }

  private String symbolJavaDisplayName(String symbol) {
    switch (symbol) {
      case "local_wildcard":
        return "?";
      case "scala/Boolean#":
        return "boolean";
      case "scala/Byte#":
        return "byte";
      case "scala/Short#":
        return "short";
      case "scala/Int#":
        return "int";
      case "scala/Long#":
        return "long";
      case "scala/Char#":
        return "char";
      case "scala/Float#":
        return "float";
      case "scala/Double#":
        return "double";
      case "scala/Unit#":
        return "void";
      default:
        return SymbolDescriptor.parseFromSymbol(symbol).descriptor.name;
    }
  }
}
