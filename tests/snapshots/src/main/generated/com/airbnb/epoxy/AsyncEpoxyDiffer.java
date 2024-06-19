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
//                     display_name AsyncEpoxyDiffer
//                     signature_documentation java class AsyncEpoxyDiffer
//                     kind Class
//                     documentation  An adaptation of Google's {@link androidx.recyclerview.widget.AsyncListDiffer}\n that adds support for payloads in changes.\n <p>\n Also adds support for canceling an in progress diff, and makes everything thread safe.\n

  interface ResultCallback {
//          ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
//                         display_name ResultCallback
//                         signature_documentation java interface ResultCallback
//                         kind Interface
    void onResult(@NonNull DiffResult result);
//       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#onResult().
//                display_name onResult
//                signature_documentation java public abstract void onResult(DiffResult result)
//                kind AbstractMethod
//                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onResult().
//                 ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                                    ^^^^^^ definition local 0
//                                           display_name result
//                                           signature_documentation java @NonNull\nDiffResult result
//                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#onResult().
  }

  private final Executor executor;
//              ^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/Executor#
//                       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#executor.
//                                display_name executor
//                                signature_documentation java private final Executor executor
//                                kind Field
  private final ResultCallback resultCallback;
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
//                             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#resultCallback.
//                                            display_name resultCallback
//                                            signature_documentation java private final ResultCallback resultCallback
//                                            kind Field
  private final ItemCallback<EpoxyModel<?>> diffCallback;
