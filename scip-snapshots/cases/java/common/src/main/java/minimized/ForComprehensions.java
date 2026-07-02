package minimized;

import java.util.Collections;
import java.util.List;

public class ForComprehensions {
  public static int app(int n) {
    List<Integer> integers = Collections.singletonList(n);
    int result = 0;
    for (int i : integers) {
      result += i;
    }
    return result;
  }
}
