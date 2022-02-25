package ujson
//      ^^^^^ definition ujson/

import java.nio.ByteBuffer
//     ^^^^ reference java/
//          ^^^ reference java/nio/
//              ^^^^^^^^^^ reference java/nio/ByteBuffer#
import java.nio.channels.ReadableByteChannel
//     ^^^^ reference java/
//          ^^^ reference java/nio/
//              ^^^^^^^^ reference java/nio/channels/
//                       ^^^^^^^^^^^^^^^^^^^ reference java/nio/channels/ReadableByteChannel#
import upickle.core.{Visitor, ObjArrVisitor}
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                   ^^^^^^^ reference upickle/core/Visitor.
//                   ^^^^^^^ reference upickle/core/Visitor#
//                            ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
trait Readable {
//    ^^^^^^^^ definition ujson/Readable# trait Readable
  def transform[T](f: Visitor[_, T]): T
//    ^^^^^^^^^ definition ujson/Readable#transform(). def transform(f: Visitor[local0, T[): T
//              ^ definition ujson/Readable#transform().[T] T
//                 ^ definition ujson/Readable#transform().(f) f: Visitor[local0, T[
//                    ^^^^^^^ reference upickle/core/Visitor#
//                               ^ reference ujson/Readable#transform().[T]
//                                    ^ reference ujson/Readable#transform().[T]
}

