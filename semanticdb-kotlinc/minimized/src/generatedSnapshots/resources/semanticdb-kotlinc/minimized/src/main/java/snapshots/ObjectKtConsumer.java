  package snapshots;
//        ^^^^^^^^^ reference semanticdb maven . . snapshots/
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/ObjectKtConsumer#
  public class ObjectKtConsumer {
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/ObjectKtConsumer#
//                              display_name ObjectKtConsumer
//                              signature_documentation java public class ObjectKtConsumer
//                              kind Class
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/ObjectKtConsumer#`<init>`().
//                              display_name <init>
//                              signature_documentation java public ObjectKtConsumer()
//                              kind Constructor
//  ⌄ enclosing_range_start semanticdb maven . . snapshots/ObjectKtConsumer#run().
    public static void run() {
//                     ^^^ definition semanticdb maven . . snapshots/ObjectKtConsumer#run().
//                         display_name run
//                         signature_documentation java public static void run()
//                         kind StaticMethod
      ObjectKt.INSTANCE.fail("boom");
//    ^^^^^^^^ reference semanticdb maven . . snapshots/ObjectKt#
//             ^^^^^^^^ reference semanticdb maven . . snapshots/ObjectKt#INSTANCE.
//                      ^^^^ reference semanticdb maven . . snapshots/ObjectKt#fail().
    }
//  ⌃ enclosing_range_end semanticdb maven . . snapshots/ObjectKtConsumer#run().
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/ObjectKtConsumer#
