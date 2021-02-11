package minimized;

public class ClassOf {
//     ^^^^^^ definition minimized/ClassOf#`<init>`().
//     ^^^^^^^ definition minimized/ClassOf#
  public static String app() {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/ClassOf#app().
    return ClassOf.class.getName();
//         ^^^^^^^ reference minimized/ClassOf#
//                 ^^^^^ reference minimized/ClassOf#class.
//                       ^^^^^^^ reference java/lang/Class#getName().
  }
}
