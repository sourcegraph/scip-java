package com.airbnb.epoxy;

import android.graphics.Canvas;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^^^^^ reference semanticdb maven . . android/graphics/
//                      ^^^^^^ reference semanticdb maven . . android/graphics/Canvas#
import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

import com.airbnb.viewmodeladapter.R;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/viewmodeladapter/
//                                 ^ reference semanticdb maven . . com/airbnb/viewmodeladapter/R#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.recyclerview.widget.ItemTouchHelper;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/ItemTouchHelper#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView#

/**
 * A wrapper around {@link androidx.recyclerview.widget.ItemTouchHelper.Callback} to enable
 * easier touch support when working with Epoxy models.
 * <p>
 * For simplicity you can use {@link EpoxyTouchHelper} to set up touch handling via this class for
 * you instead of using this class directly. However, you may choose to use this class directly with
 * your own {@link ItemTouchHelper} if you need extra flexibility or customization.
 */
public abstract class EpoxyModelTouchCallback<T extends EpoxyModel>
//                    ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#
//                                            documentation ```java\npublic abstract class EpoxyModelTouchCallback<T extends EpoxyModel>\n```
//                                            documentation  A wrapper around {@link androidx.recyclerview.widget.ItemTouchHelper.Callback} to enable\n easier touch support when working with Epoxy models.\n <p>\n For simplicity you can use {@link EpoxyTouchHelper} to set up touch handling via this class for\n you instead of using this class directly. However, you may choose to use this class directly with\n your own {@link ItemTouchHelper} if you need extra flexibility or customization.\n
//                                            relationship is_implementation semanticdb maven . . ItemTouchHelper/Callback#
//                                            relationship is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#
//                                            relationship is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#
//                                            relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#
//                                            relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#
//                                            relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#
//                                            ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                              documentation ```java\nT extends EpoxyModel\n```
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
    extends EpoxyTouchHelperCallback implements EpoxyDragCallback<T>, EpoxySwipeCallback<T> {
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#
//                                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#
//                                                                ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#
//                                                                                       ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]

  private static final int TOUCH_DEBOUNCE_MILLIS = 300;
//                         ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#TOUCH_DEBOUNCE_MILLIS.
//                                               documentation ```java\nprivate static final int TOUCH_DEBOUNCE_MILLIS\n```

  @Nullable private final EpoxyController controller;
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                        ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#controller.
//                                                   documentation ```java\n@Nullable\nprivate final EpoxyController controller\n```
  private final Class<T> targetModelClass;
//              ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#targetModelClass.
//                                        documentation ```java\nprivate final Class<T> targetModelClass\n```
  private EpoxyViewHolder holderBeingDragged;
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
//                                           documentation ```java\nprivate EpoxyViewHolder holderBeingDragged\n```
  private EpoxyViewHolder holderBeingSwiped;
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
//                                          documentation ```java\nprivate EpoxyViewHolder holderBeingSwiped\n```

  public EpoxyModelTouchCallback(@Nullable EpoxyController controller, Class<T> targetModelClass) {
//       ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#`<init>`().
//                               documentation ```java\npublic EpoxyModelTouchCallback(EpoxyController controller, Class<T> targetModelClass)\n```
//                                ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                         ^^^^^^^^^^ definition local 0
//                                                                    documentation ```java\n@Nullable\nEpoxyController controller\n```
//                                                                     ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                                           ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                                                              ^^^^^^^^^^^^^^^^ definition local 1
//                                                                                               documentation ```java\nClass<T> targetModelClass\n```
    this.controller = controller;
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#controller.
//                    ^^^^^^^^^^ reference local 0
    this.targetModelClass = targetModelClass;
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#targetModelClass.
//                          ^^^^^^^^^^^^^^^^ reference local 1
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected int getMovementFlags(RecyclerView recyclerView, EpoxyViewHolder viewHolder) {
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#getMovementFlags().
//                               documentation ```java\n@Override\nprotected int getMovementFlags(unresolved_type recyclerView, EpoxyViewHolder viewHolder)\n```
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags().
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags(+1).
//                               ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                            ^^^^^^^^^^^^ definition local 2
//                                                         documentation ```java\nunresolved_type recyclerView\n```
//                                                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                          ^^^^^^^^^^ definition local 3
//                                                                                     documentation ```java\nEpoxyViewHolder viewHolder\n```
    EpoxyModel<?> model = viewHolder.getModel();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local 4
//                      documentation ```java\nEpoxyModel<?> model\n```
//                        ^^^^^^^^^^ reference local 3
//                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().

    // If multiple touch callbacks are registered on the recyclerview (to support combinations of
    // dragging and dropping) then we won't want to enable anything if another
    // callback has a view actively selected.
    boolean isOtherCallbackActive =
//          ^^^^^^^^^^^^^^^^^^^^^ definition local 5
//                                documentation ```java\nboolean isOtherCallbackActive\n```
        holderBeingDragged == null
//      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
            && holderBeingSwiped == null
//             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
            && recyclerViewHasSelection(recyclerView);
//             ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#recyclerViewHasSelection().
//                                      ^^^^^^^^^^^^ reference local 2

    if (!isOtherCallbackActive && isTouchableModel(model)) {
//       ^^^^^^^^^^^^^^^^^^^^^ reference local 5
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                                                 ^^^^^ reference local 4
      //noinspection unchecked
      return getMovementFlagsForModel((T) model, viewHolder.getAdapterPosition());
//           ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#getMovementFlagsForModel().
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                        ^^^^^ reference local 4
//                                               ^^^^^^^^^^ reference local 3
//                                                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
    } else {
      return 0;
    }
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected boolean canDropOver(RecyclerView recyclerView, EpoxyViewHolder current,
//                  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#canDropOver().
//                              documentation ```java\n@Override\nprotected boolean canDropOver(unresolved_type recyclerView, EpoxyViewHolder current, EpoxyViewHolder target)\n```
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver().
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver(+1).
//                              ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                           ^^^^^^^^^^^^ definition local 6
//                                                        documentation ```java\nunresolved_type recyclerView\n```
//                                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                         ^^^^^^^ definition local 7
//                                                                                 documentation ```java\nEpoxyViewHolder current\n```
      EpoxyViewHolder target) {
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local 8
//                           documentation ```java\nEpoxyViewHolder target\n```
    // By default we don't allow dropping on a model that isn't a drag target
    return isTouchableModel(target.getModel());
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                          ^^^^^^ reference local 8
//                                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
  }

  protected boolean isTouchableModel(EpoxyModel<?> model) {
//                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                                   documentation ```java\nprotected boolean isTouchableModel(EpoxyModel<?> model)\n```
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^ definition local 9
//                                                       documentation ```java\nEpoxyModel<?> model\n```
    return targetModelClass.isInstance(model);
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#targetModelClass.
//                          ^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#isInstance().
//                                     ^^^^^ reference local 9
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected boolean onMove(RecyclerView recyclerView, EpoxyViewHolder viewHolder,
//                  ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onMove().
//                         documentation ```java\n@Override\nprotected boolean onMove(unresolved_type recyclerView, EpoxyViewHolder viewHolder, EpoxyViewHolder target)\n```
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove().
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove(+1).
//                         ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                      ^^^^^^^^^^^^ definition local 10
//                                                   documentation ```java\nunresolved_type recyclerView\n```
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                    ^^^^^^^^^^ definition local 11
//                                                                               documentation ```java\nEpoxyViewHolder viewHolder\n```
      EpoxyViewHolder target) {
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local 12
//                           documentation ```java\nEpoxyViewHolder target\n```

    if (controller == null) {
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#controller.
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "A controller must be provided in the constructor if dragging is enabled");
    }

    int fromPosition = viewHolder.getAdapterPosition();
//      ^^^^^^^^^^^^ definition local 13
//                   documentation ```java\nint fromPosition\n```
//                     ^^^^^^^^^^ reference local 11
//                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
    int toPosition = target.getAdapterPosition();
//      ^^^^^^^^^^ definition local 14
//                 documentation ```java\nint toPosition\n```
//                   ^^^^^^ reference local 12
//                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
    controller.moveModel(fromPosition, toPosition);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#controller.
//             ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#moveModel().
//                       ^^^^^^^^^^^^ reference local 13
//                                     ^^^^^^^^^^ reference local 14

    EpoxyModel<?> model = viewHolder.getModel();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local 15
//                      documentation ```java\nEpoxyModel<?> model\n```
//                        ^^^^^^^^^^ reference local 11
//                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
    if (!isTouchableModel(model)) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                        ^^^^^ reference local 15
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "A model was dragged that is not a valid target: " + model.getClass());
//                                                             ^^^^^ reference local 15
//                                                                   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
    }

    //noinspection unchecked
    onModelMoved(fromPosition, toPosition, (T) model, viewHolder.itemView);
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onModelMoved().
//               ^^^^^^^^^^^^ reference local 13
//                             ^^^^^^^^^^ reference local 14
//                                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                             ^^^^^ reference local 15
//                                                    ^^^^^^^^^^ reference local 11
//                                                               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
    return true;
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved, View itemView) {
//            ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onModelMoved().
//                         documentation ```java\n@Override\npublic void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved, unresolved_type itemView)\n```
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onModelMoved().
//                             ^^^^^^^^^^^^ definition local 16
//                                          documentation ```java\nint fromPosition\n```
//                                               ^^^^^^^^^^ definition local 17
//                                                          documentation ```java\nint toPosition\n```
//                                                           ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                                             ^^^^^^^^^^^^^^^ definition local 18
//                                                                             documentation ```java\nT modelBeingMoved\n```
//                                                                              ^^^^ reference semanticdb maven . . _root_/
//                                                                                   ^^^^^^^^ definition local 19
//                                                                                            documentation ```java\nunresolved_type itemView\n```

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void onSwiped(EpoxyViewHolder viewHolder, int direction) {
//               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwiped().
//                        documentation ```java\n@Override\nprotected void onSwiped(EpoxyViewHolder viewHolder, int direction)\n```
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onSwiped().
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                        ^^^^^^^^^^ definition local 20
//                                                   documentation ```java\nEpoxyViewHolder viewHolder\n```
//                                                        ^^^^^^^^^ definition local 21
//                                                                  documentation ```java\nint direction\n```
    EpoxyModel<?> model = viewHolder.getModel();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local 22
//                      documentation ```java\nEpoxyModel<?> model\n```
//                        ^^^^^^^^^^ reference local 20
//                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
    View view = viewHolder.itemView;
//  ^^^^ reference semanticdb maven . . _root_/
//       ^^^^ definition local 23
//            documentation ```java\nunresolved_type view\n```
//              ^^^^^^^^^^ reference local 20
//                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
    int position = viewHolder.getAdapterPosition();
//      ^^^^^^^^ definition local 24
//               documentation ```java\nint position\n```
//                 ^^^^^^^^^^ reference local 20
//                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#

    if (!isTouchableModel(model)) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                        ^^^^^ reference local 22
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "A model was swiped that is not a valid target: " + model.getClass());
//                                                            ^^^^^ reference local 22
//                                                                  ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
    }

    //noinspection unchecked
    onSwipeCompleted((T) model, view, position, direction);
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeCompleted().
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                       ^^^^^ reference local 22
//                              ^^^^ reference local 23
//                                    ^^^^^^^^ reference local 24
//                                              ^^^^^^^^^ reference local 21
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onSwipeCompleted(T model, View itemView, int position, int direction) {
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeCompleted().
//                             documentation ```java\n@Override\npublic void onSwipeCompleted(T model, unresolved_type itemView, int position, int direction)\n```
//                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeCompleted().
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                               ^^^^^ definition local 25
//                                     documentation ```java\nT model\n```
//                                      ^^^^ reference semanticdb maven . . _root_/
//                                           ^^^^^^^^ definition local 26
//                                                    documentation ```java\nunresolved_type itemView\n```
//                                                         ^^^^^^^^ definition local 27
//                                                                  documentation ```java\nint position\n```
//                                                                       ^^^^^^^^^ definition local 28
//                                                                                 documentation ```java\nint direction\n```

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void onSelectedChanged(@Nullable EpoxyViewHolder viewHolder, int actionState) {
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSelectedChanged().
//                                 documentation ```java\n@Override\nprotected void onSelectedChanged(EpoxyViewHolder viewHolder, int actionState)\n```
//                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onSelectedChanged().
//                                  ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                           ^^^^^^^^^^ definition local 29
//                                                                      documentation ```java\n@Nullable\nEpoxyViewHolder viewHolder\n```
//                                                                           ^^^^^^^^^^^ definition local 30
//                                                                                       documentation ```java\nint actionState\n```
    super.onSelectedChanged(viewHolder, actionState);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#super.
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onSelectedChanged().
//                          ^^^^^^^^^^ reference local 29
//                                      ^^^^^^^^^^^ reference local 30

    if (viewHolder != null) {
//      ^^^^^^^^^^ reference local 29
      EpoxyModel<?> model = viewHolder.getModel();
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^ definition local 31
//                        documentation ```java\nEpoxyModel<?> model\n```
//                          ^^^^^^^^^^ reference local 29
//                                     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
      if (!isTouchableModel(model)) {
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                          ^^^^^ reference local 31
        throw new IllegalStateException(
//                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
            "A model was selected that is not a valid target: " + model.getClass());
//                                                                ^^^^^ reference local 31
//                                                                      ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
      }

      markRecyclerViewHasSelection((RecyclerView) viewHolder.itemView.getParent());
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#markRecyclerViewHasSelection().
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                ^^^^^^^^^^ reference local 29
//                                                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                                                                    ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#getParent#

      if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//        ^^^^^^^^^^^ reference local 30
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . ACTION_STATE_SWIPE#
        holderBeingSwiped = viewHolder;
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
//                          ^^^^^^^^^^ reference local 29
        //noinspection unchecked
        onSwipeStarted((T) model, viewHolder.itemView, viewHolder.getAdapterPosition());
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeStarted().
//                      ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                         ^^^^^ reference local 31
//                                ^^^^^^^^^^ reference local 29
//                                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                                                     ^^^^^^^^^^ reference local 29
//                                                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
      } else if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
//               ^^^^^^^^^^^ reference local 30
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . ACTION_STATE_DRAG#
        holderBeingDragged = viewHolder;
//      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
//                           ^^^^^^^^^^ reference local 29
        //noinspection unchecked
        onDragStarted((T) model, viewHolder.itemView, viewHolder.getAdapterPosition());
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragStarted().
//                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                        ^^^^^ reference local 31
//                               ^^^^^^^^^^ reference local 29
//                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                                                    ^^^^^^^^^^ reference local 29
//                                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
      }
    } else if (holderBeingDragged != null) {
//             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
      //noinspection unchecked
      onDragReleased((T) holderBeingDragged.getModel(), holderBeingDragged.itemView);
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragReleased().
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
//                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
//                                                                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
      holderBeingDragged = null;
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
    } else if (holderBeingSwiped != null) {
//             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
      //noinspection unchecked
      onSwipeReleased((T) holderBeingSwiped.getModel(), holderBeingSwiped.itemView);
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeReleased().
//                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
//                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
//                                                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
      holderBeingSwiped = null;
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
    }
  }

  private void markRecyclerViewHasSelection(RecyclerView recyclerView) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#markRecyclerViewHasSelection().
