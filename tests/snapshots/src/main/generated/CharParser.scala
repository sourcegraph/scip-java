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
//                        documentation ```scala\nabstract class CharParser[J]\n```
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                          documentation ```scala\nJ\n```
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#`<init>`().
//                             documentation ```scala\ndef this()\n```
//                                   ^^^^^^^ reference semanticdb maven . . upickle/
//                                           ^^^^ reference semanticdb maven . . upickle/core/
//                                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#
  private[this] val elemOps = upickle.core.CharOps
//                  ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#elemOps.
//                          documentation ```scala\nprivate[this] val elemOps: \n```
//                            ^^^^^^^ reference semanticdb maven . . upickle/
//                                    ^^^^ reference semanticdb maven . . upickle/core/
//                                         ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.
  private[this] val outputBuilder = new upickle.core.CharBuilder()
//                  ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#outputBuilder.
//                                documentation ```scala\nprivate[this] val outputBuilder: CharBuilder\n```
//                                      ^^^^^^^ reference semanticdb maven . . upickle/
//                                              ^^^^ reference semanticdb maven . . upickle/core/
//                                                   ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#
//                                                              ^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#`<init>`().

  def requestUntilOrThrow(i: Int) = {
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#requestUntilOrThrow().
//                        documentation ```scala\ndef requestUntilOrThrow(i: Int): Unit\n```
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#requestUntilOrThrow().(i)
//                          documentation ```scala\ni: Int \n```
//                           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    if (requestUntil(i)) throw new IncompleteParseException("exhausted input")
//      ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#requestUntil().
//                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#requestUntilOrThrow().(i)
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IncompleteParseException#`<init>`().
  }
  override def getCharSafe(i: Int): Char = {
//             ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                         documentation ```scala\ndef getCharSafe(i: Int): Char\n```
//                         relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#getCharSafe().
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().(i)
//                           documentation ```scala\ni: Int \n```
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
//                          documentation ```scala\ndef atEof(i: Int): Boolean\n```
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#atEof().(i)
//                            documentation ```scala\ni: Int \n```
//                             ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/BufferingCharParser#requestUntil().
//                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#atEof().(i)

  /**
   * Should be called when parsing is finished.
   */
  protected[this] def close(): Unit
//                    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#close().
//                          documentation ```scala\ndef close(): Unit\n```
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
//                                       documentation ```scala\n@inline\nprivate[this] final val ARRBEG: 6\n```
  @inline private[this] final val OBJBEG = 7
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJBEG.
//                                       documentation ```scala\n@inline\nprivate[this] final val OBJBEG: 7\n```
  @inline private[this] final val DATA = 1
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#DATA.
//                                     documentation ```scala\n@inline\nprivate[this] final val DATA: 1\n```
  @inline private[this] final val KEY = 2
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#KEY.
//                                    documentation ```scala\n@inline\nprivate[this] final val KEY: 2\n```
  @inline private[this] final val COLON = 3
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#COLON.
//                                      documentation ```scala\n@inline\nprivate[this] final val COLON: 3\n```
  @inline private[this] final val ARREND = 4
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#ARREND.
//                                       documentation ```scala\n@inline\nprivate[this] final val ARREND: 4\n```
  @inline private[this] final val OBJEND = 5
// ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#
//        ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/inline#`<init>`().
//                                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#OBJEND.
//                                       documentation ```scala\n@inline\nprivate[this] final val OBJEND: 5\n```

  /**
    * Parse the JSON document into a single JSON value.
    *
    * The parser considers documents like '333', 'true', and '"foo"' to be
    * valid, as well as more traditional documents like [1,2,3,4,5]. However,
    * multiple top-level objects are not allowed.
    */
  final def parse(facade: Visitor[_, J]): J = {
//          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parse().
//                documentation ```scala\nfinal def parse(facade: Visitor[local0, J[): J\n```
//                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parse().(facade)
//                       documentation ```scala\nfacade: Visitor[local0, J[ \n```
//                        ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
    val (value, i) = parseTopLevel(0, facade)
//       ^^^^^ definition local 2
//             documentation ```scala\nvalue: J \n```
//              ^ definition local 3
//                documentation ```scala\ni: Int \n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel().
//                                    ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parse().(facade)
    var j = i
//      ^ definition local 4
//        documentation ```scala\nj: Int \n```
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
//                        documentation ```scala\ndef die(i: Int, msg: String): Nothing\n```
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().(i)
//                          documentation ```scala\ni: Int \n```
//                           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#die().(msg)
//                                    documentation ```scala\nmsg: String \n```
//                                     ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                              ^^^^^^^ reference semanticdb maven . . scala/Nothing#
    val out = new upickle.core.CharBuilder()
//      ^^^ definition local 6
//          documentation ```scala\nout: CharBuilder \n```
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
//        documentation ```scala\ns: String \n```
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
//                                   documentation ```scala\nfinal def parseNum(i: Int, ctxt: ObjArrVisitor[Any, J], facade: Visitor[local8, J[): Int\n```
//                                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(i)
//                                     documentation ```scala\ni: Int \n```
//                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                           ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(ctxt)
//                                                documentation ```scala\nctxt: ObjArrVisitor[Any, J] \n```
//                                                 ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                               ^^^ reference semanticdb maven . . scala/Any#
//                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(facade)
//                                                                               documentation ```scala\nfacade: Visitor[local8, J[ \n```
//                                                                                ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    var j = i
//      ^ definition local 9
//        documentation ```scala\nj: Int \n```
//          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNum().(i)
    var c = getCharSafe(j)
//      ^ definition local 10
//        documentation ```scala\nc: Char \n```
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                      ^ reference local 9
    var decIndex = -1
//      ^^^^^^^^ definition local 11
//               documentation ```scala\ndecIndex: Int \n```
    var expIndex = -1
//      ^^^^^^^^ definition local 12
//               documentation ```scala\nexpIndex: Int \n```

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
//           documentation ```scala\nj0: Int \n```
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
//           documentation ```scala\nj0: Int \n```
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
//           documentation ```scala\nj0: Int \n```
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
//                                       documentation ```scala\ndef visitFloat64StringPartsWithWrapper(facade: Visitor[local19, J[, decIndex: Int, expIndex: Int, i: Int, j: Int): J\n```
//                                       ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(facade)
//                                              documentation ```scala\nfacade: Visitor[local19, J[ \n```
//                                               ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
                                         decIndex: Int,
//                                       ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(decIndex)
//                                                documentation ```scala\ndecIndex: Int \n```
//                                                 ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                                         expIndex: Int,
//                                       ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(expIndex)
//                                                documentation ```scala\nexpIndex: Int \n```
//                                                 ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                                         i: Int,
//                                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(i)
//                                         documentation ```scala\ni: Int \n```
//                                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                                         j: Int) = {
//                                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitFloat64StringPartsWithWrapper().(j)
//                                         documentation ```scala\nj: Int \n```
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
//                                           documentation ```scala\nfinal def parseNumTopLevel(i: Int, facade: Visitor[local20, J[): (J, Int)\n```
//                                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
//                                             documentation ```scala\ni: Int \n```
//                                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                   ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(facade)
//                                                          documentation ```scala\nfacade: Visitor[local20, J[ \n```
//                                                           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    var j = i
//      ^ definition local 21
//        documentation ```scala\nj: Int \n```
//          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNumTopLevel().(i)
    var c = getCharSafe(j)
//      ^ definition local 22
//        documentation ```scala\nc: Char \n```
//          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#getCharSafe().
//                      ^ reference local 21
    var decIndex = -1
//      ^^^^^^^^ definition local 23
//               documentation ```scala\ndecIndex: Int \n```
    var expIndex = -1
//      ^^^^^^^^ definition local 24
//               documentation ```scala\nexpIndex: Int \n```

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
//           documentation ```scala\nj0: Int \n```
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
//           documentation ```scala\nj0: Int \n```
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
//           documentation ```scala\nj0: Int \n```
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
//                                  documentation ```scala\nfinal def descape(i: Int): Char\n```
//                                  ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#descape().(i)
//                                    documentation ```scala\ni: Int \n```
//                                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                           ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Char#
    import upickle.core.RenderUtils.hex
//         ^^^^^^^ reference semanticdb maven . . upickle/
//                 ^^^^ reference semanticdb maven . . upickle/core/
//                      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.
//                                  ^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.hex().
    var x = 0
//      ^ definition local 31
//        documentation ```scala\nx: Int \n```
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
//                                    documentation ```scala\nfinal def parseTrue(i: Int, facade: Visitor[local32, J[): J\n```
//                                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().(i)
//                                      documentation ```scala\ni: Int \n```
//                                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                            ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTrue().(facade)
//                                                   documentation ```scala\nfacade: Visitor[local32, J[ \n```
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
//                                     documentation ```scala\nfinal def parseFalse(i: Int, facade: Visitor[local33, J[): J\n```
//                                     ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().(i)
//                                       documentation ```scala\ni: Int \n```
//                                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                             ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseFalse().(facade)
//                                                    documentation ```scala\nfacade: Visitor[local33, J[ \n```
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
//                                    documentation ```scala\nfinal def parseNull(i: Int, facade: Visitor[local34, J[): J\n```
//                                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().(i)
//                                      documentation ```scala\ni: Int \n```
//                                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                            ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNull().(facade)
//                                                   documentation ```scala\nfacade: Visitor[local34, J[ \n```
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
//                                        documentation ```scala\nfinal def parseTopLevel(i: Int, facade: Visitor[local35, J[): (J, Int)\n```
//                                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel().(i)
//                                          documentation ```scala\ni: Int \n```
//                                           ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel().(facade)
//                                                       documentation ```scala\nfacade: Visitor[local35, J[ \n```
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
//                                         documentation ```scala\n@tailrec\nfinal def parseTopLevel0(i: Int, facade: Visitor[local38, J[): (J, Int)\n```
//                                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(i)
//                                           documentation ```scala\ni: Int \n```
//                                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                 ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseTopLevel0().(facade)
//                                                        documentation ```scala\nfacade: Visitor[local38, J[ \n```
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
//           documentation ```scala\ndef reject(j: Int): PartialFunction[Throwable, Nothing]\n```
//           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#reject().(j)
//             documentation ```scala\nj: Int \n```
//              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/PartialFunction#
//                                    ^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.Throwable#
//                                               ^^^^^^^ reference semanticdb maven . . scala/Nothing#
//                                                          ^ definition local 39
//                                                            documentation ```scala\n@SerialVersionUID\nfinal class $anonfun\n```
    case e: Abort =>
//       ^ definition local 46
//         documentation ```scala\ne: Abort \n```
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
//                                      documentation ```scala\n@tailrec\nfinal def parseNested(state: Int, i: Int, stackHead: ObjArrVisitor[local50, J[, stackTail: List[ObjArrVisitor[local51, J[]): (J, Int)\n```
//                                      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(state)
//                                            documentation ```scala\nstate: Int \n```
//                                             ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                                        i: Int,
//                                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(i)
//                                        documentation ```scala\ni: Int \n```
//                                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                                        stackHead: ObjArrVisitor[_, J],
//                                      ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackHead)
//                                                documentation ```scala\nstackHead: ObjArrVisitor[local50, J[ \n```
//                                                 ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
                                        stackTail: List[ObjArrVisitor[_, J]]) : (J, Int) = {
//                                      ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseNested().(stackTail)
//                                                documentation ```scala\nstackTail: List[ObjArrVisitor[local51, J[] \n```
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
//                    documentation ```scala\nnextJ: Int \n```
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
//                    documentation ```scala\nnextJ: Int \n```
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
//              documentation ```scala\nctx: ArrVisitor[local59, J[ \n```
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
//              documentation ```scala\nctx: ObjVisitor[local64, J[ \n```
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
//              documentation ```scala\nctx: Int \n```
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
//                        documentation ```scala\nt: (J, Int) \n```
//                            ^ reference local 77
              case None =>
//                 ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/None.
                val stackTailHead = stackTail.head
//                  ^^^^^^^^^^^^^ definition local 78
//                                documentation ```scala\nstackTailHead: ObjArrVisitor[local51, J[ \n```
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
//                        documentation ```scala\nt: (J, Int) \n```
//                            ^ reference local 79
              case None =>
//                 ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/None.
                val stackTailHead = stackTail.head
//                  ^^^^^^^^^^^^^ definition local 80
//                                documentation ```scala\nstackTailHead: ObjArrVisitor[local51, J[ \n```
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
//                          documentation ```scala\ndef dieWithFailureMessage(i: Int, state: Int): Nothing\n```
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().(i)
//                            documentation ```scala\ni: Int \n```
//                             ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                  ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#dieWithFailureMessage().(state)
//                                        documentation ```scala\nstate: Int \n```
//                                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    val expected = state match{
//      ^^^^^^^^ definition local 81
//               documentation ```scala\nexpected: String \n```
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
//                  documentation ```scala\ndef failIfNotData(state: Int, i: Int): Unit\n```
//                  ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().(state)
//                        documentation ```scala\nstate: Int \n```
//                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#failIfNotData().(i)
//                                documentation ```scala\ni: Int \n```
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
//                       documentation ```scala\ndef tryCloseCollection(stackHead: ObjArrVisitor[local82, J[, stackTail: List[ObjArrVisitor[local83, J[], i: Int): Option[(J, Int)]\n```
//                       ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(stackHead)
//                                 documentation ```scala\nstackHead: ObjArrVisitor[local82, J[ \n```
//                                  ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                       ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(stackTail)
//                                                                 documentation ```scala\nstackTail: List[ObjArrVisitor[local83, J[] \n```
//                                                                  ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.List#
//                                                                       ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                                             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#tryCloseCollection().(i)
//                                                                                               documentation ```scala\ni: Int \n```
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
//              documentation ```scala\nctxt2: ObjArrVisitor[Any, J] \n```
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
//                     documentation ```scala\ndef collectionEndFor(stackHead: ObjArrVisitor[local89, local90[): Int\n```
//                     ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#collectionEndFor().(stackHead)
//                               documentation ```scala\nstackHead: ObjArrVisitor[local89, local90[ \n```
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
//                                            documentation ```scala\nfinal def parseStringSimple(i: Int): Int\n```
//                                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringSimple().(i)
//                                              documentation ```scala\ni: Int \n```
//                                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    var j = i
//      ^ definition local 91
//        documentation ```scala\nj: Int \n```
//          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringSimple().(i)
    var c = elemOps.toUnsignedInt(getCharSafe(j))
//      ^ definition local 92
//        documentation ```scala\nc: Int \n```
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
//                                             documentation ```scala\nfinal def parseStringComplex(i0: Int): Int\n```
//                                             ^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringComplex().(i0)
//                                                documentation ```scala\ni0: Int \n```
//                                                 ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    var i = i0
//      ^ definition local 94
//        documentation ```scala\ni: Int \n```
//          ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringComplex().(i0)
    var c = elemOps.toUnsignedInt(getCharSafe(i))
//      ^ definition local 95
//        documentation ```scala\nc: Int \n```
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
//                documentation ```scala\nd: Char \n```
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
//               documentation ```scala\nc: Char \n```
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
//                                           documentation ```scala\nfinal def parseStringValue(i: Int, stackHead: ObjArrVisitor[local99, J[): Int\n```
//                                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().(i)
//                                             documentation ```scala\ni: Int \n```
//                                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                   ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringValue().(stackHead)
//                                                             documentation ```scala\nstackHead: ObjArrVisitor[local99, J[ \n```
//                                                              ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#

    val k = parseStringSimple(i + 1)
//      ^ definition local 100
//        documentation ```scala\nk: Int \n```
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
//           documentation ```scala\nk2: Int \n```
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
//                                         documentation ```scala\nfinal def parseStringKey(i: Int, stackHead: ObjArrVisitor[local102, J[): Int\n```
//                                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().(i)
//                                           documentation ```scala\ni: Int \n```
//                                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                 ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringKey().(stackHead)
//                                                           documentation ```scala\nstackHead: ObjArrVisitor[local102, J[ \n```
//                                                            ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#

    val k = parseStringSimple(i + 1)
//      ^ definition local 103
//        documentation ```scala\nk: Int \n```
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
//           documentation ```scala\nk2: Int \n```
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
//                               documentation ```scala\ndef parseStringToOutputBuilder(i: Int, k: Int): Int\n```
//                               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().(i)
//                                 documentation ```scala\ni: Int \n```
//                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().(k)
//                                         documentation ```scala\nk: Int \n```
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
//         documentation ```scala\nk2: Int \n```
//           ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringComplex().
//                              ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`unary_-`().
//                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().(k)
//                                 ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
    k2
//  ^^ reference local 105
  }

  def visitString(i: Int, s: CharSequence, stackHead: ObjArrVisitor[_, J]) = {
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().
//                documentation ```scala\ndef visitString(i: Int, s: CharSequence, stackHead: ObjArrVisitor[local106, J[): Unit\n```
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().(i)
//                  documentation ```scala\ni: Int \n```
//                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().(s)
//                          documentation ```scala\ns: CharSequence \n```
//                           ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                         ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitString().(stackHead)
//                                                   documentation ```scala\nstackHead: ObjArrVisitor[local106, J[ \n```
//                                                    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
    val v = stackHead.subVisitor.visitString(s, i)
//      ^ definition local 107
//        documentation ```scala\nv: Any \n```
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
//                   documentation ```scala\ndef visitStringKey(i: Int, s: CharSequence, stackHead: ObjArrVisitor[local108, J[): Unit\n```
//                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().(i)
//                     documentation ```scala\ni: Int \n```
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().(s)
//                             documentation ```scala\ns: CharSequence \n```
//                              ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                            ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().(stackHead)
//                                                      documentation ```scala\nstackHead: ObjArrVisitor[local108, J[ \n```
//                                                       ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#
//                                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
    val obj = stackHead.asInstanceOf[ObjVisitor[Any, _]]
//      ^^^ definition local 109
//          documentation ```scala\nobj: ObjVisitor[Any, Any] \n```
//            ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#visitStringKey().(stackHead)
//                      ^^^^^^^^^^^^ reference semanticdb maven . . scala/Any#asInstanceOf().
//                                   ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#
//                                              ^^^ reference semanticdb maven . . scala/Any#
    val keyVisitor = obj.visitKey(i)
//      ^^^^^^^^^^ definition local 110
//                 documentation ```scala\nkeyVisitor: Visitor[local111, Any[ \n```
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
//                                              documentation ```scala\nfinal def parseStringTopLevel(i: Int, facade: Visitor[local112, J[): (J, Int)\n```
//                                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(i)
//                                                documentation ```scala\ni: Int \n```
//                                                 ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                      ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(facade)
//                                                             documentation ```scala\nfacade: Visitor[local112, J[ \n```
//                                                              ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#[J]
//                                                                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#

    val k = parseStringSimple(i + 1)
//      ^ definition local 113
//        documentation ```scala\nk: Int \n```
//          ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringSimple().
//                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(i)
//                              ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
    if (k >= 0) {
//      ^ reference local 113
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`>=`(+3).
      val res = facade.visitString(unsafeCharSeqForRange(i + 1, k - i - 2), i)
//        ^^^ definition local 114
//            documentation ```scala\nres: J \n```
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
//           documentation ```scala\nk2: Int \n```
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringToOutputBuilder().
//                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharParser#parseStringTopLevel().(i)
//                                           ^ reference local 113
      val res = facade.visitString(outputBuilder.makeString(), i)
//        ^^^ definition local 116
//            documentation ```scala\nres: J \n```
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
