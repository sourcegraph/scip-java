package com.airbnb.epoxy;

import android.os.Bundle;
//     ^^^^^^^ reference android/
//             ^^ reference android/os/
//                ^^^^^^ reference android/os/Bundle#
import android.os.Handler;
//     ^^^^^^^ reference android/
//             ^^ reference android/os/
//                ^^^^^^^ reference android/os/Handler#
import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#

import com.airbnb.epoxy.stickyheader.StickyHeaderCallbacks;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/
//                                   ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#

import org.jetbrains.annotations.NotNull;
//     ^^^ reference org/
//         ^^^^^^^^^ reference org/jetbrains/
//                   ^^^^^^^^^^^ reference org/jetbrains/annotations/
//                               ^^^^^^^ reference org/jetbrains/annotations/NotNull#

import java.lang.annotation.Retention;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^ reference java/lang/annotation/Retention#
import java.lang.annotation.RetentionPolicy;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
import java.util.ArrayList;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^ reference java/util/ArrayList#
import java.util.HashSet;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^ reference java/util/HashSet#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#
import java.util.ListIterator;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^^ reference java/util/ListIterator#
import java.util.Set;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^ reference java/util/Set#
import java.util.concurrent.CopyOnWriteArrayList;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^ reference java/util/concurrent/
//                          ^^^^^^^^^^^^^^^^^^^^ reference java/util/concurrent/CopyOnWriteArrayList#

import androidx.annotation.IntDef;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^ reference androidx/annotation/IntDef#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView#
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/GridLayoutManager/
//                                                    ^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/GridLayoutManager/SpanSizeLookup#

import static com.airbnb.epoxy.ControllerHelperLookup.getHelperForController;
//            ^^^ reference com/
//                ^^^^^^ reference com/airbnb/
//                       ^^^^^ reference com/airbnb/epoxy/
//                             ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerHelperLookup#

/**
 * A controller for easily combining {@link EpoxyModel} instances in a {@link RecyclerView.Adapter}.
 * Simply implement {@link #buildModels()} to declare which models should be used, and in which
 * order. Call {@link #requestModelBuild()} whenever your data changes, and the controller will call
 * {@link #buildModels()}, update the adapter with the new models, and notify any changes between
 * the new and old models.
 * <p>
 * The controller maintains a {@link androidx.recyclerview.widget.RecyclerView.Adapter} with the
 * latest models, which you can get via {@link #getAdapter()} to set on your RecyclerView.
 * <p>
 * All data change notifications are applied automatically via Epoxy's diffing algorithm. All of
 * your models must have a unique id set on them for diffing to work. You may choose to use {@link
 * AutoModel} annotations to have the controller create models with unique ids for you
 * automatically.
 * <p>
 * Once a model is created and added to the controller in {@link #buildModels()} it should be
 * treated as immutable and never modified again. This is necessary for adapter updates to be
 * accurate.
 */
public abstract class EpoxyController implements ModelCollector, StickyHeaderCallbacks {
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#
//                                               ^^^^^^^^^^^^^^ reference _root_/
//                                                               ^^^^^^^^^^^^^^^^^^^^^ reference _root_/

  /**
   * We check that the adapter is not connected to multiple recyclerviews, but when a fragment has
   * its view quickly destroyed and recreated it may temporarily attach the same adapter to the
   * previous view and the new view (eg because of fragment transitions) if the controller is reused
   * across views. We want to allow this case since it is a brief transient state. This should be
   * enough time for screen transitions to happen.
   */
  private static final int DELAY_TO_CHECK_ADAPTER_COUNT_MS = 3000;
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#DELAY_TO_CHECK_ADAPTER_COUNT_MS.
  private static final Timer NO_OP_TIMER = new NoOpTimer();
//                     ^^^^^ reference com/airbnb/epoxy/Timer#
//                           ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#NO_OP_TIMER.
//                                         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/NoOpTimer#`<init>`().
//                                             ^^^^^^^^^ reference com/airbnb/epoxy/NoOpTimer#

  public static Handler defaultModelBuildingHandler = MainThreadExecutor.INSTANCE.handler;
//              ^^^^^^^ reference _root_/
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#defaultModelBuildingHandler.
//                                                    ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#
//                                                                       ^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#INSTANCE.
//                                                                                ^^^^^^^ reference com/airbnb/epoxy/HandlerExecutor#handler.
  public static Handler defaultDiffingHandler = MainThreadExecutor.INSTANCE.handler;
//              ^^^^^^^ reference _root_/
//                      ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#defaultDiffingHandler.
//                                              ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#
//                                                                 ^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#INSTANCE.
//                                                                          ^^^^^^^ reference com/airbnb/epoxy/HandlerExecutor#handler.
  private static boolean filterDuplicatesDefault = false;
//                       ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#filterDuplicatesDefault.
  private static boolean globalDebugLoggingEnabled = false;
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#globalDebugLoggingEnabled.

  private final EpoxyControllerAdapter adapter;
//              ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#
//                                     ^^^^^^^ definition com/airbnb/epoxy/EpoxyController#adapter.
  private EpoxyDiffLogger debugObserver;
//        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyDiffLogger#
//                        ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#debugObserver.
  private int recyclerViewAttachCount = 0;
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#recyclerViewAttachCount.
  private final Handler modelBuildHandler;
//              ^^^^^^^ reference _root_/
//                      ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#modelBuildHandler.

  /**
   * This is iterated over in the build models thread, but items can be inserted or removed from
   * other threads at any time.
   */
  private final List<Interceptor> interceptors = new CopyOnWriteArrayList<>();
//              ^^^^ reference java/util/List#
//                   ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#Interceptor#
//                                ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#interceptors.
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/concurrent/CopyOnWriteArrayList#`<init>`().
//                                                   ^^^^^^^^^^^^^^^^^^^^ reference java/util/concurrent/CopyOnWriteArrayList#

  // Volatile because -> write only on main thread, read from builder thread
  private volatile boolean filterDuplicates = filterDuplicatesDefault;
//                         ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#filterDuplicates.
//                                            ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#filterDuplicatesDefault.
  /**
   * This is used to track whether we are currently building models. If it is non null it means
   * a thread is in the building models method. We store the thread so we can know which one
   * is building models.
   * <p>
   * Volatile because -> write only on handler, read from any thread
   */
  private volatile Thread threadBuildingModels = null;
//                 ^^^^^^ reference java/lang/Thread#
//                        ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#threadBuildingModels.
  /**
   * Used to know that we should build models synchronously the first time.
   * <p>
   * Volatile because -> written from the build models thread, read from the main thread.
   */
  private volatile boolean hasBuiltModelsEver;
//                         ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#hasBuiltModelsEver.

  //////////////////////////////////////////////////////////////////////////////////////////

  /*
   * These fields are expected to only be used on the model building thread so they are not
   * synchronized.
   */

  /** Used to time operations and log their duration when in debug mode. */
  private Timer timer = NO_OP_TIMER;
//        ^^^^^ reference com/airbnb/epoxy/Timer#
//              ^^^^^ definition com/airbnb/epoxy/EpoxyController#timer.
//                      ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#NO_OP_TIMER.
  private final ControllerHelper helper = getHelperForController(this);
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerHelper#
//                               ^^^^^^ definition com/airbnb/epoxy/EpoxyController#helper.
//                                        ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerHelperLookup#getHelperForController().
//                                                               ^^^^ reference com/airbnb/epoxy/EpoxyController#this.
  private ControllerModelList modelsBeingBuilt;
//        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerModelList#
//                            ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
  private List<ModelInterceptorCallback> modelInterceptorCallbacks;
//        ^^^^ reference java/util/List#
//             ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
  private EpoxyModel<?> stagedModel;
//        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                      ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#stagedModel.

  //////////////////////////////////////////////////////////////////////////////////////////

