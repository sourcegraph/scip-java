package minimized;

/** Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4 */
public class TypeVariables {
//           ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#
//                         display_name TypeVariables
//                         signature_documentation java public class TypeVariables
//                         documentation Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4 
//           ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#`<init>`().
//                         display_name <init>
//                         signature_documentation java public TypeVariables()
  static class C {
//             ^ definition semanticdb maven . . minimized/TypeVariables#C#
//               display_name C
//               signature_documentation java static class C
//             ^ definition semanticdb maven . . minimized/TypeVariables#C#`<init>`().
//               display_name <init>
//               signature_documentation java C()
    public void mCPublic() {}
//              ^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#C#mCPublic().
//                       display_name mCPublic
//                       signature_documentation java public void mCPublic()

    protected void mCProtected() {}
//                 ^^^^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#C#mCProtected().
//                             display_name mCProtected
//                             signature_documentation java protected void mCProtected()

    void mCPackage() {}
//       ^^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#C#mCPackage().
//                 display_name mCPackage
//                 signature_documentation java void mCPackage()
  }

  interface I {
//          ^ definition semanticdb maven . . minimized/TypeVariables#I#
//            display_name I
//            signature_documentation java interface I
    void mI();
//       ^^ definition semanticdb maven . . minimized/TypeVariables#I#mI().
//          display_name mI
//          signature_documentation java public abstract void mI()
//          relationship is_reference is_implementation semanticdb maven . . minimized/TypeVariables#CT#mI().
  }

  static class CT extends C implements I {
//             ^^ definition semanticdb maven . . minimized/TypeVariables#CT#
//                display_name CT
//                signature_documentation java static class CT
//                relationship is_implementation semanticdb maven . . minimized/TypeVariables#C#
//                relationship is_implementation semanticdb maven . . minimized/TypeVariables#I#
//             ^^ definition semanticdb maven . . minimized/TypeVariables#CT#`<init>`().
//                display_name <init>
//                signature_documentation java CT()
//                        ^ reference semanticdb maven . . minimized/TypeVariables#C#
//                                     ^ reference semanticdb maven . . minimized/TypeVariables#I#
    public void mI() {}
//              ^^ definition semanticdb maven . . minimized/TypeVariables#CT#mI().
//                 display_name mI
//                 signature_documentation java public void mI()
//                 relationship is_reference is_implementation semanticdb maven . . minimized/TypeVariables#I#mI().
  }

  public static <T extends C & I> void app(T t) {
//               ^ definition semanticdb maven . . minimized/TypeVariables#app().[T]
//                 display_name T
//                 signature_documentation java T extends C & I
//                         ^ reference semanticdb maven . . minimized/TypeVariables#C#
//                             ^ reference semanticdb maven . . minimized/TypeVariables#I#
//                                     ^^^ definition semanticdb maven . . minimized/TypeVariables#app().
//                                         display_name app
//                                         signature_documentation java public static <T extends C & I> void app(T t)
//                                         ^ reference semanticdb maven . . minimized/TypeVariables#app().[T]
//                                           ^ definition local 0
//                                             display_name t
//                                             signature_documentation java T t
    t.mI();
//  ^ reference local 0
//    ^^ reference semanticdb maven . . minimized/TypeVariables#I#mI().
    t.mCPublic();
//  ^ reference local 0
//    ^^^^^^^^ reference semanticdb maven . . minimized/TypeVariables#C#mCPublic().
    t.mCProtected();
//  ^ reference local 0
//    ^^^^^^^^^^^ reference semanticdb maven . . minimized/TypeVariables#C#mCProtected().
    t.mCPackage();
//  ^ reference local 0
//    ^^^^^^^^^ reference semanticdb maven . . minimized/TypeVariables#C#mCPackage().
  }
}
