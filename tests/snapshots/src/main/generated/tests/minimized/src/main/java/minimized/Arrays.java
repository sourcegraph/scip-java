package minimized;

public class Arrays {
//           ^^^^^^ definition semanticdb maven . . minimized/Arrays#
//                  display_name Arrays
//                  documentation ```java\npublic class Arrays\n```
//           ^^^^^^ definition semanticdb maven . . minimized/Arrays#`<init>`().
//                  display_name <init>
//                  documentation ```java\npublic Arrays()\n```
  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Arrays#app().
//                         display_name app
//                         documentation ```java\npublic static String app()\n```
    int[] a = {1, 2, 3};
//        ^ definition local 0
//          display_name a
//          documentation ```java\nint[] a\n```
    String[] b = {"1", "2", "3"};
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//           ^ definition local 1
//             display_name b
//             documentation ```java\nString[] b\n```
    int[][] c = {{1}, {2}, {3}};
//          ^ definition local 2
//            display_name c
//            documentation ```java\nint[][] c\n```
    String[][] d = {{"1"}, {"2"}, {"3"}};
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//             ^ definition local 3
//               display_name d
//               documentation ```java\nString[][] d\n```
    return b[0] + a[0] + c[1][0] + d[1][0];
//         ^ reference local 1
//                ^ reference local 0
//                       ^ reference local 2
//                                 ^ reference local 3
  }
}
