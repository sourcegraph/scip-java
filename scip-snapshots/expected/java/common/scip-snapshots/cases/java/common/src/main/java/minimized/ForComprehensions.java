  package minimized;
  
  import java.util.Collections;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/Collections#
  import java.util.List;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^ reference scip-java maven jdk 11 java/util/List#
  
//⌄ enclosing_range_start scip-java maven . . minimized/ForComprehensions#
  public class ForComprehensions {
//             ^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/ForComprehensions#
//                               kind Class
//                               display_name ForComprehensions
//                               signature_documentation
//                               > public class ForComprehensions
//             ^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/ForComprehensions#`<init>`().
//                               kind Constructor
//                               display_name <init>
//                               signature_documentation
//                               > public ForComprehensions()
//  ⌄ enclosing_range_start scip-java maven . . minimized/ForComprehensions#app().
//                        ⌄ enclosing_range_start local 0
    public static int app(int n) {
//                    ^^^ definition scip-java maven . . minimized/ForComprehensions#app().
//                        kind StaticMethod
//                        display_name app
//                        signature_documentation
//                        > public static int app(int n)
//                            ^ definition local 0
//                              display_name n
//                              signature_documentation
//                              > int n
//                            ⌃ enclosing_range_end local 0
//    ⌄ enclosing_range_start local 1
      List<Integer> integers = Collections.singletonList(n);
//    ^^^^ reference scip-java maven jdk 11 java/util/List#
//         ^^^^^^^ reference scip-java maven jdk 11 java/lang/Integer#
//                  ^^^^^^^^ definition local 1
//                           kind Variable
//                           display_name integers
//                           signature_documentation
//                           > List<Integer> integers
//                             ^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/Collections#
//                                         ^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/Collections#singletonList().
//                                                       ^ reference local 0
//                                                         ⌃ enclosing_range_end local 1
//    ⌄ enclosing_range_start local 2
      int result = 0;
//        ^^^^^^ definition local 2
//               kind Variable
//               display_name result
//               signature_documentation
//               > int result
//                  ⌃ enclosing_range_end local 2
//         ⌄ enclosing_range_start local 3
      for (int i : integers) {
//             ^ definition local 3
//               kind Variable
//               display_name i
//               signature_documentation
//               > int i
//                 ^^^^^^^^ reference local 1
//             ⌃ enclosing_range_end local 3
        result += i;
//      ^^^^^^ reference local 2
//                ^ reference local 3
      }
      return result;
//           ^^^^^^ reference local 2
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/ForComprehensions#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/ForComprehensions#
  
