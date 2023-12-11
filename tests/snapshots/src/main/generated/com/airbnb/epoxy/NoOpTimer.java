package com.airbnb.epoxy;

class NoOpTimer implements Timer {
//    ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NoOpTimer#
//              display_name NoOpTimer
//              documentation ```java\nclass NoOpTimer\n```
//              relationship is_implementation semanticdb maven . . com/airbnb/epoxy/Timer#
//    ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NoOpTimer#`<init>`().
//              display_name <init>
//              documentation ```java\nNoOpTimer()\n```
//                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void start(String sectionName) {
//            ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NoOpTimer#start().
//                  display_name start
//                  documentation ```java\n@Override\npublic void start(String sectionName)\n```
//                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Timer#start().
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                         ^^^^^^^^^^^ definition local 0
//                                     display_name sectionName
//                                     documentation ```java\nString sectionName\n```

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void stop() {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/NoOpTimer#stop().
//                 display_name stop
//                 documentation ```java\n@Override\npublic void stop()\n```
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Timer#stop().

  }
}
