package minimized;

import java.util.Collections;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

public class ForComprehensions {
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ForComprehensions#
//                             display_name ForComprehensions
//                             signature_documentation java public class ForComprehensions
//                             kind Class
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ForComprehensions#`<init>`().
//                             display_name <init>
//                             signature_documentation java public ForComprehensions()
//                             kind Constructor
  public static int app(int n) {
//                  ^^^ definition semanticdb maven . . minimized/ForComprehensions#app().
//                      display_name app
//                      signature_documentation java public static int app(int n)
//                      kind StaticMethod
//                          ^ definition local 0
//                            display_name n
//                            signature_documentation java int n
//                            enclosing_symbol semanticdb maven . . minimized/ForComprehensions#app().
    List<Integer> integers = Collections.singletonList(n);
//  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//       ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                ^^^^^^^^ definition local 1
//                         display_name integers
//                         signature_documentation java List<Integer> integers
//                         enclosing_symbol semanticdb maven . . minimized/ForComprehensions#app().
//                         kind Variable
//                           ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                       ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#singletonList().
//                                                     ^ reference local 0
    int result = 0;
//      ^^^^^^ definition local 2
//             display_name result
//             signature_documentation java int result
//             enclosing_symbol semanticdb maven . . minimized/ForComprehensions#app().
//             kind Variable
    for (int i : integers) {
//           ^ definition local 3
//             display_name i
//             signature_documentation java int i
//             enclosing_symbol semanticdb maven . . minimized/ForComprehensions#app().
//             kind Variable
//               ^^^^^^^^ reference local 1
      result += i;
//    ^^^^^^ reference local 2
//              ^ reference local 3
    }
    return result;
//         ^^^^^^ reference local 2
  }
}
