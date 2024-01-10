package minimized;

public class Methods {
//           ^^^^^^^ definition semanticdb maven . . minimized/Methods#
//                   display_name Methods
//                   signature_documentation java public class Methods
//                   kind Class
//           ^^^^^^^ definition semanticdb maven . . minimized/Methods#`<init>`().
//                   display_name <init>
//                   signature_documentation java public Methods()
//                   kind Constructor
  private int overload(int value) {
//            ^^^^^^^^ definition semanticdb maven . . minimized/Methods#overload().
//                     display_name overload
//                     signature_documentation java private int overload(int value)
//                     kind Method
//                         ^^^^^ definition local 0
//                               display_name value
//                               signature_documentation java int value
//                               enclosing_symbol semanticdb maven . . minimized/Methods#overload().
    return value + 1;
//         ^^^^^ reference local 0
  }

  private String overload(String value) {
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//               ^^^^^^^^ definition semanticdb maven . . minimized/Methods#overload(+1).
//                        display_name overload
//                        signature_documentation java private String overload(String value)
//                        kind Method
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                               ^^^^^ definition local 1
//                                     display_name value
//                                     signature_documentation java String value
//                                     enclosing_symbol semanticdb maven . . minimized/Methods#overload(+1).
    return value + "1";
//         ^^^^^ reference local 1
  }

  private static int staticOverload(int value) {
//                   ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Methods#staticOverload().
//                                  display_name staticOverload
//                                  signature_documentation java private static int staticOverload(int value)
//                                  kind StaticMethod
//                                      ^^^^^ definition local 2
//                                            display_name value
//                                            signature_documentation java int value
//                                            enclosing_symbol semanticdb maven . . minimized/Methods#staticOverload().
    return value + 1;
//         ^^^^^ reference local 2
  }

  private static String staticOverload(String value) {
//               ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                      ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Methods#staticOverload(+1).
//                                     display_name staticOverload
//                                     signature_documentation java private static String staticOverload(String value)
//                                     kind StaticMethod
//                                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                            ^^^^^ definition local 3
//                                                  display_name value
//                                                  signature_documentation java String value
//                                                  enclosing_symbol semanticdb maven . . minimized/Methods#staticOverload(+1).
    return value + "1";
//         ^^^^^ reference local 3
  }

  public static String app(int n, String m) throws RuntimeException, IndexOutOfBoundsException {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Methods#app().
//                         display_name app
//                         signature_documentation java public static String app(int n, String m) throws RuntimeException, IndexOutOfBoundsException
//                         kind StaticMethod
//                             ^ definition local 4
//                               display_name n
//                               signature_documentation java int n
//                               enclosing_symbol semanticdb maven . . minimized/Methods#app().
//                                ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                       ^ definition local 5
//                                         display_name m
//                                         signature_documentation java String m
//                                         enclosing_symbol semanticdb maven . . minimized/Methods#app().
//                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
//                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#
    Methods methods = new Methods();
//  ^^^^^^^ reference semanticdb maven . . minimized/Methods#
//          ^^^^^^^ definition local 6
//                  display_name methods
//                  signature_documentation java Methods methods
//                  enclosing_symbol semanticdb maven . . minimized/Methods#app().
//                  kind Variable
//                        ^^^^^^^ reference semanticdb maven . . minimized/Methods#`<init>`().
    int a = staticOverload(n);
//      ^ definition local 7
//        display_name a
//        signature_documentation java int a
//        enclosing_symbol semanticdb maven . . minimized/Methods#app().
//        kind Variable
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Methods#staticOverload().
//                         ^ reference local 4
    String b = staticOverload(m);
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//         ^ definition local 8
//           display_name b
//           signature_documentation java String b
//           enclosing_symbol semanticdb maven . . minimized/Methods#app().
//           kind Variable
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Methods#staticOverload(+1).
//                            ^ reference local 5
    int c = methods.overload(n);
//      ^ definition local 9
//        display_name c
//        signature_documentation java int c
//        enclosing_symbol semanticdb maven . . minimized/Methods#app().
//        kind Variable
//          ^^^^^^^ reference local 6
//                  ^^^^^^^^ reference semanticdb maven . . minimized/Methods#overload().
//                           ^ reference local 4
    String d = methods.overload(m);
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//         ^ definition local 10
//           display_name d
//           signature_documentation java String d
//           enclosing_symbol semanticdb maven . . minimized/Methods#app().
//           kind Variable
//             ^^^^^^^ reference local 6
//                     ^^^^^^^^ reference semanticdb maven . . minimized/Methods#overload(+1).
//                              ^ reference local 5
    return b + a + c + d;
//         ^ reference local 8
//             ^ reference local 7
//                 ^ reference local 9
//                     ^ reference local 10
  }
}
