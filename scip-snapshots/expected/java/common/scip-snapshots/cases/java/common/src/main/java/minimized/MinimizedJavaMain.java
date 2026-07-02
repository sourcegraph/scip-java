  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/MinimizedJavaMain#
  @Annotations(value = "value", format = "format")
// ^^^^^^^^^^^ reference scip-java maven . . minimized/Annotations#
//             ^^^^^ reference scip-java maven . . minimized/Annotations#value().
//                              ^^^^^^ reference scip-java maven . . minimized/Annotations#format().
  public class MinimizedJavaMain {
//             ^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/MinimizedJavaMain#
//                               kind Class
//                               display_name MinimizedJavaMain
//                               signature_documentation
//                               > @Annotations(value = "value", format = "format")
//                               > public class MinimizedJavaMain
//             ^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/MinimizedJavaMain#`<init>`().
//                               kind Constructor
//                               display_name <init>
//                               signature_documentation
//                               > public MinimizedJavaMain()
//  ⌄ enclosing_range_start scip-java maven . . minimized/MinimizedJavaMain#main().
//                          ⌄ enclosing_range_start local 0
    public static void main(String[] args) {
//                     ^^^^ definition scip-java maven . . minimized/MinimizedJavaMain#main().
//                          kind StaticMethod
//                          display_name main
//                          signature_documentation
//                          > public static void main(String[] args)
//                          ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//                                   ^^^^ definition local 0
//                                        display_name args
//                                        signature_documentation
//                                        > String[] args
//                                      ⌃ enclosing_range_end local 0
      TypeVariables.app(new TypeVariables.CT());
//    ^^^^^^^^^^^^^ reference scip-java maven . . minimized/TypeVariables#
//                  ^^^ reference scip-java maven . . minimized/TypeVariables#app().
//                          ^^^^^^^^^^^^^ reference scip-java maven . . minimized/TypeVariables#
//                                        ^^ reference scip-java maven . . minimized/TypeVariables#CT#`<init>`().
      System.out.println(
//    ^^^^^^ reference scip-java maven jdk 17 java/lang/System#
//           ^^^ reference scip-java maven jdk 17 java/lang/System#out.
//               ^^^^^^^ reference scip-java maven jdk 17 java/io/PrintStream#println(+8).
          Methods.app(42, "42")
//        ^^^^^^^ reference scip-java maven . . minimized/Methods#
//                ^^^ reference scip-java maven . . minimized/Methods#app().
              + Enums.app()
//              ^^^^^ reference scip-java maven . . minimized/Enums#
//                    ^^^ reference scip-java maven . . minimized/Enums#app().
              + Docstrings.app()
//              ^^^^^^^^^^ reference scip-java maven . . minimized/Docstrings#
//                         ^^^ reference scip-java maven . . minimized/Docstrings#app().
              + InnerClasses.app()
//              ^^^^^^^^^^^^ reference scip-java maven . . minimized/InnerClasses#
//                           ^^^ reference scip-java maven . . minimized/InnerClasses#app().
              + ForComprehensions.app(42)
//              ^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/ForComprehensions#
//                                ^^^ reference scip-java maven . . minimized/ForComprehensions#app().
              + AnonymousClasses.app(42)
//              ^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AnonymousClasses#
//                               ^^^ reference scip-java maven . . minimized/AnonymousClasses#app().
              + Primitives.app()
//              ^^^^^^^^^^ reference scip-java maven . . minimized/Primitives#
//                         ^^^ reference scip-java maven . . minimized/Primitives#app().
              + new ParameterizedTypes<Integer, String>().app(42, "42")
//                  ^^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/ParameterizedTypes#`<init>`().
//                                     ^^^^^^^ reference scip-java maven jdk 17 java/lang/Integer#
//                                              ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//                                                        ^^^ reference scip-java maven . . minimized/ParameterizedTypes#app().
              + RawTypes.x.toString()
//              ^^^^^^^^ reference scip-java maven . . minimized/RawTypes#
//                       ^ reference scip-java maven . . minimized/RawTypes#x.
//                         ^^^^^^^^ reference scip-java maven jdk 17 java/lang/Object#toString().
              + ClassOf.app()
//              ^^^^^^^ reference scip-java maven . . minimized/ClassOf#
//                      ^^^ reference scip-java maven . . minimized/ClassOf#app().
              + SubClasses.app()
//              ^^^^^^^^^^ reference scip-java maven . . minimized/SubClasses#
//                         ^^^ reference scip-java maven . . minimized/SubClasses#app().
              + Fields.app());
//              ^^^^^^ reference scip-java maven . . minimized/Fields#
//                     ^^^ reference scip-java maven . . minimized/Fields#app().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/MinimizedJavaMain#main().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/MinimizedJavaMain#
  
