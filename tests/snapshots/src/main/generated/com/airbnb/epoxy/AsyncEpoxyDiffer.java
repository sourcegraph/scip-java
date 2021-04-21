package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference android/
//             ^^ reference android/os/
//                ^^^^^^^ reference android/os/Handler#

import java.util.Collections;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^ reference java/util/Collections#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#
import java.util.concurrent.Executor;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^ reference java/util/concurrent/
//                          ^^^^^^^^ reference java/util/concurrent/Executor#

import androidx.annotation.AnyThread;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^ reference androidx/annotation/AnyThread#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#
import androidx.recyclerview.widget.DiffUtil;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^ reference androidx/recyclerview/widget/DiffUtil#
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^ reference androidx/recyclerview/widget/DiffUtil/
//                                           ^^^^^^^^^^^^ reference androidx/recyclerview/widget/DiffUtil/ItemCallback#

/**
 * An adaptation of Google's {@link androidx.recyclerview.widget.AsyncListDiffer}
 * that adds support for payloads in changes.
 * <p>
 * Also adds support for canceling an in progress diff, and makes everything thread safe.
 */
class AsyncEpoxyDiffer {
//    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer# class AsyncEpoxyDiffer

  interface ResultCallback {
//          ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback# interface ResultCallback
    void onResult(@NonNull DiffResult result);
//       ^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#onResult(). public abstract void onResult(DiffResult result)
//                 ^^^^^^^ reference androidx/annotation/NonNull#
//                         ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                                    ^^^^^^ definition local0 @NonNull DiffResult result
  }

  private final Executor executor;
//              ^^^^^^^^ reference java/util/concurrent/Executor#
//                       ^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#executor. private final Executor executor
  private final ResultCallback resultCallback;
//              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
//                             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#resultCallback. private final ResultCallback resultCallback
  private final ItemCallback<EpoxyModel<?>> diffCallback;
//              ^^^^^^^^^^^^ reference _root_/
//                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#diffCallback. private final unresolved_type diffCallback
  private final GenerationTracker generationTracker = new GenerationTracker();
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#
//                                ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker. private final GenerationTracker generationTracker
//                                                        ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#`<init>`().

  AsyncEpoxyDiffer(
//^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#`<init>`(). AsyncEpoxyDiffer(unresolved_type handler, ResultCallback resultCallback, unresolved_type diffCallback)
      @NonNull Handler handler,
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^^^^^^^ reference _root_/
//                     ^^^^^^^ definition local1 @NonNull unresolved_type handler
      @NonNull ResultCallback resultCallback,
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
//                            ^^^^^^^^^^^^^^ definition local2 @NonNull ResultCallback resultCallback
      @NonNull ItemCallback<EpoxyModel<?>> diffCallback
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^^^^^^^^^^^^ reference _root_/
//                          ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                         ^^^^^^^^^^^^ definition local3 @NonNull unresolved_type diffCallback
  ) {
    this.executor = new HandlerExecutor(handler);
//       ^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#executor.
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HandlerExecutor#`<init>`().
//                                      ^^^^^^^ reference local1
    this.resultCallback = resultCallback;
//       ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#resultCallback.
//                        ^^^^^^^^^^^^^^ reference local2
    this.diffCallback = diffCallback;
//       ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#diffCallback.
//                      ^^^^^^^^^^^^ reference local3
  }

  @Nullable
// ^^^^^^^^ reference androidx/annotation/Nullable#
  private volatile List<? extends EpoxyModel<?>> list;
//                 ^^^^ reference java/util/List#
//                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#list. @Nullable private List<? extends EpoxyModel<?>> list

  /**
   * Non-null, unmodifiable version of list.
   * <p>
   * Collections.emptyList when list is null, wrapped by Collections.unmodifiableList otherwise
   */
  @NonNull
// ^^^^^^^ reference androidx/annotation/NonNull#
  private volatile List<? extends EpoxyModel<?>> readOnlyList = Collections.emptyList();
//                 ^^^^ reference java/util/List#
//                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#readOnlyList. @NonNull private List<? extends EpoxyModel<?>> readOnlyList
//                                                              ^^^^^^^^^^^ reference java/util/Collections#
//                                                                          ^^^^^^^^^ reference java/util/Collections#emptyList().

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
// ^^^^^^^^^ reference androidx/annotation/AnyThread#
  @NonNull
// ^^^^^^^ reference androidx/annotation/NonNull#
  public List<? extends EpoxyModel<?>> getCurrentList() {
//       ^^^^ reference java/util/List#
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                     ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#getCurrentList(). @AnyThread @NonNull public List<? extends EpoxyModel<?>> getCurrentList()
    return readOnlyList;
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#readOnlyList.
  }

