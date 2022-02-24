package ujson
//      ^^^^^ definition ujson/
import upickle.core._
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/

import upickle.core.compat._
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                  ^^^^^^ reference upickle/core/compat/

trait AstTransformer[I] extends Transformer[I] with JsVisitor[I, I]{
//    ^^^^^^^^^^^^^^ definition ujson/AstTransformer# trait AstTransformer[I]
//                   ^ definition ujson/AstTransformer#[I] I
//                              ^^^^^^^^^^^ reference ujson/Transformer#
//                                          ^ reference ujson/AstTransformer#[I]
//                                                  ^^^^^^^^^ reference ujson/JsVisitor#
//                                                            ^ reference ujson/AstTransformer#[I]
//                                                               ^ reference ujson/AstTransformer#[I]
  def apply(t: Readable): I = t.transform(this)
//    ^^^^^ definition ujson/AstTransformer#apply(). def apply(t: Readable): I
//          ^ definition ujson/AstTransformer#apply().(t) t: Readable
//             ^^^^^^^^ reference ujson/Readable#
//                        ^ reference ujson/AstTransformer#[I]
//                            ^ reference ujson/AstTransformer#apply().(t)
//                              ^^^^^^^^^ reference ujson/Readable#transform().

  def transformArray[T](f: Visitor[_, T], items: Iterable[I]) = {
//    ^^^^^^^^^^^^^^ definition ujson/AstTransformer#transformArray(). def transformArray(f: Visitor[local0, T[, items: Iterable[I]): T
//                   ^ definition ujson/AstTransformer#transformArray().[T] T
//                      ^ definition ujson/AstTransformer#transformArray().(f) f: Visitor[local0, T[
//                         ^^^^^^^ reference upickle/core/Visitor#
//                                    ^ reference ujson/AstTransformer#transformArray().[T]
//                                        ^^^^^ definition ujson/AstTransformer#transformArray().(items) items: Iterable[I]
//                                               ^^^^^^^^ reference scala/package.Iterable#
//                                                        ^ reference ujson/AstTransformer#[I]
    val ctx = f.visitArray(items.size, -1).narrow
//      ^^^ definition local1 ctx: ArrVisitor[Any, T]
//            ^ reference ujson/AstTransformer#transformArray().(f)
//              ^^^^^^^^^^ reference upickle/core/Visitor#visitArray().
//                         ^^^^^ reference ujson/AstTransformer#transformArray().(items)
//                               ^^^^ reference scala/collection/IterableOnceOps#size().
//                                         ^^^^^^ reference upickle/core/ArrVisitor#narrow().
    for(item <- items) ctx.visitValue(transform(item, ctx.subVisitor), -1)
//      ^^^^ definition local2 item: I
//              ^^^^^ reference ujson/AstTransformer#transformArray().(items)
//                     ^^^ reference local1
//                         ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
//                                    ^^^^^^^^^ reference ujson/Transformer#transform().
//                                              ^^^^ reference local2
//                                                    ^^^ reference local1
//                                                        ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
    ctx.visitEnd(-1)
//  ^^^ reference local1
//      ^^^^^^^^ reference upickle/core/ObjArrVisitor#visitEnd().
  }
  def transformObject[T](f: Visitor[_, T], items: Iterable[(String, I)]) = {
//    ^^^^^^^^^^^^^^^ definition ujson/AstTransformer#transformObject(). def transformObject(f: Visitor[local3, T[, items: Iterable[(String, I)]): T
//                    ^ definition ujson/AstTransformer#transformObject().[T] T
//                       ^ definition ujson/AstTransformer#transformObject().(f) f: Visitor[local3, T[
//                          ^^^^^^^ reference upickle/core/Visitor#
//                                     ^ reference ujson/AstTransformer#transformObject().[T]
//                                         ^^^^^ definition ujson/AstTransformer#transformObject().(items) items: Iterable[(String, I)]
//                                                ^^^^^^^^ reference scala/package.Iterable#
//                                                          ^^^^^^ reference scala/Predef.String#
//                                                                  ^ reference ujson/AstTransformer#[I]
    val ctx = f.visitObject(items.size, -1).narrow
//      ^^^ definition local4 ctx: ObjVisitor[Any, T]
//            ^ reference ujson/AstTransformer#transformObject().(f)
//              ^^^^^^^^^^^ reference upickle/core/Visitor#visitObject().
//                          ^^^^^ reference ujson/AstTransformer#transformObject().(items)
//                                ^^^^ reference scala/collection/IterableOnceOps#size().
//                                          ^^^^^^ reference upickle/core/ObjVisitor#narrow().
    for(kv <- items) {
//      ^^ definition local5 kv: (String, I)
//            ^^^^^ reference ujson/AstTransformer#transformObject().(items)
      val keyVisitor = ctx.visitKey(-1)
//        ^^^^^^^^^^ definition local6 keyVisitor: Visitor[local7, Any[
//                     ^^^ reference local4
//                         ^^^^^^^^ reference upickle/core/ObjVisitor#visitKey().
      ctx.visitKeyValue(keyVisitor.visitString(kv._1, -1))
//    ^^^ reference local4
//        ^^^^^^^^^^^^^ reference upickle/core/ObjVisitor#visitKeyValue().
//                      ^^^^^^^^^^ reference local6
//                                 ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                             ^^ reference local5
//                                                ^^ reference scala/Tuple2#_1.
      ctx.visitValue(transform(kv._2, ctx.subVisitor), -1)
//    ^^^ reference local4
//        ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
//                   ^^^^^^^^^ reference ujson/Transformer#transform().
//                             ^^ reference local5
//                                ^^ reference scala/Tuple2#_2.
//                                    ^^^ reference local4
//                                        ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
    }
    ctx.visitEnd(-1)
//  ^^^ reference local4
//      ^^^^^^^^ reference upickle/core/ObjArrVisitor#visitEnd().
  }

