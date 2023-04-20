package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^ reference semanticdb maven . . android/os/Handler#
import android.os.Looper;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^ reference semanticdb maven . . android/os/Looper#

import java.util.concurrent.Executor;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven . . java/util/concurrent/
//                          ^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/Executor#

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#

/**
 * An executor that does it's work via posting to a Handler.
 * <p>
 * A key feature of this is the runnable is executed synchronously if the current thread is the
 * same as the handler's thread.
 */
class HandlerExecutor implements Executor {
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#
//                    documentation ```java\nclass HandlerExecutor\n```
//                    documentation  An executor that does it's work via posting to a Handler.\n <p>\n A key feature of this is the runnable is executed synchronously if the current thread is the\n same as the handler's thread.\n
//                    relationship is_implementation semanticdb maven jdk 11 java/util/concurrent/Executor#
//                               ^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/Executor#
  final Handler handler;
//      ^^^^^^^ reference semanticdb maven . . _root_/
//              ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#handler.
//                      documentation ```java\nfinal unresolved_type handler\n```

  HandlerExecutor(Handler handler) {
//^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#`<init>`().
//                documentation ```java\nHandlerExecutor(unresolved_type handler)\n```
//                ^^^^^^^ reference semanticdb maven . . _root_/
//                        ^^^^^^^ definition local 0
//                                documentation ```java\nunresolved_type handler\n```
    this.handler = handler;
//       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#handler.
//                 ^^^^^^^ reference local 0
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void execute(@NonNull Runnable command) {
//            ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#execute().
//                    documentation ```java\n@Override\npublic void execute(Runnable command)\n```
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/util/concurrent/Executor#execute().
//                     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Runnable#
//                                      ^^^^^^^ definition local 1
//                                              documentation ```java\n@NonNull\nRunnable command\n```
    // If we're already on the same thread then we can execute this synchronously
    if (Looper.myLooper() == handler.getLooper()) {
//      ^^^^^^ reference semanticdb maven . . _root_/
//             ^^^^^^^^ reference semanticdb maven . . myLooper#
//                           ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#handler.
//                                   ^^^^^^^^^ reference semanticdb maven . . getLooper#
      command.run();
//    ^^^^^^^ reference local 1
//            ^^^ reference semanticdb maven jdk 11 java/lang/Runnable#run().
    } else {
      handler.post(command);
//    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#handler.
//            ^^^^ reference semanticdb maven . . post#
//                 ^^^^^^^ reference local 1
    }
  }
}
