package com.airbnb.epoxy;

import android.graphics.Canvas;
//     ^^^^^^^ reference android/
//             ^^^^^^^^ reference android/graphics/
//                      ^^^^^^ reference android/graphics/Canvas#
import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#

import androidx.recyclerview.widget.ItemTouchHelper;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/ItemTouchHelper#

/**
 * For use with {@link EpoxyModelTouchCallback}
 */
public interface EpoxySwipeCallback<T extends EpoxyModel> extends BaseEpoxyTouchCallback<T> {
//               ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxySwipeCallback# public interface EpoxySwipeCallback<T extends EpoxyModel>
//                                  ^ definition com/airbnb/epoxy/EpoxySwipeCallback#[T] T extends EpoxyModel
//                                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyTouchCallback#
//                                                                                       ^ reference com/airbnb/epoxy/EpoxySwipeCallback#[T]

  /**
   * Called when the view switches from an idle state to a swiped state, as the user begins a swipe
   * interaction with it. You can use this callback to modify the view to indicate it is being
   * swiped.
   * <p>
   * This is the first callback made in the lifecycle of a swipe event.
   *
   * @param model           The model representing the view that is being swiped
   * @param itemView        The view that is being swiped
   * @param adapterPosition The adapter position of the model
   */
  void onSwipeStarted(T model, View itemView, int adapterPosition);
//     ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxySwipeCallback#onSwipeStarted(). public abstract void onSwipeStarted(T model, unresolved_type itemView, int adapterPosition)
//                    ^ reference com/airbnb/epoxy/EpoxySwipeCallback#[T]
//                      ^^^^^ definition local0 T model
//                             ^^^^ reference _root_/
//                                  ^^^^^^^^ definition local1 unresolved_type itemView
//                                                ^^^^^^^^^^^^^^^ definition local2 int adapterPosition

  /**
   * Once a view has begun swiping with {@link #onSwipeStarted(EpoxyModel, View, int)} it will
   * receive this callback as the swipe distance changes. This can be called multiple times as the
   * swipe interaction progresses.
   *
   * @param model         The model representing the view that is being swiped
   * @param itemView      The view that is being swiped
   * @param swipeProgress A float from -1 to 1 representing the percentage that the view has been
   *                      swiped relative to its width. This will be positive if the view is being
   *                      swiped to the right and negative if it is swiped to the left. For
   *                      example,
   * @param canvas        The canvas on which RecyclerView is drawing its children. You can draw to
   *                      this to support custom swipe animations.
   */
  void onSwipeProgressChanged(T model, View itemView, float swipeProgress,
//     ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxySwipeCallback#onSwipeProgressChanged(). public abstract void onSwipeProgressChanged(T model, unresolved_type itemView, float swipeProgress, unresolved_type canvas)
//                            ^ reference com/airbnb/epoxy/EpoxySwipeCallback#[T]
//                              ^^^^^ definition local3 T model
//                                     ^^^^ reference _root_/
//                                          ^^^^^^^^ definition local4 unresolved_type itemView
//                                                          ^^^^^^^^^^^^^ definition local5 float swipeProgress
      Canvas canvas);
//    ^^^^^^ reference _root_/
//           ^^^^^^ definition local6 unresolved_type canvas

  /**
   * Called when the user has released their touch on the view. If the displacement passed the swipe
   * threshold then {@link #onSwipeCompleted(EpoxyModel, View, int, int)} will be called after this
   * and the view will be animated off screen. Otherwise the view will animate back to its original
   * position.
   *
   * @param model    The model representing the view that was being swiped
   * @param itemView The view that was being swiped
   */
  void onSwipeReleased(T model, View itemView);
//     ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxySwipeCallback#onSwipeReleased(). public abstract void onSwipeReleased(T model, unresolved_type itemView)
//                     ^ reference com/airbnb/epoxy/EpoxySwipeCallback#[T]
//                       ^^^^^ definition local7 T model
//                              ^^^^ reference _root_/
//                                   ^^^^^^^^ definition local8 unresolved_type itemView

  /**
   * Called after {@link #onSwipeReleased(EpoxyModel, View)} if the swipe surpassed the threshold to
   * be considered a full swipe. The view will now be animated off screen.
   * <p>
   * You MUST use this callback to remove this item from your backing data and request a model
   * update.
   * <p>
   * {@link #clearView(EpoxyModel, View)} will be called after this.
   *
   * @param model     The model representing the view that was being swiped
   * @param itemView  The view that was being swiped
   * @param position  The adapter position of the model
   * @param direction The direction that the view was swiped. Can be any of {@link
   *                  ItemTouchHelper#LEFT}, {@link ItemTouchHelper#RIGHT}, {@link
   *                  ItemTouchHelper#UP}, {@link ItemTouchHelper#DOWN} depending on what swipe
   *                  directions were enabled.
   */
  void onSwipeCompleted(T model, View itemView, int position, int direction);
//     ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxySwipeCallback#onSwipeCompleted(). public abstract void onSwipeCompleted(T model, unresolved_type itemView, int position, int direction)
//                      ^ reference com/airbnb/epoxy/EpoxySwipeCallback#[T]
//                        ^^^^^ definition local9 T model
//                               ^^^^ reference _root_/
//                                    ^^^^^^^^ definition local10 unresolved_type itemView
//                                                  ^^^^^^^^ definition local11 int position
//                                                                ^^^^^^^^^ definition local12 int direction
}
