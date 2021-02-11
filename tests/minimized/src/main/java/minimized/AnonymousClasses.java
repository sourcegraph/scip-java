package minimized;

import java.util.function.Function;

@SuppressWarnings("ALL")
public class AnonymousClasses {
  public static int app(int n) {
    Function<Integer, Integer> fn =
        new Function<Integer, Integer>() {
          @Override
          public Integer apply(Integer integer) {
            return integer + n;
          }
        };

    return fn.apply(n);
  }
}
