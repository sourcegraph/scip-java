  package minimized;
  
  /** Example class docstring. */
//⌄ enclosing_range_start scip-java maven . . minimized/Docstrings#
  public class Docstrings {
//             ^^^^^^^^^^ definition scip-java maven . . minimized/Docstrings#
//                        kind Class
//                        display_name Docstrings
//                        signature_documentation
//                        > public class Docstrings
//                        documentation
//                        > Example class docstring.
//             ^^^^^^^^^^ definition scip-java maven . . minimized/Docstrings#`<init>`().
//                        kind Constructor
//                        display_name <init>
//                        signature_documentation
//                        > public Docstrings()
  
    /** Example field docstring. */
//  ⌄ enclosing_range_start scip-java maven . . minimized/Docstrings#field.
    public static int field = 42;
//                    ^^^^^ definition scip-java maven . . minimized/Docstrings#field.
//                          kind StaticField
//                          display_name field
//                          signature_documentation
//                          > public static int field
//                          documentation
//                          > Example field docstring.
//                              ⌃ enclosing_range_end scip-java maven . . minimized/Docstrings#field.
  
    /**
     * Example method docstring.
     *
     * @return 42.
     */
//  ⌄ enclosing_range_start scip-java maven . . minimized/Docstrings#method().
    public static int method() {
//                    ^^^^^^ definition scip-java maven . . minimized/Docstrings#method().
//                           kind StaticMethod
//                           display_name method
//                           signature_documentation
//                           > public static int method()
//                           documentation
//                           > Example method docstring.
//                           > 
//                           >  @return 42.
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
//                                    kind StaticMethod
//                                    display_name methodParameter
//                                    signature_documentation
//                                    > public static int methodParameter(int n)
//                                    documentation
//                                    > Example method parameter docstring.
//                                    > 
//                                    >  @param n The parameter.
//                                    >  @return The number + 42.
//                                        ^ definition local 0
//                                          display_name n
//                                          signature_documentation
//                                          > int n
//                                        ⌃ enclosing_range_end local 0
      return n + 42;
//           ^ reference local 0
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Docstrings#methodParameter().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Docstrings#app().
    public static String app() {
//                ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                       ^^^ definition scip-java maven . . minimized/Docstrings#app().
//                           kind StaticMethod
//                           display_name app
//                           signature_documentation
//                           > public static String app()
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
  
