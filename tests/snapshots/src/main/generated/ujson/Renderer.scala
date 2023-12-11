package ujson
//      ^^^^^ definition semanticdb maven . . ujson/

import java.io.ByteArrayOutputStream
//     ^^^^ reference semanticdb maven . . java/
//          ^^ reference semanticdb maven . . java/io/
//             ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/ByteArrayOutputStream#

import upickle.core.{ArrVisitor, ObjVisitor, Visitor}
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                   ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#
//                               ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#
//                                           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor.

import scala.annotation.switch
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^^^ reference semanticdb maven . . scala/annotation/
//                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/annotation/switch#

case class BytesRenderer(indent: Int = -1, escapeUnicode: Boolean = false)
//         ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#
//                       display_name BytesRenderer
//                       documentation ```scala\ncase class BytesRenderer(indent: Int, escapeUnicode: Boolean) extends BaseByteRenderer[ByteArrayOutputStream]\n```
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().
//         _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#productElement().
//                       display_name productElement
//                       documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().
//                       relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#productElementName().
//                       display_name productElementName
//                       documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().
//                       relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.
//                       display_name BytesRenderer
//                       documentation ```scala\nobject BytesRenderer\n```
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().
//         _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#copy().
//                       display_name copy
//                       documentation ```scala\ndef copy(indent: Int, escapeUnicode: Boolean): BytesRenderer\n```
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#
//                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().
//         _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().
//                       display_name apply
//                       documentation ```scala\ndef apply(indent: Int, escapeUnicode: Boolean): BytesRenderer\n```
//                       relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#
//                       relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().
//                        display_name <init>
//                        documentation ```scala\ndef this(indent: Int, escapeUnicode: Boolean)\n```
//                       ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#indent.
//                              display_name indent
//                              documentation ```scala\nval indent: Int\n```
//                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().(indent)
//                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#copy().(indent)
//                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().(indent)
//                       ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#copy().(indent)
//                              display_name indent
//                              documentation ```scala\ndefault indent: Int \n```
//                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().(indent)
//                              relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#indent.
//                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().(indent)
//                       ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().(indent)
//                              display_name indent
//                              documentation ```scala\ndefault indent: Int \n```
//                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#copy().(indent)
//                              relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#indent.
//                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().(indent)
//                       ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().(indent)
//                              display_name indent
//                              documentation ```scala\ndefault indent: Int \n```
//                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().(indent)
//                              relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#copy().(indent)
//                              relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#indent.
//                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                         ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#escapeUnicode.
//                                                       display_name escapeUnicode
//                                                       documentation ```scala\nval escapeUnicode: Boolean\n```
//                                                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().(escapeUnicode)
//                                                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#copy().(escapeUnicode)
//                                                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().(escapeUnicode)
//                                         _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#copy().(escapeUnicode)
//                                                       display_name escapeUnicode
//                                                       documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().(escapeUnicode)
//                                                       relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#escapeUnicode.
//                                                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().(escapeUnicode)
//                                         _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().(escapeUnicode)
//                                                       display_name escapeUnicode
//                                                       documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().(escapeUnicode)
//                                                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#copy().(escapeUnicode)
//                                                       relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#escapeUnicode.
//                                         _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().(escapeUnicode)
//                                                       display_name escapeUnicode
//                                                       documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#copy().(escapeUnicode)
//                                                       relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#escapeUnicode.
//                                                       relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().(escapeUnicode)
//                                                        ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
  extends BaseByteRenderer(new ByteArrayOutputStream(), indent, escapeUnicode){
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#
//                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#`<init>`().
//                             ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/ByteArrayOutputStream#
//                                                  ^ reference semanticdb maven jdk 11 java/io/ByteArrayOutputStream#`<init>`().
//                                                      ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().(indent)
//                                                              ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().(escapeUnicode)
}