  public EpoxyController() {
//       ^^^^^^ definition com/airbnb/epoxy/EpoxyController#`<init>`().
    this(defaultModelBuildingHandler, defaultDiffingHandler);
//  ^^^^ reference com/airbnb/epoxy/EpoxyController#`<init>`(+1).
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#defaultModelBuildingHandler.
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#defaultDiffingHandler.
  }

  public EpoxyController(Handler modelBuildingHandler, Handler diffingHandler) {
//       ^^^^^^ definition com/airbnb/epoxy/EpoxyController#`<init>`(+1).
//                       ^^^^^^^ reference _root_/
//                               ^^^^^^^^^^^^^^^^^^^^ definition local0
//                                                     ^^^^^^^ reference _root_/
//                                                             ^^^^^^^^^^^^^^ definition local1
    adapter = new EpoxyControllerAdapter(this, diffingHandler);
//  ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#
//                                       ^^^^ reference com/airbnb/epoxy/EpoxyController#this.
//                                             ^^^^^^^^^^^^^^ reference local1
    modelBuildHandler = modelBuildingHandler;
//  ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelBuildHandler.
//                      ^^^^^^^^^^^^^^^^^^^^ reference local0
    setDebugLoggingEnabled(globalDebugLoggingEnabled);
//  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#setDebugLoggingEnabled().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#globalDebugLoggingEnabled.
  }

  /**
   * Posting and canceling runnables is a bit expensive - it is synchronizes and iterates the
   * list of runnables. We want clients to be able to request model builds as often as they want and
   * have it act as a no-op if one is already requested, without being a performance hit. To do that
   * we track whether we have a call to build models posted already so we can avoid canceling a
   * current call and posting it again.
   */
  @RequestedModelBuildType private volatile int requestedModelBuildType =
   ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                              ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
      RequestedModelBuildType.NONE;
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                            ^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NONE.

  @Retention(RetentionPolicy.SOURCE)
   ^^^^^^^^^ reference java/lang/annotation/Retention#
//           ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
//                           ^^^^^^ reference java/lang/annotation/RetentionPolicy#SOURCE.
  @IntDef({RequestedModelBuildType.NONE,
   ^^^^^^ reference androidx/annotation/IntDef#
//         ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                 ^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NONE.
      RequestedModelBuildType.NEXT_FRAME,
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NEXT_FRAME.
      RequestedModelBuildType.DELAYED})
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                            ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#DELAYED.
  private @interface RequestedModelBuildType {
//         ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
    int NONE = 0;
//      ^^^^ definition com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NONE.
    /** A request has been made to build models immediately. It is posted. */
    int NEXT_FRAME = 1;
//      ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NEXT_FRAME.
    /** A request has been made to build models after a delay. It is post delayed. */
    int DELAYED = 2;
//      ^^^^^^^ definition com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#DELAYED.
  }

  /**
   * Call this to request a model update. The controller will schedule a call to {@link
   * #buildModels()} so that models can be rebuilt for the current data. Once a build is requested
   * all subsequent requests are ignored until the model build runs. Therefore, the calling code
   * need not worry about calling this multiple times in a row.
   * <p>
   * The exception is that the first time this is called on a new instance of {@link
   * EpoxyController} it is run synchronously. This allows state to be restored and the initial view
   * to be draw quicker.
   * <p>
   * If you would like to be alerted when models have finished building use
   * {@link #addModelBuildListener(OnModelBuildFinishedListener)}
   */
  public void requestModelBuild() {
//            ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#requestModelBuild().
    if (isBuildingModels()) {
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#isBuildingModels().
      throw new IllegalEpoxyUsage("Cannot call `requestModelBuild` from inside `buildModels`");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#
    }

    // If it is the first time building models then we do it right away, otherwise we post the call.
    // We want to do it right away the first time so that scroll position can be restored correctly,
    // shared element transitions aren't delayed, and content is shown asap. We post later calls
    // so that they are debounced, and so any updates to data can be completely finished before
    // the models are built.
    if (hasBuiltModelsEver) {
//      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#hasBuiltModelsEver.
      requestDelayedModelBuild(0);
//    ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
    } else {
      buildModelsRunnable.run();
//    ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#buildModelsRunnable.
//                        ^^^ reference java/lang/Runnable#run().
    }
  }

  /**
   * Whether an update to models is currently pending. This can either be because
   * {@link #requestModelBuild()} was called, or because models are currently being built or diff
   * on a background thread.
   */
  public boolean hasPendingModelBuild() {
//               ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#hasPendingModelBuild().
    return requestedModelBuildType != RequestedModelBuildType.NONE // model build is posted
//         ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
//                                    ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                                            ^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NONE.
        || threadBuildingModels != null // model build is in progress
//         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#threadBuildingModels.
        || adapter.isDiffInProgress(); // Diff in progress
//         ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#isDiffInProgress().
  }

  /**
   * Add a listener that will be called every time {@link #buildModels()} has finished running
   * and changes have been dispatched to the RecyclerView.
   * <p>
   * Since buildModels can be called once for many calls to {@link #requestModelBuild()}, this is
   * called just once for each buildModels execution, not for every request.
   * <p>
   * Use this to react to changes in your models that need to happen after the RecyclerView has
   * been notified, such as scrolling.
   */
  public void addModelBuildListener(OnModelBuildFinishedListener listener) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#addModelBuildListener().
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                               ^^^^^^^^ definition local2
    adapter.addModelBuildListener(listener);
//  ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#addModelBuildListener().
//                                ^^^^^^^^ reference local2
  }

  /**
   * Remove a listener added with {@link #addModelBuildListener(OnModelBuildFinishedListener)}.
   * This is safe to call from inside the callback
   * {@link OnModelBuildFinishedListener#onModelBuildFinished(DiffResult)}
   */
  public void removeModelBuildListener(OnModelBuildFinishedListener listener) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#removeModelBuildListener().
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                                  ^^^^^^^^ definition local3
    adapter.removeModelBuildListener(listener);
