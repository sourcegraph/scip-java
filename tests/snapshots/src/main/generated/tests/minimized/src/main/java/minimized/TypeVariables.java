  package minimized;
  
  /** Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4 */
//⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#
  public class TypeVariables {
//             ^^^^^^^^^^^^^ definition scip-java maven . . minimized/TypeVariables#
//                           display_name TypeVariables
//                           signature_documentation java public class TypeVariables
//                           kind Class
//                           documentation Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4 
//             ^^^^^^^^^^^^^ definition scip-java maven . . minimized/TypeVariables#`<init>`().
//                           display_name <init>
//                           signature_documentation java public TypeVariables()
//                           kind Constructor
//  ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#C#
    static class C {
//               ^ definition scip-java maven . . minimized/TypeVariables#C#
//                 display_name C
//                 signature_documentation java static class C
//                 kind Class
//               ^ definition scip-java maven . . minimized/TypeVariables#C#`<init>`().
//                 display_name <init>
//                 signature_documentation java C()
//                 kind Constructor
//    ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#C#mCPublic().
      public void mCPublic() {}
//                ^^^^^^^^ definition scip-java maven . . minimized/TypeVariables#C#mCPublic().
//                         display_name mCPublic
//                         signature_documentation java public void mCPublic()
//                         kind Method
//                            ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#C#mCPublic().
  
//    ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#C#mCProtected().
      protected void mCProtected() {}
//                   ^^^^^^^^^^^ definition scip-java maven . . minimized/TypeVariables#C#mCProtected().
//                               display_name mCProtected
//                               signature_documentation java protected void mCProtected()
//                               kind Method
//                                  ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#C#mCProtected().
  
//    ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#C#mCPackage().
      void mCPackage() {}
//         ^^^^^^^^^ definition scip-java maven . . minimized/TypeVariables#C#mCPackage().
//                   display_name mCPackage
//                   signature_documentation java void mCPackage()
//                   kind Method
//                      ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#C#mCPackage().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#C#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#I#
    interface I {
//            ^ definition scip-java maven . . minimized/TypeVariables#I#
//              display_name I
//              signature_documentation java interface I
//              kind Interface
//    ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#I#mI().
      void mI();
//         ^^ definition scip-java maven . . minimized/TypeVariables#I#mI().
//            display_name mI
//            signature_documentation java public abstract void mI()
//            kind AbstractMethod
//            relationship is_reference is_implementation scip-java maven . . minimized/TypeVariables#CT#mI().
//             ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#I#mI().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#I#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#CT#
    static class CT extends C implements I {
//               ^^ definition scip-java maven . . minimized/TypeVariables#CT#
//                  display_name CT
//                  signature_documentation java static class CT extends C implements I
//                  kind Class
//                  relationship is_implementation scip-java maven . . minimized/TypeVariables#C#
//                  relationship is_implementation scip-java maven . . minimized/TypeVariables#I#
//               ^^ definition scip-java maven . . minimized/TypeVariables#CT#`<init>`().
//                  display_name <init>
//                  signature_documentation java CT()
//                  kind Constructor
//                          ^ reference scip-java maven . . minimized/TypeVariables#C#
//                                       ^ reference scip-java maven . . minimized/TypeVariables#I#
//    ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#CT#mI().
      public void mI() {}
//                ^^ definition scip-java maven . . minimized/TypeVariables#CT#mI().
//                   display_name mI
//                   signature_documentation java public void mI()
//                   kind Method
//                   relationship is_reference is_implementation scip-java maven . . minimized/TypeVariables#I#mI().
//                      ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#CT#mI().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#CT#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#app().[T]
//  ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#app().
//                                           ⌄ enclosing_range_start local 0
    public static <T extends C & I> void app(T t) {
//                 ^ definition scip-java maven . . minimized/TypeVariables#app().[T]
//                   display_name T
//                   signature_documentation java T extends C & I
//                   kind TypeParameter
//                           ^ reference scip-java maven . . minimized/TypeVariables#C#
//                               ^ reference scip-java maven . . minimized/TypeVariables#I#
//                                       ^^^ definition scip-java maven . . minimized/TypeVariables#app().
//                                           display_name app
//                                           signature_documentation java public static <T extends C & I> void app(T t)
//                                           kind StaticMethod
//                                           ^ reference scip-java maven . . minimized/TypeVariables#app().[T]
//                                             ^ definition local 0
//                                               display_name t
//                                               signature_documentation java T t
//                                               enclosing_symbol scip-java maven . . minimized/TypeVariables#app().
//                                             ⌃ enclosing_range_end local 0
      t.mI();
//    ^ reference local 0
//      ^^ reference scip-java maven . . minimized/TypeVariables#I#mI().
      t.mCPublic();
//    ^ reference local 0
//      ^^^^^^^^ reference scip-java maven . . minimized/TypeVariables#C#mCPublic().
      t.mCProtected();
//    ^ reference local 0
//      ^^^^^^^^^^^ reference scip-java maven . . minimized/TypeVariables#C#mCProtected().
      t.mCPackage();
//    ^ reference local 0
//      ^^^^^^^^^ reference scip-java maven . . minimized/TypeVariables#C#mCPackage().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#app().[T]
//  ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#
