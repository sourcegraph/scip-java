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

import upickle.core.{BufferingInputStreamParser, ObjArrVisitor, Visitor}
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingInputStreamParser.
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingInputStreamParser#
//                                               ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                              ^^^^^^^ reference upickle/core/Visitor.
//                                                              ^^^^^^^ reference upickle/core/Visitor#
/**
  * Parser that reads in bytes from an InputStream, buffering them in memory
  * until a `reset` call discards them.
  *
  * Mostly the same as ByteArrayParser, except using an UberBuffer rather than
  * reading directly from an Array[Byte].
  *
  * Generally not meant to be used directly, but via [[ujson.Readable.fromReadable]]
  */
final class InputStreamParser[J](val inputStream: java.io.InputStream,
//          ^^^^^^^^^^^^^^^^^ definition ujson/InputStreamParser# final class InputStreamParser[J]
//                            ^ definition ujson/InputStreamParser#[J] J
//                               definition ujson/InputStreamParser#`<init>`(). def this(inputStream: InputStream, minBufferStartSize: Int, maxBufferStartSize: Int)
//                                   ^^^^^^^^^^^ definition ujson/InputStreamParser#inputStream. val inputStream: InputStream
//                                                ^^^^ reference java/
//                                                     ^^ reference java/io/
//                                                        ^^^^^^^^^^^ reference java/io/InputStream#
                                 val minBufferStartSize: Int = BufferingInputStreamParser.defaultMinBufferStartSize,
//                                   ^^^^^^^^^^^^^^^^^^ definition ujson/InputStreamParser#minBufferStartSize. val minBufferStartSize: Int
//                                                       ^^^ reference scala/Int#
//                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingInputStreamParser.
//                                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingInputStreamParser.defaultMinBufferStartSize.
                                 val maxBufferStartSize: Int = BufferingInputStreamParser.defaultMaxBufferStartSize)
//                                   ^^^^^^^^^^^^^^^^^^ definition ujson/InputStreamParser#maxBufferStartSize. val maxBufferStartSize: Int
//                                                       ^^^ reference scala/Int#
//                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingInputStreamParser.
//                                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingInputStreamParser.defaultMaxBufferStartSize.
extends ByteParser[J] with upickle.core.BufferingInputStreamParser{
//      ^^^^^^^^^^ reference ujson/ByteParser#
//                 ^ reference ujson/InputStreamParser#[J]
//                     reference ujson/ByteParser#`<init>`().
//                         ^^^^^^^ reference upickle/
//                                 ^^^^ reference upickle/core/
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingInputStreamParser#
  protected[this] final def close() = {}
//                          ^^^^^ definition ujson/InputStreamParser#close(). final def close(): Unit
}

object InputStreamParser extends Transformer[java.io.InputStream]{
//     ^^^^^^^^^^^^^^^^^ definition ujson/InputStreamParser. object InputStreamParser
//                               ^^^^^^^^^^^ reference ujson/Transformer#
//                                           ^^^^ reference java/
//                                                ^^ reference java/io/
//                                                   ^^^^^^^^^^^ reference java/io/InputStream#
//                                                                reference java/lang/Object#`<init>`().
  def transform[T](j: java.io.InputStream, f: Visitor[_, T]) = {
//    ^^^^^^^^^ definition ujson/InputStreamParser.transform(). def transform(j: InputStream, f: Visitor[local0, T[): T
//              ^ definition ujson/InputStreamParser.transform().[T] T
//                 ^ definition ujson/InputStreamParser.transform().(j) j: InputStream
//                    ^^^^ reference java/
//                         ^^ reference java/io/
//                            ^^^^^^^^^^^ reference java/io/InputStream#
//                                         ^ definition ujson/InputStreamParser.transform().(f) f: Visitor[local0, T[
//                                            ^^^^^^^ reference upickle/core/Visitor#
//                                                       ^ reference ujson/InputStreamParser.transform().[T]
    val p = new InputStreamParser[T](j)
//      ^ definition local1 p: InputStreamParser[T]
//              ^^^^^^^^^^^^^^^^^ reference ujson/InputStreamParser#
//                                ^ reference ujson/InputStreamParser.transform().[T]
//                                   reference ujson/InputStreamParser#`<init>`().
//                                   ^ reference ujson/InputStreamParser.transform().(j)
    p.parse(f)
//  ^ reference local1
//    ^^^^^ reference ujson/ByteParser#parse().
//          ^ reference ujson/InputStreamParser.transform().(f)
  }
}
