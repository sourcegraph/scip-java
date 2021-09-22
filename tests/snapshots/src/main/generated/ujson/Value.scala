package ujson
//      ^^^^^ definition ujson/



import upickle.core.Util
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                  ^^^^ reference upickle/core/Util.
import upickle.core.{ObjArrVisitor, Visitor}
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                   ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                  ^^^^^^^ reference upickle/core/Visitor.
//                                  ^^^^^^^ reference upickle/core/Visitor#

import upickle.core.compat._
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                  ^^^^^^ reference upickle/core/compat/
import scala.collection.mutable
//     ^^^^^ reference scala/
//           ^^^^^^^^^^ reference scala/collection/
//                      ^^^^^^^ reference scala/collection/mutable/
import scala.collection.mutable.ArrayBuffer
//     ^^^^^ reference scala/
//           ^^^^^^^^^^ reference scala/collection/
//                      ^^^^^^^ reference scala/collection/mutable/
//                              ^^^^^^^^^^^ reference scala/collection/mutable/ArrayBuffer.
//                              ^^^^^^^^^^^ reference scala/collection/mutable/ArrayBuffer#

sealed trait Value extends Readable with geny.Writable{
//           ^^^^^ definition ujson/Value#
//                         ^^^^^^^^ reference ujson/Readable#
//                                       ^^^^ reference geny/
//                                            ^^^^^^^^ reference geny/Writable#
  override def httpContentType = Some("application/json")
//             ^^^^^^^^^^^^^^^ definition ujson/Value#httpContentType().
//                               ^^^^ reference scala/Some.
//                                    reference scala/Some.apply().
  def value: Any
//    ^^^^^ definition ujson/Value#value().
//           ^^^ reference scala/Any#

  /**
    * Returns the `String` value of this [[Value]], fails if it is not
    * a [[ujson.Str]]
    */
  def str = this match{
//    ^^^ definition ujson/Value#str().
    case ujson.Str(value) => value
//       ^^^^^ reference ujson/
//             ^^^ reference ujson/Str.
//                 ^^^^^ definition local0
//                           ^^^^^ reference local0
    case _ => throw Value.InvalidData(this, "Expected ujson.Str")
//                  ^^^^^ reference ujson/Value.
//                        ^^^^^^^^^^^ reference ujson/Value.InvalidData.
//                                    reference ujson/Value.InvalidData.apply().
  }

  /**
    * Returns an Optional `String` value of this [[Value]] in case this [[Value]] is a 'String'.
    */
  def strOpt = this match{
//    ^^^^^^ definition ujson/Value#strOpt().
    case Str(value) => Some(value)
//       ^^^ reference ujson/Str.
//           ^^^^^ definition local1
//                     ^^^^ reference scala/Some.
//                          reference scala/Some.apply().
//                          ^^^^^ reference local1
    case _ => None
//            ^^^^ reference scala/None.
  }

  /**
    * Returns the key/value map of this [[Value]], fails if it is not
    * a [[ujson.Obj]]
    */
  def obj = this match{
//    ^^^ definition ujson/Value#obj().
    case ujson.Obj(value) => value
//       ^^^^^ reference ujson/
//             ^^^ reference ujson/Obj.
//                 ^^^^^ definition local2
//                           ^^^^^ reference local2
    case _ => throw Value.InvalidData(this, "Expected ujson.Obj")
//                  ^^^^^ reference ujson/Value.
//                        ^^^^^^^^^^^ reference ujson/Value.InvalidData.
//                                    reference ujson/Value.InvalidData.apply().
  }
  /**
    * Returns an Optional key/value map of this [[Value]] in case this [[Value]] is a 'Obj'.
    */
  def objOpt = this match{
//    ^^^^^^ definition ujson/Value#objOpt().
    case Obj(value) => Some(value)
//       ^^^ reference ujson/Obj.
//           ^^^^^ definition local3
//                     ^^^^ reference scala/Some.
//                          reference scala/Some.apply().
//                          ^^^^^ reference local3
    case _ => None
//            ^^^^ reference scala/None.
  }
  /**
    * Returns the elements of this [[Value]], fails if it is not
    * a [[ujson.Arr]]
    */
  def arr = this match{
//    ^^^ definition ujson/Value#arr().
    case ujson.Arr(value) => value
//       ^^^^^ reference ujson/
//             ^^^ reference ujson/Arr.
//                 ^^^^^ definition local4
//                           ^^^^^ reference local4
    case _ => throw Value.InvalidData(this, "Expected ujson.Arr")
//                  ^^^^^ reference ujson/Value.
//                        ^^^^^^^^^^^ reference ujson/Value.InvalidData.
//                                    reference ujson/Value.InvalidData.apply().
  }
  /**
    * Returns The optional elements of this [[Value]] in case this [[Value]] is a 'Arr'.
    */
  def arrOpt = this match{
//    ^^^^^^ definition ujson/Value#arrOpt().
    case Arr(value) => Some(value)
//       ^^^ reference ujson/Arr.
//           ^^^^^ definition local5
//                     ^^^^ reference scala/Some.
//                          reference scala/Some.apply().
//                          ^^^^^ reference local5
    case _ => None
//            ^^^^ reference scala/None.
  }
  /**
    * Returns the `Double` value of this [[Value]], fails if it is not
    * a [[ujson.Num]]
    */
  def num = this match{
//    ^^^ definition ujson/Value#num().
    case ujson.Num(value) => value
//       ^^^^^ reference ujson/
//             ^^^ reference ujson/Num.
//                 ^^^^^ definition local6
//                           ^^^^^ reference local6
    case _ => throw Value.InvalidData(this, "Expected ujson.Num")
//                  ^^^^^ reference ujson/Value.
//                        ^^^^^^^^^^^ reference ujson/Value.InvalidData.
//                                    reference ujson/Value.InvalidData.apply().
  }
  /**
    * Returns an Option[Double] in case this [[Value]] is a 'Num'.
    */
  def numOpt = this match{
//    ^^^^^^ definition ujson/Value#numOpt().
    case Num(value) => Some(value)
//       ^^^ reference ujson/Num.
//           ^^^^^ definition local7
//                     ^^^^ reference scala/Some.
//                          reference scala/Some.apply().
//                          ^^^^^ reference local7
    case _ => None
//            ^^^^ reference scala/None.
  }
  /**
    * Returns the `Boolean` value of this [[Value]], fails if it is not
    * a [[ujson.Bool]]
    */
  def bool = this match{
//    ^^^^ definition ujson/Value#bool().
    case ujson.Bool(value) => value
//       ^^^^^ reference ujson/
//             ^^^^ reference ujson/Bool.
//                  reference ujson/Bool.unapply().
//                  ^^^^^ definition local8
//                            ^^^^^ reference local8
    case _ => throw Value.InvalidData(this, "Expected ujson.Bool")
//                  ^^^^^ reference ujson/Value.
//                        ^^^^^^^^^^^ reference ujson/Value.InvalidData.
//                                    reference ujson/Value.InvalidData.apply().
  }
  /**
    * Returns an Optional `Boolean` value of this [[Value]] in case this [[Value]] is a 'Bool'.
    */
  def boolOpt = this match{
//    ^^^^^^^ definition ujson/Value#boolOpt().
    case Bool(value) => Some(value)
//       ^^^^ reference ujson/Bool.
//            reference ujson/Bool.unapply().
//            ^^^^^ definition local9
//                      ^^^^ reference scala/Some.
//                           reference scala/Some.apply().
//                           ^^^^^ reference local9
    case _ => None
//            ^^^^ reference scala/None.
  }
  /**
    * Returns true if the value of this [[Value]] is ujson.Null, false otherwise
    */
  def isNull = this match {
//    ^^^^^^ definition ujson/Value#isNull().
    case ujson.Null => true
//       ^^^^^ reference ujson/
//             ^^^^ reference ujson/Null.
    case _ => false
  }

