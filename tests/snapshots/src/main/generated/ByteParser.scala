package ujson
//      ^^^^^ definition ujson/
import java.io.StringWriter
//     ^^^^ reference java/
//          ^^ reference java/io/
//             ^^^^^^^^^^^^ reference java/io/StringWriter#

import upickle.core.{Abort, AbortException, ObjArrVisitor, ObjVisitor, Visitor}
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                   ^^^^^ reference upickle/core/Abort.
//                   ^^^^^ reference upickle/core/Abort#
//                          ^^^^^^^^^^^^^^ reference upickle/core/AbortException.
//                          ^^^^^^^^^^^^^^ reference upickle/core/AbortException#
//                                          ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                         ^^^^^^^^^^ reference upickle/core/ObjVisitor#
//                                                                     ^^^^^^^ reference upickle/core/Visitor.
//                                                                     ^^^^^^^ reference upickle/core/Visitor#
import java.nio.charset.Charset
//     ^^^^ reference java/
//          ^^^ reference java/nio/
//              ^^^^^^^ reference java/nio/charset/
//                      ^^^^^^^ reference java/nio/charset/Charset#


import scala.annotation.{switch, tailrec}
//     ^^^^^ reference scala/
//           ^^^^^^^^^^ reference scala/annotation/
//                       ^^^^^^ reference scala/annotation/switch#
//                               ^^^^^^^ reference scala/annotation/tailrec#

/**
  * A specialized JSON parse that can parse Bytes (Chars or Bytes), sending
  * method calls to the given [[upickle.core.Visitor]].
  *
  * Generally has a lot of tricks for performance: e.g. having duplicate
  * implementations for nested v.s. top-level parsing, using an `ByteBuilder`
  * to construct the `CharSequences` that `visitString` requires, etc.
  */
abstract class ByteParser[J] extends upickle.core.BufferingByteParser{
//             ^^^^^^^^^^ definition ujson/ByteParser# abstract class ByteParser[J]
//                        ^ definition ujson/ByteParser#[J] J
//                            definition ujson/ByteParser#`<init>`(). def this()
//                                   ^^^^^^^ reference upickle/
//                                           ^^^^ reference upickle/core/
//                                                ^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#
  private[this] val elemOps = upickle.core.ByteOps
//                  ^^^^^^^ definition ujson/ByteParser#elemOps. private[this] val elemOps:
//                            ^^^^^^^ reference upickle/
//                                    ^^^^ reference upickle/core/
//                                         ^^^^^^^ reference upickle/core/ByteOps.
  private[this] val outputBuilder = new upickle.core.ByteBuilder()
//                  ^^^^^^^^^^^^^ definition ujson/ByteParser#outputBuilder. private[this] val outputBuilder: ByteBuilder
//                                      ^^^^^^^ reference upickle/
//                                              ^^^^ reference upickle/core/
//                                                   ^^^^^^^^^^^ reference upickle/core/ByteBuilder#
//                                                               reference upickle/core/ByteBuilder#`<init>`().

  def requestUntilOrThrow(i: Int) = {
//    ^^^^^^^^^^^^^^^^^^^ definition ujson/ByteParser#requestUntilOrThrow(). def requestUntilOrThrow(i: Int): Unit
//                        ^ definition ujson/ByteParser#requestUntilOrThrow().(i) i: Int
//                           ^^^ reference scala/Int#
    if (requestUntil(i)) throw new IncompleteParseException("exhausted input")
//      ^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#requestUntil().
//                   ^ reference ujson/ByteParser#requestUntilOrThrow().(i)
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/IncompleteParseException#
//                                                          reference ujson/IncompleteParseException#`<init>`().
  }
  override def getByteSafe(i: Int): Byte = {
//             ^^^^^^^^^^^ definition ujson/ByteParser#getByteSafe(). def getByteSafe(i: Int): Byte
//                         ^ definition ujson/ByteParser#getByteSafe().(i) i: Int
//                            ^^^ reference scala/Int#
//                                  ^^^^ reference scala/Byte#
    requestUntilOrThrow(i)
//  ^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#requestUntilOrThrow().
//                      ^ reference ujson/ByteParser#getByteSafe().(i)
    getByteUnsafe(i)
//  ^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#getByteUnsafe().
//                ^ reference ujson/ByteParser#getByteSafe().(i)
  }

  /**
   * Return true iff 'i' is at or beyond the end of the input (EOF).
   */
  protected[this] def atEof(i: Int) = requestUntil(i)
//                    ^^^^^ definition ujson/ByteParser#atEof(). def atEof(i: Int): Boolean
//                          ^ definition ujson/ByteParser#atEof().(i) i: Int
//                             ^^^ reference scala/Int#
//                                    ^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#requestUntil().
//                                                 ^ reference ujson/ByteParser#atEof().(i)

  /**
   * Should be called when parsing is finished.
   */
  protected[this] def close(): Unit
//                    ^^^^^ definition ujson/ByteParser#close(). def close(): Unit
//                             ^^^^ reference scala/Unit#

  /**
   * Valid parser states.
   */
  @inline private[this] final val ARRBEG = 6
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^^^^ definition ujson/ByteParser#ARRBEG. @inline private[this] final val ARRBEG: 6
  @inline private[this] final val OBJBEG = 7
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^^^^ definition ujson/ByteParser#OBJBEG. @inline private[this] final val OBJBEG: 7
  @inline private[this] final val DATA = 1
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^^ definition ujson/ByteParser#DATA. @inline private[this] final val DATA: 1
  @inline private[this] final val KEY = 2
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^ definition ujson/ByteParser#KEY. @inline private[this] final val KEY: 2
  @inline private[this] final val COLON = 3
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^^^ definition ujson/ByteParser#COLON. @inline private[this] final val COLON: 3
  @inline private[this] final val ARREND = 4
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^^^^ definition ujson/ByteParser#ARREND. @inline private[this] final val ARREND: 4
  @inline private[this] final val OBJEND = 5
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^^^^ definition ujson/ByteParser#OBJEND. @inline private[this] final val OBJEND: 5

  /**
    * Parse the JSON document into a single JSON value.
    *
    * The parser considers documents like '333', 'true', and '"foo"' to be
    * valid, as well as more traditional documents like [1,2,3,4,5]. However,
    * multiple top-level objects are not allowed.
    */
  final def parse(facade: Visitor[_, J]): J = {
//          ^^^^^ definition ujson/ByteParser#parse(). final def parse(facade: Visitor[local0, J[): J
//                ^^^^^^ definition ujson/ByteParser#parse().(facade) facade: Visitor[local0, J[
//                        ^^^^^^^ reference upickle/core/Visitor#
//                                   ^ reference ujson/ByteParser#[J]
//                                        ^ reference ujson/ByteParser#[J]
    val (value, i) = parseTopLevel(0, facade)
//       ^^^^^ definition local2 value: J
//              ^ definition local3 i: Int
//                   ^^^^^^^^^^^^^ reference ujson/ByteParser#parseTopLevel().
//                                    ^^^^^^ reference ujson/ByteParser#parse().(facade)
    var j = i
//      ^ definition local4 j: Int
//          ^ reference local3
    while (!atEof(j)) {
//         ^ reference scala/Boolean#`unary_!`().
//          ^^^^^ reference ujson/ByteParser#atEof().
//                ^ reference local4
      (getByteSafe(j): @switch) match {
//     ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                 ^ reference local4
        case '\n' | ' ' | '\t' | '\r' => j += 1
//                                       ^ reference local4
//                                         ^^ reference scala/Int#`+`(+4).
        case _ => die(j, "expected whitespace or eof")
//                ^^^ reference ujson/ByteParser#die().
//                    ^ reference local4
      }
    }
    if (!atEof(j)) die(j, "expected eof")
//      ^ reference scala/Boolean#`unary_!`().
//       ^^^^^ reference ujson/ByteParser#atEof().
//             ^ reference local4
//                 ^^^ reference ujson/ByteParser#die().
//                     ^ reference local4
    close()
//  ^^^^^ reference ujson/ByteParser#close().
    value
//  ^^^^^ reference local2
  }

  /**
   * Used to generate error messages with character info and offsets.
   */
  protected[this] def die(i: Int, msg: String): Nothing = {
//                    ^^^ definition ujson/ByteParser#die(). def die(i: Int, msg: String): Nothing
//                        ^ definition ujson/ByteParser#die().(i) i: Int
//                           ^^^ reference scala/Int#
//                                ^^^ definition ujson/ByteParser#die().(msg) msg: String
//                                     ^^^^^^ reference scala/Predef.String#
//                                              ^^^^^^^ reference scala/Nothing#
    val out = new upickle.core.ByteBuilder()
//      ^^^ definition local6 out: ByteBuilder
//                ^^^^^^^ reference upickle/
//                        ^^^^ reference upickle/core/
//                             ^^^^^^^^^^^ reference upickle/core/ByteBuilder#
//                                         reference upickle/core/ByteBuilder#`<init>`().
    upickle.core.RenderUtils.escapeByte(
//  ^^^^^^^ reference upickle/
//          ^^^^ reference upickle/core/
//               ^^^^^^^^^^^ reference upickle/core/RenderUtils.
//                           ^^^^^^^^^^ reference upickle/core/RenderUtils.escapeByte().
      new upickle.core.CharBuilder(),
//        ^^^^^^^ reference upickle/
//                ^^^^ reference upickle/core/
//                     ^^^^^^^^^^^ reference upickle/core/CharBuilder#
//                                 reference upickle/core/CharBuilder#`<init>`().
      out,
//    ^^^ reference local6
      new ArrayCharSequence(Array(elemOps.toInt(getByteSafe(i)).toChar)),
//        ^^^^^^^^^^^^^^^^^ reference scala/Predef.ArrayCharSequence#
//                          reference scala/Predef.ArrayCharSequence#`<init>`().
//                          ^^^^^ reference scala/Array.
//                                ^^^^^^^ reference ujson/ByteParser#elemOps.
//                                        ^^^^^ reference upickle/core/ByteOps.toInt().
//                                              ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                                                          ^ reference ujson/ByteParser#die().(i)
//                                                              ^^^^^^ reference scala/Int#toChar().
      unicode = false
//    ^^^^^^^ reference upickle/core/RenderUtils.escapeByte().(unicode)
    )
    val s = "%s got %s" format (msg, out.makeString())
//      ^ definition local7 s: String
//                      ^^^^^^ reference scala/collection/StringOps#format().
//                              ^^^ reference ujson/ByteParser#die().(msg)
//                                   ^^^ reference local6
//                                       ^^^^^^^^^^ reference upickle/core/ByteBuilder#makeString().
    throw ParseException(s, i)
//        ^^^^^^^^^^^^^^ reference ujson/ParseException.
//                       ^ reference local7
//                          ^ reference ujson/ByteParser#die().(i)
  }