object Readable extends ReadableLowPri{
//     ^^^^^^^^ definition ujson/Readable. object Readable
//                      ^^^^^^^^^^^^^^ reference ujson/ReadableLowPri#
//                                     reference java/lang/Object#`<init>`().
  case class fromTransformer[T](t: T, w: Transformer[T]) extends Readable{
//           ^^^^^^^^^^^^^^^ definition ujson/Readable.fromTransformer# case class fromTransformer(t: T, w: Transformer[T])[T] extends Readable
//           ^^^^^^^^^^^^^^^ synthetic_definition ujson/Readable.fromTransformer#copy(). def copy(t: T, w: Transformer[T]): fromTransformer[T]
//           ^^^^^^^^^^^^^^^ synthetic_definition ujson/Readable.fromTransformer#productElement(). def productElement(x$1: Int): Any
//           ^^^^^^^^^^^^^^^ synthetic_definition ujson/Readable.fromTransformer.apply(). def apply(t: T, w: Transformer[T]): fromTransformer[T]
//           ^^^^^^^^^^^^^^^ definition ujson/Readable.fromTransformer. object fromTransformer
//           ^^^^^^^^^^^^^^^ synthetic_definition ujson/Readable.fromTransformer#productElementName(). def productElementName(x$1: Int): String
//                           ^ definition ujson/Readable.fromTransformer#[T] T
//                              definition ujson/Readable.fromTransformer#`<init>`(). def this(t: T, w: Transformer[T])
//                              ^ definition ujson/Readable.fromTransformer#t. val t: T
//                              ^ definition ujson/Readable.fromTransformer#copy().(t) default t: T
//                              ^ definition ujson/Readable.fromTransformer#`<init>`().(t) t: T
//                              ^ definition ujson/Readable.fromTransformer.apply().(t) t: T
//                                 ^ reference ujson/Readable.fromTransformer#[T]
//                                    ^ definition ujson/Readable.fromTransformer#w. val w: Transformer[T]
//                                    ^ definition ujson/Readable.fromTransformer#copy().(w) default w: Transformer[T]
//                                    ^ definition ujson/Readable.fromTransformer#`<init>`().(w) w: Transformer[T]
//                                    ^ definition ujson/Readable.fromTransformer.apply().(w) w: Transformer[T]
//                                       ^^^^^^^^^^^ reference ujson/Transformer#
//                                                   ^ reference ujson/Readable.fromTransformer#[T]
//                                                               ^^^^^^^^ reference ujson/Readable#
//                                                                        reference java/lang/Object#`<init>`().
    def transform[T](f: Visitor[_, T]): T = {
//      ^^^^^^^^^ definition ujson/Readable.fromTransformer#transform(). def transform(f: Visitor[local1, T[): T
//                ^ definition ujson/Readable.fromTransformer#transform().[T] T
//                   ^ definition ujson/Readable.fromTransformer#transform().(f) f: Visitor[local1, T[
//                      ^^^^^^^ reference upickle/core/Visitor#
//                                 ^ reference ujson/Readable.fromTransformer#transform().[T]
//                                      ^ reference ujson/Readable.fromTransformer#transform().[T]
      w.transform(t, f)
//    ^ reference ujson/Readable.fromTransformer#w.
//      ^^^^^^^^^ reference ujson/Transformer#transform().
//                ^ reference ujson/Readable.fromTransformer#t.
//                   ^ reference ujson/Readable.fromTransformer#transform().(f)
    }
  }
  implicit def fromString(s: String): fromTransformer[String] = new fromTransformer(s, StringParser)
//             ^^^^^^^^^^ definition ujson/Readable.fromString(). implicit def fromString(s: String): fromTransformer[String]
//                        ^ definition ujson/Readable.fromString().(s) s: String
//                           ^^^^^^ reference scala/Predef.String#
//                                    ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                    ^^^^^^ reference scala/Predef.String#
//                                                                  ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                                                  reference ujson/Readable.fromTransformer#`<init>`().
//                                                                                  ^ reference ujson/Readable.fromString().(s)
//                                                                                     ^^^^^^^^^^^^ reference ujson/StringParser.
  implicit def fromCharSequence(s: CharSequence): fromTransformer[CharSequence] = new fromTransformer(s, CharSequenceParser)
//             ^^^^^^^^^^^^^^^^ definition ujson/Readable.fromCharSequence(). implicit def fromCharSequence(s: CharSequence): fromTransformer[CharSequence]
//                              ^ definition ujson/Readable.fromCharSequence().(s) s: CharSequence
//                                 ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                                ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                                                    ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                                                                    reference ujson/Readable.fromTransformer#`<init>`().
//                                                                                                    ^ reference ujson/Readable.fromCharSequence().(s)
//                                                                                                       ^^^^^^^^^^^^^^^^^^ reference ujson/CharSequenceParser.
  implicit def fromPath(s: java.nio.file.Path): Readable = new Readable {
//             ^^^^^^^^ definition ujson/Readable.fromPath(). implicit def fromPath(s: Path): Readable
//                      ^ definition ujson/Readable.fromPath().(s) s: Path
//                         ^^^^ reference java/
//                              ^^^ reference java/nio/
//                                  ^^^^ reference java/nio/file/
//                                       ^^^^ reference java/nio/file/Path#
//                                              ^^^^^^^^ reference ujson/Readable#
//                                                              definition local3 final class $anon
//                                                             ^^^^^^^^ reference ujson/Readable#
//                                                                       reference java/lang/Object#`<init>`().
    override def transform[T](f: Visitor[_, T]) = {
//               ^^^^^^^^^ definition local4 def transform(f: Visitor[local7, local6[): local6
//                         ^ definition local6 T
//                            ^ definition local5 f: Visitor[local7, local6[
//                               ^^^^^^^ reference upickle/core/Visitor#
//                                          ^ reference local6
      val inputStream = java.nio.file.Files.newInputStream(s)
//        ^^^^^^^^^^^ definition local8 inputStream: InputStream
//                      ^^^^ reference java/
//                           ^^^ reference java/nio/
//                               ^^^^ reference java/nio/file/
//                                    ^^^^^ reference java/nio/file/Files#
//                                          ^^^^^^^^^^^^^^ reference java/nio/file/Files#newInputStream().
//                                                         ^ reference ujson/Readable.fromPath().(s)
      try InputStreamParser.transform(inputStream, f)
//        ^^^^^^^^^^^^^^^^^ reference ujson/InputStreamParser.
//                          ^^^^^^^^^ reference ujson/InputStreamParser.transform().
//                                    ^^^^^^^^^^^ reference local8
//                                                 ^ reference local5
      finally inputStream.close()
//            ^^^^^^^^^^^ reference local8
//                        ^^^^^ reference java/io/InputStream#close().
    }
  }
  implicit def fromFile(s: java.io.File): Readable = fromPath(s.toPath)
//             ^^^^^^^^ definition ujson/Readable.fromFile(). implicit def fromFile(s: File): Readable
//                      ^ definition ujson/Readable.fromFile().(s) s: File
//                         ^^^^ reference java/
//                              ^^ reference java/io/
//                                 ^^^^ reference java/io/File#
//                                        ^^^^^^^^ reference ujson/Readable#
//                                                   ^^^^^^^^ reference ujson/Readable.fromPath().
//                                                            ^ reference ujson/Readable.fromFile().(s)
//                                                              ^^^^^^ reference java/io/File#toPath().
  implicit def fromByteBuffer(s: ByteBuffer): fromTransformer[ByteBuffer] = new fromTransformer(s, ByteBufferParser)
//             ^^^^^^^^^^^^^^ definition ujson/Readable.fromByteBuffer(). implicit def fromByteBuffer(s: ByteBuffer): fromTransformer[ByteBuffer]
//                            ^ definition ujson/Readable.fromByteBuffer().(s) s: ByteBuffer
//                               ^^^^^^^^^^ reference java/nio/ByteBuffer#
//                                            ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                            ^^^^^^^^^^ reference java/nio/ByteBuffer#
//                                                                              ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                                                              reference ujson/Readable.fromTransformer#`<init>`().
//                                                                                              ^ reference ujson/Readable.fromByteBuffer().(s)
//                                                                                                 ^^^^^^^^^^^^^^^^ reference ujson/ByteBufferParser.
  implicit def fromByteArray(s: Array[Byte]): fromTransformer[Array[Byte]] = new fromTransformer(s, ByteArrayParser)
//             ^^^^^^^^^^^^^ definition ujson/Readable.fromByteArray(). implicit def fromByteArray(s: Array[Byte]): fromTransformer[Array[Byte]]
//                           ^ definition ujson/Readable.fromByteArray().(s) s: Array[Byte]
//                              ^^^^^ reference scala/Array#
//                                    ^^^^ reference scala/Byte#
//                                            ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                            ^^^^^ reference scala/Array#
//                                                                  ^^^^ reference scala/Byte#
//                                                                               ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                                                               reference ujson/Readable.fromTransformer#`<init>`().
//                                                                                               ^ reference ujson/Readable.fromByteArray().(s)
//                                                                                                  ^^^^^^^^^^^^^^^ reference ujson/ByteArrayParser.
}

