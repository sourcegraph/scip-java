package minimized;

@Annotations(value = "value", format = "format")
//^^^^^^^^^^ reference minimized/Annotations#
//           ^^^^^ reference minimized/Annotations#value().
//                            ^^^^^^ reference minimized/Annotations#format().
public class MinimizedJavaMain {
//           ^^^^^^^^^^^^^^^^^ definition minimized/MinimizedJavaMain# public class MinimizedJavaMain
//           ^^^^^^^^^^^^^^^^^ definition minimized/MinimizedJavaMain#`<init>`(). public void <init>()
  public static void main(String[] args) {
//                   ^^^^ definition minimized/MinimizedJavaMain#main(). public static void main(String[] args)
//                        ^^^^^^ reference java/lang/String#
//                                 ^^^^ definition local0 String[] args
    TypeVariables.app(new TypeVariables.CT());
//  ^^^^^^^^^^^^^ reference minimized/TypeVariables#
//                ^^^ reference minimized/TypeVariables#app().
//                    ^^^^^^^^^^^^^^^^^^^^^^ reference minimized/TypeVariables#CT#`<init>`().
//                        ^^^^^^^^^^^^^ reference minimized/TypeVariables#
//                                      ^^ reference minimized/TypeVariables#CT#
    System.out.println(
//  ^^^^^^ reference java/lang/System#
//         ^^^ reference java/lang/System#out.
//             ^^^^^^^ reference java/io/PrintStream#println(+8).
        Methods.app(42, "42")
//      ^^^^^^^ reference minimized/Methods#
//              ^^^ reference minimized/Methods#app().
            + Enums.app()
//            ^^^^^ reference minimized/Enums#
//                  ^^^ reference minimized/Enums#app().
            + Docstrings.app()
//            ^^^^^^^^^^ reference minimized/Docstrings#
//                       ^^^ reference minimized/Docstrings#app().
            + InnerClasses.app()
//            ^^^^^^^^^^^^ reference minimized/InnerClasses#
//                         ^^^ reference minimized/InnerClasses#app().
            + ForComprehensions.app(42)
//            ^^^^^^^^^^^^^^^^^ reference minimized/ForComprehensions#
//                              ^^^ reference minimized/ForComprehensions#app().
            + AnonymousClasses.app(42)
//            ^^^^^^^^^^^^^^^^ reference minimized/AnonymousClasses#
//                             ^^^ reference minimized/AnonymousClasses#app().
            + Primitives.app()
//            ^^^^^^^^^^ reference minimized/Primitives#
//                       ^^^ reference minimized/Primitives#app().
            + new ParameterizedTypes<Integer, String>().app(42, "42")
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference minimized/ParameterizedTypes#`<init>`().
//                ^^^^^^^^^^^^^^^^^^ reference minimized/ParameterizedTypes#
//                                   ^^^^^^^ reference java/lang/Integer#
//                                            ^^^^^^ reference java/lang/String#
//                                                      ^^^ reference minimized/ParameterizedTypes#app().
            + RawTypes.x.toString()
//            ^^^^^^^^ reference minimized/RawTypes#
//                     ^ reference minimized/RawTypes#x.
//                       ^^^^^^^^ reference java/lang/Object#toString().
            + ClassOf.app()
//            ^^^^^^^ reference minimized/ClassOf#
//                    ^^^ reference minimized/ClassOf#app().
            + SubClasses.app()
//            ^^^^^^^^^^ reference minimized/SubClasses#
//                       ^^^ reference minimized/SubClasses#app().
            + Fields.app());
//            ^^^^^^ reference minimized/Fields#
//                   ^^^ reference minimized/Fields#app().
  }
}
