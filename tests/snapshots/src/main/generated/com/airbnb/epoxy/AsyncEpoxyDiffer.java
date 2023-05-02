package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^ reference semanticdb maven . . android/os/Handler#

import java.util.Collections;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#
import java.util.concurrent.Executor;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven . . java/util/concurrent/
//                          ^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/Executor#

import androidx.annotation.AnyThread;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/AnyThread#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.recyclerview.widget.DiffUtil;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/DiffUtil#
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/DiffUtil/
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/DiffUtil/ItemCallback#

/**
 * An adaptation of Google's {@link androidx.recyclerview.widget.AsyncListDiffer}
 * that adds support for payloads in changes.
 * <p>
 * Also adds support for canceling an in progress diff, and makes everything thread safe.
 */
class AsyncEpoxyDiffer {
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#
//                     documentation ```java\nclass AsyncEpoxyDiffer\n```
//                     documentation  An adaptation of Google's {@link androidx.recyclerview.widget.AsyncListDiffer}\n that adds support for payloads in changes.\n <p>\n Also adds support for canceling an in progress diff, and makes everything thread safe.\n

  interface ResultCallback {
//          ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
//                         documentation ```java\ninterface ResultCallback\n```
    void onResult(@NonNull DiffResult result);
//       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#onResult().
//                documentation ```java\npublic abstract void onResult(DiffResult result)\n```
//                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onResult().
//                 ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                                    ^^^^^^ definition local 0
//                                           documentation ```java\n@NonNull\nDiffResult result\n```
  }

  private final Executor executor;
//              ^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/Executor#
//                       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#executor.
//                                documentation ```java\nprivate final Executor executor\n```
  private final ResultCallback resultCallback;
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
//                             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#resultCallback.
//                                            documentation ```java\nprivate final ResultCallback resultCallback\n```
  private final ItemCallback<EpoxyModel<?>> diffCallback;
//              ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#diffCallback.
//                                                       documentation ```java\nprivate final unresolved_type diffCallback\n```
  private final GenerationTracker generationTracker = new GenerationTracker();
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#
//                                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                                                  documentation ```java\nprivate final GenerationTracker generationTracker\n```
//                                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#`<init>`().

  AsyncEpoxyDiffer(
//^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#`<init>`().
//                 documentation ```java\nAsyncEpoxyDiffer(unresolved_type handler, ResultCallback resultCallback, unresolved_type diffCallback)\n```
      @NonNull Handler handler,
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^^^^ reference semanticdb maven . . _root_/
//                     ^^^^^^^ definition local 1
//                             documentation ```java\n@NonNull\nunresolved_type handler\n```
      @NonNull ResultCallback resultCallback,
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
//                            ^^^^^^^^^^^^^^ definition local 2
//                                           documentation ```java\n@NonNull\nResultCallback resultCallback\n```
      @NonNull ItemCallback<EpoxyModel<?>> diffCallback
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                         ^^^^^^^^^^^^ definition local 3
//                                                      documentation ```java\n@NonNull\nunresolved_type diffCallback\n```
  ) {
    this.executor = new HandlerExecutor(handler);
//       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#executor.
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#`<init>`().
//                                      ^^^^^^^ reference local 1
    this.resultCallback = resultCallback;
//       ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#resultCallback.
//                        ^^^^^^^^^^^^^^ reference local 2
    this.diffCallback = diffCallback;
//       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#diffCallback.
//                      ^^^^^^^^^^^^ reference local 3
  }

  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  private volatile List<? extends EpoxyModel<?>> list;
//                 ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#list.
//                                                    documentation ```java\n@Nullable\nprivate List<? extends EpoxyModel<?>> list\n```

  /**
   * Non-null, unmodifiable version of list.
   * <p>
   * Collections.emptyList when list is null, wrapped by Collections.unmodifiableList otherwise
   */
  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  private volatile List<? extends EpoxyModel<?>> readOnlyList = Collections.emptyList();
//                 ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#readOnlyList.
//                                                            documentation ```java\n@NonNull\nprivate List<? extends EpoxyModel<?>> readOnlyList\n```
//                                                            documentation  Non-null, unmodifiable version of list.\n <p>\n Collections.emptyList when list is null, wrapped by Collections.unmodifiableList otherwise\n
//                                                              ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                                                          ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#emptyList().

