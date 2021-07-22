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
//    ^^^^^^^^^^^^^^ definition ujson/AstTransformer#
//                   ^ definition ujson/AstTransformer#[I]
//                              ^^^^^^^^^^^ reference ujson/Transformer#
//                                          ^ reference ujson/AstTransformer#[I]
//                                                  ^^^^^^^^^ reference ujson/JsVisitor#
//                                                            ^ reference ujson/AstTransformer#[I]
//                                                               ^ reference ujson/AstTransformer#[I]
  def apply(t: Readable): I = t.transform(this)
//    ^^^^^ definition ujson/AstTransformer#apply().
//          ^ definition ujson/AstTransformer#apply().(t)
//             ^^^^^^^^ reference ujson/Readable#
//                        ^ reference ujson/AstTransformer#[I]
//                            ^ reference ujson/AstTransformer#apply().(t)
//                              ^^^^^^^^^ reference ujson/Readable#transform().

  def transformArray[T](f: Visitor[_, T], items: Iterable[I]) = {
//    ^^^^^^^^^^^^^^ definition ujson/AstTransformer#transformArray().
//                   ^ definition ujson/AstTransformer#transformArray().[T]
//                      ^ definition ujson/AstTransformer#transformArray().(f)
//                         ^^^^^^^ reference upickle/core/Visitor#
//                                    ^ reference ujson/AstTransformer#transformArray().[T]
//                                        ^^^^^ definition ujson/AstTransformer#transformArray().(items)
//                                               ^^^^^^^^ reference scala/package.Iterable#
//                                                        ^ reference ujson/AstTransformer#[I]
    val ctx = f.visitArray(items.size, -1).narrow
//      ^^^ definition local0
//            ^ reference ujson/AstTransformer#transformArray().(f)
//              ^^^^^^^^^^ reference upickle/core/Visitor#visitArray().
//                         ^^^^^ reference ujson/AstTransformer#transformArray().(items)
//                               ^^^^ reference scala/collection/IterableOnceOps#size().
//                                         ^^^^^^ reference upickle/core/ArrVisitor#narrow().
    for(item <- items) ctx.visitValue(transform(item, ctx.subVisitor), -1)
//      ^^^^ definition local1
//              ^^^^^ reference ujson/AstTransformer#transformArray().(items)
//                     ^^^ reference local0
//                         ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
//                                    ^^^^^^^^^ reference ujson/Transformer#transform().
//                                              ^^^^ reference local1
//                                                    ^^^ reference local0
//                                                        ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
    ctx.visitEnd(-1)
//  ^^^ reference local0
//      ^^^^^^^^ reference upickle/core/ObjArrVisitor#visitEnd().
  }
  def transformObject[T](f: Visitor[_, T], items: Iterable[(String, I)]) = {
//    ^^^^^^^^^^^^^^^ definition ujson/AstTransformer#transformObject().
//                    ^ definition ujson/AstTransformer#transformObject().[T]
//                       ^ definition ujson/AstTransformer#transformObject().(f)
//                          ^^^^^^^ reference upickle/core/Visitor#
//                                     ^ reference ujson/AstTransformer#transformObject().[T]
//                                         ^^^^^ definition ujson/AstTransformer#transformObject().(items)
//                                                ^^^^^^^^ reference scala/package.Iterable#
//                                                          ^^^^^^ reference scala/Predef.String#
//                                                                  ^ reference ujson/AstTransformer#[I]
    val ctx = f.visitObject(items.size, -1).narrow
//      ^^^ definition local3
//            ^ reference ujson/AstTransformer#transformObject().(f)
//              ^^^^^^^^^^^ reference upickle/core/Visitor#visitObject().
//                          ^^^^^ reference ujson/AstTransformer#transformObject().(items)
//                                ^^^^ reference scala/collection/IterableOnceOps#size().
//                                          ^^^^^^ reference upickle/core/ObjVisitor#narrow().
    for(kv <- items) {
//      ^^ definition local4
//            ^^^^^ reference ujson/AstTransformer#transformObject().(items)
      val keyVisitor = ctx.visitKey(-1)
//        ^^^^^^^^^^ definition local5
//                     ^^^ reference local3
//                         ^^^^^^^^ reference upickle/core/ObjVisitor#visitKey().
      ctx.visitKeyValue(keyVisitor.visitString(kv._1, -1))
//    ^^^ reference local3
//        ^^^^^^^^^^^^^ reference upickle/core/ObjVisitor#visitKeyValue().
//                      ^^^^^^^^^^ reference local5
//                                 ^^^^^^^^^^^ reference upickle/core/Visitor#visitString().
//                                             ^^ reference local4
//                                                ^^ reference scala/Tuple2#_1.
      ctx.visitValue(transform(kv._2, ctx.subVisitor), -1)
//    ^^^ reference local3
//        ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#visitValue().
//                   ^^^^^^^^^ reference ujson/Transformer#transform().
//                             ^^ reference local4
//                                ^^ reference scala/Tuple2#_2.
//                                    ^^^ reference local3
//                                        ^^^^^^^^^^ reference upickle/core/ObjArrVisitor#subVisitor().
    }
    ctx.visitEnd(-1)
//  ^^^ reference local3
//      ^^^^^^^^ reference upickle/core/ObjArrVisitor#visitEnd().
  }

  class AstObjVisitor[T](build: T => I)
