package ujson
//      ^^^^^ definition semanticdb maven . . ujson/
import scala.annotation.switch
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^^^ reference semanticdb maven . . scala/annotation/
//                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/annotation/switch#
import upickle.core.{ArrVisitor, ObjVisitor}
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                   ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#
//                               ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#

/**
  * A specialized JSON renderer that can render Chars (Chars or Bytes) directly
  * to a [[java.io.Writer]] or [[java.io.OutputStream]]
  *
  * Note that we use an internal `CharBuilder` to buffer the output internally
  * before sending it to [[out]] in batches. This lets us benefit from the high
  * performance and minimal overhead of `CharBuilder` in the fast path of
  * pushing characters, and avoid the synchronization/polymorphism overhead of
  * [[out]] on the fast path. Most [[out]]s would also have performance
  * benefits from receiving data in batches, rather than elem by elem.
  */
class BaseCharRenderer[T <: upickle.core.CharOps.Output]
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#
//                     display_name BaseCharRenderer
//                     signature_documentation scala class BaseCharRenderer[T <: Output]
//                     kind Class
//                     relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer.
//    ________________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer.
//                     display_name BaseCharRenderer
//                     signature_documentation scala object BaseCharRenderer
//                     kind Object
//                     relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#
//                     ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#[T]
//                       display_name T
//                       signature_documentation scala T <: Output
//                       kind TypeParameter
//                          ^^^^^^^ reference semanticdb maven . . upickle/
//                                  ^^^^ reference semanticdb maven . . upickle/core/
//                                       ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.
//                                               ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharOps.Output#
                      (out: T,
//                     ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#out.
//                         display_name out
//                         signature_documentation scala private[this] val out: T
//                         kind Method
//                         relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#`<init>`().(out)
//                     ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#`<init>`().(out)
//                         display_name out
//                         signature_documentation scala out: T 
//                         kind Parameter
//                         relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#out.
//                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#[T]
                       indent: Int = -1,
//                     ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#indent.
//                            display_name indent
//                            signature_documentation scala private[this] val indent: Int
//                            kind Method
//                            relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#`<init>`().(indent)
//                     ______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#`<init>`().(indent)
//                            display_name indent
//                            signature_documentation scala default indent: Int 
//                            kind Parameter
//                            relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#indent.
//                             ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                       escapeUnicode: Boolean = false) extends JsVisitor[T, T]{
//                     ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#escapeUnicode.
//                                   display_name escapeUnicode
//                                   signature_documentation scala private[this] val escapeUnicode: Boolean
//                                   kind Method
//                                   relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#`<init>`().(escapeUnicode)
//                     _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#`<init>`().(escapeUnicode)
//                                   display_name escapeUnicode
//                                   signature_documentation scala default escapeUnicode: Boolean 
//                                   kind Parameter
//                                   relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#escapeUnicode.
//                                    ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                                             ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#
//                                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#[T]
//                                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#[T]
//                                                                            ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
  private[this] val elemBuilder = new upickle.core.CharBuilder
//                  ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//                              display_name elemBuilder
//                              signature_documentation scala private[this] val elemBuilder: CharBuilder
//                              kind Method
//                                    ^^^^^^^ reference semanticdb maven . . upickle/
//                                            ^^^^ reference semanticdb maven . . upickle/core/
//                                                 ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#
//                                                            ^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#`<init>`().
  private[this] val unicodeCharBuilder = new upickle.core.CharBuilder()
//                  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#unicodeCharBuilder.
//                                     display_name unicodeCharBuilder
//                                     signature_documentation scala private[this] val unicodeCharBuilder: CharBuilder
//                                     kind Method
//                                           ^^^^^^^ reference semanticdb maven . . upickle/
//                                                   ^^^^ reference semanticdb maven . . upickle/core/
//                                                        ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#
//                                                                   ^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#`<init>`().
  def flushCharBuilder() = {
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushCharBuilder().
//                     display_name flushCharBuilder
//                     signature_documentation scala def flushCharBuilder(): Unit
//                     kind Method
    elemBuilder.writeOutToIfLongerThan(out, if (depth == 0) 0 else 1000)
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#writeOutToIfLongerThan().
//                                     ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#out.
//                                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#depth().
//                                                    ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`==`(+3).
  }

  private[this] var depth: Int = 0
//                  ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#depth().
//                        display_name depth
//                        signature_documentation scala private[this] var depth: Int
//                        kind Method
//                  _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#`depth_=`().
//                        display_name depth_=
//                        signature_documentation scala private[this] var depth_=(x$1: Int): Unit
//                        kind Method
//                        relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#depth().
//                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#


  private[this] var commaBuffered = false
//                  ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#commaBuffered().
//                                display_name commaBuffered
//                                signature_documentation scala private[this] var commaBuffered: Boolean
//                                kind Method
//                  _____________ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#`commaBuffered_=`().
//                                display_name commaBuffered_=
//                                signature_documentation scala private[this] var commaBuffered_=(x$1: Boolean): Unit
//                                kind Method
//                                relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#commaBuffered().

  def flushBuffer() = {
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushBuffer().
//                display_name flushBuffer
//                signature_documentation scala def flushBuffer(): Unit
//                kind Method
    if (commaBuffered) {
//      ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#commaBuffered().
      commaBuffered = false
//    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#commaBuffered().
      elemBuilder.append(',')
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
      renderIndent()
//    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#renderIndent().
    }
  }
  def visitArray(length: Int, index: Int) = new ArrVisitor[T, T] {
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitArray().
//               display_name visitArray
//               signature_documentation scala def visitArray(length: Int, index: Int): { def subVisitor: BaseCharRenderer[T] }
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//               ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitArray().(length)
//                      display_name length
//                      signature_documentation scala length: Int 
//                      kind Parameter
//                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                            ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitArray().(index)
//                                  display_name index
//                                  signature_documentation scala index: Int 
//                                  kind Parameter
//                                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                              ^ definition local 1
//                                                display_name $anon
//                                                signature_documentation scala final class $anon
//                                                kind Class
//                                              ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#[T]
//                                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#[T]
//                                                               ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushBuffer().
    elemBuilder.append('[')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).

    depth += 1
//  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#depth().
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
    renderIndent()
//  ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#renderIndent().
    def subVisitor = BaseCharRenderer.this
//      ^^^^^^^^^^ definition local 0
//                 display_name subVisitor
//                 signature_documentation scala def subVisitor: BaseCharRenderer[T]
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#
    def visitValue(v: T, index: Int): Unit = {
//      ^^^^^^^^^^ definition local 2
//                 display_name visitValue
//                 signature_documentation scala def visitValue(v: T, index: Int): Unit
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                 ^ definition local 4
//                   display_name v
//                   signature_documentation scala v: T 
//                   kind Parameter
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#[T]
//                       ^^^^^ definition local 5
//                             display_name index
//                             signature_documentation scala index: Int 
//                             kind Parameter
//                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
      flushBuffer()
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushBuffer().
      commaBuffered = true
//    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#commaBuffered().
    }
    def visitEnd(index: Int) = {
//      ^^^^^^^^ definition local 3
//               display_name visitEnd
//               signature_documentation scala def visitEnd(index: Int): T
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//               ^^^^^ definition local 6
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
      commaBuffered = false
//    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#commaBuffered().
      depth -= 1
//    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#depth().
//          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
      renderIndent()
//    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#renderIndent().
      elemBuilder.append(']')
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
      flushCharBuilder()
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushCharBuilder().
      out
//    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#out.
    }
  }

  def visitObject(length: Int, index: Int) = new ObjVisitor[T, T] {
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitObject().
//                display_name visitObject
//                signature_documentation scala def visitObject(length: Int, index: Int): { def subVisitor: BaseCharRenderer[T]; def visitKey(index: Int): BaseCharRenderer[T] }
//                kind Method
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitObject().
//                ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitObject().(length)
//                       display_name length
//                       signature_documentation scala length: Int 
//                       kind Parameter
//                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitObject().(index)
//                                   display_name index
//                                   signature_documentation scala index: Int 
//                                   kind Parameter
//                                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                               ^ definition local 10
//                                                 display_name $anon
//                                                 signature_documentation scala final class $anon
//                                                 kind Class
//                                               ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#
//                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#[T]
//                                                             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#[T]
//                                                                ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushBuffer().
    elemBuilder.append('{')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
    depth += 1
//  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#depth().
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
    renderIndent()
//  ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#renderIndent().
    def subVisitor = BaseCharRenderer.this
//      ^^^^^^^^^^ definition local 7
//                 display_name subVisitor
//                 signature_documentation scala def subVisitor: BaseCharRenderer[T]
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#
    def visitKey(index: Int) = BaseCharRenderer.this
//      ^^^^^^^^ definition local 8
//               display_name visitKey
//               signature_documentation scala def visitKey(index: Int): BaseCharRenderer[T]
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKey().
//               ^^^^^ definition local 9
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#
    def visitKeyValue(s: Any): Unit = {
//      ^^^^^^^^^^^^^ definition local 11
//                    display_name visitKeyValue
//                    signature_documentation scala def visitKeyValue(s: Any): Unit
//                    kind Method
//                    relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKeyValue().
//                    ^ definition local 14
//                      display_name s
//                      signature_documentation scala s: Any 
//                      kind Parameter
//                       ^^^ reference semanticdb maven . . scala/Any#
//                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
      elemBuilder.append(':')
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
      if (indent != -1) elemBuilder.append(' ')
//        ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#indent.
//               ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`!=`(+3).
//                      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//                                  ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
    }
    def visitValue(v: T, index: Int): Unit = {
//      ^^^^^^^^^^ definition local 12
//                 display_name visitValue
//                 signature_documentation scala def visitValue(v: T, index: Int): Unit
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                 ^ definition local 15
//                   display_name v
//                   signature_documentation scala v: T 
//                   kind Parameter
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#[T]
//                       ^^^^^ definition local 16
//                             display_name index
//                             signature_documentation scala index: Int 
//                             kind Parameter
//                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
      commaBuffered = true
//    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#commaBuffered().
    }
    def visitEnd(index: Int) = {
//      ^^^^^^^^ definition local 13
//               display_name visitEnd
//               signature_documentation scala def visitEnd(index: Int): T
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//               ^^^^^ definition local 17
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
      commaBuffered = false
//    ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#commaBuffered().
      depth -= 1
//    ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#depth().
//          ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
      renderIndent()
//    ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#renderIndent().
      elemBuilder.append('}')
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#append(+1).
      flushCharBuilder()
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushCharBuilder().
      out
//    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#out.
    }
  }

  def visitNull(index: Int) = {
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitNull().
//              display_name visitNull
//              signature_documentation scala def visitNull(index: Int): T
//              kind Method
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitNull().
//              ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitNull().(index)
//                    display_name index
//                    signature_documentation scala index: Int 
//                    kind Parameter
//                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushBuffer().
    elemBuilder.ensureLength(4)
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#ensureLength().
    elemBuilder.appendUnsafe('n')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('u')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('l')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('l')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    flushCharBuilder()
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushCharBuilder().
    out
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#out.
  }

  def visitFalse(index: Int) = {
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFalse().
//               display_name visitFalse
//               signature_documentation scala def visitFalse(index: Int): T
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFalse().
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFalse().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushBuffer().
    elemBuilder.ensureLength(5)
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#ensureLength().
    elemBuilder.appendUnsafe('f')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('a')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('l')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('s')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('e')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    flushCharBuilder()
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushCharBuilder().
    out
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#out.
  }

  def visitTrue(index: Int) = {
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitTrue().
//              display_name visitTrue
//              signature_documentation scala def visitTrue(index: Int): T
//              kind Method
//              relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitTrue().
//              ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitTrue().(index)
//                    display_name index
//                    signature_documentation scala index: Int 
//                    kind Parameter
//                     ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushBuffer().
    elemBuilder.ensureLength(4)
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#ensureLength().
    elemBuilder.appendUnsafe('t')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('r')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('u')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    elemBuilder.appendUnsafe('e')
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
    flushCharBuilder()
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushCharBuilder().
    out
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#out.
  }

  def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int) = {
//    ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64StringParts().
//                            display_name visitFloat64StringParts
//                            signature_documentation scala def visitFloat64StringParts(s: CharSequence, decIndex: Int, expIndex: Int, index: Int): T
//                            kind Method
//                            relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64StringParts().
//                            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64StringParts().(s)
//                              display_name s
//                              signature_documentation scala s: CharSequence 
//                              kind Parameter
//                               ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                             ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64StringParts().(decIndex)
//                                                      display_name decIndex
//                                                      signature_documentation scala decIndex: Int 
//                                                      kind Parameter
//                                                       ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                            ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64StringParts().(expIndex)
//                                                                     display_name expIndex
//                                                                     signature_documentation scala expIndex: Int 
//                                                                     kind Parameter
//                                                                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                           ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64StringParts().(index)
//                                                                                 display_name index
//                                                                                 signature_documentation scala index: Int 
//                                                                                 kind Parameter
//                                                                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushBuffer().
    elemBuilder.ensureLength(s.length())
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//              ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#ensureLength().
//                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64StringParts().(s)
//                             ^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#length().
    var i = 0
//      ^ definition local 18
//        display_name i
//        signature_documentation scala i: Int 
//        kind Variable
    val sLength = s.length
//      ^^^^^^^ definition local 19
//              display_name sLength
//              signature_documentation scala sLength: Int 
//              kind Variable
//                ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64StringParts().(s)
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#length().
    while(i < sLength){
//        ^ reference local 18
//          ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`<`(+3).
//            ^^^^^^^ reference local 19
      elemBuilder.appendUnsafeC(s.charAt(i))
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafeC().
//                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64StringParts().(s)
//                                ^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#charAt().
//                                       ^ reference local 18
      i += 1
//    ^ reference local 18
//      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
    }
    flushCharBuilder()
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushCharBuilder().
    out
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#out.
  }

  override def visitFloat64(d: Double, index: Int) = {
//             ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64().
//                          display_name visitFloat64
//                          signature_documentation scala def visitFloat64(d: Double, index: Int): T
//                          kind Method
//                          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                          relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitFloat64().
//                          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64().(d)
//                            display_name d
//                            signature_documentation scala d: Double 
//                            kind Parameter
//                             ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#
//                                     ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64().(index)
//                                           display_name index
//                                           signature_documentation scala index: Int 
//                                           kind Parameter
//                                            ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    d match{
//  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64().(d)
      case Double.PositiveInfinity => visitNonNullString("Infinity", -1)
//         ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double.
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double.PositiveInfinity.
//                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitNonNullString().
      case Double.NegativeInfinity => visitNonNullString("-Infinity", -1)
//         ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double.
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double.NegativeInfinity.
//                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitNonNullString().
      case d if java.lang.Double.isNaN(d) => visitNonNullString("NaN", -1)
//         ^ definition local 21
//           display_name d
//           signature_documentation scala d: Double 
//           kind Variable
//              ^^^^ reference semanticdb maven . . java/
//                   ^^^^ reference semanticdb maven . . java/lang/
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/Double#
//                               ^^^^^ reference semanticdb maven jdk 11 java/lang/Double#isNaN(+1).
//                                     ^ reference local 21
//                                           ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitNonNullString().
      case d =>
//         ^ definition local 22
//           display_name d
//           signature_documentation scala d: Double 
//           kind Variable
        val i = d.toInt
//          ^ definition local 23
//            display_name i
//            signature_documentation scala i: Int 
//            kind Variable
//              ^ reference local 22
//                ^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#toInt().
        if (d == i) visitFloat64StringParts(i.toString, -1, -1, index)
//          ^ reference local 22
//            ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Double#`==`(+3).
//               ^ reference local 23
//                  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64StringParts().
//                                          ^ reference local 23
//                                            ^^^^^^^^ reference semanticdb maven . . scala/Any#toString().
//                                                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64().(index)
        else super.visitFloat64(d, index)
//                 ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#visitFloat64().
//                              ^ reference local 22
//                                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitFloat64().(index)
        flushBuffer()
//      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushBuffer().
    }
    flushCharBuilder()
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushCharBuilder().
    out
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#out.
  }


  def visitString(s: CharSequence, index: Int) = {
//    ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitString().
//                display_name visitString
//                signature_documentation scala def visitString(s: CharSequence, index: Int): T
//                kind Method
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitString().(s)
//                  display_name s
//                  signature_documentation scala s: CharSequence 
//                  kind Parameter
//                   ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                 ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitString().(index)
//                                       display_name index
//                                       signature_documentation scala index: Int 
//                                       kind Parameter
//                                        ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#

    if (s eq null) visitNull(index)
//      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitString().(s)
//        ^^ reference semanticdb maven jdk 11 java/lang/Object#eq().
//                 ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitNull().
//                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitString().(index)
    else visitNonNullString(s, index)
//       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitNonNullString().
//                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitString().(s)
//                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitString().(index)
  }

  def visitNonNullString(s: CharSequence, index: Int) = {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitNonNullString().
//                       display_name visitNonNullString
//                       signature_documentation scala def visitNonNullString(s: CharSequence, index: Int): T
//                       kind Method
//                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitNonNullString().(s)
//                         display_name s
//                         signature_documentation scala s: CharSequence 
//                         kind Parameter
//                          ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitNonNullString().(index)
//                                              display_name index
//                                              signature_documentation scala index: Int 
//                                              kind Parameter
//                                               ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
    flushBuffer()
//  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushBuffer().
    upickle.core.RenderUtils.escapeChar(unicodeCharBuilder, elemBuilder, s, escapeUnicode)
//  ^^^^^^^ reference semanticdb maven . . upickle/
//          ^^^^ reference semanticdb maven . . upickle/core/
//               ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.
//                           ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/RenderUtils.escapeChar().
//                                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#unicodeCharBuilder.
//                                                          ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//                                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#visitNonNullString().(s)
//                                                                          ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#escapeUnicode.
    flushCharBuilder()
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#flushCharBuilder().
    out
//  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#out.
  }

  final def renderIndent() = {
//          ^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#renderIndent().
//                       display_name renderIndent
//                       signature_documentation scala final def renderIndent(): Unit
//                       kind Method
    if (indent == -1) ()
//      ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#indent.
//             ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`==`(+3).
    else {
      var i = indent * depth
//        ^ definition local 24
//          display_name i
//          signature_documentation scala i: Int 
//          kind Variable
//            ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#indent.
//                   ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`*`(+3).
//                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#depth().
      elemBuilder.ensureLength(i + 1)
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#ensureLength().
//                             ^ reference local 24
//                               ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`+`(+4).
      elemBuilder.appendUnsafe('\n')
//    ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//                ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
      while(i > 0) {
//          ^ reference local 24
//            ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`>`(+3).
        elemBuilder.appendUnsafe(' ')
//      ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseCharRenderer#elemBuilder.
//                  ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/CharBuilder#appendUnsafe().
        i -= 1
//      ^ reference local 24
//        ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#`-`(+3).
      }
    }
  }
}
