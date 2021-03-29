package minimized;

public interface Interfaces {
//               ^^^^^^^^^^ definition minimized/Interfaces# public abstract interface Interfaces
  String abstractInterfaceMethod();
//^^^^^^ reference java/lang/String#
//       ^^^^^^^^^^^^^^^^^^^^^^^ definition minimized/Interfaces#abstractInterfaceMethod(). public abstract String abstractInterfaceMethod()

  default String defaultInterfaceMethod() {
//        ^^^^^^ reference java/lang/String#
//               ^^^^^^^^^^^^^^^^^^^^^^ definition minimized/Interfaces#defaultInterfaceMethod(). public abstract String defaultInterfaceMethod()
    return "default";
  }
}
