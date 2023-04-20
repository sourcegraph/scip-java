package com.airbnb.epoxy;

import android.util.Log;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/util/
//                  ^^^ reference semanticdb maven . . android/util/Log#

class DebugTimer implements Timer {
//    ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#
//               documentation ```java\nclass DebugTimer\n```
//               relationship is_implementation semanticdb maven . . com/airbnb/epoxy/Timer#
//                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#

  private final String tag;
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#tag.
//                         documentation ```java\nprivate final String tag\n```
  private long startTime;
//             ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#startTime.
//                       documentation ```java\nprivate long startTime\n```
  private String sectionName;
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//               ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#sectionName.
//                           documentation ```java\nprivate String sectionName\n```

  DebugTimer(String tag) {
//^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#`<init>`().
//           documentation ```java\nDebugTimer(String tag)\n```
//           ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                  ^^^ definition local 0
//                      documentation ```java\nString tag\n```
    this.tag = tag;
//       ^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#tag.
//             ^^^ reference local 0
    reset();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#reset().
  }

  private void reset() {
//             ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#reset().
//                   documentation ```java\nprivate void reset()\n```
    startTime = -1;
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#startTime.
    sectionName = null;
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#sectionName.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void start(String sectionName) {
//            ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#start().
//                  documentation ```java\n@Override\npublic void start(String sectionName)\n```
//                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Timer#start().
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                         ^^^^^^^^^^^ definition local 1
//                                     documentation ```java\nString sectionName\n```
    if (startTime != -1) {
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#startTime.
      throw new IllegalStateException("Timer was already started");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }

    startTime = System.nanoTime();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#startTime.
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//                     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/System#nanoTime().
    this.sectionName = sectionName;
//       ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#sectionName.
//                     ^^^^^^^^^^^ reference local 1
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void stop() {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#stop().
//                 documentation ```java\n@Override\npublic void stop()\n```
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Timer#stop().
    if (startTime == -1) {
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#startTime.
      throw new IllegalStateException("Timer was not started");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }

    float durationMs = (System.nanoTime() - startTime) / 1000000f;
//        ^^^^^^^^^^ definition local 2
//                   documentation ```java\nfloat durationMs\n```
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/System#nanoTime().
//                                          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#startTime.
    Log.d(tag, String.format(sectionName + ": %.3fms", durationMs));
//  ^^^ reference semanticdb maven . . _root_/
//      ^ reference semanticdb maven . . d#
//        ^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#tag.
//             ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#format().
//                           ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#sectionName.
//                                                     ^^^^^^^^^^ reference local 2
    reset();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#reset().
  }
}
