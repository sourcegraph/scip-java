package ujson
//      ^^^^^ definition ujson/
import scala.annotation.switch
//     ^^^^^ reference scala/
//           ^^^^^^^^^^ reference scala/annotation/
//                      ^^^^^^ reference scala/annotation/switch#
import upickle.core.{ArrVisitor, ObjVisitor}
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                   ^^^^^^^^^^ reference upickle/core/ArrVisitor#
//                               ^^^^^^^^^^ reference upickle/core/ObjVisitor#

/**
  * A specialized JSON renderer that can render Chars (Chars or Bytes) directly
  * to a [[java.io.Writer]] or [[java.io.OutputStream]]
  *
  * Note that we use an internal `CharBuilder` to buffer the output internally
  * before sending it to [[out]] in batches. This lets us benefit from the high
  * performance and minimal overhead of `CharBuilder` in the fast path of
  * pushing characters, and avoid the synchronization/polymorphism overhead of
  * [[out]] on the fast path. Most [[out]]s would also have performance
  * benefits from receiving data in batches, rather than elem by elem.
  */
class BaseCharRenderer[T <: upickle.core.CharOps.Output]
//    ^^^^^^^^^^^^^^^^ definition ujson/BaseCharRenderer# class BaseCharRenderer[T <: Output]
//    ^^^^^^^^^^^^^^^^ definition ujson/BaseCharRenderer. object BaseCharRenderer
//                     ^ definition ujson/BaseCharRenderer#[T] T <: Output
//                          ^^^^^^^ reference upickle/
//                                  ^^^^ reference upickle/core/
//                                       ^^^^^^^ reference upickle/core/CharOps.
//                                               ^^^^^^ reference upickle/core/CharOps.Output#
                      (out: T,
//                     ^^^ definition ujson/BaseCharRenderer#out. private[this] val out: T
//                          ^ reference ujson/BaseCharRenderer#[T]
                       indent: Int = -1,
//                     ^^^^^^ definition ujson/BaseCharRenderer#indent. private[this] val indent: Int
//                             ^^^ reference scala/Int#
                       escapeUnicode: Boolean = false) extends JsVisitor[T, T]{
//                     ^^^^^^^^^^^^^ definition ujson/BaseCharRenderer#escapeUnicode. private[this] val escapeUnicode: Boolean
//                                    ^^^^^^^ reference scala/Boolean#
//                                                             ^^^^^^^^^ reference ujson/JsVisitor#
//                                                                       ^ reference ujson/BaseCharRenderer#[T]
//                                                                          ^ reference ujson/BaseCharRenderer#[T]
//                                                                             reference java/lang/Object#`<init>`().
  private[this] val elemBuilder = new upickle.core.CharBuilder
//                  ^^^^^^^^^^^ definition ujson/BaseCharRenderer#elemBuilder. private[this] val elemBuilder: CharBuilder
//                                    ^^^^^^^ reference upickle/
//                                            ^^^^ reference upickle/core/
//                                                 ^^^^^^^^^^^ reference upickle/core/CharBuilder#
//                                                             reference upickle/core/CharBuilder#`<init>`().
  private[this] val unicodeCharBuilder = new upickle.core.CharBuilder()
//                  ^^^^^^^^^^^^^^^^^^ definition ujson/BaseCharRenderer#unicodeCharBuilder. private[this] val unicodeCharBuilder: CharBuilder
//                                           ^^^^^^^ reference upickle/
//                                                   ^^^^ reference upickle/core/
//                                                        ^^^^^^^^^^^ reference upickle/core/CharBuilder#
//                                                                    reference upickle/core/CharBuilder#`<init>`().
  def flushCharBuilder() = {
//    ^^^^^^^^^^^^^^^^ definition ujson/BaseCharRenderer#flushCharBuilder(). def flushCharBuilder(): Unit
    elemBuilder.writeOutToIfLongerThan(out, if (depth == 0) 0 else 1000)
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/CharBuilder#writeOutToIfLongerThan().
//                                     ^^^ reference ujson/BaseCharRenderer#out.
//                                              ^^^^^ reference ujson/BaseCharRenderer#depth().
//                                                    ^^ reference scala/Int#`==`(+3).
  }

  private[this] var depth: Int = 0
//                  ^^^^^ definition ujson/BaseCharRenderer#depth(). private[this] var depth: Int
//                  ^^^^^ definition ujson/BaseCharRenderer#`depth_=`(). private[this] var depth_=(x$1: Int): Unit
//                         ^^^ reference scala/Int#


  private[this] var commaBuffered = false
//                  ^^^^^^^^^^^^^ definition ujson/BaseCharRenderer#commaBuffered(). private[this] var commaBuffered: Boolean
//                  ^^^^^^^^^^^^^ definition ujson/BaseCharRenderer#`commaBuffered_=`(). private[this] var commaBuffered_=(x$1: Boolean): Unit

  def flushBuffer() = {
//    ^^^^^^^^^^^ definition ujson/BaseCharRenderer#flushBuffer(). def flushBuffer(): Unit
    if (commaBuffered) {
//      ^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#commaBuffered().
      commaBuffered = false
//    ^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#commaBuffered().
      elemBuilder.append(',')
//    ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^ reference upickle/core/CharBuilder#append(+1).
      renderIndent()
//    ^^^^^^^^^^^^ reference ujson/BaseCharRenderer#renderIndent().
    }
  }
  def visitArray(length: Int, index: Int) = new ArrVisitor[T, T] {
//    ^^^^^^^^^^ definition ujson/BaseCharRenderer#visitArray(). def visitArray(length: Int, index: Int): { def subVisitor: BaseCharRenderer[T] }
//               ^^^^^^ definition ujson/BaseCharRenderer#visitArray().(length) length: Int
//                       ^^^ reference scala/Int#
//                            ^^^^^ definition ujson/BaseCharRenderer#visitArray().(index) index: Int
//                                   ^^^ reference scala/Int#
//                                               definition local1 final class $anon
//                                              ^^^^^^^^^^ reference upickle/core/ArrVisitor#
//                                                         ^ reference ujson/BaseCharRenderer#[T]
//                                                            ^ reference ujson/BaseCharRenderer#[T]
//                                                                reference java/lang/Object#`<init>`().
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushBuffer().
    elemBuilder.append('[')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^ reference upickle/core/CharBuilder#append(+1).

    depth += 1
//  ^^^^^ reference ujson/BaseCharRenderer#depth().
//        ^^ reference scala/Int#`+`(+4).
    renderIndent()
//  ^^^^^^^^^^^^ reference ujson/BaseCharRenderer#renderIndent().
    def subVisitor = BaseCharRenderer.this
//      ^^^^^^^^^^ definition local0 def subVisitor: BaseCharRenderer[T]
//                   ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#
    def visitValue(v: T, index: Int): Unit = {
//      ^^^^^^^^^^ definition local2 def visitValue(v: T, index: Int): Unit
//                 ^ definition local4 v: T
//                    ^ reference ujson/BaseCharRenderer#[T]
//                       ^^^^^ definition local5 index: Int
//                              ^^^ reference scala/Int#
//                                    ^^^^ reference scala/Unit#
      flushBuffer()
//    ^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushBuffer().
      commaBuffered = true
//    ^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#commaBuffered().
    }
    def visitEnd(index: Int) = {
//      ^^^^^^^^ definition local3 def visitEnd(index: Int): T
//               ^^^^^ definition local6 index: Int
//                      ^^^ reference scala/Int#
      commaBuffered = false
//    ^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#commaBuffered().
      depth -= 1
//    ^^^^^ reference ujson/BaseCharRenderer#depth().
//          ^^ reference scala/Int#`-`(+3).
      renderIndent()
//    ^^^^^^^^^^^^ reference ujson/BaseCharRenderer#renderIndent().
      elemBuilder.append(']')
//    ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^ reference upickle/core/CharBuilder#append(+1).
      flushCharBuilder()
//    ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushCharBuilder().
      out
//    ^^^ reference ujson/BaseCharRenderer#out.
    }
  }

  def visitObject(length: Int, index: Int) = new ObjVisitor[T, T] {
//    ^^^^^^^^^^^ definition ujson/BaseCharRenderer#visitObject(). def visitObject(length: Int, index: Int): { def subVisitor: BaseCharRenderer[T]; def visitKey(index: Int): BaseCharRenderer[T] }
//                ^^^^^^ definition ujson/BaseCharRenderer#visitObject().(length) length: Int
//                        ^^^ reference scala/Int#
//                             ^^^^^ definition ujson/BaseCharRenderer#visitObject().(index) index: Int
//                                    ^^^ reference scala/Int#
//                                                definition local10 final class $anon
//                                               ^^^^^^^^^^ reference upickle/core/ObjVisitor#
//                                                          ^ reference ujson/BaseCharRenderer#[T]
//                                                             ^ reference ujson/BaseCharRenderer#[T]
//                                                                 reference java/lang/Object#`<init>`().
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushBuffer().
    elemBuilder.append('{')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^ reference upickle/core/CharBuilder#append(+1).
    depth += 1
//  ^^^^^ reference ujson/BaseCharRenderer#depth().
//        ^^ reference scala/Int#`+`(+4).
    renderIndent()
//  ^^^^^^^^^^^^ reference ujson/BaseCharRenderer#renderIndent().
    def subVisitor = BaseCharRenderer.this
//      ^^^^^^^^^^ definition local7 def subVisitor: BaseCharRenderer[T]
//                   ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#
    def visitKey(index: Int) = BaseCharRenderer.this
//      ^^^^^^^^ definition local8 def visitKey(index: Int): BaseCharRenderer[T]
//               ^^^^^ definition local9 index: Int
//                      ^^^ reference scala/Int#
//                             ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#
    def visitKeyValue(s: Any): Unit = {
//      ^^^^^^^^^^^^^ definition local11 def visitKeyValue(s: Any): Unit
//                    ^ definition local14 s: Any
//                       ^^^ reference scala/Any#
//                             ^^^^ reference scala/Unit#
      elemBuilder.append(':')
//    ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^ reference upickle/core/CharBuilder#append(+1).
      if (indent != -1) elemBuilder.append(' ')
//        ^^^^^^ reference ujson/BaseCharRenderer#indent.
//               ^^ reference scala/Int#`!=`(+3).
//                      ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//                                  ^^^^^^ reference upickle/core/CharBuilder#append(+1).
    }
    def visitValue(v: T, index: Int): Unit = {
//      ^^^^^^^^^^ definition local12 def visitValue(v: T, index: Int): Unit
//                 ^ definition local15 v: T
//                    ^ reference ujson/BaseCharRenderer#[T]
//                       ^^^^^ definition local16 index: Int
//                              ^^^ reference scala/Int#
//                                    ^^^^ reference scala/Unit#
      commaBuffered = true
//    ^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#commaBuffered().
    }
    def visitEnd(index: Int) = {
//      ^^^^^^^^ definition local13 def visitEnd(index: Int): T
//               ^^^^^ definition local17 index: Int
//                      ^^^ reference scala/Int#
      commaBuffered = false
//    ^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#commaBuffered().
      depth -= 1
//    ^^^^^ reference ujson/BaseCharRenderer#depth().
//          ^^ reference scala/Int#`-`(+3).
      renderIndent()
//    ^^^^^^^^^^^^ reference ujson/BaseCharRenderer#renderIndent().
      elemBuilder.append('}')
//    ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^ reference upickle/core/CharBuilder#append(+1).
      flushCharBuilder()
//    ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushCharBuilder().
      out
//    ^^^ reference ujson/BaseCharRenderer#out.
    }
  }

  def visitNull(index: Int) = {
//    ^^^^^^^^^ definition ujson/BaseCharRenderer#visitNull(). def visitNull(index: Int): T
//              ^^^^^ definition ujson/BaseCharRenderer#visitNull().(index) index: Int
//                     ^^^ reference scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushBuffer().
    elemBuilder.ensureLength(4)
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#ensureLength().
    elemBuilder.appendUnsafe('n')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('u')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('l')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('l')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    flushCharBuilder()
//  ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushCharBuilder().
    out
//  ^^^ reference ujson/BaseCharRenderer#out.
  }

  def visitFalse(index: Int) = {
//    ^^^^^^^^^^ definition ujson/BaseCharRenderer#visitFalse(). def visitFalse(index: Int): T
//               ^^^^^ definition ujson/BaseCharRenderer#visitFalse().(index) index: Int
//                      ^^^ reference scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushBuffer().
    elemBuilder.ensureLength(5)
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#ensureLength().
    elemBuilder.appendUnsafe('f')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('a')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('l')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('s')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('e')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    flushCharBuilder()
//  ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushCharBuilder().
    out
//  ^^^ reference ujson/BaseCharRenderer#out.
  }

  def visitTrue(index: Int) = {
//    ^^^^^^^^^ definition ujson/BaseCharRenderer#visitTrue(). def visitTrue(index: Int): T
//              ^^^^^ definition ujson/BaseCharRenderer#visitTrue().(index) index: Int
//                     ^^^ reference scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushBuffer().
    elemBuilder.ensureLength(4)
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#ensureLength().
    elemBuilder.appendUnsafe('t')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('r')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('u')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('e')
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
    flushCharBuilder()
//  ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushCharBuilder().
    out
//  ^^^ reference ujson/BaseCharRenderer#out.
  }

  def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int) = {
//    ^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/BaseCharRenderer#visitFloat64StringParts(). def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int): T
//                            ^ definition ujson/BaseCharRenderer#visitFloat64StringParts().(s) s: CharSequence
//                               ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                             ^^^^^^^^ definition ujson/BaseCharRenderer#visitFloat64StringParts().(decIndex) decIndex: Int
//                                                       ^^^ reference scala/Int#
//                                                            ^^^^^^^^ definition ujson/BaseCharRenderer#visitFloat64StringParts().(expIndex) expIndex: Int
//                                                                      ^^^ reference scala/Int#
//                                                                           ^^^^^ definition ujson/BaseCharRenderer#visitFloat64StringParts().(index) index: Int
//                                                                                  ^^^ reference scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushBuffer().
    elemBuilder.ensureLength(s.length())
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/CharBuilder#ensureLength().
//                           ^ reference ujson/BaseCharRenderer#visitFloat64StringParts().(s)
//                             ^^^^^^ reference java/lang/CharSequence#length().
    var i = 0
//      ^ definition local18 i: Int
    val sLength = s.length
//      ^^^^^^^ definition local19 sLength: Int
//                ^ reference ujson/BaseCharRenderer#visitFloat64StringParts().(s)
//                  ^^^^^^ reference java/lang/CharSequence#length().
    while(i < sLength){
//        ^ reference local18
//          ^ reference scala/Int#`<`(+3).
//            ^^^^^^^ reference local19
      elemBuilder.appendUnsafeC(s.charAt(i))
//    ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafeC().
//                              ^ reference ujson/BaseCharRenderer#visitFloat64StringParts().(s)
//                                ^^^^^^ reference java/lang/CharSequence#charAt().
//                                       ^ reference local18
      i += 1
//    ^ reference local18
//      ^^ reference scala/Int#`+`(+4).
    }
    flushCharBuilder()
//  ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushCharBuilder().
    out
//  ^^^ reference ujson/BaseCharRenderer#out.
  }

  override def visitFloat64(d: Double, index: Int) = {
//             ^^^^^^^^^^^^ definition ujson/BaseCharRenderer#visitFloat64(). def visitFloat64(d: Double, index: Int): T
//                          ^ definition ujson/BaseCharRenderer#visitFloat64().(d) d: Double
//                             ^^^^^^ reference scala/Double#
//                                     ^^^^^ definition ujson/BaseCharRenderer#visitFloat64().(index) index: Int
//                                            ^^^ reference scala/Int#
    d match{
//  ^ reference ujson/BaseCharRenderer#visitFloat64().(d)
      case Double.PositiveInfinity => visitNonNullString("Infinity", -1)
//         ^^^^^^ reference scala/Double.
//                ^^^^^^^^^^^^^^^^ reference scala/Double.PositiveInfinity.
//                                    ^^^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#visitNonNullString().
      case Double.NegativeInfinity => visitNonNullString("-Infinity", -1)
//         ^^^^^^ reference scala/Double.
//                ^^^^^^^^^^^^^^^^ reference scala/Double.NegativeInfinity.
//                                    ^^^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#visitNonNullString().
      case d if java.lang.Double.isNaN(d) => visitNonNullString("NaN", -1)
//         ^ definition local21 d: Double
//              ^^^^ reference java/
//                   ^^^^ reference java/lang/
//                        ^^^^^^ reference java/lang/Double#
//                               ^^^^^ reference java/lang/Double#isNaN(+1).
//                                     ^ reference local21
//                                           ^^^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#visitNonNullString().
      case d =>
//         ^ definition local22 d: Double
        val i = d.toInt
//          ^ definition local23 i: Int
//              ^ reference local22
//                ^^^^^ reference scala/Double#toInt().
        if (d == i) visitFloat64StringParts(i.toString, -1, -1, index)
//          ^ reference local22
//            ^^ reference scala/Double#`==`(+3).
//               ^ reference local23
//                  ^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#visitFloat64StringParts().
//                                          ^ reference local23
//                                            ^^^^^^^^ reference scala/Any#toString().
//                                                              ^^^^^ reference ujson/BaseCharRenderer#visitFloat64().(index)
        else super.visitFloat64(d, index)
//                 ^^^^^^^^^^^^ reference ujson/JsVisitor#visitFloat64().
//                              ^ reference local22
//                                 ^^^^^ reference ujson/BaseCharRenderer#visitFloat64().(index)
        flushBuffer()
//      ^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushBuffer().
    }
    flushCharBuilder()
//  ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushCharBuilder().
    out
//  ^^^ reference ujson/BaseCharRenderer#out.
  }


  def visitString(s: CharSequence, index: Int) = {
//    ^^^^^^^^^^^ definition ujson/BaseCharRenderer#visitString(). def visitString(s: CharSequence, index: Int): T
//                ^ definition ujson/BaseCharRenderer#visitString().(s) s: CharSequence
//                   ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                 ^^^^^ definition ujson/BaseCharRenderer#visitString().(index) index: Int
//                                        ^^^ reference scala/Int#

    if (s eq null) visitNull(index)
//      ^ reference ujson/BaseCharRenderer#visitString().(s)
//        ^^ reference java/lang/Object#eq().
//                 ^^^^^^^^^ reference ujson/BaseCharRenderer#visitNull().
//                           ^^^^^ reference ujson/BaseCharRenderer#visitString().(index)
    else visitNonNullString(s, index)
//       ^^^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#visitNonNullString().
//                          ^ reference ujson/BaseCharRenderer#visitString().(s)
//                             ^^^^^ reference ujson/BaseCharRenderer#visitString().(index)
  }

  def visitNonNullString(s: CharSequence, index: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition ujson/BaseCharRenderer#visitNonNullString(). def visitNonNullString(s: CharSequence, index: Int): T
//                       ^ definition ujson/BaseCharRenderer#visitNonNullString().(s) s: CharSequence
//                          ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                        ^^^^^ definition ujson/BaseCharRenderer#visitNonNullString().(index) index: Int
//                                               ^^^ reference scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushBuffer().
    upickle.core.RenderUtils.escapeChar(unicodeCharBuilder, elemBuilder, s, escapeUnicode)
//  ^^^^^^^ reference upickle/
//          ^^^^ reference upickle/core/
//               ^^^^^^^^^^^ reference upickle/core/RenderUtils.
//                           ^^^^^^^^^^ reference upickle/core/RenderUtils.escapeChar().
//                                      ^^^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#unicodeCharBuilder.
//                                                          ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//                                                                       ^ reference ujson/BaseCharRenderer#visitNonNullString().(s)
//                                                                          ^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#escapeUnicode.
    flushCharBuilder()
//  ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#flushCharBuilder().
    out
//  ^^^ reference ujson/BaseCharRenderer#out.
  }

  final def renderIndent() = {
//          ^^^^^^^^^^^^ definition ujson/BaseCharRenderer#renderIndent(). final def renderIndent(): Unit
    if (indent == -1) ()
//      ^^^^^^ reference ujson/BaseCharRenderer#indent.
//             ^^ reference scala/Int#`==`(+3).
    else {
      var i = indent * depth
//        ^ definition local24 i: Int
//            ^^^^^^ reference ujson/BaseCharRenderer#indent.
//                   ^ reference scala/Int#`*`(+3).
//                     ^^^^^ reference ujson/BaseCharRenderer#depth().
      elemBuilder.ensureLength(i + 1)
//    ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^^^^^^^ reference upickle/core/CharBuilder#ensureLength().
//                             ^ reference local24
//                               ^ reference scala/Int#`+`(+4).
      elemBuilder.appendUnsafe('\n')
//    ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
      while(i > 0) {
//          ^ reference local24
//            ^ reference scala/Int#`>`(+3).
        elemBuilder.appendUnsafe(' ')
//      ^^^^^^^^^^^ reference ujson/BaseCharRenderer#elemBuilder.
//                  ^^^^^^^^^^^^ reference upickle/core/CharBuilder#appendUnsafe().
        i -= 1
//      ^ reference local24
//        ^^ reference scala/Int#`-`(+3).
      }
    }
  }
}
