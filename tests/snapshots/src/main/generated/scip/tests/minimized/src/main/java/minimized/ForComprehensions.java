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
//                             documentation ```java\npublic class ForComprehensions\n```
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/ForComprehensions#`<init>`().
//                             documentation ```java\npublic ForComprehensions()\n```
  public static int app(int n) {
//                  ^^^ definition semanticdb maven . . minimized/ForComprehensions#app().
//                      documentation ```java\npublic static int app(int n)\n```
//                          ^ definition local 0
//                            documentation ```java\nint n\n```
    List<Integer> integers = Collections.singletonList(n);
//  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//       ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                ^^^^^^^^ definition local 1
//                         documentation ```java\nList<Integer> integers\n```
//                           ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                       ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#singletonList().
//                                                     ^ reference local 0
    int result = 0;
//      ^^^^^^ definition local 2
//             documentation ```java\nint result\n```
    for (int i : integers) {
//           ^ definition local 3
//             documentation ```java\nint i\n```
//               ^^^^^^^^ reference local 1
      result += i;
//    ^^^^^^ reference local 2
//              ^ reference local 3
    }
    return result;
//         ^^^^^^ reference local 2
  }
}
