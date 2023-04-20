package minimized;

public class Methods {
//           ^^^^^^^ definition semanticdb maven . . minimized/Methods#
//                   documentation ```java\npublic class Methods\n```
//           ^^^^^^^ definition semanticdb maven . . minimized/Methods#`<init>`().
//                   documentation ```java\npublic Methods()\n```
  private int overload(int value) {
//            ^^^^^^^^ definition semanticdb maven . . minimized/Methods#overload().
//                     documentation ```java\nprivate int overload(int value)\n```
//                         ^^^^^ definition local 0
//                               documentation ```java\nint value\n```
    return value + 1;
//         ^^^^^ reference local 0
  }

  private String overload(String value) {
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//               ^^^^^^^^ definition semanticdb maven . . minimized/Methods#overload(+1).
//                        documentation ```java\nprivate String overload(String value)\n```
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                               ^^^^^ definition local 1
//                                     documentation ```java\nString value\n```
    return value + "1";
//         ^^^^^ reference local 1
  }

  private static int staticOverload(int value) {
//                   ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Methods#staticOverload().
//                                  documentation ```java\nprivate static int staticOverload(int value)\n```
//                                      ^^^^^ definition local 2
//                                            documentation ```java\nint value\n```
    return value + 1;
//         ^^^^^ reference local 2
  }

  private static String staticOverload(String value) {
//               ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                      ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Methods#staticOverload(+1).
//                                     documentation ```java\nprivate static String staticOverload(String value)\n```
//                                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                            ^^^^^ definition local 3
//                                                  documentation ```java\nString value\n```
    return value + "1";
//         ^^^^^ reference local 3
  }

  public static String app(int n, String m) throws RuntimeException, IndexOutOfBoundsException {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Methods#app().
//                         documentation ```java\npublic static String app(int n, String m) throws RuntimeException, IndexOutOfBoundsException\n```
//                             ^ definition local 4
//                               documentation ```java\nint n\n```
//                                ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                       ^ definition local 5
//                                         documentation ```java\nString m\n```
//                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
//                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#
    Methods methods = new Methods();
//  ^^^^^^^ reference semanticdb maven . . minimized/Methods#
//          ^^^^^^^ definition local 6
//                  documentation ```java\nMethods methods\n```
//                        ^^^^^^^ reference semanticdb maven . . minimized/Methods#`<init>`().
    int a = staticOverload(n);
//      ^ definition local 7
//        documentation ```java\nint a\n```
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Methods#staticOverload().
//                         ^ reference local 4
    String b = staticOverload(m);
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//         ^ definition local 8
//           documentation ```java\nString b\n```
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Methods#staticOverload(+1).
//                            ^ reference local 5
    int c = methods.overload(n);
//      ^ definition local 9
//        documentation ```java\nint c\n```
//          ^^^^^^^ reference local 6
//                  ^^^^^^^^ reference semanticdb maven . . minimized/Methods#overload().
//                           ^ reference local 4
    String d = methods.overload(m);
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//         ^ definition local 10
//           documentation ```java\nString d\n```
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
