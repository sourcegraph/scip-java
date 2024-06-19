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
//             signature_documentation scala trait Readable
//             kind Trait
  def transform[T](f: Visitor[_, T]): T
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().
//              display_name transform
//              signature_documentation scala def transform(f: Visitor[local0, T[): T
//              kind AbstractMethod
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#transform().
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().[T]
//                display_name T
//                signature_documentation scala T
//                kind TypeParameter
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().(f)
//                   display_name f
//                   signature_documentation scala f: Visitor[local0, T[ 
//                   kind Parameter
//                    ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().[T]
//                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().[T]
}

object Readable extends ReadableLowPri{
//     ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.
//              display_name Readable
//              signature_documentation scala object Readable
//              kind Object
//                      ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#
//                                    ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  case class fromTransformer[T](t: T, w: Transformer[T]) extends Readable{
//           ^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                           display_name fromTransformer
//                           signature_documentation scala case class fromTransformer(t: T, w: Transformer[T])[T] extends Readable
//                           kind Class
//                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.
//                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().
//           _______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().
//                           display_name copy
//                           signature_documentation scala def copy(t: T, w: Transformer[T]): fromTransformer[T]
//                           kind Method
//                           relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().
//           _______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#productElement().
//                           display_name productElement
//                           signature_documentation scala def productElement(x$1: Int): Any
//                           kind Method
//                           relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().
//                           relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Product#productElement().
//           _______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().
//                           display_name apply
//                           signature_documentation scala def apply(t: T, w: Transformer[T]): fromTransformer[T]
//                           kind Method
//                           relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//           _______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.
//                           display_name fromTransformer
//                           signature_documentation scala object fromTransformer
//                           kind Object
//                           relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().
//           _______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#productElementName().
//                           display_name productElementName
//                           signature_documentation scala def productElementName(x$1: Int): String
//                           kind Method
//                           relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().
//                           relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Product#productElementName().
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#[T]
//                             display_name T
//                             signature_documentation scala T
//                             kind TypeParameter
//                             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().
//                               display_name <init>
//                               signature_documentation scala def this(t: T, w: Transformer[T])
//                               kind Constructor
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#t.
//                                display_name t
//                                signature_documentation scala val t: T
//                                kind Method
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(t)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(t)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(t)
//                              _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(t)
//                                display_name t
//                                signature_documentation scala default t: T 
//                                kind Parameter
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(t)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#t.
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(t)
//                              _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(t)
//                                display_name t
//                                signature_documentation scala t: T 
//                                kind Parameter
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(t)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#t.
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(t)
//                              _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(t)
//                                display_name t
//                                signature_documentation scala t: T 
//                                kind Parameter
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(t)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(t)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#t.
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#[T]
//                                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#w.
//                                      display_name w
//                                      signature_documentation scala val w: Transformer[T]
//                                      kind Method
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(w)
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(w)
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(w)
//                                    _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(w)
//                                      display_name w
//                                      signature_documentation scala default w: Transformer[T] 
//                                      kind Parameter
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(w)
//                                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#w.
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(w)
//                                    _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().(w)
//                                      display_name w
//                                      signature_documentation scala w: Transformer[T] 
//                                      kind Parameter
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#copy().(w)
//                                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#w.
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(w)
//                                    _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.apply().(w)
//                                      display_name w
//                                      signature_documentation scala w: Transformer[T] 
//                                      kind Parameter
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
//                signature_documentation scala def transform(f: Visitor[local1, T[): T
//                kind Method
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#transform().[T]
//                  display_name T
//                  signature_documentation scala T
//                  kind TypeParameter
//                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#transform().(f)
//                     display_name f
//                     signature_documentation scala f: Visitor[local1, T[ 
//                     kind Parameter
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
//                        signature_documentation scala implicit def fromString(s: String): fromTransformer[String]
//                        kind Method
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromString().(s)
//                          display_name s
//                          signature_documentation scala s: String 
//                          kind Parameter
//                           ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Predef.String#
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                                                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Predef.String#
//                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                                                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().
//                                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromString().(s)
//                                                                                     ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser.
  implicit def fromCharSequence(s: CharSequence): fromTransformer[CharSequence] = new fromTransformer(s, CharSequenceParser)
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromCharSequence().
//                              display_name fromCharSequence
//                              signature_documentation scala implicit def fromCharSequence(s: CharSequence): fromTransformer[CharSequence]
//                              kind Method
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromCharSequence().(s)
//                                display_name s
//                                signature_documentation scala s: CharSequence 
//                                kind Parameter
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
//                      signature_documentation scala implicit def fromPath(s: Path): Readable
//                      kind Method
//                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromPath().(s)
//                        display_name s
//                        signature_documentation scala s: Path 
//                        kind Parameter
//                         ^^^^ reference semanticdb maven . . java/
//                              ^^^ reference semanticdb maven . . java/nio/
//                                  ^^^^ reference semanticdb maven . . java/nio/file/
//                                       ^^^^ reference semanticdb maven jdk 11 java/nio/file/Path#
//                                              ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                                                             ^ definition local 3
//                                                               display_name $anon
//                                                               signature_documentation scala final class $anon
//                                                               kind Class
//                                                             ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                                                                      ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    override def transform[T](f: Visitor[_, T]) = {
//               ^^^^^^^^^ definition local 4
//                         display_name transform
//                         signature_documentation scala def transform(f: Visitor[local7, local6[): local6
//                         kind Method
//                         relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().
//                         ^ definition local 6
//                           display_name T
//                           signature_documentation scala T
//                           kind TypeParameter
//                            ^ definition local 5
//                              display_name f
//                              signature_documentation scala f: Visitor[local7, local6[ 
//                              kind Parameter
//                               ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                          ^ reference local 6
      val inputStream = java.nio.file.Files.newInputStream(s)
//        ^^^^^^^^^^^ definition local 8
//                    display_name inputStream
//                    signature_documentation scala inputStream: InputStream 
//                    kind Variable
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
//                      signature_documentation scala implicit def fromFile(s: File): Readable
//                      kind Method
//                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromFile().(s)
//                        display_name s
//                        signature_documentation scala s: File 
//                        kind Parameter
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
//                            signature_documentation scala implicit def fromByteBuffer(s: ByteBuffer): fromTransformer[ByteBuffer]
//                            kind Method
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromByteBuffer().(s)
//                              display_name s
//                              signature_documentation scala s: ByteBuffer 
//                              kind Parameter
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
//                           signature_documentation scala implicit def fromByteArray(s: Array[Byte]): fromTransformer[Array[Byte]]
//                           kind Method
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromByteArray().(s)
//                             display_name s
//                             signature_documentation scala s: Array[Byte] 
//                             kind Parameter
//                              ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Array#
//                                    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Byte#
//                                            ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                                                            ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Array#
//                                                                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Byte#
//                                                                               ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#
//                                                                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer#`<init>`().
//                                                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromByteArray().(s)
//                                                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser.
}

