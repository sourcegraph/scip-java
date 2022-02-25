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
//           ^^^^^ definition ujson/Value# sealed trait Value
//                         ^^^^^^^^ reference ujson/Readable#
//                                       ^^^^ reference geny/
//                                            ^^^^^^^^ reference geny/Writable#
  override def httpContentType = Some("application/json")
//             ^^^^^^^^^^^^^^^ definition ujson/Value#httpContentType(). def httpContentType: Some[String]
//                               ^^^^ reference scala/Some.
  def value: Any
//    ^^^^^ definition ujson/Value#value(). def value: Any
//           ^^^ reference scala/Any#

  /**
    * Returns the `String` value of this [[Value]], fails if it is not
    * a [[ujson.Str]]
    */
  def str = this match{
//    ^^^ definition ujson/Value#str(). def str: String
    case ujson.Str(value) => value
//       ^^^^^ reference ujson/
//             ^^^ reference ujson/Str.
//                 ^^^^^ definition local0 value: String
//                           ^^^^^ reference local0
    case _ => throw Value.InvalidData(this, "Expected ujson.Str")
//                  ^^^^^ reference ujson/Value.
//                        ^^^^^^^^^^^ reference ujson/Value.InvalidData.
  }

  /**
    * Returns an Optional `String` value of this [[Value]] in case this [[Value]] is a 'String'.
    */
  def strOpt = this match{
//    ^^^^^^ definition ujson/Value#strOpt(). def strOpt: Option[String]
    case Str(value) => Some(value)
//       ^^^ reference ujson/Str.
//           ^^^^^ definition local1 value: String
//                     ^^^^ reference scala/Some.
//                          ^^^^^ reference local1
    case _ => None
//            ^^^^ reference scala/None.
  }

  /**
    * Returns the key/value map of this [[Value]], fails if it is not
    * a [[ujson.Obj]]
    */
  def obj = this match{
//    ^^^ definition ujson/Value#obj(). def obj: LinkedHashMap[String, Value]
    case ujson.Obj(value) => value
//       ^^^^^ reference ujson/
//             ^^^ reference ujson/Obj.
//                 ^^^^^ definition local2 value: LinkedHashMap[String, Value]
//                           ^^^^^ reference local2
    case _ => throw Value.InvalidData(this, "Expected ujson.Obj")
//                  ^^^^^ reference ujson/Value.
//                        ^^^^^^^^^^^ reference ujson/Value.InvalidData.
  }
  /**
    * Returns an Optional key/value map of this [[Value]] in case this [[Value]] is a 'Obj'.
    */
  def objOpt = this match{
//    ^^^^^^ definition ujson/Value#objOpt(). def objOpt: Option[LinkedHashMap[String, Value]]
    case Obj(value) => Some(value)
//       ^^^ reference ujson/Obj.
//           ^^^^^ definition local3 value: LinkedHashMap[String, Value]
//                     ^^^^ reference scala/Some.
//                          ^^^^^ reference local3
    case _ => None
//            ^^^^ reference scala/None.
  }
  /**
    * Returns the elements of this [[Value]], fails if it is not
    * a [[ujson.Arr]]
    */
  def arr = this match{
//    ^^^ definition ujson/Value#arr(). def arr: ArrayBuffer[Value]
    case ujson.Arr(value) => value
//       ^^^^^ reference ujson/
//             ^^^ reference ujson/Arr.
//                 ^^^^^ definition local4 value: ArrayBuffer[Value]
//                           ^^^^^ reference local4
    case _ => throw Value.InvalidData(this, "Expected ujson.Arr")
//                  ^^^^^ reference ujson/Value.
//                        ^^^^^^^^^^^ reference ujson/Value.InvalidData.
  }
  /**
    * Returns The optional elements of this [[Value]] in case this [[Value]] is a 'Arr'.
    */
  def arrOpt = this match{
//    ^^^^^^ definition ujson/Value#arrOpt(). def arrOpt: Option[ArrayBuffer[Value]]
    case Arr(value) => Some(value)
//       ^^^ reference ujson/Arr.
//           ^^^^^ definition local5 value: ArrayBuffer[Value]
//                     ^^^^ reference scala/Some.
//                          ^^^^^ reference local5
    case _ => None
//            ^^^^ reference scala/None.
  }
  /**
    * Returns the `Double` value of this [[Value]], fails if it is not
    * a [[ujson.Num]]
    */
  def num = this match{
//    ^^^ definition ujson/Value#num(). def num: Double
    case ujson.Num(value) => value
//       ^^^^^ reference ujson/
//             ^^^ reference ujson/Num.
//                 ^^^^^ definition local6 value: Double
//                           ^^^^^ reference local6
    case _ => throw Value.InvalidData(this, "Expected ujson.Num")
//                  ^^^^^ reference ujson/Value.
//                        ^^^^^^^^^^^ reference ujson/Value.InvalidData.
  }
  /**
    * Returns an Option[Double] in case this [[Value]] is a 'Num'.
    */
  def numOpt = this match{
//    ^^^^^^ definition ujson/Value#numOpt(). def numOpt: Option[Double]
    case Num(value) => Some(value)
//       ^^^ reference ujson/Num.
//           ^^^^^ definition local7 value: Double
//                     ^^^^ reference scala/Some.
//                          ^^^^^ reference local7
    case _ => None
//            ^^^^ reference scala/None.
  }
  /**
    * Returns the `Boolean` value of this [[Value]], fails if it is not
    * a [[ujson.Bool]]
    */
  def bool = this match{
//    ^^^^ definition ujson/Value#bool(). def bool: Boolean
    case ujson.Bool(value) => value
//       ^^^^^ reference ujson/
//             ^^^^ reference ujson/Bool.
//                  ^^^^^ definition local8 value: Boolean
//                            ^^^^^ reference local8
    case _ => throw Value.InvalidData(this, "Expected ujson.Bool")
//                  ^^^^^ reference ujson/Value.
//                        ^^^^^^^^^^^ reference ujson/Value.InvalidData.
  }
  /**
    * Returns an Optional `Boolean` value of this [[Value]] in case this [[Value]] is a 'Bool'.
    */
  def boolOpt = this match{
//    ^^^^^^^ definition ujson/Value#boolOpt(). def boolOpt: Option[Boolean]
    case Bool(value) => Some(value)
//       ^^^^ reference ujson/Bool.
//            ^^^^^ definition local9 value: Boolean
//                      ^^^^ reference scala/Some.
//                           ^^^^^ reference local9
    case _ => None
//            ^^^^ reference scala/None.
  }
  /**
    * Returns true if the value of this [[Value]] is ujson.Null, false otherwise
    */
  def isNull = this match {
//    ^^^^^^ definition ujson/Value#isNull(). def isNull: Boolean
    case ujson.Null => true
//       ^^^^^ reference ujson/
//             ^^^^ reference ujson/Null.
    case _ => false
  }

  def apply(s: Value.Selector): Value = s(this)
