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
//                   documentation ```scala\ntrait AstTransformer[I]\n```
//                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                     documentation ```scala\nI\n```
//                              ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#
//                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                  ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/JsVisitor#
//                                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
  def apply(t: Readable): I = t.transform(this)
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#apply().
//          documentation ```scala\ndef apply(t: Readable): I\n```
//          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#apply().(t)
//            documentation ```scala\nt: Readable \n```
//             ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#apply().(t)
//                              ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().

  def transformArray[T](f: Visitor[_, T], items: Iterable[I]) = {
//    ^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().
//                   documentation ```scala\ndef transformArray(f: Visitor[local0, T[, items: Iterable[I]): T\n```
//                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().[T]
//                     documentation ```scala\nT\n```
//                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().(f)
//                        documentation ```scala\nf: Visitor[local0, T[ \n```
//                         ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().[T]
//                                        ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().(items)
//                                              documentation ```scala\nitems: Iterable[I] \n```
//                                               ^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.Iterable#
//                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
    val ctx = f.visitArray(items.size, -1).narrow
//      ^^^ definition local 1
//          documentation ```scala\nctx: ArrVisitor[Any, T] \n```
//            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().(f)
//              ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitArray().
//                         ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformArray().(items)
//                               ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOnceOps#size().
//                                         ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ArrVisitor#narrow().
    for(item <- items) ctx.visitValue(transform(item, ctx.subVisitor), -1)
//      ^^^^ definition local 2
//           documentation ```scala\nitem: I \n```
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
//                    documentation ```scala\ndef transformObject(f: Visitor[local3, T[, items: Iterable[(String, I)]): T\n```
//                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().[T]
//                      documentation ```scala\nT\n```
//                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().(f)
//                         documentation ```scala\nf: Visitor[local3, T[ \n```
//                          ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                     ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().[T]
//                                         ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().(items)
//                                               documentation ```scala\nitems: Iterable[(String, I)] \n```
//                                                ^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/package.Iterable#
//                                                          ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
    val ctx = f.visitObject(items.size, -1).narrow
//      ^^^ definition local 4
//          documentation ```scala\nctx: ObjVisitor[Any, T] \n```
//            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().(f)
//              ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitObject().
//                          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().(items)
//                                ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/IterableOnceOps#size().
//                                          ^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#narrow().
    for(kv <- items) {
//      ^^ definition local 5
//         documentation ```scala\nkv: (String, I) \n```
//            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#transformObject().(items)
      val keyVisitor = ctx.visitKey(-1)
//        ^^^^^^^^^^ definition local 6
//                   documentation ```scala\nkeyVisitor: Visitor[local7, Any[ \n```
//                     ^^^ reference local 4
//                         ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKey().
      ctx.visitKeyValue(keyVisitor.visitString(kv._1, -1))
//    ^^^ reference local 4
//        ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKeyValue().
//                      ^^^^^^^^^^ reference local 6
//                                 ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#visitString().
//                                             ^^ reference local 5
//                                                ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Tuple2#_1.
      ctx.visitValue(transform(kv._2, ctx.subVisitor), -1)
//    ^^^ reference local 4
//        ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                   ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//                             ^^ reference local 5
//                                ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Tuple2#_2.
//                                    ^^^ reference local 4
//                                        ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
    }
    ctx.visitEnd(-1)
//  ^^^ reference local 4
//      ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
  }

  class AstObjVisitor[T](build: T => I)
