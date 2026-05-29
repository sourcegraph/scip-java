  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/Interfaces#
  public interface Interfaces {
//                 ^^^^^^^^^^ definition scip-java maven . . minimized/Interfaces#
//                            display_name Interfaces
//                            signature_documentation java public abstract interface Interfaces
//                            kind Interface
//  ⌄ enclosing_range_start scip-java maven . . minimized/Interfaces#staticInterfaceMethod().
    static void staticInterfaceMethod() {}
//              ^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/Interfaces#staticInterfaceMethod().
//                                    display_name staticInterfaceMethod
//                                    signature_documentation java public static void staticInterfaceMethod()
//                                    kind StaticMethod
//                                       ⌃ enclosing_range_end scip-java maven . . minimized/Interfaces#staticInterfaceMethod().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Interfaces#abstractInterfaceMethod().
    String abstractInterfaceMethod();
//  ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//         ^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/Interfaces#abstractInterfaceMethod().
//                                 display_name abstractInterfaceMethod
//                                 signature_documentation java public abstract String abstractInterfaceMethod()
//                                 kind AbstractMethod
//                                 relationship is_reference is_implementation scip-java maven . . minimized/SubClasses#abstractInterfaceMethod().
//                                  ⌃ enclosing_range_end scip-java maven . . minimized/Interfaces#abstractInterfaceMethod().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Interfaces#defaultInterfaceMethod().
    default String defaultInterfaceMethod() {
//          ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/Interfaces#defaultInterfaceMethod().
//                                        display_name defaultInterfaceMethod
//                                        signature_documentation java public default String defaultInterfaceMethod()
//                                        kind Method
      return "default";
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Interfaces#defaultInterfaceMethod().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Interfaces#
  
//⌄ enclosing_range_start scip-java maven . . minimized/BookService#
  interface BookService {
//          ^^^^^^^^^^^ definition scip-java maven . . minimized/BookService#
//                      display_name BookService
//                      signature_documentation java abstract interface BookService
//                      kind Interface
//  ⌄ enclosing_range_start scip-java maven . . minimized/BookService#checkPages().
    void checkPages();
//       ^^^^^^^^^^ definition scip-java maven . . minimized/BookService#checkPages().
//                  display_name checkPages
//                  signature_documentation java public abstract void checkPages()
//                  kind AbstractMethod
//                   ⌃ enclosing_range_end scip-java maven . . minimized/BookService#checkPages().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/BookService#
  
//⌄ enclosing_range_start scip-java maven . . minimized/MyService#
  interface MyService {
//          ^^^^^^^^^ definition scip-java maven . . minimized/MyService#
//                    display_name MyService
//                    signature_documentation java abstract interface MyService
//                    kind Interface
//  ⌄ enclosing_range_start scip-java maven . . minimized/MyService#bookService().
    BookService bookService();
//  ^^^^^^^^^^^ reference scip-java maven . . minimized/BookService#
//              ^^^^^^^^^^^ definition scip-java maven . . minimized/MyService#bookService().
//                          display_name bookService
//                          signature_documentation java public abstract BookService bookService()
//                          kind AbstractMethod
//                           ⌃ enclosing_range_end scip-java maven . . minimized/MyService#bookService().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/MyService#example().
    default void example() {
//               ^^^^^^^ definition scip-java maven . . minimized/MyService#example().
//                       display_name example
//                       signature_documentation java public default void example()
//                       kind Method
      bookService().checkPages();
//    ^^^^^^^^^^^ reference scip-java maven . . minimized/MyService#bookService().
//                  ^^^^^^^^^^ reference scip-java maven . . minimized/BookService#checkPages().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/MyService#example().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/MyService#
