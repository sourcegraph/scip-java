package com.airbnb.epoxy;

interface Timer {
//        ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Timer#
//              display_name Timer
//              documentation ```java\ninterface Timer\n```
  void start(String sectionName);
//     ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Timer#start().
//           display_name start
//           documentation ```java\npublic abstract void start(String sectionName)\n```
//           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/DebugTimer#start().
//           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/NoOpTimer#start().
//           ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                  ^^^^^^^^^^^ definition local 0
//                              display_name sectionName
//                              documentation ```java\nString sectionName\n```
  void stop();
//     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/Timer#stop().
//          display_name stop
//          documentation ```java\npublic abstract void stop()\n```
//          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/DebugTimer#stop().
//          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/NoOpTimer#stop().
}
