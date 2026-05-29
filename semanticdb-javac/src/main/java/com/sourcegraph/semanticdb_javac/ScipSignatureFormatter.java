package com.sourcegraph.semanticdb_javac;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
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
 * Formats a Java {@link Element} as a human-readable declaration string suitable for SCIP's {@code
 * SymbolInformation.signature_documentation.text}.
 *
 * <p>This is a port of the Java-relevant parts of {@code SignatureFormatter} that runs directly
 * over javac's {@link Element}/{@link TypeMirror} APIs, eliminating the need to round-trip through
 * SemanticDB signatures.
 */
public final class ScipSignatureFormatter {

  private final Element sym;

  public ScipSignatureFormatter(Element sym) {
    this.sym = sym;
  }

  /** Returns the formatted signature, or {@code ""} if {@link #sym} has no meaningful signature. */
  public String formatSymbol() {
    StringBuilder out = new StringBuilder();
    switch (sym.getKind()) {
      case CLASS:
      case INTERFACE:
      case ANNOTATION_TYPE:
      case ENUM:
        formatType(out, (TypeElement) sym);
        break;
      case CONSTRUCTOR:
      case METHOD:
        formatExecutable(out, (ExecutableElement) sym);
        break;
      case FIELD:
      case ENUM_CONSTANT:
      case PARAMETER:
      case LOCAL_VARIABLE:
      case EXCEPTION_PARAMETER:
      case RESOURCE_VARIABLE:
        formatVariable(out, (VariableElement) sym);
        break;
      case TYPE_PARAMETER:
        formatTypeParameter(out, (TypeParameterElement) sym);
        break;
      default:
        return "";
    }
    return out.toString();
  }

  private static void formatAnnotations(StringBuilder out, Element element) {
    for (AnnotationMirror mirror : element.getAnnotationMirrors()) {
      out.append('@').append(simpleName(mirror.getAnnotationType())).append('\n');
    }
  }

  private static String simpleName(TypeMirror t) {
    if (t instanceof DeclaredType) {
      Element e = ((DeclaredType) t).asElement();
      return e.getSimpleName().toString();
    }
    return t.toString();
  }

  private static void formatModifiers(StringBuilder out, Set<Modifier> modifiers) {
    for (Modifier m : modifiers) {
      out.append(m.toString()).append(' ');
    }
  }

  private void formatType(StringBuilder out, TypeElement type) {
    formatAnnotations(out, type);
    formatModifiers(out, type.getModifiers());
    switch (type.getKind()) {
      case ENUM:
        out.append("enum ");
        break;
      case INTERFACE:
        out.append("interface ");
        break;
      case ANNOTATION_TYPE:
        out.append("@interface ");
        break;
      case CLASS:
      default:
        out.append("class ");
        break;
    }
    out.append(type.getSimpleName());
    formatTypeParameters(out, type.getTypeParameters());

    TypeMirror superclass = type.getSuperclass();
    if (superclass.getKind() != TypeKind.NONE
        && !isJavaLangObject(superclass)
        && type.getKind() != ElementKind.INTERFACE) {
      out.append(" extends ");
      formatTypeMirror(out, superclass);
    }

    List<? extends TypeMirror> interfaces = type.getInterfaces();
    if (!interfaces.isEmpty()) {
      out.append(type.getKind() == ElementKind.INTERFACE ? " extends " : " implements ");
      formatJoin(out, interfaces, ", ");
    }
  }

  private void formatExecutable(StringBuilder out, ExecutableElement method) {
    formatAnnotations(out, method);
    formatModifiers(out, method.getModifiers());
    if (!method.getTypeParameters().isEmpty()) {
      formatTypeParameters(out, method.getTypeParameters());
      out.append(' ');
    }
    if (method.getKind() != ElementKind.CONSTRUCTOR) {
      formatTypeMirror(out, method.getReturnType());
      out.append(' ');
      out.append(method.getSimpleName());
    } else {
      // Constructor: name = enclosing class simple name
      out.append(method.getEnclosingElement().getSimpleName());
    }
    out.append('(');
    Iterator<? extends VariableElement> it = method.getParameters().iterator();
    while (it.hasNext()) {
      VariableElement p = it.next();
      formatTypeMirror(out, p.asType());
      out.append(' ').append(p.getSimpleName());
      if (it.hasNext()) out.append(", ");
    }
    out.append(')');
    List<? extends TypeMirror> thrown = method.getThrownTypes();
    if (!thrown.isEmpty()) {
      out.append(" throws ");
      formatJoin(out, thrown, ", ");
    }
  }

