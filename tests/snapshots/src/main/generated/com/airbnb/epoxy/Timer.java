package com.airbnb.epoxy;

interface Timer {
//        ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Timer#
//              documentation ```java\ninterface Timer\n```
  void start(String sectionName);
//     ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Timer#start().
//           documentation ```java\npublic abstract void start(String sectionName)\n```
//           ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                  ^^^^^^^^^^^ definition local 0
//                              documentation ```java\nString sectionName\n```
  void stop();
//     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/Timer#stop().
//          documentation ```java\npublic abstract void stop()\n```
}
