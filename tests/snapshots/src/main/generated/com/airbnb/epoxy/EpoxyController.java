package com.airbnb.epoxy;

import android.os.Bundle;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^ reference semanticdb maven . . android/os/Bundle#
import android.os.Handler;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^ reference semanticdb maven . . android/os/Handler#
import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

import com.airbnb.epoxy.stickyheader.StickyHeaderCallbacks;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/
//                                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#

import org.jetbrains.annotations.NotNull;
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/annotations/
//                               ^^^^^^^ reference semanticdb maven maven/org.jetbrains/annotations 13.0 org/jetbrains/annotations/NotNull#

import java.lang.annotation.Retention;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                          ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Retention#
import java.lang.annotation.RetentionPolicy;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/RetentionPolicy#
import java.util.ArrayList;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
import java.util.HashSet;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#
import java.util.ListIterator;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
import java.util.Set;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^ reference semanticdb maven jdk 11 java/util/Set#
import java.util.concurrent.CopyOnWriteArrayList;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven . . java/util/concurrent/
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/CopyOnWriteArrayList#

import androidx.annotation.IntDef;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntDef#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView#
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/GridLayoutManager/
//                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/GridLayoutManager/SpanSizeLookup#

import static com.airbnb.epoxy.ControllerHelperLookup.getHelperForController;
//            ^^^ reference semanticdb maven . . com/
//                ^^^^^^ reference semanticdb maven . . com/airbnb/
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                             ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#

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
//                    ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                    documentation ```java\npublic abstract class EpoxyController\n```
//                                    documentation  A controller for easily combining {@link EpoxyModel} instances in a {@link RecyclerView.Adapter}.\n Simply implement {@link #buildModels()} to declare which models should be used, and in which\n order. Call {@link #requestModelBuild()} whenever your data changes, and the controller will call\n {@link #buildModels()}, update the adapter with the new models, and notify any changes between\n the new and old models.\n <p>\n The controller maintains a {@link androidx.recyclerview.widget.RecyclerView.Adapter} with the\n latest models, which you can get via {@link #getAdapter()} to set on your RecyclerView.\n <p>\n All data change notifications are applied automatically via Epoxy's diffing algorithm. All of\n your models must have a unique id set on them for diffing to work. You may choose to use {@link\n AutoModel} annotations to have the controller create models with unique ids for you\n automatically.\n <p>\n Once a model is created and added to the controller in {@link #buildModels()} it should be\n treated as immutable and never modified again. This is necessary for adapter updates to be\n accurate.\n
//                                    relationship is_implementation semanticdb maven . . ``/ModelCollector#
//                                    relationship is_implementation semanticdb maven . . ``/StickyHeaderCallbacks#
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                               ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/

  /**
   * We check that the adapter is not connected to multiple recyclerviews, but when a fragment has
   * its view quickly destroyed and recreated it may temporarily attach the same adapter to the
   * previous view and the new view (eg because of fragment transitions) if the controller is reused
   * across views. We want to allow this case since it is a brief transient state. This should be
   * enough time for screen transitions to happen.
   */
  private static final int DELAY_TO_CHECK_ADAPTER_COUNT_MS = 3000;
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#DELAY_TO_CHECK_ADAPTER_COUNT_MS.
//                                                         documentation ```java\nprivate static final int DELAY_TO_CHECK_ADAPTER_COUNT_MS\n```
//                                                         documentation  We check that the adapter is not connected to multiple recyclerviews, but when a fragment has\n its view quickly destroyed and recreated it may temporarily attach the same adapter to the\n previous view and the new view (eg because of fragment transitions) if the controller is reused\n across views. We want to allow this case since it is a brief transient state. This should be\n enough time for screen transitions to happen.\n
  private static final Timer NO_OP_TIMER = new NoOpTimer();
//                     ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#
//                           ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#NO_OP_TIMER.
//                                       documentation ```java\nprivate static final Timer NO_OP_TIMER\n```
//                                             ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NoOpTimer#`<init>`().

  public static Handler defaultModelBuildingHandler = MainThreadExecutor.INSTANCE.handler;
//              ^^^^^^^ reference semanticdb maven . . _root_/
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#defaultModelBuildingHandler.
//                                                  documentation ```java\npublic static unresolved_type defaultModelBuildingHandler\n```
//                                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#
//                                                                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#INSTANCE.
//                                                                                ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#handler.
  public static Handler defaultDiffingHandler = MainThreadExecutor.INSTANCE.handler;
//              ^^^^^^^ reference semanticdb maven . . _root_/
//                      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#defaultDiffingHandler.
//                                            documentation ```java\npublic static unresolved_type defaultDiffingHandler\n```
//                                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#
//                                                                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#INSTANCE.
//                                                                          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#handler.
  private static boolean filterDuplicatesDefault = false;
//                       ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#filterDuplicatesDefault.
//                                               documentation ```java\nprivate static boolean filterDuplicatesDefault\n```
  private static boolean globalDebugLoggingEnabled = false;
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#globalDebugLoggingEnabled.
//                                                 documentation ```java\nprivate static boolean globalDebugLoggingEnabled\n```

  private final EpoxyControllerAdapter adapter;
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#
//                                     ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//                                             documentation ```java\nprivate final EpoxyControllerAdapter adapter\n```
  private EpoxyDiffLogger debugObserver;
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#
//                        ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#debugObserver.
//                                      documentation ```java\nprivate EpoxyDiffLogger debugObserver\n```
  private int recyclerViewAttachCount = 0;
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#recyclerViewAttachCount.
//                                    documentation ```java\nprivate int recyclerViewAttachCount\n```
  private final Handler modelBuildHandler;
//              ^^^^^^^ reference semanticdb maven . . _root_/
//                      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelBuildHandler.
//                                        documentation ```java\nprivate final unresolved_type modelBuildHandler\n```

  /**
   * This is iterated over in the build models thread, but items can be inserted or removed from
   * other threads at any time.
   */
  private final List<Interceptor> interceptors = new CopyOnWriteArrayList<>();
//              ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                   ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#Interceptor#
//                                ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#interceptors.
//                                             documentation ```java\nprivate final List<Interceptor> interceptors\n```
//                                             documentation  This is iterated over in the build models thread, but items can be inserted or removed from\n other threads at any time.\n
//                                                   ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/CopyOnWriteArrayList#`<init>`().

  // Volatile because -> write only on main thread, read from builder thread
  private volatile boolean filterDuplicates = filterDuplicatesDefault;
//                         ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#filterDuplicates.
//                                          documentation ```java\nprivate boolean filterDuplicates\n```
//                                            ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#filterDuplicatesDefault.
  /**
   * This is used to track whether we are currently building models. If it is non null it means
   * a thread is in the building models method. We store the thread so we can know which one
   * is building models.
   * <p>
   * Volatile because -> write only on handler, read from any thread
   */
  private volatile Thread threadBuildingModels = null;
//                 ^^^^^^ reference semanticdb maven jdk 11 java/lang/Thread#
//                        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#threadBuildingModels.
//                                             documentation ```java\nprivate Thread threadBuildingModels\n```
//                                             documentation  This is used to track whether we are currently building models. If it is non null it means\n a thread is in the building models method. We store the thread so we can know which one\n is building models.\n <p>\n Volatile because -> write only on handler, read from any thread\n
  /**
   * Used to know that we should build models synchronously the first time.
   * <p>
   * Volatile because -> written from the build models thread, read from the main thread.
   */
  private volatile boolean hasBuiltModelsEver;
//                         ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#hasBuiltModelsEver.
//                                            documentation ```java\nprivate boolean hasBuiltModelsEver\n```
//                                            documentation  Used to know that we should build models synchronously the first time.\n <p>\n Volatile because -> written from the build models thread, read from the main thread.\n

  //////////////////////////////////////////////////////////////////////////////////////////

  /*
   * These fields are expected to only be used on the model building thread so they are not
   * synchronized.
   */

  /** Used to time operations and log their duration when in debug mode. */
  private Timer timer = NO_OP_TIMER;
//        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//                    documentation ```java\nprivate Timer timer\n```
//                    documentation Used to time operations and log their duration when in debug mode. 
//                      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#NO_OP_TIMER.
  private final ControllerHelper helper = getHelperForController(this);
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelper#
//                               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#helper.
//                                      documentation ```java\nprivate final ControllerHelper helper\n```
//                                        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#getHelperForController().
  private ControllerModelList modelsBeingBuilt;
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerModelList#
//                            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                                             documentation ```java\nprivate ControllerModelList modelsBeingBuilt\n```
  private List<ModelInterceptorCallback> modelInterceptorCallbacks;
