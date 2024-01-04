package com.airbnb.epoxy;

import java.util.Collections;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.recyclerview.widget.AdapterListUpdateCallback;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/AdapterListUpdateCallback#
import androidx.recyclerview.widget.DiffUtil;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/DiffUtil#
import androidx.recyclerview.widget.ListUpdateCallback;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/ListUpdateCallback#
import androidx.recyclerview.widget.RecyclerView.Adapter;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/
//                                               ^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/Adapter#

/**
 * Wraps the result of {@link AsyncEpoxyDiffer#submitList(List)}.
 */
public class DiffResult {
//           ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                      display_name DiffResult
//                      signature_documentation java public class DiffResult
//                      documentation  Wraps the result of {@link AsyncEpoxyDiffer#submitList(List)}.\n
  @NonNull final List<? extends EpoxyModel<?>> previousModels;
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#previousModels.
//                                                            display_name previousModels
//                                                            signature_documentation java @NonNull\nfinal List<? extends EpoxyModel<?>> previousModels
  @NonNull final List<? extends EpoxyModel<?>> newModels;
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#newModels.
//                                                       display_name newModels
//                                                       signature_documentation java @NonNull\nfinal List<? extends EpoxyModel<?>> newModels

  /**
   * If this is non null it means the full differ ran and the result is contained
   * in this object. If it is null, it means that either the old list or the new list was empty, so
   * we can simply add all or clear all items and skipped running the full diffing.
   */
  @Nullable final DiffUtil.DiffResult differResult;
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                ^^^^^^^^ reference semanticdb maven . . DiffUtil/
//                         ^^^^^^^^^^ reference semanticdb maven . . DiffUtil/DiffResult#
//                                    ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#differResult.
//                                                 display_name differResult
//                                                 signature_documentation java @Nullable\nfinal unresolved_type differResult
//                                                 documentation  If this is non null it means the full differ ran and the result is contained\n in this object. If it is null, it means that either the old list or the new list was empty, so\n we can simply add all or clear all items and skipped running the full diffing.\n

  /** No changes were made to the models. */
  static DiffResult noOp(@Nullable List<? extends EpoxyModel<?>> models) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                  ^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#noOp().
//                       display_name noOp
//                       signature_documentation java static DiffResult noOp(List<? extends EpoxyModel<?>> models)
//                       documentation No changes were made to the models. 
//                        ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                 ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                               ^^^^^^ definition local 0
//                                                                      display_name models
//                                                                      signature_documentation java @Nullable\nList<? extends EpoxyModel<?>> models
//                                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffResult#noOp().
    if (models == null) {
//      ^^^^^^ reference local 0
      models = Collections.emptyList();
//    ^^^^^^ reference local 0
//             ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                         ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#emptyList().
    }
    return new DiffResult(models, models, null);
//             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#`<init>`().
//                        ^^^^^^ reference local 0
//                                ^^^^^^ reference local 0
  }

  /** The previous list was empty and the given non empty list was inserted. */
  static DiffResult inserted(@NonNull List<? extends EpoxyModel<?>> newModels) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                  ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#inserted().
//                           display_name inserted
//                           signature_documentation java static DiffResult inserted(List<? extends EpoxyModel<?>> newModels)
//                           documentation The previous list was empty and the given non empty list was inserted. 
//                            ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                    ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                  ^^^^^^^^^ definition local 1
//                                                                            display_name newModels
//                                                                            signature_documentation java @NonNull\nList<? extends EpoxyModel<?>> newModels
//                                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffResult#inserted().
    //noinspection unchecked
    return new DiffResult(Collections.EMPTY_LIST, newModels, null);
//             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#`<init>`().
//                        ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                    ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#EMPTY_LIST.
//                                                ^^^^^^^^^ reference local 1
  }

  /** The previous list was non empty and the new list is empty. */
  static DiffResult clear(@NonNull List<? extends EpoxyModel<?>> previousModels) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                  ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#clear().
//                        display_name clear
//                        signature_documentation java static DiffResult clear(List<? extends EpoxyModel<?>> previousModels)
//                        documentation The previous list was non empty and the new list is empty. 
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                 ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                               ^^^^^^^^^^^^^^ definition local 2
//                                                                              display_name previousModels
//                                                                              signature_documentation java @NonNull\nList<? extends EpoxyModel<?>> previousModels
//                                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffResult#clear().
    //noinspection unchecked
    return new DiffResult(previousModels, Collections.EMPTY_LIST, null);
