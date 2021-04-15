package minimized;

import java.util.function.Function;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^ reference java/util/function/
//                        ^^^^^^^^ reference java/util/function/Function#

@SuppressWarnings("ALL")
//^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
public class AnonymousClasses {
//           ^^^^^^^^^^^^^^^^ definition minimized/AnonymousClasses# @SuppressWarnings("ALL") public class AnonymousClasses
//           ^^^^^^^^^^^^^^^^ definition minimized/AnonymousClasses#`<init>`(). public AnonymousClasses()
  public static int app(int n) {
//                  ^^^ definition minimized/AnonymousClasses#app(). public static int app(int n)
//                          ^ definition local0 int n
    Function<Integer, Integer> fn =
//  ^^^^^^^^ reference java/util/function/Function#
//           ^^^^^^^ reference java/lang/Integer#
//                    ^^^^^^^ reference java/lang/Integer#
//                             ^^ definition local1 Function<Integer, Integer> fn
        new Function<Integer, Integer>() {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local3 5:9
//          ^^^^^^^^ reference java/util/function/Function#
//                   ^^^^^^^ reference java/lang/Integer#
//                            ^^^^^^^ reference java/lang/Integer#
          @Override
//         ^^^^^^^^ reference java/lang/Override#
          public Integer apply(Integer integer) {
//               ^^^^^^^ reference java/lang/Integer#
//                       ^^^^^ definition local4 @Override public Integer apply(Integer integer)
//                             ^^^^^^^ reference java/lang/Integer#
//                                     ^^^^^^^ definition local5 Integer integer
            return integer + n;
//                 ^^^^^^^ reference local5
//                           ^ reference local0
          }
        };

    return fn.apply(n);
//         ^^ reference local1
//            ^^^^^ reference java/util/function/Function#apply().
//                  ^ reference local0
  }
}
