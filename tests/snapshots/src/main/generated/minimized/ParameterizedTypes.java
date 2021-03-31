package minimized;

import java.util.HashMap;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^ reference java/util/HashMap#
import java.util.Iterator;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^ reference java/util/Iterator#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#
import java.util.Map;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^ reference java/util/Map#

public class ParameterizedTypes<A, B extends String> {
//           ^^^^^^^^^^^^^^^^^^ definition minimized/ParameterizedTypes# public class ParameterizedTypes<A, B extends String>
//           ^^^^^^^^^^^^^^^^^^ definition minimized/ParameterizedTypes#`<init>`(). public void <init>()
//                              ^ definition minimized/ParameterizedTypes#[A] A
//                                 ^ definition minimized/ParameterizedTypes#[B] B extends String
//                                           ^^^^^^ reference java/lang/String#
  public <T extends Iterable<A> & Iterator<B>> void iteratorable(List<T> list) {}
//        ^ definition minimized/ParameterizedTypes#iteratorable().[T] T extends Iterable<A> & Iterator<B>
//                  ^^^^^^^^ reference java/lang/Iterable#
//                           ^ reference minimized/ParameterizedTypes#[A]
//                                ^^^^^^^^ reference java/util/Iterator#
//                                         ^ reference minimized/ParameterizedTypes#[B]
//                                                  ^^^^^^^^^^^^ definition minimized/ParameterizedTypes#iteratorable(). public <T extends Iterable<A> & Iterator<B>> void iteratorable(List<T> list)
//                                                               ^^^^ reference java/util/List#
//                                                                    ^ reference minimized/ParameterizedTypes#iteratorable().[T]
//                                                                       ^^^^ definition local0 List<T> list

  public String app(A a, B b) {
//       ^^^^^^ reference java/lang/String#
//              ^^^ definition minimized/ParameterizedTypes#app(). public String app(A a, B b)
//                  ^ reference minimized/ParameterizedTypes#[A]
//                    ^ definition local1 A a
//                       ^ reference minimized/ParameterizedTypes#[B]
//                         ^ definition local2 B b
    return a.toString() + b;
//         ^ reference local1
//           ^^^^^^^^ reference java/lang/Object#toString().
//                        ^ reference local2
  }

  public Map<? extends String, ?> doStuff() { return null; }
//       ^^^ reference java/util/Map#
//                     ^^^^^^ reference java/lang/String#
//                                ^^^^^^^ definition minimized/ParameterizedTypes#doStuff(). public Map<? extends String, ?> doStuff()

  public Quadruplet<String, ?, Object, ? super Integer> createQuadruplet() { return null; }
//       ^^^^^^^^^^ reference minimized/ParameterizedTypes#Quadruplet#
//                  ^^^^^^ reference java/lang/String#
//                             ^^^^^^ reference java/lang/Object#
//                                             ^^^^^^^ reference java/lang/Integer#
//                                                      ^^^^^^^^^^^^^^^^ definition minimized/ParameterizedTypes#createQuadruplet(). public Quadruplet<String, ?, Object, ? super Integer> createQuadruplet()

  public static class Quadruplet<T, S, X, Y> {}
//                    ^^^^^^^^^^ definition minimized/ParameterizedTypes#Quadruplet# public static class Quadruplet<T, S, X, Y>
//                    ^^^^^^^^^^ definition minimized/ParameterizedTypes#Quadruplet#`<init>`(). public void <init>()
//                               ^ definition minimized/ParameterizedTypes#Quadruplet#[T] T
//                                  ^ definition minimized/ParameterizedTypes#Quadruplet#[S] S
//                                     ^ definition minimized/ParameterizedTypes#Quadruplet#[X] X
//                                        ^ definition minimized/ParameterizedTypes#Quadruplet#[Y] Y
}