  def apply(s: Value.Selector): Value = s(this)
//    ^^^^^ definition ujson/Value#apply().
//          ^ definition ujson/Value#apply().(s)
//             ^^^^^ reference ujson/Value.
//                   ^^^^^^^^ reference ujson/Value.Selector#
//                              ^^^^^ reference ujson/Value#
//                                      ^ reference ujson/Value#apply().(s)
//                                        reference ujson/Value.Selector#apply().
  def update(s: Value.Selector, v: Value): Unit = s(this) = v
//    ^^^^^^ definition ujson/Value#update().
//           ^ definition ujson/Value#update().(s)
//              ^^^^^ reference ujson/Value.
//                    ^^^^^^^^ reference ujson/Value.Selector#
//                              ^ definition ujson/Value#update().(v)
//                                 ^^^^^ reference ujson/Value#
//                                         ^^^^ reference scala/Unit#
//                                                ^ reference ujson/Value#update().(s)
//                                                  reference ujson/Value.Selector#update().
//                                                          ^ reference ujson/Value#update().(v)

  /**
    * Update a value in-place. Takes an `Int` or a `String`, through the
    * implicitly-constructe [[Value.Selector]] type.
    *
    * We cannot just overload `update` on `s: Int` and `s: String` because
    * of type inference problems in Scala 2.11.
    */
  def update(s: Value.Selector, f: Value => Value): Unit = s(this) = f(s(this))
//    ^^^^^^ definition ujson/Value#update(+1).
//           ^ definition ujson/Value#update(+1).(s)
//              ^^^^^ reference ujson/Value.
//                    ^^^^^^^^ reference ujson/Value.Selector#
//                              ^ definition ujson/Value#update(+1).(f)
//                                 ^^^^^ reference ujson/Value#
//                                          ^^^^^ reference ujson/Value#
//                                                  ^^^^ reference scala/Unit#
//                                                         ^ reference ujson/Value#update(+1).(s)
//                                                           reference ujson/Value.Selector#update().
//                                                                   ^ reference ujson/Value#update(+1).(f)
//                                                                     reference scala/Function1#apply().
//                                                                     ^ reference ujson/Value#update(+1).(s)
//                                                                       reference ujson/Value.Selector#apply().

  def transform[T](f: Visitor[_, T]) = Value.transform(this, f)
//    ^^^^^^^^^ definition ujson/Value#transform().
//              ^ definition ujson/Value#transform().[T]
//                 ^ definition ujson/Value#transform().(f)
//                    ^^^^^^^ reference upickle/core/Visitor#
//                               ^ reference ujson/Value#transform().[T]
//                                     ^^^^^ reference ujson/Value.
//                                           ^^^^^^^^^ reference ujson/Value.transform().
//                                                           ^ reference ujson/Value#transform().(f)
  override def toString = render()
//             ^^^^^^^^ definition ujson/Value#toString().
//                        ^^^^^^ reference ujson/Value#render().
  def render(indent: Int = -1, escapeUnicode: Boolean = false) = this.transform(StringRenderer(indent, escapeUnicode)).toString
//    ^^^^^^ definition ujson/Value#render().
//           ^^^^^^ definition ujson/Value#render().(indent)
//                   ^^^ reference scala/Int#
//                             ^^^^^^^^^^^^^ definition ujson/Value#render().(escapeUnicode)
//                                            ^^^^^^^ reference scala/Boolean#
//                                                                    ^^^^^^^^^ reference ujson/Value#transform().
//                                                                              ^^^^^^^^^^^^^^ reference ujson/StringRenderer.
//                                                                                             reference ujson/StringRenderer.apply().
//                                                                                             ^^^^^^ reference ujson/Value#render().(indent)
//                                                                                                     ^^^^^^^^^^^^^ reference ujson/Value#render().(escapeUnicode)
//                                                                                                                     ^^^^^^^^ reference java/io/StringWriter#toString().

  def writeBytesTo(out: java.io.OutputStream, indent: Int = -1, escapeUnicode: Boolean = false): Unit = {
//    ^^^^^^^^^^^^ definition ujson/Value#writeBytesTo().
//                 ^^^ definition ujson/Value#writeBytesTo().(out)
//                      ^^^^ reference java/
//                           ^^ reference java/io/
//                              ^^^^^^^^^^^^ reference java/io/OutputStream#
//                                            ^^^^^^ definition ujson/Value#writeBytesTo().(indent)
//                                                    ^^^ reference scala/Int#
//                                                              ^^^^^^^^^^^^^ definition ujson/Value#writeBytesTo().(escapeUnicode)
//                                                                             ^^^^^^^ reference scala/Boolean#
//                                                                                               ^^^^ reference scala/Unit#
    this.transform(new ujson.BaseByteRenderer(out, indent, escapeUnicode))
//       ^^^^^^^^^ reference ujson/Value#transform().
//                     ^^^^^ reference ujson/
//                           ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#
//                                            reference ujson/BaseByteRenderer#`<init>`().
//                                            ^^^ reference ujson/Value#writeBytesTo().(out)
//                                                 ^^^^^^ reference ujson/Value#writeBytesTo().(indent)
//                                                         ^^^^^^^^^^^^^ reference ujson/Value#writeBytesTo().(escapeUnicode)
  }
  def writeBytesTo(out: java.io.OutputStream): Unit = writeBytesTo(out, -1, false)
//    ^^^^^^^^^^^^ definition ujson/Value#writeBytesTo(+1).
//                 ^^^ definition ujson/Value#writeBytesTo(+1).(out)
//                      ^^^^ reference java/
//                           ^^ reference java/io/
//                              ^^^^^^^^^^^^ reference java/io/OutputStream#
//                                             ^^^^ reference scala/Unit#
//                                                    ^^^^^^^^^^^^ reference ujson/Value#writeBytesTo().
//                                                                 ^^^ reference ujson/Value#writeBytesTo(+1).(out)
}

