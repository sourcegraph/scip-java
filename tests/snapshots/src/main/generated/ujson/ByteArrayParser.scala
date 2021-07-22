package ujson
//      ^^^^^ definition ujson/

import scala.annotation.{switch, tailrec}
//     ^^^^^ reference scala/
//           ^^^^^^^^^^ reference scala/annotation/
//                       ^^^^^^ reference scala/annotation/switch#
//                               ^^^^^^^ reference scala/annotation/tailrec#
import java.nio.ByteBuffer
//     ^^^^ reference java/
//          ^^^ reference java/nio/
//              ^^^^^^^^^^ reference java/nio/ByteBuffer#
import java.nio.charset.StandardCharsets
//     ^^^^ reference java/
//          ^^^ reference java/nio/
//              ^^^^^^^ reference java/nio/charset/
//                      ^^^^^^^^^^^^^^^^ reference java/nio/charset/StandardCharsets#

import upickle.core.{ObjArrVisitor, Visitor}
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                   ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                  ^^^^^^^ reference upickle/core/Visitor.
//                                  ^^^^^^^ reference upickle/core/Visitor#
/**
  * Basic ByteBuffer parser.
  *
  * This assumes that the provided ByteBuffer is ready to be read. The
  * user is responsible for any necessary flipping/resetting of the
  * ByteBuffer before parsing.
  *
  * The parser makes absolute calls to the ByteBuffer, which will not
  * update its own mutable position fields.
  */
final class ByteArrayParser[J](src: Array[Byte]) extends ByteParser[J]{
//          ^^^^^^^^^^^^^^^ definition ujson/ByteArrayParser#
//                          ^ definition ujson/ByteArrayParser#[J]
//                             definition ujson/ByteArrayParser#`<init>`().
//                             ^^^ definition ujson/ByteArrayParser#src.
//                                  ^^^^^ reference scala/Array#
//                                        ^^^^ reference scala/Byte#
//                                                       ^^^^^^^^^^ reference ujson/ByteParser#
//                                                                  ^ reference ujson/ByteArrayParser#[J]
//                                                                     reference ujson/ByteParser#`<init>`().

  val srcLength = src.length
//    ^^^^^^^^^ definition ujson/ByteArrayParser#srcLength.
//                ^^^ reference ujson/ByteArrayParser#src.
//                    ^^^^^^ reference scala/Array#length().
  protected[this] final def close() = {}
//                          ^^^^^ definition ujson/ByteArrayParser#close().

  // Never grow the buffer since it's a directly using the original
  override def growBuffer(until: Int): Unit = ()
//             ^^^^^^^^^^ definition ujson/ByteArrayParser#growBuffer().
//                        ^^^^^ definition ujson/ByteArrayParser#growBuffer().(until)
//                               ^^^ reference scala/Int#
//                                     ^^^^ reference scala/Unit#

  def readDataIntoBuffer(buffer: Array[Byte], bufferOffset: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition ujson/ByteArrayParser#readDataIntoBuffer().
//                       ^^^^^^ definition ujson/ByteArrayParser#readDataIntoBuffer().(buffer)
//                               ^^^^^ reference scala/Array#
//                                     ^^^^ reference scala/Byte#
//                                            ^^^^^^^^^^^^ definition ujson/ByteArrayParser#readDataIntoBuffer().(bufferOffset)
//                                                          ^^^ reference scala/Int#
    if(buffer == null) (src, srcLength == 0, srcLength)
//     ^^^^^^ reference ujson/ByteArrayParser#readDataIntoBuffer().(buffer)
//            ^^ reference java/lang/Object#`==`().
//                      ^^^ reference ujson/ByteArrayParser#src.
//                           ^^^^^^^^^ reference ujson/ByteArrayParser#srcLength.
//                                     ^^ reference scala/Int#`==`(+3).
//                                           ^^^^^^^^^ reference ujson/ByteArrayParser#srcLength.
    else (src, true, -1)
//        ^^^ reference ujson/ByteArrayParser#src.
  }
}

object ByteArrayParser extends Transformer[Array[Byte]]{
//     ^^^^^^^^^^^^^^^ definition ujson/ByteArrayParser.
//                             ^^^^^^^^^^^ reference ujson/Transformer#
//                                         ^^^^^ reference scala/Array#
//                                               ^^^^ reference scala/Byte#
//                                                      reference java/lang/Object#`<init>`().
  def transform[T](j: Array[Byte], f: Visitor[_, T]) = new ByteArrayParser(j).parse(f)
//    ^^^^^^^^^ definition ujson/ByteArrayParser.transform().
//              ^ definition ujson/ByteArrayParser.transform().[T]
//                 ^ definition ujson/ByteArrayParser.transform().(j)
//                    ^^^^^ reference scala/Array#
//                          ^^^^ reference scala/Byte#
//                                 ^ definition ujson/ByteArrayParser.transform().(f)
//                                    ^^^^^^^ reference upickle/core/Visitor#
//                                               ^ reference ujson/ByteArrayParser.transform().[T]
//                                                         ^^^^^^^^^^^^^^^ reference ujson/ByteArrayParser#
//                                                                         reference ujson/ByteArrayParser#`<init>`().
//                                                                         ^ reference ujson/ByteArrayParser.transform().(j)
//                                                                            ^^^^^ reference ujson/ByteParser#parse().
//                                                                                  ^ reference ujson/ByteArrayParser.transform().(f)
}