  /**
   * Parse the given number, and add it to the given context.
   *
   * We don't actually instantiate a number here, but rather pass the
   * string of for future use. Facades can choose to be lazy and just
   * store the string. This ends up being way faster and has the nice
   * side-effect that we know exactly how the user represented the
   * number.
   */
  protected[this] final def parseNum(i: Int, ctxt: ObjArrVisitor[Any, J], facade: Visitor[_, J]): Int = {
//                          ^^^^^^^^ definition ujson/ByteParser#parseNum(). final def parseNum(i: Int, ctxt: ObjArrVisitor[Any, J], facade: Visitor[local8, J[): Int
//                                   ^ definition ujson/ByteParser#parseNum().(i) i: Int
//                                      ^^^ reference scala/Int#
//                                           ^^^^ definition ujson/ByteParser#parseNum().(ctxt) ctxt: ObjArrVisitor[Any, J]
//                                                 ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                               ^^^ reference scala/Any#
//                                                                    ^ reference ujson/ByteParser#[J]
//                                                                        ^^^^^^ definition ujson/ByteParser#parseNum().(facade) facade: Visitor[local8, J[
//                                                                                ^^^^^^^ reference upickle/core/Visitor#
//                                                                                           ^ reference ujson/ByteParser#[J]
//                                                                                                ^^^ reference scala/Int#
    var j = i
//      ^ definition local9 j: Int
//          ^ reference ujson/ByteParser#parseNum().(i)
    var c = getByteSafe(j)
//      ^ definition local10 c: Byte
//          ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                      ^ reference local9
    var decIndex = -1
//      ^^^^^^^^ definition local11 decIndex: Int
    var expIndex = -1
//      ^^^^^^^^ definition local12 expIndex: Int

    if (c == '-') {
//      ^ reference local10
//        ^^ reference scala/Byte#`==`(+2).
      j += 1
//    ^ reference local9
//      ^^ reference scala/Int#`+`(+4).
      c = getByteSafe(j)
//    ^ reference local10
//        ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                    ^ reference local9
    }
    if (c == '0') {
//      ^ reference local10
//        ^^ reference scala/Byte#`==`(+2).
      j += 1
//    ^ reference local9
//      ^^ reference scala/Int#`+`(+4).
      c = getByteSafe(j)
//    ^ reference local10
//        ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                    ^ reference local9
    } else {
      val j0 = j
//        ^^ definition local13 j0: Int
//             ^ reference local9
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference ujson/ByteParser#elemOps.
//                   ^^^^^^ reference upickle/core/ByteOps.within().
//                               ^ reference local10
        j += 1;
//      ^ reference local9
//        ^^ reference scala/Int#`+`(+4).
        c = getByteSafe(j)
//      ^ reference local10
//          ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                      ^ reference local9
      }
      if (j == j0) die(i, "expected digit")
//        ^ reference local9
//          ^^ reference scala/Int#`==`(+3).
//             ^^ reference local13
//                 ^^^ reference ujson/ByteParser#die().
//                     ^ reference ujson/ByteParser#parseNum().(i)
    }

    if (c == '.') {
//      ^ reference local10
//        ^^ reference scala/Byte#`==`(+2).
      decIndex = j - i
//    ^^^^^^^^ reference local11
//               ^ reference local9
//                 ^ reference scala/Int#`-`(+3).
//                   ^ reference ujson/ByteParser#parseNum().(i)
      j += 1
//    ^ reference local9
//      ^^ reference scala/Int#`+`(+4).
      c = getByteSafe(j)
//    ^ reference local10
//        ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                    ^ reference local9
      val j0 = j
//        ^^ definition local15 j0: Int
//             ^ reference local9
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference ujson/ByteParser#elemOps.
//                   ^^^^^^ reference upickle/core/ByteOps.within().
//                               ^ reference local10
        j += 1
//      ^ reference local9
//        ^^ reference scala/Int#`+`(+4).
        c = getByteSafe(j)
//      ^ reference local10
//          ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                      ^ reference local9
      }
      if (j0 == j) die(i, "expected digit")
//        ^^ reference local15
//           ^^ reference scala/Int#`==`(+3).
//              ^ reference local9
//                 ^^^ reference ujson/ByteParser#die().
//                     ^ reference ujson/ByteParser#parseNum().(i)
    }

    if (c == 'e' || c == 'E') {
//      ^ reference local10
//        ^^ reference scala/Byte#`==`(+2).
//               ^^ reference scala/Boolean#`||`().
//                  ^ reference local10
//                    ^^ reference scala/Byte#`==`(+2).
      expIndex = j - i
//    ^^^^^^^^ reference local12
//               ^ reference local9
//                 ^ reference scala/Int#`-`(+3).
//                   ^ reference ujson/ByteParser#parseNum().(i)
      j += 1
//    ^ reference local9
//      ^^ reference scala/Int#`+`(+4).
      c = getByteSafe(j)
//    ^ reference local10
//        ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                    ^ reference local9
      if (c == '+' || c == '-') {
//        ^ reference local10
//          ^^ reference scala/Byte#`==`(+2).
//                 ^^ reference scala/Boolean#`||`().
//                    ^ reference local10
//                      ^^ reference scala/Byte#`==`(+2).
        j += 1
//      ^ reference local9
//        ^^ reference scala/Int#`+`(+4).
        c = getByteSafe(j)
//      ^ reference local10
//          ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                      ^ reference local9
      }
      val j0 = j
//        ^^ definition local17 j0: Int
//             ^ reference local9
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference ujson/ByteParser#elemOps.
//                   ^^^^^^ reference upickle/core/ByteOps.within().
//                               ^ reference local10
        j += 1
//      ^ reference local9
//        ^^ reference scala/Int#`+`(+4).
        c = getByteSafe(j)
//      ^ reference local10
//          ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                      ^ reference local9
      }
      if (j0 == j)  die(i, "expected digit")
//        ^^ reference local17
//           ^^ reference scala/Int#`==`(+3).
//              ^ reference local9
//                  ^^^ reference ujson/ByteParser#die().
//                      ^ reference ujson/ByteParser#parseNum().(i)
    }

    ctxt.visitValue(visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), i)
//  ^^^^ reference ujson/ByteParser#parseNum().(ctxt)
//       ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().
//                                                     ^^^^^^ reference ujson/ByteParser#parseNum().(facade)
//                                                             ^^^^^^^^ reference local11
//                                                                       ^^^^^^^^ reference local12
//                                                                                 ^ reference ujson/ByteParser#parseNum().(i)
//                                                                                    ^ reference local9
//                                                                                        ^ reference ujson/ByteParser#parseNum().(i)
    j
