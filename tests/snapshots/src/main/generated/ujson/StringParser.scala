package ujson
//      ^^^^^ definition semanticdb maven . . ujson/

import upickle.core.{ObjArrVisitor, Visitor}
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                   ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                  ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                  ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor.

/**
 * Basic in-memory string parsing.
 *
 * This is probably the simplest Parser implementation, since there is
 * no UTF-8 decoding, and the data is already fully available.
 *
 * This parser is limited to the maximum string size (~2G). Obviously
 * for large JSON documents it's better to avoid using this parser and
 * go straight from disk, to avoid having to load the whole thing into
 * memory at once. So this limit will probably not be a problem in
 * practice.
 */
private[ujson] final class StringParser[J](s: String) extends CharParser[J]{
//      ^^^^^ reference semanticdb maven . . ujson/
//                         ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#
//                                      display_name StringParser
//                                      signature_documentation scala protected[ujson] final class StringParser[J]
//                                      kind Class
//                                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#[J]
//                                        display_name J
//                                        signature_documentation scala J
//                                        kind TypeParameter
//                                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#`<init>`().
//                                          display_name <init>
//                                          signature_documentation scala def this(s: String)
//                                          kind Constructor
//                                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#s.
//                                           display_name s
//                                           signature_documentation scala private[this] val s: String
//                                           kind Method
//                                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#`<init>`().(s)
//                                         _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#`<init>`().(s)
//                                           display_name s
//                                           signature_documentation scala s: String 
//                                           kind Parameter
//                                           relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#s.
//                                            ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                            ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#
//                                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#[J]
//                                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#`<init>`().
  private[this] val sLength = s.length
//                  ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#sLength.
//                          display_name sLength
//                          signature_documentation scala private[this] val sLength: Int
//                          kind Method
//                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#s.
//                              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#length().
  override def growBuffer(until: Int): Unit = ()
//             ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#growBuffer().
//                        display_name growBuffer
//                        signature_documentation scala def growBuffer(until: Int): Unit
//                        kind Method
//                        relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#growBuffer().
//                        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#growBuffer().(until)
//                              display_name until
//                              signature_documentation scala until: Int 
//                              kind Parameter
//                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                     ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
  def readDataIntoBuffer(buffer: Array[Char], bufferOffset: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#readDataIntoBuffer().
//                       display_name readDataIntoBuffer
//                       signature_documentation scala def readDataIntoBuffer(buffer: Array[Char], bufferOffset: Int): (Array[Char], Boolean, Int)
//                       kind Method
//                       relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#readDataIntoBuffer().
//                       ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#readDataIntoBuffer().(buffer)
//                              display_name buffer
//                              signature_documentation scala buffer: Array[Char] 
//                              kind Parameter
//                               ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Array#
//                                     ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#
//                                            ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#readDataIntoBuffer().(bufferOffset)
//                                                         display_name bufferOffset
//                                                         signature_documentation scala bufferOffset: Int 
//                                                         kind Parameter
//                                                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    if(buffer == null) (s.toCharArray, sLength == 0, sLength)
//     ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#readDataIntoBuffer().(buffer)
//            ^^ reference semanticdb maven jdk 11 java/lang/Object#`==`().
//                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#s.
//                        ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/String#toCharArray().
//                                     ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#sLength.
//                                             ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`==`(+3).
//                                                   ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#sLength.
    else (buffer, true, -1)
//        ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#readDataIntoBuffer().(buffer)
  }
  final def close() = ()
//          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#close().
//                display_name close
//                signature_documentation scala final def close(): Unit
//                kind Method
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#close().
}

object StringParser extends Transformer[String]{
//     ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser.
//                  display_name StringParser
//                  signature_documentation scala object StringParser
//                  kind Object
//                          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#
//                                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                             ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  def transform[T](j: String, f: Visitor[_, T]) = new StringParser(j).parse(f)
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser.transform().
//              display_name transform
//              signature_documentation scala def transform(j: String, f: Visitor[local0, T[): T
//              kind Method
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser.transform().[T]
//                display_name T
//                signature_documentation scala T
//                kind TypeParameter
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser.transform().(j)
//                   display_name j
//                   signature_documentation scala j: String 
//                   kind Parameter
//                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser.transform().(f)
//                              display_name f
//                              signature_documentation scala f: Visitor[local0, T[ 
//                              kind Parameter
//                               ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser.transform().[T]
//                                                    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#
//                                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#`<init>`().
//                                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser.transform().(j)
//                                                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parse().
//                                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser.transform().(f)
}
