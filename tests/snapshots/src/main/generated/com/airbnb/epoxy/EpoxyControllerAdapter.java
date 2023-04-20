package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^ reference semanticdb maven . . android/os/Handler#
import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

import com.airbnb.epoxy.AsyncEpoxyDiffer.ResultCallback;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#
//                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#

import org.jetbrains.annotations.NotNull;
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/annotations/
//                               ^^^^^^^ reference semanticdb maven maven/org.jetbrains/annotations 13.0 org/jetbrains/annotations/NotNull#

import java.util.ArrayList;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
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
import androidx.annotation.UiThread;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/UiThread#
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/DiffUtil/
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/DiffUtil/ItemCallback#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView#

public final class EpoxyControllerAdapter extends BaseEpoxyAdapter implements ResultCallback {
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#
//                                        documentation ```java\npublic final class EpoxyControllerAdapter\n```
//                                        relationship is_implementation semanticdb maven . . RecyclerView/Adapter#
//                                        relationship is_implementation semanticdb maven . . ``/StickyHeaderCallbacks#
//                                        relationship is_implementation semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
//                                        relationship is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#
//                                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
  private final NotifyBlocker notifyBlocker = new NotifyBlocker();
//              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#
//                            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                                          documentation ```java\nprivate final NotifyBlocker notifyBlocker\n```
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#`<init>`().
  private final AsyncEpoxyDiffer differ;
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#
//                               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                                      documentation ```java\nprivate final AsyncEpoxyDiffer differ\n```
  private final EpoxyController epoxyController;
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                                              documentation ```java\nprivate final EpoxyController epoxyController\n```
  private int itemCount;
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#itemCount.
//                      documentation ```java\nprivate int itemCount\n```
  private final List<OnModelBuildFinishedListener> modelBuildListeners = new ArrayList<>();
//              ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                                                                     documentation ```java\nprivate final List<OnModelBuildFinishedListener> modelBuildListeners\n```
//                                                                           ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+1).