//  ^ reference local9
  }

  def visitFloat64StringPartsWithWrapper(facade: Visitor[_, J],
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/ByteParser#visitFloat64StringPartsWithWrapper(). def visitFloat64StringPartsWithWrapper(facade: Visitor[local19, J[, decIndex: Int, expIndex: Int, i: Int, j: Int): J
//                                       ^^^^^^ definition ujson/ByteParser#visitFloat64StringPartsWithWrapper().(facade) facade: Visitor[local19, J[
//                                               ^^^^^^^ reference upickle/core/Visitor#
//                                                          ^ reference ujson/ByteParser#[J]
                                         decIndex: Int,
//                                       ^^^^^^^^ definition ujson/ByteParser#visitFloat64StringPartsWithWrapper().(decIndex) decIndex: Int
//                                                 ^^^ reference scala/Int#
                                         expIndex: Int,
//                                       ^^^^^^^^ definition ujson/ByteParser#visitFloat64StringPartsWithWrapper().(expIndex) expIndex: Int
//                                                 ^^^ reference scala/Int#
                                         i: Int,
//                                       ^ definition ujson/ByteParser#visitFloat64StringPartsWithWrapper().(i) i: Int
//                                          ^^^ reference scala/Int#
                                         j: Int) = {
//                                       ^ definition ujson/ByteParser#visitFloat64StringPartsWithWrapper().(j) j: Int
//                                          ^^^ reference scala/Int#
    facade.visitFloat64StringParts(
//  ^^^^^^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().(facade)
//         ^^^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/Visitor#visitFloat64StringParts().
      unsafeCharSeqForRange(i, j - i),
//    ^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#unsafeCharSeqForRange().
//                          ^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().(i)
//                             ^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().(j)
//                               ^ reference scala/Int#`-`(+3).
//                                 ^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().(i)
      decIndex,
//    ^^^^^^^^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().(decIndex)
      expIndex,
//    ^^^^^^^^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().(expIndex)
      i
//    ^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().(i)
    )
  }

  /**
   * Parse the given number, and add it to the given context.
   *
   * This method is a bit slower than parseNum() because it has to be
   * sure it doesn't run off the end of the input.
   *
   * Normally (when operating in rparse in the context of an outer
   * array or object) we don't need to worry about this and can just
   * grab characters, because if we run out of characters that would
   * indicate bad input. This is for cases where the number could
   * possibly be followed by a valid EOF.
   *
   * This method has all the same caveats as the previous method.
   */
  protected[this] final def parseNumTopLevel(i: Int, facade: Visitor[_, J]): (J, Int) = {
//                          ^^^^^^^^^^^^^^^^ definition ujson/ByteParser#parseNumTopLevel(). final def parseNumTopLevel(i: Int, facade: Visitor[local20, J[): (J, Int)
//                                           ^ definition ujson/ByteParser#parseNumTopLevel().(i) i: Int
//                                              ^^^ reference scala/Int#
//                                                   ^^^^^^ definition ujson/ByteParser#parseNumTopLevel().(facade) facade: Visitor[local20, J[
//                                                           ^^^^^^^ reference upickle/core/Visitor#
//                                                                      ^ reference ujson/ByteParser#[J]
//                                                                            ^ reference ujson/ByteParser#[J]
//                                                                               ^^^ reference scala/Int#
    var j = i
//      ^ definition local21 j: Int
//          ^ reference ujson/ByteParser#parseNumTopLevel().(i)
    var c = getByteSafe(j)
//      ^ definition local22 c: Byte
//          ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                      ^ reference local21
    var decIndex = -1
//      ^^^^^^^^ definition local23 decIndex: Int
    var expIndex = -1
//      ^^^^^^^^ definition local24 expIndex: Int

    if (c == '-') {
//      ^ reference local22
//        ^^ reference scala/Byte#`==`(+2).
      // any valid input will require at least one digit after -
      j += 1
//    ^ reference local21
//      ^^ reference scala/Int#`+`(+4).
      c = getByteSafe(j)
//    ^ reference local22
//        ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                    ^ reference local21
    }
    if (c == '0') {
//      ^ reference local22
//        ^^ reference scala/Byte#`==`(+2).
      j += 1
//    ^ reference local21
//      ^^ reference scala/Int#`+`(+4).
      if (atEof(j)) {
//        ^^^^^ reference ujson/ByteParser#atEof().
//              ^ reference local21
        return (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().
//                                                 ^^^^^^ reference ujson/ByteParser#parseNumTopLevel().(facade)
//                                                         ^^^^^^^^ reference local23
//                                                                   ^^^^^^^^ reference local24
//                                                                             ^ reference ujson/ByteParser#parseNumTopLevel().(i)
//                                                                                ^ reference local21
//                                                                                    ^ reference local21
      }
      c = getByteSafe(j)
//    ^ reference local22
//        ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                    ^ reference local21
    } else {
      val j0 = j
//        ^^ definition local25 j0: Int
//             ^ reference local21
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference ujson/ByteParser#elemOps.
//                   ^^^^^^ reference upickle/core/ByteOps.within().
//                               ^ reference local22
        j += 1
//      ^ reference local21
//        ^^ reference scala/Int#`+`(+4).
        if (atEof(j)) {
//          ^^^^^ reference ujson/ByteParser#atEof().
//                ^ reference local21
          return (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().
//                                                   ^^^^^^ reference ujson/ByteParser#parseNumTopLevel().(facade)
//                                                           ^^^^^^^^ reference local23
//                                                                     ^^^^^^^^ reference local24
//                                                                               ^ reference ujson/ByteParser#parseNumTopLevel().(i)
//                                                                                  ^ reference local21
//                                                                                      ^ reference local21
        }
        c = getByteSafe(j)
//      ^ reference local22
//          ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                      ^ reference local21
      }
      if (j0 == j) die(i, "expected digit")
//        ^^ reference local25
//           ^^ reference scala/Int#`==`(+3).
//              ^ reference local21
//                 ^^^ reference ujson/ByteParser#die().
//                     ^ reference ujson/ByteParser#parseNumTopLevel().(i)
    }

    if (c == '.') {
//      ^ reference local22
//        ^^ reference scala/Byte#`==`(+2).
      // any valid input will require at least one digit after .
      decIndex = j - i
//    ^^^^^^^^ reference local23
//               ^ reference local21
//                 ^ reference scala/Int#`-`(+3).
//                   ^ reference ujson/ByteParser#parseNumTopLevel().(i)
      j += 1
//    ^ reference local21
//      ^^ reference scala/Int#`+`(+4).
      c = getByteSafe(j)
//    ^ reference local22
//        ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                    ^ reference local21
      val j0 = j
//        ^^ definition local27 j0: Int
//             ^ reference local21
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference ujson/ByteParser#elemOps.
//                   ^^^^^^ reference upickle/core/ByteOps.within().
//                               ^ reference local22
        j += 1
//      ^ reference local21
//        ^^ reference scala/Int#`+`(+4).
        if (atEof(j)) {
//          ^^^^^ reference ujson/ByteParser#atEof().
//                ^ reference local21
          return (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().
//                                                   ^^^^^^ reference ujson/ByteParser#parseNumTopLevel().(facade)
//                                                           ^^^^^^^^ reference local23
//                                                                     ^^^^^^^^ reference local24
//                                                                               ^ reference ujson/ByteParser#parseNumTopLevel().(i)
//                                                                                  ^ reference local21
//                                                                                      ^ reference local21
        }
        c = getByteSafe(j)
//      ^ reference local22
//          ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                      ^ reference local21
      }
      if(j0 == j) die(i, "expected digit")
//       ^^ reference local27
//          ^^ reference scala/Int#`==`(+3).
//             ^ reference local21
//                ^^^ reference ujson/ByteParser#die().
//                    ^ reference ujson/ByteParser#parseNumTopLevel().(i)
    }

    if (c == 'e' || c == 'E') {
//      ^ reference local22
//        ^^ reference scala/Byte#`==`(+2).
//               ^^ reference scala/Boolean#`||`().
//                  ^ reference local22
//                    ^^ reference scala/Byte#`==`(+2).
      // any valid input will require at least one digit after e, e+, etc
      expIndex = j - i
//    ^^^^^^^^ reference local24
//               ^ reference local21
//                 ^ reference scala/Int#`-`(+3).
//                   ^ reference ujson/ByteParser#parseNumTopLevel().(i)
      j += 1
//    ^ reference local21
//      ^^ reference scala/Int#`+`(+4).
      c = getByteSafe(j)
//    ^ reference local22
//        ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                    ^ reference local21
      if (c == '+' || c == '-') {
//        ^ reference local22
//          ^^ reference scala/Byte#`==`(+2).
//                 ^^ reference scala/Boolean#`||`().
//                    ^ reference local22
//                      ^^ reference scala/Byte#`==`(+2).
        j += 1
//      ^ reference local21
//        ^^ reference scala/Int#`+`(+4).
        c = getByteSafe(j)
//      ^ reference local22
//          ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                      ^ reference local21
      }
      val j0 = j
//        ^^ definition local29 j0: Int
//             ^ reference local21
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference ujson/ByteParser#elemOps.
//                   ^^^^^^ reference upickle/core/ByteOps.within().
//                               ^ reference local22
        j += 1
//      ^ reference local21
//        ^^ reference scala/Int#`+`(+4).
        if (atEof(j)) {
//          ^^^^^ reference ujson/ByteParser#atEof().
//                ^ reference local21
          return (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().
//                                                   ^^^^^^ reference ujson/ByteParser#parseNumTopLevel().(facade)
//                                                           ^^^^^^^^ reference local23
//                                                                     ^^^^^^^^ reference local24
//                                                                               ^ reference ujson/ByteParser#parseNumTopLevel().(i)
//                                                                                  ^ reference local21
//                                                                                      ^ reference local21
        }
        c = getByteSafe(j)
//      ^ reference local22
//          ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                      ^ reference local21
      }
      if (j0 == j) die(i, "expected digit")
//        ^^ reference local29
//           ^^ reference scala/Int#`==`(+3).
//              ^ reference local21
//                 ^^^ reference ujson/ByteParser#die().
//                     ^ reference ujson/ByteParser#parseNumTopLevel().(i)
    }

    (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#visitFloat64StringPartsWithWrapper().
//                                      ^^^^^^ reference ujson/ByteParser#parseNumTopLevel().(facade)
//                                              ^^^^^^^^ reference local23
//                                                        ^^^^^^^^ reference local24
//                                                                  ^ reference ujson/ByteParser#parseNumTopLevel().(i)
//                                                                     ^ reference local21
//                                                                         ^ reference local21
  }

  /**
   * Generate a Char from the hex digits of "\u1234" (i.e. "1234").
   *
   * NOTE: This is only capable of generating characters from the basic plane.
   * This is why it can only return Char instead of Int.
   */
  protected[this] final def descape(i: Int): Char = {
//                          ^^^^^^^ definition ujson/ByteParser#descape(). final def descape(i: Int): Char
//                                  ^ definition ujson/ByteParser#descape().(i) i: Int
//                                     ^^^ reference scala/Int#
//                                           ^^^^ reference scala/Char#
    import upickle.core.RenderUtils.hex
//         ^^^^^^^ reference upickle/
//                 ^^^^ reference upickle/core/
//                      ^^^^^^^^^^^ reference upickle/core/RenderUtils.
//                                  ^^^ reference upickle/core/RenderUtils.hex().
    var x = 0
//      ^ definition local31 x: Int
    x = (x << 4) | hex(getByteSafe(i+2).toInt)
//  ^ reference local31
//       ^ reference local31
//         ^^ reference scala/Int#`<<`().
//               ^ reference scala/Int#`|`(+3).
//                 ^^^ reference upickle/core/RenderUtils.hex().
//                     ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                                 ^ reference ujson/ByteParser#descape().(i)
//                                  ^ reference scala/Int#`+`(+4).
//                                      ^^^^^ reference scala/Byte#toInt().
    x = (x << 4) | hex(getByteSafe(i+3).toInt)
//  ^ reference local31
//       ^ reference local31
//         ^^ reference scala/Int#`<<`().
//               ^ reference scala/Int#`|`(+3).
//                 ^^^ reference upickle/core/RenderUtils.hex().
//                     ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                                 ^ reference ujson/ByteParser#descape().(i)
//                                  ^ reference scala/Int#`+`(+4).
//                                      ^^^^^ reference scala/Byte#toInt().
    x = (x << 4) | hex(getByteSafe(i+4).toInt)
//  ^ reference local31
//       ^ reference local31
//         ^^ reference scala/Int#`<<`().
//               ^ reference scala/Int#`|`(+3).
//                 ^^^ reference upickle/core/RenderUtils.hex().
//                     ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                                 ^ reference ujson/ByteParser#descape().(i)
//                                  ^ reference scala/Int#`+`(+4).
//                                      ^^^^^ reference scala/Byte#toInt().
    x = (x << 4) | hex(getByteSafe(i+5).toInt)
//  ^ reference local31
//       ^ reference local31
//         ^^ reference scala/Int#`<<`().
//               ^ reference scala/Int#`|`(+3).
//                 ^^^ reference upickle/core/RenderUtils.hex().
//                     ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                                 ^ reference ujson/ByteParser#descape().(i)
//                                  ^ reference scala/Int#`+`(+4).
//                                      ^^^^^ reference scala/Byte#toInt().
    x.toChar
//  ^ reference local31
//    ^^^^^^ reference scala/Int#toChar().
  }


  /**
   * Parse the JSON constant "true".
   *
   * Note that this method assumes that the first character has already been checked.
   */
  protected[this] final def parseTrue(i: Int, facade: Visitor[_, J]): J = {
//                          ^^^^^^^^^ definition ujson/ByteParser#parseTrue(). final def parseTrue(i: Int, facade: Visitor[local32, J[): J
//                                    ^ definition ujson/ByteParser#parseTrue().(i) i: Int
//                                       ^^^ reference scala/Int#
//                                            ^^^^^^ definition ujson/ByteParser#parseTrue().(facade) facade: Visitor[local32, J[
//                                                    ^^^^^^^ reference upickle/core/Visitor#
//                                                               ^ reference ujson/ByteParser#[J]
//                                                                    ^ reference ujson/ByteParser#[J]
    requestUntilOrThrow(i + 3)
//  ^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#requestUntilOrThrow().
//                      ^ reference ujson/ByteParser#parseTrue().(i)
//                        ^ reference scala/Int#`+`(+4).
    if (getByteUnsafe(i + 1) == 'r' && getByteUnsafe(i + 2) == 'u' && getByteUnsafe(i + 3) == 'e') {
//      ^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#getByteUnsafe().
//                    ^ reference ujson/ByteParser#parseTrue().(i)
//                      ^ reference scala/Int#`+`(+4).
//                           ^^ reference scala/Byte#`==`(+2).
//                                  ^^ reference scala/Boolean#`&&`().
//                                     ^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#getByteUnsafe().
//                                                   ^ reference ujson/ByteParser#parseTrue().(i)
//                                                     ^ reference scala/Int#`+`(+4).
//                                                          ^^ reference scala/Byte#`==`(+2).
//                                                                 ^^ reference scala/Boolean#`&&`().
//                                                                    ^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#getByteUnsafe().
//                                                                                  ^ reference ujson/ByteParser#parseTrue().(i)
//                                                                                    ^ reference scala/Int#`+`(+4).
//                                                                                         ^^ reference scala/Byte#`==`(+2).
      facade.visitTrue(i)
//    ^^^^^^ reference ujson/ByteParser#parseTrue().(facade)
//           ^^^^^^^^^ reference upickle/core/Visitor#visitTrue().
//                     ^ reference ujson/ByteParser#parseTrue().(i)
    } else {
      die(i, "expected true")
//    ^^^ reference ujson/ByteParser#die().
//        ^ reference ujson/ByteParser#parseTrue().(i)
    }
  }

  /**
   * Parse the JSON constant "false".
   *
   * Note that this method assumes that the first character has already been checked.
   */
  protected[this] final def parseFalse(i: Int, facade: Visitor[_, J]): J = {
//                          ^^^^^^^^^^ definition ujson/ByteParser#parseFalse(). final def parseFalse(i: Int, facade: Visitor[local33, J[): J
//                                     ^ definition ujson/ByteParser#parseFalse().(i) i: Int
//                                        ^^^ reference scala/Int#
//                                             ^^^^^^ definition ujson/ByteParser#parseFalse().(facade) facade: Visitor[local33, J[
//                                                     ^^^^^^^ reference upickle/core/Visitor#
//                                                                ^ reference ujson/ByteParser#[J]
//                                                                     ^ reference ujson/ByteParser#[J]
    requestUntilOrThrow(i + 4)
//  ^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#requestUntilOrThrow().
//                      ^ reference ujson/ByteParser#parseFalse().(i)
//                        ^ reference scala/Int#`+`(+4).

    if (getByteUnsafe(i + 1) == 'a' && getByteUnsafe(i + 2) == 'l' && getByteUnsafe(i + 3) == 's' && getByteUnsafe(i + 4) == 'e') {
//      ^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#getByteUnsafe().
//                    ^ reference ujson/ByteParser#parseFalse().(i)
//                      ^ reference scala/Int#`+`(+4).
//                           ^^ reference scala/Byte#`==`(+2).
//                                  ^^ reference scala/Boolean#`&&`().
//                                     ^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#getByteUnsafe().
//                                                   ^ reference ujson/ByteParser#parseFalse().(i)
//                                                     ^ reference scala/Int#`+`(+4).
//                                                          ^^ reference scala/Byte#`==`(+2).
//                                                                 ^^ reference scala/Boolean#`&&`().
//                                                                    ^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#getByteUnsafe().
//                                                                                  ^ reference ujson/ByteParser#parseFalse().(i)
//                                                                                    ^ reference scala/Int#`+`(+4).
//                                                                                         ^^ reference scala/Byte#`==`(+2).
//                                                                                                ^^ reference scala/Boolean#`&&`().
//                                                                                                   ^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#getByteUnsafe().
//                                                                                                                 ^ reference ujson/ByteParser#parseFalse().(i)
//                                                                                                                   ^ reference scala/Int#`+`(+4).
//                                                                                                                        ^^ reference scala/Byte#`==`(+2).
      facade.visitFalse(i)
//    ^^^^^^ reference ujson/ByteParser#parseFalse().(facade)
//           ^^^^^^^^^^ reference upickle/core/Visitor#visitFalse().
//                      ^ reference ujson/ByteParser#parseFalse().(i)
    } else {
      die(i, "expected false")
//    ^^^ reference ujson/ByteParser#die().
//        ^ reference ujson/ByteParser#parseFalse().(i)
    }
  }

  /**
   * Parse the JSON constant "null".
   *
   * Note that this method assumes that the first character has already been checked.
   */
  protected[this] final def parseNull(i: Int, facade: Visitor[_, J]): J = {
//                          ^^^^^^^^^ definition ujson/ByteParser#parseNull(). final def parseNull(i: Int, facade: Visitor[local34, J[): J
//                                    ^ definition ujson/ByteParser#parseNull().(i) i: Int
//                                       ^^^ reference scala/Int#
//                                            ^^^^^^ definition ujson/ByteParser#parseNull().(facade) facade: Visitor[local34, J[
//                                                    ^^^^^^^ reference upickle/core/Visitor#
//                                                               ^ reference ujson/ByteParser#[J]
//                                                                    ^ reference ujson/ByteParser#[J]
    requestUntilOrThrow(i + 3)
//  ^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#requestUntilOrThrow().
//                      ^ reference ujson/ByteParser#parseNull().(i)
//                        ^ reference scala/Int#`+`(+4).
    if (getByteUnsafe(i + 1) == 'u' && getByteUnsafe(i + 2) == 'l' && getByteUnsafe(i + 3) == 'l') {
//      ^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#getByteUnsafe().
//                    ^ reference ujson/ByteParser#parseNull().(i)
//                      ^ reference scala/Int#`+`(+4).
//                           ^^ reference scala/Byte#`==`(+2).
//                                  ^^ reference scala/Boolean#`&&`().
//                                     ^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#getByteUnsafe().
//                                                   ^ reference ujson/ByteParser#parseNull().(i)
//                                                     ^ reference scala/Int#`+`(+4).
//                                                          ^^ reference scala/Byte#`==`(+2).
//                                                                 ^^ reference scala/Boolean#`&&`().
//                                                                    ^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#getByteUnsafe().
//                                                                                  ^ reference ujson/ByteParser#parseNull().(i)
//                                                                                    ^ reference scala/Int#`+`(+4).
//                                                                                         ^^ reference scala/Byte#`==`(+2).
      facade.visitNull(i)
//    ^^^^^^ reference ujson/ByteParser#parseNull().(facade)
//           ^^^^^^^^^ reference upickle/core/Visitor#visitNull().
//                     ^ reference ujson/ByteParser#parseNull().(i)
    } else {
      die(i, "expected null")
//    ^^^ reference ujson/ByteParser#die().
//        ^ reference ujson/ByteParser#parseNull().(i)
    }
  }

  protected[this] final def parseTopLevel(i: Int, facade: Visitor[_, J]): (J, Int) = {
//                          ^^^^^^^^^^^^^ definition ujson/ByteParser#parseTopLevel(). final def parseTopLevel(i: Int, facade: Visitor[local35, J[): (J, Int)
//                                        ^ definition ujson/ByteParser#parseTopLevel().(i) i: Int
//                                           ^^^ reference scala/Int#
//                                                ^^^^^^ definition ujson/ByteParser#parseTopLevel().(facade) facade: Visitor[local35, J[
//                                                        ^^^^^^^ reference upickle/core/Visitor#
//                                                                   ^ reference ujson/ByteParser#[J]
//                                                                         ^ reference ujson/ByteParser#[J]
//                                                                            ^^^ reference scala/Int#
    try parseTopLevel0(i, facade)
//      ^^^^^^^^^^^^^^ reference ujson/ByteParser#parseTopLevel0().
//                     ^ reference ujson/ByteParser#parseTopLevel().(i)
//                        ^^^^^^ reference ujson/ByteParser#parseTopLevel().(facade)
    catch reject(i)
//        ^^^^^^ reference ujson/ByteParser#reject().
//               ^ reference ujson/ByteParser#parseTopLevel().(i)
  }
  /**
   * Parse and return the next JSON value and the position beyond it.
   */
  @tailrec
// ^^^^^^^ reference scala/annotation/tailrec#
//         reference scala/annotation/tailrec#`<init>`().
  protected[this] final def parseTopLevel0(i: Int, facade: Visitor[_, J]): (J, Int) = {
//                          ^^^^^^^^^^^^^^ definition ujson/ByteParser#parseTopLevel0(). @tailrec final def parseTopLevel0(i: Int, facade: Visitor[local38, J[): (J, Int)
//                                         ^ definition ujson/ByteParser#parseTopLevel0().(i) i: Int
//                                            ^^^ reference scala/Int#
//                                                 ^^^^^^ definition ujson/ByteParser#parseTopLevel0().(facade) facade: Visitor[local38, J[
//                                                         ^^^^^^^ reference upickle/core/Visitor#
//                                                                    ^ reference ujson/ByteParser#[J]
//                                                                          ^ reference ujson/ByteParser#[J]
//                                                                             ^^^ reference scala/Int#
    (getByteSafe(i): @switch) match {
//   ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//               ^ reference ujson/ByteParser#parseTopLevel0().(i)
      // ignore whitespace
      case ' ' | '\t' | 'r' => parseTopLevel0(i + 1, facade)
//                             ^^^^^^^^^^^^^^ reference ujson/ByteParser#parseTopLevel0().
//                                            ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                                              ^ reference scala/Int#`+`(+4).
//                                                   ^^^^^^ reference ujson/ByteParser#parseTopLevel0().(facade)
      case '\n' => parseTopLevel0(i + 1, facade)
//                 ^^^^^^^^^^^^^^ reference ujson/ByteParser#parseTopLevel0().
//                                ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                                  ^ reference scala/Int#`+`(+4).
//                                       ^^^^^^ reference ujson/ByteParser#parseTopLevel0().(facade)

      // if we have a recursive top-level structure, we'll delegate the parsing
      // duties to our good friend rparse().
      case '[' => parseNested(ARRBEG, i + 1, facade.visitArray(-1, i), Nil)
//                ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                            ^^^^^^ reference ujson/ByteParser#ARRBEG.
//                                    ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                                      ^ reference scala/Int#`+`(+4).
//                                           ^^^^^^ reference ujson/ByteParser#parseTopLevel0().(facade)
//                                                  ^^^^^^^^^^ reference upickle/core/Visitor#visitArray().
//                                                                 ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                                                                     ^^^ reference scala/package.Nil.
      case '{' => parseNested(OBJBEG, i + 1, facade.visitObject(-1, i), Nil)
//                ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                            ^^^^^^ reference ujson/ByteParser#OBJBEG.
//                                    ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                                      ^ reference scala/Int#`+`(+4).
//                                           ^^^^^^ reference ujson/ByteParser#parseTopLevel0().(facade)
//                                                  ^^^^^^^^^^^ reference upickle/core/Visitor#visitObject().
//                                                                  ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                                                                      ^^^ reference scala/package.Nil.

      // we have a single top-level number
      case '-' | '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' => parseNumTopLevel(i, facade)
//                                                                            ^^^^^^^^^^^^^^^^ reference ujson/ByteParser#parseNumTopLevel().
//                                                                                             ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                                                                                                ^^^^^^ reference ujson/ByteParser#parseTopLevel0().(facade)

      // we have a single top-level string
      case '"' => parseStringTopLevel(i, facade)
//                ^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#parseStringTopLevel().
//                                    ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                                       ^^^^^^ reference ujson/ByteParser#parseTopLevel0().(facade)

      // we have a single top-level constant
      case 't' => (parseTrue(i, facade), i + 4)
//                 ^^^^^^^^^ reference ujson/ByteParser#parseTrue().
//                           ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                              ^^^^^^ reference ujson/ByteParser#parseTopLevel0().(facade)
//                                       ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                                         ^ reference scala/Int#`+`(+4).
      case 'f' => (parseFalse(i, facade), i + 5)
//                 ^^^^^^^^^^ reference ujson/ByteParser#parseFalse().
//                            ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                               ^^^^^^ reference ujson/ByteParser#parseTopLevel0().(facade)
//                                        ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                                          ^ reference scala/Int#`+`(+4).
      case 'n' => (parseNull(i, facade), i + 4)
//                 ^^^^^^^^^ reference ujson/ByteParser#parseNull().
//                           ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                              ^^^^^^ reference ujson/ByteParser#parseTopLevel0().(facade)
//                                       ^ reference ujson/ByteParser#parseTopLevel0().(i)
//                                         ^ reference scala/Int#`+`(+4).

      // invalid
      case _ => die(i, "expected json value")
//              ^^^ reference ujson/ByteParser#die().
//                  ^ reference ujson/ByteParser#parseTopLevel0().(i)
    }
  }

  def reject(j: Int): PartialFunction[Throwable, Nothing] = {
//    ^^^^^^ definition ujson/ByteParser#reject(). def reject(j: Int): PartialFunction[Throwable, Nothing]
//           ^ definition ujson/ByteParser#reject().(j) j: Int
//              ^^^ reference scala/Int#
//                    ^^^^^^^^^^^^^^^ reference scala/PartialFunction#
//                                    ^^^^^^^^^ reference scala/package.Throwable#
//                                               ^^^^^^^ reference scala/Nothing#
//                                                           definition local39 @SerialVersionUID final class $anonfun
    case e: Abort =>
//       ^ definition local46 e: Abort
//          ^^^^^ reference upickle/core/Abort#
      throw new AbortException(e.msg, j, -1, -1, e)
//              ^^^^^^^^^^^^^^ reference upickle/core/AbortException#
//                             reference upickle/core/AbortException#`<init>`().
//                             ^ reference local46
//                               ^^^ reference upickle/core/Abort#msg.
//                                    ^ reference ujson/ByteParser#reject().(j)
//                                               ^ reference local46
  }
  /**
   * Tail-recursive parsing method to do the bulk of JSON parsing.
   *
   * This single method manages parser states, data, etc. Except for
   * parsing non-recursive values (like strings, numbers, and
   * constants) all important work happens in this loop (or in methods
   * it calls, like reset()).
   *
   * Currently the code is optimized to make use of switch
   * statements. Future work should consider whether this is better or
   * worse than manually constructed if/else statements or something
   * else. Also, it may be possible to reorder some cases for speed
   * improvements.
   *
   * @param j index/position in the source json
   * @param path the json path in the tree
   */
  @tailrec
// ^^^^^^^ reference scala/annotation/tailrec#
//         reference scala/annotation/tailrec#`<init>`().
  protected[this] final def parseNested(state: Int,
//                          ^^^^^^^^^^^ definition ujson/ByteParser#parseNested(). @tailrec final def parseNested(state: Int, i: Int, stackHead: ObjArrVisitor[local50, J[, stackTail: List[ObjArrVisitor[local51, J[]): (J, Int)
//                                      ^^^^^ definition ujson/ByteParser#parseNested().(state) state: Int
//                                             ^^^ reference scala/Int#
                                        i: Int,
//                                      ^ definition ujson/ByteParser#parseNested().(i) i: Int
//                                         ^^^ reference scala/Int#
                                        stackHead: ObjArrVisitor[_, J],
//                                      ^^^^^^^^^ definition ujson/ByteParser#parseNested().(stackHead) stackHead: ObjArrVisitor[local50, J[
//                                                 ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                  ^ reference ujson/ByteParser#[J]
                                        stackTail: List[ObjArrVisitor[_, J]]) : (J, Int) = {
//                                      ^^^^^^^^^ definition ujson/ByteParser#parseNested().(stackTail) stackTail: List[ObjArrVisitor[local51, J[]
//                                                 ^^^^ reference scala/package.List#
//                                                      ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                       ^ reference ujson/ByteParser#[J]
//                                                                               ^ reference ujson/ByteParser#[J]
//                                                                                  ^^^ reference scala/Int#
    (getByteSafe(i): @switch) match{
//   ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//               ^ reference ujson/ByteParser#parseNested().(i)
      case ' ' | '\t' | '\r' | '\n' =>
        parseNested(state, i + 1, stackHead, stackTail)
//      ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                  ^^^^^ reference ujson/ByteParser#parseNested().(state)
//                         ^ reference ujson/ByteParser#parseNested().(i)
//                           ^ reference scala/Int#`+`(+4).
//                                ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                           ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)

      case '"' =>
        state match{
//      ^^^^^ reference ujson/ByteParser#parseNested().(state)
          case KEY | OBJBEG =>
//             ^^^ reference ujson/ByteParser#KEY.
//                   ^^^^^^ reference ujson/ByteParser#OBJBEG.
            val nextJ = try parseStringKey(i, stackHead) catch reject(i)
//              ^^^^^ definition local52 nextJ: Int
//                          ^^^^^^^^^^^^^^ reference ujson/ByteParser#parseStringKey().
//                                         ^ reference ujson/ByteParser#parseNested().(i)
//                                            ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                                             ^^^^^^ reference ujson/ByteParser#reject().
//                                                                    ^ reference ujson/ByteParser#parseNested().(i)
            parseNested(COLON, nextJ, stackHead, stackTail)
//          ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                      ^^^^^ reference ujson/ByteParser#COLON.
//                             ^^^^^ reference local52
//                                    ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                               ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)

          case DATA | ARRBEG =>
//             ^^^^ reference ujson/ByteParser#DATA.
//                    ^^^^^^ reference ujson/ByteParser#ARRBEG.
            val nextJ = try parseStringValue(i, stackHead) catch reject(i)
//              ^^^^^ definition local55 nextJ: Int
//                          ^^^^^^^^^^^^^^^^ reference ujson/ByteParser#parseStringValue().
//                                           ^ reference ujson/ByteParser#parseNested().(i)
//                                              ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                                               ^^^^^^ reference ujson/ByteParser#reject().
//                                                                      ^ reference ujson/ByteParser#parseNested().(i)
            parseNested(collectionEndFor(stackHead), nextJ, stackHead, stackTail)
//          ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                      ^^^^^^^^^^^^^^^^ reference ujson/ByteParser#collectionEndFor().
//                                       ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                                   ^^^^^ reference local55
//                                                          ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                                                     ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)

          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#dieWithFailureMessage().
//                                        ^ reference ujson/ByteParser#parseNested().(i)
//                                           ^^^^^ reference ujson/ByteParser#parseNested().(state)
        }

      case ':' =>
        // we are in an object just after a key, expecting to see a colon.
        state match{
//      ^^^^^ reference ujson/ByteParser#parseNested().(state)
          case COLON => parseNested(DATA, i + 1, stackHead, stackTail)
//             ^^^^^ reference ujson/ByteParser#COLON.
//                      ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                                  ^^^^ reference ujson/ByteParser#DATA.
//                                        ^ reference ujson/ByteParser#parseNested().(i)
//                                          ^ reference scala/Int#`+`(+4).
//                                               ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                                          ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)
          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#dieWithFailureMessage().
//                                        ^ reference ujson/ByteParser#parseNested().(i)
//                                           ^^^^^ reference ujson/ByteParser#parseNested().(state)
        }

      case '[' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference ujson/ByteParser#failIfNotData().
//                    ^^^^^ reference ujson/ByteParser#parseNested().(state)
//                           ^ reference ujson/ByteParser#parseNested().(i)
        val ctx =
//          ^^^ definition local58 ctx: ArrVisitor[local59, J[
          try stackHead.subVisitor.asInstanceOf[Visitor[_, J]].visitArray(-1, i)
//            ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                      ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                 ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                              ^^^^^^^ reference upickle/core/Visitor#
//                                                         ^ reference ujson/ByteParser#[J]
//                                                             ^^^^^^^^^^ reference upickle/core/Visitor#visitArray().
//                                                                            ^ reference ujson/ByteParser#parseNested().(i)
          catch reject(i)
//              ^^^^^^ reference ujson/ByteParser#reject().
//                     ^ reference ujson/ByteParser#parseNested().(i)
        parseNested(ARRBEG, i + 1, ctx, stackHead :: stackTail)
//      ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                  ^^^^^^ reference ujson/ByteParser#ARRBEG.
//                          ^ reference ujson/ByteParser#parseNested().(i)
//                            ^ reference scala/Int#`+`(+4).
//                                 ^^^ reference local58
//                                      ^^^^^^^^^ reference local62
//                                                ^^ reference scala/collection/immutable/List#`::`().
//                                                   ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)

      case '{' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference ujson/ByteParser#failIfNotData().
//                    ^^^^^ reference ujson/ByteParser#parseNested().(state)
//                           ^ reference ujson/ByteParser#parseNested().(i)
        val ctx =
//          ^^^ definition local63 ctx: ObjVisitor[local64, J[
          try stackHead.subVisitor.asInstanceOf[Visitor[_, J]].visitObject(-1, i)
//            ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                      ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                 ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                              ^^^^^^^ reference upickle/core/Visitor#
//                                                         ^ reference ujson/ByteParser#[J]
//                                                             ^^^^^^^^^^^ reference upickle/core/Visitor#visitObject().
//                                                                             ^ reference ujson/ByteParser#parseNested().(i)
          catch reject(i)
//              ^^^^^^ reference ujson/ByteParser#reject().
//                     ^ reference ujson/ByteParser#parseNested().(i)
        parseNested(OBJBEG, i + 1, ctx, stackHead :: stackTail)
//      ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                  ^^^^^^ reference ujson/ByteParser#OBJBEG.
//                          ^ reference ujson/ByteParser#parseNested().(i)
//                            ^ reference scala/Int#`+`(+4).
//                                 ^^^ reference local63
//                                      ^^^^^^^^^ reference local67
//                                                ^^ reference scala/collection/immutable/List#`::`().
//                                                   ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)

      case '-' | '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference ujson/ByteParser#failIfNotData().
//                    ^^^^^ reference ujson/ByteParser#parseNested().(state)
//                           ^ reference ujson/ByteParser#parseNested().(i)
        val ctx =
//          ^^^ definition local68 ctx: Int
          try parseNum(i, stackHead.narrow, stackHead.subVisitor.asInstanceOf[Visitor[_, J]])
//            ^^^^^^^^ reference ujson/ByteParser#parseNum().
//                     ^ reference ujson/ByteParser#parseNested().(i)
//                        ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                  ^^^^^^ reference upickle/core/ObjArrVisitor#narrow().
//                                          ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                                    ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                                               ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                                                            ^^^^^^^ reference upickle/core/Visitor#
//                                                                                       ^ reference ujson/ByteParser#[J]
          catch reject(i)
//              ^^^^^^ reference ujson/ByteParser#reject().
//                     ^ reference ujson/ByteParser#parseNested().(i)
        parseNested(collectionEndFor(stackHead), ctx, stackHead, stackTail)
//      ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                  ^^^^^^^^^^^^^^^^ reference ujson/ByteParser#collectionEndFor().
//                                   ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                               ^^^ reference local68
//                                                    ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                                               ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)

      case 't' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference ujson/ByteParser#failIfNotData().
//                    ^^^^^ reference ujson/ByteParser#parseNested().(state)
//                           ^ reference ujson/ByteParser#parseNested().(i)
        try stackHead.narrow.visitValue(
//          ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                    ^^^^^^ reference upickle/core/ObjArrVisitor#narrow().
//                           ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
          parseTrue(i, stackHead.subVisitor.asInstanceOf[Visitor[_, J]]),
//        ^^^^^^^^^ reference ujson/ByteParser#parseTrue().
//                  ^ reference ujson/ByteParser#parseNested().(i)
//                     ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                               ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                          ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                                       ^^^^^^^ reference upickle/core/Visitor#
//                                                                  ^ reference ujson/ByteParser#[J]
          i
//        ^ reference ujson/ByteParser#parseNested().(i)
        )
        catch reject(i)
//            ^^^^^^ reference ujson/ByteParser#reject().
//                   ^ reference ujson/ByteParser#parseNested().(i)
        parseNested(collectionEndFor(stackHead), i + 4, stackHead, stackTail)
//      ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                  ^^^^^^^^^^^^^^^^ reference ujson/ByteParser#collectionEndFor().
//                                   ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                               ^ reference ujson/ByteParser#parseNested().(i)
//                                                 ^ reference scala/Int#`+`(+4).
//                                                      ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                                                 ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)

      case 'f' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference ujson/ByteParser#failIfNotData().
//                    ^^^^^ reference ujson/ByteParser#parseNested().(state)
//                           ^ reference ujson/ByteParser#parseNested().(i)
        try stackHead.narrow.visitValue(
//          ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                    ^^^^^^ reference upickle/core/ObjArrVisitor#narrow().
//                           ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
          parseFalse(i, stackHead.subVisitor.asInstanceOf[Visitor[_, J]]),
//        ^^^^^^^^^^ reference ujson/ByteParser#parseFalse().
//                   ^ reference ujson/ByteParser#parseNested().(i)
//                      ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                           ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                                        ^^^^^^^ reference upickle/core/Visitor#
//                                                                   ^ reference ujson/ByteParser#[J]
          i
//        ^ reference ujson/ByteParser#parseNested().(i)
        )
        catch reject(i)
//            ^^^^^^ reference ujson/ByteParser#reject().
//                   ^ reference ujson/ByteParser#parseNested().(i)
        parseNested(collectionEndFor(stackHead), i + 5, stackHead, stackTail)
//      ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                  ^^^^^^^^^^^^^^^^ reference ujson/ByteParser#collectionEndFor().
//                                   ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                               ^ reference ujson/ByteParser#parseNested().(i)
//                                                 ^ reference scala/Int#`+`(+4).
//                                                      ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                                                 ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)

      case 'n' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference ujson/ByteParser#failIfNotData().
//                    ^^^^^ reference ujson/ByteParser#parseNested().(state)
//                           ^ reference ujson/ByteParser#parseNested().(i)
        try stackHead.narrow.visitValue(
//          ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                    ^^^^^^ reference upickle/core/ObjArrVisitor#narrow().
//                           ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
          parseNull(i, stackHead.subVisitor.asInstanceOf[Visitor[_, J]]),
//        ^^^^^^^^^ reference ujson/ByteParser#parseNull().
//                  ^ reference ujson/ByteParser#parseNested().(i)
//                     ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                               ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                          ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                                       ^^^^^^^ reference upickle/core/Visitor#
//                                                                  ^ reference ujson/ByteParser#[J]
          i
//        ^ reference ujson/ByteParser#parseNested().(i)
        )
        catch reject(i)
//            ^^^^^^ reference ujson/ByteParser#reject().
//                   ^ reference ujson/ByteParser#parseNested().(i)
        parseNested(collectionEndFor(stackHead), i + 4, stackHead, stackTail)
//      ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                  ^^^^^^^^^^^^^^^^ reference ujson/ByteParser#collectionEndFor().
//                                   ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                               ^ reference ujson/ByteParser#parseNested().(i)
//                                                 ^ reference scala/Int#`+`(+4).
//                                                      ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                                                 ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)

      case ',' =>
        dropBufferUntil(i)
//      ^^^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#dropBufferUntil().
//                      ^ reference ujson/ByteParser#parseNested().(i)
        (state: @switch) match{
//       ^^^^^ reference ujson/ByteParser#parseNested().(state)
          case ARREND => parseNested(DATA, i + 1, stackHead, stackTail)
//             ^^^^^^ reference ujson/ByteParser#ARREND.
//                       ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                                   ^^^^ reference ujson/ByteParser#DATA.
//                                         ^ reference ujson/ByteParser#parseNested().(i)
//                                           ^ reference scala/Int#`+`(+4).
//                                                ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                                           ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)
          case OBJEND => parseNested(KEY, i + 1, stackHead, stackTail)
//             ^^^^^^ reference ujson/ByteParser#OBJEND.
//                       ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                                   ^^^ reference ujson/ByteParser#KEY.
//                                        ^ reference ujson/ByteParser#parseNested().(i)
//                                          ^ reference scala/Int#`+`(+4).
//                                               ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                                          ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)
          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#dieWithFailureMessage().
//                                        ^ reference ujson/ByteParser#parseNested().(i)
//                                           ^^^^^ reference ujson/ByteParser#parseNested().(state)
        }

      case ']' =>
        (state: @switch) match{
//       ^^^^^ reference ujson/ByteParser#parseNested().(state)
          case ARREND | ARRBEG =>
//             ^^^^^^ reference ujson/ByteParser#ARREND.
//                      ^^^^^^ reference ujson/ByteParser#ARRBEG.
            tryCloseCollection(stackHead, stackTail, i) match{
//          ^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#tryCloseCollection().
//                             ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                        ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)
//                                                   ^ reference ujson/ByteParser#parseNested().(i)
              case Some(t) => t
//                 ^^^^ reference scala/Some.
//                      ^ definition local77 t: (J, Int)
//                            ^ reference local77
              case None =>
//                 ^^^^ reference scala/None.
                val stackTailHead = stackTail.head
//                  ^^^^^^^^^^^^^ definition local78 stackTailHead: ObjArrVisitor[local51, J[
//                                  ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)
//                                            ^^^^ reference scala/collection/IterableOps#head().
                parseNested(collectionEndFor(stackTailHead), i + 1, stackTailHead, stackTail.tail)
//              ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                          ^^^^^^^^^^^^^^^^ reference ujson/ByteParser#collectionEndFor().
//                                           ^^^^^^^^^^^^^ reference local78
//                                                           ^ reference ujson/ByteParser#parseNested().(i)
//                                                             ^ reference scala/Int#`+`(+4).
//                                                                  ^^^^^^^^^^^^^ reference local78
//                                                                                 ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)
//                                                                                           ^^^^ reference scala/collection/IterableOps#tail().
            }
          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#dieWithFailureMessage().
//                                        ^ reference ujson/ByteParser#parseNested().(i)
//                                           ^^^^^ reference ujson/ByteParser#parseNested().(state)
        }

      case '}' =>
        (state: @switch) match{
//       ^^^^^ reference ujson/ByteParser#parseNested().(state)
          case OBJEND | OBJBEG =>
//             ^^^^^^ reference ujson/ByteParser#OBJEND.
//                      ^^^^^^ reference ujson/ByteParser#OBJBEG.
            tryCloseCollection(stackHead, stackTail, i) match{
//          ^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#tryCloseCollection().
//                             ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackHead)
//                                        ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)
//                                                   ^ reference ujson/ByteParser#parseNested().(i)
              case Some(t) => t
//                 ^^^^ reference scala/Some.
//                      ^ definition local79 t: (J, Int)
//                            ^ reference local79
              case None =>
//                 ^^^^ reference scala/None.
                val stackTailHead = stackTail.head
//                  ^^^^^^^^^^^^^ definition local80 stackTailHead: ObjArrVisitor[local51, J[
//                                  ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)
//                                            ^^^^ reference scala/collection/IterableOps#head().
                parseNested(collectionEndFor(stackTailHead), i + 1, stackTailHead, stackTail.tail)
//              ^^^^^^^^^^^ reference ujson/ByteParser#parseNested().
//                          ^^^^^^^^^^^^^^^^ reference ujson/ByteParser#collectionEndFor().
//                                           ^^^^^^^^^^^^^ reference local80
//                                                           ^ reference ujson/ByteParser#parseNested().(i)
//                                                             ^ reference scala/Int#`+`(+4).
//                                                                  ^^^^^^^^^^^^^ reference local80
//                                                                                 ^^^^^^^^^ reference ujson/ByteParser#parseNested().(stackTail)
//                                                                                           ^^^^ reference scala/collection/IterableOps#tail().
            }
          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#dieWithFailureMessage().
//                                        ^ reference ujson/ByteParser#parseNested().(i)
//                                           ^^^^^ reference ujson/ByteParser#parseNested().(state)
        }
      case _ => dieWithFailureMessage(i, state)
//              ^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#dieWithFailureMessage().
//                                    ^ reference ujson/ByteParser#parseNested().(i)
//                                       ^^^^^ reference ujson/ByteParser#parseNested().(state)

    }
  }


  def dieWithFailureMessage(i: Int, state: Int) = {
//    ^^^^^^^^^^^^^^^^^^^^^ definition ujson/ByteParser#dieWithFailureMessage(). def dieWithFailureMessage(i: Int, state: Int): Nothing
//                          ^ definition ujson/ByteParser#dieWithFailureMessage().(i) i: Int
//                             ^^^ reference scala/Int#
//                                  ^^^^^ definition ujson/ByteParser#dieWithFailureMessage().(state) state: Int
//                                         ^^^ reference scala/Int#
    val expected = state match{
//      ^^^^^^^^ definition local81 expected: String
//                 ^^^^^ reference ujson/ByteParser#dieWithFailureMessage().(state)
      case ARRBEG => "json value or ]"
//         ^^^^^^ reference ujson/ByteParser#ARRBEG.
      case OBJBEG => "json value or }"
//         ^^^^^^ reference ujson/ByteParser#OBJBEG.
      case DATA => "json value"
//         ^^^^ reference ujson/ByteParser#DATA.
      case KEY => "json string key"
//         ^^^ reference ujson/ByteParser#KEY.
      case COLON => ":"
//         ^^^^^ reference ujson/ByteParser#COLON.
      case ARREND => ", or ]"
//         ^^^^^^ reference ujson/ByteParser#ARREND.
      case OBJEND => ", or }"
//         ^^^^^^ reference ujson/ByteParser#OBJEND.
    }
    die(i, s"expected $expected")
//  ^^^ reference ujson/ByteParser#die().
//      ^ reference ujson/ByteParser#dieWithFailureMessage().(i)
//         ^ reference scala/StringContext#s().
//                     ^^^^^^^^ reference local81
  }

  def failIfNotData(state: Int, i: Int) = (state: @switch) match{
//    ^^^^^^^^^^^^^ definition ujson/ByteParser#failIfNotData(). def failIfNotData(state: Int, i: Int): Unit
//                  ^^^^^ definition ujson/ByteParser#failIfNotData().(state) state: Int
//                         ^^^ reference scala/Int#
//                              ^ definition ujson/ByteParser#failIfNotData().(i) i: Int
//                                 ^^^ reference scala/Int#
//                                         ^^^^^ reference ujson/ByteParser#failIfNotData().(state)
    case DATA | ARRBEG => // do nothing
//       ^^^^ reference ujson/ByteParser#DATA.
//              ^^^^^^ reference ujson/ByteParser#ARRBEG.
    case _ => dieWithFailureMessage(i, state)
//            ^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#dieWithFailureMessage().
//                                  ^ reference ujson/ByteParser#failIfNotData().(i)
//                                     ^^^^^ reference ujson/ByteParser#failIfNotData().(state)
  }

  def tryCloseCollection(stackHead: ObjArrVisitor[_, J], stackTail: List[ObjArrVisitor[_, J]], i: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition ujson/ByteParser#tryCloseCollection(). def tryCloseCollection(stackHead: ObjArrVisitor[local82, J[, stackTail: List[ObjArrVisitor[local83, J[], i: Int): Option[(J, Int)]
//                       ^^^^^^^^^ definition ujson/ByteParser#tryCloseCollection().(stackHead) stackHead: ObjArrVisitor[local82, J[
//                                  ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                   ^ reference ujson/ByteParser#[J]
//                                                       ^^^^^^^^^ definition ujson/ByteParser#tryCloseCollection().(stackTail) stackTail: List[ObjArrVisitor[local83, J[]
//                                                                  ^^^^ reference scala/package.List#
//                                                                       ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                                        ^ reference ujson/ByteParser#[J]
//                                                                                             ^ definition ujson/ByteParser#tryCloseCollection().(i) i: Int
//                                                                                                ^^^ reference scala/Int#
    if (stackTail.isEmpty) {
//      ^^^^^^^^^ reference ujson/ByteParser#tryCloseCollection().(stackTail)
//                ^^^^^^^ reference scala/collection/immutable/List#isEmpty().
      Some(try stackHead.visitEnd(i) catch reject(i), i + 1)
//    ^^^^ reference scala/Some.
//             ^^^^^^^^^ reference ujson/ByteParser#tryCloseCollection().(stackHead)
//                       ^^^^^^^^ reference upickle/core/ObjArrVisitor#visitEnd().
//                                ^ reference ujson/ByteParser#tryCloseCollection().(i)
//                                         ^^^^^^ reference ujson/ByteParser#reject().
//                                                ^ reference ujson/ByteParser#tryCloseCollection().(i)
//                                                    ^ reference ujson/ByteParser#tryCloseCollection().(i)
//                                                      ^ reference scala/Int#`+`(+4).
    } else {
      val ctxt2 = stackTail.head.narrow
//        ^^^^^ definition local86 ctxt2: ObjArrVisitor[Any, J]
//                ^^^^^^^^^ reference ujson/ByteParser#tryCloseCollection().(stackTail)
//                          ^^^^ reference scala/collection/IterableOps#head().
//                               ^^^^^^ reference upickle/core/ObjArrVisitor#narrow().
      try ctxt2.visitValue(stackHead.visitEnd(i), i) catch reject(i)
//        ^^^^^ reference local86
//              ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
//                         ^^^^^^^^^ reference ujson/ByteParser#tryCloseCollection().(stackHead)
//                                   ^^^^^^^^ reference upickle/core/ObjArrVisitor#visitEnd().
//                                            ^ reference ujson/ByteParser#tryCloseCollection().(i)
//                                                ^ reference ujson/ByteParser#tryCloseCollection().(i)
//                                                         ^^^^^^ reference ujson/ByteParser#reject().
//                                                                ^ reference ujson/ByteParser#tryCloseCollection().(i)
      None
//    ^^^^ reference scala/None.

    }
  }
  def collectionEndFor(stackHead: ObjArrVisitor[_, _]) = {
//    ^^^^^^^^^^^^^^^^ definition ujson/ByteParser#collectionEndFor(). def collectionEndFor(stackHead: ObjArrVisitor[local89, local90[): Int
//                     ^^^^^^^^^ definition ujson/ByteParser#collectionEndFor().(stackHead) stackHead: ObjArrVisitor[local89, local90[
//                                ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
    if (stackHead.isObj) OBJEND
//      ^^^^^^^^^ reference ujson/ByteParser#collectionEndFor().(stackHead)
//                ^^^^^ reference upickle/core/ObjArrVisitor#isObj().
//                       ^^^^^^ reference ujson/ByteParser#OBJEND.
    else ARREND
//       ^^^^^^ reference ujson/ByteParser#ARREND.
  }

  /**
    * See if the string has any escape sequences. If not, return the
    * end of the string. If so, bail out and return -1.
    *
    * This method expects the data to be in UTF-16 and accesses it as
    * chars.
    */
  protected[this] final def parseStringSimple(i: Int): Int = {
//                          ^^^^^^^^^^^^^^^^^ definition ujson/ByteParser#parseStringSimple(). final def parseStringSimple(i: Int): Int
//                                            ^ definition ujson/ByteParser#parseStringSimple().(i) i: Int
//                                               ^^^ reference scala/Int#
//                                                     ^^^ reference scala/Int#
    var j = i
//      ^ definition local91 j: Int
//          ^ reference ujson/ByteParser#parseStringSimple().(i)
    var c = elemOps.toUnsignedInt(getByteSafe(j))
//      ^ definition local92 c: Int
//          ^^^^^^^ reference ujson/ByteParser#elemOps.
//                  ^^^^^^^^^^^^^ reference upickle/core/ByteOps.toUnsignedInt().
//                                ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                                            ^ reference local91
    while (c != '"') {
//         ^ reference local92
//           ^^ reference scala/Int#`!=`(+2).
      if (c < ' ') die(j, s"control char (${c}) in string")
//        ^ reference local92
//          ^ reference scala/Int#`<`(+2).
//                 ^^^ reference ujson/ByteParser#die().
//                     ^ reference local91
//                        ^ reference scala/StringContext#s().
//                                          ^ reference local92
      if (c == '\\' || c > 127) return -1 - j
//        ^ reference local92
//          ^^ reference scala/Int#`==`(+2).
//                  ^^ reference scala/Boolean#`||`().
//                     ^ reference local92
//                       ^ reference scala/Int#`>`(+3).
//                                        ^ reference scala/Int#`-`(+3).
//                                          ^ reference local91
      j += 1
//    ^ reference local91
//      ^^ reference scala/Int#`+`(+4).
      c = elemOps.toUnsignedInt(getByteSafe(j))
//    ^ reference local92
//        ^^^^^^^ reference ujson/ByteParser#elemOps.
//                ^^^^^^^^^^^^^ reference upickle/core/ByteOps.toUnsignedInt().
//                              ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                                          ^ reference local91
    }
    j + 1
//  ^ reference local91
//    ^ reference scala/Int#`+`(+4).
  }

  /**
    * Parse a string that is known to have escape sequences.
    */
  protected[this] final def parseStringComplex(i0: Int): Int = {
//                          ^^^^^^^^^^^^^^^^^^ definition ujson/ByteParser#parseStringComplex(). final def parseStringComplex(i0: Int): Int
//                                             ^^ definition ujson/ByteParser#parseStringComplex().(i0) i0: Int
//                                                 ^^^ reference scala/Int#
//                                                       ^^^ reference scala/Int#
    var i = i0
//      ^ definition local94 i: Int
//          ^^ reference ujson/ByteParser#parseStringComplex().(i0)
    var c = elemOps.toUnsignedInt(getByteSafe(i))
//      ^ definition local95 c: Int
//          ^^^^^^^ reference ujson/ByteParser#elemOps.
//                  ^^^^^^^^^^^^^ reference upickle/core/ByteOps.toUnsignedInt().
//                                ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                                            ^ reference local94
    while (c != '"') {
//         ^ reference local95
//           ^^ reference scala/Int#`!=`(+2).

      if (c < ' ') die(i, s"control char (${c}) in string")
//        ^ reference local95
//          ^ reference scala/Int#`<`(+2).
//                 ^^^ reference ujson/ByteParser#die().
//                     ^ reference local94
//                        ^ reference scala/StringContext#s().
//                                          ^ reference local95
      else if (c == '\\') {
//             ^ reference local95
//               ^^ reference scala/Int#`==`(+2).
        (getByteSafe(i + 1): @switch) match {
//       ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                   ^ reference local94
//                     ^ reference scala/Int#`+`(+4).
          case 'b' => { outputBuilder.append('\b'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/ByteBuilder#append().
//                                                  ^ reference local94
//                                                    ^^ reference scala/Int#`+`(+4).
          case 'f' => { outputBuilder.append('\f'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/ByteBuilder#append().
//                                                  ^ reference local94
//                                                    ^^ reference scala/Int#`+`(+4).
          case 'n' => { outputBuilder.append('\n'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/ByteBuilder#append().
//                                                  ^ reference local94
//                                                    ^^ reference scala/Int#`+`(+4).
          case 'r' => { outputBuilder.append('\r'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/ByteBuilder#append().
//                                                  ^ reference local94
//                                                    ^^ reference scala/Int#`+`(+4).
          case 't' => { outputBuilder.append('\t'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/ByteBuilder#append().
//                                                  ^ reference local94
//                                                    ^^ reference scala/Int#`+`(+4).

          case '"' => { outputBuilder.append('"'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/ByteBuilder#append().
//                                                 ^ reference local94
//                                                   ^^ reference scala/Int#`+`(+4).
          case '/' => { outputBuilder.append('/'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/ByteBuilder#append().
//                                                 ^ reference local94
//                                                   ^^ reference scala/Int#`+`(+4).
          case '\\' => { outputBuilder.append('\\'); i += 2 }
//                       ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                                     ^^^^^^ reference upickle/core/ByteBuilder#append().
//                                                   ^ reference local94
//                                                     ^^ reference scala/Int#`+`(+4).

          // if there's a problem then descape will explode
          case 'u' =>
            val d = descape(i)
//              ^ definition local97 d: Char
//                  ^^^^^^^ reference ujson/ByteParser#descape().
//                          ^ reference local94
            outputBuilder.appendC(d)
//          ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                        ^^^^^^^ reference upickle/core/ByteAppendC#appendC().
//                                ^ reference local97

            i += 6
//          ^ reference local94
//            ^^ reference scala/Int#`+`(+4).

          case c => die(i + 1, s"illegal escape sequence after \\")
//             ^ definition local98 c: Byte
//                  ^^^ reference ujson/ByteParser#die().
//                      ^ reference local94
//                        ^ reference scala/Int#`+`(+4).
//                             ^ reference scala/StringContext#s().
        }
      } else {
        // this case is for "normal" code points that are just one Char.
        //
        // we don't have to worry about surrogate pairs, since those
        // will all be in the ranges D800–DBFF (high surrogates) or
        // DC00–DFFF (low surrogates).
        outputBuilder.append(c)
//      ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                    ^^^^^^ reference upickle/core/ByteBuilder#append().
//                           ^ reference local95
        i += 1
//      ^ reference local94
//        ^^ reference scala/Int#`+`(+4).
      }
      c = elemOps.toUnsignedInt(getByteSafe(i))
//    ^ reference local95
//        ^^^^^^^ reference ujson/ByteParser#elemOps.
//                ^^^^^^^^^^^^^ reference upickle/core/ByteOps.toUnsignedInt().
//                              ^^^^^^^^^^^ reference ujson/ByteParser#getByteSafe().
//                                          ^ reference local94
    }

    i + 1
//  ^ reference local94
//    ^ reference scala/Int#`+`(+4).
  }

  /**
    * Parse the string according to JSON rules, and add to the given
    * context.
    *
    * This method expects the data to be in UTF-16, and access it as
    * Char. It performs the correct checks to make sure that we don't
    * interpret a multi-char code point incorrectly.
    */
  protected[this] final def parseStringValue(i: Int, stackHead: ObjArrVisitor[_, J]): Int = {
//                          ^^^^^^^^^^^^^^^^ definition ujson/ByteParser#parseStringValue(). final def parseStringValue(i: Int, stackHead: ObjArrVisitor[local99, J[): Int
//                                           ^ definition ujson/ByteParser#parseStringValue().(i) i: Int
//                                              ^^^ reference scala/Int#
//                                                   ^^^^^^^^^ definition ujson/ByteParser#parseStringValue().(stackHead) stackHead: ObjArrVisitor[local99, J[
//                                                              ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                               ^ reference ujson/ByteParser#[J]
//                                                                                    ^^^ reference scala/Int#

    val k = parseStringSimple(i + 1)
//      ^ definition local100 k: Int
//          ^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#parseStringSimple().
//                            ^ reference ujson/ByteParser#parseStringValue().(i)
//                              ^ reference scala/Int#`+`(+4).
    if (k >= 0) {
//      ^ reference local100
//        ^^ reference scala/Int#`>=`(+3).
      visitString(i, unsafeCharSeqForRange(i + 1, k - i - 2), stackHead)
//    ^^^^^^^^^^^ reference ujson/ByteParser#visitString().
//                ^ reference ujson/ByteParser#parseStringValue().(i)
//                   ^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#unsafeCharSeqForRange().
//                                         ^ reference ujson/ByteParser#parseStringValue().(i)
//                                           ^ reference scala/Int#`+`(+4).
//                                                ^ reference local100
//                                                  ^ reference scala/Int#`-`(+3).
//                                                    ^ reference ujson/ByteParser#parseStringValue().(i)
//                                                      ^ reference scala/Int#`-`(+3).
//                                                            ^^^^^^^^^ reference ujson/ByteParser#parseStringValue().(stackHead)
      k
//    ^ reference local100
    } else {
      val k2 = parseStringToOutputBuilder(i, k)
//        ^^ definition local101 k2: Int
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#parseStringToOutputBuilder().
//                                        ^ reference ujson/ByteParser#parseStringValue().(i)
//                                           ^ reference local100
      visitString(i, outputBuilder.makeString(), stackHead)
//    ^^^^^^^^^^^ reference ujson/ByteParser#visitString().
//                ^ reference ujson/ByteParser#parseStringValue().(i)
//                   ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                                 ^^^^^^^^^^ reference upickle/core/ByteBuilder#makeString().
//                                               ^^^^^^^^^ reference ujson/ByteParser#parseStringValue().(stackHead)
      k2
//    ^^ reference local101
    }
  }

  protected[this] final def parseStringKey(i: Int, stackHead: ObjArrVisitor[_, J]): Int = {
//                          ^^^^^^^^^^^^^^ definition ujson/ByteParser#parseStringKey(). final def parseStringKey(i: Int, stackHead: ObjArrVisitor[local102, J[): Int
//                                         ^ definition ujson/ByteParser#parseStringKey().(i) i: Int
//                                            ^^^ reference scala/Int#
//                                                 ^^^^^^^^^ definition ujson/ByteParser#parseStringKey().(stackHead) stackHead: ObjArrVisitor[local102, J[
//                                                            ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                             ^ reference ujson/ByteParser#[J]
//                                                                                  ^^^ reference scala/Int#

    val k = parseStringSimple(i + 1)
//      ^ definition local103 k: Int
//          ^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#parseStringSimple().
//                            ^ reference ujson/ByteParser#parseStringKey().(i)
//                              ^ reference scala/Int#`+`(+4).
    if (k >= 0) {
//      ^ reference local103
//        ^^ reference scala/Int#`>=`(+3).
      visitStringKey(i, unsafeCharSeqForRange(i + 1, k - i - 2), stackHead)
//    ^^^^^^^^^^^^^^ reference ujson/ByteParser#visitStringKey().
//                   ^ reference ujson/ByteParser#parseStringKey().(i)
//                      ^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#unsafeCharSeqForRange().
//                                            ^ reference ujson/ByteParser#parseStringKey().(i)
//                                              ^ reference scala/Int#`+`(+4).
//                                                   ^ reference local103
//                                                     ^ reference scala/Int#`-`(+3).
//                                                       ^ reference ujson/ByteParser#parseStringKey().(i)
//                                                         ^ reference scala/Int#`-`(+3).
//                                                               ^^^^^^^^^ reference ujson/ByteParser#parseStringKey().(stackHead)
      k
//    ^ reference local103
    } else {
      val k2 = parseStringToOutputBuilder(i, k)
//        ^^ definition local104 k2: Int
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#parseStringToOutputBuilder().
//                                        ^ reference ujson/ByteParser#parseStringKey().(i)
//                                           ^ reference local103
      visitStringKey(i, outputBuilder.makeString(), stackHead)
//    ^^^^^^^^^^^^^^ reference ujson/ByteParser#visitStringKey().
//                   ^ reference ujson/ByteParser#parseStringKey().(i)
//                      ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                                    ^^^^^^^^^^ reference upickle/core/ByteBuilder#makeString().
//                                                  ^^^^^^^^^ reference ujson/ByteParser#parseStringKey().(stackHead)
      k2
//    ^^ reference local104
    }
  }


  def parseStringToOutputBuilder(i: Int, k: Int) = {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/ByteParser#parseStringToOutputBuilder(). def parseStringToOutputBuilder(i: Int, k: Int): Int
//                               ^ definition ujson/ByteParser#parseStringToOutputBuilder().(i) i: Int
//                                  ^^^ reference scala/Int#
//                                       ^ definition ujson/ByteParser#parseStringToOutputBuilder().(k) k: Int
//                                          ^^^ reference scala/Int#
    outputBuilder.reset()
//  ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                ^^^^^ reference upickle/core/ByteBuilder#reset().
    appendBytesToBuilder(outputBuilder, i + 1, -k - 2 - i)
//  ^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#appendBytesToBuilder().
//                       ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                                      ^ reference ujson/ByteParser#parseStringToOutputBuilder().(i)
//                                        ^ reference scala/Int#`+`(+4).
//                                             ^ reference scala/Int#`unary_-`().
//                                              ^ reference ujson/ByteParser#parseStringToOutputBuilder().(k)
//                                                ^ reference scala/Int#`-`(+3).
//                                                    ^ reference scala/Int#`-`(+3).
//                                                      ^ reference ujson/ByteParser#parseStringToOutputBuilder().(i)
    val k2 = parseStringComplex(-k - 1)
//      ^^ definition local105 k2: Int
//           ^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#parseStringComplex().
//                              ^ reference scala/Int#`unary_-`().
//                               ^ reference ujson/ByteParser#parseStringToOutputBuilder().(k)
//                                 ^ reference scala/Int#`-`(+3).
    k2
//  ^^ reference local105
  }

  def visitString(i: Int, s: CharSequence, stackHead: ObjArrVisitor[_, J]) = {
//    ^^^^^^^^^^^ definition ujson/ByteParser#visitString(). def visitString(i: Int, s: CharSequence, stackHead: ObjArrVisitor[local106, J[): Unit
//                ^ definition ujson/ByteParser#visitString().(i) i: Int
//                   ^^^ reference scala/Int#
//                        ^ definition ujson/ByteParser#visitString().(s) s: CharSequence
//                           ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                         ^^^^^^^^^ definition ujson/ByteParser#visitString().(stackHead) stackHead: ObjArrVisitor[local106, J[
//                                                    ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                     ^ reference ujson/ByteParser#[J]
    val v = stackHead.subVisitor.visitString(s, i)
//      ^ definition local107 v: Any
//          ^^^^^^^^^ reference ujson/ByteParser#visitString().(stackHead)
//                    ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                               ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                           ^ reference ujson/ByteParser#visitString().(s)
//                                              ^ reference ujson/ByteParser#visitString().(i)
    stackHead.narrow.visitValue(v, i)
//  ^^^^^^^^^ reference ujson/ByteParser#visitString().(stackHead)
//            ^^^^^^ reference upickle/core/ObjArrVisitor#narrow().
//                   ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
//                              ^ reference local107
//                                 ^ reference ujson/ByteParser#visitString().(i)
  }
  def visitStringKey(i: Int, s: CharSequence, stackHead: ObjArrVisitor[_, J]) = {
//    ^^^^^^^^^^^^^^ definition ujson/ByteParser#visitStringKey(). def visitStringKey(i: Int, s: CharSequence, stackHead: ObjArrVisitor[local108, J[): Unit
//                   ^ definition ujson/ByteParser#visitStringKey().(i) i: Int
//                      ^^^ reference scala/Int#
//                           ^ definition ujson/ByteParser#visitStringKey().(s) s: CharSequence
//                              ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                            ^^^^^^^^^ definition ujson/ByteParser#visitStringKey().(stackHead) stackHead: ObjArrVisitor[local108, J[
//                                                       ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                        ^ reference ujson/ByteParser#[J]
    val obj = stackHead.asInstanceOf[ObjVisitor[Any, _]]
//      ^^^ definition local109 obj: ObjVisitor[Any, Any]
//            ^^^^^^^^^ reference ujson/ByteParser#visitStringKey().(stackHead)
//                      ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                   ^^^^^^^^^^ reference upickle/core/ObjVisitor#
//                                              ^^^ reference scala/Any#
    val keyVisitor = obj.visitKey(i)
//      ^^^^^^^^^^ definition local110 keyVisitor: Visitor[local111, Any[
//                   ^^^ reference local109
//                       ^^^^^^^^ reference upickle/core/ObjVisitor#visitKey().
//                                ^ reference ujson/ByteParser#visitStringKey().(i)
    obj.visitKeyValue(keyVisitor.visitString(s, i))
//  ^^^ reference local109
//      ^^^^^^^^^^^^^ reference upickle/core/ObjVisitor#visitKeyValue().
//                    ^^^^^^^^^^ reference local110
//                               ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                           ^ reference ujson/ByteParser#visitStringKey().(s)
//                                              ^ reference ujson/ByteParser#visitStringKey().(i)
  }


  protected[this] final def parseStringTopLevel(i: Int, facade: Visitor[_, J]): (J, Int) = {
//                          ^^^^^^^^^^^^^^^^^^^ definition ujson/ByteParser#parseStringTopLevel(). final def parseStringTopLevel(i: Int, facade: Visitor[local112, J[): (J, Int)
//                                              ^ definition ujson/ByteParser#parseStringTopLevel().(i) i: Int
//                                                 ^^^ reference scala/Int#
//                                                      ^^^^^^ definition ujson/ByteParser#parseStringTopLevel().(facade) facade: Visitor[local112, J[
//                                                              ^^^^^^^ reference upickle/core/Visitor#
//                                                                         ^ reference ujson/ByteParser#[J]
//                                                                               ^ reference ujson/ByteParser#[J]
//                                                                                  ^^^ reference scala/Int#

    val k = parseStringSimple(i + 1)
//      ^ definition local113 k: Int
//          ^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#parseStringSimple().
//                            ^ reference ujson/ByteParser#parseStringTopLevel().(i)
//                              ^ reference scala/Int#`+`(+4).
    if (k >= 0) {
//      ^ reference local113
//        ^^ reference scala/Int#`>=`(+3).
      val res = facade.visitString(unsafeCharSeqForRange(i + 1, k - i - 2), i)
//        ^^^ definition local114 res: J
//              ^^^^^^ reference ujson/ByteParser#parseStringTopLevel().(facade)
//                     ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                 ^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingByteParser#unsafeCharSeqForRange().
//                                                       ^ reference ujson/ByteParser#parseStringTopLevel().(i)
//                                                         ^ reference scala/Int#`+`(+4).
//                                                              ^ reference local113
//                                                                ^ reference scala/Int#`-`(+3).
//                                                                  ^ reference ujson/ByteParser#parseStringTopLevel().(i)
//                                                                    ^ reference scala/Int#`-`(+3).
//                                                                          ^ reference ujson/ByteParser#parseStringTopLevel().(i)
      (res, k)
//     ^^^ reference local114
//          ^ reference local113
    } else {
      val k2 = parseStringToOutputBuilder(i, k)
//        ^^ definition local115 k2: Int
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/ByteParser#parseStringToOutputBuilder().
//                                        ^ reference ujson/ByteParser#parseStringTopLevel().(i)
//                                           ^ reference local113
      val res = facade.visitString(outputBuilder.makeString(), i)
//        ^^^ definition local116 res: J
//              ^^^^^^ reference ujson/ByteParser#parseStringTopLevel().(facade)
//                     ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                 ^^^^^^^^^^^^^ reference ujson/ByteParser#outputBuilder.
//                                               ^^^^^^^^^^ reference upickle/core/ByteBuilder#makeString().
//                                                             ^ reference ujson/ByteParser#parseStringTopLevel().(i)
      (res, k2)
//     ^^^ reference local116
//          ^^ reference local115
    }
  }
}
