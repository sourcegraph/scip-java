package com.airbnb.epoxy;

import java.util.Collections;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^ reference java/util/Collections#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#
import androidx.recyclerview.widget.AdapterListUpdateCallback;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/AdapterListUpdateCallback#
import androidx.recyclerview.widget.DiffUtil;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^ reference androidx/recyclerview/widget/DiffUtil#
import androidx.recyclerview.widget.ListUpdateCallback;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/ListUpdateCallback#
import androidx.recyclerview.widget.RecyclerView.Adapter;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView/
//                                               ^^^^^^^ reference androidx/recyclerview/widget/RecyclerView/Adapter#

/**
 * Wraps the result of {@link AsyncEpoxyDiffer#submitList(List)}.
 */
public class DiffResult {
//     ^^^^^^^^^^ definition com/airbnb/epoxy/DiffResult#
  @NonNull final List<? extends EpoxyModel<?>> previousModels;
// ^^^^^^^ reference androidx/annotation/NonNull#
//               ^^^^ reference java/util/List#
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffResult#previousModels.
  @NonNull final List<? extends EpoxyModel<?>> newModels;
// ^^^^^^^ reference androidx/annotation/NonNull#
//               ^^^^ reference java/util/List#
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^^^^^ definition com/airbnb/epoxy/DiffResult#newModels.

  /**
   * If this is non null it means the full differ ran and the result is contained
   * in this object. If it is null, it means that either the old list or the new list was empty, so
   * we can simply add all or clear all items and skipped running the full diffing.
   */
  @Nullable final DiffUtil.DiffResult differResult;
// ^^^^^^^^ reference androidx/annotation/Nullable#
//                ^^^^^^^^ reference DiffUtil/
//                         ^^^^^^^^^^ reference DiffUtil/DiffResult#
//                                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffResult#differResult.

  /** No changes were made to the models. */
  static DiffResult noOp(@Nullable List<? extends EpoxyModel<?>> models) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                  ^^^^ definition com/airbnb/epoxy/DiffResult#noOp().
//                        ^^^^^^^^ reference androidx/annotation/Nullable#
//                                 ^^^^ reference java/util/List#
//                                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                               ^^^^^^ definition local0
    if (models == null) {
//      ^^^^^^ reference local0
      models = Collections.emptyList();
//    ^^^^^^ reference local0
//             ^^^^^^^^^^^ reference java/util/Collections#
//                         ^^^^^^^^^ reference java/util/Collections#emptyList().
    }
    return new DiffResult(models, models, null);
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#`<init>`().
//             ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                        ^^^^^^ reference local0
//                                ^^^^^^ reference local0
  }

  /** The previous list was empty and the given non empty list was inserted. */
  static DiffResult inserted(@NonNull List<? extends EpoxyModel<?>> newModels) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                  ^^^^^^^^ definition com/airbnb/epoxy/DiffResult#inserted().
//                            ^^^^^^^ reference androidx/annotation/NonNull#
//                                    ^^^^ reference java/util/List#
//                                                   ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                  ^^^^^^^^^ definition local1
    //noinspection unchecked
    return new DiffResult(Collections.EMPTY_LIST, newModels, null);
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#`<init>`().
//             ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                        ^^^^^^^^^^^ reference java/util/Collections#
//                                    ^^^^^^^^^^ reference java/util/Collections#EMPTY_LIST.
//                                                ^^^^^^^^^ reference local1
  }

  /** The previous list was non empty and the new list is empty. */
  static DiffResult clear(@NonNull List<? extends EpoxyModel<?>> previousModels) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                  ^^^^^ definition com/airbnb/epoxy/DiffResult#clear().
