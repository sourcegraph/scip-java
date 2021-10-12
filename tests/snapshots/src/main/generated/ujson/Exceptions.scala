package ujson
//      ^^^^^ definition ujson/


sealed trait ParsingFailedException extends Exception
//           ^^^^^^^^^^^^^^^^^^^^^^ definition ujson/ParsingFailedException# sealed trait ParsingFailedException
//                                          ^^^^^^^^^ reference scala/package.Exception#

case class ParseException(clue: String, index: Int)
//         ^^^^^^^^^^^^^^ definition ujson/ParseException# case class ParseException(clue: String, index: Int) extends Exception with ParsingFailedException
//                        definition ujson/ParseException#`<init>`(). def this(clue: String, index: Int)
//                        ^^^^ definition ujson/ParseException#clue. val clue: String
//                              ^^^^^^ reference scala/Predef.String#
//                                      ^^^^^ definition ujson/ParseException#index. val index: Int
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
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/IncompleteParseException# case class IncompleteParseException(msg: String) extends Exception with ParsingFailedException
//                                  definition ujson/IncompleteParseException#`<init>`(). def this(msg: String)
//                                  ^^^ definition ujson/IncompleteParseException#msg. val msg: String
//                                       ^^^^^^ reference scala/Predef.String#
  extends Exception(msg) with ParsingFailedException
//        ^^^^^^^^^ reference scala/package.Exception#
//                  reference java/lang/Exception#`<init>`(+1).
//                  ^^^ reference ujson/IncompleteParseException#`<init>`().(msg)
//                            ^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ParsingFailedException#
