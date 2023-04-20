package ujson
//      ^^^^^ definition ujson/

import upickle.core.{ObjArrVisitor, Visitor}
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                   ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                  ^^^^^^^ reference upickle/core/Visitor.
//                                  ^^^^^^^ reference upickle/core/Visitor#
/**
 * Lazy character sequence parsing.
 *
 * This is similar to StringParser, but acts on character sequences.
 */
private[ujson] final class CharSequenceParser[J](cs: CharSequence) extends CharParser[J]{
//      ^^^^^ reference ujson/
//                         ^^^^^^^^^^^^^^^^^^ definition ujson/CharSequenceParser# protected[ujson] final class CharSequenceParser[J]
//                                            ^ definition ujson/CharSequenceParser#[J] J
//                                               definition ujson/CharSequenceParser#`<init>`(). def this(cs: CharSequence)
//                                               ^^ definition ujson/CharSequenceParser#cs. private[this] val cs: CharSequence
//                                                   ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                                         ^^^^^^^^^^ reference ujson/CharParser#
//                                                                                    ^ reference ujson/CharSequenceParser#[J]
//                                                                                       reference ujson/CharParser#`<init>`().
  override def growBuffer(until: Int): Unit = ()
//             ^^^^^^^^^^ definition ujson/CharSequenceParser#growBuffer(). def growBuffer(until: Int): Unit
//                        ^^^^^ definition ujson/CharSequenceParser#growBuffer().(until) until: Int
//                               ^^^ reference scala/Int#
//                                     ^^^^ reference scala/Unit#
  def readDataIntoBuffer(buffer: Array[Char], bufferOffset: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition ujson/CharSequenceParser#readDataIntoBuffer(). def readDataIntoBuffer(buffer: Array[Char], bufferOffset: Int): (Array[Char], Boolean, Int)
//                       ^^^^^^ definition ujson/CharSequenceParser#readDataIntoBuffer().(buffer) buffer: Array[Char]
//                               ^^^^^ reference scala/Array#
//                                     ^^^^ reference scala/Char#
//                                            ^^^^^^^^^^^^ definition ujson/CharSequenceParser#readDataIntoBuffer().(bufferOffset) bufferOffset: Int
//                                                          ^^^ reference scala/Int#
    if(buffer == null) (cs.toString.toCharArray, cs.length == 0, cs.length)
//     ^^^^^^ reference ujson/CharSequenceParser#readDataIntoBuffer().(buffer)
//            ^^ reference java/lang/Object#`==`().
//                      ^^ reference ujson/CharSequenceParser#cs.
//                         ^^^^^^^^ reference java/lang/Object#toString().
//                                  ^^^^^^^^^^^ reference java/lang/String#toCharArray().
//                                               ^^ reference ujson/CharSequenceParser#cs.
//                                                  ^^^^^^ reference java/lang/CharSequence#length().
//                                                         ^^ reference scala/Int#`==`(+3).
//                                                               ^^ reference ujson/CharSequenceParser#cs.
//                                                                  ^^^^^^ reference java/lang/CharSequence#length().
    else (buffer, true, -1)
//        ^^^^^^ reference ujson/CharSequenceParser#readDataIntoBuffer().(buffer)
  }
  final def close() = ()
//          ^^^^^ definition ujson/CharSequenceParser#close(). final def close(): Unit
}

object CharSequenceParser extends Transformer[CharSequence]{
//     ^^^^^^^^^^^^^^^^^^ definition ujson/CharSequenceParser. object CharSequenceParser
//                                ^^^^^^^^^^^ reference ujson/Transformer#
//                                            ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                          reference java/lang/Object#`<init>`().
  def transform[T](j: CharSequence, f: Visitor[_, T]) = new CharSequenceParser(j).parse(f)
//    ^^^^^^^^^ definition ujson/CharSequenceParser.transform(). def transform(j: CharSequence, f: Visitor[local0, T[): T
//              ^ definition ujson/CharSequenceParser.transform().[T] T
//                 ^ definition ujson/CharSequenceParser.transform().(j) j: CharSequence
//                    ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                  ^ definition ujson/CharSequenceParser.transform().(f) f: Visitor[local0, T[
//                                     ^^^^^^^ reference upickle/core/Visitor#
//                                                ^ reference ujson/CharSequenceParser.transform().[T]
//                                                          ^^^^^^^^^^^^^^^^^^ reference ujson/CharSequenceParser#
//                                                                             reference ujson/CharSequenceParser#`<init>`().
//                                                                             ^ reference ujson/CharSequenceParser.transform().(j)
//                                                                                ^^^^^ reference ujson/CharParser#parse().
//                                                                                      ^ reference ujson/CharSequenceParser.transform().(f)
}
