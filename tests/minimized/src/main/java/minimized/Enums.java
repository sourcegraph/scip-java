package minimized;

import java.util.Arrays;

public enum Enums {
  A("A"),
  B("B"),
  C("C");
  public String value;

  Enums(String value) {
    this.value = value;
  }

  public static String app() {
    String all = Arrays.stream(values()).map(e -> e.value).map(Enums::valueOf).toString();
    return all + A.value + B.value + C.value;
  }
}
