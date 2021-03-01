package minimized;
^^^^^ reference minimized/Enums#

import java.util.Arrays;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^ reference java/util/Arrays#

public enum Enums {
//     ^^^^^ definition minimized/Enums#
  A("A"),
  ^ definition minimized/Enums#A.
   ^^^^^ reference minimized/Enums#`<init>`().
  B("B"),
  ^ definition minimized/Enums#B.
   ^^^^^ reference minimized/Enums#`<init>`().
  C("C");
  ^ definition minimized/Enums#C.
   ^^^^^ reference minimized/Enums#`<init>`().
  public String value;
//       ^^^^^^ reference java/lang/String#
//              ^^^^^ definition minimized/Enums#value.

  Enums(String value) {
  ^^^^^^ definition minimized/Enums#`<init>`().
//      ^^^^^^ reference java/lang/String#
//             ^^^^^ definition local0
    this.value = value;
//  ^^^^ reference minimized/Enums#this.
//       ^^^^^ reference minimized/Enums#value.
//               ^^^^^ reference local0
  }

  public static String app() {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/Enums#app().
    String all = Arrays.stream(values()).map(e -> e.value).map(Enums::valueOf).toString();
//  ^^^^^^ reference java/lang/String#
//         ^^^ definition local1
//               ^^^^^^ reference java/util/Arrays#
//                      ^^^^^^ reference java/util/Arrays#stream().
//                             ^^^^^^ reference minimized/Enums#values().
//                                       ^^^ reference java/util/stream/Stream#map().
//                                           ^ definition local2
//                                                ^ reference local2
//                                                  ^^^^^ reference minimized/Enums#value.
//                                                         ^^^ reference java/util/stream/Stream#map().
//                                                             ^^^^^ reference minimized/Enums#
//                                                             ^^^^^^^^^^^^^^ reference minimized/Enums#valueOf().
//                                                                             ^^^^^^^^ reference java/lang/Object#toString().
    return all + A.value + B.value + C.value;
//         ^^^ reference local1
//               ^ reference minimized/Enums#A.
//                 ^^^^^ reference minimized/Enums#value.
//                         ^ reference minimized/Enums#B.
//                           ^^^^^ reference minimized/Enums#value.
//                                   ^ reference minimized/Enums#C.
//                                     ^^^^^ reference minimized/Enums#value.
  }
}
