package com.sourcegraph.scip;

import java.util.Objects;

/**
 * Utilities to construct SCIP symbols.
 *
 * <p>Most parts of this file have been adapted from the companion Scala implementation:
 *
 * <p>https://github.com/scalameta/scalameta/blob/cf796cf2436b40494baf2bdc266623dc65264ad5/semanticdb/semanticdb/src/main/scala/scala/meta/internal/semanticdb/Scala.scala
 */
public final class ScipSymbols {

  public static String NONE = "";
  public static String ROOT_PACKAGE = "_root_/";

  /** Creates a new global SCIP symbol. */
  public static String global(String owner, Descriptor desc) {
    if (desc == Descriptor.NONE) return ScipSymbols.NONE;
    else if (!ROOT_PACKAGE.equals(owner)) return owner + desc.encode();
    else return desc.encode();
  }

  /**
   * Creates a new local SCIP symbol. The space matches the SCIP wire format and lets {@link
   * #isLocal} disambiguate from a bare descriptor that happens to start with {@code local}.
   */
  public static String local(int suffix) {
    return "local " + suffix;
  }

  public static boolean isLocal(String symbol) {
    return symbol.startsWith("local ");
  }

  public static boolean isGlobal(String symbol) {
    return !isLocal(symbol);
  }

  public static boolean isMethodOrField(String symbol) {
    return symbol.endsWith("#");
  }

  /**
   * A SCIP symbol is composed from a list of "descriptors".
   *
   * <p>For example, the symbol "com/example/Class#method()." is composed of
   *
   * <ul>
   *   <li>package descriptors "com/" and "example/"
   *   <li>type descriptor "Class/"
   *   <li>method descriptor "method()."
   * </ul>
   */
  public static final class Descriptor {

    public static Descriptor NONE = new Descriptor(Kind.None, "", "");

    public enum Kind {
      None,
      Local,
      Term,
      Method,
      Type,
      Package,
      Parameter,
      TypeParameter;
    }

    public final Kind kind;
    public final String name;
    public final String disambiguator;

    public Descriptor(Kind kind, String name) {
      this(kind, name, "");
    }

    public Descriptor(Kind kind, String name, String disambiguator) {
      this.kind = kind;
      this.name = name;
      this.disambiguator = disambiguator;
    }

    public Descriptor withName(String newName) {
      return new Descriptor(kind, newName, disambiguator);
    }

    public Descriptor withKind(Kind newKind) {
      return new Descriptor(newKind, name, disambiguator);
    }

    public static Descriptor local(String name) {
      return new Descriptor(Kind.Local, name);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Descriptor that = (Descriptor) o;
      return kind == that.kind
          && Objects.equals(name, that.name)
          && Objects.equals(disambiguator, that.disambiguator);
    }

    @Override
    public int hashCode() {
      return Objects.hash(kind, name, disambiguator);
    }

    @Override
    public String toString() {
      return "Descriptor{"
          + "kind="
          + kind
          + ", name='"
          + name
          + '\''
          + ", disambiguator='"
          + disambiguator
          + '\''
          + '}';
    }

    public String encode() {
      return switch (kind) {
        case None -> "";
        case Term -> encodeName(name) + ".";
        case Method -> encodeName(name) + disambiguator + ".";
        case Type -> encodeName(name) + "#";
        case Package -> encodeName(name) + "/";
        case Parameter -> "(" + encodeName(name) + ")";
        case TypeParameter -> "[" + encodeName(name) + "]";
        default -> throw new IllegalArgumentException(String.format("%s", kind));
      };
    }

    /** Wraps non-alphanumeric identifiers in backticks, according to the SCIP spec. */
    private static String encodeName(String name) {
      if (name == null || name.isEmpty()) return "``";
      boolean isStartOk = Character.isJavaIdentifierStart(name.charAt(0));
      boolean isPartsOk = true;
      for (int i = 1; isPartsOk && i < name.length(); i++) {
        isPartsOk = Character.isJavaIdentifierPart(name.charAt(i));
      }
      if (isStartOk && isPartsOk) return name;
      else return "`" + name + "`";
    }
  }
}
