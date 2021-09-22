package minimized
//      ^^^^^^^^^ definition minimized/

import scala.concurrent.ExecutionContext.Implicits.global
//     ^^^^^ reference scala/
//           ^^^^^^^^^^ reference scala/concurrent/
//                      ^^^^^^^^^^^^^^^^ reference scala/concurrent/ExecutionContext.
//                                       ^^^^^^^^^ reference scala/concurrent/ExecutionContext.Implicits.
//                                                 ^^^^^^ reference scala/concurrent/ExecutionContext.Implicits.global().
import scala.concurrent.Future
//     ^^^^^ reference scala/
//           ^^^^^^^^^^ reference scala/concurrent/
//                      ^^^^^^ reference scala/concurrent/Future.
//                      ^^^^^^ reference scala/concurrent/Future#

class MinimizedScalaSynthetic {
//    ^^^^^^^^^^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSynthetic# class MinimizedScalaSynthetic
//                             definition minimized/MinimizedScalaSynthetic#`<init>`(). def this()
  def everything(): Unit = Future(1)
//    ^^^^^^^^^^ definition minimized/MinimizedScalaSynthetic#everything(). def everything(): Unit
//                  ^^^^ reference scala/Unit#
//                         ^^^^^^ reference scala/concurrent/Future.
//                                reference scala/concurrent/Future.apply().
//                                   reference scala/concurrent/ExecutionContext.Implicits.global().
  def applyTree(): Unit = Future.apply[Int](1)
//    ^^^^^^^^^ definition minimized/MinimizedScalaSynthetic#applyTree(). def applyTree(): Unit
//                 ^^^^ reference scala/Unit#
//                        ^^^^^^ reference scala/concurrent/Future.
//                               ^^^^^ reference scala/concurrent/Future.apply().
//                                     ^^^ reference scala/Int#
//                                             reference scala/concurrent/ExecutionContext.Implicits.global().
  def applyTree2(): Unit = List.apply[Int](1).sorted
//    ^^^^^^^^^^ definition minimized/MinimizedScalaSynthetic#applyTree2(). def applyTree2(): Unit
//                  ^^^^ reference scala/Unit#
//                         ^^^^ reference scala/package.List.
//                              ^^^^^ reference scala/collection/IterableFactory#apply().
//                                    ^^^ reference scala/Int#
//                                            ^^^^^^ reference scala/collection/immutable/StrictOptimizedSeqOps#sorted().
//                                                   reference scala/math/Ordering.Int.
  def selectTree(): Unit = Future[Int](1)
//    ^^^^^^^^^^ definition minimized/MinimizedScalaSynthetic#selectTree(). def selectTree(): Unit
//                  ^^^^ reference scala/Unit#
//                         ^^^^^^ reference scala/concurrent/Future.
//                                reference scala/concurrent/Future.apply().
//                                ^^^ reference scala/Int#
//                                        reference scala/concurrent/ExecutionContext.Implicits.global().
  def typeApplyTree(): Unit = Future.apply(1)
//    ^^^^^^^^^^^^^ definition minimized/MinimizedScalaSynthetic#typeApplyTree(). def typeApplyTree(): Unit
//                     ^^^^ reference scala/Unit#
//                            ^^^^^^ reference scala/concurrent/Future.
//                                   ^^^^^ reference scala/concurrent/Future.apply().
//                                            reference scala/concurrent/ExecutionContext.Implicits.global().
  def forComprehensions(): Unit =
//    ^^^^^^^^^^^^^^^^^ definition minimized/MinimizedScalaSynthetic#forComprehensions(). def forComprehensions(): Unit
//                         ^^^^ reference scala/Unit#
    for {
      x <- Future(1)
//    ^ definition local0 x: Int
//         ^^^^^^ reference scala/concurrent/Future.
//                reference scala/concurrent/Future.apply().
      y <- Future.successful(1)
//    ^ definition local1 y: Int
//         ^^^^^^ reference scala/concurrent/Future.
//                ^^^^^^^^^^ reference scala/concurrent/Future.successful().
      if y < 2
//       ^ reference local1
//         ^ reference scala/Int#`<`(+3).
      z <- Future.apply[Int](1)
//    ^ definition local2 z: Int
//         ^^^^^^ reference scala/concurrent/Future.
//                ^^^^^ reference scala/concurrent/Future.apply().
//                      ^^^ reference scala/Int#
    } yield x + y + z
//          ^ reference local0
//            ^ reference scala/Int#`+`(+4).
//              ^ reference local1
//                ^ reference scala/Int#`+`(+4).
//                  ^ reference local2
//                    reference scala/concurrent/ExecutionContext.Implicits.global().
//                    reference scala/concurrent/Future#flatMap().
//                    reference local0
//                    reference scala/concurrent/Future#withFilter().
//                    reference local1
//                    reference scala/concurrent/ExecutionContext.Implicits.global().
//                    reference scala/concurrent/Future#flatMap().
//                    reference local1
//                    reference scala/concurrent/ExecutionContext.Implicits.global().
//                    reference scala/concurrent/Future#map().
//                    reference local2
//                    reference scala/concurrent/ExecutionContext.Implicits.global().
//                    reference scala/concurrent/ExecutionContext.Implicits.global().
//                    reference scala/concurrent/ExecutionContext.Implicits.global().
}
