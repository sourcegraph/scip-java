package ujson
//      ^^^^^ definition ujson/


sealed trait ParsingFailedException extends Exception
//           ^^^^^^^^^^^^^^^^^^^^^^ definition ujson/ParsingFailedException#
//                                          ^^^^^^^^^ reference scala/package.Exception#

case class ParseException(clue: String, index: Int)
//         ^^^^^^^^^^^^^^ definition ujson/ParseException#
//                        definition ujson/ParseException#`<init>`().
//                        ^^^^ definition ujson/ParseException#clue.
//                              ^^^^^^ reference scala/Predef.String#
//                                      ^^^^^ definition ujson/ParseException#index.
//                                             ^^^ reference scala/Int#
  extends Exception(clue + " at index " + index) with ParsingFailedException
//        ^^^^^^^^^ reference scala/package.Exception#
//                  reference java/lang/Exception#`<init>`(+1).
//                  ^^^^ reference ujson/ParseException#`<init>`().(clue)
//                       ^ reference java/lang/String#`+`().
//                                      ^ reference java/lang/String#`+`().
//                                        ^^^^^ reference ujson/ParseException#`<init>`().(index)
//                                                    ^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ParsingFailedException#

case class IncompleteParseException(msg: String)
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/IncompleteParseException#
//                                  definition ujson/IncompleteParseException#`<init>`().
//                                  ^^^ definition ujson/IncompleteParseException#msg.
//                                       ^^^^^^ reference scala/Predef.String#
  extends Exception(msg) with ParsingFailedException
//        ^^^^^^^^^ reference scala/package.Exception#
//                  reference java/lang/Exception#`<init>`(+1).
//                  ^^^ reference ujson/IncompleteParseException#`<init>`().(msg)
//                            ^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ParsingFailedException#
