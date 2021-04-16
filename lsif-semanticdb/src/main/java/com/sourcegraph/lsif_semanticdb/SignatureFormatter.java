package com.sourcegraph.lsif_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation.Property;
import com.sourcegraph.semanticdb_javac.Semanticdb.*;

import com.sourcegraph.semanticdb_javac.SemanticdbSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SignatureFormatter {
  private static final Type OBJECT_TYPE_REF =
      Type.newBuilder().setTypeRef(TypeRef.newBuilder().setSymbol("java/lang/Object#")).build();

  private static final Type WILDCARD_TYPE_REF =
      Type.newBuilder().setTypeRef(TypeRef.newBuilder().setSymbol("local_wildcard")).build();

  private static final String ARRAY_SYMBOL = "scala/Array#";
  private static final String ENUM_SYMBOL = "java/lang/Enum#";
  private static final String ANNOTATION_SYMBOL = "java/lang/annotation/Annotation#";

  private final StringBuilder s = new StringBuilder();
  private final SymbolInformation symbolInformation;
  private final Symtab symtab;

  public SignatureFormatter(SymbolInformation symbolInformation, Symtab symtab) {
    this.symbolInformation = symbolInformation;
    this.symtab = symtab;
  }

  public String formatSymbol() {
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

    printKeywordln(formatAnnotations());

    printKeyword(formatAccess());
    if (!isEnum && !isAnnotation) printKeyword(formatModifiers());

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
    }
    s.append(symbolInformation.getDisplayName());

    List<SymbolInformation> typeParameters = getSymlinks(classSignature.getTypeParameters());
    if (!typeParameters.isEmpty()) {
      s.append(
          typeParameters.stream()
              .map(this::formatTypeParameter)
              .collect(Collectors.joining(", ", "<", ">")));
    }

    boolean hasSuperClass = !classSignature.getParentsList().contains(OBJECT_TYPE_REF);

    List<Type> nonSyntheticParents =
        classSignature.getParentsList().stream()
            .filter(parent -> !parent.equals(OBJECT_TYPE_REF))
            .filter(parent -> !parent.getTypeRef().getSymbol().equals(ENUM_SYMBOL))
            .filter(parent -> !parent.getTypeRef().getSymbol().equals(ANNOTATION_SYMBOL))
            .collect(Collectors.toList());

    if (nonSyntheticParents.isEmpty()) return;

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
        if (isEnum || !hasSuperClass) {
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

    if (symbolInformation.getKind() != SymbolInformation.Kind.CONSTRUCTOR) {
      printKeyword(formatType(methodSignature.getReturnType()));
      s.append(symbolInformation.getDisplayName());
    } else {
      String owner = SymbolDescriptor.parseFromSymbol(symbolInformation.getSymbol()).owner;
      // Fix for https://github.com/sourcegraph/lsif-java/issues/150
      if (!owner.equals(SemanticdbSymbols.NONE)) {
        s.append(SymbolDescriptor.parseFromSymbol(owner).descriptor.name);
      }
    }

    s.append(
        methodSignature.getParameterListsList().stream()
            .flatMap((params) -> getSymlinks(params).stream())
            .map(
                symInfo ->
                    formatType(symInfo.getSignature().getValueSignature().getTpe())
                        + " "
                        + symInfo.getDisplayName())
            .collect(Collectors.joining(", ", "(", ")")));

    if (!methodSignature.getThrowsList().isEmpty()) {
      printKeyword(" throws");
      s.append(
          methodSignature.getThrowsList().stream()
              .map(this::formatType)
              .collect(Collectors.joining(", ")));
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
      printKeyword(formatType(valueSignature.getTpe()));
      s.append(symbolInformation.getDisplayName());
    }
  }

  private void formatTypeParameterSignature(TypeSignature typeSignature) {
    s.append(symbolInformation.getDisplayName());
    if (typeSignature.hasLowerBound()) {
      printKeyword(" super");
      s.append(formatType(typeSignature.getLowerBound()));
    } else if (typeSignature.hasUpperBound()
        && !typeSignature.getUpperBound().equals(OBJECT_TYPE_REF)) {
      printKeyword(" extends");
      s.append(formatType(typeSignature.getUpperBound()));
    }
  }

  /**
   * Transforms symlinks from a Scope into a List of SymbolInformation's looked up in the Symtab.
   */
  private List<SymbolInformation> getSymlinks(Scope scope) {
    ArrayList<SymbolInformation> symlinks = new ArrayList<>();
    for (int i = 0; i < scope.getSymlinksCount(); i++) {
      symlinks.add(symtab.symbols.get(scope.getSymlinks(i)));
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

    return typeArguments.stream().map(this::formatType).collect(Collectors.joining(", ", "<", ">"));
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
    if (annotation.getParametersCount() > 0) {
      b.append('(');
      AssignTree firstParam = annotation.getParameters(0).getAssignTree();
      // if only 1 parameter, and its LHS is named 'value', we can omit the 'value = '
      // https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html#jls-9.7.3
      if (annotation.getParametersCount() == 1
          && SymbolDescriptor.parseFromSymbol(firstParam.getLhs().getIdTree().getSymbol())
              .descriptor
              .name
              .equals("value")) {
        b.append(formatTree(firstParam.getRhs()));
      } else {
        String parameter =
            annotation.getParametersList().stream()
                .map(
                    p ->
                        SymbolDescriptor.parseFromSymbol(
                                    p.getAssignTree().getLhs().getIdTree().getSymbol())
                                .descriptor
                                .name
                            + " = "
                            + formatTree(p.getAssignTree().getRhs()))
                .collect(Collectors.joining(", "));
        b.append(parameter);
      }
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
    }

    throw new IllegalArgumentException("tree was of unexpected type " + tree);
  }

  private String formatConstant(Constant constant) {
    if (constant.hasBooleanConstant()) {
      return Boolean.toString(constant.getBooleanConstant().getValue());
    } else if (constant.hasByteConstant()) {
      return Integer.toString(constant.getByteConstant().getValue());
    } else if (constant.hasShortConstant()) {
      return Integer.toString(constant.getShortConstant().getValue());
    } else if (constant.hasCharConstant()) {
      return String.valueOf((char) constant.getCharConstant().getValue());
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
    }
    throw new IllegalArgumentException("constant was not of known type " + constant);
  }

  private String formatType(Type type) {
    StringBuilder b = new StringBuilder();
    if (type.hasTypeRef()) {
      TypeRef typeRef = type.getTypeRef();
      if (typeRef.getSymbol().equals(ARRAY_SYMBOL)) {
        b.append(formatType(typeRef.getTypeArguments(0)));
        b.append("[]");
      } else {
        b.append(symbolDisplayName(typeRef.getSymbol()));
        b.append(formatTypeArguments(typeRef.getTypeArgumentsList()));
      }
    } else if (type.hasIntersectionType()) {
      b.append(
          type.getIntersectionType().getTypesList().stream()
              .map(this::formatType)
              .collect(Collectors.joining(" & ")));
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
              .collect(Collectors.joining(", ", "<", ">")));
    }

    return b.toString();
  }

  private String formatAccess() {
    if (symbolInformation.getAccess().hasPrivateAccess()) {
      return "private";
    } else if (symbolInformation.getAccess().hasPublicAccess()) {
      return "public";
    } else if (symbolInformation.getAccess().hasProtectedAccess()) {
      return "protected";
    }
    return "";
  }

  private String formatModifiers() {
    ArrayList<String> modifiers = new ArrayList<>();
    if (has(Property.ABSTRACT)) {
      modifiers.add("abstract");
    }
    if (has(Property.STATIC)) {
      modifiers.add("static");
    }
    if (has(Property.FINAL)) {
      modifiers.add("final");
    }
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
