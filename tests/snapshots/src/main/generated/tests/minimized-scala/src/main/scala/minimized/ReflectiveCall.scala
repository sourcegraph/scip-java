package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

import scala.language.reflectiveCalls
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^ reference semanticdb maven . . scala/language.
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . scala/language.reflectiveCalls.

class ReflectiveCall {
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ReflectiveCall#
//                   display_name ReflectiveCall
//                   documentation ```scala\nclass ReflectiveCall\n```
//                   ^ definition semanticdb maven . . minimized/ReflectiveCall#`<init>`().
//                     display_name <init>
//                     documentation ```scala\ndef this()\n```
  // Reproduction for https://github.com/scalameta/scalameta/issues/2788
  val a =
//    ^ definition semanticdb maven . . minimized/ReflectiveCall#a.
//      display_name a
//      documentation ```scala\nval a: { val b: Int }\n```
    new {
//      ^ definition local 0
//        display_name $anon
//        documentation ```scala\nfinal class $anon\n```
      val b = 1
//        ^ definition local 1
//          display_name b
//          documentation ```scala\nval b: Int\n```
    }
  println(a.b)
//^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//        ^ reference semanticdb maven . . minimized/ReflectiveCall#a.
//          ^ reference local 1
}
