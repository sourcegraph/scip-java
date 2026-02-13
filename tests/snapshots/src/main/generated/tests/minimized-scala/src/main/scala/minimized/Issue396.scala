  package minimized
//        ^^^^^^^^^ definition semanticdb maven . . minimized/
  
  case class Issue396(a: Int)
//           ^^^^^^^^ definition semanticdb maven . . minimized/Issue396#
//                    display_name Issue396
//                    signature_documentation scala case class Issue396(a: Int)
//                    kind Class
//                    relationship is_reference semanticdb maven . . minimized/Issue396.
//                    relationship is_reference semanticdb maven . . minimized/Issue396.apply().
//           ________ synthetic_definition semanticdb maven . . minimized/Issue396#copy().
//                    display_name copy
//                    signature_documentation scala def copy(a: Int): Issue396
//                    kind Method
//                    relationship is_definition semanticdb maven . . minimized/Issue396#
//                    relationship is_reference semanticdb maven . . minimized/Issue396.apply().
//           ________ synthetic_definition semanticdb maven . . minimized/Issue396#productElement().
//                    display_name productElement
//                    signature_documentation scala def productElement(x$1: Int): Any
//                    kind Method
//                    relationship is_definition semanticdb maven . . minimized/Issue396#
//                    relationship is_reference semanticdb maven . . minimized/Issue396.apply().
//                    relationship is_reference is_implementation semanticdb maven . . scala/Product#productElement().
//           ________ synthetic_definition semanticdb maven . . minimized/Issue396.
//                    display_name Issue396
//                    signature_documentation scala object Issue396
//                    kind Object
//                    relationship is_definition semanticdb maven . . minimized/Issue396#
//                    relationship is_reference semanticdb maven . . minimized/Issue396.apply().
//           ________ synthetic_definition semanticdb maven . . minimized/Issue396.apply().
//                    display_name apply
//                    signature_documentation scala def apply(a: Int): Issue396
//                    kind Method
//                    relationship is_definition semanticdb maven . . minimized/Issue396#
//                    relationship is_reference is_implementation semanticdb maven . . scala/Function1#apply().
//           ________ synthetic_definition semanticdb maven . . minimized/Issue396#productElementName().
//                    display_name productElementName
//                    signature_documentation scala def productElementName(x$1: Int): String
//                    kind Method
//                    relationship is_definition semanticdb maven . . minimized/Issue396#
//                    relationship is_reference semanticdb maven . . minimized/Issue396.apply().
//                    relationship is_reference is_implementation semanticdb maven . . scala/Product#productElementName().
//                   ^ definition semanticdb maven . . minimized/Issue396#`<init>`().
//                     display_name <init>
//                     signature_documentation scala def this(a: Int)
//                     kind Constructor
//                    ^ definition semanticdb maven . . minimized/Issue396#a.
//                      display_name a
//                      signature_documentation scala val a: Int
//                      kind Method
//                      relationship is_reference semanticdb maven . . minimized/Issue396#`<init>`().(a)
//                      relationship is_reference semanticdb maven . . minimized/Issue396#copy().(a)
//                      relationship is_reference semanticdb maven . . minimized/Issue396.apply().(a)
//                    _ synthetic_definition semanticdb maven . . minimized/Issue396.apply().(a)
//                      display_name a
//                      signature_documentation scala a: Int 
//                      kind Parameter
//                      relationship is_reference semanticdb maven . . minimized/Issue396#`<init>`().(a)
//                      relationship is_reference is_definition semanticdb maven . . minimized/Issue396#a.
//                      relationship is_reference semanticdb maven . . minimized/Issue396#copy().(a)
//                    _ synthetic_definition semanticdb maven . . minimized/Issue396#`<init>`().(a)
//                      display_name a
//                      signature_documentation scala a: Int 
//                      kind Parameter
//                      relationship is_reference is_definition semanticdb maven . . minimized/Issue396#a.
//                      relationship is_reference semanticdb maven . . minimized/Issue396#copy().(a)
//                      relationship is_reference semanticdb maven . . minimized/Issue396.apply().(a)
//                    _ synthetic_definition semanticdb maven . . minimized/Issue396#copy().(a)
//                      display_name a
//                      signature_documentation scala default a: Int 
//                      kind Parameter
//                      relationship is_reference semanticdb maven . . minimized/Issue396#`<init>`().(a)
//                      relationship is_reference is_definition semanticdb maven . . minimized/Issue396#a.
//                      relationship is_reference semanticdb maven . . minimized/Issue396.apply().(a)
//                       ^^^ reference semanticdb maven . . scala/Int#
  object Issue396App {
//       ^^^^^^^^^^^ definition semanticdb maven . . minimized/Issue396App.
//                   display_name Issue396App
//                   signature_documentation scala object Issue396App
//                   kind Object
    println(Issue396)
//  ^^^^^^^ reference semanticdb maven . . scala/Predef.println(+1).
//          ^^^^^^^^ reference semanticdb maven . . minimized/Issue396.
    Issue396.apply(a = 42).copy(a = 41)
//  ^^^^^^^^ reference semanticdb maven . . minimized/Issue396.
//           ^^^^^ reference semanticdb maven . . minimized/Issue396.apply().
//                 ^ reference semanticdb maven . . minimized/Issue396.apply().(a)
//                         ^^^^ reference semanticdb maven . . minimized/Issue396#copy().
//                              ^ reference semanticdb maven . . minimized/Issue396#copy().(a)
    Issue396.apply(a = 42).productElement(0)
//  ^^^^^^^^ reference semanticdb maven . . minimized/Issue396.
//           ^^^^^ reference semanticdb maven . . minimized/Issue396.apply().
//                 ^ reference semanticdb maven . . minimized/Issue396.apply().(a)
//                         ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Issue396#productElement().
    Issue396.apply(a = 42).productElementName(0)
//  ^^^^^^^^ reference semanticdb maven . . minimized/Issue396.
//           ^^^^^ reference semanticdb maven . . minimized/Issue396.apply().
//                 ^ reference semanticdb maven . . minimized/Issue396.apply().(a)
//                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Issue396#productElementName().
  }
