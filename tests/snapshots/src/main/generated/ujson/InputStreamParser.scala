package ujson
//      ^^^^^ definition semanticdb maven . . ujson/

import scala.annotation.{switch, tailrec}
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^^^ reference semanticdb maven . . scala/annotation/
//                       ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/annotation/switch#
//                               ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/annotation/tailrec#
import java.nio.ByteBuffer
//     ^^^^ reference semanticdb maven . . java/
//          ^^^ reference semanticdb maven . . java/nio/
//              ^^^^^^^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#

import upickle.core.{BufferingInputStreamParser, ObjArrVisitor, Visitor}
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingInputStreamParser#
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingInputStreamParser.
//                                               ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                              ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                              ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor.
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
//          ^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#
//                            display_name InputStreamParser
//                            documentation ```scala\nfinal class InputStreamParser[J]\n```
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#[J]
//                              display_name J
//                              documentation ```scala\nJ\n```
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#`<init>`().
//                                display_name <init>
//                                documentation ```scala\ndef this(inputStream: InputStream, minBufferStartSize: Int, maxBufferStartSize: Int)\n```
//                                   ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#inputStream.
//                                               display_name inputStream
//                                               documentation ```scala\nval inputStream: InputStream\n```
//                                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#`<init>`().(inputStream)
//                                               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingInputStreamParser#inputStream().
//                                   ___________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#`<init>`().(inputStream)
//                                               display_name inputStream
//                                               documentation ```scala\ninputStream: InputStream \n```
//                                               relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#inputStream.
//                                                ^^^^ reference semanticdb maven . . java/
//                                                     ^^ reference semanticdb maven . . java/io/
//                                                        ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/InputStream#
                                 val minBufferStartSize: Int = BufferingInputStreamParser.defaultMinBufferStartSize,
//                                   ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#minBufferStartSize.
//                                                      display_name minBufferStartSize
//                                                      documentation ```scala\nval minBufferStartSize: Int\n```
//                                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#`<init>`().(minBufferStartSize)
//                                                      relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingInputStreamParser#minBufferStartSize().
//                                   __________________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#`<init>`().(minBufferStartSize)
//                                                      display_name minBufferStartSize
//                                                      documentation ```scala\ndefault minBufferStartSize: Int \n```
//                                                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#minBufferStartSize.
//                                                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingInputStreamParser.
//                                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingInputStreamParser.defaultMinBufferStartSize.
                                 val maxBufferStartSize: Int = BufferingInputStreamParser.defaultMaxBufferStartSize)
//                                   ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#maxBufferStartSize.
//                                                      display_name maxBufferStartSize
//                                                      documentation ```scala\nval maxBufferStartSize: Int\n```
//                                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#`<init>`().(maxBufferStartSize)
//                                                      relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingInputStreamParser#maxBufferStartSize().
//                                   __________________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#`<init>`().(maxBufferStartSize)
//                                                      display_name maxBufferStartSize
//                                                      documentation ```scala\ndefault maxBufferStartSize: Int \n```
//                                                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#maxBufferStartSize.
//                                                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingInputStreamParser.
//                                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingInputStreamParser.defaultMaxBufferStartSize.
extends ByteParser[J] with upickle.core.BufferingInputStreamParser{
//      ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteParser#
//                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#[J]
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteParser#`<init>`().
//                         ^^^^^^^ reference semanticdb maven . . upickle/
//                                 ^^^^ reference semanticdb maven . . upickle/core/
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingInputStreamParser#
  protected[this] final def close() = {}
//                          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#close().
//                                display_name close
//                                documentation ```scala\nfinal def close(): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteParser#close().
}

object InputStreamParser extends Transformer[java.io.InputStream]{
//     ^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.
//                       display_name InputStreamParser
//                       documentation ```scala\nobject InputStreamParser\n```
//                               ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#
//                                           ^^^^ reference semanticdb maven . . java/
//                                                ^^ reference semanticdb maven . . java/io/
//                                                   ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/InputStream#
//                                                               ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  def transform[T](j: java.io.InputStream, f: Visitor[_, T]) = {
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.transform().
//              display_name transform
//              documentation ```scala\ndef transform(j: InputStream, f: Visitor[local0, T[): T\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.transform().[T]
//                display_name T
//                documentation ```scala\nT\n```
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.transform().(j)
//                   display_name j
//                   documentation ```scala\nj: InputStream \n```
//                    ^^^^ reference semanticdb maven . . java/
//                         ^^ reference semanticdb maven . . java/io/
//                            ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/InputStream#
//                                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.transform().(f)
//                                           display_name f
//                                           documentation ```scala\nf: Visitor[local0, T[ \n```
//                                            ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.transform().[T]
    val p = new InputStreamParser[T](j)
//      ^ definition local 1
//        display_name p
//        documentation ```scala\np: InputStreamParser[T] \n```
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#
//                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.transform().[T]
//                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser#`<init>`().
//                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.transform().(j)
    p.parse(f)
//  ^ reference local 1
//    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteParser#parse().
//          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.transform().(f)
  }
}
