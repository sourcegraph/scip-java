package ujson
//      ^^^^^ definition semanticdb maven . . ujson/



import upickle.core.Util
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                  ^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Util.
import upickle.core.{ObjArrVisitor, Visitor}
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                   ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                  ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                  ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor.

import upickle.core.compat._
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                  ^^^^^^ reference semanticdb maven . . upickle/core/compat/
import scala.collection.mutable
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^^^ reference semanticdb maven . . scala/collection/
//                      ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
import scala.collection.mutable.ArrayBuffer
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^^^ reference semanticdb maven . . scala/collection/
//                      ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                              ^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/ArrayBuffer#
//                              ^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/ArrayBuffer.

sealed trait Value extends Readable with geny.Writable{
//           ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                 display_name Value
//                 signature_documentation scala sealed trait Value
//                 kind Trait
//                         ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                                       ^^^^ reference semanticdb maven . . geny/
//                                            ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/geny_2.13 0.6.10 geny/Writable#
  override def httpContentType = Some("application/json")
//             ^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#httpContentType().
//                             display_name httpContentType
//                             signature_documentation scala def httpContentType: Some[String]
//                             kind Method
//                             relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/geny_2.13 0.6.10 geny/Writable#httpContentType().
//                               ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Some.
  def value: Any
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
//          display_name value
//          signature_documentation scala def value: Any
//          kind AbstractMethod
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#value.
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#value().
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.value().
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.value().
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#value.
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#value.
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#value.
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.value().
//           ^^^ reference semanticdb maven . . scala/Any#

  /**
    * Returns the `String` value of this [[Value]], fails if it is not
    * a [[ujson.Str]]
    */
  def str = this match{
//    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#str().
//        display_name str
//        signature_documentation scala def str: String
//        kind Method
    case ujson.Str(value) => value
//       ^^^^^ reference semanticdb maven . . ujson/
//             ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.
//                 ^^^^^ definition local 0
//                       display_name value
//                       signature_documentation scala value: String 
//                       kind Variable
//                           ^^^^^ reference local 0
    case _ => throw Value.InvalidData(this, "Expected ujson.Str")
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.
  }

  /**
    * Returns an Optional `String` value of this [[Value]] in case this [[Value]] is a 'String'.
    */
  def strOpt = this match{
//    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#strOpt().
//           display_name strOpt
//           signature_documentation scala def strOpt: Option[String]
//           kind Method
    case Str(value) => Some(value)
//       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.
//           ^^^^^ definition local 1
//                 display_name value
//                 signature_documentation scala value: String 
//                 kind Variable
//                     ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Some.
//                          ^^^^^ reference local 1
    case _ => None
//            ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/None.
  }

  /**
    * Returns the key/value map of this [[Value]], fails if it is not
    * a [[ujson.Obj]]
    */
  def obj = this match{
//    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#obj().
//        display_name obj
//        signature_documentation scala def obj: LinkedHashMap[String, Value]
//        kind Method
    case ujson.Obj(value) => value
//       ^^^^^ reference semanticdb maven . . ujson/
//             ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
//                 ^^^^^ definition local 2
//                       display_name value
//                       signature_documentation scala value: LinkedHashMap[String, Value] 
//                       kind Variable
//                           ^^^^^ reference local 2
    case _ => throw Value.InvalidData(this, "Expected ujson.Obj")
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.
  }
  /**
    * Returns an Optional key/value map of this [[Value]] in case this [[Value]] is a 'Obj'.
    */
  def objOpt = this match{
//    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#objOpt().
//           display_name objOpt
//           signature_documentation scala def objOpt: Option[LinkedHashMap[String, Value]]
//           kind Method
    case Obj(value) => Some(value)
//       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
//           ^^^^^ definition local 3
//                 display_name value
//                 signature_documentation scala value: LinkedHashMap[String, Value] 
//                 kind Variable
//                     ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Some.
//                          ^^^^^ reference local 3
    case _ => None
//            ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/None.
  }
  /**
    * Returns the elements of this [[Value]], fails if it is not
    * a [[ujson.Arr]]
    */
  def arr = this match{
//    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#arr().
//        display_name arr
//        signature_documentation scala def arr: ArrayBuffer[Value]
//        kind Method
    case ujson.Arr(value) => value
//       ^^^^^ reference semanticdb maven . . ujson/
//             ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
//                 ^^^^^ definition local 4
//                       display_name value
//                       signature_documentation scala value: ArrayBuffer[Value] 
//                       kind Variable
//                           ^^^^^ reference local 4
    case _ => throw Value.InvalidData(this, "Expected ujson.Arr")
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.
  }
  /**
    * Returns The optional elements of this [[Value]] in case this [[Value]] is a 'Arr'.
    */
  def arrOpt = this match{
//    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#arrOpt().
//           display_name arrOpt
//           signature_documentation scala def arrOpt: Option[ArrayBuffer[Value]]
//           kind Method
    case Arr(value) => Some(value)
//       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
//           ^^^^^ definition local 5
//                 display_name value
//                 signature_documentation scala value: ArrayBuffer[Value] 
//                 kind Variable
//                     ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Some.
//                          ^^^^^ reference local 5
    case _ => None
//            ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/None.
  }
  /**
    * Returns the `Double` value of this [[Value]], fails if it is not
    * a [[ujson.Num]]
    */
  def num = this match{
//    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#num().
//        display_name num
//        signature_documentation scala def num: Double
//        kind Method
    case ujson.Num(value) => value
//       ^^^^^ reference semanticdb maven . . ujson/
//             ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
//                 ^^^^^ definition local 6
//                       display_name value
//                       signature_documentation scala value: Double 
//                       kind Variable
//                           ^^^^^ reference local 6
    case _ => throw Value.InvalidData(this, "Expected ujson.Num")
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.
  }
  /**
    * Returns an Option[Double] in case this [[Value]] is a 'Num'.
    */
  def numOpt = this match{
//    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#numOpt().
//           display_name numOpt
//           signature_documentation scala def numOpt: Option[Double]
//           kind Method
    case Num(value) => Some(value)
//       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
//           ^^^^^ definition local 7
//                 display_name value
//                 signature_documentation scala value: Double 
//                 kind Variable
//                     ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Some.
//                          ^^^^^ reference local 7
    case _ => None
//            ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/None.
  }
  /**
    * Returns the `Boolean` value of this [[Value]], fails if it is not
    * a [[ujson.Bool]]
    */
  def bool = this match{
//    ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#bool().
//         display_name bool
//         signature_documentation scala def bool: Boolean
//         kind Method
    case ujson.Bool(value) => value
//       ^^^^^ reference semanticdb maven . . ujson/
//             ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.
//                  ^^^^^ definition local 8
//                        display_name value
//                        signature_documentation scala value: Boolean 
//                        kind Variable
//                            ^^^^^ reference local 8
    case _ => throw Value.InvalidData(this, "Expected ujson.Bool")
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.
  }
  /**
    * Returns an Optional `Boolean` value of this [[Value]] in case this [[Value]] is a 'Bool'.
    */
  def boolOpt = this match{
//    ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#boolOpt().
//            display_name boolOpt
//            signature_documentation scala def boolOpt: Option[Boolean]
//            kind Method
    case Bool(value) => Some(value)
//       ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.
//            ^^^^^ definition local 9
//                  display_name value
//                  signature_documentation scala value: Boolean 
//                  kind Variable
//                      ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Some.
//                           ^^^^^ reference local 9
    case _ => None
//            ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/None.
  }
  /**
    * Returns true if the value of this [[Value]] is ujson.Null, false otherwise
    */
  def isNull = this match {
//    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#isNull().
//           display_name isNull
//           signature_documentation scala def isNull: Boolean
//           kind Method
    case ujson.Null => true
//       ^^^^^ reference semanticdb maven . . ujson/
//             ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.
    case _ => false
  }

