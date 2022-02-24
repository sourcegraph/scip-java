package ujson
//      ^^^^^ definition ujson/

import java.io.ByteArrayOutputStream
//     ^^^^ reference java/
//          ^^ reference java/io/
//             ^^^^^^^^^^^^^^^^^^^^^ reference java/io/ByteArrayOutputStream#

import upickle.core.{ArrVisitor, ObjVisitor, Visitor}
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                   ^^^^^^^^^^ reference upickle/core/ArrVisitor#
//                               ^^^^^^^^^^ reference upickle/core/ObjVisitor#
//                                           ^^^^^^^ reference upickle/core/Visitor.
//                                           ^^^^^^^ reference upickle/core/Visitor#

import scala.annotation.switch
//     ^^^^^ reference scala/
//           ^^^^^^^^^^ reference scala/annotation/
//                      ^^^^^^ reference scala/annotation/switch#

case class BytesRenderer(indent: Int = -1, escapeUnicode: Boolean = false)
//         ^^^^^^^^^^^^^ definition ujson/BytesRenderer# case class BytesRenderer(indent: Int, escapeUnicode: Boolean) extends BaseByteRenderer[ByteArrayOutputStream]
//         ^^^^^^^^^^^^^ synthetic_definition ujson/BytesRenderer#productElement(). def productElement(x$1: Int): Any
//         ^^^^^^^^^^^^^ synthetic_definition ujson/BytesRenderer#productElementName(). def productElementName(x$1: Int): String
//         ^^^^^^^^^^^^^ synthetic_definition ujson/BytesRenderer. object BytesRenderer
//         ^^^^^^^^^^^^^ synthetic_definition ujson/BytesRenderer#copy(). def copy(indent: Int, escapeUnicode: Boolean): BytesRenderer
//         ^^^^^^^^^^^^^ synthetic_definition ujson/BytesRenderer.apply(). def apply(indent: Int, escapeUnicode: Boolean): BytesRenderer
//                       definition ujson/BytesRenderer#`<init>`(). def this(indent: Int, escapeUnicode: Boolean)
//                       ^^^^^^ definition ujson/BytesRenderer#indent. val indent: Int
//                       ^^^^^^ synthetic_definition ujson/BytesRenderer#copy().(indent) default indent: Int
//                       ^^^^^^ synthetic_definition ujson/BytesRenderer.apply().(indent) default indent: Int
//                               ^^^ reference scala/Int#
//                                         ^^^^^^^^^^^^^ definition ujson/BytesRenderer#escapeUnicode. val escapeUnicode: Boolean
//                                         ^^^^^^^^^^^^^ synthetic_definition ujson/BytesRenderer#copy().(escapeUnicode) default escapeUnicode: Boolean
//                                         ^^^^^^^^^^^^^ synthetic_definition ujson/BytesRenderer.apply().(escapeUnicode) default escapeUnicode: Boolean
//                                                        ^^^^^^^ reference scala/Boolean#
  extends BaseByteRenderer(new ByteArrayOutputStream(), indent, escapeUnicode){
//        ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#
//                         reference ujson/BaseByteRenderer#`<init>`().
//                             ^^^^^^^^^^^^^^^^^^^^^ reference java/io/ByteArrayOutputStream#
//                                                   reference java/io/ByteArrayOutputStream#`<init>`().
//                                                      ^^^^^^ reference ujson/BytesRenderer#`<init>`().(indent)
//                                                              ^^^^^^^^^^^^^ reference ujson/BytesRenderer#`<init>`().(escapeUnicode)
}


case class StringRenderer(indent: Int = -1,
//         ^^^^^^^^^^^^^^ definition ujson/StringRenderer# case class StringRenderer(indent: Int, escapeUnicode: Boolean) extends BaseCharRenderer[StringWriter]
//         ^^^^^^^^^^^^^^ synthetic_definition ujson/StringRenderer. object StringRenderer
//         ^^^^^^^^^^^^^^ synthetic_definition ujson/StringRenderer#copy(). def copy(indent: Int, escapeUnicode: Boolean): StringRenderer
//         ^^^^^^^^^^^^^^ synthetic_definition ujson/StringRenderer.apply(). def apply(indent: Int, escapeUnicode: Boolean): StringRenderer
//         ^^^^^^^^^^^^^^ synthetic_definition ujson/StringRenderer#productElement(). def productElement(x$1: Int): Any
//         ^^^^^^^^^^^^^^ synthetic_definition ujson/StringRenderer#productElementName(). def productElementName(x$1: Int): String
//                        definition ujson/StringRenderer#`<init>`(). def this(indent: Int, escapeUnicode: Boolean)
//                        ^^^^^^ definition ujson/StringRenderer#indent. val indent: Int
//                        ^^^^^^ synthetic_definition ujson/StringRenderer#copy().(indent) default indent: Int
//                        ^^^^^^ synthetic_definition ujson/StringRenderer.apply().(indent) default indent: Int
//                                ^^^ reference scala/Int#
                          escapeUnicode: Boolean = false)
