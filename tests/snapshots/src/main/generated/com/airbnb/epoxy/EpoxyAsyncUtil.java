package com.airbnb.epoxy;

import android.os.Build;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^ reference semanticdb maven . . android/os/Build#
import android.os.Handler;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^ reference semanticdb maven . . android/os/Handler#
import android.os.Handler.Callback;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^ reference semanticdb maven . . android/os/Handler/
//                        ^^^^^^^^ reference semanticdb maven . . android/os/Handler/Callback#
import android.os.HandlerThread;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^^^^^^^ reference semanticdb maven . . android/os/HandlerThread#
import android.os.Looper;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^ reference semanticdb maven . . android/os/Looper#
import android.os.Message;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^ reference semanticdb maven . . android/os/Message#

import androidx.annotation.MainThread;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/MainThread#

/**
 * Various helpers for running Epoxy operations off the main thread.
 */
public final class EpoxyAsyncUtil {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#
//                                display_name EpoxyAsyncUtil
//                                signature_documentation java public final class EpoxyAsyncUtil
//                                documentation  Various helpers for running Epoxy operations off the main thread.\n
  private EpoxyAsyncUtil() {
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#`<init>`().
//                       display_name <init>
//                       signature_documentation java private EpoxyAsyncUtil()
  }

  /**
   * A Handler class that uses the main thread's Looper.
   */
  public static final Handler MAIN_THREAD_HANDLER =
//                    ^^^^^^^ reference semanticdb maven . . Handler#
//                            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#MAIN_THREAD_HANDLER.
//                                                display_name MAIN_THREAD_HANDLER
//                                                signature_documentation java public static final unresolved_type MAIN_THREAD_HANDLER
//                                                documentation  A Handler class that uses the main thread's Looper.\n
      createHandler(Looper.getMainLooper(), false);
//    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#createHandler().
//                  ^^^^^^ reference semanticdb maven . . Looper#
//                         ^^^^^^^^^^^^^ reference semanticdb maven . . Looper#getMainLooper#

  /**
   * A Handler class that uses the main thread's Looper. Additionally, this handler calls
   * {@link Message#setAsynchronous(boolean)} for
   * each {@link Message} that is sent to it or {@link Runnable} that is posted to it
   */
  public static final Handler AYSNC_MAIN_THREAD_HANDLER =
//                    ^^^^^^^ reference semanticdb maven . . Handler#
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#AYSNC_MAIN_THREAD_HANDLER.
//                                                      display_name AYSNC_MAIN_THREAD_HANDLER
//                                                      signature_documentation java public static final unresolved_type AYSNC_MAIN_THREAD_HANDLER
//                                                      documentation  A Handler class that uses the main thread's Looper. Additionally, this handler calls\n {@link Message#setAsynchronous(boolean)} for\n each {@link Message} that is sent to it or {@link Runnable} that is posted to it\n
      createHandler(Looper.getMainLooper(), true);
//    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#createHandler().
//                  ^^^^^^ reference semanticdb maven . . Looper#
//                         ^^^^^^^^^^^^^ reference semanticdb maven . . Looper#getMainLooper#

  private static Handler asyncBackgroundHandler;
//               ^^^^^^^ reference semanticdb maven . . Handler#
//                       ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#asyncBackgroundHandler.
//                                              display_name asyncBackgroundHandler
//                                              signature_documentation java private static unresolved_type asyncBackgroundHandler

  /**
   * A Handler class that uses a separate background thread dedicated to Epoxy. Additionally,
   * this handler calls {@link Message#setAsynchronous(boolean)} for
   * each {@link Message} that is sent to it or {@link Runnable} that is posted to it
   */
  @MainThread
// ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/MainThread#
  public static Handler getAsyncBackgroundHandler() {
//              ^^^^^^^ reference semanticdb maven . . Handler#
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#getAsyncBackgroundHandler().
//                                                display_name getAsyncBackgroundHandler
//                                                signature_documentation java @MainThread\npublic static unresolved_type getAsyncBackgroundHandler()
//                                                documentation  A Handler class that uses a separate background thread dedicated to Epoxy. Additionally,\n this handler calls {@link Message#setAsynchronous(boolean)} for\n each {@link Message} that is sent to it or {@link Runnable} that is posted to it\n
    // This is initialized lazily so we don't create the thread unless it will be used.
    // It isn't synchronized so it should only be accessed on the main thread.
    if (asyncBackgroundHandler == null) {
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#asyncBackgroundHandler.
      asyncBackgroundHandler = createHandler(buildBackgroundLooper("epoxy"), true);
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#asyncBackgroundHandler.
//                             ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#createHandler().
//                                           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#buildBackgroundLooper().
    }

    return asyncBackgroundHandler;
//         ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#asyncBackgroundHandler.
  }

