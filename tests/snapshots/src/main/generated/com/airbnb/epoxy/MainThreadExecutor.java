package com.airbnb.epoxy;

import static com.airbnb.epoxy.EpoxyAsyncUtil.AYSNC_MAIN_THREAD_HANDLER;
//            ^^^ reference com/
//                ^^^^^^ reference com/airbnb/
//                       ^^^^^ reference com/airbnb/epoxy/
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAsyncUtil#
import static com.airbnb.epoxy.EpoxyAsyncUtil.MAIN_THREAD_HANDLER;
//            ^^^ reference com/
//                ^^^^^^ reference com/airbnb/
//                       ^^^^^ reference com/airbnb/epoxy/
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAsyncUtil#

class MainThreadExecutor extends HandlerExecutor {
^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/MainThreadExecutor#
//                               ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HandlerExecutor#
  static final MainThreadExecutor INSTANCE = new MainThreadExecutor(false);
//             ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#
//                                ^^^^^^^^ definition com/airbnb/epoxy/MainThreadExecutor#INSTANCE.
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#`<init>`().
//                                               ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#
  static final MainThreadExecutor ASYNC_INSTANCE = new MainThreadExecutor(true);
//             ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#
//                                ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/MainThreadExecutor#ASYNC_INSTANCE.
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#`<init>`().
//                                                     ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#

  MainThreadExecutor(boolean async) {
  ^^^^^^ definition com/airbnb/epoxy/MainThreadExecutor#`<init>`().
//                           ^^^^^ definition local0
    super(async ? AYSNC_MAIN_THREAD_HANDLER : MAIN_THREAD_HANDLER);
//  ^^^^^ reference com/airbnb/epoxy/HandlerExecutor#`<init>`().
//        ^^^^^ reference local0
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAsyncUtil#AYSNC_MAIN_THREAD_HANDLER.
//                                            ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAsyncUtil#MAIN_THREAD_HANDLER.
  }
}