  def apply(s: Value.Selector): Value = s(this)
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#apply().
//          display_name apply
//          signature_documentation scala def apply(s: Selector): Value
//          kind Method
//          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#apply().(s)
//            display_name s
//            signature_documentation scala s: Selector 
//            kind Parameter
//             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                   ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#
//                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#apply().(s)
  def update(s: Value.Selector, v: Value): Unit = s(this) = v
//    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update().
//           display_name update
//           signature_documentation scala def update(s: Selector, v: Value): Unit
//           kind Method
//           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update().(s)
//             display_name s
//             signature_documentation scala s: Selector 
//             kind Parameter
//              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                    ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update().(v)
//                                display_name v
//                                signature_documentation scala v: Value 
//                                kind Parameter
//                                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                         ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update().(s)
//                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update().(v)

  /**
    * Update a value in-place. Takes an `Int` or a `String`, through the
    * implicitly-constructe [[Value.Selector]] type.
    *
    * We cannot just overload `update` on `s: Int` and `s: String` because
    * of type inference problems in Scala 2.11.
    */
  def update(s: Value.Selector, f: Value => Value): Unit = s(this) = f(s(this))
//    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update(+1).
//           display_name update
//           signature_documentation scala def update(s: Selector, f: (Value) => Value): Unit
//           kind Method
//           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update(+1).(s)
//             display_name s
//             signature_documentation scala s: Selector 
//             kind Parameter
//              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                    ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update(+1).(f)
//                                display_name f
//                                signature_documentation scala f: (Value) => Value 
//                                kind Parameter
//                                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update(+1).(s)
//                                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update(+1).(f)
//                                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update(+1).(s)

  def transform[T](f: Visitor[_, T]) = Value.transform(this, f)
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().
//              display_name transform
//              signature_documentation scala def transform(f: Visitor[local10, T[): T
//              kind Method
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().[T]
//                display_name T
//                signature_documentation scala T
//                kind TypeParameter
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().(f)
//                   display_name f
//                   signature_documentation scala f: Visitor[local10, T[ 
//                   kind Parameter
//                    ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().[T]
//                                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                                           ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().
//                                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().(f)
  override def toString = render()
//             ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#toString().
//                      display_name toString
//                      signature_documentation scala def toString(): String
//                      kind Method
//                      relationship is_reference is_implementation semanticdb maven . . scala/Any#toString().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#toString().
//                        ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#render().
  def render(indent: Int = -1, escapeUnicode: Boolean = false) = this.transform(StringRenderer(indent, escapeUnicode)).toString
//    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#render().
//           display_name render
//           signature_documentation scala def render(indent: Int, escapeUnicode: Boolean): String
//           kind Method
//           ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#render().(indent)
//                  display_name indent
//                  signature_documentation scala default indent: Int 
//                  kind Parameter
//                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                             ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#render().(escapeUnicode)
//                                           display_name escapeUnicode
//                                           signature_documentation scala default escapeUnicode: Boolean 
//                                           kind Parameter
//                                            ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                                                    ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().
//                                                                              ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.
//                                                                                             ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#render().(indent)
//                                                                                                     ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#render().(escapeUnicode)
//                                                                                                                     ^^^^^^^^ reference semanticdb maven jdk 11 java/io/StringWriter#toString().

  def writeBytesTo(out: java.io.OutputStream, indent: Int = -1, escapeUnicode: Boolean = false): Unit = {
//    ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo().
//                 display_name writeBytesTo
//                 signature_documentation scala def writeBytesTo(out: OutputStream, indent: Int, escapeUnicode: Boolean): Unit
//                 kind Method
//                 ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo().(out)
//                     display_name out
//                     signature_documentation scala out: OutputStream 
//                     kind Parameter
//                      ^^^^ reference semanticdb maven . . java/
//                           ^^ reference semanticdb maven . . java/io/
//                              ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/OutputStream#
//                                            ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo().(indent)
//                                                   display_name indent
//                                                   signature_documentation scala default indent: Int 
//                                                   kind Parameter
//                                                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                              ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo().(escapeUnicode)
//                                                                            display_name escapeUnicode
//                                                                            signature_documentation scala default escapeUnicode: Boolean 
//                                                                            kind Parameter
//                                                                             ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                                                                               ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
    this.transform(new ujson.BaseByteRenderer(out, indent, escapeUnicode))
//       ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().
//                     ^^^^^ reference semanticdb maven . . ujson/
//                           ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#
//                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#`<init>`().
//                                            ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo().(out)
//                                                 ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo().(indent)
//                                                         ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo().(escapeUnicode)
  }
  def writeBytesTo(out: java.io.OutputStream): Unit = writeBytesTo(out, -1, false)
//    ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo(+1).
//                 display_name writeBytesTo
//                 signature_documentation scala def writeBytesTo(out: OutputStream): Unit
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/geny_2.13 0.6.10 geny/Writable#writeBytesTo().
//                 ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo(+1).(out)
//                     display_name out
//                     signature_documentation scala out: OutputStream 
//                     kind Parameter
//                      ^^^^ reference semanticdb maven . . java/
//                           ^^ reference semanticdb maven . . java/io/
//                              ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/OutputStream#
//                                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
//                                                    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo().
//                                                                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo(+1).(out)
}

