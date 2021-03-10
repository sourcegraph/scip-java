package com.airbnb.epoxy;

class NoOpTimer implements Timer {
//    ^^^^^^^^^ definition com/airbnb/epoxy/NoOpTimer#
//    ^^^^^^^^^ definition com/airbnb/epoxy/NoOpTimer#`<init>`().
//                         ^^^^^ reference com/airbnb/epoxy/Timer#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void start(String sectionName) {
//            ^^^^^ definition com/airbnb/epoxy/NoOpTimer#start().
//                  ^^^^^^ reference java/lang/String#
//                         ^^^^^^^^^^^ definition local0

  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void stop() {
//            ^^^^ definition com/airbnb/epoxy/NoOpTimer#stop().

  }
}
