package com.sourcegraph.scip_javac;

import static com.sourcegraph.scip_javac.Debugging.pprint;

import com.sourcegraph.scip.LocalSymbolsCache;
import com.sourcegraph.scip.ScipSymbols;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.ModuleElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.QualifiedNameable;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;

/** Cache of SCIP symbols that can be referenced between files. */
public final class GlobalSymbolsCache {

  private final IdentityHashMap<Element, String> globals = new IdentityHashMap<>();
  private final ScipJavacOptions options;

  public GlobalSymbolsCache(ScipJavacOptions options) {
    this.options = options;
  }

  public String symbol(Element sym, LocalSymbolsCache<Element, String> locals) {
    String result = globals.get(sym);
    if (result != null) return result;
    String localResult = locals.get(sym);
    if (localResult != null) return localResult;
    result = uncachedSymbol(sym, locals);
    if (ScipSymbols.isGlobal(result)) {
      globals.put(sym, result);
    }
    return result;
  }

  private String uncachedSymbol(Element sym, LocalSymbolsCache<Element, String> locals) {
    if (sym == null) return ScipSymbols.ROOT_PACKAGE;

    if (sym instanceof PackageElement packageElement) {
      if (packageElement.isUnnamed()) return ScipSymbols.ROOT_PACKAGE;

      StringBuilder sb = new StringBuilder();
      String qualifiedName = packageElement.getQualifiedName().toString();
      int i = 0;
      int j = 0;
      while (j < qualifiedName.length()) {
        if (i == qualifiedName.length() || qualifiedName.charAt(i) == '.') {
          final String name = qualifiedName.substring(j, i);
          ScipSymbols.Descriptor desc =
              new ScipSymbols.Descriptor(ScipSymbols.Descriptor.Kind.Package, name);
          sb.append(desc.encode());
          j = i + 1;
        }
        i++;
      }

      return sb.toString();
    } else if (sym instanceof ModuleElement) return ScipSymbols.ROOT_PACKAGE;

    if (isAnonymousClass(sym) || isLocalVariable(sym)) return locals.put(sym);

    String owner = symbol(sym.getEnclosingElement(), locals);
    if (ScipSymbols.isLocal(owner)) return locals.put(sym);

    ScipSymbols.Descriptor desc = scipDescriptor(sym);
    if (options.verboseEnabled && desc.kind() == ScipSymbols.Descriptor.Kind.None) {
      if (sym instanceof QualifiedNameable qualifiedNameable)
        pprint(qualifiedNameable.getQualifiedName().toString());
      else pprint(sym.getSimpleName().toString());
      pprint(
          String.format(
              "sym: %s (%s - superclass %s)", sym, sym.getClass(), sym.getClass().getSuperclass()));
    }
    return ScipSymbols.global(owner, desc);
  }

  private boolean isLocalVariable(Element sym) {
    return switch (sym.getKind()) {
      case PARAMETER, EXCEPTION_PARAMETER, LOCAL_VARIABLE -> true;
      default -> false;
    };
  }

  private boolean isAnonymousClass(Element sym) {
    return sym instanceof TypeElement && sym.getSimpleName().length() == 0;
  }

  private ScipSymbols.Descriptor scipDescriptor(Element sym) {
    if (sym instanceof TypeElement) {
      return new ScipSymbols.Descriptor(
          ScipSymbols.Descriptor.Kind.Type, sym.getSimpleName().toString());
    } else if (sym instanceof ExecutableElement executableElement) {
      return new ScipSymbols.Descriptor(
          ScipSymbols.Descriptor.Kind.Method,
          sym.getSimpleName().toString(),
          methodDisambiguator(executableElement));
    } else if (sym instanceof TypeParameterElement) {
      return new ScipSymbols.Descriptor(
          ScipSymbols.Descriptor.Kind.TypeParameter, sym.getSimpleName().toString());
    } else if (sym instanceof VariableElement) {
      return new ScipSymbols.Descriptor(
          ScipSymbols.Descriptor.Kind.Term, sym.getSimpleName().toString());
    } else {
      return ScipSymbols.Descriptor.NONE;
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
      if (e instanceof ExecutableElement executableElement
          && e.getSimpleName() == sym.getSimpleName()) {
        methods.add(executableElement);
      }
    }
    // NOTE(olafur): sort static methods last, according to the spec. Historical note: this
    // requirement is
    // part of the SCIP spec because static methods and non-static methods have a different
    // "owner" symbol.
    // There is no way to recover the definition order for a mix of static nnon-static method
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
