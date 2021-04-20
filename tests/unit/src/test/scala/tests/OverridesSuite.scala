package tests

import scala.meta.Input

import com.sourcegraph.lsif_semanticdb.Symtab
import munit.FunSuite
import munit.TestOptions

class OverridesSuite extends FunSuite with TempDirectories {

  val targetroot = new DirectoryFixture()

  override def munitFixtures: Seq[Fixture[_]] =
    super.munitFixtures ++ List(targetroot)

  def checkOverrides(
      options: TestOptions,
      source: String,
      extractSymbol: String,
      expectedSymbols: List[String],
      expectedCount: Int,
      qualifiedClassName: String = "example.Parent"
  ): Unit = {
    test(options) {
      val compiler = new TestCompiler(targetroot())
      val relativePath = qualifiedClassName.replace('.', '/') + ".java"
      val input = Input.VirtualFile(relativePath, source)
      val result = compiler.compileSemanticdb(List(input))
      val symtab = new Symtab(result.textDocument)

      val count = symtab.symbols.get(extractSymbol).getOverriddenSymbolsCount
      val syms = symtab
        .symbols
        .get(extractSymbol)
        .getOverriddenSymbolsList
        .toArray(new Array[String](count))
      assertEquals(count, expectedCount)
      syms
        .zipWithIndex
        .foreach { case (str, i) =>
          assertEquals(str, expectedSymbols(i))
        }
    }
  }

  checkOverrides(
    "same file",
    """package example;
      |
      |class Parent {
      | public void stuff() {}
      |
      | class Child extends Parent {
      |   @Override
      |   public void stuff() {}
      | }
      |}
      |""".stripMargin,
    "example/Parent#Child#stuff().",
    List("example/Parent#stuff()."),
    1
  )

  checkOverrides(
    "external override",
    """package example;
      |
      |class Parent {
      | @Override
      | public String toString() { return ""; }
      |}
      |""".stripMargin,
    "example/Parent#toString().",
    List("java/lang/Object#toString()."),
    1
  )

  checkOverrides(
    "implement interface",
    """package example;
      |
      |class Parent {
      | interface Test {
      |   public void stuff();
      | }
      |
      | class Child implements Test {
      |   @Override
      |   public void stuff() {}
      | }
      |}
      |""".stripMargin,
    "example/Parent#Child#stuff().",
    List("example/Parent#Test#stuff()."),
    1
  )

  checkOverrides(
    "type params",
    """package example;
      |
      |class Parent {
      | interface Haha<T> {
      |   void add(T elem);
      | }
      | class IntHaha implements Haha<Integer> {
      |  void add(Integer elem) {}
      | }
      |}
      |""".stripMargin,
    "example/Parent#IntHaha#add().",
    List("example/Parent#Haha#add()."),
    1
  )

  checkOverrides(
    "multiple",
    """package example;
      |
      |class Parent {
      | @Override
      | public String toString() { return ""; }
      |
      | class Child extends Parent {
      |  @Override
      |  public String toString() { return ""; }
      | }
      |}
      |""".stripMargin,
    "example/Parent#Child#toString().",
    List("example/Parent#toString().", "java/lang/Object#toString()."),
    2
  )

  checkOverrides(
    "abstract",
    """package example;
      |
      |abstract class Parent {
      | public abstract void stuff();
      |
      | class Child extends Parent {
      |  @Override
      |  public void stuff() {}
      | }
      |}
      |""".stripMargin,
    "example/Parent#Child#stuff().",
    List("example/Parent#stuff()."),
    1
  )
}
