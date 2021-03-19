package minimized;

import java.util.Map;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^ reference java/util/Map#

public class ParameterizedTypes<A, B> {
//           ^^^^^^^^^^^^^^^^^^ definition minimized/ParameterizedTypes#
//           ^^^^^^^^^^^^^^^^^^ definition minimized/ParameterizedTypes#`<init>`().
//                              ^ definition minimized/ParameterizedTypes#[A]
//                                 ^ definition minimized/ParameterizedTypes#[B]
  public String app(A a, B b) {
//       ^^^^^^ reference java/lang/String#
//              ^^^ definition minimized/ParameterizedTypes#app().
//                  ^ reference minimized/ParameterizedTypes#[A]
//                    ^ definition local0
//                       ^ reference minimized/ParameterizedTypes#[B]
//                         ^ definition local1
    return a.toString() + b;
//         ^ reference local0
//           ^^^^^^^^ reference java/lang/Object#toString().
//                        ^ reference local1
  }

  public Map<? extends String, ?> doStuff() { return null; }
//       ^^^ reference java/util/Map#
//                     ^^^^^^ reference java/lang/String#
//                                ^^^^^^^ definition minimized/ParameterizedTypes#doStuff().
}