case class StringRenderer(indent: Int = -1,
//         ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#
//                        display_name StringRenderer
//                        documentation ```scala\ncase class StringRenderer(indent: Int, escapeUnicode: Boolean) extends BaseCharRenderer[StringWriter]\n```
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().
//         ______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.
//                        display_name StringRenderer
//                        documentation ```scala\nobject StringRenderer\n```
//                        relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().
//         ______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#copy().
//                        display_name copy
//                        documentation ```scala\ndef copy(indent: Int, escapeUnicode: Boolean): StringRenderer\n```
//                        relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().
//         ______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().
//                        display_name apply
//                        documentation ```scala\ndef apply(indent: Int, escapeUnicode: Boolean): StringRenderer\n```
//                        relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#
//                        relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//         ______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#productElement().
//                        display_name productElement
//                        documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                        relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().
//                        relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ______________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#productElementName().
//                        display_name productElementName
//                        documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                        relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#
//                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().
//                        relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().
//                         display_name <init>
//                         documentation ```scala\ndef this(indent: Int, escapeUnicode: Boolean)\n```
//                        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#indent.
//                               display_name indent
//                               documentation ```scala\nval indent: Int\n```
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().(indent)
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#copy().(indent)
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().(indent)
//                        ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#copy().(indent)
//                               display_name indent
//                               documentation ```scala\ndefault indent: Int \n```
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().(indent)
//                               relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#indent.
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().(indent)
//                        ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().(indent)
//                               display_name indent
//                               documentation ```scala\ndefault indent: Int \n```
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#copy().(indent)
//                               relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#indent.
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().(indent)
//                        ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().(indent)
//                               display_name indent
//                               documentation ```scala\ndefault indent: Int \n```
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().(indent)
//                               relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#copy().(indent)
//                               relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#indent.
//                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                          escapeUnicode: Boolean = false)
//                        ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#escapeUnicode.
//                                      display_name escapeUnicode
//                                      documentation ```scala\nval escapeUnicode: Boolean\n```
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().(escapeUnicode)
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#copy().(escapeUnicode)
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().(escapeUnicode)
//                        _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().(escapeUnicode)
//                                      display_name escapeUnicode
//                                      documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().(escapeUnicode)
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#copy().(escapeUnicode)
//                                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#escapeUnicode.
//                        _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#copy().(escapeUnicode)
//                                      display_name escapeUnicode
//                                      documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().(escapeUnicode)
//                                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#escapeUnicode.
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().(escapeUnicode)
//                        _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().(escapeUnicode)
//                                      display_name escapeUnicode
//                                      documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#copy().(escapeUnicode)
//                                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#escapeUnicode.
//                                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().(escapeUnicode)
//                                       ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
  extends BaseCharRenderer(new java.io.StringWriter(), indent, escapeUnicode)
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#
//                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#`<init>`().
//                             ^^^^ reference semanticdb maven . . java/
//                                  ^^ reference semanticdb maven . . java/io/
//                                     ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/StringWriter#
//                                                 ^ reference semanticdb maven jdk 11 java/io/StringWriter#`<init>`().
//                                                     ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().(indent)
//                                                             ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().(escapeUnicode)

case class Renderer(out: java.io.Writer,
//         ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#
//                  display_name Renderer
//                  documentation ```scala\ncase class Renderer(out: Writer, indent: Int, escapeUnicode: Boolean) extends BaseCharRenderer[Writer]\n```
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().
//         ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.
//                  display_name Renderer
//                  documentation ```scala\nobject Renderer\n```
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().
//         ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().
//                  display_name apply
//                  documentation ```scala\ndef apply(out: Writer, indent: Int, escapeUnicode: Boolean): Renderer\n```
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#
//                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function3#apply().
//         ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#productElementName().
//                  display_name productElementName
//                  documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().
//                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().
//                  display_name copy
//                  documentation ```scala\ndef copy(out: Writer, indent: Int, escapeUnicode: Boolean): Renderer\n```
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().
//         ________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#productElement().
//                  display_name productElement
//                  documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                  relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#
//                  relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().
//                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().
//                   display_name <init>
//                   documentation ```scala\ndef this(out: Writer, indent: Int, escapeUnicode: Boolean)\n```
//                  ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#out.
//                      display_name out
//                      documentation ```scala\nval out: Writer\n```
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(out)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(out)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(out)
//                  ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(out)
//                      display_name out
//                      documentation ```scala\nout: Writer \n```
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(out)
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(out)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#out.
//                  ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(out)
//                      display_name out
//                      documentation ```scala\ndefault out: Writer \n```
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(out)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#out.
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(out)
//                  ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(out)
//                      display_name out
//                      documentation ```scala\nout: Writer \n```
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(out)
//                      relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#out.
//                      relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(out)
//                       ^^^^ reference semanticdb maven . . java/
//                            ^^ reference semanticdb maven . . java/io/
//                               ^^^^^^ reference semanticdb maven jdk 11 java/io/Writer#
                    indent: Int = -1,
//                  ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#indent.
//                         display_name indent
//                         documentation ```scala\nval indent: Int\n```
//                         relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(indent)
//                         relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(indent)
//                         relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(indent)
//                  ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(indent)
//                         display_name indent
//                         documentation ```scala\ndefault indent: Int \n```
//                         relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(indent)
//                         relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#indent.
//                         relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(indent)
//                  ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(indent)
//                         display_name indent
//                         documentation ```scala\ndefault indent: Int \n```
//                         relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(indent)
//                         relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#indent.
//                         relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(indent)
//                  ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(indent)
//                         display_name indent
//                         documentation ```scala\ndefault indent: Int \n```
//                         relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(indent)
//                         relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(indent)
//                         relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#indent.
//                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                    escapeUnicode: Boolean = false)
//                  ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#escapeUnicode.
//                                display_name escapeUnicode
//                                documentation ```scala\nval escapeUnicode: Boolean\n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(escapeUnicode)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(escapeUnicode)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(escapeUnicode)
//                  _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(escapeUnicode)
//                                display_name escapeUnicode
//                                documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(escapeUnicode)
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(escapeUnicode)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#escapeUnicode.
//                  _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(escapeUnicode)
//                                display_name escapeUnicode
//                                documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(escapeUnicode)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#escapeUnicode.
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(escapeUnicode)
//                  _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(escapeUnicode)
//                                display_name escapeUnicode
//                                documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(escapeUnicode)
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#escapeUnicode.
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(escapeUnicode)
//                                 ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
  extends BaseCharRenderer(out, indent, escapeUnicode)
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#
//                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#`<init>`().
//                         ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(out)
//                              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(indent)
//                                      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(escapeUnicode)
