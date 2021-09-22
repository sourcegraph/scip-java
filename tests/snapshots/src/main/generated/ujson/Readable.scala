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
//    ^^^^^^^^ definition ujson/Readable#
  def transform[T](f: Visitor[_, T]): T
//    ^^^^^^^^^ definition ujson/Readable#transform().
//              ^ definition ujson/Readable#transform().[T]
//                 ^ definition ujson/Readable#transform().(f)
//                    ^^^^^^^ reference upickle/core/Visitor#
//                               ^ reference ujson/Readable#transform().[T]
//                                    ^ reference ujson/Readable#transform().[T]
}

object Readable extends ReadableLowPri{
//     ^^^^^^^^ definition ujson/Readable.
//                      ^^^^^^^^^^^^^^ reference ujson/ReadableLowPri#
//                                     reference java/lang/Object#`<init>`().
  case class fromTransformer[T](t: T, w: Transformer[T]) extends Readable{
//           ^^^^^^^^^^^^^^^ definition ujson/Readable.fromTransformer#
//                           ^ definition ujson/Readable.fromTransformer#[T]
//                              definition ujson/Readable.fromTransformer#`<init>`().
//                              ^ definition ujson/Readable.fromTransformer#t.
//                                 ^ reference ujson/Readable.fromTransformer#[T]
//                                    ^ definition ujson/Readable.fromTransformer#w.
//                                       ^^^^^^^^^^^ reference ujson/Transformer#
//                                                   ^ reference ujson/Readable.fromTransformer#[T]
//                                                               ^^^^^^^^ reference ujson/Readable#
//                                                                        reference java/lang/Object#`<init>`().
    def transform[T](f: Visitor[_, T]): T = {
//      ^^^^^^^^^ definition ujson/Readable.fromTransformer#transform().
//                ^ definition ujson/Readable.fromTransformer#transform().[T]
//                   ^ definition ujson/Readable.fromTransformer#transform().(f)
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
//             ^^^^^^^^^^ definition ujson/Readable.fromString().
//                        ^ definition ujson/Readable.fromString().(s)
//                           ^^^^^^ reference scala/Predef.String#
//                                    ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                    ^^^^^^ reference scala/Predef.String#
//                                                                  ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                                                  reference ujson/Readable.fromTransformer#`<init>`().
//                                                                                  ^ reference ujson/Readable.fromString().(s)
//                                                                                     ^^^^^^^^^^^^ reference ujson/StringParser.
  implicit def fromCharSequence(s: CharSequence): fromTransformer[CharSequence] = new fromTransformer(s, CharSequenceParser)
//             ^^^^^^^^^^^^^^^^ definition ujson/Readable.fromCharSequence().
//                              ^ definition ujson/Readable.fromCharSequence().(s)
//                                 ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                                ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                                                    ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                                                                    reference ujson/Readable.fromTransformer#`<init>`().
//                                                                                                    ^ reference ujson/Readable.fromCharSequence().(s)
//                                                                                                       ^^^^^^^^^^^^^^^^^^ reference ujson/CharSequenceParser.
  implicit def fromPath(s: java.nio.file.Path): Readable = new Readable {
//             ^^^^^^^^ definition ujson/Readable.fromPath().
//                      ^ definition ujson/Readable.fromPath().(s)
//                         ^^^^ reference java/
//                              ^^^ reference java/nio/
//                                  ^^^^ reference java/nio/file/
//                                       ^^^^ reference java/nio/file/Path#
//                                              ^^^^^^^^ reference ujson/Readable#
//                                                             ^^^^^^^^ reference ujson/Readable#
//                                                                       reference java/lang/Object#`<init>`().
    override def transform[T](f: Visitor[_, T]) = {
//               ^^^^^^^^^ definition local0
//                         ^ definition local1
//                            ^ definition local2
//                               ^^^^^^^ reference upickle/core/Visitor#
//                                          ^ reference local1
      val inputStream = java.nio.file.Files.newInputStream(s)
//        ^^^^^^^^^^^ definition local3
//                      ^^^^ reference java/
//                           ^^^ reference java/nio/
//                               ^^^^ reference java/nio/file/
//                                    ^^^^^ reference java/nio/file/Files#
//                                          ^^^^^^^^^^^^^^ reference java/nio/file/Files#newInputStream().
//                                                         ^ reference ujson/Readable.fromPath().(s)
      try InputStreamParser.transform(inputStream, f)
//        ^^^^^^^^^^^^^^^^^ reference ujson/InputStreamParser.
//                          ^^^^^^^^^ reference ujson/InputStreamParser.transform().
//                                    ^^^^^^^^^^^ reference local3
//                                                 ^ reference local2
      finally inputStream.close()
//            ^^^^^^^^^^^ reference local3
//                        ^^^^^ reference java/io/InputStream#close().
    }
  }
  implicit def fromFile(s: java.io.File): Readable = fromPath(s.toPath)
//             ^^^^^^^^ definition ujson/Readable.fromFile().
//                      ^ definition ujson/Readable.fromFile().(s)
//                         ^^^^ reference java/
//                              ^^ reference java/io/
//                                 ^^^^ reference java/io/File#
//                                        ^^^^^^^^ reference ujson/Readable#
//                                                   ^^^^^^^^ reference ujson/Readable.fromPath().
//                                                            ^ reference ujson/Readable.fromFile().(s)
//                                                              ^^^^^^ reference java/io/File#toPath().
  implicit def fromByteBuffer(s: ByteBuffer): fromTransformer[ByteBuffer] = new fromTransformer(s, ByteBufferParser)
//             ^^^^^^^^^^^^^^ definition ujson/Readable.fromByteBuffer().
//                            ^ definition ujson/Readable.fromByteBuffer().(s)
//                               ^^^^^^^^^^ reference java/nio/ByteBuffer#
//                                            ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                            ^^^^^^^^^^ reference java/nio/ByteBuffer#
//                                                                              ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer#
//                                                                                              reference ujson/Readable.fromTransformer#`<init>`().
//                                                                                              ^ reference ujson/Readable.fromByteBuffer().(s)
//                                                                                                 ^^^^^^^^^^^^^^^^ reference ujson/ByteBufferParser.
  implicit def fromByteArray(s: Array[Byte]): fromTransformer[Array[Byte]] = new fromTransformer(s, ByteArrayParser)
//             ^^^^^^^^^^^^^ definition ujson/Readable.fromByteArray().
//                           ^ definition ujson/Readable.fromByteArray().(s)
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
//    ^^^^^^^^^^^^^^ definition ujson/ReadableLowPri#
  implicit def fromReadable[T](s: T)(implicit conv: T => geny.Readable): Readable = new Readable{
//             ^^^^^^^^^^^^ definition ujson/ReadableLowPri#fromReadable().
//                          ^ definition ujson/ReadableLowPri#fromReadable().[T]
//                             ^ definition ujson/ReadableLowPri#fromReadable().(s)
//                                ^ reference ujson/ReadableLowPri#fromReadable().[T]
//                                            ^^^^ definition ujson/ReadableLowPri#fromReadable().(conv)
//                                                  ^ reference ujson/ReadableLowPri#fromReadable().[T]
//                                                       ^^^^ reference geny/
//                                                            ^^^^^^^^ reference geny/Readable#
//                                                                       ^^^^^^^^ reference ujson/Readable#
//                                                                                      ^^^^^^^^ reference ujson/Readable#
//                                                                                               reference java/lang/Object#`<init>`().
    def transform[T](f: Visitor[_, T]): T = conv(s).readBytesThrough(InputStreamParser.transform(_, f))
//      ^^^^^^^^^ definition local4
//                ^ definition local5
//                   ^ definition local6
//                      ^^^^^^^ reference upickle/core/Visitor#
//                                 ^ reference local5
//                                      ^ reference local5
//                                          ^^^^ reference ujson/ReadableLowPri#fromReadable().(conv)
//                                               reference scala/Function1#apply().
//                                               ^ reference ujson/ReadableLowPri#fromReadable().(s)
//                                                  ^^^^^^^^^^^^^^^^ reference geny/Readable#readBytesThrough().
//                                                                   ^^^^^^^^^^^^^^^^^ reference ujson/InputStreamParser.
//                                                                                     ^^^^^^^^^ reference ujson/InputStreamParser.transform().
//                                                                                                  ^ reference local6
  }
}
