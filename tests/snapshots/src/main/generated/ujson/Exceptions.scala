package ujson
//      ^^^^^ definition semanticdb maven . . ujson/


sealed trait ParsingFailedException extends Exception
//           ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParsingFailedException#
//                                  documentation ```scala\nsealed trait ParsingFailedException\n```
//                                          ^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.Exception#

case class ParseException(clue: String, index: Int)
//         ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#
//                        documentation ```scala\ncase class ParseException(clue: String, index: Int) extends Exception with ParsingFailedException\n```
//         ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#copy().
//                        documentation ```scala\ndef copy(clue: String, index: Int): ParseException\n```
//         ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#productElement().
//                        documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                        relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#productElementName().
//                        documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                        relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.
//                        documentation ```scala\nobject ParseException\n```
//         ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().
//                        documentation ```scala\ndef apply(clue: String, index: Int): ParseException\n```
//                        relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().
//                         documentation ```scala\ndef this(clue: String, index: Int)\n```
//                        ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(clue)
//                             documentation ```scala\nclue: String \n```
//                        ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#clue.
//                             documentation ```scala\nval clue: String\n```
//                        ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#copy().(clue)
//                             documentation ```scala\ndefault clue: String \n```
//                        ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().(clue)
//                             documentation ```scala\nclue: String \n```
//                              ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(index)
//                                            documentation ```scala\nindex: Int \n```
//                                      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#copy().(index)
//                                            documentation ```scala\ndefault index: Int \n```
//                                      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#index.
//                                            documentation ```scala\nval index: Int\n```
//                                      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.apply().(index)
//                                            documentation ```scala\nindex: Int \n```
//                                             ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
  extends Exception(clue + " at index " + index) with ParsingFailedException
//        ^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.Exception#
//                 ^ reference semanticdb maven jdk 11 java/lang/Exception#`<init>`(+1).
//                  ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(clue)
//                       ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
//                                      ^ reference semanticdb maven jdk 11 java/lang/String#`+`().
//                                        ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException#`<init>`().(index)
//                                                    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParsingFailedException#

case class IncompleteParseException(msg: String)
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#
//                                  documentation ```scala\ncase class IncompleteParseException(msg: String) extends Exception with ParsingFailedException\n```
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#copy().
//                                  documentation ```scala\ndef copy(msg: String): IncompleteParseException\n```
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#productElement().
//                                  documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#productElementName().
//                                  documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.
//                                  documentation ```scala\nobject IncompleteParseException\n```
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.apply().
//                                  documentation ```scala\ndef apply(msg: String): IncompleteParseException\n```
//                                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function1#apply().
//                                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#`<init>`().
//                                   documentation ```scala\ndef this(msg: String)\n```
//                                  ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#`<init>`().(msg)
//                                      documentation ```scala\nmsg: String \n```
//                                  ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#copy().(msg)
//                                      documentation ```scala\ndefault msg: String \n```
//                                  ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#msg.
//                                      documentation ```scala\nval msg: String\n```
//                                  ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException.apply().(msg)
//                                      documentation ```scala\nmsg: String \n```
//                                       ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
  extends Exception(msg) with ParsingFailedException
//        ^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.Exception#
//                 ^ reference semanticdb maven jdk 11 java/lang/Exception#`<init>`(+1).
//                  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#`<init>`().(msg)
//                            ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParsingFailedException#
