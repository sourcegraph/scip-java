  package snapshots;
  
//⌄ enclosing_range_start scip-java maven . . snapshots/ClassConsumer#
  public class ClassConsumer {
//             ^^^^^^^^^^^^^ definition scip-java maven . . snapshots/ClassConsumer#
//                           display_name ClassConsumer
//                           signature_documentation java public class ClassConsumer
//                           kind Class
//             ^^^^^^^^^^^^^ definition scip-java maven . . snapshots/ClassConsumer#`<init>`().
//                           display_name <init>
//                           signature_documentation java public ClassConsumer()
//                           kind Constructor
//  ⌄ enclosing_range_start scip-java maven . . snapshots/ClassConsumer#run().
    public static void run() {
//                     ^^^ definition scip-java maven . . snapshots/ClassConsumer#run().
//                         display_name run
//                         signature_documentation java public static void run()
//                         kind StaticMethod
      System.out.println(new Class().getAsdf());
//    ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//           ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//               ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+9).
//                           ^^^^^ reference scip-java maven . . snapshots/Class#`<init>`(+1).
//                                   ^^^^^^^ reference scip-java maven . . snapshots/Class#getAsdf().
    }
//  ⌃ enclosing_range_end scip-java maven . . snapshots/ClassConsumer#run().
  }
//⌃ enclosing_range_end scip-java maven . . snapshots/ClassConsumer#
