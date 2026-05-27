package tests

import java.nio.file.Files

import scala.jdk.CollectionConverters._
import scala.meta.Input

import org.scip_code.scip.Index
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

    val shard = Index.parseFrom(Files.readAllBytes(scipPath))
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