//    ^^^^^ definition ujson/Value#apply(). def apply(s: Selector): Value
//          ^ definition ujson/Value#apply().(s) s: Selector
//             ^^^^^ reference ujson/Value.
//                   ^^^^^^^^ reference ujson/Value.Selector#
//                              ^^^^^ reference ujson/Value#
//                                      ^ reference ujson/Value#apply().(s)
  def update(s: Value.Selector, v: Value): Unit = s(this) = v
//    ^^^^^^ definition ujson/Value#update(). def update(s: Selector, v: Value): Unit
//           ^ definition ujson/Value#update().(s) s: Selector
//              ^^^^^ reference ujson/Value.
//                    ^^^^^^^^ reference ujson/Value.Selector#
//                              ^ definition ujson/Value#update().(v) v: Value
//                                 ^^^^^ reference ujson/Value#
//                                         ^^^^ reference scala/Unit#
//                                                ^ reference ujson/Value#update().(s)
//                                                          ^ reference ujson/Value#update().(v)

  /**
    * Update a value in-place. Takes an `Int` or a `String`, through the
    * implicitly-constructe [[Value.Selector]] type.
    *
    * We cannot just overload `update` on `s: Int` and `s: String` because
    * of type inference problems in Scala 2.11.
    */
  def update(s: Value.Selector, f: Value => Value): Unit = s(this) = f(s(this))
//    ^^^^^^ definition ujson/Value#update(+1). def update(s: Selector, f: (Value) => Value): Unit
//           ^ definition ujson/Value#update(+1).(s) s: Selector
//              ^^^^^ reference ujson/Value.
//                    ^^^^^^^^ reference ujson/Value.Selector#
//                              ^ definition ujson/Value#update(+1).(f) f: (Value) => Value
//                                 ^^^^^ reference ujson/Value#
//                                          ^^^^^ reference ujson/Value#
//                                                  ^^^^ reference scala/Unit#
//                                                         ^ reference ujson/Value#update(+1).(s)
//                                                                   ^ reference ujson/Value#update(+1).(f)
//                                                                     ^ reference ujson/Value#update(+1).(s)

  def transform[T](f: Visitor[_, T]) = Value.transform(this, f)
//    ^^^^^^^^^ definition ujson/Value#transform(). def transform(f: Visitor[local10, T[): T
//              ^ definition ujson/Value#transform().[T] T
//                 ^ definition ujson/Value#transform().(f) f: Visitor[local10, T[
//                    ^^^^^^^ reference upickle/core/Visitor#
//                               ^ reference ujson/Value#transform().[T]
//                                     ^^^^^ reference ujson/Value.
//                                           ^^^^^^^^^ reference ujson/Value.transform().
//                                                           ^ reference ujson/Value#transform().(f)
  override def toString = render()
//             ^^^^^^^^ definition ujson/Value#toString(). def toString(): String
//                        ^^^^^^ reference ujson/Value#render().
  def render(indent: Int = -1, escapeUnicode: Boolean = false) = this.transform(StringRenderer(indent, escapeUnicode)).toString
