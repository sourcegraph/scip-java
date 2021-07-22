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
  * A specialized JSON parse that can parse Chars (Chars or Bytes), sending
  * method calls to the given [[upickle.core.Visitor]].
  *
  * Generally has a lot of tricks for performance: e.g. having duplicate
  * implementations for nested v.s. top-level parsing, using an `CharBuilder`
  * to construct the `CharSequences` that `visitString` requires, etc.
  */
abstract class CharParser[J] extends upickle.core.BufferingCharParser{
//             ^^^^^^^^^^ definition ujson/CharParser#
//                        ^ definition ujson/CharParser#[J]
//                            definition ujson/CharParser#`<init>`().
//                                   ^^^^^^^ reference upickle/
//                                           ^^^^ reference upickle/core/
//                                                ^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#
  private[this] val elemOps = upickle.core.CharOps
//                  ^^^^^^^ definition ujson/CharParser#elemOps.
//                            ^^^^^^^ reference upickle/
//                                    ^^^^ reference upickle/core/
//                                         ^^^^^^^ reference upickle/core/CharOps.
  private[this] val outputBuilder = new upickle.core.CharBuilder()
//                  ^^^^^^^^^^^^^ definition ujson/CharParser#outputBuilder.
//                                      ^^^^^^^ reference upickle/
//                                              ^^^^ reference upickle/core/
//                                                   ^^^^^^^^^^^ reference upickle/core/CharBuilder#
//                                                               reference upickle/core/CharBuilder#`<init>`().

  def requestUntilOrThrow(i: Int) = {
//    ^^^^^^^^^^^^^^^^^^^ definition ujson/CharParser#requestUntilOrThrow().
//                        ^ definition ujson/CharParser#requestUntilOrThrow().(i)
//                           ^^^ reference scala/Int#
    if (requestUntil(i)) throw new IncompleteParseException("exhausted input")
//      ^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#requestUntil().
//                   ^ reference ujson/CharParser#requestUntilOrThrow().(i)
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/IncompleteParseException#
//                                                          reference ujson/IncompleteParseException#`<init>`().
  }
  override def getCharSafe(i: Int): Char = {
//             ^^^^^^^^^^^ definition ujson/CharParser#getCharSafe().
//                         ^ definition ujson/CharParser#getCharSafe().(i)
//                            ^^^ reference scala/Int#
//                                  ^^^^ reference scala/Char#
    requestUntilOrThrow(i)
//  ^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#requestUntilOrThrow().
//                      ^ reference ujson/CharParser#getCharSafe().(i)
    getCharUnsafe(i)
//  ^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#getCharUnsafe().
//                ^ reference ujson/CharParser#getCharSafe().(i)
  }

  /**
   * Return true iff 'i' is at or beyond the end of the input (EOF).
   */
  protected[this] def atEof(i: Int) = requestUntil(i)
//                    ^^^^^ definition ujson/CharParser#atEof().
//                          ^ definition ujson/CharParser#atEof().(i)
//                             ^^^ reference scala/Int#
//                                    ^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#requestUntil().
//                                                 ^ reference ujson/CharParser#atEof().(i)

  /**
   * Should be called when parsing is finished.
   */
  protected[this] def close(): Unit
//                    ^^^^^ definition ujson/CharParser#close().
//                             ^^^^ reference scala/Unit#

  /**
   * Valid parser states.
   */
  @inline private[this] final val ARRBEG = 6
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^^^^ definition ujson/CharParser#ARRBEG.
  @inline private[this] final val OBJBEG = 7
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^^^^ definition ujson/CharParser#OBJBEG.
  @inline private[this] final val DATA = 1
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^^ definition ujson/CharParser#DATA.
  @inline private[this] final val KEY = 2
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^ definition ujson/CharParser#KEY.
  @inline private[this] final val COLON = 3
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^^^ definition ujson/CharParser#COLON.
  @inline private[this] final val ARREND = 4
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^^^^ definition ujson/CharParser#ARREND.
  @inline private[this] final val OBJEND = 5
// ^^^^^^ reference scala/inline#
//         reference scala/inline#`<init>`().
//                                ^^^^^^ definition ujson/CharParser#OBJEND.

  /**
    * Parse the JSON document into a single JSON value.
    *
    * The parser considers documents like '333', 'true', and '"foo"' to be
    * valid, as well as more traditional documents like [1,2,3,4,5]. However,
    * multiple top-level objects are not allowed.
    */
  final def parse(facade: Visitor[_, J]): J = {
//          ^^^^^ definition ujson/CharParser#parse().
//                ^^^^^^ definition ujson/CharParser#parse().(facade)
//                        ^^^^^^^ reference upickle/core/Visitor#
//                                   ^ reference ujson/CharParser#[J]
//                                        ^ reference ujson/CharParser#[J]
    val (value, i) = parseTopLevel(0, facade)
//       ^^^^^ definition local0
//              ^ definition local1
//                   ^^^^^^^^^^^^^ reference ujson/CharParser#parseTopLevel().
//                                    ^^^^^^ reference ujson/CharParser#parse().(facade)
    var j = i
//      ^ definition local3
//          ^ reference local1
    while (!atEof(j)) {
//         ^ reference scala/Boolean#`unary_!`().
//          ^^^^^ reference ujson/CharParser#atEof().
//                ^ reference local3
      (getCharSafe(j): @switch) match {
//     ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                 ^ reference local3
        case '\n' | ' ' | '\t' | '\r' => j += 1
//                                       ^ reference local3
//                                         ^^ reference scala/Int#`+`(+4).
        case _ => die(j, "expected whitespace or eof")
//                ^^^ reference ujson/CharParser#die().
//                    ^ reference local3
      }
    }
    if (!atEof(j)) die(j, "expected eof")
//      ^ reference scala/Boolean#`unary_!`().
//       ^^^^^ reference ujson/CharParser#atEof().
//             ^ reference local3
//                 ^^^ reference ujson/CharParser#die().
//                     ^ reference local3
    close()
//  ^^^^^ reference ujson/CharParser#close().
    value
//  ^^^^^ reference local0
  }

  /**
   * Used to generate error messages with character info and offsets.
   */
  protected[this] def die(i: Int, msg: String): Nothing = {
//                    ^^^ definition ujson/CharParser#die().
//                        ^ definition ujson/CharParser#die().(i)
//                           ^^^ reference scala/Int#
//                                ^^^ definition ujson/CharParser#die().(msg)
//                                     ^^^^^^ reference scala/Predef.String#
//                                              ^^^^^^^ reference scala/Nothing#
    val out = new upickle.core.CharBuilder()
//      ^^^ definition local4
//                ^^^^^^^ reference upickle/
//                        ^^^^ reference upickle/core/
//                             ^^^^^^^^^^^ reference upickle/core/CharBuilder#
//                                         reference upickle/core/CharBuilder#`<init>`().
    upickle.core.RenderUtils.escapeChar(
//  ^^^^^^^ reference upickle/
//          ^^^^ reference upickle/core/
//               ^^^^^^^^^^^ reference upickle/core/RenderUtils.
//                           ^^^^^^^^^^ reference upickle/core/RenderUtils.escapeChar().
      new upickle.core.CharBuilder(),
//        ^^^^^^^ reference upickle/
//                ^^^^ reference upickle/core/
//                     ^^^^^^^^^^^ reference upickle/core/CharBuilder#
//                                 reference upickle/core/CharBuilder#`<init>`().
      out,
//    ^^^ reference local4
      new ArrayCharSequence(Array(elemOps.toInt(getCharSafe(i)).toChar)),
//        ^^^^^^^^^^^^^^^^^ reference scala/Predef.ArrayCharSequence#
//                          reference scala/Predef.ArrayCharSequence#`<init>`().
//                          ^^^^^ reference scala/Array.
//                                ^^^^^^^ reference ujson/CharParser#elemOps.
//                                        ^^^^^ reference upickle/core/CharOps.toInt().
//                                              ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                                                          ^ reference ujson/CharParser#die().(i)
//                                                              ^^^^^^ reference scala/Int#toChar().
      unicode = false
//    ^^^^^^^ reference upickle/core/RenderUtils.escapeChar().(unicode)
    )
    val s = "%s got %s" format (msg, out.makeString())
//      ^ definition local5
//                      ^^^^^^ reference scala/collection/StringOps#format().
//                              ^^^ reference ujson/CharParser#die().(msg)
//                                   ^^^ reference local4
//                                       ^^^^^^^^^^ reference upickle/core/CharBuilder#makeString().
    throw ParseException(s, i)
//        ^^^^^^^^^^^^^^ reference ujson/ParseException.
//                       ^ reference local5
//                          ^ reference ujson/CharParser#die().(i)
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
//                          ^^^^^^^^ definition ujson/CharParser#parseNum().
//                                   ^ definition ujson/CharParser#parseNum().(i)
//                                      ^^^ reference scala/Int#
//                                           ^^^^ definition ujson/CharParser#parseNum().(ctxt)
//                                                 ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                               ^^^ reference scala/Any#
//                                                                    ^ reference ujson/CharParser#[J]
//                                                                        ^^^^^^ definition ujson/CharParser#parseNum().(facade)
//                                                                                ^^^^^^^ reference upickle/core/Visitor#
//                                                                                           ^ reference ujson/CharParser#[J]
//                                                                                                ^^^ reference scala/Int#
    var j = i
//      ^ definition local6
//          ^ reference ujson/CharParser#parseNum().(i)
    var c = getCharSafe(j)
//      ^ definition local7
//          ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                      ^ reference local6
    var decIndex = -1
//      ^^^^^^^^ definition local8
    var expIndex = -1
//      ^^^^^^^^ definition local9

    if (c == '-') {
//      ^ reference local7
//        ^^ reference scala/Char#`==`(+2).
      j += 1
//    ^ reference local6
//      ^^ reference scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local7
//        ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                    ^ reference local6
    }
    if (c == '0') {
//      ^ reference local7
//        ^^ reference scala/Char#`==`(+2).
      j += 1
//    ^ reference local6
//      ^^ reference scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local7
//        ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                    ^ reference local6
    } else {
      val j0 = j
//        ^^ definition local10
//             ^ reference local6
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference ujson/CharParser#elemOps.
//                   ^^^^^^ reference upickle/core/CharOps.within().
//                               ^ reference local7
        j += 1;
//      ^ reference local6
//        ^^ reference scala/Int#`+`(+4).
        c = getCharSafe(j)
//      ^ reference local7
//          ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                      ^ reference local6
      }
      if (j == j0) die(i, "expected digit")
//        ^ reference local6
//          ^^ reference scala/Int#`==`(+3).
//             ^^ reference local10
//                 ^^^ reference ujson/CharParser#die().
//                     ^ reference ujson/CharParser#parseNum().(i)
    }

