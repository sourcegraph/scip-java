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
//                         ^^^^^^^^^^^^^^^^^^ definition ujson/CharSequenceParser#
//                                            ^ definition ujson/CharSequenceParser#[J]
//                                               definition ujson/CharSequenceParser#`<init>`().
//                                               ^^ definition ujson/CharSequenceParser#cs.
//                                                   ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                                         ^^^^^^^^^^ reference ujson/CharParser#
//                                                                                    ^ reference ujson/CharSequenceParser#[J]
//                                                                                       reference ujson/CharParser#`<init>`().
  override def growBuffer(until: Int): Unit = ()
//             ^^^^^^^^^^ definition ujson/CharSequenceParser#growBuffer().
//                        ^^^^^ definition ujson/CharSequenceParser#growBuffer().(until)
//                               ^^^ reference scala/Int#
//                                     ^^^^ reference scala/Unit#
  def readDataIntoBuffer(buffer: Array[Char], bufferOffset: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition ujson/CharSequenceParser#readDataIntoBuffer().
//                       ^^^^^^ definition ujson/CharSequenceParser#readDataIntoBuffer().(buffer)
//                               ^^^^^ reference scala/Array#
//                                     ^^^^ reference scala/Char#
//                                            ^^^^^^^^^^^^ definition ujson/CharSequenceParser#readDataIntoBuffer().(bufferOffset)
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
//          ^^^^^ definition ujson/CharSequenceParser#close().
}

object CharSequenceParser extends Transformer[CharSequence]{
//     ^^^^^^^^^^^^^^^^^^ definition ujson/CharSequenceParser.
//                                ^^^^^^^^^^^ reference ujson/Transformer#
//                                            ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                          reference java/lang/Object#`<init>`().
  def transform[T](j: CharSequence, f: Visitor[_, T]) = new CharSequenceParser(j).parse(f)
//    ^^^^^^^^^ definition ujson/CharSequenceParser.transform().
//              ^ definition ujson/CharSequenceParser.transform().[T]
//                 ^ definition ujson/CharSequenceParser.transform().(j)
//                    ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                  ^ definition ujson/CharSequenceParser.transform().(f)
//                                     ^^^^^^^ reference upickle/core/Visitor#
//                                                ^ reference ujson/CharSequenceParser.transform().[T]
//                                                          ^^^^^^^^^^^^^^^^^^ reference ujson/CharSequenceParser#
//                                                                             reference ujson/CharSequenceParser#`<init>`().
//                                                                             ^ reference ujson/CharSequenceParser.transform().(j)
//                                                                                ^^^^^ reference ujson/CharParser#parse().
//                                                                                      ^ reference ujson/CharSequenceParser.transform().(f)
}
