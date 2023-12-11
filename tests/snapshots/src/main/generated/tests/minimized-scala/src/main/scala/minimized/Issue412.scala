package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

class Issue412 {
//    ^^^^^^^^ definition semanticdb maven . . minimized/Issue412#
//             display_name Issue412
//             signature_documentation scala class Issue412
//             ^ definition semanticdb maven . . minimized/Issue412#`<init>`().
//               display_name <init>
//               signature_documentation scala def this()
  val a: Int = 5
//    ^ definition semanticdb maven . . minimized/Issue412#a.
//      display_name a
//      signature_documentation scala val a: Int
//       ^^^ reference semanticdb maven . . scala/Int#
  val b: Long = a
//    ^ definition semanticdb maven . . minimized/Issue412#b.
//      display_name b
//      signature_documentation scala val b: Long
//       ^^^^ reference semanticdb maven . . scala/Long#
//              ^ reference semanticdb maven . . minimized/Issue412#a.

  def a(b: Long): Unit = {
//    ^ definition semanticdb maven . . minimized/Issue412#a().
//      display_name a
//      signature_documentation scala def a(b: Long): Unit
//      ^ definition semanticdb maven . . minimized/Issue412#a().(b)
//        display_name b
//        signature_documentation scala b: Long 
//         ^^^^ reference semanticdb maven . . scala/Long#
//                ^^^^ reference semanticdb maven . . scala/Unit#
    println(b)
//  ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//          ^ reference semanticdb maven . . minimized/Issue412#a().(b)
  }
  a(a)
//^ reference semanticdb maven . . minimized/Issue412#a().
//  ^ reference semanticdb maven . . minimized/Issue412#a.

}