/**
* A very small, very simple JSON AST that uPickle uses as part of its
* serialization process. A common standard between the Jawn AST (which
* we don't use so we don't pull in the bulk of Spire) and the Javascript
* JSON AST.
*/
object Value extends AstTransformer[Value]{
//     ^^^^^ definition ujson/Value.
//                   ^^^^^^^^^^^^^^ reference ujson/AstTransformer#
//                                  ^^^^^ reference ujson/Value#
//                                         reference java/lang/Object#`<init>`().
  type Value = ujson.Value
//     ^^^^^ definition ujson/Value.Value#
//             ^^^^^ reference ujson/
//                   ^^^^^ reference ujson/Value#
  sealed trait Selector{
//             ^^^^^^^^ definition ujson/Value.Selector#
    def apply(x: Value): Value
//      ^^^^^ definition ujson/Value.Selector#apply().
//            ^ definition ujson/Value.Selector#apply().(x)
//               ^^^^^ reference ujson/Value.Value#
//                       ^^^^^ reference ujson/Value.Value#
    def update(x: Value, y: Value): Unit
//      ^^^^^^ definition ujson/Value.Selector#update().
//             ^ definition ujson/Value.Selector#update().(x)
//                ^^^^^ reference ujson/Value.Value#
//                       ^ definition ujson/Value.Selector#update().(y)
//                          ^^^^^ reference ujson/Value.Value#
//                                  ^^^^ reference scala/Unit#
  }
  object Selector{
//       ^^^^^^^^ definition ujson/Value.Selector.
    implicit class IntSelector(i: Int) extends Selector{
//                 ^^^^^^^^^^^ definition ujson/Value.Selector.IntSelector#
//                             definition ujson/Value.Selector.IntSelector#`<init>`().
//                             ^ definition ujson/Value.Selector.IntSelector#i.
//                                ^^^ reference scala/Int#
//                                             ^^^^^^^^ reference ujson/Value.Selector#
//                                                      reference java/lang/Object#`<init>`().
      def apply(x: Value): Value = x.arr(i)
//        ^^^^^ definition ujson/Value.Selector.IntSelector#apply().
//              ^ definition ujson/Value.Selector.IntSelector#apply().(x)
//                 ^^^^^ reference ujson/Value.Value#
//                         ^^^^^ reference ujson/Value.Value#
//                                 ^ reference ujson/Value.Selector.IntSelector#apply().(x)
//                                   ^^^ reference ujson/Value#arr().
//                                       reference scala/collection/mutable/ArrayBuffer#apply().
//                                       ^ reference ujson/Value.Selector.IntSelector#i.
      def update(x: Value, y: Value) = x.arr(i) = y
//        ^^^^^^ definition ujson/Value.Selector.IntSelector#update().
//               ^ definition ujson/Value.Selector.IntSelector#update().(x)
//                  ^^^^^ reference ujson/Value.Value#
//                         ^ definition ujson/Value.Selector.IntSelector#update().(y)
//                            ^^^^^ reference ujson/Value.Value#
//                                     ^ reference ujson/Value.Selector.IntSelector#update().(x)
//                                       ^^^ reference ujson/Value#arr().
//                                           reference scala/collection/mutable/ArrayBuffer#update().
//                                           ^ reference ujson/Value.Selector.IntSelector#i.
//                                                ^ reference ujson/Value.Selector.IntSelector#update().(y)
    }
    implicit class StringSelector(i: String) extends Selector{
//                 ^^^^^^^^^^^^^^ definition ujson/Value.Selector.StringSelector#
//                                definition ujson/Value.Selector.StringSelector#`<init>`().
//                                ^ definition ujson/Value.Selector.StringSelector#i.
//                                   ^^^^^^ reference scala/Predef.String#
//                                                   ^^^^^^^^ reference ujson/Value.Selector#
//                                                            reference java/lang/Object#`<init>`().
      def apply(x: Value): Value = x.obj(i)
//        ^^^^^ definition ujson/Value.Selector.StringSelector#apply().
//              ^ definition ujson/Value.Selector.StringSelector#apply().(x)
//                 ^^^^^ reference ujson/Value.Value#
//                         ^^^^^ reference ujson/Value.Value#
//                                 ^ reference ujson/Value.Selector.StringSelector#apply().(x)
//                                   ^^^ reference ujson/Value#obj().
//                                       reference scala/collection/MapOps#apply().
//                                       ^ reference ujson/Value.Selector.StringSelector#i.
      def update(x: Value, y: Value) = x.obj(i) = y
//        ^^^^^^ definition ujson/Value.Selector.StringSelector#update().
//               ^ definition ujson/Value.Selector.StringSelector#update().(x)
//                  ^^^^^ reference ujson/Value.Value#
//                         ^ definition ujson/Value.Selector.StringSelector#update().(y)
//                            ^^^^^ reference ujson/Value.Value#
//                                     ^ reference ujson/Value.Selector.StringSelector#update().(x)
//                                       ^^^ reference ujson/Value#obj().
//                                           reference scala/collection/mutable/LinkedHashMap#update().
//                                           ^ reference ujson/Value.Selector.StringSelector#i.
//                                                ^ reference ujson/Value.Selector.StringSelector#update().(y)
    }
  }

