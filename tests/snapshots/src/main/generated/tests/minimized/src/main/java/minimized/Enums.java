  package minimized;
  
  import java.util.Arrays;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^^^ reference scip-java maven jdk 11 java/util/Arrays#
  import java.util.stream.Collectors;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^^^ reference scip-java maven . . java/util/stream/
//                        ^^^^^^^^^^ reference scip-java maven jdk 11 java/util/stream/Collectors#
  
//⌄ enclosing_range_start scip-java maven . . minimized/Enums#
  enum Enums {
//     ^^^^^ definition scip-java maven . . minimized/Enums#
//           display_name Enums
//           signature_documentation java final enum Enums extends Enum<Enums>
//           kind Enum
//           relationship is_implementation scip-java maven jdk 11 java/io/Serializable#
//           relationship is_implementation scip-java maven jdk 11 java/lang/Comparable#
//           relationship is_implementation scip-java maven jdk 11 java/lang/Enum#
//  ⌄ enclosing_range_start scip-java maven . . minimized/Enums#A.
    A("A", 420),
//  ^ definition scip-java maven . . minimized/Enums#A.
//    display_name A("A", 420)
//    signature_documentation java public static final A
//    kind EnumMember
//  ^ reference scip-java maven . . minimized/Enums#`<init>`().
//            ⌃ enclosing_range_end scip-java maven . . minimized/Enums#A.
//  ⌄ enclosing_range_start scip-java maven . . minimized/Enums#B.
    B("B", 1),
//  ^ definition scip-java maven . . minimized/Enums#B.
//    display_name B("B", 1)
//    signature_documentation java public static final B
//    kind EnumMember
//  ^ reference scip-java maven . . minimized/Enums#`<init>`().
//          ⌃ enclosing_range_end scip-java maven . . minimized/Enums#B.
//  ⌄ enclosing_range_start scip-java maven . . minimized/Enums#C.
    C("C", 5);
//  ^ definition scip-java maven . . minimized/Enums#C.
//    display_name C("C", 5)
//    signature_documentation java public static final C
//    kind EnumMember
//  ^ reference scip-java maven . . minimized/Enums#`<init>`().
//          ⌃ enclosing_range_end scip-java maven . . minimized/Enums#C.
//  ⌄ enclosing_range_start scip-java maven . . minimized/Enums#value.
    public String value;
//         ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                ^^^^^ definition scip-java maven . . minimized/Enums#value.
//                      display_name value
//                      signature_documentation java public String value
//                      kind Field
//                     ⌃ enclosing_range_end scip-java maven . . minimized/Enums#value.
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Enums#`<init>`().
//        ⌄ enclosing_range_start local 0
//                      ⌄ enclosing_range_start local 1
    Enums(String value, int a) {
//  ^^^^^ definition scip-java maven . . minimized/Enums#`<init>`().
//        display_name <init>
//        signature_documentation java private Enums(String value, int a)
//        kind Constructor
//        ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//               ^^^^^ definition local 0
//                     display_name value
//                     signature_documentation java String value
//                     enclosing_symbol scip-java maven . . minimized/Enums#`<init>`().
//                     kind Parameter
//                          ^ definition local 1
//                            display_name a
//                            signature_documentation java int a
//                            enclosing_symbol scip-java maven . . minimized/Enums#`<init>`().
//                            kind Parameter
//                   ⌃ enclosing_range_end local 0
//                          ⌃ enclosing_range_end local 1
      this.value = value;
//         ^^^^^ reference scip-java maven . . minimized/Enums#value.
//                 ^^^^^ reference local 0
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Enums#`<init>`().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Enums#app().
    public static String app() {
//                ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                       ^^^ definition scip-java maven . . minimized/Enums#app().
//                           display_name app
//                           signature_documentation java public static String app()
//                           kind StaticMethod
//    ⌄ enclosing_range_start local 2
//                                             ⌄ enclosing_range_start local 3
      String all = Arrays.stream(values()).map(e -> e.value).map(Enums::valueOf).collect(Collectors.toList()).toString();
//    ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//           ^^^ definition local 2
//               display_name all
//               signature_documentation java String all
//               enclosing_symbol scip-java maven . . minimized/Enums#app().
//               kind Variable
//                 ^^^^^^ reference scip-java maven jdk 11 java/util/Arrays#
//                        ^^^^^^ reference scip-java maven jdk 11 java/util/Arrays#stream().
//                               ^^^^^^ reference scip-java maven . . minimized/Enums#values().
//                                         ^^^ reference scip-java maven jdk 11 java/util/stream/Stream#map().
//                                             ^ definition local 3
//                                               display_name e
//                                               signature_documentation java Enums e
//                                               enclosing_symbol scip-java maven . . minimized/Enums#app().
//                                               kind Parameter
//                                                  ^ reference local 3
//                                                    ^^^^^ reference scip-java maven . . minimized/Enums#value.
//                                                           ^^^ reference scip-java maven jdk 11 java/util/stream/Stream#map().
//                                                               ^^^^^ reference scip-java maven . . minimized/Enums#
//                                                                      ^^^^^^^ reference scip-java maven . . minimized/Enums#valueOf().
//                                                                               ^^^^^^^ reference scip-java maven jdk 11 java/util/stream/Stream#collect(+1).
//                                                                                       ^^^^^^^^^^ reference scip-java maven jdk 11 java/util/stream/Collectors#
//                                                                                                  ^^^^^^ reference scip-java maven jdk 11 java/util/stream/Collectors#toList().
//                                                                                                            ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Object#toString().
//                                             ⌃ enclosing_range_end local 3
//                                                                                                                      ⌃ enclosing_range_end local 2
      return all + A.value + B.value + C.value;
//           ^^^ reference local 2
//                 ^ reference scip-java maven . . minimized/Enums#A.
//                   ^^^^^ reference scip-java maven . . minimized/Enums#value.
//                           ^ reference scip-java maven . . minimized/Enums#B.
//                             ^^^^^ reference scip-java maven . . minimized/Enums#value.
//                                     ^ reference scip-java maven . . minimized/Enums#C.
//                                       ^^^^^ reference scip-java maven . . minimized/Enums#value.
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Enums#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Enums#