//    ^^^^^^ definition ujson/Value#render(). def render(indent: Int, escapeUnicode: Boolean): String
//           ^^^^^^ definition ujson/Value#render().(indent) default indent: Int
//                   ^^^ reference scala/Int#
//                             ^^^^^^^^^^^^^ definition ujson/Value#render().(escapeUnicode) default escapeUnicode: Boolean
//                                            ^^^^^^^ reference scala/Boolean#
//                                                                    ^^^^^^^^^ reference ujson/Value#transform().
//                                                                              ^^^^^^^^^^^^^^ reference ujson/StringRenderer.
//                                                                                             ^^^^^^ reference ujson/Value#render().(indent)
//                                                                                                     ^^^^^^^^^^^^^ reference ujson/Value#render().(escapeUnicode)
//                                                                                                                     ^^^^^^^^ reference java/io/StringWriter#toString().

  def writeBytesTo(out: java.io.OutputStream, indent: Int = -1, escapeUnicode: Boolean = false): Unit = {
//    ^^^^^^^^^^^^ definition ujson/Value#writeBytesTo(). def writeBytesTo(out: OutputStream, indent: Int, escapeUnicode: Boolean): Unit
//                 ^^^ definition ujson/Value#writeBytesTo().(out) out: OutputStream
//                      ^^^^ reference java/
//                           ^^ reference java/io/
//                              ^^^^^^^^^^^^ reference java/io/OutputStream#
//                                            ^^^^^^ definition ujson/Value#writeBytesTo().(indent) default indent: Int
//                                                    ^^^ reference scala/Int#
//                                                              ^^^^^^^^^^^^^ definition ujson/Value#writeBytesTo().(escapeUnicode) default escapeUnicode: Boolean
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
//    ^^^^^^^^^^^^ definition ujson/Value#writeBytesTo(+1). def writeBytesTo(out: OutputStream): Unit
//                 ^^^ definition ujson/Value#writeBytesTo(+1).(out) out: OutputStream
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
//     ^^^^^ definition ujson/Value. object Value
//                   ^^^^^^^^^^^^^^ reference ujson/AstTransformer#
//                                  ^^^^^ reference ujson/Value#
//                                         reference java/lang/Object#`<init>`().
  type Value = ujson.Value
//     ^^^^^ definition ujson/Value.Value# type Value >: Value <: Value
//             ^^^^^ reference ujson/
//                   ^^^^^ reference ujson/Value#
  sealed trait Selector{
//             ^^^^^^^^ definition ujson/Value.Selector# sealed trait Selector
    def apply(x: Value): Value
//      ^^^^^ definition ujson/Value.Selector#apply(). def apply(x: Value): Value
//            ^ definition ujson/Value.Selector#apply().(x) x: Value
//               ^^^^^ reference ujson/Value.Value#
//                       ^^^^^ reference ujson/Value.Value#
    def update(x: Value, y: Value): Unit
//      ^^^^^^ definition ujson/Value.Selector#update(). def update(x: Value, y: Value): Unit
//             ^ definition ujson/Value.Selector#update().(x) x: Value
//                ^^^^^ reference ujson/Value.Value#
//                       ^ definition ujson/Value.Selector#update().(y) y: Value
//                          ^^^^^ reference ujson/Value.Value#
//                                  ^^^^ reference scala/Unit#
  }
  object Selector{
//       ^^^^^^^^ definition ujson/Value.Selector. object Selector
    implicit class IntSelector(i: Int) extends Selector{
//                 ^^^^^^^^^^^ definition ujson/Value.Selector.IntSelector# implicit class IntSelector
//                             definition ujson/Value.Selector.IntSelector#`<init>`(). def this(i: Int)
//                             ^ definition ujson/Value.Selector.IntSelector#i. private[this] val i: Int
//                             ^ definition ujson/Value.Selector.IntSelector#`<init>`().(i) i: Int
//                                ^^^ reference scala/Int#
//                                             ^^^^^^^^ reference ujson/Value.Selector#
//                                                      reference java/lang/Object#`<init>`().
      def apply(x: Value): Value = x.arr(i)
//        ^^^^^ definition ujson/Value.Selector.IntSelector#apply(). def apply(x: Value): Value
//              ^ definition ujson/Value.Selector.IntSelector#apply().(x) x: Value
//                 ^^^^^ reference ujson/Value.Value#
//                         ^^^^^ reference ujson/Value.Value#
//                                 ^ reference ujson/Value.Selector.IntSelector#apply().(x)
//                                   ^^^ reference ujson/Value#arr().
//                                       ^ reference ujson/Value.Selector.IntSelector#i.
      def update(x: Value, y: Value) = x.arr(i) = y
//        ^^^^^^ definition ujson/Value.Selector.IntSelector#update(). def update(x: Value, y: Value): Unit
//               ^ definition ujson/Value.Selector.IntSelector#update().(x) x: Value
//                  ^^^^^ reference ujson/Value.Value#
//                         ^ definition ujson/Value.Selector.IntSelector#update().(y) y: Value
//                            ^^^^^ reference ujson/Value.Value#
//                                     ^ reference ujson/Value.Selector.IntSelector#update().(x)
//                                       ^^^ reference ujson/Value#arr().
//                                           ^ reference ujson/Value.Selector.IntSelector#i.
//                                                ^ reference ujson/Value.Selector.IntSelector#update().(y)
    }
    implicit class StringSelector(i: String) extends Selector{
//                 ^^^^^^^^^^^^^^ definition ujson/Value.Selector.StringSelector# implicit class StringSelector
//                                definition ujson/Value.Selector.StringSelector#`<init>`(). def this(i: String)
//                                ^ definition ujson/Value.Selector.StringSelector#i. private[this] val i: String
//                                ^ definition ujson/Value.Selector.StringSelector#`<init>`().(i) i: String
//                                   ^^^^^^ reference scala/Predef.String#
//                                                   ^^^^^^^^ reference ujson/Value.Selector#
//                                                            reference java/lang/Object#`<init>`().
      def apply(x: Value): Value = x.obj(i)
//        ^^^^^ definition ujson/Value.Selector.StringSelector#apply(). def apply(x: Value): Value
//              ^ definition ujson/Value.Selector.StringSelector#apply().(x) x: Value
//                 ^^^^^ reference ujson/Value.Value#
//                         ^^^^^ reference ujson/Value.Value#
//                                 ^ reference ujson/Value.Selector.StringSelector#apply().(x)
//                                   ^^^ reference ujson/Value#obj().
//                                       ^ reference ujson/Value.Selector.StringSelector#i.
      def update(x: Value, y: Value) = x.obj(i) = y
//        ^^^^^^ definition ujson/Value.Selector.StringSelector#update(). def update(x: Value, y: Value): Unit
//               ^ definition ujson/Value.Selector.StringSelector#update().(x) x: Value
//                  ^^^^^ reference ujson/Value.Value#
//                         ^ definition ujson/Value.Selector.StringSelector#update().(y) y: Value
//                            ^^^^^ reference ujson/Value.Value#
//                                     ^ reference ujson/Value.Selector.StringSelector#update().(x)
//                                       ^^^ reference ujson/Value#obj().
//                                           ^ reference ujson/Value.Selector.StringSelector#i.
//                                                ^ reference ujson/Value.Selector.StringSelector#update().(y)
    }
  }

  @deprecated("use ujson.Str")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Str = ujson.Str
//    ^^^ definition ujson/Value.Str. @deprecated val Str: Str.type
//          ^^^^^ reference ujson/
//                ^^^ reference ujson/Str.
  @deprecated("use ujson.Str")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  type Str = ujson.Str
//     ^^^ definition ujson/Value.Str# type Str >: Str <: Str
//           ^^^^^ reference ujson/
//                 ^^^ reference ujson/Str#
  @deprecated("use ujson.Obj")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Obj = ujson.Obj
//    ^^^ definition ujson/Value.Obj. @deprecated val Obj: Obj.type
//          ^^^^^ reference ujson/
//                ^^^ reference ujson/Obj.
  @deprecated("use ujson.Obj")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  type Obj = ujson.Obj
//     ^^^ definition ujson/Value.Obj# type Obj >: Obj <: Obj
//           ^^^^^ reference ujson/
//                 ^^^ reference ujson/Obj#
  @deprecated("use ujson.Arr")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Arr = ujson.Arr
//    ^^^ definition ujson/Value.Arr. @deprecated val Arr: Arr.type
//          ^^^^^ reference ujson/
//                ^^^ reference ujson/Arr.
  @deprecated("use ujson.Arr")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  type Arr = ujson.Arr
//     ^^^ definition ujson/Value.Arr# type Arr >: Arr <: Arr
//           ^^^^^ reference ujson/
//                 ^^^ reference ujson/Arr#
  @deprecated("use ujson.Num")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Num = ujson.Num
//    ^^^ definition ujson/Value.Num. @deprecated val Num: Num.type
//          ^^^^^ reference ujson/
//                ^^^ reference ujson/Num.
  @deprecated("use ujson.Num")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  type Num = ujson.Num
//     ^^^ definition ujson/Value.Num# type Num >: Num <: Num
//           ^^^^^ reference ujson/
//                 ^^^ reference ujson/Num#
  @deprecated("use ujson.Bool")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Bool = ujson.Bool
//    ^^^^ definition ujson/Value.Bool. @deprecated val Bool: Bool.type
//           ^^^^^ reference ujson/
//                 ^^^^ reference ujson/Bool.
  @deprecated("use ujson.Bool")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  type Bool = ujson.Bool
//     ^^^^ definition ujson/Value.Bool# type Bool >: Bool <: Bool
//            ^^^^^ reference ujson/
//                  ^^^^ reference ujson/Bool#
  @deprecated("use ujson.True")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val True = ujson.True
//    ^^^^ definition ujson/Value.True. @deprecated val True: True.type
//           ^^^^^ reference ujson/
//                 ^^^^ reference ujson/True.
  @deprecated("use ujson.False")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val False = ujson.False
//    ^^^^^ definition ujson/Value.False. @deprecated val False: False.type
//            ^^^^^ reference ujson/
//                  ^^^^^ reference ujson/False.
  @deprecated("use ujson.Null")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Null = ujson.Null
//    ^^^^ definition ujson/Value.Null. @deprecated val Null: Null.type
//           ^^^^^ reference ujson/
//                 ^^^^ reference ujson/Null.
  implicit def JsonableSeq[T](items: TraversableOnce[T])
//             ^^^^^^^^^^^ definition ujson/Value.JsonableSeq(). implicit def JsonableSeq(items: TraversableOnce[T])(f: (T) => Value): Arr
//                         ^ definition ujson/Value.JsonableSeq().[T] T
//                            ^^^^^ definition ujson/Value.JsonableSeq().(items) items: TraversableOnce[T]
//                                   ^^^^^^^^^^^^^^^ reference scala/package.TraversableOnce#
//                                                   ^ reference ujson/Value.JsonableSeq().[T]
                             (implicit f: T => Value): Arr = Arr.from(items.map(f))
//                                     ^ definition ujson/Value.JsonableSeq().(f) implicit f: (T) => Value
//                                        ^ reference ujson/Value.JsonableSeq().[T]
//                                             ^^^^^ reference ujson/Value.Value#
//                                                     ^^^ reference ujson/Value.Arr#
//                                                           ^^^ reference ujson/Value.Arr.
//                                                               ^^^^ reference ujson/Arr.from().
//                                                                    ^^^^^ reference ujson/Value.JsonableSeq().(items)
//                                                                          ^^^ reference scala/collection/IterableOnceExtensionMethods#map().
//                                                                              ^ reference ujson/Value.JsonableSeq().(f)
  implicit def JsonableDict[T](items: TraversableOnce[(String, T)])
//             ^^^^^^^^^^^^ definition ujson/Value.JsonableDict(). implicit def JsonableDict(items: TraversableOnce[(String, T)])(f: (T) => Value): Obj
//                          ^ definition ujson/Value.JsonableDict().[T] T
//                             ^^^^^ definition ujson/Value.JsonableDict().(items) items: TraversableOnce[(String, T)]
//                                    ^^^^^^^^^^^^^^^ reference scala/package.TraversableOnce#
//                                                     ^^^^^^ reference scala/Predef.String#
//                                                             ^ reference ujson/Value.JsonableDict().[T]
                              (implicit f: T => Value): Obj = Obj.from(items.map(x => (x._1, f(x._2))))
//                                      ^ definition ujson/Value.JsonableDict().(f) implicit f: (T) => Value
//                                         ^ reference ujson/Value.JsonableDict().[T]
//                                              ^^^^^ reference ujson/Value.Value#
//                                                      ^^^ reference ujson/Value.Obj#
//                                                            ^^^ reference ujson/Value.Obj.
//                                                                ^^^^ reference ujson/Obj.from().
//                                                                     ^^^^^ reference ujson/Value.JsonableDict().(items)
//                                                                           ^^^ reference scala/collection/IterableOnceExtensionMethods#map().
//                                                                               ^ definition local11 x: (String, T)
//                                                                                     ^ reference local11
//                                                                                       ^^ reference scala/Tuple2#_1.
//                                                                                           ^ reference ujson/Value.JsonableDict().(f)
//                                                                                             ^ reference local11
//                                                                                               ^^ reference scala/Tuple2#_2.
  implicit def JsonableBoolean(i: Boolean): Bool = if (i) ujson.True else ujson.False
//             ^^^^^^^^^^^^^^^ definition ujson/Value.JsonableBoolean(). implicit def JsonableBoolean(i: Boolean): Bool
//                             ^ definition ujson/Value.JsonableBoolean().(i) i: Boolean
//                                ^^^^^^^ reference scala/Boolean#
//                                          ^^^^ reference ujson/Value.Bool#
//                                                     ^ reference ujson/Value.JsonableBoolean().(i)
//                                                        ^^^^^ reference ujson/
//                                                              ^^^^ reference ujson/True.
//                                                                        ^^^^^ reference ujson/
//                                                                              ^^^^^ reference ujson/False.
  implicit def JsonableByte(i: Byte): Num = Num(i)
//             ^^^^^^^^^^^^ definition ujson/Value.JsonableByte(). implicit def JsonableByte(i: Byte): Num
//                          ^ definition ujson/Value.JsonableByte().(i) i: Byte
//                             ^^^^ reference scala/Byte#
//                                    ^^^ reference ujson/Value.Num#
//                                          ^^^ reference ujson/Value.Num.
//                                              ^ reference scala/Byte#toDouble().
  implicit def JsonableShort(i: Short): Num = Num(i)
//             ^^^^^^^^^^^^^ definition ujson/Value.JsonableShort(). implicit def JsonableShort(i: Short): Num
//                           ^ definition ujson/Value.JsonableShort().(i) i: Short
//                              ^^^^^ reference scala/Short#
//                                      ^^^ reference ujson/Value.Num#
//                                            ^^^ reference ujson/Value.Num.
//                                                ^ reference scala/Short#toDouble().
  implicit def JsonableInt(i: Int): Num = Num(i)
//             ^^^^^^^^^^^ definition ujson/Value.JsonableInt(). implicit def JsonableInt(i: Int): Num
//                         ^ definition ujson/Value.JsonableInt().(i) i: Int
//                            ^^^ reference scala/Int#
//                                  ^^^ reference ujson/Value.Num#
//                                        ^^^ reference ujson/Value.Num.
//                                            ^ reference scala/Int#toDouble().
  implicit def JsonableLong(i: Long): Str = Str(i.toString)
//             ^^^^^^^^^^^^ definition ujson/Value.JsonableLong(). implicit def JsonableLong(i: Long): Str
//                          ^ definition ujson/Value.JsonableLong().(i) i: Long
//                             ^^^^ reference scala/Long#
//                                    ^^^ reference ujson/Value.Str#
//                                          ^^^ reference ujson/Value.Str.
//                                              ^ reference ujson/Value.JsonableLong().(i)
//                                                ^^^^^^^^ reference scala/Any#toString().
  implicit def JsonableFloat(i: Float): Num = Num(i)
//             ^^^^^^^^^^^^^ definition ujson/Value.JsonableFloat(). implicit def JsonableFloat(i: Float): Num
//                           ^ definition ujson/Value.JsonableFloat().(i) i: Float
//                              ^^^^^ reference scala/Float#
//                                      ^^^ reference ujson/Value.Num#
//                                            ^^^ reference ujson/Value.Num.
//                                                ^ reference scala/Float#toDouble().
  implicit def JsonableDouble(i: Double): Num = Num(i)
//             ^^^^^^^^^^^^^^ definition ujson/Value.JsonableDouble(). implicit def JsonableDouble(i: Double): Num
//                            ^ definition ujson/Value.JsonableDouble().(i) i: Double
//                               ^^^^^^ reference scala/Double#
//                                        ^^^ reference ujson/Value.Num#
//                                              ^^^ reference ujson/Value.Num.
//                                                  ^ reference ujson/Value.JsonableDouble().(i)
  implicit def JsonableNull(i: Null): Null.type = Null
//             ^^^^^^^^^^^^ definition ujson/Value.JsonableNull(). implicit def JsonableNull(i: Null): Null.type
//                          ^ definition ujson/Value.JsonableNull().(i) i: Null
//                             ^^^^ reference scala/Null#
//                                    ^^^^ reference ujson/Value.Null.
//                                                ^^^^ reference ujson/Value.Null.
  implicit def JsonableString(s: CharSequence): Str = Str(s.toString)
//             ^^^^^^^^^^^^^^ definition ujson/Value.JsonableString(). implicit def JsonableString(s: CharSequence): Str
//                            ^ definition ujson/Value.JsonableString().(s) s: CharSequence
//                               ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                              ^^^ reference ujson/Value.Str#
//                                                    ^^^ reference ujson/Value.Str.
//                                                        ^ reference ujson/Value.JsonableString().(s)
//                                                          ^^^^^^^^ reference java/lang/Object#toString().


  def transform[T](j: Value, f: Visitor[_, T]): T = {
//    ^^^^^^^^^ definition ujson/Value.transform(). def transform(j: Value, f: Visitor[local12, T[): T
//              ^ definition ujson/Value.transform().[T] T
//                 ^ definition ujson/Value.transform().(j) j: Value
//                    ^^^^^ reference ujson/Value.Value#
//                           ^ definition ujson/Value.transform().(f) f: Visitor[local12, T[
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
//                   ^ definition local13 s: String
//                         ^ reference ujson/Value.transform().(f)
//                           ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                       ^ reference local13
      case ujson.Num(d) => f.visitFloat64(d, -1)
//         ^^^^^ reference ujson/
//               ^^^ reference ujson/Num.
//                   ^ definition local14 d: Double
//                         ^ reference ujson/Value.transform().(f)
//                           ^^^^^^^^^^^^ reference upickle/core/Visitor#visitFloat64().
//                                        ^ reference local14
      case ujson.Arr(items) => transformArray(f, items)
//         ^^^^^ reference ujson/
//               ^^^ reference ujson/Arr.
//                   ^^^^^ definition local15 items: ArrayBuffer[Value]
//                             ^^^^^^^^^^^^^^ reference ujson/AstTransformer#transformArray().
//                                            ^ reference ujson/Value.transform().(f)
//                                               ^^^^^ reference local15
      case ujson.Obj(items) => transformObject(f, items)
//         ^^^^^ reference ujson/
//               ^^^ reference ujson/Obj.
//                   ^^^^^ definition local16 items: LinkedHashMap[String, Value]
//                             ^^^^^^^^^^^^^^^ reference ujson/AstTransformer#transformObject().
//                                             ^ reference ujson/Value.transform().(f)
//                                                ^^^^^ reference local16
    }
  }

  def visitArray(length: Int, index: Int) = new AstArrVisitor[ArrayBuffer](xs => ujson.Arr(xs))