  EpoxyControllerAdapter(@NonNull EpoxyController epoxyController, Handler diffingHandler) {
//^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#`<init>`().
//                       documentation ```java\nEpoxyControllerAdapter(EpoxyController epoxyController, unresolved_type diffingHandler)\n```
//                        ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                ^^^^^^^^^^^^^^^ definition local 0
//                                                                documentation ```java\n@NonNull\nEpoxyController epoxyController\n```
//                                                                 ^^^^^^^ reference semanticdb maven . . _root_/
//                                                                         ^^^^^^^^^^^^^^ definition local 1
//                                                                                        documentation ```java\nunresolved_type diffingHandler\n```
    this.epoxyController = epoxyController;
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                         ^^^^^^^^^^^^^^^ reference local 0
    differ = new AsyncEpoxyDiffer(
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#`<init>`().
        diffingHandler,
//      ^^^^^^^^^^^^^^ reference local 1
        this,
        ITEM_CALLBACK
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#ITEM_CALLBACK.
    );
    registerAdapterDataObserver(notifyBlocker);
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#registerAdapterDataObserver#
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void onExceptionSwallowed(@NonNull RuntimeException exception) {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onExceptionSwallowed().
//                                    documentation ```java\n@Override\nprotected void onExceptionSwallowed(RuntimeException exception)\n```
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onExceptionSwallowed().
//                                     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
//                                                              ^^^^^^^^^ definition local 2
//                                                                        documentation ```java\n@NonNull\nRuntimeException exception\n```
    epoxyController.onExceptionSwallowed(exception);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onExceptionSwallowed().
//                                       ^^^^^^^^^ reference local 2
  }

  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  List<? extends EpoxyModel<?>> getCurrentModels() {
//^^^^ reference semanticdb maven jdk 11 java/util/List#
//               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                                               documentation ```java\n@NonNull\n@Override\nList<? extends EpoxyModel<?>> getCurrentModels()\n```
//                                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
    return differ.getCurrentList();
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#getCurrentList().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getItemCount() {
//           ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getItemCount().
//                        documentation ```java\n@Override\npublic int getItemCount()\n```
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getItemCount().
    // RecyclerView calls this A LOT. The base class implementation does
    // getCurrentModels().size() which adds some overhead because of the method calls.
    // We can easily memoize this, which seems to help when there are lots of models.
    return itemCount;
//         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#itemCount.
  }

  /** This is set from whatever thread model building happened on, so must be thread safe. */
  void setModels(@NonNull ControllerModelList models) {
//     ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#setModels().
//               documentation ```java\nvoid setModels(ControllerModelList models)\n```
//               documentation This is set from whatever thread model building happened on, so must be thread safe. 
//                ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerModelList#
//                                            ^^^^^^ definition local 3
//                                                   documentation ```java\n@NonNull\nControllerModelList models\n```
    // If debug model validations are on then we should help detect the error case where models
    // were incorrectly mutated once they were added. That check is also done before and after
    // bind, but there is no other check after that to see if a model is incorrectly
    // mutated after being bound.
    // If a data class inside a model is mutated, then when models are rebuilt the differ
    // will still recognize the old and new models as equal, even though the old model was changed.
    // To help catch that error case we check for mutations here, before running the differ.
    //
    // https://github.com/airbnb/epoxy/issues/805
    List<? extends EpoxyModel<?>> currentModels = getCurrentModels();
//  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                ^^^^^^^^^^^^^ definition local 4
//                                              documentation ```java\nList<? extends EpoxyModel<?>> currentModels\n```
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
    if (!currentModels.isEmpty() && currentModels.get(0).isDebugValidationEnabled()) {
//       ^^^^^^^^^^^^^ reference local 4
//                     ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
//                                  ^^^^^^^^^^^^^ reference local 4
//                                                ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                                       ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#isDebugValidationEnabled().
      for (int i = 0; i < currentModels.size(); i++) {
//             ^ definition local 5
//               documentation ```java\nint i\n```
//                    ^ reference local 5
//                        ^^^^^^^^^^^^^ reference local 4
//                                      ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
//                                              ^ reference local 5
        EpoxyModel<?> model = currentModels.get(i);
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                    ^^^^^ definition local 6
//                          documentation ```java\nEpoxyModel<?> model\n```
//                            ^^^^^^^^^^^^^ reference local 4
//                                          ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                              ^ reference local 5
        model.validateStateHasNotChangedSinceAdded(
//      ^^^^^ reference local 6
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#validateStateHasNotChangedSinceAdded().
            "The model was changed between being bound and when models were rebuilt",
            i
//          ^ reference local 5
        );
      }
    }

    differ.submitList(models);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#submitList().
//                    ^^^^^^ reference local 3
  }

  /**
   * @return True if a diff operation is in progress.
   */
  public boolean isDiffInProgress() {
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#isDiffInProgress().
//                                documentation ```java\npublic boolean isDiffInProgress()\n```
//                                documentation  @return True if a diff operation is in progress.\n
    return differ.isDiffInProgress();
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#isDiffInProgress().
  }

  // Called on diff results from the differ
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onResult(@NonNull DiffResult result) {
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onResult().
//                     documentation ```java\n@Override\npublic void onResult(DiffResult result)\n```
//                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#onResult().
//                      ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                                         ^^^^^^ definition local 7
//                                                documentation ```java\n@NonNull\nDiffResult result\n```
    itemCount = result.newModels.size();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#itemCount.
//              ^^^^^^ reference local 7
//                     ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#newModels.
//                               ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    notifyBlocker.allowChanges();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#allowChanges().
    result.dispatchTo(this);
//  ^^^^^^ reference local 7
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#dispatchTo().
    notifyBlocker.blockChanges();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#blockChanges().

    for (int i = modelBuildListeners.size() - 1; i >= 0; i--) {
//           ^ definition local 8
//             documentation ```java\nint i\n```
//               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                                   ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
//                                               ^ reference local 8
//                                                       ^ reference local 8
      modelBuildListeners.get(i).onModelBuildFinished(result);
//    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                        ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                            ^ reference local 8
//                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#onModelBuildFinished().
//                                                    ^^^^^^ reference local 7
    }
  }

  public void addModelBuildListener(OnModelBuildFinishedListener listener) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#addModelBuildListener().
//                                  documentation ```java\npublic void addModelBuildListener(OnModelBuildFinishedListener listener)\n```
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                               ^^^^^^^^ definition local 9
//                                                                        documentation ```java\nOnModelBuildFinishedListener listener\n```
    modelBuildListeners.add(listener);
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                      ^^^ reference semanticdb maven jdk 11 java/util/List#add().
//                          ^^^^^^^^ reference local 9
  }

