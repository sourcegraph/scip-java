package com.sourcegraph.semanticdb_javac;

import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sourcegraph.semanticdb_javac.Semanticdb.*;

import javax.lang.model.element.Element;
import javax.lang.model.type.*;
import javax.lang.model.type.IntersectionType;
import javax.lang.model.util.SimpleTypeVisitor8;
import java.util.ArrayList;
import java.util.List;

public final class SemanticdbSignatures {
  private final GlobalSymbolsCache cache;
  private final LocalSymbolsCache locals;

  private static final Semanticdb.Type UNRESOLVED_TYPE_REF =
      Semanticdb.Type.newBuilder()
          .setTypeRef(TypeRef.newBuilder().setSymbol("unresolved_type#"))
          .build();

  public SemanticdbSignatures(GlobalSymbolsCache cache, LocalSymbolsCache locals) {
    this.cache = cache;
    this.locals = locals;
  }

  public Signature generateSignature(Symbol sym) {
    if (sym instanceof Symbol.ClassSymbol) {
      return generateClassSignature((Symbol.ClassSymbol) sym);
    } else if (sym instanceof Symbol.MethodSymbol) {
      return generateMethodSignature((Symbol.MethodSymbol) sym);
    } else if (sym instanceof Symbol.VarSymbol) {
      return generateFieldSignature((Symbol.VarSymbol) sym);
    } else if (sym instanceof Symbol.TypeVariableSymbol) {
      return generateTypeSignature((Symbol.TypeVariableSymbol) sym);
    }
    return null;
  }

  private Signature generateClassSignature(Symbol.ClassSymbol sym) {
    ClassSignature.Builder builder = ClassSignature.newBuilder();

    builder.setTypeParameters(generateScope(sym.getTypeParameters()));

    if (sym.getSuperclass() != Type.noType) {
      Semanticdb.Type superType = generateType(sym.getSuperclass());
      if (superType == null) {
        superType = UNRESOLVED_TYPE_REF;
      }
      builder.addParents(superType);
    }
    for (Type iType : sym.getInterfaces()) {
      Semanticdb.Type type = generateType(iType);
      if (type == null) {
        type = UNRESOLVED_TYPE_REF;
      }
      builder.addParents(type);
    }

    Scope.Builder declarations = Scope.newBuilder();
    for (Symbol enclosed : sym.getEnclosedElements()) {
      declarations.addSymlinks(cache.semanticdbSymbol(enclosed, locals));
    }
    builder.setDeclarations(generateScope(sym.getEnclosedElements()));

    return Signature.newBuilder().setClassSignature(builder).build();
  }

  private Signature generateMethodSignature(Symbol.MethodSymbol sym) {
    MethodSignature.Builder builder = MethodSignature.newBuilder();

    builder.setTypeParameters(generateScope(sym.getTypeParameters()));

    builder.addParameterLists(generateScope(sym.params()));

    Semanticdb.Type returnType = generateType(sym.getReturnType());
    if (returnType != null) {
      builder.setReturnType(returnType);
    }

    return Signature.newBuilder().setMethodSignature(builder).build();
  }

  private Signature generateFieldSignature(Symbol.VarSymbol sym) {
    Semanticdb.Type generateType = generateType(sym.type);
    if (generateType == null) {
      generateType = UNRESOLVED_TYPE_REF;
    }
    return Signature.newBuilder()
        .setValueSignature(ValueSignature.newBuilder().setTpe(generateType))
        .build();
  }

  private Signature generateTypeSignature(Symbol.TypeVariableSymbol sym) {
    TypeSignature.Builder builder = TypeSignature.newBuilder();

    builder.setTypeParameters(generateScope(sym.getTypeParameters()));

    Semanticdb.Type upperBound = generateType(sym.type.getUpperBound());
    if (upperBound != null) builder.setUpperBound(upperBound);
    else builder.setUpperBound(UNRESOLVED_TYPE_REF);

    return Signature.newBuilder().setTypeSignature(builder).build();
  }

  private <T extends Element> Scope generateScope(List<T> elements) {
    Scope.Builder scope = Scope.newBuilder();
    for (T typeVar : elements) {
      String s = cache.semanticdbSymbol(typeVar, locals);
      scope.addSymlinks(s);
    }
    return scope.build();
  }

