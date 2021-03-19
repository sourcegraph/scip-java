package minimized;

import java.util.Map;

public class ParameterizedTypes<A, B> {
  public String app(A a, B b) {
    return a.toString() + b;
  }

  public Map<? extends String, ?> doStuff() { return null; }
}
