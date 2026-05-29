  package minimized;
  
//⌄ enclosing_range_start semanticdb maven . . minimized/Interfaces#
  public interface Interfaces {
//                 ^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#
//                            display_name Interfaces
//                            signature_documentation java public interface Interfaces
//                            kind Interface
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Interfaces#staticInterfaceMethod().
    static void staticInterfaceMethod() {}
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#staticInterfaceMethod().
//                                    display_name staticInterfaceMethod
//                                    signature_documentation java public static void staticInterfaceMethod()
//                                    kind StaticMethod
//                                       ⌃ enclosing_range_end semanticdb maven . . minimized/Interfaces#staticInterfaceMethod().
  
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Interfaces#abstractInterfaceMethod().
    String abstractInterfaceMethod();
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//         ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#abstractInterfaceMethod().
//                                 display_name abstractInterfaceMethod
//                                 signature_documentation java public abstract String abstractInterfaceMethod()
//                                 kind AbstractMethod
//                                 relationship is_reference is_implementation semanticdb maven . . minimized/SubClasses#abstractInterfaceMethod().
//                                  ⌃ enclosing_range_end semanticdb maven . . minimized/Interfaces#abstractInterfaceMethod().
  
//  ⌄ enclosing_range_start semanticdb maven . . minimized/Interfaces#defaultInterfaceMethod().
    default String defaultInterfaceMethod() {
//          ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#defaultInterfaceMethod().
//                                        display_name defaultInterfaceMethod
//                                        signature_documentation java public default String defaultInterfaceMethod()
//                                        kind Method
      return "default";
    }
//  ⌃ enclosing_range_end semanticdb maven . . minimized/Interfaces#defaultInterfaceMethod().
  }
//⌃ enclosing_range_end semanticdb maven . . minimized/Interfaces#
  
//⌄ enclosing_range_start semanticdb maven . . minimized/BookService#
  interface BookService {
//          ^^^^^^^^^^^ definition semanticdb maven . . minimized/BookService#
//                      display_name BookService
//                      signature_documentation java interface BookService
//                      kind Interface
//  ⌄ enclosing_range_start semanticdb maven . . minimized/BookService#checkPages().
    void checkPages();
//       ^^^^^^^^^^ definition semanticdb maven . . minimized/BookService#checkPages().
//                  display_name checkPages
//                  signature_documentation java public abstract void checkPages()
//                  kind AbstractMethod
//                   ⌃ enclosing_range_end semanticdb maven . . minimized/BookService#checkPages().
  }
//⌃ enclosing_range_end semanticdb maven . . minimized/BookService#
  
//⌄ enclosing_range_start semanticdb maven . . minimized/MyService#
  interface MyService {
//          ^^^^^^^^^ definition semanticdb maven . . minimized/MyService#
//                    display_name MyService
//                    signature_documentation java interface MyService
//                    kind Interface
//  ⌄ enclosing_range_start semanticdb maven . . minimized/MyService#bookService().
    BookService bookService();
//  ^^^^^^^^^^^ reference semanticdb maven . . minimized/BookService#
//              ^^^^^^^^^^^ definition semanticdb maven . . minimized/MyService#bookService().
//                          display_name bookService
//                          signature_documentation java public abstract BookService bookService()
//                          kind AbstractMethod
//                           ⌃ enclosing_range_end semanticdb maven . . minimized/MyService#bookService().
  
//  ⌄ enclosing_range_start semanticdb maven . . minimized/MyService#example().
    default void example() {
//               ^^^^^^^ definition semanticdb maven . . minimized/MyService#example().
//                       display_name example
//                       signature_documentation java public default void example()
//                       kind Method
      bookService().checkPages();
//    ^^^^^^^^^^^ reference semanticdb maven . . minimized/MyService#bookService().
//                  ^^^^^^^^^^ reference semanticdb maven . . minimized/BookService#checkPages().
    }
//  ⌃ enclosing_range_end semanticdb maven . . minimized/MyService#example().
  }
//⌃ enclosing_range_end semanticdb maven . . minimized/MyService#
