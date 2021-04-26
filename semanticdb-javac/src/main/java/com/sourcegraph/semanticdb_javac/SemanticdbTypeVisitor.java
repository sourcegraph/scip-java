package com.sourcegraph.semanticdb_javac;

import com.sun.tools.javac.code.Type;

import javax.lang.model.type.*;
import javax.lang.model.util.SimpleTypeVisitor8;
import java.util.ArrayList;

/** A TypeMirror tree visitor that constructs a recursive SemanticDB Type structure. */
class SemanticdbTypeVisitor extends SimpleTypeVisitor8<Semanticdb.Type, Void> {
  static final Semanticdb.Type UNRESOLVED_TYPE_REF =
      Semanticdb.Type.newBuilder()
          .setTypeRef(Semanticdb.TypeRef.newBuilder().setSymbol("unresolved_type#"))
          .build();

  static final String ARRAY_SYMBOL = "scala/Array#";

  private final GlobalSymbolsCache cache;
  private final LocalSymbolsCache locals;

  SemanticdbTypeVisitor(GlobalSymbolsCache cache, LocalSymbolsCache locals) {
    this.cache = cache;
    this.locals = locals;
  }

  public Semanticdb.Type semanticdbType(TypeMirror tpe) {
    Semanticdb.Type result = super.visit(tpe);
    return result == null ? UNRESOLVED_TYPE_REF : result;
  }

  @Override
  public Semanticdb.Type visitDeclared(DeclaredType t, Void unused) {
    boolean isExistential =
        t.getTypeArguments().stream().anyMatch((type) -> type instanceof WildcardType);

    ArrayList<Semanticdb.Type> typeParams = new ArrayList<>();
    Semanticdb.Scope.Builder declarations = Semanticdb.Scope.newBuilder();
    for (TypeMirror type : t.getTypeArguments()) {
      typeParams.add(semanticdbType(type));

      if (type instanceof WildcardType) {
        Semanticdb.TypeSignature.Builder typeSig = Semanticdb.TypeSignature.newBuilder();
        WildcardType wildcardType = (WildcardType) type;

        // semanticdb spec asks for List() not None for  type_parameters field
        typeSig.setTypeParameters(Semanticdb.Scope.newBuilder());

        if (wildcardType.getExtendsBound() != null) {
          typeSig.setUpperBound(super.visit(wildcardType.getExtendsBound()));
        } else if (wildcardType.getSuperBound() != null) {
          typeSig.setLowerBound(super.visit(wildcardType.getSuperBound()));
        }

        declarations.addHardlinks(
            Semanticdb.SymbolInformation.newBuilder()
                .setSymbol("local_wildcard")
                .setSignature(Semanticdb.Signature.newBuilder().setTypeSignature(typeSig)));
      } else {
        declarations.addSymlinks(cache.semanticdbSymbol(((Type) type).asElement(), locals));
      }
    }

    if (!isExistential) {
      return Semanticdb.Type.newBuilder()
          .setTypeRef(
              Semanticdb.TypeRef.newBuilder()
                  .setSymbol(cache.semanticdbSymbol(t.asElement(), locals))
                  .addAllTypeArguments(typeParams))
          .build();
    } else {
      return Semanticdb.Type.newBuilder()
          .setExistentialType(
              Semanticdb.ExistentialType.newBuilder()
                  .setTpe(
                      Semanticdb.Type.newBuilder()
                          .setTypeRef(
                              Semanticdb.TypeRef.newBuilder()
                                  .setSymbol(cache.semanticdbSymbol(t.asElement(), locals))
                                  .addAllTypeArguments(typeParams)))
                  .setDeclarations(declarations))
          .build();
    }
  }

  @Override
  public Semanticdb.Type visitArray(ArrayType t, Void unused) {
    return Semanticdb.Type.newBuilder()
        .setTypeRef(
            Semanticdb.TypeRef.newBuilder()
                .setSymbol(ARRAY_SYMBOL)
                .addTypeArguments(semanticdbType(t.getComponentType())))
        .build();
  }

  @Override
  public Semanticdb.Type visitPrimitive(PrimitiveType t, Void unused) {
    return Semanticdb.Type.newBuilder()
        .setTypeRef(Semanticdb.TypeRef.newBuilder().setSymbol(primitiveSymbol(t.getKind())))
        .build();
  }

  @Override
  public Semanticdb.Type visitTypeVariable(TypeVariable t, Void unused) {
    return Semanticdb.Type.newBuilder()
        .setTypeRef(
            Semanticdb.TypeRef.newBuilder()
                .setSymbol(cache.semanticdbSymbol(t.asElement(), locals))
                .build())
        .build();
  }

  @Override
  public Semanticdb.Type visitIntersection(IntersectionType t, Void unused) {
    ArrayList<Semanticdb.Type> types = new ArrayList<>();
    for (TypeMirror type : t.getBounds()) {
      types.add(super.visit(type));
    }

    return Semanticdb.Type.newBuilder()
        .setIntersectionType(Semanticdb.IntersectionType.newBuilder().addAllTypes(types).build())
        .build();
  }

  @Override
  public Semanticdb.Type visitWildcard(WildcardType t, Void unused) {
    return Semanticdb.Type.newBuilder()
        .setTypeRef(
            // https://github.com/scalameta/scalameta/issues/1703
            // https://sourcegraph.com/github.com/scalameta/scalameta/-/blob/semanticdb/metacp/src/main/scala/scala/meta/internal/javacp/Javacp.scala#L452:19
            Semanticdb.TypeRef.newBuilder().setSymbol("local_wildcard").build())
        .build();
  }

  @Override
  public Semanticdb.Type visitNoType(NoType t, Void unused) {
    return Semanticdb.Type.newBuilder()
        .setTypeRef(Semanticdb.TypeRef.newBuilder().setSymbol(primitiveSymbol(t.getKind())))
        .build();
  }

  public String primitiveSymbol(TypeKind kind) {
    switch (kind) {
      case BOOLEAN:
        return "scala/Boolean#";
      case BYTE:
        return "scala/Byte#";
      case SHORT:
        return "scala/Short#";
      case INT:
        return "scala/Int#";
      case LONG:
        return "scala/Long#";
      case CHAR:
        return "scala/Char#";
      case FLOAT:
        return "scala/Float#";
      case DOUBLE:
        return "scala/Double#";
      case VOID:
        return "scala/Unit#";
      default:
        throw new IllegalArgumentException("got " + kind.name());
    }
  }
}
