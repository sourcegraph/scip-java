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
  * A specialized JSON renderer that can render Bytes (Chars or Bytes) directly
  * to a [[java.io.Writer]] or [[java.io.OutputStream]]
  *
  * Note that we use an internal `ByteBuilder` to buffer the output internally
  * before sending it to [[out]] in batches. This lets us benefit from the high
  * performance and minimal overhead of `ByteBuilder` in the fast path of
  * pushing characters, and avoid the synchronization/polymorphism overhead of
  * [[out]] on the fast path. Most [[out]]s would also have performance
  * benefits from receiving data in batches, rather than elem by elem.
  */
class BaseByteRenderer[T <: upickle.core.ByteOps.Output]
//    ^^^^^^^^^^^^^^^^ definition ujson/BaseByteRenderer# class BaseByteRenderer[T <: Output]
//    ^^^^^^^^^^^^^^^^ definition ujson/BaseByteRenderer. object BaseByteRenderer
//                     ^ definition ujson/BaseByteRenderer#[T] T <: Output
//                          ^^^^^^^ reference upickle/
//                                  ^^^^ reference upickle/core/
//                                       ^^^^^^^ reference upickle/core/ByteOps.
//                                               ^^^^^^ reference upickle/core/ByteOps.Output#
                      (out: T,
//                     ^^^ definition ujson/BaseByteRenderer#out. private[this] val out: T
//                          ^ reference ujson/BaseByteRenderer#[T]
                       indent: Int = -1,
//                     ^^^^^^ definition ujson/BaseByteRenderer#indent. private[this] val indent: Int
//                             ^^^ reference scala/Int#
                       escapeUnicode: Boolean = false) extends JsVisitor[T, T]{
//                     ^^^^^^^^^^^^^ definition ujson/BaseByteRenderer#escapeUnicode. private[this] val escapeUnicode: Boolean
//                                    ^^^^^^^ reference scala/Boolean#
//                                                             ^^^^^^^^^ reference ujson/JsVisitor#
//                                                                       ^ reference ujson/BaseByteRenderer#[T]
//                                                                          ^ reference ujson/BaseByteRenderer#[T]
//                                                                             reference java/lang/Object#`<init>`().
  private[this] val elemBuilder = new upickle.core.ByteBuilder
//                  ^^^^^^^^^^^ definition ujson/BaseByteRenderer#elemBuilder. private[this] val elemBuilder: ByteBuilder
//                                    ^^^^^^^ reference upickle/
//                                            ^^^^ reference upickle/core/
//                                                 ^^^^^^^^^^^ reference upickle/core/ByteBuilder#
//                                                             reference upickle/core/ByteBuilder#`<init>`().
  private[this] val unicodeCharBuilder = new upickle.core.CharBuilder()
//                  ^^^^^^^^^^^^^^^^^^ definition ujson/BaseByteRenderer#unicodeCharBuilder. private[this] val unicodeCharBuilder: CharBuilder
//                                           ^^^^^^^ reference upickle/
//                                                   ^^^^ reference upickle/core/
//                                                        ^^^^^^^^^^^ reference upickle/core/CharBuilder#
//                                                                    reference upickle/core/CharBuilder#`<init>`().
  def flushByteBuilder() = {
//    ^^^^^^^^^^^^^^^^ definition ujson/BaseByteRenderer#flushByteBuilder(). def flushByteBuilder(): Unit
    elemBuilder.writeOutToIfLongerThan(out, if (depth == 0) 0 else 1000)
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/ByteBuilder#writeOutToIfLongerThan().
//                                     ^^^ reference ujson/BaseByteRenderer#out.
//                                              ^^^^^ reference ujson/BaseByteRenderer#depth().
//                                                    ^^ reference scala/Int#`==`(+3).
  }

  private[this] var depth: Int = 0
//                  ^^^^^ definition ujson/BaseByteRenderer#depth(). private[this] var depth: Int
//                  ^^^^^ definition ujson/BaseByteRenderer#`depth_=`(). private[this] var depth_=(x$1: Int): Unit
//                         ^^^ reference scala/Int#


  private[this] var commaBuffered = false
//                  ^^^^^^^^^^^^^ definition ujson/BaseByteRenderer#commaBuffered(). private[this] var commaBuffered: Boolean
//                  ^^^^^^^^^^^^^ definition ujson/BaseByteRenderer#`commaBuffered_=`(). private[this] var commaBuffered_=(x$1: Boolean): Unit

  def flushBuffer() = {
//    ^^^^^^^^^^^ definition ujson/BaseByteRenderer#flushBuffer(). def flushBuffer(): Unit
    if (commaBuffered) {
//      ^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#commaBuffered().
      commaBuffered = false
//    ^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#commaBuffered().
      elemBuilder.append(',')
//    ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^ reference upickle/core/ByteBuilder#append().
      renderIndent()
//    ^^^^^^^^^^^^ reference ujson/BaseByteRenderer#renderIndent().
    }
  }
  def visitArray(length: Int, index: Int) = new ArrVisitor[T, T] {
//    ^^^^^^^^^^ definition ujson/BaseByteRenderer#visitArray(). def visitArray(length: Int, index: Int): { def subVisitor: BaseByteRenderer[T] }
//               ^^^^^^ definition ujson/BaseByteRenderer#visitArray().(length) length: Int
//                       ^^^ reference scala/Int#
//                            ^^^^^ definition ujson/BaseByteRenderer#visitArray().(index) index: Int
//                                   ^^^ reference scala/Int#
//                                               definition local1 final class $anon
//                                              ^^^^^^^^^^ reference upickle/core/ArrVisitor#
//                                                         ^ reference ujson/BaseByteRenderer#[T]
//                                                            ^ reference ujson/BaseByteRenderer#[T]
//                                                                reference java/lang/Object#`<init>`().
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushBuffer().
    elemBuilder.append('[')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^ reference upickle/core/ByteBuilder#append().

    depth += 1
//  ^^^^^ reference ujson/BaseByteRenderer#depth().
//        ^^ reference scala/Int#`+`(+4).
    renderIndent()
//  ^^^^^^^^^^^^ reference ujson/BaseByteRenderer#renderIndent().
    def subVisitor = BaseByteRenderer.this
//      ^^^^^^^^^^ definition local0 def subVisitor: BaseByteRenderer[T]
//                   ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#
    def visitValue(v: T, index: Int): Unit = {
//      ^^^^^^^^^^ definition local2 def visitValue(v: T, index: Int): Unit
//                 ^ definition local4 v: T
//                    ^ reference ujson/BaseByteRenderer#[T]
//                       ^^^^^ definition local5 index: Int
//                              ^^^ reference scala/Int#
//                                    ^^^^ reference scala/Unit#
      flushBuffer()
//    ^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushBuffer().
      commaBuffered = true
//    ^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#commaBuffered().
    }
    def visitEnd(index: Int) = {
//      ^^^^^^^^ definition local3 def visitEnd(index: Int): T
//               ^^^^^ definition local6 index: Int
//                      ^^^ reference scala/Int#
      commaBuffered = false
//    ^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#commaBuffered().
      depth -= 1
//    ^^^^^ reference ujson/BaseByteRenderer#depth().
//          ^^ reference scala/Int#`-`(+3).
      renderIndent()
//    ^^^^^^^^^^^^ reference ujson/BaseByteRenderer#renderIndent().
      elemBuilder.append(']')
//    ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^ reference upickle/core/ByteBuilder#append().
      flushByteBuilder()
//    ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushByteBuilder().
      out
//    ^^^ reference ujson/BaseByteRenderer#out.
    }
  }

  def visitObject(length: Int, index: Int) = new ObjVisitor[T, T] {
//    ^^^^^^^^^^^ definition ujson/BaseByteRenderer#visitObject(). def visitObject(length: Int, index: Int): { def subVisitor: BaseByteRenderer[T]; def visitKey(index: Int): BaseByteRenderer[T] }
//                ^^^^^^ definition ujson/BaseByteRenderer#visitObject().(length) length: Int
//                        ^^^ reference scala/Int#
//                             ^^^^^ definition ujson/BaseByteRenderer#visitObject().(index) index: Int
//                                    ^^^ reference scala/Int#
//                                                definition local10 final class $anon
//                                               ^^^^^^^^^^ reference upickle/core/ObjVisitor#
//                                                          ^ reference ujson/BaseByteRenderer#[T]
//                                                             ^ reference ujson/BaseByteRenderer#[T]
//                                                                 reference java/lang/Object#`<init>`().
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushBuffer().
    elemBuilder.append('{')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^ reference upickle/core/ByteBuilder#append().
    depth += 1
//  ^^^^^ reference ujson/BaseByteRenderer#depth().
//        ^^ reference scala/Int#`+`(+4).
    renderIndent()
//  ^^^^^^^^^^^^ reference ujson/BaseByteRenderer#renderIndent().
    def subVisitor = BaseByteRenderer.this
//      ^^^^^^^^^^ definition local7 def subVisitor: BaseByteRenderer[T]
//                   ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#
    def visitKey(index: Int) = BaseByteRenderer.this
//      ^^^^^^^^ definition local8 def visitKey(index: Int): BaseByteRenderer[T]
//               ^^^^^ definition local9 index: Int
//                      ^^^ reference scala/Int#
//                             ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#
    def visitKeyValue(s: Any): Unit = {
//      ^^^^^^^^^^^^^ definition local11 def visitKeyValue(s: Any): Unit
//                    ^ definition local14 s: Any
//                       ^^^ reference scala/Any#
//                             ^^^^ reference scala/Unit#
      elemBuilder.append(':')
//    ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^ reference upickle/core/ByteBuilder#append().
      if (indent != -1) elemBuilder.append(' ')
//        ^^^^^^ reference ujson/BaseByteRenderer#indent.
//               ^^ reference scala/Int#`!=`(+3).
//                      ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//                                  ^^^^^^ reference upickle/core/ByteBuilder#append().
    }
    def visitValue(v: T, index: Int): Unit = {
//      ^^^^^^^^^^ definition local12 def visitValue(v: T, index: Int): Unit
//                 ^ definition local15 v: T
//                    ^ reference ujson/BaseByteRenderer#[T]
//                       ^^^^^ definition local16 index: Int
//                              ^^^ reference scala/Int#
//                                    ^^^^ reference scala/Unit#
      commaBuffered = true
//    ^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#commaBuffered().
    }
    def visitEnd(index: Int) = {
//      ^^^^^^^^ definition local13 def visitEnd(index: Int): T
//               ^^^^^ definition local17 index: Int
//                      ^^^ reference scala/Int#
      commaBuffered = false
//    ^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#commaBuffered().
      depth -= 1
//    ^^^^^ reference ujson/BaseByteRenderer#depth().
//          ^^ reference scala/Int#`-`(+3).
      renderIndent()
//    ^^^^^^^^^^^^ reference ujson/BaseByteRenderer#renderIndent().
      elemBuilder.append('}')
//    ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^ reference upickle/core/ByteBuilder#append().
      flushByteBuilder()
//    ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushByteBuilder().
      out
//    ^^^ reference ujson/BaseByteRenderer#out.
    }
  }

  def visitNull(index: Int) = {
//    ^^^^^^^^^ definition ujson/BaseByteRenderer#visitNull(). def visitNull(index: Int): T
//              ^^^^^ definition ujson/BaseByteRenderer#visitNull().(index) index: Int
//                     ^^^ reference scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushBuffer().
    elemBuilder.ensureLength(4)
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#ensureLength().
    elemBuilder.appendUnsafe('n')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('u')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('l')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('l')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    flushByteBuilder()
//  ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushByteBuilder().
    out
//  ^^^ reference ujson/BaseByteRenderer#out.
  }

  def visitFalse(index: Int) = {
//    ^^^^^^^^^^ definition ujson/BaseByteRenderer#visitFalse(). def visitFalse(index: Int): T
//               ^^^^^ definition ujson/BaseByteRenderer#visitFalse().(index) index: Int
//                      ^^^ reference scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushBuffer().
    elemBuilder.ensureLength(5)
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#ensureLength().
    elemBuilder.appendUnsafe('f')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('a')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('l')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('s')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('e')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    flushByteBuilder()
//  ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushByteBuilder().
    out
//  ^^^ reference ujson/BaseByteRenderer#out.
  }

  def visitTrue(index: Int) = {
//    ^^^^^^^^^ definition ujson/BaseByteRenderer#visitTrue(). def visitTrue(index: Int): T
//              ^^^^^ definition ujson/BaseByteRenderer#visitTrue().(index) index: Int
//                     ^^^ reference scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushBuffer().
    elemBuilder.ensureLength(4)
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#ensureLength().
    elemBuilder.appendUnsafe('t')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('r')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('u')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('e')
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
    flushByteBuilder()
//  ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushByteBuilder().
    out
//  ^^^ reference ujson/BaseByteRenderer#out.
  }

  def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int) = {
//    ^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/BaseByteRenderer#visitFloat64StringParts(). def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int): T
//                            ^ definition ujson/BaseByteRenderer#visitFloat64StringParts().(s) s: CharSequence
//                               ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                             ^^^^^^^^ definition ujson/BaseByteRenderer#visitFloat64StringParts().(decIndex) decIndex: Int
//                                                       ^^^ reference scala/Int#
//                                                            ^^^^^^^^ definition ujson/BaseByteRenderer#visitFloat64StringParts().(expIndex) expIndex: Int
//                                                                      ^^^ reference scala/Int#
//                                                                           ^^^^^ definition ujson/BaseByteRenderer#visitFloat64StringParts().(index) index: Int
//                                                                                  ^^^ reference scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushBuffer().
    elemBuilder.ensureLength(s.length())
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#ensureLength().
//                           ^ reference ujson/BaseByteRenderer#visitFloat64StringParts().(s)
//                             ^^^^^^ reference java/lang/CharSequence#length().
    var i = 0
//      ^ definition local18 i: Int
    val sLength = s.length
//      ^^^^^^^ definition local19 sLength: Int
//                ^ reference ujson/BaseByteRenderer#visitFloat64StringParts().(s)
//                  ^^^^^^ reference java/lang/CharSequence#length().
    while(i < sLength){
//        ^ reference local18
//          ^ reference scala/Int#`<`(+3).
//            ^^^^^^^ reference local19
      elemBuilder.appendUnsafeC(s.charAt(i))
//    ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafeC().
//                              ^ reference ujson/BaseByteRenderer#visitFloat64StringParts().(s)
//                                ^^^^^^ reference java/lang/CharSequence#charAt().
//                                       ^ reference local18
      i += 1
//    ^ reference local18
//      ^^ reference scala/Int#`+`(+4).
    }
    flushByteBuilder()
//  ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushByteBuilder().
    out
//  ^^^ reference ujson/BaseByteRenderer#out.
  }

  override def visitFloat64(d: Double, index: Int) = {
//             ^^^^^^^^^^^^ definition ujson/BaseByteRenderer#visitFloat64(). def visitFloat64(d: Double, index: Int): T
//                          ^ definition ujson/BaseByteRenderer#visitFloat64().(d) d: Double
//                             ^^^^^^ reference scala/Double#
//                                     ^^^^^ definition ujson/BaseByteRenderer#visitFloat64().(index) index: Int
//                                            ^^^ reference scala/Int#
    d match{
//  ^ reference ujson/BaseByteRenderer#visitFloat64().(d)
      case Double.PositiveInfinity => visitNonNullString("Infinity", -1)
//         ^^^^^^ reference scala/Double.
//                ^^^^^^^^^^^^^^^^ reference scala/Double.PositiveInfinity.
//                                    ^^^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#visitNonNullString().
      case Double.NegativeInfinity => visitNonNullString("-Infinity", -1)
//         ^^^^^^ reference scala/Double.
//                ^^^^^^^^^^^^^^^^ reference scala/Double.NegativeInfinity.
//                                    ^^^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#visitNonNullString().
      case d if java.lang.Double.isNaN(d) => visitNonNullString("NaN", -1)
//         ^ definition local21 d: Double
//              ^^^^ reference java/
//                   ^^^^ reference java/lang/
//                        ^^^^^^ reference java/lang/Double#
//                               ^^^^^ reference java/lang/Double#isNaN(+1).
//                                     ^ reference local21
//                                           ^^^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#visitNonNullString().
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
//                  ^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#visitFloat64StringParts().
//                                          ^ reference local23
//                                            ^^^^^^^^ reference scala/Any#toString().
//                                                              ^^^^^ reference ujson/BaseByteRenderer#visitFloat64().(index)
        else super.visitFloat64(d, index)
//                 ^^^^^^^^^^^^ reference ujson/JsVisitor#visitFloat64().
//                              ^ reference local22
//                                 ^^^^^ reference ujson/BaseByteRenderer#visitFloat64().(index)
        flushBuffer()
//      ^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushBuffer().
    }
    flushByteBuilder()
//  ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushByteBuilder().
    out
//  ^^^ reference ujson/BaseByteRenderer#out.
  }


  def visitString(s: CharSequence, index: Int) = {
//    ^^^^^^^^^^^ definition ujson/BaseByteRenderer#visitString(). def visitString(s: CharSequence, index: Int): T
//                ^ definition ujson/BaseByteRenderer#visitString().(s) s: CharSequence
//                   ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                 ^^^^^ definition ujson/BaseByteRenderer#visitString().(index) index: Int
//                                        ^^^ reference scala/Int#

    if (s eq null) visitNull(index)
//      ^ reference ujson/BaseByteRenderer#visitString().(s)
//        ^^ reference java/lang/Object#eq().
//                 ^^^^^^^^^ reference ujson/BaseByteRenderer#visitNull().
//                           ^^^^^ reference ujson/BaseByteRenderer#visitString().(index)
    else visitNonNullString(s, index)
//       ^^^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#visitNonNullString().
//                          ^ reference ujson/BaseByteRenderer#visitString().(s)
//                             ^^^^^ reference ujson/BaseByteRenderer#visitString().(index)
  }

  def visitNonNullString(s: CharSequence, index: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition ujson/BaseByteRenderer#visitNonNullString(). def visitNonNullString(s: CharSequence, index: Int): T
//                       ^ definition ujson/BaseByteRenderer#visitNonNullString().(s) s: CharSequence
//                          ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                        ^^^^^ definition ujson/BaseByteRenderer#visitNonNullString().(index) index: Int
//                                               ^^^ reference scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushBuffer().
    upickle.core.RenderUtils.escapeByte(unicodeCharBuilder, elemBuilder, s, escapeUnicode)
//  ^^^^^^^ reference upickle/
//          ^^^^ reference upickle/core/
//               ^^^^^^^^^^^ reference upickle/core/RenderUtils.
//                           ^^^^^^^^^^ reference upickle/core/RenderUtils.escapeByte().
//                                      ^^^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#unicodeCharBuilder.
//                                                          ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//                                                                       ^ reference ujson/BaseByteRenderer#visitNonNullString().(s)
//                                                                          ^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#escapeUnicode.
    flushByteBuilder()
//  ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#flushByteBuilder().
    out
//  ^^^ reference ujson/BaseByteRenderer#out.
  }

  final def renderIndent() = {
//          ^^^^^^^^^^^^ definition ujson/BaseByteRenderer#renderIndent(). final def renderIndent(): Unit
    if (indent == -1) ()
//      ^^^^^^ reference ujson/BaseByteRenderer#indent.
//             ^^ reference scala/Int#`==`(+3).
    else {
      var i = indent * depth
//        ^ definition local24 i: Int
//            ^^^^^^ reference ujson/BaseByteRenderer#indent.
//                   ^ reference scala/Int#`*`(+3).
//                     ^^^^^ reference ujson/BaseByteRenderer#depth().
      elemBuilder.ensureLength(i + 1)
//    ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#ensureLength().
//                             ^ reference local24
//                               ^ reference scala/Int#`+`(+4).
      elemBuilder.appendUnsafe('\n')
//    ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
      while(i > 0) {
//          ^ reference local24
//            ^ reference scala/Int#`>`(+3).
        elemBuilder.appendUnsafe(' ')
//      ^^^^^^^^^^^ reference ujson/BaseByteRenderer#elemBuilder.
//                  ^^^^^^^^^^^^ reference upickle/core/ByteBuilder#appendUnsafe().
        i -= 1
//      ^ reference local24
//        ^^ reference scala/Int#`-`(+3).
      }
    }
  }
}