//      ^^^^^^^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#
//                    ^ definition ujson/AstTransformer#AstObjVisitor#[T]
//                       definition ujson/AstTransformer#AstObjVisitor#`<init>`().
//                       ^^^^^ definition ujson/AstTransformer#AstObjVisitor#build.
//                              ^ reference ujson/AstTransformer#AstObjVisitor#[T]
//                                   ^ reference ujson/AstTransformer#[I]
                        (implicit factory: Factory[(String, I), T])extends ObjVisitor[I, I] {
//                                ^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#factory.
//                                         ^^^^^^^ reference upickle/core/compat/package.Factory#
//                                                  ^^^^^^ reference scala/Predef.String#
//                                                          ^ reference ujson/AstTransformer#[I]
//                                                              ^ reference ujson/AstTransformer#AstObjVisitor#[T]
//                                                                         ^^^^^^^^^^ reference upickle/core/ObjVisitor#
//                                                                                    ^ reference ujson/AstTransformer#[I]
//                                                                                       ^ reference ujson/AstTransformer#[I]
//                                                                                           reference java/lang/Object#`<init>`().

    private[this] var key: String = null
//                    ^^^ definition ujson/AstTransformer#AstObjVisitor#key().
//                         ^^^^^^ reference scala/Predef.String#
    private[this] val vs = factory.newBuilder
//                    ^^ definition ujson/AstTransformer#AstObjVisitor#vs.
//                         ^^^^^^^ reference ujson/AstTransformer#AstObjVisitor#factory.
//                                 ^^^^^^^^^^ reference scala/collection/Factory#newBuilder().
    def subVisitor = AstTransformer.this
//      ^^^^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#subVisitor().
//                   ^^^^^^^^^^^^^^ reference ujson/AstTransformer#
    def visitKey(index: Int) = upickle.core.StringVisitor
//      ^^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitKey().
//               ^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitKey().(index)
//                      ^^^ reference scala/Int#
//                             ^^^^^^^ reference upickle/
//                                     ^^^^ reference upickle/core/
//                                          ^^^^^^^^^^^^^ reference upickle/core/StringVisitor.
    def visitKeyValue(s: Any): Unit = key = s.toString
//      ^^^^^^^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitKeyValue().
//                    ^ definition ujson/AstTransformer#AstObjVisitor#visitKeyValue().(s)
//                       ^^^ reference scala/Any#
//                             ^^^^ reference scala/Unit#
//                                    ^^^ reference ujson/AstTransformer#AstObjVisitor#key().
//                                          ^ reference ujson/AstTransformer#AstObjVisitor#visitKeyValue().(s)
//                                            ^^^^^^^^ reference scala/Any#toString().

    def visitValue(v: I, index: Int): Unit = vs += (key -> v)
//      ^^^^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitValue().
//                 ^ definition ujson/AstTransformer#AstObjVisitor#visitValue().(v)
//                    ^ reference ujson/AstTransformer#[I]
//                       ^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitValue().(index)
//                              ^^^ reference scala/Int#
//                                    ^^^^ reference scala/Unit#
//                                           ^^ reference ujson/AstTransformer#AstObjVisitor#vs.
//                                              ^^ reference scala/collection/mutable/Growable#`+=`().
//                                                  ^^^ reference ujson/AstTransformer#AstObjVisitor#key().
//                                                      ^^ reference scala/Predef.ArrowAssoc#`->`().
//                                                         ^ reference ujson/AstTransformer#AstObjVisitor#visitValue().(v)

    def visitEnd(index: Int) = build(vs.result)
//      ^^^^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitEnd().
//               ^^^^^ definition ujson/AstTransformer#AstObjVisitor#visitEnd().(index)
//                      ^^^ reference scala/Int#
//                             ^^^^^ reference ujson/AstTransformer#AstObjVisitor#build.
//                                   ^^ reference ujson/AstTransformer#AstObjVisitor#vs.
//                                      ^^^^^^ reference scala/collection/mutable/Builder#result().
  }
  class AstArrVisitor[T[_]](build: T[I] => I)
