package minimized
//      ^^^^^^^^^ definition semanticdb maven . . minimized/

import scala.concurrent.ExecutionContext.Implicits.global
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^^^ reference semanticdb maven . . scala/concurrent/
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . scala/concurrent/ExecutionContext.
//                                       ^^^^^^^^^ reference semanticdb maven . . scala/concurrent/ExecutionContext.Implicits.
//                                                 ^^^^^^ reference semanticdb maven . . scala/concurrent/ExecutionContext.Implicits.global().
import scala.concurrent.Future
//     ^^^^^ reference semanticdb maven . . scala/
//           ^^^^^^^^^^ reference semanticdb maven . . scala/concurrent/
//                      ^^^^^^ reference semanticdb maven . . scala/concurrent/Future#
//                      ^^^^^^ reference semanticdb maven . . scala/concurrent/Future.

class MinimizedScalaSynthetic {
//    ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSynthetic#
//                            display_name MinimizedScalaSynthetic
//                            documentation ```scala\nclass MinimizedScalaSynthetic\n```
//                            ^ definition semanticdb maven . . minimized/MinimizedScalaSynthetic#`<init>`().
//                              display_name <init>
//                              documentation ```scala\ndef this()\n```
  def everything(): Unit = Future(1)
//    ^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSynthetic#everything().
//               display_name everything
//               documentation ```scala\ndef everything(): Unit\n```
//                  ^^^^ reference semanticdb maven . . scala/Unit#
//                         ^^^^^^ reference semanticdb maven . . scala/concurrent/Future.
//                               ^ reference semanticdb maven . . scala/concurrent/Future.apply().
//                                  ^ reference semanticdb maven . . scala/concurrent/ExecutionContext.Implicits.global().
  def applyTree(): Unit = Future.apply[Int](1)
//    ^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSynthetic#applyTree().
//              display_name applyTree
//              documentation ```scala\ndef applyTree(): Unit\n```
//                 ^^^^ reference semanticdb maven . . scala/Unit#
//                        ^^^^^^ reference semanticdb maven . . scala/concurrent/Future.
//                               ^^^^^ reference semanticdb maven . . scala/concurrent/Future.apply().
//                                     ^^^ reference semanticdb maven . . scala/Int#
//                                            ^ reference semanticdb maven . . scala/concurrent/ExecutionContext.Implicits.global().
  def applyTree2(): Unit = List.apply[Int](1).sorted
//    ^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSynthetic#applyTree2().
//               display_name applyTree2
//               documentation ```scala\ndef applyTree2(): Unit\n```
//                  ^^^^ reference semanticdb maven . . scala/Unit#
//                         ^^^^ reference semanticdb maven . . scala/package.List.
//                              ^^^^^ reference semanticdb maven . . scala/collection/IterableFactory#apply().
//                                    ^^^ reference semanticdb maven . . scala/Int#
//                                            ^^^^^^ reference semanticdb maven . . scala/collection/immutable/StrictOptimizedSeqOps#sorted().
//                                                  ^ reference semanticdb maven . . scala/math/Ordering.Int.
  def selectTree(): Unit = Future[Int](1)
//    ^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSynthetic#selectTree().
//               display_name selectTree
//               documentation ```scala\ndef selectTree(): Unit\n```
//                  ^^^^ reference semanticdb maven . . scala/Unit#
//                         ^^^^^^ reference semanticdb maven . . scala/concurrent/Future.
//                               ^ reference semanticdb maven . . scala/concurrent/Future.apply().
//                                ^^^ reference semanticdb maven . . scala/Int#
//                                       ^ reference semanticdb maven . . scala/concurrent/ExecutionContext.Implicits.global().
  def typeApplyTree(): Unit = Future.apply(1)
//    ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSynthetic#typeApplyTree().
//                  display_name typeApplyTree
//                  documentation ```scala\ndef typeApplyTree(): Unit\n```
//                     ^^^^ reference semanticdb maven . . scala/Unit#
//                            ^^^^^^ reference semanticdb maven . . scala/concurrent/Future.
//                                   ^^^^^ reference semanticdb maven . . scala/concurrent/Future.apply().
//                                           ^ reference semanticdb maven . . scala/concurrent/ExecutionContext.Implicits.global().
  def forComprehensions(): Unit =
//    ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedScalaSynthetic#forComprehensions().
//                      display_name forComprehensions
//                      documentation ```scala\ndef forComprehensions(): Unit\n```
//                         ^^^^ reference semanticdb maven . . scala/Unit#
    for {
      x <- Future(1)
//    ^ definition local 0
//      display_name x
//      documentation ```scala\nx: Int \n```
//         ^^^^^^ reference semanticdb maven . . scala/concurrent/Future.
//               ^ reference semanticdb maven . . scala/concurrent/Future.apply().
      y <- Future.successful(1)
//    ^ definition local 1
//      display_name y
//      documentation ```scala\ny: Int \n```
//         ^^^^^^ reference semanticdb maven . . scala/concurrent/Future.
//                ^^^^^^^^^^ reference semanticdb maven . . scala/concurrent/Future.successful().
      if y < 2
//       ^ reference local 1
//         ^ reference semanticdb maven . . scala/Int#`<`(+3).
      z <- Future.apply[Int](1)
//    ^ definition local 2
//      display_name z
//      documentation ```scala\nz: Int \n```
//         ^^^^^^ reference semanticdb maven . . scala/concurrent/Future.
//                ^^^^^ reference semanticdb maven . . scala/concurrent/Future.apply().
//                      ^^^ reference semanticdb maven . . scala/Int#
    } yield x + y + z
//          ^ reference local 0
//            ^ reference semanticdb maven . . scala/Int#`+`(+4).
//              ^ reference local 1
//                ^ reference semanticdb maven . . scala/Int#`+`(+4).
//                  ^ reference local 2
//                   ^ reference local 0
//                   ^ reference local 1
//                   ^ reference local 1
//                   ^ reference local 2
//                   ^ reference semanticdb maven . . scala/concurrent/ExecutionContext.Implicits.global().
//                   ^ reference semanticdb maven . . scala/concurrent/ExecutionContext.Implicits.global().
//                   ^ reference semanticdb maven . . scala/concurrent/ExecutionContext.Implicits.global().
//                   ^ reference semanticdb maven . . scala/concurrent/ExecutionContext.Implicits.global().
//                   ^ reference semanticdb maven . . scala/concurrent/ExecutionContext.Implicits.global().
//                   ^ reference semanticdb maven . . scala/concurrent/ExecutionContext.Implicits.global().
//                   ^ reference semanticdb maven . . scala/concurrent/Future#flatMap().
//                   ^ reference semanticdb maven . . scala/concurrent/Future#flatMap().
//                   ^ reference semanticdb maven . . scala/concurrent/Future#map().
//                   ^ reference semanticdb maven . . scala/concurrent/Future#withFilter().
}
