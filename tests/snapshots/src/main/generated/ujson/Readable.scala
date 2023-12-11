package ujson
//      ^^^^^ definition semanticdb maven . . ujson/

import java.nio.ByteBuffer
//     ^^^^ reference semanticdb maven . . java/
//          ^^^ reference semanticdb maven . . java/nio/
//              ^^^^^^^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#
import java.nio.channels.ReadableByteChannel
//     ^^^^ reference semanticdb maven . . java/
//          ^^^ reference semanticdb maven . . java/nio/
//              ^^^^^^^^ reference semanticdb maven . . java/nio/channels/
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/nio/channels/ReadableByteChannel#
import upickle.core.{Visitor, ObjArrVisitor}
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                   ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                   ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor.
//                            ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
trait Readable {
//    ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//             display_name Readable
//             documentation ```scala\ntrait Readable\n```
  def transform[T](f: Visitor[_, T]): T
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().
//              display_name transform
//              documentation ```scala\ndef transform(f: Visitor[local0, T[): T\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#transform().
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().[T]
//                display_name T
//                documentation ```scala\nT\n```
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().(f)
//                   display_name f
//                   documentation ```scala\nf: Visitor[local0, T[ \n```
//                    ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().[T]
//                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().[T]
}

object Readable extends ReadableLowPri{
//     ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.
//              display_name Readable
//              documentation ```scala\nobject Readable\n```
//                      ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#
//                                    ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  case class fromTransformer[T](t: T, w: Transformer[T]) extends Readable{
//           ^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                           display_name fromTransformer
//                           documentation ```scala\ncase class fromTransformer(t: T, w: Transformer[T])[T] extends Readable\n```
//                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.
//                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().
//           _______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().
//                           display_name copy
//                           documentation ```scala\ndef copy(t: T, w: Transformer[T]): fromTransformer[T]\n```
//                           relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().
//           _______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#productElement().
//                           display_name productElement
//                           documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                           relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().
//                           relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//           _______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().
//                           display_name apply
//                           documentation ```scala\ndef apply(t: T, w: Transformer[T]): fromTransformer[T]\n```
//                           relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//           _______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.
//                           display_name fromTransformer
//                           documentation ```scala\nobject fromTransformer\n```
//                           relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().
//           _______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#productElementName().
//                           display_name productElementName
//                           documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                           relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().
//                           relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#[T]
//                             display_name T
//                             documentation ```scala\nT\n```
//                             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().
//                               display_name <init>
//                               documentation ```scala\ndef this(t: T, w: Transformer[T])\n```
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#t.
//                                display_name t
//                                documentation ```scala\nval t: T\n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(t)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(t)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(t)
//                              _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(t)
//                                display_name t
//                                documentation ```scala\ndefault t: T \n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(t)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#t.
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(t)
//                              _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(t)
//                                display_name t
//                                documentation ```scala\nt: T \n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(t)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#t.
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(t)
//                              _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(t)
//                                display_name t
//                                documentation ```scala\nt: T \n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(t)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(t)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#t.
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#[T]
//                                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#w.
//                                      display_name w
//                                      documentation ```scala\nval w: Transformer[T]\n```
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(w)
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(w)
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(w)
//                                    _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(w)
//                                      display_name w
//                                      documentation ```scala\ndefault w: Transformer[T] \n```
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(w)
//                                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#w.
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(w)
//                                    _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(w)
//                                      display_name w
//                                      documentation ```scala\nw: Transformer[T] \n```
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(w)
//                                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#w.
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(w)
//                                    _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(w)
//                                      display_name w
//                                      documentation ```scala\nw: Transformer[T] \n```
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(w)
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(w)
//                                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#w.
//                                       ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#
//                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#[T]
//                                                               ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                                                                       ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    def transform[T](f: Visitor[_, T]): T = {
//      ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#transform().
//                display_name transform
//                documentation ```scala\ndef transform(f: Visitor[local1, T[): T\n```
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#transform().[T]
//                  display_name T
//                  documentation ```scala\nT\n```
//                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#transform().(f)
//                     display_name f
//                     documentation ```scala\nf: Visitor[local1, T[ \n```
//                      ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#transform().[T]
//                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#transform().[T]
      w.transform(t, f)
//    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#w.
//      ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#t.
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#transform().(f)
    }
  }
  implicit def fromString(s: String): fromTransformer[String] = new fromTransformer(s, StringParser)
