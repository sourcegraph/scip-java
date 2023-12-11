package ujson
//      ^^^^^ definition semanticdb maven . . ujson/
import java.io.StringWriter
//     ^^^^ reference semanticdb maven . . java/
//          ^^ reference semanticdb maven . . java/io/
//             ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/StringWriter#

import upickle.core.{Abort, AbortException, ObjArrVisitor, ObjVisitor, Visitor}
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                   ^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Abort#
//                   ^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Abort.
//                          ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/AbortException#
//                          ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/AbortException.
//                                          ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                         ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#
//                                                                     ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                     ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor.
import java.nio.charset.Charset
//     ^^^^ reference semanticdb maven . . java/
//          ^^^ reference semanticdb maven . . java/nio/
//              ^^^^^^^ reference semanticdb maven . . java/nio/charset/
//                      ^^^^^^^ reference semanticdb maven jdk 11 java/nio/charset/Charset#


import scala.annotation.{switch, tailrec}
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^^^ reference semanticdb maven . . scala/annotation/
//                       ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/annotation/switch#
//                               ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/annotation/tailrec#

/**
  * A specialized JSON parse that can parse Chars (Chars or Bytes), sending
  * method calls to the given [[upickle.core.Visitor]].
  *
  * Generally has a lot of tricks for performance: e.g. having duplicate
  * implementations for nested v.s. top-level parsing, using an `CharBuilder`
  * to construct the `CharSequences` that `visitString` requires, etc.
  */
abstract class CharParser[J] extends upickle.core.BufferingCharParser{
//             ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#
//                        display_name CharParser
//                        signature_documentation scala abstract class CharParser[J]
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                          display_name J
//                          signature_documentation scala J
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#`<init>`().
//                             display_name <init>
//                             signature_documentation scala def this()
//                                   ^^^^^^^ reference semanticdb maven . . upickle/
//                                           ^^^^ reference semanticdb maven . . upickle/core/
//                                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#
  private[this] val elemOps = upickle.core.CharOps
//                  ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                          display_name elemOps
//                          signature_documentation scala private[this] val elemOps: 
//                            ^^^^^^^ reference semanticdb maven . . upickle/
//                                    ^^^^ reference semanticdb maven . . upickle/core/
//                                         ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.
  private[this] val outputBuilder = new upickle.core.CharBuilder()
//                  ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                display_name outputBuilder
//                                signature_documentation scala private[this] val outputBuilder: CharBuilder
//                                      ^^^^^^^ reference semanticdb maven . . upickle/
//                                              ^^^^ reference semanticdb maven . . upickle/core/
//                                                   ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#
//                                                              ^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#`<init>`().

  def requestUntilOrThrow(i: Int) = {
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#requestUntilOrThrow().
//                        display_name requestUntilOrThrow
//                        signature_documentation scala def requestUntilOrThrow(i: Int): Unit
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#requestUntilOrThrow().(i)
//                          display_name i
//                          signature_documentation scala i: Int 
//                           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    if (requestUntil(i)) throw new IncompleteParseException("exhausted input")
//      ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#requestUntil().
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#requestUntilOrThrow().(i)
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#`<init>`().
  }
  override def getCharSafe(i: Int): Char = {
//             ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                         display_name getCharSafe
//                         signature_documentation scala def getCharSafe(i: Int): Char
//                         relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharSafe().
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().(i)
//                           display_name i
//                           signature_documentation scala i: Int 
//                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#
    requestUntilOrThrow(i)
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#requestUntilOrThrow().
//                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().(i)
    getCharUnsafe(i)
//  ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharUnsafe().
//                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().(i)
  }

  /**
   * Return true iff 'i' is at or beyond the end of the input (EOF).
   */
  protected[this] def atEof(i: Int) = requestUntil(i)
//                    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#atEof().
//                          display_name atEof
//                          signature_documentation scala def atEof(i: Int): Boolean
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#atEof().(i)
//                            display_name i
//                            signature_documentation scala i: Int 
//                             ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#requestUntil().
//                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#atEof().(i)

  /**
   * Should be called when parsing is finished.
   */
  protected[this] def close(): Unit
//                    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#close().
//                          display_name close
//                          signature_documentation scala def close(): Unit
//                          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser#close().
//                          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser#close().
//                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#

  /**
   * Valid parser states.
   */
  @inline private[this] final val ARRBEG = 6
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARRBEG.
//                                       display_name ARRBEG
//                                       signature_documentation scala @inline\nprivate[this] final val ARRBEG: 6
  @inline private[this] final val OBJBEG = 7
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJBEG.
//                                       display_name OBJBEG
//                                       signature_documentation scala @inline\nprivate[this] final val OBJBEG: 7
  @inline private[this] final val DATA = 1
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#DATA.
//                                     display_name DATA
//                                     signature_documentation scala @inline\nprivate[this] final val DATA: 1
  @inline private[this] final val KEY = 2
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#KEY.
//                                    display_name KEY
//                                    signature_documentation scala @inline\nprivate[this] final val KEY: 2
  @inline private[this] final val COLON = 3
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#COLON.
//                                      display_name COLON
//                                      signature_documentation scala @inline\nprivate[this] final val COLON: 3
  @inline private[this] final val ARREND = 4
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARREND.
//                                       display_name ARREND
//                                       signature_documentation scala @inline\nprivate[this] final val ARREND: 4
  @inline private[this] final val OBJEND = 5
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJEND.
//                                       display_name OBJEND
//                                       signature_documentation scala @inline\nprivate[this] final val OBJEND: 5

  /**
    * Parse the JSON document into a single JSON value.
    *
    * The parser considers documents like '333', 'true', and '"foo"' to be
    * valid, as well as more traditional documents like [1,2,3,4,5]. However,
    * multiple top-level objects are not allowed.
    */
  final def parse(facade: Visitor[_, J]): J = {
//          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parse().
//                display_name parse
//                signature_documentation scala final def parse(facade: Visitor[local0, J[): J
//                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parse().(facade)
//                       display_name facade
//                       signature_documentation scala facade: Visitor[local0, J[ 
//                        ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
    val (value, i) = parseTopLevel(0, facade)
//       ^^^^^ definition local 2
//             display_name value
//             signature_documentation scala value: J 
//              ^ definition local 3
//                display_name i
//                signature_documentation scala i: Int 
//                   ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel().
//                                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parse().(facade)
    var j = i
//      ^ definition local 4
//        display_name j
//        signature_documentation scala j: Int 
//          ^ reference local 3
    while (!atEof(j)) {
//         ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`unary_!`().
//          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#atEof().
//                ^ reference local 4
      (getCharSafe(j): @switch) match {
//     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                 ^ reference local 4
        case '\n' | ' ' | '\t' | '\r' => j += 1
//                                       ^ reference local 4
//                                         ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
        case _ => die(j, "expected whitespace or eof")
//                ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                    ^ reference local 4
      }
    }
    if (!atEof(j)) die(j, "expected eof")
//      ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`unary_!`().
//       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#atEof().
//             ^ reference local 4
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                     ^ reference local 4
    close()
//  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#close().
    value
//  ^^^^^ reference local 2
  }