//                                          documentation ```java\nprivate void markRecyclerViewHasSelection(unresolved_type recyclerView)\n```
//                                          ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                       ^^^^^^^^^^^^ definition local 32
//                                                                    documentation ```java\nunresolved_type recyclerView\n```
    recyclerView.setTag(R.id.epoxy_touch_helper_selection_status, Boolean.TRUE);
//  ^^^^^^^^^^^^ reference local 32
//               ^^^^^^ reference semanticdb maven . . setTag#
//                      ^ reference semanticdb maven . . R/
//                        ^^ reference semanticdb maven . . R/id#
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/id#epoxy_touch_helper_selection_status#
//                                                                ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Boolean#
//                                                                        ^^^^ reference semanticdb maven jdk 11 java/lang/Boolean#TRUE.
  }

  private boolean recyclerViewHasSelection(RecyclerView recyclerView) {
//                ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#recyclerViewHasSelection().
//                                         documentation ```java\nprivate boolean recyclerViewHasSelection(unresolved_type recyclerView)\n```
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                      ^^^^^^^^^^^^ definition local 33
//                                                                   documentation ```java\nunresolved_type recyclerView\n```
    return recyclerView.getTag(R.id.epoxy_touch_helper_selection_status) != null;
//         ^^^^^^^^^^^^ reference local 33
//                      ^^^^^^ reference semanticdb maven . . getTag#
//                             ^ reference semanticdb maven . . R/
//                               ^^ reference semanticdb maven . . R/id#
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/id#epoxy_touch_helper_selection_status#
  }

  private void clearRecyclerViewSelectionMarker(RecyclerView recyclerView) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearRecyclerViewSelectionMarker().
