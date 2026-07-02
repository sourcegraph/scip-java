  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/Interfaces#
  public interface Interfaces {
//                 ^^^^^^^^^^ definition scip-java maven . . minimized/Interfaces#
//                            kind Interface
//                            display_name Interfaces
//                            signature_documentation
//                            > public interface Interfaces
//  ⌄ enclosing_range_start scip-java maven . . minimized/Interfaces#staticInterfaceMethod().
    static void staticInterfaceMethod() {}
//              ^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/Interfaces#staticInterfaceMethod().
//                                    kind StaticMethod
//                                    display_name staticInterfaceMethod
//                                    signature_documentation
//                                    > public static void staticInterfaceMethod()
//                                       ⌃ enclosing_range_end scip-java maven . . minimized/Interfaces#staticInterfaceMethod().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Interfaces#abstractInterfaceMethod().
    String abstractInterfaceMethod();
//  ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//         ^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/Interfaces#abstractInterfaceMethod().
//                                 kind AbstractMethod
//                                 display_name abstractInterfaceMethod
//                                 signature_documentation
//                                 > public abstract String abstractInterfaceMethod()
//                                 relationship scip-java maven . . minimized/SubClasses#abstractInterfaceMethod(). implementation reference
//                                  ⌃ enclosing_range_end scip-java maven . . minimized/Interfaces#abstractInterfaceMethod().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/Interfaces#defaultInterfaceMethod().
    default String defaultInterfaceMethod() {
//          ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/Interfaces#defaultInterfaceMethod().
//                                        kind Method
//                                        display_name defaultInterfaceMethod
//                                        signature_documentation
//                                        > public default String defaultInterfaceMethod()
      return "default";
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/Interfaces#defaultInterfaceMethod().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/Interfaces#
  
//⌄ enclosing_range_start scip-java maven . . minimized/BookService#
  interface BookService {
//          ^^^^^^^^^^^ definition scip-java maven . . minimized/BookService#
//                      kind Interface
//                      display_name BookService
//                      signature_documentation
//                      > interface BookService
//  ⌄ enclosing_range_start scip-java maven . . minimized/BookService#checkPages().
    void checkPages();
//       ^^^^^^^^^^ definition scip-java maven . . minimized/BookService#checkPages().
//                  kind AbstractMethod
//                  display_name checkPages
//                  signature_documentation
//                  > public abstract void checkPages()
//                   ⌃ enclosing_range_end scip-java maven . . minimized/BookService#checkPages().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/BookService#
  
//⌄ enclosing_range_start scip-java maven . . minimized/MyService#
  interface MyService {
//          ^^^^^^^^^ definition scip-java maven . . minimized/MyService#
//                    kind Interface
//                    display_name MyService
//                    signature_documentation
//                    > interface MyService
//  ⌄ enclosing_range_start scip-java maven . . minimized/MyService#bookService().
    BookService bookService();
//  ^^^^^^^^^^^ reference scip-java maven . . minimized/BookService#
//              ^^^^^^^^^^^ definition scip-java maven . . minimized/MyService#bookService().
//                          kind AbstractMethod
//                          display_name bookService
//                          signature_documentation
//                          > public abstract BookService bookService()
//                           ⌃ enclosing_range_end scip-java maven . . minimized/MyService#bookService().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/MyService#example().
    default void example() {
//               ^^^^^^^ definition scip-java maven . . minimized/MyService#example().
//                       kind Method
//                       display_name example
//                       signature_documentation
//                       > public default void example()
      bookService().checkPages();
//    ^^^^^^^^^^^ reference scip-java maven . . minimized/MyService#bookService().
//                  ^^^^^^^^^^ reference scip-java maven . . minimized/BookService#checkPages().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/MyService#example().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/MyService#
  
