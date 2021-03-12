package minimized;

public class Methods {
//           ^^^^^^^ definition minimized/Methods#
//           ^^^^^^^ definition minimized/Methods#`<init>`().
  private int overload(int value) {
//            ^^^^^^^^ definition minimized/Methods#overload().
//                         ^^^^^ definition local0
    return value + 1;
//         ^^^^^ reference local0
  }

  private String overload(String value) {
//        ^^^^^^ reference java/lang/String#
//               ^^^^^^^^ definition minimized/Methods#overload(+1).
//                        ^^^^^^ reference java/lang/String#
//                               ^^^^^ definition local1
    return value + "1";
//         ^^^^^ reference local1
  }

  private static int staticOverload(int value) {
//                   ^^^^^^^^^^^^^^ definition minimized/Methods#staticOverload().
//                                      ^^^^^ definition local2
    return value + 1;
//         ^^^^^ reference local2
  }

  private static String staticOverload(String value) {
//               ^^^^^^ reference java/lang/String#
//                      ^^^^^^^^^^^^^^ definition minimized/Methods#staticOverload(+1).
//                                     ^^^^^^ reference java/lang/String#
//                                            ^^^^^ definition local3
    return value + "1";
//         ^^^^^ reference local3
  }

  public static String app(int n, String m) {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/Methods#app().
//                             ^ definition local4
//                                ^^^^^^ reference java/lang/String#
//                                       ^ definition local5
    Methods methods = new Methods();
//  ^^^^^^^ reference minimized/Methods#
//          ^^^^^^^ definition local6
//                    ^^^^^^^^^^^^^ reference minimized/Methods#`<init>`().
//                        ^^^^^^^ reference minimized/Methods#
    int a = staticOverload(n);
//      ^ definition local7
//          ^^^^^^^^^^^^^^ reference minimized/Methods#staticOverload().
//                         ^ reference local4
    String b = staticOverload(m);
//  ^^^^^^ reference java/lang/String#
//         ^ definition local8
//             ^^^^^^^^^^^^^^ reference minimized/Methods#staticOverload(+1).
//                            ^ reference local5
    int c = methods.overload(n);
//      ^ definition local9
//          ^^^^^^^ reference local6
//                  ^^^^^^^^ reference minimized/Methods#overload().
//                           ^ reference local4
    String d = methods.overload(m);
//  ^^^^^^ reference java/lang/String#
//         ^ definition local10
//             ^^^^^^^ reference local6
//                     ^^^^^^^^ reference minimized/Methods#overload(+1).
//                              ^ reference local5
    return b + a + c + d;
//         ^ reference local8
//             ^ reference local7
//                 ^ reference local9
//                     ^ reference local10
  }
}
