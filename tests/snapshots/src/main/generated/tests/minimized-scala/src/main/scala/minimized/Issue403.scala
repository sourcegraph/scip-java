package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

case class Issue403(value: String)
//         ^^^^^^^^ definition semanticdb maven . . minimized/Issue403#
//                  display_name Issue403
//                  documentation ```scala\ncase class Issue403(value: String)\n```
//                  relationship is_reference semanticdb maven . . minimized/Issue403.
//                  relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue403#productElementName().
//                  display_name productElementName
//                  documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue403#
//                  relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//                  relationship is_reference is_implementation semanticdb maven . . scala/Product#productElementName().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue403.apply().
//                  display_name apply
//                  documentation ```scala\ndef apply(value: String): Issue403\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue403#
//                  relationship is_reference is_implementation semanticdb maven . . scala/Function1#apply().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue403.
//                  display_name Issue403
//                  documentation ```scala\nobject Issue403\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue403#
//                  relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue403#productElement().
//                  display_name productElement
//                  documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue403#
//                  relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//                  relationship is_reference is_implementation semanticdb maven . . scala/Product#productElement().
//         ________ synthetic_definition semanticdb maven . . minimized/Issue403#copy().
//                  display_name copy
//                  documentation ```scala\ndef copy(value: String): Issue403\n```
//                  relationship is_definition semanticdb maven . . minimized/Issue403#
//                  relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//                 ^ definition semanticdb maven . . minimized/Issue403#`<init>`().
//                   display_name <init>
//                   documentation ```scala\ndef this(value: String)\n```
//                  ^^^^^ definition semanticdb maven . . minimized/Issue403#value.
//                        display_name value
//                        documentation ```scala\nval value: String\n```
//                        relationship is_reference semanticdb maven . . minimized/Issue403#`<init>`().(value)
//                        relationship is_reference semanticdb maven . . minimized/Issue403#copy().(value)
//                        relationship is_reference semanticdb maven . . minimized/Issue403.apply().(value)
//                  _____ synthetic_definition semanticdb maven . . minimized/Issue403#copy().(value)
//                        display_name value
//                        documentation ```scala\ndefault value: String \n```
//                        relationship is_reference semanticdb maven . . minimized/Issue403#`<init>`().(value)
//                        relationship is_reference is_definition semanticdb maven . . minimized/Issue403#value.
//                        relationship is_reference semanticdb maven . . minimized/Issue403.apply().(value)
//                  _____ synthetic_definition semanticdb maven . . minimized/Issue403.apply().(value)
//                        display_name value
//                        documentation ```scala\nvalue: String \n```
//                        relationship is_reference semanticdb maven . . minimized/Issue403#`<init>`().(value)
//                        relationship is_reference semanticdb maven . . minimized/Issue403#copy().(value)
//                        relationship is_reference is_definition semanticdb maven . . minimized/Issue403#value.
//                  _____ synthetic_definition semanticdb maven . . minimized/Issue403#`<init>`().(value)
//                        display_name value
//                        documentation ```scala\nvalue: String \n```
//                        relationship is_reference semanticdb maven . . minimized/Issue403#copy().(value)
//                        relationship is_reference is_definition semanticdb maven . . minimized/Issue403#value.
//                        relationship is_reference semanticdb maven . . minimized/Issue403.apply().(value)
//                         ^^^^^^ reference semanticdb maven . . scala/Predef.String#

object Issue403App {
//     ^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue403App.
//                 display_name Issue403App
//                 documentation ```scala\nobject Issue403App\n```
  def instantiations(): Unit = {
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue403App.instantiations().
//                   display_name instantiations
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
//                        display_name value
//                        documentation ```scala\nvalue: String \n```
        println(value)
//      ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//              ^^^^^ reference local 1
    }
  }
}