//    ^^^^^^^^^^ definition ujson/Value.visitArray(). def visitArray(length: Int, index: Int): AstArrVisitor[ArrayBuffer]
//               ^^^^^^ definition ujson/Value.visitArray().(length) length: Int
//                       ^^^ reference scala/Int#
//                            ^^^^^ definition ujson/Value.visitArray().(index) index: Int
//                                   ^^^ reference scala/Int#
//                                              ^^^^^^^^^^^^^ reference ujson/AstTransformer#AstArrVisitor#
//                                                            ^^^^^^^^^^^ reference scala/collection/mutable/ArrayBuffer#
//                                                                         reference ujson/AstTransformer#AstArrVisitor#`<init>`().
//                                                                         ^^ definition local17 xs: ArrayBuffer[Value]
//                                                                               ^^^^^ reference ujson/
//                                                                                     ^^^ reference ujson/Arr.
//                                                                                         ^^ reference local17

  def visitObject(length: Int, index: Int) = new AstObjVisitor[mutable.LinkedHashMap[String, Value]](xs => ujson.Obj(xs))
//    ^^^^^^^^^^^ definition ujson/Value.visitObject(). def visitObject(length: Int, index: Int): AstObjVisitor[LinkedHashMap[String, Value]]
//                ^^^^^^ definition ujson/Value.visitObject().(length) length: Int
//                        ^^^ reference scala/Int#
//                             ^^^^^ definition ujson/Value.visitObject().(index) index: Int
//                                    ^^^ reference scala/Int#
//                                               ^^^^^^^^^^^^^ reference ujson/AstTransformer#AstObjVisitor#
//                                                             ^^^^^^^ reference scala/collection/mutable/
//                                                                     ^^^^^^^^^^^^^ reference scala/collection/mutable/LinkedHashMap#
//                                                                                   ^^^^^^ reference scala/Predef.String#
//                                                                                           ^^^^^ reference ujson/Value.Value#
//                                                                                                   reference ujson/AstTransformer#AstObjVisitor#`<init>`().
//                                                                                                   ^^ definition local18 xs: LinkedHashMap[String, Value]
//                                                                                                         ^^^^^ reference ujson/
//                                                                                                               ^^^ reference ujson/Obj.
//                                                                                                                   ^^ reference local18

  def visitNull(index: Int) = ujson.Null
