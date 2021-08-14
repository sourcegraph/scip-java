package minimized;
//^^^^^ reference minimized/Enums#

import java.util.Arrays;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^ reference java/util/Arrays#

enum Enums {
//   ^^^^^ definition minimized/Enums# enum Enums
  A("A", 420),
//^ definition minimized/Enums#A. Enums.A("A", 420) /* ordinal 0 */
  B("B", 1),
//^ definition minimized/Enums#B. Enums.B("B", 1) /* ordinal 1 */
  C("C", 5);
//^ definition minimized/Enums#C. Enums.C("C", 5) /* ordinal 2 */
  public String value;
//       ^^^^^^ reference java/lang/String#
//              ^^^^^ definition minimized/Enums#value. public String value

  Enums(String value, int a) {
//^^^^^ reference minimized/Enums#`<init>`().
//^^^^^ reference minimized/Enums#`<init>`().
//^^^^^ reference minimized/Enums#`<init>`().
//^^^^^ definition minimized/Enums#`<init>`(). private Enums(String value, int a)
//      ^^^^^^ reference java/lang/String#
//             ^^^^^ definition local0 String value
//                        ^ definition local1 int a
    this.value = value;
//       ^^^^^ reference minimized/Enums#value.
//               ^^^^^ reference local0
  }

  public static String app() {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/Enums#app(). public static String app()
    String all = Arrays.stream(values()).map(e -> e.value).map(Enums::valueOf).toString();
//  ^^^^^^ reference java/lang/String#
//         ^^^ definition local2 String all
//               ^^^^^^ reference java/util/Arrays#
//                      ^^^^^^ reference java/util/Arrays#stream().
//                             ^^^^^^ reference minimized/Enums#values().
//                                       ^^^ reference java/util/stream/Stream#map().
//                                           ^ definition local3 Enums e
//                                                ^ reference local3
//                                                  ^^^^^ reference minimized/Enums#value.
//                                                         ^^^ reference java/util/stream/Stream#map().
//                                                             ^^^^^ reference minimized/Enums#
//                                                                    ^^^^^^^ reference minimized/Enums#valueOf().
//                                                                             ^^^^^^^^ reference java/lang/Object#toString().
    return all + A.value + B.value + C.value;
//         ^^^ reference local2
//               ^ reference minimized/Enums#A.
//                 ^^^^^ reference minimized/Enums#value.
//                         ^ reference minimized/Enums#B.
//                           ^^^^^ reference minimized/Enums#value.
//                                   ^ reference minimized/Enums#C.
//                                     ^^^^^ reference minimized/Enums#value.
  }
}