//      ^^^^^^^^^^^^^ definition ujson/AstTransformer#AstArrVisitor#
//                    ^ definition ujson/AstTransformer#AstArrVisitor#[T]
//                          definition ujson/AstTransformer#AstArrVisitor#`<init>`().
//                          ^^^^^ definition ujson/AstTransformer#AstArrVisitor#build.
//                                 ^ reference ujson/AstTransformer#AstArrVisitor#[T]
//                                   ^ reference ujson/AstTransformer#[I]
//                                         ^ reference ujson/AstTransformer#[I]
                           (implicit factory: Factory[I, T[I]]) extends ArrVisitor[I, I]{
//                                   ^^^^^^^ definition ujson/AstTransformer#AstArrVisitor#factory.
//                                            ^^^^^^^ reference upickle/core/compat/package.Factory#
//                                                    ^ reference ujson/AstTransformer#[I]
//                                                       ^ reference ujson/AstTransformer#AstArrVisitor#[T]
//                                                         ^ reference ujson/AstTransformer#[I]
//                                                                      ^^^^^^^^^^ reference upickle/core/ArrVisitor#
//                                                                                 ^ reference ujson/AstTransformer#[I]
//                                                                                    ^ reference ujson/AstTransformer#[I]
//                                                                                       reference java/lang/Object#`<init>`().
    def subVisitor = AstTransformer.this
//      ^^^^^^^^^^ definition ujson/AstTransformer#AstArrVisitor#subVisitor().
//                   ^^^^^^^^^^^^^^ reference ujson/AstTransformer#
    private[this] val vs = factory.newBuilder
//                    ^^ definition ujson/AstTransformer#AstArrVisitor#vs.
//                         ^^^^^^^ reference ujson/AstTransformer#AstArrVisitor#factory.
//                                 ^^^^^^^^^^ reference scala/collection/Factory#newBuilder().
    def visitValue(v: I, index: Int): Unit = vs += v
//      ^^^^^^^^^^ definition ujson/AstTransformer#AstArrVisitor#visitValue().
//                 ^ definition ujson/AstTransformer#AstArrVisitor#visitValue().(v)
//                    ^ reference ujson/AstTransformer#[I]
//                       ^^^^^ definition ujson/AstTransformer#AstArrVisitor#visitValue().(index)
//                              ^^^ reference scala/Int#
//                                    ^^^^ reference scala/Unit#
//                                           ^^ reference ujson/AstTransformer#AstArrVisitor#vs.
//                                              ^^ reference scala/collection/mutable/Growable#`+=`().
//                                                 ^ reference ujson/AstTransformer#AstArrVisitor#visitValue().(v)

    def visitEnd(index: Int) = build(vs.result())
//      ^^^^^^^^ definition ujson/AstTransformer#AstArrVisitor#visitEnd().
//               ^^^^^ definition ujson/AstTransformer#AstArrVisitor#visitEnd().(index)
//                      ^^^ reference scala/Int#
//                             ^^^^^ reference ujson/AstTransformer#AstArrVisitor#build.
//                                   ^^ reference ujson/AstTransformer#AstArrVisitor#vs.
//                                      ^^^^^^ reference scala/collection/mutable/Builder#result().
  }
}
