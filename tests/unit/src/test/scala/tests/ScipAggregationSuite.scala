package tests

import java.nio.file.Files
import java.util.Collections

import scala.jdk.CollectionConverters._

import scala.meta.Input

import com.sourcegraph.scip_semanticdb.ScipSemanticdbOptions
import com.sourcegraph.scip_semanticdb.ScipSemanticdbReporter
import com.sourcegraph.scip_semanticdb.ScipShardAggregator
import munit.FunSuite
import org.scip_code.scip.Index
import org.scip_code.scip.ToolInfo

// End-to-end test for the SCIP shard aggregation pipeline: compile Java with
// the default shard emission, run ScipShardAggregator over the produced
// META-INF/scip shards, and assert the final index.scip is well-formed and
// uses the scip-java symbol scheme.
class ScipAggregationSuite extends FunSuite {

  private val source = Input.VirtualFile(
    "example/Foo.java",
    """package example;
      |
      |public class Foo {
      |  public int bar() { return 1; }
      |}
      |""".stripMargin
  )

  test("aggregator produces a scip-java index from compiler shards") {
    val targetroot = Files.createTempDirectory("scip-agg-target-")
    val sourceroot = Files.createTempDirectory("scip-agg-source-")
    val compiler =
      new TestCompiler(TestCompiler.PROCESSOR_PATH, Nil, targetroot, sourceroot)
    val result = compiler.compile(
      Seq(source),
      Seq(
        s"-Xplugin:semanticdb -text:on -sourceroot:$sourceroot -targetroot:$targetroot"
      )
    )
    assert(result.isSuccess, s"javac failed:\n${result.stdout}")

    val output = Files.createTempFile("scip-agg-out-", ".scip")
    val options =
      new ScipSemanticdbOptions(
        Collections.singletonList(targetroot),
        output,
        sourceroot,
        new ScipSemanticdbReporter() {},
        ToolInfo.newBuilder().setName("scip-java").setVersion("test").build(),
        false,
        Collections.emptyList(),
        true,
        false,
        false
      )

    ScipShardAggregator.run(options)

    // SCIP's stream format concatenates multiple Index messages. Protobuf merges concatenated
    // messages of the same type when parsed as a single message: singular fields take the last
    // value and repeated fields are concatenated, so this gives us the full aggregated view.
    val bytes = Files.readAllBytes(output)
    val index = Index.parseFrom(bytes)

    // Metadata is present.
    assert(index.hasMetadata, s"expected metadata in index: $index")
    assertEquals(index.getMetadata.getToolInfo.getName, "scip-java")

    val docs = index.getDocumentsList.asScala
    assert(docs.nonEmpty, "expected at least one document in aggregated index")
    val doc = docs.find(_.getRelativePath == "example/Foo.java").get

    // Every symbol/occurrence must be in final form: either local or scip-java.
    doc
      .getSymbolsList
      .asScala
      .foreach { info =>
        val s = info.getSymbol
        val ok = s.startsWith("scip-java maven ") || s.startsWith("local ")
        assert(ok, s"symbol not in final form: $s")
      }
    doc
      .getOccurrencesList
      .asScala
      .foreach { occ =>
        val s = occ.getSymbol
        val ok = s.startsWith("scip-java maven ") || s.startsWith("local ")
        assert(ok, s"occurrence not in final form: $s")
      }
  }
}
