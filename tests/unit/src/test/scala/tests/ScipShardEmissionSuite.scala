package tests

import java.nio.file.Files

import scala.jdk.CollectionConverters._
import scala.meta.Input

import com.sourcegraph.Scip
import com.sourcegraph.semanticdb_javac.ScipSymbols
import munit.FunSuite

/**
 * Verifies that the `-emit-scip:on` plugin flag produces a parseable `*.scip`
 * shard alongside the existing `*.semanticdb` file.
 */
class ScipShardEmissionSuite extends FunSuite {

  private val source = Input.VirtualFile(
    "example/Foo.java",
    """package example;
      |
      |public class Foo {
      |  public int bar() {
      |    int x = 1;
      |    return x;
      |  }
      |}
      |""".stripMargin
  )

  test("compiler emits a parseable SCIP shard when -emit-scip:on is set") {
    val targetroot = Files.createTempDirectory("scip-shard-emission-")
    val sourceroot = Files.createTempDirectory("scip-shard-emission-src-")
    val compiler =
      new TestCompiler(TestCompiler.PROCESSOR_PATH, Nil, targetroot, sourceroot)
    val result = compiler.compile(
      Seq(source),
      Seq(
        s"-Xplugin:semanticdb -emit-scip:on -text:on -sourceroot:$sourceroot -targetroot:$targetroot"
      )
    )
    assert(result.isSuccess, s"javac failed:\n${result.stdout}")

    val semanticdbPath = targetroot.resolve(
      "META-INF/semanticdb/example/Foo.java.semanticdb"
    )
    val scipPath = targetroot.resolve("META-INF/scip/example/Foo.java.scip")

    assert(Files.isRegularFile(semanticdbPath), s"missing $semanticdbPath")
    assert(Files.isRegularFile(scipPath), s"missing $scipPath")

    val shard = Scip.Index.parseFrom(Files.readAllBytes(scipPath))
    assertEquals(shard.getDocumentsCount, 1)
    val doc = shard.getDocuments(0)
    assertEquals(doc.getRelativePath, "example/Foo.java")
    assertEquals(doc.getLanguage, "Java")

    val symbols = doc.getSymbolsList.asScala
    assert(symbols.nonEmpty, "expected at least one symbol")

    // Globals must use the placeholder prefix; locals must use "local N".
    symbols.foreach { info =>
      val s = info.getSymbol
      val ok =
        s.startsWith(ScipSymbols.PLACEHOLDER_PREFIX) || s.startsWith("local ")
      assert(ok, s"unexpected symbol form: $s")
    }

    val occurrences = doc.getOccurrencesList.asScala
    assert(occurrences.nonEmpty, "expected at least one occurrence")
    occurrences.foreach { occ =>
      val s = occ.getSymbol
      val ok =
        s.startsWith(ScipSymbols.PLACEHOLDER_PREFIX) || s.startsWith("local ")
      assert(ok, s"unexpected occurrence symbol: $s")
    }

    // At least one definition should carry a Java signature_documentation block.
    val withSignatures = symbols.filter { info =>
      info.hasSignatureDocumentation &&
      info.getSignatureDocumentation.getLanguage == "Java" &&
      info.getSignatureDocumentation.getText.nonEmpty
    }
    assert(
      withSignatures.nonEmpty,
      s"expected signature docs; got: ${symbols.mkString("\n")}"
    )

    val fooClass = symbols.find { info =>
      info.getKind == Scip.SymbolInformation.Kind.Class &&
      info.getDisplayName == "Foo"
    }
    assert(fooClass.isDefined, "expected Foo class symbol")
    val text = fooClass.get.getSignatureDocumentation.getText
    assert(text.contains("class Foo"), s"unexpected signature: $text")

    val barMethod = symbols.find { info =>
      info.getKind == Scip.SymbolInformation.Kind.Method &&
      info.getDisplayName == "bar"
    }
    assert(barMethod.isDefined, "expected bar method symbol")
    val barText = barMethod.get.getSignatureDocumentation.getText
    assert(barText.contains("int bar("), s"unexpected bar signature: $barText")
  }

  test("compiler does not emit SCIP shards when -emit-scip is off") {
    val targetroot = Files.createTempDirectory("scip-shard-off-")
    val sourceroot = Files.createTempDirectory("scip-shard-off-src-")
    val compiler =
      new TestCompiler(TestCompiler.PROCESSOR_PATH, Nil, targetroot, sourceroot)
    val result = compiler.compileSemanticdb(Seq(source))
    assert(result.isSuccess, s"javac failed:\n${result.stdout}")

    val scipPath = targetroot.resolve("META-INF/scip/example/Foo.java.scip")
    assert(!Files.exists(scipPath), s"unexpected scip shard at $scipPath")
  }
}
