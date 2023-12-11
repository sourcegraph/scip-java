package com.airbnb.epoxy;

class NoOpTimer implements Timer {
//    ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NoOpTimer#
//              display_name NoOpTimer
//              signature_documentation java class NoOpTimer
//              relationship is_implementation semanticdb maven . . com/airbnb/epoxy/Timer#
//    ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NoOpTimer#`<init>`().
//              display_name <init>
//              signature_documentation java NoOpTimer()
//                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void start(String sectionName) {
//            ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NoOpTimer#start().
//                  display_name start
//                  signature_documentation java @Override\npublic void start(String sectionName)
//                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Timer#start().
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                         ^^^^^^^^^^^ definition local 0
//                                     display_name sectionName
//                                     signature_documentation java String sectionName

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void stop() {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/NoOpTimer#stop().
//                 display_name stop
//                 signature_documentation java @Override\npublic void stop()
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Timer#stop().

  }
}
