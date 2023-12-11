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
import java.nio.charset.StandardCharsets
//     ^^^^ reference semanticdb maven . . java/
//          ^^^ reference semanticdb maven . . java/nio/
//              ^^^^^^^ reference semanticdb maven . . java/nio/charset/
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/nio/charset/StandardCharsets#

import upickle.core.{ObjArrVisitor, Visitor}
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                   ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                  ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                  ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor.
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
//          ^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#
//                          display_name ByteArrayParser
//                          documentation ```scala\nfinal class ByteArrayParser[J]\n```
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#[J]
//                            display_name J
//                            documentation ```scala\nJ\n```
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#`<init>`().
//                              display_name <init>
//                              documentation ```scala\ndef this(src: Array[Byte])\n```
//                             ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#src.
//                                 display_name src
//                                 documentation ```scala\nprivate[this] val src: Array[Byte]\n```
//                                 relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#`<init>`().(src)
//                             ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#`<init>`().(src)
//                                 display_name src
//                                 documentation ```scala\nsrc: Array[Byte] \n```
//                                 relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#src.
//                                  ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Array#
//                                        ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Byte#
//                                                       ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteParser#
//                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#[J]
//                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteParser#`<init>`().

  val srcLength = src.length
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#srcLength.
//              display_name srcLength
//              documentation ```scala\nval srcLength: Int\n```
//                ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#src.
//                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Array#length().
  protected[this] final def close() = {}
//                          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#close().
//                                display_name close
//                                documentation ```scala\nfinal def close(): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteParser#close().

  // Never grow the buffer since it's a directly using the original
  override def growBuffer(until: Int): Unit = ()
//             ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#growBuffer().
//                        display_name growBuffer
//                        documentation ```scala\ndef growBuffer(until: Int): Unit\n```
//                        relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingByteParser#growBuffer().
//                        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#growBuffer().(until)
//                              display_name until
//                              documentation ```scala\nuntil: Int \n```
//                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                                     ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Unit#

  def readDataIntoBuffer(buffer: Array[Byte], bufferOffset: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#readDataIntoBuffer().
//                       display_name readDataIntoBuffer
//                       documentation ```scala\ndef readDataIntoBuffer(buffer: Array[Byte], bufferOffset: Int): (Array[Byte], Boolean, Int)\n```
//                       relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingByteParser#readDataIntoBuffer().
//                       ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#readDataIntoBuffer().(buffer)
//                              display_name buffer
//                              documentation ```scala\nbuffer: Array[Byte] \n```
//                               ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Array#
//                                     ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Byte#
//                                            ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#readDataIntoBuffer().(bufferOffset)
//                                                         display_name bufferOffset
//                                                         documentation ```scala\nbufferOffset: Int \n```
//                                                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
    if(buffer == null) (src, srcLength == 0, srcLength)
//     ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#readDataIntoBuffer().(buffer)
//            ^^ reference semanticdb maven jdk 11 java/lang/Object#`==`().
//                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#src.
//                           ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#srcLength.
//                                     ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`==`(+3).
//                                           ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#srcLength.
    else (src, true, -1)
//        ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#src.
  }
}

object ByteArrayParser extends Transformer[Array[Byte]]{
//     ^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser.
//                     display_name ByteArrayParser
//                     documentation ```scala\nobject ByteArrayParser\n```
//                             ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#
//                                         ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Array#
//                                               ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Byte#
//                                                     ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  def transform[T](j: Array[Byte], f: Visitor[_, T]) = new ByteArrayParser(j).parse(f)
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser.transform().
//              display_name transform
//              documentation ```scala\ndef transform(j: Array[Byte], f: Visitor[local0, T[): T\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser.transform().[T]
//                display_name T
//                documentation ```scala\nT\n```
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser.transform().(j)
//                   display_name j
//                   documentation ```scala\nj: Array[Byte] \n```
//                    ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Array#
//                          ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Byte#
//                                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser.transform().(f)
//                                   display_name f
//                                   documentation ```scala\nf: Visitor[local0, T[ \n```
//                                    ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser.transform().[T]
//                                                         ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#
//                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser#`<init>`().
//                                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser.transform().(j)
//                                                                            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteParser#parse().
//                                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser.transform().(f)
}