  /**
   * Prevents any ongoing diff from dispatching results. Returns true if there was an ongoing
   * diff to cancel, false otherwise.
   */
  @SuppressWarnings("WeakerAccess")
// ^^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
  @AnyThread
// ^^^^^^^^^ reference androidx/annotation/AnyThread#
  public boolean cancelDiff() {
//               ^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#cancelDiff(). @SuppressWarnings("WeakerAccess") @AnyThread public boolean cancelDiff()
    return generationTracker.finishMaxGeneration();
//         ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                           ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishMaxGeneration().
  }

  /**
   * @return True if a diff operation is in progress.
   */
  @SuppressWarnings("WeakerAccess")
// ^^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
  @AnyThread
// ^^^^^^^^^ reference androidx/annotation/AnyThread#
  public boolean isDiffInProgress() {
//               ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#isDiffInProgress(). @SuppressWarnings("WeakerAccess") @AnyThread public boolean isDiffInProgress()
    return generationTracker.hasUnfinishedGeneration();
//         ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                           ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#hasUnfinishedGeneration().
  }

  /**
   * Set the current list without performing any diffing. Cancels any diff in progress.
   * <p>
   * This can be used if you notified a change to the adapter manually and need this list to be
   * synced.
   */
  @AnyThread
// ^^^^^^^^^ reference androidx/annotation/AnyThread#
  public synchronized boolean forceListOverride(@Nullable List<EpoxyModel<?>> newList) {
//                            ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#forceListOverride(). @AnyThread public boolean forceListOverride(List<EpoxyModel<?>> newList)
//                                               ^^^^^^^^ reference androidx/annotation/Nullable#
//                                                        ^^^^ reference java/util/List#
//                                                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                            ^^^^^^^ definition local4 @Nullable List<EpoxyModel<?>> newList
    // We need to make sure that generation changes and list updates are synchronized
    final boolean interruptedDiff = cancelDiff();
//                ^^^^^^^^^^^^^^^ definition local5 final boolean interruptedDiff
//                                  ^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#cancelDiff().
    int generation = generationTracker.incrementAndGetNextScheduled();
//      ^^^^^^^^^^ definition local6 int generation
//                   ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#incrementAndGetNextScheduled().
    tryLatchList(newList, generation);
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#tryLatchList().
//               ^^^^^^^ reference local4
//                        ^^^^^^^^^^ reference local6
    return interruptedDiff;
//         ^^^^^^^^^^^^^^^ reference local5
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
// ^^^^^^^^^ reference androidx/annotation/AnyThread#
  @SuppressWarnings("WeakerAccess")
// ^^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
  public void submitList(@Nullable final List<? extends EpoxyModel<?>> newList) {
//            ^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#submitList(). @AnyThread @SuppressWarnings("WeakerAccess") public void submitList(List<? extends EpoxyModel<?>> newList)
//                        ^^^^^^^^ reference androidx/annotation/Nullable#
//                                       ^^^^ reference java/util/List#
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                     ^^^^^^^ definition local7 @Nullable final List<? extends EpoxyModel<?>> newList
    final int runGeneration;
//            ^^^^^^^^^^^^^ definition local8 final int runGeneration
    @Nullable final List<? extends EpoxyModel<?>> previousList;
//   ^^^^^^^^ reference androidx/annotation/Nullable#
//                  ^^^^ reference java/util/List#
//                                 ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                ^^^^^^^^^^^^ definition local9 @Nullable final List<? extends EpoxyModel<?>> previousList

    synchronized (this) {
      // Incrementing generation means any currently-running diffs are discarded when they finish
      // We synchronize to guarantee list object and generation number are in sync
      runGeneration = generationTracker.incrementAndGetNextScheduled();
//    ^^^^^^^^^^^^^ reference local8
//                    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#incrementAndGetNextScheduled().
      previousList = list;
//    ^^^^^^^^^^^^ reference local9
//                   ^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#list.
    }

    if (newList == previousList) {
//      ^^^^^^^ reference local7
//                 ^^^^^^^^^^^^ reference local9
      // nothing to do
      onRunCompleted(runGeneration, newList, DiffResult.noOp(previousList));
//    ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
//                   ^^^^^^^^^^^^^ reference local8
//                                  ^^^^^^^ reference local7
//                                           ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                                                      ^^^^ reference com/airbnb/epoxy/DiffResult#noOp().
//                                                           ^^^^^^^^^^^^ reference local9
      return;
    }

    if (newList == null || newList.isEmpty()) {
//      ^^^^^^^ reference local7
//                         ^^^^^^^ reference local7
//                                 ^^^^^^^ reference java/util/List#isEmpty().
      // fast simple clear all
      DiffResult result = null;
//    ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//               ^^^^^^ definition local10 DiffResult result
      if (previousList != null && !previousList.isEmpty()) {
//        ^^^^^^^^^^^^ reference local9
//                                 ^^^^^^^^^^^^ reference local9
//                                              ^^^^^^^ reference java/util/List#isEmpty().
        result = DiffResult.clear(previousList);
//      ^^^^^^ reference local10
//               ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                          ^^^^^ reference com/airbnb/epoxy/DiffResult#clear().
//                                ^^^^^^^^^^^^ reference local9
      }
      onRunCompleted(runGeneration, null, result);
//    ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
//                   ^^^^^^^^^^^^^ reference local8
//                                        ^^^^^^ reference local10
      return;
    }

    if (previousList == null || previousList.isEmpty()) {
//      ^^^^^^^^^^^^ reference local9
//                              ^^^^^^^^^^^^ reference local9
//                                           ^^^^^^^ reference java/util/List#isEmpty().
      // fast simple first insert
      onRunCompleted(runGeneration, newList, DiffResult.inserted(newList));
//    ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
//                   ^^^^^^^^^^^^^ reference local8
//                                  ^^^^^^^ reference local7
//                                           ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                                                      ^^^^^^^^ reference com/airbnb/epoxy/DiffResult#inserted().
//                                                               ^^^^^^^ reference local7
      return;
    }

    final DiffCallback wrappedCallback = new DiffCallback(previousList, newList, diffCallback);
//        ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#
//                     ^^^^^^^^^^^^^^^ definition local11 final DiffCallback wrappedCallback
//                                           ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#`<init>`().
//                                                        ^^^^^^^^^^^^ reference local9
//                                                                      ^^^^^^^ reference local7
//                                                                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#diffCallback.

    executor.execute(new Runnable() {
//  ^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#executor.
//           ^^^^^^^ reference java/util/concurrent/Executor#execute().
//                       ^^^^^^^^ reference java/lang/Runnable#
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void run() {
//                ^^^ definition local14 @Override public void run()
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(wrappedCallback);
//      ^^^^^^^^ reference DiffUtil/
//               ^^^^^^^^^^ reference DiffUtil/DiffResult#
//                          ^^^^^^ definition local15 unresolved_type result
//                                   ^^^^^^^^ reference _root_/
//                                            ^^^^^^^^^^^^^ reference calculateDiff#
//                                                          ^^^^^^^^^^^^^^^ reference local11
        onRunCompleted(runGeneration, newList, DiffResult.diff(previousList, newList, result));
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
//                     ^^^^^^^^^^^^^ reference local8
//                                    ^^^^^^^ reference local7
//                                             ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                                                        ^^^^ reference com/airbnb/epoxy/DiffResult#diff().
//                                                             ^^^^^^^^^^^^ reference local9
//                                                                           ^^^^^^^ reference local7
//                                                                                    ^^^^^^ reference local15
      }
    });
  }

  private void onRunCompleted(
//             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted(). private void onRunCompleted(int runGeneration, List<? extends EpoxyModel<?>> newList, DiffResult result)
      final int runGeneration,
//              ^^^^^^^^^^^^^ definition local16 final int runGeneration
      @Nullable final List<? extends EpoxyModel<?>> newList,
//     ^^^^^^^^ reference androidx/annotation/Nullable#
//                    ^^^^ reference java/util/List#
//                                   ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^^ definition local17 @Nullable final List<? extends EpoxyModel<?>> newList
      @Nullable final DiffResult result
//     ^^^^^^^^ reference androidx/annotation/Nullable#
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                               ^^^^^^ definition local18 @Nullable final DiffResult result
  ) {

    // We use an asynchronous handler so that the Runnable can be posted directly back to the main
    // thread without waiting on view invalidation synchronization.
    MainThreadExecutor.ASYNC_INSTANCE.execute(new Runnable() {
//  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#
//                     ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/MainThreadExecutor#ASYNC_INSTANCE.
//                                    ^^^^^^^ reference com/airbnb/epoxy/HandlerExecutor#execute().
//                                                ^^^^^^^^ reference java/lang/Runnable#
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void run() {
//                ^^^ definition local21 @Override public void run()
        final boolean dispatchResult = tryLatchList(newList, runGeneration);
//                    ^^^^^^^^^^^^^^ definition local22 final boolean dispatchResult
//                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#tryLatchList().
//                                                  ^^^^^^^ reference local17
//                                                           ^^^^^^^^^^^^^ reference local16
        if (result != null && dispatchResult) {
//          ^^^^^^ reference local18
//                            ^^^^^^^^^^^^^^ reference local22
          resultCallback.onResult(result);
//        ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#resultCallback.
//                       ^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#onResult().
//                                ^^^^^^ reference local18
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
// ^^^^^^^^^ reference androidx/annotation/AnyThread#
  private synchronized boolean tryLatchList(@Nullable List<? extends EpoxyModel<?>> newList,
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#tryLatchList(). @AnyThread private boolean tryLatchList(List<? extends EpoxyModel<?>> newList, int runGeneration)
//                                           ^^^^^^^^ reference androidx/annotation/Nullable#
//                                                    ^^^^ reference java/util/List#
//                                                                   ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                  ^^^^^^^ definition local23 @Nullable List<? extends EpoxyModel<?>> newList
      int runGeneration) {
//        ^^^^^^^^^^^^^ definition local24 int runGeneration
    if (generationTracker.finishGeneration(runGeneration)) {
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishGeneration().
//                                         ^^^^^^^^^^^^^ reference local24
      list = newList;
//    ^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#list.
//           ^^^^^^^ reference local23

      if (newList == null) {
//        ^^^^^^^ reference local23
        readOnlyList = Collections.emptyList();
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#readOnlyList.
//                     ^^^^^^^^^^^ reference java/util/Collections#
//                                 ^^^^^^^^^ reference java/util/Collections#emptyList().
      } else {
        readOnlyList = Collections.unmodifiableList(newList);
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#readOnlyList.
//                     ^^^^^^^^^^^ reference java/util/Collections#
//                                 ^^^^^^^^^^^^^^^^ reference java/util/Collections#unmodifiableList().
//                                                  ^^^^^^^ reference local23
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
//                     ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker# private static class GenerationTracker
//                     ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#`<init>`(). private GenerationTracker()

    // Max generation of currently scheduled runnable
    private volatile int maxScheduledGeneration;
//                       ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration. private int maxScheduledGeneration
    private volatile int maxFinishedGeneration;
//                       ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration. private int maxFinishedGeneration

    synchronized int incrementAndGetNextScheduled() {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#incrementAndGetNextScheduled(). int incrementAndGetNextScheduled()
      return ++maxScheduledGeneration;
//             ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
    }

    synchronized boolean finishMaxGeneration() {
//                       ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishMaxGeneration(). boolean finishMaxGeneration()
      boolean isInterrupting = hasUnfinishedGeneration();
//            ^^^^^^^^^^^^^^ definition local25 boolean isInterrupting
//                             ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#hasUnfinishedGeneration().
      maxFinishedGeneration = maxScheduledGeneration;
//    ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.
//                            ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
      return isInterrupting;
//           ^^^^^^^^^^^^^^ reference local25
    }

    synchronized boolean hasUnfinishedGeneration() {
//                       ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#hasUnfinishedGeneration(). boolean hasUnfinishedGeneration()
      return maxScheduledGeneration > maxFinishedGeneration;
//           ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.
    }

    synchronized boolean finishGeneration(int runGeneration) {
//                       ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishGeneration(). boolean finishGeneration(int runGeneration)
//                                            ^^^^^^^^^^^^^ definition local26 int runGeneration
      boolean isLatestGeneration =
//            ^^^^^^^^^^^^^^^^^^ definition local27 boolean isLatestGeneration
          maxScheduledGeneration == runGeneration && runGeneration > maxFinishedGeneration;
//        ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
//                                  ^^^^^^^^^^^^^ reference local26
//                                                   ^^^^^^^^^^^^^ reference local26
//                                                                   ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.

      if (isLatestGeneration) {
//        ^^^^^^^^^^^^^^^^^^ reference local27
        maxFinishedGeneration = runGeneration;
//      ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.
//                              ^^^^^^^^^^^^^ reference local26
      }

      return isLatestGeneration;
//           ^^^^^^^^^^^^^^^^^^ reference local27
    }
  }

  private static class DiffCallback extends DiffUtil.Callback {
//                     ^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback# private static class DiffCallback extends unresolved_type
//                                          ^^^^^^^^ reference DiffUtil/
//                                                   ^^^^^^^^ reference DiffUtil/Callback#

    final List<? extends EpoxyModel<?>> oldList;
//        ^^^^ reference java/util/List#
//                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList. final List<? extends EpoxyModel<?>> oldList
    final List<? extends EpoxyModel<?>> newList;
//        ^^^^ reference java/util/List#
//                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList. final List<? extends EpoxyModel<?>> newList
    private final ItemCallback<EpoxyModel<?>> diffCallback;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                            ^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback. private final unresolved_type diffCallback

    DiffCallback(List<? extends EpoxyModel<?>> oldList, List<? extends EpoxyModel<?>> newList,
//  ^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#`<init>`(). DiffCallback(List<? extends EpoxyModel<?>> oldList, List<? extends EpoxyModel<?>> newList, unresolved_type diffCallback)
//               ^^^^ reference java/util/List#
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^^^ definition local28 List<? extends EpoxyModel<?>> oldList
//                                                      ^^^^ reference java/util/List#
//                                                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                    ^^^^^^^ definition local29 List<? extends EpoxyModel<?>> newList
        ItemCallback<EpoxyModel<?>> diffCallback) {
//      ^^^^^^^^^^^^ reference _root_/
//                   ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^^^^^^^ definition local30 unresolved_type diffCallback
      this.oldList = oldList;
//         ^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                   ^^^^^^^ reference local28
      this.newList = newList;
//         ^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                   ^^^^^^^ reference local29
      this.diffCallback = diffCallback;
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                        ^^^^^^^^^^^^ reference local30
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public int getOldListSize() {
//             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#getOldListSize(). @Override public int getOldListSize()
      return oldList.size();
//           ^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                   ^^^^ reference java/util/List#size().
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public int getNewListSize() {
//             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#getNewListSize(). @Override public int getNewListSize()
      return newList.size();
//           ^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                   ^^^^ reference java/util/List#size().
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
//                 ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#areItemsTheSame(). @Override public boolean areItemsTheSame(int oldItemPosition, int newItemPosition)
//                                     ^^^^^^^^^^^^^^^ definition local31 int oldItemPosition
//                                                          ^^^^^^^^^^^^^^^ definition local32 int newItemPosition
      return diffCallback.areItemsTheSame(
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                        ^^^^^^^^^^^^^^^ reference `<any>`#areItemsTheSame#
          oldList.get(oldItemPosition),
//        ^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                ^^^ reference java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local31
          newList.get(newItemPosition)
//        ^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                ^^^ reference java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local32
      );
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
//                 ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#areContentsTheSame(). @Override public boolean areContentsTheSame(int oldItemPosition, int newItemPosition)
//                                        ^^^^^^^^^^^^^^^ definition local33 int oldItemPosition
//                                                             ^^^^^^^^^^^^^^^ definition local34 int newItemPosition
      return diffCallback.areContentsTheSame(
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                        ^^^^^^^^^^^^^^^^^^ reference `<any>`#areContentsTheSame#
          oldList.get(oldItemPosition),
//        ^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                ^^^ reference java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local33
          newList.get(newItemPosition)
//        ^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                ^^^ reference java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local34
      );
    }

    @Nullable
//   ^^^^^^^^ reference androidx/annotation/Nullable#
    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
//         ^^^^^^ reference java/lang/Object#
//                ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#getChangePayload(). @Nullable @Override public Object getChangePayload(int oldItemPosition, int newItemPosition)
//                                     ^^^^^^^^^^^^^^^ definition local35 int oldItemPosition
//                                                          ^^^^^^^^^^^^^^^ definition local36 int newItemPosition
      return diffCallback.getChangePayload(
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                        ^^^^^^^^^^^^^^^^ reference `<any>`#getChangePayload#
          oldList.get(oldItemPosition),
//        ^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                ^^^ reference java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local35
          newList.get(newItemPosition)
//        ^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                ^^^ reference java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local36
      );
    }
  }
}
