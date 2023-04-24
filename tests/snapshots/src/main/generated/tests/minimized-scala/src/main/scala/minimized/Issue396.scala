package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

case class Issue396(a: Int)
//         ^^^^^^^^ definition semanticdb maven . . minimized/Issue396#
//                  documentation ```scala\ncase class Issue396(a: Int)\n```
//                  relationship is_reference semanticdb maven . . minimized/Issue396.
//                  relationship is_reference semanticdb maven . . minimized/Issue396.apply().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue396#copy().
//                  documentation ```scala\ndef copy(a: Int): Issue396\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue396#
//                  relationship is_reference semanticdb maven . . minimized/Issue396.apply().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue396#productElement().
//                  documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue396#
//                  relationship is_reference semanticdb maven . . minimized/Issue396.apply().
//                  relationship is_reference is_implementation semanticdb maven . . scala/Product#productElement().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue396.
//                  documentation ```scala\nobject Issue396\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue396#
//                  relationship is_reference semanticdb maven . . minimized/Issue396.apply().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue396.apply().
//                  documentation ```scala\ndef apply(a: Int): Issue396\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue396#
//                  relationship is_reference is_implementation semanticdb maven . . scala/Function1#apply().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue396#productElementName().
//                  documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue396#
//                  relationship is_reference semanticdb maven . . minimized/Issue396.apply().
//                  relationship is_reference is_implementation semanticdb maven . . scala/Product#productElementName().
//                 ^ definition semanticdb maven . . minimized/Issue396#`<init>`().
//                   documentation ```scala\ndef this(a: Int)\n```
//                  ^ definition semanticdb maven . . minimized/Issue396#a.
//                    documentation ```scala\nval a: Int\n```
//                    relationship is_reference semanticdb maven . . minimized/Issue396#`<init>`().(a)
//                    relationship is_reference semanticdb maven . . minimized/Issue396#copy().(a)
//                    relationship is_reference semanticdb maven . . minimized/Issue396.apply().(a)
//                  _ synthetic_definition semanticdb maven . . minimized/Issue396.apply().(a)
//                    documentation ```scala\na: Int \n```
//                    relationship is_reference semanticdb maven . . minimized/Issue396#`<init>`().(a)
//                    relationship is_reference is_definition semanticdb maven . . minimized/Issue396#a.
//                    relationship is_reference semanticdb maven . . minimized/Issue396#copy().(a)
//                  _ synthetic_definition semanticdb maven . . minimized/Issue396#`<init>`().(a)
//                    documentation ```scala\na: Int \n```
//                    relationship is_reference is_definition semanticdb maven . . minimized/Issue396#a.
//                    relationship is_reference semanticdb maven . . minimized/Issue396#copy().(a)
//                    relationship is_reference semanticdb maven . . minimized/Issue396.apply().(a)
//                  _ synthetic_definition semanticdb maven . . minimized/Issue396#copy().(a)
//                    documentation ```scala\ndefault a: Int \n```
//                    relationship is_reference semanticdb maven . . minimized/Issue396#`<init>`().(a)
//                    relationship is_reference is_definition semanticdb maven . . minimized/Issue396#a.
//                    relationship is_reference semanticdb maven . . minimized/Issue396.apply().(a)
//                     ^^^ reference semanticdb maven . . scala/Int#
object Issue396App {
//     ^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue396App.
//                 documentation ```scala\nobject Issue396App\n```
  println(Issue396)
//^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//        ^^^^^^^^ reference semanticdb maven . . minimized/Issue396.
  Issue396.apply(a = 42).copy(a = 41)
//^^^^^^^^ reference semanticdb maven . . minimized/Issue396.
//         ^^^^^ reference semanticdb maven . . minimized/Issue396.apply().
//               ^ reference semanticdb maven . . minimized/Issue396.apply().(a)
//                       ^^^^ reference semanticdb maven . . minimized/Issue396#copy().
//                            ^ reference semanticdb maven . . minimized/Issue396#copy().(a)
  Issue396.apply(a = 42).productElement(0)
//^^^^^^^^ reference semanticdb maven . . minimized/Issue396.
//         ^^^^^ reference semanticdb maven . . minimized/Issue396.apply().
//               ^ reference semanticdb maven . . minimized/Issue396.apply().(a)
//                       ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Issue396#productElement().
  Issue396.apply(a = 42).productElementName(0)
//^^^^^^^^ reference semanticdb maven . . minimized/Issue396.
//         ^^^^^ reference semanticdb maven . . minimized/Issue396.apply().
//               ^ reference semanticdb maven . . minimized/Issue396.apply().(a)
//                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Issue396#productElementName().
}
