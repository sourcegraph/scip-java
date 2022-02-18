package ujson
//      ^^^^^ definition ujson/


sealed trait ParsingFailedException extends Exception
//           ^^^^^^^^^^^^^^^^^^^^^^ definition ujson/ParsingFailedException# sealed trait ParsingFailedException
//                                          ^^^^^^^^^ reference scala/package.Exception#

case class ParseException(clue: String, index: Int)
//         ^^^^^^^^^^^^^^ definition ujson/ParseException# case class ParseException(clue: String, index: Int) extends Exception with ParsingFailedException
//         ^^^^^^^^^^^^^^ definition ujson/ParseException#productElementName(). def productElementName(x$1: Int): String
//         ^^^^^^^^^^^^^^ definition ujson/ParseException.apply(). def apply(clue: String, index: Int): ParseException
//         ^^^^^^^^^^^^^^ definition ujson/ParseException. object ParseException
//         ^^^^^^^^^^^^^^ definition ujson/ParseException#copy(). def copy(clue: String, index: Int): ParseException
//         ^^^^^^^^^^^^^^ definition ujson/ParseException#productElement(). def productElement(x$1: Int): Any
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
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/IncompleteParseException#productElement(). def productElement(x$1: Int): Any
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/IncompleteParseException.apply(). def apply(msg: String): IncompleteParseException
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/IncompleteParseException#copy(). def copy(msg: String): IncompleteParseException
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/IncompleteParseException#productElementName(). def productElementName(x$1: Int): String
//         ^^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/IncompleteParseException. object IncompleteParseException
//                                  definition ujson/IncompleteParseException#`<init>`(). def this(msg: String)
//                                  ^^^ definition ujson/IncompleteParseException#msg. val msg: String
//                                       ^^^^^^ reference scala/Predef.String#
  extends Exception(msg) with ParsingFailedException
//        ^^^^^^^^^ reference scala/package.Exception#
//                  reference java/lang/Exception#`<init>`(+1).
//                  ^^^ reference ujson/IncompleteParseException#`<init>`().(msg)
//                            ^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ParsingFailedException#
