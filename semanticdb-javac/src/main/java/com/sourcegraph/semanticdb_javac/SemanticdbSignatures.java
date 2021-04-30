package com.sourcegraph.semanticdb_javac;

import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sourcegraph.semanticdb_javac.Semanticdb.*;

import javax.lang.model.element.Element;
import javax.lang.model.type.*;
import java.util.List;
import java.util.stream.Collectors;

import static com.sourcegraph.semanticdb_javac.SemanticdbBuilders.*;
import static com.sourcegraph.semanticdb_javac.SemanticdbTypeVisitor.UNRESOLVED_TYPE_REF;

public final class SemanticdbSignatures {
  private final GlobalSymbolsCache cache;
  private final LocalSymbolsCache locals;

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

    builder.setDeclarations(generateScope(sym.getEnclosedElements()));

    return signature(builder);
  }

  private Signature generateMethodSignature(Symbol.MethodSymbol sym) {
    MethodSignature.Builder builder = MethodSignature.newBuilder();

    builder.setTypeParameters(generateScope(sym.getTypeParameters()));

    builder.addParameterLists(generateScope(sym.params()));

    Semanticdb.Type returnType = generateType(sym.getReturnType());
    if (returnType != null) {
      builder.setReturnType(returnType);
    }

    List<Semanticdb.Type> thrownTypes =
        sym.getThrownTypes().stream().map(this::generateType).collect(Collectors.toList());
    builder.addAllThrows(thrownTypes);

    return signature(builder);
  }

  private Signature generateFieldSignature(Symbol.VarSymbol sym) {
    Semanticdb.Type generateType = generateType(sym.type);
    if (generateType == null) {
      generateType = UNRESOLVED_TYPE_REF;
    }
    return signature(ValueSignature.newBuilder().setTpe(generateType));
  }

  private Signature generateTypeSignature(Symbol.TypeVariableSymbol sym) {
    TypeSignature.Builder builder = TypeSignature.newBuilder();

    builder.setTypeParameters(generateScope(sym.getTypeParameters()));

    Semanticdb.Type upperBound = generateType(sym.type.getUpperBound());
    if (upperBound != null) builder.setUpperBound(upperBound);
    else builder.setUpperBound(UNRESOLVED_TYPE_REF);

    return signature(builder);
  }

  private Scope generateScope(List<? extends Element> elements) {
    Scope.Builder scope = Scope.newBuilder();
    for (Element typeVar : elements) {
      scope.addSymlinks(cache.semanticdbSymbol(typeVar, locals));
    }
    return scope.build();
  }

  private Semanticdb.Type generateType(TypeMirror mirror) {
    return new SemanticdbTypeVisitor(cache, locals).semanticdbType(mirror);
  }
}
