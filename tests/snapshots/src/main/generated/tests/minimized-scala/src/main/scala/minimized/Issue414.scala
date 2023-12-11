package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

object Issue414 {
//     ^^^^^^^^ definition semanticdb maven . . minimized/Issue414.
//              display_name Issue414
//              signature_documentation scala object Issue414
  trait A {
//      ^ definition semanticdb maven . . minimized/Issue414.A#
//        display_name A
//        signature_documentation scala trait A
    def b(): Unit
//      ^ definition semanticdb maven . . minimized/Issue414.A#b().
//        display_name b
//        signature_documentation scala def b(): Unit
//           ^^^^ reference semanticdb maven . . scala/Unit#
  }
  val a1 =
//    ^^ definition semanticdb maven . . minimized/Issue414.a1.
//       display_name a1
//       signature_documentation scala val a1: {}
    new A {
//      ^ definition local 0
//        display_name $anon
//        signature_documentation scala final class $anon
//      ^ reference semanticdb maven . . minimized/Issue414.A#
//        ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
      override def b(): Unit = {
//                 ^ definition local 1
//                   display_name b
//                   signature_documentation scala def b(): Unit
//                   relationship is_reference is_implementation semanticdb maven . . minimized/Issue414.A#b().
//                      ^^^^ reference semanticdb maven . . scala/Unit#
        print("Hello")
//      ^^^^^ reference semanticdb maven . . scala/Predef.print().
      }
    }
  val a2: A = a1
//    ^^ definition semanticdb maven . . minimized/Issue414.a2.
//       display_name a2
//       signature_documentation scala val a2: A
//        ^ reference semanticdb maven . . minimized/Issue414.A#
//            ^^ reference semanticdb maven . . minimized/Issue414.a1.
  println(a1.b())
//^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//        ^^ reference semanticdb maven . . minimized/Issue414.a1.
//           ^ reference semanticdb maven . . minimized/Issue414.A#b().
  println(a2.b())
//^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//        ^^ reference semanticdb maven . . minimized/Issue414.a2.
//           ^ reference semanticdb maven . . minimized/Issue414.A#b().
}
