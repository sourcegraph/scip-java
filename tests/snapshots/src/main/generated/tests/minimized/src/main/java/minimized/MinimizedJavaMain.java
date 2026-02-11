package minimized;

@Annotations(value = "value", format = "format")
//^^^^^^^^^^ reference semanticdb maven . . minimized/Annotations#
//           ^^^^^ reference semanticdb maven . . minimized/Annotations#value().
//                            ^^^^^^ reference semanticdb maven . . minimized/Annotations#format().
public class MinimizedJavaMain {
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedJavaMain#
//                             display_name MinimizedJavaMain
//                             signature_documentation java @Annotations(value = "value", format = "format")\npublic class MinimizedJavaMain
//                             enclosing_range 2 0 20 1
//                             kind Class
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/MinimizedJavaMain#`<init>`().
//                             display_name <init>
//                             signature_documentation java public MinimizedJavaMain()
//                             kind Constructor
  public static void main(String[] args) {
//                   ^^^^ definition semanticdb maven . . minimized/MinimizedJavaMain#main().
//                        display_name main
//                        signature_documentation java public static void main(String[] args)
//                        enclosing_range 4 2 19 3
//                        kind StaticMethod
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                 ^^^^ definition local 0
//                                      display_name args
//                                      signature_documentation java String[] args
//                                      enclosing_symbol semanticdb maven . . minimized/MinimizedJavaMain#main().
//                                      enclosing_range 4 26 39
    TypeVariables.app(new TypeVariables.CT());
//  ^^^^^^^^^^^^^ reference semanticdb maven . . minimized/TypeVariables#
//                ^^^ reference semanticdb maven . . minimized/TypeVariables#app().
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . minimized/TypeVariables#
//                                      ^^ reference semanticdb maven . . minimized/TypeVariables#CT#`<init>`().
    System.out.println(
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//         ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//             ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+8).
        Methods.app(42, "42")
//      ^^^^^^^ reference semanticdb maven . . minimized/Methods#
//              ^^^ reference semanticdb maven . . minimized/Methods#app().
            + Enums.app()
//            ^^^^^ reference semanticdb maven . . minimized/Enums#
//                  ^^^ reference semanticdb maven . . minimized/Enums#app().
            + Docstrings.app()
//            ^^^^^^^^^^ reference semanticdb maven . . minimized/Docstrings#
//                       ^^^ reference semanticdb maven . . minimized/Docstrings#app().
            + InnerClasses.app()
//            ^^^^^^^^^^^^ reference semanticdb maven . . minimized/InnerClasses#
//                         ^^^ reference semanticdb maven . . minimized/InnerClasses#app().
            + ForComprehensions.app(42)
//            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/ForComprehensions#
//                              ^^^ reference semanticdb maven . . minimized/ForComprehensions#app().
            + AnonymousClasses.app(42)
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnonymousClasses#
//                             ^^^ reference semanticdb maven . . minimized/AnonymousClasses#app().
            + Primitives.app()
//            ^^^^^^^^^^ reference semanticdb maven . . minimized/Primitives#
//                       ^^^ reference semanticdb maven . . minimized/Primitives#app().
            + new ParameterizedTypes<Integer, String>().app(42, "42")
//                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/ParameterizedTypes#`<init>`().
//                                   ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                                            ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                                      ^^^ reference semanticdb maven . . minimized/ParameterizedTypes#app().
            + RawTypes.x.toString()
//            ^^^^^^^^ reference semanticdb maven . . minimized/RawTypes#
//                     ^ reference semanticdb maven . . minimized/RawTypes#x.
//                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#toString().
            + ClassOf.app()
//            ^^^^^^^ reference semanticdb maven . . minimized/ClassOf#
//                    ^^^ reference semanticdb maven . . minimized/ClassOf#app().
            + SubClasses.app()
//            ^^^^^^^^^^ reference semanticdb maven . . minimized/SubClasses#
//                       ^^^ reference semanticdb maven . . minimized/SubClasses#app().
            + Fields.app());
//            ^^^^^^ reference semanticdb maven . . minimized/Fields#
//                   ^^^ reference semanticdb maven . . minimized/Fields#app().
  }
}
