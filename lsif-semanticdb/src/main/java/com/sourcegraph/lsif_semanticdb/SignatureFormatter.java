package com.sourcegraph.lsif_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation.Property;
import com.sourcegraph.semanticdb_javac.Semanticdb.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SignatureFormatter {
  private static final Type OBJECT_TYPE_REF =
      Type.newBuilder().setTypeRef(TypeRef.newBuilder().setSymbol("java/lang/Object#")).build();

  private static final Type WILDCARD_TYPE_REF =
      Type.newBuilder().setTypeRef(TypeRef.newBuilder().setSymbol("local_wildcard")).build();

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
    printKeyword(formatAccess());
    printKeyword(formatModifiers());

    switch (symbolInformation.getKind()) {
      case CLASS:
        if (has(Property.ENUM)) {
          printKeyword("enum");
        } else {
          printKeyword("class");
        }
        break;
      case INTERFACE:
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

    List<Type> parentsList =
        classSignature.getParentsList().stream()
            .filter((parent) -> !parent.equals(OBJECT_TYPE_REF))
            .collect(Collectors.toList());
    if (!parentsList.isEmpty()) {
      printKeyword(" extends");

      String parents = parentsList.stream().map(this::formatType).collect(Collectors.joining(", "));
      s.append(parents);
    }
  }

  private void formatMethodSignature(MethodSignature methodSignature) {
    printKeyword(formatAccess());
    printKeyword(formatModifiers());

    List<SymbolInformation> typeParameters = getSymlinks(methodSignature.getTypeParameters());
    if (!typeParameters.isEmpty()) {
      printKeyword(
          typeParameters.stream()
              .map(this::formatTypeParameter)
              .collect(Collectors.joining(", ", "<", ">")));
    }

    printKeyword(formatType(methodSignature.getReturnType()));
    s.append(symbolInformation.getDisplayName());

    s.append(
        methodSignature.getParameterListsList().stream()
            .flatMap((params) -> getSymlinks(params).stream())
            .map(
                (symInfo) ->
                    formatType(symInfo.getSignature().getValueSignature().getTpe())
                        + " "
                        + symInfo.getDisplayName())
            .collect(Collectors.joining(", ", "(", ")")));
  }

  private void formatValueSignature(ValueSignature valueSignature) {
    printKeyword(formatAccess());
    printKeyword(formatModifiers());
    printKeyword(formatType(valueSignature.getTpe()));
    s.append(symbolInformation.getDisplayName());
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

  private String formatType(Type type) {
    StringBuilder b = new StringBuilder();
    if (type.hasTypeRef()) {
      TypeRef typeRef = type.getTypeRef();
      b.append(symbolDisplayName(typeRef.getSymbol()));
      b.append(formatTypeArguments(typeRef.getTypeArgumentsList()));
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

  private boolean has(Property property) {
    return (symbolInformation.getProperties() & property.getNumber()) > 0;
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