/**
* A very small, very simple JSON AST that uPickle uses as part of its
* serialization process. A common standard between the Jawn AST (which
* we don't use so we don't pull in the bulk of Spire) and the Javascript
* JSON AST.
*/
object Value extends AstTransformer[Value]{
//     ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//           display_name Value
//           signature_documentation scala object Value
//           kind Object
//                   ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#
//                                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                        ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  type Value = ujson.Value
//     ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//           display_name Value
//           signature_documentation scala type Value >: Value <: Value
//           kind Type
//             ^^^^^ reference semanticdb maven . . ujson/
//                   ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
  sealed trait Selector{
//             ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#
//                      display_name Selector
//                      signature_documentation scala sealed trait Selector
//                      kind Trait
    def apply(x: Value): Value
//      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#apply().
//            display_name apply
//            signature_documentation scala def apply(x: Value): Value
//            kind AbstractMethod
//            relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#apply().
//            relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#apply().
//            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#apply().(x)
//              display_name x
//              signature_documentation scala x: Value 
//              kind Parameter
//               ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
    def update(x: Value, y: Value): Unit
//      ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#update().
//             display_name update
//             signature_documentation scala def update(x: Value, y: Value): Unit
//             kind AbstractMethod
//             relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#update().
//             relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#update().
//             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#update().(x)
//               display_name x
//               signature_documentation scala x: Value 
//               kind Parameter
//                ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#update().(y)
//                         display_name y
//                         signature_documentation scala y: Value 
//                         kind Parameter
//                          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
  }
  object Selector{
//       ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.
//                display_name Selector
//                signature_documentation scala object Selector
//                kind Object
    implicit class IntSelector(i: Int) extends Selector{
//                 ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#
//                             display_name IntSelector
//                             signature_documentation scala implicit class IntSelector
//                             kind Class
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#`<init>`().
//                              display_name <init>
//                              signature_documentation scala def this(i: Int)
//                              kind Constructor
//                             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#i.
//                               display_name i
//                               signature_documentation scala private[this] val i: Int
//                               kind Method
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#`<init>`().(i)
//                             _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#`<init>`().(i)
//                               display_name i
//                               signature_documentation scala i: Int 
//                               kind Parameter
//                               relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#i.
//                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                             ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#
//                                                     ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
      def apply(x: Value): Value = x.arr(i)
//        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#apply().
//              display_name apply
//              signature_documentation scala def apply(x: Value): Value
//              kind Method
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#apply().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#apply().(x)
//                display_name x
//                signature_documentation scala x: Value 
//                kind Parameter
//                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                         ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#apply().(x)
//                                   ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#arr().
//                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#i.
      def update(x: Value, y: Value) = x.arr(i) = y
//        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#update().
//               display_name update
//               signature_documentation scala def update(x: Value, y: Value): Unit
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#update().
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#update().(x)
//                 display_name x
//                 signature_documentation scala x: Value 
//                 kind Parameter
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#update().(y)
//                           display_name y
//                           signature_documentation scala y: Value 
//                           kind Parameter
//                            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#update().(x)
//                                       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#arr().
//                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#i.
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#update().(y)
    }
    implicit class StringSelector(i: String) extends Selector{
//                 ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#
//                                display_name StringSelector
//                                signature_documentation scala implicit class StringSelector
//                                kind Class
//                               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#`<init>`().
//                                 display_name <init>
//                                 signature_documentation scala def this(i: String)
//                                 kind Constructor
//                                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#i.
//                                  display_name i
//                                  signature_documentation scala private[this] val i: String
//                                  kind Method
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#`<init>`().(i)
//                                _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#`<init>`().(i)
//                                  display_name i
//                                  signature_documentation scala i: String 
//                                  kind Parameter
//                                  relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#i.
//                                   ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                   ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#
//                                                           ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
      def apply(x: Value): Value = x.obj(i)
//        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#apply().
//              display_name apply
//              signature_documentation scala def apply(x: Value): Value
//              kind Method
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#apply().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#apply().(x)
//                display_name x
//                signature_documentation scala x: Value 
//                kind Parameter
//                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                         ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#apply().(x)
//                                   ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#obj().
//                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#i.
      def update(x: Value, y: Value) = x.obj(i) = y
//        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#update().
//               display_name update
//               signature_documentation scala def update(x: Value, y: Value): Unit
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#update().
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#update().(x)
//                 display_name x
//                 signature_documentation scala x: Value 
//                 kind Parameter
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#update().(y)
//                           display_name y
//                           signature_documentation scala y: Value 
//                           kind Parameter
//                            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#update().(x)
//                                       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#obj().
//                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#i.
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#update().(y)
    }
  }

