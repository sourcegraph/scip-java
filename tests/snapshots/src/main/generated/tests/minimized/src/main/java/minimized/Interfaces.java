package minimized;

public interface Interfaces {
//               ^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#
//                          display_name Interfaces
//                          signature_documentation java public interface Interfaces
//                          kind Interface
  static void staticInterfaceMethod() {}
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#staticInterfaceMethod().
//                                  display_name staticInterfaceMethod
//                                  signature_documentation java public static void staticInterfaceMethod()
//                                  kind StaticMethod

  String abstractInterfaceMethod();
//^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//       ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#abstractInterfaceMethod().
//                               display_name abstractInterfaceMethod
//                               signature_documentation java public abstract String abstractInterfaceMethod()
//                               kind AbstractMethod
//                               relationship is_reference is_implementation semanticdb maven . . minimized/SubClasses#abstractInterfaceMethod().

  default String defaultInterfaceMethod() {
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#defaultInterfaceMethod().
//                                      display_name defaultInterfaceMethod
//                                      signature_documentation java public default String defaultInterfaceMethod()
//                                      kind Method
    return "default";
  }
}

interface BookService {
//        ^^^^^^^^^^^ definition semanticdb maven . . minimized/BookService#
//                    display_name BookService
//                    signature_documentation java interface BookService
//                    kind Interface
  void checkPages();
//     ^^^^^^^^^^ definition semanticdb maven . . minimized/BookService#checkPages().
//                display_name checkPages
//                signature_documentation java public abstract void checkPages()
//                kind AbstractMethod
}

interface MyService {
//        ^^^^^^^^^ definition semanticdb maven . . minimized/MyService#
//                  display_name MyService
//                  signature_documentation java interface MyService
//                  kind Interface
  BookService bookService();
//^^^^^^^^^^^ reference semanticdb maven . . minimized/BookService#
//            ^^^^^^^^^^^ definition semanticdb maven . . minimized/MyService#bookService().
//                        display_name bookService
//                        signature_documentation java public abstract BookService bookService()
//                        kind AbstractMethod

  default void example() {
//             ^^^^^^^ definition semanticdb maven . . minimized/MyService#example().
//                     display_name example
//                     signature_documentation java public default void example()
//                     kind Method
    bookService().checkPages();
//  ^^^^^^^^^^^ reference semanticdb maven . . minimized/MyService#bookService().
//                ^^^^^^^^^^ reference semanticdb maven . . minimized/BookService#checkPages().
  }
}
