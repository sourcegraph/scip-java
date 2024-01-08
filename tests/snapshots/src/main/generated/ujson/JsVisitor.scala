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
//              display_name JsVisitor
//              signature_documentation scala trait JsVisitor[T, J]
//              kind Trait
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[T]
//                 display_name T
//                 signature_documentation scala T
//                 kind TypeParameter
//                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
//                     display_name J
//                     signature_documentation scala J
//                     kind TypeParameter
//                              ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[T]
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
  def visitFloat64(d: Double, index: Int): J = {
//    ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                 display_name visitFloat64
//                 signature_documentation scala def visitFloat64(d: Double, index: Int): J
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64().
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64().
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.Builder.visitFloat64().
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64().
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().(d)
//                   display_name d
//                   signature_documentation scala d: Double 
//                   kind Parameter
//                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                            ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().(index)
//                                  display_name index
//                                  signature_documentation scala index: Int 
//                                  kind Parameter
//                                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
    val i = d.toLong
//      ^ definition local 0
//        display_name i
//        signature_documentation scala i: Long 
//        kind Variable
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
//                 display_name visitFloat32
//                 signature_documentation scala def visitFloat32(d: Float, index: Int): J
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat32().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat32().(d)
//                   display_name d
//                   signature_documentation scala d: Float 
//                   kind Parameter
//                    ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Float#
//                           ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat32().(index)
//                                 display_name index
//                                 signature_documentation scala index: Int 
//                                 kind Parameter
//                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
//                                            ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat32().(d)
//                                                            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat32().(index)
  def visitInt32(i: Int, index: Int): J = visitFloat64(i, index)
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt32().
//               display_name visitInt32
//               signature_documentation scala def visitInt32(i: Int, index: Int): J
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitInt32().
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt32().(i)
//                 display_name i
//                 signature_documentation scala i: Int 
//                 kind Parameter
//                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                       ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt32().(index)
//                             display_name index
//                             signature_documentation scala index: Int 
//                             kind Parameter
//                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
//                                        ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt32().(i)
//                                                        ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt32().(index)
  def visitInt64(i: Long, index: Int): J = {
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt64().
//               display_name visitInt64
//               signature_documentation scala def visitInt64(i: Long, index: Int): J
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitInt64().
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt64().(i)
//                 display_name i
//                 signature_documentation scala i: Long 
//                 kind Parameter
//                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Long#
//                        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitInt64().(index)
//                              display_name index
//                              signature_documentation scala index: Int 
//                              kind Parameter
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
//                display_name visitUInt64
//                signature_documentation scala def visitUInt64(i: Long, index: Int): J
//                kind Method
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitUInt64().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitUInt64().(i)
//                  display_name i
//                  signature_documentation scala i: Long 
//                  kind Parameter
//                   ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Long#
//                         ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitUInt64().(index)
//                               display_name index
//                               signature_documentation scala index: Int 
//                               kind Parameter
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
//                       display_name visitFloat64String
//                       signature_documentation scala def visitFloat64String(s: String, index: Int): J
//                       kind Method
//                       relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64String().
//                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64String().(s)
//                         display_name s
//                         signature_documentation scala s: String 
//                         kind Parameter
//                          ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                  ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64String().(index)
//                                        display_name index
//                                        signature_documentation scala index: Int 
//                                        kind Parameter
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
//             display_name n
//             signature_documentation scala n: Int 
//             kind Variable
//                ^ reference local 1
      },
      -1
    )
  }

  def visitBinary(bytes: Array[Byte], offset: Int, len: Int, index: Int): J = {
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().
//                display_name visitBinary
//                signature_documentation scala def visitBinary(bytes: Array[Byte], offset: Int, len: Int, index: Int): J
//                kind Method
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitBinary().
//                ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(bytes)
//                      display_name bytes
//                      signature_documentation scala bytes: Array[Byte] 
//                      kind Parameter
//                       ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Array#
//                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Byte#
//                                    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(offset)
//                                           display_name offset
//                                           signature_documentation scala offset: Int 
//                                           kind Parameter
//                                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                 ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(len)
//                                                     display_name len
//                                                     signature_documentation scala len: Int 
//                                                     kind Parameter
//                                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                           ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(index)
//                                                                 display_name index
//                                                                 signature_documentation scala index: Int 
//                                                                 kind Parameter
//                                                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
    val arr = visitArray(len, index)
//      ^^^ definition local 2
//          display_name arr
//          signature_documentation scala arr: ArrVisitor[T, J] 
//          kind Variable
//            ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//                       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(len)
//                            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitBinary().(index)
    var i = 0
//      ^ definition local 3
//        display_name i
//        signature_documentation scala i: Int 
//        kind Variable
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
//                            display_name visitFloat64StringParts
//                            signature_documentation scala def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int): J
//                            kind Method
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().(s)
//                              display_name s
//                              signature_documentation scala s: CharSequence 
//                              kind Parameter
//                               ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                             ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().(decIndex)
//                                                      display_name decIndex
//                                                      signature_documentation scala decIndex: Int 
//                                                      kind Parameter
//                                                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                            ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().(expIndex)
//                                                                     display_name expIndex
//                                                                     signature_documentation scala expIndex: Int 
//                                                                     kind Parameter
//                                                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
//                                                                                ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64StringParts().
//                                                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().(s)
//                                                                                                           ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().(decIndex)
//                                                                                                                     ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64StringParts().(expIndex)

  def visitExt(tag: Byte, bytes: Array[Byte], offset: Int, len: Int, index: Int): J = {
//    ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().
//             display_name visitExt
//             signature_documentation scala def visitExt(tag: Byte, bytes: Array[Byte], offset: Int, len: Int, index: Int): J
//             kind Method
//             relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitExt().
//             ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(tag)
//                 display_name tag
//                 signature_documentation scala tag: Byte 
//                 kind Parameter
//                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Byte#
//                        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(bytes)
//                              display_name bytes
//                              signature_documentation scala bytes: Array[Byte] 
//                              kind Parameter
//                               ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Array#
//                                     ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Byte#
//                                            ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(offset)
//                                                   display_name offset
//                                                   signature_documentation scala offset: Int 
//                                                   kind Parameter
//                                                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                         ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(len)
//                                                             display_name len
//                                                             signature_documentation scala len: Int 
//                                                             kind Parameter
//                                                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                   ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitExt().(index)
//                                                                         display_name index
//                                                                         signature_documentation scala index: Int 
//                                                                         kind Parameter
//                                                                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#[J]
    val arr = visitArray(-1, index)
//      ^^^ definition local 5
//          display_name arr
//          signature_documentation scala arr: ArrVisitor[T, J] 
//          kind Variable
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
//              display_name visitChar
//              signature_documentation scala def visitChar(s: Char, index: Int): J
//              kind Method
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitChar().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitChar().(s)
//                display_name s
//                signature_documentation scala s: Char 
//                kind Parameter
//                 ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#
//                       ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitChar().(index)
//                             display_name index
//                             signature_documentation scala index: Int 
//                             kind Parameter
//                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitChar().(s)
//                                                   ^^^^^^^^ reference semanticdb maven . . scala/Any#toString().
//                                                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitChar().(index)
}
