package ujson
//      ^^^^^ definition semanticdb maven . . ujson/
import upickle.core._
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/

import upickle.core.compat._
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                  ^^^^^^ reference semanticdb maven . . upickle/core/compat/

trait AstTransformer[I] extends Transformer[I] with JsVisitor[I, I]{
//    ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#
//                   display_name AstTransformer
//                   signature_documentation scala trait AstTransformer[I]
//                   kind Trait
//                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                     display_name I
//                     signature_documentation scala I
//                     kind TypeParameter
//                              ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#
//                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                  ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#
//                                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
  def apply(t: Readable): I = t.transform(this)
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#apply().
//          display_name apply
//          signature_documentation scala def apply(t: Readable): I
//          kind Method
//          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#apply().(t)
//            display_name t
//            signature_documentation scala t: Readable 
//            kind Parameter
//             ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#apply().(t)
//                              ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().

  def transformArray[T](f: Visitor[_, T], items: Iterable[I]) = {
//    ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().
//                   display_name transformArray
//                   signature_documentation scala def transformArray(f: Visitor[local0, T[, items: Iterable[I]): T
//                   kind Method
//                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().[T]
//                     display_name T
//                     signature_documentation scala T
//                     kind TypeParameter
//                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().(f)
//                        display_name f
//                        signature_documentation scala f: Visitor[local0, T[ 
//                        kind Parameter
//                         ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().[T]
//                                        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().(items)
//                                              display_name items
//                                              signature_documentation scala items: Iterable[I] 
//                                              kind Parameter
//                                               ^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/package.Iterable#
//                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
    val ctx = f.visitArray(items.size, -1).narrow
//      ^^^ definition local 1
//          display_name ctx
//          signature_documentation scala ctx: ArrVisitor[Any, T] 
//          kind Variable
//            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().(f)
//              ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//                         ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().(items)
//                               ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/collection/IterableOnceOps#size().
//                                         ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#narrow().
    for(item <- items) ctx.visitValue(transform(item, ctx.subVisitor), -1)
//      ^^^^ definition local 2
//           display_name item
//           signature_documentation scala item: I 
//           kind Parameter
//              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().(items)
//                     ^^^ reference local 1
//                         ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                                    ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//                                              ^^^^ reference local 2
//                                                    ^^^ reference local 1
//                                                        ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
    ctx.visitEnd(-1)
//  ^^^ reference local 1
//      ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
  }
  def transformObject[T](f: Visitor[_, T], items: Iterable[(String, I)]) = {
//    ^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().
//                    display_name transformObject
//                    signature_documentation scala def transformObject(f: Visitor[local3, T[, items: Iterable[(String, I)]): T
//                    kind Method
//                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().[T]
//                      display_name T
//                      signature_documentation scala T
//                      kind TypeParameter
//                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().(f)
//                         display_name f
//                         signature_documentation scala f: Visitor[local3, T[ 
//                         kind Parameter
//                          ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().[T]
//                                         ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().(items)
//                                               display_name items
//                                               signature_documentation scala items: Iterable[(String, I)] 
//                                               kind Parameter
//                                                ^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/package.Iterable#
//                                                          ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Predef.String#
//                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
    val ctx = f.visitObject(items.size, -1).narrow
//      ^^^ definition local 4
//          display_name ctx
//          signature_documentation scala ctx: ObjVisitor[Any, T] 
//          kind Variable
//            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().(f)
//              ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitObject().
//                          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().(items)
//                                ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/collection/IterableOnceOps#size().
//                                          ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#narrow().
    for(kv <- items) {
//      ^^ definition local 5
//         display_name kv
//         signature_documentation scala kv: (String, I) 
//         kind Parameter
//            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().(items)
      val keyVisitor = ctx.visitKey(-1)
//        ^^^^^^^^^^ definition local 6
//                   display_name keyVisitor
//                   signature_documentation scala keyVisitor: Visitor[local7, Any[ 
//                   kind Variable
//                     ^^^ reference local 4
//                         ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKey().
      ctx.visitKeyValue(keyVisitor.visitString(kv._1, -1))
//    ^^^ reference local 4
//        ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKeyValue().
//                      ^^^^^^^^^^ reference local 6
//                                 ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                             ^^ reference local 5
//                                                ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Tuple2#_1.
      ctx.visitValue(transform(kv._2, ctx.subVisitor), -1)
//    ^^^ reference local 4
//        ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                   ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//                             ^^ reference local 5
//                                ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Tuple2#_2.
//                                    ^^^ reference local 4
//                                        ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
    }
    ctx.visitEnd(-1)
//  ^^^ reference local 4
//      ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
  }

