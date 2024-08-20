package minimized;

public interface Interfaces {
  static void staticInterfaceMethod() {}

  String abstractInterfaceMethod();

  default String defaultInterfaceMethod() {
    return "default";
  }
}

interface BookService {
  void checkPages();
}

interface MyService {
  BookService bookService();

  default void example() {
    bookService().checkPages();
  }
}