  public void removeModelBuildListener(OnModelBuildFinishedListener listener) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#removeModelBuildListener().
//                                     documentation ```java\npublic void removeModelBuildListener(OnModelBuildFinishedListener listener)\n```
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                                  ^^^^^^^^ definition local 10
//                                                                           documentation ```java\nOnModelBuildFinishedListener listener\n```
    modelBuildListeners.remove(listener);
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                      ^^^^^^ reference semanticdb maven jdk 11 java/util/List#remove().
//                             ^^^^^^^^ reference local 10
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  boolean diffPayloadsEnabled() {
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#diffPayloadsEnabled().
//                            documentation ```java\n@Override\nboolean diffPayloadsEnabled()\n```
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#diffPayloadsEnabled().
    return true;
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onAttachedToRecyclerView().
//                                     documentation ```java\n@Override\npublic void onAttachedToRecyclerView(unresolved_type recyclerView)\n```
//                                      ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                           ^^^^^^^^^^^^ definition local 11
//                                                                        documentation ```java\n@NonNull\nunresolved_type recyclerView\n```
    super.onAttachedToRecyclerView(recyclerView);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onAttachedToRecyclerView#
//                                 ^^^^^^^^^^^^ reference local 11
    epoxyController.onAttachedToRecyclerViewInternal(recyclerView);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onAttachedToRecyclerViewInternal().
//                                                   ^^^^^^^^^^^^ reference local 11
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onDetachedFromRecyclerView().
//                                       documentation ```java\n@Override\npublic void onDetachedFromRecyclerView(unresolved_type recyclerView)\n```
//                                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onDetachedFromRecyclerView().
//                                        ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                             ^^^^^^^^^^^^ definition local 12
//                                                                          documentation ```java\n@NonNull\nunresolved_type recyclerView\n```
    super.onDetachedFromRecyclerView(recyclerView);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onDetachedFromRecyclerView().
//                                   ^^^^^^^^^^^^ reference local 12
    epoxyController.onDetachedFromRecyclerViewInternal(recyclerView);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onDetachedFromRecyclerViewInternal().
//                                                     ^^^^^^^^^^^^ reference local 12
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewAttachedToWindow(@NonNull EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onViewAttachedToWindow().
//                                   documentation ```java\n@Override\npublic void onViewAttachedToWindow(EpoxyViewHolder holder)\n```
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewAttachedToWindow().
//                                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                            ^^^^^^ definition local 13
//                                                                   documentation ```java\n@NonNull\nEpoxyViewHolder holder\n```
    super.onViewAttachedToWindow(holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewAttachedToWindow().
//                               ^^^^^^ reference local 13
    epoxyController.onViewAttachedToWindow(holder, holder.getModel());
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onViewAttachedToWindow().
//                                         ^^^^^^ reference local 13
//                                                 ^^^^^^ reference local 13
//                                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewDetachedFromWindow(@NonNull EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onViewDetachedFromWindow().
//                                     documentation ```java\n@Override\npublic void onViewDetachedFromWindow(EpoxyViewHolder holder)\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewDetachedFromWindow().
//                                      ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                              ^^^^^^ definition local 14
//                                                                     documentation ```java\n@NonNull\nEpoxyViewHolder holder\n```
    super.onViewDetachedFromWindow(holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewDetachedFromWindow().
//                                 ^^^^^^ reference local 14
    epoxyController.onViewDetachedFromWindow(holder, holder.getModel());
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onViewDetachedFromWindow().
//                                           ^^^^^^ reference local 14
//                                                   ^^^^^^ reference local 14
//                                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void onModelBound(@NonNull EpoxyViewHolder holder, @NonNull EpoxyModel<?> model,
//               ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onModelBound().
//                            documentation ```java\n@Override\nprotected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position, EpoxyModel<?> previouslyBoundModel)\n```
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+1).
//                             ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^ definition local 15
//                                                            documentation ```java\n@NonNull\nEpoxyViewHolder holder\n```
//                                                              ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                    ^^^^^ definition local 16
//                                                                                          documentation ```java\n@NonNull\nEpoxyModel<?> model\n```
      int position, @Nullable EpoxyModel<?> previouslyBoundModel) {
//        ^^^^^^^^ definition local 17
//                 documentation ```java\nint position\n```
//                   ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^^^^^^^^^^^^^^^^ definition local 18
//                                                               documentation ```java\n@Nullable\nEpoxyModel<?> previouslyBoundModel\n```
    epoxyController.onModelBound(holder, model, position, previouslyBoundModel);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onModelBound().
//                               ^^^^^^ reference local 15
//                                       ^^^^^ reference local 16
//                                              ^^^^^^^^ reference local 17
//                                                        ^^^^^^^^^^^^^^^^^^^^ reference local 18
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void onModelUnbound(@NonNull EpoxyViewHolder holder, @NonNull EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onModelUnbound().
//                              documentation ```java\n@Override\nprotected void onModelUnbound(EpoxyViewHolder holder, EpoxyModel<?> model)\n```
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelUnbound().
//                               ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                       ^^^^^^ definition local 19
//                                                              documentation ```java\n@NonNull\nEpoxyViewHolder holder\n```
//                                                                ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                      ^^^^^ definition local 20
//                                                                                            documentation ```java\n@NonNull\nEpoxyModel<?> model\n```
    epoxyController.onModelUnbound(holder, model);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onModelUnbound().
//                                 ^^^^^^ reference local 19
//                                         ^^^^^ reference local 20
  }

  /** Get an unmodifiable copy of the current models set on the adapter. */
  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public List<EpoxyModel<?>> getCopyOfModels() {
//       ^^^^ reference semanticdb maven jdk 11 java/util/List#
//            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCopyOfModels().
//                                           documentation ```java\n@NonNull\npublic List<EpoxyModel<?>> getCopyOfModels()\n```
//                                           documentation Get an unmodifiable copy of the current models set on the adapter. 
    //noinspection unchecked
    return (List<EpoxyModel<?>>) getCurrentModels();
//          ^^^^ reference semanticdb maven jdk 11 java/util/List#
//               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
  }

  /**
   * @throws IndexOutOfBoundsException If the given position is out of range of the current model
   *                                   list.
   */
  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public EpoxyModel<?> getModelAtPosition(int position) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelAtPosition().
//                                        documentation ```java\n@NonNull\npublic EpoxyModel<?> getModelAtPosition(int position)\n```
//                                        documentation  @throws IndexOutOfBoundsException If the given position is out of range of the current model\n                                   list.\n
//                                            ^^^^^^^^ definition local 21
//                                                     documentation ```java\nint position\n```
    return getCurrentModels().get(position);
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                            ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                ^^^^^^^^ reference local 21
  }

  /**
   * Searches the current model list for the model with the given id. Returns the matching model if
   * one is found, otherwise null is returned.
   */
  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  public EpoxyModel<?> getModelById(long id) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelById().
//                                  documentation ```java\n@Nullable\npublic EpoxyModel<?> getModelById(long id)\n```
//                                  documentation  Searches the current model list for the model with the given id. Returns the matching model if\n one is found, otherwise null is returned.\n
//                                       ^^ definition local 22
//                                          documentation ```java\nlong id\n```
    for (EpoxyModel<?> model : getCurrentModels()) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local 23
//                           documentation ```java\nEpoxyModel<?> model\n```
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
      if (model.id() == id) {
//        ^^^^^ reference local 23
//              ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
//                      ^^ reference local 22
        return model;
//             ^^^^^ reference local 23
      }
    }

    return null;
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getModelPosition(@NonNull EpoxyModel<?> targetModel) {
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelPosition().
//                            documentation ```java\n@Override\npublic int getModelPosition(EpoxyModel<?> targetModel)\n```
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                             ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                   ^^^^^^^^^^^ definition local 24
//                                                               documentation ```java\n@NonNull\nEpoxyModel<?> targetModel\n```
    int size = getCurrentModels().size();
//      ^^^^ definition local 25
//           documentation ```java\nint size\n```
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                                ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    for (int i = 0; i < size; i++) {
//           ^ definition local 26
//             documentation ```java\nint i\n```
//                  ^ reference local 26
//                      ^^^^ reference local 25
//                            ^ reference local 26
      EpoxyModel<?> model = getCurrentModels().get(i);
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^ definition local 27
//                        documentation ```java\nEpoxyModel<?> model\n```
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                                             ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                                 ^ reference local 26
      if (model.id() == targetModel.id()) {
//        ^^^^^ reference local 27
//              ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
//                      ^^^^^^^^^^^ reference local 24
//                                  ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
        return i;
//             ^ reference local 26
      }
    }

    return -1;
  }

  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public BoundViewHolders getBoundViewHolders() {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#
//                        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getBoundViewHolders().
//                                            documentation ```java\n@NonNull\n@Override\npublic BoundViewHolders getBoundViewHolders()\n```
//                                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
    return super.getBoundViewHolders();
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#super.
//               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
  }

  @UiThread
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/UiThread#
  void moveModel(int fromPosition, int toPosition) {
//     ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#moveModel().
//               documentation ```java\n@UiThread\nvoid moveModel(int fromPosition, int toPosition)\n```
//                   ^^^^^^^^^^^^ definition local 28
//                                documentation ```java\nint fromPosition\n```
//                                     ^^^^^^^^^^ definition local 29
//                                                documentation ```java\nint toPosition\n```
    ArrayList<EpoxyModel<?>> updatedList = new ArrayList<>(getCurrentModels());
//  ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^ definition local 30
//                                       documentation ```java\nArrayList<EpoxyModel<?>> updatedList\n```
//                                             ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+2).
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().

    updatedList.add(toPosition, updatedList.remove(fromPosition));
//  ^^^^^^^^^^^ reference local 30
//              ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add(+1).
//                  ^^^^^^^^^^ reference local 29
//                              ^^^^^^^^^^^ reference local 30
//                                          ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#remove().
//                                                 ^^^^^^^^^^^^ reference local 28
    notifyBlocker.allowChanges();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#allowChanges().
    notifyItemMoved(fromPosition, toPosition);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyItemMoved#
//                  ^^^^^^^^^^^^ reference local 28
//                                ^^^^^^^^^^ reference local 29
    notifyBlocker.blockChanges();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#blockChanges().

    boolean interruptedDiff = differ.forceListOverride(updatedList);
//          ^^^^^^^^^^^^^^^ definition local 31
//                          documentation ```java\nboolean interruptedDiff\n```
//                            ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#forceListOverride().
//                                                     ^^^^^^^^^^^ reference local 30

    if (interruptedDiff) {
//      ^^^^^^^^^^^^^^^ reference local 31
      // The move interrupted a model rebuild/diff that was in progress,
      // so models may be out of date and we should force them to rebuilt
      epoxyController.requestModelBuild();
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
    }
  }

  @UiThread
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/UiThread#
  void notifyModelChanged(int position) {
//     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyModelChanged().
//                        documentation ```java\n@UiThread\nvoid notifyModelChanged(int position)\n```
//                            ^^^^^^^^ definition local 32
//                                     documentation ```java\nint position\n```
    ArrayList<EpoxyModel<?>> updatedList = new ArrayList<>(getCurrentModels());
//  ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^ definition local 33
//                                       documentation ```java\nArrayList<EpoxyModel<?>> updatedList\n```
//                                             ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+2).
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().

    notifyBlocker.allowChanges();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#allowChanges().
    notifyItemChanged(position);
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyItemChanged#
//                    ^^^^^^^^ reference local 32
    notifyBlocker.blockChanges();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#blockChanges().

    boolean interruptedDiff = differ.forceListOverride(updatedList);
//          ^^^^^^^^^^^^^^^ definition local 34
//                          documentation ```java\nboolean interruptedDiff\n```
//                            ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#forceListOverride().
//                                                     ^^^^^^^^^^^ reference local 33

    if (interruptedDiff) {
//      ^^^^^^^^^^^^^^^ reference local 34
      // The move interrupted a model rebuild/diff that was in progress,
      // so models may be out of date and we should force them to rebuilt
      epoxyController.requestModelBuild();
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
    }
  }

  private static final ItemCallback<EpoxyModel<?>> ITEM_CALLBACK =
//                     ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#ITEM_CALLBACK.
//                                                               documentation ```java\nprivate static final unresolved_type ITEM_CALLBACK\n```
      new ItemCallback<EpoxyModel<?>>() {
        @Override
        public boolean areItemsTheSame(EpoxyModel<?> oldItem, EpoxyModel<?> newItem) {
          return oldItem.id() == newItem.id();
        }

        @Override
        public boolean areContentsTheSame(EpoxyModel<?> oldItem, EpoxyModel<?> newItem) {
          return oldItem.equals(newItem);
        }

        @Override
        public Object getChangePayload(EpoxyModel<?> oldItem, EpoxyModel<?> newItem) {
          return new DiffPayload(oldItem);
        }
      };

  /**
   * Delegates the callbacks received in the adapter
   * to the controller.
   */
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean isStickyHeader(int position) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#isStickyHeader().
//                              documentation ```java\n@Override\npublic boolean isStickyHeader(int position)\n```
//                              documentation  Delegates the callbacks received in the adapter\n to the controller.\n
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#isStickyHeader().
//                                  ^^^^^^^^ definition local 35
//                                           documentation ```java\nint position\n```
    return epoxyController.isStickyHeader(position);
//         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                         ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#isStickyHeader().
//                                        ^^^^^^^^ reference local 35
  }