  @deprecated("use ujson.Str")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Str = ujson.Str
//    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Str.
//        display_name Str
//        signature_documentation scala @deprecated\nval Str: Str.type
//        kind Method
//          ^^^^^ reference semanticdb maven . . ujson/
//                ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.
  @deprecated("use ujson.Str")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  type Str = ujson.Str
//     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Str#
//         display_name Str
//         signature_documentation scala type Str >: Str <: Str
//         kind Type
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
  @deprecated("use ujson.Obj")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Obj = ujson.Obj
//    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Obj.
//        display_name Obj
//        signature_documentation scala @deprecated\nval Obj: Obj.type
//        kind Method
//          ^^^^^ reference semanticdb maven . . ujson/
//                ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
  @deprecated("use ujson.Obj")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  type Obj = ujson.Obj
//     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Obj#
//         display_name Obj
//         signature_documentation scala type Obj >: Obj <: Obj
//         kind Type
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
  @deprecated("use ujson.Arr")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Arr = ujson.Arr
//    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Arr.
//        display_name Arr
//        signature_documentation scala @deprecated\nval Arr: Arr.type
//        kind Method
//          ^^^^^ reference semanticdb maven . . ujson/
//                ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
  @deprecated("use ujson.Arr")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  type Arr = ujson.Arr
//     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Arr#
//         display_name Arr
//         signature_documentation scala type Arr >: Arr <: Arr
//         kind Type
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
  @deprecated("use ujson.Num")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Num = ujson.Num
//    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num.
//        display_name Num
//        signature_documentation scala @deprecated\nval Num: Num.type
//        kind Method
//          ^^^^^ reference semanticdb maven . . ujson/
//                ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
  @deprecated("use ujson.Num")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  type Num = ujson.Num
//     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num#
//         display_name Num
//         signature_documentation scala type Num >: Num <: Num
//         kind Type
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
  @deprecated("use ujson.Bool")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Bool = ujson.Bool
//    ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Bool.
//         display_name Bool
//         signature_documentation scala @deprecated\nval Bool: Bool.type
//         kind Method
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.
  @deprecated("use ujson.Bool")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  type Bool = ujson.Bool
//     ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Bool#
//          display_name Bool
//          signature_documentation scala type Bool >: Bool <: Bool
//          kind Type
//            ^^^^^ reference semanticdb maven . . ujson/
//                  ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#
  @deprecated("use ujson.True")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val True = ujson.True
//    ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.True.
//         display_name True
//         signature_documentation scala @deprecated\nval True: True.type
//         kind Method
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.
  @deprecated("use ujson.False")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val False = ujson.False
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.False.
//          display_name False
//          signature_documentation scala @deprecated\nval False: False.type
//          kind Method
//            ^^^^^ reference semanticdb maven . . ujson/
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.
  @deprecated("use ujson.Null")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Null = ujson.Null
//    ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Null.
//         display_name Null
//         signature_documentation scala @deprecated\nval Null: Null.type
//         kind Method
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.
  implicit def JsonableSeq[T](items: TraversableOnce[T])
//             ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().
//                         display_name JsonableSeq
//                         signature_documentation scala implicit def JsonableSeq(items: TraversableOnce[T])(f: (T) => Value): Arr
//                         kind Method
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().[T]
//                           display_name T
//                           signature_documentation scala T
//                           kind TypeParameter
//                            ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().(items)
//                                  display_name items
//                                  signature_documentation scala items: TraversableOnce[T] 
//                                  kind Parameter
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.TraversableOnce#
//                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().[T]
                             (implicit f: T => Value): Arr = Arr.from(items.map(f))
//                                     ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().(f)
//                                       display_name f
//                                       signature_documentation scala implicit f: (T) => Value 
//                                       kind Parameter
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().[T]
//                                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                                     ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Arr#
//                                                           ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Arr.
//                                                               ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().
//                                                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().(items)
//                                                                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOnceExtensionMethods#map().
//                                                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().(f)
  implicit def JsonableDict[T](items: TraversableOnce[(String, T)])
//             ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().
//                          display_name JsonableDict
//                          signature_documentation scala implicit def JsonableDict(items: TraversableOnce[(String, T)])(f: (T) => Value): Obj
//                          kind Method
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().[T]
//                            display_name T
//                            signature_documentation scala T
//                            kind TypeParameter
//                             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().(items)
//                                   display_name items
//                                   signature_documentation scala items: TraversableOnce[(String, T)] 
//                                   kind Parameter
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.TraversableOnce#
//                                                     ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().[T]
                              (implicit f: T => Value): Obj = Obj.from(items.map(x => (x._1, f(x._2))))
//                                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().(f)
//                                        display_name f
//                                        signature_documentation scala implicit f: (T) => Value 
//                                        kind Parameter
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().[T]
//                                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Obj#
//                                                            ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Obj.
//                                                                ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.from().
//                                                                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().(items)
//                                                                           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOnceExtensionMethods#map().
//                                                                               ^ definition local 11
//                                                                                 display_name x
//                                                                                 signature_documentation scala x: (String, T) 
//                                                                                 kind Parameter
//                                                                                     ^ reference local 11
//                                                                                       ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Tuple2#_1.
//                                                                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().(f)
//                                                                                             ^ reference local 11
//                                                                                               ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Tuple2#_2.
  implicit def JsonableBoolean(i: Boolean): Bool = if (i) ujson.True else ujson.False
//             ^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableBoolean().
//                             display_name JsonableBoolean
//                             signature_documentation scala implicit def JsonableBoolean(i: Boolean): Bool
//                             kind Method
//                             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableBoolean().(i)
//                               display_name i
//                               signature_documentation scala i: Boolean 
//                               kind Parameter
//                                ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                          ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Bool#
//                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableBoolean().(i)
//                                                        ^^^^^ reference semanticdb maven . . ujson/
//                                                              ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.
//                                                                        ^^^^^ reference semanticdb maven . . ujson/
//                                                                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.
  implicit def JsonableByte(i: Byte): Num = Num(i)
//             ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableByte().
//                          display_name JsonableByte
//                          signature_documentation scala implicit def JsonableByte(i: Byte): Num
//                          kind Method
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableByte().(i)
//                            display_name i
//                            signature_documentation scala i: Byte 
//                            kind Parameter
//                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Byte#
//                                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num#
//                                          ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num.
//                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableByte().(i)
  implicit def JsonableShort(i: Short): Num = Num(i)
//             ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableShort().
//                           display_name JsonableShort
//                           signature_documentation scala implicit def JsonableShort(i: Short): Num
//                           kind Method
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableShort().(i)
//                             display_name i
//                             signature_documentation scala i: Short 
//                             kind Parameter
//                              ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Short#
//                                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num#
//                                            ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num.
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableShort().(i)
  implicit def JsonableInt(i: Int): Num = Num(i)
//             ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableInt().
//                         display_name JsonableInt
//                         signature_documentation scala implicit def JsonableInt(i: Int): Num
//                         kind Method
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableInt().(i)
//                           display_name i
//                           signature_documentation scala i: Int 
//                           kind Parameter
//                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num#
//                                        ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num.
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableInt().(i)
  implicit def JsonableLong(i: Long): Str = Str(i.toString)
//             ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableLong().
//                          display_name JsonableLong
//                          signature_documentation scala implicit def JsonableLong(i: Long): Str
//                          kind Method
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableLong().(i)
//                            display_name i
//                            signature_documentation scala i: Long 
//                            kind Parameter
//                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Long#
//                                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Str#
//                                          ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Str.
//                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableLong().(i)
//                                                ^^^^^^^^ reference semanticdb maven . . scala/Any#toString().
  implicit def JsonableFloat(i: Float): Num = Num(i)
//             ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableFloat().
//                           display_name JsonableFloat
//                           signature_documentation scala implicit def JsonableFloat(i: Float): Num
//                           kind Method
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableFloat().(i)
//                             display_name i
//                             signature_documentation scala i: Float 
//                             kind Parameter
//                              ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Float#
//                                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num#
//                                            ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num.
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableFloat().(i)
  implicit def JsonableDouble(i: Double): Num = Num(i)
//             ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDouble().
//                            display_name JsonableDouble
//                            signature_documentation scala implicit def JsonableDouble(i: Double): Num
//                            kind Method
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDouble().(i)
//                              display_name i
//                              signature_documentation scala i: Double 
//                              kind Parameter
//                               ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                                        ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num#
//                                              ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num.
//                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDouble().(i)
  implicit def JsonableNull(i: Null): Null.type = Null
//             ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableNull().
//                          display_name JsonableNull
//                          signature_documentation scala implicit def JsonableNull(i: Null): Null.type
//                          kind Method
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableNull().(i)
//                            display_name i
//                            signature_documentation scala i: Null 
//                            kind Parameter
//                             ^^^^ reference semanticdb maven . . scala/Null#
//                                    ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Null.
//                                                ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Null.
  implicit def JsonableString(s: CharSequence): Str = Str(s.toString)
//             ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableString().
//                            display_name JsonableString
//                            signature_documentation scala implicit def JsonableString(s: CharSequence): Str
//                            kind Method
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableString().(s)
//                              display_name s
//                              signature_documentation scala s: CharSequence 
//                              kind Parameter
//                               ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                              ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Str#
//                                                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Str.
//                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableString().(s)
//                                                          ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#toString().


