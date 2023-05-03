package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

/**
 * For use with {@link EpoxyModelTouchCallback}
 */
public interface EpoxyDragCallback<T extends EpoxyModel> extends BaseEpoxyTouchCallback<T> {
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#
//                                 documentation ```java\npublic interface EpoxyDragCallback<T extends EpoxyModel>\n```
//                                 documentation  For use with {@link EpoxyModelTouchCallback}\n
//                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#
//                                 ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#[T]
//                                   documentation ```java\nT extends EpoxyModel\n```
//                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                               ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#
//                                                                                      ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#[T]

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
//     ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onDragStarted().
//                   documentation ```java\npublic abstract void onDragStarted(T model, unresolved_type itemView, int adapterPosition)\n```
//                   documentation  Called when the view switches from an idle state to a dragged state, as the user begins a drag\n interaction with it. You can use this callback to modify the view to indicate it is being\n dragged.\n <p>\n This is the first callback in the lifecycle of a drag event.\n\n @param model           The model representing the view that is being dragged\n @param itemView        The view that is being dragged\n @param adapterPosition The adapter position of the model\n
//                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragStarted().
//                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragStarted().
//                   ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#[T]
//                     ^^^^^ definition local 0
//                           documentation ```java\nT model\n```
//                            ^^^^ reference semanticdb maven . . _root_/
//                                 ^^^^^^^^ definition local 1
//                                          documentation ```java\nunresolved_type itemView\n```
//                                               ^^^^^^^^^^^^^^^ definition local 2
//                                                               documentation ```java\nint adapterPosition\n```

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
//     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onModelMoved().
//                  documentation ```java\npublic abstract void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved, unresolved_type itemView)\n```
//                  documentation  Called after {@link #onDragStarted(EpoxyModel, View, int)} when the dragged view is dropped to\n a new position. The EpoxyController will be updated automatically for you to reposition the\n models and notify the RecyclerView of the change.\n <p>\n You MUST use this callback to modify your data backing the models to reflect the change.\n <p>\n The next callback in the drag lifecycle will be {@link #onDragStarted(EpoxyModel, View, int)}\n\n @param modelBeingMoved The model representing the view that was moved\n @param itemView        The view that was moved\n @param fromPosition    The adapter position that the model came from\n @param toPosition      The new adapter position of the model\n
//                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onModelMoved().
//                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onModelMoved().
//                      ^^^^^^^^^^^^ definition local 3
//                                   documentation ```java\nint fromPosition\n```
//                                        ^^^^^^^^^^ definition local 4
//                                                   documentation ```java\nint toPosition\n```
//                                                    ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#[T]
//                                                      ^^^^^^^^^^^^^^^ definition local 5
//                                                                      documentation ```java\nT modelBeingMoved\n```
//                                                                       ^^^^ reference semanticdb maven . . _root_/
//                                                                            ^^^^^^^^ definition local 6
//                                                                                     documentation ```java\nunresolved_type itemView\n```

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
//     ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onDragReleased().
//                    documentation ```java\npublic abstract void onDragReleased(T model, unresolved_type itemView)\n```
//                    documentation  Called after {@link #onDragStarted(EpoxyModel, View, int)} when the view being dragged is\n released. If the view was dragged to a new, valid location then {@link #onModelMoved(int, int,\n EpoxyModel, View)} will be called before this and the view will settle to the new location.\n Otherwise the view will animate back to its original position.\n <p>\n You can use this callback to modify the view as it animates back into position.\n <p>\n {@link BaseEpoxyTouchCallback#clearView(EpoxyModel, View)} will be called after this, when the\n view has finished animating. Final cleanup of the view should be done there.\n\n @param model    The model representing the view that is being released\n @param itemView The view that was being dragged\n
//                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragReleased().
//                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragReleased().
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#[T]
//                      ^^^^^ definition local 7
//                            documentation ```java\nT model\n```
//                             ^^^^ reference semanticdb maven . . _root_/
//                                  ^^^^^^^^ definition local 8
//                                           documentation ```java\nunresolved_type itemView\n```
}
