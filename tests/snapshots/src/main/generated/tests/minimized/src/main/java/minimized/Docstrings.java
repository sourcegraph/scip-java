  package minimized;
  
  /** Example class docstring. */
//⌄ enclosing_range_start scip-java maven . . minimized/Docstrings#
  public class Docstrings {
//             ^^^^^^^^^^ definition scip-java maven . . minimized/Docstrings#
//                        display_name Docstrings
//                        signature_documentation java public class Docstrings
//                        kind Class
//                        documentation Example class docstring. 
//             ^^^^^^^^^^ definition scip-java maven . . minimized/Docstrings#`<init>`().
//                        display_name <init>
//                        signature_documentation java public Docstrings()
//                        kind Constructor
  
    /** Example field docstring. */
//  ⌄ enclosing_range_start scip-java maven . . minimized/Docstrings#field.
    public static int field = 42;
//                    ^^^^^ definition scip-java maven . . minimized/Docstrings#field.
//                          display_name field
//                          signature_documentation java public static int field
//                          kind StaticField
//                          documentation Example field docstring. 
//                              ⌃ enclosing_range_end scip-java maven . . minimized/Docstrings#field.
  
    /**
     * Example method docstring.
     *
     * @return 42.
     */
//  ⌄ enclosing_range_start scip-java maven . . minimized/Docstrings#method().
    public static int method() {
//                    ^^^^^^ definition scip-java maven . . minimized/Docstrings#method().
//                           display_name method
//                           signature_documentation java public static int method()
//                           kind StaticMethod
//                           documentation  Example method docstring.\n\n @return 42.\n
      return 42;
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Docstrings#method().
  
    /**
     * Example method parameter docstring.
     *
     * @param n The parameter.
     * @return The number + 42.
     */
//  ⌄ enclosing_range_start scip-java maven . . minimized/Docstrings#methodParameter().
//                                    ⌄ enclosing_range_start local 0
    public static int methodParameter(int n) {
//                    ^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/Docstrings#methodParameter().
//                                    display_name methodParameter
//                                    signature_documentation java public static int methodParameter(int n)
//                                    kind StaticMethod
//                                    documentation  Example method parameter docstring.\n\n @param n The parameter.\n @return The number + 42.\n
//                                        ^ definition local 0
//                                          display_name n
//                                          signature_documentation java int n
//                                          enclosing_symbol scip-java maven . . minimized/Docstrings#methodParameter().
//                                        ⌃ enclosing_range_end local 0
      return n + 42;
//           ^ reference local 0
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Docstrings#methodParameter().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Docstrings#app().
    public static String app() {
//                ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                       ^^^ definition scip-java maven . . minimized/Docstrings#app().
//                           display_name app
//                           signature_documentation java public static String app()
//                           kind StaticMethod
      return String.format("%s%s%s", field, method(), methodParameter(42));
//           ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                  ^^^^^^ reference scip-java maven jdk 11 java/lang/String#format().
//                                   ^^^^^ reference scip-java maven . . minimized/Docstrings#field.
//                                          ^^^^^^ reference scip-java maven . . minimized/Docstrings#method().
//                                                    ^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/Docstrings#methodParameter().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Docstrings#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Docstrings#
