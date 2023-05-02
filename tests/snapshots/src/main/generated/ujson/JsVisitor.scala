package ujson
//      ^^^^^ definition semanticdb maven . . ujson/

import upickle.core.{ArrVisitor, ObjVisitor, Visitor}
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                   ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#
//                               ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#
//                                           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor.

/**
  * A [[Visitor]] specialized to work with JSON types. Forwards the
  * not-JSON-related methods to their JSON equivalents.
  */
trait JsVisitor[-T, +J] extends Visitor[T, J]{
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#
//              documentation ```scala\ntrait JsVisitor[T, J]\n```
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[T]
//                 documentation ```scala\nT\n```
//                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
//                     documentation ```scala\nJ\n```
//                              ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[T]
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
  def visitFloat64(d: Double, index: Int): J = {
//    ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                 documentation ```scala\ndef visitFloat64(d: Double, index: Int): J\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64().
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64().
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64().
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64().
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().(d)
//                   documentation ```scala\nd: Double \n```
//                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                            ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().(index)
//                                  documentation ```scala\nindex: Int \n```
//                                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
    val i = d.toLong
//      ^ definition local 0
//        documentation ```scala\ni: Long \n```
//          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().(d)
//            ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#toLong().
    if(i == d) visitFloat64StringParts(i.toString, -1, -1, index)
//     ^ reference local 0
//       ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Long#`==`(+6).
//          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().(d)
//             ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64StringParts().
//                                     ^ reference local 0
//                                       ^^^^^^^^ reference semanticdb maven . . scala/Any#toString().
//                                                         ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().(index)
    else visitFloat64String(d.toString, index)
//       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64String().
//                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().(d)
//                            ^^^^^^^^ reference semanticdb maven . . scala/Any#toString().
//                                      ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().(index)

  }

  def visitFloat32(d: Float, index: Int): J = visitFloat64(d, index)
//    ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat32().
//                 documentation ```scala\ndef visitFloat32(d: Float, index: Int): J\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat32().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat32().(d)
//                   documentation ```scala\nd: Float \n```
//                    ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Float#
//                           ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat32().(index)
//                                 documentation ```scala\nindex: Int \n```
//                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
//                                            ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat32().(d)
//                                                            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat32().(index)
  def visitInt32(i: Int, index: Int): J = visitFloat64(i, index)
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt32().
//               documentation ```scala\ndef visitInt32(i: Int, index: Int): J\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitInt32().
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt32().(i)
//                 documentation ```scala\ni: Int \n```
//                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                       ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt32().(index)
//                             documentation ```scala\nindex: Int \n```
//                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
//                                        ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt32().(i)
//                                                        ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt32().(index)
  def visitInt64(i: Long, index: Int): J = {
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt64().
//               documentation ```scala\ndef visitInt64(i: Long, index: Int): J\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitInt64().
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt64().(i)
//                 documentation ```scala\ni: Long \n```
//                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Long#
//                        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt64().(index)
//                              documentation ```scala\nindex: Int \n```
//                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
    if (math.abs(i) > math.pow(2, 53) || i == -9223372036854775808L) visitString(i.toString, index)
//      ^^^^ reference semanticdb maven . . scala/math/
//           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/math/package.abs(+1).
//               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt64().(i)
//                  ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Long#`>`(+6).
//                    ^^^^ reference semanticdb maven . . scala/math/
//                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/math/package.pow().
//                                    ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`||`().
//                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt64().(i)
//                                         ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Long#`==`(+4).
//                                                                   ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt64().(i)
//                                                                                 ^^^^^^^^ reference semanticdb maven . . scala/Any#toString().
//                                                                                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt64().(index)
    else visitFloat64(i, index)
//       ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt64().(i)
//                       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt64().(index)
  }
  def visitUInt64(i: Long, index: Int): J = {
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitUInt64().
//                documentation ```scala\ndef visitUInt64(i: Long, index: Int): J\n```
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitUInt64().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitUInt64().(i)
//                  documentation ```scala\ni: Long \n```
//                   ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Long#
//                         ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitUInt64().(index)
//                               documentation ```scala\nindex: Int \n```
//                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
    if (i > math.pow(2, 53) || i < 0) visitString(java.lang.Long.toUnsignedString(i), index)
//      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitUInt64().(i)
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Long#`>`(+6).
//          ^^^^ reference semanticdb maven . . scala/math/
//               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/math/package.pow().
//                          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`||`().
//                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitUInt64().(i)
//                               ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Long#`<`(+3).
//                                    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                                ^^^^ reference semanticdb maven . . java/
//                                                     ^^^^ reference semanticdb maven . . java/lang/
//                                                          ^^^^ reference semanticdb maven jdk 11 java/lang/Long#
//                                                               ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Long#toUnsignedString(+1).
//                                                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitUInt64().(i)
//                                                                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitUInt64().(index)
    else visitFloat64(i, index)
//       ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitUInt64().(i)
//                       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitUInt64().(index)
  }

