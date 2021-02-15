package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference android/
//             ^^ reference android/os/
//                ^^^^^^^ reference android/os/Handler#
import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#

import com.airbnb.epoxy.AsyncEpoxyDiffer.ResultCallback;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#
//                                       ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#

import org.jetbrains.annotations.NotNull;
//     ^^^ reference org/
//         ^^^^^^^^^ reference org/jetbrains/
//                   ^^^^^^^^^^^ reference org/jetbrains/annotations/
//                               ^^^^^^^ reference org/jetbrains/annotations/NotNull#

import java.util.ArrayList;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^ reference java/util/ArrayList#
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
import androidx.annotation.UiThread;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/UiThread#
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^ reference androidx/recyclerview/widget/DiffUtil/
//                                           ^^^^^^^^^^^^ reference androidx/recyclerview/widget/DiffUtil/ItemCallback#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView#

public final class EpoxyControllerAdapter extends BaseEpoxyAdapter implements ResultCallback {
//           ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#
//                                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#
//                                                                            ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
  private final NotifyBlocker notifyBlocker = new NotifyBlocker();
//              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#
//                            ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                                            ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#`<init>`().
//                                                ^^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#
  private final AsyncEpoxyDiffer differ;
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#
//                               ^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#differ.
  private final EpoxyController epoxyController;
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
  private int itemCount;
//            ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#itemCount.
  private final List<OnModelBuildFinishedListener> modelBuildListeners = new ArrayList<>();
//              ^^^^ reference java/util/List#
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                 ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                                                                       ^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`(+1).
//                                                                           ^^^^^^^^^ reference java/util/ArrayList#

  EpoxyControllerAdapter(@NonNull EpoxyController epoxyController, Handler diffingHandler) {
  ^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#`<init>`().
//                        ^^^^^^^ reference androidx/annotation/NonNull#
//                                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                                ^^^^^^^^^^^^^^^ definition local0
//                                                                 ^^^^^^^ reference _root_/
//                                                                         ^^^^^^^^^^^^^^ definition local1
    this.epoxyController = epoxyController;
//  ^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#this.
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                         ^^^^^^^^^^^^^^^ reference local0
    differ = new AsyncEpoxyDiffer(
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//           ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#`<init>`(). 4:5
//               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#
        diffingHandler,
//      ^^^^^^^^^^^^^^ reference local1
        this,
//      ^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#this.
        ITEM_CALLBACK
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#ITEM_CALLBACK.
    );
    registerAdapterDataObserver(notifyBlocker);
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#registerAdapterDataObserver#
//                              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  protected void onExceptionSwallowed(@NonNull RuntimeException exception) {
//               ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onExceptionSwallowed().
//                                     ^^^^^^^ reference androidx/annotation/NonNull#
//                                             ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
//                                                              ^^^^^^^^^ definition local2
    epoxyController.onExceptionSwallowed(exception);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onExceptionSwallowed().
//                                       ^^^^^^^^^ reference local2
  }

  @NonNull
   ^^^^^^^ reference androidx/annotation/NonNull#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  List<? extends EpoxyModel<?>> getCurrentModels() {
  ^^^^ reference java/util/List#
//               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
    return differ.getCurrentList();
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#getCurrentList().
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public int getItemCount() {
//           ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getItemCount().
    // RecyclerView calls this A LOT. The base class implementation does
    // getCurrentModels().size() which adds some overhead because of the method calls.
    // We can easily memoize this, which seems to help when there are lots of models.
    return itemCount;
//         ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#itemCount.
  }

  /** This is set from whatever thread model building happened on, so must be thread safe. */
  void setModels(@NonNull ControllerModelList models) {
//     ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#setModels().
//                ^^^^^^^ reference androidx/annotation/NonNull#
//                        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerModelList#
//                                            ^^^^^^ definition local3
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
//  ^^^^ reference java/util/List#
//                 ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                ^^^^^^^^^^^^^ definition local4
//                                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
    if (!currentModels.isEmpty() && currentModels.get(0).isDebugValidationEnabled()) {
//       ^^^^^^^^^^^^^ reference local4
//                     ^^^^^^^ reference java/util/List#isEmpty().
//                                  ^^^^^^^^^^^^^ reference local4
//                                                ^^^ reference java/util/List#get().
//                                                       ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#isDebugValidationEnabled().
      for (int i = 0; i < currentModels.size(); i++) {
//             ^ definition local5
//                    ^ reference local5
//                        ^^^^^^^^^^^^^ reference local4
//                                      ^^^^ reference java/util/List#size().
//                                              ^ reference local5
        EpoxyModel<?> model = currentModels.get(i);
//      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                    ^^^^^ definition local6
//                            ^^^^^^^^^^^^^ reference local4
//                                          ^^^ reference java/util/List#get().
//                                              ^ reference local5
        model.validateStateHasNotChangedSinceAdded(
//      ^^^^^ reference local6
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#validateStateHasNotChangedSinceAdded().
            "The model was changed between being bound and when models were rebuilt",
            i
//          ^ reference local5
        );
      }
    }

    differ.submitList(models);
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//         ^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#submitList().
//                    ^^^^^^ reference local3
  }

  /**
   * @return True if a diff operation is in progress.
   */
  public boolean isDiffInProgress() {
//               ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#isDiffInProgress().
    return differ.isDiffInProgress();
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#isDiffInProgress().
  }

  // Called on diff results from the differ
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onResult(@NonNull DiffResult result) {
//            ^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onResult().
//                      ^^^^^^^ reference androidx/annotation/NonNull#
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                                         ^^^^^^ definition local7
    itemCount = result.newModels.size();
//  ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#itemCount.
//              ^^^^^^ reference local7
//                     ^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#newModels.
//                               ^^^^ reference java/util/List#size().
    notifyBlocker.allowChanges();
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#allowChanges().
    result.dispatchTo(this);
//  ^^^^^^ reference local7
//         ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#dispatchTo().
//                    ^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#this.
    notifyBlocker.blockChanges();
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#blockChanges().

    for (int i = modelBuildListeners.size() - 1; i >= 0; i--) {
//           ^ definition local8
//               ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                                   ^^^^ reference java/util/List#size().
//                                               ^ reference local8
//                                                       ^ reference local8
      modelBuildListeners.get(i).onModelBuildFinished(result);
//    ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                        ^^^ reference java/util/List#get().
//                            ^ reference local8
//                               ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/OnModelBuildFinishedListener#onModelBuildFinished().
//                                                    ^^^^^^ reference local7
    }
  }

  public void addModelBuildListener(OnModelBuildFinishedListener listener) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#addModelBuildListener().
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                               ^^^^^^^^ definition local9
    modelBuildListeners.add(listener);
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                      ^^^ reference java/util/List#add().
//                          ^^^^^^^^ reference local9
  }

  public void removeModelBuildListener(OnModelBuildFinishedListener listener) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#removeModelBuildListener().
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                                  ^^^^^^^^ definition local10
    modelBuildListeners.remove(listener);
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                      ^^^^^^ reference java/util/List#remove().
//                             ^^^^^^^^ reference local10
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  boolean diffPayloadsEnabled() {
//        ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#diffPayloadsEnabled().
    return true;
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onAttachedToRecyclerView().
//                                      ^^^^^^^ reference androidx/annotation/NonNull#
//                                              ^^^^^^^^^^^^ reference _root_/
//                                                           ^^^^^^^^^^^^ definition local11
    super.onAttachedToRecyclerView(recyclerView);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onAttachedToRecyclerView#
//                                 ^^^^^^^^^^^^ reference local11
    epoxyController.onAttachedToRecyclerViewInternal(recyclerView);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onAttachedToRecyclerViewInternal().
//                                                   ^^^^^^^^^^^^ reference local11
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onDetachedFromRecyclerView().
//                                        ^^^^^^^ reference androidx/annotation/NonNull#
//                                                ^^^^^^^^^^^^ reference _root_/
//                                                             ^^^^^^^^^^^^ definition local12
    super.onDetachedFromRecyclerView(recyclerView);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onDetachedFromRecyclerView().
//                                   ^^^^^^^^^^^^ reference local12
    epoxyController.onDetachedFromRecyclerViewInternal(recyclerView);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onDetachedFromRecyclerViewInternal().
//                                                     ^^^^^^^^^^^^ reference local12
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onViewAttachedToWindow(@NonNull EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onViewAttachedToWindow().
//                                    ^^^^^^^ reference androidx/annotation/NonNull#
//                                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                            ^^^^^^ definition local13
    super.onViewAttachedToWindow(holder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onViewAttachedToWindow().
//                               ^^^^^^ reference local13
    epoxyController.onViewAttachedToWindow(holder, holder.getModel());
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onViewAttachedToWindow().
//                                         ^^^^^^ reference local13
//                                                 ^^^^^^ reference local13
//                                                        ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onViewDetachedFromWindow(@NonNull EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onViewDetachedFromWindow().
//                                      ^^^^^^^ reference androidx/annotation/NonNull#
//                                              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                              ^^^^^^ definition local14
    super.onViewDetachedFromWindow(holder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onViewDetachedFromWindow().
//                                 ^^^^^^ reference local14
    epoxyController.onViewDetachedFromWindow(holder, holder.getModel());
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onViewDetachedFromWindow().
//                                           ^^^^^^ reference local14
//                                                   ^^^^^^ reference local14
//                                                          ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  protected void onModelBound(@NonNull EpoxyViewHolder holder, @NonNull EpoxyModel<?> model,
//               ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onModelBound().
//                             ^^^^^^^ reference androidx/annotation/NonNull#
//                                     ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^ definition local15
//                                                              ^^^^^^^ reference androidx/annotation/NonNull#
//                                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                    ^^^^^ definition local16
      int position, @Nullable EpoxyModel<?> previouslyBoundModel) {
//        ^^^^^^^^ definition local17
//                   ^^^^^^^^ reference androidx/annotation/Nullable#
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^^^^^^^^^^^^^^^^ definition local18
    epoxyController.onModelBound(holder, model, position, previouslyBoundModel);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onModelBound().
//                               ^^^^^^ reference local15
//                                       ^^^^^ reference local16
//                                              ^^^^^^^^ reference local17
//                                                        ^^^^^^^^^^^^^^^^^^^^ reference local18
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  protected void onModelUnbound(@NonNull EpoxyViewHolder holder, @NonNull EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onModelUnbound().
//                               ^^^^^^^ reference androidx/annotation/NonNull#
//                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                       ^^^^^^ definition local19
//                                                                ^^^^^^^ reference androidx/annotation/NonNull#
//                                                                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                      ^^^^^ definition local20
    epoxyController.onModelUnbound(holder, model);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onModelUnbound().
//                                 ^^^^^^ reference local19
//                                         ^^^^^ reference local20
  }

  /** Get an unmodifiable copy of the current models set on the adapter. */
  @NonNull
   ^^^^^^^ reference androidx/annotation/NonNull#
  public List<EpoxyModel<?>> getCopyOfModels() {
//       ^^^^ reference java/util/List#
//            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getCopyOfModels().
    //noinspection unchecked
    return (List<EpoxyModel<?>>) getCurrentModels();
//          ^^^^ reference java/util/List#
//               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
  }

  /**
   * @throws IndexOutOfBoundsException If the given position is out of range of the current model
   *                                   list.
   */
  @NonNull
   ^^^^^^^ reference androidx/annotation/NonNull#
  public EpoxyModel<?> getModelAtPosition(int position) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getModelAtPosition().
//                                            ^^^^^^^^ definition local21
    return getCurrentModels().get(position);
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                            ^^^ reference java/util/List#get().
//                                ^^^^^^^^ reference local21
  }

  /**
   * Searches the current model list for the model with the given id. Returns the matching model if
   * one is found, otherwise null is returned.
   */
  @Nullable
   ^^^^^^^^ reference androidx/annotation/Nullable#
  public EpoxyModel<?> getModelById(long id) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getModelById().
//                                       ^^ definition local22
    for (EpoxyModel<?> model : getCurrentModels()) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local23
//                             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
      if (model.id() == id) {
//        ^^^^^ reference local23
//              ^^ reference com/airbnb/epoxy/EpoxyModel#id(+1).
//                      ^^ reference local22
        return model;
//             ^^^^^ reference local23
      }
    }

    return null;
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public int getModelPosition(@NonNull EpoxyModel<?> targetModel) {
//           ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getModelPosition().
//                             ^^^^^^^ reference androidx/annotation/NonNull#
//                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                   ^^^^^^^^^^^ definition local24
    int size = getCurrentModels().size();
//      ^^^^ definition local25
//             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                                ^^^^ reference java/util/List#size().
    for (int i = 0; i < size; i++) {
//           ^ definition local26
//                  ^ reference local26
//                      ^^^^ reference local25
//                            ^ reference local26
      EpoxyModel<?> model = getCurrentModels().get(i);
//    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^ definition local27
//                          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                                             ^^^ reference java/util/List#get().
//                                                 ^ reference local26
      if (model.id() == targetModel.id()) {
//        ^^^^^ reference local27
//              ^^ reference com/airbnb/epoxy/EpoxyModel#id(+1).
//                      ^^^^^^^^^^^ reference local24
//                                  ^^ reference com/airbnb/epoxy/EpoxyModel#id(+1).
        return i;
//             ^ reference local26
      }
    }

    return -1;
  }

  @NonNull
   ^^^^^^^ reference androidx/annotation/NonNull#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public BoundViewHolders getBoundViewHolders() {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#
//                        ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getBoundViewHolders().
    return super.getBoundViewHolders();
//         ^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#super.
//               ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
  }

  @UiThread
   ^^^^^^^^ reference androidx/annotation/UiThread#
  void moveModel(int fromPosition, int toPosition) {
//     ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#moveModel().
//                   ^^^^^^^^^^^^ definition local28
//                                     ^^^^^^^^^^ definition local29
    ArrayList<EpoxyModel<?>> updatedList = new ArrayList<>(getCurrentModels());
//  ^^^^^^^^^ reference java/util/ArrayList#
//            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^ definition local30
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`(+2).
//                                             ^^^^^^^^^ reference java/util/ArrayList#
//                                                         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().

