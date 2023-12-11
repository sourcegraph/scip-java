package ujson
//      ^^^^^ definition semanticdb maven . . ujson/
import scala.annotation.switch
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^^^ reference semanticdb maven . . scala/annotation/
//                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/annotation/switch#
import upickle.core.{ArrVisitor, ObjVisitor}
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                   ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#
//                               ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#

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
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#
//                     display_name BaseByteRenderer
//                     documentation ```scala\nclass BaseByteRenderer[T <: Output]\n```
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer.
//    ________________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer.
//                     display_name BaseByteRenderer
//                     documentation ```scala\nobject BaseByteRenderer\n```
//                     relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#
//                     ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#[T]
//                       display_name T
//                       documentation ```scala\nT <: Output\n```
//                          ^^^^^^^ reference semanticdb maven . . upickle/
//                                  ^^^^ reference semanticdb maven . . upickle/core/
//                                       ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteOps.
//                                               ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteOps.Output#
                      (out: T,
//                     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#out.
//                         display_name out
//                         documentation ```scala\nprivate[this] val out: T\n```
//                         relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#`<init>`().(out)
//                     ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#`<init>`().(out)
//                         display_name out
//                         documentation ```scala\nout: T \n```
//                         relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#out.
//                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#[T]
                       indent: Int = -1,
//                     ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#indent.
//                            display_name indent
//                            documentation ```scala\nprivate[this] val indent: Int\n```
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#`<init>`().(indent)
//                     ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#`<init>`().(indent)
//                            display_name indent
//                            documentation ```scala\ndefault indent: Int \n```
//                            relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#indent.
//                             ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
                       escapeUnicode: Boolean = false) extends JsVisitor[T, T]{
//                     ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#escapeUnicode.
//                                   display_name escapeUnicode
//                                   documentation ```scala\nprivate[this] val escapeUnicode: Boolean\n```
//                                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#`<init>`().(escapeUnicode)
//                     _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#`<init>`().(escapeUnicode)
//                                   display_name escapeUnicode
//                                   documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#escapeUnicode.
//                                    ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Boolean#
//                                                             ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#
//                                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#[T]
//                                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#[T]
//                                                                            ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  private[this] val elemBuilder = new upickle.core.ByteBuilder
//                  ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//                              display_name elemBuilder
//                              documentation ```scala\nprivate[this] val elemBuilder: ByteBuilder\n```
//                                    ^^^^^^^ reference semanticdb maven . . upickle/
//                                            ^^^^ reference semanticdb maven . . upickle/core/
//                                                 ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#
//                                                            ^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#`<init>`().
  private[this] val unicodeCharBuilder = new upickle.core.CharBuilder()
//                  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#unicodeCharBuilder.
//                                     display_name unicodeCharBuilder
//                                     documentation ```scala\nprivate[this] val unicodeCharBuilder: CharBuilder\n```
//                                           ^^^^^^^ reference semanticdb maven . . upickle/
//                                                   ^^^^ reference semanticdb maven . . upickle/core/
//                                                        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#
//                                                                   ^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#`<init>`().
  def flushByteBuilder() = {
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushByteBuilder().
//                     display_name flushByteBuilder
//                     documentation ```scala\ndef flushByteBuilder(): Unit\n```
    elemBuilder.writeOutToIfLongerThan(out, if (depth == 0) 0 else 1000)
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#writeOutToIfLongerThan().
//                                     ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#out.
//                                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#depth().
//                                                    ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`==`(+3).
  }

  private[this] var depth: Int = 0
//                  ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#depth().
//                        display_name depth
//                        documentation ```scala\nprivate[this] var depth: Int\n```
//                  _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#`depth_=`().
//                        display_name depth_=
//                        documentation ```scala\nprivate[this] var depth_=(x$1: Int): Unit\n```
//                        relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#depth().
//                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#


  private[this] var commaBuffered = false
//                  ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#commaBuffered().
//                                display_name commaBuffered
//                                documentation ```scala\nprivate[this] var commaBuffered: Boolean\n```
//                  _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#`commaBuffered_=`().
//                                display_name commaBuffered_=
//                                documentation ```scala\nprivate[this] var commaBuffered_=(x$1: Boolean): Unit\n```
//                                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#commaBuffered().

  def flushBuffer() = {
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushBuffer().
//                display_name flushBuffer
//                documentation ```scala\ndef flushBuffer(): Unit\n```
    if (commaBuffered) {
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#commaBuffered().
      commaBuffered = false
//    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#commaBuffered().
      elemBuilder.append(',')
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#append().
      renderIndent()
//    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#renderIndent().
    }
  }
  def visitArray(length: Int, index: Int) = new ArrVisitor[T, T] {
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitArray().
//               display_name visitArray
//               documentation ```scala\ndef visitArray(length: Int, index: Int): { def subVisitor: BaseByteRenderer[T] }\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//               ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitArray().(length)
//                      display_name length
//                      documentation ```scala\nlength: Int \n```
//                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                            ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitArray().(index)
//                                  display_name index
//                                  documentation ```scala\nindex: Int \n```
//                                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                                              ^ definition local 1
//                                                display_name $anon
//                                                documentation ```scala\nfinal class $anon\n```
//                                              ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#[T]
//                                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#[T]
//                                                               ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushBuffer().
    elemBuilder.append('[')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#append().

    depth += 1
//  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#depth().
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`+`(+4).
    renderIndent()
//  ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#renderIndent().
    def subVisitor = BaseByteRenderer.this
//      ^^^^^^^^^^ definition local 0
//                 display_name subVisitor
//                 documentation ```scala\ndef subVisitor: BaseByteRenderer[T]\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#
    def visitValue(v: T, index: Int): Unit = {
//      ^^^^^^^^^^ definition local 2
//                 display_name visitValue
//                 documentation ```scala\ndef visitValue(v: T, index: Int): Unit\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                 ^ definition local 4
//                   display_name v
//                   documentation ```scala\nv: T \n```
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#[T]
//                       ^^^^^ definition local 5
//                             display_name index
//                             documentation ```scala\nindex: Int \n```
//                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                                    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Unit#
      flushBuffer()
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushBuffer().
      commaBuffered = true
//    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#commaBuffered().
    }
    def visitEnd(index: Int) = {
//      ^^^^^^^^ definition local 3
//               display_name visitEnd
//               documentation ```scala\ndef visitEnd(index: Int): T\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//               ^^^^^ definition local 6
//                     display_name index
//                     documentation ```scala\nindex: Int \n```
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
      commaBuffered = false
//    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#commaBuffered().
      depth -= 1
//    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#depth().
//          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`-`(+3).
      renderIndent()
//    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#renderIndent().
      elemBuilder.append(']')
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#append().
      flushByteBuilder()
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushByteBuilder().
      out
//    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#out.
    }
  }

  def visitObject(length: Int, index: Int) = new ObjVisitor[T, T] {
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitObject().
//                display_name visitObject
//                documentation ```scala\ndef visitObject(length: Int, index: Int): { def subVisitor: BaseByteRenderer[T]; def visitKey(index: Int): BaseByteRenderer[T] }\n```
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitObject().
//                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitObject().(length)
//                       display_name length
//                       documentation ```scala\nlength: Int \n```
//                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitObject().(index)
//                                   display_name index
//                                   documentation ```scala\nindex: Int \n```
//                                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                                               ^ definition local 10
//                                                 display_name $anon
//                                                 documentation ```scala\nfinal class $anon\n```
//                                               ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#
//                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#[T]
//                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#[T]
//                                                                ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushBuffer().
    elemBuilder.append('{')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#append().
    depth += 1
//  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#depth().
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`+`(+4).
    renderIndent()
//  ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#renderIndent().
    def subVisitor = BaseByteRenderer.this
//      ^^^^^^^^^^ definition local 7
//                 display_name subVisitor
//                 documentation ```scala\ndef subVisitor: BaseByteRenderer[T]\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#
    def visitKey(index: Int) = BaseByteRenderer.this
//      ^^^^^^^^ definition local 8
//               display_name visitKey
//               documentation ```scala\ndef visitKey(index: Int): BaseByteRenderer[T]\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKey().
//               ^^^^^ definition local 9
//                     display_name index
//                     documentation ```scala\nindex: Int \n```
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#
    def visitKeyValue(s: Any): Unit = {
//      ^^^^^^^^^^^^^ definition local 11
//                    display_name visitKeyValue
//                    documentation ```scala\ndef visitKeyValue(s: Any): Unit\n```
//                    relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKeyValue().
//                    ^ definition local 14
//                      display_name s
//                      documentation ```scala\ns: Any \n```
//                       ^^^ reference semanticdb maven . . scala/Any#
//                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Unit#
      elemBuilder.append(':')
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#append().
      if (indent != -1) elemBuilder.append(' ')
//        ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#indent.
//               ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`!=`(+3).
//                      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//                                  ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#append().
    }
    def visitValue(v: T, index: Int): Unit = {
//      ^^^^^^^^^^ definition local 12
//                 display_name visitValue
//                 documentation ```scala\ndef visitValue(v: T, index: Int): Unit\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                 ^ definition local 15
//                   display_name v
//                   documentation ```scala\nv: T \n```
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#[T]
//                       ^^^^^ definition local 16
//                             display_name index
//                             documentation ```scala\nindex: Int \n```
//                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                                    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Unit#
      commaBuffered = true
//    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#commaBuffered().
    }
    def visitEnd(index: Int) = {
//      ^^^^^^^^ definition local 13
//               display_name visitEnd
//               documentation ```scala\ndef visitEnd(index: Int): T\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//               ^^^^^ definition local 17
//                     display_name index
//                     documentation ```scala\nindex: Int \n```
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
      commaBuffered = false
//    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#commaBuffered().
      depth -= 1
//    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#depth().
//          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`-`(+3).
      renderIndent()
//    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#renderIndent().
      elemBuilder.append('}')
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#append().
      flushByteBuilder()
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushByteBuilder().
      out
//    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#out.
    }
  }

  def visitNull(index: Int) = {
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitNull().
//              display_name visitNull
//              documentation ```scala\ndef visitNull(index: Int): T\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitNull().
//              ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitNull().(index)
//                    display_name index
//                    documentation ```scala\nindex: Int \n```
//                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushBuffer().
    elemBuilder.ensureLength(4)
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#ensureLength().
    elemBuilder.appendUnsafe('n')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('u')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('l')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('l')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    flushByteBuilder()
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushByteBuilder().
    out
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#out.
  }

  def visitFalse(index: Int) = {
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFalse().
//               display_name visitFalse
//               documentation ```scala\ndef visitFalse(index: Int): T\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFalse().
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFalse().(index)
//                     display_name index
//                     documentation ```scala\nindex: Int \n```
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushBuffer().
    elemBuilder.ensureLength(5)
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#ensureLength().
    elemBuilder.appendUnsafe('f')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('a')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('l')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('s')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('e')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    flushByteBuilder()
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushByteBuilder().
    out
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#out.
  }

  def visitTrue(index: Int) = {
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitTrue().
//              display_name visitTrue
//              documentation ```scala\ndef visitTrue(index: Int): T\n```
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitTrue().
//              ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitTrue().(index)
//                    display_name index
//                    documentation ```scala\nindex: Int \n```
//                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushBuffer().
    elemBuilder.ensureLength(4)
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#ensureLength().
    elemBuilder.appendUnsafe('t')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('r')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('u')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('e')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
    flushByteBuilder()
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushByteBuilder().
    out
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#out.
  }

  def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int) = {
//    ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64StringParts().
//                            display_name visitFloat64StringParts
//                            documentation ```scala\ndef visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int): T\n```
//                            relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64StringParts().
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64StringParts().(s)
//                              display_name s
//                              documentation ```scala\ns: CharSequence \n```
//                               ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                             ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64StringParts().(decIndex)
//                                                      display_name decIndex
//                                                      documentation ```scala\ndecIndex: Int \n```
//                                                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                                                            ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64StringParts().(expIndex)
//                                                                     display_name expIndex
//                                                                     documentation ```scala\nexpIndex: Int \n```
//                                                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                                                                           ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64StringParts().(index)
//                                                                                 display_name index
//                                                                                 documentation ```scala\nindex: Int \n```
//                                                                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushBuffer().
    elemBuilder.ensureLength(s.length())
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#ensureLength().
//                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64StringParts().(s)
//                             ^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#length().
    var i = 0
//      ^ definition local 18
//        display_name i
//        documentation ```scala\ni: Int \n```
    val sLength = s.length
//      ^^^^^^^ definition local 19
//              display_name sLength
//              documentation ```scala\nsLength: Int \n```
//                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64StringParts().(s)
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#length().
    while(i < sLength){
//        ^ reference local 18
//          ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`<`(+3).
//            ^^^^^^^ reference local 19
      elemBuilder.appendUnsafeC(s.charAt(i))
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafeC().
//                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64StringParts().(s)
//                                ^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#charAt().
//                                       ^ reference local 18
      i += 1
//    ^ reference local 18
//      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`+`(+4).
    }
    flushByteBuilder()
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushByteBuilder().
    out
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#out.
  }

  override def visitFloat64(d: Double, index: Int) = {
//             ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64().
//                          display_name visitFloat64
//                          documentation ```scala\ndef visitFloat64(d: Double, index: Int): T\n```
//                          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64().
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64().(d)
//                            display_name d
//                            documentation ```scala\nd: Double \n```
//                             ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Double#
//                                     ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64().(index)
//                                           display_name index
//                                           documentation ```scala\nindex: Int \n```
//                                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
    d match{
//  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64().(d)
      case Double.PositiveInfinity => visitNonNullString("Infinity", -1)
//         ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Double.
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Double.PositiveInfinity.
//                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitNonNullString().
      case Double.NegativeInfinity => visitNonNullString("-Infinity", -1)
//         ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Double.
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Double.NegativeInfinity.
//                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitNonNullString().
      case d if java.lang.Double.isNaN(d) => visitNonNullString("NaN", -1)
//         ^ definition local 21
//           display_name d
//           documentation ```scala\nd: Double \n```
//              ^^^^ reference semanticdb maven . . java/
//                   ^^^^ reference semanticdb maven . . java/lang/
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/Double#
//                               ^^^^^ reference semanticdb maven jdk 11 java/lang/Double#isNaN(+1).
//                                     ^ reference local 21
//                                           ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitNonNullString().
      case d =>
//         ^ definition local 22
//           display_name d
//           documentation ```scala\nd: Double \n```
        val i = d.toInt
//          ^ definition local 23
//            display_name i
//            documentation ```scala\ni: Int \n```
//              ^ reference local 22
//                ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Double#toInt().
        if (d == i) visitFloat64StringParts(i.toString, -1, -1, index)
//          ^ reference local 22
//            ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Double#`==`(+3).
//               ^ reference local 23
//                  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64StringParts().
//                                          ^ reference local 23
//                                            ^^^^^^^^ reference semanticdb maven . . scala/Any#toString().
//                                                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64().(index)
        else super.visitFloat64(d, index)
//                 ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                              ^ reference local 22
//                                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitFloat64().(index)
        flushBuffer()
//      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushBuffer().
    }
    flushByteBuilder()
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushByteBuilder().
    out
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#out.
  }


  def visitString(s: CharSequence, index: Int) = {
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitString().
//                display_name visitString
//                documentation ```scala\ndef visitString(s: CharSequence, index: Int): T\n```
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitString().(s)
//                  display_name s
//                  documentation ```scala\ns: CharSequence \n```
//                   ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                 ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitString().(index)
//                                       display_name index
//                                       documentation ```scala\nindex: Int \n```
//                                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#

    if (s eq null) visitNull(index)
//      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitString().(s)
//        ^^ reference semanticdb maven jdk 11 java/lang/Object#eq().
//                 ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitNull().
//                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitString().(index)
    else visitNonNullString(s, index)
//       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitNonNullString().
//                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitString().(s)
//                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitString().(index)
  }

  def visitNonNullString(s: CharSequence, index: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitNonNullString().
//                       display_name visitNonNullString
//                       documentation ```scala\ndef visitNonNullString(s: CharSequence, index: Int): T\n```
//                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitNonNullString().(s)
//                         display_name s
//                         documentation ```scala\ns: CharSequence \n```
//                          ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitNonNullString().(index)
//                                              display_name index
//                                              documentation ```scala\nindex: Int \n```
//                                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushBuffer().
    upickle.core.RenderUtils.escapeByte(unicodeCharBuilder, elemBuilder, s, escapeUnicode)
//  ^^^^^^^ reference semanticdb maven . . upickle/
//          ^^^^ reference semanticdb maven . . upickle/core/
//               ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.
//                           ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.escapeByte().
//                                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#unicodeCharBuilder.
//                                                          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//                                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#visitNonNullString().(s)
//                                                                          ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#escapeUnicode.
    flushByteBuilder()
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#flushByteBuilder().
    out
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#out.
  }

  final def renderIndent() = {
//          ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#renderIndent().
//                       display_name renderIndent
//                       documentation ```scala\nfinal def renderIndent(): Unit\n```
    if (indent == -1) ()
//      ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#indent.
//             ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`==`(+3).
    else {
      var i = indent * depth
//        ^ definition local 24
//          display_name i
//          documentation ```scala\ni: Int \n```
//            ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#indent.
//                   ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`*`(+3).
//                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#depth().
      elemBuilder.ensureLength(i + 1)
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#ensureLength().
//                             ^ reference local 24
//                               ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`+`(+4).
      elemBuilder.appendUnsafe('\n')
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//                ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
      while(i > 0) {
//          ^ reference local 24
//            ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`>`(+3).
        elemBuilder.appendUnsafe(' ')
//      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#elemBuilder.
//                  ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ByteBuilder#appendUnsafe().
        i -= 1
//      ^ reference local 24
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#`-`(+3).
      }
    }
  }
}
