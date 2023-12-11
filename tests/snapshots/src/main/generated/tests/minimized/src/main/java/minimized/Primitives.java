package minimized;

import java.util.Random;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/Random#

public class Primitives {
//           ^^^^^^^^^^ definition semanticdb maven . . minimized/Primitives#
//                      display_name Primitives
//                      signature_documentation java public class Primitives
//           ^^^^^^^^^^ definition semanticdb maven . . minimized/Primitives#`<init>`().
//                      display_name <init>
//                      signature_documentation java public Primitives()
  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Primitives#app().
//                         display_name app
//                         signature_documentation java public static String app()
    Random random = new Random();
//  ^^^^^^ reference semanticdb maven jdk 11 java/util/Random#
//         ^^^^^^ definition local 0
//                display_name random
//                signature_documentation java Random random
//                      ^^^^^^ reference semanticdb maven jdk 11 java/util/Random#`<init>`().
    byte a = (byte) random.nextInt();
//       ^ definition local 1
//         display_name a
//         signature_documentation java byte a
//                  ^^^^^^ reference local 0
//                         ^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextInt().
    short b = (short) random.nextInt();
//        ^ definition local 2
//          display_name b
//          signature_documentation java short b
//                    ^^^^^^ reference local 0
//                           ^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextInt().
    int c = random.nextInt();
//      ^ definition local 3
//        display_name c
//        signature_documentation java int c
//          ^^^^^^ reference local 0
//                 ^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextInt().
    long d = random.nextLong();
//       ^ definition local 4
//         display_name d
//         signature_documentation java long d
//           ^^^^^^ reference local 0
//                  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextLong().
    char e = (char) random.nextInt();
//       ^ definition local 5
//         display_name e
//         signature_documentation java char e
//                  ^^^^^^ reference local 0
//                         ^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextInt().
    float f = (float) random.nextDouble();
//        ^ definition local 6
//          display_name f
//          signature_documentation java float f
//                    ^^^^^^ reference local 0
//                           ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextDouble().
    double g = (double) random.nextDouble();
//         ^ definition local 7
//           display_name g
//           signature_documentation java double g
//                      ^^^^^^ reference local 0
//                             ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextDouble().
    boolean h = random.nextBoolean();
//          ^ definition local 8
//            display_name h
//            signature_documentation java boolean h
//              ^^^^^^ reference local 0
//                     ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextBoolean().
    return "" + a + b + c + d + e + f + g + h;
//              ^ reference local 1
//                  ^ reference local 2
//                      ^ reference local 3
//                          ^ reference local 4
//                              ^ reference local 5
//                                  ^ reference local 6
//                                      ^ reference local 7
//                                          ^ reference local 8
  }

  public static void test() {}
//                   ^^^^ definition semanticdb maven . . minimized/Primitives#test().
//                        display_name test
//                        signature_documentation java public static void test()
}