//        ^^^^ reference semanticdb maven jdk 11 java/util/List#
//             ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
//                                                                 documentation ```java\nprivate List<ModelInterceptorCallback> modelInterceptorCallbacks\n```
  private EpoxyModel<?> stagedModel;
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#stagedModel.
//                                  documentation ```java\nprivate EpoxyModel<?> stagedModel\n```

  //////////////////////////////////////////////////////////////////////////////////////////

  public EpoxyController() {
//       ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#`<init>`().
//                       documentation ```java\npublic EpoxyController()\n```
    this(defaultModelBuildingHandler, defaultDiffingHandler);
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#`<init>`(+1).
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#defaultModelBuildingHandler.
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#defaultDiffingHandler.
  }

  public EpoxyController(Handler modelBuildingHandler, Handler diffingHandler) {
//       ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#`<init>`(+1).
//                       documentation ```java\npublic EpoxyController(unresolved_type modelBuildingHandler, unresolved_type diffingHandler)\n```
//                       ^^^^^^^ reference semanticdb maven . . _root_/
//                               ^^^^^^^^^^^^^^^^^^^^ definition local 0
//                                                    documentation ```java\nunresolved_type modelBuildingHandler\n```
//                                                     ^^^^^^^ reference semanticdb maven . . _root_/
//                                                             ^^^^^^^^^^^^^^ definition local 1
//                                                                            documentation ```java\nunresolved_type diffingHandler\n```
    adapter = new EpoxyControllerAdapter(this, diffingHandler);
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#`<init>`().
//                                             ^^^^^^^^^^^^^^ reference local 1
    modelBuildHandler = modelBuildingHandler;
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelBuildHandler.
//                      ^^^^^^^^^^^^^^^^^^^^ reference local 0
    setDebugLoggingEnabled(globalDebugLoggingEnabled);
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#setDebugLoggingEnabled().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#globalDebugLoggingEnabled.
  }

  /**
   * Posting and canceling runnables is a bit expensive - it is synchronizes and iterates the
   * list of runnables. We want clients to be able to request model builds as often as they want and
   * have it act as a no-op if one is already requested, without being a performance hit. To do that
   * we track whether we have a call to build models posted already so we can avoid canceling a
   * current call and posting it again.
   */
  @RequestedModelBuildType private volatile int requestedModelBuildType =
// ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                              ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
//                                                                      documentation ```java\n@RequestedModelBuildType\nprivate int requestedModelBuildType\n```
//                                                                      documentation  Posting and canceling runnables is a bit expensive - it is synchronizes and iterates the\n list of runnables. We want clients to be able to request model builds as often as they want and\n have it act as a no-op if one is already requested, without being a performance hit. To do that\n we track whether we have a call to build models posted already so we can avoid canceling a\n current call and posting it again.\n
      RequestedModelBuildType.NONE;
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                            ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NONE.

  @Retention(RetentionPolicy.SOURCE)
// ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Retention#
//           ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/RetentionPolicy#
//                           ^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/RetentionPolicy#SOURCE.
  @IntDef({RequestedModelBuildType.NONE,
// ^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntDef#
//         ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NONE.
      RequestedModelBuildType.NEXT_FRAME,
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NEXT_FRAME.
      RequestedModelBuildType.DELAYED})
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                            ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#DELAYED.
  private @interface RequestedModelBuildType {
//                   ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                           documentation ```java\n@Retention(RetentionPolicy.SOURCE)\n@IntDef({RequestedModelBuildType.NONE, RequestedModelBuildType.NEXT_FRAME, RequestedModelBuildType.DELAYED})\nprivate @interface RequestedModelBuildType\n```
//                                           relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
    int NONE = 0;
//      ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NONE.
//           documentation ```java\npublic static final int NONE\n```
    /** A request has been made to build models immediately. It is posted. */
    int NEXT_FRAME = 1;
//      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NEXT_FRAME.
//                 documentation ```java\npublic static final int NEXT_FRAME\n```
//                 documentation A request has been made to build models immediately. It is posted. 
    /** A request has been made to build models after a delay. It is post delayed. */
    int DELAYED = 2;
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#DELAYED.
//              documentation ```java\npublic static final int DELAYED\n```
//              documentation A request has been made to build models after a delay. It is post delayed. 
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
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
//                              documentation ```java\npublic void requestModelBuild()\n```
//                              documentation  Call this to request a model update. The controller will schedule a call to {@link\n #buildModels()} so that models can be rebuilt for the current data. Once a build is requested\n all subsequent requests are ignored until the model build runs. Therefore, the calling code\n need not worry about calling this multiple times in a row.\n <p>\n The exception is that the first time this is called on a new instance of {@link\n EpoxyController} it is run synchronously. This allows state to be restored and the initial view\n to be draw quicker.\n <p>\n If you would like to be alerted when models have finished building use\n {@link #addModelBuildListener(OnModelBuildFinishedListener)}\n
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#requestModelBuild().
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#requestModelBuild().
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#requestModelBuild().
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Typed4EpoxyController#requestModelBuild().
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#requestModelBuild().
    if (isBuildingModels()) {
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#isBuildingModels().
      throw new IllegalEpoxyUsage("Cannot call `requestModelBuild` from inside `buildModels`");
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
    }

    // If it is the first time building models then we do it right away, otherwise we post the call.
    // We want to do it right away the first time so that scroll position can be restored correctly,
    // shared element transitions aren't delayed, and content is shown asap. We post later calls
    // so that they are debounced, and so any updates to data can be completely finished before
    // the models are built.
    if (hasBuiltModelsEver) {
//      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#hasBuiltModelsEver.
      requestDelayedModelBuild(0);
//    ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
    } else {
      buildModelsRunnable.run();
//    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#buildModelsRunnable.
//                        ^^^ reference semanticdb maven jdk 11 java/lang/Runnable#run().
    }
  }

  /**
   * Whether an update to models is currently pending. This can either be because
   * {@link #requestModelBuild()} was called, or because models are currently being built or diff
   * on a background thread.
   */
  public boolean hasPendingModelBuild() {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#hasPendingModelBuild().
//                                    documentation ```java\npublic boolean hasPendingModelBuild()\n```
//                                    documentation  Whether an update to models is currently pending. This can either be because\n {@link #requestModelBuild()} was called, or because models are currently being built or diff\n on a background thread.\n
    return requestedModelBuildType != RequestedModelBuildType.NONE // model build is posted
//         ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
//                                    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                                            ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NONE.
        || threadBuildingModels != null // model build is in progress
//         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#threadBuildingModels.
        || adapter.isDiffInProgress(); // Diff in progress
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#isDiffInProgress().
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
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#addModelBuildListener().
//                                  documentation ```java\npublic void addModelBuildListener(OnModelBuildFinishedListener listener)\n```
//                                  documentation  Add a listener that will be called every time {@link #buildModels()} has finished running\n and changes have been dispatched to the RecyclerView.\n <p>\n Since buildModels can be called once for many calls to {@link #requestModelBuild()}, this is\n called just once for each buildModels execution, not for every request.\n <p>\n Use this to react to changes in your models that need to happen after the RecyclerView has\n been notified, such as scrolling.\n
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                               ^^^^^^^^ definition local 2
//                                                                        documentation ```java\nOnModelBuildFinishedListener listener\n```
    adapter.addModelBuildListener(listener);
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#addModelBuildListener().
//                                ^^^^^^^^ reference local 2
  }

  /**
   * Remove a listener added with {@link #addModelBuildListener(OnModelBuildFinishedListener)}.
   * This is safe to call from inside the callback
   * {@link OnModelBuildFinishedListener#onModelBuildFinished(DiffResult)}
   */
  public void removeModelBuildListener(OnModelBuildFinishedListener listener) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#removeModelBuildListener().
//                                     documentation ```java\npublic void removeModelBuildListener(OnModelBuildFinishedListener listener)\n```
//                                     documentation  Remove a listener added with {@link #addModelBuildListener(OnModelBuildFinishedListener)}.\n This is safe to call from inside the callback\n {@link OnModelBuildFinishedListener#onModelBuildFinished(DiffResult)}\n
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                                  ^^^^^^^^ definition local 3
//                                                                           documentation ```java\nOnModelBuildFinishedListener listener\n```
    adapter.removeModelBuildListener(listener);
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#removeModelBuildListener().
//                                   ^^^^^^^^ reference local 3
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
//                         ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
//                                                  documentation ```java\npublic void requestDelayedModelBuild(int delayMs)\n```
//                                                  documentation  Call this to request a delayed model update. The controller will schedule a call to {@link\n #buildModels()} so that models can be rebuilt for the current data.\n <p>\n Using this to delay a model update may be helpful in cases where user input is causing many\n rapid changes in the models, such as typing. In that case, the view is already updated on\n screen and constantly rebuilding models is potentially slow and unnecessary. The downside to\n delaying the model build too long is that models will not be in sync with the data or view, and\n scrolling the view offscreen and back onscreen will cause the model to bind old data.\n <p>\n If a previous request is still pending it will be removed in favor of this new delay\n <p>\n Any call to {@link #requestModelBuild()} will override a delayed request.\n <p>\n In most cases you should use {@link #requestModelBuild()} instead of this.\n\n @param delayMs The time in milliseconds to delay the model build by. Should be greater than or\n                equal to 0. A value of 0 is equivalent to calling {@link #requestModelBuild()}\n
//                                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#requestDelayedModelBuild().
//                                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#requestDelayedModelBuild().
//                                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Typed4EpoxyController#requestDelayedModelBuild().
//                                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#requestDelayedModelBuild().
//                                                      ^^^^^^^ definition local 4
//                                                              documentation ```java\nint delayMs\n```
    if (isBuildingModels()) {
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#isBuildingModels().
      throw new IllegalEpoxyUsage(
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
          "Cannot call `requestDelayedModelBuild` from inside `buildModels`");
    }

    if (requestedModelBuildType == RequestedModelBuildType.DELAYED) {
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
//                                 ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                                         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#DELAYED.
      cancelPendingModelBuild();
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#cancelPendingModelBuild().
    } else if (requestedModelBuildType == RequestedModelBuildType.NEXT_FRAME) {
//             ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
//                                        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NEXT_FRAME.
      return;
    }

    requestedModelBuildType =
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
        delayMs == 0 ? RequestedModelBuildType.NEXT_FRAME : RequestedModelBuildType.DELAYED;