  @deprecated("use ujson.Str")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Str = ujson.Str
//    ^^^ definition ujson/Value.Str.
//          ^^^^^ reference ujson/
//                ^^^ reference ujson/Str.
  @deprecated("use ujson.Str")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  type Str = ujson.Str
//     ^^^ definition ujson/Value.Str#
//           ^^^^^ reference ujson/
//                 ^^^ reference ujson/Str#
  @deprecated("use ujson.Obj")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Obj = ujson.Obj
//    ^^^ definition ujson/Value.Obj.
//          ^^^^^ reference ujson/
//                ^^^ reference ujson/Obj.
  @deprecated("use ujson.Obj")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  type Obj = ujson.Obj
//     ^^^ definition ujson/Value.Obj#
//           ^^^^^ reference ujson/
//                 ^^^ reference ujson/Obj#
  @deprecated("use ujson.Arr")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Arr = ujson.Arr
//    ^^^ definition ujson/Value.Arr.
//          ^^^^^ reference ujson/
//                ^^^ reference ujson/Arr.
  @deprecated("use ujson.Arr")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  type Arr = ujson.Arr
//     ^^^ definition ujson/Value.Arr#
//           ^^^^^ reference ujson/
//                 ^^^ reference ujson/Arr#
  @deprecated("use ujson.Num")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Num = ujson.Num
//    ^^^ definition ujson/Value.Num.
//          ^^^^^ reference ujson/
//                ^^^ reference ujson/Num.
  @deprecated("use ujson.Num")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  type Num = ujson.Num
//     ^^^ definition ujson/Value.Num#
//           ^^^^^ reference ujson/
//                 ^^^ reference ujson/Num#
  @deprecated("use ujson.Bool")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Bool = ujson.Bool
//    ^^^^ definition ujson/Value.Bool.
//           ^^^^^ reference ujson/
//                 ^^^^ reference ujson/Bool.
  @deprecated("use ujson.Bool")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  type Bool = ujson.Bool
//     ^^^^ definition ujson/Value.Bool#
//            ^^^^^ reference ujson/
//                  ^^^^ reference ujson/Bool#
  @deprecated("use ujson.True")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val True = ujson.True
//    ^^^^ definition ujson/Value.True.
//           ^^^^^ reference ujson/
//                 ^^^^ reference ujson/True.
  @deprecated("use ujson.False")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val False = ujson.False
//    ^^^^^ definition ujson/Value.False.
//            ^^^^^ reference ujson/
//                  ^^^^^ reference ujson/False.
  @deprecated("use ujson.Null")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Null = ujson.Null
//    ^^^^ definition ujson/Value.Null.
//           ^^^^^ reference ujson/
//                 ^^^^ reference ujson/Null.
  implicit def JsonableSeq[T](items: TraversableOnce[T])
//             ^^^^^^^^^^^ definition ujson/Value.JsonableSeq().
//                         ^ definition ujson/Value.JsonableSeq().[T]
//                            ^^^^^ definition ujson/Value.JsonableSeq().(items)
//                                   ^^^^^^^^^^^^^^^ reference scala/package.TraversableOnce#
//                                                   ^ reference ujson/Value.JsonableSeq().[T]
                             (implicit f: T => Value): Arr = Arr.from(items.map(f))
//                                     ^ definition ujson/Value.JsonableSeq().(f)
//                                        ^ reference ujson/Value.JsonableSeq().[T]
//                                             ^^^^^ reference ujson/Value.Value#
//                                                     ^^^ reference ujson/Value.Arr#
//                                                           ^^^ reference ujson/Value.Arr.
//                                                               ^^^^ reference ujson/Arr.from().
//                                                                    ^^^^^ reference ujson/Value.JsonableSeq().(items)
//                                                                          reference scala/collection/IterableOnce.
//                                                                          reference scala/collection/IterableOnce.iterableOnceExtensionMethods().
//                                                                          ^^^ reference scala/collection/IterableOnceExtensionMethods#map().
//                                                                              ^ reference ujson/Value.JsonableSeq().(f)
//                                                                                  reference scala/Predef.
//                                                                                  reference scala/Predef.$conforms().
  implicit def JsonableDict[T](items: TraversableOnce[(String, T)])
//             ^^^^^^^^^^^^ definition ujson/Value.JsonableDict().
//                          ^ definition ujson/Value.JsonableDict().[T]
//                             ^^^^^ definition ujson/Value.JsonableDict().(items)
//                                    ^^^^^^^^^^^^^^^ reference scala/package.TraversableOnce#
//                                                     ^^^^^^ reference scala/Predef.String#
//                                                             ^ reference ujson/Value.JsonableDict().[T]
                              (implicit f: T => Value): Obj = Obj.from(items.map(x => (x._1, f(x._2))))
//                                      ^ definition ujson/Value.JsonableDict().(f)
//                                         ^ reference ujson/Value.JsonableDict().[T]
//                                              ^^^^^ reference ujson/Value.Value#
//                                                      ^^^ reference ujson/Value.Obj#
//                                                            ^^^ reference ujson/Value.Obj.
//                                                                ^^^^ reference ujson/Obj.from().
//                                                                     ^^^^^ reference ujson/Value.JsonableDict().(items)
//                                                                           reference scala/collection/IterableOnce.
//                                                                           reference scala/collection/IterableOnce.iterableOnceExtensionMethods().
//                                                                           ^^^ reference scala/collection/IterableOnceExtensionMethods#map().
//                                                                               ^ definition local10
//                                                                                     ^ reference local10
//                                                                                       ^^ reference scala/Tuple2#_1.
//                                                                                           ^ reference ujson/Value.JsonableDict().(f)
//                                                                                             reference scala/Function1#apply().
//                                                                                             ^ reference local10
//                                                                                               ^^ reference scala/Tuple2#_2.
  implicit def JsonableBoolean(i: Boolean): Bool = if (i) ujson.True else ujson.False
//             ^^^^^^^^^^^^^^^ definition ujson/Value.JsonableBoolean().
//                             ^ definition ujson/Value.JsonableBoolean().(i)
//                                ^^^^^^^ reference scala/Boolean#
//                                          ^^^^ reference ujson/Value.Bool#
//                                                     ^ reference ujson/Value.JsonableBoolean().(i)
//                                                        ^^^^^ reference ujson/
//                                                              ^^^^ reference ujson/True.
//                                                                        ^^^^^ reference ujson/
//                                                                              ^^^^^ reference ujson/False.
  implicit def JsonableByte(i: Byte): Num = Num(i)
//             ^^^^^^^^^^^^ definition ujson/Value.JsonableByte().
//                          ^ definition ujson/Value.JsonableByte().(i)
//                             ^^^^ reference scala/Byte#
//                                    ^^^ reference ujson/Value.Num#
//                                          ^^^ reference ujson/Value.Num.
//                                              reference ujson/Num.apply().
//                                              ^ reference scala/Byte#toDouble().
  implicit def JsonableShort(i: Short): Num = Num(i)
//             ^^^^^^^^^^^^^ definition ujson/Value.JsonableShort().
//                           ^ definition ujson/Value.JsonableShort().(i)
//                              ^^^^^ reference scala/Short#
//                                      ^^^ reference ujson/Value.Num#
//                                            ^^^ reference ujson/Value.Num.
//                                                reference ujson/Num.apply().
//                                                ^ reference scala/Short#toDouble().
  implicit def JsonableInt(i: Int): Num = Num(i)
//             ^^^^^^^^^^^ definition ujson/Value.JsonableInt().
//                         ^ definition ujson/Value.JsonableInt().(i)
//                            ^^^ reference scala/Int#
//                                  ^^^ reference ujson/Value.Num#
//                                        ^^^ reference ujson/Value.Num.
//                                            reference ujson/Num.apply().
//                                            ^ reference scala/Int#toDouble().
  implicit def JsonableLong(i: Long): Str = Str(i.toString)
//             ^^^^^^^^^^^^ definition ujson/Value.JsonableLong().
//                          ^ definition ujson/Value.JsonableLong().(i)
//                             ^^^^ reference scala/Long#
//                                    ^^^ reference ujson/Value.Str#
//                                          ^^^ reference ujson/Value.Str.
//                                              reference ujson/Str.apply().
//                                              ^ reference ujson/Value.JsonableLong().(i)
//                                                ^^^^^^^^ reference scala/Any#toString().
  implicit def JsonableFloat(i: Float): Num = Num(i)
//             ^^^^^^^^^^^^^ definition ujson/Value.JsonableFloat().
//                           ^ definition ujson/Value.JsonableFloat().(i)
//                              ^^^^^ reference scala/Float#
//                                      ^^^ reference ujson/Value.Num#
//                                            ^^^ reference ujson/Value.Num.
//                                                reference ujson/Num.apply().
//                                                ^ reference scala/Float#toDouble().
  implicit def JsonableDouble(i: Double): Num = Num(i)
//             ^^^^^^^^^^^^^^ definition ujson/Value.JsonableDouble().
//                            ^ definition ujson/Value.JsonableDouble().(i)
//                               ^^^^^^ reference scala/Double#
//                                        ^^^ reference ujson/Value.Num#
//                                              ^^^ reference ujson/Value.Num.
//                                                  reference ujson/Num.apply().
//                                                  ^ reference ujson/Value.JsonableDouble().(i)
  implicit def JsonableNull(i: Null): Null.type = Null
//             ^^^^^^^^^^^^ definition ujson/Value.JsonableNull().
//                          ^ definition ujson/Value.JsonableNull().(i)
//                             ^^^^ reference scala/Null#
//                                    ^^^^ reference ujson/Value.Null.
//                                                ^^^^ reference ujson/Value.Null.
  implicit def JsonableString(s: CharSequence): Str = Str(s.toString)
//             ^^^^^^^^^^^^^^ definition ujson/Value.JsonableString().
//                            ^ definition ujson/Value.JsonableString().(s)
//                               ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                              ^^^ reference ujson/Value.Str#
//                                                    ^^^ reference ujson/Value.Str.
//                                                        reference ujson/Str.apply().
//                                                        ^ reference ujson/Value.JsonableString().(s)
//                                                          ^^^^^^^^ reference java/lang/Object#toString().


