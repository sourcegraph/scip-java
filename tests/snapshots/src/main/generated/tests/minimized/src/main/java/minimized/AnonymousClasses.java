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
//                            display_name AnonymousClasses
//                            signature_documentation java @SuppressWarnings("ALL")\npublic class AnonymousClasses
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnonymousClasses#`<init>`().
//                            display_name <init>
//                            signature_documentation java public AnonymousClasses()
  public static int app(int n) {
//                  ^^^ definition semanticdb maven . . minimized/AnonymousClasses#app().
//                      display_name app
//                      signature_documentation java public static int app(int n)
//                          ^ definition local 0
//                            display_name n
//                            signature_documentation java int n
    Function<Integer, Integer> fn =
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//           ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                    ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                             ^^ definition local 1
//                                display_name fn
//                                signature_documentation java Function<Integer, Integer> fn
        new Function<Integer, Integer>() {
//          ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//                   ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                            ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
          @Override
//         ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
          public Integer apply(Integer integer) {
//               ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                       ^^^^^ definition local 3
//                             display_name apply
//                             signature_documentation java @Override\npublic Integer apply(Integer integer)
//                             relationship is_reference is_implementation semanticdb maven jdk 11 java/util/function/Function#apply().
//                             ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                                     ^^^^^^^ definition local 4
//                                             display_name integer
//                                             signature_documentation java Integer integer
            return integer + n;
//                 ^^^^^^^ reference local 4
//                           ^ reference local 0
          }
        };

    return fn.apply(n);
//         ^^ reference local 1
//            ^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#apply().
//                  ^ reference local 0
  }
}
