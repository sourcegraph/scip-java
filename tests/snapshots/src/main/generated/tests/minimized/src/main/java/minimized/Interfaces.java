package minimized;

public interface Interfaces {
//               ^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#
//                          display_name Interfaces
//                          signature_documentation java public interface Interfaces
//                          kind Interface
  static void staticInterfaceMethod() {}

  String abstractInterfaceMethod();

  default String defaultInterfaceMethod() {
    return "default";
  }
}

interface BookService {
//        ^^^^^^^^^^^ definition semanticdb maven . . minimized/BookService#
//                    display_name BookService
//                    signature_documentation java interface BookService
//                    kind Interface
  void checkPages();
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
