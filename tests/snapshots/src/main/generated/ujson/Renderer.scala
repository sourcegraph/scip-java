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
//         ^^^^^^^^^^^^^ definition ujson/BytesRenderer#
//                       definition ujson/BytesRenderer#`<init>`().
//                       ^^^^^^ definition ujson/BytesRenderer#indent.
//                               ^^^ reference scala/Int#
//                                         ^^^^^^^^^^^^^ definition ujson/BytesRenderer#escapeUnicode.
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
//         ^^^^^^^^^^^^^^ definition ujson/StringRenderer#
//                        definition ujson/StringRenderer#`<init>`().
//                        ^^^^^^ definition ujson/StringRenderer#indent.
//                                ^^^ reference scala/Int#
                          escapeUnicode: Boolean = false)
//                        ^^^^^^^^^^^^^ definition ujson/StringRenderer#escapeUnicode.
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
//         ^^^^^^^^ definition ujson/Renderer#
//                  definition ujson/Renderer#`<init>`().
//                  ^^^ definition ujson/Renderer#out.
//                       ^^^^ reference java/
//                            ^^ reference java/io/
//                               ^^^^^^ reference java/io/Writer#
                    indent: Int = -1,
//                  ^^^^^^ definition ujson/Renderer#indent.
//                          ^^^ reference scala/Int#
                    escapeUnicode: Boolean = false)
//                  ^^^^^^^^^^^^^ definition ujson/Renderer#escapeUnicode.
//                                 ^^^^^^^ reference scala/Boolean#
  extends BaseCharRenderer(out, indent, escapeUnicode)
//        ^^^^^^^^^^^^^^^^ reference ujson/BaseCharRenderer#
//                         reference ujson/BaseCharRenderer#`<init>`().
//                         ^^^ reference ujson/Renderer#`<init>`().(out)
//                              ^^^^^^ reference ujson/Renderer#`<init>`().(indent)
//                                      ^^^^^^^^^^^^^ reference ujson/Renderer#`<init>`().(escapeUnicode)