    if (c == '.') {
//      ^ reference local7
//        ^^ reference scala/Char#`==`(+2).
      decIndex = j - i
//    ^^^^^^^^ reference local8
//               ^ reference local6
//                 ^ reference scala/Int#`-`(+3).
//                   ^ reference ujson/CharParser#parseNum().(i)
      j += 1
//    ^ reference local6
//      ^^ reference scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local7
//        ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                    ^ reference local6
      val j0 = j
//        ^^ definition local11
//             ^ reference local6
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference ujson/CharParser#elemOps.
//                   ^^^^^^ reference upickle/core/CharOps.within().
//                               ^ reference local7
        j += 1
//      ^ reference local6
//        ^^ reference scala/Int#`+`(+4).
        c = getCharSafe(j)
//      ^ reference local7
//          ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                      ^ reference local6
      }
      if (j0 == j) die(i, "expected digit")
//        ^^ reference local11
//           ^^ reference scala/Int#`==`(+3).
//              ^ reference local6
//                 ^^^ reference ujson/CharParser#die().
//                     ^ reference ujson/CharParser#parseNum().(i)
    }

    if (c == 'e' || c == 'E') {
//      ^ reference local7
//        ^^ reference scala/Char#`==`(+2).
//               ^^ reference scala/Boolean#`||`().
//                  ^ reference local7
//                    ^^ reference scala/Char#`==`(+2).
      expIndex = j - i
//    ^^^^^^^^ reference local9
//               ^ reference local6
//                 ^ reference scala/Int#`-`(+3).
//                   ^ reference ujson/CharParser#parseNum().(i)
      j += 1
//    ^ reference local6
//      ^^ reference scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local7
//        ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                    ^ reference local6
      if (c == '+' || c == '-') {
//        ^ reference local7
//          ^^ reference scala/Char#`==`(+2).
//                 ^^ reference scala/Boolean#`||`().
//                    ^ reference local7
//                      ^^ reference scala/Char#`==`(+2).
        j += 1
//      ^ reference local6
//        ^^ reference scala/Int#`+`(+4).
        c = getCharSafe(j)
//      ^ reference local7
//          ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                      ^ reference local6
      }
      val j0 = j
//        ^^ definition local12
//             ^ reference local6
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference ujson/CharParser#elemOps.
//                   ^^^^^^ reference upickle/core/CharOps.within().
//                               ^ reference local7
        j += 1
//      ^ reference local6
//        ^^ reference scala/Int#`+`(+4).
        c = getCharSafe(j)
//      ^ reference local7
//          ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                      ^ reference local6
      }
      if (j0 == j)  die(i, "expected digit")
//        ^^ reference local12
//           ^^ reference scala/Int#`==`(+3).
//              ^ reference local6
//                  ^^^ reference ujson/CharParser#die().
//                      ^ reference ujson/CharParser#parseNum().(i)
    }

    ctxt.visitValue(visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), i)
//  ^^^^ reference ujson/CharParser#parseNum().(ctxt)
//       ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                                     ^^^^^^ reference ujson/CharParser#parseNum().(facade)
//                                                             ^^^^^^^^ reference local8
//                                                                       ^^^^^^^^ reference local9
//                                                                                 ^ reference ujson/CharParser#parseNum().(i)
//                                                                                    ^ reference local6
//                                                                                        ^ reference ujson/CharParser#parseNum().(i)
    j
