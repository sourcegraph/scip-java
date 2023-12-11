package minimized;

/** Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4 */
public class TypeVariables {
//           ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#
//                         display_name TypeVariables
//                         documentation ```java\npublic class TypeVariables\n```
//                         documentation Example from https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4 
//           ^^^^^^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#`<init>`().
//                         display_name <init>
//                         documentation ```java\npublic TypeVariables()\n```
  static class C {
//             ^ definition semanticdb maven . . minimized/TypeVariables#C#
//               display_name C
//               documentation ```java\nstatic class C\n```
//             ^ definition semanticdb maven . . minimized/TypeVariables#C#`<init>`().
//               display_name <init>
//               documentation ```java\nC()\n```
    public void mCPublic() {}
//              ^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#C#mCPublic().
//                       display_name mCPublic
//                       documentation ```java\npublic void mCPublic()\n```

    protected void mCProtected() {}
//                 ^^^^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#C#mCProtected().
//                             display_name mCProtected
//                             documentation ```java\nprotected void mCProtected()\n```

    void mCPackage() {}
//       ^^^^^^^^^ definition semanticdb maven . . minimized/TypeVariables#C#mCPackage().
//                 display_name mCPackage
//                 documentation ```java\nvoid mCPackage()\n```
  }

  interface I {
//          ^ definition semanticdb maven . . minimized/TypeVariables#I#
//            display_name I
//            documentation ```java\ninterface I\n```
    void mI();
//       ^^ definition semanticdb maven . . minimized/TypeVariables#I#mI().
//          display_name mI
//          documentation ```java\npublic abstract void mI()\n```
//          relationship is_reference is_implementation semanticdb maven . . minimized/TypeVariables#CT#mI().
  }

  static class CT extends C implements I {
//             ^^ definition semanticdb maven . . minimized/TypeVariables#CT#
//                display_name CT
//                documentation ```java\nstatic class CT\n```
//                relationship is_implementation semanticdb maven . . minimized/TypeVariables#C#
//                relationship is_implementation semanticdb maven . . minimized/TypeVariables#I#
//             ^^ definition semanticdb maven . . minimized/TypeVariables#CT#`<init>`().
//                display_name <init>
//                documentation ```java\nCT()\n```
//                        ^ reference semanticdb maven . . minimized/TypeVariables#C#
//                                     ^ reference semanticdb maven . . minimized/TypeVariables#I#
    public void mI() {}
//              ^^ definition semanticdb maven . . minimized/TypeVariables#CT#mI().
//                 display_name mI
//                 documentation ```java\npublic void mI()\n```
//                 relationship is_reference is_implementation semanticdb maven . . minimized/TypeVariables#I#mI().
  }

  public static <T extends C & I> void app(T t) {
//               ^ definition semanticdb maven . . minimized/TypeVariables#app().[T]
//                 display_name T
//                 documentation ```java\nT extends C & I\n```
//                         ^ reference semanticdb maven . . minimized/TypeVariables#C#
//                             ^ reference semanticdb maven . . minimized/TypeVariables#I#
//                                     ^^^ definition semanticdb maven . . minimized/TypeVariables#app().
//                                         display_name app
//                                         documentation ```java\npublic static <T extends C & I> void app(T t)\n```
//                                         ^ reference semanticdb maven . . minimized/TypeVariables#app().[T]
//                                           ^ definition local 0
//                                             display_name t
//                                             documentation ```java\nT t\n```
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
