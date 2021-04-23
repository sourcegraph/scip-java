package minimized;

public interface Interfaces {
  static void staticInterfaceMethod() {}

  String abstractInterfaceMethod();

  default String defaultInterfaceMethod() {
    return "default";
  }
}
