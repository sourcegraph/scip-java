package minimized;

public interface Interfaces {
//               ^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#
//                          display_name Interfaces
//                          documentation ```java\npublic interface Interfaces\n```
  static void staticInterfaceMethod() {}
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#staticInterfaceMethod().
//                                  display_name staticInterfaceMethod
//                                  documentation ```java\npublic static void staticInterfaceMethod()\n```

  String abstractInterfaceMethod();
//^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//       ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#abstractInterfaceMethod().
//                               display_name abstractInterfaceMethod
//                               documentation ```java\npublic abstract String abstractInterfaceMethod()\n```
//                               relationship is_reference is_implementation semanticdb maven . . minimized/SubClasses#abstractInterfaceMethod().

  default String defaultInterfaceMethod() {
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/Interfaces#defaultInterfaceMethod().
//                                      display_name defaultInterfaceMethod
//                                      documentation ```java\npublic default String defaultInterfaceMethod()\n```
    return "default";
  }
}
