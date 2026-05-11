  package snapshots;
//        ^^^^^^^^^ reference semanticdb maven . . snapshots/
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/ClassConsumer#
  public class ClassConsumer {
//             ^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/ClassConsumer#
//                           display_name ClassConsumer
//                           signature_documentation java public class ClassConsumer
//                           kind Class
//             ^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/ClassConsumer#`<init>`().
//                           display_name <init>
//                           signature_documentation java public ClassConsumer()
//                           kind Constructor
//    ⌄ enclosing_range_start semanticdb maven . . snapshots/ClassConsumer#run().
      public static void run() {
//                       ^^^ definition semanticdb maven . . snapshots/ClassConsumer#run().
//                           display_name run
//                           signature_documentation java public static void run()
//                           kind StaticMethod
          System.out.println(new Class().getAsdf());
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//               ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//                   ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+9).
//                               ^^^^^ reference semanticdb maven . . snapshots/Class#`<init>`(+1).
//                                       ^^^^^^^ reference semanticdb maven . . snapshots/Class#getAsdf().
      }
//    ⌃ enclosing_range_end semanticdb maven . . snapshots/ClassConsumer#run().
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/ClassConsumer#
