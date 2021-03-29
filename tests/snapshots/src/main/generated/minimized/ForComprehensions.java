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
//           ^^^^^^^^^^^^^^^^^ definition minimized/ForComprehensions# public class ForComprehensions
//           ^^^^^^^^^^^^^^^^^ definition minimized/ForComprehensions#`<init>`(). public <init>()
  public static int app(int n) {
//                  ^^^ definition minimized/ForComprehensions#app(). public static int app(int n)
//                          ^ definition local0 int n
    List<Integer> integers = Collections.singletonList(n);
//  ^^^^ reference java/util/List#
//       ^^^^^^^ reference java/lang/Integer#
//                ^^^^^^^^ definition local1 List<Integer> integers
//                           ^^^^^^^^^^^ reference java/util/Collections#
//                                       ^^^^^^^^^^^^^ reference java/util/Collections#singletonList().
//                                                     ^ reference local0
    int result = 0;
//      ^^^^^^ definition local2 int result
    for (int i : integers) {
//           ^ definition local3 int i
//               ^^^^^^^^ reference local1
      result += i;
//    ^^^^^^ reference local2
//              ^ reference local3
    }
    return result;
//         ^^^^^^ reference local2
  }
}