//                        ^^^^^^^^^^^^^ definition ujson/StringRenderer#escapeUnicode. val escapeUnicode: Boolean
//                        ^^^^^^^^^^^^^ synthetic_definition ujson/StringRenderer.apply().(escapeUnicode) default escapeUnicode: Boolean
//                        ^^^^^^^^^^^^^ synthetic_definition ujson/StringRenderer#copy().(escapeUnicode) default escapeUnicode: Boolean
//                                       ^^^^^^^ reference scala/Boolean#
  extends BaseCharRenderer(new java.io.StringWriter(), indent, escapeUnicode)
//        ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#
//                         reference ujson/BaseCharRenderer#`<init>`().
//                             ^^^^ reference java/
//                                  ^^ reference java/io/
//                                     ^^^^^^^^^^^^ reference java/io/StringWriter#
//                                                  reference java/io/StringWriter#`<init>`().
//                                                     ^^^^^^ reference ujson/StringRenderer#`<init>`().(indent)
//                                                             ^^^^^^^^^^^^^ reference ujson/StringRenderer#`<init>`().(escapeUnicode)

case class Renderer(out: java.io.Writer,
//         ^^^^^^^^ definition ujson/Renderer# case class Renderer(out: Writer, indent: Int, escapeUnicode: Boolean) extends BaseCharRenderer[Writer]
//         ^^^^^^^^ synthetic_definition ujson/Renderer. object Renderer
//         ^^^^^^^^ synthetic_definition ujson/Renderer.apply(). def apply(out: Writer, indent: Int, escapeUnicode: Boolean): Renderer
//         ^^^^^^^^ synthetic_definition ujson/Renderer#productElementName(). def productElementName(x$1: Int): String
//         ^^^^^^^^ synthetic_definition ujson/Renderer#copy(). def copy(out: Writer, indent: Int, escapeUnicode: Boolean): Renderer
//         ^^^^^^^^ synthetic_definition ujson/Renderer#productElement(). def productElement(x$1: Int): Any
//                  definition ujson/Renderer#`<init>`(). def this(out: Writer, indent: Int, escapeUnicode: Boolean)
//                  ^^^ definition ujson/Renderer#out. val out: Writer
//                  ^^^ synthetic_definition ujson/Renderer.apply().(out) out: Writer
//                  ^^^ synthetic_definition ujson/Renderer#copy().(out) default out: Writer
//                       ^^^^ reference java/
//                            ^^ reference java/io/
//                               ^^^^^^ reference java/io/Writer#
                    indent: Int = -1,
//                  ^^^^^^ definition ujson/Renderer#indent. val indent: Int
//                  ^^^^^^ synthetic_definition ujson/Renderer#copy().(indent) default indent: Int
//                  ^^^^^^ synthetic_definition ujson/Renderer.apply().(indent) default indent: Int
//                          ^^^ reference scala/Int#
                    escapeUnicode: Boolean = false)
//                  ^^^^^^^^^^^^^ definition ujson/Renderer#escapeUnicode. val escapeUnicode: Boolean
//                  ^^^^^^^^^^^^^ synthetic_definition ujson/Renderer.apply().(escapeUnicode) default escapeUnicode: Boolean
//                  ^^^^^^^^^^^^^ synthetic_definition ujson/Renderer#copy().(escapeUnicode) default escapeUnicode: Boolean
//                                 ^^^^^^^ reference scala/Boolean#
  extends BaseCharRenderer(out, indent, escapeUnicode)
//        ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#
//                         reference ujson/BaseCharRenderer#`<init>`().
//                         ^^^ reference ujson/Renderer#`<init>`().(out)
//                              ^^^^^^ reference ujson/Renderer#`<init>`().(indent)
//                                      ^^^^^^^^^^^^^ reference ujson/Renderer#`<init>`().(escapeUnicode)