//      ^^^^^^^ reference local 4
//                     ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NEXT_FRAME.
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                                                                  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#DELAYED.

    modelBuildHandler.postDelayed(buildModelsRunnable, delayMs);
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelBuildHandler.
//                    ^^^^^^^^^^^ reference semanticdb maven . . postDelayed#
//                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#buildModelsRunnable.
//                                                     ^^^^^^^ reference local 4
  }

  /**
   * Cancels a pending call to {@link #buildModels()} if one has been queued by {@link
   * #requestModelBuild()}.
   */
  public synchronized void cancelPendingModelBuild() {
//                         ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#cancelPendingModelBuild().
//                                                 documentation ```java\npublic void cancelPendingModelBuild()\n```
//                                                 documentation  Cancels a pending call to {@link #buildModels()} if one has been queued by {@link\n #requestModelBuild()}.\n
    // Access to requestedModelBuildType is synchronized because the model building thread clears
    // it when model building starts, and the main thread needs to set it to indicate a build
    // request.
    // Additionally, it is crucial to guarantee that the state of requestedModelBuildType is in sync
    // with the modelBuildHandler, otherwise we could end up in a state where we think a model build
    // is queued, but it isn't, and model building never happens - stuck forever.
    if (requestedModelBuildType != RequestedModelBuildType.NONE) {
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
//                                 ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                                         ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NONE.
      requestedModelBuildType = RequestedModelBuildType.NONE;
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestedModelBuildType.
//                              ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#
//                                                      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#RequestedModelBuildType#NONE.
      modelBuildHandler.removeCallbacks(buildModelsRunnable);
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelBuildHandler.
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . removeCallbacks#
//                                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#buildModelsRunnable.
    }
  }

  private final Runnable buildModelsRunnable = new Runnable() {
//              ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Runnable#
//                       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#buildModelsRunnable.
//                                           documentation ```java\nprivate final Runnable buildModelsRunnable\n```
//                                                 ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Runnable#
    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void run() {
//              ^^^ definition local 7
//                  documentation ```java\n@Override\npublic void run()\n```
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Runnable#run().
      // Do this first to mark the controller as being in the model building process.
      threadBuildingModels = Thread.currentThread();
//    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#threadBuildingModels.
//                           ^^^^^^ reference semanticdb maven jdk 11 java/lang/Thread#
//                                  ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Thread#currentThread().

      // This is needed to reset the requestedModelBuildType back to NONE.
      // As soon as we do this another model build can be posted.
      cancelPendingModelBuild();
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#cancelPendingModelBuild().

      helper.resetAutoModels();
//    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#helper.
//           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelper#resetAutoModels().

      modelsBeingBuilt = new ControllerModelList(getExpectedModelCount());
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerModelList#`<init>`().
//                                               ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#getExpectedModelCount().

      timer.start("Models built");
//    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#start().

      // The user's implementation of buildModels is wrapped in a try/catch so that if it fails
      // we can reset the state of this controller. This is useful when model building is done
      // on a dedicated thread, which may have its own error handler, and a failure may not
      // crash the app - in which case this controller would be in an invalid state and crash later
      // with confusing errors because "threadBuildingModels" and other properties are not
      // correctly set. This can happen particularly with Espresso testing.
      try {
        buildModels();
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#buildModels().
      } catch (Throwable throwable) {
//             ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Throwable#
//                       ^^^^^^^^^ definition local 8
//                                 documentation ```java\nThrowable throwable\n```
        timer.stop();
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//            ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#stop().
        modelsBeingBuilt = null;
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
        hasBuiltModelsEver = true;
//      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#hasBuiltModelsEver.
        threadBuildingModels = null;
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#threadBuildingModels.
        stagedModel = null;
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#stagedModel.
        throw throwable;
//            ^^^^^^^^^ reference local 8
      }

      addCurrentlyStagedModelIfExists();
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#addCurrentlyStagedModelIfExists().
      timer.stop();
//    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#stop().

      runInterceptors();
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#runInterceptors().
      filterDuplicatesIfNeeded(modelsBeingBuilt);
//    ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#filterDuplicatesIfNeeded().
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
      modelsBeingBuilt.freeze();
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerModelList#freeze().

      timer.start("Models diffed");
//    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#start().
      adapter.setModels(modelsBeingBuilt);
//    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//            ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#setModels().
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
      // This timing is only right if diffing and model building are on the same thread
      timer.stop();
//    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#stop().

      modelsBeingBuilt = null;
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
      hasBuiltModelsEver = true;
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#hasBuiltModelsEver.
      threadBuildingModels = null;
//    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#threadBuildingModels.
    }
  };

  /** An estimate for how many models will be built in the next {@link #buildModels()} phase. */
  private int getExpectedModelCount() {
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#getExpectedModelCount().
//                                  documentation ```java\nprivate int getExpectedModelCount()\n```
//                                  documentation An estimate for how many models will be built in the next {@link #buildModels()} phase. 
    int currentModelCount = adapter.getItemCount();
//      ^^^^^^^^^^^^^^^^^ definition local 9
//                        documentation ```java\nint currentModelCount\n```
//                          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getItemCount().
    return currentModelCount != 0 ? currentModelCount : 25;
//         ^^^^^^^^^^^^^^^^^ reference local 9
//                                  ^^^^^^^^^^^^^^^^^ reference local 9
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
//                        ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#buildModels().
//                                    documentation ```java\nprotected abstract void buildModels()\n```
//                                    documentation  Subclasses should implement this to describe what models should be shown for the current state.\n Implementations should call either {@link #add(EpoxyModel)}, {@link\n EpoxyModel#addTo(EpoxyController)}, or {@link EpoxyModel#addIf(boolean, EpoxyController)} with\n the models that should be shown, in the order that is desired.\n <p>\n Once a model is added to the controller it should be treated as immutable and never modified\n again. This is necessary for adapter updates to be accurate. If "validateEpoxyModelUsage" is\n enabled then runtime validations will be done to make sure models are not changed.\n <p>\n You CANNOT call this method directly. Instead, call {@link #requestModelBuild()} to have the\n controller schedule an update.\n
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#buildModels().
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#buildModels().
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#buildModels().
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Typed4EpoxyController#buildModels().
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#buildModels().

  int getFirstIndexOfModelInBuildingList(EpoxyModel<?> model) {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#getFirstIndexOfModelInBuildingList().
//                                       documentation ```java\nint getFirstIndexOfModelInBuildingList(EpoxyModel<?> model)\n```
//                                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                     ^^^^^ definition local 10
//                                                           documentation ```java\nEpoxyModel<?> model\n```
    assertIsBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#assertIsBuildingModels().

    int size = modelsBeingBuilt.size();
//      ^^^^ definition local 11
//           documentation ```java\nint size\n```
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                              ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
    for (int i = 0; i < size; i++) {
//           ^ definition local 12
//             documentation ```java\nint i\n```
//                  ^ reference local 12
//                      ^^^^ reference local 11
//                            ^ reference local 12
      if (modelsBeingBuilt.get(i) == model) {
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                         ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#get().
//                             ^ reference local 12
//                                   ^^^^^ reference local 10
        return i;
//             ^ reference local 12
      }
    }

    return -1;
  }

  boolean isModelAddedMultipleTimes(EpoxyModel<?> model) {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#isModelAddedMultipleTimes().
//                                  documentation ```java\nboolean isModelAddedMultipleTimes(EpoxyModel<?> model)\n```
//                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                ^^^^^ definition local 13
//                                                      documentation ```java\nEpoxyModel<?> model\n```
    assertIsBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#assertIsBuildingModels().

    int modelCount = 0;
//      ^^^^^^^^^^ definition local 14
//                 documentation ```java\nint modelCount\n```
    int size = modelsBeingBuilt.size();
//      ^^^^ definition local 15
//           documentation ```java\nint size\n```
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                              ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
    for (int i = 0; i < size; i++) {
//           ^ definition local 16
//             documentation ```java\nint i\n```
//                  ^ reference local 16
//                      ^^^^ reference local 15
//                            ^ reference local 16
      if (modelsBeingBuilt.get(i) == model) {
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                         ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#get().
//                             ^ reference local 16
//                                   ^^^^^ reference local 13
        modelCount++;
//      ^^^^^^^^^^ reference local 14
      }
    }

    return modelCount > 1;
//         ^^^^^^^^^^ reference local 14
  }

  void addAfterInterceptorCallback(ModelInterceptorCallback callback) {
//     ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#addAfterInterceptorCallback().
//                                 documentation ```java\nvoid addAfterInterceptorCallback(ModelInterceptorCallback callback)\n```
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#
//                                                          ^^^^^^^^ definition local 17
//                                                                   documentation ```java\nModelInterceptorCallback callback\n```
    assertIsBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#assertIsBuildingModels().

    if (modelInterceptorCallbacks == null) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
      modelInterceptorCallbacks = new ArrayList<>();
//    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
//                                    ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+1).
    }

    modelInterceptorCallbacks.add(callback);
//  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
//                            ^^^ reference semanticdb maven jdk 11 java/util/List#add().
//                                ^^^^^^^^ reference local 17
  }

  /**
   * Callbacks to each model for when interceptors are started and stopped, so the models know when
   * to allow changes.
   */
  interface ModelInterceptorCallback {
//          ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#
//                                   documentation ```java\ninterface ModelInterceptorCallback\n```
//                                   documentation  Callbacks to each model for when interceptors are started and stopped, so the models know when\n to allow changes.\n
    void onInterceptorsStarted(EpoxyController controller);
//       ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#onInterceptorsStarted().
//                             documentation ```java\npublic abstract void onInterceptorsStarted(EpoxyController controller)\n```
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                             ^^^^^^^^^^ definition local 18
//                                                        documentation ```java\nEpoxyController controller\n```
    void onInterceptorsFinished(EpoxyController controller);
//       ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#onInterceptorsFinished().
//                              documentation ```java\npublic abstract void onInterceptorsFinished(EpoxyController controller)\n```
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                              ^^^^^^^^^^ definition local 19
//                                                         documentation ```java\nEpoxyController controller\n```
  }

  private void runInterceptors() {
//             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#runInterceptors().
//                             documentation ```java\nprivate void runInterceptors()\n```
    if (!interceptors.isEmpty()) {
//       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#interceptors.
//                    ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
      if (modelInterceptorCallbacks != null) {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
        for (ModelInterceptorCallback callback : modelInterceptorCallbacks) {
//           ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#
//                                    ^^^^^^^^ definition local 20
//                                             documentation ```java\nModelInterceptorCallback callback\n```
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
          callback.onInterceptorsStarted(this);
//        ^^^^^^^^ reference local 20
//                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#onInterceptorsStarted().
        }
      }

      timer.start("Interceptors executed");
//    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#start().

      for (Interceptor interceptor : interceptors) {
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#Interceptor#
//                     ^^^^^^^^^^^ definition local 21
//                                 documentation ```java\nInterceptor interceptor\n```
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#interceptors.
        interceptor.intercept(modelsBeingBuilt);
//      ^^^^^^^^^^^ reference local 21
//                  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#Interceptor#intercept().
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
      }

      timer.stop();
//    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#stop().

      if (modelInterceptorCallbacks != null) {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
        for (ModelInterceptorCallback callback : modelInterceptorCallbacks) {
//           ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#
//                                    ^^^^^^^^ definition local 22
//                                             documentation ```java\nModelInterceptorCallback callback\n```
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
          callback.onInterceptorsFinished(this);
//        ^^^^^^^^ reference local 22
//                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#onInterceptorsFinished().
        }
      }
    }

    // Interceptors are cleared so that future model builds don't notify past models.
    // We need to make sure they are cleared even if there are no interceptors so that
    // we don't leak the models.
    modelInterceptorCallbacks = null;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelInterceptorCallbacks.
  }

  /** A callback that is run after {@link #buildModels()} completes and before diffing is run. */
  public interface Interceptor {
//                 ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#Interceptor#
//                             documentation ```java\npublic interface Interceptor\n```
//                             documentation A callback that is run after {@link #buildModels()} completes and before diffing is run. 
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
//       ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#Interceptor#intercept().
//                 documentation ```java\npublic abstract void intercept(List<EpoxyModel<?>> models)\n```
//                 documentation  This is called immediately after {@link #buildModels()} and before diffing is run and the\n models are set on the adapter. This is a final chance to make any changes to the the models\n added in {@link #buildModels()}. This may be useful for actions that act on all models in\n aggregate, such as toggling divider settings, or for cases such as rearranging models for an\n experiment.\n <p>\n The models list must not be changed after this method returns. Doing so will throw an\n exception.\n
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^^ definition local 23
//                                                     documentation ```java\n@NonNull\nList<EpoxyModel<?>> models\n```
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
//            ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#addInterceptor().
//                           documentation ```java\npublic void addInterceptor(Interceptor interceptor)\n```
//                           documentation  Add an interceptor callback to be run after models are built, to make any last changes before\n they are set on the adapter. Interceptors are run in the order they are added.\n <p>\n Interceptors are run on the same thread that models are built on.\n\n @see Interceptor#intercept(List)\n
//                            ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#Interceptor#
//                                                ^^^^^^^^^^^ definition local 24
//                                                            documentation ```java\n@NonNull\nInterceptor interceptor\n```
    interceptors.add(interceptor);
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#interceptors.
//               ^^^ reference semanticdb maven jdk 11 java/util/List#add().
//                   ^^^^^^^^^^^ reference local 24
  }

  /** Remove an interceptor that was added with {@link #addInterceptor(Interceptor)}. */
  public void removeInterceptor(@NonNull Interceptor interceptor) {
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#removeInterceptor().
//                              documentation ```java\npublic void removeInterceptor(Interceptor interceptor)\n```
//                              documentation Remove an interceptor that was added with {@link #addInterceptor(Interceptor)}. 
//                               ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                       ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#Interceptor#
//                                                   ^^^^^^^^^^^ definition local 25
//                                                               documentation ```java\n@NonNull\nInterceptor interceptor\n```
    interceptors.remove(interceptor);
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#interceptors.
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/List#remove().
//                      ^^^^^^^^^^^ reference local 25
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
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#getModelCountBuiltSoFar().
//                                      documentation ```java\nprotected int getModelCountBuiltSoFar()\n```
//                                      documentation  Get the number of models added so far during the {@link #buildModels()} phase. It is only valid\n to call this from within that method.\n <p>\n This is different from the number of models currently on the adapter, since models on the\n adapter are not updated until after models are finished being built. To access current adapter\n count call {@link #getAdapter()} and {@link EpoxyControllerAdapter#getItemCount()}\n
    assertIsBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#assertIsBuildingModels().
    return modelsBeingBuilt.size();
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                          ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
  }

  private void assertIsBuildingModels() {
//             ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#assertIsBuildingModels().
//                                    documentation ```java\nprivate void assertIsBuildingModels()\n```
    if (!isBuildingModels()) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#isBuildingModels().
      throw new IllegalEpoxyUsage("Can only call this when inside the `buildModels` method");
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
    }
  }

  private void assertNotBuildingModels() {
//             ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#assertNotBuildingModels().
//                                     documentation ```java\nprivate void assertNotBuildingModels()\n```
    if (isBuildingModels()) {
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#isBuildingModels().
      throw new IllegalEpoxyUsage("Cannot call this from inside `buildModels`");
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
    }
  }

  /**
   * Add the model to this controller. Can only be called from inside {@link
   * EpoxyController#buildModels()}.
   */
  public void add(@NonNull EpoxyModel<?> model) {
//            ^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#add().
//                documentation ```java\npublic void add(EpoxyModel<?> model)\n```
//                documentation  Add the model to this controller. Can only be called from inside {@link\n EpoxyController#buildModels()}.\n
//                 ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^ definition local 26
//                                             documentation ```java\n@NonNull\nEpoxyModel<?> model\n```
    model.addTo(this);
//  ^^^^^ reference local 26
//        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#addTo().
  }

  /**
   * Add the models to this controller. Can only be called from inside {@link
   * EpoxyController#buildModels()}.
   */
  protected void add(@NonNull EpoxyModel<?>... modelsToAdd) {
//               ^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#add(+1).
//                   documentation ```java\nprotected void add(EpoxyModel<?>[] modelsToAdd)\n```
//                   documentation  Add the models to this controller. Can only be called from inside {@link\n EpoxyController#buildModels()}.\n
//                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^^^^^^^ definition local 27
//                                                         documentation ```java\n@NonNull\nEpoxyModel<?>[] modelsToAdd\n```
    modelsBeingBuilt.ensureCapacity(modelsBeingBuilt.size() + modelsToAdd.length);
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                   ^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#ensureCapacity().
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                                                   ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
//                                                            ^^^^^^^^^^^ reference local 27
//                                                                        ^^^^^^ reference semanticdb maven . . length.

    for (EpoxyModel<?> model : modelsToAdd) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local 28
//                           documentation ```java\nEpoxyModel<?> model\n```
//                             ^^^^^^^^^^^ reference local 27
      add(model);
//    ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#add().
//        ^^^^^ reference local 28
    }
  }

  /**
   * Add the models to this controller. Can only be called from inside {@link
   * EpoxyController#buildModels()}.
   */
  protected void add(@NonNull List<? extends EpoxyModel<?>> modelsToAdd) {
//               ^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#add(+2).
//                   documentation ```java\nprotected void add(List<? extends EpoxyModel<?>> modelsToAdd)\n```
//                   documentation  Add the models to this controller. Can only be called from inside {@link\n EpoxyController#buildModels()}.\n
//                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                            ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                          ^^^^^^^^^^^ definition local 29
//                                                                      documentation ```java\n@NonNull\nList<? extends EpoxyModel<?>> modelsToAdd\n```
    modelsBeingBuilt.ensureCapacity(modelsBeingBuilt.size() + modelsToAdd.size());
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                   ^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#ensureCapacity().
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                                                   ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
//                                                            ^^^^^^^^^^^ reference local 29
//                                                                        ^^^^ reference semanticdb maven jdk 11 java/util/List#size().

    for (EpoxyModel<?> model : modelsToAdd) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local 30
//                           documentation ```java\nEpoxyModel<?> model\n```
//                             ^^^^^^^^^^^ reference local 29
      add(model);
//    ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#add().
//        ^^^^^ reference local 30
    }
  }

  /**
   * Method to actually add the model to the list being built. Should be called after all
   * validations are done.
   */
  void addInternal(EpoxyModel<?> modelToAdd) {
//     ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#addInternal().
//                 documentation ```java\nvoid addInternal(EpoxyModel<?> modelToAdd)\n```
//                 documentation  Method to actually add the model to the list being built. Should be called after all\n validations are done.\n
//                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                               ^^^^^^^^^^ definition local 31
//                                          documentation ```java\nEpoxyModel<?> modelToAdd\n```
    assertIsBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#assertIsBuildingModels().

    if (modelToAdd.hasDefaultId()) {
//      ^^^^^^^^^^ reference local 31
//                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hasDefaultId().
      throw new IllegalEpoxyUsage(
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
          "You must set an id on a model before adding it. Use the @AutoModel annotation if you "
              + "want an id to be automatically generated for you.");
    }

    if (!modelToAdd.isShown()) {
//       ^^^^^^^^^^ reference local 31
//                  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#isShown().
      throw new IllegalEpoxyUsage(
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
          "You cannot hide a model in an EpoxyController. Use `addIf` to conditionally add a "
              + "model instead.");
    }

    // The model being added may not have been staged if it wasn't mutated before it was added.
    // In that case we may have a previously staged model that still needs to be added.
    clearModelFromStaging(modelToAdd);
//  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#clearModelFromStaging().
//                        ^^^^^^^^^^ reference local 31
    modelToAdd.controllerToStageTo = null;
//  ^^^^^^^^^^ reference local 31
//             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#controllerToStageTo.
    modelsBeingBuilt.add(modelToAdd);
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#modelsBeingBuilt.
//                   ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#add().
//                       ^^^^^^^^^^ reference local 31
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
//     ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#setStagedModel().
//                    documentation ```java\nvoid setStagedModel(EpoxyModel<?> model)\n```
//                    documentation  Staging models allows them to be implicitly added after the user finishes modifying them. This\n means that if a user has modified a model, and then moves on to modifying a different model,\n the first model is automatically added as soon as the second model is modified.\n <p>\n There are some edge cases for handling models that are added without modification, or models\n that are modified but then fail an `addIf` check.\n <p>\n This only works for AutoModels, and only if implicitly adding is enabled in configuration.\n
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^ definition local 32
//                                        documentation ```java\nEpoxyModel<?> model\n```
    if (model != stagedModel) {
//      ^^^^^ reference local 32
//               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#stagedModel.
      addCurrentlyStagedModelIfExists();
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#addCurrentlyStagedModelIfExists().
    }

    stagedModel = model;
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#stagedModel.
//                ^^^^^ reference local 32
  }

  void addCurrentlyStagedModelIfExists() {
//     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#addCurrentlyStagedModelIfExists().
//                                     documentation ```java\nvoid addCurrentlyStagedModelIfExists()\n```
    if (stagedModel != null) {
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#stagedModel.
      stagedModel.addTo(this);
//    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#stagedModel.
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#addTo().
    }
    stagedModel = null;
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#stagedModel.
  }

  void clearModelFromStaging(EpoxyModel<?> model) {
//     ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#clearModelFromStaging().
//                           documentation ```java\nvoid clearModelFromStaging(EpoxyModel<?> model)\n```
//                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                         ^^^^^ definition local 33
//                                               documentation ```java\nEpoxyModel<?> model\n```
    if (stagedModel != model) {
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#stagedModel.
//                     ^^^^^ reference local 33
      addCurrentlyStagedModelIfExists();
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#addCurrentlyStagedModelIfExists().
    }
    stagedModel = null;
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#stagedModel.
  }

  /** True if the current callstack originated from the buildModels call, on the same thread. */
  protected boolean isBuildingModels() {
//                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#isBuildingModels().
//                                   documentation ```java\nprotected boolean isBuildingModels()\n```
//                                   documentation True if the current callstack originated from the buildModels call, on the same thread. 
    return threadBuildingModels == Thread.currentThread();
//         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#threadBuildingModels.
//                                 ^^^^^^ reference semanticdb maven jdk 11 java/lang/Thread#
//                                        ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Thread#currentThread().
  }

  private void filterDuplicatesIfNeeded(List<EpoxyModel<?>> models) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#filterDuplicatesIfNeeded().
