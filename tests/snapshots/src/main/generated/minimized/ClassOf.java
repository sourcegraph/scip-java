package minimized;

public class ClassOf {
//           ^^^^^^^ definition minimized/ClassOf# public class ClassOf
//           ^^^^^^^ definition minimized/ClassOf#`<init>`(). public ClassOf()
  public static String app() {
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition minimized/ClassOf#app(). public static String app()
    return ClassOf.class.getName();
//         ^^^^^^^ reference minimized/ClassOf#
//                 ^^^^^ reference minimized/ClassOf#class.
//                       ^^^^^^^ reference java/lang/Class#getName().
  }
}
