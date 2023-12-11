package minimized;

public class SubClasses extends AbstractClasses implements Interfaces {
//           ^^^^^^^^^^ definition semanticdb maven . . minimized/SubClasses#
//                      display_name SubClasses
//                      documentation ```java\npublic class SubClasses\n```
//                      relationship is_implementation semanticdb maven . . minimized/AbstractClasses#
//                      relationship is_implementation semanticdb maven . . minimized/Interfaces#
//           ^^^^^^^^^^ definition semanticdb maven . . minimized/SubClasses#`<init>`().
//                      display_name <init>
//                      documentation ```java\npublic SubClasses()\n```
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AbstractClasses#
//                                                         ^^^^^^^^^^ reference semanticdb maven . . minimized/Interfaces#

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public String abstractImplementation() {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/SubClasses#abstractImplementation().
//                                     display_name abstractImplementation
//                                     documentation ```java\n@Override\npublic String abstractImplementation()\n```
//                                     relationship is_reference is_implementation semanticdb maven . . minimized/AbstractClasses#abstractImplementation().
    return "abstract";
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public String abstractInterfaceMethod() {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/SubClasses#abstractInterfaceMethod().
//                                      display_name abstractInterfaceMethod
//                                      documentation ```java\n@Override\npublic String abstractInterfaceMethod()\n```
//                                      relationship is_reference is_implementation semanticdb maven . . minimized/Interfaces#abstractInterfaceMethod().
    return "abstractInterface";
  }

  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/SubClasses#app().
//                         display_name app
//                         documentation ```java\npublic static String app()\n```
    SubClasses s = new SubClasses();
//  ^^^^^^^^^^ reference semanticdb maven . . minimized/SubClasses#
//             ^ definition local 0
//               display_name s
//               documentation ```java\nSubClasses s\n```
//                     ^^^^^^^^^^ reference semanticdb maven . . minimized/SubClasses#`<init>`().
    return s.abstractImplementation()
//         ^ reference local 0
//           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/SubClasses#abstractImplementation().
        + s.defaultImplementation()
//        ^ reference local 0
//          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AbstractClasses#defaultImplementation().
        + s.abstractInterfaceMethod()
//        ^ reference local 0
//          ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/SubClasses#abstractInterfaceMethod().
        + s.defaultInterfaceMethod();
//        ^ reference local 0
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/Interfaces#defaultInterfaceMethod().
  }
}
