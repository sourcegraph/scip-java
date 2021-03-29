package com.airbnb.epoxy;

import android.graphics.Canvas;
//     ^^^^^^^ reference android/
//             ^^^^^^^^ reference android/graphics/
//                      ^^^^^^ reference android/graphics/Canvas#
import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#

import com.airbnb.viewmodeladapter.R;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^^^^^^^^^^^^ reference com/airbnb/viewmodeladapter/
//                                 ^ reference com/airbnb/viewmodeladapter/R#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#
import androidx.recyclerview.widget.ItemTouchHelper;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/ItemTouchHelper#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView#

/**
 * A wrapper around {@link androidx.recyclerview.widget.ItemTouchHelper.Callback} to enable
 * easier touch support when working with Epoxy models.
 * <p>
 * For simplicity you can use {@link EpoxyTouchHelper} to set up touch handling via this class for
 * you instead of using this class directly. However, you may choose to use this class directly with
 * your own {@link ItemTouchHelper} if you need extra flexibility or customization.
 */
public abstract class EpoxyModelTouchCallback<T extends EpoxyModel>
//                    ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback# public abstract class EpoxyModelTouchCallback<T extends EpoxyModel> extends EpoxyTouchHelperCallback, EpoxyDragCallback<T>, EpoxySwipeCallback<T>
//                                            ^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#[T] T extends EpoxyModel
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
    extends EpoxyTouchHelperCallback implements EpoxyDragCallback<T>, EpoxySwipeCallback<T> {
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#
//                                              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyDragCallback#
//                                                                ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                                                    ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxySwipeCallback#
//                                                                                       ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]

  private static final int TOUCH_DEBOUNCE_MILLIS = 300;
//                         ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#TOUCH_DEBOUNCE_MILLIS. private static final int TOUCH_DEBOUNCE_MILLIS

  @Nullable private final EpoxyController controller;
// ^^^^^^^^ reference androidx/annotation/Nullable#
//                        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                        ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#controller. private final EpoxyController controller
  private final Class<T> targetModelClass;
//              ^^^^^ reference java/lang/Class#
//                    ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                       ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#targetModelClass. private final Class<T> targetModelClass
  private EpoxyViewHolder holderBeingDragged;
//        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                        ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged. private EpoxyViewHolder holderBeingDragged
  private EpoxyViewHolder holderBeingSwiped;
//        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                        ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped. private EpoxyViewHolder holderBeingSwiped

  public EpoxyModelTouchCallback(@Nullable EpoxyController controller, Class<T> targetModelClass) {
//       ^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#`<init>`(). public <init>(EpoxyController controller, Class<T> targetModelClass)
//                                ^^^^^^^^ reference androidx/annotation/Nullable#
//                                         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                                         ^^^^^^^^^^ definition local0 EpoxyController controller
//                                                                     ^^^^^ reference java/lang/Class#
//                                                                           ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                                                              ^^^^^^^^^^^^^^^^ definition local1 Class<T> targetModelClass
    this.controller = controller;
//  ^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#this.
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#controller.
//                    ^^^^^^^^^^ reference local0
    this.targetModelClass = targetModelClass;
//  ^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#this.
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#targetModelClass.
//                          ^^^^^^^^^^^^^^^^ reference local1
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected int getMovementFlags(RecyclerView recyclerView, EpoxyViewHolder viewHolder) {
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#getMovementFlags(). protected int getMovementFlags(unresolved_type recyclerView, EpoxyViewHolder viewHolder)
//                               ^^^^^^^^^^^^ reference _root_/
//                                            ^^^^^^^^^^^^ definition local2 unresolved_type recyclerView
//                                                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                          ^^^^^^^^^^ definition local3 EpoxyViewHolder viewHolder
    EpoxyModel<?> model = viewHolder.getModel();
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local4 EpoxyModel<?> model
//                        ^^^^^^^^^^ reference local3
//                                   ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().

    // If multiple touch callbacks are registered on the recyclerview (to support combinations of
    // dragging and dropping) then we won't want to enable anything if another
    // callback has a view actively selected.
    boolean isOtherCallbackActive =
//          ^^^^^^^^^^^^^^^^^^^^^ definition local5 boolean isOtherCallbackActive
        holderBeingDragged == null
//      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
            && holderBeingSwiped == null
//             ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
            && recyclerViewHasSelection(recyclerView);
//             ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#recyclerViewHasSelection().
//                                      ^^^^^^^^^^^^ reference local2

    if (!isOtherCallbackActive && isTouchableModel(model)) {
//       ^^^^^^^^^^^^^^^^^^^^^ reference local5
//                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                                                 ^^^^^ reference local4
      //noinspection unchecked
      return getMovementFlagsForModel((T) model, viewHolder.getAdapterPosition());
//           ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyTouchCallback#getMovementFlagsForModel().
//                                     ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                        ^^^^^ reference local4
//                                               ^^^^^^^^^^ reference local3
//                                                          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
    } else {
      return 0;
    }
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected boolean canDropOver(RecyclerView recyclerView, EpoxyViewHolder current,
//                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#canDropOver(). protected boolean canDropOver(unresolved_type recyclerView, EpoxyViewHolder current, EpoxyViewHolder target)
//                              ^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^^^^^^^ definition local6 unresolved_type recyclerView
//                                                         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                         ^^^^^^^ definition local7 EpoxyViewHolder current
      EpoxyViewHolder target) {
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local8 EpoxyViewHolder target
    // By default we don't allow dropping on a model that isn't a drag target
    return isTouchableModel(target.getModel());
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                          ^^^^^^ reference local8
//                                 ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
  }

  protected boolean isTouchableModel(EpoxyModel<?> model) {
//                  ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel(). protected boolean isTouchableModel(EpoxyModel<?> model)
//                                   ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^ definition local9 EpoxyModel<?> model
    return targetModelClass.isInstance(model);
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#targetModelClass.
//                          ^^^^^^^^^^ reference java/lang/Class#isInstance().
//                                     ^^^^^ reference local9
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected boolean onMove(RecyclerView recyclerView, EpoxyViewHolder viewHolder,
//                  ^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#onMove(). protected boolean onMove(unresolved_type recyclerView, EpoxyViewHolder viewHolder, EpoxyViewHolder target)
//                         ^^^^^^^^^^^^ reference _root_/
//                                      ^^^^^^^^^^^^ definition local10 unresolved_type recyclerView
//                                                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                    ^^^^^^^^^^ definition local11 EpoxyViewHolder viewHolder
      EpoxyViewHolder target) {
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local12 EpoxyViewHolder target

    if (controller == null) {
//      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#controller.
      throw new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 1:84
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
          "A controller must be provided in the constructor if dragging is enabled");
    }

    int fromPosition = viewHolder.getAdapterPosition();
//      ^^^^^^^^^^^^ definition local13 int fromPosition
//                     ^^^^^^^^^^ reference local11
//                                ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
    int toPosition = target.getAdapterPosition();
//      ^^^^^^^^^^ definition local14 int toPosition
//                   ^^^^^^ reference local12
//                          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
    controller.moveModel(fromPosition, toPosition);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#controller.
//             ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#moveModel().
//                       ^^^^^^^^^^^^ reference local13
//                                     ^^^^^^^^^^ reference local14

    EpoxyModel<?> model = viewHolder.getModel();
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local15 EpoxyModel<?> model
//                        ^^^^^^^^^^ reference local11
//                                   ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
    if (!isTouchableModel(model)) {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                        ^^^^^ reference local15
      throw new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 1:80
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
          "A model was dragged that is not a valid target: " + model.getClass());
//                                                             ^^^^^ reference local15
//                                                                   ^^^^^^^^ reference java/lang/Object#getClass().
    }

    //noinspection unchecked
    onModelMoved(fromPosition, toPosition, (T) model, viewHolder.itemView);
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#onModelMoved().
//               ^^^^^^^^^^^^ reference local13
//                             ^^^^^^^^^^ reference local14
//                                          ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                             ^^^^^ reference local15
//                                                    ^^^^^^^^^^ reference local11
//                                                               ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
    return true;
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved, View itemView) {
//            ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#onModelMoved(). public onModelMoved(int fromPosition, int toPosition, T modelBeingMoved, unresolved_type itemView)
//                             ^^^^^^^^^^^^ definition local16 int fromPosition
//                                               ^^^^^^^^^^ definition local17 int toPosition
//                                                           ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                                             ^^^^^^^^^^^^^^^ definition local18 T modelBeingMoved
//                                                                              ^^^^ reference _root_/
//                                                                                   ^^^^^^^^ definition local19 unresolved_type itemView

  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected void onSwiped(EpoxyViewHolder viewHolder, int direction) {
//               ^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#onSwiped(). protected onSwiped(EpoxyViewHolder viewHolder, int direction)
//                        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                        ^^^^^^^^^^ definition local20 EpoxyViewHolder viewHolder
//                                                        ^^^^^^^^^ definition local21 int direction
    EpoxyModel<?> model = viewHolder.getModel();
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local22 EpoxyModel<?> model
//                        ^^^^^^^^^^ reference local20
//                                   ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
    View view = viewHolder.itemView;
//  ^^^^ reference _root_/
//       ^^^^ definition local23 unresolved_type view
//              ^^^^^^^^^^ reference local20
//                         ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
    int position = viewHolder.getAdapterPosition();
//      ^^^^^^^^ definition local24 int position
//                 ^^^^^^^^^^ reference local20
//                            ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#

    if (!isTouchableModel(model)) {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                        ^^^^^ reference local22
      throw new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 1:79
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
          "A model was swiped that is not a valid target: " + model.getClass());
//                                                            ^^^^^ reference local22
//                                                                  ^^^^^^^^ reference java/lang/Object#getClass().
    }

    //noinspection unchecked
    onSwipeCompleted((T) model, view, position, direction);
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeCompleted().
//                    ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                       ^^^^^ reference local22
//                              ^^^^ reference local23
//                                    ^^^^^^^^ reference local24
//                                              ^^^^^^^^^ reference local21
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onSwipeCompleted(T model, View itemView, int position, int direction) {
//            ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeCompleted(). public onSwipeCompleted(T model, unresolved_type itemView, int position, int direction)
//                             ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                               ^^^^^ definition local25 T model
//                                      ^^^^ reference _root_/
//                                           ^^^^^^^^ definition local26 unresolved_type itemView
//                                                         ^^^^^^^^ definition local27 int position
//                                                                       ^^^^^^^^^ definition local28 int direction

  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected void onSelectedChanged(@Nullable EpoxyViewHolder viewHolder, int actionState) {
//               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#onSelectedChanged(). protected onSelectedChanged(EpoxyViewHolder viewHolder, int actionState)
//                                  ^^^^^^^^ reference androidx/annotation/Nullable#
//                                           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                           ^^^^^^^^^^ definition local29 EpoxyViewHolder viewHolder
//                                                                           ^^^^^^^^^^^ definition local30 int actionState
    super.onSelectedChanged(viewHolder, actionState);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#super.
//        ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#onSelectedChanged().
//                          ^^^^^^^^^^ reference local29
//                                      ^^^^^^^^^^^ reference local30

    if (viewHolder != null) {
//      ^^^^^^^^^^ reference local29
      EpoxyModel<?> model = viewHolder.getModel();
//    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^ definition local31 EpoxyModel<?> model
//                          ^^^^^^^^^^ reference local29
//                                     ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
      if (!isTouchableModel(model)) {
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                          ^^^^^ reference local31
        throw new IllegalStateException(
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 1:83
//                ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
            "A model was selected that is not a valid target: " + model.getClass());
//                                                                ^^^^^ reference local31
//                                                                      ^^^^^^^^ reference java/lang/Object#getClass().
      }

      markRecyclerViewHasSelection((RecyclerView) viewHolder.itemView.getParent());
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#markRecyclerViewHasSelection().
//                                  ^^^^^^^^^^^^ reference _root_/
//                                                ^^^^^^^^^^ reference local29
//                                                           ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                                                                    ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#getParent#

      if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//        ^^^^^^^^^^^ reference local30
//                       ^^^^^^^^^^^^^^^ reference _root_/
//                                       ^^^^^^^^^^^^^^^^^^ reference ACTION_STATE_SWIPE#
        holderBeingSwiped = viewHolder;
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
//                          ^^^^^^^^^^ reference local29
        //noinspection unchecked
        onSwipeStarted((T) model, viewHolder.itemView, viewHolder.getAdapterPosition());
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeStarted().
//                      ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                         ^^^^^ reference local31
//                                ^^^^^^^^^^ reference local29
//                                           ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                                                     ^^^^^^^^^^ reference local29
//                                                                ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
      } else if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
//               ^^^^^^^^^^^ reference local30
//                              ^^^^^^^^^^^^^^^ reference _root_/
//                                              ^^^^^^^^^^^^^^^^^ reference ACTION_STATE_DRAG#
        holderBeingDragged = viewHolder;
//      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
//                           ^^^^^^^^^^ reference local29
        //noinspection unchecked
        onDragStarted((T) model, viewHolder.itemView, viewHolder.getAdapterPosition());
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#onDragStarted().
//                     ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                        ^^^^^ reference local31
//                               ^^^^^^^^^^ reference local29
//                                          ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                                                    ^^^^^^^^^^ reference local29
//                                                               ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
      }
    } else if (holderBeingDragged != null) {
//             ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
      //noinspection unchecked
      onDragReleased((T) holderBeingDragged.getModel(), holderBeingDragged.itemView);
//    ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#onDragReleased().
//                    ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                       ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
//                                          ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                                      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
//                                                                         ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
      holderBeingDragged = null;
//    ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
    } else if (holderBeingSwiped != null) {
//             ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
      //noinspection unchecked
      onSwipeReleased((T) holderBeingSwiped.getModel(), holderBeingSwiped.itemView);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeReleased().
//                     ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                        ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
//                                          ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                                      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
//                                                                        ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
      holderBeingSwiped = null;
//    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
    }
  }

  private void markRecyclerViewHasSelection(RecyclerView recyclerView) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#markRecyclerViewHasSelection(). private markRecyclerViewHasSelection(unresolved_type recyclerView)
//                                          ^^^^^^^^^^^^ reference _root_/
//                                                       ^^^^^^^^^^^^ definition local32 unresolved_type recyclerView
    recyclerView.setTag(R.id.epoxy_touch_helper_selection_status, Boolean.TRUE);
//  ^^^^^^^^^^^^ reference local32
//               ^^^^^^ reference setTag#
//                      ^ reference R/
//                        ^^ reference R/id#
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference R/id#epoxy_touch_helper_selection_status#
//                                                                ^^^^^^^ reference java/lang/Boolean#
//                                                                        ^^^^ reference java/lang/Boolean#TRUE.
  }

  private boolean recyclerViewHasSelection(RecyclerView recyclerView) {
//                ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#recyclerViewHasSelection(). private boolean recyclerViewHasSelection(unresolved_type recyclerView)
//                                         ^^^^^^^^^^^^ reference _root_/
//                                                      ^^^^^^^^^^^^ definition local33 unresolved_type recyclerView
    return recyclerView.getTag(R.id.epoxy_touch_helper_selection_status) != null;
//         ^^^^^^^^^^^^ reference local33
//                      ^^^^^^ reference getTag#
//                             ^ reference R/
//                               ^^ reference R/id#
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference R/id#epoxy_touch_helper_selection_status#
  }

  private void clearRecyclerViewSelectionMarker(RecyclerView recyclerView) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#clearRecyclerViewSelectionMarker(). private clearRecyclerViewSelectionMarker(unresolved_type recyclerView)
//                                              ^^^^^^^^^^^^ reference _root_/
//                                                           ^^^^^^^^^^^^ definition local34 unresolved_type recyclerView
    recyclerView.setTag(R.id.epoxy_touch_helper_selection_status, null);
//  ^^^^^^^^^^^^ reference local34
//               ^^^^^^ reference setTag#
//                      ^ reference R/
//                        ^^ reference R/id#
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference R/id#epoxy_touch_helper_selection_status#
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onSwipeStarted(T model, View itemView, int adapterPosition) {
//            ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeStarted(). public onSwipeStarted(T model, unresolved_type itemView, int adapterPosition)
//                           ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                             ^^^^^ definition local35 T model
//                                    ^^^^ reference _root_/
//                                         ^^^^^^^^ definition local36 unresolved_type itemView
//                                                       ^^^^^^^^^^^^^^^ definition local37 int adapterPosition

  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onSwipeReleased(T model, View itemView) {
//            ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeReleased(). public onSwipeReleased(T model, unresolved_type itemView)
//                            ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                              ^^^^^ definition local38 T model
//                                     ^^^^ reference _root_/
//                                          ^^^^^^^^ definition local39 unresolved_type itemView

  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onDragStarted(T model, View itemView, int adapterPosition) {
//            ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#onDragStarted(). public onDragStarted(T model, unresolved_type itemView, int adapterPosition)
//                          ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                            ^^^^^ definition local40 T model
//                                   ^^^^ reference _root_/
//                                        ^^^^^^^^ definition local41 unresolved_type itemView
//                                                      ^^^^^^^^^^^^^^^ definition local42 int adapterPosition

  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onDragReleased(T model, View itemView) {
//            ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#onDragReleased(). public onDragReleased(T model, unresolved_type itemView)
//                           ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                             ^^^^^ definition local43 T model
//                                    ^^^^ reference _root_/
//                                         ^^^^^^^^ definition local44 unresolved_type itemView

  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected void clearView(final RecyclerView recyclerView, EpoxyViewHolder viewHolder) {
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#clearView(). protected clearView(unresolved_type recyclerView, EpoxyViewHolder viewHolder)
//                               ^^^^^^^^^^^^ reference _root_/
//                                            ^^^^^^^^^^^^ definition local45 final unresolved_type recyclerView
//                                                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                          ^^^^^^^^^^ definition local46 EpoxyViewHolder viewHolder
    super.clearView(recyclerView, viewHolder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#super.
//        ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView().
//                  ^^^^^^^^^^^^ reference local45
//                                ^^^^^^^^^^ reference local46
    //noinspection unchecked
    clearView((T) viewHolder.getModel(), viewHolder.itemView);
//  ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
//             ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                ^^^^^^^^^^ reference local46
//                           ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                       ^^^^^^^^^^ reference local46
//                                                  ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#

    // If multiple touch helpers are in use, one touch helper can pick up buffered touch inputs
    // immediately after another touch event finishes. This leads to things like a view being
    // selected for drag when another view finishes its swipe off animation. To prevent that we
    // keep the recyclerview marked as having an active selection for a brief period after a
    // touch event ends.
    recyclerView.postDelayed(new Runnable() {
//  ^^^^^^^^^^^^ reference local45
//               ^^^^^^^^^^^ reference postDelayed#
//                           ^^^^^^^^^^^^^^^^ reference local48 5:5
//                               ^^^^^^^^ reference java/lang/Runnable#
//                               ^^^^^^^^ reference java/lang/Runnable#
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void run() {
//                ^^^ definition local49 public run()
        clearRecyclerViewSelectionMarker(recyclerView);
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#clearRecyclerViewSelectionMarker().
//                                       ^^^^^^^^^^^^ reference local45
      }
    }, TOUCH_DEBOUNCE_MILLIS);
//     ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#TOUCH_DEBOUNCE_MILLIS.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void clearView(T model, View itemView) {
//            ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#clearView(+1). public clearView(T model, unresolved_type itemView)
//                      ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                        ^^^^^ definition local50 T model
//                               ^^^^ reference _root_/
//                                    ^^^^^^^^ definition local51 unresolved_type itemView

  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected void onChildDraw(Canvas c, RecyclerView recyclerView, EpoxyViewHolder viewHolder,
//               ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw(). protected onChildDraw(unresolved_type c, unresolved_type recyclerView, EpoxyViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)
//                           ^^^^^^ reference _root_/
//                                  ^ definition local52 unresolved_type c
//                                     ^^^^^^^^^^^^ reference _root_/
//                                                  ^^^^^^^^^^^^ definition local53 unresolved_type recyclerView
//                                                                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                ^^^^^^^^^^ definition local54 EpoxyViewHolder viewHolder
      float dX, float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local55 float dX
//                    ^^ definition local56 float dY
//                            ^^^^^^^^^^^ definition local57 int actionState
//                                                 ^^^^^^^^^^^^^^^^^ definition local58 boolean isCurrentlyActive
    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#super.
//        ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw().
//                    ^ reference local52
//                       ^^^^^^^^^^^^ reference local53
//                                     ^^^^^^^^^^ reference local54
//                                                 ^^ reference local55
//                                                     ^^ reference local56
//                                                         ^^^^^^^^^^^ reference local57
//                                                                      ^^^^^^^^^^^^^^^^^ reference local58

    EpoxyModel<?> model = viewHolder.getModel();
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local59 EpoxyModel<?> model
//                        ^^^^^^^^^^ reference local54
//                                   ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
    if (!isTouchableModel(model)) {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                        ^^^^^ reference local59
      throw new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 1:81
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
          "A model was selected that is not a valid target: " + model.getClass());
//                                                              ^^^^^ reference local59
//                                                                    ^^^^^^^^ reference java/lang/Object#getClass().
    }

    View itemView = viewHolder.itemView;
//  ^^^^ reference _root_/
//       ^^^^^^^^ definition local60 unresolved_type itemView
//                  ^^^^^^^^^^ reference local54
//                             ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#

    float swipeProgress;
//        ^^^^^^^^^^^^^ definition local61 float swipeProgress
    if (Math.abs(dX) > Math.abs(dY)) {
//      ^^^^ reference java/lang/Math#
//           ^^^ reference java/lang/Math#abs(+2).
//               ^^ reference local55
//                     ^^^^ reference java/lang/Math#
//                          ^^^ reference java/lang/Math#abs(+2).
//                              ^^ reference local56
      swipeProgress = dX / itemView.getWidth();
//    ^^^^^^^^^^^^^ reference local61
//                    ^^ reference local55
//                         ^^^^^^^^ reference local60
//                                  ^^^^^^^^ reference getWidth#
    } else {
      swipeProgress = dY / itemView.getHeight();
//    ^^^^^^^^^^^^^ reference local61
//                    ^^ reference local56
//                         ^^^^^^^^ reference local60
//                                  ^^^^^^^^^ reference getHeight#
    }

    // Clamp to 1/-1 in the case of side padding where the view can be swiped extra
    float clampedProgress = Math.max(-1f, Math.min(1f, swipeProgress));
//        ^^^^^^^^^^^^^^^ definition local62 float clampedProgress
//                          ^^^^ reference java/lang/Math#
//                               ^^^ reference java/lang/Math#max(+2).
//                                        ^^^^ reference java/lang/Math#
//                                             ^^^ reference java/lang/Math#min(+2).
//                                                     ^^^^^^^^^^^^^ reference local61

    //noinspection unchecked
    onSwipeProgressChanged((T) model, itemView, clampedProgress, c);
//  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeProgressChanged().
//                          ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                             ^^^^^ reference local59
//                                    ^^^^^^^^ reference local60
//                                              ^^^^^^^^^^^^^^^ reference local62
//                                                               ^ reference local52
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onSwipeProgressChanged(T model, View itemView, float swipeProgress,
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeProgressChanged(). public onSwipeProgressChanged(T model, unresolved_type itemView, float swipeProgress, unresolved_type canvas)
//                                   ^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                     ^^^^^ definition local63 T model
//                                            ^^^^ reference _root_/
//                                                 ^^^^^^^^ definition local64 unresolved_type itemView
//                                                                 ^^^^^^^^^^^^^ definition local65 float swipeProgress
      Canvas canvas) {
//    ^^^^^^ reference _root_/
//           ^^^^^^ definition local66 unresolved_type canvas

  }
}