  def transform[T](j: Value, f: Visitor[_, T]): T = {
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().
//              display_name transform
//              signature_documentation scala def transform(j: Value, f: Visitor[local12, T[): T
//              kind Method
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().[T]
//                display_name T
//                signature_documentation scala T
//                kind TypeParameter
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(j)
//                   display_name j
//                   signature_documentation scala j: Value 
//                   kind Parameter
//                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                             display_name f
//                             signature_documentation scala f: Visitor[local12, T[ 
//                             kind Parameter
//                              ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().[T]
//                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().[T]
    j match{
//  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(j)
      case ujson.Null => f.visitNull(-1)
//         ^^^^^ reference semanticdb maven . . ujson/
//               ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.
//                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                         ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitNull().
      case ujson.True => f.visitTrue(-1)
//         ^^^^^ reference semanticdb maven . . ujson/
//               ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.
//                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                         ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitTrue().
      case ujson.False => f.visitFalse(-1)
//         ^^^^^ reference semanticdb maven . . ujson/
//               ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.
//                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                          ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFalse().
      case ujson.Str(s) => f.visitString(s, -1)
//         ^^^^^ reference semanticdb maven . . ujson/
//               ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.
//                   ^ definition local 13
//                     display_name s
//                     signature_documentation scala s: String 
//                     kind Variable
//                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                           ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                       ^ reference local 13
      case ujson.Num(d) => f.visitFloat64(d, -1)
//         ^^^^^ reference semanticdb maven . . ujson/
//               ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
//                   ^ definition local 14
//                     display_name d
//                     signature_documentation scala d: Double 
//                     kind Variable
//                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                           ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64().
//                                        ^ reference local 14
      case ujson.Arr(items) => transformArray(f, items)
//         ^^^^^ reference semanticdb maven . . ujson/
//               ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
//                   ^^^^^ definition local 15
//                         display_name items
//                         signature_documentation scala items: ArrayBuffer[Value] 
//                         kind Variable
//                             ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                                               ^^^^^ reference local 15
      case ujson.Obj(items) => transformObject(f, items)
//         ^^^^^ reference semanticdb maven . . ujson/
//               ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
//                   ^^^^^ definition local 16
//                         display_name items
//                         signature_documentation scala items: LinkedHashMap[String, Value] 
//                         kind Variable
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().
//                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                                                ^^^^^ reference local 16
    }
  }

  def visitArray(length: Int, index: Int) = new AstArrVisitor[ArrayBuffer](xs => ujson.Arr(xs))
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitArray().
//               display_name visitArray
//               signature_documentation scala def visitArray(length: Int, index: Int): AstArrVisitor[ArrayBuffer]
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//               ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitArray().(length)
//                      display_name length
//                      signature_documentation scala length: Int 
//                      kind Parameter
//                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                            ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitArray().(index)
//                                  display_name index
//                                  signature_documentation scala index: Int 
//                                  kind Parameter
//                                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                              ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#
//                                                            ^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/ArrayBuffer#
//                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#`<init>`().
//                                                                         ^^ definition local 17
//                                                                            display_name xs
//                                                                            signature_documentation scala xs: ArrayBuffer[Value] 
//                                                                            kind Parameter
//                                                                               ^^^^^ reference semanticdb maven . . ujson/
//                                                                                     ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
//                                                                                         ^^ reference local 17

  def visitObject(length: Int, index: Int) = new AstObjVisitor[mutable.LinkedHashMap[String, Value]](xs => ujson.Obj(xs))
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitObject().
//                display_name visitObject
//                signature_documentation scala def visitObject(length: Int, index: Int): AstObjVisitor[LinkedHashMap[String, Value]]
//                kind Method
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitObject().
//                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitObject().(length)
//                       display_name length
//                       signature_documentation scala length: Int 
//                       kind Parameter
//                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitObject().(index)
//                                   display_name index
//                                   signature_documentation scala index: Int 
//                                   kind Parameter
//                                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                               ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#
//                                                             ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                                                                     ^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/LinkedHashMap#
//                                                                                   ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                                                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`<init>`().
//                                                                                                   ^^ definition local 18
//                                                                                                      display_name xs
//                                                                                                      signature_documentation scala xs: LinkedHashMap[String, Value] 
//                                                                                                      kind Parameter
//                                                                                                         ^^^^^ reference semanticdb maven . . ujson/
//                                                                                                               ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
//                                                                                                                   ^^ reference local 18

  def visitNull(index: Int) = ujson.Null
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitNull().
//              display_name visitNull
//              signature_documentation scala def visitNull(index: Int): Null
//              kind Method
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitNull().
//              ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitNull().(index)
//                    display_name index
//                    signature_documentation scala index: Int 
//                    kind Parameter
//                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                            ^^^^^ reference semanticdb maven . . ujson/
//                                  ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.

  def visitFalse(index: Int) = ujson.False
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFalse().
//               display_name visitFalse
//               signature_documentation scala def visitFalse(index: Int): False
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFalse().
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFalse().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                             ^^^^^ reference semanticdb maven . . ujson/
//                                   ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.

  def visitTrue(index: Int) = True
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitTrue().
//              display_name visitTrue
//              signature_documentation scala def visitTrue(index: Int): True
//              kind Method
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitTrue().
//              ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitTrue().(index)
//                    display_name index
//                    signature_documentation scala index: Int 
//                    kind Parameter
//                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                            ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.True.


