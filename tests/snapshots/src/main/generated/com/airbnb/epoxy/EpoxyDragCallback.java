package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#

/**
 * For use with {@link EpoxyModelTouchCallback}
 */
public interface EpoxyDragCallback<T extends EpoxyModel> extends BaseEpoxyTouchCallback<T> {
//               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyDragCallback# public interface EpoxyDragCallback<T extends EpoxyModel>
//                                 ^ definition com/airbnb/epoxy/EpoxyDragCallback#[T] T extends EpoxyModel
//                                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                               ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyTouchCallback#
//                                                                                      ^ reference com/airbnb/epoxy/EpoxyDragCallback#[T]

  /**
   * Called when the view switches from an idle state to a dragged state, as the user begins a drag
   * interaction with it. You can use this callback to modify the view to indicate it is being
   * dragged.
   * <p>
   * This is the first callback in the lifecycle of a drag event.
   *
   * @param model           The model representing the view that is being dragged
   * @param itemView        The view that is being dragged
   * @param adapterPosition The adapter position of the model
   */
  void onDragStarted(T model, View itemView, int adapterPosition);
//     ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyDragCallback#onDragStarted(). public abstract void onDragStarted(T model, unresolved_type itemView, int adapterPosition)
//                   ^ reference com/airbnb/epoxy/EpoxyDragCallback#[T]
//                     ^^^^^ definition local0 T model
//                            ^^^^ reference _root_/
//                                 ^^^^^^^^ definition local1 unresolved_type itemView
//                                               ^^^^^^^^^^^^^^^ definition local2 int adapterPosition

  /**
   * Called after {@link #onDragStarted(EpoxyModel, View, int)} when the dragged view is dropped to
   * a new position. The EpoxyController will be updated automatically for you to reposition the
   * models and notify the RecyclerView of the change.
   * <p>
   * You MUST use this callback to modify your data backing the models to reflect the change.
   * <p>
   * The next callback in the drag lifecycle will be {@link #onDragStarted(EpoxyModel, View, int)}
   *
   * @param modelBeingMoved The model representing the view that was moved
   * @param itemView        The view that was moved
   * @param fromPosition    The adapter position that the model came from
   * @param toPosition      The new adapter position of the model
   */
  void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved, View itemView);
//     ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyDragCallback#onModelMoved(). public abstract void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved, unresolved_type itemView)
//                      ^^^^^^^^^^^^ definition local3 int fromPosition
//                                        ^^^^^^^^^^ definition local4 int toPosition
//                                                    ^ reference com/airbnb/epoxy/EpoxyDragCallback#[T]
//                                                      ^^^^^^^^^^^^^^^ definition local5 T modelBeingMoved
//                                                                       ^^^^ reference _root_/
//                                                                            ^^^^^^^^ definition local6 unresolved_type itemView

  /**
   * Called after {@link #onDragStarted(EpoxyModel, View, int)} when the view being dragged is
   * released. If the view was dragged to a new, valid location then {@link #onModelMoved(int, int,
   * EpoxyModel, View)} will be called before this and the view will settle to the new location.
   * Otherwise the view will animate back to its original position.
   * <p>
   * You can use this callback to modify the view as it animates back into position.
   * <p>
   * {@link BaseEpoxyTouchCallback#clearView(EpoxyModel, View)} will be called after this, when the
   * view has finished animating. Final cleanup of the view should be done there.
   *
   * @param model    The model representing the view that is being released
   * @param itemView The view that was being dragged
   */
  void onDragReleased(T model, View itemView);
//     ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyDragCallback#onDragReleased(). public abstract void onDragReleased(T model, unresolved_type itemView)
//                    ^ reference com/airbnb/epoxy/EpoxyDragCallback#[T]
//                      ^^^^^ definition local7 T model
//                             ^^^^ reference _root_/
//                                  ^^^^^^^^ definition local8 unresolved_type itemView
}
