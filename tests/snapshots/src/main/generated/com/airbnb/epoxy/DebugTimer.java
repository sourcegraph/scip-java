package com.airbnb.epoxy;

import android.util.Log;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/util/
//                  ^^^ reference semanticdb maven . . android/util/Log#

class DebugTimer implements Timer {
//    ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#
//               display_name DebugTimer
//               signature_documentation java class DebugTimer
//               relationship is_implementation semanticdb maven . . com/airbnb/epoxy/Timer#
//                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#

  private final String tag;
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#tag.
//                         display_name tag
//                         signature_documentation java private final String tag
  private long startTime;
//             ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#startTime.
//                       display_name startTime
//                       signature_documentation java private long startTime
  private String sectionName;
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//               ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#sectionName.
//                           display_name sectionName
//                           signature_documentation java private String sectionName

  DebugTimer(String tag) {
//^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#`<init>`().
//           display_name <init>
//           signature_documentation java DebugTimer(String tag)
//           ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                  ^^^ definition local 0
//                      display_name tag
//                      signature_documentation java String tag
    this.tag = tag;
//       ^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#tag.
//             ^^^ reference local 0
    reset();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#reset().
  }

  private void reset() {
//             ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#reset().
//                   display_name reset
//                   signature_documentation java private void reset()
    startTime = -1;
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#startTime.
    sectionName = null;
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#sectionName.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void start(String sectionName) {
//            ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DebugTimer#start().
//                  display_name start
//                  signature_documentation java @Override\npublic void start(String sectionName)
//                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Timer#start().
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                         ^^^^^^^^^^^ definition local 1
//                                     display_name sectionName
//                                     signature_documentation java String sectionName
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
//                 display_name stop
//                 signature_documentation java @Override\npublic void stop()
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Timer#stop().
    if (startTime == -1) {
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#startTime.
      throw new IllegalStateException("Timer was not started");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }

    float durationMs = (System.nanoTime() - startTime) / 1000000f;
//        ^^^^^^^^^^ definition local 2
//                   display_name durationMs
//                   signature_documentation java float durationMs
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/System#nanoTime().
//                                          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#startTime.
    Log.d(tag, String.format(sectionName + ": %.3fms", durationMs));
//  ^^^ reference semanticdb maven . . Log#
//      ^ reference semanticdb maven . . Log#d#
//        ^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#tag.
//             ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#format().
//                           ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#sectionName.
//                                                     ^^^^^^^^^^ reference local 2
    reset();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#reset().
  }
}
