package minimized;

/** Example class docstring. */
public class Docstrings {
//           ^^^^^^^^^^ definition semanticdb maven . . minimized/Docstrings#
//                      display_name Docstrings
//                      signature_documentation java public class Docstrings
//                      documentation Example class docstring. 
//           ^^^^^^^^^^ definition semanticdb maven . . minimized/Docstrings#`<init>`().
//                      display_name <init>
//                      signature_documentation java public Docstrings()

  /** Example field docstring. */
  public static int field = 42;
//                  ^^^^^ definition semanticdb maven . . minimized/Docstrings#field.
//                        display_name field
//                        signature_documentation java public static int field
//                        documentation Example field docstring. 

  /**
   * Example method docstring.
   *
   * @return 42.
   */
  public static int method() {
//                  ^^^^^^ definition semanticdb maven . . minimized/Docstrings#method().
//                         display_name method
//                         signature_documentation java public static int method()
//                         documentation  Example method docstring.\n\n @return 42.\n
    return 42;
  }

  /**
   * Example method parameter docstring.
   *
   * @param n The parameter.
   * @return The number + 42.
   */
  public static int methodParameter(int n) {
//                  ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Docstrings#methodParameter().
//                                  display_name methodParameter
//                                  signature_documentation java public static int methodParameter(int n)
//                                  documentation  Example method parameter docstring.\n\n @param n The parameter.\n @return The number + 42.\n
//                                      ^ definition local 0
//                                        display_name n
//                                        signature_documentation java int n
    return n + 42;
//         ^ reference local 0
  }

  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/Docstrings#app().
//                         display_name app
//                         signature_documentation java public static String app()
    return String.format("%s%s%s", field, method(), methodParameter(42));
//         ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#format().
//                                 ^^^^^ reference semanticdb maven . . minimized/Docstrings#field.
//                                        ^^^^^^ reference semanticdb maven . . minimized/Docstrings#method().
//                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Docstrings#methodParameter().
  }
}
