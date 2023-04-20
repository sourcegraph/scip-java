package minimized;

import java.util.HashMap;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#
import java.util.Iterator;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#
import java.util.Map;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^ reference semanticdb maven jdk 11 java/util/Map#

public class ParameterizedTypes<A, B extends String> {
//           ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#
//                              documentation ```java\npublic class ParameterizedTypes<A, B extends String>\n```
//           ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#`<init>`().
//                              documentation ```java\npublic ParameterizedTypes()\n```
//                              ^ definition semanticdb maven . . minimized/ParameterizedTypes#[A]
//                                documentation ```java\nA\n```
//                                 ^ definition semanticdb maven . . minimized/ParameterizedTypes#[B]
//                                   documentation ```java\nB extends String\n```
//                                           ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
  public <T extends Iterable<A> & Iterator<B>> void iteratorable(List<T> list) {}
//        ^ definition semanticdb maven . . minimized/ParameterizedTypes#iteratorable().[T]
//          documentation ```java\nT extends Iterable<A> & Iterator<B>\n```
//                  ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                           ^ reference semanticdb maven . . minimized/ParameterizedTypes#[A]
//                                ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//                                         ^ reference semanticdb maven . . minimized/ParameterizedTypes#[B]
//                                                  ^^^^^^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#iteratorable().
//                                                               documentation ```java\npublic <T extends Iterable<A> & Iterator<B>> void iteratorable(List<T> list)\n```
//                                                               ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                                    ^ reference semanticdb maven . . minimized/ParameterizedTypes#iteratorable().[T]
//                                                                       ^^^^ definition local 0
//                                                                            documentation ```java\nList<T> list\n```

  public String app(A a, B b) {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^ definition semanticdb maven . . minimized/ParameterizedTypes#app().
//                  documentation ```java\npublic String app(A a, B b)\n```
//                  ^ reference semanticdb maven . . minimized/ParameterizedTypes#[A]
//                    ^ definition local 1
//                      documentation ```java\nA a\n```
//                       ^ reference semanticdb maven . . minimized/ParameterizedTypes#[B]
//                         ^ definition local 2
//                           documentation ```java\nB b\n```
    return a.toString() + b;
//         ^ reference local 1
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#toString().
//                        ^ reference local 2
  }

  public Map<? extends String, ?> doStuff() { return null; }
//       ^^^ reference semanticdb maven jdk 11 java/util/Map#
//                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                ^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#doStuff().
//                                        documentation ```java\npublic Map<? extends String, ?> doStuff()\n```

  public Quadruplet<String, ?, Object, ? super Integer> createQuadruplet() { return null; }
//       ^^^^^^^^^^ reference semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                             ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                             ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                                                      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#createQuadruplet().
//                                                                       documentation ```java\npublic Quadruplet<String, ?, Object, ? super Integer> createQuadruplet()\n```

  public static class Quadruplet<T, S, X, Y> {}
//                    ^^^^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#
//                               documentation ```java\npublic static class Quadruplet<T, S, X, Y>\n```
//                    ^^^^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#`<init>`().
//                               documentation ```java\npublic Quadruplet()\n```
//                               ^ definition semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#[T]
//                                 documentation ```java\nT\n```
//                                  ^ definition semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#[S]
//                                    documentation ```java\nS\n```
//                                     ^ definition semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#[X]
//                                       documentation ```java\nX\n```
//                                        ^ definition semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#[Y]
//                                          documentation ```java\nY\n```
}
