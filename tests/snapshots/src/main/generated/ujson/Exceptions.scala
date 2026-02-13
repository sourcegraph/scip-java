  package ujson
//        ^^^^^ definition semanticdb maven . . ujson/
  
  
  sealed trait ParsingFailedException extends Exception
//             ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParsingFailedException#
//                                    display_name ParsingFailedException
//                                    signature_documentation scala sealed trait ParsingFailedException
//                                    kind Trait
//                                            ^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/package.Exception#
  
  case class ParseException(clue: String, index: Int)
//           ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#
//                          display_name ParseException
//                          signature_documentation scala case class ParseException(clue: String, index: Int) extends Exception with ParsingFailedException
//                          kind Class
//                          relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.
//                          relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().
//           ______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#productElementName().
//                          display_name productElementName
//                          signature_documentation scala def productElementName(x$1: Int): String
//                          kind Method
//                          relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#
//                          relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().
//                          relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Product#productElementName().
//           ______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().
//                          display_name apply
//                          signature_documentation scala def apply(clue: String, index: Int): ParseException
//                          kind Method
//                          relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#
//                          relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Function2#apply().
//           ______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.
//                          display_name ParseException
//                          signature_documentation scala object ParseException
//                          kind Object
//                          relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#
//                          relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().
//           ______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#copy().
//                          display_name copy
//                          signature_documentation scala def copy(clue: String, index: Int): ParseException
//                          kind Method
//                          relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#
//                          relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().
//           ______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#productElement().
//                          display_name productElement
//                          signature_documentation scala def productElement(x$1: Int): Any
//                          kind Method
//                          relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#
//                          relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().
//                          relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Product#productElement().
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().
//                           display_name <init>
//                           signature_documentation scala def this(clue: String, index: Int)
//                           kind Constructor
//                          ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#clue.
//                               display_name clue
//                               signature_documentation scala val clue: String
//                               kind Method
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(clue)
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#copy().(clue)
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().(clue)
//                          ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().(clue)
//                               display_name clue
//                               signature_documentation scala clue: String 
//                               kind Parameter
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(clue)
//                               relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#clue.
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#copy().(clue)
//                          ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(clue)
//                               display_name clue
//                               signature_documentation scala clue: String 
//                               kind Parameter
//                               relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#clue.
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#copy().(clue)
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().(clue)
//                          ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#copy().(clue)
//                               display_name clue
//                               signature_documentation scala default clue: String 
//                               kind Parameter
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(clue)
//                               relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#clue.
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().(clue)
//                                ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Predef.String#
//                                        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#index.
//                                              display_name index
//                                              signature_documentation scala val index: Int
//                                              kind Method
//                                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(index)
//                                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#copy().(index)
//                                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().(index)
//                                        _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(index)
//                                              display_name index
//                                              signature_documentation scala index: Int 
//                                              kind Parameter
//                                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#copy().(index)
//                                              relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#index.
//                                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().(index)
//                                        _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().(index)
//                                              display_name index
//                                              signature_documentation scala index: Int 
//                                              kind Parameter
//                                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(index)
//                                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#copy().(index)
//                                              relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#index.
//                                        _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#copy().(index)
//                                              display_name index
//                                              signature_documentation scala default index: Int 
//                                              kind Parameter
//                                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(index)
//                                              relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#index.
//                                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().(index)
//                                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
    extends Exception(clue + " at index " + index) with ParsingFailedException
//          ^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/package.Exception#
//                   ^ reference semanticdb maven jdk 11 java/lang/Exception#`<init>`(+1).
//                    ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(clue)
//                         ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
//                                        ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
//                                          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(index)
//                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParsingFailedException#
  
  case class IncompleteParseException(msg: String)
//           ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#
//                                    display_name IncompleteParseException
//                                    signature_documentation scala case class IncompleteParseException(msg: String) extends Exception with ParsingFailedException
//                                    kind Class
//                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.
//                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.apply().
//           ________________________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#productElement().
//                                    display_name productElement
//                                    signature_documentation scala def productElement(x$1: Int): Any
//                                    kind Method
//                                    relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#
//                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.apply().
//                                    relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Product#productElement().
//           ________________________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.apply().
//                                    display_name apply
//                                    signature_documentation scala def apply(msg: String): IncompleteParseException
//                                    kind Method
//                                    relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#
//                                    relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Function1#apply().
//           ________________________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#copy().
//                                    display_name copy
//                                    signature_documentation scala def copy(msg: String): IncompleteParseException
//                                    kind Method
//                                    relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#
//                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.apply().
//           ________________________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#productElementName().
//                                    display_name productElementName
//                                    signature_documentation scala def productElementName(x$1: Int): String
//                                    kind Method
//                                    relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#
//                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.apply().
//                                    relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Product#productElementName().
//           ________________________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.
//                                    display_name IncompleteParseException
//                                    signature_documentation scala object IncompleteParseException
//                                    kind Object
//                                    relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#
//                                    relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.apply().
//                                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#`<init>`().
//                                     display_name <init>
//                                     signature_documentation scala def this(msg: String)
//                                     kind Constructor
//                                    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#msg.
//                                        display_name msg
//                                        signature_documentation scala val msg: String
//                                        kind Method
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#`<init>`().(msg)
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#copy().(msg)
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.apply().(msg)
//                                    ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.apply().(msg)
//                                        display_name msg
//                                        signature_documentation scala msg: String 
//                                        kind Parameter
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#`<init>`().(msg)
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#copy().(msg)
//                                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#msg.
//                                    ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#copy().(msg)
//                                        display_name msg
//                                        signature_documentation scala default msg: String 
//                                        kind Parameter
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#`<init>`().(msg)
//                                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#msg.
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.apply().(msg)
//                                    ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#`<init>`().(msg)
//                                        display_name msg
//                                        signature_documentation scala msg: String 
//                                        kind Parameter
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#copy().(msg)
//                                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#msg.
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.apply().(msg)
//                                         ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Predef.String#
    extends Exception(msg) with ParsingFailedException
//          ^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/package.Exception#
//                   ^ reference semanticdb maven jdk 11 java/lang/Exception#`<init>`(+1).
//                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#`<init>`().(msg)
//                              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParsingFailedException#