  /**
   * Delegates the callbacks received in the adapter
   * to the controller.
   */
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void setupStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#setupStickyHeaderView().
//                                  documentation ```java\n@Override\npublic void setupStickyHeaderView(unresolved_type stickyHeader)\n```
//                                  documentation  Delegates the callbacks received in the adapter\n to the controller.\n
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#setupStickyHeaderView().
//                                   ^^^^^^^ reference semanticdb maven maven/org.jetbrains/annotations 13.0 org/jetbrains/annotations/NotNull#
//                                           ^^^^ reference semanticdb maven . . _root_/
//                                                ^^^^^^^^^^^^ definition local 36
//                                                             documentation ```java\n@NotNull\nunresolved_type stickyHeader\n```
    epoxyController.setupStickyHeaderView(stickyHeader);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#setupStickyHeaderView().
//                                        ^^^^^^^^^^^^ reference local 36
  }

  /**
   * Delegates the callbacks received in the adapter
   * to the controller.
   */
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void teardownStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#teardownStickyHeaderView().
//                                     documentation ```java\n@Override\npublic void teardownStickyHeaderView(unresolved_type stickyHeader)\n```
//                                     documentation  Delegates the callbacks received in the adapter\n to the controller.\n
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#teardownStickyHeaderView().
//                                      ^^^^^^^ reference semanticdb maven maven/org.jetbrains/annotations 13.0 org/jetbrains/annotations/NotNull#
//                                              ^^^^ reference semanticdb maven . . _root_/
//                                                   ^^^^^^^^^^^^ definition local 37
//                                                                documentation ```java\n@NotNull\nunresolved_type stickyHeader\n```
    epoxyController.teardownStickyHeaderView(stickyHeader);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#teardownStickyHeaderView().
//                                           ^^^^^^^^^^^^ reference local 37
  }
}
