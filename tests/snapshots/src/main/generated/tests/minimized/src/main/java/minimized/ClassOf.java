package minimized;

public class ClassOf {
//           ^^^^^^^ definition semanticdb maven . . minimized/ClassOf#
//                   display_name ClassOf
//                   signature_documentation java public class ClassOf
//                   kind Class
//           ^^^^^^^ definition semanticdb maven . . minimized/ClassOf#`<init>`().
//                   display_name <init>
//                   signature_documentation java public ClassOf()
//                   kind Constructor
  public static String app() {
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . minimized/ClassOf#app().
//                         display_name app
//                         signature_documentation java public static String app()
//                         kind StaticMethod
    return ClassOf.class.getName();
//         ^^^^^^^ reference semanticdb maven . . minimized/ClassOf#
//                 ^^^^^ reference semanticdb maven . . minimized/ClassOf#class.
//                       ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getName().
  }
}
