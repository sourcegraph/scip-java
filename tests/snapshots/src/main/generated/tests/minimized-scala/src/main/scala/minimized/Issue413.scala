package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

trait Issue413 {
//    ^^^^^^^^ definition semanticdb maven . . minimized/Issue413#
//             documentation ```scala\ntrait Issue413\n```
  val b: Int
//    ^ definition semanticdb maven . . minimized/Issue413#b.
//      documentation ```scala\nval b: Int\n```
//      relationship is_reference is_implementation semanticdb maven . . minimized/Issue413Subclass#b.
//       ^^^ reference semanticdb maven . . scala/Int#
  val c: Int
//    ^ definition semanticdb maven . . minimized/Issue413#c.
//      documentation ```scala\nval c: Int\n```
//      relationship is_reference is_implementation semanticdb maven . . minimized/Issue413Subclass#c.
//       ^^^ reference semanticdb maven . . scala/Int#
}
object Issue413 {
//     ^^^^^^^^ definition semanticdb maven . . minimized/Issue413.
//              documentation ```scala\nobject Issue413\n```
  def main(): Unit = {
//    ^^^^ definition semanticdb maven . . minimized/Issue413.main().
//         documentation ```scala\ndef main(): Unit\n```
//            ^^^^ reference semanticdb maven . . scala/Unit#
    val a = new Issue413Subclass()
//      ^ definition local 0
//        documentation ```scala\na: Issue413Subclass \n```
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Issue413Subclass#
//                              ^ reference semanticdb maven . . minimized/Issue413Subclass#`<init>`().
    val b: Issue413 = a
//      ^ definition local 1
//        documentation ```scala\nb: Issue413 \n```
//         ^^^^^^^^ reference semanticdb maven . . minimized/Issue413#
//                    ^ reference local 0
    println(a.b + b.b)
//  ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//          ^ reference local 0
//            ^ reference semanticdb maven . . minimized/Issue413Subclass#b.
//              ^ reference semanticdb maven . . scala/Int#`+`(+4).
//                ^ reference local 1
//                  ^ reference semanticdb maven . . minimized/Issue413#b.
  }
}

class Issue413Subclass extends Issue413 {
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue413Subclass#
//                     documentation ```scala\nclass Issue413Subclass\n```
//                     ^ definition semanticdb maven . . minimized/Issue413Subclass#`<init>`().
//                       documentation ```scala\ndef this()\n```
//                             ^^^^^^^^ reference semanticdb maven . . minimized/Issue413#
//                                      ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  override val b = 10
//             ^ definition semanticdb maven . . minimized/Issue413Subclass#b.
//               documentation ```scala\nval b: Int\n```
//               relationship is_reference is_implementation semanticdb maven . . minimized/Issue413#b.
  override val c = 10
//             ^ definition semanticdb maven . . minimized/Issue413Subclass#c.
//               documentation ```scala\nval c: Int\n```
//               relationship is_reference is_implementation semanticdb maven . . minimized/Issue413#c.
}
