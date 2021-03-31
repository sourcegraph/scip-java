package minimized;

/** Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4 */
public class TypeVariables {
//           ^^^^^^^^^^^^^ definition minimized/TypeVariables# public class TypeVariables
//           ^^^^^^^^^^^^^ definition minimized/TypeVariables#`<init>`(). public void <init>()
  static class C {
//             ^ definition minimized/TypeVariables#C# static class C
//             ^ definition minimized/TypeVariables#C#`<init>`(). void <init>()
    public void mCPublic() {}
//              ^^^^^^^^ definition minimized/TypeVariables#C#mCPublic(). public void mCPublic()

    protected void mCProtected() {}
//                 ^^^^^^^^^^^ definition minimized/TypeVariables#C#mCProtected(). protected void mCProtected()

    void mCPackage() {}
//       ^^^^^^^^^ definition minimized/TypeVariables#C#mCPackage(). void mCPackage()
  }

  interface I {
//          ^ definition minimized/TypeVariables#I# abstract static interface I
    void mI();
//       ^^ definition minimized/TypeVariables#I#mI(). public abstract void mI()
  }

  static class CT extends C implements I {
//             ^^ definition minimized/TypeVariables#CT# static class CT extends C, I
//             ^^ definition minimized/TypeVariables#CT#`<init>`(). void <init>()
//                        ^ reference minimized/TypeVariables#C#
//                                     ^ reference minimized/TypeVariables#I#
    public void mI() {}
//              ^^ definition minimized/TypeVariables#CT#mI(). public void mI()
  }

  public static <T extends C & I> void app(T t) {
//               ^ definition minimized/TypeVariables#app().[T] T extends C & I
//                         ^ reference minimized/TypeVariables#C#
//                             ^ reference minimized/TypeVariables#I#
//                                     ^^^ definition minimized/TypeVariables#app(). public static <T extends C & I> void app(T t)
//                                         ^ reference minimized/TypeVariables#app().[T]
//                                           ^ definition local0 T t
    t.mI();
//  ^ reference local0
//    ^^ reference minimized/TypeVariables#I#mI().
    t.mCPublic();
//  ^ reference local0
//    ^^^^^^^^ reference minimized/TypeVariables#C#mCPublic().
    t.mCProtected();
//  ^ reference local0
//    ^^^^^^^^^^^ reference minimized/TypeVariables#C#mCProtected().
    t.mCPackage();
//  ^ reference local0
//    ^^^^^^^^^ reference minimized/TypeVariables#C#mCPackage().
  }
}