//                                      documentation ```java\nprivate void filterDuplicatesIfNeeded(List<EpoxyModel<?>> models)\n```
//                                      ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                          ^^^^^^ definition local 34
//                                                                 documentation ```java\nList<EpoxyModel<?>> models\n```
    if (!filterDuplicates) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#filterDuplicates.
      return;
    }

    timer.start("Duplicates filtered");
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#start().
    Set<Long> modelIds = new HashSet<>(models.size());
//  ^^^ reference semanticdb maven jdk 11 java/util/Set#
//      ^^^^ reference semanticdb maven jdk 11 java/lang/Long#
//            ^^^^^^^^ definition local 35
//                     documentation ```java\nSet<Long> modelIds\n```
//                           ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashSet#`<init>`(+3).
//                                     ^^^^^^ reference local 34
//                                            ^^^^ reference semanticdb maven jdk 11 java/util/List#size().

    ListIterator<EpoxyModel<?>> modelIterator = models.listIterator();
//  ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
//               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                              ^^^^^^^^^^^^^ definition local 36
//                                            documentation ```java\nListIterator<EpoxyModel<?>> modelIterator\n```
//                                              ^^^^^^ reference local 34
//                                                     ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/List#listIterator().
    while (modelIterator.hasNext()) {
//         ^^^^^^^^^^^^^ reference local 36
//                       ^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#hasNext().
      EpoxyModel<?> model = modelIterator.next();
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^ definition local 37
//                        documentation ```java\nEpoxyModel<?> model\n```
//                          ^^^^^^^^^^^^^ reference local 36
//                                        ^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#next().
      if (!modelIds.add(model.id())) {
//         ^^^^^^^^ reference local 35
//                  ^^^ reference semanticdb maven jdk 11 java/util/Set#add().
//                      ^^^^^ reference local 37
//                            ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
        int indexOfDuplicate = modelIterator.previousIndex();
//          ^^^^^^^^^^^^^^^^ definition local 38
//                           documentation ```java\nint indexOfDuplicate\n```
//                             ^^^^^^^^^^^^^ reference local 36
//                                           ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#previousIndex().
        modelIterator.remove();
//      ^^^^^^^^^^^^^ reference local 36
//                    ^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#remove().

        int indexOfOriginal = findPositionOfDuplicate(models, model);
//          ^^^^^^^^^^^^^^^ definition local 39
//                          documentation ```java\nint indexOfOriginal\n```
//                            ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#findPositionOfDuplicate().
//                                                    ^^^^^^ reference local 34
//                                                            ^^^^^ reference local 37
        EpoxyModel<?> originalModel = models.get(indexOfOriginal);
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                    ^^^^^^^^^^^^^ definition local 40
//                                  documentation ```java\nEpoxyModel<?> originalModel\n```
//                                    ^^^^^^ reference local 34
//                                           ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                               ^^^^^^^^^^^^^^^ reference local 39
        if (indexOfDuplicate <= indexOfOriginal) {
//          ^^^^^^^^^^^^^^^^ reference local 38
//                              ^^^^^^^^^^^^^^^ reference local 39
          // Adjust for the original positions of the models before the duplicate was removed
          indexOfOriginal++;
//        ^^^^^^^^^^^^^^^ reference local 39
        }

        onExceptionSwallowed(
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onExceptionSwallowed().
            new IllegalEpoxyUsage("Two models have the same ID. ID's must be unique!"
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
                + "\nOriginal has position " + indexOfOriginal + ":\n" + originalModel
//                                             ^^^^^^^^^^^^^^^ reference local 39
//                                                                       ^^^^^^^^^^^^^ reference local 40
                + "\nDuplicate has position " + indexOfDuplicate + ":\n" + model)
//                                              ^^^^^^^^^^^^^^^^ reference local 38
//                                                                         ^^^^^ reference local 37
        );
      }
    }

    timer.stop();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Timer#stop().
  }

  private int findPositionOfDuplicate(List<EpoxyModel<?>> models, EpoxyModel<?> duplicateModel) {
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#findPositionOfDuplicate().
//                                    documentation ```java\nprivate int findPositionOfDuplicate(List<EpoxyModel<?>> models, EpoxyModel<?> duplicateModel)\n```
//                                    ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                        ^^^^^^ definition local 41
//                                                               documentation ```java\nList<EpoxyModel<?>> models\n```
//                                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                              ^^^^^^^^^^^^^^ definition local 42
//                                                                                             documentation ```java\nEpoxyModel<?> duplicateModel\n```
    int size = models.size();
//      ^^^^ definition local 43
//           documentation ```java\nint size\n```
//             ^^^^^^ reference local 41
//                    ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    for (int i = 0; i < size; i++) {
//           ^ definition local 44
//             documentation ```java\nint i\n```
//                  ^ reference local 44
//                      ^^^^ reference local 43
//                            ^ reference local 44
      EpoxyModel<?> model = models.get(i);
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^ definition local 45
//                        documentation ```java\nEpoxyModel<?> model\n```
//                          ^^^^^^ reference local 41
//                                 ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                     ^ reference local 44
      if (model.id() == duplicateModel.id()) {
//        ^^^^^ reference local 45
//              ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
//                      ^^^^^^^^^^^^^^ reference local 42
//                                     ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
        return i;
//             ^ reference local 44
      }
    }

    throw new IllegalArgumentException("No duplicates in list");
