  package minimized;
  
  import java.util.HashMap;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^^^^ reference scip-java maven jdk 11 java/util/HashMap#
  import java.util.Iterator;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^^^^^ reference scip-java maven jdk 11 java/util/Iterator#
  import java.util.List;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^ reference scip-java maven jdk 11 java/util/List#
  import java.util.Map;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^ reference scip-java maven jdk 11 java/util/Map#
  
//⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#
//⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#[A]
//⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#[B]
  public class ParameterizedTypes<A, B extends String> {
//             ^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/ParameterizedTypes#
//                                kind Class
//                                display_name ParameterizedTypes
//                                signature_documentation
//                                > public class ParameterizedTypes<A, B extends String>
//             ^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/ParameterizedTypes#`<init>`().
//                                kind Constructor
//                                display_name <init>
//                                signature_documentation
//                                > public ParameterizedTypes()
//                                ^ definition scip-java maven . . minimized/ParameterizedTypes#[A]
//                                  kind TypeParameter
//                                  display_name A
//                                  signature_documentation
//                                  > A
//                                   ^ definition scip-java maven . . minimized/ParameterizedTypes#[B]
//                                     kind TypeParameter
//                                     display_name B
//                                     signature_documentation
//                                     > B extends String
//                                             ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//  ⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#iteratorable().[T]
//  ⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#iteratorable().
//                                                                 ⌄ enclosing_range_start local 0
    public <T extends Iterable<A> & Iterator<B>> void iteratorable(List<T> list) {}
//          ^ definition scip-java maven . . minimized/ParameterizedTypes#iteratorable().[T]
//            kind TypeParameter
//            display_name T
//            signature_documentation
//            > T extends Iterable<A> & Iterator<B>
//                    ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Iterable#
//                             ^ reference scip-java maven . . minimized/ParameterizedTypes#[A]
//                                  ^^^^^^^^ reference scip-java maven jdk 11 java/util/Iterator#
//                                           ^ reference scip-java maven . . minimized/ParameterizedTypes#[B]
//                                                    ^^^^^^^^^^^^ definition scip-java maven . . minimized/ParameterizedTypes#iteratorable().
//                                                                 kind Method
//                                                                 display_name iteratorable
//                                                                 signature_documentation
//                                                                 > public <T extends Iterable<A> & Iterator<B>> void iteratorable(List<T> list)
//                                                                 ^^^^ reference scip-java maven jdk 11 java/util/List#
//                                                                      ^ reference scip-java maven . . minimized/ParameterizedTypes#iteratorable().[T]
//                                                                         ^^^^ definition local 0
//                                                                              display_name list
//                                                                              signature_documentation
//                                                                              > List<T> list
//                                                                            ⌃ enclosing_range_end local 0
//                                                                                ⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#iteratorable().[T]
//                                                                                ⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#iteratorable().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#app().
//                    ⌄ enclosing_range_start local 1
//                         ⌄ enclosing_range_start local 2
    public String app(A a, B b) {
//         ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                ^^^ definition scip-java maven . . minimized/ParameterizedTypes#app().
//                    kind Method
//                    display_name app
//                    signature_documentation
//                    > public String app(A a, B b)
//                    ^ reference scip-java maven . . minimized/ParameterizedTypes#[A]
//                      ^ definition local 1
//                        display_name a
//                        signature_documentation
//                        > A a
//                         ^ reference scip-java maven . . minimized/ParameterizedTypes#[B]
//                           ^ definition local 2
//                             display_name b
//                             signature_documentation
//                             > B b
//                      ⌃ enclosing_range_end local 1
//                           ⌃ enclosing_range_end local 2
      return a.toString() + b;
//           ^ reference local 1
//             ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Object#toString().
//                          ^ reference local 2
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#app().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#doStuff().
    public Map<? extends String, ?> doStuff() { return null; }
//         ^^^ reference scip-java maven jdk 11 java/util/Map#
//                       ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                                  ^^^^^^^ definition scip-java maven . . minimized/ParameterizedTypes#doStuff().
//                                          kind Method
//                                          display_name doStuff
//                                          signature_documentation
//                                          > public Map<? extends String, ?> doStuff()
//                                                           ⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#doStuff().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#createQuadruplet().
    public Quadruplet<String, ?, Object, ? super Integer> createQuadruplet() { return null; }
//         ^^^^^^^^^^ reference scip-java maven . . minimized/ParameterizedTypes#Quadruplet#
//                    ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                               ^^^^^^ reference scip-java maven jdk 11 java/lang/Object#
//                                               ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//                                                        ^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/ParameterizedTypes#createQuadruplet().
//                                                                         kind Method
//                                                                         display_name createQuadruplet
//                                                                         signature_documentation
//                                                                         > public Quadruplet<String, ?, Object, ? super Integer> createQuadruplet()
//                                                                                          ⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#createQuadruplet().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#Quadruplet#
//  ⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#Quadruplet#[T]
//  ⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#Quadruplet#[S]
//  ⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#Quadruplet#[X]
//  ⌄ enclosing_range_start scip-java maven . . minimized/ParameterizedTypes#Quadruplet#[Y]
    public static class Quadruplet<T, S, X, Y> {}
//                      ^^^^^^^^^^ definition scip-java maven . . minimized/ParameterizedTypes#Quadruplet#
//                                 kind Class
//                                 display_name Quadruplet
//                                 signature_documentation
//                                 > public static class Quadruplet<T, S, X, Y>
//                      ^^^^^^^^^^ definition scip-java maven . . minimized/ParameterizedTypes#Quadruplet#`<init>`().
//                                 kind Constructor
//                                 display_name <init>
//                                 signature_documentation
//                                 > public Quadruplet()
//                                 ^ definition scip-java maven . . minimized/ParameterizedTypes#Quadruplet#[T]
//                                   kind TypeParameter
//                                   display_name T
//                                   signature_documentation
//                                   > T
//                                    ^ definition scip-java maven . . minimized/ParameterizedTypes#Quadruplet#[S]
//                                      kind TypeParameter
//                                      display_name S
//                                      signature_documentation
//                                      > S
//                                       ^ definition scip-java maven . . minimized/ParameterizedTypes#Quadruplet#[X]
//                                         kind TypeParameter
//                                         display_name X
//                                         signature_documentation
//                                         > X
//                                          ^ definition scip-java maven . . minimized/ParameterizedTypes#Quadruplet#[Y]
//                                            kind TypeParameter
//                                            display_name Y
//                                            signature_documentation
//                                            > Y
//                                              ⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#Quadruplet#
//                                              ⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#Quadruplet#[T]
//                                              ⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#Quadruplet#[S]
//                                              ⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#Quadruplet#[X]
//                                              ⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#Quadruplet#[Y]
  }
//⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#
//⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#[A]
//⌃ enclosing_range_end scip-java maven . . minimized/ParameterizedTypes#[B]
  
