package minimized;

public interface Interfaces {
//     ^^^^^^^^^^ definition minimized/Interfaces#
  String abstractInterfaceMethod();
  ^^^^^^ reference java/lang/String#
//       ^^^^^^^^^^^^^^^^^^^^^^^ definition minimized/Interfaces#abstractInterfaceMethod().

  default String defaultInterfaceMethod() {
//        ^^^^^^ reference java/lang/String#
//               ^^^^^^^^^^^^^^^^^^^^^^ definition minimized/Interfaces#defaultInterfaceMethod().
    return "default";
  }
}
