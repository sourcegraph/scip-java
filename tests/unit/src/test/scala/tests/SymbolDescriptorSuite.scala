package tests

import scala.meta.internal.semanticdb.Scala._

import com.sourcegraph.scip_semanticdb.SymbolDescriptor
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols.Descriptor.Kind
import munit.FunSuite
import munit.TestOptions

class SymbolDescriptorSuite extends FunSuite {
  def checkDescriptor(options: TestOptions): Unit = {
    test(options) {
      val original = options.name
      val obtained = SymbolDescriptor.parseFromSymbol(original);
      val expectedKind =
        original.desc match {
          case Descriptor.None =>
            Kind.None
          case Descriptor.Term(value) =>
            Kind.Term
          case Descriptor.Method(value, disambiguator) =>
            Kind.Method
          case Descriptor.Type(value) =>
            Kind.Type
          case Descriptor.Package(value) =>
            Kind.Package
          case Descriptor.Parameter(value) =>
            Kind.Parameter
          case Descriptor.TypeParameter(value) =>
            Kind.TypeParameter
        }
      assertEquals(obtained.descriptor.name, original.desc.value, original)
      assertEquals(obtained.owner, original.owner, original)
      assertEquals(obtained.descriptor.kind, expectedKind, original)
    }
  }
  checkDescriptor("Test#")
  checkDescriptor("sample/Test#")
  checkDescriptor("sample/Test#m1().")
  checkDescriptor("sample/Test#m1().(t1)")
  checkDescriptor("sample/Test#m1().[T1]")
  checkDescriptor("sample/Test#field.")
  checkDescriptor("sample/Test#`<init>`().")
  checkDescriptor("sample/Test#Inner#")
  checkDescriptor("sample/")
}
