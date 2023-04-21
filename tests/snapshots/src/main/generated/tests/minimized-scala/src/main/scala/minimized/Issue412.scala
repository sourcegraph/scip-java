package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

class Issue412 {
//    ^^^^^^^^ definition semanticdb maven . . minimized/Issue412#
//             documentation ```scala\nclass Issue412\n```
//             ^ definition semanticdb maven . . minimized/Issue412#`<init>`().
//               documentation ```scala\ndef this()\n```
  val a: Int = 5
//    ^ definition semanticdb maven . . minimized/Issue412#a.
//      documentation ```scala\nval a: Int\n```
//       ^^^ reference semanticdb maven . . scala/Int#
  val b: Long = a
//    ^ definition semanticdb maven . . minimized/Issue412#b.
//      documentation ```scala\nval b: Long\n```
//       ^^^^ reference semanticdb maven . . scala/Long#
//              ^ reference semanticdb maven . . minimized/Issue412#a.

  def a(b: Long): Unit = {
//    ^ definition semanticdb maven . . minimized/Issue412#a().
//      documentation ```scala\ndef a(b: Long): Unit\n```
//      ^ definition semanticdb maven . . minimized/Issue412#a().(b)
//        documentation ```scala\nb: Long \n```
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
