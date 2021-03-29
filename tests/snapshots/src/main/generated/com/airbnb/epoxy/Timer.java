package com.airbnb.epoxy;

interface Timer {
//        ^^^^^ definition com/airbnb/epoxy/Timer# abstract interface Timer
  void start(String sectionName);
//     ^^^^^ definition com/airbnb/epoxy/Timer#start(). public abstract start(String sectionName)
//           ^^^^^^ reference java/lang/String#
//                  ^^^^^^^^^^^ definition local0 String sectionName
  void stop();
//     ^^^^ definition com/airbnb/epoxy/Timer#stop(). public abstract stop()
}
