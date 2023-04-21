package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

object Issue414 {
//     ^^^^^^^^ definition semanticdb maven . . minimized/Issue414.
//              documentation ```scala\nobject Issue414\n```
  trait A {
//      ^ definition semanticdb maven . . minimized/Issue414.A#
//        documentation ```scala\ntrait A\n```
    def b(): Unit
//      ^ definition semanticdb maven . . minimized/Issue414.A#b().
//        documentation ```scala\ndef b(): Unit\n```
//           ^^^^ reference semanticdb maven . . scala/Unit#
  }
  val a1 =
//    ^^ definition semanticdb maven . . minimized/Issue414.a1.
//       documentation ```scala\nval a1: {}\n```
    new A {
//      ^ definition local 0
//        documentation ```scala\nfinal class $anon\n```
//      ^ reference semanticdb maven . . minimized/Issue414.A#
//        ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
      override def b(): Unit = {
//                 ^ definition local 1
//                   documentation ```scala\ndef b(): Unit\n```
//                   relationship is_reference is_implementation semanticdb maven . . minimized/Issue414.A#b().
//                      ^^^^ reference semanticdb maven . . scala/Unit#
        print("Hello")
//      ^^^^^ reference semanticdb maven . . scala/Predef.print().
      }
    }
  val a2: A = a1
//    ^^ definition semanticdb maven . . minimized/Issue414.a2.
//       documentation ```scala\nval a2: A\n```
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
