package minimized;

public interface Interfaces {
//               ^^^^^^^^^^ definition minimized/Interfaces# public interface Interfaces
  String abstractInterfaceMethod();
//^^^^^^ reference java/lang/String#
//       ^^^^^^^^^^^^^^^^^^^^^^^ definition minimized/Interfaces#abstractInterfaceMethod(). public String abstractInterfaceMethod()

  default String defaultInterfaceMethod() {
//        ^^^^^^ reference java/lang/String#
//               ^^^^^^^^^^^^^^^^^^^^^^ definition minimized/Interfaces#defaultInterfaceMethod(). public String defaultInterfaceMethod()
    return "default";
  }
}