  /**
   * Get the current List - any diffing to present this list has already been computed and
   * dispatched via the ListUpdateCallback.
   * <p>
   * If a <code>null</code> List, or no List has been submitted, an empty list will be returned.
   * <p>
   * The returned list may not be mutated - mutations to content must be done through
   * {@link #submitList(List)}.
   *
   * @return current List.
   */
  @AnyThread
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/AnyThread#
  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public List<? extends EpoxyModel<?>> getCurrentList() {
//       ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                     ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#getCurrentList().
//                                                    documentation ```java\n@AnyThread\n@NonNull\npublic List<? extends EpoxyModel<?>> getCurrentList()\n```
//                                                    documentation  Get the current List - any diffing to present this list has already been computed and\n dispatched via the ListUpdateCallback.\n <p>\n If a <code>null</code> List, or no List has been submitted, an empty list will be returned.\n <p>\n The returned list may not be mutated - mutations to content must be done through\n {@link #submitList(List)}.\n\n @return current List.\n
    return readOnlyList;
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#readOnlyList.
  }

  /**
   * Prevents any ongoing diff from dispatching results. Returns true if there was an ongoing
   * diff to cancel, false otherwise.
   */
  @SuppressWarnings("WeakerAccess")
// ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
  @AnyThread
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/AnyThread#
  public boolean cancelDiff() {
//               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#cancelDiff().
//                          documentation ```java\n@SuppressWarnings("WeakerAccess")\n@AnyThread\npublic boolean cancelDiff()\n```
//                          documentation  Prevents any ongoing diff from dispatching results. Returns true if there was an ongoing\n diff to cancel, false otherwise.\n
    return generationTracker.finishMaxGeneration();
//         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishMaxGeneration().
  }

  /**
   * @return True if a diff operation is in progress.
   */
  @SuppressWarnings("WeakerAccess")
// ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
  @AnyThread
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/AnyThread#
  public boolean isDiffInProgress() {
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#isDiffInProgress().
//                                documentation ```java\n@SuppressWarnings("WeakerAccess")\n@AnyThread\npublic boolean isDiffInProgress()\n```
//                                documentation  @return True if a diff operation is in progress.\n
    return generationTracker.hasUnfinishedGeneration();
//         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                           ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#hasUnfinishedGeneration().
  }

  /**
   * Set the current list without performing any diffing. Cancels any diff in progress.
   * <p>
   * This can be used if you notified a change to the adapter manually and need this list to be
   * synced.
   */
  @AnyThread
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/AnyThread#
  public synchronized boolean forceListOverride(@Nullable List<EpoxyModel<?>> newList) {
//                            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#forceListOverride().
//                                              documentation ```java\n@AnyThread\npublic boolean forceListOverride(List<EpoxyModel<?>> newList)\n```
//                                              documentation  Set the current list without performing any diffing. Cancels any diff in progress.\n <p>\n This can be used if you notified a change to the adapter manually and need this list to be\n synced.\n
//                                               ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                        ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                            ^^^^^^^ definition local 4
//                                                                                    documentation ```java\n@Nullable\nList<EpoxyModel<?>> newList\n```
    // We need to make sure that generation changes and list updates are synchronized
    final boolean interruptedDiff = cancelDiff();
//                ^^^^^^^^^^^^^^^ definition local 5
//                                documentation ```java\nfinal boolean interruptedDiff\n```
//                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#cancelDiff().
    int generation = generationTracker.incrementAndGetNextScheduled();
//      ^^^^^^^^^^ definition local 6
//                 documentation ```java\nint generation\n```
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#incrementAndGetNextScheduled().
    tryLatchList(newList, generation);
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#tryLatchList().
//               ^^^^^^^ reference local 4
//                        ^^^^^^^^^^ reference local 6
    return interruptedDiff;
//         ^^^^^^^^^^^^^^^ reference local 5
  }

