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
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter# public final class EpoxyControllerAdapter
//                                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#
//                                                                            ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
  private final NotifyBlocker notifyBlocker = new NotifyBlocker();
//              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#
//                            ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker. private final NotifyBlocker notifyBlocker
//                                                ^^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#`<init>`().
  private final AsyncEpoxyDiffer differ;
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#
//                               ^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#differ. private final AsyncEpoxyDiffer differ
  private final EpoxyController epoxyController;
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController. private final EpoxyController epoxyController
  private int itemCount;
//            ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#itemCount. private int itemCount
  private final List<OnModelBuildFinishedListener> modelBuildListeners = new ArrayList<>();
//              ^^^^ reference java/util/List#
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                 ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners. private final List<OnModelBuildFinishedListener> modelBuildListeners
//                                                                           ^^^^^^^^^ reference java/util/ArrayList#`<init>`(+1).

  EpoxyControllerAdapter(@NonNull EpoxyController epoxyController, Handler diffingHandler) {
//^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#`<init>`(). EpoxyControllerAdapter(EpoxyController epoxyController, unresolved_type diffingHandler)
//                        ^^^^^^^ reference androidx/annotation/NonNull#
//                                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                                ^^^^^^^^^^^^^^^ definition local0 @NonNull EpoxyController epoxyController
//                                                                 ^^^^^^^ reference _root_/
//                                                                         ^^^^^^^^^^^^^^ definition local1 unresolved_type diffingHandler
    this.epoxyController = epoxyController;
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                         ^^^^^^^^^^^^^^^ reference local0
    differ = new AsyncEpoxyDiffer(
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#`<init>`().
        diffingHandler,
//      ^^^^^^^^^^^^^^ reference local1
        this,
        ITEM_CALLBACK
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#ITEM_CALLBACK.
    );
    registerAdapterDataObserver(notifyBlocker);
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#registerAdapterDataObserver#
//                              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected void onExceptionSwallowed(@NonNull RuntimeException exception) {
//               ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onExceptionSwallowed(). @Override protected void onExceptionSwallowed(RuntimeException exception)
//                                     ^^^^^^^ reference androidx/annotation/NonNull#
//                                             ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
//                                                              ^^^^^^^^^ definition local2 @NonNull RuntimeException exception
    epoxyController.onExceptionSwallowed(exception);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onExceptionSwallowed().
//                                       ^^^^^^^^^ reference local2
  }

  @NonNull
// ^^^^^^^ reference androidx/annotation/NonNull#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  List<? extends EpoxyModel<?>> getCurrentModels() {
//^^^^ reference java/util/List#
//               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels(). @NonNull @Override List<? extends EpoxyModel<?>> getCurrentModels()
    return differ.getCurrentList();
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#getCurrentList().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public int getItemCount() {
//           ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getItemCount(). @Override public int getItemCount()
    // RecyclerView calls this A LOT. The base class implementation does
    // getCurrentModels().size() which adds some overhead because of the method calls.
    // We can easily memoize this, which seems to help when there are lots of models.
    return itemCount;
