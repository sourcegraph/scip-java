package minimized;

/** Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4 */
public class TypeVariables {
  static class C {
    public void mCPublic() {}

    protected void mCProtected() {}

    void mCPackage() {}
  }

  interface I {
    void mI();
  }

  static class CT extends C implements I {
    public void mI() {}
  }

  public static <T extends C & I> void app(T t) {
    t.mI();
    t.mCPublic();
    t.mCProtected();
    t.mCPackage();
  }
}
