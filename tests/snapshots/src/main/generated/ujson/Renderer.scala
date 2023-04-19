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
//                                           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor.
//                                           ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#

import scala.annotation.switch
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^^^ reference semanticdb maven . . scala/annotation/
//                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/annotation/switch#

case class BytesRenderer(indent: Int = -1, escapeUnicode: Boolean = false)
//         ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#
//                       documentation ```scala\ncase class BytesRenderer(indent: Int, escapeUnicode: Boolean) extends BaseByteRenderer[ByteArrayOutputStream]\n```
//         ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#productElement().
//                       documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                       relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#productElementName().
//                       documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                       relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.
//                       documentation ```scala\nobject BytesRenderer\n```
//         ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#copy().
//                       documentation ```scala\ndef copy(indent: Int, escapeUnicode: Boolean): BytesRenderer\n```
//         ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().
//                       documentation ```scala\ndef apply(indent: Int, escapeUnicode: Boolean): BytesRenderer\n```
//                       relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().
//                        documentation ```scala\ndef this(indent: Int, escapeUnicode: Boolean)\n```
//                       ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#indent.
//                              documentation ```scala\nval indent: Int\n```
//                       ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#copy().(indent)
//                              documentation ```scala\ndefault indent: Int \n```
//                       ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().(indent)
//                              documentation ```scala\ndefault indent: Int \n```
//                       ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().(indent)
//                              documentation ```scala\ndefault indent: Int \n```
//                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                         ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#escapeUnicode.
//                                                       documentation ```scala\nval escapeUnicode: Boolean\n```
//                                         ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#copy().(escapeUnicode)
//                                                       documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                         ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer.apply().(escapeUnicode)
//                                                       documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                         ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BytesRenderer#`<init>`().(escapeUnicode)
//                                                       documentation ```scala\ndefault escapeUnicode: Boolean \n```
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
//                        documentation ```scala\ncase class StringRenderer(indent: Int, escapeUnicode: Boolean) extends BaseCharRenderer[StringWriter]\n```
//         ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.
//                        documentation ```scala\nobject StringRenderer\n```
//         ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#copy().
//                        documentation ```scala\ndef copy(indent: Int, escapeUnicode: Boolean): StringRenderer\n```
//         ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().
//                        documentation ```scala\ndef apply(indent: Int, escapeUnicode: Boolean): StringRenderer\n```
//                        relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function2#apply().
//         ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#productElement().
//                        documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                        relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//         ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#productElementName().
//                        documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                        relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().
//                         documentation ```scala\ndef this(indent: Int, escapeUnicode: Boolean)\n```
//                        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#indent.
//                               documentation ```scala\nval indent: Int\n```
//                        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#copy().(indent)
//                               documentation ```scala\ndefault indent: Int \n```
//                        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().(indent)
//                               documentation ```scala\ndefault indent: Int \n```
//                        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().(indent)
//                               documentation ```scala\ndefault indent: Int \n```
//                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                          escapeUnicode: Boolean = false)
//                        ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#escapeUnicode.
//                                      documentation ```scala\nval escapeUnicode: Boolean\n```
//                        ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer.apply().(escapeUnicode)
//                                      documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                        ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#copy().(escapeUnicode)
//                                      documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                        ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringRenderer#`<init>`().(escapeUnicode)
//                                      documentation ```scala\ndefault escapeUnicode: Boolean \n```
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
//                  documentation ```scala\ncase class Renderer(out: Writer, indent: Int, escapeUnicode: Boolean) extends BaseCharRenderer[Writer]\n```
//         ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.
//                  documentation ```scala\nobject Renderer\n```
//         ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().
//                  documentation ```scala\ndef apply(out: Writer, indent: Int, escapeUnicode: Boolean): Renderer\n```
//                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Function3#apply().
//         ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#productElementName().
//                  documentation ```scala\ndef productElementName(x$1: Int): String\n```
//                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElementName().
//         ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().
//                  documentation ```scala\ndef copy(out: Writer, indent: Int, escapeUnicode: Boolean): Renderer\n```
//         ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#productElement().
//                  documentation ```scala\ndef productElement(x$1: Int): Any\n```
//                  relationship is_reference is_implementation semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Product#productElement().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().
//                   documentation ```scala\ndef this(out: Writer, indent: Int, escapeUnicode: Boolean)\n```
//                  ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#out.
//                      documentation ```scala\nval out: Writer\n```
//                  ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(out)
//                      documentation ```scala\nout: Writer \n```
//                  ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(out)
//                      documentation ```scala\ndefault out: Writer \n```
//                  ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(out)
//                      documentation ```scala\nout: Writer \n```
//                       ^^^^ reference semanticdb maven . . java/
//                            ^^ reference semanticdb maven . . java/io/
//                               ^^^^^^ reference semanticdb maven jdk 11 java/io/Writer#
                    indent: Int = -1,
//                  ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#indent.
//                         documentation ```scala\nval indent: Int\n```
//                  ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(indent)
//                         documentation ```scala\ndefault indent: Int \n```
//                  ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(indent)
//                         documentation ```scala\ndefault indent: Int \n```
//                  ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(indent)
//                         documentation ```scala\ndefault indent: Int \n```
//                          ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                    escapeUnicode: Boolean = false)
//                  ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#escapeUnicode.
//                                documentation ```scala\nval escapeUnicode: Boolean\n```
//                  ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.apply().(escapeUnicode)
//                                documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                  ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#copy().(escapeUnicode)
//                                documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                  ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(escapeUnicode)
//                                documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                 ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
  extends BaseCharRenderer(out, indent, escapeUnicode)
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#
//                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#`<init>`().
//                         ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(out)
//                              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(indent)
//                                      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer#`<init>`().(escapeUnicode)
