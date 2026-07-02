package minimized;

import java.util.Random;

public class Primitives {
  public static String app() {
    Random random = new Random();
    byte a = (byte) random.nextInt();
    short b = (short) random.nextInt();
    int c = random.nextInt();
    long d = random.nextLong();
    char e = (char) random.nextInt();
    float f = (float) random.nextDouble();
    double g = (double) random.nextDouble();
    boolean h = random.nextBoolean();
    return "" + a + b + c + d + e + f + g + h;
  }

  public static void test() {}
}
