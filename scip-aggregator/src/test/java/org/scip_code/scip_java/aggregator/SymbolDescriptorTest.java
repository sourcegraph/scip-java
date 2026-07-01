package org.scip_code.scip_java.aggregator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.scip_code.scip_java.shared.ScipSymbols.Descriptor.Kind;

/**
 * Colocated unit test for {@link SymbolDescriptor#parseFromSymbol}. Migrated from the former Scala
 * SymbolDescriptorSuite in tests/unit; the expected (kind, name, owner) triples follow the SCIP
 * symbol grammar.
 */
class SymbolDescriptorTest {

  private static void check(String symbol, Kind kind, String name, String owner) {
    SymbolDescriptor obtained = SymbolDescriptor.parseFromSymbol(symbol);
    assertEquals(name, obtained.descriptor().name(), symbol);
    assertEquals(owner, obtained.owner(), symbol);
    assertEquals(kind, obtained.descriptor().kind(), symbol);
  }

  @Test
  void topLevelType() {
    check("Test#", Kind.Type, "Test", "_root_/");
  }

  @Test
  void typeInPackage() {
    check("sample/Test#", Kind.Type, "Test", "sample/");
  }

  @Test
  void method() {
    check("sample/Test#m1().", Kind.Method, "m1", "sample/Test#");
  }

  @Test
  void parameter() {
    check("sample/Test#m1().(t1)", Kind.Parameter, "t1", "sample/Test#m1().");
  }

  @Test
  void typeParameter() {
    check("sample/Test#m1().[T1]", Kind.TypeParameter, "T1", "sample/Test#m1().");
  }

  @Test
  void term() {
    check("sample/Test#field.", Kind.Term, "field", "sample/Test#");
  }

  @Test
  void constructor() {
    check("sample/Test#`<init>`().", Kind.Method, "<init>", "sample/Test#");
  }

  @Test
  void innerType() {
    check("sample/Test#Inner#", Kind.Type, "Inner", "sample/Test#");
  }

  @Test
  void packageDescriptor() {
    check("sample/", Kind.Package, "sample", "_root_/");
  }
}