//              ^^^^^^^^^^^^ reference semanticdb maven . . ItemCallback#
//                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#diffCallback.
//                                                       display_name diffCallback
//                                                       signature_documentation java private final unresolved_type diffCallback
//                                                       kind Field
  private final GenerationTracker generationTracker = new GenerationTracker();
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#
//                                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                                                  display_name generationTracker
//                                                  signature_documentation java private final GenerationTracker generationTracker
//                                                  kind Field
//                                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#`<init>`().

  AsyncEpoxyDiffer(
//^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#`<init>`().
//                 display_name <init>
//                 signature_documentation java AsyncEpoxyDiffer(unresolved_type handler, ResultCallback resultCallback, unresolved_type diffCallback)
//                 kind Constructor
      @NonNull Handler handler,
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^^^^ reference semanticdb maven . . Handler#
//                     ^^^^^^^ definition local 1
//                             display_name handler
//                             signature_documentation java @NonNull\nunresolved_type handler
//                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#`<init>`().
      @NonNull ResultCallback resultCallback,
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
//                            ^^^^^^^^^^^^^^ definition local 2
//                                           display_name resultCallback
//                                           signature_documentation java @NonNull\nResultCallback resultCallback
//                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#`<init>`().
      @NonNull ItemCallback<EpoxyModel<?>> diffCallback
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^^^^^^^^^ reference semanticdb maven . . ItemCallback#
//                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                         ^^^^^^^^^^^^ definition local 3
//                                                      display_name diffCallback
//                                                      signature_documentation java @NonNull\nunresolved_type diffCallback
//                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#`<init>`().
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
//                                                    display_name list
//                                                    signature_documentation java @Nullable\nprivate List<? extends EpoxyModel<?>> list
//                                                    kind Field

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
//                                                            display_name readOnlyList
//                                                            signature_documentation java @NonNull\nprivate List<? extends EpoxyModel<?>> readOnlyList
//                                                            kind Field
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
//                                                    display_name getCurrentList
//                                                    signature_documentation java @AnyThread\n@NonNull\npublic List<? extends EpoxyModel<?>> getCurrentList()
//                                                    kind Method
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
//                          display_name cancelDiff
//                          signature_documentation java @SuppressWarnings("WeakerAccess")\n@AnyThread\npublic boolean cancelDiff()
//                          kind Method
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
//                                display_name isDiffInProgress
//                                signature_documentation java @SuppressWarnings("WeakerAccess")\n@AnyThread\npublic boolean isDiffInProgress()
//                                kind Method
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
//                                              display_name forceListOverride
//                                              signature_documentation java @AnyThread\npublic boolean forceListOverride(List<EpoxyModel<?>> newList)
//                                              kind Method
//                                              documentation  Set the current list without performing any diffing. Cancels any diff in progress.\n <p>\n This can be used if you notified a change to the adapter manually and need this list to be\n synced.\n
//                                               ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                        ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                            ^^^^^^^ definition local 4
//                                                                                    display_name newList
//                                                                                    signature_documentation java @Nullable\nList<EpoxyModel<?>> newList
//                                                                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#forceListOverride().
    // We need to make sure that generation changes and list updates are synchronized
    final boolean interruptedDiff = cancelDiff();
//                ^^^^^^^^^^^^^^^ definition local 5
//                                display_name interruptedDiff
//                                signature_documentation java final boolean interruptedDiff
//                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#forceListOverride().
//                                kind Variable
//                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#cancelDiff().
    int generation = generationTracker.incrementAndGetNextScheduled();
//      ^^^^^^^^^^ definition local 6
//                 display_name generation
//                 signature_documentation java int generation
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#forceListOverride().
//                 kind Variable
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
//                       display_name submitList
//                       signature_documentation java @AnyThread\n@SuppressWarnings("WeakerAccess")\npublic void submitList(List<? extends EpoxyModel<?>> newList)
//                       kind Method
//                       documentation  Set a new List representing your latest data.\n <p>\n A diff will be computed between this list and the last list set. If this has not previously\n been called then an empty list is used as the previous list.\n <p>\n The diff computation will be done on the thread given by the handler in the constructor.\n When the diff is done it will be applied (dispatched to the result callback),\n and the new List will be swapped in.\n
//                        ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                       ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                     ^^^^^^^ definition local 7
//                                                                             display_name newList
//                                                                             signature_documentation java @Nullable\nfinal List<? extends EpoxyModel<?>> newList
//                                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#submitList().
    final int runGeneration;
//            ^^^^^^^^^^^^^ definition local 8
//                          display_name runGeneration
//                          signature_documentation java final int runGeneration
//                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#submitList().
//                          kind Variable
    @Nullable final List<? extends EpoxyModel<?>> previousList;
//   ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                ^^^^^^^^^^^^ definition local 9
//                                                             display_name previousList
//                                                             signature_documentation java @Nullable\nfinal List<? extends EpoxyModel<?>> previousList
//                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#submitList().
//                                                             kind Variable

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
//                      display_name result
//                      signature_documentation java DiffResult result
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#submitList().
//                      kind Variable
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
//                                     display_name wrappedCallback
//                                     signature_documentation java final DiffCallback wrappedCallback
//                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#submitList().
//                                     kind Variable
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
//                ^^^ definition local 13
//                    display_name run
//                    signature_documentation java @Override\npublic void run()
//                    enclosing_symbol local 12
//                    kind Method
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Runnable#run().
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(wrappedCallback);
//      ^^^^^^^^ reference semanticdb maven . . DiffUtil/
//               ^^^^^^^^^^ reference semanticdb maven . . DiffUtil/DiffResult#
//                          ^^^^^^ definition local 14
//                                 display_name result
//                                 signature_documentation java unresolved_type result
//                                 enclosing_symbol local 13
//                                 kind Variable
//                                   ^^^^^^^^ reference semanticdb maven . . DiffUtil#
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . DiffUtil#calculateDiff#
//                                                          ^^^^^^^^^^^^^^^ reference local 11
        onRunCompleted(runGeneration, newList, DiffResult.diff(previousList, newList, result));
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
//                     ^^^^^^^^^^^^^ reference local 8
//                                    ^^^^^^^ reference local 7
//                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                                                        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#diff().
//                                                             ^^^^^^^^^^^^ reference local 9
//                                                                           ^^^^^^^ reference local 7
//                                                                                    ^^^^^^ reference local 14
      }
    });
  }

  private void onRunCompleted(
//             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
//                            display_name onRunCompleted
//                            signature_documentation java private void onRunCompleted(int runGeneration, List<? extends EpoxyModel<?>> newList, DiffResult result)
//                            kind Method
      final int runGeneration,
//              ^^^^^^^^^^^^^ definition local 15
//                            display_name runGeneration
//                            signature_documentation java final int runGeneration
//                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
      @Nullable final List<? extends EpoxyModel<?>> newList,
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                    ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^^ definition local 16
//                                                          display_name newList
//                                                          signature_documentation java @Nullable\nfinal List<? extends EpoxyModel<?>> newList
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
      @Nullable final DiffResult result
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                               ^^^^^^ definition local 17
//                                      display_name result
//                                      signature_documentation java @Nullable\nfinal DiffResult result
//                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#onRunCompleted().
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
//                ^^^ definition local 19
//                    display_name run
//                    signature_documentation java @Override\npublic void run()
//                    enclosing_symbol local 18
//                    kind Method
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Runnable#run().
        final boolean dispatchResult = tryLatchList(newList, runGeneration);
//                    ^^^^^^^^^^^^^^ definition local 20
//                                   display_name dispatchResult
//                                   signature_documentation java final boolean dispatchResult
//                                   enclosing_symbol local 19
//                                   kind Variable
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#tryLatchList().
//                                                  ^^^^^^^ reference local 16
//                                                           ^^^^^^^^^^^^^ reference local 15
        if (result != null && dispatchResult) {
//          ^^^^^^ reference local 17
//                            ^^^^^^^^^^^^^^ reference local 20
          resultCallback.onResult(result);
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#resultCallback.
//                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#onResult().
//                                ^^^^^^ reference local 17
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
//                                          display_name tryLatchList
//                                          signature_documentation java @AnyThread\nprivate boolean tryLatchList(List<? extends EpoxyModel<?>> newList, int runGeneration)
//                                          kind Method
//                                          documentation  Marks the generation as done, and updates the list if the generation is the most recent.\n\n @return True if the given generation is the most recent, in which case the given list was\n set. False if the generation is old and the list was ignored.\n
//                                           ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                    ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                  ^^^^^^^ definition local 21
//                                                                                          display_name newList
//                                                                                          signature_documentation java @Nullable\nList<? extends EpoxyModel<?>> newList
//                                                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#tryLatchList().
      int runGeneration) {
//        ^^^^^^^^^^^^^ definition local 22
//                      display_name runGeneration
//                      signature_documentation java int runGeneration
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#tryLatchList().
    if (generationTracker.finishGeneration(runGeneration)) {
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#generationTracker.
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishGeneration().
//                                         ^^^^^^^^^^^^^ reference local 22
      list = newList;
//    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#list.
//           ^^^^^^^ reference local 21

      if (newList == null) {
//        ^^^^^^^ reference local 21
        readOnlyList = Collections.emptyList();
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#readOnlyList.
//                     ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                 ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#emptyList().
      } else {
        readOnlyList = Collections.unmodifiableList(newList);
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#readOnlyList.
//                     ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#unmodifiableList().
//                                                  ^^^^^^^ reference local 21
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
//                                       display_name GenerationTracker
//                                       signature_documentation java private static class GenerationTracker
//                                       kind Class
//                                       documentation  The concept of a "generation" is used to associate a diff result with a point in time when\n it was created. This allows us to handle list updates concurrently, and ignore outdated diffs.\n <p>\n We track the highest start generation, and the highest finished generation, and these must\n be kept in sync, so all access to this class is synchronized.\n <p>\n The general synchronization strategy for this class is that when a generation number\n is queried that action must be synchronized with accessing the current list, so that the\n generation number is synced with the list state at the time it was created.\n
//                     ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#`<init>`().
//                                       display_name <init>
//                                       signature_documentation java private GenerationTracker()
//                                       kind Constructor

    // Max generation of currently scheduled runnable
    private volatile int maxScheduledGeneration;
//                       ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
//                                              display_name maxScheduledGeneration
//                                              signature_documentation java private int maxScheduledGeneration
//                                              kind Field
    private volatile int maxFinishedGeneration;
//                       ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.
//                                             display_name maxFinishedGeneration
//                                             signature_documentation java private int maxFinishedGeneration
//                                             kind Field

    synchronized int incrementAndGetNextScheduled() {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#incrementAndGetNextScheduled().
//                                                display_name incrementAndGetNextScheduled
//                                                signature_documentation java int incrementAndGetNextScheduled()
//                                                kind Method
      return ++maxScheduledGeneration;
//             ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
    }

    synchronized boolean finishMaxGeneration() {
//                       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishMaxGeneration().
//                                           display_name finishMaxGeneration
//                                           signature_documentation java boolean finishMaxGeneration()
//                                           kind Method
      boolean isInterrupting = hasUnfinishedGeneration();
//            ^^^^^^^^^^^^^^ definition local 23
//                           display_name isInterrupting
//                           signature_documentation java boolean isInterrupting
//                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishMaxGeneration().
//                           kind Variable
//                             ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#hasUnfinishedGeneration().
      maxFinishedGeneration = maxScheduledGeneration;
//    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.
//                            ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
      return isInterrupting;
//           ^^^^^^^^^^^^^^ reference local 23
    }

    synchronized boolean hasUnfinishedGeneration() {
//                       ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#hasUnfinishedGeneration().
//                                               display_name hasUnfinishedGeneration
//                                               signature_documentation java boolean hasUnfinishedGeneration()
//                                               kind Method
      return maxScheduledGeneration > maxFinishedGeneration;
//           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.
    }

    synchronized boolean finishGeneration(int runGeneration) {
//                       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishGeneration().
//                                        display_name finishGeneration
//                                        signature_documentation java boolean finishGeneration(int runGeneration)
//                                        kind Method
//                                            ^^^^^^^^^^^^^ definition local 24
//                                                          display_name runGeneration
//                                                          signature_documentation java int runGeneration
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishGeneration().
      boolean isLatestGeneration =
//            ^^^^^^^^^^^^^^^^^^ definition local 25
//                               display_name isLatestGeneration
//                               signature_documentation java boolean isLatestGeneration
//                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#finishGeneration().
//                               kind Variable
          maxScheduledGeneration == runGeneration && runGeneration > maxFinishedGeneration;
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxScheduledGeneration.
//                                  ^^^^^^^^^^^^^ reference local 24
//                                                   ^^^^^^^^^^^^^ reference local 24
//                                                                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.

      if (isLatestGeneration) {
//        ^^^^^^^^^^^^^^^^^^ reference local 25
        maxFinishedGeneration = runGeneration;
//      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#GenerationTracker#maxFinishedGeneration.
//                              ^^^^^^^^^^^^^ reference local 24
      }

      return isLatestGeneration;
//           ^^^^^^^^^^^^^^^^^^ reference local 25
    }
  }

  private static class DiffCallback extends DiffUtil.Callback {
//                     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#
//                                  display_name DiffCallback
//                                  signature_documentation java private static class DiffCallback
//                                  kind Class
//                                  relationship is_implementation semanticdb maven . . DiffUtil/Callback#
//                                          ^^^^^^^^ reference semanticdb maven . . DiffUtil/
//                                                   ^^^^^^^^ reference semanticdb maven . . DiffUtil/Callback#

    final List<? extends EpoxyModel<?>> oldList;
//        ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                                              display_name oldList
//                                              signature_documentation java final List<? extends EpoxyModel<?>> oldList
//                                              kind Field
    final List<? extends EpoxyModel<?>> newList;
//        ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                                              display_name newList
//                                              signature_documentation java final List<? extends EpoxyModel<?>> newList
//                                              kind Field
    private final ItemCallback<EpoxyModel<?>> diffCallback;
//                ^^^^^^^^^^^^ reference semanticdb maven . . ItemCallback#
//                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                            ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                                                         display_name diffCallback
//                                                         signature_documentation java private final unresolved_type diffCallback
//                                                         kind Field

    DiffCallback(List<? extends EpoxyModel<?>> oldList, List<? extends EpoxyModel<?>> newList,
//  ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#`<init>`().
//               display_name <init>
//               signature_documentation java DiffCallback(List<? extends EpoxyModel<?>> oldList, List<? extends EpoxyModel<?>> newList, unresolved_type diffCallback)
//               kind Constructor
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^^^ definition local 26
//                                                     display_name oldList
//                                                     signature_documentation java List<? extends EpoxyModel<?>> oldList
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#`<init>`().
//                                                      ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                    ^^^^^^^ definition local 27
//                                                                                            display_name newList
//                                                                                            signature_documentation java List<? extends EpoxyModel<?>> newList
//                                                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#`<init>`().
        ItemCallback<EpoxyModel<?>> diffCallback) {
//      ^^^^^^^^^^^^ reference semanticdb maven . . ItemCallback#
//                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^^^^^^^ definition local 28
//                                               display_name diffCallback
//                                               signature_documentation java unresolved_type diffCallback
//                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#`<init>`().
      this.oldList = oldList;
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                   ^^^^^^^ reference local 26
      this.newList = newList;
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                   ^^^^^^^ reference local 27
      this.diffCallback = diffCallback;
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                        ^^^^^^^^^^^^ reference local 28
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public int getOldListSize() {
//             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#getOldListSize().
//                            display_name getOldListSize
//                            signature_documentation java @Override\npublic int getOldListSize()
//                            kind Method
      return oldList.size();
//           ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                   ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public int getNewListSize() {
//             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#getNewListSize().
//                            display_name getNewListSize
//                            signature_documentation java @Override\npublic int getNewListSize()
//                            kind Method
      return newList.size();
//           ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                   ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#areItemsTheSame().
//                                 display_name areItemsTheSame
//                                 signature_documentation java @Override\npublic boolean areItemsTheSame(int oldItemPosition, int newItemPosition)
//                                 kind Method
//                                     ^^^^^^^^^^^^^^^ definition local 29
//                                                     display_name oldItemPosition
//                                                     signature_documentation java int oldItemPosition
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#areItemsTheSame().
//                                                          ^^^^^^^^^^^^^^^ definition local 30
//                                                                          display_name newItemPosition
//                                                                          signature_documentation java int newItemPosition
//                                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#areItemsTheSame().
      return diffCallback.areItemsTheSame(
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . `<any>`#areItemsTheSame#
          oldList.get(oldItemPosition),
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#oldList.
//                ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local 29
          newList.get(newItemPosition)
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#newList.
//                ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                    ^^^^^^^^^^^^^^^ reference local 30
      );
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
//                 ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#areContentsTheSame().
//                                    display_name areContentsTheSame
//                                    signature_documentation java @Override\npublic boolean areContentsTheSame(int oldItemPosition, int newItemPosition)
//                                    kind Method
//                                        ^^^^^^^^^^^^^^^ definition local 31
//                                                        display_name oldItemPosition
//                                                        signature_documentation java int oldItemPosition
//                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#areContentsTheSame().
//                                                             ^^^^^^^^^^^^^^^ definition local 32
//                                                                             display_name newItemPosition
//                                                                             signature_documentation java int newItemPosition
//                                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#areContentsTheSame().
      return diffCallback.areContentsTheSame(
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . `<any>`#areContentsTheSame#
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

    @Nullable
//   ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
//         ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#getChangePayload().
//                                 display_name getChangePayload
//                                 signature_documentation java @Nullable\n@Override\npublic Object getChangePayload(int oldItemPosition, int newItemPosition)
//                                 kind Method
//                                     ^^^^^^^^^^^^^^^ definition local 33
//                                                     display_name oldItemPosition
//                                                     signature_documentation java int oldItemPosition
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#getChangePayload().
//                                                          ^^^^^^^^^^^^^^^ definition local 34
//                                                                          display_name newItemPosition
//                                                                          signature_documentation java int newItemPosition
//                                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#getChangePayload().
      return diffCallback.getChangePayload(
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#DiffCallback#diffCallback.
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . `<any>`#getChangePayload#
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
  }
}
