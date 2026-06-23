  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/Methods#
  public class Methods {
//             ^^^^^^^ definition scip-java maven . . minimized/Methods#
//                     kind Class
//                     display_name Methods
//                     signature_documentation
//                     > public class Methods
//             ^^^^^^^ definition scip-java maven . . minimized/Methods#`<init>`().
//                     kind Constructor
//                     display_name <init>
//                     signature_documentation
//                     > public Methods()
//  ⌄ enclosing_range_start scip-java maven . . minimized/Methods#overload().
//                       ⌄ enclosing_range_start local 0
    private int overload(int value) {
//              ^^^^^^^^ definition scip-java maven . . minimized/Methods#overload().
//                       kind Method
//                       display_name overload
//                       signature_documentation
//                       > private int overload(int value)
//                           ^^^^^ definition local 0
//                                 display_name value
//                                 signature_documentation
//                                 > int value
//                               ⌃ enclosing_range_end local 0
      return value + 1;
//           ^^^^^ reference local 0
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Methods#overload().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Methods#overload(+1).
//                          ⌄ enclosing_range_start local 1
    private String overload(String value) {
//          ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                 ^^^^^^^^ definition scip-java maven . . minimized/Methods#overload(+1).
//                          kind Method
//                          display_name overload
//                          signature_documentation
//                          > private String overload(String value)
//                          ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                                 ^^^^^ definition local 1
//                                       display_name value
//                                       signature_documentation
//                                       > String value
//                                     ⌃ enclosing_range_end local 1
      return value + "1";
//           ^^^^^ reference local 1
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Methods#overload(+1).
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Methods#staticOverload().
//                                    ⌄ enclosing_range_start local 2
    private static int staticOverload(int value) {
//                     ^^^^^^^^^^^^^^ definition scip-java maven . . minimized/Methods#staticOverload().
//                                    kind StaticMethod
//                                    display_name staticOverload
//                                    signature_documentation
//                                    > private static int staticOverload(int value)
//                                        ^^^^^ definition local 2
//                                              display_name value
//                                              signature_documentation
//                                              > int value
//                                            ⌃ enclosing_range_end local 2
      return value + 1;
//           ^^^^^ reference local 2
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Methods#staticOverload().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Methods#staticOverload(+1).
//                                       ⌄ enclosing_range_start local 3
    private static String staticOverload(String value) {
//                 ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                        ^^^^^^^^^^^^^^ definition scip-java maven . . minimized/Methods#staticOverload(+1).
//                                       kind StaticMethod
//                                       display_name staticOverload
//                                       signature_documentation
//                                       > private static String staticOverload(String value)
//                                       ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                                              ^^^^^ definition local 3
//                                                    display_name value
//                                                    signature_documentation
//                                                    > String value
//                                                  ⌃ enclosing_range_end local 3
      return value + "1";
//           ^^^^^ reference local 3
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Methods#staticOverload(+1).
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Methods#app().
//                           ⌄ enclosing_range_start local 4
//                                  ⌄ enclosing_range_start local 5
    public static String app(int n, String m) throws RuntimeException, IndexOutOfBoundsException {
//                ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                       ^^^ definition scip-java maven . . minimized/Methods#app().
//                           kind StaticMethod
//                           display_name app
//                           signature_documentation
//                           > public static String app(int n, String m) throws RuntimeException, IndexOutOfBoundsException
//                               ^ definition local 4
//                                 display_name n
//                                 signature_documentation
//                                 > int n
//                                  ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                                         ^ definition local 5
//                                           display_name m
//                                           signature_documentation
//                                           > String m
//                                                   ^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/RuntimeException#
//                                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/IndexOutOfBoundsException#
//                               ⌃ enclosing_range_end local 4
//                                         ⌃ enclosing_range_end local 5
//    ⌄ enclosing_range_start local 6
      Methods methods = new Methods();
//    ^^^^^^^ reference scip-java maven . . minimized/Methods#
//            ^^^^^^^ definition local 6
//                    kind Variable
//                    display_name methods
//                    signature_documentation
//                    > Methods methods
//                          ^^^^^^^ reference scip-java maven . . minimized/Methods#`<init>`().
//                                   ⌃ enclosing_range_end local 6
//    ⌄ enclosing_range_start local 7
      int a = staticOverload(n);
//        ^ definition local 7
//          kind Variable
//          display_name a
//          signature_documentation
//          > int a
//            ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/Methods#staticOverload().
//                           ^ reference local 4
//                             ⌃ enclosing_range_end local 7
//    ⌄ enclosing_range_start local 8
      String b = staticOverload(m);
//    ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//           ^ definition local 8
//             kind Variable
//             display_name b
//             signature_documentation
//             > String b
//               ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/Methods#staticOverload(+1).
//                              ^ reference local 5
//                                ⌃ enclosing_range_end local 8
//    ⌄ enclosing_range_start local 9
      int c = methods.overload(n);
//        ^ definition local 9
//          kind Variable
//          display_name c
//          signature_documentation
//          > int c
//            ^^^^^^^ reference local 6
//                    ^^^^^^^^ reference scip-java maven . . minimized/Methods#overload().
//                             ^ reference local 4
//                               ⌃ enclosing_range_end local 9
//    ⌄ enclosing_range_start local 10
      String d = methods.overload(m);
//    ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//           ^ definition local 10
//             kind Variable
//             display_name d
//             signature_documentation
//             > String d
//               ^^^^^^^ reference local 6
//                       ^^^^^^^^ reference scip-java maven . . minimized/Methods#overload(+1).
//                                ^ reference local 5
//                                  ⌃ enclosing_range_end local 10
      return b + a + c + d;
//           ^ reference local 8
//               ^ reference local 7
//                   ^ reference local 9
//                       ^ reference local 10
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Methods#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Methods#
  
