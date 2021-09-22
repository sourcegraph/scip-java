package ujson
//      ^^^^^ definition ujson/
import upickle.core.Visitor
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                  ^^^^^^^ reference upickle/core/Visitor.
//                  ^^^^^^^ reference upickle/core/Visitor#

trait Transformer[I] {
//    ^^^^^^^^^^^ definition ujson/Transformer#
//                ^ definition ujson/Transformer#[I]
  def transform[T](j: I, f: Visitor[_, T]): T
//    ^^^^^^^^^ definition ujson/Transformer#transform().
//              ^ definition ujson/Transformer#transform().[T]
//                 ^ definition ujson/Transformer#transform().(j)
//                    ^ reference ujson/Transformer#[I]
//                       ^ definition ujson/Transformer#transform().(f)
//                          ^^^^^^^ reference upickle/core/Visitor#
//                                     ^ reference ujson/Transformer#transform().[T]
//                                          ^ reference ujson/Transformer#transform().[T]
  def transformable[T](j: I) = Readable.fromTransformer(j, this)
//    ^^^^^^^^^^^^^ definition ujson/Transformer#transformable().
//                  ^ definition ujson/Transformer#transformable().[T]
//                     ^ definition ujson/Transformer#transformable().(j)
//                        ^ reference ujson/Transformer#[I]
//                             ^^^^^^^^ reference ujson/Readable.
//                                      ^^^^^^^^^^^^^^^ reference ujson/Readable.fromTransformer.
//                                                      reference ujson/Readable.fromTransformer.apply().
//                                                      ^ reference ujson/Transformer#transformable().(j)
}