//  ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#removeModelBuildListener().
//                                   ^^^^^^^^ reference local3
  }

  /**
   * Call this to request a delayed model update. The controller will schedule a call to {@link
   * #buildModels()} so that models can be rebuilt for the current data.
   * <p>
   * Using this to delay a model update may be helpful in cases where user input is causing many
   * rapid changes in the models, such as typing. In that case, the view is already updated on
   * screen and constantly rebuilding models is potentially slow and unnecessary. The downside to
   * delaying the model build too long is that models will not be in sync with the data or view, and
   * scrolling the view offscreen and back onscreen will cause the model to bind old data.
   * <p>
   * If a previous request is still pending it will be removed in favor of this new delay
   * <p>
   * Any call to {@link #requestModelBuild()} will override a delayed request.
   * <p>
   * In most cases you should use {@link #requestModelBuild()} instead of this.
   *
   * @param delayMs The time in milliseconds to delay the model build by. Should be greater than or
   *                equal to 0. A value of 0 is equivalent to calling {@link #requestModelBuild()}
   */
  public synchronized void requestDelayedModelBuild(int delayMs) {
//                         ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
//                                                      ^^^^^^^ definition local4
    if (isBuildingModels()) {
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#isBuildingModels().
      throw new IllegalEpoxyUsage(
//          ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`(). 1:77
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#
          "Cannot call `requestDelayedModelBuild` from inside `buildModels`");
    }

    if (requestedModelBuildType == RequestedModelBuildType.DELAYED) {
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
//                                 ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                                         ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#DELAYED.
      cancelPendingModelBuild();
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#cancelPendingModelBuild().
    } else if (requestedModelBuildType == RequestedModelBuildType.NEXT_FRAME) {
//             ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NEXT_FRAME.
      return;
    }

    requestedModelBuildType =
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
        delayMs == 0 ? RequestedModelBuildType.NEXT_FRAME : RequestedModelBuildType.DELAYED;
//      ^^^^^^^ reference local4
//                     ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NEXT_FRAME.
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                                                                  ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#DELAYED.

    modelBuildHandler.postDelayed(buildModelsRunnable, delayMs);
//  ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelBuildHandler.
//                    ^^^^^^^^^^^ reference postDelayed#
//                                ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#buildModelsRunnable.
//                                                     ^^^^^^^ reference local4
  }

  /**
   * Cancels a pending call to {@link #buildModels()} if one has been queued by {@link
   * #requestModelBuild()}.
   */
  public synchronized void cancelPendingModelBuild() {
//                         ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#cancelPendingModelBuild().
    // Access to requestedModelBuildType is synchronized because the model building thread clears
    // it when model building starts, and the main thread needs to set it to indicate a build
    // request.
    // Additionally, it is crucial to guarantee that the state of requestedModelBuildType is in sync
    // with the modelBuildHandler, otherwise we could end up in a state where we think a model build
    // is queued, but it isn't, and model building never happens - stuck forever.
    if (requestedModelBuildType != RequestedModelBuildType.NONE) {
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
//                                 ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                                         ^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NONE.
      requestedModelBuildType = RequestedModelBuildType.NONE;
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
//                              ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                                      ^^^^ reference com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NONE.
      modelBuildHandler.removeCallbacks(buildModelsRunnable);
//    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelBuildHandler.
//                      ^^^^^^^^^^^^^^^ reference removeCallbacks#
//                                      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#buildModelsRunnable.
    }
  }

  private final Runnable buildModelsRunnable = new Runnable() {
//              ^^^^^^^^ reference java/lang/Runnable#
//                       ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#buildModelsRunnable.
//                                             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#buildModelsRunnable.``#`<init>`(). 49:3
//                                                 ^^^^^^^^ reference java/lang/Runnable#
//                                                 ^^^^^^^^ reference java/lang/Runnable#
//                                                            ^ definition com/airbnb/epoxy/EpoxyController#buildModelsRunnable.``#`<init>`(). 1:4
    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void run() {
//              ^^^ definition com/airbnb/epoxy/EpoxyController#buildModelsRunnable.``#run().
      // Do this first to mark the controller as being in the model building process.
      threadBuildingModels = Thread.currentThread();
//    ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#threadBuildingModels.
//                           ^^^^^^ reference java/lang/Thread#
//                                  ^^^^^^^^^^^^^ reference java/lang/Thread#currentThread().

      // This is needed to reset the requestedModelBuildType back to NONE.
      // As soon as we do this another model build can be posted.
      cancelPendingModelBuild();
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#cancelPendingModelBuild().

      helper.resetAutoModels();
//    ^^^^^^ reference com/airbnb/epoxy/EpoxyController#helper.
//           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerHelper#resetAutoModels().

      modelsBeingBuilt = new ControllerModelList(getExpectedModelCount());
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerModelList#`<init>`().
//                           ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerModelList#
//                                               ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#getExpectedModelCount().

      timer.start("Models built");
//    ^^^^^ reference com/airbnb/epoxy/EpoxyController#timer.
//          ^^^^^ reference com/airbnb/epoxy/Timer#start().

      // The user's implementation of buildModels is wrapped in a try/catch so that if it fails
      // we can reset the state of this controller. This is useful when model building is done
      // on a dedicated thread, which may have its own error handler, and a failure may not
      // crash the app - in which case this controller would be in an invalid state and crash later
      // with confusing errors because "threadBuildingModels" and other properties are not
      // correctly set. This can happen particularly with Espresso testing.
      try {
        buildModels();
//      ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#buildModels().
      } catch (Throwable throwable) {
//             ^^^^^^^^^ reference java/lang/Throwable#
//                       ^^^^^^^^^ definition local5
        timer.stop();
//      ^^^^^ reference com/airbnb/epoxy/EpoxyController#timer.
//            ^^^^ reference com/airbnb/epoxy/Timer#stop().
        modelsBeingBuilt = null;
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
        hasBuiltModelsEver = true;
//      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#hasBuiltModelsEver.
        threadBuildingModels = null;
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#threadBuildingModels.
        stagedModel = null;
//      ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#stagedModel.
        throw throwable;
//            ^^^^^^^^^ reference local5
      }

      addCurrentlyStagedModelIfExists();
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#addCurrentlyStagedModelIfExists().
      timer.stop();
//    ^^^^^ reference com/airbnb/epoxy/EpoxyController#timer.
//          ^^^^ reference com/airbnb/epoxy/Timer#stop().

      runInterceptors();
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#runInterceptors().
      filterDuplicatesIfNeeded(modelsBeingBuilt);
//    ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#filterDuplicatesIfNeeded().
//                             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
      modelsBeingBuilt.freeze();
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                     ^^^^^^ reference com/airbnb/epoxy/ControllerModelList#freeze().

      timer.start("Models diffed");
//    ^^^^^ reference com/airbnb/epoxy/EpoxyController#timer.
//          ^^^^^ reference com/airbnb/epoxy/Timer#start().
      adapter.setModels(modelsBeingBuilt);
//    ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//            ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#setModels().
//                      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
      // This timing is only right if diffing and model building are on the same thread
      timer.stop();
//    ^^^^^ reference com/airbnb/epoxy/EpoxyController#timer.
//          ^^^^ reference com/airbnb/epoxy/Timer#stop().

      modelsBeingBuilt = null;
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
      hasBuiltModelsEver = true;
//    ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#hasBuiltModelsEver.
      threadBuildingModels = null;
//    ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#threadBuildingModels.
    }
  };

  /** An estimate for how many models will be built in the next {@link #buildModels()} phase. */
  private int getExpectedModelCount() {
//            ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#getExpectedModelCount().
    int currentModelCount = adapter.getItemCount();
//      ^^^^^^^^^^^^^^^^^ definition local6
//                          ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//                                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getItemCount().
    return currentModelCount != 0 ? currentModelCount : 25;
//         ^^^^^^^^^^^^^^^^^ reference local6
//                                  ^^^^^^^^^^^^^^^^^ reference local6
  }

  /**
   * Subclasses should implement this to describe what models should be shown for the current state.
   * Implementations should call either {@link #add(EpoxyModel)}, {@link
   * EpoxyModel#addTo(EpoxyController)}, or {@link EpoxyModel#addIf(boolean, EpoxyController)} with
   * the models that should be shown, in the order that is desired.
   * <p>
   * Once a model is added to the controller it should be treated as immutable and never modified
   * again. This is necessary for adapter updates to be accurate. If "validateEpoxyModelUsage" is
   * enabled then runtime validations will be done to make sure models are not changed.
   * <p>
   * You CANNOT call this method directly. Instead, call {@link #requestModelBuild()} to have the
   * controller schedule an update.
   */
  protected abstract void buildModels();
//                        ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#buildModels().

  int getFirstIndexOfModelInBuildingList(EpoxyModel<?> model) {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#getFirstIndexOfModelInBuildingList().
//                                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                     ^^^^^ definition local7
    assertIsBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#assertIsBuildingModels().

    int size = modelsBeingBuilt.size();
//      ^^^^ definition local8
//             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                              ^^^^ reference java/util/ArrayList#size(+1).
    for (int i = 0; i < size; i++) {
//           ^ definition local9
//                  ^ reference local9
//                      ^^^^ reference local8
//                            ^ reference local9
      if (modelsBeingBuilt.get(i) == model) {
//        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                         ^^^ reference java/util/ArrayList#get().
//                             ^ reference local9
//                                   ^^^^^ reference local7
        return i;
//             ^ reference local9
      }
    }

    return -1;
  }

  boolean isModelAddedMultipleTimes(EpoxyModel<?> model) {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#isModelAddedMultipleTimes().
//                                  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                ^^^^^ definition local10
    assertIsBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#assertIsBuildingModels().

    int modelCount = 0;
//      ^^^^^^^^^^ definition local11
    int size = modelsBeingBuilt.size();
//      ^^^^ definition local12
//             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                              ^^^^ reference java/util/ArrayList#size(+1).
    for (int i = 0; i < size; i++) {
//           ^ definition local13
//                  ^ reference local13
//                      ^^^^ reference local12
//                            ^ reference local13
      if (modelsBeingBuilt.get(i) == model) {
//        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                         ^^^ reference java/util/ArrayList#get().
//                             ^ reference local13
//                                   ^^^^^ reference local10
        modelCount++;
//      ^^^^^^^^^^ reference local11
      }
    }

    return modelCount > 1;
//         ^^^^^^^^^^ reference local11
  }

  void addAfterInterceptorCallback(ModelInterceptorCallback callback) {
//     ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#addAfterInterceptorCallback().
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#
//                                                          ^^^^^^^^ definition local14
    assertIsBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#assertIsBuildingModels().

    if (modelInterceptorCallbacks == null) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
      modelInterceptorCallbacks = new ArrayList<>();
//    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
//                                ^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`(+1).
//                                    ^^^^^^^^^ reference java/util/ArrayList#
    }

    modelInterceptorCallbacks.add(callback);