  def visitFloat64String(s: String, index: Int): J = {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64String().
//                       documentation ```scala\ndef visitFloat64String(s: String, index: Int): J\n```
//                       relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64String().
//                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64String().(s)
//                         documentation ```scala\ns: String \n```
//                          ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                  ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64String().(index)
//                                        documentation ```scala\nindex: Int \n```
//                                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
    visitFloat64StringParts(
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64StringParts().
      s,
//    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64String().(s)
      s.indexOf('.'),
//    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64String().(s)
//      ^^^^^^^ reference semanticdb maven jdk 11 java/lang/String#indexOf().
      s.indexOf('E') match{
//    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64String().(s)
//      ^^^^^^^ reference semanticdb maven jdk 11 java/lang/String#indexOf().
        case -1 => s.indexOf('e')
//                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64String().(s)
//                   ^^^^^^^ reference semanticdb maven jdk 11 java/lang/String#indexOf().
        case n => n
//           ^ definition local 1
//             documentation ```scala\nn: Int \n```
//                ^ reference local 1
      },
      -1
    )
  }

  def visitBinary(bytes: Array[Byte], offset: Int, len: Int, index: Int): J = {
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().
//                documentation ```scala\ndef visitBinary(bytes: Array[Byte], offset: Int, len: Int, index: Int): J\n```
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitBinary().
//                ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(bytes)
//                      documentation ```scala\nbytes: Array[Byte] \n```
//                       ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Array#
//                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Byte#
//                                    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(offset)
//                                           documentation ```scala\noffset: Int \n```
//                                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                 ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(len)
//                                                     documentation ```scala\nlen: Int \n```
//                                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                           ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(index)
//                                                                 documentation ```scala\nindex: Int \n```
//                                                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
    val arr = visitArray(len, index)
//      ^^^ definition local 2
//          documentation ```scala\narr: ArrVisitor[T, J] \n```
//            ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//                       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(len)
//                            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(index)
    var i = 0
//      ^ definition local 3
//        documentation ```scala\ni: Int \n```
    while (i < len){
//         ^ reference local 3
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`<`(+3).
//             ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(len)
      arr.visitValue(arr.subVisitor.visitInt32(bytes(offset + i), index).asInstanceOf[T], index)
//    ^^^ reference local 2
//        ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                   ^^^ reference local 2
//                       ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                                  ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitInt32().
//                                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(bytes)
//                                                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(offset)
//                                                          ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                            ^ reference local 3
//                                                                ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(index)
//                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . scala/Any#asInstanceOf().
//                                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[T]
//                                                                                        ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(index)
      i += 1
//    ^ reference local 3
//      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
    }
    arr.visitEnd(index)
//  ^^^ reference local 2
//      ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//               ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(index)
  }

  def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int): J = visitFloat64StringParts(s, decIndex, expIndex, -1)
//    ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().
//                            documentation ```scala\ndef visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int): J\n```
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().(s)
//                              documentation ```scala\ns: CharSequence \n```
//                               ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                             ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().(decIndex)
//                                                      documentation ```scala\ndecIndex: Int \n```
//                                                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                            ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().(expIndex)
//                                                                     documentation ```scala\nexpIndex: Int \n```
//                                                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
//                                                                                ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64StringParts().
//                                                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().(s)
//                                                                                                           ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().(decIndex)
//                                                                                                                     ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().(expIndex)

  def visitExt(tag: Byte, bytes: Array[Byte], offset: Int, len: Int, index: Int): J = {
//    ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().
//             documentation ```scala\ndef visitExt(tag: Byte, bytes: Array[Byte], offset: Int, len: Int, index: Int): J\n```
//             relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitExt().
//             ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(tag)
//                 documentation ```scala\ntag: Byte \n```
//                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Byte#
//                        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(bytes)
//                              documentation ```scala\nbytes: Array[Byte] \n```
//                               ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Array#
//                                     ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Byte#
//                                            ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(offset)
//                                                   documentation ```scala\noffset: Int \n```
//                                                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                         ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(len)
//                                                             documentation ```scala\nlen: Int \n```
//                                                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                   ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(index)
//                                                                         documentation ```scala\nindex: Int \n```
//                                                                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
    val arr = visitArray(-1, index)
//      ^^^ definition local 5
//          documentation ```scala\narr: ArrVisitor[T, J] \n```
//            ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(index)
    arr.visitValue(visitFloat64(tag, index).asInstanceOf[T], -1)
//  ^^^ reference local 5
//      ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                 ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                              ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(tag)
//                                   ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(index)
//                                          ^^^^^^^^^^^^ reference semanticdb maven . . scala/Any#asInstanceOf().
//                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[T]
    arr.visitValue(visitBinary(bytes, offset, len, index).asInstanceOf[T], -1)
//  ^^^ reference local 5
//      ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                 ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().
//                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(bytes)
//                                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(offset)
//                                            ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(len)
//                                                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(index)
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . scala/Any#asInstanceOf().
//                                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[T]
    arr.visitEnd(-1)
//  ^^^ reference local 5
//      ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
  }

  def visitChar(s: Char, index: Int) = visitString(s.toString, index)
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitChar().
//              documentation ```scala\ndef visitChar(s: Char, index: Int): J\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitChar().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitChar().(s)
//                documentation ```scala\ns: Char \n```
//                 ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#
//                       ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitChar().(index)
//                             documentation ```scala\nindex: Int \n```
//                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitChar().(s)
//                                                   ^^^^^^^^ reference semanticdb maven . . scala/Any#toString().
//                                                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitChar().(index)
}