  /**
   * Used to generate error messages with character info and offsets.
   */
  protected[this] def die(i: Int, msg: String): Nothing = {
//                    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                        display_name die
//                        signature_documentation scala def die(i: Int, msg: String): Nothing
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().(i)
//                          display_name i
//                          signature_documentation scala i: Int 
//                           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().(msg)
//                                    display_name msg
//                                    signature_documentation scala msg: String 
//                                     ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                              ^^^^^^^ reference semanticdb maven . . scala/Nothing#
    val out = new upickle.core.CharBuilder()
//      ^^^ definition local 6
//          display_name out
//          signature_documentation scala out: CharBuilder 
//                ^^^^^^^ reference semanticdb maven . . upickle/
//                        ^^^^ reference semanticdb maven . . upickle/core/
//                             ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#
//                                        ^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#`<init>`().
    upickle.core.RenderUtils.escapeChar(
//  ^^^^^^^ reference semanticdb maven . . upickle/
//          ^^^^ reference semanticdb maven . . upickle/core/
//               ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.
//                           ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.escapeChar().
      new upickle.core.CharBuilder(),
//        ^^^^^^^ reference semanticdb maven . . upickle/
//                ^^^^ reference semanticdb maven . . upickle/core/
//                     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#
//                                ^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#`<init>`().
      out,
//    ^^^ reference local 6
      new ArrayCharSequence(Array(elemOps.toInt(getCharSafe(i)).toChar)),
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.ArrayCharSequence#
//                         ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.ArrayCharSequence#`<init>`().
//                          ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Array.
//                                ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                                        ^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.toInt().
//                                              ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().(i)
//                                                              ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#toChar().
      unicode = false
//    ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.escapeChar().(unicode)
    )
    val s = "%s got %s" format (msg, out.makeString())
//      ^ definition local 7
//        display_name s
//        signature_documentation scala s: String 
//                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/StringOps#format().
//                              ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().(msg)
//                                   ^^^ reference local 6
//                                       ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#makeString().
    throw ParseException(s, i)
//        ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ParseException.
//                       ^ reference local 7
//                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().(i)
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
//                          ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().
//                                   display_name parseNum
//                                   signature_documentation scala final def parseNum(i: Int, ctxt: ObjArrVisitor[Any, J], facade: Visitor[local8, J[): Int
//                                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(i)
//                                     display_name i
//                                     signature_documentation scala i: Int 
//                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                           ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(ctxt)
//                                                display_name ctxt
//                                                signature_documentation scala ctxt: ObjArrVisitor[Any, J] 
//                                                 ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                               ^^^ reference semanticdb maven . . scala/Any#
//                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(facade)
//                                                                               display_name facade
//                                                                               signature_documentation scala facade: Visitor[local8, J[ 
//                                                                                ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    var j = i
//      ^ definition local 9
//        display_name j
//        signature_documentation scala j: Int 
//          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(i)
    var c = getCharSafe(j)
//      ^ definition local 10
//        display_name c
//        signature_documentation scala c: Char 
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                      ^ reference local 9
    var decIndex = -1
//      ^^^^^^^^ definition local 11
//               display_name decIndex
//               signature_documentation scala decIndex: Int 
    var expIndex = -1
//      ^^^^^^^^ definition local 12
//               display_name expIndex
//               signature_documentation scala expIndex: Int 

    if (c == '-') {
//      ^ reference local 10
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
      j += 1
//    ^ reference local 9
//      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local 10
//        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                    ^ reference local 9
    }
    if (c == '0') {
//      ^ reference local 10
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
      j += 1
//    ^ reference local 9
//      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local 10
//        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                    ^ reference local 9
    } else {
      val j0 = j
//        ^^ definition local 13
//           display_name j0
//           signature_documentation scala j0: Int 
//             ^ reference local 9
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.within().
//                               ^ reference local 10
        j += 1;
//      ^ reference local 9
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
        c = getCharSafe(j)
//      ^ reference local 10
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                      ^ reference local 9
      }
      if (j == j0) die(i, "expected digit")
//        ^ reference local 9
//          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`==`(+3).
//             ^^ reference local 13
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(i)
    }

    if (c == '.') {
//      ^ reference local 10
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
      decIndex = j - i
//    ^^^^^^^^ reference local 11
//               ^ reference local 9
//                 ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(i)
      j += 1
//    ^ reference local 9
//      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local 10
//        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                    ^ reference local 9
      val j0 = j
//        ^^ definition local 15
//           display_name j0
//           signature_documentation scala j0: Int 
//             ^ reference local 9
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.within().
//                               ^ reference local 10
        j += 1
//      ^ reference local 9
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
        c = getCharSafe(j)
//      ^ reference local 10
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                      ^ reference local 9
      }
      if (j0 == j) die(i, "expected digit")
//        ^^ reference local 15
//           ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`==`(+3).
//              ^ reference local 9
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(i)
    }

    if (c == 'e' || c == 'E') {
//      ^ reference local 10
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
//               ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`||`().
//                  ^ reference local 10
//                    ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
      expIndex = j - i
//    ^^^^^^^^ reference local 12
//               ^ reference local 9
//                 ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(i)
      j += 1
//    ^ reference local 9
//      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local 10
//        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                    ^ reference local 9
      if (c == '+' || c == '-') {
//        ^ reference local 10
//          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
//                 ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`||`().
//                    ^ reference local 10
//                      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
        j += 1
//      ^ reference local 9
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
        c = getCharSafe(j)
//      ^ reference local 10
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                      ^ reference local 9
      }
      val j0 = j
//        ^^ definition local 17
//           display_name j0
//           signature_documentation scala j0: Int 
//             ^ reference local 9
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.within().
//                               ^ reference local 10
        j += 1
//      ^ reference local 9
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
        c = getCharSafe(j)
//      ^ reference local 10
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                      ^ reference local 9
      }
      if (j0 == j)  die(i, "expected digit")
//        ^^ reference local 17
//           ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`==`(+3).
//              ^ reference local 9
//                  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(i)
    }

    ctxt.visitValue(visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), i)
//  ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(ctxt)
//       ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                                     ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(facade)
//                                                             ^^^^^^^^ reference local 11
//                                                                       ^^^^^^^^ reference local 12
//                                                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(i)
//                                                                                    ^ reference local 9
//                                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(i)
    j
