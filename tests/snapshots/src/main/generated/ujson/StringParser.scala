package ujson
//      ^^^^^ definition ujson/

import upickle.core.{ObjArrVisitor, Visitor}
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                   ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                  ^^^^^^^ reference upickle/core/Visitor.
//                                  ^^^^^^^ reference upickle/core/Visitor#

/**
 * Basic in-memory string parsing.
 *
 * This is probably the simplest Parser implementation, since there is
 * no UTF-8 decoding, and the data is already fully available.
 *
 * This parser is limited to the maximum string size (~2G). Obviously
 * for large JSON documents it's better to avoid using this parser and
 * go straight from disk, to avoid having to load the whole thing into
 * memory at once. So this limit will probably not be a problem in
 * practice.
 */
private[ujson] final class StringParser[J](s: String) extends CharParser[J]{
//      ^^^^^ reference ujson/
//                         ^^^^^^^^^^^^ definition ujson/StringParser# protected[ujson] final class StringParser[J]
//                                      ^ definition ujson/StringParser#[J] J
//                                         definition ujson/StringParser#`<init>`(). def this(s: String)
//                                         ^ definition ujson/StringParser#s. private[this] val s: String
//                                            ^^^^^^ reference scala/Predef.String#
//                                                            ^^^^^^^^^^ reference ujson/CharParser#
//                                                                       ^ reference ujson/StringParser#[J]
//                                                                          reference ujson/CharParser#`<init>`().
  private[this] val sLength = s.length
//                  ^^^^^^^ definition ujson/StringParser#sLength. private[this] val sLength: Int
//                            ^ reference ujson/StringParser#s.
//                              ^^^^^^ reference java/lang/String#length().
  override def growBuffer(until: Int): Unit = ()
//             ^^^^^^^^^^ definition ujson/StringParser#growBuffer(). def growBuffer(until: Int): Unit
//                        ^^^^^ definition ujson/StringParser#growBuffer().(until) until: Int
//                               ^^^ reference scala/Int#
//                                     ^^^^ reference scala/Unit#
  def readDataIntoBuffer(buffer: Array[Char], bufferOffset: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition ujson/StringParser#readDataIntoBuffer(). def readDataIntoBuffer(buffer: Array[Char], bufferOffset: Int): (Array[Char], Boolean, Int)
//                       ^^^^^^ definition ujson/StringParser#readDataIntoBuffer().(buffer) buffer: Array[Char]
//                               ^^^^^ reference scala/Array#
//                                     ^^^^ reference scala/Char#
//                                            ^^^^^^^^^^^^ definition ujson/StringParser#readDataIntoBuffer().(bufferOffset) bufferOffset: Int
//                                                          ^^^ reference scala/Int#
    if(buffer == null) (s.toCharArray, sLength == 0, sLength)
//     ^^^^^^ reference ujson/StringParser#readDataIntoBuffer().(buffer)
//            ^^ reference java/lang/Object#`==`().
//                      ^ reference ujson/StringParser#s.
//                        ^^^^^^^^^^^ reference java/lang/String#toCharArray().
//                                     ^^^^^^^ reference ujson/StringParser#sLength.
//                                             ^^ reference scala/Int#`==`(+3).
//                                                   ^^^^^^^ reference ujson/StringParser#sLength.
    else (buffer, true, -1)
//        ^^^^^^ reference ujson/StringParser#readDataIntoBuffer().(buffer)
  }
  final def close() = ()
//          ^^^^^ definition ujson/StringParser#close(). final def close(): Unit
}

object StringParser extends Transformer[String]{
//     ^^^^^^^^^^^^ definition ujson/StringParser. object StringParser
//                          ^^^^^^^^^^^ reference ujson/Transformer#
//                                      ^^^^^^ reference scala/Predef.String#
//                                              reference java/lang/Object#`<init>`().
  def transform[T](j: String, f: Visitor[_, T]) = new StringParser(j).parse(f)
//    ^^^^^^^^^ definition ujson/StringParser.transform(). def transform(j: String, f: Visitor[local0, T[): T
//              ^ definition ujson/StringParser.transform().[T] T
//                 ^ definition ujson/StringParser.transform().(j) j: String
//                    ^^^^^^ reference scala/Predef.String#
//                            ^ definition ujson/StringParser.transform().(f) f: Visitor[local0, T[
//                               ^^^^^^^ reference upickle/core/Visitor#
//                                          ^ reference ujson/StringParser.transform().[T]
//                                                    ^^^^^^^^^^^^ reference ujson/StringParser#
//                                                                 reference ujson/StringParser#`<init>`().
//                                                                 ^ reference ujson/StringParser.transform().(j)
//                                                                    ^^^^^ reference ujson/CharParser#parse().
//                                                                          ^ reference ujson/StringParser.transform().(f)
}
