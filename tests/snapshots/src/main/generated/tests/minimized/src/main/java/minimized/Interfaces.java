  package minimized;
  
  public interface Interfaces {
//                 ^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#
//                            display_name Interfaces
//                            signature_documentation java public interface Interfaces
//                            enclosing_range 2 0 10 1
//                            kind Interface
    static void staticInterfaceMethod() {}
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#staticInterfaceMethod().
//                                    display_name staticInterfaceMethod
//                                    signature_documentation java public static void staticInterfaceMethod()
//                                    enclosing_range 3 2 40
//                                    kind StaticMethod
  
    String abstractInterfaceMethod();
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//         ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#abstractInterfaceMethod().
//                                 display_name abstractInterfaceMethod
//                                 signature_documentation java public abstract String abstractInterfaceMethod()
//                                 enclosing_range 5 2 35
//                                 kind AbstractMethod
//                                 relationship is_reference is_implementation semanticdb maven . . minimized/SubClasses#abstractInterfaceMethod().
  
    default String defaultInterfaceMethod() {
//          ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#defaultInterfaceMethod().
//                                        display_name defaultInterfaceMethod
//                                        signature_documentation java public default String defaultInterfaceMethod()
//                                        enclosing_range 7 2 9 3
//                                        kind Method
      return "default";
    }
  }
  
  interface BookService {
//          ^^^^^^^^^^^ definition semanticdb maven . . minimized/BookService#
//                      display_name BookService
//                      signature_documentation java interface BookService
//                      enclosing_range 12 0 14 1
//                      kind Interface
    void checkPages();
//       ^^^^^^^^^^ definition semanticdb maven . . minimized/BookService#checkPages().
//                  display_name checkPages
//                  signature_documentation java public abstract void checkPages()
//                  enclosing_range 13 2 20
//                  kind AbstractMethod
  }
  
  interface MyService {
//          ^^^^^^^^^ definition semanticdb maven . . minimized/MyService#
//                    display_name MyService
//                    signature_documentation java interface MyService
//                    enclosing_range 16 0 22 1
//                    kind Interface
    BookService bookService();
//  ^^^^^^^^^^^ reference semanticdb maven . . minimized/BookService#
//              ^^^^^^^^^^^ definition semanticdb maven . . minimized/MyService#bookService().
//                          display_name bookService
//                          signature_documentation java public abstract BookService bookService()
//                          enclosing_range 17 2 28
//                          kind AbstractMethod
  
    default void example() {
//               ^^^^^^^ definition semanticdb maven . . minimized/MyService#example().
//                       display_name example
//                       signature_documentation java public default void example()
//                       enclosing_range 19 2 21 3
//                       kind Method
      bookService().checkPages();
//    ^^^^^^^^^^^ reference semanticdb maven . . minimized/MyService#bookService().
//                  ^^^^^^^^^^ reference semanticdb maven . . minimized/BookService#checkPages().
    }
  }
