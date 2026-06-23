package minimized;

public class Arrays {
  public static String app() {
    int[] a = {1, 2, 3};
    String[] b = {"1", "2", "3"};
    int[][] c = {{1}, {2}, {3}};
    String[][] d = {{"1"}, {"2"}, {"3"}};
    return b[0] + a[0] + c[1][0] + d[1][0];
  }
}
