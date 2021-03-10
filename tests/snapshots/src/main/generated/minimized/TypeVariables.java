package minimized;

/** Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4 */
public class TypeVariables {
//           ^^^^^^^^^^^^^ definition minimized/TypeVariables#
//           ^^^^^^^^^^^^^ definition minimized/TypeVariables#`<init>`().
  static class C {
//             ^ definition minimized/TypeVariables#C#
//             ^ definition minimized/TypeVariables#C#`<init>`().
    public void mCPublic() {}
//              ^^^^^^^^ definition minimized/TypeVariables#C#mCPublic().

    protected void mCProtected() {}
//                 ^^^^^^^^^^^ definition minimized/TypeVariables#C#mCProtected().

    void mCPackage() {}
//       ^^^^^^^^^ definition minimized/TypeVariables#C#mCPackage().
  }

  interface I {
//          ^ definition minimized/TypeVariables#I#
    void mI();
//       ^^ definition minimized/TypeVariables#I#mI().
  }

  static class CT extends C implements I {
//             ^^ definition minimized/TypeVariables#CT#
//             ^^ definition minimized/TypeVariables#CT#`<init>`().
//                        ^ reference minimized/TypeVariables#C#
//                                     ^ reference minimized/TypeVariables#I#
    public void mI() {}
//              ^^ definition minimized/TypeVariables#CT#mI().
  }

  public static <T extends C & I> void app(T t) {
//                         ^ reference minimized/TypeVariables#C#
//                             ^ reference minimized/TypeVariables#I#
//                                     ^^^ definition minimized/TypeVariables#app().
//                                         ^ reference minimized/TypeVariables#app().[T]
//                                           ^ definition local0
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