  private Semanticdb.Type generateType(TypeMirror mirror) {
    return mirror.accept(new SemanticdbTypeVisitor(cache, locals), null);
  }

  /** A TypeMirror tree visitor that constructs a recursive SemanticDB Type structure. */
  private static class SemanticdbTypeVisitor extends SimpleTypeVisitor8<Semanticdb.Type, Void> {
    private final GlobalSymbolsCache cache;
    private final LocalSymbolsCache locals;

    private SemanticdbTypeVisitor(GlobalSymbolsCache cache, LocalSymbolsCache locals) {
      this.cache = cache;
      this.locals = locals;
    }

    @Override
    public Semanticdb.Type visitDeclared(DeclaredType t, Void unused) {
      boolean isExistential =
          t.getTypeArguments().stream().anyMatch((type) -> type instanceof WildcardType);

      ArrayList<Semanticdb.Type> typeParams = new ArrayList<>();
      Scope.Builder declarations = Scope.newBuilder();
      for (TypeMirror type : t.getTypeArguments()) {
        Semanticdb.Type visited = super.visit(type);
        if (visited == null) {
          visited = UNRESOLVED_TYPE_REF;
        }
        typeParams.add(visited);

        if (type instanceof WildcardType) {
          TypeSignature.Builder typeSig = TypeSignature.newBuilder();
          WildcardType wildcardType = (WildcardType) type;

          // semanticdb spec asks for List() not None for  type_parameters field
          typeSig.setTypeParameters(Scope.newBuilder());

          if (wildcardType.getExtendsBound() != null) {
            typeSig.setUpperBound(super.visit(wildcardType.getExtendsBound()));
          } else if (wildcardType.getSuperBound() != null) {
            typeSig.setLowerBound(super.visit(wildcardType.getSuperBound()));
          }

          declarations.addHardlinks(
              SymbolInformation.newBuilder()
                  .setSymbol("local_wildcard")
                  .setSignature(Signature.newBuilder().setTypeSignature(typeSig)));
        } else {
          declarations.addSymlinks(cache.semanticdbSymbol(((Type) type).asElement(), locals));
        }
      }

      if (!isExistential) {
        return Semanticdb.Type.newBuilder()
            .setTypeRef(
                TypeRef.newBuilder()
                    .setSymbol(cache.semanticdbSymbol(t.asElement(), locals))
                    .addAllTypeArguments(typeParams))
            .build();
      } else {
        return Semanticdb.Type.newBuilder()
            .setExistentialType(
                ExistentialType.newBuilder()
                    .setTpe(
                        Semanticdb.Type.newBuilder()
                            .setTypeRef(
                                TypeRef.newBuilder()
                                    .setSymbol(cache.semanticdbSymbol(t.asElement(), locals))
                                    .addAllTypeArguments(typeParams)))
                    .setDeclarations(declarations))
            .build();
      }
    }

    @Override
    public Semanticdb.Type visitArray(ArrayType t, Void unused) {
      Semanticdb.Type arrayComponentType = super.visit(t.getComponentType());
      if (arrayComponentType == null) {
        arrayComponentType = UNRESOLVED_TYPE_REF;
      }
      return Semanticdb.Type.newBuilder()
          .setTypeRef(
              TypeRef.newBuilder().setSymbol("scala/Array#").addTypeArguments(arrayComponentType))
          .build();
    }

    @Override
    public Semanticdb.Type visitPrimitive(PrimitiveType t, Void unused) {
      return Semanticdb.Type.newBuilder()
          .setTypeRef(TypeRef.newBuilder().setSymbol(primitiveSymbol(t.getKind())))
          .build();
    }

    @Override
    public Semanticdb.Type visitTypeVariable(TypeVariable t, Void unused) {
      return Semanticdb.Type.newBuilder()
          .setTypeRef(
              TypeRef.newBuilder().setSymbol(cache.semanticdbSymbol(t.asElement(), locals)).build())
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
              TypeRef.newBuilder().setSymbol("local_wildcard").build())
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
}
