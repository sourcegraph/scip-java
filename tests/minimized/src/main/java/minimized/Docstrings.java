package minimized;

/** Example class docstring. */
public class Docstrings {

  /** Example field docstring. */
  public static int field = 42;

  /**
   * Example method docstring.
   *
   * @return 42.
   */
  public static int method() {
    return 42;
  }

  /**
   * Example method parameter docstring.
   *
   * @param n The parameter.
   * @return The number + 42.
   */
  public static int methodParameter(int n) {
    return n + 42;
  }

  public static String app() {
    return String.format("%s%s%s", field, method(), methodParameter(42));
  }
}