//                                              documentation ```java\nprivate void clearRecyclerViewSelectionMarker(unresolved_type recyclerView)\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                           ^^^^^^^^^^^^ definition local 34
//                                                                        documentation ```java\nunresolved_type recyclerView\n```
    recyclerView.setTag(R.id.epoxy_touch_helper_selection_status, null);
//  ^^^^^^^^^^^^ reference local 34
//               ^^^^^^ reference semanticdb maven . . setTag#
//                      ^ reference semanticdb maven . . R/
//                        ^^ reference semanticdb maven . . R/id#
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/id#epoxy_touch_helper_selection_status#
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onSwipeStarted(T model, View itemView, int adapterPosition) {
//            ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeStarted().
//                           documentation ```java\n@Override\npublic void onSwipeStarted(T model, unresolved_type itemView, int adapterPosition)\n```
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeStarted().
//                           ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                             ^^^^^ definition local 35
//                                   documentation ```java\nT model\n```
//                                    ^^^^ reference semanticdb maven . . _root_/
//                                         ^^^^^^^^ definition local 36
//                                                  documentation ```java\nunresolved_type itemView\n```
//                                                       ^^^^^^^^^^^^^^^ definition local 37
//                                                                       documentation ```java\nint adapterPosition\n```

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onSwipeReleased(T model, View itemView) {
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeReleased().
//                            documentation ```java\n@Override\npublic void onSwipeReleased(T model, unresolved_type itemView)\n```
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeReleased().
//                            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                              ^^^^^ definition local 38
//                                    documentation ```java\nT model\n```
//                                     ^^^^ reference semanticdb maven . . _root_/
//                                          ^^^^^^^^ definition local 39
//                                                   documentation ```java\nunresolved_type itemView\n```

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onDragStarted(T model, View itemView, int adapterPosition) {
//            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragStarted().
//                          documentation ```java\n@Override\npublic void onDragStarted(T model, unresolved_type itemView, int adapterPosition)\n```
//                          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onDragStarted().
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                            ^^^^^ definition local 40
//                                  documentation ```java\nT model\n```
//                                   ^^^^ reference semanticdb maven . . _root_/
//                                        ^^^^^^^^ definition local 41
//                                                 documentation ```java\nunresolved_type itemView\n```
//                                                      ^^^^^^^^^^^^^^^ definition local 42
//                                                                      documentation ```java\nint adapterPosition\n```

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onDragReleased(T model, View itemView) {
//            ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragReleased().
//                           documentation ```java\n@Override\npublic void onDragReleased(T model, unresolved_type itemView)\n```
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onDragReleased().
//                           ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                             ^^^^^ definition local 43
//                                   documentation ```java\nT model\n```
//                                    ^^^^ reference semanticdb maven . . _root_/
//                                         ^^^^^^^^ definition local 44
//                                                  documentation ```java\nunresolved_type itemView\n```

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void clearView(final RecyclerView recyclerView, EpoxyViewHolder viewHolder) {
//               ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
//                         documentation ```java\n@Override\nprotected void clearView(unresolved_type recyclerView, EpoxyViewHolder viewHolder)\n```
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#clearView().
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView().
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView(+1).
//                               ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                            ^^^^^^^^^^^^ definition local 45
//                                                         documentation ```java\nfinal unresolved_type recyclerView\n```
//                                                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                          ^^^^^^^^^^ definition local 46
//                                                                                     documentation ```java\nEpoxyViewHolder viewHolder\n```
    super.clearView(recyclerView, viewHolder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView().
//                  ^^^^^^^^^^^^ reference local 45
//                                ^^^^^^^^^^ reference local 46
    //noinspection unchecked
    clearView((T) viewHolder.getModel(), viewHolder.itemView);
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
//             ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                ^^^^^^^^^^ reference local 46
//                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                       ^^^^^^^^^^ reference local 46
//                                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#

    // If multiple touch helpers are in use, one touch helper can pick up buffered touch inputs
    // immediately after another touch event finishes. This leads to things like a view being
    // selected for drag when another view finishes its swipe off animation. To prevent that we
    // keep the recyclerview marked as having an active selection for a brief period after a
    // touch event ends.
    recyclerView.postDelayed(new Runnable() {
//  ^^^^^^^^^^^^ reference local 45
//               ^^^^^^^^^^^ reference semanticdb maven . . postDelayed#
//                               ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Runnable#
      @Override
//     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
      public void run() {
//                ^^^ definition local 49
//                    documentation ```java\n@Override\npublic void run()\n```
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Runnable#run().
        clearRecyclerViewSelectionMarker(recyclerView);
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearRecyclerViewSelectionMarker().
//                                       ^^^^^^^^^^^^ reference local 45
      }
    }, TOUCH_DEBOUNCE_MILLIS);
//     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#TOUCH_DEBOUNCE_MILLIS.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void clearView(T model, View itemView) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView(+1).
//                      documentation ```java\n@Override\npublic void clearView(T model, unresolved_type itemView)\n```
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#clearView().
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView().
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView(+1).
//                      ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                        ^^^^^ definition local 50
//                              documentation ```java\nT model\n```
//                               ^^^^ reference semanticdb maven . . _root_/
//                                    ^^^^^^^^ definition local 51
//                                             documentation ```java\nunresolved_type itemView\n```

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void onChildDraw(Canvas c, RecyclerView recyclerView, EpoxyViewHolder viewHolder,
//               ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                           documentation ```java\n@Override\nprotected void onChildDraw(unresolved_type c, unresolved_type recyclerView, EpoxyViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)\n```
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw().
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw(+1).
//                           ^^^^^^ reference semanticdb maven . . _root_/
//                                  ^ definition local 52
//                                    documentation ```java\nunresolved_type c\n```
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                  ^^^^^^^^^^^^ definition local 53
//                                                               documentation ```java\nunresolved_type recyclerView\n```
//                                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                ^^^^^^^^^^ definition local 54
//                                                                                           documentation ```java\nEpoxyViewHolder viewHolder\n```
      float dX, float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local 55
//             documentation ```java\nfloat dX\n```
//                    ^^ definition local 56
//                       documentation ```java\nfloat dY\n```
//                            ^^^^^^^^^^^ definition local 57
//                                        documentation ```java\nint actionState\n```
//                                                 ^^^^^^^^^^^^^^^^^ definition local 58
//                                                                   documentation ```java\nboolean isCurrentlyActive\n```
    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#super.
//        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw().
//                    ^ reference local 52
//                       ^^^^^^^^^^^^ reference local 53
//                                     ^^^^^^^^^^ reference local 54
//                                                 ^^ reference local 55
//                                                     ^^ reference local 56
//                                                         ^^^^^^^^^^^ reference local 57
//                                                                      ^^^^^^^^^^^^^^^^^ reference local 58

    EpoxyModel<?> model = viewHolder.getModel();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local 59
//                      documentation ```java\nEpoxyModel<?> model\n```
//                        ^^^^^^^^^^ reference local 54
//                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
    if (!isTouchableModel(model)) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                        ^^^^^ reference local 59
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "A model was selected that is not a valid target: " + model.getClass());
//                                                              ^^^^^ reference local 59
//                                                                    ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
    }

    View itemView = viewHolder.itemView;
//  ^^^^ reference semanticdb maven . . _root_/
//       ^^^^^^^^ definition local 60
//                documentation ```java\nunresolved_type itemView\n```
//                  ^^^^^^^^^^ reference local 54
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#

    float swipeProgress;
//        ^^^^^^^^^^^^^ definition local 61
//                      documentation ```java\nfloat swipeProgress\n```
    if (Math.abs(dX) > Math.abs(dY)) {
//      ^^^^ reference semanticdb maven jdk 11 java/lang/Math#
//           ^^^ reference semanticdb maven jdk 11 java/lang/Math#abs(+2).
//               ^^ reference local 55
//                     ^^^^ reference semanticdb maven jdk 11 java/lang/Math#
//                          ^^^ reference semanticdb maven jdk 11 java/lang/Math#abs(+2).
//                              ^^ reference local 56
      swipeProgress = dX / itemView.getWidth();
//    ^^^^^^^^^^^^^ reference local 61
//                    ^^ reference local 55
//                         ^^^^^^^^ reference local 60
//                                  ^^^^^^^^ reference semanticdb maven . . getWidth#
    } else {
      swipeProgress = dY / itemView.getHeight();
//    ^^^^^^^^^^^^^ reference local 61
//                    ^^ reference local 56
//                         ^^^^^^^^ reference local 60
//                                  ^^^^^^^^^ reference semanticdb maven . . getHeight#
    }

    // Clamp to 1/-1 in the case of side padding where the view can be swiped extra
    float clampedProgress = Math.max(-1f, Math.min(1f, swipeProgress));
//        ^^^^^^^^^^^^^^^ definition local 62
//                        documentation ```java\nfloat clampedProgress\n```
//                          ^^^^ reference semanticdb maven jdk 11 java/lang/Math#
//                               ^^^ reference semanticdb maven jdk 11 java/lang/Math#max(+2).
//                                        ^^^^ reference semanticdb maven jdk 11 java/lang/Math#
//                                             ^^^ reference semanticdb maven jdk 11 java/lang/Math#min(+2).
//                                                     ^^^^^^^^^^^^^ reference local 61

    //noinspection unchecked
    onSwipeProgressChanged((T) model, itemView, clampedProgress, c);
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeProgressChanged().
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                             ^^^^^ reference local 59
//                                    ^^^^^^^^ reference local 60
//                                              ^^^^^^^^^^^^^^^ reference local 62
//                                                               ^ reference local 52
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onSwipeProgressChanged(T model, View itemView, float swipeProgress,
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeProgressChanged().
//                                   documentation ```java\n@Override\npublic void onSwipeProgressChanged(T model, unresolved_type itemView, float swipeProgress, unresolved_type canvas)\n```
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeProgressChanged().
//                                   ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                     ^^^^^ definition local 63
//                                           documentation ```java\nT model\n```
//                                            ^^^^ reference semanticdb maven . . _root_/
//                                                 ^^^^^^^^ definition local 64
//                                                          documentation ```java\nunresolved_type itemView\n```
//                                                                 ^^^^^^^^^^^^^ definition local 65
//                                                                               documentation ```java\nfloat swipeProgress\n```
      Canvas canvas) {
//    ^^^^^^ reference semanticdb maven . . _root_/
//           ^^^^^^ definition local 66
//                  documentation ```java\nunresolved_type canvas\n```

  }
}
