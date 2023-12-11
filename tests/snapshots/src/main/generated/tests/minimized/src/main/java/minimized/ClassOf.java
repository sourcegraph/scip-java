package minimized;

public class ClassOf {
//           ^^^^^^^ definition semanticdb maven . . minimized/ClassOf#
//                   display_name ClassOf
//                   documentation ```java\npublic class ClassOf\n```
//           ^^^^^^^ definition semanticdb maven . . minimized/ClassOf#`<init>`().
//                   display_name <init>
//                   documentation ```java\npublic ClassOf()\n```
  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/ClassOf#app().
//                         display_name app
//                         documentation ```java\npublic static String app()\n```
    return ClassOf.class.getName();
//         ^^^^^^^ reference semanticdb maven . . minimized/ClassOf#
//                 ^^^^^ reference semanticdb maven . . minimized/ClassOf#class.
//                       ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getName().
  }
}