  /**
   * Set a new List representing your latest data.
   * <p>
   * A diff will be computed between this list and the last list set. If this has not previously
   * been called then an empty list is used as the previous list.
   * <p>
   * The diff computation will be done on the thread given by the handler in the constructor.
   * When the diff is done it will be applied (dispatched to the result callback),
   * and the new List will be swapped in.
   */
  @AnyThread
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/AnyThread#
  @SuppressWarnings("WeakerAccess")
// ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
  public void submitList(@Nullable final List<? extends EpoxyModel<?>> newList) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#submitList().
//                       documentation ```java\n@AnyThread\n@SuppressWarnings("WeakerAccess")\npublic void submitList(List<? extends EpoxyModel<?>> newList)\n```
//                       documentation  Set a new List representing your latest data.\n <p>\n A diff will be computed between this list and the last list set. If this has not previously\n been called then an empty list is used as the previous list.\n <p>\n The diff computation will be done on the thread given by the handler in the constructor.\n When the diff is done it will be applied (dispatched to the result callback),\n and the new List will be swapped in.\n
//                        ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                       ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                     ^^^^^^^ definition local 7
//                                                                             documentation ```java\n@Nullable\nfinal List<? extends EpoxyModel<?>> newList\n```
    final int runGeneration;
//            ^^^^^^^^^^^^^ definition local 8
//                          documentation ```java\nfinal int runGeneration\n```
    @Nullable final List<? extends EpoxyModel<?>> previousList;
//   ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                ^^^^^^^^^^^^ definition local 9
//                                                             documentation ```java\n@Nullable\nfinal List<? extends EpoxyModel<?>> previousList\n```

    synchronized (this) {
      // Incrementing generation means any currently-running diffs are discarded when they finish
      // We synchronize to guarantee list object and generation number are in sync
      runGeneration = generationTracker.incrementAndGetNextScheduled();
//    ^^^^^^^^^^^^^ reference local 8
//                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#incrementAndGetNextScheduled().
      previousList = list;
//    ^^^^^^^^^^^^ reference local 9
//                   ^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#list.
    }

    if (newList == previousList) {
//      ^^^^^^^ reference local 7
//                 ^^^^^^^^^^^^ reference local 9
      // nothing to do
      onRunCompleted(runGeneration, newList, DiffResult.noOp(previousList));
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
//                   ^^^^^^^^^^^^^ reference local 8
//                                  ^^^^^^^ reference local 7
//                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                                                      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#noOp().
//                                                           ^^^^^^^^^^^^ reference local 9
      return;
    }

    if (newList == null || newList.isEmpty()) {
//      ^^^^^^^ reference local 7
//                         ^^^^^^^ reference local 7
//                                 ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
      // fast simple clear all
      DiffResult result = null;
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//               ^^^^^^ definition local 10
//                      documentation ```java\nDiffResult result\n```
      if (previousList != null && !previousList.isEmpty()) {
//        ^^^^^^^^^^^^ reference local 9
//                                 ^^^^^^^^^^^^ reference local 9
//                                              ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
        result = DiffResult.clear(previousList);
//      ^^^^^^ reference local 10
//               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#clear().
//                                ^^^^^^^^^^^^ reference local 9
      }
      onRunCompleted(runGeneration, null, result);
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
//                   ^^^^^^^^^^^^^ reference local 8
//                                        ^^^^^^ reference local 10
      return;
    }

    if (previousList == null || previousList.isEmpty()) {
//      ^^^^^^^^^^^^ reference local 9
//                              ^^^^^^^^^^^^ reference local 9
//                                           ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
      // fast simple first insert
      onRunCompleted(runGeneration, newList, DiffResult.inserted(newList));
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
//                   ^^^^^^^^^^^^^ reference local 8
//                                  ^^^^^^^ reference local 7
//                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                                                      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#inserted().
//                                                               ^^^^^^^ reference local 7
      return;
    }

    final DiffCallback wrappedCallback = new DiffCallback(previousList, newList, diffCallback);
//        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#
//                     ^^^^^^^^^^^^^^^ definition local 11
//                                     documentation ```java\nfinal DiffCallback wrappedCallback\n```
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#`<init>`().
//                                                        ^^^^^^^^^^^^ reference local 9
//                                                                      ^^^^^^^ reference local 7
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#diffCallback.

