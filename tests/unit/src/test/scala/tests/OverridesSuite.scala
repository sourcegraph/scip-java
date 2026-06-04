package tests

import scala.jdk.CollectionConverters._

import scala.meta.Input

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
      expectedSymbols: String*
  ): Unit =
    test(options) {
      val compiler = new TestCompiler(targetroot())
      val relativePath = "example.Parent".replace('.', '/') + ".java"
      val input = Input.VirtualFile(relativePath, source)
      val result = compiler.compileScip(List(input))
      val document = result.document.orNull
      val info = document
        .getSymbolsList
        .asScala
        .find(_.getSymbol == extractSymbol)
        .getOrElse(
          fail(
            s"no SymbolInformation for $extractSymbol",
            clues(document.getSymbolsList.asScala.map(_.getSymbol))
          )
        )
      val implementations = info
        .getRelationshipsList
        .asScala
        .filter(_.getIsImplementation)
        .map(_.getSymbol)
        .mkString("\n")
      assertNoDiff(implementations, expectedSymbols.mkString("\n"))
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
    "example/Parent#stuff()."
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
    "java/lang/Object#toString()."
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
    "example/Parent#Test#stuff()."
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
    "example/Parent#Haha#add()."
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
    """java/lang/Object#toString().
      |example/Parent#toString().
      |""".stripMargin
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
    "example/Parent#stuff()."
  )
}
