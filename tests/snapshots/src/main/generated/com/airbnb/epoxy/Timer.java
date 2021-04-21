package com.airbnb.epoxy;

interface Timer {
//        ^^^^^ definition com/airbnb/epoxy/Timer# interface Timer
  void start(String sectionName);
//     ^^^^^ definition com/airbnb/epoxy/Timer#start(). public void start(String sectionName)
//           ^^^^^^ reference java/lang/String#
//                  ^^^^^^^^^^^ definition local0 String sectionName
  void stop();
//     ^^^^ definition com/airbnb/epoxy/Timer#stop(). public void stop()
}
