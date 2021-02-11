package minimized;

public class ParameterizedTypes<A, B> {
  public String app(A a, B b) {
    return a.toString() + b;
  }
}