//      ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#
//                    documentation ```scala\nclass AstObjVisitor[T]\n```
//                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#[T]
//                      documentation ```scala\nT\n```
//                      ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`<init>`().
//                        documentation ```scala\ndef this(build: (T) => I)(factory: Factory[(String, I), T])\n```
//                       ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#build.
//                             documentation ```scala\nprivate[this] val build: (T) => I\n```
//                             relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`<init>`().(build)
//                       _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`<init>`().(build)
//                             documentation ```scala\nbuild: (T) => I \n```
//                             relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#build.
//                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#[T]
//                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
                        (implicit factory: Factory[(String, I), T])extends ObjVisitor[I, I] {
//                                ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#factory.
//                                        documentation ```scala\nprivate[this] implicit val factory: Factory[(String, I), T]\n```
//                                        relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`<init>`().(factory)
//                                _______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`<init>`().(factory)
//                                        documentation ```scala\nimplicit factory: Factory[(String, I), T] \n```
//                                        relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#factory.
//                                         ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/compat/package.Factory#
//                                                  ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
//                                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#[T]
//                                                                         ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#
//                                                                                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                                                                          ^ reference semanticdb maven jdk 11 java/lang/Object#`<init>`().

    private[this] var key: String = null
//                    ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#key().
//                        documentation ```scala\nprivate[this] var key: String\n```
//                    ___ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#`key_=`().
//                        documentation ```scala\nprivate[this] var key_=(x$1: String): Unit\n```
//                        relationship is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#key().
//                         ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
    private[this] val vs = factory.newBuilder
//                    ^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#vs.
//                       documentation ```scala\nprivate[this] val vs: Builder[(String, I), T]\n```
//                         ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#factory.
//                                 ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/Factory#newBuilder().
    def subVisitor = AstTransformer.this
//      ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#subVisitor().
//                 documentation ```scala\ndef subVisitor: AstTransformer[I]\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                   ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#
    def visitKey(index: Int) = upickle.core.StringVisitor
//      ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitKey().
//               documentation ```scala\ndef visitKey(index: Int): StringVisitor\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKey().
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitKey().(index)
//                     documentation ```scala\nindex: Int \n```
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                             ^^^^^^^ reference semanticdb maven . . upickle/
//                                     ^^^^ reference semanticdb maven . . upickle/core/
//                                          ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/StringVisitor.
    def visitKeyValue(s: Any): Unit = key = s.toString
//      ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitKeyValue().
//                    documentation ```scala\ndef visitKeyValue(s: Any): Unit\n```
//                    relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjVisitor#visitKeyValue().
//                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitKeyValue().(s)
//                      documentation ```scala\ns: Any \n```
//                       ^^^ reference semanticdb maven . . scala/Any#
//                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
//                                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#key().
//                                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitKeyValue().(s)
//                                            ^^^^^^^^ reference semanticdb maven . . scala/Any#toString().

    def visitValue(v: I, index: Int): Unit = vs += (key -> v)
//      ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitValue().
//                 documentation ```scala\ndef visitValue(v: I, index: Int): Unit\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitValue().(v)
//                   documentation ```scala\nv: I \n```
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                       ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitValue().(index)
//                             documentation ```scala\nindex: Int \n```
//                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
//                                           ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#vs.
//                                              ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Growable#`+=`().
//                                                  ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#key().
//                                                      ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.ArrowAssoc#`->`().
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitValue().(v)

    def visitEnd(index: Int) = build(vs.result)
//      ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitEnd().
//               documentation ```scala\ndef visitEnd(index: Int): I\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#visitEnd().(index)
//                     documentation ```scala\nindex: Int \n```
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#build.
//                                   ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstObjVisitor#vs.
//                                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Builder#result().
  }
  class AstArrVisitor[T[_]](build: T[I] => I)
//      ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#
//                    documentation ```scala\nclass AstArrVisitor[T]\n```
//                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#[T]
//                      documentation ```scala\nT\n```
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#`<init>`().
//                           documentation ```scala\ndef this(build: (T[I]) => I)(factory: Factory[I, T[I]])\n```
//                          ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#build.
//                                documentation ```scala\nprivate[this] val build: (T[I]) => I\n```
//                                relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#`<init>`().(build)
//                          _____ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#`<init>`().(build)
//                                documentation ```scala\nbuild: (T[I]) => I \n```
//                                relationship is_reference is_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#build.
//                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#[T]
//                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
                           (implicit factory: Factory[I, T[I]]) extends ArrVisitor[I, I]{
//                                   ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#factory.
//                                           documentation ```scala\nprivate[this] implicit val factory: Factory[I, T[I]]\n```
//                                           relationship is_reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#`<init>`().(factory)
//                                   _______ synthetic_definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#`<init>`().(factory)
//                                           documentation ```scala\nimplicit factory: Factory[I, T[I]] \n```
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
//                 documentation ```scala\ndef subVisitor: AstTransformer[I]\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#subVisitor().
//                   ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#
    private[this] val vs = factory.newBuilder
//                    ^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#vs.
//                       documentation ```scala\nprivate[this] val vs: Builder[I, T[I]]\n```
//                         ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#factory.
//                                 ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/Factory#newBuilder().
    def visitValue(v: I, index: Int): Unit = vs += v
//      ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#visitValue().
//                 documentation ```scala\ndef visitValue(v: I, index: Int): Unit\n```
//                 relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitValue().
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#visitValue().(v)
//                   documentation ```scala\nv: I \n```
//                    ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#[I]
//                       ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#visitValue().(index)
//                             documentation ```scala\nindex: Int \n```
//                              ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
//                                           ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#vs.
//                                              ^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Growable#`+=`().
//                                                 ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#visitValue().(v)

    def visitEnd(index: Int) = build(vs.result())
//      ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#visitEnd().
//               documentation ```scala\ndef visitEnd(index: Int): I\n```
//               relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/ObjArrVisitor#visitEnd().
//               ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#visitEnd().(index)
//                     documentation ```scala\nindex: Int \n```
//                      ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#build.
//                                   ^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/AstTransformer#AstArrVisitor#vs.
//                                      ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/collection/mutable/Builder#result().
  }
}
