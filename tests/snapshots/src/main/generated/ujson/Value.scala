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
//                 documentation ```scala\nsealed trait Value\n```
//                         ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                                       ^^^^ reference semanticdb maven . . geny/
//                                            ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/geny_2.13 0.6.10 geny/Writable#
  override def httpContentType = Some("application/json")
//             ^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#httpContentType().
//                             documentation ```scala\ndef httpContentType: Some[String]\n```
//                             relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/geny_2.13 0.6.10 geny/Writable#httpContentType().
//                               ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Some.
  def value: Any
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
//          documentation ```scala\ndef value: Any\n```
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
//        documentation ```scala\ndef str: String\n```
    case ujson.Str(value) => value
//       ^^^^^ reference semanticdb maven . . ujson/
//             ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.
//                 ^^^^^ definition local 0
//                       documentation ```scala\nvalue: String \n```
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
//           documentation ```scala\ndef strOpt: Option[String]\n```
    case Str(value) => Some(value)
//       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.
//           ^^^^^ definition local 1
//                 documentation ```scala\nvalue: String \n```
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
//        documentation ```scala\ndef obj: LinkedHashMap[String, Value]\n```
    case ujson.Obj(value) => value
//       ^^^^^ reference semanticdb maven . . ujson/
//             ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
//                 ^^^^^ definition local 2
//                       documentation ```scala\nvalue: LinkedHashMap[String, Value] \n```
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
//           documentation ```scala\ndef objOpt: Option[LinkedHashMap[String, Value]]\n```
    case Obj(value) => Some(value)
//       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
//           ^^^^^ definition local 3
//                 documentation ```scala\nvalue: LinkedHashMap[String, Value] \n```
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
//        documentation ```scala\ndef arr: ArrayBuffer[Value]\n```
    case ujson.Arr(value) => value
//       ^^^^^ reference semanticdb maven . . ujson/
//             ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
//                 ^^^^^ definition local 4
//                       documentation ```scala\nvalue: ArrayBuffer[Value] \n```
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
//           documentation ```scala\ndef arrOpt: Option[ArrayBuffer[Value]]\n```
    case Arr(value) => Some(value)
//       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
//           ^^^^^ definition local 5
//                 documentation ```scala\nvalue: ArrayBuffer[Value] \n```
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
//        documentation ```scala\ndef num: Double\n```
    case ujson.Num(value) => value
//       ^^^^^ reference semanticdb maven . . ujson/
//             ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
//                 ^^^^^ definition local 6
//                       documentation ```scala\nvalue: Double \n```
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
//           documentation ```scala\ndef numOpt: Option[Double]\n```
    case Num(value) => Some(value)
//       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
//           ^^^^^ definition local 7
//                 documentation ```scala\nvalue: Double \n```
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
//         documentation ```scala\ndef bool: Boolean\n```
    case ujson.Bool(value) => value
//       ^^^^^ reference semanticdb maven . . ujson/
//             ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.
//                  ^^^^^ definition local 8
//                        documentation ```scala\nvalue: Boolean \n```
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
//            documentation ```scala\ndef boolOpt: Option[Boolean]\n```
    case Bool(value) => Some(value)
//       ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.
//            ^^^^^ definition local 9
//                  documentation ```scala\nvalue: Boolean \n```
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
//           documentation ```scala\ndef isNull: Boolean\n```
    case ujson.Null => true
//       ^^^^^ reference semanticdb maven . . ujson/
//             ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.
    case _ => false
  }

  def apply(s: Value.Selector): Value = s(this)
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#apply().
//          documentation ```scala\ndef apply(s: Selector): Value\n```
//          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#apply().(s)
//            documentation ```scala\ns: Selector \n```
//             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                   ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#
//                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#apply().(s)
  def update(s: Value.Selector, v: Value): Unit = s(this) = v
//    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update().
//           documentation ```scala\ndef update(s: Selector, v: Value): Unit\n```
//           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update().(s)
//             documentation ```scala\ns: Selector \n```
//              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                    ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update().(v)
//                                documentation ```scala\nv: Value \n```
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
//           documentation ```scala\ndef update(s: Selector, f: (Value) => Value): Unit\n```
//           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update(+1).(s)
//             documentation ```scala\ns: Selector \n```
//              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                    ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update(+1).(f)
//                                documentation ```scala\nf: (Value) => Value \n```
//                                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update(+1).(s)
//                                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update(+1).(f)
//                                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#update(+1).(s)

  def transform[T](f: Visitor[_, T]) = Value.transform(this, f)
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().
//              documentation ```scala\ndef transform(f: Visitor[local10, T[): T\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().[T]
//                documentation ```scala\nT\n```
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().(f)
//                   documentation ```scala\nf: Visitor[local10, T[ \n```
//                    ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().[T]
//                                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                                           ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().
//                                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().(f)
  override def toString = render()
