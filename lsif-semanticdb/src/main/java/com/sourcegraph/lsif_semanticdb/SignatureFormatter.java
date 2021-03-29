package com.sourcegraph.lsif_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb.*;

public class SignatureFormatter {
  private static final Type OBJECT_TYPE_REF =
      Type.newBuilder().setTypeRef(TypeRef.newBuilder().setSymbol("java/lang/Object#")).build();

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
    }

    return s.toString();
  }

  private void formatClassSignature(ClassSignature classSignature) {

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

  private String formatType(Type type) {
    StringBuilder b = new StringBuilder();

    return b.toString();
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
