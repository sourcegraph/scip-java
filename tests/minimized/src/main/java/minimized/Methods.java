package minimized;

public class Methods {
  private int overload(int value) {
    return value + 1;
  }

  private String overload(String value) {
    return value + "1";
  }

  private static int staticOverload(int value) {
    return value + 1;
  }

  private static String staticOverload(String value) {
    return value + "1";
  }

  public static String app(int n, String m) throws RuntimeException, IndexOutOfBoundsException {
    Methods methods = new Methods();
    int a = staticOverload(n);
    String b = staticOverload(m);
    int c = methods.overload(n);
    String d = methods.overload(m);
    return b + a + c + d;
  }
}
