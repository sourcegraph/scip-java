package minimized;

public interface Interfaces {
//               ^^^^^^^^^^ definition minimized/Interfaces# public interface Interfaces
  static void staticInterfaceMethod() {}
//            ^^^^^^^^^^^^^^^^^^^^^ definition minimized/Interfaces#staticInterfaceMethod(). public static void staticInterfaceMethod()

  String abstractInterfaceMethod();
//^^^^^^ reference java/lang/String#
//       ^^^^^^^^^^^^^^^^^^^^^^^ definition minimized/Interfaces#abstractInterfaceMethod(). public abstract String abstractInterfaceMethod()

  default String defaultInterfaceMethod() {
//        ^^^^^^ reference java/lang/String#
//               ^^^^^^^^^^^^^^^^^^^^^^ definition minimized/Interfaces#defaultInterfaceMethod(). public default String defaultInterfaceMethod()
    return "default";
  }
}
