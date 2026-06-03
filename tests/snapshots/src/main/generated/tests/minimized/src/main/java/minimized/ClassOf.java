  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/ClassOf#
  public class ClassOf {
//             ^^^^^^^ definition scip-java maven . . minimized/ClassOf#
//                     display_name ClassOf
//                     signature_documentation java public class ClassOf
//                     kind Class
//             ^^^^^^^ definition scip-java maven . . minimized/ClassOf#`<init>`().
//                     display_name <init>
//                     signature_documentation java public ClassOf()
//                     kind Constructor
//  ⌄ enclosing_range_start scip-java maven . . minimized/ClassOf#app().
    public static String app() {
//                ^^^^^^ reference scip-java maven jdk 11 java/lang/String#
//                       ^^^ definition scip-java maven . . minimized/ClassOf#app().
//                           display_name app
//                           signature_documentation java public static String app()
//                           kind StaticMethod
      return ClassOf.class.getName();
//           ^^^^^^^ reference scip-java maven . . minimized/ClassOf#
//                   ^^^^^ reference scip-java maven . . minimized/ClassOf#class.
//                         ^^^^^^^ reference scip-java maven jdk 11 java/lang/Class#getName().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/ClassOf#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/ClassOf#