//             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#`<init>`().
//                        ^^^^^^^^^^^^^^ reference local 2
//                                        ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                                    ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#EMPTY_LIST.
  }

  /**
   * The previous and new models are both non empty and a full differ pass was run on them.
   * There may be no changes, however.
   */
  static DiffResult diff(
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                  ^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#diff().
//                       display_name diff
//                       signature_documentation java static DiffResult diff(List<? extends EpoxyModel<?>> previousModels, List<? extends EpoxyModel<?>> newModels, unresolved_type differResult)
//                       documentation  The previous and new models are both non empty and a full differ pass was run on them.\n There may be no changes, however.\n
      @NonNull List<? extends EpoxyModel<?>> previousModels,
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^^^^^^ definition local 3
//                                                          display_name previousModels
//                                                          signature_documentation java @NonNull\nList<? extends EpoxyModel<?>> previousModels
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffResult#diff().
      @NonNull List<? extends EpoxyModel<?>> newModels,
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^ definition local 4
//                                                     display_name newModels
//                                                     signature_documentation java @NonNull\nList<? extends EpoxyModel<?>> newModels
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffResult#diff().
      @NonNull DiffUtil.DiffResult differResult
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^^^^^ reference semanticdb maven . . DiffUtil/
//                      ^^^^^^^^^^ reference semanticdb maven . . DiffUtil/DiffResult#
//                                 ^^^^^^^^^^^^ definition local 5
//                                              display_name differResult
//                                              signature_documentation java @NonNull\nunresolved_type differResult
//                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffResult#diff().
  ) {
    return new DiffResult(previousModels, newModels, differResult);
//             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#`<init>`().
//                        ^^^^^^^^^^^^^^ reference local 3
//                                        ^^^^^^^^^ reference local 4
//                                                   ^^^^^^^^^^^^ reference local 5
  }

  private DiffResult(
//        ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#`<init>`().
//                   display_name <init>
//                   signature_documentation java private DiffResult(List<? extends EpoxyModel<?>> previousModels, List<? extends EpoxyModel<?>> newModels, unresolved_type differResult)
      @NonNull List<? extends EpoxyModel<?>> previousModels,
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^^^^^^ definition local 6
//                                                          display_name previousModels
//                                                          signature_documentation java @NonNull\nList<? extends EpoxyModel<?>> previousModels
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffResult#`<init>`().
      @NonNull List<? extends EpoxyModel<?>> newModels,
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^ definition local 7
//                                                     display_name newModels
//                                                     signature_documentation java @NonNull\nList<? extends EpoxyModel<?>> newModels
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffResult#`<init>`().
      @Nullable DiffUtil.DiffResult differResult
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^^^^^ reference semanticdb maven . . DiffUtil/
//                       ^^^^^^^^^^ reference semanticdb maven . . DiffUtil/DiffResult#
//                                  ^^^^^^^^^^^^ definition local 8
//                                               display_name differResult
//                                               signature_documentation java @Nullable\nunresolved_type differResult
//                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffResult#`<init>`().
  ) {
    this.previousModels = previousModels;
//       ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#previousModels.
//                        ^^^^^^^^^^^^^^ reference local 6
    this.newModels = newModels;
//       ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#newModels.
//                   ^^^^^^^^^ reference local 7
    this.differResult = differResult;
//       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#differResult.
//                      ^^^^^^^^^^^^ reference local 8
  }

  public void dispatchTo(Adapter adapter) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#dispatchTo().
//                       display_name dispatchTo
//                       signature_documentation java public void dispatchTo(unresolved_type adapter)
//                       ^^^^^^^ reference semanticdb maven . . Adapter#
//                               ^^^^^^^ definition local 9
//                                       display_name adapter
//                                       signature_documentation java unresolved_type adapter
//                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffResult#dispatchTo().
    dispatchTo(new AdapterListUpdateCallback(adapter));
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#dispatchTo().
//                                           ^^^^^^^ reference local 9
  }

  public void dispatchTo(ListUpdateCallback callback) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#dispatchTo(+1).
//                       display_name dispatchTo
//                       signature_documentation java public void dispatchTo(unresolved_type callback)
//                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . ListUpdateCallback#
//                                          ^^^^^^^^ definition local 10
//                                                   display_name callback
//                                                   signature_documentation java unresolved_type callback
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffResult#dispatchTo(+1).
    if (differResult != null) {
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#differResult.
      differResult.dispatchUpdatesTo(callback);
//    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#differResult.
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . DiffUtil/DiffResult#dispatchUpdatesTo#
//                                   ^^^^^^^^ reference local 10
    } else if (newModels.isEmpty() && !previousModels.isEmpty()) {
//             ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#newModels.
//                       ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#previousModels.
//                                                    ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
      callback.onRemoved(0, previousModels.size());
//    ^^^^^^^^ reference local 10
//             ^^^^^^^^^ reference semanticdb maven . . ListUpdateCallback#onRemoved#
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#previousModels.
//                                         ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    } else if (!newModels.isEmpty() && previousModels.isEmpty()) {
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#newModels.
//                        ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#previousModels.
//                                                    ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
      callback.onInserted(0, newModels.size());
//    ^^^^^^^^ reference local 10
//             ^^^^^^^^^^ reference semanticdb maven . . ListUpdateCallback#onInserted#
//                           ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#newModels.
//                                     ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    }

    // Else nothing changed!
  }
}