//  ^ reference local 9
  }

  def visitFloat64StringPartsWithWrapper(facade: Visitor[_, J],
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                       display_name visitFloat64StringPartsWithWrapper
//                                       signature_documentation scala def visitFloat64StringPartsWithWrapper(facade: Visitor[local19, J[, decIndex: Int, expIndex: Int, i: Int, j: Int): J
//                                       ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(facade)
//                                              display_name facade
//                                              signature_documentation scala facade: Visitor[local19, J[ 
//                                               ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
                                         decIndex: Int,
//                                       ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(decIndex)
//                                                display_name decIndex
//                                                signature_documentation scala decIndex: Int 
//                                                 ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                                         expIndex: Int,
//                                       ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(expIndex)
//                                                display_name expIndex
//                                                signature_documentation scala expIndex: Int 
//                                                 ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                                         i: Int,
//                                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(i)
//                                         display_name i
//                                         signature_documentation scala i: Int 
//                                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                                         j: Int) = {
//                                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(j)
//                                         display_name j
//                                         signature_documentation scala j: Int 
//                                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    facade.visitFloat64StringParts(
//  ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(facade)
//         ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64StringParts().
      unsafeCharSeqForRange(i, j - i),
//    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#unsafeCharSeqForRange().
//                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(i)
//                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(j)
//                               ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(i)
      decIndex,
//    ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(decIndex)
      expIndex,
//    ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(expIndex)
      i
//    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(i)
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
//                          ^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().
//                                           display_name parseNumTopLevel
//                                           signature_documentation scala final def parseNumTopLevel(i: Int, facade: Visitor[local20, J[): (J, Int)
//                                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
//                                             display_name i
//                                             signature_documentation scala i: Int 
//                                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                   ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(facade)
//                                                          display_name facade
//                                                          signature_documentation scala facade: Visitor[local20, J[ 
//                                                           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    var j = i
//      ^ definition local 21
//        display_name j
//        signature_documentation scala j: Int 
//          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
    var c = getCharSafe(j)
//      ^ definition local 22
//        display_name c
//        signature_documentation scala c: Char 
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                      ^ reference local 21
    var decIndex = -1
//      ^^^^^^^^ definition local 23
//               display_name decIndex
//               signature_documentation scala decIndex: Int 
    var expIndex = -1
//      ^^^^^^^^ definition local 24
//               display_name expIndex
//               signature_documentation scala expIndex: Int 

    if (c == '-') {
//      ^ reference local 22
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
      // any valid input will require at least one digit after -
      j += 1
//    ^ reference local 21
//      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local 22
//        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                    ^ reference local 21
    }
    if (c == '0') {
//      ^ reference local 22
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
      j += 1
//    ^ reference local 21
//      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      if (atEof(j)) {
//        ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#atEof().
//              ^ reference local 21
        return (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                                 ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(facade)
//                                                         ^^^^^^^^ reference local 23
//                                                                   ^^^^^^^^ reference local 24
//                                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
//                                                                                ^ reference local 21
//                                                                                    ^ reference local 21
      }
      c = getCharSafe(j)
//    ^ reference local 22
//        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                    ^ reference local 21
    } else {
      val j0 = j
//        ^^ definition local 25
//           display_name j0
//           signature_documentation scala j0: Int 
//             ^ reference local 21
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.within().
//                               ^ reference local 22
        j += 1
//      ^ reference local 21
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
        if (atEof(j)) {
//          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#atEof().
//                ^ reference local 21
          return (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(facade)
//                                                           ^^^^^^^^ reference local 23
//                                                                     ^^^^^^^^ reference local 24
//                                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
//                                                                                  ^ reference local 21
//                                                                                      ^ reference local 21
        }
        c = getCharSafe(j)
//      ^ reference local 22
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                      ^ reference local 21
      }
      if (j0 == j) die(i, "expected digit")
//        ^^ reference local 25
//           ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`==`(+3).
//              ^ reference local 21
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
    }

    if (c == '.') {
//      ^ reference local 22
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
      // any valid input will require at least one digit after .
      decIndex = j - i
//    ^^^^^^^^ reference local 23
//               ^ reference local 21
//                 ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
      j += 1
//    ^ reference local 21
//      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local 22
//        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                    ^ reference local 21
      val j0 = j
//        ^^ definition local 27
//           display_name j0
//           signature_documentation scala j0: Int 
//             ^ reference local 21
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.within().
//                               ^ reference local 22
        j += 1
//      ^ reference local 21
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
        if (atEof(j)) {
//          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#atEof().
//                ^ reference local 21
          return (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(facade)
//                                                           ^^^^^^^^ reference local 23
//                                                                     ^^^^^^^^ reference local 24
//                                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
//                                                                                  ^ reference local 21
//                                                                                      ^ reference local 21
        }
        c = getCharSafe(j)
//      ^ reference local 22
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                      ^ reference local 21
      }
      if(j0 == j) die(i, "expected digit")
//       ^^ reference local 27
//          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`==`(+3).
//             ^ reference local 21
//                ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
    }

    if (c == 'e' || c == 'E') {
//      ^ reference local 22
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
//               ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`||`().
//                  ^ reference local 22
//                    ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
      // any valid input will require at least one digit after e, e+, etc
      expIndex = j - i
//    ^^^^^^^^ reference local 24
//               ^ reference local 21
//                 ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
      j += 1
//    ^ reference local 21
//      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      c = getCharSafe(j)
//    ^ reference local 22
//        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                    ^ reference local 21
      if (c == '+' || c == '-') {
//        ^ reference local 22
//          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
//                 ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`||`().
//                    ^ reference local 22
//                      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
        j += 1
//      ^ reference local 21
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
        c = getCharSafe(j)
//      ^ reference local 22
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                      ^ reference local 21
      }
      val j0 = j
//        ^^ definition local 29
//           display_name j0
//           signature_documentation scala j0: Int 
//             ^ reference local 21
      while (elemOps.within('0', c, '9')) {
//           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.within().
//                               ^ reference local 22
        j += 1
//      ^ reference local 21
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
        if (atEof(j)) {
//          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#atEof().
//                ^ reference local 21
          return (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(facade)
//                                                           ^^^^^^^^ reference local 23
//                                                                     ^^^^^^^^ reference local 24
//                                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
//                                                                                  ^ reference local 21
//                                                                                      ^ reference local 21
        }
        c = getCharSafe(j)
//      ^ reference local 22
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                      ^ reference local 21
      }
      if (j0 == j) die(i, "expected digit")
//        ^^ reference local 29
//           ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`==`(+3).
//              ^ reference local 21
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
    }

    (visitFloat64StringPartsWithWrapper(facade, decIndex, expIndex, i, j), j)
//   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().
//                                      ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(facade)
//                                              ^^^^^^^^ reference local 23
//                                                        ^^^^^^^^ reference local 24
//                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
//                                                                     ^ reference local 21
//                                                                         ^ reference local 21
  }

  /**
   * Generate a Char from the hex digits of "\u1234" (i.e. "1234").
   *
   * NOTE: This is only capable of generating characters from the basic plane.
   * This is why it can only return Char instead of Int.
   */
  protected[this] final def descape(i: Int): Char = {
//                          ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#descape().
//                                  display_name descape
//                                  signature_documentation scala final def descape(i: Int): Char
//                                  ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#descape().(i)
//                                    display_name i
//                                    signature_documentation scala i: Int 
//                                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                           ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#
    import upickle.core.RenderUtils.hex
//         ^^^^^^^ reference semanticdb maven . . upickle/
//                 ^^^^ reference semanticdb maven . . upickle/core/
//                      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.
//                                  ^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.hex().
    var x = 0
//      ^ definition local 31
//        display_name x
//        signature_documentation scala x: Int 
    x = (x << 4) | hex(getCharSafe(i+2).toInt)
//  ^ reference local 31
//       ^ reference local 31
//         ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`<<`().
//               ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`|`(+3).
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.hex().
//                     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#descape().(i)
//                                  ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                      ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#toInt().
    x = (x << 4) | hex(getCharSafe(i+3).toInt)
//  ^ reference local 31
//       ^ reference local 31
//         ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`<<`().
//               ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`|`(+3).
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.hex().
//                     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#descape().(i)
//                                  ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                      ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#toInt().
    x = (x << 4) | hex(getCharSafe(i+4).toInt)
//  ^ reference local 31
//       ^ reference local 31
//         ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`<<`().
//               ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`|`(+3).
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.hex().
//                     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#descape().(i)
//                                  ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                      ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#toInt().
    x = (x << 4) | hex(getCharSafe(i+5).toInt)
//  ^ reference local 31
//       ^ reference local 31
//         ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`<<`().
//               ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`|`(+3).
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.hex().
//                     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#descape().(i)
//                                  ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                      ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#toInt().
    x.toChar
//  ^ reference local 31
//    ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#toChar().
  }


  /**
   * Parse the JSON constant "true".
   *
   * Note that this method assumes that the first character has already been checked.
   */
  protected[this] final def parseTrue(i: Int, facade: Visitor[_, J]): J = {
//                          ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().
//                                    display_name parseTrue
//                                    signature_documentation scala final def parseTrue(i: Int, facade: Visitor[local32, J[): J
//                                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().(i)
//                                      display_name i
//                                      signature_documentation scala i: Int 
//                                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                            ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().(facade)
//                                                   display_name facade
//                                                   signature_documentation scala facade: Visitor[local32, J[ 
//                                                    ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
    requestUntilOrThrow(i + 3)
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#requestUntilOrThrow().
//                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().(i)
//                        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
    if (getCharUnsafe(i + 1) == 'r' && getCharUnsafe(i + 2) == 'u' && getCharUnsafe(i + 3) == 'e') {
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharUnsafe().
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().(i)
//                      ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                           ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
//                                  ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`&&`().
//                                     ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharUnsafe().
//                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().(i)
//                                                     ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
//                                                                 ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`&&`().
//                                                                    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharUnsafe().
//                                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().(i)
//                                                                                    ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                                                         ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
      facade.visitTrue(i)
//    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().(facade)
//           ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitTrue().
//                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().(i)
    } else {
      die(i, "expected true")
//    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().(i)
    }
  }

  /**
   * Parse the JSON constant "false".
   *
   * Note that this method assumes that the first character has already been checked.
   */
  protected[this] final def parseFalse(i: Int, facade: Visitor[_, J]): J = {
//                          ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().
//                                     display_name parseFalse
//                                     signature_documentation scala final def parseFalse(i: Int, facade: Visitor[local33, J[): J
//                                     ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().(i)
//                                       display_name i
//                                       signature_documentation scala i: Int 
//                                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                             ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().(facade)
//                                                    display_name facade
//                                                    signature_documentation scala facade: Visitor[local33, J[ 
//                                                     ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
    requestUntilOrThrow(i + 4)
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#requestUntilOrThrow().
//                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().(i)
//                        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).

    if (getCharUnsafe(i + 1) == 'a' && getCharUnsafe(i + 2) == 'l' && getCharUnsafe(i + 3) == 's' && getCharUnsafe(i + 4) == 'e') {
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharUnsafe().
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().(i)
//                      ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                           ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
//                                  ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`&&`().
//                                     ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharUnsafe().
//                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().(i)
//                                                     ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
//                                                                 ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`&&`().
//                                                                    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharUnsafe().
//                                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().(i)
//                                                                                    ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                                                         ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
//                                                                                                ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`&&`().
//                                                                                                   ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharUnsafe().
//                                                                                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().(i)
//                                                                                                                   ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                                                                                        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
      facade.visitFalse(i)
//    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().(facade)
//           ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFalse().
//                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().(i)
    } else {
      die(i, "expected false")
//    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().(i)
    }
  }

  /**
   * Parse the JSON constant "null".
   *
   * Note that this method assumes that the first character has already been checked.
   */
  protected[this] final def parseNull(i: Int, facade: Visitor[_, J]): J = {
//                          ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().
//                                    display_name parseNull
//                                    signature_documentation scala final def parseNull(i: Int, facade: Visitor[local34, J[): J
//                                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().(i)
//                                      display_name i
//                                      signature_documentation scala i: Int 
//                                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                            ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().(facade)
//                                                   display_name facade
//                                                   signature_documentation scala facade: Visitor[local34, J[ 
//                                                    ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
    requestUntilOrThrow(i + 3)
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#requestUntilOrThrow().
//                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().(i)
//                        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
    if (getCharUnsafe(i + 1) == 'u' && getCharUnsafe(i + 2) == 'l' && getCharUnsafe(i + 3) == 'l') {
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharUnsafe().
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().(i)
//                      ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                           ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
//                                  ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`&&`().
//                                     ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharUnsafe().
//                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().(i)
//                                                     ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
//                                                                 ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`&&`().
//                                                                    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharUnsafe().
//                                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().(i)
//                                                                                    ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                                                         ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#`==`(+2).
      facade.visitNull(i)
//    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().(facade)
//           ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitNull().
//                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().(i)
    } else {
      die(i, "expected null")
//    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().(i)
    }
  }

  protected[this] final def parseTopLevel(i: Int, facade: Visitor[_, J]): (J, Int) = {
//                          ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel().
//                                        display_name parseTopLevel
//                                        signature_documentation scala final def parseTopLevel(i: Int, facade: Visitor[local35, J[): (J, Int)
//                                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel().(i)
//                                          display_name i
//                                          signature_documentation scala i: Int 
//                                           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel().(facade)
//                                                       display_name facade
//                                                       signature_documentation scala facade: Visitor[local35, J[ 
//                                                        ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    try parseTopLevel0(i, facade)
//      ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().
//                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel().(i)
//                        ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel().(facade)
    catch reject(i)
//        ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().
//               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel().(i)
  }
  /**
   * Parse and return the next JSON value and the position beyond it.
   */
  @tailrec
// ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/annotation/tailrec#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/annotation/tailrec#`<init>`().
  protected[this] final def parseTopLevel0(i: Int, facade: Visitor[_, J]): (J, Int) = {
//                          ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().
//                                         display_name parseTopLevel0
//                                         signature_documentation scala @tailrec\nfinal def parseTopLevel0(i: Int, facade: Visitor[local38, J[): (J, Int)
//                                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                           display_name i
//                                           signature_documentation scala i: Int 
//                                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                 ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(facade)
//                                                        display_name facade
//                                                        signature_documentation scala facade: Visitor[local38, J[ 
//                                                         ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                             ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    (getCharSafe(i): @switch) match {
//   ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
      // ignore whitespace
      case ' ' | '\t' | 'r' => parseTopLevel0(i + 1, facade)
//                             ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                              ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(facade)
      case '\n' => parseTopLevel0(i + 1, facade)
//                 ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().
//                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                  ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                       ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(facade)

      // if we have a recursive top-level structure, we'll delegate the parsing
      // duties to our good friend rparse().
      case '[' => parseNested(ARRBEG, i + 1, facade.visitArray(-1, i), Nil)
//                ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                            ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARRBEG.
//                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                      ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                           ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(facade)
//                                                  ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//                                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                                                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.Nil.
      case '{' => parseNested(OBJBEG, i + 1, facade.visitObject(-1, i), Nil)
//                ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                            ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJBEG.
//                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                      ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                           ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(facade)
//                                                  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitObject().
//                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.Nil.

      // we have a single top-level number
      case '-' | '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' => parseNumTopLevel(i, facade)
//                                                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().
//                                                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                                                                                ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(facade)

      // we have a single top-level string
      case '"' => parseStringTopLevel(i, facade)
//                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().
//                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                       ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(facade)

      // we have a single top-level constant
      case 't' => (parseTrue(i, facade), i + 4)
//                 ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().
//                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(facade)
//                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                         ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      case 'f' => (parseFalse(i, facade), i + 5)
//                 ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().
//                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                               ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(facade)
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                          ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      case 'n' => (parseNull(i, facade), i + 4)
//                 ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().
//                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(facade)
//                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                         ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).

      // invalid
      case _ => die(i, "expected json value")
//              ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
    }
  }

  def reject(j: Int): PartialFunction[Throwable, Nothing] = {
//    ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().
//           display_name reject
//           signature_documentation scala def reject(j: Int): PartialFunction[Throwable, Nothing]
//           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().(j)
//             display_name j
//             signature_documentation scala j: Int 
//              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/PartialFunction#
//                                    ^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.Throwable#
//                                               ^^^^^^^ reference semanticdb maven . . scala/Nothing#
//                                                          ^ definition local 39
//                                                            display_name $anonfun
//                                                            signature_documentation scala @SerialVersionUID\nfinal class $anonfun
    case e: Abort =>
//       ^ definition local 46
//         display_name e
//         signature_documentation scala e: Abort 
//          ^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Abort#
      throw new AbortException(e.msg, j, -1, -1, e)
//              ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/AbortException#
//                            ^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/AbortException#`<init>`().
//                             ^ reference local 46
//                               ^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Abort#msg.
//                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().(j)
//                                               ^ reference local 46
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
// ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/annotation/tailrec#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/annotation/tailrec#`<init>`().
  protected[this] final def parseNested(state: Int,
//                          ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                                      display_name parseNested
//                                      signature_documentation scala @tailrec\nfinal def parseNested(state: Int, i: Int, stackHead: ObjArrVisitor[local50, J[, stackTail: List[ObjArrVisitor[local51, J[]): (J, Int)
//                                      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
//                                            display_name state
//                                            signature_documentation scala state: Int 
//                                             ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                                        i: Int,
//                                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                        display_name i
//                                        signature_documentation scala i: Int 
//                                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                                        stackHead: ObjArrVisitor[_, J],
//                                      ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                display_name stackHead
//                                                signature_documentation scala stackHead: ObjArrVisitor[local50, J[ 
//                                                 ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
                                        stackTail: List[ObjArrVisitor[_, J]]) : (J, Int) = {
//                                      ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)
//                                                display_name stackTail
//                                                signature_documentation scala stackTail: List[ObjArrVisitor[local51, J[] 
//                                                 ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.List#
//                                                      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    (getCharSafe(i): @switch) match{
//   ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
      case ' ' | '\t' | '\r' | '\n' =>
        parseNested(state, i + 1, stackHead, stackTail)
//      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
//                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                           ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)

      case '"' =>
        state match{
//      ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
          case KEY | OBJBEG =>
//             ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#KEY.
//                   ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJBEG.
            val nextJ = try parseStringKey(i, stackHead) catch reject(i)
//              ^^^^^ definition local 52
//                    display_name nextJ
//                    signature_documentation scala nextJ: Int 
//                          ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                            ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                             ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().
//                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
            parseNested(COLON, nextJ, stackHead, stackTail)
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                      ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#COLON.
//                             ^^^^^ reference local 52
//                                    ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                               ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)

          case DATA | ARRBEG =>
//             ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#DATA.
//                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARRBEG.
            val nextJ = try parseStringValue(i, stackHead) catch reject(i)
//              ^^^^^ definition local 55
//                    display_name nextJ
//                    signature_documentation scala nextJ: Int 
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().
//                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                              ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                               ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().
//                                                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
            parseNested(collectionEndFor(stackHead), nextJ, stackHead, stackTail)
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#collectionEndFor().
//                                       ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                   ^^^^^ reference local 55
//                                                          ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                                     ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)

          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
        }

      case ':' =>
        // we are in an object just after a key, expecting to see a colon.
        state match{
//      ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
          case COLON => parseNested(DATA, i + 1, stackHead, stackTail)
//             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#COLON.
//                      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                                  ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#DATA.
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                          ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                               ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                          ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)
          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
        }

      case '[' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().
//                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
//                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        val ctx =
//          ^^^ definition local 58
//              display_name ctx
//              signature_documentation scala ctx: ArrVisitor[local59, J[ 
          try stackHead.subVisitor.asInstanceOf[Visitor[_, J]].visitArray(-1, i)
//            ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                      ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                                 ^^^^^^^^^^^^ reference semanticdb maven . . scala/Any#asInstanceOf().
//                                              ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                             ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//                                                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
          catch reject(i)
//              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().
//                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        parseNested(ARRBEG, i + 1, ctx, stackHead :: stackTail)
//      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                  ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARRBEG.
//                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                            ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                 ^^^ reference local 58
//                                      ^^^^^^^^^ reference local 62
//                                                ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/immutable/List#`::`().
//                                                   ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)

      case '{' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().
//                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
//                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        val ctx =
//          ^^^ definition local 63
//              display_name ctx
//              signature_documentation scala ctx: ObjVisitor[local64, J[ 
          try stackHead.subVisitor.asInstanceOf[Visitor[_, J]].visitObject(-1, i)
//            ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                      ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                                 ^^^^^^^^^^^^ reference semanticdb maven . . scala/Any#asInstanceOf().
//                                              ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                             ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitObject().
//                                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
          catch reject(i)
//              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().
//                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        parseNested(OBJBEG, i + 1, ctx, stackHead :: stackTail)
//      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                  ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJBEG.
//                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                            ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                 ^^^ reference local 63
//                                      ^^^^^^^^^ reference local 67
//                                                ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/immutable/List#`::`().
//                                                   ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)

      case '-' | '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().
//                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
//                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        val ctx =
//          ^^^ definition local 68
//              display_name ctx
//              signature_documentation scala ctx: Int 
          try parseNum(i, stackHead.narrow, stackHead.subVisitor.asInstanceOf[Visitor[_, J]])
//            ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().
//                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                        ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                  ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#narrow().
//                                          ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                    ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . scala/Any#asInstanceOf().
//                                                                            ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
          catch reject(i)
//              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().
//                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        parseNested(collectionEndFor(stackHead), ctx, stackHead, stackTail)
//      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#collectionEndFor().
//                                   ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                               ^^^ reference local 68
//                                                    ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                               ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)

      case 't' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().
//                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
//                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        try stackHead.narrow.visitValue(
//          ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#narrow().
//                           ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
          parseTrue(i, stackHead.subVisitor.asInstanceOf[Visitor[_, J]]),
//        ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().
//                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                     ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                               ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                                          ^^^^^^^^^^^^ reference semanticdb maven . . scala/Any#asInstanceOf().
//                                                       ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
          i
//        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        )
        catch reject(i)
//            ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        parseNested(collectionEndFor(stackHead), i + 4, stackHead, stackTail)
//      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#collectionEndFor().
//                                   ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                                 ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                      ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                                 ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)

      case 'f' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().
//                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
//                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        try stackHead.narrow.visitValue(
//          ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#narrow().
//                           ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
          parseFalse(i, stackHead.subVisitor.asInstanceOf[Visitor[_, J]]),
//        ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                      ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . scala/Any#asInstanceOf().
//                                                        ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
          i
//        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        )
        catch reject(i)
//            ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        parseNested(collectionEndFor(stackHead), i + 5, stackHead, stackTail)
//      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#collectionEndFor().
//                                   ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                                 ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                      ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                                 ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)

      case 'n' =>
        failIfNotData(state, i)
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().
//                    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
//                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        try stackHead.narrow.visitValue(
//          ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#narrow().
//                           ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
          parseNull(i, stackHead.subVisitor.asInstanceOf[Visitor[_, J]]),
//        ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().
//                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                     ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                               ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                                          ^^^^^^^^^^^^ reference semanticdb maven . . scala/Any#asInstanceOf().
//                                                       ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
          i
//        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        )
        catch reject(i)
//            ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        parseNested(collectionEndFor(stackHead), i + 4, stackHead, stackTail)
//      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#collectionEndFor().
//                                   ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                                 ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                      ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                                 ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)

      case ',' =>
        dropBufferUntil(i)
//      ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#dropBufferUntil().
//                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
        (state: @switch) match{
//       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
          case ARREND => parseNested(DATA, i + 1, stackHead, stackTail)
//             ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARREND.
//                       ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                                   ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#DATA.
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                           ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)
          case OBJEND => parseNested(KEY, i + 1, stackHead, stackTail)
//             ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJEND.
//                       ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                                   ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#KEY.
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                          ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                               ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                          ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)
          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
        }

      case ']' =>
        (state: @switch) match{
//       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
          case ARREND | ARRBEG =>
//             ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARREND.
//                      ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARRBEG.
            tryCloseCollection(stackHead, stackTail, i) match{
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().
//                             ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                        ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)
//                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
              case Some(t) => t
//                 ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Some.
//                      ^ definition local 77
//                        display_name t
//                        signature_documentation scala t: (J, Int) 
//                            ^ reference local 77
              case None =>
//                 ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/None.
                val stackTailHead = stackTail.head
//                  ^^^^^^^^^^^^^ definition local 78
//                                display_name stackTailHead
//                                signature_documentation scala stackTailHead: ObjArrVisitor[local51, J[ 
//                                  ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)
//                                            ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOps#head().
                parseNested(collectionEndFor(stackTailHead), i + 1, stackTailHead, stackTail.tail)
//              ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#collectionEndFor().
//                                           ^^^^^^^^^^^^^ reference local 78
//                                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                                             ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                                  ^^^^^^^^^^^^^ reference local 78
//                                                                                 ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)
//                                                                                           ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOps#tail().
            }
          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
        }

      case '}' =>
        (state: @switch) match{
//       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
          case OBJEND | OBJBEG =>
//             ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJEND.
//                      ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJBEG.
            tryCloseCollection(stackHead, stackTail, i) match{
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().
//                             ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                        ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)
//                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
              case Some(t) => t
//                 ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Some.
//                      ^ definition local 79
//                        display_name t
//                        signature_documentation scala t: (J, Int) 
//                            ^ reference local 79
              case None =>
//                 ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/None.
                val stackTailHead = stackTail.head
//                  ^^^^^^^^^^^^^ definition local 80
//                                display_name stackTailHead
//                                signature_documentation scala stackTailHead: ObjArrVisitor[local51, J[ 
//                                  ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)
//                                            ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOps#head().
                parseNested(collectionEndFor(stackTailHead), i + 1, stackTailHead, stackTail.tail)
//              ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#collectionEndFor().
//                                           ^^^^^^^^^^^^^ reference local 80
//                                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                                             ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                                  ^^^^^^^^^^^^^ reference local 80
//                                                                                 ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)
//                                                                                           ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOps#tail().
            }
          case _ => dieWithFailureMessage(i, state)
//                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
        }
      case _ => dieWithFailureMessage(i, state)
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().
//                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                       ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)

    }
  }


  def dieWithFailureMessage(i: Int, state: Int) = {
//    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().
//                          display_name dieWithFailureMessage
//                          signature_documentation scala def dieWithFailureMessage(i: Int, state: Int): Nothing
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().(i)
//                            display_name i
//                            signature_documentation scala i: Int 
//                             ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                  ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().(state)
//                                        display_name state
//                                        signature_documentation scala state: Int 
//                                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    val expected = state match{
//      ^^^^^^^^ definition local 81
//               display_name expected
//               signature_documentation scala expected: String 
//                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().(state)
      case ARRBEG => "json value or ]"
//         ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARRBEG.
      case OBJBEG => "json value or }"
//         ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJBEG.
      case DATA => "json value"
//         ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#DATA.
      case KEY => "json string key"
//         ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#KEY.
      case COLON => ":"
//         ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#COLON.
      case ARREND => ", or ]"
//         ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARREND.
      case OBJEND => ", or }"
//         ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJEND.
    }
    die(i, s"expected $expected")
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().(i)
//         ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/StringContext#s().
//                     ^^^^^^^^ reference local 81
  }

  def failIfNotData(state: Int, i: Int) = (state: @switch) match{
//    ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().
//                  display_name failIfNotData
//                  signature_documentation scala def failIfNotData(state: Int, i: Int): Unit
//                  ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().(state)
//                        display_name state
//                        signature_documentation scala state: Int 
//                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().(i)
//                                display_name i
//                                signature_documentation scala i: Int 
//                                 ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                         ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().(state)
    case DATA | ARRBEG => // do nothing
//       ^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#DATA.
//              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARRBEG.
    case _ => dieWithFailureMessage(i, state)
//            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().
//                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().(i)
//                                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().(state)
  }

  def tryCloseCollection(stackHead: ObjArrVisitor[_, J], stackTail: List[ObjArrVisitor[_, J]], i: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().
//                       display_name tryCloseCollection
//                       signature_documentation scala def tryCloseCollection(stackHead: ObjArrVisitor[local82, J[, stackTail: List[ObjArrVisitor[local83, J[], i: Int): Option[(J, Int)]
//                       ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(stackHead)
//                                 display_name stackHead
//                                 signature_documentation scala stackHead: ObjArrVisitor[local82, J[ 
//                                  ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                       ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(stackTail)
//                                                                 display_name stackTail
//                                                                 signature_documentation scala stackTail: List[ObjArrVisitor[local83, J[] 
//                                                                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.List#
//                                                                       ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                                             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(i)
//                                                                                               display_name i
//                                                                                               signature_documentation scala i: Int 
//                                                                                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    if (stackTail.isEmpty) {
//      ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(stackTail)
//                ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/immutable/List#isEmpty().
      Some(try stackHead.visitEnd(i) catch reject(i), i + 1)
//    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Some.
//             ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(stackHead)
//                       ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(i)
//                                         ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(i)
//                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(i)
//                                                      ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
    } else {
      val ctxt2 = stackTail.head.narrow
//        ^^^^^ definition local 86
//              display_name ctxt2
//              signature_documentation scala ctxt2: ObjArrVisitor[Any, J] 
//                ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(stackTail)
//                          ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOps#head().
//                               ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#narrow().
      try ctxt2.visitValue(stackHead.visitEnd(i), i) catch reject(i)
//        ^^^^^ reference local 86
//              ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                         ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(stackHead)
//                                   ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(i)
//                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(i)
//                                                         ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().
//                                                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(i)
      None
//    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/None.

    }
  }
  def collectionEndFor(stackHead: ObjArrVisitor[_, _]) = {
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#collectionEndFor().
//                     display_name collectionEndFor
//                     signature_documentation scala def collectionEndFor(stackHead: ObjArrVisitor[local89, local90[): Int
//                     ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#collectionEndFor().(stackHead)
//                               display_name stackHead
//                               signature_documentation scala stackHead: ObjArrVisitor[local89, local90[ 
//                                ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
    if (stackHead.isObj) OBJEND
//      ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#collectionEndFor().(stackHead)
//                ^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#isObj().
//                       ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJEND.
    else ARREND
//       ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARREND.
  }

  /**
    * See if the string has any escape sequences. If not, return the
    * end of the string. If so, bail out and return -1.
    *
    * This method expects the data to be in UTF-16 and accesses it as
    * chars.
    */
  protected[this] final def parseStringSimple(i: Int): Int = {
//                          ^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringSimple().
//                                            display_name parseStringSimple
//                                            signature_documentation scala final def parseStringSimple(i: Int): Int
//                                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringSimple().(i)
//                                              display_name i
//                                              signature_documentation scala i: Int 
//                                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    var j = i
//      ^ definition local 91
//        display_name j
//        signature_documentation scala j: Int 
//          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringSimple().(i)
    var c = elemOps.toUnsignedInt(getCharSafe(j))
//      ^ definition local 92
//        display_name c
//        signature_documentation scala c: Int 
//          ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                  ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.toUnsignedInt().
//                                ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                                            ^ reference local 91
    while (c != '"') {
//         ^ reference local 92
//           ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`!=`(+2).
      if (c < ' ') die(j, s"control char (${c}) in string")
//        ^ reference local 92
//          ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`<`(+2).
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                     ^ reference local 91
//                        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/StringContext#s().
//                                          ^ reference local 92
      if (c == '\\' || c > 127) return -1 - j
//        ^ reference local 92
//          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`==`(+2).
//                  ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#`||`().
//                     ^ reference local 92
//                       ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`>`(+3).
//                                        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                                          ^ reference local 91
      j += 1
//    ^ reference local 91
//      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      c = elemOps.toUnsignedInt(getCharSafe(j))
//    ^ reference local 92
//        ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.toUnsignedInt().
//                              ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                                          ^ reference local 91
    }
    j + 1
//  ^ reference local 91
//    ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
  }

  /**
    * Parse a string that is known to have escape sequences.
    */
  protected[this] final def parseStringComplex(i0: Int): Int = {
//                          ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringComplex().
//                                             display_name parseStringComplex
//                                             signature_documentation scala final def parseStringComplex(i0: Int): Int
//                                             ^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringComplex().(i0)
//                                                display_name i0
//                                                signature_documentation scala i0: Int 
//                                                 ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    var i = i0
//      ^ definition local 94
//        display_name i
//        signature_documentation scala i: Int 
//          ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringComplex().(i0)
    var c = elemOps.toUnsignedInt(getCharSafe(i))
//      ^ definition local 95
//        display_name c
//        signature_documentation scala c: Int 
//          ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                  ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.toUnsignedInt().
//                                ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                                            ^ reference local 94
    while (c != '"') {
//         ^ reference local 95
//           ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`!=`(+2).

      if (c < ' ') die(i, s"control char (${c}) in string")
//        ^ reference local 95
//          ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`<`(+2).
//                 ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                     ^ reference local 94
//                        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/StringContext#s().
//                                          ^ reference local 95
      else if (c == '\\') {
//             ^ reference local 95
//               ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`==`(+2).
        (getCharSafe(i + 1): @switch) match {
//       ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                   ^ reference local 94
//                     ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
          case 'b' => { outputBuilder.append('\b'); i += 2 }
//                      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
//                                                  ^ reference local 94
//                                                    ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
          case 'f' => { outputBuilder.append('\f'); i += 2 }
//                      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
//                                                  ^ reference local 94
//                                                    ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
          case 'n' => { outputBuilder.append('\n'); i += 2 }
//                      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
//                                                  ^ reference local 94
//                                                    ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
          case 'r' => { outputBuilder.append('\r'); i += 2 }
//                      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
//                                                  ^ reference local 94
//                                                    ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
          case 't' => { outputBuilder.append('\t'); i += 2 }
//                      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
//                                                  ^ reference local 94
//                                                    ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).

          case '"' => { outputBuilder.append('"'); i += 2 }
//                      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
//                                                 ^ reference local 94
//                                                   ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
          case '/' => { outputBuilder.append('/'); i += 2 }
//                      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
//                                                 ^ reference local 94
//                                                   ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
          case '\\' => { outputBuilder.append('\\'); i += 2 }
//                       ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                     ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
//                                                   ^ reference local 94
//                                                     ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).

          // if there's a problem then descape will explode
          case 'u' =>
            val d = descape(i)
//              ^ definition local 97
//                display_name d
//                signature_documentation scala d: Char 
//                  ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#descape().
//                          ^ reference local 94
            outputBuilder.appendC(d)
//          ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                        ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharAppendC#appendC().
//                                ^ reference local 97

            i += 6
//          ^ reference local 94
//            ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).

          case c => die(i + 1, s"illegal escape sequence after \\")
//             ^ definition local 98
//               display_name c
//               signature_documentation scala c: Char 
//                  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().
//                      ^ reference local 94
//                        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                             ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/StringContext#s().
        }
      } else {
        // this case is for "normal" code points that are just one Char.
        //
        // we don't have to worry about surrogate pairs, since those
        // will all be in the ranges D800–DBFF (high surrogates) or
        // DC00–DFFF (low surrogates).
        outputBuilder.append(c)
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append().
//                           ^ reference local 95
        i += 1
//      ^ reference local 94
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      }
      c = elemOps.toUnsignedInt(getCharSafe(i))
//    ^ reference local 95
//        ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.toUnsignedInt().
//                              ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                                          ^ reference local 94
    }

    i + 1
//  ^ reference local 94
//    ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
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
//                          ^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().
//                                           display_name parseStringValue
//                                           signature_documentation scala final def parseStringValue(i: Int, stackHead: ObjArrVisitor[local99, J[): Int
//                                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().(i)
//                                             display_name i
//                                             signature_documentation scala i: Int 
//                                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                   ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().(stackHead)
//                                                             display_name stackHead
//                                                             signature_documentation scala stackHead: ObjArrVisitor[local99, J[ 
//                                                              ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#

    val k = parseStringSimple(i + 1)
//      ^ definition local 100
//        display_name k
//        signature_documentation scala k: Int 
//          ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringSimple().
//                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().(i)
//                              ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
    if (k >= 0) {
//      ^ reference local 100
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`>=`(+3).
      visitString(i, unsafeCharSeqForRange(i + 1, k - i - 2), stackHead)
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().
//                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().(i)
//                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#unsafeCharSeqForRange().
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().(i)
//                                           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                ^ reference local 100
//                                                  ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().(i)
//                                                      ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                                                            ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().(stackHead)
      k
//    ^ reference local 100
    } else {
      val k2 = parseStringToOutputBuilder(i, k)
//        ^^ definition local 101
//           display_name k2
//           signature_documentation scala k2: Int 
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().(i)
//                                           ^ reference local 100
      visitString(i, outputBuilder.makeString(), stackHead)
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().
//                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().(i)
//                   ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                 ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#makeString().
//                                               ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().(stackHead)
      k2
//    ^^ reference local 101
    }
  }

  protected[this] final def parseStringKey(i: Int, stackHead: ObjArrVisitor[_, J]): Int = {
//                          ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().
//                                         display_name parseStringKey
//                                         signature_documentation scala final def parseStringKey(i: Int, stackHead: ObjArrVisitor[local102, J[): Int
//                                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().(i)
//                                           display_name i
//                                           signature_documentation scala i: Int 
//                                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                 ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().(stackHead)
//                                                           display_name stackHead
//                                                           signature_documentation scala stackHead: ObjArrVisitor[local102, J[ 
//                                                            ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#

    val k = parseStringSimple(i + 1)
//      ^ definition local 103
//        display_name k
//        signature_documentation scala k: Int 
//          ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringSimple().
//                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().(i)
//                              ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
    if (k >= 0) {
//      ^ reference local 103
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`>=`(+3).
      visitStringKey(i, unsafeCharSeqForRange(i + 1, k - i - 2), stackHead)
//    ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().(i)
//                      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#unsafeCharSeqForRange().
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().(i)
//                                              ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                   ^ reference local 103
//                                                     ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().(i)
//                                                         ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                                                               ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().(stackHead)
      k
//    ^ reference local 103
    } else {
      val k2 = parseStringToOutputBuilder(i, k)
//        ^^ definition local 104
//           display_name k2
//           signature_documentation scala k2: Int 
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().(i)
//                                           ^ reference local 103
      visitStringKey(i, outputBuilder.makeString(), stackHead)
//    ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().(i)
//                      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                    ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#makeString().
//                                                  ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().(stackHead)
      k2
//    ^^ reference local 104
    }
  }


  def parseStringToOutputBuilder(i: Int, k: Int) = {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().
//                               display_name parseStringToOutputBuilder
//                               signature_documentation scala def parseStringToOutputBuilder(i: Int, k: Int): Int
//                               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().(i)
//                                 display_name i
//                                 signature_documentation scala i: Int 
//                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().(k)
//                                         display_name k
//                                         signature_documentation scala k: Int 
//                                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    outputBuilder.reset()
//  ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                ^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#reset().
    appendCharsToBuilder(outputBuilder, i + 1, -k - 2 - i)
//  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#appendCharsToBuilder().
//                       ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().(i)
//                                        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                             ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`unary_-`().
//                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().(k)
//                                                ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                                                    ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().(i)
    val k2 = parseStringComplex(-k - 1)
//      ^^ definition local 105
//         display_name k2
//         signature_documentation scala k2: Int 
//           ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringComplex().
//                              ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`unary_-`().
//                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().(k)
//                                 ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
    k2
//  ^^ reference local 105
  }

  def visitString(i: Int, s: CharSequence, stackHead: ObjArrVisitor[_, J]) = {
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().
//                display_name visitString
//                signature_documentation scala def visitString(i: Int, s: CharSequence, stackHead: ObjArrVisitor[local106, J[): Unit
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().(i)
//                  display_name i
//                  signature_documentation scala i: Int 
//                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().(s)
//                          display_name s
//                          signature_documentation scala s: CharSequence 
//                           ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                         ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().(stackHead)
//                                                   display_name stackHead
//                                                   signature_documentation scala stackHead: ObjArrVisitor[local106, J[ 
//                                                    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
    val v = stackHead.subVisitor.visitString(s, i)
//      ^ definition local 107
//        display_name v
//        signature_documentation scala v: Any 
//          ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().(stackHead)
//                    ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                               ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().(s)
//                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().(i)
    stackHead.narrow.visitValue(v, i)
//  ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().(stackHead)
//            ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#narrow().
//                   ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                              ^ reference local 107
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().(i)
  }
  def visitStringKey(i: Int, s: CharSequence, stackHead: ObjArrVisitor[_, J]) = {
//    ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().
//                   display_name visitStringKey
//                   signature_documentation scala def visitStringKey(i: Int, s: CharSequence, stackHead: ObjArrVisitor[local108, J[): Unit
//                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().(i)
//                     display_name i
//                     signature_documentation scala i: Int 
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().(s)
//                             display_name s
//                             signature_documentation scala s: CharSequence 
//                              ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                            ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().(stackHead)
//                                                      display_name stackHead
//                                                      signature_documentation scala stackHead: ObjArrVisitor[local108, J[ 
//                                                       ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
    val obj = stackHead.asInstanceOf[ObjVisitor[Any, _]]
//      ^^^ definition local 109
//          display_name obj
//          signature_documentation scala obj: ObjVisitor[Any, Any] 
//            ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().(stackHead)
//                      ^^^^^^^^^^^^ reference semanticdb maven . . scala/Any#asInstanceOf().
//                                   ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#
//                                              ^^^ reference semanticdb maven . . scala/Any#
    val keyVisitor = obj.visitKey(i)
//      ^^^^^^^^^^ definition local 110
//                 display_name keyVisitor
//                 signature_documentation scala keyVisitor: Visitor[local111, Any[ 
//                   ^^^ reference local 109
//                       ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKey().
//                                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().(i)
    obj.visitKeyValue(keyVisitor.visitString(s, i))
//  ^^^ reference local 109
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKeyValue().
//                    ^^^^^^^^^^ reference local 110
//                               ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().(s)
//                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().(i)
  }


  protected[this] final def parseStringTopLevel(i: Int, facade: Visitor[_, J]): (J, Int) = {
//                          ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().
//                                              display_name parseStringTopLevel
//                                              signature_documentation scala final def parseStringTopLevel(i: Int, facade: Visitor[local112, J[): (J, Int)
//                                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(i)
//                                                display_name i
//                                                signature_documentation scala i: Int 
//                                                 ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                      ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(facade)
//                                                             display_name facade
//                                                             signature_documentation scala facade: Visitor[local112, J[ 
//                                                              ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#

    val k = parseStringSimple(i + 1)
//      ^ definition local 113
//        display_name k
//        signature_documentation scala k: Int 
//          ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringSimple().
//                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(i)
//                              ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
    if (k >= 0) {
//      ^ reference local 113
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`>=`(+3).
      val res = facade.visitString(unsafeCharSeqForRange(i + 1, k - i - 2), i)
//        ^^^ definition local 114
//            display_name res
//            signature_documentation scala res: J 
//              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(facade)
//                     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#unsafeCharSeqForRange().
//                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(i)
//                                                         ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
//                                                              ^ reference local 113
//                                                                ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(i)
//                                                                    ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
//                                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(i)
      (res, k)
//     ^^^ reference local 114
//          ^ reference local 113
    } else {
      val k2 = parseStringToOutputBuilder(i, k)
//        ^^ definition local 115
//           display_name k2
//           signature_documentation scala k2: Int 
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(i)
//                                           ^ reference local 113
      val res = facade.visitString(outputBuilder.makeString(), i)
//        ^^^ definition local 116
//            display_name res
//            signature_documentation scala res: J 
//              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(facade)
//                     ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                 ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                               ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#makeString().
//                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(i)
      (res, k2)
//     ^^^ reference local 116
//          ^^ reference local 115
    }
  }
}
