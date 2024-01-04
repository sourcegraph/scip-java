package com.airbnb.epoxy;

public class IllegalEpoxyUsage extends RuntimeException {
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#
//                             display_name IllegalEpoxyUsage
//                             signature_documentation java public class IllegalEpoxyUsage
//                             relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//                             relationship is_implementation semanticdb maven jdk 11 java/lang/Exception#
//                             relationship is_implementation semanticdb maven jdk 11 java/lang/RuntimeException#
//                             relationship is_implementation semanticdb maven jdk 11 java/lang/Throwable#
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
  public IllegalEpoxyUsage(String message) {
//       ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
//                         display_name <init>
//                         signature_documentation java public IllegalEpoxyUsage(String message)
//                         ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                ^^^^^^^ definition local 0
//                                        display_name message
//                                        signature_documentation java String message
//                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
    super(message);
//  ^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#`<init>`(+1).
//        ^^^^^^^ reference local 0
  }
}