//  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
//                            ^^^ reference java/util/List#add().
//                                ^^^^^^^^ reference local14
  }

  /**
   * Callbacks to each model for when interceptors are started and stopped, so the models know when
   * to allow changes.
   */
  interface ModelInterceptorCallback {
  ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#
    void onInterceptorsStarted(EpoxyController controller);
//       ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#onInterceptorsStarted().
//                             ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                             ^^^^^^^^^^ definition local15
    void onInterceptorsFinished(EpoxyController controller);
//       ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#onInterceptorsFinished().
//                              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                              ^^^^^^^^^^ definition local16
  }

  private void runInterceptors() {
//             ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#runInterceptors().
    if (!interceptors.isEmpty()) {
//       ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#interceptors.
//                    ^^^^^^^ reference java/util/List#isEmpty().
      if (modelInterceptorCallbacks != null) {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
        for (ModelInterceptorCallback callback : modelInterceptorCallbacks) {
//           ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#
//                                    ^^^^^^^^ definition local17
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
          callback.onInterceptorsStarted(this);
//        ^^^^^^^^ reference local17
//                 ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#onInterceptorsStarted().
//                                       ^^^^ reference com/airbnb/epoxy/EpoxyController#this.
        }
      }

      timer.start("Interceptors executed");
//    ^^^^^ reference com/airbnb/epoxy/EpoxyController#timer.
//          ^^^^^ reference com/airbnb/epoxy/Timer#start().

      for (Interceptor interceptor : interceptors) {
//         ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#Interceptor#
//                     ^^^^^^^^^^^ definition local18
//                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#interceptors.
        interceptor.intercept(modelsBeingBuilt);
//      ^^^^^^^^^^^ reference local18
//                  ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#Interceptor#intercept().
//                            ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
      }

      timer.stop();
//    ^^^^^ reference com/airbnb/epoxy/EpoxyController#timer.
//          ^^^^ reference com/airbnb/epoxy/Timer#stop().

      if (modelInterceptorCallbacks != null) {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
        for (ModelInterceptorCallback callback : modelInterceptorCallbacks) {
//           ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#
//                                    ^^^^^^^^ definition local19
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
          callback.onInterceptorsFinished(this);
//        ^^^^^^^^ reference local19
//                 ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#onInterceptorsFinished().
//                                        ^^^^ reference com/airbnb/epoxy/EpoxyController#this.
        }
      }
    }

    // Interceptors are cleared so that future model builds don't notify past models.
    // We need to make sure they are cleared even if there are no interceptors so that
    // we don't leak the models.
    modelInterceptorCallbacks = null;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
  }

  /** A callback that is run after {@link #buildModels()} completes and before diffing is run. */
  public interface Interceptor {
//       ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#Interceptor#
    /**
     * This is called immediately after {@link #buildModels()} and before diffing is run and the
     * models are set on the adapter. This is a final chance to make any changes to the the models
     * added in {@link #buildModels()}. This may be useful for actions that act on all models in
     * aggregate, such as toggling divider settings, or for cases such as rearranging models for an
     * experiment.
     * <p>
     * The models list must not be changed after this method returns. Doing so will throw an
     * exception.
     */
    void intercept(@NonNull List<EpoxyModel<?>> models);
//       ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#Interceptor#intercept().
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^^^^ reference java/util/List#
//                               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^^ definition local20
  }

  /**
   * Add an interceptor callback to be run after models are built, to make any last changes before
   * they are set on the adapter. Interceptors are run in the order they are added.
   * <p>
   * Interceptors are run on the same thread that models are built on.
   *
   * @see Interceptor#intercept(List)
   */
  public void addInterceptor(@NonNull Interceptor interceptor) {
//            ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#addInterceptor().
//                            ^^^^^^^ reference androidx/annotation/NonNull#
//                                    ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#Interceptor#
//                                                ^^^^^^^^^^^ definition local21
    interceptors.add(interceptor);
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#interceptors.
//               ^^^ reference java/util/List#add().
//                   ^^^^^^^^^^^ reference local21
  }

  /** Remove an interceptor that was added with {@link #addInterceptor(Interceptor)}. */
  public void removeInterceptor(@NonNull Interceptor interceptor) {
//            ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#removeInterceptor().
//                               ^^^^^^^ reference androidx/annotation/NonNull#
//                                       ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#Interceptor#
//                                                   ^^^^^^^^^^^ definition local22
    interceptors.remove(interceptor);
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#interceptors.
//               ^^^^^^ reference java/util/List#remove().
//                      ^^^^^^^^^^^ reference local22
  }

  /**
   * Get the number of models added so far during the {@link #buildModels()} phase. It is only valid
   * to call this from within that method.
   * <p>
   * This is different from the number of models currently on the adapter, since models on the
   * adapter are not updated until after models are finished being built. To access current adapter
   * count call {@link #getAdapter()} and {@link EpoxyControllerAdapter#getItemCount()}
   */
  protected int getModelCountBuiltSoFar() {
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#getModelCountBuiltSoFar().
    assertIsBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#assertIsBuildingModels().
    return modelsBeingBuilt.size();
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                          ^^^^ reference java/util/ArrayList#size(+1).
  }

  private void assertIsBuildingModels() {
//             ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#assertIsBuildingModels().
    if (!isBuildingModels()) {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#isBuildingModels().
      throw new IllegalEpoxyUsage("Can only call this when inside the `buildModels` method");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#
    }
  }

  private void assertNotBuildingModels() {
//             ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#assertNotBuildingModels().
    if (isBuildingModels()) {
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#isBuildingModels().
      throw new IllegalEpoxyUsage("Cannot call this from inside `buildModels`");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#
    }
  }

  /**
   * Add the model to this controller. Can only be called from inside {@link
   * EpoxyController#buildModels()}.
   */
  public void add(@NonNull EpoxyModel<?> model) {
//            ^^^ definition com/airbnb/epoxy/EpoxyController#add().
//                 ^^^^^^^ reference androidx/annotation/NonNull#
//                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^ definition local23
    model.addTo(this);
//  ^^^^^ reference local23
//        ^^^^^ reference com/airbnb/epoxy/EpoxyModel#addTo().
//              ^^^^ reference com/airbnb/epoxy/EpoxyController#this.
  }

  /**
   * Add the models to this controller. Can only be called from inside {@link
   * EpoxyController#buildModels()}.
   */
  protected void add(@NonNull EpoxyModel<?>... modelsToAdd) {
//               ^^^ definition com/airbnb/epoxy/EpoxyController#add(+1).
//                    ^^^^^^^ reference androidx/annotation/NonNull#
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^^^^^^^ definition local24
    modelsBeingBuilt.ensureCapacity(modelsBeingBuilt.size() + modelsToAdd.length);
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                   ^^^^^^^^^^^^^^ reference java/util/ArrayList#ensureCapacity().
//                                  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                                                   ^^^^ reference java/util/ArrayList#size(+1).
//                                                            ^^^^^^^^^^^ reference local24
//                                                                        ^^^^^^ reference length.

    for (EpoxyModel<?> model : modelsToAdd) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local25
//                             ^^^^^^^^^^^ reference local24
      add(model);
//    ^^^ reference com/airbnb/epoxy/EpoxyController#add().
//        ^^^^^ reference local25
    }
  }

  /**
   * Add the models to this controller. Can only be called from inside {@link
   * EpoxyController#buildModels()}.
   */
  protected void add(@NonNull List<? extends EpoxyModel<?>> modelsToAdd) {
//               ^^^ definition com/airbnb/epoxy/EpoxyController#add(+2).
//                    ^^^^^^^ reference androidx/annotation/NonNull#
//                            ^^^^ reference java/util/List#
//                                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                          ^^^^^^^^^^^ definition local26
    modelsBeingBuilt.ensureCapacity(modelsBeingBuilt.size() + modelsToAdd.size());
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                   ^^^^^^^^^^^^^^ reference java/util/ArrayList#ensureCapacity().
//                                  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                                                   ^^^^ reference java/util/ArrayList#size(+1).
//                                                            ^^^^^^^^^^^ reference local26
//                                                                        ^^^^ reference java/util/List#size().

    for (EpoxyModel<?> model : modelsToAdd) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local27
//                             ^^^^^^^^^^^ reference local26
      add(model);
//    ^^^ reference com/airbnb/epoxy/EpoxyController#add().
//        ^^^^^ reference local27
    }
  }

  /**
   * Method to actually add the model to the list being built. Should be called after all
   * validations are done.
   */
  void addInternal(EpoxyModel<?> modelToAdd) {
//     ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#addInternal().
//                 ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                               ^^^^^^^^^^ definition local28
    assertIsBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#assertIsBuildingModels().

    if (modelToAdd.hasDefaultId()) {
//      ^^^^^^^^^^ reference local28
//                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#hasDefaultId(+1).
      throw new IllegalEpoxyUsage(
//          ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`(). 2:68
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#
          "You must set an id on a model before adding it. Use the @AutoModel annotation if you "
              + "want an id to be automatically generated for you.");
    }

    if (!modelToAdd.isShown()) {
//       ^^^^^^^^^^ reference local28
//                  ^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#isShown().
      throw new IllegalEpoxyUsage(
//          ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`(). 2:33
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#
          "You cannot hide a model in an EpoxyController. Use `addIf` to conditionally add a "
              + "model instead.");
    }

    // The model being added may not have been staged if it wasn't mutated before it was added.
    // In that case we may have a previously staged model that still needs to be added.
    clearModelFromStaging(modelToAdd);
//  ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#clearModelFromStaging().
//                        ^^^^^^^^^^ reference local28
    modelToAdd.controllerToStageTo = null;
//  ^^^^^^^^^^ reference local28
//             ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#controllerToStageTo.
    modelsBeingBuilt.add(modelToAdd);
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                   ^^^ reference com/airbnb/epoxy/ModelList#add().
//                       ^^^^^^^^^^ reference local28
  }

  /**
   * Staging models allows them to be implicitly added after the user finishes modifying them. This
   * means that if a user has modified a model, and then moves on to modifying a different model,
   * the first model is automatically added as soon as the second model is modified.
   * <p>
   * There are some edge cases for handling models that are added without modification, or models
   * that are modified but then fail an `addIf` check.
   * <p>
   * This only works for AutoModels, and only if implicitly adding is enabled in configuration.
   */
  void setStagedModel(EpoxyModel<?> model) {
//     ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#setStagedModel().
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^ definition local29
    if (model != stagedModel) {
//      ^^^^^ reference local29
//               ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#stagedModel.
      addCurrentlyStagedModelIfExists();
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#addCurrentlyStagedModelIfExists().
    }

    stagedModel = model;
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#stagedModel.
//                ^^^^^ reference local29
  }

  void addCurrentlyStagedModelIfExists() {
//     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#addCurrentlyStagedModelIfExists().
    if (stagedModel != null) {
//      ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#stagedModel.
      stagedModel.addTo(this);
//    ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#stagedModel.
//                ^^^^^ reference com/airbnb/epoxy/EpoxyModel#addTo().
//                      ^^^^ reference com/airbnb/epoxy/EpoxyController#this.
    }
    stagedModel = null;
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#stagedModel.
  }

  void clearModelFromStaging(EpoxyModel<?> model) {
//     ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#clearModelFromStaging().
//                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                         ^^^^^ definition local30
    if (stagedModel != model) {
//      ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#stagedModel.
//                     ^^^^^ reference local30
      addCurrentlyStagedModelIfExists();
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#addCurrentlyStagedModelIfExists().
    }
    stagedModel = null;
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#stagedModel.
  }

  /** True if the current callstack originated from the buildModels call, on the same thread. */
  protected boolean isBuildingModels() {
//                  ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#isBuildingModels().
    return threadBuildingModels == Thread.currentThread();
//         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#threadBuildingModels.
//                                 ^^^^^^ reference java/lang/Thread#
//                                        ^^^^^^^^^^^^^ reference java/lang/Thread#currentThread().
  }

  private void filterDuplicatesIfNeeded(List<EpoxyModel<?>> models) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#filterDuplicatesIfNeeded().
