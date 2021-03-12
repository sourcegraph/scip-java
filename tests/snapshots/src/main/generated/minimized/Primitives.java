package minimized;

import java.util.Random;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^ reference java/util/Random#

public class Primitives {
//           ^^^^^^^^^^ definition minimized/Primitives#
//           ^^^^^^^^^^ definition minimized/Primitives#`<init>`().
  public static String app() {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/Primitives#app().
    Random random = new Random();
//  ^^^^^^ reference java/util/Random#
//         ^^^^^^ definition local0
//                  ^^^^^^^^^^^^ reference java/util/Random#`<init>`().
//                      ^^^^^^ reference java/util/Random#
    byte a = (byte) random.nextInt();
//       ^ definition local1
//                  ^^^^^^ reference local0
//                         ^^^^^^^ reference java/util/Random#nextInt().
    short b = (short) random.nextInt();
//        ^ definition local2
//                    ^^^^^^ reference local0
//                           ^^^^^^^ reference java/util/Random#nextInt().
    int c = random.nextInt();
//      ^ definition local3
//          ^^^^^^ reference local0
//                 ^^^^^^^ reference java/util/Random#nextInt().
    long d = random.nextLong();
//       ^ definition local4
//           ^^^^^^ reference local0
//                  ^^^^^^^^ reference java/util/Random#nextLong().
    char e = (char) random.nextInt();
//       ^ definition local5
//                  ^^^^^^ reference local0
//                         ^^^^^^^ reference java/util/Random#nextInt().
    float f = (float) random.nextDouble();
//        ^ definition local6
//                    ^^^^^^ reference local0
//                           ^^^^^^^^^^ reference java/util/Random#nextDouble().
    double g = (double) random.nextDouble();
//         ^ definition local7
//                      ^^^^^^ reference local0
//                             ^^^^^^^^^^ reference java/util/Random#nextDouble().
    boolean h = random.nextBoolean();
//          ^ definition local8
//              ^^^^^^ reference local0
//                     ^^^^^^^^^^^ reference java/util/Random#nextBoolean().
    return "" + a + b + c + d + e + f + g + h;
//              ^ reference local1
//                  ^ reference local2
//                      ^ reference local3
//                          ^ reference local4
//                              ^ reference local5
//                                  ^ reference local6
//                                      ^ reference local7
//                                          ^ reference local8
  }
}
