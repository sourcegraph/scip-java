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
  val a: A =
//    ^ definition semanticdb maven . . minimized/Issue414.a.
//      documentation ```scala\nval a: A\n```
//       ^ reference semanticdb maven . . minimized/Issue414.A#
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
  println(a.b())
//^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//        ^ reference semanticdb maven . . minimized/Issue414.a.
//          ^ reference semanticdb maven . . minimized/Issue414.A#b().
}
