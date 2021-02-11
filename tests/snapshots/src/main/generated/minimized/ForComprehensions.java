package minimized;

import java.util.Collections;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^ reference java/util/Collections#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

public class ForComprehensions {
//     ^^^^^^ definition minimized/ForComprehensions#`<init>`().
//     ^^^^^^^^^^^^^^^^^ definition minimized/ForComprehensions#
  public static int app(int n) {
//                  ^^^ definition minimized/ForComprehensions#app().
//                          ^ definition local0
    List<Integer> integers = Collections.singletonList(n);
//  ^^^^ reference java/util/List#
//       ^^^^^^^ reference java/lang/Integer#
//                ^^^^^^^^ definition local1
//                           ^^^^^^^^^^^ reference java/util/Collections#
//                                       ^^^^^^^^^^^^^ reference java/util/Collections#singletonList().
//                                                     ^ reference local0
    int result = 0;
//      ^^^^^^ definition local2
    for (int i : integers) {
//           ^ definition local3
//               ^^^^^^^^ reference local1
      result += i;
//    ^^^^^^ reference local2
//              ^ reference local3
    }
    return result;
//         ^^^^^^ reference local2
  }
}