//                         ^^^^^^^ reference androidx/annotation/NonNull#
//                                 ^^^^ reference java/util/List#
//                                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                               ^^^^^^^^^^^^^^ definition local2
    //noinspection unchecked
    return new DiffResult(previousModels, Collections.EMPTY_LIST, null);
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#`<init>`().
//             ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                        ^^^^^^^^^^^^^^ reference local2
//                                        ^^^^^^^^^^^ reference java/util/Collections#
//                                                    ^^^^^^^^^^ reference java/util/Collections#EMPTY_LIST.
  }

  /**
   * The previous and new models are both non empty and a full differ pass was run on them.
   * There may be no changes, however.
   */
  static DiffResult diff(
//       ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                  ^^^^ definition com/airbnb/epoxy/DiffResult#diff().
      @NonNull List<? extends EpoxyModel<?>> previousModels,
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^^^^ reference java/util/List#
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^^^^^^ definition local3
      @NonNull List<? extends EpoxyModel<?>> newModels,
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^^^^ reference java/util/List#
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^ definition local4
      @NonNull DiffUtil.DiffResult differResult
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^^^^^^^^ reference DiffUtil/
//                      ^^^^^^^^^^ reference DiffUtil/DiffResult#
//                                 ^^^^^^^^^^^^ definition local5
  ) {
    return new DiffResult(previousModels, newModels, differResult);
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#`<init>`().
//             ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                        ^^^^^^^^^^^^^^ reference local3
//                                        ^^^^^^^^^ reference local4
//                                                   ^^^^^^^^^^^^ reference local5
  }

  private DiffResult(
//        ^^^^^^ definition com/airbnb/epoxy/DiffResult#`<init>`().
      @NonNull List<? extends EpoxyModel<?>> previousModels,
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^^^^ reference java/util/List#
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^^^^^^ definition local6
      @NonNull List<? extends EpoxyModel<?>> newModels,
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^^^^ reference java/util/List#
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^ definition local7
      @Nullable DiffUtil.DiffResult differResult
//     ^^^^^^^^ reference androidx/annotation/Nullable#
//              ^^^^^^^^ reference DiffUtil/
//                       ^^^^^^^^^^ reference DiffUtil/DiffResult#
//                                  ^^^^^^^^^^^^ definition local8
  ) {
    this.previousModels = previousModels;
//  ^^^^ reference com/airbnb/epoxy/DiffResult#this.
//       ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#previousModels.
//                        ^^^^^^^^^^^^^^ reference local6
    this.newModels = newModels;
//  ^^^^ reference com/airbnb/epoxy/DiffResult#this.
//       ^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#newModels.
//                   ^^^^^^^^^ reference local7
    this.differResult = differResult;
//  ^^^^ reference com/airbnb/epoxy/DiffResult#this.
//       ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#differResult.
//                      ^^^^^^^^^^^^ reference local8
  }

  public void dispatchTo(Adapter adapter) {
//            ^^^^^^^^^^ definition com/airbnb/epoxy/DiffResult#dispatchTo().
//                       ^^^^^^^ reference _root_/
//                               ^^^^^^^ definition local9
    dispatchTo(new AdapterListUpdateCallback(adapter));
//  ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#dispatchTo().
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference `<init>`#
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^^ reference local9
  }

  public void dispatchTo(ListUpdateCallback callback) {
//            ^^^^^^^^^^ definition com/airbnb/epoxy/DiffResult#dispatchTo(+1).
//                       ^^^^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^^^^^^^ definition local10
    if (differResult != null) {
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#differResult.
      differResult.dispatchUpdatesTo(callback);
//    ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#differResult.
//                 ^^^^^^^^^^^^^^^^^ reference DiffUtil/DiffResult#dispatchUpdatesTo#
//                                   ^^^^^^^^ reference local10
    } else if (newModels.isEmpty() && !previousModels.isEmpty()) {
//             ^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#newModels.
//                       ^^^^^^^ reference java/util/List#isEmpty().
//                                     ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#previousModels.
//                                                    ^^^^^^^ reference java/util/List#isEmpty().
      callback.onRemoved(0, previousModels.size());
//    ^^^^^^^^ reference local10
//             ^^^^^^^^^ reference onRemoved#
//                          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#previousModels.
//                                         ^^^^ reference java/util/List#size().
    } else if (!newModels.isEmpty() && previousModels.isEmpty()) {
//              ^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#newModels.
//                        ^^^^^^^ reference java/util/List#isEmpty().
//                                     ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#previousModels.
//                                                    ^^^^^^^ reference java/util/List#isEmpty().
      callback.onInserted(0, newModels.size());
//    ^^^^^^^^ reference local10
//             ^^^^^^^^^^ reference onInserted#
//                           ^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#newModels.
//                                     ^^^^ reference java/util/List#size().
    }

    // Else nothing changed!
  }
}