trait ReadableLowPri{
//    ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#
//                   display_name ReadableLowPri
//                   signature_documentation scala trait ReadableLowPri
//                   kind Trait
  implicit def fromReadable[T](s: T)(implicit conv: T => geny.Readable): Readable = new Readable{
//             ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().
//                          display_name fromReadable
//                          signature_documentation scala implicit def fromReadable(s: T)(conv: (T) => Readable): Readable
//                          kind Method
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().[T]
//                            display_name T
//                            signature_documentation scala T
//                            kind TypeParameter
//                             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().(s)
//                               display_name s
//                               signature_documentation scala s: T 
//                               kind Parameter
//                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().[T]
//                                            ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().(conv)
//                                                 display_name conv
//                                                 signature_documentation scala implicit conv: (T) => Readable 
//                                                 kind Parameter
//                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ReadableLowPri#fromReadable().[T]
//                                                       ^^^^ reference semanticdb maven . . geny/
//                                                            ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/geny_2.13 0.6.10 geny/Readable#
//                                                                       ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                                                                                      ^ definition local 9
//                                                                                        display_name $anon
//                                                                                        signature_documentation scala final class $anon
//                                                                                        kind Class
//                                                                                      ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                                                                                              ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    def transform[T](f: Visitor[_, T]): T = conv(s).readBytesThrough(InputStreamParser.transform(_, f))
//      ^^^^^^^^^ definition local 10
//                display_name transform
//                signature_documentation scala def transform(f: Visitor[local13, local12[): local12
//                kind Method
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().
//                ^ definition local 12
//                  display_name T
//                  signature_documentation scala T
//                  kind TypeParameter
//                   ^ definition local 11
//                     display_name f
//                     signature_documentation scala f: Visitor[local13, local12[ 
//                     kind Parameter
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
