package minimized;

public interface Interfaces {
  String abstractInterfaceMethod();

  default String defaultInterfaceMethod() {
    return "default";
  }
}
