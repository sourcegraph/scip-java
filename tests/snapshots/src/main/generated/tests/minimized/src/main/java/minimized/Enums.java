package minimized;
//^^^^^ reference semanticdb maven . . minimized/Enums#

import java.util.Arrays;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
import java.util.stream.Collectors;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^ reference semanticdb maven . . java/util/stream/
//                      ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/stream/Collectors#

enum Enums {
//   ^^^^^ definition semanticdb maven . . minimized/Enums#
//         documentation ```java\nenum Enums\n```
//         relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//         relationship is_implementation semanticdb maven jdk 11 java/lang/Comparable#
//         relationship is_implementation semanticdb maven jdk 11 java/lang/Enum#
  A("A", 420),
//^ definition semanticdb maven . . minimized/Enums#A.
//  documentation ```java\nEnums.A("A", 420) /* ordinal 0 */\n```
  B("B", 1),
//^ definition semanticdb maven . . minimized/Enums#B.
//  documentation ```java\nEnums.B("B", 1) /* ordinal 1 */\n```
  C("C", 5);
//^ definition semanticdb maven . . minimized/Enums#C.
//  documentation ```java\nEnums.C("C", 5) /* ordinal 2 */\n```
  public String value;
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^^^ definition semanticdb maven . . minimized/Enums#value.
//                    documentation ```java\npublic String value\n```

  Enums(String value, int a) {
//^^^^^ reference semanticdb maven . . minimized/Enums#`<init>`().
//^^^^^ reference semanticdb maven . . minimized/Enums#`<init>`().
//^^^^^ reference semanticdb maven . . minimized/Enums#`<init>`().
//^^^^^ definition semanticdb maven . . minimized/Enums#`<init>`().
//      documentation ```java\nprivate Enums(String value, int a)\n```
//      ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//             ^^^^^ definition local 0
//                   documentation ```java\nString value\n```
//                        ^ definition local 1
//                          documentation ```java\nint a\n```
    this.value = value;
//       ^^^^^ reference semanticdb maven . . minimized/Enums#value.
//               ^^^^^ reference local 0
  }

  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Enums#app().
//                         documentation ```java\npublic static String app()\n```
    String all = Arrays.stream(values()).map(e -> e.value).map(Enums::valueOf).collect(Collectors.toList()).toString();
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//         ^^^ definition local 2
//             documentation ```java\nString all\n```
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//                      ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#stream().
//                             ^^^^^^ reference semanticdb maven . . minimized/Enums#values().
//                                       ^^^ reference semanticdb maven jdk 11 java/util/stream/Stream#map().
//                                           ^ definition local 3
//                                             documentation ```java\nEnums e\n```
//                                                ^ reference local 3
//                                                  ^^^^^ reference semanticdb maven . . minimized/Enums#value.
//                                                         ^^^ reference semanticdb maven jdk 11 java/util/stream/Stream#map().
//                                                             ^^^^^ reference semanticdb maven . . minimized/Enums#
//                                                                    ^^^^^^^ reference semanticdb maven . . minimized/Enums#valueOf().
//                                                                             ^^^^^^^ reference semanticdb maven jdk 11 java/util/stream/Stream#collect(+1).
//                                                                                     ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/stream/Collectors#
//                                                                                                ^^^^^^ reference semanticdb maven jdk 11 java/util/stream/Collectors#toList().
//                                                                                                          ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#toString().
    return all + A.value + B.value + C.value;
//         ^^^ reference local 2
//               ^ reference semanticdb maven . . minimized/Enums#A.
//                 ^^^^^ reference semanticdb maven . . minimized/Enums#value.
//                         ^ reference semanticdb maven . . minimized/Enums#B.
//                           ^^^^^ reference semanticdb maven . . minimized/Enums#value.
//                                   ^ reference semanticdb maven . . minimized/Enums#C.
//                                     ^^^^^ reference semanticdb maven . . minimized/Enums#value.
  }
}
