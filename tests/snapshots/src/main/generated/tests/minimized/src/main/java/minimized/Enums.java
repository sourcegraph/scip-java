package minimized;

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
//         display_name Enums
//         documentation ```java\nenum Enums\n```
//         relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//         relationship is_implementation semanticdb maven jdk 11 java/lang/Comparable#
//         relationship is_implementation semanticdb maven jdk 11 java/lang/Enum#
  A("A", 420),
//^ definition semanticdb maven . . minimized/Enums#A.
//  display_name A("A", 420)
//  documentation ```java\nEnums.A("A", 420) /* ordinal 0 */\n```
//^ reference semanticdb maven . . minimized/Enums#`<init>`().
  B("B", 1),
//^ definition semanticdb maven . . minimized/Enums#B.
//  display_name B("B", 1)
//  documentation ```java\nEnums.B("B", 1) /* ordinal 1 */\n```
//^ reference semanticdb maven . . minimized/Enums#`<init>`().
  C("C", 5);
//^ definition semanticdb maven . . minimized/Enums#C.
//  display_name C("C", 5)
//  documentation ```java\nEnums.C("C", 5) /* ordinal 2 */\n```
//^ reference semanticdb maven . . minimized/Enums#`<init>`().
  public String value;
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^^^ definition semanticdb maven . . minimized/Enums#value.
//                    display_name value
//                    documentation ```java\npublic String value\n```

  Enums(String value, int a) {
//^^^^^ definition semanticdb maven . . minimized/Enums#`<init>`().
//      display_name <init>
//      documentation ```java\nprivate Enums(String value, int a)\n```
//      ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//             ^^^^^ definition local 0
//                   display_name value
//                   documentation ```java\nString value\n```
//                        ^ definition local 1
//                          display_name a
//                          documentation ```java\nint a\n```
    this.value = value;
//       ^^^^^ reference semanticdb maven . . minimized/Enums#value.
//               ^^^^^ reference local 0
  }

  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Enums#app().
//                         display_name app
//                         documentation ```java\npublic static String app()\n```
    String all = Arrays.stream(values()).map(e -> e.value).map(Enums::valueOf).collect(Collectors.toList()).toString();
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//         ^^^ definition local 2
//             display_name all
//             documentation ```java\nString all\n```
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//                      ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#stream().
//                             ^^^^^^ reference semanticdb maven . . minimized/Enums#values().
//                                       ^^^ reference semanticdb maven jdk 11 java/util/stream/Stream#map().
//                                           ^ definition local 3
//                                             display_name e
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