  override def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int) = {
//             ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().
//                                     display_name visitFloat64StringParts
//                                     signature_documentation scala def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int): Num
//                                     kind Method
//                                     relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64StringParts().
//                                     ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(s)
//                                       display_name s
//                                       signature_documentation scala s: CharSequence 
//                                       kind Parameter
//                                        ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                                      ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(decIndex)
//                                                               display_name decIndex
//                                                               signature_documentation scala decIndex: Int 
//                                                               kind Parameter
//                                                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                     ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(expIndex)
//                                                                              display_name expIndex
//                                                                              signature_documentation scala expIndex: Int 
//                                                                              kind Parameter
//                                                                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                                    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(index)
//                                                                                          display_name index
//                                                                                          signature_documentation scala index: Int 
//                                                                                          kind Parameter
//                                                                                           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    ujson.Num(
//  ^^^^^ reference semanticdb maven . . ujson/
//        ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
      if (decIndex != -1 || expIndex != -1) s.toString.toDouble
//        ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(decIndex)
//                 ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`!=`(+3).
//                       ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`||`().
//                          ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(expIndex)
//                                   ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`!=`(+3).
//                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(s)
//                                            ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#toString().
//                                                     ^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/StringOps#toDouble().
      else Util.parseIntegralNum(s, decIndex, expIndex, index)
//         ^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Util.
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Util.parseIntegralNum().
//                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(s)
//                                  ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(decIndex)
//                                            ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(expIndex)
//                                                      ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(index)
    )
  }

  override def visitFloat64(d: Double, index: Int) = ujson.Num(d)
//             ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64().
//                          display_name visitFloat64
//                          signature_documentation scala def visitFloat64(d: Double, index: Int): Num
//                          kind Method
//                          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64().
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64().(d)
//                            display_name d
//                            signature_documentation scala d: Double 
//                            kind Parameter
//                             ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                                     ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64().(index)
//                                           display_name index
//                                           signature_documentation scala index: Int 
//                                           kind Parameter
//                                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                   ^^^^^ reference semanticdb maven . . ujson/
//                                                         ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
//                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64().(d)

  def visitString(s: CharSequence, index: Int) = ujson.Str(s.toString)
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitString().
//                display_name visitString
//                signature_documentation scala def visitString(s: CharSequence, index: Int): Str
//                kind Method
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitString().(s)
//                  display_name s
//                  signature_documentation scala s: CharSequence 
//                  kind Parameter
//                   ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                 ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitString().(index)
//                                       display_name index
//                                       signature_documentation scala index: Int 
//                                       kind Parameter
//                                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                               ^^^^^ reference semanticdb maven . . ujson/
//                                                     ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitString().(s)
//                                                           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#toString().

  /**
    * Thrown when uPickle tries to convert a JSON blob into a given data
    * structure but fails because part the blob is invalid
    *
    * @param data The section of the JSON blob that uPickle tried to convert.
    *             This could be the entire blob, or it could be some subtree.
    * @param msg Human-readable text saying what went wrong
    */
  case class InvalidData(data: Value, msg: String)
//           ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#
//                       display_name InvalidData
//                       signature_documentation scala case class InvalidData(data: Value, msg: String) extends Exception
//                       kind Class
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().
//           ___________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().
//                       display_name copy
//                       signature_documentation scala def copy(data: Value, msg: String): InvalidData
//                       kind Method
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().
//           ___________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.
//                       display_name InvalidData
//                       signature_documentation scala object InvalidData
//                       kind Object
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().
//           ___________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().
//                       display_name apply
//                       signature_documentation scala def apply(data: Value, msg: String): InvalidData
//                       kind Method
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#
//                       relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//           ___________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#productElementName().
//                       display_name productElementName
//                       signature_documentation scala def productElementName(x$1: Int): String
//                       kind Method
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().
//                       relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//           ___________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#productElement().
//                       display_name productElement
//                       signature_documentation scala def productElement(x$1: Int): Any
//                       kind Method
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().
//                       relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().
//                        display_name <init>
//                        signature_documentation scala def this(data: Value, msg: String)
//                        kind Constructor
//                       ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#data.
//                            display_name data
//                            signature_documentation scala val data: Value
//                            kind Method
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(data)
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(data)
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(data)
//                       ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(data)
//                            display_name data
//                            signature_documentation scala data: Value 
//                            kind Parameter
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(data)
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(data)
//                            relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#data.
//                       ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(data)
//                            display_name data
//                            signature_documentation scala data: Value 
//                            kind Parameter
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(data)
//                            relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#data.
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(data)
//                       ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(data)
//                            display_name data
//                            signature_documentation scala default data: Value 
//                            kind Parameter
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(data)
//                            relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#data.
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(data)
//                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#msg.
//                                        display_name msg
//                                        signature_documentation scala val msg: String
//                                        kind Method
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(msg)
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(msg)
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(msg)
//                                    ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(msg)
//                                        display_name msg
//                                        signature_documentation scala msg: String 
//                                        kind Parameter
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(msg)
//                                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#msg.
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(msg)
//                                    ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(msg)
//                                        display_name msg
//                                        signature_documentation scala default msg: String 
//                                        kind Parameter
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(msg)
//                                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#msg.
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(msg)
//                                    ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(msg)
//                                        display_name msg
//                                        signature_documentation scala msg: String 
//                                        kind Parameter
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(msg)
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(msg)
//                                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#msg.
//                                         ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
    extends Exception(s"$msg (data: $data)")
//          ^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.Exception#
//                   ^ reference semanticdb maven jdk 11 java/lang/Exception#`<init>`(+1).
//                    ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/StringContext#s().
//                       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(msg)
//                                   ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(data)
}