//         ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#itemCount.
  }

  /** This is set from whatever thread model building happened on, so must be thread safe. */
  void setModels(@NonNull ControllerModelList models) {
//     ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#setModels(). void setModels(ControllerModelList models)
//                ^^^^^^^ reference androidx/annotation/NonNull#
//                        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerModelList#
//                                            ^^^^^^ definition local3 @NonNull ControllerModelList models
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
//                                ^^^^^^^^^^^^^ definition local4 List<? extends EpoxyModel<?>> currentModels
//                                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
    if (!currentModels.isEmpty() && currentModels.get(0).isDebugValidationEnabled()) {
//       ^^^^^^^^^^^^^ reference local4
//                     ^^^^^^^ reference java/util/List#isEmpty().
//                                  ^^^^^^^^^^^^^ reference local4
//                                                ^^^ reference java/util/List#get().
//                                                       ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#isDebugValidationEnabled().
      for (int i = 0; i < currentModels.size(); i++) {
//             ^ definition local5 int i
//                    ^ reference local5
//                        ^^^^^^^^^^^^^ reference local4
//                                      ^^^^ reference java/util/List#size().
//                                              ^ reference local5
        EpoxyModel<?> model = currentModels.get(i);
//      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                    ^^^^^ definition local6 EpoxyModel<?> model
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
//               ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#isDiffInProgress(). public boolean isDiffInProgress()
    return differ.isDiffInProgress();
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/AsyncEpoxyDiffer#isDiffInProgress().
  }

  // Called on diff results from the differ
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onResult(@NonNull DiffResult result) {
//            ^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onResult(). @Override public void onResult(DiffResult result)
//                      ^^^^^^^ reference androidx/annotation/NonNull#
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                                         ^^^^^^ definition local7 @NonNull DiffResult result
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
    notifyBlocker.blockChanges();
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#blockChanges().

    for (int i = modelBuildListeners.size() - 1; i >= 0; i--) {
//           ^ definition local8 int i
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
//            ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#addModelBuildListener(). public void addModelBuildListener(OnModelBuildFinishedListener listener)
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                               ^^^^^^^^ definition local9 OnModelBuildFinishedListener listener
    modelBuildListeners.add(listener);
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                      ^^^ reference java/util/List#add().
//                          ^^^^^^^^ reference local9
  }

  public void removeModelBuildListener(OnModelBuildFinishedListener listener) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#removeModelBuildListener(). public void removeModelBuildListener(OnModelBuildFinishedListener listener)
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                                  ^^^^^^^^ definition local10 OnModelBuildFinishedListener listener
    modelBuildListeners.remove(listener);
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                      ^^^^^^ reference java/util/List#remove().
//                             ^^^^^^^^ reference local10
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  boolean diffPayloadsEnabled() {
//        ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#diffPayloadsEnabled(). @Override boolean diffPayloadsEnabled()
    return true;
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onAttachedToRecyclerView(). @Override public void onAttachedToRecyclerView(unresolved_type recyclerView)
//                                      ^^^^^^^ reference androidx/annotation/NonNull#
//                                              ^^^^^^^^^^^^ reference _root_/
//                                                           ^^^^^^^^^^^^ definition local11 @NonNull unresolved_type recyclerView
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
// ^^^^^^^^ reference java/lang/Override#
  public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onDetachedFromRecyclerView(). @Override public void onDetachedFromRecyclerView(unresolved_type recyclerView)
//                                        ^^^^^^^ reference androidx/annotation/NonNull#
//                                                ^^^^^^^^^^^^ reference _root_/
//                                                             ^^^^^^^^^^^^ definition local12 @NonNull unresolved_type recyclerView
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
// ^^^^^^^^ reference java/lang/Override#
  public void onViewAttachedToWindow(@NonNull EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onViewAttachedToWindow(). @Override public void onViewAttachedToWindow(EpoxyViewHolder holder)
//                                    ^^^^^^^ reference androidx/annotation/NonNull#
//                                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                            ^^^^^^ definition local13 @NonNull EpoxyViewHolder holder
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
// ^^^^^^^^ reference java/lang/Override#
  public void onViewDetachedFromWindow(@NonNull EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onViewDetachedFromWindow(). @Override public void onViewDetachedFromWindow(EpoxyViewHolder holder)
//                                      ^^^^^^^ reference androidx/annotation/NonNull#
//                                              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                              ^^^^^^ definition local14 @NonNull EpoxyViewHolder holder
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
// ^^^^^^^^ reference java/lang/Override#
  protected void onModelBound(@NonNull EpoxyViewHolder holder, @NonNull EpoxyModel<?> model,
//               ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onModelBound(). @Override protected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position, EpoxyModel<?> previouslyBoundModel)
//                             ^^^^^^^ reference androidx/annotation/NonNull#
//                                     ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^ definition local15 @NonNull EpoxyViewHolder holder
//                                                              ^^^^^^^ reference androidx/annotation/NonNull#
//                                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                    ^^^^^ definition local16 @NonNull EpoxyModel<?> model
      int position, @Nullable EpoxyModel<?> previouslyBoundModel) {
//        ^^^^^^^^ definition local17 int position
//                   ^^^^^^^^ reference androidx/annotation/Nullable#
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^^^^^^^^^^^^^^^^ definition local18 @Nullable EpoxyModel<?> previouslyBoundModel
    epoxyController.onModelBound(holder, model, position, previouslyBoundModel);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onModelBound().
//                               ^^^^^^ reference local15
//                                       ^^^^^ reference local16
//                                              ^^^^^^^^ reference local17
//                                                        ^^^^^^^^^^^^^^^^^^^^ reference local18
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected void onModelUnbound(@NonNull EpoxyViewHolder holder, @NonNull EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#onModelUnbound(). @Override protected void onModelUnbound(EpoxyViewHolder holder, EpoxyModel<?> model)
//                               ^^^^^^^ reference androidx/annotation/NonNull#
//                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                       ^^^^^^ definition local19 @NonNull EpoxyViewHolder holder
//                                                                ^^^^^^^ reference androidx/annotation/NonNull#
//                                                                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                      ^^^^^ definition local20 @NonNull EpoxyModel<?> model
    epoxyController.onModelUnbound(holder, model);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#onModelUnbound().
//                                 ^^^^^^ reference local19
//                                         ^^^^^ reference local20
  }

  /** Get an unmodifiable copy of the current models set on the adapter. */
  @NonNull
// ^^^^^^^ reference androidx/annotation/NonNull#
  public List<EpoxyModel<?>> getCopyOfModels() {
//       ^^^^ reference java/util/List#
//            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getCopyOfModels(). @NonNull public List<EpoxyModel<?>> getCopyOfModels()
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
// ^^^^^^^ reference androidx/annotation/NonNull#
  public EpoxyModel<?> getModelAtPosition(int position) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getModelAtPosition(). @NonNull public EpoxyModel<?> getModelAtPosition(int position)
//                                            ^^^^^^^^ definition local21 int position
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
// ^^^^^^^^ reference androidx/annotation/Nullable#
  public EpoxyModel<?> getModelById(long id) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getModelById(). @Nullable public EpoxyModel<?> getModelById(long id)
//                                       ^^ definition local22 long id
    for (EpoxyModel<?> model : getCurrentModels()) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local23 EpoxyModel<?> model
//                             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
      if (model.id() == id) {
//        ^^^^^ reference local23
//              ^^ reference com/airbnb/epoxy/EpoxyModel#id().
//                      ^^ reference local22
        return model;
//             ^^^^^ reference local23
      }
    }

    return null;
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public int getModelPosition(@NonNull EpoxyModel<?> targetModel) {
//           ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getModelPosition(). @Override public int getModelPosition(EpoxyModel<?> targetModel)
//                             ^^^^^^^ reference androidx/annotation/NonNull#
//                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                   ^^^^^^^^^^^ definition local24 @NonNull EpoxyModel<?> targetModel
    int size = getCurrentModels().size();
//      ^^^^ definition local25 int size
//             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                                ^^^^ reference java/util/List#size().
    for (int i = 0; i < size; i++) {
//           ^ definition local26 int i
//                  ^ reference local26
//                      ^^^^ reference local25
//                            ^ reference local26
      EpoxyModel<?> model = getCurrentModels().get(i);
//    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^ definition local27 EpoxyModel<?> model
//                          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                                             ^^^ reference java/util/List#get().
//                                                 ^ reference local26
      if (model.id() == targetModel.id()) {
//        ^^^^^ reference local27
//              ^^ reference com/airbnb/epoxy/EpoxyModel#id().
//                      ^^^^^^^^^^^ reference local24
//                                  ^^ reference com/airbnb/epoxy/EpoxyModel#id().
        return i;
//             ^ reference local26
      }
    }

    return -1;
  }

  @NonNull
// ^^^^^^^ reference androidx/annotation/NonNull#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public BoundViewHolders getBoundViewHolders() {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#
//                        ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#getBoundViewHolders(). @NonNull @Override public BoundViewHolders getBoundViewHolders()
    return super.getBoundViewHolders();
//         ^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#super.
//               ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
  }

  @UiThread
// ^^^^^^^^ reference androidx/annotation/UiThread#
  void moveModel(int fromPosition, int toPosition) {
//     ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#moveModel(). @UiThread void moveModel(int fromPosition, int toPosition)
//                   ^^^^^^^^^^^^ definition local28 int fromPosition
//                                     ^^^^^^^^^^ definition local29 int toPosition
    ArrayList<EpoxyModel<?>> updatedList = new ArrayList<>(getCurrentModels());
//  ^^^^^^^^^ reference java/util/ArrayList#
//            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^ definition local30 ArrayList<EpoxyModel<?>> updatedList
//                                             ^^^^^^^^^ reference java/util/ArrayList#`<init>`(+2).
//                                                         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().

    updatedList.add(toPosition, updatedList.remove(fromPosition));
//  ^^^^^^^^^^^ reference local30
//              ^^^ reference java/util/ArrayList#add(+2).
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
//          ^^^^^^^^^^^^^^^ definition local31 boolean interruptedDiff
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
// ^^^^^^^^ reference androidx/annotation/UiThread#
  void notifyModelChanged(int position) {
//     ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#notifyModelChanged(). @UiThread void notifyModelChanged(int position)
//                            ^^^^^^^^ definition local32 int position
    ArrayList<EpoxyModel<?>> updatedList = new ArrayList<>(getCurrentModels());
//  ^^^^^^^^^ reference java/util/ArrayList#
//            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^ definition local33 ArrayList<EpoxyModel<?>> updatedList
//                                             ^^^^^^^^^ reference java/util/ArrayList#`<init>`(+2).
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
//          ^^^^^^^^^^^^^^^ definition local34 boolean interruptedDiff
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
//                                                 ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#ITEM_CALLBACK. private static final unresolved_type ITEM_CALLBACK
      new ItemCallback<EpoxyModel<?>>() {
//        ^^^^^^^^^^^^ reference _root_/
//                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
        @Override
//       ^^^^^^^^ reference java/lang/Override#
        public boolean areItemsTheSame(EpoxyModel<?> oldItem, EpoxyModel<?> newItem) {
//                     ^^^^^^^^^^^^^^^ definition local36 @Override public boolean areItemsTheSame(EpoxyModel<?> oldItem, EpoxyModel<?> newItem)
//                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                   ^^^^^^^ definition local39 EpoxyModel<?> oldItem
//                                                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                          ^^^^^^^ definition local40 EpoxyModel<?> newItem
          return oldItem.id() == newItem.id();
//               ^^^^^^^ reference local39
//                       ^^ reference com/airbnb/epoxy/EpoxyModel#id().
//                               ^^^^^^^ reference local40
//                                       ^^ reference com/airbnb/epoxy/EpoxyModel#id().
        }

        @Override
//       ^^^^^^^^ reference java/lang/Override#
        public boolean areContentsTheSame(EpoxyModel<?> oldItem, EpoxyModel<?> newItem) {
//                     ^^^^^^^^^^^^^^^^^^ definition local37 @Override public boolean areContentsTheSame(EpoxyModel<?> oldItem, EpoxyModel<?> newItem)
//                                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                      ^^^^^^^ definition local41 EpoxyModel<?> oldItem
//                                                               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                             ^^^^^^^ definition local42 EpoxyModel<?> newItem
          return oldItem.equals(newItem);
//               ^^^^^^^ reference local41
//                       ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#equals().
//                              ^^^^^^^ reference local42
        }

        @Override
//       ^^^^^^^^ reference java/lang/Override#
        public Object getChangePayload(EpoxyModel<?> oldItem, EpoxyModel<?> newItem) {
//             ^^^^^^ reference java/lang/Object#
//                    ^^^^^^^^^^^^^^^^ definition local38 @Override public Object getChangePayload(EpoxyModel<?> oldItem, EpoxyModel<?> newItem)
//                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                   ^^^^^^^ definition local43 EpoxyModel<?> oldItem
//                                                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                          ^^^^^^^ definition local44 EpoxyModel<?> newItem
          return new DiffPayload(oldItem);
//                   ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#`<init>`(+1).
//                               ^^^^^^^ reference local43
        }
      };

  /**
   * Delegates the callbacks received in the adapter
   * to the controller.
   */
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public boolean isStickyHeader(int position) {
//               ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#isStickyHeader(). @Override public boolean isStickyHeader(int position)
//                                  ^^^^^^^^ definition local45 int position
    return epoxyController.isStickyHeader(position);
//         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                         ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#isStickyHeader().
//                                        ^^^^^^^^ reference local45
  }

  /**
   * Delegates the callbacks received in the adapter
   * to the controller.
   */
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void setupStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#setupStickyHeaderView(). @Override public void setupStickyHeaderView(unresolved_type stickyHeader)
//                                   ^^^^^^^ reference org/jetbrains/annotations/NotNull#
//                                           ^^^^ reference _root_/
//                                                ^^^^^^^^^^^^ definition local46 @NotNull unresolved_type stickyHeader
    epoxyController.setupStickyHeaderView(stickyHeader);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#setupStickyHeaderView().
//                                        ^^^^^^^^^^^^ reference local46
  }

  /**
   * Delegates the callbacks received in the adapter
   * to the controller.
   */
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void teardownStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyControllerAdapter#teardownStickyHeaderView(). @Override public void teardownStickyHeaderView(unresolved_type stickyHeader)
//                                      ^^^^^^^ reference org/jetbrains/annotations/NotNull#
//                                              ^^^^ reference _root_/
//                                                   ^^^^^^^^^^^^ definition local47 @NotNull unresolved_type stickyHeader
    epoxyController.teardownStickyHeaderView(stickyHeader);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#teardownStickyHeaderView().
//                                           ^^^^^^^^^^^^ reference local47
  }
}
