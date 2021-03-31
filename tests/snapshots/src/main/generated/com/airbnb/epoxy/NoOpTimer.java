package com.airbnb.epoxy;

class NoOpTimer implements Timer {
//    ^^^^^^^^^ definition com/airbnb/epoxy/NoOpTimer# class NoOpTimer extends Timer
//    ^^^^^^^^^ definition com/airbnb/epoxy/NoOpTimer#`<init>`(). NoOpTimer()
//                         ^^^^^ reference com/airbnb/epoxy/Timer#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void start(String sectionName) {
//            ^^^^^ definition com/airbnb/epoxy/NoOpTimer#start(). public void start(String sectionName)
//                  ^^^^^^ reference java/lang/String#
//                         ^^^^^^^^^^^ definition local0 String sectionName

  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void stop() {
//            ^^^^ definition com/airbnb/epoxy/NoOpTimer#stop(). public void stop()

  }
}