//    ^^^^^^^^^ definition ujson/Value.visitNull(). def visitNull(index: Int): Null
//              ^^^^^ definition ujson/Value.visitNull().(index) index: Int
//                     ^^^ reference scala/Int#
//                            ^^^^^ reference ujson/
//                                  ^^^^ reference ujson/Null.

  def visitFalse(index: Int) = ujson.False
//    ^^^^^^^^^^ definition ujson/Value.visitFalse(). def visitFalse(index: Int): False
//               ^^^^^ definition ujson/Value.visitFalse().(index) index: Int
//                      ^^^ reference scala/Int#
//                             ^^^^^ reference ujson/
//                                   ^^^^^ reference ujson/False.

  def visitTrue(index: Int) = True
//    ^^^^^^^^^ definition ujson/Value.visitTrue(). def visitTrue(index: Int): True
//              ^^^^^ definition ujson/Value.visitTrue().(index) index: Int
//                     ^^^ reference scala/Int#
//                            ^^^^ reference ujson/Value.True.


  override def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int) = {
//             ^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/Value.visitFloat64StringParts(). def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int): Num
//                                     ^ definition ujson/Value.visitFloat64StringParts().(s) s: CharSequence
//                                        ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                      ^^^^^^^^ definition ujson/Value.visitFloat64StringParts().(decIndex) decIndex: Int
//                                                                ^^^ reference scala/Int#
//                                                                     ^^^^^^^^ definition ujson/Value.visitFloat64StringParts().(expIndex) expIndex: Int
//                                                                               ^^^ reference scala/Int#
//                                                                                    ^^^^^ definition ujson/Value.visitFloat64StringParts().(index) index: Int
//                                                                                           ^^^ reference scala/Int#
    ujson.Num(
//  ^^^^^ reference ujson/
//        ^^^ reference ujson/Num.
      if (decIndex != -1 || expIndex != -1) s.toString.toDouble
//        ^^^^^^^^ reference ujson/Value.visitFloat64StringParts().(decIndex)
//                 ^^ reference scala/Int#`!=`(+3).
//                       ^^ reference scala/Boolean#`||`().
//                          ^^^^^^^^ reference ujson/Value.visitFloat64StringParts().(expIndex)
//                                   ^^ reference scala/Int#`!=`(+3).
//                                          ^ reference ujson/Value.visitFloat64StringParts().(s)
//                                            ^^^^^^^^ reference java/lang/Object#toString().
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
//             ^^^^^^^^^^^^ definition ujson/Value.visitFloat64(). def visitFloat64(d: Double, index: Int): Num
//                          ^ definition ujson/Value.visitFloat64().(d) d: Double
//                             ^^^^^^ reference scala/Double#
//                                     ^^^^^ definition ujson/Value.visitFloat64().(index) index: Int
//                                            ^^^ reference scala/Int#
//                                                   ^^^^^ reference ujson/
//                                                         ^^^ reference ujson/Num.
//                                                             ^ reference ujson/Value.visitFloat64().(d)

  def visitString(s: CharSequence, index: Int) = ujson.Str(s.toString)
//    ^^^^^^^^^^^ definition ujson/Value.visitString(). def visitString(s: CharSequence, index: Int): Str
//                ^ definition ujson/Value.visitString().(s) s: CharSequence
//                   ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                 ^^^^^ definition ujson/Value.visitString().(index) index: Int
//                                        ^^^ reference scala/Int#
//                                               ^^^^^ reference ujson/
//                                                     ^^^ reference ujson/Str.
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
//           ^^^^^^^^^^^ definition ujson/Value.InvalidData# case class InvalidData(data: Value, msg: String) extends Exception
//           ^^^^^^^^^^^ synthetic_definition ujson/Value.InvalidData#copy(). def copy(data: Value, msg: String): InvalidData
//           ^^^^^^^^^^^ definition ujson/Value.InvalidData. object InvalidData
//           ^^^^^^^^^^^ synthetic_definition ujson/Value.InvalidData.apply(). def apply(data: Value, msg: String): InvalidData
//           ^^^^^^^^^^^ synthetic_definition ujson/Value.InvalidData#productElementName(). def productElementName(x$1: Int): String
//           ^^^^^^^^^^^ synthetic_definition ujson/Value.InvalidData#productElement(). def productElement(x$1: Int): Any
//                       definition ujson/Value.InvalidData#`<init>`(). def this(data: Value, msg: String)
//                       ^^^^ definition ujson/Value.InvalidData#data. val data: Value
//                       ^^^^ definition ujson/Value.InvalidData.apply().(data) data: Value
//                       ^^^^ definition ujson/Value.InvalidData#`<init>`().(data) data: Value
//                       ^^^^ definition ujson/Value.InvalidData#copy().(data) default data: Value
//                             ^^^^^ reference ujson/Value.Value#
//                                    ^^^ definition ujson/Value.InvalidData#msg. val msg: String
//                                    ^^^ definition ujson/Value.InvalidData#`<init>`().(msg) msg: String
//                                    ^^^ definition ujson/Value.InvalidData#copy().(msg) default msg: String
//                                    ^^^ definition ujson/Value.InvalidData.apply().(msg) msg: String
//                                         ^^^^^^ reference scala/Predef.String#
    extends Exception(s"$msg (data: $data)")
//          ^^^^^^^^^ reference scala/package.Exception#
//                    reference java/lang/Exception#`<init>`(+1).
//                    ^ reference scala/StringContext#s().
//                       ^^^ reference ujson/Value.InvalidData#`<init>`().(msg)
//                                   ^^^^ reference ujson/Value.InvalidData#`<init>`().(data)
}

case class Str(value: String) extends Value
//         ^^^ definition ujson/Str# case class Str(value: String) extends Value
//         ^^^ synthetic_definition ujson/Str#productElement(). def productElement(x$1: Int): Any
//         ^^^ synthetic_definition ujson/Str#copy(). def copy(value: String): Str
//         ^^^ definition ujson/Str. object Str
//         ^^^ synthetic_definition ujson/Str#productElementName(). def productElementName(x$1: Int): String
//         ^^^ synthetic_definition ujson/Str.apply(). def apply(value: String): Str
//             definition ujson/Str#`<init>`(). def this(value: String)
//             ^^^^^ definition ujson/Str#value. val value: String
//             ^^^^^ definition ujson/Str.apply().(value) value: String
//             ^^^^^ definition ujson/Str#`<init>`().(value) value: String
//             ^^^^^ definition ujson/Str#copy().(value) default value: String
//                    ^^^^^^ reference scala/Predef.String#
//                                    ^^^^^ reference ujson/Value#
//                                          reference java/lang/Object#`<init>`().
case class Obj(value: mutable.LinkedHashMap[String, Value]) extends Value
//         ^^^ definition ujson/Obj# case class Obj(value: LinkedHashMap[String, Value]) extends Value
//         ^^^ synthetic_definition ujson/Obj#productElementName(). def productElementName(x$1: Int): String
//         ^^^ synthetic_definition ujson/Obj#productElement(). def productElement(x$1: Int): Any
//         ^^^ synthetic_definition ujson/Obj#copy(). def copy(value: LinkedHashMap[String, Value]): Obj
//             definition ujson/Obj#`<init>`(). def this(value: LinkedHashMap[String, Value])
//             ^^^^^ definition ujson/Obj#value. val value: LinkedHashMap[String, Value]
//             ^^^^^ definition ujson/Obj.apply(+2).(value) value: LinkedHashMap[String, Value]
//             ^^^^^ definition ujson/Obj#`<init>`().(value) value: LinkedHashMap[String, Value]
//             ^^^^^ definition ujson/Obj#copy().(value) default value: LinkedHashMap[String, Value]
//                    ^^^^^^^ reference scala/collection/mutable/
//                            ^^^^^^^^^^^^^ reference scala/collection/mutable/LinkedHashMap#
//                                          ^^^^^^ reference scala/Predef.String#
//                                                  ^^^^^ reference ujson/Value#
//                                                                  ^^^^^ reference ujson/Value#

// reference java/lang/Object#`<init>`().
object Obj{
//     ^^^ definition ujson/Obj. object Obj
//     ^^^ synthetic_definition ujson/Obj.apply(+2). def apply(value: LinkedHashMap[String, Value]): Obj
  implicit def from(items: TraversableOnce[(String, Value)]): Obj = {
//             ^^^^ definition ujson/Obj.from(). implicit def from(items: TraversableOnce[(String, Value)]): Obj
//                  ^^^^^ definition ujson/Obj.from().(items) items: TraversableOnce[(String, Value)]
//                         ^^^^^^^^^^^^^^^ reference scala/package.TraversableOnce#
//                                          ^^^^^^ reference scala/Predef.String#
//                                                  ^^^^^ reference ujson/Value#
//                                                            ^^^ reference ujson/Obj#
    Obj(mutable.LinkedHashMap(items.toSeq:_*))
//  ^^^ reference ujson/Obj.
//      ^^^^^^^ reference scala/collection/mutable/
//              ^^^^^^^^^^^^^ reference scala/collection/mutable/LinkedHashMap.
//                            ^^^^^ reference ujson/Obj.from().(items)
//                                  ^^^^^ reference scala/collection/IterableOnceExtensionMethods#toSeq().
  }
  // Weird telescoped version of `apply(items: (String, Value)*)`, to avoid
  // type inference issues due to overloading the existing `apply` method
  // generated by the case class itself
  // https://github.com/lihaoyi/upickle/issues/230
  def apply[V](item: (String, V),
//    ^^^^^ definition ujson/Obj.apply(). def apply(item: (String, V), items: (String, Value)*)(conv: (V) => Value): Obj
//          ^ definition ujson/Obj.apply().[V] V
//             ^^^^ definition ujson/Obj.apply().(item) item: (String, V)
//                    ^^^^^^ reference scala/Predef.String#
//                            ^ reference ujson/Obj.apply().[V]
                        items: (String, Value)*)(implicit conv: V => Value): Obj = {
//                      ^^^^^ definition ujson/Obj.apply().(items) items: (String, Value)*
//                              ^^^^^^ reference scala/Predef.String#
//                                      ^^^^^ reference ujson/Value#
//                                                        ^^^^ definition ujson/Obj.apply().(conv) implicit conv: (V) => Value
//                                                              ^ reference ujson/Obj.apply().[V]
//                                                                   ^^^^^ reference ujson/Value#
//                                                                           ^^^ reference ujson/Obj#
    val map = new mutable.LinkedHashMap[String, Value]()
//      ^^^ definition local22 map: LinkedHashMap[String, Value]
//                ^^^^^^^ reference scala/collection/mutable/
//                        ^^^^^^^^^^^^^ reference scala/collection/mutable/LinkedHashMap#
//                                      ^^^^^^ reference scala/Predef.String#
//                                              ^^^^^ reference ujson/Value#
//                                                     reference scala/collection/mutable/LinkedHashMap#`<init>`().
    map.put(item._1, conv(item._2))
//  ^^^ reference local22
//      ^^^ reference scala/collection/mutable/LinkedHashMap#put().
//          ^^^^ reference ujson/Obj.apply().(item)
//               ^^ reference scala/Tuple2#_1.
//                   ^^^^ reference ujson/Obj.apply().(conv)
//                        ^^^^ reference ujson/Obj.apply().(item)
//                             ^^ reference scala/Tuple2#_2.
    for (i <- items) map.put(i._1, i._2)
//       ^ definition local23 i: (String, Value)
//            ^^^^^ reference ujson/Obj.apply().(items)
//                   ^^^ reference local22
//                       ^^^ reference scala/collection/mutable/LinkedHashMap#put().
//                           ^ reference local23
//                             ^^ reference scala/Tuple2#_1.
//                                 ^ reference local23
//                                   ^^ reference scala/Tuple2#_2.
    Obj(map)
//  ^^^ reference ujson/Obj.
//      ^^^ reference local22
  }

  def apply(): Obj = Obj(new mutable.LinkedHashMap[String, Value]())
//    ^^^^^ definition ujson/Obj.apply(+1). def apply(): Obj
//             ^^^ reference ujson/Obj#
//                   ^^^ reference ujson/Obj.
//                           ^^^^^^^ reference scala/collection/mutable/
//                                   ^^^^^^^^^^^^^ reference scala/collection/mutable/LinkedHashMap#
//                                                 ^^^^^^ reference scala/Predef.String#
//                                                         ^^^^^ reference ujson/Value#
//                                                                reference scala/collection/mutable/LinkedHashMap#`<init>`().
}
case class Arr(value: ArrayBuffer[Value]) extends Value
//         ^^^ definition ujson/Arr# case class Arr(value: ArrayBuffer[Value]) extends Value
//         ^^^ synthetic_definition ujson/Arr#productElement(). def productElement(x$1: Int): Any
//         ^^^ synthetic_definition ujson/Arr#productElementName(). def productElementName(x$1: Int): String
//         ^^^ synthetic_definition ujson/Arr#copy(). def copy(value: ArrayBuffer[Value]): Arr
//             definition ujson/Arr#`<init>`(). def this(value: ArrayBuffer[Value])
//             ^^^^^ definition ujson/Arr#value. val value: ArrayBuffer[Value]
//             ^^^^^ definition ujson/Arr#`<init>`().(value) value: ArrayBuffer[Value]
//             ^^^^^ definition ujson/Arr#copy().(value) default value: ArrayBuffer[Value]
//             ^^^^^ definition ujson/Arr.apply(+1).(value) value: ArrayBuffer[Value]
//                    ^^^^^^^^^^^ reference scala/collection/mutable/ArrayBuffer#
//                                ^^^^^ reference ujson/Value#
//                                                ^^^^^ reference ujson/Value#

// reference java/lang/Object#`<init>`().
object Arr{
//     ^^^ definition ujson/Arr. object Arr
//     ^^^ synthetic_definition ujson/Arr.apply(+1). def apply(value: ArrayBuffer[Value]): Arr
  implicit def from[T](items: TraversableOnce[T])(implicit conv: T => Value): Arr = {
//             ^^^^ definition ujson/Arr.from(). implicit def from(items: TraversableOnce[T])(conv: (T) => Value): Arr
//                  ^ definition ujson/Arr.from().[T] T
//                     ^^^^^ definition ujson/Arr.from().(items) items: TraversableOnce[T]
//                            ^^^^^^^^^^^^^^^ reference scala/package.TraversableOnce#
//                                            ^ reference ujson/Arr.from().[T]
//                                                         ^^^^ definition ujson/Arr.from().(conv) implicit conv: (T) => Value
//                                                               ^ reference ujson/Arr.from().[T]
//                                                                    ^^^^^ reference ujson/Value#
//                                                                            ^^^ reference ujson/Arr#
    val buf = new mutable.ArrayBuffer[Value]()
//      ^^^ definition local25 buf: ArrayBuffer[Value]
//                ^^^^^^^ reference scala/collection/mutable/
//                        ^^^^^^^^^^^ reference scala/collection/mutable/ArrayBuffer#
//                                    ^^^^^ reference ujson/Value#
//                                           reference scala/collection/mutable/ArrayBuffer#`<init>`(+1).
    items.foreach{ item =>
//  ^^^^^ reference ujson/Arr.from().(items)
//        ^^^^^^^ reference scala/collection/IterableOnceExtensionMethods#foreach().
//                 ^^^^ definition local26 item: T
      buf += (conv(item): Value)
//    ^^^ reference local25
//        ^^ reference scala/collection/mutable/Growable#`+=`().
//            ^^^^ reference ujson/Arr.from().(conv)
//                 ^^^^ reference local26
//                        ^^^^^ reference ujson/Value#
    }
    Arr(buf)
//  ^^^ reference ujson/Arr.
//      ^^^ reference local25
  }

  def apply(items: Value*): Arr = {
//    ^^^^^ definition ujson/Arr.apply(). def apply(items: Value*): Arr
//          ^^^^^ definition ujson/Arr.apply().(items) items: Value*
//                 ^^^^^ reference ujson/Value#
//                          ^^^ reference ujson/Arr#
    val buf = new mutable.ArrayBuffer[Value](items.length)
//      ^^^ definition local27 buf: ArrayBuffer[Value]
//                ^^^^^^^ reference scala/collection/mutable/
//                        ^^^^^^^^^^^ reference scala/collection/mutable/ArrayBuffer#
//                                    ^^^^^ reference ujson/Value#
//                                           reference scala/collection/mutable/ArrayBuffer#`<init>`(+2).
//                                           ^^^^^ reference ujson/Arr.apply().(items)
//                                                 ^^^^^^ reference scala/collection/SeqOps#length().
    items.foreach{ item =>
//  ^^^^^ reference ujson/Arr.apply().(items)
//        ^^^^^^^ reference scala/collection/IterableOnceOps#foreach().
//                 ^^^^ definition local28 item: Value
      buf += item
//    ^^^ reference local27
//        ^^ reference scala/collection/mutable/Growable#`+=`().
//           ^^^^ reference local28
    }
    Arr(buf)
//  ^^^ reference ujson/Arr.
//      ^^^ reference local27
  }
}
case class Num(value: Double) extends Value
//         ^^^ definition ujson/Num# case class Num(value: Double) extends Value
//         ^^^ synthetic_definition ujson/Num#productElement(). def productElement(x$1: Int): Any
//         ^^^ synthetic_definition ujson/Num#copy(). def copy(value: Double): Num
//         ^^^ synthetic_definition ujson/Num.apply(). def apply(value: Double): Num
//         ^^^ synthetic_definition ujson/Num#productElementName(). def productElementName(x$1: Int): String
//         ^^^ definition ujson/Num. object Num
//             definition ujson/Num#`<init>`(). def this(value: Double)
//             ^^^^^ definition ujson/Num#value. val value: Double
//             ^^^^^ definition ujson/Num.apply().(value) value: Double
//             ^^^^^ definition ujson/Num#copy().(value) default value: Double
//             ^^^^^ definition ujson/Num#`<init>`().(value) value: Double
//                    ^^^^^^ reference scala/Double#
//                                    ^^^^^ reference ujson/Value#
//                                          reference java/lang/Object#`<init>`().
sealed abstract class Bool extends Value{
//                    ^^^^ definition ujson/Bool# abstract sealed class Bool
//                          definition ujson/Bool#`<init>`(). def this()
//                                 ^^^^^ reference ujson/Value#
//                                       reference java/lang/Object#`<init>`().
  def value: Boolean
//    ^^^^^ definition ujson/Bool#value(). def value: Boolean
//           ^^^^^^^ reference scala/Boolean#
}
object Bool{
//     ^^^^ definition ujson/Bool. object Bool
  def apply(value: Boolean): Bool = if (value) True else False
//    ^^^^^ definition ujson/Bool.apply(). def apply(value: Boolean): Bool
//          ^^^^^ definition ujson/Bool.apply().(value) value: Boolean
//                 ^^^^^^^ reference scala/Boolean#
//                           ^^^^ reference ujson/Bool#
//                                      ^^^^^ reference ujson/Bool.apply().(value)
//                                             ^^^^ reference ujson/True.
//                                                       ^^^^^ reference ujson/False.
  def unapply(bool: Bool): Option[Boolean] = Some(bool.value)
//    ^^^^^^^ definition ujson/Bool.unapply(). def unapply(bool: Bool): Option[Boolean]
//            ^^^^ definition ujson/Bool.unapply().(bool) bool: Bool
//                  ^^^^ reference ujson/Bool#
//                         ^^^^^^ reference scala/Option#
//                                ^^^^^^^ reference scala/Boolean#
//                                           ^^^^ reference scala/Some.
//                                                ^^^^ reference ujson/Bool.unapply().(bool)
//                                                     ^^^^^ reference ujson/Bool#value().
}
case object False extends Bool{
//          ^^^^^ definition ujson/False. case object False
//          ^^^^^ synthetic_definition ujson/False.productElement(). def productElement(x$1: Int): Any
//                        ^^^^ reference ujson/Bool#
//                             reference ujson/Bool#`<init>`().
  def value = false
//    ^^^^^ definition ujson/False.value(). def value: Boolean
}
case object True extends Bool{
//          ^^^^ definition ujson/True. case object True
//          ^^^^ synthetic_definition ujson/True.productElement(). def productElement(x$1: Int): Any
//                       ^^^^ reference ujson/Bool#
//                            reference ujson/Bool#`<init>`().
  def value = true
//    ^^^^^ definition ujson/True.value(). def value: Boolean
}
case object Null extends Value{
//          ^^^^ definition ujson/Null. case object Null
//          ^^^^ synthetic_definition ujson/Null.productElement(). def productElement(x$1: Int): Any
//                       ^^^^^ reference ujson/Value#
//                             reference java/lang/Object#`<init>`().
  def value = null
//    ^^^^^ definition ujson/Null.value(). def value: Null
}
