  package minimized;
  
//⌄ enclosing_range_start scip-java maven . . minimized/ClassOf#
  public class ClassOf {
//             ^^^^^^^ definition scip-java maven . . minimized/ClassOf#
//                     kind Class
//                     display_name ClassOf
//                     signature_documentation
//                     > public class ClassOf
//             ^^^^^^^ definition scip-java maven . . minimized/ClassOf#`<init>`().
//                     kind Constructor
//                     display_name <init>
//                     signature_documentation
//                     > public ClassOf()
//  ⌄ enclosing_range_start scip-java maven . . minimized/ClassOf#app().
    public static String app() {
//                ^^^^^^ reference scip-java maven jdk 17 java/lang/String#
//                       ^^^ definition scip-java maven . . minimized/ClassOf#app().
//                           kind StaticMethod
//                           display_name app
//                           signature_documentation
//                           > public static String app()
      return ClassOf.class.getName();
//           ^^^^^^^ reference scip-java maven . . minimized/ClassOf#
//                   ^^^^^ reference scip-java maven . . minimized/ClassOf#class.
//                         ^^^^^^^ reference scip-java maven jdk 17 java/lang/Class#getName().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/ClassOf#app().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/ClassOf#
  
