  package snapshots;
  
//⌄ enclosing_range_start scip-java maven . . snapshots/ClassConsumer#
  public class ClassConsumer {
//             ^^^^^^^^^^^^^ definition scip-java maven . . snapshots/ClassConsumer#
//                           kind Class
//                           display_name ClassConsumer
//                           signature_documentation
//                           > public class ClassConsumer
//             ^^^^^^^^^^^^^ definition scip-java maven . . snapshots/ClassConsumer#`<init>`().
//                           kind Constructor
//                           display_name <init>
//                           signature_documentation
//                           > public ClassConsumer()
//  ⌄ enclosing_range_start scip-java maven . . snapshots/ClassConsumer#run().
    public static void run() {
//                     ^^^ definition scip-java maven . . snapshots/ClassConsumer#run().
//                         kind StaticMethod
//                         display_name run
//                         signature_documentation
//                         > public static void run()
      System.out.println(new Class().getAsdf());
//    ^^^^^^ reference scip-java maven jdk 17 java/lang/System#
//           ^^^ reference scip-java maven jdk 17 java/lang/System#out.
//               ^^^^^^^ reference scip-java maven jdk 17 java/io/PrintStream#println(+9).
//                           ^^^^^ reference scip-java maven . . snapshots/Class#`<init>`(+1).
//                                   ^^^^^^^ reference scip-java maven . . snapshots/Class#getAsdf().
    }
//  ⌃ enclosing_range_end scip-java maven . . snapshots/ClassConsumer#run().
  }
//⌃ enclosing_range_end scip-java maven . . snapshots/ClassConsumer#
  
