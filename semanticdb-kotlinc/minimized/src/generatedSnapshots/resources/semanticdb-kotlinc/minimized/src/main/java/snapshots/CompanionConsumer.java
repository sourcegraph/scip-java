  package snapshots;
//        ^^^^^^^^^ reference semanticdb maven . . snapshots/
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/CompanionConsumer#
  public class CompanionConsumer {
//             ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/CompanionConsumer#
//                               display_name CompanionConsumer
//                               signature_documentation java public class CompanionConsumer
//                               kind Class
//  ⌄ enclosing_range_start semanticdb maven . . snapshots/CompanionConsumer#`<init>`().
    CompanionConsumer() {
//  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/CompanionConsumer#`<init>`().
//                    display_name <init>
//                    signature_documentation java CompanionConsumer()
//                    kind Constructor
      CompanionOwner.Companion.create();
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . snapshots/CompanionOwner#
//                   ^^^^^^^^^ reference semanticdb maven . . snapshots/CompanionOwner#Companion.
//                             ^^^^^^ reference semanticdb maven . . snapshots/CompanionOwner#Companion#create().
      new CompanionOwner().create();
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . snapshots/CompanionOwner#`<init>`().
//                         ^^^^^^ reference semanticdb maven . . snapshots/CompanionOwner#create().
    }
//  ⌃ enclosing_range_end semanticdb maven . . snapshots/CompanionConsumer#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/CompanionConsumer#
