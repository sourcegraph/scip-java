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
//         signature_documentation java enum Enums
//         enclosing_range 5 0 19 1
//         kind Enum
//         relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//         relationship is_implementation semanticdb maven jdk 11 java/lang/Comparable#
//         relationship is_implementation semanticdb maven jdk 11 java/lang/Enum#
  A("A", 420),
//^ definition semanticdb maven . . minimized/Enums#A.
//  display_name A("A", 420)
//  signature_documentation java Enums.A("A", 420) /* ordinal 0 */
//  enclosing_range 6 2 13
//^ reference semanticdb maven . . minimized/Enums#`<init>`().
  B("B", 1),
//^ definition semanticdb maven . . minimized/Enums#B.
//  display_name B("B", 1)
//  signature_documentation java Enums.B("B", 1) /* ordinal 1 */
//  enclosing_range 7 2 11
//^ reference semanticdb maven . . minimized/Enums#`<init>`().
  C("C", 5);
//^ definition semanticdb maven . . minimized/Enums#C.
//  display_name C("C", 5)
//  signature_documentation java Enums.C("C", 5) /* ordinal 2 */
//  enclosing_range 8 2 11
//^ reference semanticdb maven . . minimized/Enums#`<init>`().
  public String value;
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^^^ definition semanticdb maven . . minimized/Enums#value.
//                    display_name value
//                    signature_documentation java public String value
//                    enclosing_range 9 2 22
//                    kind Field

  Enums(String value, int a) {
//^^^^^ definition semanticdb maven . . minimized/Enums#`<init>`().
//      display_name <init>
//      signature_documentation java private Enums(String value, int a)
//      enclosing_range 11 2 13 3
//      kind Constructor
//      ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//             ^^^^^ definition local 0
//                   display_name value
//                   signature_documentation java String value
//                   enclosing_symbol semanticdb maven . . minimized/Enums#`<init>`().
//                   enclosing_range 11 8 20
//                        ^ definition local 1
//                          display_name a
//                          signature_documentation java int a
//                          enclosing_symbol semanticdb maven . . minimized/Enums#`<init>`().
//                          enclosing_range 11 22 27
    this.value = value;
//       ^^^^^ reference semanticdb maven . . minimized/Enums#value.
//               ^^^^^ reference local 0
  }

  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Enums#app().
//                         display_name app
//                         signature_documentation java public static String app()
//                         enclosing_range 15 2 18 3
//                         kind StaticMethod
    String all = Arrays.stream(values()).map(e -> e.value).map(Enums::valueOf).collect(Collectors.toList()).toString();
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//         ^^^ definition local 2
//             display_name all
//             signature_documentation java String all
//             enclosing_symbol semanticdb maven . . minimized/Enums#app().
//             enclosing_range 16 4 119
//             kind Variable
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//                      ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#stream().
//                             ^^^^^^ reference semanticdb maven . . minimized/Enums#values().
//                                       ^^^ reference semanticdb maven jdk 11 java/util/stream/Stream#map().
//                                           ^ definition local 3
//                                             display_name e
//                                             signature_documentation java Enums e
//                                             enclosing_symbol semanticdb maven . . minimized/Enums#app().
//                                             enclosing_range 16 45 46
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
