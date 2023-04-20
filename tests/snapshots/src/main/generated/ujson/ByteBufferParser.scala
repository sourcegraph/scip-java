package ujson
//      ^^^^^ definition ujson/
import upickle.core.{ObjArrVisitor, Visitor}
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                   ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                  ^^^^^^^ reference upickle/core/Visitor.
//                                  ^^^^^^^ reference upickle/core/Visitor#

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
final class ByteBufferParser[J](src: ByteBuffer) extends ByteParser[J]{
//          ^^^^^^^^^^^^^^^^ definition ujson/ByteBufferParser# final class ByteBufferParser[J]
//                           ^ definition ujson/ByteBufferParser#[J] J
//                              definition ujson/ByteBufferParser#`<init>`(). def this(src: ByteBuffer)
//                              ^^^ definition ujson/ByteBufferParser#src. private[this] val src: ByteBuffer
//                                   ^^^^^^^^^^ reference java/nio/ByteBuffer#
//                                                       ^^^^^^^^^^ reference ujson/ByteParser#
//                                                                  ^ reference ujson/ByteBufferParser#[J]
//                                                                     reference ujson/ByteParser#`<init>`().
  private[this] final val start = src.position()
//                        ^^^^^ definition ujson/ByteBufferParser#start. private[this] final val start: Int
//                                ^^^ reference ujson/ByteBufferParser#src.
//                                    ^^^^^^^^ reference java/nio/Buffer#position().
  private[this] final val limit = src.limit() - start
//                        ^^^^^ definition ujson/ByteBufferParser#limit. private[this] final val limit: Int
//                                ^^^ reference ujson/ByteBufferParser#src.
//                                    ^^^^^ reference java/nio/Buffer#limit().
//                                            ^ reference scala/Int#`-`(+3).
//                                              ^^^^^ reference ujson/ByteBufferParser#start.


  protected[this] final def close() = { src.position(start) }
//                          ^^^^^ definition ujson/ByteBufferParser#close(). final def close(): Unit
//                                      ^^^ reference ujson/ByteBufferParser#src.
//                                          ^^^^^^^^ reference java/nio/ByteBuffer#position().
//                                                   ^^^^^ reference ujson/ByteBufferParser#start.
  override def growBuffer(until: Int): Unit = ()
//             ^^^^^^^^^^ definition ujson/ByteBufferParser#growBuffer(). def growBuffer(until: Int): Unit
//                        ^^^^^ definition ujson/ByteBufferParser#growBuffer().(until) until: Int
//                               ^^^ reference scala/Int#
//                                     ^^^^ reference scala/Unit#
  def readDataIntoBuffer(buffer: Array[Byte], bufferOffset: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition ujson/ByteBufferParser#readDataIntoBuffer(). def readDataIntoBuffer(buffer: Array[Byte], bufferOffset: Int): (Array[Byte], Boolean, Int)
//                       ^^^^^^ definition ujson/ByteBufferParser#readDataIntoBuffer().(buffer) buffer: Array[Byte]
//                               ^^^^^ reference scala/Array#
//                                     ^^^^ reference scala/Byte#
//                                            ^^^^^^^^^^^^ definition ujson/ByteBufferParser#readDataIntoBuffer().(bufferOffset) bufferOffset: Int
//                                                          ^^^ reference scala/Int#

    if(buffer == null) (java.util.Arrays.copyOfRange(src.array(), start, src.limit()), limit == 0, limit)
//     ^^^^^^ reference ujson/ByteBufferParser#readDataIntoBuffer().(buffer)
//            ^^ reference java/lang/Object#`==`().
//                      ^^^^ reference java/
//                           ^^^^ reference java/util/
//                                ^^^^^^ reference java/util/Arrays#
//                                       ^^^^^^^^^^^ reference java/util/Arrays#copyOfRange(+2).
//                                                   ^^^ reference ujson/ByteBufferParser#src.
//                                                       ^^^^^ reference java/nio/ByteBuffer#array().
//                                                                ^^^^^ reference ujson/ByteBufferParser#start.
//                                                                       ^^^ reference ujson/ByteBufferParser#src.
//                                                                           ^^^^^ reference java/nio/Buffer#limit().
//                                                                                     ^^^^^ reference ujson/ByteBufferParser#limit.
//                                                                                           ^^ reference scala/Int#`==`(+3).
//                                                                                                 ^^^^^ reference ujson/ByteBufferParser#limit.
    else (src.array(), true, -1)
//        ^^^ reference ujson/ByteBufferParser#src.
//            ^^^^^ reference java/nio/ByteBuffer#array().
  }
}

object ByteBufferParser extends Transformer[ByteBuffer]{
//     ^^^^^^^^^^^^^^^^ definition ujson/ByteBufferParser. object ByteBufferParser
//                              ^^^^^^^^^^^ reference ujson/Transformer#
//                                          ^^^^^^^^^^ reference java/nio/ByteBuffer#
//                                                      reference java/lang/Object#`<init>`().
  def transform[T](j: ByteBuffer, f: Visitor[_, T]) = new ByteBufferParser(j).parse(f)
//    ^^^^^^^^^ definition ujson/ByteBufferParser.transform(). def transform(j: ByteBuffer, f: Visitor[local0, T[): T
//              ^ definition ujson/ByteBufferParser.transform().[T] T
//                 ^ definition ujson/ByteBufferParser.transform().(j) j: ByteBuffer
//                    ^^^^^^^^^^ reference java/nio/ByteBuffer#
//                                ^ definition ujson/ByteBufferParser.transform().(f) f: Visitor[local0, T[
//                                   ^^^^^^^ reference upickle/core/Visitor#
//                                              ^ reference ujson/ByteBufferParser.transform().[T]
//                                                        ^^^^^^^^^^^^^^^^ reference ujson/ByteBufferParser#
//                                                                         reference ujson/ByteBufferParser#`<init>`().
//                                                                         ^ reference ujson/ByteBufferParser.transform().(j)
//                                                                            ^^^^^ reference ujson/ByteParser#parse().
//                                                                                  ^ reference ujson/ByteBufferParser.transform().(f)
}
