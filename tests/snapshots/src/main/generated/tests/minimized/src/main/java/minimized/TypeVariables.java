  package minimized;
  
  /** Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4 */
//⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#
  public class TypeVariables {
//             ^^^^^^^^^^^^^ definition scip-java maven . . minimized/TypeVariables#
//                           kind Class
//                           display_name TypeVariables
//                           signature_documentation
//                           > public class TypeVariables
//                           documentation
//                           > Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4
//             ^^^^^^^^^^^^^ definition scip-java maven . . minimized/TypeVariables#`<init>`().
//                           kind Constructor
//                           display_name <init>
//                           signature_documentation
//                           > public TypeVariables()
//  ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#C#
    static class C {
//               ^ definition scip-java maven . . minimized/TypeVariables#C#
//                 kind Class
//                 display_name C
//                 signature_documentation
//                 > static class C
//               ^ definition scip-java maven . . minimized/TypeVariables#C#`<init>`().
//                 kind Constructor
//                 display_name <init>
//                 signature_documentation
//                 > C()
//    ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#C#mCPublic().
      public void mCPublic() {}
//                ^^^^^^^^ definition scip-java maven . . minimized/TypeVariables#C#mCPublic().
//                         kind Method
//                         display_name mCPublic
//                         signature_documentation
//                         > public void mCPublic()
//                            ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#C#mCPublic().
  
//    ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#C#mCProtected().
      protected void mCProtected() {}
//                   ^^^^^^^^^^^ definition scip-java maven . . minimized/TypeVariables#C#mCProtected().
//                               kind Method
//                               display_name mCProtected
//                               signature_documentation
//                               > protected void mCProtected()
//                                  ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#C#mCProtected().
  
//    ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#C#mCPackage().
      void mCPackage() {}
//         ^^^^^^^^^ definition scip-java maven . . minimized/TypeVariables#C#mCPackage().
//                   kind Method
//                   display_name mCPackage
//                   signature_documentation
//                   > void mCPackage()
//                      ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#C#mCPackage().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#C#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#I#
    interface I {
//            ^ definition scip-java maven . . minimized/TypeVariables#I#
//              kind Interface
//              display_name I
//              signature_documentation
//              > interface I
//    ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#I#mI().
      void mI();
//         ^^ definition scip-java maven . . minimized/TypeVariables#I#mI().
//            kind AbstractMethod
//            display_name mI
//            signature_documentation
//            > public abstract void mI()
//            relationship scip-java maven . . minimized/TypeVariables#CT#mI(). implementation reference
//             ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#I#mI().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#I#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#CT#
    static class CT extends C implements I {
//               ^^ definition scip-java maven . . minimized/TypeVariables#CT#
//                  kind Class
//                  display_name CT
//                  signature_documentation
//                  > static class CT extends C implements I
//                  relationship scip-java maven . . minimized/TypeVariables#C# implementation
//                  relationship scip-java maven . . minimized/TypeVariables#I# implementation
//               ^^ definition scip-java maven . . minimized/TypeVariables#CT#`<init>`().
//                  kind Constructor
//                  display_name <init>
//                  signature_documentation
//                  > CT()
//                          ^ reference scip-java maven . . minimized/TypeVariables#C#
//                                       ^ reference scip-java maven . . minimized/TypeVariables#I#
//    ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#CT#mI().
      public void mI() {}
//                ^^ definition scip-java maven . . minimized/TypeVariables#CT#mI().
//                   kind Method
//                   display_name mI
//                   signature_documentation
//                   > public void mI()
//                   relationship scip-java maven . . minimized/TypeVariables#I#mI(). implementation reference
//                      ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#CT#mI().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/TypeVariables#CT#
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#app().[T]
//  ⌄ enclosing_range_start scip-java maven . . minimized/TypeVariables#app().
//                                           ⌄ enclosing_range_start local 0
    public static <T extends C & I> void app(T t) {
//                 ^ definition scip-java maven . . minimized/TypeVariables#app().[T]
//                   kind TypeParameter
//                   display_name T
//                   signature_documentation
//                   > T extends C & I
//                           ^ reference scip-java maven . . minimized/TypeVariables#C#
//                               ^ reference scip-java maven . . minimized/TypeVariables#I#
//                                       ^^^ definition scip-java maven . . minimized/TypeVariables#app().
//                                           kind StaticMethod
//                                           display_name app
//                                           signature_documentation
//                                           > public static <T extends C & I> void app(T t)
//                                           ^ reference scip-java maven . . minimized/TypeVariables#app().[T]
//                                             ^ definition local 0
//                                               display_name t
//                                               signature_documentation
//                                               > T t
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
  