  def transform[T](j: Value, f: Visitor[_, T]): T = {
//    ^^^^^^^^^ definition ujson/Value.transform().
//              ^ definition ujson/Value.transform().[T]
//                 ^ definition ujson/Value.transform().(j)
//                    ^^^^^ reference ujson/Value.Value#
//                           ^ definition ujson/Value.transform().(f)
//                              ^^^^^^^ reference upickle/core/Visitor#
//                                         ^ reference ujson/Value.transform().[T]
//                                              ^ reference ujson/Value.transform().[T]
    j match{
//  ^ reference ujson/Value.transform().(j)
      case ujson.Null => f.visitNull(-1)
//         ^^^^^ reference ujson/
//               ^^^^ reference ujson/Null.
//                       ^ reference ujson/Value.transform().(f)
//                         ^^^^^^^^^ reference upickle/core/Visitor#visitNull().
      case ujson.True => f.visitTrue(-1)
//         ^^^^^ reference ujson/
//               ^^^^ reference ujson/True.
//                       ^ reference ujson/Value.transform().(f)
//                         ^^^^^^^^^ reference upickle/core/Visitor#visitTrue().
      case ujson.False => f.visitFalse(-1)
//         ^^^^^ reference ujson/
//               ^^^^^ reference ujson/False.
//                        ^ reference ujson/Value.transform().(f)
//                          ^^^^^^^^^^ reference upickle/core/Visitor#visitFalse().
      case ujson.Str(s) => f.visitString(s, -1)
//         ^^^^^ reference ujson/
//               ^^^ reference ujson/Str.
//                   ^ definition local11
//                         ^ reference ujson/Value.transform().(f)
//                           ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                       ^ reference local11
      case ujson.Num(d) => f.visitFloat64(d, -1)
//         ^^^^^ reference ujson/
//               ^^^ reference ujson/Num.
//                   ^ definition local12
//                         ^ reference ujson/Value.transform().(f)
//                           ^^^^^^^^^^^^ reference upickle/core/Visitor#visitFloat64().
//                                        ^ reference local12
      case ujson.Arr(items) => transformArray(f, items)
//         ^^^^^ reference ujson/
//               ^^^ reference ujson/Arr.
//                   ^^^^^ definition local13
//                             ^^^^^^^^^^^^^^ reference ujson/AstTransformer#transformArray().
//                                            ^ reference ujson/Value.transform().(f)
//                                               ^^^^^ reference local13
      case ujson.Obj(items) => transformObject(f, items)
//         ^^^^^ reference ujson/
//               ^^^ reference ujson/Obj.
//                   ^^^^^ definition local14
//                             ^^^^^^^^^^^^^^^ reference ujson/AstTransformer#transformObject().
//                                             ^ reference ujson/Value.transform().(f)
//                                                ^^^^^ reference local14
    }
  }

