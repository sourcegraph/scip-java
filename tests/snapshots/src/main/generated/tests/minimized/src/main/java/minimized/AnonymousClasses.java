package minimized;

import java.util.function.Function;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^ reference semanticdb maven . . java/util/function/
//                        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#

@SuppressWarnings("ALL")
//^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
public class AnonymousClasses {
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnonymousClasses#
//                            documentation ```java\n@SuppressWarnings("ALL")\npublic class AnonymousClasses\n```
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnonymousClasses#`<init>`().
//                            documentation ```java\npublic AnonymousClasses()\n```
  public static int app(int n) {
//                  ^^^ definition semanticdb maven . . minimized/AnonymousClasses#app().
//                      documentation ```java\npublic static int app(int n)\n```
//                          ^ definition local 0
//                            documentation ```java\nint n\n```
    Function<Integer, Integer> fn =
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//           ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                    ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                             ^^ definition local 1
//                                documentation ```java\nFunction<Integer, Integer> fn\n```
        new Function<Integer, Integer>() {
//          ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//                   ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                            ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
          @Override
//         ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
          public Integer apply(Integer integer) {
//               ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                       ^^^^^ definition local 4
//                             documentation ```java\n@Override\npublic Integer apply(Integer integer)\n```
//                             relationship is_reference is_implementation semanticdb maven jdk 11 java/util/function/Function#apply().
//                             ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                                     ^^^^^^^ definition local 5
//                                             documentation ```java\nInteger integer\n```
            return integer + n;
//                 ^^^^^^^ reference local 5
//                           ^ reference local 0
          }
        };

    return fn.apply(n);
//         ^^ reference local 1
//            ^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#apply().
//                  ^ reference local 0
  }
}
