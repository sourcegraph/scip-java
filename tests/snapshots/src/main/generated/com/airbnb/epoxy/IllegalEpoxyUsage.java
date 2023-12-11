package com.airbnb.epoxy;

public class IllegalEpoxyUsage extends RuntimeException {
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#
//                             display_name IllegalEpoxyUsage
//                             documentation ```java\npublic class IllegalEpoxyUsage\n```
//                             relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//                             relationship is_implementation semanticdb maven jdk 11 java/lang/Exception#
//                             relationship is_implementation semanticdb maven jdk 11 java/lang/RuntimeException#
//                             relationship is_implementation semanticdb maven jdk 11 java/lang/Throwable#
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
  public IllegalEpoxyUsage(String message) {
//       ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
//                         display_name <init>
//                         documentation ```java\npublic IllegalEpoxyUsage(String message)\n```
//                         ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                ^^^^^^^ definition local 0
//                                        display_name message
//                                        documentation ```java\nString message\n```
    super(message);
//  ^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#`<init>`(+1).
//        ^^^^^^^ reference local 0
  }
}
