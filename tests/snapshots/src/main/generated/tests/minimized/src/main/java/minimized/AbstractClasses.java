package minimized;

public abstract class AbstractClasses {
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#
//                                    documentation ```java\npublic abstract class AbstractClasses\n```
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#`<init>`().
//                                    documentation ```java\npublic AbstractClasses()\n```
  public String defaultImplementation() {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#defaultImplementation().
//                                    documentation ```java\npublic String defaultImplementation()\n```
    return "";
  }

  public abstract String abstractImplementation();
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                       ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AbstractClasses#abstractImplementation().
//                                              documentation ```java\npublic abstract String abstractImplementation()\n```
//                                              relationship is_reference is_implementation semanticdb maven . . minimized/SubClasses#abstractImplementation().
}
