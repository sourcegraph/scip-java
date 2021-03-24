package tests

import scala.annotation.nowarn
import scala.jdk.CollectionConverters._

import scala.meta.Input
import scala.meta.Position
import scala.meta.internal.inputs._

import com.sourcegraph.semanticdb_javac.Semanticdb
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocument
import munit.FunSuite
import munit.TestOptions

@nowarn("msg=match may not be exhaustive")
class TargetedSuite extends FunSuite with TempDirectories {

  val targetroot = new DirectoryFixture()

  override def munitFixtures: Seq[Fixture[_]] =
    super.munitFixtures ++ List(targetroot)

  def checkDoc(
      options: TestOptions,
      original: String,
      fn: (TextDocument, List[String]) => Unit,
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
      val occurrences = result.textDocument.getOccurrencesList.asScala.toList
      val symbols: List[String] = positions.map { pos =>
        val posRange = Semanticdb
          .Range
          .newBuilder()
          .setStartLine(pos.startLine)
          .setStartCharacter(pos.startColumn)
          .setEndLine(pos.endLine)
          .setEndCharacter(pos.endColumn)
          .build()
        val matchingOccurrences = occurrences.filter(_.getRange == posRange)
        matchingOccurrences match {
          case Nil =>
            fail(
              pos.formatMessage(
                "error",
                s"no symbol occurrence for this position."
              ),
              clues(occurrences, posRange)
            )
          case sym :: Nil =>
            sym.getSymbol
          case many =>
            fail(
              pos
                .formatMessage("error", s"ambiguous symbols for this position"),
              clues(many, occurrences, posRange)
            )
        }
      }
      fn(result.textDocument, symbols)
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
      assertNoDiff(a, "java/lang/String#lastIndexOf().")
      assertNoDiff(b, "java/lang/String#lastIndexOf(+1).")
      assertNoDiff(c, "java/lang/String#lastIndexOf(+2).")
      assertNoDiff(d, "java/lang/String#lastIndexOf(+3).")
    }
  )
}