//             ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromString().
//                        display_name fromString
//                        documentation ```scala\nimplicit def fromString(s: String): fromTransformer[String]\n```
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromString().(s)
//                          display_name s
//                          documentation ```scala\ns: String \n```
//                           ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                                                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                                                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().
//                                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromString().(s)
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser.
  implicit def fromCharSequence(s: CharSequence): fromTransformer[CharSequence] = new fromTransformer(s, CharSequenceParser)
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromCharSequence().
//                              display_name fromCharSequence
//                              documentation ```scala\nimplicit def fromCharSequence(s: CharSequence): fromTransformer[CharSequence]\n```
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromCharSequence().(s)
//                                display_name s
//                                documentation ```scala\ns: CharSequence \n```
//                                 ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                                ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                                                                ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                                                                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().
//                                                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromCharSequence().(s)
//                                                                                                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser.
  implicit def fromPath(s: java.nio.file.Path): Readable = new Readable {
//             ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromPath().
//                      display_name fromPath
//                      documentation ```scala\nimplicit def fromPath(s: Path): Readable\n```
//                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromPath().(s)
//                        display_name s
//                        documentation ```scala\ns: Path \n```
//                         ^^^^ reference semanticdb maven . . java/
//                              ^^^ reference semanticdb maven . . java/nio/
//                                  ^^^^ reference semanticdb maven . . java/nio/file/
//                                       ^^^^ reference semanticdb maven jdk 11 java/nio/file/Path#
//                                              ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                                                             ^ definition local 3
//                                                               display_name $anon
//                                                               documentation ```scala\nfinal class $anon\n```
//                                                             ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                                                                      ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    override def transform[T](f: Visitor[_, T]) = {
//               ^^^^^^^^^ definition local 4
//                         display_name transform
//                         documentation ```scala\ndef transform(f: Visitor[local7, local6[): local6\n```
//                         relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().
//                         ^ definition local 6
//                           display_name T
//                           documentation ```scala\nT\n```
//                            ^ definition local 5
//                              display_name f
//                              documentation ```scala\nf: Visitor[local7, local6[ \n```
//                               ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                          ^ reference local 6
      val inputStream = java.nio.file.Files.newInputStream(s)
//        ^^^^^^^^^^^ definition local 8
//                    display_name inputStream
//                    documentation ```scala\ninputStream: InputStream \n```
//                      ^^^^ reference semanticdb maven . . java/
//                           ^^^ reference semanticdb maven . . java/nio/
//                               ^^^^ reference semanticdb maven . . java/nio/file/
//                                    ^^^^^ reference semanticdb maven jdk 11 java/nio/file/Files#
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/nio/file/Files#newInputStream().
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromPath().(s)
      try InputStreamParser.transform(inputStream, f)
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.
//                          ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.transform().
//                                    ^^^^^^^^^^^ reference local 8
//                                                 ^ reference local 5
      finally inputStream.close()
//            ^^^^^^^^^^^ reference local 8
//                        ^^^^^ reference semanticdb maven jdk 11 java/io/InputStream#close().
    }
  }
  implicit def fromFile(s: java.io.File): Readable = fromPath(s.toPath)
//             ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromFile().
//                      display_name fromFile
//                      documentation ```scala\nimplicit def fromFile(s: File): Readable\n```
//                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromFile().(s)
//                        display_name s
//                        documentation ```scala\ns: File \n```
//                         ^^^^ reference semanticdb maven . . java/
//                              ^^ reference semanticdb maven . . java/io/
//                                 ^^^^ reference semanticdb maven jdk 11 java/io/File#
//                                        ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                                                   ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromPath().
//                                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromFile().(s)
//                                                              ^^^^^^ reference semanticdb maven jdk 11 java/io/File#toPath().
  implicit def fromByteBuffer(s: ByteBuffer): fromTransformer[ByteBuffer] = new fromTransformer(s, ByteBufferParser)
//             ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromByteBuffer().
//                            display_name fromByteBuffer
//                            documentation ```scala\nimplicit def fromByteBuffer(s: ByteBuffer): fromTransformer[ByteBuffer]\n```
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromByteBuffer().(s)
//                              display_name s
//                              documentation ```scala\ns: ByteBuffer \n```
//                               ^^^^^^^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#
//                                            ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                                                            ^^^^^^^^^^ reference semanticdb maven jdk 11 java/nio/ByteBuffer#
//                                                                              ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                                                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().
//                                                                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromByteBuffer().(s)
//                                                                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteBufferParser.
  implicit def fromByteArray(s: Array[Byte]): fromTransformer[Array[Byte]] = new fromTransformer(s, ByteArrayParser)
//             ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromByteArray().
//                           display_name fromByteArray
//                           documentation ```scala\nimplicit def fromByteArray(s: Array[Byte]): fromTransformer[Array[Byte]]\n```
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromByteArray().(s)
//                             display_name s
//                             documentation ```scala\ns: Array[Byte] \n```
//                              ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Array#
//                                    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Byte#
//                                            ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                                                            ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Array#
//                                                                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Byte#
//                                                                               ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                                                                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().
//                                                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromByteArray().(s)
//                                                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser.
}

trait ReadableLowPri{
//    ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#
//                   display_name ReadableLowPri
//                   documentation ```scala\ntrait ReadableLowPri\n```
  implicit def fromReadable[T](s: T)(implicit conv: T => geny.Readable): Readable = new Readable{
//             ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().
//                          display_name fromReadable
//                          documentation ```scala\nimplicit def fromReadable(s: T)(conv: (T) => Readable): Readable\n```
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().[T]
//                            display_name T
//                            documentation ```scala\nT\n```
//                             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().(s)
//                               display_name s
//                               documentation ```scala\ns: T \n```
//                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().[T]
//                                            ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().(conv)
//                                                 display_name conv
//                                                 documentation ```scala\nimplicit conv: (T) => Readable \n```
//                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().[T]
//                                                       ^^^^ reference semanticdb maven . . geny/
//                                                            ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/geny_2.13 0.6.10 geny/Readable#
//                                                                       ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                                                                                      ^ definition local 9
//                                                                                        display_name $anon
//                                                                                        documentation ```scala\nfinal class $anon\n```
//                                                                                      ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                                                                                              ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    def transform[T](f: Visitor[_, T]): T = conv(s).readBytesThrough(InputStreamParser.transform(_, f))
//      ^^^^^^^^^ definition local 10
//                display_name transform
//                documentation ```scala\ndef transform(f: Visitor[local13, local12[): local12\n```
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().
//                ^ definition local 12
//                  display_name T
//                  documentation ```scala\nT\n```
//                   ^ definition local 11
//                     display_name f
//                     documentation ```scala\nf: Visitor[local13, local12[ \n```
//                      ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                 ^ reference local 12
//                                      ^ reference local 12
//                                          ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().(conv)
//                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().(s)
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/geny_2.13 0.6.10 geny/Readable#readBytesThrough().
//                                                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.
//                                                                                     ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.transform().
//                                                                                                  ^ reference local 11
  }
}
