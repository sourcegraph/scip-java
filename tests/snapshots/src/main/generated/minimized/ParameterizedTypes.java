package minimized;

public class ParameterizedTypes<A, B> {
//           ^^^^^^^^^^^^^^^^^^ definition minimized/ParameterizedTypes#
//           ^^^^^^^^^^^^^^^^^^ definition minimized/ParameterizedTypes#`<init>`().
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
}
