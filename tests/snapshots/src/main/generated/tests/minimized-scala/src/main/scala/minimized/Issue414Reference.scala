package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

object Issue414Reference {
//     ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue414Reference.
//                       display_name Issue414Reference
//                       signature_documentation scala object Issue414Reference
//                       kind Object
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