//            ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalArgumentException#`<init>`(+1).
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
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#setFilterDuplicates().
//                                documentation ```java\npublic void setFilterDuplicates(boolean filterDuplicates)\n```
//                                documentation  If set to true, Epoxy will search for models with duplicate ids added during {@link\n #buildModels()} and remove any duplicates found. If models with the same id are found, the\n first one is left in the adapter and any subsequent models are removed. {@link\n #onExceptionSwallowed(RuntimeException)} will be called for each duplicate removed.\n <p>\n This may be useful if your models are created via server supplied data, in which case the\n server may erroneously send duplicate items. Duplicate items are otherwise left in and can\n result in undefined behavior.\n
//                                        ^^^^^^^^^^^^^^^^ definition local 46
//                                                         documentation ```java\nboolean filterDuplicates\n```
    this.filterDuplicates = filterDuplicates;
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#filterDuplicates.
//                          ^^^^^^^^^^^^^^^^ reference local 46
  }

  public boolean isDuplicateFilteringEnabled() {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#isDuplicateFilteringEnabled().
//                                           documentation ```java\npublic boolean isDuplicateFilteringEnabled()\n```
    return filterDuplicates;
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#filterDuplicates.
  }

  /**
   * {@link #setFilterDuplicates(boolean)} is disabled in each EpoxyController by default. It can be
   * toggled individually in each controller, or alternatively you can use this to change the
   * default value for all EpoxyControllers.
   */
  public static void setGlobalDuplicateFilteringDefault(boolean filterDuplicatesByDefault) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#setGlobalDuplicateFilteringDefault().
