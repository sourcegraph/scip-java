package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

import scala.language.reflectiveCalls
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^ reference semanticdb maven . . scala/language.
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . scala/language.reflectiveCalls.

class ReflectiveCall {
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ReflectiveCall#
//                   display_name ReflectiveCall
//                   signature_documentation scala class ReflectiveCall
//                   kind Class
//                   ^ definition semanticdb maven . . minimized/ReflectiveCall#`<init>`().
//                     display_name <init>
//                     signature_documentation scala def this()
//                     kind Constructor
  // Reproduction for https://github.com/scalameta/scalameta/issues/2788
  val a =
//    ^ definition semanticdb maven . . minimized/ReflectiveCall#a.
//      display_name a
//      signature_documentation scala val a: { val b: Int }
//      kind Method
    new {
//      ^ definition local 0
//        display_name $anon
//        signature_documentation scala final class $anon
//        kind Class
      val b = 1
//        ^ definition local 1
//          display_name b
//          signature_documentation scala val b: Int
//          kind Method
    }
  println(a.b)
//^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//        ^ reference semanticdb maven . . minimized/ReflectiveCall#a.
//          ^ reference local 1
}
