package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#

interface BaseEpoxyTouchCallback<T extends EpoxyModel> {
//        ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyTouchCallback# abstract interface BaseEpoxyTouchCallback<T extends EpoxyModel>
//                               ^ definition com/airbnb/epoxy/BaseEpoxyTouchCallback#[T] T extends EpoxyModel
//                                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#

  /**
   * Should return a composite flag which defines the enabled move directions in each state
   * (idle, swiping, dragging) for the given model.
   * <p>
   * Return 0 to disable movement for the model.
   *
   * @param model           The model being targeted for movement.
   * @param adapterPosition The current adapter position of the targeted model
   * @see androidx.recyclerview.widget.ItemTouchHelper.Callback#getMovementFlags
   */
  int getMovementFlagsForModel(T model, int adapterPosition);
//    ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyTouchCallback#getMovementFlagsForModel(). public abstract int getMovementFlagsForModel(T model, int adapterPosition)
//                             ^ reference com/airbnb/epoxy/BaseEpoxyTouchCallback#[T]
//                               ^^^^^ definition local0 T model
//                                          ^^^^^^^^^^^^^^^ definition local1 int adapterPosition

  /**
   * Called when the user interaction with a view is over and the view has
   * completed its animation. This is a good place to clear all changes on the view that were done
   * in other previous touch callbacks (such as on touch start, change, release, etc).
   * <p>
   * This is the last callback in the lifecycle of a touch event.
   *
   * @param model    The model whose view is being cleared.
   * @param itemView The view being cleared.
   */
  void clearView(T model, View itemView);
//     ^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyTouchCallback#clearView(). public abstract void clearView(T model, unresolved_type itemView)
//               ^ reference com/airbnb/epoxy/BaseEpoxyTouchCallback#[T]
//                 ^^^^^ definition local2 T model
//                        ^^^^ reference _root_/
//                             ^^^^^^^^ definition local3 unresolved_type itemView
}
