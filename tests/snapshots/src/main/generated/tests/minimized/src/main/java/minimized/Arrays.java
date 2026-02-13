  package minimized;
  
//⌄ enclosing_range_start semanticdb maven . . minimized/Arrays#
  public class Arrays {
//             ^^^^^^ definition semanticdb maven . . minimized/Arrays#
//                    display_name Arrays
//                    signature_documentation java public class Arrays
//                    kind Class
//             ^^^^^^ definition semanticdb maven . . minimized/Arrays#`<init>`().
//                    display_name <init>
//                    signature_documentation java public Arrays()
//                    kind Constructor
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Arrays#app().
    public static String app() {
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                       ^^^ definition semanticdb maven . . minimized/Arrays#app().
//                           display_name app
//                           signature_documentation java public static String app()
//                           kind StaticMethod
//    ⌄ enclosing_range_start local 0
      int[] a = {1, 2, 3};
//          ^ definition local 0
//            display_name a
//            signature_documentation java int[] a
//            enclosing_symbol semanticdb maven . . minimized/Arrays#app().
//            kind Variable
//                       ⌃ enclosing_range_end local 0
//    ⌄ enclosing_range_start local 1
      String[] b = {"1", "2", "3"};
//    ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//             ^ definition local 1
//               display_name b
//               signature_documentation java String[] b
//               enclosing_symbol semanticdb maven . . minimized/Arrays#app().
//               kind Variable
//                                ⌃ enclosing_range_end local 1
//    ⌄ enclosing_range_start local 2
      int[][] c = {{1}, {2}, {3}};
//            ^ definition local 2
//              display_name c
//              signature_documentation java int[][] c
//              enclosing_symbol semanticdb maven . . minimized/Arrays#app().
//              kind Variable
//                               ⌃ enclosing_range_end local 2
//    ⌄ enclosing_range_start local 3
      String[][] d = {{"1"}, {"2"}, {"3"}};
//    ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//               ^ definition local 3
//                 display_name d
//                 signature_documentation java String[][] d
//                 enclosing_symbol semanticdb maven . . minimized/Arrays#app().
//                 kind Variable
//                                        ⌃ enclosing_range_end local 3
      return b[0] + a[0] + c[1][0] + d[1][0];
//           ^ reference local 1
//                  ^ reference local 0
//                         ^ reference local 2
//                                   ^ reference local 3
    }
//  ⌃ enclosing_range_end semanticdb maven . . minimized/Arrays#app().
  }
//⌃ enclosing_range_end semanticdb maven . . minimized/Arrays#
