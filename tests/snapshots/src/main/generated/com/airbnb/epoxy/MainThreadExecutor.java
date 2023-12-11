package com.airbnb.epoxy;

import static com.airbnb.epoxy.EpoxyAsyncUtil.AYSNC_MAIN_THREAD_HANDLER;
//            ^^^ reference semanticdb maven . . com/
//                ^^^^^^ reference semanticdb maven . . com/airbnb/
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#
import static com.airbnb.epoxy.EpoxyAsyncUtil.MAIN_THREAD_HANDLER;
//            ^^^ reference semanticdb maven . . com/
//                ^^^^^^ reference semanticdb maven . . com/airbnb/
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#

class MainThreadExecutor extends HandlerExecutor {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#
//                       display_name MainThreadExecutor
//                       signature_documentation java class MainThreadExecutor
//                       relationship is_implementation semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#
//                       relationship is_implementation semanticdb maven jdk 11 java/util/concurrent/Executor#
//                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#
  static final MainThreadExecutor INSTANCE = new MainThreadExecutor(false);
//             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#
//                                ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#INSTANCE.
//                                         display_name INSTANCE
//                                         signature_documentation java static final MainThreadExecutor INSTANCE
//                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#`<init>`().
  static final MainThreadExecutor ASYNC_INSTANCE = new MainThreadExecutor(true);
//             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#
//                                ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#ASYNC_INSTANCE.
//                                               display_name ASYNC_INSTANCE
//                                               signature_documentation java static final MainThreadExecutor ASYNC_INSTANCE
//                                                     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#`<init>`().

  MainThreadExecutor(boolean async) {
//^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#`<init>`().
//                   display_name <init>
//                   signature_documentation java MainThreadExecutor(boolean async)
//                           ^^^^^ definition local 0
//                                 display_name async
//                                 signature_documentation java boolean async
    super(async ? AYSNC_MAIN_THREAD_HANDLER : MAIN_THREAD_HANDLER);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#`<init>`().
//        ^^^^^ reference local 0
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#AYSNC_MAIN_THREAD_HANDLER.
//                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#MAIN_THREAD_HANDLER.
  }
}


