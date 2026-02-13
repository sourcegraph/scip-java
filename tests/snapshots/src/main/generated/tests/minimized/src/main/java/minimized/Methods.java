  package minimized;
  
//⌄ enclosing_range_start semanticdb maven . . minimized/Methods#
  public class Methods {
//             ^^^^^^^ definition semanticdb maven . . minimized/Methods#
//                     display_name Methods
//                     signature_documentation java public class Methods
//                     kind Class
//             ^^^^^^^ definition semanticdb maven . . minimized/Methods#`<init>`().
//                     display_name <init>
//                     signature_documentation java public Methods()
//                     kind Constructor
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Methods#overload().
//                       ⌄ enclosing_range_start local 0
    private int overload(int value) {
//              ^^^^^^^^ definition semanticdb maven . . minimized/Methods#overload().
//                       display_name overload
//                       signature_documentation java private int overload(int value)
//                       kind Method
//                           ^^^^^ definition local 0
//                                 display_name value
//                                 signature_documentation java int value
//                                 enclosing_symbol semanticdb maven . . minimized/Methods#overload().
//                               ⌃ enclosing_range_end local 0
      return value + 1;
//           ^^^^^ reference local 0
    }
//  ⌃ enclosing_range_end semanticdb maven . . minimized/Methods#overload().
  
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Methods#overload(+1).
//                          ⌄ enclosing_range_start local 1
    private String overload(String value) {
//          ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                 ^^^^^^^^ definition semanticdb maven . . minimized/Methods#overload(+1).
//                          display_name overload
//                          signature_documentation java private String overload(String value)
//                          kind Method
//                          ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                 ^^^^^ definition local 1
//                                       display_name value
//                                       signature_documentation java String value
//                                       enclosing_symbol semanticdb maven . . minimized/Methods#overload(+1).
//                                     ⌃ enclosing_range_end local 1
      return value + "1";
//           ^^^^^ reference local 1
    }
//  ⌃ enclosing_range_end semanticdb maven . . minimized/Methods#overload(+1).
  
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Methods#staticOverload().
//                                    ⌄ enclosing_range_start local 2
    private static int staticOverload(int value) {
//                     ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Methods#staticOverload().
//                                    display_name staticOverload
//                                    signature_documentation java private static int staticOverload(int value)
//                                    kind StaticMethod
//                                        ^^^^^ definition local 2
//                                              display_name value
//                                              signature_documentation java int value
//                                              enclosing_symbol semanticdb maven . . minimized/Methods#staticOverload().
//                                            ⌃ enclosing_range_end local 2
      return value + 1;
//           ^^^^^ reference local 2
    }
//  ⌃ enclosing_range_end semanticdb maven . . minimized/Methods#staticOverload().
  
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Methods#staticOverload(+1).
//                                       ⌄ enclosing_range_start local 3
    private static String staticOverload(String value) {
//                 ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                        ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Methods#staticOverload(+1).
//                                       display_name staticOverload
//                                       signature_documentation java private static String staticOverload(String value)
//                                       kind StaticMethod
//                                       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                              ^^^^^ definition local 3
//                                                    display_name value
//                                                    signature_documentation java String value
//                                                    enclosing_symbol semanticdb maven . . minimized/Methods#staticOverload(+1).
//                                                  ⌃ enclosing_range_end local 3
      return value + "1";
//           ^^^^^ reference local 3
    }
//  ⌃ enclosing_range_end semanticdb maven . . minimized/Methods#staticOverload(+1).
  
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Methods#app().
//                           ⌄ enclosing_range_start local 4
//                                  ⌄ enclosing_range_start local 5
    public static String app(int n, String m) throws RuntimeException, IndexOutOfBoundsException {
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                       ^^^ definition semanticdb maven . . minimized/Methods#app().
//                           display_name app
//                           signature_documentation java public static String app(int n, String m) throws RuntimeException, IndexOutOfBoundsException
//                           kind StaticMethod
//                               ^ definition local 4
//                                 display_name n
//                                 signature_documentation java int n
//                                 enclosing_symbol semanticdb maven . . minimized/Methods#app().
//                                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                         ^ definition local 5
//                                           display_name m
//                                           signature_documentation java String m
//                                           enclosing_symbol semanticdb maven . . minimized/Methods#app().
//                                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
//                                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#
//                               ⌃ enclosing_range_end local 4
//                                         ⌃ enclosing_range_end local 5
//    ⌄ enclosing_range_start local 6
      Methods methods = new Methods();
//    ^^^^^^^ reference semanticdb maven . . minimized/Methods#
//            ^^^^^^^ definition local 6
//                    display_name methods
//                    signature_documentation java Methods methods
//                    enclosing_symbol semanticdb maven . . minimized/Methods#app().
//                    kind Variable
//                          ^^^^^^^ reference semanticdb maven . . minimized/Methods#`<init>`().
//                                   ⌃ enclosing_range_end local 6
//    ⌄ enclosing_range_start local 7
      int a = staticOverload(n);
//        ^ definition local 7
//          display_name a
//          signature_documentation java int a
//          enclosing_symbol semanticdb maven . . minimized/Methods#app().
//          kind Variable
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Methods#staticOverload().
//                           ^ reference local 4
//                             ⌃ enclosing_range_end local 7
//    ⌄ enclosing_range_start local 8
      String b = staticOverload(m);
//    ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//           ^ definition local 8
//             display_name b
//             signature_documentation java String b
//             enclosing_symbol semanticdb maven . . minimized/Methods#app().
//             kind Variable
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Methods#staticOverload(+1).
//                              ^ reference local 5
//                                ⌃ enclosing_range_end local 8
//    ⌄ enclosing_range_start local 9
      int c = methods.overload(n);
//        ^ definition local 9
//          display_name c
//          signature_documentation java int c
//          enclosing_symbol semanticdb maven . . minimized/Methods#app().
//          kind Variable
//            ^^^^^^^ reference local 6
//                    ^^^^^^^^ reference semanticdb maven . . minimized/Methods#overload().
//                             ^ reference local 4
//                               ⌃ enclosing_range_end local 9
//    ⌄ enclosing_range_start local 10
      String d = methods.overload(m);
//    ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//           ^ definition local 10
//             display_name d
//             signature_documentation java String d
//             enclosing_symbol semanticdb maven . . minimized/Methods#app().
//             kind Variable
//               ^^^^^^^ reference local 6
//                       ^^^^^^^^ reference semanticdb maven . . minimized/Methods#overload(+1).
//                                ^ reference local 5
//                                  ⌃ enclosing_range_end local 10
      return b + a + c + d;
//           ^ reference local 8
//               ^ reference local 7
//                   ^ reference local 9
//                       ^ reference local 10
    }
//  ⌃ enclosing_range_end semanticdb maven . . minimized/Methods#app().
  }
//⌃ enclosing_range_end semanticdb maven . . minimized/Methods#
