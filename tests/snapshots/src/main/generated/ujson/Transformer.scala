package ujson
//      ^^^^^ definition ujson/
import upickle.core.Visitor
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                  ^^^^^^^ reference upickle/core/Visitor.
//                  ^^^^^^^ reference upickle/core/Visitor#

trait Transformer[I] {
//    ^^^^^^^^^^^ definition ujson/Transformer# trait Transformer[I]
//                ^ definition ujson/Transformer#[I] I
  def transform[T](j: I, f: Visitor[_, T]): T
//    ^^^^^^^^^ definition ujson/Transformer#transform(). def transform(j: I, f: Visitor[local0, T[): T
//              ^ definition ujson/Transformer#transform().[T] T
//                 ^ definition ujson/Transformer#transform().(j) j: I
//                    ^ reference ujson/Transformer#[I]
//                       ^ definition ujson/Transformer#transform().(f) f: Visitor[local0, T[
//                          ^^^^^^^ reference upickle/core/Visitor#
//                                     ^ reference ujson/Transformer#transform().[T]
//                                          ^ reference ujson/Transformer#transform().[T]
  def transformable[T](j: I) = Readable.fromTransformer(j, this)
//    ^^^^^^^^^^^^^ definition ujson/Transformer#transformable(). def transformable(j: I): fromTransformer[I]
//                  ^ definition ujson/Transformer#transformable().[T] T
//                     ^ definition ujson/Transformer#transformable().(j) j: I
//                        ^ reference ujson/Transformer#[I]
//                             ^^^^^^^^ reference ujson/Readable.
//                                      ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer.
//                                                      ^ reference ujson/Transformer#transformable().(j)
}