  def visitArray(length: Int, index: Int) = new AstArrVisitor[ArrayBuffer](xs => ujson.Arr(xs))
//    ^^^^^^^^^^ definition ujson/Value.visitArray().
//               ^^^^^^ definition ujson/Value.visitArray().(length)
//                       ^^^ reference scala/Int#
//                            ^^^^^ definition ujson/Value.visitArray().(index)
//                                   ^^^ reference scala/Int#
//                                              ^^^^^^^^^^^^^ reference ujson/AstTransformer#AstArrVisitor#
//                                                            ^^^^^^^^^^^ reference scala/collection/mutable/ArrayBuffer#
//                                                                         reference ujson/AstTransformer#AstArrVisitor#`<init>`().
//                                                                         ^^ definition local15
//                                                                               ^^^^^ reference ujson/
//                                                                                     ^^^ reference ujson/Arr.
//                                                                                         reference ujson/Arr.apply(+1).
//                                                                                         ^^ reference local15
//                                                                                              reference scala/collection/mutable/ArrayBuffer.
//                                                                                              reference scala/collection/IterableFactory#iterableFactory().

  def visitObject(length: Int, index: Int) = new AstObjVisitor[mutable.LinkedHashMap[String, Value]](xs => ujson.Obj(xs))
//    ^^^^^^^^^^^ definition ujson/Value.visitObject().
//                ^^^^^^ definition ujson/Value.visitObject().(length)
//                        ^^^ reference scala/Int#
//                             ^^^^^ definition ujson/Value.visitObject().(index)
//                                    ^^^ reference scala/Int#
//                                               ^^^^^^^^^^^^^ reference ujson/AstTransformer#AstObjVisitor#
//                                                             ^^^^^^^ reference scala/collection/mutable/
//                                                                     ^^^^^^^^^^^^^ reference scala/collection/mutable/LinkedHashMap#
//                                                                                   ^^^^^^ reference scala/Predef.String#
//                                                                                           ^^^^^ reference ujson/Value.Value#
//                                                                                                   reference ujson/AstTransformer#AstObjVisitor#`<init>`().
//                                                                                                   ^^ definition local16
//                                                                                                         ^^^^^ reference ujson/
//                                                                                                               ^^^ reference ujson/Obj.
//                                                                                                                   reference ujson/Obj.apply(+2).
//                                                                                                                   ^^ reference local16
//                                                                                                                        reference scala/collection/mutable/LinkedHashMap.
//                                                                                                                        reference scala/collection/MapFactory#mapFactory().

  def visitNull(index: Int) = ujson.Null
//    ^^^^^^^^^ definition ujson/Value.visitNull().
//              ^^^^^ definition ujson/Value.visitNull().(index)
//                     ^^^ reference scala/Int#
//                            ^^^^^ reference ujson/
//                                  ^^^^ reference ujson/Null.

  def visitFalse(index: Int) = ujson.False
//    ^^^^^^^^^^ definition ujson/Value.visitFalse().
//               ^^^^^ definition ujson/Value.visitFalse().(index)
//                      ^^^ reference scala/Int#
//                             ^^^^^ reference ujson/
//                                   ^^^^^ reference ujson/False.

  def visitTrue(index: Int) = True
//    ^^^^^^^^^ definition ujson/Value.visitTrue().
//              ^^^^^ definition ujson/Value.visitTrue().(index)
//                     ^^^ reference scala/Int#
//                            ^^^^ reference ujson/Value.True.


  override def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int) = {
//             ^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/Value.visitFloat64StringParts().
//                                     ^ definition ujson/Value.visitFloat64StringParts().(s)
//                                        ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                      ^^^^^^^^ definition ujson/Value.visitFloat64StringParts().(decIndex)
//                                                                ^^^ reference scala/Int#
//                                                                     ^^^^^^^^ definition ujson/Value.visitFloat64StringParts().(expIndex)
//                                                                               ^^^ reference scala/Int#
//                                                                                    ^^^^^ definition ujson/Value.visitFloat64StringParts().(index)
//                                                                                           ^^^ reference scala/Int#
    ujson.Num(
//  ^^^^^ reference ujson/
//        ^^^ reference ujson/Num.
//            reference ujson/Num.apply().
      if (decIndex != -1 || expIndex != -1) s.toString.toDouble
//        ^^^^^^^^ reference ujson/Value.visitFloat64StringParts().(decIndex)
//                 ^^ reference scala/Int#`!=`(+3).
//                       ^^ reference scala/Boolean#`||`().
//                          ^^^^^^^^ reference ujson/Value.visitFloat64StringParts().(expIndex)
//                                   ^^ reference scala/Int#`!=`(+3).
//                                          ^ reference ujson/Value.visitFloat64StringParts().(s)
//                                            ^^^^^^^^ reference java/lang/Object#toString().
//                                                     reference scala/Predef.augmentString().
//                                                     ^^^^^^^^ reference scala/collection/StringOps#toDouble().
      else Util.parseIntegralNum(s, decIndex, expIndex, index)
//         ^^^^ reference upickle/core/Util.
//              ^^^^^^^^^^^^^^^^ reference upickle/core/Util.parseIntegralNum().
//                               ^ reference ujson/Value.visitFloat64StringParts().(s)
//                                  ^^^^^^^^ reference ujson/Value.visitFloat64StringParts().(decIndex)
//                                            ^^^^^^^^ reference ujson/Value.visitFloat64StringParts().(expIndex)
//                                                      ^^^^^ reference ujson/Value.visitFloat64StringParts().(index)
    )
  }

  override def visitFloat64(d: Double, index: Int) = ujson.Num(d)
//             ^^^^^^^^^^^^ definition ujson/Value.visitFloat64().
//                          ^ definition ujson/Value.visitFloat64().(d)
//                             ^^^^^^ reference scala/Double#
//                                     ^^^^^ definition ujson/Value.visitFloat64().(index)
//                                            ^^^ reference scala/Int#
//                                                   ^^^^^ reference ujson/
//                                                         ^^^ reference ujson/Num.
//                                                             reference ujson/Num.apply().
//                                                             ^ reference ujson/Value.visitFloat64().(d)

  def visitString(s: CharSequence, index: Int) = ujson.Str(s.toString)
//    ^^^^^^^^^^^ definition ujson/Value.visitString().
//                ^ definition ujson/Value.visitString().(s)
//                   ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                 ^^^^^ definition ujson/Value.visitString().(index)
//                                        ^^^ reference scala/Int#
//                                               ^^^^^ reference ujson/
//                                                     ^^^ reference ujson/Str.
//                                                         reference ujson/Str.apply().
//                                                         ^ reference ujson/Value.visitString().(s)
//                                                           ^^^^^^^^ reference java/lang/Object#toString().

  /**
    * Thrown when uPickle tries to convert a JSON blob into a given data
    * structure but fails because part the blob is invalid
    *
    * @param data The section of the JSON blob that uPickle tried to convert.
    *             This could be the entire blob, or it could be some subtree.
    * @param msg Human-readable text saying what went wrong
    */
  case class InvalidData(data: Value, msg: String)
