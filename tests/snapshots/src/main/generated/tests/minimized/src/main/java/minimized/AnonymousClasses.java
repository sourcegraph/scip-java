  package minimized;
  
  import java.util.function.Function;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^^^^^ reference scip-java maven . . java/util/function/
//                          ^^^^^^^^ reference scip-java maven jdk 11 java/util/function/Function#
  
//⌄ enclosing_range_start scip-java maven . . minimized/AnonymousClasses#
  @SuppressWarnings("ALL")
// ^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/SuppressWarnings#
  public class AnonymousClasses {
//             ^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/AnonymousClasses#
//                              kind Class
//                              display_name AnonymousClasses
//                              signature_documentation
//                              > @SuppressWarnings("ALL")
//                              > public class AnonymousClasses
//             ^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/AnonymousClasses#`<init>`().
//                              kind Constructor
//                              display_name <init>
//                              signature_documentation
//                              > public AnonymousClasses()
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnonymousClasses#app().
//                        ⌄ enclosing_range_start local 0
    public static int app(int n) {
//                    ^^^ definition scip-java maven . . minimized/AnonymousClasses#app().
//                        kind StaticMethod
//                        display_name app
//                        signature_documentation
//                        > public static int app(int n)
//                            ^ definition local 0
//                              display_name n
//                              signature_documentation
//                              > int n
//                            ⌃ enclosing_range_end local 0
//    ⌄ enclosing_range_start local 1
      Function<Integer, Integer> fn =
//    ^^^^^^^^ reference scip-java maven jdk 11 java/util/function/Function#
//             ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//                      ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//                               ^^ definition local 1
//                                  kind Variable
//                                  display_name fn
//                                  signature_documentation
//                                  > Function<Integer, Integer> fn
          new Function<Integer, Integer>() {
//            ^^^^^^^^ reference scip-java maven jdk 11 java/util/function/Function#
//                     ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//                              ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//          ⌄ enclosing_range_start local 3
            @Override
//           ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Override#
//                               ⌄ enclosing_range_start local 4
            public Integer apply(Integer integer) {
//                 ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//                         ^^^^^ definition local 3
//                               kind Method
//                               display_name apply
//                               signature_documentation
//                               > @Override
//                               > public Integer apply(Integer integer)
//                               relationship scip-java maven jdk 11 java/util/function/Function#apply(). implementation reference
//                               ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//                                       ^^^^^^^ definition local 4
//                                               display_name integer
//                                               signature_documentation
//                                               > Integer integer
//                                             ⌃ enclosing_range_end local 4
              return integer + n;
//                   ^^^^^^^ reference local 4
//                             ^ reference local 0
            }
//          ⌃ enclosing_range_end local 3
          };
//         ⌃ enclosing_range_end local 1
  
      return fn.apply(n);
//           ^^ reference local 1
//              ^^^^^ reference scip-java maven jdk 11 java/util/function/Function#apply().
//                    ^ reference local 0
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnonymousClasses#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/AnonymousClasses#
  