    updatedList.add(toPosition, updatedList.remove(fromPosition));
//  ^^^^^^^^^^^ reference local30
//              ^^^ reference java/util/ArrayList#add(+1).
//                  ^^^^^^^^^^ reference local29
//                              ^^^^^^^^^^^ reference local30
//                                          ^^^^^^ reference java/util/ArrayList#remove().
//                                                 ^^^^^^^^^^^^ reference local28
    notifyBlocker.allowChanges();
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#allowChanges().
    notifyItemMoved(fromPosition, toPosition);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#notifyItemMoved#
//                  ^^^^^^^^^^^^ reference local28
//                                ^^^^^^^^^^ reference local29
    notifyBlocker.blockChanges();
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#blockChanges().

    boolean interruptedDiff = differ.forceListOverride(updatedList);
//          ^^^^^^^^^^^^^^^ definition local31
//                            ^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                                   ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#forceListOverride().
//                                                     ^^^^^^^^^^^ reference local30

    if (interruptedDiff) {
//      ^^^^^^^^^^^^^^^ reference local31
      // The move interrupted a model rebuild/diff that was in progress,
      // so models may be out of date and we should force them to rebuilt
      epoxyController.requestModelBuild();
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#requestModelBuild().
    }
  }

  @UiThread
   ^^^^^^^^ reference androidx/annotation/UiThread#
  void notifyModelChanged(int position) {
//     ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#notifyModelChanged().
//                            ^^^^^^^^ definition local32
    ArrayList<EpoxyModel<?>> updatedList = new ArrayList<>(getCurrentModels());
//  ^^^^^^^^^ reference java/util/ArrayList#
//            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^ definition local33
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`(+2).
//                                             ^^^^^^^^^ reference java/util/ArrayList#
//                                                         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().

    notifyBlocker.allowChanges();
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#allowChanges().
    notifyItemChanged(position);
//  ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#notifyItemChanged#
//                    ^^^^^^^^ reference local32
    notifyBlocker.blockChanges();
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#blockChanges().

    boolean interruptedDiff = differ.forceListOverride(updatedList);
//          ^^^^^^^^^^^^^^^ definition local34
//                            ^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                                   ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#forceListOverride().
//                                                     ^^^^^^^^^^^ reference local33

    if (interruptedDiff) {
//      ^^^^^^^^^^^^^^^ reference local34
      // The move interrupted a model rebuild/diff that was in progress,
      // so models may be out of date and we should force them to rebuilt
      epoxyController.requestModelBuild();
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#requestModelBuild().
    }
  }

  private static final ItemCallback<EpoxyModel<?>> ITEM_CALLBACK =
//                     ^^^^^^^^^^^^ reference _root_/
//                                  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#ITEM_CALLBACK.
      new ItemCallback<EpoxyModel<?>>() {
//        ^^^^^^^^^^^^ reference _root_/
//                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
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
   ^^^^^^^^ reference java/lang/Override#
  public boolean isStickyHeader(int position) {
//               ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#isStickyHeader().
//                                  ^^^^^^^^ definition local35
    return epoxyController.isStickyHeader(position);
//         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                         ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#isStickyHeader().
//                                        ^^^^^^^^ reference local35
  }

  /**
   * Delegates the callbacks received in the adapter
   * to the controller.
   */
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void setupStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#setupStickyHeaderView().
//                                   ^^^^^^^ reference org/jetbrains/annotations/NotNull#
//                                           ^^^^ reference _root_/
//                                                ^^^^^^^^^^^^ definition local36
    epoxyController.setupStickyHeaderView(stickyHeader);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#setupStickyHeaderView().
//                                        ^^^^^^^^^^^^ reference local36
  }

  /**
   * Delegates the callbacks received in the adapter
   * to the controller.
   */
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void teardownStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#teardownStickyHeaderView().
//                                      ^^^^^^^ reference org/jetbrains/annotations/NotNull#
//                                              ^^^^ reference _root_/
//                                                   ^^^^^^^^^^^^ definition local37
    epoxyController.teardownStickyHeaderView(stickyHeader);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#teardownStickyHeaderView().
//                                           ^^^^^^^^^^^^ reference local37
  }
}
