package com.airbnb.epoxy;

interface Timer {
^^^^^ definition com/airbnb/epoxy/Timer#
  void start(String sectionName);
//     ^^^^^ definition com/airbnb/epoxy/Timer#start().
//           ^^^^^^ reference java/lang/String#
//                  ^^^^^^^^^^^ definition local0
  void stop();
//     ^^^^ definition com/airbnb/epoxy/Timer#stop().
}
