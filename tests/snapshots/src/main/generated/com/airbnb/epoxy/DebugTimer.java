package com.airbnb.epoxy;

import android.util.Log;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/util/
//                  ^^^ reference android/util/Log#

class DebugTimer implements Timer {
//^^^^^^^^^^ definition com/airbnb/epoxy/DebugTimer#
//                          ^^^^^ reference com/airbnb/epoxy/Timer#

  private final String tag;
//              ^^^^^^ reference java/lang/String#
//                     ^^^ definition com/airbnb/epoxy/DebugTimer#tag.
  private long startTime;
//             ^^^^^^^^^ definition com/airbnb/epoxy/DebugTimer#startTime.
  private String sectionName;
//        ^^^^^^ reference java/lang/String#
//               ^^^^^^^^^^^ definition com/airbnb/epoxy/DebugTimer#sectionName.

  DebugTimer(String tag) {
//^^^^^^ definition com/airbnb/epoxy/DebugTimer#`<init>`().
//           ^^^^^^ reference java/lang/String#
//                  ^^^ definition local0
    this.tag = tag;
//  ^^^^ reference com/airbnb/epoxy/DebugTimer#this.
//       ^^^ reference com/airbnb/epoxy/DebugTimer#tag.
//             ^^^ reference local0
    reset();
//  ^^^^^ reference com/airbnb/epoxy/DebugTimer#reset().
  }

  private void reset() {
//             ^^^^^ definition com/airbnb/epoxy/DebugTimer#reset().
    startTime = -1;
//  ^^^^^^^^^ reference com/airbnb/epoxy/DebugTimer#startTime.
    sectionName = null;
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/DebugTimer#sectionName.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void start(String sectionName) {
//            ^^^^^ definition com/airbnb/epoxy/DebugTimer#start().
//                  ^^^^^^ reference java/lang/String#
//                         ^^^^^^^^^^^ definition local1
    if (startTime != -1) {
//      ^^^^^^^^^ reference com/airbnb/epoxy/DebugTimer#startTime.
      throw new IllegalStateException("Timer was already started");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }

    startTime = System.nanoTime();
//  ^^^^^^^^^ reference com/airbnb/epoxy/DebugTimer#startTime.
//              ^^^^^^ reference java/lang/System#
//                     ^^^^^^^^ reference java/lang/System#nanoTime().
    this.sectionName = sectionName;
//  ^^^^ reference com/airbnb/epoxy/DebugTimer#this.
//       ^^^^^^^^^^^ reference com/airbnb/epoxy/DebugTimer#sectionName.
//                     ^^^^^^^^^^^ reference local1
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void stop() {
//            ^^^^ definition com/airbnb/epoxy/DebugTimer#stop().
    if (startTime == -1) {
//      ^^^^^^^^^ reference com/airbnb/epoxy/DebugTimer#startTime.
      throw new IllegalStateException("Timer was not started");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }

    float durationMs = (System.nanoTime() - startTime) / 1000000f;
//        ^^^^^^^^^^ definition local2
//                      ^^^^^^ reference java/lang/System#
//                             ^^^^^^^^ reference java/lang/System#nanoTime().
//                                          ^^^^^^^^^ reference com/airbnb/epoxy/DebugTimer#startTime.
    Log.d(tag, String.format(sectionName + ": %.3fms", durationMs));
//  ^^^ reference _root_/
//      ^ reference d#
//        ^^^ reference com/airbnb/epoxy/DebugTimer#tag.
//             ^^^^^^ reference java/lang/String#
//                    ^^^^^^ reference java/lang/String#format().
//                           ^^^^^^^^^^^ reference com/airbnb/epoxy/DebugTimer#sectionName.
//                                                     ^^^^^^^^^^ reference local2
    reset();
//  ^^^^^ reference com/airbnb/epoxy/DebugTimer#reset().
  }
}
