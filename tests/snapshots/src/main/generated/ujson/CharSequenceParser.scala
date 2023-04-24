package ujson
//      ^^^^^ definition semanticdb maven . . ujson/

import upickle.core.{ObjArrVisitor, Visitor}
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                   ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                  ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                  ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor.
/**
 * Lazy character sequence parsing.
 *
 * This is similar to StringParser, but acts on character sequences.
 */
private[ujson] final class CharSequenceParser[J](cs: CharSequence) extends CharParser[J]{
//      ^^^^^ reference semanticdb maven . . ujson/
//                         ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#
//                                            documentation ```scala\nprotected[ujson] final class CharSequenceParser[J]\n```
//                                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#[J]
//                                              documentation ```scala\nJ\n```
//                                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#`<init>`().
//                                                documentation ```scala\ndef this(cs: CharSequence)\n```
//                                               ^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#cs.
//                                                  documentation ```scala\nprivate[this] val cs: CharSequence\n```
//                                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#`<init>`().(cs)
//                                               __ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#`<init>`().(cs)
//                                                  documentation ```scala\ncs: CharSequence \n```
//                                                  relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#cs.
//                                                   ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                                                         ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#
//                                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#[J]
//                                                                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#`<init>`().
  override def growBuffer(until: Int): Unit = ()
//             ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#growBuffer().
//                        documentation ```scala\ndef growBuffer(until: Int): Unit\n```
//                        relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#growBuffer().
//                        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#growBuffer().(until)
//                              documentation ```scala\nuntil: Int \n```
//                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                     ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
  def readDataIntoBuffer(buffer: Array[Char], bufferOffset: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#readDataIntoBuffer().
//                       documentation ```scala\ndef readDataIntoBuffer(buffer: Array[Char], bufferOffset: Int): (Array[Char], Boolean, Int)\n```
//                       relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#readDataIntoBuffer().
//                       ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#readDataIntoBuffer().(buffer)
//                              documentation ```scala\nbuffer: Array[Char] \n```
//                               ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Array#
//                                     ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#
//                                            ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#readDataIntoBuffer().(bufferOffset)
//                                                         documentation ```scala\nbufferOffset: Int \n```
//                                                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    if(buffer == null) (cs.toString.toCharArray, cs.length == 0, cs.length)
//     ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#readDataIntoBuffer().(buffer)
//            ^^ reference semanticdb maven jdk 11 java/lang/Object#`==`().
//                      ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#cs.
//                         ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#toString().
//                                  ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/String#toCharArray().
//                                               ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#cs.
//                                                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#length().
//                                                         ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`==`(+3).
//                                                               ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#cs.
//                                                                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#length().
    else (buffer, true, -1)
//        ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#readDataIntoBuffer().(buffer)
  }
  final def close() = ()
//          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#close().
//                documentation ```scala\nfinal def close(): Unit\n```
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#close().
}

object CharSequenceParser extends Transformer[CharSequence]{
//     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser.
//                        documentation ```scala\nobject CharSequenceParser\n```
//                                ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#
//                                            ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                                         ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  def transform[T](j: CharSequence, f: Visitor[_, T]) = new CharSequenceParser(j).parse(f)
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser.transform().
//              documentation ```scala\ndef transform(j: CharSequence, f: Visitor[local0, T[): T\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser.transform().[T]
//                documentation ```scala\nT\n```
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser.transform().(j)
//                   documentation ```scala\nj: CharSequence \n```
//                    ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                  ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser.transform().(f)
//                                    documentation ```scala\nf: Visitor[local0, T[ \n```
//                                     ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser.transform().[T]
//                                                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#
//                                                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#`<init>`().
//                                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser.transform().(j)
//                                                                                ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parse().
//                                                                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser.transform().(f)
}
