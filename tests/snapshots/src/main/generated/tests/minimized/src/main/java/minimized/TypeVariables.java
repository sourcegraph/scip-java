package minimized;

/** Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4 */
public class TypeVariables {
//           ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#
//                         display_name TypeVariables
//                         signature_documentation java public class TypeVariables
//                         kind Class
//                         documentation Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4 
//           ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#`<init>`().
//                         display_name <init>
//                         signature_documentation java public TypeVariables()
//                         kind Constructor
  static class C {
//             ^ definition semanticdb maven . . minimized/TypeVariables#C#
//               display_name C
//               signature_documentation java static class C
//               kind Class
//             ^ definition semanticdb maven . . minimized/TypeVariables#C#`<init>`().
//               display_name <init>
//               signature_documentation java C()
//               kind Constructor
    public void mCPublic() {}
//              ^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#C#mCPublic().
//                       display_name mCPublic
//                       signature_documentation java public void mCPublic()
//                       kind Method

    protected void mCProtected() {}
//                 ^^^^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#C#mCProtected().
//                             display_name mCProtected
//                             signature_documentation java protected void mCProtected()
//                             kind Method

    void mCPackage() {}
//       ^^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#C#mCPackage().
//                 display_name mCPackage
//                 signature_documentation java void mCPackage()
//                 kind Method
  }

  interface I {
//          ^ definition semanticdb maven . . minimized/TypeVariables#I#
//            display_name I
//            signature_documentation java interface I
//            kind Interface
    void mI();
//       ^^ definition semanticdb maven . . minimized/TypeVariables#I#mI().
//          display_name mI
//          signature_documentation java public abstract void mI()
//          kind AbstractMethod
//          relationship is_reference is_implementation semanticdb maven . . minimized/TypeVariables#CT#mI().
  }

  static class CT extends C implements I {
//             ^^ definition semanticdb maven . . minimized/TypeVariables#CT#
//                display_name CT
//                signature_documentation java static class CT
//                kind Class
//                relationship is_implementation semanticdb maven . . minimized/TypeVariables#C#
//                relationship is_implementation semanticdb maven . . minimized/TypeVariables#I#
//             ^^ definition semanticdb maven . . minimized/TypeVariables#CT#`<init>`().
//                display_name <init>
//                signature_documentation java CT()
//                kind Constructor
//                        ^ reference semanticdb maven . . minimized/TypeVariables#C#
//                                     ^ reference semanticdb maven . . minimized/TypeVariables#I#
    public void mI() {}
//              ^^ definition semanticdb maven . . minimized/TypeVariables#CT#mI().
//                 display_name mI
//                 signature_documentation java public void mI()
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven . . minimized/TypeVariables#I#mI().
  }

  public static <T extends C & I> void app(T t) {
//               ^ definition semanticdb maven . . minimized/TypeVariables#app().[T]
//                 display_name T
//                 signature_documentation java T extends C & I
//                 kind TypeParameter
//                         ^ reference semanticdb maven . . minimized/TypeVariables#C#
//                             ^ reference semanticdb maven . . minimized/TypeVariables#I#
//                                     ^^^ definition semanticdb maven . . minimized/TypeVariables#app().
//                                         display_name app
//                                         signature_documentation java public static <T extends C & I> void app(T t)
//                                         kind StaticMethod
//                                         ^ reference semanticdb maven . . minimized/TypeVariables#app().[T]
//                                           ^ definition local 0
//                                             display_name t
//                                             signature_documentation java T t
//                                             enclosing_symbol semanticdb maven . . minimized/TypeVariables#app().
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
