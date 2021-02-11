package com.airbnb.epoxy;

public class IllegalEpoxyUsage extends RuntimeException {
//     ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/IllegalEpoxyUsage#
//                                     ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
  public IllegalEpoxyUsage(String message) {
//       ^^^^^^ definition com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
//                         ^^^^^^ reference java/lang/String#
//                                ^^^^^^^ definition local0
    super(message);
//  ^^^^^ reference java/lang/RuntimeException#`<init>`(+1).
//        ^^^^^^^ reference local0
  }
}