//                                                      documentation ```java\npublic static void setGlobalDuplicateFilteringDefault(boolean filterDuplicatesByDefault)\n```
//                                                      documentation  {@link #setFilterDuplicates(boolean)} is disabled in each EpoxyController by default. It can be\n toggled individually in each controller, or alternatively you can use this to change the\n default value for all EpoxyControllers.\n
//                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 47
//                                                                                        documentation ```java\nboolean filterDuplicatesByDefault\n```
    EpoxyController.filterDuplicatesDefault = filterDuplicatesByDefault;
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#filterDuplicatesDefault.
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 47
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
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#setDebugLoggingEnabled().
//                                   documentation ```java\npublic void setDebugLoggingEnabled(boolean enabled)\n```
//                                   documentation  If enabled, DEBUG logcat messages will be printed to show when models are rebuilt, the time\n taken to build them, the time taken to diff them, and the item change outcomes from the\n differ. The tag of the logcat message is the class name of your EpoxyController.\n <p>\n This is useful to verify that models are being diffed as expected, as well as to watch for\n slowdowns in model building or diffing to indicate when you should optimize model building or\n model hashCode/equals implementations (which can often slow down diffing).\n <p>\n This should only be used in debug builds to avoid a performance hit in prod.\n
//                                           ^^^^^^^ definition local 48
//                                                   documentation ```java\nboolean enabled\n```
    assertNotBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#assertNotBuildingModels().

    if (enabled) {
//      ^^^^^^^ reference local 48
      timer = new DebugTimer(getClass().getSimpleName());
//    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DebugTimer#`<init>`().
//                           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
//                                      ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getSimpleName().
      if (debugObserver == null) {
//        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#debugObserver.
        debugObserver = new EpoxyDiffLogger(getClass().getSimpleName());
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#debugObserver.
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#`<init>`().
//                                          ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
//                                                     ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getSimpleName().
      }
      adapter.registerAdapterDataObserver(debugObserver);
//    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#registerAdapterDataObserver#
//                                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#debugObserver.
    } else {
      timer = NO_OP_TIMER;
//    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#NO_OP_TIMER.
      if (debugObserver != null) {
//        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#debugObserver.
        adapter.unregisterAdapterDataObserver(debugObserver);
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#unregisterAdapterDataObserver#
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#debugObserver.
      }
    }
  }

  public boolean isDebugLoggingEnabled() {
//               ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#isDebugLoggingEnabled().
//                                     documentation ```java\npublic boolean isDebugLoggingEnabled()\n```
    return timer != NO_OP_TIMER;
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#timer.
//                  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#NO_OP_TIMER.
  }

  /**
   * Similar to {@link #setDebugLoggingEnabled(boolean)}, but this changes the global default for
   * all EpoxyControllers.
   * <p>
   * The default is false.
   */
  public static void setGlobalDebugLoggingEnabled(boolean globalDebugLoggingEnabled) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#setGlobalDebugLoggingEnabled().
//                                                documentation ```java\npublic static void setGlobalDebugLoggingEnabled(boolean globalDebugLoggingEnabled)\n```
//                                                documentation  Similar to {@link #setDebugLoggingEnabled(boolean)}, but this changes the global default for\n all EpoxyControllers.\n <p>\n The default is false.\n
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 49
//                                                                                  documentation ```java\nboolean globalDebugLoggingEnabled\n```
    EpoxyController.globalDebugLoggingEnabled = globalDebugLoggingEnabled;
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#globalDebugLoggingEnabled.
//                                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 49
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
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#moveModel().
//                      documentation ```java\npublic void moveModel(int fromPosition, int toPosition)\n```
//                      documentation  An optimized way to move a model from one position to another without rebuilding all models.\n This is intended to be used with {@link androidx.recyclerview.widget.ItemTouchHelper} to\n allow for efficient item dragging and rearranging. It cannot be\n <p>\n If you call this you MUST also update the data backing your models as necessary.\n <p>\n This will immediately change the model's position and notify the change to the RecyclerView.\n However, a delayed request to rebuild models will be scheduled for the future to guarantee that\n models are in sync with data.\n\n @param fromPosition Previous position of the item.\n @param toPosition   New position of the item.\n
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#moveModel().
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#moveModel().
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Typed4EpoxyController#moveModel().
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#moveModel().
//                          ^^^^^^^^^^^^ definition local 50
//                                       documentation ```java\nint fromPosition\n```
//                                            ^^^^^^^^^^ definition local 51
//                                                       documentation ```java\nint toPosition\n```
    assertNotBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#assertNotBuildingModels().

    adapter.moveModel(fromPosition, toPosition);
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#moveModel().
//                    ^^^^^^^^^^^^ reference local 50
//                                  ^^^^^^^^^^ reference local 51

    requestDelayedModelBuild(500);
