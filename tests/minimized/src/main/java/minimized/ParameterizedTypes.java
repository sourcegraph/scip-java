package minimized;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ParameterizedTypes<A, B extends String> {
  public <T extends Iterable<A> & Iterator<B>> void iteratorable(List<T> list) {}

  public String app(A a, B b) {
    return a.toString() + b;
  }

  public Map<? extends String, ?> doStuff() { return null; }

  public Quadruplet<String, ?, Object, ? super Integer> createQuadruplet() { return null; }

  public static class Quadruplet<T, S, X, Y> {}
}
