package minimized;

public class Methods {
//           ^^^^^^^ definition minimized/Methods# public class Methods
//           ^^^^^^^ definition minimized/Methods#`<init>`(). public void <init>()
  private int overload(int value) {
//            ^^^^^^^^ definition minimized/Methods#overload(). private int overload(int value)
//                         ^^^^^ definition local0 int value
    return value + 1;
//         ^^^^^ reference local0
  }

  private String overload(String value) {
//        ^^^^^^ reference java/lang/String#
//               ^^^^^^^^ definition minimized/Methods#overload(+1). private String overload(String value)
//                        ^^^^^^ reference java/lang/String#
//                               ^^^^^ definition local1 String value
    return value + "1";
//         ^^^^^ reference local1
  }

  private static int staticOverload(int value) {
//                   ^^^^^^^^^^^^^^ definition minimized/Methods#staticOverload(). private static int staticOverload(int value)
//                                      ^^^^^ definition local2 int value
    return value + 1;
//         ^^^^^ reference local2
  }

  private static String staticOverload(String value) {
//               ^^^^^^ reference java/lang/String#
//                      ^^^^^^^^^^^^^^ definition minimized/Methods#staticOverload(+1). private static String staticOverload(String value)
//                                     ^^^^^^ reference java/lang/String#
//                                            ^^^^^ definition local3 String value
    return value + "1";
//         ^^^^^ reference local3
  }

  public static String app(int n, String m) {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/Methods#app(). public static String app(int n, String m)
//                             ^ definition local4 int n
//                                ^^^^^^ reference java/lang/String#
//                                       ^ definition local5 String m
    Methods methods = new Methods();
//  ^^^^^^^ reference minimized/Methods#
//          ^^^^^^^ definition local6 Methods methods
//                    ^^^^^^^^^^^^^ reference minimized/Methods#`<init>`().
//                        ^^^^^^^ reference minimized/Methods#
    int a = staticOverload(n);
//      ^ definition local7 int a
//          ^^^^^^^^^^^^^^ reference minimized/Methods#staticOverload().
//                         ^ reference local4
    String b = staticOverload(m);
//  ^^^^^^ reference java/lang/String#
//         ^ definition local8 String b
//             ^^^^^^^^^^^^^^ reference minimized/Methods#staticOverload(+1).
//                            ^ reference local5
    int c = methods.overload(n);
//      ^ definition local9 int c
//          ^^^^^^^ reference local6
//                  ^^^^^^^^ reference minimized/Methods#overload().
//                           ^ reference local4
    String d = methods.overload(m);
//  ^^^^^^ reference java/lang/String#
//         ^ definition local10 String d
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