case class Str(value: String) extends Value
//         ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
//             display_name Str
//             signature_documentation scala case class Str(value: String) extends Value
//             kind Class
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#productElement().
//             display_name productElement
//             signature_documentation scala def productElement(x$1: Int): Any
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#copy().
//             display_name copy
//             signature_documentation scala def copy(value: String): Str
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.
//             display_name Str
//             signature_documentation scala object Str
//             kind Object
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#productElementName().
//             display_name productElementName
//             signature_documentation scala def productElementName(x$1: Int): String
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().
//             display_name apply
//             signature_documentation scala def apply(value: String): Str
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function1#apply().
//            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#`<init>`().
//              display_name <init>
//              signature_documentation scala def this(value: String)
//              kind Constructor
//             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#value.
//                   display_name value
//                   signature_documentation scala val value: String
//                   kind Method
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#copy().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().(value)
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().(value)
//                   display_name value
//                   signature_documentation scala value: String 
//                   kind Parameter
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#value.
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#`<init>`().(value)
//                   display_name value
//                   signature_documentation scala value: String 
//                   kind Parameter
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().(value)
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#copy().(value)
//                   display_name value
//                   signature_documentation scala default value: String 
//                   kind Parameter
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#`<init>`().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().(value)
//                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                         ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
case class Obj(value: mutable.LinkedHashMap[String, Value]) extends Value
//         ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
//             display_name Obj
//             signature_documentation scala case class Obj(value: LinkedHashMap[String, Value]) extends Value
//             kind Class
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#productElementName().
//             display_name productElementName
//             signature_documentation scala def productElementName(x$1: Int): String
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#productElement().
//             display_name productElement
//             signature_documentation scala def productElement(x$1: Int): Any
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#copy().
//             display_name copy
//             signature_documentation scala def copy(value: LinkedHashMap[String, Value]): Obj
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
//            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#`<init>`().
//              display_name <init>
//              signature_documentation scala def this(value: LinkedHashMap[String, Value])
//              kind Constructor
//             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#value.
//                   display_name value
//                   signature_documentation scala val value: LinkedHashMap[String, Value]
//                   kind Method
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#copy().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply(+2).(value)
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply(+2).(value)
//                   display_name value
//                   signature_documentation scala value: LinkedHashMap[String, Value] 
//                   kind Parameter
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#value.
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#`<init>`().(value)
//                   display_name value
//                   signature_documentation scala value: LinkedHashMap[String, Value] 
//                   kind Parameter
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply(+2).(value)
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#copy().(value)
//                   display_name value
//                   signature_documentation scala default value: LinkedHashMap[String, Value] 
//                   kind Parameter
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#`<init>`().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply(+2).(value)
//                    ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                            ^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/LinkedHashMap#
//                                          ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#

//^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
object Obj{
//     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
//         display_name Obj
//         signature_documentation scala object Obj
//         kind Object
//     ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply(+2).
//         display_name apply
//         signature_documentation scala def apply(value: LinkedHashMap[String, Value]): Obj
//         kind Method
//         relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
  implicit def from(items: TraversableOnce[(String, Value)]): Obj = {
//             ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.from().
//                  display_name from
//                  signature_documentation scala implicit def from(items: TraversableOnce[(String, Value)]): Obj
//                  kind Method
//                  ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.from().(items)
//                        display_name items
//                        signature_documentation scala items: TraversableOnce[(String, Value)] 
//                        kind Parameter
//                         ^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.TraversableOnce#
//                                          ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                            ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
    Obj(mutable.LinkedHashMap(items.toSeq:_*))
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
//      ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//              ^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/LinkedHashMap.
//                            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.from().(items)
//                                  ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOnceExtensionMethods#toSeq().
  }
  // Weird telescoped version of `apply(items: (String, Value)*)`, to avoid
  // type inference issues due to overloading the existing `apply` method
  // generated by the case class itself
  // https://github.com/lihaoyi/upickle/issues/230
  def apply[V](item: (String, V),
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().
//          display_name apply
//          signature_documentation scala def apply(item: (String, V), items: (String, Value)*)(conv: (V) => Value): Obj
//          kind Method
//          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().[V]
//            display_name V
//            signature_documentation scala V
//            kind TypeParameter
//             ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().(item)
//                  display_name item
//                  signature_documentation scala item: (String, V) 
//                  kind Parameter
//                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().[V]
                        items: (String, Value)*)(implicit conv: V => Value): Obj = {
//                      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().(items)
//                            display_name items
//                            signature_documentation scala items: (String, Value)* 
//                            kind Parameter
//                              ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                      ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                        ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().(conv)
//                                                             display_name conv
//                                                             signature_documentation scala implicit conv: (V) => Value 
//                                                             kind Parameter
//                                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().[V]
//                                                                   ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                                           ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
    val map = new mutable.LinkedHashMap[String, Value]()
//      ^^^ definition local 22
//          display_name map
//          signature_documentation scala map: LinkedHashMap[String, Value] 
//          kind Variable
//                ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                        ^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/LinkedHashMap#
//                                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                    ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/LinkedHashMap#`<init>`().
    map.put(item._1, conv(item._2))
//  ^^^ reference local 22
//      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/LinkedHashMap#put().
//          ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().(item)
//               ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Tuple2#_1.
//                   ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().(conv)
//                        ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().(item)
//                             ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Tuple2#_2.
    for (i <- items) map.put(i._1, i._2)
//       ^ definition local 23
//         display_name i
//         signature_documentation scala i: (String, Value) 
//         kind Parameter
//            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().(items)
//                   ^^^ reference local 22
//                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/LinkedHashMap#put().
//                           ^ reference local 23
//                             ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Tuple2#_1.
//                                 ^ reference local 23
//                                   ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Tuple2#_2.
    Obj(map)
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
//      ^^^ reference local 22
  }

  def apply(): Obj = Obj(new mutable.LinkedHashMap[String, Value]())
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply(+1).
//          display_name apply
//          signature_documentation scala def apply(): Obj
//          kind Method
//             ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
//                   ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
//                           ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                                   ^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/LinkedHashMap#
//                                                 ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                         ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                               ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/LinkedHashMap#`<init>`().
}
case class Arr(value: ArrayBuffer[Value]) extends Value
//         ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
//             display_name Arr
//             signature_documentation scala case class Arr(value: ArrayBuffer[Value]) extends Value
//             kind Class
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#productElement().
//             display_name productElement
//             signature_documentation scala def productElement(x$1: Int): Any
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#productElementName().
//             display_name productElementName
//             signature_documentation scala def productElementName(x$1: Int): String
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#copy().
//             display_name copy
//             signature_documentation scala def copy(value: ArrayBuffer[Value]): Arr
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
//            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#`<init>`().
//              display_name <init>
//              signature_documentation scala def this(value: ArrayBuffer[Value])
//              kind Constructor
//             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#value.
//                   display_name value
//                   signature_documentation scala val value: ArrayBuffer[Value]
//                   kind Method
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#copy().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply(+1).(value)
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#`<init>`().(value)
//                   display_name value
//                   signature_documentation scala value: ArrayBuffer[Value] 
//                   kind Parameter
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply(+1).(value)
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#copy().(value)
//                   display_name value
//                   signature_documentation scala default value: ArrayBuffer[Value] 
//                   kind Parameter
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#`<init>`().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply(+1).(value)
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply(+1).(value)
//                   display_name value
//                   signature_documentation scala value: ArrayBuffer[Value] 
//                   kind Parameter
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#value.
//                    ^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/ArrayBuffer#
//                                ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#

