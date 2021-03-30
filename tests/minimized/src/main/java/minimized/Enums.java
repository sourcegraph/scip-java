package minimized;

import java.util.Arrays;

enum Enums {
  A("A", 420),
  B("B", 1),
  C("C", 5);
  public String value;

  Enums(String value, int a) {
    this.value = value;
  }

  public static String app() {
    String all = Arrays.stream(values()).map(e -> e.value).map(Enums::valueOf).toString();
    return all + A.value + B.value + C.value;
  }
}