//           ^^^^^^^^^^^ definition ujson/Value.InvalidData#
//                       definition ujson/Value.InvalidData#`<init>`().
//                       ^^^^ definition ujson/Value.InvalidData#data.
//                             ^^^^^ reference ujson/Value.Value#
//                                    ^^^ definition ujson/Value.InvalidData#msg.
//                                         ^^^^^^ reference scala/Predef.String#
    extends Exception(s"$msg (data: $data)")
//          ^^^^^^^^^ reference scala/package.Exception#
//                    reference java/lang/Exception#`<init>`(+1).
//                     reference scala/StringContext.apply().
//                    ^ reference scala/StringContext#s().
//                       ^^^ reference ujson/Value.InvalidData#`<init>`().(msg)
//                                   ^^^^ reference ujson/Value.InvalidData#`<init>`().(data)
}

case class Str(value: String) extends Value
//         ^^^ definition ujson/Str#
//             definition ujson/Str#`<init>`().
//             ^^^^^ definition ujson/Str#value.
//                    ^^^^^^ reference scala/Predef.String#
//                                    ^^^^^ reference ujson/Value#
//                                          reference java/lang/Object#`<init>`().
case class Obj(value: mutable.LinkedHashMap[String, Value]) extends Value
//         ^^^ definition ujson/Obj#
//             definition ujson/Obj#`<init>`().
//             ^^^^^ definition ujson/Obj#value.
//                    ^^^^^^^ reference scala/collection/mutable/
//                            ^^^^^^^^^^^^^ reference scala/collection/mutable/LinkedHashMap#
//                                          ^^^^^^ reference scala/Predef.String#
//                                                  ^^^^^ reference ujson/Value#
//                                                                  ^^^^^ reference ujson/Value#

// reference java/lang/Object#`<init>`().
object Obj{
//     ^^^ definition ujson/Obj.
  implicit def from(items: TraversableOnce[(String, Value)]): Obj = {
//             ^^^^ definition ujson/Obj.from().
//                  ^^^^^ definition ujson/Obj.from().(items)
//                         ^^^^^^^^^^^^^^^ reference scala/package.TraversableOnce#
//                                          ^^^^^^ reference scala/Predef.String#
//                                                  ^^^^^ reference ujson/Value#
//                                                            ^^^ reference ujson/Obj#
    Obj(mutable.LinkedHashMap(items.toSeq:_*))
//  ^^^ reference ujson/Obj.
//      reference ujson/Obj.apply(+2).
//      ^^^^^^^ reference scala/collection/mutable/
//              ^^^^^^^^^^^^^ reference scala/collection/mutable/LinkedHashMap.
//                            reference scala/collection/MapFactory#apply().
//                            ^^^^^ reference ujson/Obj.from().(items)
//                                  reference scala/collection/IterableOnce.
//                                  reference scala/collection/IterableOnce.iterableOnceExtensionMethods().
//                                  ^^^^^ reference scala/collection/IterableOnceExtensionMethods#toSeq().
  }
  // Weird telescoped version of `apply(items: (String, Value)*)`, to avoid
  // type inference issues due to overloading the existing `apply` method
  // generated by the case class itself
  // https://github.com/lihaoyi/upickle/issues/230
  def apply[V](item: (String, V),
//    ^^^^^ definition ujson/Obj.apply().
//          ^ definition ujson/Obj.apply().[V]
//             ^^^^ definition ujson/Obj.apply().(item)
//                    ^^^^^^ reference scala/Predef.String#
//                            ^ reference ujson/Obj.apply().[V]
                        items: (String, Value)*)(implicit conv: V => Value): Obj = {
//                      ^^^^^ definition ujson/Obj.apply().(items)
//                              ^^^^^^ reference scala/Predef.String#
//                                      ^^^^^ reference ujson/Value#
//                                                        ^^^^ definition ujson/Obj.apply().(conv)
//                                                              ^ reference ujson/Obj.apply().[V]
//                                                                   ^^^^^ reference ujson/Value#
//                                                                           ^^^ reference ujson/Obj#
    val map = new mutable.LinkedHashMap[String, Value]()
//      ^^^ definition local17
//                ^^^^^^^ reference scala/collection/mutable/
//                        ^^^^^^^^^^^^^ reference scala/collection/mutable/LinkedHashMap#
//                                      ^^^^^^ reference scala/Predef.String#
//                                              ^^^^^ reference ujson/Value#
//                                                     reference scala/collection/mutable/LinkedHashMap#`<init>`().
    map.put(item._1, conv(item._2))
//  ^^^ reference local17
//      ^^^ reference scala/collection/mutable/LinkedHashMap#put().
//          ^^^^ reference ujson/Obj.apply().(item)
//               ^^ reference scala/Tuple2#_1.
//                   ^^^^ reference ujson/Obj.apply().(conv)
//                        reference scala/Function1#apply().
//                        ^^^^ reference ujson/Obj.apply().(item)
//                             ^^ reference scala/Tuple2#_2.
    for (i <- items) map.put(i._1, i._2)
//       ^ definition local18
//            ^^^^^ reference ujson/Obj.apply().(items)
//                   ^^^ reference local17
//                       ^^^ reference scala/collection/mutable/LinkedHashMap#put().
//                           ^ reference local18
//                             ^^ reference scala/Tuple2#_1.
//                                 ^ reference local18
//                                   ^^ reference scala/Tuple2#_2.
//                                       reference scala/collection/IterableOnceOps#foreach().
//                                       reference local18
    Obj(map)
//  ^^^ reference ujson/Obj.
//      reference ujson/Obj.apply(+2).
//      ^^^ reference local17
  }