    executor.execute(new Runnable() {
//  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#executor.
//           ^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/Executor#execute().
//                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Runnable#
      @Override
//     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
      public void run() {
//                ^^^ definition local 14
//                    documentation ```java\n@Override\npublic void run()\n```
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Runnable#run().
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(wrappedCallback);
//      ^^^^^^^^ reference semanticdb maven . . DiffUtil/
//               ^^^^^^^^^^ reference semanticdb maven . . DiffUtil/DiffResult#
//                          ^^^^^^ definition local 15
//                                 documentation ```java\nunresolved_type result\n```
//                                   ^^^^^^^^ reference semanticdb maven . . _root_/
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . calculateDiff#
//                                                          ^^^^^^^^^^^^^^^ reference local 11
        onRunCompleted(runGeneration, newList, DiffResult.diff(previousList, newList, result));
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
//                     ^^^^^^^^^^^^^ reference local 8
//                                    ^^^^^^^ reference local 7
//                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                                                        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#diff().
//                                                             ^^^^^^^^^^^^ reference local 9
//                                                                           ^^^^^^^ reference local 7
//                                                                                    ^^^^^^ reference local 15
      }
    });
  }

  private void onRunCompleted(
//             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
//                            documentation ```java\nprivate void onRunCompleted(int runGeneration, List<? extends EpoxyModel<?>> newList, DiffResult result)\n```
      final int runGeneration,
//              ^^^^^^^^^^^^^ definition local 16
//                            documentation ```java\nfinal int runGeneration\n```
      @Nullable final List<? extends EpoxyModel<?>> newList,
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                    ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^^ definition local 17
//                                                          documentation ```java\n@Nullable\nfinal List<? extends EpoxyModel<?>> newList\n```
      @Nullable final DiffResult result
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                               ^^^^^^ definition local 18
//                                      documentation ```java\n@Nullable\nfinal DiffResult result\n```
  ) {

    // We use an asynchronous handler so that the Runnable can be posted directly back to the main
    // thread without waiting on view invalidation synchronization.
    MainThreadExecutor.ASYNC_INSTANCE.execute(new Runnable() {
//  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/MainThreadExecutor#ASYNC_INSTANCE.
//                                    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HandlerExecutor#execute().
//                                                ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Runnable#
      @Override
//     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
      public void run() {
//                ^^^ definition local 21
//                    documentation ```java\n@Override\npublic void run()\n```
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Runnable#run().
        final boolean dispatchResult = tryLatchList(newList, runGeneration);
//                    ^^^^^^^^^^^^^^ definition local 22
//                                   documentation ```java\nfinal boolean dispatchResult\n```
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#tryLatchList().
//                                                  ^^^^^^^ reference local 17
//                                                           ^^^^^^^^^^^^^ reference local 16
        if (result != null && dispatchResult) {
//          ^^^^^^ reference local 18
//                            ^^^^^^^^^^^^^^ reference local 22
          resultCallback.onResult(result);
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#resultCallback.
//                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#onResult().
//                                ^^^^^^ reference local 18
        }
      }
    });
  }

  /**
   * Marks the generation as done, and updates the list if the generation is the most recent.
   *
   * @return True if the given generation is the most recent, in which case the given list was
   * set. False if the generation is old and the list was ignored.
   */
  @AnyThread
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/AnyThread#
  private synchronized boolean tryLatchList(@Nullable List<? extends EpoxyModel<?>> newList,
//                             ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#tryLatchList().
//                                          documentation ```java\n@AnyThread\nprivate boolean tryLatchList(List<? extends EpoxyModel<?>> newList, int runGeneration)\n```
//                                          documentation  Marks the generation as done, and updates the list if the generation is the most recent.\n\n @return True if the given generation is the most recent, in which case the given list was\n set. False if the generation is old and the list was ignored.\n
//                                           ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                    ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                  ^^^^^^^ definition local 23
//                                                                                          documentation ```java\n@Nullable\nList<? extends EpoxyModel<?>> newList\n```
      int runGeneration) {
//        ^^^^^^^^^^^^^ definition local 24
//                      documentation ```java\nint runGeneration\n```
    if (generationTracker.finishGeneration(runGeneration)) {
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishGeneration().
//                                         ^^^^^^^^^^^^^ reference local 24
      list = newList;
//    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#list.
//           ^^^^^^^ reference local 23

      if (newList == null) {
//        ^^^^^^^ reference local 23
        readOnlyList = Collections.emptyList();
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#readOnlyList.
//                     ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                 ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#emptyList().
      } else {
        readOnlyList = Collections.unmodifiableList(newList);
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#readOnlyList.
//                     ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#unmodifiableList().
//                                                  ^^^^^^^ reference local 23
      }

      return true;
    }

    return false;
  }

  /**
   * The concept of a "generation" is used to associate a diff result with a point in time when
   * it was created. This allows us to handle list updates concurrently, and ignore outdated diffs.
   * <p>
   * We track the highest start generation, and the highest finished generation, and these must
   * be kept in sync, so all access to this class is synchronized.
   * <p>
   * The general synchronization strategy for this class is that when a generation number
   * is queried that action must be synchronized with accessing the current list, so that the
   * generation number is synced with the list state at the time it was created.
   */
  private static class GenerationTracker {
//                     ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#
//                                       documentation ```java\nprivate static class GenerationTracker\n```
//                                       documentation  The concept of a "generation" is used to associate a diff result with a point in time when\n it was created. This allows us to handle list updates concurrently, and ignore outdated diffs.\n <p>\n We track the highest start generation, and the highest finished generation, and these must\n be kept in sync, so all access to this class is synchronized.\n <p>\n The general synchronization strategy for this class is that when a generation number\n is queried that action must be synchronized with accessing the current list, so that the\n generation number is synced with the list state at the time it was created.\n
//                     ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#`<init>`().
//                                       documentation ```java\nprivate GenerationTracker()\n```

    // Max generation of currently scheduled runnable
    private volatile int maxScheduledGeneration;
//                       ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
//                                              documentation ```java\nprivate int maxScheduledGeneration\n```
    private volatile int maxFinishedGeneration;
//                       ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.
//                                             documentation ```java\nprivate int maxFinishedGeneration\n```

    synchronized int incrementAndGetNextScheduled() {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#incrementAndGetNextScheduled().
//                                                documentation ```java\nint incrementAndGetNextScheduled()\n```
      return ++maxScheduledGeneration;
//             ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
    }

    synchronized boolean finishMaxGeneration() {
//                       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishMaxGeneration().
//                                           documentation ```java\nboolean finishMaxGeneration()\n```
      boolean isInterrupting = hasUnfinishedGeneration();
//            ^^^^^^^^^^^^^^ definition local 25
//                           documentation ```java\nboolean isInterrupting\n```
//                             ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#hasUnfinishedGeneration().
      maxFinishedGeneration = maxScheduledGeneration;
//    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.
//                            ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
      return isInterrupting;
//           ^^^^^^^^^^^^^^ reference local 25
    }

    synchronized boolean hasUnfinishedGeneration() {
//                       ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#hasUnfinishedGeneration().
//                                               documentation ```java\nboolean hasUnfinishedGeneration()\n```
      return maxScheduledGeneration > maxFinishedGeneration;
//           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.
    }

    synchronized boolean finishGeneration(int runGeneration) {
//                       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishGeneration().
//                                        documentation ```java\nboolean finishGeneration(int runGeneration)\n```
//                                            ^^^^^^^^^^^^^ definition local 26
//                                                          documentation ```java\nint runGeneration\n```
      boolean isLatestGeneration =
//            ^^^^^^^^^^^^^^^^^^ definition local 27
//                               documentation ```java\nboolean isLatestGeneration\n```
          maxScheduledGeneration == runGeneration && runGeneration > maxFinishedGeneration;
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
//                                  ^^^^^^^^^^^^^ reference local 26
//                                                   ^^^^^^^^^^^^^ reference local 26
//                                                                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.

      if (isLatestGeneration) {
//        ^^^^^^^^^^^^^^^^^^ reference local 27
        maxFinishedGeneration = runGeneration;
//      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.
//                              ^^^^^^^^^^^^^ reference local 26
      }

      return isLatestGeneration;
//           ^^^^^^^^^^^^^^^^^^ reference local 27
    }
  }

  private static class DiffCallback extends DiffUtil.Callback {
//                     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#
//                                  documentation ```java\nprivate static class DiffCallback\n```
//                                  relationship is_implementation semanticdb maven . . DiffUtil/Callback#
//                                          ^^^^^^^^ reference semanticdb maven . . DiffUtil/
//                                                   ^^^^^^^^ reference semanticdb maven . . DiffUtil/Callback#

    final List<? extends EpoxyModel<?>> oldList;
//        ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                                              documentation ```java\nfinal List<? extends EpoxyModel<?>> oldList\n```
    final List<? extends EpoxyModel<?>> newList;
//        ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                                              documentation ```java\nfinal List<? extends EpoxyModel<?>> newList\n```
    private final ItemCallback<EpoxyModel<?>> diffCallback;
//                ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                            ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                                                         documentation ```java\nprivate final unresolved_type diffCallback\n```

    DiffCallback(List<? extends EpoxyModel<?>> oldList, List<? extends EpoxyModel<?>> newList,
//  ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#`<init>`().
//               documentation ```java\nDiffCallback(List<? extends EpoxyModel<?>> oldList, List<? extends EpoxyModel<?>> newList, unresolved_type diffCallback)\n```
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^^^ definition local 28
//                                                     documentation ```java\nList<? extends EpoxyModel<?>> oldList\n```
//                                                      ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                    ^^^^^^^ definition local 29
//                                                                                            documentation ```java\nList<? extends EpoxyModel<?>> newList\n```
        ItemCallback<EpoxyModel<?>> diffCallback) {
//      ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^^^^^^^ definition local 30
//                                               documentation ```java\nunresolved_type diffCallback\n```
      this.oldList = oldList;
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                   ^^^^^^^ reference local 28
      this.newList = newList;
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                   ^^^^^^^ reference local 29
      this.diffCallback = diffCallback;
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                        ^^^^^^^^^^^^ reference local 30
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public int getOldListSize() {
//             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#getOldListSize().
//                            documentation ```java\n@Override\npublic int getOldListSize()\n```
      return oldList.size();
//           ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                   ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public int getNewListSize() {
//             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#getNewListSize().
//                            documentation ```java\n@Override\npublic int getNewListSize()\n```
      return newList.size();
//           ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                   ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#areItemsTheSame().
//                                 documentation ```java\n@Override\npublic boolean areItemsTheSame(int oldItemPosition, int newItemPosition)\n```
//                                     ^^^^^^^^^^^^^^^ definition local 31
//                                                     documentation ```java\nint oldItemPosition\n```
//                                                          ^^^^^^^^^^^^^^^ definition local 32
//                                                                          documentation ```java\nint newItemPosition\n```
      return diffCallback.areItemsTheSame(
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . `<any>`#areItemsTheSame#
          oldList.get(oldItemPosition),
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local 31
          newList.get(newItemPosition)
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local 32
      );
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
//                 ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#areContentsTheSame().
//                                    documentation ```java\n@Override\npublic boolean areContentsTheSame(int oldItemPosition, int newItemPosition)\n```
//                                        ^^^^^^^^^^^^^^^ definition local 33
//                                                        documentation ```java\nint oldItemPosition\n```
//                                                             ^^^^^^^^^^^^^^^ definition local 34
//                                                                             documentation ```java\nint newItemPosition\n```
      return diffCallback.areContentsTheSame(
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . `<any>`#areContentsTheSame#
          oldList.get(oldItemPosition),
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local 33
          newList.get(newItemPosition)
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local 34
      );
    }

    @Nullable
//   ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
//         ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#getChangePayload().
//                                 documentation ```java\n@Nullable\n@Override\npublic Object getChangePayload(int oldItemPosition, int newItemPosition)\n```
//                                     ^^^^^^^^^^^^^^^ definition local 35
//                                                     documentation ```java\nint oldItemPosition\n```
//                                                          ^^^^^^^^^^^^^^^ definition local 36
//                                                                          documentation ```java\nint newItemPosition\n```
      return diffCallback.getChangePayload(
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . `<any>`#getChangePayload#
          oldList.get(oldItemPosition),
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local 35
          newList.get(newItemPosition)
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local 36
      );
    }
  }
}
