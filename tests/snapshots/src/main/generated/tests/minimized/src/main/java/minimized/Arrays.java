package minimized;

public class Arrays {
//           ^^^^^^ definition semanticdb maven . . minimized/Arrays#
//                  display_name Arrays
//                  signature_documentation java public class Arrays
//           ^^^^^^ definition semanticdb maven . . minimized/Arrays#`<init>`().
//                  display_name <init>
//                  signature_documentation java public Arrays()
  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Arrays#app().
//                         display_name app
//                         signature_documentation java public static String app()
    int[] a = {1, 2, 3};
//        ^ definition local 0
//          display_name a
//          signature_documentation java int[] a
//          enclosing_symbol semanticdb maven . . minimized/Arrays#app().
    String[] b = {"1", "2", "3"};
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//           ^ definition local 1
//             display_name b
//             signature_documentation java String[] b
//             enclosing_symbol semanticdb maven . . minimized/Arrays#app().
    int[][] c = {{1}, {2}, {3}};
//          ^ definition local 2
//            display_name c
//            signature_documentation java int[][] c
//            enclosing_symbol semanticdb maven . . minimized/Arrays#app().
    String[][] d = {{"1"}, {"2"}, {"3"}};
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//             ^ definition local 3
//               display_name d
//               signature_documentation java String[][] d
//               enclosing_symbol semanticdb maven . . minimized/Arrays#app().
    return b[0] + a[0] + c[1][0] + d[1][0];
//         ^ reference local 1
//                ^ reference local 0
//                       ^ reference local 2
//                                 ^ reference local 3
  }
}