//  ^ reference local6
  }

  def visitFloat64StringPartsWithWrapper(facade: Visitor[_, J],
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                       ^^^^^^ definition ujson/CharParser#visitFloat64StringPartsWithWrapper().(facade)
//                                               ^^^^^^^ reference upickle/core/Visitor#
//                                                          ^ reference ujson/CharParser#[J]
                                         decIndex: Int,
//                                       ^^^^^^^^ definition ujson/CharParser#visitFloat64StringPartsWithWrapper().(decIndex)
//                                                 ^^^ reference scala/Int#
                                         expIndex: Int,
//                                       ^^^^^^^^ definition ujson/CharParser#visitFloat64StringPartsWithWrapper().(expIndex)
//                                                 ^^^ reference scala/Int#
                                         i: Int,
//                                       ^ definition ujson/CharParser#visitFloat64StringPartsWithWrapper().(i)
//                                          ^^^ reference scala/Int#
                                         j: Int) = {
//                                       ^ definition ujson/CharParser#visitFloat64StringPartsWithWrapper().(j)
//                                          ^^^ reference scala/Int#
    facade.visitFloat64StringParts(
//  ^^^^^^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().(facade)
//         ^^^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/Visitor#visitFloat64StringParts().
      unsafeCharSeqForRange(i, j - i),
//    ^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#unsafeCharSeqForRange().
//                          ^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().(i)
//                             ^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().(j)
//                               ^ reference scala/Int#`-`(+3).
//                                 ^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().(i)
      decIndex,
//    ^^^^^^^^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().(decIndex)
      expIndex,
//    ^^^^^^^^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().(expIndex)
      i
//    ^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().(i)
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
//                          ^^^^^^^^^^^^^^^^ definition ujson/CharParser#parseNumTopLevel().
//                                           ^ definition ujson/CharParser#parseNumTopLevel().(i)
//                                              ^^^ reference scala/Int#
//                                                   ^^^^^^ definition ujson/CharParser#parseNumTopLevel().(facade)
//                                                           ^^^^^^^ reference upickle/core/Visitor#
//                                                                      ^ reference ujson/CharParser#[J]
//                                                                            ^ reference ujson/CharParser#[J]
//                                                                               ^^^ reference scala/Int#
    var j = i
//      ^ definition local13
//          ^ reference ujson/CharParser#parseNumTopLevel().(i)
    var c = getCharSafe(j)
//      ^ definition local14
//          ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                      ^ reference local13
    var decIndex = -1
//      ^^^^^^^^ definition local15
    var expIndex = -1
//      ^^^^^^^^ definition local16

    if (c == '-') {
//      ^ reference local14
//        ^^ reference scala/Char#`==`(+2).
      // any valid input will require at least one digit after -
      j += 1
//    ^ reference local13
//      ^^ reference scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local14
//        ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                    ^ reference local13
    }
    if (c == '0') {
//      ^ reference local14
//        ^^ reference scala/Char#`==`(+2).
      j += 1
//    ^ reference local13
//      ^^ reference scala/Int#`+`(+4).
      if (atEof(j)) {
//        ^^^^^ reference ujson/CharParser#atEof().
//              ^ reference local13
        return (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                                 ^^^^^^ reference ujson/CharParser#parseNumTopLevel().(facade)
//                                                         ^^^^^^^^ reference local15
//                                                                   ^^^^^^^^ reference local16
//                                                                             ^ reference ujson/CharParser#parseNumTopLevel().(i)
//                                                                                ^ reference local13
//                                                                                    ^ reference local13
      }
      c = getCharSafe(j)
//    ^ reference local14
//        ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                    ^ reference local13
    } else {
      val j0 = j
//        ^^ definition local17
//             ^ reference local13
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference ujson/CharParser#elemOps.
//                   ^^^^^^ reference upickle/core/CharOps.within().
//                               ^ reference local14
        j += 1
//      ^ reference local13
//        ^^ reference scala/Int#`+`(+4).
        if (atEof(j)) {
//          ^^^^^ reference ujson/CharParser#atEof().
//                ^ reference local13
          return (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                                   ^^^^^^ reference ujson/CharParser#parseNumTopLevel().(facade)
//                                                           ^^^^^^^^ reference local15
//                                                                     ^^^^^^^^ reference local16
//                                                                               ^ reference ujson/CharParser#parseNumTopLevel().(i)
//                                                                                  ^ reference local13
//                                                                                      ^ reference local13
        }
        c = getCharSafe(j)
//      ^ reference local14
//          ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                      ^ reference local13
      }
      if (j0 == j) die(i, "expected digit")
//        ^^ reference local17
//           ^^ reference scala/Int#`==`(+3).
//              ^ reference local13
//                 ^^^ reference ujson/CharParser#die().
//                     ^ reference ujson/CharParser#parseNumTopLevel().(i)
    }

    if (c == '.') {
//      ^ reference local14
//        ^^ reference scala/Char#`==`(+2).
      // any valid input will require at least one digit after .
      decIndex = j - i
//    ^^^^^^^^ reference local15
//               ^ reference local13
//                 ^ reference scala/Int#`-`(+3).
//                   ^ reference ujson/CharParser#parseNumTopLevel().(i)
      j += 1
//    ^ reference local13
//      ^^ reference scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local14
//        ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                    ^ reference local13
      val j0 = j
//        ^^ definition local18
//             ^ reference local13
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference ujson/CharParser#elemOps.
//                   ^^^^^^ reference upickle/core/CharOps.within().
//                               ^ reference local14
        j += 1
//      ^ reference local13
//        ^^ reference scala/Int#`+`(+4).
        if (atEof(j)) {
//          ^^^^^ reference ujson/CharParser#atEof().
//                ^ reference local13
          return (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                                   ^^^^^^ reference ujson/CharParser#parseNumTopLevel().(facade)
//                                                           ^^^^^^^^ reference local15
//                                                                     ^^^^^^^^ reference local16
//                                                                               ^ reference ujson/CharParser#parseNumTopLevel().(i)
//                                                                                  ^ reference local13
//                                                                                      ^ reference local13
        }
        c = getCharSafe(j)
//      ^ reference local14
//          ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                      ^ reference local13
      }
      if(j0 == j) die(i, "expected digit")
//       ^^ reference local18
//          ^^ reference scala/Int#`==`(+3).
//             ^ reference local13
//                ^^^ reference ujson/CharParser#die().
//                    ^ reference ujson/CharParser#parseNumTopLevel().(i)
    }

    if (c == 'e' || c == 'E') {
//      ^ reference local14
//        ^^ reference scala/Char#`==`(+2).
//               ^^ reference scala/Boolean#`||`().
//                  ^ reference local14
//                    ^^ reference scala/Char#`==`(+2).
      // any valid input will require at least one digit after e, e+, etc
      expIndex = j - i
//    ^^^^^^^^ reference local16
//               ^ reference local13
//                 ^ reference scala/Int#`-`(+3).
//                   ^ reference ujson/CharParser#parseNumTopLevel().(i)
      j += 1
//    ^ reference local13
//      ^^ reference scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local14
//        ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                    ^ reference local13
      if (c == '+' || c == '-') {
//        ^ reference local14
//          ^^ reference scala/Char#`==`(+2).
//                 ^^ reference scala/Boolean#`||`().
//                    ^ reference local14
//                      ^^ reference scala/Char#`==`(+2).
        j += 1
//      ^ reference local13
//        ^^ reference scala/Int#`+`(+4).
        c = getCharSafe(j)
//      ^ reference local14
//          ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                      ^ reference local13
      }
      val j0 = j
//        ^^ definition local19
//             ^ reference local13
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference ujson/CharParser#elemOps.
//                   ^^^^^^ reference upickle/core/CharOps.within().
//                               ^ reference local14
        j += 1
//      ^ reference local13
//        ^^ reference scala/Int#`+`(+4).
        if (atEof(j)) {
//          ^^^^^ reference ujson/CharParser#atEof().
//                ^ reference local13
          return (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                                   ^^^^^^ reference ujson/CharParser#parseNumTopLevel().(facade)
//                                                           ^^^^^^^^ reference local15
//                                                                     ^^^^^^^^ reference local16
//                                                                               ^ reference ujson/CharParser#parseNumTopLevel().(i)
//                                                                                  ^ reference local13
//                                                                                      ^ reference local13
        }
        c = getCharSafe(j)
//      ^ reference local14
//          ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                      ^ reference local13
      }
      if (j0 == j) die(i, "expected digit")
//        ^^ reference local19
//           ^^ reference scala/Int#`==`(+3).
//              ^ reference local13
//                 ^^^ reference ujson/CharParser#die().
//                     ^ reference ujson/CharParser#parseNumTopLevel().(i)
    }

    (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                      ^^^^^^ reference ujson/CharParser#parseNumTopLevel().(facade)
//                                              ^^^^^^^^ reference local15
//                                                        ^^^^^^^^ reference local16
//                                                                  ^ reference ujson/CharParser#parseNumTopLevel().(i)
//                                                                     ^ reference local13
//                                                                         ^ reference local13
  }

  /**
   * Generate a Char from the hex digits of "\u1234" (i.e. "1234").
   *
   * NOTE: This is only capable of generating characters from the basic plane.
   * This is why it can only return Char instead of Int.
   */
  protected[this] final def descape(i: Int): Char = {
//                          ^^^^^^^ definition ujson/CharParser#descape().
//                                  ^ definition ujson/CharParser#descape().(i)
//                                     ^^^ reference scala/Int#
//                                           ^^^^ reference scala/Char#
    import upickle.core.RenderUtils.hex
//         ^^^^^^^ reference upickle/
//                 ^^^^ reference upickle/core/
//                      ^^^^^^^^^^^ reference upickle/core/RenderUtils.
//                                  ^^^ reference upickle/core/RenderUtils.hex().
    var x = 0
//      ^ definition local20
    x = (x << 4) | hex(getCharSafe(i+2).toInt)
//  ^ reference local20
//       ^ reference local20
//         ^^ reference scala/Int#`<<`().
//               ^ reference scala/Int#`|`(+3).
//                 ^^^ reference upickle/core/RenderUtils.hex().
//                     ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                                 ^ reference ujson/CharParser#descape().(i)
//                                  ^ reference scala/Int#`+`(+4).
//                                      ^^^^^ reference scala/Char#toInt().
    x = (x << 4) | hex(getCharSafe(i+3).toInt)
//  ^ reference local20
//       ^ reference local20
//         ^^ reference scala/Int#`<<`().
//               ^ reference scala/Int#`|`(+3).
//                 ^^^ reference upickle/core/RenderUtils.hex().
//                     ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                                 ^ reference ujson/CharParser#descape().(i)
//                                  ^ reference scala/Int#`+`(+4).
//                                      ^^^^^ reference scala/Char#toInt().
    x = (x << 4) | hex(getCharSafe(i+4).toInt)
//  ^ reference local20
//       ^ reference local20
//         ^^ reference scala/Int#`<<`().
//               ^ reference scala/Int#`|`(+3).
//                 ^^^ reference upickle/core/RenderUtils.hex().
//                     ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                                 ^ reference ujson/CharParser#descape().(i)
//                                  ^ reference scala/Int#`+`(+4).
//                                      ^^^^^ reference scala/Char#toInt().
    x = (x << 4) | hex(getCharSafe(i+5).toInt)
//  ^ reference local20
//       ^ reference local20
//         ^^ reference scala/Int#`<<`().
//               ^ reference scala/Int#`|`(+3).
//                 ^^^ reference upickle/core/RenderUtils.hex().
//                     ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                                 ^ reference ujson/CharParser#descape().(i)
//                                  ^ reference scala/Int#`+`(+4).
//                                      ^^^^^ reference scala/Char#toInt().
    x.toChar
//  ^ reference local20
//    ^^^^^^ reference scala/Int#toChar().
  }


  /**
   * Parse the JSON constant "true".
   *
   * Note that this method assumes that the first character has already been checked.
   */
  protected[this] final def parseTrue(i: Int, facade: Visitor[_, J]): J = {
//                          ^^^^^^^^^ definition ujson/CharParser#parseTrue().
//                                    ^ definition ujson/CharParser#parseTrue().(i)
//                                       ^^^ reference scala/Int#
//                                            ^^^^^^ definition ujson/CharParser#parseTrue().(facade)
//                                                    ^^^^^^^ reference upickle/core/Visitor#
//                                                               ^ reference ujson/CharParser#[J]
//                                                                    ^ reference ujson/CharParser#[J]
    requestUntilOrThrow(i + 3)
//  ^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#requestUntilOrThrow().
//                      ^ reference ujson/CharParser#parseTrue().(i)
//                        ^ reference scala/Int#`+`(+4).
    if (getCharUnsafe(i + 1) == 'r' && getCharUnsafe(i + 2) == 'u' && getCharUnsafe(i + 3) == 'e') {
//      ^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#getCharUnsafe().
//                    ^ reference ujson/CharParser#parseTrue().(i)
//                      ^ reference scala/Int#`+`(+4).
//                           ^^ reference scala/Char#`==`(+2).
//                                  ^^ reference scala/Boolean#`&&`().
//                                     ^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#getCharUnsafe().
//                                                   ^ reference ujson/CharParser#parseTrue().(i)
//                                                     ^ reference scala/Int#`+`(+4).
//                                                          ^^ reference scala/Char#`==`(+2).
//                                                                 ^^ reference scala/Boolean#`&&`().
//                                                                    ^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#getCharUnsafe().
//                                                                                  ^ reference ujson/CharParser#parseTrue().(i)
//                                                                                    ^ reference scala/Int#`+`(+4).
//                                                                                         ^^ reference scala/Char#`==`(+2).
      facade.visitTrue(i)
//    ^^^^^^ reference ujson/CharParser#parseTrue().(facade)
//           ^^^^^^^^^ reference upickle/core/Visitor#visitTrue().
//                     ^ reference ujson/CharParser#parseTrue().(i)
    } else {
      die(i, "expected true")
//    ^^^ reference ujson/CharParser#die().
//        ^ reference ujson/CharParser#parseTrue().(i)
    }
  }

  /**
   * Parse the JSON constant "false".
   *
   * Note that this method assumes that the first character has already been checked.
   */
  protected[this] final def parseFalse(i: Int, facade: Visitor[_, J]): J = {
//                          ^^^^^^^^^^ definition ujson/CharParser#parseFalse().
//                                     ^ definition ujson/CharParser#parseFalse().(i)
//                                        ^^^ reference scala/Int#
//                                             ^^^^^^ definition ujson/CharParser#parseFalse().(facade)
//                                                     ^^^^^^^ reference upickle/core/Visitor#
//                                                                ^ reference ujson/CharParser#[J]
//                                                                     ^ reference ujson/CharParser#[J]
    requestUntilOrThrow(i + 4)
//  ^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#requestUntilOrThrow().
//                      ^ reference ujson/CharParser#parseFalse().(i)
//                        ^ reference scala/Int#`+`(+4).

    if (getCharUnsafe(i + 1) == 'a' && getCharUnsafe(i + 2) == 'l' && getCharUnsafe(i + 3) == 's' && getCharUnsafe(i + 4) == 'e') {
//      ^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#getCharUnsafe().
//                    ^ reference ujson/CharParser#parseFalse().(i)
//                      ^ reference scala/Int#`+`(+4).
//                           ^^ reference scala/Char#`==`(+2).
//                                  ^^ reference scala/Boolean#`&&`().
//                                     ^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#getCharUnsafe().
//                                                   ^ reference ujson/CharParser#parseFalse().(i)
//                                                     ^ reference scala/Int#`+`(+4).
//                                                          ^^ reference scala/Char#`==`(+2).
//                                                                 ^^ reference scala/Boolean#`&&`().
//                                                                    ^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#getCharUnsafe().
//                                                                                  ^ reference ujson/CharParser#parseFalse().(i)
//                                                                                    ^ reference scala/Int#`+`(+4).
//                                                                                         ^^ reference scala/Char#`==`(+2).
//                                                                                                ^^ reference scala/Boolean#`&&`().
//                                                                                                   ^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#getCharUnsafe().
//                                                                                                                 ^ reference ujson/CharParser#parseFalse().(i)
//                                                                                                                   ^ reference scala/Int#`+`(+4).
//                                                                                                                        ^^ reference scala/Char#`==`(+2).
      facade.visitFalse(i)
//    ^^^^^^ reference ujson/CharParser#parseFalse().(facade)
//           ^^^^^^^^^^ reference upickle/core/Visitor#visitFalse().
//                      ^ reference ujson/CharParser#parseFalse().(i)
    } else {
      die(i, "expected false")
//    ^^^ reference ujson/CharParser#die().
//        ^ reference ujson/CharParser#parseFalse().(i)
    }
  }

  /**
   * Parse the JSON constant "null".
   *
   * Note that this method assumes that the first character has already been checked.
   */
  protected[this] final def parseNull(i: Int, facade: Visitor[_, J]): J = {
//                          ^^^^^^^^^ definition ujson/CharParser#parseNull().
//                                    ^ definition ujson/CharParser#parseNull().(i)
//                                       ^^^ reference scala/Int#
//                                            ^^^^^^ definition ujson/CharParser#parseNull().(facade)
//                                                    ^^^^^^^ reference upickle/core/Visitor#
//                                                               ^ reference ujson/CharParser#[J]
//                                                                    ^ reference ujson/CharParser#[J]
    requestUntilOrThrow(i + 3)
//  ^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#requestUntilOrThrow().
//                      ^ reference ujson/CharParser#parseNull().(i)
//                        ^ reference scala/Int#`+`(+4).
    if (getCharUnsafe(i + 1) == 'u' && getCharUnsafe(i + 2) == 'l' && getCharUnsafe(i + 3) == 'l') {
//      ^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#getCharUnsafe().
//                    ^ reference ujson/CharParser#parseNull().(i)
//                      ^ reference scala/Int#`+`(+4).
//                           ^^ reference scala/Char#`==`(+2).
//                                  ^^ reference scala/Boolean#`&&`().
//                                     ^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#getCharUnsafe().
//                                                   ^ reference ujson/CharParser#parseNull().(i)
//                                                     ^ reference scala/Int#`+`(+4).
//                                                          ^^ reference scala/Char#`==`(+2).
//                                                                 ^^ reference scala/Boolean#`&&`().
//                                                                    ^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#getCharUnsafe().
//                                                                                  ^ reference ujson/CharParser#parseNull().(i)
//                                                                                    ^ reference scala/Int#`+`(+4).
//                                                                                         ^^ reference scala/Char#`==`(+2).
      facade.visitNull(i)
//    ^^^^^^ reference ujson/CharParser#parseNull().(facade)
//           ^^^^^^^^^ reference upickle/core/Visitor#visitNull().
//                     ^ reference ujson/CharParser#parseNull().(i)
    } else {
      die(i, "expected null")
//    ^^^ reference ujson/CharParser#die().
//        ^ reference ujson/CharParser#parseNull().(i)
    }
  }

  protected[this] final def parseTopLevel(i: Int, facade: Visitor[_, J]): (J, Int) = {
//                          ^^^^^^^^^^^^^ definition ujson/CharParser#parseTopLevel().
//                                        ^ definition ujson/CharParser#parseTopLevel().(i)
//                                           ^^^ reference scala/Int#
//                                                ^^^^^^ definition ujson/CharParser#parseTopLevel().(facade)
//                                                        ^^^^^^^ reference upickle/core/Visitor#
//                                                                   ^ reference ujson/CharParser#[J]
//                                                                         ^ reference ujson/CharParser#[J]
//                                                                            ^^^ reference scala/Int#
    try parseTopLevel0(i, facade)
//      ^^^^^^^^^^^^^^ reference ujson/CharParser#parseTopLevel0().
//                     ^ reference ujson/CharParser#parseTopLevel().(i)
//                        ^^^^^^ reference ujson/CharParser#parseTopLevel().(facade)
    catch reject(i)
//        ^^^^^^ reference ujson/CharParser#reject().
//               ^ reference ujson/CharParser#parseTopLevel().(i)
  }
  /**
   * Parse and return the next JSON value and the position beyond it.
   */
  @tailrec
// ^^^^^^^ reference scala/annotation/tailrec#
//         reference scala/annotation/tailrec#`<init>`().
  protected[this] final def parseTopLevel0(i: Int, facade: Visitor[_, J]): (J, Int) = {
//                          ^^^^^^^^^^^^^^ definition ujson/CharParser#parseTopLevel0().
//                                         ^ definition ujson/CharParser#parseTopLevel0().(i)
//                                            ^^^ reference scala/Int#
//                                                 ^^^^^^ definition ujson/CharParser#parseTopLevel0().(facade)
//                                                         ^^^^^^^ reference upickle/core/Visitor#
//                                                                    ^ reference ujson/CharParser#[J]
//                                                                          ^ reference ujson/CharParser#[J]
//                                                                             ^^^ reference scala/Int#
    (getCharSafe(i): @switch) match {
//   ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//               ^ reference ujson/CharParser#parseTopLevel0().(i)
      // ignore whitespace
      case ' ' | '\t' | 'r' => parseTopLevel0(i + 1, facade)
//                             ^^^^^^^^^^^^^^ reference ujson/CharParser#parseTopLevel0().
//                                            ^ reference ujson/CharParser#parseTopLevel0().(i)
//                                              ^ reference scala/Int#`+`(+4).
//                                                   ^^^^^^ reference ujson/CharParser#parseTopLevel0().(facade)
      case '\n' => parseTopLevel0(i + 1, facade)
//                 ^^^^^^^^^^^^^^ reference ujson/CharParser#parseTopLevel0().
//                                ^ reference ujson/CharParser#parseTopLevel0().(i)
//                                  ^ reference scala/Int#`+`(+4).
//                                       ^^^^^^ reference ujson/CharParser#parseTopLevel0().(facade)

      // if we have a recursive top-level structure, we'll delegate the parsing
      // duties to our good friend rparse().
      case '[' => parseNested(ARRBEG, i + 1, facade.visitArray(-1, i), Nil)
//                ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                            ^^^^^^ reference ujson/CharParser#ARRBEG.
//                                    ^ reference ujson/CharParser#parseTopLevel0().(i)
//                                      ^ reference scala/Int#`+`(+4).
//                                           ^^^^^^ reference ujson/CharParser#parseTopLevel0().(facade)
//                                                  ^^^^^^^^^^ reference upickle/core/Visitor#visitArray().
//                                                                 ^ reference ujson/CharParser#parseTopLevel0().(i)
//                                                                     ^^^ reference scala/package.Nil.
      case '{' => parseNested(OBJBEG, i + 1, facade.visitObject(-1, i), Nil)
//                ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                            ^^^^^^ reference ujson/CharParser#OBJBEG.
//                                    ^ reference ujson/CharParser#parseTopLevel0().(i)
//                                      ^ reference scala/Int#`+`(+4).
//                                           ^^^^^^ reference ujson/CharParser#parseTopLevel0().(facade)
//                                                  ^^^^^^^^^^^ reference upickle/core/Visitor#visitObject().
//                                                                  ^ reference ujson/CharParser#parseTopLevel0().(i)
//                                                                      ^^^ reference scala/package.Nil.

      // we have a single top-level number
      case '-' | '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' => parseNumTopLevel(i, facade)
//                                                                            ^^^^^^^^^^^^^^^^ reference ujson/CharParser#parseNumTopLevel().
//                                                                                             ^ reference ujson/CharParser#parseTopLevel0().(i)
//                                                                                                ^^^^^^ reference ujson/CharParser#parseTopLevel0().(facade)

      // we have a single top-level string
      case '"' => parseStringTopLevel(i, facade)
//                ^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#parseStringTopLevel().
//                                    ^ reference ujson/CharParser#parseTopLevel0().(i)
//                                       ^^^^^^ reference ujson/CharParser#parseTopLevel0().(facade)

      // we have a single top-level constant
      case 't' => (parseTrue(i, facade), i + 4)
//                 ^^^^^^^^^ reference ujson/CharParser#parseTrue().
//                           ^ reference ujson/CharParser#parseTopLevel0().(i)
//                              ^^^^^^ reference ujson/CharParser#parseTopLevel0().(facade)
//                                       ^ reference ujson/CharParser#parseTopLevel0().(i)
//                                         ^ reference scala/Int#`+`(+4).
      case 'f' => (parseFalse(i, facade), i + 5)
//                 ^^^^^^^^^^ reference ujson/CharParser#parseFalse().
//                            ^ reference ujson/CharParser#parseTopLevel0().(i)
//                               ^^^^^^ reference ujson/CharParser#parseTopLevel0().(facade)
//                                        ^ reference ujson/CharParser#parseTopLevel0().(i)
//                                          ^ reference scala/Int#`+`(+4).
      case 'n' => (parseNull(i, facade), i + 4)
//                 ^^^^^^^^^ reference ujson/CharParser#parseNull().
//                           ^ reference ujson/CharParser#parseTopLevel0().(i)
//                              ^^^^^^ reference ujson/CharParser#parseTopLevel0().(facade)
//                                       ^ reference ujson/CharParser#parseTopLevel0().(i)
//                                         ^ reference scala/Int#`+`(+4).

      // invalid
      case _ => die(i, "expected json value")
//              ^^^ reference ujson/CharParser#die().
//                  ^ reference ujson/CharParser#parseTopLevel0().(i)
    }
  }

  def reject(j: Int): PartialFunction[Throwable, Nothing] = {
//    ^^^^^^ definition ujson/CharParser#reject().
//           ^ definition ujson/CharParser#reject().(j)
//              ^^^ reference scala/Int#
//                    ^^^^^^^^^^^^^^^ reference scala/PartialFunction#
//                                    ^^^^^^^^^ reference scala/package.Throwable#
//                                               ^^^^^^^ reference scala/Nothing#
    case e: Abort =>
//       ^ definition local21
//          ^^^^^ reference upickle/core/Abort#
      throw new AbortException(e.msg, j, -1, -1, e)
//              ^^^^^^^^^^^^^^ reference upickle/core/AbortException#
//                             reference upickle/core/AbortException#`<init>`().
//                             ^ reference local21
//                               ^^^ reference upickle/core/Abort#msg.
//                                    ^ reference ujson/CharParser#reject().(j)
//                                               ^ reference local21
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
//                          ^^^^^^^^^^^ definition ujson/CharParser#parseNested().
//                                      ^^^^^ definition ujson/CharParser#parseNested().(state)
//                                             ^^^ reference scala/Int#
                                        i: Int,
//                                      ^ definition ujson/CharParser#parseNested().(i)
//                                         ^^^ reference scala/Int#
                                        stackHead: ObjArrVisitor[_, J],
//                                      ^^^^^^^^^ definition ujson/CharParser#parseNested().(stackHead)
//                                                 ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                  ^ reference ujson/CharParser#[J]
                                        stackTail: List[ObjArrVisitor[_, J]]) : (J, Int) = {
//                                      ^^^^^^^^^ definition ujson/CharParser#parseNested().(stackTail)
//                                                 ^^^^ reference scala/package.List#
//                                                      ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                       ^ reference ujson/CharParser#[J]
//                                                                               ^ reference ujson/CharParser#[J]
//                                                                                  ^^^ reference scala/Int#
    (getCharSafe(i): @switch) match{
//   ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//               ^ reference ujson/CharParser#parseNested().(i)
      case ' ' | '\t' | '\r' | '\n' =>
        parseNested(state, i + 1, stackHead, stackTail)
//      ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                  ^^^^^ reference ujson/CharParser#parseNested().(state)
//                         ^ reference ujson/CharParser#parseNested().(i)
//                           ^ reference scala/Int#`+`(+4).
//                                ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                           ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)

      case '"' =>
        state match{
//      ^^^^^ reference ujson/CharParser#parseNested().(state)
          case KEY | OBJBEG =>
//             ^^^ reference ujson/CharParser#KEY.
//                   ^^^^^^ reference ujson/CharParser#OBJBEG.
            val nextJ = try parseStringKey(i, stackHead) catch reject(i)
//              ^^^^^ definition local22
//                          ^^^^^^^^^^^^^^ reference ujson/CharParser#parseStringKey().
//                                         ^ reference ujson/CharParser#parseNested().(i)
//                                            ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                                             ^^^^^^ reference ujson/CharParser#reject().
//                                                                    ^ reference ujson/CharParser#parseNested().(i)
            parseNested(COLON, nextJ, stackHead, stackTail)
//          ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                      ^^^^^ reference ujson/CharParser#COLON.
//                             ^^^^^ reference local22
//                                    ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                               ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)

          case DATA | ARRBEG =>
//             ^^^^ reference ujson/CharParser#DATA.
//                    ^^^^^^ reference ujson/CharParser#ARRBEG.
            val nextJ = try parseStringValue(i, stackHead) catch reject(i)
//              ^^^^^ definition local23
//                          ^^^^^^^^^^^^^^^^ reference ujson/CharParser#parseStringValue().
//                                           ^ reference ujson/CharParser#parseNested().(i)
//                                              ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                                               ^^^^^^ reference ujson/CharParser#reject().
//                                                                      ^ reference ujson/CharParser#parseNested().(i)
            parseNested(collectionEndFor(stackHead), nextJ, stackHead, stackTail)
//          ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                      ^^^^^^^^^^^^^^^^ reference ujson/CharParser#collectionEndFor().
//                                       ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                                   ^^^^^ reference local23
//                                                          ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                                                     ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)

          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#dieWithFailureMessage().
//                                        ^ reference ujson/CharParser#parseNested().(i)
//                                           ^^^^^ reference ujson/CharParser#parseNested().(state)
        }

      case ':' =>
        // we are in an object just after a key, expecting to see a colon.
        state match{
//      ^^^^^ reference ujson/CharParser#parseNested().(state)
          case COLON => parseNested(DATA, i + 1, stackHead, stackTail)
//             ^^^^^ reference ujson/CharParser#COLON.
//                      ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                                  ^^^^ reference ujson/CharParser#DATA.
//                                        ^ reference ujson/CharParser#parseNested().(i)
//                                          ^ reference scala/Int#`+`(+4).
//                                               ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                                          ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)
          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#dieWithFailureMessage().
//                                        ^ reference ujson/CharParser#parseNested().(i)
//                                           ^^^^^ reference ujson/CharParser#parseNested().(state)
        }

      case '[' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference ujson/CharParser#failIfNotData().
//                    ^^^^^ reference ujson/CharParser#parseNested().(state)
//                           ^ reference ujson/CharParser#parseNested().(i)
        val ctx =
//          ^^^ definition local24
          try stackHead.subVisitor.asInstanceOf[Visitor[_, J]].visitArray(-1, i)
//            ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                      ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                 ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                              ^^^^^^^ reference upickle/core/Visitor#
//                                                         ^ reference ujson/CharParser#[J]
//                                                             ^^^^^^^^^^ reference upickle/core/Visitor#visitArray().
//                                                                            ^ reference ujson/CharParser#parseNested().(i)
          catch reject(i)
//              ^^^^^^ reference ujson/CharParser#reject().
//                     ^ reference ujson/CharParser#parseNested().(i)
        parseNested(ARRBEG, i + 1, ctx, stackHead :: stackTail)
//      ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                  ^^^^^^ reference ujson/CharParser#ARRBEG.
//                          ^ reference ujson/CharParser#parseNested().(i)
//                            ^ reference scala/Int#`+`(+4).
//                                 ^^^ reference local24
//                                      ^^^^^^^^^ reference local25
//                                                ^^ reference scala/collection/immutable/List#`::`().
//                                                   ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)

      case '{' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference ujson/CharParser#failIfNotData().
//                    ^^^^^ reference ujson/CharParser#parseNested().(state)
//                           ^ reference ujson/CharParser#parseNested().(i)
        val ctx =
//          ^^^ definition local27
          try stackHead.subVisitor.asInstanceOf[Visitor[_, J]].visitObject(-1, i)
//            ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                      ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                 ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                              ^^^^^^^ reference upickle/core/Visitor#
//                                                         ^ reference ujson/CharParser#[J]
//                                                             ^^^^^^^^^^^ reference upickle/core/Visitor#visitObject().
//                                                                             ^ reference ujson/CharParser#parseNested().(i)
          catch reject(i)
//              ^^^^^^ reference ujson/CharParser#reject().
//                     ^ reference ujson/CharParser#parseNested().(i)
        parseNested(OBJBEG, i + 1, ctx, stackHead :: stackTail)
//      ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                  ^^^^^^ reference ujson/CharParser#OBJBEG.
//                          ^ reference ujson/CharParser#parseNested().(i)
//                            ^ reference scala/Int#`+`(+4).
//                                 ^^^ reference local27
//                                      ^^^^^^^^^ reference local28
//                                                ^^ reference scala/collection/immutable/List#`::`().
//                                                   ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)

      case '-' | '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference ujson/CharParser#failIfNotData().
//                    ^^^^^ reference ujson/CharParser#parseNested().(state)
//                           ^ reference ujson/CharParser#parseNested().(i)
        val ctx =
//          ^^^ definition local29
          try parseNum(i, stackHead.narrow, stackHead.subVisitor.asInstanceOf[Visitor[_, J]])
//            ^^^^^^^^ reference ujson/CharParser#parseNum().
//                     ^ reference ujson/CharParser#parseNested().(i)
//                        ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                  ^^^^^^ reference upickle/core/ObjArrVisitor#narrow().
//                                          ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                                    ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                                               ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                                                            ^^^^^^^ reference upickle/core/Visitor#
//                                                                                       ^ reference ujson/CharParser#[J]
          catch reject(i)
//              ^^^^^^ reference ujson/CharParser#reject().
//                     ^ reference ujson/CharParser#parseNested().(i)
        parseNested(collectionEndFor(stackHead), ctx, stackHead, stackTail)
//      ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                  ^^^^^^^^^^^^^^^^ reference ujson/CharParser#collectionEndFor().
//                                   ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                               ^^^ reference local29
//                                                    ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                                               ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)

      case 't' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference ujson/CharParser#failIfNotData().
//                    ^^^^^ reference ujson/CharParser#parseNested().(state)
//                           ^ reference ujson/CharParser#parseNested().(i)
        try stackHead.narrow.visitValue(
//          ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                    ^^^^^^ reference upickle/core/ObjArrVisitor#narrow().
//                           ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
          parseTrue(i, stackHead.subVisitor.asInstanceOf[Visitor[_, J]]),
//        ^^^^^^^^^ reference ujson/CharParser#parseTrue().
//                  ^ reference ujson/CharParser#parseNested().(i)
//                     ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                               ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                          ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                                       ^^^^^^^ reference upickle/core/Visitor#
//                                                                  ^ reference ujson/CharParser#[J]
          i
//        ^ reference ujson/CharParser#parseNested().(i)
        )
        catch reject(i)
//            ^^^^^^ reference ujson/CharParser#reject().
//                   ^ reference ujson/CharParser#parseNested().(i)
        parseNested(collectionEndFor(stackHead), i + 4, stackHead, stackTail)
//      ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                  ^^^^^^^^^^^^^^^^ reference ujson/CharParser#collectionEndFor().
//                                   ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                               ^ reference ujson/CharParser#parseNested().(i)
//                                                 ^ reference scala/Int#`+`(+4).
//                                                      ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                                                 ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)

      case 'f' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference ujson/CharParser#failIfNotData().
//                    ^^^^^ reference ujson/CharParser#parseNested().(state)
//                           ^ reference ujson/CharParser#parseNested().(i)
        try stackHead.narrow.visitValue(
//          ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                    ^^^^^^ reference upickle/core/ObjArrVisitor#narrow().
//                           ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
          parseFalse(i, stackHead.subVisitor.asInstanceOf[Visitor[_, J]]),
//        ^^^^^^^^^^ reference ujson/CharParser#parseFalse().
//                   ^ reference ujson/CharParser#parseNested().(i)
//                      ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                           ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                                        ^^^^^^^ reference upickle/core/Visitor#
//                                                                   ^ reference ujson/CharParser#[J]
          i
//        ^ reference ujson/CharParser#parseNested().(i)
        )
        catch reject(i)
//            ^^^^^^ reference ujson/CharParser#reject().
//                   ^ reference ujson/CharParser#parseNested().(i)
        parseNested(collectionEndFor(stackHead), i + 5, stackHead, stackTail)
//      ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                  ^^^^^^^^^^^^^^^^ reference ujson/CharParser#collectionEndFor().
//                                   ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                               ^ reference ujson/CharParser#parseNested().(i)
//                                                 ^ reference scala/Int#`+`(+4).
//                                                      ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                                                 ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)

      case 'n' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference ujson/CharParser#failIfNotData().
//                    ^^^^^ reference ujson/CharParser#parseNested().(state)
//                           ^ reference ujson/CharParser#parseNested().(i)
        try stackHead.narrow.visitValue(
//          ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                    ^^^^^^ reference upickle/core/ObjArrVisitor#narrow().
//                           ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
          parseNull(i, stackHead.subVisitor.asInstanceOf[Visitor[_, J]]),
//        ^^^^^^^^^ reference ujson/CharParser#parseNull().
//                  ^ reference ujson/CharParser#parseNested().(i)
//                     ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                               ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                                          ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                                       ^^^^^^^ reference upickle/core/Visitor#
//                                                                  ^ reference ujson/CharParser#[J]
          i
//        ^ reference ujson/CharParser#parseNested().(i)
        )
        catch reject(i)
//            ^^^^^^ reference ujson/CharParser#reject().
//                   ^ reference ujson/CharParser#parseNested().(i)
        parseNested(collectionEndFor(stackHead), i + 4, stackHead, stackTail)
//      ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                  ^^^^^^^^^^^^^^^^ reference ujson/CharParser#collectionEndFor().
//                                   ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                               ^ reference ujson/CharParser#parseNested().(i)
//                                                 ^ reference scala/Int#`+`(+4).
//                                                      ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                                                 ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)

      case ',' =>
        dropBufferUntil(i)
//      ^^^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#dropBufferUntil().
//                      ^ reference ujson/CharParser#parseNested().(i)
        (state: @switch) match{
//       ^^^^^ reference ujson/CharParser#parseNested().(state)
          case ARREND => parseNested(DATA, i + 1, stackHead, stackTail)
//             ^^^^^^ reference ujson/CharParser#ARREND.
//                       ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                                   ^^^^ reference ujson/CharParser#DATA.
//                                         ^ reference ujson/CharParser#parseNested().(i)
//                                           ^ reference scala/Int#`+`(+4).
//                                                ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                                           ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)
          case OBJEND => parseNested(KEY, i + 1, stackHead, stackTail)
//             ^^^^^^ reference ujson/CharParser#OBJEND.
//                       ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                                   ^^^ reference ujson/CharParser#KEY.
//                                        ^ reference ujson/CharParser#parseNested().(i)
//                                          ^ reference scala/Int#`+`(+4).
//                                               ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                                          ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)
          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#dieWithFailureMessage().
//                                        ^ reference ujson/CharParser#parseNested().(i)
//                                           ^^^^^ reference ujson/CharParser#parseNested().(state)
        }

      case ']' =>
        (state: @switch) match{
//       ^^^^^ reference ujson/CharParser#parseNested().(state)
          case ARREND | ARRBEG =>
//             ^^^^^^ reference ujson/CharParser#ARREND.
//                      ^^^^^^ reference ujson/CharParser#ARRBEG.
            tryCloseCollection(stackHead, stackTail, i) match{
//          ^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#tryCloseCollection().
//                             ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                        ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)
//                                                   ^ reference ujson/CharParser#parseNested().(i)
              case Some(t) => t
//                 ^^^^ reference scala/Some.
//                      ^ definition local30
//                            ^ reference local30
              case None =>
//                 ^^^^ reference scala/None.
                val stackTailHead = stackTail.head
//                  ^^^^^^^^^^^^^ definition local31
//                                  ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)
//                                            ^^^^ reference scala/collection/IterableOps#head().
                parseNested(collectionEndFor(stackTailHead), i + 1, stackTailHead, stackTail.tail)
//              ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                          ^^^^^^^^^^^^^^^^ reference ujson/CharParser#collectionEndFor().
//                                           ^^^^^^^^^^^^^ reference local31
//                                                           ^ reference ujson/CharParser#parseNested().(i)
//                                                             ^ reference scala/Int#`+`(+4).
//                                                                  ^^^^^^^^^^^^^ reference local31
//                                                                                 ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)
//                                                                                           ^^^^ reference scala/collection/IterableOps#tail().
            }
          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#dieWithFailureMessage().
//                                        ^ reference ujson/CharParser#parseNested().(i)
//                                           ^^^^^ reference ujson/CharParser#parseNested().(state)
        }

      case '}' =>
        (state: @switch) match{
//       ^^^^^ reference ujson/CharParser#parseNested().(state)
          case OBJEND | OBJBEG =>
//             ^^^^^^ reference ujson/CharParser#OBJEND.
//                      ^^^^^^ reference ujson/CharParser#OBJBEG.
            tryCloseCollection(stackHead, stackTail, i) match{
//          ^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#tryCloseCollection().
//                             ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackHead)
//                                        ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)
//                                                   ^ reference ujson/CharParser#parseNested().(i)
              case Some(t) => t
//                 ^^^^ reference scala/Some.
//                      ^ definition local32
//                            ^ reference local32
              case None =>
//                 ^^^^ reference scala/None.
                val stackTailHead = stackTail.head
//                  ^^^^^^^^^^^^^ definition local33
//                                  ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)
//                                            ^^^^ reference scala/collection/IterableOps#head().
                parseNested(collectionEndFor(stackTailHead), i + 1, stackTailHead, stackTail.tail)
//              ^^^^^^^^^^^ reference ujson/CharParser#parseNested().
//                          ^^^^^^^^^^^^^^^^ reference ujson/CharParser#collectionEndFor().
//                                           ^^^^^^^^^^^^^ reference local33
//                                                           ^ reference ujson/CharParser#parseNested().(i)
//                                                             ^ reference scala/Int#`+`(+4).
//                                                                  ^^^^^^^^^^^^^ reference local33
//                                                                                 ^^^^^^^^^ reference ujson/CharParser#parseNested().(stackTail)
//                                                                                           ^^^^ reference scala/collection/IterableOps#tail().
            }
          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#dieWithFailureMessage().
//                                        ^ reference ujson/CharParser#parseNested().(i)
//                                           ^^^^^ reference ujson/CharParser#parseNested().(state)
        }
      case _ => dieWithFailureMessage(i, state)
//              ^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#dieWithFailureMessage().
//                                    ^ reference ujson/CharParser#parseNested().(i)
//                                       ^^^^^ reference ujson/CharParser#parseNested().(state)

    }
  }


  def dieWithFailureMessage(i: Int, state: Int) = {
//    ^^^^^^^^^^^^^^^^^^^^^ definition ujson/CharParser#dieWithFailureMessage().
//                          ^ definition ujson/CharParser#dieWithFailureMessage().(i)
//                             ^^^ reference scala/Int#
//                                  ^^^^^ definition ujson/CharParser#dieWithFailureMessage().(state)
//                                         ^^^ reference scala/Int#
    val expected = state match{
//      ^^^^^^^^ definition local34
//                 ^^^^^ reference ujson/CharParser#dieWithFailureMessage().(state)
      case ARRBEG => "json value or ]"
//         ^^^^^^ reference ujson/CharParser#ARRBEG.
      case OBJBEG => "json value or }"
//         ^^^^^^ reference ujson/CharParser#OBJBEG.
      case DATA => "json value"
//         ^^^^ reference ujson/CharParser#DATA.
      case KEY => "json string key"
//         ^^^ reference ujson/CharParser#KEY.
      case COLON => ":"
//         ^^^^^ reference ujson/CharParser#COLON.
      case ARREND => ", or ]"
//         ^^^^^^ reference ujson/CharParser#ARREND.
      case OBJEND => ", or }"
//         ^^^^^^ reference ujson/CharParser#OBJEND.
    }
    die(i, s"expected $expected")
//  ^^^ reference ujson/CharParser#die().
//      ^ reference ujson/CharParser#dieWithFailureMessage().(i)
//         ^ reference scala/StringContext#s().
//                     ^^^^^^^^ reference local34
  }

  def failIfNotData(state: Int, i: Int) = (state: @switch) match{
//    ^^^^^^^^^^^^^ definition ujson/CharParser#failIfNotData().
//                  ^^^^^ definition ujson/CharParser#failIfNotData().(state)
//                         ^^^ reference scala/Int#
//                              ^ definition ujson/CharParser#failIfNotData().(i)
//                                 ^^^ reference scala/Int#
//                                         ^^^^^ reference ujson/CharParser#failIfNotData().(state)
    case DATA | ARRBEG => // do nothing
//       ^^^^ reference ujson/CharParser#DATA.
//              ^^^^^^ reference ujson/CharParser#ARRBEG.
    case _ => dieWithFailureMessage(i, state)
//            ^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#dieWithFailureMessage().
//                                  ^ reference ujson/CharParser#failIfNotData().(i)
//                                     ^^^^^ reference ujson/CharParser#failIfNotData().(state)
  }

  def tryCloseCollection(stackHead: ObjArrVisitor[_, J], stackTail: List[ObjArrVisitor[_, J]], i: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition ujson/CharParser#tryCloseCollection().
//                       ^^^^^^^^^ definition ujson/CharParser#tryCloseCollection().(stackHead)
//                                  ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                   ^ reference ujson/CharParser#[J]
//                                                       ^^^^^^^^^ definition ujson/CharParser#tryCloseCollection().(stackTail)
//                                                                  ^^^^ reference scala/package.List#
//                                                                       ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                                        ^ reference ujson/CharParser#[J]
//                                                                                             ^ definition ujson/CharParser#tryCloseCollection().(i)
//                                                                                                ^^^ reference scala/Int#
    if (stackTail.isEmpty) {
//      ^^^^^^^^^ reference ujson/CharParser#tryCloseCollection().(stackTail)
//                ^^^^^^^ reference scala/collection/immutable/List#isEmpty().
      Some(try stackHead.visitEnd(i) catch reject(i), i + 1)
//    ^^^^ reference scala/Some.
//             ^^^^^^^^^ reference ujson/CharParser#tryCloseCollection().(stackHead)
//                       ^^^^^^^^ reference upickle/core/ObjArrVisitor#visitEnd().
//                                ^ reference ujson/CharParser#tryCloseCollection().(i)
//                                         ^^^^^^ reference ujson/CharParser#reject().
//                                                ^ reference ujson/CharParser#tryCloseCollection().(i)
//                                                    ^ reference ujson/CharParser#tryCloseCollection().(i)
//                                                      ^ reference scala/Int#`+`(+4).
    } else {
      val ctxt2 = stackTail.head.narrow
//        ^^^^^ definition local35
//                ^^^^^^^^^ reference ujson/CharParser#tryCloseCollection().(stackTail)
//                          ^^^^ reference scala/collection/IterableOps#head().
//                               ^^^^^^ reference upickle/core/ObjArrVisitor#narrow().
      try ctxt2.visitValue(stackHead.visitEnd(i), i) catch reject(i)
//        ^^^^^ reference local35
//              ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
//                         ^^^^^^^^^ reference ujson/CharParser#tryCloseCollection().(stackHead)
//                                   ^^^^^^^^ reference upickle/core/ObjArrVisitor#visitEnd().
//                                            ^ reference ujson/CharParser#tryCloseCollection().(i)
//                                                ^ reference ujson/CharParser#tryCloseCollection().(i)
//                                                         ^^^^^^ reference ujson/CharParser#reject().
//                                                                ^ reference ujson/CharParser#tryCloseCollection().(i)
      None
//    ^^^^ reference scala/None.

    }
  }
  def collectionEndFor(stackHead: ObjArrVisitor[_, _]) = {
//    ^^^^^^^^^^^^^^^^ definition ujson/CharParser#collectionEndFor().
//                     ^^^^^^^^^ definition ujson/CharParser#collectionEndFor().(stackHead)
//                                ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
    if (stackHead.isObj) OBJEND
//      ^^^^^^^^^ reference ujson/CharParser#collectionEndFor().(stackHead)
//                ^^^^^ reference upickle/core/ObjArrVisitor#isObj().
//                       ^^^^^^ reference ujson/CharParser#OBJEND.
    else ARREND
//       ^^^^^^ reference ujson/CharParser#ARREND.
  }

  /**
    * See if the string has any escape sequences. If not, return the
    * end of the string. If so, bail out and return -1.
    *
    * This method expects the data to be in UTF-16 and accesses it as
    * chars.
    */
  protected[this] final def parseStringSimple(i: Int): Int = {
//                          ^^^^^^^^^^^^^^^^^ definition ujson/CharParser#parseStringSimple().
//                                            ^ definition ujson/CharParser#parseStringSimple().(i)
//                                               ^^^ reference scala/Int#
//                                                     ^^^ reference scala/Int#
    var j = i
//      ^ definition local36
//          ^ reference ujson/CharParser#parseStringSimple().(i)
    var c = elemOps.toUnsignedInt(getCharSafe(j))
//      ^ definition local37
//          ^^^^^^^ reference ujson/CharParser#elemOps.
//                  ^^^^^^^^^^^^^ reference upickle/core/CharOps.toUnsignedInt().
//                                ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                                            ^ reference local36
    while (c != '"') {
//         ^ reference local37
//           ^^ reference scala/Int#`!=`(+2).
      if (c < ' ') die(j, s"control char (${c}) in string")
//        ^ reference local37
//          ^ reference scala/Int#`<`(+2).
//                 ^^^ reference ujson/CharParser#die().
//                     ^ reference local36
//                        ^ reference scala/StringContext#s().
//                                          ^ reference local37
      if (c == '\\' || c > 127) return -1 - j
//        ^ reference local37
//          ^^ reference scala/Int#`==`(+2).
//                  ^^ reference scala/Boolean#`||`().
//                     ^ reference local37
//                       ^ reference scala/Int#`>`(+3).
//                                        ^ reference scala/Int#`-`(+3).
//                                          ^ reference local36
      j += 1
//    ^ reference local36
//      ^^ reference scala/Int#`+`(+4).
      c = elemOps.toUnsignedInt(getCharSafe(j))
//    ^ reference local37
//        ^^^^^^^ reference ujson/CharParser#elemOps.
//                ^^^^^^^^^^^^^ reference upickle/core/CharOps.toUnsignedInt().
//                              ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                                          ^ reference local36
    }
    j + 1
//  ^ reference local36
//    ^ reference scala/Int#`+`(+4).
  }

  /**
    * Parse a string that is known to have escape sequences.
    */
  protected[this] final def parseStringComplex(i0: Int): Int = {
//                          ^^^^^^^^^^^^^^^^^^ definition ujson/CharParser#parseStringComplex().
//                                             ^^ definition ujson/CharParser#parseStringComplex().(i0)
//                                                 ^^^ reference scala/Int#
//                                                       ^^^ reference scala/Int#
    var i = i0
//      ^ definition local38
//          ^^ reference ujson/CharParser#parseStringComplex().(i0)
    var c = elemOps.toUnsignedInt(getCharSafe(i))
//      ^ definition local39
//          ^^^^^^^ reference ujson/CharParser#elemOps.
//                  ^^^^^^^^^^^^^ reference upickle/core/CharOps.toUnsignedInt().
//                                ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                                            ^ reference local38
    while (c != '"') {
//         ^ reference local39
//           ^^ reference scala/Int#`!=`(+2).

      if (c < ' ') die(i, s"control char (${c}) in string")
//        ^ reference local39
//          ^ reference scala/Int#`<`(+2).
//                 ^^^ reference ujson/CharParser#die().
//                     ^ reference local38
//                        ^ reference scala/StringContext#s().
//                                          ^ reference local39
      else if (c == '\\') {
//             ^ reference local39
//               ^^ reference scala/Int#`==`(+2).
        (getCharSafe(i + 1): @switch) match {
//       ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                   ^ reference local38
//                     ^ reference scala/Int#`+`(+4).
          case 'b' => { outputBuilder.append('\b'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/CharBuilder#append(+1).
//                                                  ^ reference local38
//                                                    ^^ reference scala/Int#`+`(+4).
          case 'f' => { outputBuilder.append('\f'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/CharBuilder#append(+1).
//                                                  ^ reference local38
//                                                    ^^ reference scala/Int#`+`(+4).
          case 'n' => { outputBuilder.append('\n'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/CharBuilder#append(+1).
//                                                  ^ reference local38
//                                                    ^^ reference scala/Int#`+`(+4).
          case 'r' => { outputBuilder.append('\r'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/CharBuilder#append(+1).
//                                                  ^ reference local38
//                                                    ^^ reference scala/Int#`+`(+4).
          case 't' => { outputBuilder.append('\t'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/CharBuilder#append(+1).
//                                                  ^ reference local38
//                                                    ^^ reference scala/Int#`+`(+4).

          case '"' => { outputBuilder.append('"'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/CharBuilder#append(+1).
//                                                 ^ reference local38
//                                                   ^^ reference scala/Int#`+`(+4).
          case '/' => { outputBuilder.append('/'); i += 2 }
//                      ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference upickle/core/CharBuilder#append(+1).
//                                                 ^ reference local38
//                                                   ^^ reference scala/Int#`+`(+4).
          case '\\' => { outputBuilder.append('\\'); i += 2 }
//                       ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                                     ^^^^^^ reference upickle/core/CharBuilder#append(+1).
//                                                   ^ reference local38
//                                                     ^^ reference scala/Int#`+`(+4).

          // if there's a problem then descape will explode
          case 'u' =>
            val d = descape(i)
//              ^ definition local40
//                  ^^^^^^^ reference ujson/CharParser#descape().
//                          ^ reference local38
            outputBuilder.appendC(d)
//          ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                        ^^^^^^^ reference upickle/core/CharAppendC#appendC().
//                                ^ reference local40

            i += 6
//          ^ reference local38
//            ^^ reference scala/Int#`+`(+4).

          case c => die(i + 1, s"illegal escape sequence after \\")
//             ^ definition local41
//                  ^^^ reference ujson/CharParser#die().
//                      ^ reference local38
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
//      ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                    ^^^^^^ reference upickle/core/CharBuilder#append().
//                           ^ reference local39
        i += 1
//      ^ reference local38
//        ^^ reference scala/Int#`+`(+4).
      }
      c = elemOps.toUnsignedInt(getCharSafe(i))
//    ^ reference local39
//        ^^^^^^^ reference ujson/CharParser#elemOps.
//                ^^^^^^^^^^^^^ reference upickle/core/CharOps.toUnsignedInt().
//                              ^^^^^^^^^^^ reference ujson/CharParser#getCharSafe().
//                                          ^ reference local38
    }

    i + 1
//  ^ reference local38
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
//                          ^^^^^^^^^^^^^^^^ definition ujson/CharParser#parseStringValue().
//                                           ^ definition ujson/CharParser#parseStringValue().(i)
//                                              ^^^ reference scala/Int#
//                                                   ^^^^^^^^^ definition ujson/CharParser#parseStringValue().(stackHead)
//                                                              ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                               ^ reference ujson/CharParser#[J]
//                                                                                    ^^^ reference scala/Int#

    val k = parseStringSimple(i + 1)
//      ^ definition local42
//          ^^^^^^^^^^^^^^^^^ reference ujson/CharParser#parseStringSimple().
//                            ^ reference ujson/CharParser#parseStringValue().(i)
//                              ^ reference scala/Int#`+`(+4).
    if (k >= 0) {
//      ^ reference local42
//        ^^ reference scala/Int#`>=`(+3).
      visitString(i, unsafeCharSeqForRange(i + 1, k - i - 2), stackHead)
//    ^^^^^^^^^^^ reference ujson/CharParser#visitString().
//                ^ reference ujson/CharParser#parseStringValue().(i)
//                   ^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#unsafeCharSeqForRange().
//                                         ^ reference ujson/CharParser#parseStringValue().(i)
//                                           ^ reference scala/Int#`+`(+4).
//                                                ^ reference local42
//                                                  ^ reference scala/Int#`-`(+3).
//                                                    ^ reference ujson/CharParser#parseStringValue().(i)
//                                                      ^ reference scala/Int#`-`(+3).
//                                                            ^^^^^^^^^ reference ujson/CharParser#parseStringValue().(stackHead)
      k
//    ^ reference local42
    } else {
      val k2 = parseStringToOutputBuilder(i, k)
//        ^^ definition local43
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#parseStringToOutputBuilder().
//                                        ^ reference ujson/CharParser#parseStringValue().(i)
//                                           ^ reference local42
      visitString(i, outputBuilder.makeString(), stackHead)
//    ^^^^^^^^^^^ reference ujson/CharParser#visitString().
//                ^ reference ujson/CharParser#parseStringValue().(i)
//                   ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                                 ^^^^^^^^^^ reference upickle/core/CharBuilder#makeString().
//                                               ^^^^^^^^^ reference ujson/CharParser#parseStringValue().(stackHead)
      k2
//    ^^ reference local43
    }
  }

  protected[this] final def parseStringKey(i: Int, stackHead: ObjArrVisitor[_, J]): Int = {
//                          ^^^^^^^^^^^^^^ definition ujson/CharParser#parseStringKey().
//                                         ^ definition ujson/CharParser#parseStringKey().(i)
//                                            ^^^ reference scala/Int#
//                                                 ^^^^^^^^^ definition ujson/CharParser#parseStringKey().(stackHead)
//                                                            ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                             ^ reference ujson/CharParser#[J]
//                                                                                  ^^^ reference scala/Int#

    val k = parseStringSimple(i + 1)
//      ^ definition local44
//          ^^^^^^^^^^^^^^^^^ reference ujson/CharParser#parseStringSimple().
//                            ^ reference ujson/CharParser#parseStringKey().(i)
//                              ^ reference scala/Int#`+`(+4).
    if (k >= 0) {
//      ^ reference local44
//        ^^ reference scala/Int#`>=`(+3).
      visitStringKey(i, unsafeCharSeqForRange(i + 1, k - i - 2), stackHead)
//    ^^^^^^^^^^^^^^ reference ujson/CharParser#visitStringKey().
//                   ^ reference ujson/CharParser#parseStringKey().(i)
//                      ^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#unsafeCharSeqForRange().
//                                            ^ reference ujson/CharParser#parseStringKey().(i)
//                                              ^ reference scala/Int#`+`(+4).
//                                                   ^ reference local44
//                                                     ^ reference scala/Int#`-`(+3).
//                                                       ^ reference ujson/CharParser#parseStringKey().(i)
//                                                         ^ reference scala/Int#`-`(+3).
//                                                               ^^^^^^^^^ reference ujson/CharParser#parseStringKey().(stackHead)
      k
//    ^ reference local44
    } else {
      val k2 = parseStringToOutputBuilder(i, k)
//        ^^ definition local45
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#parseStringToOutputBuilder().
//                                        ^ reference ujson/CharParser#parseStringKey().(i)
//                                           ^ reference local44
      visitStringKey(i, outputBuilder.makeString(), stackHead)
//    ^^^^^^^^^^^^^^ reference ujson/CharParser#visitStringKey().
//                   ^ reference ujson/CharParser#parseStringKey().(i)
//                      ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                                    ^^^^^^^^^^ reference upickle/core/CharBuilder#makeString().
//                                                  ^^^^^^^^^ reference ujson/CharParser#parseStringKey().(stackHead)
      k2
//    ^^ reference local45
    }
  }


  def parseStringToOutputBuilder(i: Int, k: Int) = {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition ujson/CharParser#parseStringToOutputBuilder().
//                               ^ definition ujson/CharParser#parseStringToOutputBuilder().(i)
//                                  ^^^ reference scala/Int#
//                                       ^ definition ujson/CharParser#parseStringToOutputBuilder().(k)
//                                          ^^^ reference scala/Int#
    outputBuilder.reset()
//  ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                ^^^^^ reference upickle/core/CharBuilder#reset().
    appendCharsToBuilder(outputBuilder, i + 1, -k - 2 - i)
//  ^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#appendCharsToBuilder().
//                       ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                                      ^ reference ujson/CharParser#parseStringToOutputBuilder().(i)
//                                        ^ reference scala/Int#`+`(+4).
//                                             ^ reference scala/Int#`unary_-`().
//                                              ^ reference ujson/CharParser#parseStringToOutputBuilder().(k)
//                                                ^ reference scala/Int#`-`(+3).
//                                                    ^ reference scala/Int#`-`(+3).
//                                                      ^ reference ujson/CharParser#parseStringToOutputBuilder().(i)
    val k2 = parseStringComplex(-k - 1)
//      ^^ definition local46
//           ^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#parseStringComplex().
//                              ^ reference scala/Int#`unary_-`().
//                               ^ reference ujson/CharParser#parseStringToOutputBuilder().(k)
//                                 ^ reference scala/Int#`-`(+3).
    k2
//  ^^ reference local46
  }

  def visitString(i: Int, s: CharSequence, stackHead: ObjArrVisitor[_, J]) = {
//    ^^^^^^^^^^^ definition ujson/CharParser#visitString().
//                ^ definition ujson/CharParser#visitString().(i)
//                   ^^^ reference scala/Int#
//                        ^ definition ujson/CharParser#visitString().(s)
//                           ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                         ^^^^^^^^^ definition ujson/CharParser#visitString().(stackHead)
//                                                    ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                     ^ reference ujson/CharParser#[J]
    val v = stackHead.subVisitor.visitString(s, i)
//      ^ definition local47
//          ^^^^^^^^^ reference ujson/CharParser#visitString().(stackHead)
//                    ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
//                               ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                           ^ reference ujson/CharParser#visitString().(s)
//                                              ^ reference ujson/CharParser#visitString().(i)
    stackHead.narrow.visitValue(v, i)
//  ^^^^^^^^^ reference ujson/CharParser#visitString().(stackHead)
//            ^^^^^^ reference upickle/core/ObjArrVisitor#narrow().
//                   ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
//                              ^ reference local47
//                                 ^ reference ujson/CharParser#visitString().(i)
  }
  def visitStringKey(i: Int, s: CharSequence, stackHead: ObjArrVisitor[_, J]) = {
//    ^^^^^^^^^^^^^^ definition ujson/CharParser#visitStringKey().
//                   ^ definition ujson/CharParser#visitStringKey().(i)
//                      ^^^ reference scala/Int#
//                           ^ definition ujson/CharParser#visitStringKey().(s)
//                              ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                            ^^^^^^^^^ definition ujson/CharParser#visitStringKey().(stackHead)
//                                                       ^^^^^^^^^^^^^ reference upickle/core/ObjArrVisitor#
//                                                                        ^ reference ujson/CharParser#[J]
    val obj = stackHead.asInstanceOf[ObjVisitor[Any, _]]
//      ^^^ definition local48
//            ^^^^^^^^^ reference ujson/CharParser#visitStringKey().(stackHead)
//                      ^^^^^^^^^^^^ reference scala/Any#asInstanceOf().
//                                   ^^^^^^^^^^ reference upickle/core/ObjVisitor#
//                                              ^^^ reference scala/Any#
    val keyVisitor = obj.visitKey(i)
//      ^^^^^^^^^^ definition local49
//                   ^^^ reference local48
//                       ^^^^^^^^ reference upickle/core/ObjVisitor#visitKey().
//                                ^ reference ujson/CharParser#visitStringKey().(i)
    obj.visitKeyValue(keyVisitor.visitString(s, i))
//  ^^^ reference local48
//      ^^^^^^^^^^^^^ reference upickle/core/ObjVisitor#visitKeyValue().
//                    ^^^^^^^^^^ reference local49
//                               ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                           ^ reference ujson/CharParser#visitStringKey().(s)
//                                              ^ reference ujson/CharParser#visitStringKey().(i)
  }


  protected[this] final def parseStringTopLevel(i: Int, facade: Visitor[_, J]): (J, Int) = {
//                          ^^^^^^^^^^^^^^^^^^^ definition ujson/CharParser#parseStringTopLevel().
//                                              ^ definition ujson/CharParser#parseStringTopLevel().(i)
//                                                 ^^^ reference scala/Int#
//                                                      ^^^^^^ definition ujson/CharParser#parseStringTopLevel().(facade)
//                                                              ^^^^^^^ reference upickle/core/Visitor#
//                                                                         ^ reference ujson/CharParser#[J]
//                                                                               ^ reference ujson/CharParser#[J]
//                                                                                  ^^^ reference scala/Int#

    val k = parseStringSimple(i + 1)
//      ^ definition local50
//          ^^^^^^^^^^^^^^^^^ reference ujson/CharParser#parseStringSimple().
//                            ^ reference ujson/CharParser#parseStringTopLevel().(i)
//                              ^ reference scala/Int#`+`(+4).
    if (k >= 0) {
//      ^ reference local50
//        ^^ reference scala/Int#`>=`(+3).
      val res = facade.visitString(unsafeCharSeqForRange(i + 1, k - i - 2), i)
//        ^^^ definition local51
//              ^^^^^^ reference ujson/CharParser#parseStringTopLevel().(facade)
//                     ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                 ^^^^^^^^^^^^^^^^^^^^^ reference upickle/core/BufferingCharParser#unsafeCharSeqForRange().
//                                                       ^ reference ujson/CharParser#parseStringTopLevel().(i)
//                                                         ^ reference scala/Int#`+`(+4).
//                                                              ^ reference local50
//                                                                ^ reference scala/Int#`-`(+3).
//                                                                  ^ reference ujson/CharParser#parseStringTopLevel().(i)
//                                                                    ^ reference scala/Int#`-`(+3).
//                                                                          ^ reference ujson/CharParser#parseStringTopLevel().(i)
      (res, k)
//     ^^^ reference local51
//          ^ reference local50
    } else {
      val k2 = parseStringToOutputBuilder(i, k)
//        ^^ definition local52
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference ujson/CharParser#parseStringToOutputBuilder().
//                                        ^ reference ujson/CharParser#parseStringTopLevel().(i)
//                                           ^ reference local50
      val res = facade.visitString(outputBuilder.makeString(), i)
//        ^^^ definition local53
//              ^^^^^^ reference ujson/CharParser#parseStringTopLevel().(facade)
//                     ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                 ^^^^^^^^^^^^^ reference ujson/CharParser#outputBuilder.
//                                               ^^^^^^^^^^ reference upickle/core/CharBuilder#makeString().
//                                                             ^ reference ujson/CharParser#parseStringTopLevel().(i)
      (res, k2)
//     ^^^ reference local53
//          ^^ reference local52
    }
  }
}