  def apply(): Obj = Obj(new mutable.LinkedHashMap[String, Value]())
//    ^^^^^ definition ujson/Obj.apply(+1).
//             ^^^ reference ujson/Obj#
//                   ^^^ reference ujson/Obj.
//                       reference ujson/Obj.apply(+2).
//                           ^^^^^^^ reference scala/collection/mutable/
//                                   ^^^^^^^^^^^^^ reference scala/collection/mutable/LinkedHashMap#
//                                                 ^^^^^^ reference scala/Predef.String#
//                                                         ^^^^^ reference ujson/Value#
//                                                                reference scala/collection/mutable/LinkedHashMap#`<init>`().
}
case class Arr(value: ArrayBuffer[Value]) extends Value
//         ^^^ definition ujson/Arr#
//             definition ujson/Arr#`<init>`().
//             ^^^^^ definition ujson/Arr#value.
//                    ^^^^^^^^^^^ reference scala/collection/mutable/ArrayBuffer#
//                                ^^^^^ reference ujson/Value#
//                                                ^^^^^ reference ujson/Value#

// reference java/lang/Object#`<init>`().
object Arr{
//     ^^^ definition ujson/Arr.
  implicit def from[T](items: TraversableOnce[T])(implicit conv: T => Value): Arr = {
//             ^^^^ definition ujson/Arr.from().
//                  ^ definition ujson/Arr.from().[T]
//                     ^^^^^ definition ujson/Arr.from().(items)
//                            ^^^^^^^^^^^^^^^ reference scala/package.TraversableOnce#
//                                            ^ reference ujson/Arr.from().[T]
//                                                         ^^^^ definition ujson/Arr.from().(conv)
//                                                               ^ reference ujson/Arr.from().[T]
//                                                                    ^^^^^ reference ujson/Value#
//                                                                            ^^^ reference ujson/Arr#
    val buf = new mutable.ArrayBuffer[Value]()
//      ^^^ definition local19
//                ^^^^^^^ reference scala/collection/mutable/
//                        ^^^^^^^^^^^ reference scala/collection/mutable/ArrayBuffer#
//                                    ^^^^^ reference ujson/Value#
//                                           reference scala/collection/mutable/ArrayBuffer#`<init>`(+1).
    items.foreach{ item =>
//  ^^^^^ reference ujson/Arr.from().(items)
//        reference scala/collection/IterableOnce.
//        reference scala/collection/IterableOnce.iterableOnceExtensionMethods().
//        ^^^^^^^ reference scala/collection/IterableOnceExtensionMethods#foreach().
//                 ^^^^ definition local20
      buf += (conv(item): Value)
//    ^^^ reference local19
//        ^^ reference scala/collection/mutable/Growable#`+=`().
//            ^^^^ reference ujson/Arr.from().(conv)
//                 reference scala/Function1#apply().
//                 ^^^^ reference local20
//                        ^^^^^ reference ujson/Value#
    }
    Arr(buf)
//  ^^^ reference ujson/Arr.
//      reference ujson/Arr.apply(+1).
//      ^^^ reference local19
  }

  def apply(items: Value*): Arr = {
//    ^^^^^ definition ujson/Arr.apply().
//          ^^^^^ definition ujson/Arr.apply().(items)
//                 ^^^^^ reference ujson/Value#
//                          ^^^ reference ujson/Arr#
    val buf = new mutable.ArrayBuffer[Value](items.length)
//      ^^^ definition local21
//                ^^^^^^^ reference scala/collection/mutable/
//                        ^^^^^^^^^^^ reference scala/collection/mutable/ArrayBuffer#
//                                    ^^^^^ reference ujson/Value#
//                                           reference scala/collection/mutable/ArrayBuffer#`<init>`(+2).
//                                           ^^^^^ reference ujson/Arr.apply().(items)
//                                                 ^^^^^^ reference scala/collection/SeqOps#length().
    items.foreach{ item =>
//  ^^^^^ reference ujson/Arr.apply().(items)
//        ^^^^^^^ reference scala/collection/IterableOnceOps#foreach().
//                 ^^^^ definition local22
      buf += item
//    ^^^ reference local21
//        ^^ reference scala/collection/mutable/Growable#`+=`().
//           ^^^^ reference local22
    }
    Arr(buf)
//  ^^^ reference ujson/Arr.
//      reference ujson/Arr.apply(+1).
//      ^^^ reference local21
  }
}
case class Num(value: Double) extends Value
//         ^^^ definition ujson/Num#
//             definition ujson/Num#`<init>`().
//             ^^^^^ definition ujson/Num#value.
//                    ^^^^^^ reference scala/Double#
//                                    ^^^^^ reference ujson/Value#
//                                          reference java/lang/Object#`<init>`().
sealed abstract class Bool extends Value{
//                    ^^^^ definition ujson/Bool#
//                          definition ujson/Bool#`<init>`().
//                                 ^^^^^ reference ujson/Value#
//                                       reference java/lang/Object#`<init>`().
  def value: Boolean
//    ^^^^^ definition ujson/Bool#value().
//           ^^^^^^^ reference scala/Boolean#
}
object Bool{
//     ^^^^ definition ujson/Bool.
  def apply(value: Boolean): Bool = if (value) True else False
//    ^^^^^ definition ujson/Bool.apply().
//          ^^^^^ definition ujson/Bool.apply().(value)
//                 ^^^^^^^ reference scala/Boolean#
//                           ^^^^ reference ujson/Bool#
//                                      ^^^^^ reference ujson/Bool.apply().(value)
//                                             ^^^^ reference ujson/True.
//                                                       ^^^^^ reference ujson/False.
  def unapply(bool: Bool): Option[Boolean] = Some(bool.value)
//    ^^^^^^^ definition ujson/Bool.unapply().
//            ^^^^ definition ujson/Bool.unapply().(bool)
//                  ^^^^ reference ujson/Bool#
//                         ^^^^^^ reference scala/Option#
//                                ^^^^^^^ reference scala/Boolean#
//                                           ^^^^ reference scala/Some.
//                                                reference scala/Some.apply().
//                                                ^^^^ reference ujson/Bool.unapply().(bool)
//                                                     ^^^^^ reference ujson/Bool#value().
}
case object False extends Bool{
//          ^^^^^ definition ujson/False.
//                        ^^^^ reference ujson/Bool#
//                             reference ujson/Bool#`<init>`().
  def value = false
//    ^^^^^ definition ujson/False.value().
}
case object True extends Bool{
//          ^^^^ definition ujson/True.
//                       ^^^^ reference ujson/Bool#
//                            reference ujson/Bool#`<init>`().
  def value = true
//    ^^^^^ definition ujson/True.value().
}
case object Null extends Value{
//          ^^^^ definition ujson/Null.
//                       ^^^^^ reference ujson/Value#
//                             reference java/lang/Object#`<init>`().
  def value = null
//    ^^^^^ definition ujson/Null.value().
}
