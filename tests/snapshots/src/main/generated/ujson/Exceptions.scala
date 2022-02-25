package ujson
//      ^^^^^ definition ujson/


sealed trait ParsingFailedException extends Exception
//           ^^^^^^^^^^^^^^^^^^^^^^ definition ujson/ParsingFailedException# sealed trait ParsingFailedException
//                                          ^^^^^^^^^ reference scala/package.Exception#

case class ParseException(clue: String, index: Int)
//         ^^^^^^^^^^^^^^ definition ujson/ParseException# case class ParseException(clue: String, index: Int) extends Exception with ParsingFailedException
//         ^^^^^^^^^^^^^^ synthetic_definition ujson/ParseException#productElementName(). def productElementName(x$1: Int): String
//         ^^^^^^^^^^^^^^ synthetic_definition ujson/ParseException.apply(). def apply(clue: String, index: Int): ParseException
//         ^^^^^^^^^^^^^^ definition ujson/ParseException. object ParseException
//         ^^^^^^^^^^^^^^ synthetic_definition ujson/ParseException#copy(). def copy(clue: String, index: Int): ParseException
//         ^^^^^^^^^^^^^^ synthetic_definition ujson/ParseException#productElement(). def productElement(x$1: Int): Any
//                        definition ujson/ParseException#`<init>`(). def this(clue: String, index: Int)
//                        ^^^^ definition ujson/ParseException#clue. val clue: String
//                        ^^^^ definition ujson/ParseException.apply().(clue) clue: String
//                        ^^^^ definition ujson/ParseException#`<init>`().(clue) clue: String
//                        ^^^^ definition ujson/ParseException#copy().(clue) default clue: String
//                              ^^^^^^ reference scala/Predef.String#
//                                      ^^^^^ definition ujson/ParseException#index. val index: Int
//                                      ^^^^^ definition ujson/ParseException#`<init>`().(index) index: Int
//                                      ^^^^^ definition ujson/ParseException.apply().(index) index: Int
//                                      ^^^^^ definition ujson/ParseException#copy().(index) default index: Int
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
//         ^^^^^^^^^^^^^^^^^^^^^^^^ synthetic_definition ujson/IncompleteParseException#productElement(). def productElement(x$1: Int): Any
//         ^^^^^^^^^^^^^^^^^^^^^^^^ synthetic_definition ujson/IncompleteParseException.apply(). def apply(msg: String): IncompleteParseException
//         ^^^^^^^^^^^^^^^^^^^^^^^^ synthetic_definition ujson/IncompleteParseException#copy(). def copy(msg: String): IncompleteParseException
//         ^^^^^^^^^^^^^^^^^^^^^^^^ synthetic_definition ujson/IncompleteParseException#productElementName(). def productElementName(x$1: Int): String
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/IncompleteParseException. object IncompleteParseException
//                                  definition ujson/IncompleteParseException#`<init>`(). def this(msg: String)
//                                  ^^^ definition ujson/IncompleteParseException#msg. val msg: String
//                                  ^^^ definition ujson/IncompleteParseException.apply().(msg) msg: String
//                                  ^^^ definition ujson/IncompleteParseException#copy().(msg) default msg: String
//                                  ^^^ definition ujson/IncompleteParseException#`<init>`().(msg) msg: String
//                                       ^^^^^^ reference scala/Predef.String#
  extends Exception(msg) with ParsingFailedException
//        ^^^^^^^^^ reference scala/package.Exception#
//                  reference java/lang/Exception#`<init>`(+1).
//                  ^^^ reference ujson/IncompleteParseException#`<init>`().(msg)
//                            ^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ParsingFailedException#