  /**
   * Create a Handler with the given Looper
   *
   * @param async If true the Handler will calls {@link Message#setAsynchronous(boolean)} for
   *              each {@link Message} that is sent to it or {@link Runnable} that is posted to it.
   */
  public static Handler createHandler(Looper looper, boolean async) {
//              ^^^^^^^ reference semanticdb maven . . Handler#
//                      ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#createHandler().
//                                    display_name createHandler
//                                    signature_documentation java public static unresolved_type createHandler(unresolved_type looper, boolean async)
//                                    documentation  Create a Handler with the given Looper\n\n @param async If true the Handler will calls {@link Message#setAsynchronous(boolean)} for\n              each {@link Message} that is sent to it or {@link Runnable} that is posted to it.\n
//                                    ^^^^^^ reference semanticdb maven . . Looper#
//                                           ^^^^^^ definition local 0
//                                                  display_name looper
//                                                  signature_documentation java unresolved_type looper
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#createHandler().
//                                                           ^^^^^ definition local 1
//                                                                 display_name async
//                                                                 signature_documentation java boolean async
//                                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#createHandler().
    if (!async) {
//       ^^^^^ reference local 1
      return new Handler(looper);
//                       ^^^^^^ reference local 0
    }

    // Standard way of exposing async handler on older api's from the support library
    // https://android.googlesource.com/platform/frameworks/support/+/androidx-master-dev/core
    // /src/main/java/androidx/core/os/HandlerCompat.java#51
    if (Build.VERSION.SDK_INT >= 28) {
//      ^^^^^ reference semanticdb maven . . Build/
//            ^^^^^^^ reference semanticdb maven . . Build/VERSION#
//                    ^^^^^^^ reference semanticdb maven . . Build/VERSION#SDK_INT#
      return Handler.createAsync(looper);
//           ^^^^^^^ reference semanticdb maven . . Handler#
//                   ^^^^^^^^^^^ reference semanticdb maven . . Handler#createAsync#
//                               ^^^^^^ reference local 0
    }
    if (Build.VERSION.SDK_INT >= 16) {
//      ^^^^^ reference semanticdb maven . . Build/
//            ^^^^^^^ reference semanticdb maven . . Build/VERSION#
//                    ^^^^^^^ reference semanticdb maven . . Build/VERSION#SDK_INT#
      try {
        //noinspection JavaReflectionMemberAccess
        return Handler.class.getDeclaredConstructor(Looper.class, Callback.class, boolean.class)
//             ^^^^^^^ reference semanticdb maven . . Handler#
//                     ^^^^^ reference semanticdb maven . . Handler#class#
//                           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . Handler#class#getDeclaredConstructor#
//                                                  ^^^^^^ reference semanticdb maven . . Looper#
//                                                         ^^^^^ reference semanticdb maven . . Looper#class#
//                                                                ^^^^^^^^ reference semanticdb maven . . Callback#
//                                                                         ^^^^^ reference semanticdb maven . . Callback#class#
//                                                                                        ^^^^^ reference semanticdb maven . . boolean#class.
            .newInstance(looper, null, true);
//           ^^^^^^^^^^^ reference semanticdb maven . . `<any>`#newInstance#
//                       ^^^^^^ reference local 0
      } catch (Throwable ignored) {
//             ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Throwable#
//                       ^^^^^^^ definition local 2
//                               display_name ignored
//                               signature_documentation java Throwable ignored
//                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#createHandler().
      }
    }

    return new Handler(looper);
//                     ^^^^^^ reference local 0
  }

  /**
   * Create a new looper that runs on a new background thread.
   */
  public static Looper buildBackgroundLooper(String threadName) {
//              ^^^^^^ reference semanticdb maven . . Looper#
//                     ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#buildBackgroundLooper().
//                                           display_name buildBackgroundLooper
//                                           signature_documentation java public static unresolved_type buildBackgroundLooper(String threadName)
//                                           documentation  Create a new looper that runs on a new background thread.\n
//                                           ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                                  ^^^^^^^^^^ definition local 3
//                                                             display_name threadName
//                                                             signature_documentation java String threadName
//                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#buildBackgroundLooper().
    HandlerThread handlerThread = new HandlerThread(threadName);
//  ^^^^^^^^^^^^^ reference semanticdb maven . . HandlerThread#
//                ^^^^^^^^^^^^^ definition local 4
//                              display_name handlerThread
//                              signature_documentation java unresolved_type handlerThread
//                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#buildBackgroundLooper().
//                                                  ^^^^^^^^^^ reference local 3
    handlerThread.start();
//  ^^^^^^^^^^^^^ reference local 4
//                ^^^^^ reference semanticdb maven . . HandlerThread#start#
    return handlerThread.getLooper();
//         ^^^^^^^^^^^^^ reference local 4
//                       ^^^^^^^^^ reference semanticdb maven . . HandlerThread#getLooper#
  }
}