//             ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#toString().
//                      documentation ```scala\ndef toString(): String\n```
//                      relationship is_reference is_implementation semanticdb maven . . scala/Any#toString().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#toString().
//                        ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#render().
  def render(indent: Int = -1, escapeUnicode: Boolean = false) = this.transform(StringRenderer(indent, escapeUnicode)).toString
//    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#render().
//           documentation ```scala\ndef render(indent: Int, escapeUnicode: Boolean): String\n```
//           ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#render().(indent)
//                  documentation ```scala\ndefault indent: Int \n```
//                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                             ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#render().(escapeUnicode)
//                                           documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                            ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                                                    ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#transform().
//                                                                              ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.
//                                                                                             ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#render().(indent)
//                                                                                                     ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#render().(escapeUnicode)
//                                                                                                                     ^^^^^^^^ reference semanticdb maven jdk 11 java/io/StringWriter#toString().

  def writeBytesTo(out: java.io.OutputStream, indent: Int = -1, escapeUnicode: Boolean = false): Unit = {
//    ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo().
//                 documentation ```scala\ndef writeBytesTo(out: OutputStream, indent: Int, escapeUnicode: Boolean): Unit\n```
//                 ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo().(out)
//                     documentation ```scala\nout: OutputStream \n```
//                      ^^^^ reference semanticdb maven . . java/
//                           ^^ reference semanticdb maven . . java/io/
//                              ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/OutputStream#
//                                            ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo().(indent)
//                                                   documentation ```scala\ndefault indent: Int \n```
//                                                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                              ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo().(escapeUnicode)
//                                                                            documentation ```scala\ndefault escapeUnicode: Boolean \n```
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
//                 documentation ```scala\ndef writeBytesTo(out: OutputStream): Unit\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/geny_2.13 0.6.10 geny/Writable#writeBytesTo().
//                 ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#writeBytesTo(+1).(out)
//                     documentation ```scala\nout: OutputStream \n```
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
//           documentation ```scala\nobject Value\n```
//                   ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#
//                                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                        ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  type Value = ujson.Value
//     ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//           documentation ```scala\ntype Value >: Value <: Value\n```
//             ^^^^^ reference semanticdb maven . . ujson/
//                   ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
  sealed trait Selector{
//             ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#
//                      documentation ```scala\nsealed trait Selector\n```
    def apply(x: Value): Value
//      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#apply().
//            documentation ```scala\ndef apply(x: Value): Value\n```
//            relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#apply().
//            relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#apply().
//            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#apply().(x)
//              documentation ```scala\nx: Value \n```
//               ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
    def update(x: Value, y: Value): Unit
//      ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#update().
//             documentation ```scala\ndef update(x: Value, y: Value): Unit\n```
//             relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#update().
//             relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#update().
//             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#update().(x)
//               documentation ```scala\nx: Value \n```
//                ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#update().(y)
//                         documentation ```scala\ny: Value \n```
//                          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
  }
  object Selector{
//       ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.
//                documentation ```scala\nobject Selector\n```
    implicit class IntSelector(i: Int) extends Selector{
//                 ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#
//                             documentation ```scala\nimplicit class IntSelector\n```
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#`<init>`().
//                              documentation ```scala\ndef this(i: Int)\n```
//                             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#i.
//                               documentation ```scala\nprivate[this] val i: Int\n```
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#`<init>`().(i)
//                             _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#`<init>`().(i)
//                               documentation ```scala\ni: Int \n```
//                               relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#i.
//                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                             ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#
//                                                     ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
      def apply(x: Value): Value = x.arr(i)
//        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#apply().
//              documentation ```scala\ndef apply(x: Value): Value\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#apply().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#apply().(x)
//                documentation ```scala\nx: Value \n```
//                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                         ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#apply().(x)
//                                   ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#arr().
//                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#i.
      def update(x: Value, y: Value) = x.arr(i) = y
//        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#update().
//               documentation ```scala\ndef update(x: Value, y: Value): Unit\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#update().
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#update().(x)
//                 documentation ```scala\nx: Value \n```
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#update().(y)
//                           documentation ```scala\ny: Value \n```
//                            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#update().(x)
//                                       ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#arr().
//                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#i.
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.IntSelector#update().(y)
    }
    implicit class StringSelector(i: String) extends Selector{
//                 ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#
//                                documentation ```scala\nimplicit class StringSelector\n```
//                               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#`<init>`().
//                                 documentation ```scala\ndef this(i: String)\n```
//                                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#i.
//                                  documentation ```scala\nprivate[this] val i: String\n```
//                                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#`<init>`().(i)
//                                _ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#`<init>`().(i)
//                                  documentation ```scala\ni: String \n```
//                                  relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#i.
//                                   ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                   ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#
//                                                           ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
      def apply(x: Value): Value = x.obj(i)
//        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#apply().
//              documentation ```scala\ndef apply(x: Value): Value\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#apply().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#apply().(x)
//                documentation ```scala\nx: Value \n```
//                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                         ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#apply().(x)
//                                   ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#obj().
//                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#i.
      def update(x: Value, y: Value) = x.obj(i) = y
//        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#update().
//               documentation ```scala\ndef update(x: Value, y: Value): Unit\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector#update().
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#update().(x)
//                 documentation ```scala\nx: Value \n```
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Selector.StringSelector#update().(y)
//                           documentation ```scala\ny: Value \n```
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
//        documentation ```scala\n@deprecated\nval Str: Str.type\n```
//          ^^^^^ reference semanticdb maven . . ujson/
//                ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.
  @deprecated("use ujson.Str")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  type Str = ujson.Str
//     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Str#
//         documentation ```scala\ntype Str >: Str <: Str\n```
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
  @deprecated("use ujson.Obj")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Obj = ujson.Obj
//    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Obj.
//        documentation ```scala\n@deprecated\nval Obj: Obj.type\n```
//          ^^^^^ reference semanticdb maven . . ujson/
//                ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
  @deprecated("use ujson.Obj")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  type Obj = ujson.Obj
//     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Obj#
//         documentation ```scala\ntype Obj >: Obj <: Obj\n```
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
  @deprecated("use ujson.Arr")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Arr = ujson.Arr
//    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Arr.
//        documentation ```scala\n@deprecated\nval Arr: Arr.type\n```
//          ^^^^^ reference semanticdb maven . . ujson/
//                ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
  @deprecated("use ujson.Arr")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  type Arr = ujson.Arr
//     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Arr#
//         documentation ```scala\ntype Arr >: Arr <: Arr\n```
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
  @deprecated("use ujson.Num")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Num = ujson.Num
//    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num.
//        documentation ```scala\n@deprecated\nval Num: Num.type\n```
//          ^^^^^ reference semanticdb maven . . ujson/
//                ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
  @deprecated("use ujson.Num")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  type Num = ujson.Num
//     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num#
//         documentation ```scala\ntype Num >: Num <: Num\n```
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
  @deprecated("use ujson.Bool")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Bool = ujson.Bool
//    ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Bool.
//         documentation ```scala\n@deprecated\nval Bool: Bool.type\n```
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.
  @deprecated("use ujson.Bool")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  type Bool = ujson.Bool
//     ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Bool#
//          documentation ```scala\ntype Bool >: Bool <: Bool\n```
//            ^^^^^ reference semanticdb maven . . ujson/
//                  ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#
  @deprecated("use ujson.True")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val True = ujson.True
//    ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.True.
//         documentation ```scala\n@deprecated\nval True: True.type\n```
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.
  @deprecated("use ujson.False")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val False = ujson.False
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.False.
//          documentation ```scala\n@deprecated\nval False: False.type\n```
//            ^^^^^ reference semanticdb maven . . ujson/
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.
  @deprecated("use ujson.Null")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Null = ujson.Null
//    ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Null.
//         documentation ```scala\n@deprecated\nval Null: Null.type\n```
//           ^^^^^ reference semanticdb maven . . ujson/
//                 ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.
  implicit def JsonableSeq[T](items: TraversableOnce[T])
//             ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().
//                         documentation ```scala\nimplicit def JsonableSeq(items: TraversableOnce[T])(f: (T) => Value): Arr\n```
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().[T]
//                           documentation ```scala\nT\n```
//                            ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().(items)
//                                  documentation ```scala\nitems: TraversableOnce[T] \n```
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.TraversableOnce#
//                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().[T]
                             (implicit f: T => Value): Arr = Arr.from(items.map(f))
//                                     ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableSeq().(f)
//                                       documentation ```scala\nimplicit f: (T) => Value \n```
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
//                          documentation ```scala\nimplicit def JsonableDict(items: TraversableOnce[(String, T)])(f: (T) => Value): Obj\n```
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().[T]
//                            documentation ```scala\nT\n```
//                             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().(items)
//                                   documentation ```scala\nitems: TraversableOnce[(String, T)] \n```
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.TraversableOnce#
//                                                     ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().[T]
                              (implicit f: T => Value): Obj = Obj.from(items.map(x => (x._1, f(x._2))))
//                                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().(f)
//                                        documentation ```scala\nimplicit f: (T) => Value \n```
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().[T]
//                                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Obj#
//                                                            ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Obj.
//                                                                ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.from().
//                                                                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().(items)
//                                                                           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOnceExtensionMethods#map().
//                                                                               ^ definition local 11
//                                                                                 documentation ```scala\nx: (String, T) \n```
//                                                                                     ^ reference local 11
//                                                                                       ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Tuple2#_1.
//                                                                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDict().(f)
//                                                                                             ^ reference local 11
//                                                                                               ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Tuple2#_2.
  implicit def JsonableBoolean(i: Boolean): Bool = if (i) ujson.True else ujson.False
//             ^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableBoolean().
//                             documentation ```scala\nimplicit def JsonableBoolean(i: Boolean): Bool\n```
//                             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableBoolean().(i)
//                               documentation ```scala\ni: Boolean \n```
//                                ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                          ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Bool#
//                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableBoolean().(i)
//                                                        ^^^^^ reference semanticdb maven . . ujson/
//                                                              ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.
//                                                                        ^^^^^ reference semanticdb maven . . ujson/
//                                                                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.
  implicit def JsonableByte(i: Byte): Num = Num(i)
//             ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableByte().
//                          documentation ```scala\nimplicit def JsonableByte(i: Byte): Num\n```
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableByte().(i)
//                            documentation ```scala\ni: Byte \n```
//                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Byte#
//                                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num#
//                                          ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num.
//                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableByte().(i)
  implicit def JsonableShort(i: Short): Num = Num(i)
//             ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableShort().
//                           documentation ```scala\nimplicit def JsonableShort(i: Short): Num\n```
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableShort().(i)
//                             documentation ```scala\ni: Short \n```
//                              ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Short#
//                                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num#
//                                            ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num.
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableShort().(i)
  implicit def JsonableInt(i: Int): Num = Num(i)
//             ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableInt().
//                         documentation ```scala\nimplicit def JsonableInt(i: Int): Num\n```
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableInt().(i)
//                           documentation ```scala\ni: Int \n```
//                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num#
//                                        ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num.
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableInt().(i)
  implicit def JsonableLong(i: Long): Str = Str(i.toString)
//             ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableLong().
//                          documentation ```scala\nimplicit def JsonableLong(i: Long): Str\n```
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableLong().(i)
//                            documentation ```scala\ni: Long \n```
//                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Long#
//                                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Str#
//                                          ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Str.
//                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableLong().(i)
//                                                ^^^^^^^^ reference semanticdb maven . . scala/Any#toString().
  implicit def JsonableFloat(i: Float): Num = Num(i)
//             ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableFloat().
//                           documentation ```scala\nimplicit def JsonableFloat(i: Float): Num\n```
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableFloat().(i)
//                             documentation ```scala\ni: Float \n```
//                              ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Float#
//                                      ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num#
//                                            ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num.
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableFloat().(i)
  implicit def JsonableDouble(i: Double): Num = Num(i)
//             ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDouble().
//                            documentation ```scala\nimplicit def JsonableDouble(i: Double): Num\n```
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDouble().(i)
//                              documentation ```scala\ni: Double \n```
//                               ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                                        ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num#
//                                              ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Num.
//                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableDouble().(i)
  implicit def JsonableNull(i: Null): Null.type = Null
//             ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableNull().
//                          documentation ```scala\nimplicit def JsonableNull(i: Null): Null.type\n```
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableNull().(i)
//                            documentation ```scala\ni: Null \n```
//                             ^^^^ reference semanticdb maven . . scala/Null#
//                                    ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Null.
//                                                ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Null.
  implicit def JsonableString(s: CharSequence): Str = Str(s.toString)
//             ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableString().
//                            documentation ```scala\nimplicit def JsonableString(s: CharSequence): Str\n```
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableString().(s)
//                              documentation ```scala\ns: CharSequence \n```
//                               ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                              ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Str#
//                                                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Str.
//                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.JsonableString().(s)
//                                                          ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#toString().


  def transform[T](j: Value, f: Visitor[_, T]): T = {
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().
//              documentation ```scala\ndef transform(j: Value, f: Visitor[local12, T[): T\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().[T]
//                documentation ```scala\nT\n```
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(j)
//                   documentation ```scala\nj: Value \n```
//                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                             documentation ```scala\nf: Visitor[local12, T[ \n```
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
//                     documentation ```scala\ns: String \n```
//                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                           ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                       ^ reference local 13
      case ujson.Num(d) => f.visitFloat64(d, -1)
//         ^^^^^ reference semanticdb maven . . ujson/
//               ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
//                   ^ definition local 14
//                     documentation ```scala\nd: Double \n```
//                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                           ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64().
//                                        ^ reference local 14
      case ujson.Arr(items) => transformArray(f, items)
//         ^^^^^ reference semanticdb maven . . ujson/
//               ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
//                   ^^^^^ definition local 15
//                         documentation ```scala\nitems: ArrayBuffer[Value] \n```
//                             ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                                               ^^^^^ reference local 15
      case ujson.Obj(items) => transformObject(f, items)
//         ^^^^^ reference semanticdb maven . . ujson/
//               ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
//                   ^^^^^ definition local 16
//                         documentation ```scala\nitems: LinkedHashMap[String, Value] \n```
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().
//                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().(f)
//                                                ^^^^^ reference local 16
    }
  }

  def visitArray(length: Int, index: Int) = new AstArrVisitor[ArrayBuffer](xs => ujson.Arr(xs))
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitArray().
//               documentation ```scala\ndef visitArray(length: Int, index: Int): AstArrVisitor[ArrayBuffer]\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//               ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitArray().(length)
//                      documentation ```scala\nlength: Int \n```
//                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                            ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitArray().(index)
//                                  documentation ```scala\nindex: Int \n```
//                                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                              ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#
//                                                            ^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/ArrayBuffer#
//                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#`<init>`().
//                                                                         ^^ definition local 17
//                                                                            documentation ```scala\nxs: ArrayBuffer[Value] \n```
//                                                                               ^^^^^ reference semanticdb maven . . ujson/
//                                                                                     ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
//                                                                                         ^^ reference local 17

  def visitObject(length: Int, index: Int) = new AstObjVisitor[mutable.LinkedHashMap[String, Value]](xs => ujson.Obj(xs))
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitObject().
//                documentation ```scala\ndef visitObject(length: Int, index: Int): AstObjVisitor[LinkedHashMap[String, Value]]\n```
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitObject().
//                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitObject().(length)
//                       documentation ```scala\nlength: Int \n```
//                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitObject().(index)
//                                   documentation ```scala\nindex: Int \n```
//                                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                               ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#
//                                                             ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                                                                     ^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/LinkedHashMap#
//                                                                                   ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                                                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`<init>`().
//                                                                                                   ^^ definition local 18
//                                                                                                      documentation ```scala\nxs: LinkedHashMap[String, Value] \n```
//                                                                                                         ^^^^^ reference semanticdb maven . . ujson/
//                                                                                                               ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
//                                                                                                                   ^^ reference local 18

  def visitNull(index: Int) = ujson.Null
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitNull().
//              documentation ```scala\ndef visitNull(index: Int): Null\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitNull().
//              ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitNull().(index)
//                    documentation ```scala\nindex: Int \n```
//                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                            ^^^^^ reference semanticdb maven . . ujson/
//                                  ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.

  def visitFalse(index: Int) = ujson.False
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFalse().
//               documentation ```scala\ndef visitFalse(index: Int): False\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFalse().
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFalse().(index)
//                     documentation ```scala\nindex: Int \n```
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                             ^^^^^ reference semanticdb maven . . ujson/
//                                   ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.

  def visitTrue(index: Int) = True
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitTrue().
//              documentation ```scala\ndef visitTrue(index: Int): True\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitTrue().
//              ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitTrue().(index)
//                    documentation ```scala\nindex: Int \n```
//                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                            ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.True.


  override def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int) = {
//             ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().
//                                     documentation ```scala\ndef visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int): Num\n```
//                                     relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64StringParts().
//                                     ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(s)
//                                       documentation ```scala\ns: CharSequence \n```
//                                        ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                                      ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(decIndex)
//                                                               documentation ```scala\ndecIndex: Int \n```
//                                                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                     ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(expIndex)
//                                                                              documentation ```scala\nexpIndex: Int \n```
//                                                                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                                    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64StringParts().(index)
//                                                                                          documentation ```scala\nindex: Int \n```
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
//                          documentation ```scala\ndef visitFloat64(d: Double, index: Int): Num\n```
//                          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64().
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64().(d)
//                            documentation ```scala\nd: Double \n```
//                             ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                                     ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64().(index)
//                                           documentation ```scala\nindex: Int \n```
//                                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                   ^^^^^ reference semanticdb maven . . ujson/
//                                                         ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
//                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitFloat64().(d)

  def visitString(s: CharSequence, index: Int) = ujson.Str(s.toString)
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitString().
//                documentation ```scala\ndef visitString(s: CharSequence, index: Int): Str\n```
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitString().(s)
//                  documentation ```scala\ns: CharSequence \n```
//                   ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                 ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.visitString().(index)
//                                       documentation ```scala\nindex: Int \n```
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
//                       documentation ```scala\ncase class InvalidData(data: Value, msg: String) extends Exception\n```
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().
//           ___________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().
//                       documentation ```scala\ndef copy(data: Value, msg: String): InvalidData\n```
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().
//           ___________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.
//                       documentation ```scala\nobject InvalidData\n```
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().
//           ___________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().
//                       documentation ```scala\ndef apply(data: Value, msg: String): InvalidData\n```
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#
//                       relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//           ___________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#productElementName().
//                       documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().
//                       relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//           ___________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#productElement().
//                       documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().
//                       relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().
//                        documentation ```scala\ndef this(data: Value, msg: String)\n```
//                       ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#data.
//                            documentation ```scala\nval data: Value\n```
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(data)
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(data)
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(data)
//                       ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(data)
//                            documentation ```scala\ndata: Value \n```
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(data)
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(data)
//                            relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#data.
//                       ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(data)
//                            documentation ```scala\ndata: Value \n```
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(data)
//                            relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#data.
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(data)
//                       ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(data)
//                            documentation ```scala\ndefault data: Value \n```
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(data)
//                            relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#data.
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(data)
//                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#msg.
//                                        documentation ```scala\nval msg: String\n```
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(msg)
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(msg)
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(msg)
//                                    ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(msg)
//                                        documentation ```scala\nmsg: String \n```
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(msg)
//                                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#msg.
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(msg)
//                                    ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#copy().(msg)
//                                        documentation ```scala\ndefault msg: String \n```
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#`<init>`().(msg)
//                                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData#msg.
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(msg)
//                                    ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.InvalidData.apply().(msg)
//                                        documentation ```scala\nmsg: String \n```
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
//             documentation ```scala\ncase class Str(value: String) extends Value\n```
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#productElement().
//             documentation ```scala\ndef productElement(x$1: Int): Any\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#copy().
//             documentation ```scala\ndef copy(value: String): Str\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.
//             documentation ```scala\nobject Str\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#productElementName().
//             documentation ```scala\ndef productElementName(x$1: Int): String\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().
//             documentation ```scala\ndef apply(value: String): Str\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function1#apply().
//            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#`<init>`().
//              documentation ```scala\ndef this(value: String)\n```
//             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#value.
//                   documentation ```scala\nval value: String\n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#copy().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().(value)
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().(value)
//                   documentation ```scala\nvalue: String \n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#value.
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#`<init>`().(value)
//                   documentation ```scala\nvalue: String \n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().(value)
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#copy().(value)
//                   documentation ```scala\ndefault value: String \n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#`<init>`().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Str.apply().(value)
//                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                         ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
case class Obj(value: mutable.LinkedHashMap[String, Value]) extends Value
//         ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
//             documentation ```scala\ncase class Obj(value: LinkedHashMap[String, Value]) extends Value\n```
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#productElementName().
//             documentation ```scala\ndef productElementName(x$1: Int): String\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#productElement().
//             documentation ```scala\ndef productElement(x$1: Int): Any\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#copy().
//             documentation ```scala\ndef copy(value: LinkedHashMap[String, Value]): Obj\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
//            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#`<init>`().
//              documentation ```scala\ndef this(value: LinkedHashMap[String, Value])\n```
//             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#value.
//                   documentation ```scala\nval value: LinkedHashMap[String, Value]\n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#copy().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply(+2).(value)
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply(+2).(value)
//                   documentation ```scala\nvalue: LinkedHashMap[String, Value] \n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#value.
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#`<init>`().(value)
//                   documentation ```scala\nvalue: LinkedHashMap[String, Value] \n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply(+2).(value)
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#copy().(value)
//                   documentation ```scala\ndefault value: LinkedHashMap[String, Value] \n```
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
//         documentation ```scala\nobject Obj\n```
//     ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply(+2).
//         documentation ```scala\ndef apply(value: LinkedHashMap[String, Value]): Obj\n```
//         relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.
  implicit def from(items: TraversableOnce[(String, Value)]): Obj = {
//             ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.from().
//                  documentation ```scala\nimplicit def from(items: TraversableOnce[(String, Value)]): Obj\n```
//                  ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.from().(items)
//                        documentation ```scala\nitems: TraversableOnce[(String, Value)] \n```
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
//          documentation ```scala\ndef apply(item: (String, V), items: (String, Value)*)(conv: (V) => Value): Obj\n```
//          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().[V]
//            documentation ```scala\nV\n```
//             ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().(item)
//                  documentation ```scala\nitem: (String, V) \n```
//                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().[V]
                        items: (String, Value)*)(implicit conv: V => Value): Obj = {
//                      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().(items)
//                            documentation ```scala\nitems: (String, Value)* \n```
//                              ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                      ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                        ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().(conv)
//                                                             documentation ```scala\nimplicit conv: (V) => Value \n```
//                                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj.apply().[V]
//                                                                   ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                                           ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Obj#
    val map = new mutable.LinkedHashMap[String, Value]()
//      ^^^ definition local 22
//          documentation ```scala\nmap: LinkedHashMap[String, Value] \n```
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
//         documentation ```scala\ni: (String, Value) \n```
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
//          documentation ```scala\ndef apply(): Obj\n```
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
//             documentation ```scala\ncase class Arr(value: ArrayBuffer[Value]) extends Value\n```
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#productElement().
//             documentation ```scala\ndef productElement(x$1: Int): Any\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#productElementName().
//             documentation ```scala\ndef productElementName(x$1: Int): String\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#copy().
//             documentation ```scala\ndef copy(value: ArrayBuffer[Value]): Arr\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
//            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#`<init>`().
//              documentation ```scala\ndef this(value: ArrayBuffer[Value])\n```
//             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#value.
//                   documentation ```scala\nval value: ArrayBuffer[Value]\n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#copy().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply(+1).(value)
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#`<init>`().(value)
//                   documentation ```scala\nvalue: ArrayBuffer[Value] \n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply(+1).(value)
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#copy().(value)
//                   documentation ```scala\ndefault value: ArrayBuffer[Value] \n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#`<init>`().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply(+1).(value)
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply(+1).(value)
//                   documentation ```scala\nvalue: ArrayBuffer[Value] \n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#value.
//                    ^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/ArrayBuffer#
//                                ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#

//^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
object Arr{
//     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
//         documentation ```scala\nobject Arr\n```
//     ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply(+1).
//         documentation ```scala\ndef apply(value: ArrayBuffer[Value]): Arr\n```
//         relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.
  implicit def from[T](items: TraversableOnce[T])(implicit conv: T => Value): Arr = {
//             ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().
//                  documentation ```scala\nimplicit def from(items: TraversableOnce[T])(conv: (T) => Value): Arr\n```
//                  ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().[T]
//                    documentation ```scala\nT\n```
//                     ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().(items)
//                           documentation ```scala\nitems: TraversableOnce[T] \n```
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.TraversableOnce#
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().[T]
//                                                         ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().(conv)
//                                                              documentation ```scala\nimplicit conv: (T) => Value \n```
//                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().[T]
//                                                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                                                            ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
    val buf = new mutable.ArrayBuffer[Value]()
//      ^^^ definition local 25
//          documentation ```scala\nbuf: ArrayBuffer[Value] \n```
//                ^^^^^^^ reference semanticdb maven . . scala/collection/mutable/
//                        ^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/ArrayBuffer#
//                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                          ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/ArrayBuffer#`<init>`(+1).
    items.foreach{ item =>
//  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.from().(items)
//        ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOnceExtensionMethods#foreach().
//                 ^^^^ definition local 26
//                      documentation ```scala\nitem: T \n```
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
//          documentation ```scala\ndef apply(items: Value*): Arr\n```
//          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr.apply().(items)
//                documentation ```scala\nitems: Value* \n```
//                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                          ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Arr#
    val buf = new mutable.ArrayBuffer[Value](items.length)
//      ^^^ definition local 27
//          documentation ```scala\nbuf: ArrayBuffer[Value] \n```
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
//                      documentation ```scala\nitem: Value \n```
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
//             documentation ```scala\ncase class Num(value: Double) extends Value\n```
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#productElement().
//             documentation ```scala\ndef productElement(x$1: Int): Any\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#copy().
//             documentation ```scala\ndef copy(value: Double): Num\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().
//             documentation ```scala\ndef apply(value: Double): Num\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function1#apply().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#productElementName().
//             documentation ```scala\ndef productElementName(x$1: Int): String\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().
//             relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.
//             documentation ```scala\nobject Num\n```
//             relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#
//             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().
//            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#`<init>`().
//              documentation ```scala\ndef this(value: Double)\n```
//             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#value.
//                   documentation ```scala\nval value: Double\n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#copy().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().(value)
//                   relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().(value)
//                   documentation ```scala\nvalue: Double \n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#`<init>`().(value)
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#value.
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#copy().(value)
//                   documentation ```scala\ndefault value: Double \n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#`<init>`().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().(value)
//             _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#`<init>`().(value)
//                   documentation ```scala\nvalue: Double \n```
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#copy().(value)
//                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num#value.
//                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Num.apply().(value)
//                    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                         ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
sealed abstract class Bool extends Value{
//                    ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#
//                         documentation ```scala\nabstract sealed class Bool\n```
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#`<init>`().
//                           documentation ```scala\ndef this()\n```
//                                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                                      ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  def value: Boolean
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#value().
//          documentation ```scala\ndef value: Boolean\n```
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.value().
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.value().
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
//           ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
}
object Bool{
//     ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.
//          documentation ```scala\nobject Bool\n```
  def apply(value: Boolean): Bool = if (value) True else False
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.apply().
//          documentation ```scala\ndef apply(value: Boolean): Bool\n```
//          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.apply().(value)
//                documentation ```scala\nvalue: Boolean \n```
//                 ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                           ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#
//                                      ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.apply().(value)
//                                             ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.
//                                                       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.
  def unapply(bool: Bool): Option[Boolean] = Some(bool.value)
//    ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.unapply().
//            documentation ```scala\ndef unapply(bool: Bool): Option[Boolean]\n```
//            ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.unapply().(bool)
//                 documentation ```scala\nbool: Bool \n```
//                  ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#
//                         ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Option#
//                                ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                           ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Some.
//                                                ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool.unapply().(bool)
//                                                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#value().
}
case object False extends Bool{
//          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.
//                documentation ```scala\ncase object False\n```
//          _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.productElement().
//                documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.
//                relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//                        ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#
//                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#`<init>`().
  def value = false
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/False.value().
//          documentation ```scala\ndef value: Boolean\n```
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#value().
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
}
case object True extends Bool{
//          ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.
//               documentation ```scala\ncase object True\n```
//          ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.productElement().
//               documentation ```scala\ndef productElement(x$1: Int): Any\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//                       ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#
//                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#`<init>`().
  def value = true
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/True.value().
//          documentation ```scala\ndef value: Boolean\n```
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Bool#value().
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
}
case object Null extends Value{
//          ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.
//               documentation ```scala\ncase object Null\n```
//          ____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.productElement().
//               documentation ```scala\ndef productElement(x$1: Int): Any\n```
//               relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.
//               relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//                       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
//                            ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  def value = null
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Null.value().
//          documentation ```scala\ndef value: Null\n```
//          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#value().
}