  class AstObjVisitor[T](build: T => I)
//      ^^^^^^^^^^^^^ definition ujson/AstTransformer#AstObjVisitor# class AstObjVisitor[T]
//                    ^ definition ujson/AstTransformer#AstObjVisitor#[T] T
//                       definition ujson/AstTransformer#AstObjVisitor#`<init>`(). def this(build: (T) => I)(factory: Factory[(String, I), T])
//                       ^^^^^ definition ujson/AstTransformer#AstObjVisitor#build. private[this] val build: (T) => I
//                              ^ reference ujson/AstTransformer#AstObjVisitor#[T]
//                                   ^ reference ujson/AstTransformer#[I]
                        (implicit factory: Factory[(String, I), T])extends ObjVisitor[I, I] {
//                                ^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#factory. private[this] implicit val factory: Factory[(String, I), T]
//                                         ^^^^^^^ reference upickle/core/compat/package.Factory#
//                                                  ^^^^^^ reference scala/Predef.String#
//                                                          ^ reference ujson/AstTransformer#[I]
//                                                              ^ reference ujson/AstTransformer#AstObjVisitor#[T]
//                                                                         ^^^^^^^^^^ reference upickle/core/ObjVisitor#
//                                                                                    ^ reference ujson/AstTransformer#[I]
//                                                                                       ^ reference ujson/AstTransformer#[I]
//                                                                                           reference java/lang/Object#`<init>`().

    private[this] var key: String = null
//                    ^^^ definition ujson/AstTransformer#AstObjVisitor#key(). private[this] var key: String
//                    ^^^ synthetic_definition ujson/AstTransformer#AstObjVisitor#`key_=`(). private[this] var key_=(x$1: String): Unit
//                         ^^^^^^ reference scala/Predef.String#
    private[this] val vs = factory.newBuilder
//                    ^^ definition ujson/AstTransformer#AstObjVisitor#vs. private[this] val vs: Builder[(String, I), T]
//                         ^^^^^^^ reference ujson/AstTransformer#AstObjVisitor#factory.
//                                 ^^^^^^^^^^ reference scala/collection/Factory#newBuilder().
    def subVisitor = AstTransformer.this
//      ^^^^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#subVisitor(). def subVisitor: AstTransformer[I]
//                   ^^^^^^^^^^^^^^ reference ujson/AstTransformer#
    def visitKey(index: Int) = upickle.core.StringVisitor
//      ^^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitKey(). def visitKey(index: Int): StringVisitor
//               ^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitKey().(index) index: Int
//                      ^^^ reference scala/Int#
//                             ^^^^^^^ reference upickle/
//                                     ^^^^ reference upickle/core/
//                                          ^^^^^^^^^^^^^ reference upickle/core/StringVisitor.
    def visitKeyValue(s: Any): Unit = key = s.toString
//      ^^^^^^^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitKeyValue(). def visitKeyValue(s: Any): Unit
//                    ^ definition ujson/AstTransformer#AstObjVisitor#visitKeyValue().(s) s: Any
//                       ^^^ reference scala/Any#
//                             ^^^^ reference scala/Unit#
//                                    ^^^ reference ujson/AstTransformer#AstObjVisitor#key().
//                                          ^ reference ujson/AstTransformer#AstObjVisitor#visitKeyValue().(s)
//                                            ^^^^^^^^ reference scala/Any#toString().

    def visitValue(v: I, index: Int): Unit = vs += (key -> v)
//      ^^^^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitValue(). def visitValue(v: I, index: Int): Unit
//                 ^ definition ujson/AstTransformer#AstObjVisitor#visitValue().(v) v: I
//                    ^ reference ujson/AstTransformer#[I]
//                       ^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitValue().(index) index: Int
//                              ^^^ reference scala/Int#
//                                    ^^^^ reference scala/Unit#
//                                           ^^ reference ujson/AstTransformer#AstObjVisitor#vs.
//                                              ^^ reference scala/collection/mutable/Growable#`+=`().
//                                                  ^^^ reference ujson/AstTransformer#AstObjVisitor#key().
//                                                      ^^ reference scala/Predef.ArrowAssoc#`->`().
//                                                         ^ reference ujson/AstTransformer#AstObjVisitor#visitValue().(v)

    def visitEnd(index: Int) = build(vs.result)
//      ^^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitEnd(). def visitEnd(index: Int): I
//               ^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitEnd().(index) index: Int
//                      ^^^ reference scala/Int#
//                             ^^^^^ reference ujson/AstTransformer#AstObjVisitor#build.
//                                   ^^ reference ujson/AstTransformer#AstObjVisitor#vs.
//                                      ^^^^^^ reference scala/collection/mutable/Builder#result().
  }
  class AstArrVisitor[T[_]](build: T[I] => I)
//      ^^^^^^^^^^^^^ definition ujson/AstTransformer#AstArrVisitor# class AstArrVisitor[T]
//                    ^ definition ujson/AstTransformer#AstArrVisitor#[T] T
//                          definition ujson/AstTransformer#AstArrVisitor#`<init>`(). def this(build: (T[I]) => I)(factory: Factory[I, T[I]])
//                          ^^^^^ definition ujson/AstTransformer#AstArrVisitor#build. private[this] val build: (T[I]) => I
//                                 ^ reference ujson/AstTransformer#AstArrVisitor#[T]
//                                   ^ reference ujson/AstTransformer#[I]
//                                         ^ reference ujson/AstTransformer#[I]
                           (implicit factory: Factory[I, T[I]]) extends ArrVisitor[I, I]{
//                                   ^^^^^^^ definition ujson/AstTransformer#AstArrVisitor#factory. private[this] implicit val factory: Factory[I, T[I]]
//                                            ^^^^^^^ reference upickle/core/compat/package.Factory#
//                                                    ^ reference ujson/AstTransformer#[I]
//                                                       ^ reference ujson/AstTransformer#AstArrVisitor#[T]
//                                                         ^ reference ujson/AstTransformer#[I]
//                                                                      ^^^^^^^^^^ reference upickle/core/ArrVisitor#
//                                                                                 ^ reference ujson/AstTransformer#[I]
//                                                                                    ^ reference ujson/AstTransformer#[I]
//                                                                                       reference java/lang/Object#`<init>`().
    def subVisitor = AstTransformer.this
//      ^^^^^^^^^^ definition ujson/AstTransformer#AstArrVisitor#subVisitor(). def subVisitor: AstTransformer[I]
//                   ^^^^^^^^^^^^^^ reference ujson/AstTransformer#
    private[this] val vs = factory.newBuilder
//                    ^^ definition ujson/AstTransformer#AstArrVisitor#vs. private[this] val vs: Builder[I, T[I]]
//                         ^^^^^^^ reference ujson/AstTransformer#AstArrVisitor#factory.
//                                 ^^^^^^^^^^ reference scala/collection/Factory#newBuilder().
    def visitValue(v: I, index: Int): Unit = vs += v
//      ^^^^^^^^^^ definition ujson/AstTransformer#AstArrVisitor#visitValue(). def visitValue(v: I, index: Int): Unit
//                 ^ definition ujson/AstTransformer#AstArrVisitor#visitValue().(v) v: I
//                    ^ reference ujson/AstTransformer#[I]
//                       ^^^^^ definition ujson/AstTransformer#AstArrVisitor#visitValue().(index) index: Int
//                              ^^^ reference scala/Int#
//                                    ^^^^ reference scala/Unit#
//                                           ^^ reference ujson/AstTransformer#AstArrVisitor#vs.
//                                              ^^ reference scala/collection/mutable/Growable#`+=`().
//                                                 ^ reference ujson/AstTransformer#AstArrVisitor#visitValue().(v)

    def visitEnd(index: Int) = build(vs.result())
//      ^^^^^^^^ definition ujson/AstTransformer#AstArrVisitor#visitEnd(). def visitEnd(index: Int): I
//               ^^^^^ definition ujson/AstTransformer#AstArrVisitor#visitEnd().(index) index: Int
//                      ^^^ reference scala/Int#
//                             ^^^^^ reference ujson/AstTransformer#AstArrVisitor#build.
//                                   ^^ reference ujson/AstTransformer#AstArrVisitor#vs.
//                                      ^^^^^^ reference scala/collection/mutable/Builder#result().
  }
}
