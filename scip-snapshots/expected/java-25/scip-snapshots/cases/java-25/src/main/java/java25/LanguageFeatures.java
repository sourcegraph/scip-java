  package java25;
  
  import module java.base;
  
  /// Exercises language features that require Java 22 through Java 25 source support.
//⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#
  public class LanguageFeatures {
//             ^^^^^^^^^^^^^^^^ definition scip-java maven . . java25/LanguageFeatures#
//                              kind Class
//                              display_name LanguageFeatures
//                              signature_documentation
//                              > public class LanguageFeatures
//                              documentation
//                              > Exercises language features that require Java 22 through Java 25 source support.
//             ^^^^^^^^^^^^^^^^ definition scip-java maven . . java25/LanguageFeatures#`<init>`().
//                              kind Constructor
//                              display_name <init>
//                              signature_documentation
//                              > public LanguageFeatures()
    /// Java 22 unnamed variables and unnamed record patterns.
//  ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#unnamedVariablesAndPatterns().
//                                                ⌄ enclosing_range_start local 0
    public static int unnamedVariablesAndPatterns(Object input) {
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . java25/LanguageFeatures#unnamedVariablesAndPatterns().
//                                                kind StaticMethod
//                                                display_name unnamedVariablesAndPatterns
//                                                signature_documentation
//                                                > public static int unnamedVariablesAndPatterns(Object input)
//                                                documentation
//                                                > Java 22 unnamed variables and unnamed record patterns.
//                                                ^^^^^^ reference scip-java maven jdk 25 java/lang/Object#
//                                                       ^^^^^ definition local 0
//                                                             display_name input
//                                                             signature_documentation
//                                                             > Object input
//                                                           ⌃ enclosing_range_end local 0
//    ⌄ enclosing_range_start local 1
      int seen = 0;
//        ^^^^ definition local 1
//             kind Variable
//             display_name seen
//             signature_documentation
//             > int seen
//                ⌃ enclosing_range_end local 1
      for (String _ : List.of("alpha", "beta")) {
//         ^^^^^^ reference scip-java maven jdk 25 java/lang/String#
//                    ^^^^ reference scip-java maven jdk 25 java/util/List#
//                         ^^ reference scip-java maven jdk 25 java/util/List#of(+2).
        seen++;
//      ^^^^ reference local 1
      }
      try {
        Integer.parseInt("not-a-number");
//      ^^^^^^^ reference scip-java maven jdk 25 java/lang/Integer#
//              ^^^^^^^^ reference scip-java maven jdk 25 java/lang/Integer#parseInt(+1).
      } catch (NumberFormatException _) {
//             ^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven jdk 25 java/lang/NumberFormatException#
        seen++;
//      ^^^^ reference local 1
      }
//                               ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#unnamedVariablesAndPatterns().start.
      if (input instanceof Range(int start, int _)) {
//        ^^^^^ reference local 0
//                         ^^^^^ reference scip-java maven . . java25/LanguageFeatures#Range#
//                                   ^^^^^ definition scip-java maven . . java25/LanguageFeatures#unnamedVariablesAndPatterns().start.
//                                         display_name start
//                                         signature_documentation
//                                         > int start
//                                       ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#unnamedVariablesAndPatterns().start.
        return start + seen;
//             ^^^^^ reference scip-java maven . . java25/LanguageFeatures#unnamedVariablesAndPatterns().start.
//                     ^^^^ reference local 1
      }
      return seen;
//           ^^^^ reference local 1
    }
//  ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#unnamedVariablesAndPatterns().
  
    /// Java 24/25 primitive patterns in switch.
//  ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#primitivePatterns().
//                                         ⌄ enclosing_range_start local 2
    public static String primitivePatterns(int value) {
//                ^^^^^^ reference scip-java maven jdk 25 java/lang/String#
//                       ^^^^^^^^^^^^^^^^^ definition scip-java maven . . java25/LanguageFeatures#primitivePatterns().
//                                         kind StaticMethod
//                                         display_name primitivePatterns
//                                         signature_documentation
//                                         > public static String primitivePatterns(int value)
//                                         documentation
//                                         > Java 24/25 primitive patterns in switch.
//                                             ^^^^^ definition local 2
//                                                   display_name value
//                                                   signature_documentation
//                                                   > int value
//                                                 ⌃ enclosing_range_end local 2
      return switch (value) {
//                   ^^^^^ reference local 2
        case byte _ -> "byte range";
//           ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#primitivePatterns().i.
        case int i when i > 0 -> "positive int";
//               ^ definition scip-java maven . . java25/LanguageFeatures#primitivePatterns().i.
//                 display_name i
//                 signature_documentation
//                 > int i
//                      ^ reference scip-java maven . . java25/LanguageFeatures#primitivePatterns().i.
//               ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#primitivePatterns().i.
        case int _ -> "int";
      };
    }
//  ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#primitivePatterns().
  
    /// Java 25 flexible constructor bodies.
//  ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#Child#
    public static final class Child extends Parent {
//                            ^^^^^ definition scip-java maven . . java25/LanguageFeatures#Child#
//                                  kind Class
//                                  display_name Child
//                                  signature_documentation
//                                  > public static final class Child extends Parent
//                                  documentation
//                                  > Java 25 flexible constructor bodies.
//                                  relationship scip-java maven . . java25/LanguageFeatures#Parent# implementation
//                                          ^^^^^^ reference scip-java maven . . java25/LanguageFeatures#Parent#
//    ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#Child#`<init>`().
//                 ⌄ enclosing_range_start local 3
      public Child(String input) {
//           ^^^^^ definition scip-java maven . . java25/LanguageFeatures#Child#`<init>`().
//                 kind Constructor
//                 display_name <init>
//                 signature_documentation
//                 > public Child(String input)
//                 ^^^^^^ reference scip-java maven jdk 25 java/lang/String#
//                        ^^^^^ definition local 3
//                              display_name input
//                              signature_documentation
//                              > String input
//                            ⌃ enclosing_range_end local 3
//      ⌄ enclosing_range_start local 4
        String normalized = Objects.requireNonNull(input).strip();
//      ^^^^^^ reference scip-java maven jdk 25 java/lang/String#
//             ^^^^^^^^^^ definition local 4
//                        kind Variable
//                        display_name normalized
//                        signature_documentation
//                        > String normalized
//                          ^^^^^^^ reference scip-java maven jdk 25 java/util/Objects#
//                                  ^^^^^^^^^^^^^^ reference scip-java maven jdk 25 java/util/Objects#requireNonNull(+1).
//                                                 ^^^^^ reference local 3
//                                                        ^^^^^ reference scip-java maven jdk 25 java/lang/String#strip().
//                                                               ⌃ enclosing_range_end local 4
        if (normalized.isEmpty()) {
//          ^^^^^^^^^^ reference local 4
//                     ^^^^^^^ reference scip-java maven jdk 25 java/lang/String#isEmpty().
          throw new IllegalArgumentException("blank");
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven jdk 25 java/lang/IllegalArgumentException#`<init>`(+1).
        }
        super(normalized);
//      ^^^^^ reference scip-java maven . . java25/LanguageFeatures#Parent#`<init>`().
//            ^^^^^^^^^^ reference local 4
      }
//    ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#Child#`<init>`().
    }
//  ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#Child#
  
//  ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#Parent#
    public static sealed class Parent permits Child {
//                             ^^^^^^ definition scip-java maven . . java25/LanguageFeatures#Parent#
//                                    kind Class
//                                    display_name Parent
//                                    signature_documentation
//                                    > public static class Parent
//                                            ^^^^^ reference scip-java maven . . java25/LanguageFeatures#Child#
//    ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#Parent#value.
      private final String value;
//                  ^^^^^^ reference scip-java maven jdk 25 java/lang/String#
//                         ^^^^^ definition scip-java maven . . java25/LanguageFeatures#Parent#value.
//                               kind Field
//                               display_name value
//                               signature_documentation
//                               > private final String value
//                              ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#Parent#value.
  
//    ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#Parent#`<init>`().
//                     ⌄ enclosing_range_start local 5
      protected Parent(String value) {
//              ^^^^^^ definition scip-java maven . . java25/LanguageFeatures#Parent#`<init>`().
//                     kind Constructor
//                     display_name <init>
//                     signature_documentation
//                     > protected Parent(String value)
//                     ^^^^^^ reference scip-java maven jdk 25 java/lang/String#
//                            ^^^^^ definition local 5
//                                  display_name value
//                                  signature_documentation
//                                  > String value
//                                ⌃ enclosing_range_end local 5
        this.value = value;
//           ^^^^^ reference scip-java maven . . java25/LanguageFeatures#Parent#value.
//                   ^^^^^ reference local 5
      }
//    ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#Parent#`<init>`().
  
//    ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#Parent#value().
      public String value() {
//           ^^^^^^ reference scip-java maven jdk 25 java/lang/String#
//                  ^^^^^ definition scip-java maven . . java25/LanguageFeatures#Parent#value().
//                        kind Method
//                        display_name value
//                        signature_documentation
//                        > public String value()
        return value;
//             ^^^^^ reference scip-java maven . . java25/LanguageFeatures#Parent#value.
      }
//    ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#Parent#value().
    }
//  ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#Parent#
  
//  ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#Range#
//                      ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#Range#start.
//                                 ⌄ enclosing_range_start scip-java maven . . java25/LanguageFeatures#Range#end.
    public record Range(int start, int end) {}
//                ^^^^^ definition scip-java maven . . java25/LanguageFeatures#Range#
//                      display_name Range
//                      signature_documentation
//                      > public static final Range
//                      relationship scip-java maven jdk 25 java/lang/Record# implementation
//                ^^^^^ definition scip-java maven . . java25/LanguageFeatures#Range#`<init>`().
//                      kind Constructor
//                      display_name <init>
//                      signature_documentation
//                      > public Range(int start, int end)
//                          ^^^^^ definition local 6
//                                display_name start
//                                signature_documentation
//                                > int start
//                          ^^^^^ definition scip-java maven . . java25/LanguageFeatures#Range#start.
//                                kind Field
//                                display_name start
//                                signature_documentation
//                                > private final int start
//                                     ^^^ definition local 7
//                                         display_name end
//                                         signature_documentation
//                                         > int end
//                                     ^^^ definition scip-java maven . . java25/LanguageFeatures#Range#end.
//                                         kind Field
//                                         display_name end
//                                         signature_documentation
//                                         > private final int end
//                              ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#Range#start.
//                                       ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#Range#end.
//                                           ⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#Range#
  }
//⌃ enclosing_range_end scip-java maven . . java25/LanguageFeatures#
  
