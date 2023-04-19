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
//                      documentation ```java\npublic class DiffResult\n```
//                      documentation  Wraps the result of {@link AsyncEpoxyDiffer#submitList(List)}.\n
  @NonNull final List<? extends EpoxyModel<?>> previousModels;
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#previousModels.
//                                                            documentation ```java\n@NonNull\nfinal List<? extends EpoxyModel<?>> previousModels\n```
  @NonNull final List<? extends EpoxyModel<?>> newModels;
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#newModels.
//                                                       documentation ```java\n@NonNull\nfinal List<? extends EpoxyModel<?>> newModels\n```

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
//                                                 documentation ```java\n@Nullable\nfinal unresolved_type differResult\n```
//                                                 documentation  If this is non null it means the full differ ran and the result is contained\n in this object. If it is null, it means that either the old list or the new list was empty, so\n we can simply add all or clear all items and skipped running the full diffing.\n

  /** No changes were made to the models. */
  static DiffResult noOp(@Nullable List<? extends EpoxyModel<?>> models) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                  ^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#noOp().
//                       documentation ```java\nstatic DiffResult noOp(List<? extends EpoxyModel<?>> models)\n```
//                       documentation No changes were made to the models. 
//                        ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                 ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                               ^^^^^^ definition local 0
//                                                                      documentation ```java\n@Nullable\nList<? extends EpoxyModel<?>> models\n```
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
//                           documentation ```java\nstatic DiffResult inserted(List<? extends EpoxyModel<?>> newModels)\n```
//                           documentation The previous list was empty and the given non empty list was inserted. 
//                            ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                    ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                  ^^^^^^^^^ definition local 1
//                                                                            documentation ```java\n@NonNull\nList<? extends EpoxyModel<?>> newModels\n```
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
//                        documentation ```java\nstatic DiffResult clear(List<? extends EpoxyModel<?>> previousModels)\n```
//                        documentation The previous list was non empty and the new list is empty. 
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                 ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                               ^^^^^^^^^^^^^^ definition local 2
//                                                                              documentation ```java\n@NonNull\nList<? extends EpoxyModel<?>> previousModels\n```
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
//                       documentation ```java\nstatic DiffResult diff(List<? extends EpoxyModel<?>> previousModels, List<? extends EpoxyModel<?>> newModels, unresolved_type differResult)\n```
//                       documentation  The previous and new models are both non empty and a full differ pass was run on them.\n There may be no changes, however.\n
      @NonNull List<? extends EpoxyModel<?>> previousModels,
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^^^^^^ definition local 3
//                                                          documentation ```java\n@NonNull\nList<? extends EpoxyModel<?>> previousModels\n```
      @NonNull List<? extends EpoxyModel<?>> newModels,
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^ definition local 4
//                                                     documentation ```java\n@NonNull\nList<? extends EpoxyModel<?>> newModels\n```
      @NonNull DiffUtil.DiffResult differResult
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^^^^^ reference semanticdb maven . . DiffUtil/
//                      ^^^^^^^^^^ reference semanticdb maven . . DiffUtil/DiffResult#
//                                 ^^^^^^^^^^^^ definition local 5
//                                              documentation ```java\n@NonNull\nunresolved_type differResult\n```
  ) {
    return new DiffResult(previousModels, newModels, differResult);
//             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#`<init>`().
//                        ^^^^^^^^^^^^^^ reference local 3
//                                        ^^^^^^^^^ reference local 4
//                                                   ^^^^^^^^^^^^ reference local 5
  }

  private DiffResult(
//        ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#`<init>`().
//                   documentation ```java\nprivate DiffResult(List<? extends EpoxyModel<?>> previousModels, List<? extends EpoxyModel<?>> newModels, unresolved_type differResult)\n```
      @NonNull List<? extends EpoxyModel<?>> previousModels,
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^^^^^^ definition local 6
//                                                          documentation ```java\n@NonNull\nList<? extends EpoxyModel<?>> previousModels\n```
      @NonNull List<? extends EpoxyModel<?>> newModels,
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^ definition local 7
//                                                     documentation ```java\n@NonNull\nList<? extends EpoxyModel<?>> newModels\n```
      @Nullable DiffUtil.DiffResult differResult
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^^^^^ reference semanticdb maven . . DiffUtil/
//                       ^^^^^^^^^^ reference semanticdb maven . . DiffUtil/DiffResult#
//                                  ^^^^^^^^^^^^ definition local 8
//                                               documentation ```java\n@Nullable\nunresolved_type differResult\n```
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
//                       documentation ```java\npublic void dispatchTo(unresolved_type adapter)\n```
//                       ^^^^^^^ reference semanticdb maven . . _root_/
//                               ^^^^^^^ definition local 9
//                                       documentation ```java\nunresolved_type adapter\n```
    dispatchTo(new AdapterListUpdateCallback(adapter));
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#dispatchTo().
//                                           ^^^^^^^ reference local 9
  }

  public void dispatchTo(ListUpdateCallback callback) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffResult#dispatchTo(+1).
//                       documentation ```java\npublic void dispatchTo(unresolved_type callback)\n```
//                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                          ^^^^^^^^ definition local 10
//                                                   documentation ```java\nunresolved_type callback\n```
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
//             ^^^^^^^^^ reference semanticdb maven . . onRemoved#
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#previousModels.
//                                         ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    } else if (!newModels.isEmpty() && previousModels.isEmpty()) {
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#newModels.
//                        ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#previousModels.
//                                                    ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
      callback.onInserted(0, newModels.size());
//    ^^^^^^^^ reference local 10
//             ^^^^^^^^^^ reference semanticdb maven . . onInserted#
//                           ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#newModels.
//                                     ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    }

    // Else nothing changed!
  }
}
