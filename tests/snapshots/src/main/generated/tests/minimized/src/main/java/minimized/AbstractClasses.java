package minimized;

public abstract class AbstractClasses {
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#
//                                    display_name AbstractClasses
//                                    documentation ```java\npublic abstract class AbstractClasses\n```
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#`<init>`().
//                                    display_name <init>
//                                    documentation ```java\npublic AbstractClasses()\n```
  public String defaultImplementation() {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#defaultImplementation().
//                                    display_name defaultImplementation
//                                    documentation ```java\npublic String defaultImplementation()\n```
    return "";
  }

  public abstract String abstractImplementation();
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                       ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#abstractImplementation().
//                                              display_name abstractImplementation
//                                              documentation ```java\npublic abstract String abstractImplementation()\n```
//                                              relationship is_reference is_implementation semanticdb maven . . minimized/SubClasses#abstractImplementation().
}
