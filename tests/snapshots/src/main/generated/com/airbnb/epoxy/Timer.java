package com.airbnb.epoxy;

interface Timer {
//        ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Timer#
//              display_name Timer
//              signature_documentation java interface Timer
  void start(String sectionName);
//     ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Timer#start().
//           display_name start
//           signature_documentation java public abstract void start(String sectionName)
//           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/DebugTimer#start().
//           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/NoOpTimer#start().
//           ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                  ^^^^^^^^^^^ definition local 0
//                              display_name sectionName
//                              signature_documentation java String sectionName
//                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Timer#start().
  void stop();
//     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/Timer#stop().
//          display_name stop
//          signature_documentation java public abstract void stop()
//          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/DebugTimer#stop().
//          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/NoOpTimer#stop().
}