  private void formatVariable(StringBuilder out, VariableElement variable) {
    formatAnnotations(out, variable);
    formatModifiers(out, variable.getModifiers());
    if (variable.getKind() == ElementKind.ENUM_CONSTANT) {
      out.append(variable.getSimpleName());
    } else {
      formatTypeMirror(out, variable.asType());
      out.append(' ').append(variable.getSimpleName());
    }
  }

  private void formatTypeParameter(StringBuilder out, TypeParameterElement tp) {
    out.append(tp.getSimpleName());
    List<? extends TypeMirror> bounds = tp.getBounds();
    if (!bounds.isEmpty()) {
      // Skip implicit `extends Object`.
      if (bounds.size() != 1 || !isJavaLangObject(bounds.get(0))) {
        out.append(" extends ");
        formatJoin(out, bounds, " & ");
      }
    }
  }

  private void formatTypeParameters(
      StringBuilder out, List<? extends TypeParameterElement> typeParameters) {
    if (typeParameters.isEmpty()) return;
    out.append('<');
    Iterator<? extends TypeParameterElement> it = typeParameters.iterator();
    while (it.hasNext()) {
      formatTypeParameter(out, it.next());
      if (it.hasNext()) out.append(", ");
    }
    out.append('>');
  }

  private void formatJoin(StringBuilder out, List<? extends TypeMirror> types, String separator) {
    Iterator<? extends TypeMirror> it = types.iterator();
    while (it.hasNext()) {
      formatTypeMirror(out, it.next());
      if (it.hasNext()) out.append(separator);
    }
  }

  private void formatTypeMirror(StringBuilder out, TypeMirror type) {
    type.accept(new TypePrinter(), out);
  }

  private static boolean isJavaLangObject(TypeMirror type) {
    if (!(type instanceof DeclaredType)) return false;
    Element e = ((DeclaredType) type).asElement();
    return e instanceof TypeElement
        && ((TypeElement) e).getQualifiedName().contentEquals("java.lang.Object");
  }

  /** Prints a TypeMirror using simple-names + type arguments + array brackets. */
  private static final class TypePrinter extends SimpleTypeVisitor8<Void, StringBuilder> {

    @Override
    public Void visitDeclared(DeclaredType t, StringBuilder out) {
      out.append(simpleName(t));
      List<? extends TypeMirror> args = t.getTypeArguments();
      if (!args.isEmpty()) {
        out.append('<');
        Iterator<? extends TypeMirror> it = args.iterator();
        while (it.hasNext()) {
          visit(it.next(), out);
          if (it.hasNext()) out.append(", ");
        }
        out.append('>');
      }
      return null;
    }

    @Override
    public Void visitArray(ArrayType t, StringBuilder out) {
      visit(t.getComponentType(), out);
      out.append("[]");
      return null;
    }

    @Override
    public Void visitPrimitive(PrimitiveType t, StringBuilder out) {
      out.append(t.getKind().name().toLowerCase());
      return null;
    }

    @Override
    public Void visitTypeVariable(TypeVariable t, StringBuilder out) {
      out.append(t.asElement().getSimpleName());
      return null;
    }

    @Override
    public Void visitWildcard(WildcardType t, StringBuilder out) {
      out.append('?');
      if (t.getExtendsBound() != null) {
        out.append(" extends ");
        visit(t.getExtendsBound(), out);
      } else if (t.getSuperBound() != null) {
        out.append(" super ");
        visit(t.getSuperBound(), out);
      }
      return null;
    }

    @Override
    public Void visitIntersection(IntersectionType t, StringBuilder out) {
      Iterator<? extends TypeMirror> it = t.getBounds().iterator();
      while (it.hasNext()) {
        visit(it.next(), out);
        if (it.hasNext()) out.append(" & ");
      }
      return null;
    }

    @Override
    public Void visitNoType(NoType t, StringBuilder out) {
      if (t.getKind() == TypeKind.VOID) {
        out.append("void");
      }
      return null;
    }

    @Override
    protected Void defaultAction(TypeMirror t, StringBuilder out) {
      out.append(t.toString());
      return null;
    }
  }
}
