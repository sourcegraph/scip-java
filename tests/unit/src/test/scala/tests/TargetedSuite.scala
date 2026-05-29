package tests

import scala.annotation.nowarn
import scala.jdk.CollectionConverters._

import scala.meta.Input
import scala.meta.Position
import scala.meta.internal.inputs._

import com.sourcegraph.Scip
import munit.FunSuite
import munit.TestOptions

@nowarn("msg=match may not be exhaustive")
class TargetedSuite extends FunSuite with TempDirectories {

  val targetroot = new DirectoryFixture()

  override def munitFixtures: Seq[Fixture[_]] =
    super.munitFixtures ++ List(targetroot)

  /** Encodes a position the same way SCIP encodes a single-line range. */
  private def asScipRange(pos: Position): java.util.List[Integer] = {
    if (pos.startLine == pos.endLine)
      List[Integer](pos.startLine, pos.startColumn, pos.endColumn).asJava
    else
      List[Integer](
        pos.startLine,
        pos.startColumn,
        pos.endLine,
        pos.endColumn
      ).asJava
  }

  def checkDoc(
      options: TestOptions,
      original: String,
      fn: (Scip.Document, List[String]) => Unit,
      qualifiedClassName: String = "example.Test"
  )(implicit loc: munit.Location): Unit = {
    test(options) {
      val groups = "<<([0-9a-zA-Z]+)>>".r
      val compiler = new TestCompiler(targetroot())
      val trimmedText = groups.replaceAllIn(original, "$1")
      val relativePath = qualifiedClassName.replace('.', '/') + ".java"
      val input = Input.VirtualFile(relativePath, trimmedText)
      var matcherCount = 0
      val positions =
        groups
          .findAllMatchIn(original)
          .map(m => {
            val startOffset = matcherCount * 4
            val endOffset = (matcherCount + 1) * 4
            matcherCount += 1
            Position.Range(input, m.start - startOffset, m.end - endOffset)
          })
          .toList
      val result = compiler.compileSemanticdb(List(input))
      val document = result.document.getOrElse(fail("no SCIP document emitted"))
      val occurrences = document.getOccurrencesList.asScala.toList
      val symbols: List[String] = positions.map { pos =>
        val expected = asScipRange(pos)
        val matchingOccurrences = occurrences.filter(_.getRangeList == expected)
        matchingOccurrences match {
          case Nil =>
            fail(
              pos.formatMessage(
                "error",
                s"no symbol occurrence for this position."
              ),
              clues(occurrences, expected)
            )
          case sym :: Nil =>
            sym.getSymbol
          case many =>
            fail(
              pos.formatMessage(
                "error",
                s"ambiguous symbols for this position"
              ),
              clues(many, occurrences, expected)
            )
        }
      }
      fn(document, symbols)
    }
  }

  checkDoc(
    "issue-24",
    """package example;
      |/** Docstring for class. */
      |class Test {
      |  /** Docstring for method. */
      |  public int number() {
      |    System.out.println(42);
      |    "".<<lastIndexOf>>('a');
      |    "".<<lastIndexOf>>('b', 0);
      |    "".<<lastIndexOf>>("c");
      |    "".<<lastIndexOf>>("d", 0);
      |    return 42;
      |  }
      |}
      |""".stripMargin,
    { case (_, List(a, b, c, d)) =>
      assertNoDiff(stripPlaceholder(a), "java/lang/String#lastIndexOf().")
      assertNoDiff(stripPlaceholder(b), "java/lang/String#lastIndexOf(+1).")
      assertNoDiff(stripPlaceholder(c), "java/lang/String#lastIndexOf(+2).")
      assertNoDiff(stripPlaceholder(d), "java/lang/String#lastIndexOf(+3).")
    }
  )

  /** Strips the placeholder prefix that compiler-emitted shards use for globals. */
  private def stripPlaceholder(symbol: String): String = {
    import com.sourcegraph.semanticdb_javac.ScipSymbols.PLACEHOLDER_PREFIX
    if (symbol.startsWith(PLACEHOLDER_PREFIX))
      symbol.substring(PLACEHOLDER_PREFIX.length)
    else
      symbol
  }
}