//  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
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
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#notifyModelChanged().
//                               documentation ```java\npublic void notifyModelChanged(int position)\n```
//                               documentation  An way to notify the adapter that a model has changed. This is intended to be used with\n {@link androidx.recyclerview.widget.ItemTouchHelper} to allow revert swiping a model.\n <p>\n This will immediately notify the change to the RecyclerView.\n\n @param position Position of the item.\n
//                                   ^^^^^^^^ definition local 52
//                                            documentation ```java\nint position\n```
    assertNotBuildingModels();
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#assertNotBuildingModels().

    adapter.notifyModelChanged(position);
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyModelChanged().
//                             ^^^^^^^^ reference local 52
  }


  /**
   * Get the underlying adapter built by this controller. Use this to get the adapter to set on a
   * RecyclerView, or to get information about models currently in use.
   */
  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public EpoxyControllerAdapter getAdapter() {
//       ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#
//                              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#getAdapter().
//                                         documentation ```java\n@NonNull\npublic EpoxyControllerAdapter getAdapter()\n```
//                                         documentation  Get the underlying adapter built by this controller. Use this to get the adapter to set on a\n RecyclerView, or to get information about models currently in use.\n
    return adapter;
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
  }

  public void onSaveInstanceState(@NonNull Bundle outState) {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#onSaveInstanceState().
//                                documentation ```java\npublic void onSaveInstanceState(unresolved_type outState)\n```
//                                 ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                         ^^^^^^ reference semanticdb maven . . _root_/
//                                                ^^^^^^^^ definition local 53
//                                                         documentation ```java\n@NonNull\nunresolved_type outState\n```
    adapter.onSaveInstanceState(outState);
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onSaveInstanceState().
//                              ^^^^^^^^ reference local 53
  }

  public void onRestoreInstanceState(@Nullable Bundle inState) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#onRestoreInstanceState().
