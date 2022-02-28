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
//          ^^^^^^^^^^^^^^^ definition ujson/ByteArrayParser# final class ByteArrayParser[J]
//                          ^ definition ujson/ByteArrayParser#[J] J
//                             definition ujson/ByteArrayParser#`<init>`(). def this(src: Array[Byte])
//                             ^^^ definition ujson/ByteArrayParser#src. private[this] val src: Array[Byte]
//                             ^^^ definition ujson/ByteArrayParser#`<init>`().(src) src: Array[Byte]
//                                  ^^^^^ reference scala/Array#
//                                        ^^^^ reference scala/Byte#
//                                                       ^^^^^^^^^^ reference ujson/ByteParser#
//                                                                  ^ reference ujson/ByteArrayParser#[J]
//                                                                     reference ujson/ByteParser#`<init>`().

  val srcLength = src.length
//    ^^^^^^^^^ definition ujson/ByteArrayParser#srcLength. val srcLength: Int
//                ^^^ reference ujson/ByteArrayParser#src.
//                    ^^^^^^ reference scala/Array#length().
  protected[this] final def close() = {}
//                          ^^^^^ definition ujson/ByteArrayParser#close(). final def close(): Unit

  // Never grow the buffer since it's a directly using the original
  override def growBuffer(until: Int): Unit = ()
//             ^^^^^^^^^^ definition ujson/ByteArrayParser#growBuffer(). def growBuffer(until: Int): Unit
//                        ^^^^^ definition ujson/ByteArrayParser#growBuffer().(until) until: Int
//                               ^^^ reference scala/Int#
//                                     ^^^^ reference scala/Unit#

  def readDataIntoBuffer(buffer: Array[Byte], bufferOffset: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition ujson/ByteArrayParser#readDataIntoBuffer(). def readDataIntoBuffer(buffer: Array[Byte], bufferOffset: Int): (Array[Byte], Boolean, Int)
//                       ^^^^^^ definition ujson/ByteArrayParser#readDataIntoBuffer().(buffer) buffer: Array[Byte]
//                               ^^^^^ reference scala/Array#
//                                     ^^^^ reference scala/Byte#
//                                            ^^^^^^^^^^^^ definition ujson/ByteArrayParser#readDataIntoBuffer().(bufferOffset) bufferOffset: Int
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
//     ^^^^^^^^^^^^^^^ definition ujson/ByteArrayParser. object ByteArrayParser
//                             ^^^^^^^^^^^ reference ujson/Transformer#
//                                         ^^^^^ reference scala/Array#
//                                               ^^^^ reference scala/Byte#
//                                                      reference java/lang/Object#`<init>`().
  def transform[T](j: Array[Byte], f: Visitor[_, T]) = new ByteArrayParser(j).parse(f)
//    ^^^^^^^^^ definition ujson/ByteArrayParser.transform(). def transform(j: Array[Byte], f: Visitor[local0, T[): T
//              ^ definition ujson/ByteArrayParser.transform().[T] T
//                 ^ definition ujson/ByteArrayParser.transform().(j) j: Array[Byte]
//                    ^^^^^ reference scala/Array#
//                          ^^^^ reference scala/Byte#
//                                 ^ definition ujson/ByteArrayParser.transform().(f) f: Visitor[local0, T[
//                                    ^^^^^^^ reference upickle/core/Visitor#
//                                               ^ reference ujson/ByteArrayParser.transform().[T]
//                                                         ^^^^^^^^^^^^^^^ reference ujson/ByteArrayParser#
//                                                                         reference ujson/ByteArrayParser#`<init>`().
//                                                                         ^ reference ujson/ByteArrayParser.transform().(j)
//                                                                            ^^^^^ reference ujson/ByteParser#parse().
//                                                                                  ^ reference ujson/ByteArrayParser.transform().(f)
}
