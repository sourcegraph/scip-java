package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference android/
//             ^^ reference android/os/
//                ^^^^^^^ reference android/os/Handler#
import android.os.Looper;
//     ^^^^^^^ reference android/
//             ^^ reference android/os/
//                ^^^^^^ reference android/os/Looper#

import java.util.concurrent.Executor;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^ reference java/util/concurrent/
//                          ^^^^^^^^ reference java/util/concurrent/Executor#

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#

/**
 * An executor that does it's work via posting to a Handler.
 * <p>
 * A key feature of this is the runnable is executed synchronously if the current thread is the
 * same as the handler's thread.
 */
class HandlerExecutor implements Executor {
//    ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HandlerExecutor# class HandlerExecutor extends Executor
//                               ^^^^^^^^ reference java/util/concurrent/Executor#
  final Handler handler;
//      ^^^^^^^ reference _root_/
//              ^^^^^^^ definition com/airbnb/epoxy/HandlerExecutor#handler. final unresolved_type handler

  HandlerExecutor(Handler handler) {
//^^^^^^ definition com/airbnb/epoxy/HandlerExecutor#`<init>`(). void <init>(unresolved_type handler)
//                ^^^^^^^ reference _root_/
//                        ^^^^^^^ definition local0 unresolved_type handler
    this.handler = handler;
//  ^^^^ reference com/airbnb/epoxy/HandlerExecutor#
//       ^^^^^^^ reference com/airbnb/epoxy/HandlerExecutor#handler.
//                 ^^^^^^^ reference local0
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void execute(@NonNull Runnable command) {
//            ^^^^^^^ definition com/airbnb/epoxy/HandlerExecutor#execute(). public void execute(Runnable command)
//                     ^^^^^^^ reference androidx/annotation/NonNull#
//                             ^^^^^^^^ reference java/lang/Runnable#
//                                      ^^^^^^^ definition local1 Runnable command
    // If we're already on the same thread then we can execute this synchronously
    if (Looper.myLooper() == handler.getLooper()) {
//      ^^^^^^ reference _root_/
//             ^^^^^^^^ reference myLooper#
//                           ^^^^^^^ reference com/airbnb/epoxy/HandlerExecutor#handler.
//                                   ^^^^^^^^^ reference getLooper#
      command.run();
//    ^^^^^^^ reference local1
//            ^^^ reference java/lang/Runnable#run().
    } else {
      handler.post(command);
//    ^^^^^^^ reference com/airbnb/epoxy/HandlerExecutor#handler.
//            ^^^^ reference post#
//                 ^^^^^^^ reference local1
    }
  }
}