//^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
object Arr{
//     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
//         display_name Arr
//         signature_documentation scala object Arr
//         kind Object
//     ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply(+1).
//         display_name apply
//         signature_documentation scala def apply(value: ArrayBuffer[Value]): Arr
//         kind Method
//         relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
  implicit def from[T](items: TraversableOnce[T])(implicit conv: T => Value): Arr = {
//             ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().
//                  display_name from
//                  signature_documentation scala implicit def from(items: TraversableOnce[T])(conv: (T) => Value): Arr
//                  kind Method
//                  ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().[T]
//                    display_name T
//                    signature_documentation scala T
//                    kind TypeParameter
//                     ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().(items)
//                           display_name items
//                           signature_documentation scala items: TraversableOnce[T] 
//                           kind Parameter
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.TraversableOnce#
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().[T]
//                                                         ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().(conv)
//                                                              display_name conv
//                                                              signature_documentation scala implicit conv: (T) => Value 
//                                                              kind Parameter
//                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().[T]
//                                                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                                            ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
    val buf = new mutable.ArrayBuffer[Value]()
//      ^^^ definition local 25
//          display_name buf
//          signature_documentation scala buf: ArrayBuffer[Value] 
//          kind Variable
//                ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                        ^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/ArrayBuffer#
//                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                          ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/ArrayBuffer#`<init>`(+1).
    items.foreach{ item =>
//  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().(items)
//        ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOnceExtensionMethods#foreach().
//                 ^^^^ definition local 26
//                      display_name item
//                      signature_documentation scala item: T 
//                      kind Parameter
      buf += (conv(item): Value)
//    ^^^ reference local 25
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Growable#`+=`().
//            ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().(conv)
//                 ^^^^ reference local 26
//                        ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
    }
    Arr(buf)
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
//      ^^^ reference local 25
  }

  def apply(items: Value*): Arr = {
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply().
//          display_name apply
//          signature_documentation scala def apply(items: Value*): Arr
//          kind Method
//          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply().(items)
//                display_name items
//                signature_documentation scala items: Value* 
//                kind Parameter
//                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                          ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
    val buf = new mutable.ArrayBuffer[Value](items.length)
//      ^^^ definition local 27
//          display_name buf
//          signature_documentation scala buf: ArrayBuffer[Value] 
//          kind Variable
//                ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                        ^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/ArrayBuffer#
//                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                          ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/ArrayBuffer#`<init>`(+2).
//                                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply().(items)
//                                                 ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/SeqOps#length().
    items.foreach{ item =>
//  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply().(items)
//        ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOnceOps#foreach().
//                 ^^^^ definition local 28
//                      display_name item
//                      signature_documentation scala item: Value 
//                      kind Parameter
      buf += item
//    ^^^ reference local 27
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Growable#`+=`().
//           ^^^^ reference local 28
    }
    Arr(buf)
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
//      ^^^ reference local 27
  }
}
case class Num(value: Double) extends Value
//         ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
//             display_name Num
//             signature_documentation scala case class Num(value: Double) extends Value
//             kind Class
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#productElement().
//             display_name productElement
//             signature_documentation scala def productElement(x$1: Int): Any
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#copy().
//             display_name copy
//             signature_documentation scala def copy(value: Double): Num
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().
//             display_name apply
//             signature_documentation scala def apply(value: Double): Num
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function1#apply().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#productElementName().
//             display_name productElementName
//             signature_documentation scala def productElementName(x$1: Int): String
//             kind Method
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
//             display_name Num
//             signature_documentation scala object Num
//             kind Object
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().
//            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#`<init>`().
//              display_name <init>
//              signature_documentation scala def this(value: Double)
//              kind Constructor
//             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#value.
//                   display_name value
//                   signature_documentation scala val value: Double
//                   kind Method
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#copy().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().(value)
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().(value)
//                   display_name value
//                   signature_documentation scala value: Double 
//                   kind Parameter
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#value.
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#copy().(value)
//                   display_name value
//                   signature_documentation scala default value: Double 
//                   kind Parameter
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#`<init>`().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().(value)
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#`<init>`().(value)
//                   display_name value
//                   signature_documentation scala value: Double 
//                   kind Parameter
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().(value)
//                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                         ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
sealed abstract class Bool extends Value{
//                    ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#
//                         display_name Bool
//                         signature_documentation scala abstract sealed class Bool
//                         kind Class
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#`<init>`().
//                           display_name <init>
//                           signature_documentation scala def this()
//                           kind Constructor
//                                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                      ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  def value: Boolean
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#value().
//          display_name value
//          signature_documentation scala def value: Boolean
//          kind AbstractMethod
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.value().
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.value().
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
//           ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
}
object Bool{
//     ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.
//          display_name Bool
//          signature_documentation scala object Bool
//          kind Object
  def apply(value: Boolean): Bool = if (value) True else False
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.apply().
//          display_name apply
//          signature_documentation scala def apply(value: Boolean): Bool
//          kind Method
//          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.apply().(value)
//                display_name value
//                signature_documentation scala value: Boolean 
//                kind Parameter
//                 ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                           ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#
//                                      ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.apply().(value)
//                                             ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.
//                                                       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.
  def unapply(bool: Bool): Option[Boolean] = Some(bool.value)
//    ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.unapply().
//            display_name unapply
//            signature_documentation scala def unapply(bool: Bool): Option[Boolean]
//            kind Method
//            ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.unapply().(bool)
//                 display_name bool
//                 signature_documentation scala bool: Bool 
//                 kind Parameter
//                  ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#
//                         ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Option#
//                                ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                           ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Some.
//                                                ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.unapply().(bool)
//                                                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#value().
}
case object False extends Bool{
//          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.
//                display_name False
//                signature_documentation scala case object False
//                kind Object
//          _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.productElement().
//                display_name productElement
//                signature_documentation scala def productElement(x$1: Int): Any
//                kind Method
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//                        ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#
//                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#`<init>`().
  def value = false
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.value().
//          display_name value
//          signature_documentation scala def value: Boolean
//          kind Method
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#value().
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
}
case object True extends Bool{
//          ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.
//               display_name True
//               signature_documentation scala case object True
//               kind Object
//          ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.productElement().
//               display_name productElement
//               signature_documentation scala def productElement(x$1: Int): Any
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//                       ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#
//                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#`<init>`().
  def value = true
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.value().
//          display_name value
//          signature_documentation scala def value: Boolean
//          kind Method
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#value().
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
}
case object Null extends Value{
//          ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.
//               display_name Null
//               signature_documentation scala case object Null
//               kind Object
//          ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.productElement().
//               display_name productElement
//               signature_documentation scala def productElement(x$1: Int): Any
//               kind Method
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//                       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                            ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  def value = null
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.value().
//          display_name value
//          signature_documentation scala def value: Null
//          kind Method
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
}