trait ReadableLowPri{
//    ^^^^^^^^^^^^^^ definition ujson/ReadableLowPri# trait ReadableLowPri
  implicit def fromReadable[T](s: T)(implicit conv: T => geny.Readable): Readable = new Readable{
//             ^^^^^^^^^^^^ definition ujson/ReadableLowPri#fromReadable(). implicit def fromReadable(s: T)(conv: (T) => Readable): Readable
//                          ^ definition ujson/ReadableLowPri#fromReadable().[T] T
//                             ^ definition ujson/ReadableLowPri#fromReadable().(s) s: T
//                                ^ reference ujson/ReadableLowPri#fromReadable().[T]
//                                            ^^^^ definition ujson/ReadableLowPri#fromReadable().(conv) implicit conv: (T) => Readable
//                                                  ^ reference ujson/ReadableLowPri#fromReadable().[T]
//                                                       ^^^^ reference geny/
//                                                            ^^^^^^^^ reference geny/Readable#
//                                                                       ^^^^^^^^ reference ujson/Readable#
//                                                                                       definition local9 final class $anon
//                                                                                      ^^^^^^^^ reference ujson/Readable#
//                                                                                               reference java/lang/Object#`<init>`().
    def transform[T](f: Visitor[_, T]): T = conv(s).readBytesThrough(InputStreamParser.transform(_, f))
//      ^^^^^^^^^ definition local10 def transform(f: Visitor[local13, local12[): local12
//                ^ definition local12 T
//                   ^ definition local11 f: Visitor[local13, local12[
//                      ^^^^^^^ reference upickle/core/Visitor#
//                                 ^ reference local12
//                                      ^ reference local12
//                                          ^^^^ reference ujson/ReadableLowPri#fromReadable().(conv)
//                                               ^ reference ujson/ReadableLowPri#fromReadable().(s)
//                                                  ^^^^^^^^^^^^^^^^ reference geny/Readable#readBytesThrough().
//                                                                   ^^^^^^^^^^^^^^^^^ reference ujson/InputStreamParser.
//                                                                                     ^^^^^^^^^ reference ujson/InputStreamParser.transform().
//                                                                                                  ^ reference local11
  }
}
