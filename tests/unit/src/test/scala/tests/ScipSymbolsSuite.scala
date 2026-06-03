package tests

import java.nio.file.Paths
import java.util.Collections
import java.util.Optional

import com.sourcegraph.scip_semanticdb.Package
import com.sourcegraph.scip_semanticdb.PackageTable
import com.sourcegraph.scip_semanticdb.ScipSemanticdbOptions
import com.sourcegraph.scip_semanticdb.ScipSemanticdbReporter
import com.sourcegraph.scip_semanticdb.SymbolRewriter
import com.sourcegraph.semanticdb_javac.ScipSymbols
import munit.FunSuite
import org.scip_code.scip.ToolInfo

class ScipSymbolsSuite extends FunSuite {

  test("global symbol gets placeholder prefix") {
    assertEquals(
      ScipSymbols.format("com/example/Foo#bar()."),
      ". . . . com/example/Foo#bar()."
    )
  }

  test("local symbol gets canonical SCIP form") {
    assertEquals(ScipSymbols.format("local42"), "local 42")
  }

  test("empty / null symbol stays empty") {
    assertEquals(ScipSymbols.format(""), "")
    assertEquals(ScipSymbols.format(null), "")
  }

  // PackageTable that always returns no package; isolates SymbolRewriter from classpath.
  private lazy val emptyPackages: PackageTable =
    new PackageTable(
      new ScipSemanticdbOptions(
        Collections.emptyList(),
        Paths.get("/tmp"),
        Paths.get("/tmp"),
        new ScipSemanticdbReporter() {},
        ToolInfo.newBuilder().setName("scip-java").setVersion("test").build(),
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
