package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

case class Issue403(value: String)
//         ^^^^^^^^ definition semanticdb maven . . minimized/Issue403#
//                  documentation ```scala\ncase class Issue403(value: String)\n```
//                  relationship is_reference semanticdb maven . . minimized/Issue403.
//                  relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue403#productElementName().
//                  documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue403#
//                  relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//                  relationship is_reference is_implementation semanticdb maven . . scala/Product#productElementName().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue403.apply().
//                  documentation ```scala\ndef apply(value: String): Issue403\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue403#
//                  relationship is_reference is_implementation semanticdb maven . . scala/Function1#apply().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue403.
//                  documentation ```scala\nobject Issue403\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue403#
//                  relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue403#productElement().
//                  documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue403#
//                  relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//                  relationship is_reference is_implementation semanticdb maven . . scala/Product#productElement().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue403#copy().
//                  documentation ```scala\ndef copy(value: String): Issue403\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue403#
//                  relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//                 ^ definition semanticdb maven . . minimized/Issue403#`<init>`().
//                   documentation ```scala\ndef this(value: String)\n```
//                  ^^^^^ definition semanticdb maven . . minimized/Issue403#value.
//                        documentation ```scala\nval value: String\n```
//                        relationship is_reference semanticdb maven . . minimized/Issue403#`<init>`().(value)
//                        relationship is_reference semanticdb maven . . minimized/Issue403#copy().(value)
//                        relationship is_reference semanticdb maven . . minimized/Issue403.apply().(value)
//                  _____ synthetic_definition semanticdb maven . . minimized/Issue403#copy().(value)
//                        documentation ```scala\ndefault value: String \n```
//                        relationship is_reference semanticdb maven . . minimized/Issue403#`<init>`().(value)
//                        relationship is_reference is_definition semanticdb maven . . minimized/Issue403#value.
//                        relationship is_reference semanticdb maven . . minimized/Issue403.apply().(value)
//                  _____ synthetic_definition semanticdb maven . . minimized/Issue403.apply().(value)
//                        documentation ```scala\nvalue: String \n```
//                        relationship is_reference semanticdb maven . . minimized/Issue403#`<init>`().(value)
//                        relationship is_reference semanticdb maven . . minimized/Issue403#copy().(value)
//                        relationship is_reference is_definition semanticdb maven . . minimized/Issue403#value.
//                  _____ synthetic_definition semanticdb maven . . minimized/Issue403#`<init>`().(value)
//                        documentation ```scala\nvalue: String \n```
//                        relationship is_reference semanticdb maven . . minimized/Issue403#copy().(value)
//                        relationship is_reference is_definition semanticdb maven . . minimized/Issue403#value.
//                        relationship is_reference semanticdb maven . . minimized/Issue403.apply().(value)
//                         ^^^^^^ reference semanticdb maven . . scala/Predef.String#

object Issue403App {
//     ^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue403App.
//                 documentation ```scala\nobject Issue403App\n```
  def instantiations(): Unit = {
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue403App.instantiations().
//                   documentation ```scala\ndef instantiations(): Unit\n```
//                      ^^^^ reference semanticdb maven . . scala/Unit#
    println(Issue403("a").value)
//  ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//          ^^^^^^^^ reference semanticdb maven . . minimized/Issue403.
//                  ^ reference semanticdb maven . . minimized/Issue403.apply().
//                        ^^^^^ reference semanticdb maven . . minimized/Issue403#value.
    println(Issue403.apply("a").value)
//  ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//          ^^^^^^^^ reference semanticdb maven . . minimized/Issue403.
//                   ^^^^^ reference semanticdb maven . . minimized/Issue403.apply().
//                              ^^^^^ reference semanticdb maven . . minimized/Issue403#value.
    println(new Issue403("a").value)
//  ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//              ^^^^^^^^ reference semanticdb maven . . minimized/Issue403#
//                      ^ reference semanticdb maven . . minimized/Issue403#`<init>`().
//                            ^^^^^ reference semanticdb maven . . minimized/Issue403#value.

    Issue403("a") match {
//  ^^^^^^^^ reference semanticdb maven . . minimized/Issue403.
//          ^ reference semanticdb maven . . minimized/Issue403.apply().
      case Issue403(value) =>
//         ^^^^^^^^ reference semanticdb maven . . minimized/Issue403.
//                  ^^^^^ definition local 1
//                        documentation ```scala\nvalue: String \n```
        println(value)
//      ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//              ^^^^^ reference local 1
    }
  }
}
