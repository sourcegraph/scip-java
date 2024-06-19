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
