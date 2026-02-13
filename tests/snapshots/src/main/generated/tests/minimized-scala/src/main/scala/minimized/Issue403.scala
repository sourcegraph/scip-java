  package minimized
//        ^^^^^^^^^ definition semanticdb maven . . minimized/
  
  case class Issue403(value: String)
//           ^^^^^^^^ definition semanticdb maven . . minimized/Issue403#
//                    display_name Issue403
//                    signature_documentation scala case class Issue403(value: String)
//                    kind Class
//                    relationship is_reference semanticdb maven . . minimized/Issue403.
//                    relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//           ________ synthetic_definition semanticdb maven . . minimized/Issue403#productElementName().
//                    display_name productElementName
//                    signature_documentation scala def productElementName(x$1: Int): String
//                    kind Method
//                    relationship is_definition semanticdb maven . . minimized/Issue403#
//                    relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//                    relationship is_reference is_implementation semanticdb maven . . scala/Product#productElementName().
//           ________ synthetic_definition semanticdb maven . . minimized/Issue403.apply().
//                    display_name apply
//                    signature_documentation scala def apply(value: String): Issue403
//                    kind Method
//                    relationship is_definition semanticdb maven . . minimized/Issue403#
//                    relationship is_reference is_implementation semanticdb maven . . scala/Function1#apply().
//           ________ synthetic_definition semanticdb maven . . minimized/Issue403.
//                    display_name Issue403
//                    signature_documentation scala object Issue403
//                    kind Object
//                    relationship is_definition semanticdb maven . . minimized/Issue403#
//                    relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//           ________ synthetic_definition semanticdb maven . . minimized/Issue403#productElement().
//                    display_name productElement
//                    signature_documentation scala def productElement(x$1: Int): Any
//                    kind Method
//                    relationship is_definition semanticdb maven . . minimized/Issue403#
//                    relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//                    relationship is_reference is_implementation semanticdb maven . . scala/Product#productElement().
//           ________ synthetic_definition semanticdb maven . . minimized/Issue403#copy().
//                    display_name copy
//                    signature_documentation scala def copy(value: String): Issue403
//                    kind Method
//                    relationship is_definition semanticdb maven . . minimized/Issue403#
//                    relationship is_reference semanticdb maven . . minimized/Issue403.apply().
//                   ^ definition semanticdb maven . . minimized/Issue403#`<init>`().
//                     display_name <init>
//                     signature_documentation scala def this(value: String)
//                     kind Constructor
//                    ^^^^^ definition semanticdb maven . . minimized/Issue403#value.
//                          display_name value
//                          signature_documentation scala val value: String
//                          kind Method
//                          relationship is_reference semanticdb maven . . minimized/Issue403#`<init>`().(value)
//                          relationship is_reference semanticdb maven . . minimized/Issue403#copy().(value)
//                          relationship is_reference semanticdb maven . . minimized/Issue403.apply().(value)
//                    _____ synthetic_definition semanticdb maven . . minimized/Issue403#copy().(value)
//                          display_name value
//                          signature_documentation scala default value: String 
//                          kind Parameter
//                          relationship is_reference semanticdb maven . . minimized/Issue403#`<init>`().(value)
//                          relationship is_reference is_definition semanticdb maven . . minimized/Issue403#value.
//                          relationship is_reference semanticdb maven . . minimized/Issue403.apply().(value)
//                    _____ synthetic_definition semanticdb maven . . minimized/Issue403.apply().(value)
//                          display_name value
//                          signature_documentation scala value: String 
//                          kind Parameter
//                          relationship is_reference semanticdb maven . . minimized/Issue403#`<init>`().(value)
//                          relationship is_reference semanticdb maven . . minimized/Issue403#copy().(value)
//                          relationship is_reference is_definition semanticdb maven . . minimized/Issue403#value.
//                    _____ synthetic_definition semanticdb maven . . minimized/Issue403#`<init>`().(value)
//                          display_name value
//                          signature_documentation scala value: String 
//                          kind Parameter
//                          relationship is_reference semanticdb maven . . minimized/Issue403#copy().(value)
//                          relationship is_reference is_definition semanticdb maven . . minimized/Issue403#value.
//                          relationship is_reference semanticdb maven . . minimized/Issue403.apply().(value)
//                           ^^^^^^ reference semanticdb maven . . scala/Predef.String#
  
  object Issue403App {
//       ^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue403App.
//                   display_name Issue403App
//                   signature_documentation scala object Issue403App
//                   kind Object
    def instantiations(): Unit = {
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue403App.instantiations().
//                     display_name instantiations
//                     signature_documentation scala def instantiations(): Unit
//                     kind Method
//                        ^^^^ reference semanticdb maven . . scala/Unit#
      println(Issue403("a").value)
//    ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//            ^^^^^^^^ reference semanticdb maven . . minimized/Issue403.
//                    ^ reference semanticdb maven . . minimized/Issue403.apply().
//                          ^^^^^ reference semanticdb maven . . minimized/Issue403#value.
      println(Issue403.apply("a").value)
//    ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//            ^^^^^^^^ reference semanticdb maven . . minimized/Issue403.
//                     ^^^^^ reference semanticdb maven . . minimized/Issue403.apply().
//                                ^^^^^ reference semanticdb maven . . minimized/Issue403#value.
      println(new Issue403("a").value)
//    ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//                ^^^^^^^^ reference semanticdb maven . . minimized/Issue403#
//                        ^ reference semanticdb maven . . minimized/Issue403#`<init>`().
//                              ^^^^^ reference semanticdb maven . . minimized/Issue403#value.
  
      Issue403("a") match {
//    ^^^^^^^^ reference semanticdb maven . . minimized/Issue403.
//            ^ reference semanticdb maven . . minimized/Issue403.apply().
        case Issue403(value) =>
//           ^^^^^^^^ reference semanticdb maven . . minimized/Issue403.
//                    ^^^^^ definition local 1
//                          display_name value
//                          signature_documentation scala value: String 
//                          kind Variable
          println(value)
//        ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//                ^^^^^ reference local 1
      }
    }
  }
