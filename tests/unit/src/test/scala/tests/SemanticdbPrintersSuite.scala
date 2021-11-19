package tests

import com.sourcegraph.lsif_java.SemanticdbPrinters
import com.sourcegraph.semanticdb_javac.Semanticdb.Documentation
import com.sourcegraph.semanticdb_javac.Semanticdb.Range
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence.Role
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocument
import munit.FunSuite

class SemanticdbPrintersSuite extends FunSuite {
  test("tabs") {
    val doc = TextDocument
      .newBuilder()
      .setText("type Indexer interface {\n\tFoo()\n\t\tBar()\n\t\t\tQux()\n}\n")
      .addOccurrences(
        SymbolOccurrence
          .newBuilder()
          .setRole(Role.DEFINITION)
          .setSymbol("foo/Indexer#")
          .setRange(
            Range
              .newBuilder()
              .setStartLine(0)
              .setStartCharacter(5)
              .setEndLine(0)
              .setEndCharacter(5 + "Indexer".length)
          )
      )
      .addOccurrences(
        SymbolOccurrence
          .newBuilder()
          .setRole(Role.DEFINITION)
          .setSymbol("foo/Indexer#Foo().")
          .setRange(
            Range
              .newBuilder()
              .setStartLine(1)
              .setStartCharacter(1)
              .setEndLine(1)
              .setEndCharacter(4)
          )
      )
      .addOccurrences(
        SymbolOccurrence
          .newBuilder()
          .setRole(Role.DEFINITION)
          .setSymbol("foo/Indexer#Bar().")
          .setRange(
            Range
              .newBuilder()
              .setStartLine(2)
              .setStartCharacter(2)
              .setEndLine(2)
              .setEndCharacter(5)
          )
      )
      .addOccurrences(
        SymbolOccurrence
          .newBuilder()
          .setRole(Role.DEFINITION)
          .setSymbol("foo/Indexer#Qux().")
          .setRange(
            Range
              .newBuilder()
              .setStartLine(3)
              .setStartCharacter(3)
              .setEndLine(3)
              .setEndCharacter(6)
          )
      )
    val obtained = SemanticdbPrinters.printTextDocument(doc.build())
    assertNoDiff(
      obtained,
      """|type Indexer interface {
         |//   ^^^^^^^ definition foo/Indexer#
         |→Foo()
         |//^^ definition foo/Indexer#Foo().
         |→→Bar()
         |//^^^ definition foo/Indexer#Bar().
         |→→→Qux()
         |// ^^^ definition foo/Indexer#Qux().
         |}
         |""".stripMargin
    )
  }

  test("documentation") {
    val doc = TextDocument
      .newBuilder()
      .setText("fun main() {}\n")
      .addOccurrences(
        SymbolOccurrence
          .newBuilder()
          .setSymbol("main().")
          .setRange(
            Range
              .newBuilder()
              .setStartLine(0)
              .setStartCharacter(4)
              .setEndLine(0)
              .setEndCharacter(8)
          )
          .setRole(Role.DEFINITION)
      )
      .addSymbols(
        SymbolInformation
          .newBuilder()
          .setSymbol("main().")
          .setDocumentation(
            Documentation
              .newBuilder()
              .setMessage("```kt\nfun main(): kotlin.Unit\n```")
          )
      )
      .build()

    assertNoDiff(
      SemanticdbPrinters.printTextDocument(doc),
      """|fun main() {}
         |//  ^^^^ definition main(). fun main(): kotlin.Unit
         |""".stripMargin
    )
  }

}
