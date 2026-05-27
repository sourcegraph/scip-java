package tests

import java.nio.file.Paths
import java.util.{Collections, Optional}

import org.scip_code.scip.ToolInfo
import com.sourcegraph.scip_semanticdb.{
  Package,
  PackageTable,
  ScipSemanticdbOptions,
  ScipSemanticdbReporter,
  SymbolRewriter
}
import com.sourcegraph.semanticdb_javac.ScipSymbols
import munit.FunSuite

class ScipSymbolsSuite extends FunSuite {

  test("global symbol gets placeholder prefix") {
    assertEquals(
      ScipSymbols.fromSemanticdbSymbol("com/example/Foo#bar()."),
      ". . . . com/example/Foo#bar()."
    )
  }

  test("local symbol gets canonical SCIP form") {
    assertEquals(ScipSymbols.fromSemanticdbSymbol("local42"), "local 42")
  }

  test("empty / null symbol stays empty") {
    assertEquals(ScipSymbols.fromSemanticdbSymbol(""), "")
    assertEquals(ScipSymbols.fromSemanticdbSymbol(null), "")
  }

  test("isPlaceholderGlobal recognises the prefix") {
    assert(ScipSymbols.isPlaceholderGlobal(". . . . a/b#"))
    assert(!ScipSymbols.isPlaceholderGlobal("local 1"))
    assert(!ScipSymbols.isPlaceholderGlobal("scip-java maven g a v a/b#"))
  }

  test("descriptorPath strips the placeholder prefix") {
    assertEquals(ScipSymbols.descriptorPath(". . . . a/b#"), "a/b#")
    assertEquals(ScipSymbols.descriptorPath("local 1"), "local 1")
  }

  // A PackageTable built with no packages — packageForSymbol always returns empty
  // unless the JDK classfile is on the classpath. Override defensively just in case.
  private lazy val emptyPackages: PackageTable =
    new PackageTable(
      new ScipSemanticdbOptions(
        Collections.emptyList(),
        Paths.get("/tmp"),
        Paths.get("/tmp"),
        new ScipSemanticdbReporter() {},
        ToolInfo
          .newBuilder()
          .setName("scip-java")
          .setVersion("test")
          .build(),
        false,
        Collections.emptyList(),
        false,
        true,
        false
      )
    ) {
      override def packageForSymbol(symbol: String): Optional[Package] =
        Optional.empty()
    }

  test("SymbolRewriter leaves locals and final symbols alone") {
    val rewriter = new SymbolRewriter(emptyPackages)
    assertEquals(rewriter.rewrite("local 1"), "local 1")
    assertEquals(
      rewriter.rewrite("scip-java maven g a v com/example/Foo#"),
      "scip-java maven g a v com/example/Foo#"
    )
    assertEquals(rewriter.rewrite(""), "")
    assertEquals(rewriter.rewrite(null), null)
  }

  test(
    "SymbolRewriter falls back to empty package when no metadata available"
  ) {
    val rewriter = new SymbolRewriter(emptyPackages)
    assertEquals(
      rewriter.rewrite(". . . . com/example/Foo#bar()."),
      "scip-java maven . . com/example/Foo#bar()."
    )
  }
}
