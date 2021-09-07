package com.sourcegraph.semanticdb_javac;

import javax.lang.model.element.*;
import java.util.*;
import java.util.stream.Collectors;

import static com.sourcegraph.semanticdb_javac.Debugging.pprint;

/** Cache of SemanticDB symbols that can be referenced between files. */
public final class GlobalSymbolsCache {

  private final IdentityHashMap<Element, String> globals = new IdentityHashMap<>();
  private final SemanticdbJavacOptions options;

  public GlobalSymbolsCache(SemanticdbJavacOptions options) {
    this.options = options;
  }

  public String semanticdbSymbol(Element sym, LocalSymbolsCache locals) {
    String result = globals.get(sym);
    if (result != null) return result;
    String localResult = locals.get(sym);
    if (localResult != null) return localResult;
    result = uncachedSemanticdbSymbol(sym, locals);
    if (SemanticdbSymbols.isGlobal(result)) {
      globals.put(sym, result);
    }
    return result;
  }

  public boolean isNone(Element sym) {
    return sym == null;
  }

  private String uncachedSemanticdbSymbol(Element sym, LocalSymbolsCache locals) {
    if (isNone(sym)) return SemanticdbSymbols.NONE;
    if (sym instanceof PackageElement) return packageElementSymbol((PackageElement) sym);
    String owner;
    if (sym.getEnclosingElement() instanceof PackageElement) {
      owner = packageElementSymbol((PackageElement) sym.getEnclosingElement());
    } else {
      owner = semanticdbSymbol(sym.getEnclosingElement(), locals);
    }

    if (owner.equals(SemanticdbSymbols.NONE)) {
      return SemanticdbSymbols.ROOT_PACKAGE;
    } else if (SemanticdbSymbols.isLocal(owner) || isAnonymousClass(sym) || isLocalVariable(sym)) {
      return locals.put(sym);
    }
    SemanticdbSymbols.Descriptor desc = semanticdbDescriptor(sym);
    if (options.verboseEnabled && desc.kind == SemanticdbSymbols.Descriptor.Kind.None) {
      pprint(sym.getSimpleName().toString());
      pprint(
          String.format(
              "sym: '%s' (%s - superclass %s)",
              sym, sym.getClass(), sym.getClass().getSuperclass()));
    }
    return SemanticdbSymbols.global(owner, desc);
  }

  private String packageElementSymbol(PackageElement packageElement) {
    List<String> parts =
        Arrays.stream(packageElement.getQualifiedName().toString().split("\\."))
            .filter(s -> !s.isEmpty())
            .collect(Collectors.toList());
    if (parts.size() == 0) return SemanticdbSymbols.ROOT_PACKAGE;
    return SemanticdbSymbols.global(
        packageOwnerSymbol(parts.subList(0, parts.size() - 1)),
        new SemanticdbSymbols.Descriptor(
            SemanticdbSymbols.Descriptor.Kind.Package, parts.get(parts.size() - 1)));
  }

  private String packageOwnerSymbol(List<String> parts) {
    if (parts.isEmpty()) return SemanticdbSymbols.Descriptor.NONE.encode();
    return SemanticdbSymbols.global(
        packageOwnerSymbol(parts.subList(0, parts.size() - 1)),
        new SemanticdbSymbols.Descriptor(
            SemanticdbSymbols.Descriptor.Kind.Package, parts.get(parts.size() - 1)));
  }

  private boolean isLocalVariable(Element sym) {
    return sym instanceof VariableElement
        && (sym.getKind() == ElementKind.LOCAL_VARIABLE
            || sym.getKind() == ElementKind.PARAMETER
            || sym.getKind() == ElementKind.EXCEPTION_PARAMETER);
  }

  private boolean isAnonymousClass(Element sym) {
    return sym instanceof TypeElement && sym.getSimpleName().toString().isEmpty();
  }

  private SemanticdbSymbols.Descriptor semanticdbDescriptor(Element sym) {
    if (sym instanceof TypeElement) {
      return new SemanticdbSymbols.Descriptor(
          SemanticdbSymbols.Descriptor.Kind.Type, sym.getSimpleName().toString());
    } else if (sym instanceof ExecutableElement) {
      return new SemanticdbSymbols.Descriptor(
          SemanticdbSymbols.Descriptor.Kind.Method,
          sym.getSimpleName().toString(),
          methodDisambiguator((ExecutableElement) sym));
    } else if (sym instanceof PackageElement) {
      return new SemanticdbSymbols.Descriptor(
          SemanticdbSymbols.Descriptor.Kind.Package, sym.getSimpleName().toString());
    } else if (sym instanceof TypeParameterElement) {
      return new SemanticdbSymbols.Descriptor(
          SemanticdbSymbols.Descriptor.Kind.TypeParameter, sym.getSimpleName().toString());
    } else if (sym instanceof VariableElement) {
      return new SemanticdbSymbols.Descriptor(
          SemanticdbSymbols.Descriptor.Kind.Term, sym.getSimpleName().toString());
    } else {
      return SemanticdbSymbols.Descriptor.NONE;
    }
  }

  /**
   * Computes the method "disambiguator" according to the SemanticDB spec.
   *
   * <p><quote> Concatenation of a left parenthesis ("("), a tag and a right parenthesis (")"). If
   * the definition is not overloaded, the tag is empty. If the definition is overloaded, the tag is
   * computed depending on where the definition appears in the following order:
   *
   * <ul>
   *   <li>non-static overloads first, following the same order as they appear in the original
   *       source,
   *   <li>static overloads secondly, following the same order as they appear in the original source
   * </ul>
   *
   * </quote>
   *
   * <p><a href="https://scalameta.org/docs/semanticdb/specification.html#symbol-2">Link to
   * SemanticDB spec</a>.
   */
  private String methodDisambiguator(ExecutableElement sym) {
    Iterable<? extends Element> elements = sym.getEnclosingElement().getEnclosedElements();
    ArrayList<ExecutableElement> methods = new ArrayList<>();
    for (Element e : elements) {
      if (e instanceof ExecutableElement && e.getSimpleName() == sym.getSimpleName()) {
        methods.add((ExecutableElement) e);
      }
    }
    // NOTE(olafur): sort static methods last, according to the spec. Historical note: this
    // requirement is
    // part of the SemanticDB spec because static methods and non-static methods have a different
    // "owner" symbol.
    // There is no way to recover the definition order for a mix of static non-static method
    // definitions.
    // In practice, it's unusual to mix static and non-static methods so this shouldn't be a big
    // issue.
    methods.sort(
        (a, b) -> Boolean.compare(a.getReceiverType() == null, b.getReceiverType() == null));
    int index = methods.indexOf(sym);
    if (index == 0) return "()";
    return String.format("(+%d)", index);
  }
}
