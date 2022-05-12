package com.sourcegraph.scip_semanticdb;

import com.sourcegraph.semanticdb_javac.SemanticdbSymbols;
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols.Descriptor;
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols.Descriptor.Kind;
import java.util.Optional;

public class SymbolDescriptor {

  public final SemanticdbSymbols.Descriptor descriptor;
  public final String owner;

  public SymbolDescriptor(SemanticdbSymbols.Descriptor descriptor, String owner) {
    this.descriptor = descriptor;
    this.owner = owner;
  }

  public static SymbolDescriptor NONE =
      new SymbolDescriptor(Descriptor.NONE, SemanticdbSymbols.NONE);

  public static SymbolDescriptor parseFromSymbol(String symbol) {
    return new Parser(symbol).entryPoint();
  }

  public static Optional<SymbolDescriptor> toplevel(String symbol) {
    if (symbol == null || symbol.isEmpty()) {
      return Optional.empty();
    }
    if (SemanticdbSymbols.isLocal(symbol)) {
      return Optional.empty();
    }
    SymbolDescriptor current = parseFromSymbol(symbol);
    if (current.descriptor.kind == Kind.Package) {
      return Optional.empty();
    }
    SymbolDescriptor owner = parseFromSymbol(current.owner);
    if (owner.descriptor.kind == Kind.Package) {
      return Optional.of(current);
    } else {
      return toplevel(current.owner);
    }
  }

  public static class Parser {

    private int i;
    private char currChar = EOF;
    private final String symbol;

    private static final char BOF = '\u0000';
    private static final char EOF = '\u001A';

    public Parser(String symbol) {
      i = symbol.length();
      this.symbol = symbol;
    }

    public SymbolDescriptor entryPoint() {
      if (SemanticdbSymbols.isLocal(symbol)) {
        return new SymbolDescriptor(Descriptor.local(symbol), SemanticdbSymbols.NONE);
      }
      if (SemanticdbSymbols.NONE.equals(symbol)) {
        return SymbolDescriptor.NONE;
      }
      readChar();
      SemanticdbSymbols.Descriptor descriptor = parseDescriptor();

      String owner = i < 0 ? SemanticdbSymbols.ROOT_PACKAGE : symbol.substring(0, i + 1);
      return new SymbolDescriptor(descriptor, owner);
    }

    public IllegalArgumentException fail() {
      StringBuilder b = new StringBuilder();
      for (int j = 0; j < i; j++) {
        b.append(' ');
      }
      b.append('^');
      return new IllegalArgumentException("invalid symbol format\n" + symbol + "\n" + b.toString());
    }

    public char readChar() {
      if (i < 0) throw fail();

      if (i == 0) {
        i--;
        currChar = BOF;
        return currChar;
      }

      i--;
      currChar = symbol.charAt(i);
      return currChar;
    }

    public String parseValue() {
      if (currChar == '`') {
        int end = i;
        while (readChar() != '`') {}
        readChar();
        return symbol.substring(i + 2, end);
      } else {
        int end = i + 1;
        if (!Character.isJavaIdentifierPart(currChar)) throw fail();

        while (Character.isJavaIdentifierPart(readChar()) && currChar != BOF) {}
        return symbol.substring(i + 1, end);
      }
    }

    public String parseDisambiguator() {
      int end = i + 1;
      if (currChar != ')') throw fail();
      while (readChar() != '(') {}
      readChar();
      return symbol.substring(i + 1, end);
    }

    public SemanticdbSymbols.Descriptor parseDescriptor() {
      String value;
      switch (currChar) {
        case '.':
          readChar();
          if (currChar == ')') {
            String disamiguator = parseDisambiguator();
            value = parseValue();
            return new SemanticdbSymbols.Descriptor(Kind.Method, value, disamiguator);
          } else {
            return new SemanticdbSymbols.Descriptor(Kind.Term, parseValue());
          }
        case '#':
          readChar();
          return new SemanticdbSymbols.Descriptor(Kind.Type, parseValue());
        case '/':
          readChar();
          return new SemanticdbSymbols.Descriptor(Kind.Package, parseValue());
        case ')':
          readChar();
          value = parseValue();
          if (currChar != '(') throw fail();
          readChar();
          return new SemanticdbSymbols.Descriptor(Kind.Parameter, value);
        case ']':
          readChar();
          value = parseValue();
          if (currChar != '[') throw fail();
          readChar();
          return new SemanticdbSymbols.Descriptor(Kind.TypeParameter, value);
        default:
          throw fail();
      }
    }
  }
}
