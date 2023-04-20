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
//                                documentation ```java\npublic final class EpoxyAsyncUtil\n```
//                                documentation  Various helpers for running Epoxy operations off the main thread.\n
  private EpoxyAsyncUtil() {
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#`<init>`().
//                       documentation ```java\nprivate EpoxyAsyncUtil()\n```
  }

  /**
   * A Handler class that uses the main thread's Looper.
   */
  public static final Handler MAIN_THREAD_HANDLER =
//                    ^^^^^^^ reference semanticdb maven . . _root_/
//                            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#MAIN_THREAD_HANDLER.
//                                                documentation ```java\npublic static final unresolved_type MAIN_THREAD_HANDLER\n```
//                                                documentation  A Handler class that uses the main thread's Looper.\n
      createHandler(Looper.getMainLooper(), false);
//    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#createHandler().
//                  ^^^^^^ reference semanticdb maven . . _root_/
//                         ^^^^^^^^^^^^^ reference semanticdb maven . . getMainLooper#

  /**
   * A Handler class that uses the main thread's Looper. Additionally, this handler calls
   * {@link Message#setAsynchronous(boolean)} for
   * each {@link Message} that is sent to it or {@link Runnable} that is posted to it
   */
  public static final Handler AYSNC_MAIN_THREAD_HANDLER =
//                    ^^^^^^^ reference semanticdb maven . . _root_/
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#AYSNC_MAIN_THREAD_HANDLER.
//                                                      documentation ```java\npublic static final unresolved_type AYSNC_MAIN_THREAD_HANDLER\n```
//                                                      documentation  A Handler class that uses the main thread's Looper. Additionally, this handler calls\n {@link Message#setAsynchronous(boolean)} for\n each {@link Message} that is sent to it or {@link Runnable} that is posted to it\n
      createHandler(Looper.getMainLooper(), true);
//    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#createHandler().
//                  ^^^^^^ reference semanticdb maven . . _root_/
//                         ^^^^^^^^^^^^^ reference semanticdb maven . . getMainLooper#

  private static Handler asyncBackgroundHandler;
//               ^^^^^^^ reference semanticdb maven . . _root_/
//                       ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#asyncBackgroundHandler.
//                                              documentation ```java\nprivate static unresolved_type asyncBackgroundHandler\n```

  /**
   * A Handler class that uses a separate background thread dedicated to Epoxy. Additionally,
   * this handler calls {@link Message#setAsynchronous(boolean)} for
   * each {@link Message} that is sent to it or {@link Runnable} that is posted to it
   */
  @MainThread
// ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/MainThread#
  public static Handler getAsyncBackgroundHandler() {
//              ^^^^^^^ reference semanticdb maven . . _root_/
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#getAsyncBackgroundHandler().
//                                                documentation ```java\n@MainThread\npublic static unresolved_type getAsyncBackgroundHandler()\n```
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
//              ^^^^^^^ reference semanticdb maven . . _root_/
//                      ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#createHandler().
//                                    documentation ```java\npublic static unresolved_type createHandler(unresolved_type looper, boolean async)\n```
//                                    documentation  Create a Handler with the given Looper\n\n @param async If true the Handler will calls {@link Message#setAsynchronous(boolean)} for\n              each {@link Message} that is sent to it or {@link Runnable} that is posted to it.\n
//                                    ^^^^^^ reference semanticdb maven . . _root_/
//                                           ^^^^^^ definition local 0
//                                                  documentation ```java\nunresolved_type looper\n```
//                                                           ^^^^^ definition local 1
//                                                                 documentation ```java\nboolean async\n```
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
//           ^^^^^^^ reference semanticdb maven . . _root_/
//                   ^^^^^^^^^^^ reference semanticdb maven . . createAsync#
//                               ^^^^^^ reference local 0
    }
    if (Build.VERSION.SDK_INT >= 16) {
//      ^^^^^ reference semanticdb maven . . Build/
//            ^^^^^^^ reference semanticdb maven . . Build/VERSION#
//                    ^^^^^^^ reference semanticdb maven . . Build/VERSION#SDK_INT#
      try {
        //noinspection JavaReflectionMemberAccess
        return Handler.class.getDeclaredConstructor(Looper.class, Callback.class, boolean.class)
//             ^^^^^^^ reference semanticdb maven . . _root_/
//                     ^^^^^ reference semanticdb maven . . class#
//                           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . class#getDeclaredConstructor#
//                                                  ^^^^^^ reference semanticdb maven . . _root_/
//                                                         ^^^^^ reference semanticdb maven . . class#
//                                                                ^^^^^^^^ reference semanticdb maven . . _root_/
//                                                                         ^^^^^ reference semanticdb maven . . class#
//                                                                                        ^^^^^ reference semanticdb maven . . boolean#class.
            .newInstance(looper, null, true);
//           ^^^^^^^^^^^ reference semanticdb maven . . `<any>`#newInstance#
//                       ^^^^^^ reference local 0
      } catch (Throwable ignored) {
//             ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Throwable#
//                       ^^^^^^^ definition local 2
//                               documentation ```java\nThrowable ignored\n```
      }
    }

    return new Handler(looper);
//                     ^^^^^^ reference local 0
  }

  /**
   * Create a new looper that runs on a new background thread.
   */
  public static Looper buildBackgroundLooper(String threadName) {
//              ^^^^^^ reference semanticdb maven . . _root_/
//                     ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#buildBackgroundLooper().
//                                           documentation ```java\npublic static unresolved_type buildBackgroundLooper(String threadName)\n```
//                                           documentation  Create a new looper that runs on a new background thread.\n
//                                           ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                                  ^^^^^^^^^^ definition local 3
//                                                             documentation ```java\nString threadName\n```
    HandlerThread handlerThread = new HandlerThread(threadName);
//  ^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                ^^^^^^^^^^^^^ definition local 4
//                              documentation ```java\nunresolved_type handlerThread\n```
//                                                  ^^^^^^^^^^ reference local 3
    handlerThread.start();
//  ^^^^^^^^^^^^^ reference local 4
//                ^^^^^ reference semanticdb maven . . start#
    return handlerThread.getLooper();
//         ^^^^^^^^^^^^^ reference local 4
//                       ^^^^^^^^^ reference semanticdb maven . . getLooper#
  }
}