  class AstObjVisitor[T](build: T => I)
//      ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#
//                    display_name AstObjVisitor
//                    signature_documentation scala class AstObjVisitor[T]
//                    kind Class
//                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#[T]
//                      display_name T
//                      signature_documentation scala T
//                      kind TypeParameter
//                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`<init>`().
//                        display_name <init>
//                        signature_documentation scala def this(build: (T) => I)(factory: Factory[(String, I), T])
//                        kind Constructor
//                       ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#build.
//                             display_name build
//                             signature_documentation scala private[this] val build: (T) => I
//                             kind Method
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`<init>`().(build)
//                       _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`<init>`().(build)
//                             display_name build
//                             signature_documentation scala build: (T) => I 
//                             kind Parameter
//                             relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#build.
//                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#[T]
//                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
                        (implicit factory: Factory[(String, I), T])extends ObjVisitor[I, I] {
//                                ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#factory.
//                                        display_name factory
//                                        signature_documentation scala private[this] implicit val factory: Factory[(String, I), T]
//                                        kind Method
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`<init>`().(factory)
//                                _______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`<init>`().(factory)
//                                        display_name factory
//                                        signature_documentation scala implicit factory: Factory[(String, I), T] 
//                                        kind Parameter
//                                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#factory.
//                                         ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/compat/package.Factory#
//                                                  ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Predef.String#
//                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#[T]
//                                                                         ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#
//                                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                                                          ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().

    private[this] var key: String = null
//                    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#key().
//                        display_name key
//                        signature_documentation scala private[this] var key: String
//                        kind Method
//                    ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`key_=`().
//                        display_name key_=
//                        signature_documentation scala private[this] var key_=(x$1: String): Unit
//                        kind Method
//                        relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#key().
//                         ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Predef.String#
    private[this] val vs = factory.newBuilder
//                    ^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#vs.
//                       display_name vs
//                       signature_documentation scala private[this] val vs: Builder[(String, I), T]
//                       kind Method
//                         ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#factory.
//                                 ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/collection/Factory#newBuilder().
    def subVisitor = AstTransformer.this
//      ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#subVisitor().
//                 display_name subVisitor
//                 signature_documentation scala def subVisitor: AstTransformer[I]
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                   ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#
    def visitKey(index: Int) = upickle.core.StringVisitor
//      ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitKey().
//               display_name visitKey
//               signature_documentation scala def visitKey(index: Int): StringVisitor
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKey().
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitKey().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                             ^^^^^^^ reference semanticdb maven . . upickle/
//                                     ^^^^ reference semanticdb maven . . upickle/core/
//                                          ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/StringVisitor.
    def visitKeyValue(s: Any): Unit = key = s.toString
//      ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitKeyValue().
//                    display_name visitKeyValue
//                    signature_documentation scala def visitKeyValue(s: Any): Unit
//                    kind Method
//                    relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKeyValue().
//                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitKeyValue().(s)
//                      display_name s
//                      signature_documentation scala s: Any 
//                      kind Parameter
//                       ^^^ reference semanticdb maven . . scala/Any#
//                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Unit#
//                                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#key().
//                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitKeyValue().(s)
//                                            ^^^^^^^^ reference semanticdb maven . . scala/Any#toString().

    def visitValue(v: I, index: Int): Unit = vs += (key -> v)
//      ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitValue().
//                 display_name visitValue
//                 signature_documentation scala def visitValue(v: I, index: Int): Unit
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitValue().(v)
//                   display_name v
//                   signature_documentation scala v: I 
//                   kind Parameter
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                       ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitValue().(index)
//                             display_name index
//                             signature_documentation scala index: Int 
//                             kind Parameter
//                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                                    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Unit#
//                                           ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#vs.
//                                              ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/collection/mutable/Growable#`+=`().
//                                                  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#key().
//                                                      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Predef.ArrowAssoc#`->`().
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitValue().(v)

    def visitEnd(index: Int) = build(vs.result)
//      ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitEnd().
//               display_name visitEnd
//               signature_documentation scala def visitEnd(index: Int): I
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitEnd().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#build.
//                                   ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#vs.
//                                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/collection/mutable/Builder#result().
  }
  class AstArrVisitor[T[_]](build: T[I] => I)
//      ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#
//                    display_name AstArrVisitor
//                    signature_documentation scala class AstArrVisitor[T]
//                    kind Class
//                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#[T]
//                      display_name T
//                      signature_documentation scala T
//                      kind TypeParameter
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#`<init>`().
//                           display_name <init>
//                           signature_documentation scala def this(build: (T[I]) => I)(factory: Factory[I, T[I]])
//                           kind Constructor
//                          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#build.
//                                display_name build
//                                signature_documentation scala private[this] val build: (T[I]) => I
//                                kind Method
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#`<init>`().(build)
//                          _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#`<init>`().(build)
//                                display_name build
//                                signature_documentation scala build: (T[I]) => I 
//                                kind Parameter
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#build.
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#[T]
//                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
                           (implicit factory: Factory[I, T[I]]) extends ArrVisitor[I, I]{
//                                   ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#factory.
//                                           display_name factory
//                                           signature_documentation scala private[this] implicit val factory: Factory[I, T[I]]
//                                           kind Method
//                                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#`<init>`().(factory)
//                                   _______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#`<init>`().(factory)
//                                           display_name factory
//                                           signature_documentation scala implicit factory: Factory[I, T[I]] 
//                                           kind Parameter
//                                           relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#factory.
//                                            ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/compat/package.Factory#
//                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#[T]
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                                      ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#
//                                                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                                                      ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().
    def subVisitor = AstTransformer.this
//      ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#subVisitor().
//                 display_name subVisitor
//                 signature_documentation scala def subVisitor: AstTransformer[I]
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                   ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#
    private[this] val vs = factory.newBuilder
//                    ^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#vs.
//                       display_name vs
//                       signature_documentation scala private[this] val vs: Builder[I, T[I]]
//                       kind Method
//                         ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#factory.
//                                 ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/collection/Factory#newBuilder().
    def visitValue(v: I, index: Int): Unit = vs += v
//      ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#visitValue().
//                 display_name visitValue
//                 signature_documentation scala def visitValue(v: I, index: Int): Unit
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#visitValue().(v)
//                   display_name v
//                   signature_documentation scala v: I 
//                   kind Parameter
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                       ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#visitValue().(index)
//                             display_name index
//                             signature_documentation scala index: Int 
//                             kind Parameter
//                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                                    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Unit#
//                                           ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#vs.
//                                              ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/collection/mutable/Growable#`+=`().
//                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#visitValue().(v)

    def visitEnd(index: Int) = build(vs.result())
//      ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#visitEnd().
//               display_name visitEnd
//               signature_documentation scala def visitEnd(index: Int): I
//               kind Method
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#visitEnd().(index)
//                     display_name index
//                     signature_documentation scala index: Int 
//                     kind Parameter
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/Int#
//                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#build.
//                                   ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#vs.
//                                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.13 scala/collection/mutable/Builder#result().
  }
}