//                                   documentation ```java\npublic void onRestoreInstanceState(unresolved_type inState)\n```
//                                    ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                             ^^^^^^ reference semanticdb maven . . _root_/
//                                                    ^^^^^^^ definition local 54
//                                                            documentation ```java\n@Nullable\nunresolved_type inState\n```
    adapter.onRestoreInstanceState(inState);
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onRestoreInstanceState().
//                                 ^^^^^^^ reference local 54
  }

  /**
   * For use with a grid layout manager - use this to get the {@link SpanSizeLookup} for models in
   * this controller. This will delegate span look up calls to each model's {@link
   * EpoxyModel#getSpanSize(int, int, int)}. Make sure to also call {@link #setSpanCount(int)} so
   * the span count is correct.
   */
  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public SpanSizeLookup getSpanSizeLookup() {
//       ^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#getSpanSizeLookup().
//                                        documentation ```java\n@NonNull\npublic unresolved_type getSpanSizeLookup()\n```
//                                        documentation  For use with a grid layout manager - use this to get the {@link SpanSizeLookup} for models in\n this controller. This will delegate span look up calls to each model's {@link\n EpoxyModel#getSpanSize(int, int, int)}. Make sure to also call {@link #setSpanCount(int)} so\n the span count is correct.\n
    return adapter.getSpanSizeLookup();
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getSpanSizeLookup().
  }

  /**
   * If you are using a grid layout manager you must call this to set the span count of the grid.
   * This span count will be passed on to the models so models can choose which span count to be.
   *
   * @see #getSpanSizeLookup()
   * @see EpoxyModel#getSpanSize(int, int, int)
   */
  public void setSpanCount(int spanCount) {
//            ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#setSpanCount().
//                         documentation ```java\npublic void setSpanCount(int spanCount)\n```
//                         documentation  If you are using a grid layout manager you must call this to set the span count of the grid.\n This span count will be passed on to the models so models can choose which span count to be.\n\n @see #getSpanSizeLookup()\n @see EpoxyModel#getSpanSize(int, int, int)\n
//                             ^^^^^^^^^ definition local 55
//                                       documentation ```java\nint spanCount\n```
    adapter.setSpanCount(spanCount);
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#setSpanCount().
//                       ^^^^^^^^^ reference local 55
  }

  public int getSpanCount() {
//           ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#getSpanCount().
//                        documentation ```java\npublic int getSpanCount()\n```
    return adapter.getSpanCount();
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getSpanCount().
  }

  public boolean isMultiSpan() {
//               ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#isMultiSpan().
//                           documentation ```java\npublic boolean isMultiSpan()\n```
    return adapter.isMultiSpan();
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#adapter.
//                 ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#isMultiSpan().
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
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#onExceptionSwallowed().
//                                    documentation ```java\nprotected void onExceptionSwallowed(RuntimeException exception)\n```
//                                    documentation  This is called when recoverable exceptions occur at runtime. By default they are ignored and\n Epoxy will recover, but you can override this to be aware of when they happen.\n <p>\n A common use for this is being aware of duplicates when {@link #setFilterDuplicates(boolean)}\n is enabled.\n <p>\n By default the global exception handler provided by\n {@link #setGlobalExceptionHandler(ExceptionHandler)}\n is called with the exception. Overriding this allows you to provide your own handling for a\n controller.\n
//                                     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
//                                                              ^^^^^^^^^ definition local 56
//                                                                        documentation ```java\n@NonNull\nRuntimeException exception\n```
    globalExceptionHandler.onException(this, exception);
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#globalExceptionHandler.
//                         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#ExceptionHandler#onException().
//                                           ^^^^^^^^^ reference local 56
  }

  /**
   * Default handler for exceptions in all EpoxyControllers. Set with {@link
   * #setGlobalExceptionHandler(ExceptionHandler)}
   */
  private static ExceptionHandler globalExceptionHandler =
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#ExceptionHandler#
//                                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#globalExceptionHandler.
//                                                       documentation ```java\nprivate static ExceptionHandler globalExceptionHandler\n```
//                                                       documentation  Default handler for exceptions in all EpoxyControllers. Set with {@link\n #setGlobalExceptionHandler(ExceptionHandler)}\n
      new ExceptionHandler() {
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#ExceptionHandler#

        @Override
//       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
        public void onException(@NonNull EpoxyController controller,
//                  ^^^^^^^^^^^ definition local 59
//                              documentation ```java\n@Override\npublic void onException(EpoxyController controller, RuntimeException exception)\n```
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#ExceptionHandler#onException().
//                               ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                       ^^^^^^^^^^ definition local 60
//                                                                  documentation ```java\n@NonNull\nEpoxyController controller\n```
            @NonNull RuntimeException exception) {
//           ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
//                                    ^^^^^^^^^ definition local 61
//                                              documentation ```java\n@NonNull\nRuntimeException exception\n```
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
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#setGlobalExceptionHandler().
//                                             documentation ```java\npublic static void setGlobalExceptionHandler(ExceptionHandler globalExceptionHandler)\n```
//                                             documentation  Set a callback to be notified when a recoverable exception occurs at runtime.  By default these\n are ignored and Epoxy will recover, but you can override this to be aware of when they happen.\n <p>\n For example, you could choose to rethrow the exception in development builds, or log them in\n production.\n <p>\n A common use for this is being aware of duplicates when {@link #setFilterDuplicates(boolean)}\n is enabled.\n <p>\n This callback will be used in all EpoxyController classes. If you would like specific handling\n in a certain controller you can override {@link #onExceptionSwallowed(RuntimeException)} in\n that controller.\n
      @NonNull ExceptionHandler globalExceptionHandler) {
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#ExceptionHandler#
//                              ^^^^^^^^^^^^^^^^^^^^^^ definition local 62
//                                                     documentation ```java\n@NonNull\nExceptionHandler globalExceptionHandler\n```
    EpoxyController.globalExceptionHandler = globalExceptionHandler;
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#globalExceptionHandler.
//                                           ^^^^^^^^^^^^^^^^^^^^^^ reference local 62
  }

  public interface ExceptionHandler {
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#ExceptionHandler#
//                                  documentation ```java\npublic interface ExceptionHandler\n```
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
//       ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#ExceptionHandler#onException().
//                   documentation ```java\npublic abstract void onException(EpoxyController controller, RuntimeException exception)\n```
//                   documentation  This is called when recoverable exceptions happen at runtime. They can be ignored and Epoxy\n will recover, but you can override this to be aware of when they happen.\n <p>\n For example, you could choose to rethrow the exception in development builds, or log them in\n production.\n\n @param controller The EpoxyController that the error occurred in.\n
//                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                            ^^^^^^^^^^ definition local 63
//                                                       documentation ```java\n@NonNull\nEpoxyController controller\n```
//                                                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
//                                                                                  ^^^^^^^^^ definition local 64
//                                                                                            documentation ```java\n@NonNull\nRuntimeException exception\n```
  }

  void onAttachedToRecyclerViewInternal(RecyclerView recyclerView) {
//     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#onAttachedToRecyclerViewInternal().
//                                      documentation ```java\nvoid onAttachedToRecyclerViewInternal(unresolved_type recyclerView)\n```
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                   ^^^^^^^^^^^^ definition local 65
//                                                                documentation ```java\nunresolved_type recyclerView\n```
    recyclerViewAttachCount++;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#recyclerViewAttachCount.

    if (recyclerViewAttachCount > 1) {
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#recyclerViewAttachCount.
      MainThreadExecutor.INSTANCE.handler.postDelayed(new Runnable() {
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#
//                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#INSTANCE.
//                                ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#handler.
//                                        ^^^^^^^^^^^ reference semanticdb maven . . postDelayed#
//                                                        ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Runnable#
        @Override
//       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
        public void run() {
//                  ^^^ definition local 68
//                      documentation ```java\n@Override\npublic void run()\n```
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Runnable#run().
          // Only warn if there are still multiple adapters attached after a delay, to allow for
          // a grace period
          if (recyclerViewAttachCount > 1) {
//            ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#recyclerViewAttachCount.
            onExceptionSwallowed(new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onExceptionSwallowed().
//                                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
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
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#DELAY_TO_CHECK_ADAPTER_COUNT_MS.
    }

    onAttachedToRecyclerView(recyclerView);
//  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onAttachedToRecyclerView().
//                           ^^^^^^^^^^^^ reference local 65
  }

  void onDetachedFromRecyclerViewInternal(RecyclerView recyclerView) {
//     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#onDetachedFromRecyclerViewInternal().
//                                        documentation ```java\nvoid onDetachedFromRecyclerViewInternal(unresolved_type recyclerView)\n```
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                     ^^^^^^^^^^^^ definition local 69
//                                                                  documentation ```java\nunresolved_type recyclerView\n```
    recyclerViewAttachCount--;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#recyclerViewAttachCount.
    onDetachedFromRecyclerView(recyclerView);
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onDetachedFromRecyclerView().
//                             ^^^^^^^^^^^^ reference local 69
  }

  /** Called when the controller's adapter is attach to a recyclerview. */
  protected void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
//               ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#onAttachedToRecyclerView().
//                                        documentation ```java\nprotected void onAttachedToRecyclerView(unresolved_type recyclerView)\n```
//                                        documentation Called when the controller's adapter is attach to a recyclerview. 
//                                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                              ^^^^^^^^^^^^ definition local 70
//                                                                           documentation ```java\n@NonNull\nunresolved_type recyclerView\n```

  }

  /** Called when the controller's adapter is detached from a recyclerview. */
  protected void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#onDetachedFromRecyclerView().
//                                          documentation ```java\nprotected void onDetachedFromRecyclerView(unresolved_type recyclerView)\n```
//                                          documentation Called when the controller's adapter is detached from a recyclerview. 
//                                           ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                                ^^^^^^^^^^^^ definition local 71
//                                                                             documentation ```java\n@NonNull\nunresolved_type recyclerView\n```

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
//               ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#onModelBound().
//                            documentation ```java\nprotected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> boundModel, int position, EpoxyModel<?> previouslyBoundModel)\n```
//                            documentation  Called immediately after a model is bound to a view holder. Subclasses can override this if\n they want alerts on when a model is bound. Alternatively you may attach a listener directly to\n a generated model with model.onBind(...)\n\n @param previouslyBoundModel If non null, this is a model with the same id as the newly bound\n                             model, and was previously bound to a view. This means that {@link\n                             #buildModels()} returned a model that is different from the\n                             previouslyBoundModel and the view is being rebound to incorporate\n                             the change. You can compare this previous model with the new one to\n                             see exactly what changed.\n                             <p>\n                             The newly bound model and the previously bound model are guaranteed\n                             to have the same id, but will not necessarily be of the same type\n                             depending on your implementation of {@link #buildModels()}. With\n                             common usage patterns of Epoxy they should be the same type, and\n                             will only differ if you are using different model classes with the\n                             same id.\n                             <p>\n                             Comparing the newly bound model with the previous model allows you\n                             to be more intelligent when updating your view. This may help you\n                             optimize, or make it easier to work with animations.\n                             <p>\n                             If the new model and the previous model have the same view type\n                             (given by {@link EpoxyModel#getViewType()}), and if you are using\n                             the default ReyclerView item animator, the same view will be kept.\n                             If you are using a custom item animator then the view will be the\n                             same if the animator returns true in canReuseUpdatedViewHolder.\n                             <p>\n                             This previously bound model is taken as a payload from the diffing\n                             process, and follows the same general conditions for all\n                             recyclerview change payloads.\n
//                             ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^ definition local 72
//                                                            documentation ```java\n@NonNull\nEpoxyViewHolder holder\n```
//                                                              ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                    ^^^^^^^^^^ definition local 73
//                                                                                               documentation ```java\n@NonNull\nEpoxyModel<?> boundModel\n```
      int position,
//        ^^^^^^^^ definition local 74
//                 documentation ```java\nint position\n```
      @Nullable EpoxyModel<?> previouslyBoundModel) {
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^^^^^^^^^^^^^^ definition local 75
//                                                 documentation ```java\n@Nullable\nEpoxyModel<?> previouslyBoundModel\n```
  }

  /**
   * Called immediately after a model is unbound from a view holder. Subclasses can override this if
   * they want alerts on when a model is unbound. Alternatively you may attach a listener directly
   * to a generated model with model.onUnbind(...)
   */
  protected void onModelUnbound(@NonNull EpoxyViewHolder holder, @NonNull EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#onModelUnbound().
//                              documentation ```java\nprotected void onModelUnbound(EpoxyViewHolder holder, EpoxyModel<?> model)\n```
//                              documentation  Called immediately after a model is unbound from a view holder. Subclasses can override this if\n they want alerts on when a model is unbound. Alternatively you may attach a listener directly\n to a generated model with model.onUnbind(...)\n
//                               ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                       ^^^^^^ definition local 76
//                                                              documentation ```java\n@NonNull\nEpoxyViewHolder holder\n```
//                                                                ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                      ^^^^^ definition local 77
//                                                                                            documentation ```java\n@NonNull\nEpoxyModel<?> model\n```

  }

  /**
   * Called when the given viewholder is attached to the window, along with the model it is bound
   * to.
   *
   * @see BaseEpoxyAdapter#onViewAttachedToWindow(EpoxyViewHolder)
   */
  protected void onViewAttachedToWindow(@NonNull EpoxyViewHolder holder,
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#onViewAttachedToWindow().
//                                      documentation ```java\nprotected void onViewAttachedToWindow(EpoxyViewHolder holder, EpoxyModel<?> model)\n```
//                                      documentation  Called when the given viewholder is attached to the window, along with the model it is bound\n to.\n\n @see BaseEpoxyAdapter#onViewAttachedToWindow(EpoxyViewHolder)\n
//                                       ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                               ^^^^^^ definition local 78
//                                                                      documentation ```java\n@NonNull\nEpoxyViewHolder holder\n```
      @NonNull EpoxyModel<?> model) {
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^ definition local 79
//                                 documentation ```java\n@NonNull\nEpoxyModel<?> model\n```

  }

  /**
   * Called when the given viewholder is detechaed from the window, along with the model it is bound
   * to.
   *
   * @see BaseEpoxyAdapter#onViewDetachedFromWindow(EpoxyViewHolder)
   */
  protected void onViewDetachedFromWindow(@NonNull EpoxyViewHolder holder,
//               ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#onViewDetachedFromWindow().
//                                        documentation ```java\nprotected void onViewDetachedFromWindow(EpoxyViewHolder holder, EpoxyModel<?> model)\n```
//                                        documentation  Called when the given viewholder is detechaed from the window, along with the model it is bound\n to.\n\n @see BaseEpoxyAdapter#onViewDetachedFromWindow(EpoxyViewHolder)\n
//                                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                 ^^^^^^ definition local 80
//                                                                        documentation ```java\n@NonNull\nEpoxyViewHolder holder\n```
      @NonNull EpoxyModel<?> model) {
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^ definition local 81
//                                 documentation ```java\n@NonNull\nEpoxyModel<?> model\n```

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
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void setupStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#setupStickyHeaderView().
//                                  documentation ```java\n@Override\npublic void setupStickyHeaderView(unresolved_type stickyHeader)\n```
//                                  documentation  Optional callback to setup the sticky view,\n by default it doesn't do anything.\n\n The sub-classes should override the function if they are\n using sticky header feature.\n
//                                   ^^^^^^^ reference semanticdb maven maven/org.jetbrains/annotations 13.0 org/jetbrains/annotations/NotNull#
//                                           ^^^^ reference semanticdb maven . . _root_/
//                                                ^^^^^^^^^^^^ definition local 82
//                                                             documentation ```java\n@NotNull\nunresolved_type stickyHeader\n```
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
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void teardownStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#teardownStickyHeaderView().
//                                     documentation ```java\n@Override\npublic void teardownStickyHeaderView(unresolved_type stickyHeader)\n```
//                                     documentation  Optional callback to perform tear down operation on the\n sticky view, by default it doesn't do anything.\n\n The sub-classes should override the function if they are\n using sticky header feature.\n
//                                      ^^^^^^^ reference semanticdb maven maven/org.jetbrains/annotations 13.0 org/jetbrains/annotations/NotNull#
//                                              ^^^^ reference semanticdb maven . . _root_/
//                                                   ^^^^^^^^^^^^ definition local 83
//                                                                documentation ```java\n@NotNull\nunresolved_type stickyHeader\n```
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
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean isStickyHeader(int position) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyController#isStickyHeader().
//                              documentation ```java\n@Override\npublic boolean isStickyHeader(int position)\n```
//                              documentation  Called to check if the item at the position is a sticky item,\n by default returns false.\n\n The sub-classes should override the function if they are\n using sticky header feature.\n
//                                  ^^^^^^^^ definition local 84
//                                           documentation ```java\nint position\n```
    return false;
  }

  //endregion
}
