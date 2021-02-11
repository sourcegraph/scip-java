package minimized;

/** Example class docstring. */
public class Docstrings {
//     ^^^^^^ definition minimized/Docstrings#`<init>`().
//     ^^^^^^^^^^ definition minimized/Docstrings#

  /** Example field docstring. */
  public static int field = 42;
//                  ^^^^^ definition minimized/Docstrings#field.

  /**
   * Example method docstring.
   *
   * @return 42.
   */
  public static int method() {
//                  ^^^^^^ definition minimized/Docstrings#method().
    return 42;
  }

  /**
   * Example method parameter docstring.
   *
   * @param n The parameter.
   * @return The number + 42.
   */
  public static int methodParameter(int n) {
//                  ^^^^^^^^^^^^^^^ definition minimized/Docstrings#methodParameter().
//                                      ^ definition local0
    return n + 42;
//         ^ reference local0
  }

  public static String app() {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/Docstrings#app().
    return String.format("%s%s%s", field, method(), methodParameter(42));
//         ^^^^^^ reference java/lang/String#
//                ^^^^^^ reference java/lang/String#format().
//                                 ^^^^^ reference minimized/Docstrings#field.
//                                        ^^^^^^ reference minimized/Docstrings#method().
//                                                  ^^^^^^^^^^^^^^^ reference minimized/Docstrings#methodParameter().
  }
}
