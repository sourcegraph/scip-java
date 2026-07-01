  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/Arrays#
  public class Arrays {
//             ^^^^^^ definition scip-java maven . . minimized/Arrays#
//                    kind Class
//                    display_name Arrays
//                    signature_documentation
//                    > public class Arrays
//             ^^^^^^ definition scip-java maven . . minimized/Arrays#`<init>`().
//                    kind Constructor
//                    display_name <init>
//                    signature_documentation
//                    > public Arrays()
//  ⌄ enclosing_range_start scip-java maven . . minimized/Arrays#app().
    public static String app() {
//                ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//                       ^^^ definition scip-java maven . . minimized/Arrays#app().
//                           kind StaticMethod
//                           display_name app
//                           signature_documentation
//                           > public static String app()
//    ⌄ enclosing_range_start local 0
      int[] a = {1, 2, 3};
//          ^ definition local 0
//            kind Variable
//            display_name a
//            signature_documentation
//            > int[] a
//                       ⌃ enclosing_range_end local 0
//    ⌄ enclosing_range_start local 1
      String[] b = {"1", "2", "3"};
//    ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//             ^ definition local 1
//               kind Variable
//               display_name b
//               signature_documentation
//               > String[] b
//                                ⌃ enclosing_range_end local 1
//    ⌄ enclosing_range_start local 2
      int[][] c = {{1}, {2}, {3}};
//            ^ definition local 2
//              kind Variable
//              display_name c
//              signature_documentation
//              > int[][] c
//                               ⌃ enclosing_range_end local 2
//    ⌄ enclosing_range_start local 3
      String[][] d = {{"1"}, {"2"}, {"3"}};
//    ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//               ^ definition local 3
//                 kind Variable
//                 display_name d
//                 signature_documentation
//                 > String[][] d
//                                        ⌃ enclosing_range_end local 3
      return b[0] + a[0] + c[1][0] + d[1][0];
//           ^ reference local 1
//                  ^ reference local 0
//                         ^ reference local 2
//                                   ^ reference local 3
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Arrays#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Arrays#
  
