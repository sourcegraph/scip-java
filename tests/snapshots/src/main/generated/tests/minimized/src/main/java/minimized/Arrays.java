package minimized;

public class Arrays {
//           ^^^^^^ definition semanticdb maven . . minimized/Arrays#
//                  documentation ```java\npublic class Arrays\n```
//           ^^^^^^ definition semanticdb maven . . minimized/Arrays#`<init>`().
//                  documentation ```java\npublic Arrays()\n```
  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Arrays#app().
//                         documentation ```java\npublic static String app()\n```
    int[] a = {1, 2, 3};
//        ^ definition local 0
//          documentation ```java\nint[] a\n```
    String[] b = {"1", "2", "3"};
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//           ^ definition local 1
//             documentation ```java\nString[] b\n```
    int[][] c = {{1}, {2}, {3}};
//          ^ definition local 2
//            documentation ```java\nint[][] c\n```
    String[][] d = {{"1"}, {"2"}, {"3"}};
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//             ^ definition local 3
//               documentation ```java\nString[][] d\n```
    return b[0] + a[0] + c[1][0] + d[1][0];
//         ^ reference local 1
//                ^ reference local 0
//                       ^ reference local 2
//                                 ^ reference local 3
  }
}
