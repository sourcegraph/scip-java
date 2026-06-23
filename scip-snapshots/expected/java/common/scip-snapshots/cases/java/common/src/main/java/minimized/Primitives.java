  package minimized;
  
  import java.util.Random;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^^^ reference scip-java maven jdk 11 java/util/Random#
  
//⌄ enclosing_range_start scip-java maven . . minimized/Primitives#
  public class Primitives {
//             ^^^^^^^^^^ definition scip-java maven . . minimized/Primitives#
//                        kind Class
//                        display_name Primitives
//                        signature_documentation
//                        > public class Primitives
//             ^^^^^^^^^^ definition scip-java maven . . minimized/Primitives#`<init>`().
//                        kind Constructor
//                        display_name <init>
//                        signature_documentation
//                        > public Primitives()
//  ⌄ enclosing_range_start scip-java maven . . minimized/Primitives#app().
    public static String app() {
//                ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                       ^^^ definition scip-java maven . . minimized/Primitives#app().
//                           kind StaticMethod
//                           display_name app
//                           signature_documentation
//                           > public static String app()
//    ⌄ enclosing_range_start local 0
      Random random = new Random();
//    ^^^^^^ reference scip-java maven jdk 11 java/util/Random#
//           ^^^^^^ definition local 0
//                  kind Variable
//                  display_name random
//                  signature_documentation
//                  > Random random
//                        ^^^^^^ reference scip-java maven jdk 11 java/util/Random#`<init>`().
//                                ⌃ enclosing_range_end local 0
//    ⌄ enclosing_range_start local 1
      byte a = (byte) random.nextInt();
//         ^ definition local 1
//           kind Variable
//           display_name a
//           signature_documentation
//           > byte a
//                    ^^^^^^ reference local 0
//                           ^^^^^^^ reference scip-java maven jdk 11 java/util/Random#nextInt().
//                                    ⌃ enclosing_range_end local 1
//    ⌄ enclosing_range_start local 2
      short b = (short) random.nextInt();
//          ^ definition local 2
//            kind Variable
//            display_name b
//            signature_documentation
//            > short b
//                      ^^^^^^ reference local 0
//                             ^^^^^^^ reference scip-java maven jdk 11 java/util/Random#nextInt().
//                                      ⌃ enclosing_range_end local 2
//    ⌄ enclosing_range_start local 3
      int c = random.nextInt();
//        ^ definition local 3
//          kind Variable
//          display_name c
//          signature_documentation
//          > int c
//            ^^^^^^ reference local 0
//                   ^^^^^^^ reference scip-java maven jdk 11 java/util/Random#nextInt().
//                            ⌃ enclosing_range_end local 3
//    ⌄ enclosing_range_start local 4
      long d = random.nextLong();
//         ^ definition local 4
//           kind Variable
//           display_name d
//           signature_documentation
//           > long d
//             ^^^^^^ reference local 0
//                    ^^^^^^^^ reference scip-java maven jdk 11 java/util/Random#nextLong().
//                              ⌃ enclosing_range_end local 4
//    ⌄ enclosing_range_start local 5
      char e = (char) random.nextInt();
//         ^ definition local 5
//           kind Variable
//           display_name e
//           signature_documentation
//           > char e
//                    ^^^^^^ reference local 0
//                           ^^^^^^^ reference scip-java maven jdk 11 java/util/Random#nextInt().
//                                    ⌃ enclosing_range_end local 5
//    ⌄ enclosing_range_start local 6
      float f = (float) random.nextDouble();
//          ^ definition local 6
//            kind Variable
//            display_name f
//            signature_documentation
//            > float f
//                      ^^^^^^ reference local 0
//                             ^^^^^^^^^^ reference scip-java maven jdk 11 java/util/Random#nextDouble().
//                                         ⌃ enclosing_range_end local 6
//    ⌄ enclosing_range_start local 7
      double g = (double) random.nextDouble();
//           ^ definition local 7
//             kind Variable
//             display_name g
//             signature_documentation
//             > double g
//                        ^^^^^^ reference local 0
//                               ^^^^^^^^^^ reference scip-java maven jdk 11 java/util/Random#nextDouble().
//                                           ⌃ enclosing_range_end local 7
//    ⌄ enclosing_range_start local 8
      boolean h = random.nextBoolean();
//            ^ definition local 8
//              kind Variable
//              display_name h
//              signature_documentation
//              > boolean h
//                ^^^^^^ reference local 0
//                       ^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/Random#nextBoolean().
//                                    ⌃ enclosing_range_end local 8
      return "" + a + b + c + d + e + f + g + h;
//                ^ reference local 1
//                    ^ reference local 2
//                        ^ reference local 3
//                            ^ reference local 4
//                                ^ reference local 5
//                                    ^ reference local 6
//                                        ^ reference local 7
//                                            ^ reference local 8
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Primitives#app().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Primitives#test().
    public static void test() {}
//                     ^^^^ definition scip-java maven . . minimized/Primitives#test().
//                          kind StaticMethod
//                          display_name test
//                          signature_documentation
//                          > public static void test()
//                             ⌃ enclosing_range_end scip-java maven . . minimized/Primitives#test().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Primitives#
  