//                                      ^^^^ reference java/util/List#
//                                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                          ^^^^^^ definition local31
    if (!filterDuplicates) {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#filterDuplicates.
      return;
    }

    timer.start("Duplicates filtered");
//  ^^^^^ reference com/airbnb/epoxy/EpoxyController#timer.
//        ^^^^^ reference com/airbnb/epoxy/Timer#start().
    Set<Long> modelIds = new HashSet<>(models.size());
//  ^^^ reference java/util/Set#
//      ^^^^ reference java/lang/Long#
//            ^^^^^^^^ definition local32
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/HashSet#`<init>`(+3).
//                           ^^^^^^^ reference java/util/HashSet#
//                                     ^^^^^^ reference local31
//                                            ^^^^ reference java/util/List#size().

    ListIterator<EpoxyModel<?>> modelIterator = models.listIterator();
//  ^^^^^^^^^^^^ reference java/util/ListIterator#
//               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                              ^^^^^^^^^^^^^ definition local33
//                                              ^^^^^^ reference local31
//                                                     ^^^^^^^^^^^^ reference java/util/List#listIterator().
    while (modelIterator.hasNext()) {
//         ^^^^^^^^^^^^^ reference local33
//                       ^^^^^^^ reference java/util/ListIterator#hasNext().
      EpoxyModel<?> model = modelIterator.next();
//    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^ definition local34
//                          ^^^^^^^^^^^^^ reference local33
//                                        ^^^^ reference java/util/ListIterator#next().
      if (!modelIds.add(model.id())) {
//         ^^^^^^^^ reference local32
//                  ^^^ reference java/util/Set#add().
//                      ^^^^^ reference local34
//                            ^^ reference com/airbnb/epoxy/EpoxyModel#id(+1).
        int indexOfDuplicate = modelIterator.previousIndex();
//          ^^^^^^^^^^^^^^^^ definition local35
//                             ^^^^^^^^^^^^^ reference local33
//                                           ^^^^^^^^^^^^^ reference java/util/ListIterator#previousIndex().
        modelIterator.remove();
//      ^^^^^^^^^^^^^ reference local33
//                    ^^^^^^ reference java/util/ListIterator#remove().

        int indexOfOriginal = findPositionOfDuplicate(models, model);
//          ^^^^^^^^^^^^^^^ definition local36
//                            ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#findPositionOfDuplicate().
//                                                    ^^^^^^ reference local31
//                                                            ^^^^^ reference local34
        EpoxyModel<?> originalModel = models.get(indexOfOriginal);
//      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                    ^^^^^^^^^^^^^ definition local37
//                                    ^^^^^^ reference local31
//                                           ^^^ reference java/util/List#get().
//                                               ^^^^^^^^^^^^^^^ reference local36
        if (indexOfDuplicate <= indexOfOriginal) {
//          ^^^^^^^^^^^^^^^^ reference local35
//                              ^^^^^^^^^^^^^^^ reference local36
          // Adjust for the original positions of the models before the duplicate was removed
          indexOfOriginal++;
//        ^^^^^^^^^^^^^^^ reference local36
        }

        onExceptionSwallowed(
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onExceptionSwallowed().
            new IllegalEpoxyUsage("Two models have the same ID. ID's must be unique!"
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`(). 2:81
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/IllegalEpoxyUsage#
                + "\nOriginal has position " + indexOfOriginal + ":\n" + originalModel
//                                             ^^^^^^^^^^^^^^^ reference local36
//                                                                       ^^^^^^^^^^^^^ reference local37
                + "\nDuplicate has position " + indexOfDuplicate + ":\n" + model)
//                                              ^^^^^^^^^^^^^^^^ reference local35
//                                                                         ^^^^^ reference local34
        );
      }
    }

    timer.stop();
//  ^^^^^ reference com/airbnb/epoxy/EpoxyController#timer.
//        ^^^^ reference com/airbnb/epoxy/Timer#stop().
  }

  private int findPositionOfDuplicate(List<EpoxyModel<?>> models, EpoxyModel<?> duplicateModel) {
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#findPositionOfDuplicate().
//                                    ^^^^ reference java/util/List#
//                                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                        ^^^^^^ definition local38
//                                                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                              ^^^^^^^^^^^^^^ definition local39
    int size = models.size();
//      ^^^^ definition local40
//             ^^^^^^ reference local38
//                    ^^^^ reference java/util/List#size().
    for (int i = 0; i < size; i++) {
//           ^ definition local41
//                  ^ reference local41
//                      ^^^^ reference local40
//                            ^ reference local41
      EpoxyModel<?> model = models.get(i);
//    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^ definition local42
//                          ^^^^^^ reference local38
//                                 ^^^ reference java/util/List#get().
//                                     ^ reference local41
      if (model.id() == duplicateModel.id()) {
//        ^^^^^ reference local42
//              ^^ reference com/airbnb/epoxy/EpoxyModel#id(+1).
//                      ^^^^^^^^^^^^^^ reference local39
//                                     ^^ reference com/airbnb/epoxy/EpoxyModel#id(+1).
        return i;
//             ^ reference local41
      }
    }

    throw new IllegalArgumentException("No duplicates in list");
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#`<init>`(+1).
//            ^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#
  }

  /**
   * If set to true, Epoxy will search for models with duplicate ids added during {@link
   * #buildModels()} and remove any duplicates found. If models with the same id are found, the
   * first one is left in the adapter and any subsequent models are removed. {@link
   * #onExceptionSwallowed(RuntimeException)} will be called for each duplicate removed.
   * <p>
   * This may be useful if your models are created via server supplied data, in which case the
   * server may erroneously send duplicate items. Duplicate items are otherwise left in and can
   * result in undefined behavior.
   */
  public void setFilterDuplicates(boolean filterDuplicates) {
//            ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#setFilterDuplicates().
//                                        ^^^^^^^^^^^^^^^^ definition local43
    this.filterDuplicates = filterDuplicates;
//  ^^^^ reference com/airbnb/epoxy/EpoxyController#this.
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#filterDuplicates.
//                          ^^^^^^^^^^^^^^^^ reference local43
  }

  public boolean isDuplicateFilteringEnabled() {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#isDuplicateFilteringEnabled().
    return filterDuplicates;
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#filterDuplicates.
  }

  /**
   * {@link #setFilterDuplicates(boolean)} is disabled in each EpoxyController by default. It can be
   * toggled individually in each controller, or alternatively you can use this to change the
   * default value for all EpoxyControllers.
   */
  public static void setGlobalDuplicateFilteringDefault(boolean filterDuplicatesByDefault) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#setGlobalDuplicateFilteringDefault().
//                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition local44
    EpoxyController.filterDuplicatesDefault = filterDuplicatesByDefault;
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#filterDuplicatesDefault.
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local44
  }

  /**
   * If enabled, DEBUG logcat messages will be printed to show when models are rebuilt, the time
   * taken to build them, the time taken to diff them, and the item change outcomes from the
   * differ. The tag of the logcat message is the class name of your EpoxyController.
   * <p>
   * This is useful to verify that models are being diffed as expected, as well as to watch for
   * slowdowns in model building or diffing to indicate when you should optimize model building or
   * model hashCode/equals implementations (which can often slow down diffing).
   * <p>
   * This should only be used in debug builds to avoid a performance hit in prod.
   */
  public void setDebugLoggingEnabled(boolean enabled) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#setDebugLoggingEnabled().
//                                           ^^^^^^^ definition local45
    assertNotBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#assertNotBuildingModels().

    if (enabled) {
//      ^^^^^^^ reference local45
      timer = new DebugTimer(getClass().getSimpleName());
//    ^^^^^ reference com/airbnb/epoxy/EpoxyController#timer.
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DebugTimer#`<init>`().
//                ^^^^^^^^^^ reference com/airbnb/epoxy/DebugTimer#
//                           ^^^^^^^^ reference java/lang/Object#getClass().
//                                      ^^^^^^^^^^^^^ reference java/lang/Class#getSimpleName().
      if (debugObserver == null) {
//        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#debugObserver.
        debugObserver = new EpoxyDiffLogger(getClass().getSimpleName());
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#debugObserver.
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyDiffLogger#`<init>`().
//                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyDiffLogger#
//                                          ^^^^^^^^ reference java/lang/Object#getClass().
//                                                     ^^^^^^^^^^^^^ reference java/lang/Class#getSimpleName().
      }
      adapter.registerAdapterDataObserver(debugObserver);
//    ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#registerAdapterDataObserver#
//                                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#debugObserver.
    } else {
      timer = NO_OP_TIMER;
//    ^^^^^ reference com/airbnb/epoxy/EpoxyController#timer.
//            ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#NO_OP_TIMER.
      if (debugObserver != null) {
//        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#debugObserver.
        adapter.unregisterAdapterDataObserver(debugObserver);
//      ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#unregisterAdapterDataObserver#
//                                            ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#debugObserver.
      }
    }
  }

  public boolean isDebugLoggingEnabled() {
//               ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#isDebugLoggingEnabled().
    return timer != NO_OP_TIMER;
//         ^^^^^ reference com/airbnb/epoxy/EpoxyController#timer.
//                  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#NO_OP_TIMER.
  }

  /**
   * Similar to {@link #setDebugLoggingEnabled(boolean)}, but this changes the global default for
   * all EpoxyControllers.
   * <p>
   * The default is false.
   */
  public static void setGlobalDebugLoggingEnabled(boolean globalDebugLoggingEnabled) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#setGlobalDebugLoggingEnabled().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ definition local46
    EpoxyController.globalDebugLoggingEnabled = globalDebugLoggingEnabled;
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#globalDebugLoggingEnabled.
//                                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local46
  }

  /**
   * An optimized way to move a model from one position to another without rebuilding all models.
   * This is intended to be used with {@link androidx.recyclerview.widget.ItemTouchHelper} to
   * allow for efficient item dragging and rearranging. It cannot be
   * <p>
   * If you call this you MUST also update the data backing your models as necessary.
   * <p>
   * This will immediately change the model's position and notify the change to the RecyclerView.
   * However, a delayed request to rebuild models will be scheduled for the future to guarantee that
   * models are in sync with data.
   *
   * @param fromPosition Previous position of the item.
   * @param toPosition   New position of the item.
   */
  public void moveModel(int fromPosition, int toPosition) {
//            ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#moveModel().
//                          ^^^^^^^^^^^^ definition local47
//                                            ^^^^^^^^^^ definition local48
    assertNotBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#assertNotBuildingModels().

    adapter.moveModel(fromPosition, toPosition);
//  ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#moveModel().
//                    ^^^^^^^^^^^^ reference local47
//                                  ^^^^^^^^^^ reference local48

    requestDelayedModelBuild(500);
//  ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
  }


  /**
   * An way to notify the adapter that a model has changed. This is intended to be used with
   * {@link androidx.recyclerview.widget.ItemTouchHelper} to allow revert swiping a model.
   * <p>
   * This will immediately notify the change to the RecyclerView.
   *
   * @param position Position of the item.
   */
  public void notifyModelChanged(int position) {
//            ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#notifyModelChanged().
//                                   ^^^^^^^^ definition local49
    assertNotBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#assertNotBuildingModels().

    adapter.notifyModelChanged(position);
//  ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#notifyModelChanged().
//                             ^^^^^^^^ reference local49
  }


  /**
   * Get the underlying adapter built by this controller. Use this to get the adapter to set on a
   * RecyclerView, or to get information about models currently in use.
   */
  @NonNull
   ^^^^^^^ reference androidx/annotation/NonNull#
  public EpoxyControllerAdapter getAdapter() {
//       ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#
//                              ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#getAdapter().
    return adapter;
//         ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
  }

  public void onSaveInstanceState(@NonNull Bundle outState) {
//            ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#onSaveInstanceState().
//                                 ^^^^^^^ reference androidx/annotation/NonNull#
//                                         ^^^^^^ reference _root_/
//                                                ^^^^^^^^ definition local50
    adapter.onSaveInstanceState(outState);
//  ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onSaveInstanceState().
//                              ^^^^^^^^ reference local50
  }

  public void onRestoreInstanceState(@Nullable Bundle inState) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#onRestoreInstanceState().
//                                    ^^^^^^^^ reference androidx/annotation/Nullable#
//                                             ^^^^^^ reference _root_/
//                                                    ^^^^^^^ definition local51
    adapter.onRestoreInstanceState(inState);
//  ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onRestoreInstanceState().
//                                 ^^^^^^^ reference local51
  }

  /**
   * For use with a grid layout manager - use this to get the {@link SpanSizeLookup} for models in
   * this controller. This will delegate span look up calls to each model's {@link
   * EpoxyModel#getSpanSize(int, int, int)}. Make sure to also call {@link #setSpanCount(int)} so
   * the span count is correct.
   */
  @NonNull
   ^^^^^^^ reference androidx/annotation/NonNull#
  public SpanSizeLookup getSpanSizeLookup() {
//       ^^^^^^^^^^^^^^ reference _root_/
//                      ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#getSpanSizeLookup().
    return adapter.getSpanSizeLookup();
//         ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//                 ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getSpanSizeLookup().
  }

  /**
   * If you are using a grid layout manager you must call this to set the span count of the grid.
   * This span count will be passed on to the models so models can choose which span count to be.
   *
   * @see #getSpanSizeLookup()
   * @see EpoxyModel#getSpanSize(int, int, int)
   */
  public void setSpanCount(int spanCount) {
//            ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#setSpanCount().
//                             ^^^^^^^^^ definition local52
    adapter.setSpanCount(spanCount);
//  ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#setSpanCount().
//                       ^^^^^^^^^ reference local52
  }

  public int getSpanCount() {
//           ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#getSpanCount().
    return adapter.getSpanCount();
//         ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getSpanCount().
  }

  public boolean isMultiSpan() {
//               ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#isMultiSpan().
    return adapter.isMultiSpan();
//         ^^^^^^^ reference com/airbnb/epoxy/EpoxyController#adapter.
//                 ^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#isMultiSpan().
  }

  /**
   * This is called when recoverable exceptions occur at runtime. By default they are ignored and
   * Epoxy will recover, but you can override this to be aware of when they happen.
   * <p>
   * A common use for this is being aware of duplicates when {@link #setFilterDuplicates(boolean)}
   * is enabled.
   * <p>
   * By default the global exception handler provided by
   * {@link #setGlobalExceptionHandler(ExceptionHandler)}
   * is called with the exception. Overriding this allows you to provide your own handling for a
   * controller.
   */
  protected void onExceptionSwallowed(@NonNull RuntimeException exception) {
//               ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#onExceptionSwallowed().
//                                     ^^^^^^^ reference androidx/annotation/NonNull#
//                                             ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
//                                                              ^^^^^^^^^ definition local53
    globalExceptionHandler.onException(this, exception);
//  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#globalExceptionHandler.
//                         ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#ExceptionHandler#onException().
//                                     ^^^^ reference com/airbnb/epoxy/EpoxyController#this.
//                                           ^^^^^^^^^ reference local53
  }

  /**
   * Default handler for exceptions in all EpoxyControllers. Set with {@link
   * #setGlobalExceptionHandler(ExceptionHandler)}
   */
  private static ExceptionHandler globalExceptionHandler =
//               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#ExceptionHandler#
//                                ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#globalExceptionHandler.
      new ExceptionHandler() {
//    ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#globalExceptionHandler.``#`<init>`(). 7:7
//        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#ExceptionHandler#
//        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#ExceptionHandler#
//                           ^ definition com/airbnb/epoxy/EpoxyController#globalExceptionHandler.``#`<init>`(). 2:3

        @Override
//       ^^^^^^^^ reference java/lang/Override#
        public void onException(@NonNull EpoxyController controller,
//                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#globalExceptionHandler.``#onException().
//                               ^^^^^^^ reference androidx/annotation/NonNull#
//                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                                       ^^^^^^^^^^ definition local54
            @NonNull RuntimeException exception) {
//           ^^^^^^^ reference androidx/annotation/NonNull#
//                   ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
//                                    ^^^^^^^^^ definition local55
          // Ignore exceptions as the default
        }
      };

  /**
   * Set a callback to be notified when a recoverable exception occurs at runtime.  By default these
   * are ignored and Epoxy will recover, but you can override this to be aware of when they happen.
   * <p>
   * For example, you could choose to rethrow the exception in development builds, or log them in
   * production.
   * <p>
   * A common use for this is being aware of duplicates when {@link #setFilterDuplicates(boolean)}
   * is enabled.
   * <p>
   * This callback will be used in all EpoxyController classes. If you would like specific handling
   * in a certain controller you can override {@link #onExceptionSwallowed(RuntimeException)} in
   * that controller.
   */
  public static void setGlobalExceptionHandler(
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#setGlobalExceptionHandler().
      @NonNull ExceptionHandler globalExceptionHandler) {
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#ExceptionHandler#
//                              ^^^^^^^^^^^^^^^^^^^^^^ definition local56
    EpoxyController.globalExceptionHandler = globalExceptionHandler;
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#globalExceptionHandler.
//                                           ^^^^^^^^^^^^^^^^^^^^^^ reference local56
  }

  public interface ExceptionHandler {
//       ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#ExceptionHandler#
    /**
     * This is called when recoverable exceptions happen at runtime. They can be ignored and Epoxy
     * will recover, but you can override this to be aware of when they happen.
     * <p>
     * For example, you could choose to rethrow the exception in development builds, or log them in
     * production.
     *
     * @param controller The EpoxyController that the error occurred in.
     */
    void onException(@NonNull EpoxyController controller, @NonNull RuntimeException exception);
//       ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#ExceptionHandler#onException().
//                    ^^^^^^^ reference androidx/annotation/NonNull#
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                            ^^^^^^^^^^ definition local57
//                                                         ^^^^^^^ reference androidx/annotation/NonNull#
//                                                                 ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
//                                                                                  ^^^^^^^^^ definition local58
  }

  void onAttachedToRecyclerViewInternal(RecyclerView recyclerView) {
//     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#onAttachedToRecyclerViewInternal().
//                                      ^^^^^^^^^^^^ reference _root_/
//                                                   ^^^^^^^^^^^^ definition local59
    recyclerViewAttachCount++;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#recyclerViewAttachCount.

    if (recyclerViewAttachCount > 1) {
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#recyclerViewAttachCount.
      MainThreadExecutor.INSTANCE.handler.postDelayed(new Runnable() {
//    ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#
//                       ^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#INSTANCE.
//                                ^^^^^^^ reference com/airbnb/epoxy/HandlerExecutor#handler.
//                                        ^^^^^^^^^^^ reference postDelayed#
//                                                    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onAttachedToRecyclerViewInternal().``#`<init>`(). 19:7
//                                                        ^^^^^^^^ reference java/lang/Runnable#
//                                                        ^^^^^^^^ reference java/lang/Runnable#
//                                                                   ^ definition com/airbnb/epoxy/EpoxyController#onAttachedToRecyclerViewInternal().``#`<init>`(). 1:4
        @Override
//       ^^^^^^^^ reference java/lang/Override#
        public void run() {
//                  ^^^ definition com/airbnb/epoxy/EpoxyController#onAttachedToRecyclerViewInternal().``#run().
          // Only warn if there are still multiple adapters attached after a delay, to allow for
          // a grace period
          if (recyclerViewAttachCount > 1) {
//            ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#recyclerViewAttachCount.
            onExceptionSwallowed(new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onExceptionSwallowed().
//                               ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 10:91
//                                   ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
                "This EpoxyController had its adapter added to more than one ReyclerView. Epoxy "
                    + "does not support attaching an adapter to multiple RecyclerViews because "
                    + "saved state will not work properly. If you did not intend to attach your "
                    + "adapter "
                    + "to multiple RecyclerViews you may be leaking a "
                    + "reference to a previous RecyclerView. Make sure to remove the adapter from "
                    + "any "
                    + "previous RecyclerViews (eg if the adapter is reused in a Fragment across "
                    + "multiple onCreateView/onDestroyView cycles). See https://github"
                    + ".com/airbnb/epoxy/wiki/Avoiding-Memory-Leaks for more information."));
          }
        }
      }, DELAY_TO_CHECK_ADAPTER_COUNT_MS);
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#DELAY_TO_CHECK_ADAPTER_COUNT_MS.
    }

    onAttachedToRecyclerView(recyclerView);
//  ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onAttachedToRecyclerView().
//                           ^^^^^^^^^^^^ reference local59
  }

  void onDetachedFromRecyclerViewInternal(RecyclerView recyclerView) {
//     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#onDetachedFromRecyclerViewInternal().
//                                        ^^^^^^^^^^^^ reference _root_/
//                                                     ^^^^^^^^^^^^ definition local60
    recyclerViewAttachCount--;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#recyclerViewAttachCount.
    onDetachedFromRecyclerView(recyclerView);
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onDetachedFromRecyclerView().
//                             ^^^^^^^^^^^^ reference local60
  }

  /** Called when the controller's adapter is attach to a recyclerview. */
  protected void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
//               ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#onAttachedToRecyclerView().
//                                         ^^^^^^^ reference androidx/annotation/NonNull#
//                                                 ^^^^^^^^^^^^ reference _root_/
//                                                              ^^^^^^^^^^^^ definition local61

  }

  /** Called when the controller's adapter is detached from a recyclerview. */
  protected void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#onDetachedFromRecyclerView().
//                                           ^^^^^^^ reference androidx/annotation/NonNull#
//                                                   ^^^^^^^^^^^^ reference _root_/
//                                                                ^^^^^^^^^^^^ definition local62

  }

  /**
   * Called immediately after a model is bound to a view holder. Subclasses can override this if
   * they want alerts on when a model is bound. Alternatively you may attach a listener directly to
   * a generated model with model.onBind(...)
   *
   * @param previouslyBoundModel If non null, this is a model with the same id as the newly bound
   *                             model, and was previously bound to a view. This means that {@link
   *                             #buildModels()} returned a model that is different from the
   *                             previouslyBoundModel and the view is being rebound to incorporate
   *                             the change. You can compare this previous model with the new one to
   *                             see exactly what changed.
   *                             <p>
   *                             The newly bound model and the previously bound model are guaranteed
   *                             to have the same id, but will not necessarily be of the same type
   *                             depending on your implementation of {@link #buildModels()}. With
   *                             common usage patterns of Epoxy they should be the same type, and
   *                             will only differ if you are using different model classes with the
   *                             same id.
   *                             <p>
   *                             Comparing the newly bound model with the previous model allows you
   *                             to be more intelligent when updating your view. This may help you
   *                             optimize, or make it easier to work with animations.
   *                             <p>
   *                             If the new model and the previous model have the same view type
   *                             (given by {@link EpoxyModel#getViewType()}), and if you are using
   *                             the default ReyclerView item animator, the same view will be kept.
   *                             If you are using a custom item animator then the view will be the
   *                             same if the animator returns true in canReuseUpdatedViewHolder.
   *                             <p>
   *                             This previously bound model is taken as a payload from the diffing
   *                             process, and follows the same general conditions for all
   *                             recyclerview change payloads.
   */
  protected void onModelBound(@NonNull EpoxyViewHolder holder, @NonNull EpoxyModel<?> boundModel,
//               ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#onModelBound().
//                             ^^^^^^^ reference androidx/annotation/NonNull#
//                                     ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^ definition local63
//                                                              ^^^^^^^ reference androidx/annotation/NonNull#
//                                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                    ^^^^^^^^^^ definition local64
      int position,
//        ^^^^^^^^ definition local65
      @Nullable EpoxyModel<?> previouslyBoundModel) {
//     ^^^^^^^^ reference androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^^^^^^^^^^^^^^ definition local66
  }

  /**
   * Called immediately after a model is unbound from a view holder. Subclasses can override this if
   * they want alerts on when a model is unbound. Alternatively you may attach a listener directly
   * to a generated model with model.onUnbind(...)
   */
  protected void onModelUnbound(@NonNull EpoxyViewHolder holder, @NonNull EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#onModelUnbound().
//                               ^^^^^^^ reference androidx/annotation/NonNull#
//                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                       ^^^^^^ definition local67
//                                                                ^^^^^^^ reference androidx/annotation/NonNull#
//                                                                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                      ^^^^^ definition local68

  }

  /**
   * Called when the given viewholder is attached to the window, along with the model it is bound
   * to.
   *
   * @see BaseEpoxyAdapter#onViewAttachedToWindow(EpoxyViewHolder)
   */
  protected void onViewAttachedToWindow(@NonNull EpoxyViewHolder holder,
//               ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#onViewAttachedToWindow().
//                                       ^^^^^^^ reference androidx/annotation/NonNull#
//                                               ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                               ^^^^^^ definition local69
      @NonNull EpoxyModel<?> model) {
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^ definition local70

  }

  /**
   * Called when the given viewholder is detechaed from the window, along with the model it is bound
   * to.
   *
   * @see BaseEpoxyAdapter#onViewDetachedFromWindow(EpoxyViewHolder)
   */
  protected void onViewDetachedFromWindow(@NonNull EpoxyViewHolder holder,
//               ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#onViewDetachedFromWindow().
//                                         ^^^^^^^ reference androidx/annotation/NonNull#
//                                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                 ^^^^^^ definition local71
      @NonNull EpoxyModel<?> model) {
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^ definition local72

  }

  //region Sticky header

  /**
   * Optional callback to setup the sticky view,
   * by default it doesn't do anything.
   *
   * The sub-classes should override the function if they are
   * using sticky header feature.
   */
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void setupStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#setupStickyHeaderView().
//                                   ^^^^^^^ reference org/jetbrains/annotations/NotNull#
//                                           ^^^^ reference _root_/
//                                                ^^^^^^^^^^^^ definition local73
    // no-op
  }

  /**
   * Optional callback to perform tear down operation on the
   * sticky view, by default it doesn't do anything.
   *
   * The sub-classes should override the function if they are
   * using sticky header feature.
   */
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void teardownStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#teardownStickyHeaderView().
//                                      ^^^^^^^ reference org/jetbrains/annotations/NotNull#
//                                              ^^^^ reference _root_/
//                                                   ^^^^^^^^^^^^ definition local74
    // no-op
  }

  /**
   * Called to check if the item at the position is a sticky item,
   * by default returns false.
   *
   * The sub-classes should override the function if they are
   * using sticky header feature.
   */
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public boolean isStickyHeader(int position) {
//               ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyController#isStickyHeader().
//                                  ^^^^^^^^ definition local75
    return false;
  }

  //endregion
}
