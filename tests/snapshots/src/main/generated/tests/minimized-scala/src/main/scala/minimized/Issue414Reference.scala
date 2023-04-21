package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

object Issue414Reference {
//     ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue414Reference.
//                       documentation ```scala\nobject Issue414Reference\n```
  println(Issue414.a1.b())
//^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//        ^^^^^^^^ reference semanticdb maven . . minimized/Issue414.
//                 ^^ reference semanticdb maven . . minimized/Issue414.a1.
//                    ^ reference semanticdb maven . . minimized/Issue414.A#b().
  println(Issue414.a2.b())
//^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//        ^^^^^^^^ reference semanticdb maven . . minimized/Issue414.
//                 ^^ reference semanticdb maven . . minimized/Issue414.a2.
//                    ^ reference semanticdb maven . . minimized/Issue414.A#b().
}
