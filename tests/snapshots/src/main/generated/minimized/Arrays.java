package minimized;

public class Arrays {
//           ^^^^^^ definition minimized/Arrays# public class Arrays
//           ^^^^^^ definition minimized/Arrays#`<init>`(). public <init>()
  public static String app() {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/Arrays#app(). public static String app()
    int[] a = {1, 2, 3};
//        ^ definition local0 int[] a
    String[] b = {"1", "2", "3"};
//  ^^^^^^ reference java/lang/String#
//           ^ definition local1 String[] b
    int[][] c = {{1}, {2}, {3}};
//          ^ definition local2 int[][] c
    String[][] d = {{"1"}, {"2"}, {"3"}};
//  ^^^^^^ reference java/lang/String#
//             ^ definition local3 String[][] d
    return b[0] + a[0] + c[1][0] + d[1][0];
//         ^ reference local1
//                ^ reference local0
//                       ^ reference local2
//                                 ^ reference local3
  }
}
