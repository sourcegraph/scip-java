package minimized;

import java.util.Random;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/Random#

public class Primitives {
//           ^^^^^^^^^^ definition semanticdb maven . . minimized/Primitives#
//                      documentation ```java\npublic class Primitives\n```
//           ^^^^^^^^^^ definition semanticdb maven . . minimized/Primitives#`<init>`().
//                      documentation ```java\npublic Primitives()\n```
  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Primitives#app().
//                         documentation ```java\npublic static String app()\n```
    Random random = new Random();
//  ^^^^^^ reference semanticdb maven jdk 11 java/util/Random#
//         ^^^^^^ definition local 0
//                documentation ```java\nRandom random\n```
//                      ^^^^^^ reference semanticdb maven jdk 11 java/util/Random#`<init>`().
    byte a = (byte) random.nextInt();
//       ^ definition local 1
//         documentation ```java\nbyte a\n```
//                  ^^^^^^ reference local 0
//                         ^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextInt().
    short b = (short) random.nextInt();
//        ^ definition local 2
//          documentation ```java\nshort b\n```
//                    ^^^^^^ reference local 0
//                           ^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextInt().
    int c = random.nextInt();
//      ^ definition local 3
//        documentation ```java\nint c\n```
//          ^^^^^^ reference local 0
//                 ^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextInt().
    long d = random.nextLong();
//       ^ definition local 4
//         documentation ```java\nlong d\n```
//           ^^^^^^ reference local 0
//                  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextLong().
    char e = (char) random.nextInt();
//       ^ definition local 5
//         documentation ```java\nchar e\n```
//                  ^^^^^^ reference local 0
//                         ^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextInt().
    float f = (float) random.nextDouble();
//        ^ definition local 6
//          documentation ```java\nfloat f\n```
//                    ^^^^^^ reference local 0
//                           ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextDouble().
    double g = (double) random.nextDouble();
//         ^ definition local 7
//           documentation ```java\ndouble g\n```
//                      ^^^^^^ reference local 0
//                             ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Random#nextDouble().
    boolean h = random.nextBoolean();
//          ^ definition local 8
//            documentation ```java\nboolean h\n```
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
//                        documentation ```java\npublic static void test()\n```
}
