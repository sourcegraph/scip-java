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
//                              display_name ParameterizedTypes
//                              signature_documentation java public class ParameterizedTypes<A, B extends String>
//                              enclosing_range 7 0 19 1
//                              kind Class
//           ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#`<init>`().
//                              display_name <init>
//                              signature_documentation java public ParameterizedTypes()
//                              kind Constructor
//                              ^ definition semanticdb maven . . minimized/ParameterizedTypes#[A]
//                                display_name A
//                                signature_documentation java A
//                                enclosing_range 7 0 19 1
//                                kind TypeParameter
//                                 ^ definition semanticdb maven . . minimized/ParameterizedTypes#[B]
//                                   display_name B
//                                   signature_documentation java B extends String
//                                   enclosing_range 7 0 19 1
//                                   kind TypeParameter
//                                           ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
  public <T extends Iterable<A> & Iterator<B>> void iteratorable(List<T> list) {}
//        ^ definition semanticdb maven . . minimized/ParameterizedTypes#iteratorable().[T]
//          display_name T
//          signature_documentation java T extends Iterable<A> & Iterator<B>
//          enclosing_range 8 2 81
//          kind TypeParameter
//                  ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                           ^ reference semanticdb maven . . minimized/ParameterizedTypes#[A]
//                                ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//                                         ^ reference semanticdb maven . . minimized/ParameterizedTypes#[B]
//                                                  ^^^^^^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#iteratorable().
//                                                               display_name iteratorable
//                                                               signature_documentation java public <T extends Iterable<A> & Iterator<B>> void iteratorable(List<T> list)
//                                                               enclosing_range 8 2 81
//                                                               kind Method
//                                                               ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                                    ^ reference semanticdb maven . . minimized/ParameterizedTypes#iteratorable().[T]
//                                                                       ^^^^ definition local 0
//                                                                            display_name list
//                                                                            signature_documentation java List<T> list
//                                                                            enclosing_symbol semanticdb maven . . minimized/ParameterizedTypes#iteratorable().
//                                                                            enclosing_range 8 65 77

  public String app(A a, B b) {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^ definition semanticdb maven . . minimized/ParameterizedTypes#app().
//                  display_name app
//                  signature_documentation java public String app(A a, B b)
//                  enclosing_range 10 2 12 3
//                  kind Method
//                  ^ reference semanticdb maven . . minimized/ParameterizedTypes#[A]
//                    ^ definition local 1
//                      display_name a
//                      signature_documentation java A a
//                      enclosing_symbol semanticdb maven . . minimized/ParameterizedTypes#app().
//                      enclosing_range 10 20 23
//                       ^ reference semanticdb maven . . minimized/ParameterizedTypes#[B]
//                         ^ definition local 2
//                           display_name b
//                           signature_documentation java B b
//                           enclosing_symbol semanticdb maven . . minimized/ParameterizedTypes#app().
//                           enclosing_range 10 25 28
    return a.toString() + b;
//         ^ reference local 1
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#toString().
//                        ^ reference local 2
  }

  public Map<? extends String, ?> doStuff() { return null; }
//       ^^^ reference semanticdb maven jdk 11 java/util/Map#
//                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                ^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#doStuff().
//                                        display_name doStuff
//                                        signature_documentation java public Map<? extends String, ?> doStuff()
//                                        enclosing_range 14 2 60
//                                        kind Method

  public Quadruplet<String, ?, Object, ? super Integer> createQuadruplet() { return null; }
//       ^^^^^^^^^^ reference semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                             ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                             ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                                                      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#createQuadruplet().
//                                                                       display_name createQuadruplet
//                                                                       signature_documentation java public Quadruplet<String, ?, Object, ? super Integer> createQuadruplet()
//                                                                       enclosing_range 16 2 91
//                                                                       kind Method

  public static class Quadruplet<T, S, X, Y> {}
//                    ^^^^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#
//                               display_name Quadruplet
//                               signature_documentation java public static class Quadruplet<T, S, X, Y>
//                               enclosing_range 18 2 47
//                               kind Class
//                    ^^^^^^^^^^ definition semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#`<init>`().
//                               display_name <init>
//                               signature_documentation java public Quadruplet()
//                               kind Constructor
//                               ^ definition semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#[T]
//                                 display_name T
//                                 signature_documentation java T
//                                 enclosing_range 18 2 47
//                                 kind TypeParameter
//                                  ^ definition semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#[S]
//                                    display_name S
//                                    signature_documentation java S
//                                    enclosing_range 18 2 47
//                                    kind TypeParameter
//                                     ^ definition semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#[X]
//                                       display_name X
//                                       signature_documentation java X
//                                       enclosing_range 18 2 47
//                                       kind TypeParameter
//                                        ^ definition semanticdb maven . . minimized/ParameterizedTypes#Quadruplet#[Y]
//                                          display_name Y
//                                          signature_documentation java Y
//                                          enclosing_range 18 2 47
//                                          kind TypeParameter
}
