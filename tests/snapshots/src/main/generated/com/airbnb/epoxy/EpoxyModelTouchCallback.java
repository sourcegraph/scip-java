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
//                                            display_name EpoxyModelTouchCallback
//                                            signature_documentation java public abstract class EpoxyModelTouchCallback<T extends EpoxyModel>
//                                            kind Class
//                                            documentation  A wrapper around {@link androidx.recyclerview.widget.ItemTouchHelper.Callback} to enable\n easier touch support when working with Epoxy models.\n <p>\n For simplicity you can use {@link EpoxyTouchHelper} to set up touch handling via this class for\n you instead of using this class directly. However, you may choose to use this class directly with\n your own {@link ItemTouchHelper} if you need extra flexibility or customization.\n
//                                            relationship is_implementation semanticdb maven . . ItemTouchHelper/Callback#
//                                            relationship is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#
//                                            relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#
//                                            relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#
//                                            relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#
//                                            ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                              display_name T
//                                              signature_documentation java T extends EpoxyModel
//                                              kind TypeParameter
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
    extends EpoxyTouchHelperCallback implements EpoxyDragCallback<T>, EpoxySwipeCallback<T> {
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#
//                                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#
//                                                                ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#
//                                                                                       ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]

  private static final int TOUCH_DEBOUNCE_MILLIS = 300;
//                         ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#TOUCH_DEBOUNCE_MILLIS.
//                                               display_name TOUCH_DEBOUNCE_MILLIS
//                                               signature_documentation java private static final int TOUCH_DEBOUNCE_MILLIS
//                                               kind StaticField

  @Nullable private final EpoxyController controller;
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                        ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#controller.
//                                                   display_name controller
//                                                   signature_documentation java @Nullable\nprivate final EpoxyController controller
//                                                   kind Field
  private final Class<T> targetModelClass;
//              ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#targetModelClass.
//                                        display_name targetModelClass
//                                        signature_documentation java private final Class<T> targetModelClass
//                                        kind Field
  private EpoxyViewHolder holderBeingDragged;
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingDragged.
//                                           display_name holderBeingDragged
//                                           signature_documentation java private EpoxyViewHolder holderBeingDragged
//                                           kind Field
  private EpoxyViewHolder holderBeingSwiped;
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#holderBeingSwiped.
//                                          display_name holderBeingSwiped
//                                          signature_documentation java private EpoxyViewHolder holderBeingSwiped
//                                          kind Field

  public EpoxyModelTouchCallback(@Nullable EpoxyController controller, Class<T> targetModelClass) {
//       ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#`<init>`().
//                               display_name <init>
//                               signature_documentation java public EpoxyModelTouchCallback(EpoxyController controller, Class<T> targetModelClass)
//                               kind Constructor
//                                ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                         ^^^^^^^^^^ definition local 0
//                                                                    display_name controller
//                                                                    signature_documentation java @Nullable\nEpoxyController controller
//                                                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#`<init>`().
//                                                                     ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                                           ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                                                              ^^^^^^^^^^^^^^^^ definition local 1
//                                                                                               display_name targetModelClass
//                                                                                               signature_documentation java Class<T> targetModelClass
//                                                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#`<init>`().
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
//                               display_name getMovementFlags
//                               signature_documentation java @Override\nprotected int getMovementFlags(unresolved_type recyclerView, EpoxyViewHolder viewHolder)
//                               kind Method
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags().
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags(+1).
//                               ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                            ^^^^^^^^^^^^ definition local 2
//                                                         display_name recyclerView
//                                                         signature_documentation java unresolved_type recyclerView
//                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#getMovementFlags().
//                                                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                          ^^^^^^^^^^ definition local 3
//                                                                                     display_name viewHolder
//                                                                                     signature_documentation java EpoxyViewHolder viewHolder
//                                                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#getMovementFlags().
    EpoxyModel<?> model = viewHolder.getModel();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local 4
//                      display_name model
//                      signature_documentation java EpoxyModel<?> model
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#getMovementFlags().
//                      kind Variable
//                        ^^^^^^^^^^ reference local 3
//                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().

    // If multiple touch callbacks are registered on the recyclerview (to support combinations of
    // dragging and dropping) then we won't want to enable anything if another
    // callback has a view actively selected.
    boolean isOtherCallbackActive =
//          ^^^^^^^^^^^^^^^^^^^^^ definition local 5
//                                display_name isOtherCallbackActive
//                                signature_documentation java boolean isOtherCallbackActive
//                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#getMovementFlags().
//                                kind Variable
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
//                              display_name canDropOver
//                              signature_documentation java @Override\nprotected boolean canDropOver(unresolved_type recyclerView, EpoxyViewHolder current, EpoxyViewHolder target)
//                              kind Method
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver().
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver(+1).
//                              ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                           ^^^^^^^^^^^^ definition local 6
//                                                        display_name recyclerView
//                                                        signature_documentation java unresolved_type recyclerView
//                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#canDropOver().
//                                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                         ^^^^^^^ definition local 7
//                                                                                 display_name current
//                                                                                 signature_documentation java EpoxyViewHolder current
//                                                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#canDropOver().
      EpoxyViewHolder target) {
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local 8
//                           display_name target
//                           signature_documentation java EpoxyViewHolder target
//                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#canDropOver().
    // By default we don't allow dropping on a model that isn't a drag target
    return isTouchableModel(target.getModel());
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                          ^^^^^^ reference local 8
//                                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
  }

  protected boolean isTouchableModel(EpoxyModel<?> model) {
//                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                                   display_name isTouchableModel
//                                   signature_documentation java protected boolean isTouchableModel(EpoxyModel<?> model)
//                                   kind Method
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^ definition local 9
//                                                       display_name model
//                                                       signature_documentation java EpoxyModel<?> model
//                                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
    return targetModelClass.isInstance(model);
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#targetModelClass.
//                          ^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#isInstance().
//                                     ^^^^^ reference local 9
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected boolean onMove(RecyclerView recyclerView, EpoxyViewHolder viewHolder,
//                  ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onMove().
//                         display_name onMove
//                         signature_documentation java @Override\nprotected boolean onMove(unresolved_type recyclerView, EpoxyViewHolder viewHolder, EpoxyViewHolder target)
//                         kind Method
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove().
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove(+1).
//                         ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                      ^^^^^^^^^^^^ definition local 10
//                                                   display_name recyclerView
//                                                   signature_documentation java unresolved_type recyclerView
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onMove().
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                    ^^^^^^^^^^ definition local 11
//                                                                               display_name viewHolder
//                                                                               signature_documentation java EpoxyViewHolder viewHolder
//                                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onMove().
      EpoxyViewHolder target) {
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local 12
//                           display_name target
//                           signature_documentation java EpoxyViewHolder target
//                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onMove().

    if (controller == null) {
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#controller.
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "A controller must be provided in the constructor if dragging is enabled");
    }

    int fromPosition = viewHolder.getAdapterPosition();
//      ^^^^^^^^^^^^ definition local 13
//                   display_name fromPosition
//                   signature_documentation java int fromPosition
//                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onMove().
//                   kind Variable
//                     ^^^^^^^^^^ reference local 11
//                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
    int toPosition = target.getAdapterPosition();
//      ^^^^^^^^^^ definition local 14
//                 display_name toPosition
//                 signature_documentation java int toPosition
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onMove().
//                 kind Variable
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
//                      display_name model
//                      signature_documentation java EpoxyModel<?> model
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onMove().
//                      kind Variable
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
//                         display_name onModelMoved
//                         signature_documentation java @Override\npublic void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved, unresolved_type itemView)
//                         kind Method
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onModelMoved().
//                             ^^^^^^^^^^^^ definition local 16
//                                          display_name fromPosition
//                                          signature_documentation java int fromPosition
//                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onModelMoved().
//                                               ^^^^^^^^^^ definition local 17
//                                                          display_name toPosition
//                                                          signature_documentation java int toPosition
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onModelMoved().
//                                                           ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                                             ^^^^^^^^^^^^^^^ definition local 18
//                                                                             display_name modelBeingMoved
//                                                                             signature_documentation java T modelBeingMoved
//                                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onModelMoved().
//                                                                              ^^^^ reference semanticdb maven . . View#
//                                                                                   ^^^^^^^^ definition local 19
//                                                                                            display_name itemView
//                                                                                            signature_documentation java unresolved_type itemView
//                                                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onModelMoved().

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void onSwiped(EpoxyViewHolder viewHolder, int direction) {
//               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwiped().
//                        display_name onSwiped
//                        signature_documentation java @Override\nprotected void onSwiped(EpoxyViewHolder viewHolder, int direction)
//                        kind Method
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onSwiped().
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                        ^^^^^^^^^^ definition local 20
//                                                   display_name viewHolder
//                                                   signature_documentation java EpoxyViewHolder viewHolder
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwiped().
//                                                        ^^^^^^^^^ definition local 21
//                                                                  display_name direction
//                                                                  signature_documentation java int direction
//                                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwiped().
    EpoxyModel<?> model = viewHolder.getModel();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local 22
//                      display_name model
//                      signature_documentation java EpoxyModel<?> model
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwiped().
//                      kind Variable
//                        ^^^^^^^^^^ reference local 20
//                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
    View view = viewHolder.itemView;
//  ^^^^ reference semanticdb maven . . View#
//       ^^^^ definition local 23
//            display_name view
//            signature_documentation java unresolved_type view
//            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwiped().
//            kind Variable
//              ^^^^^^^^^^ reference local 20
//                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
    int position = viewHolder.getAdapterPosition();
//      ^^^^^^^^ definition local 24
//               display_name position
//               signature_documentation java int position
//               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwiped().
//               kind Variable
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
//                             display_name onSwipeCompleted
//                             signature_documentation java @Override\npublic void onSwipeCompleted(T model, unresolved_type itemView, int position, int direction)
//                             kind Method
//                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeCompleted().
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                               ^^^^^ definition local 25
//                                     display_name model
//                                     signature_documentation java T model
//                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeCompleted().
//                                      ^^^^ reference semanticdb maven . . View#
//                                           ^^^^^^^^ definition local 26
//                                                    display_name itemView
//                                                    signature_documentation java unresolved_type itemView
//                                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeCompleted().
//                                                         ^^^^^^^^ definition local 27
//                                                                  display_name position
//                                                                  signature_documentation java int position
//                                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeCompleted().
//                                                                       ^^^^^^^^^ definition local 28
//                                                                                 display_name direction
//                                                                                 signature_documentation java int direction
//                                                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeCompleted().

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void onSelectedChanged(@Nullable EpoxyViewHolder viewHolder, int actionState) {
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSelectedChanged().
//                                 display_name onSelectedChanged
//                                 signature_documentation java @Override\nprotected void onSelectedChanged(EpoxyViewHolder viewHolder, int actionState)
//                                 kind Method
//                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onSelectedChanged().
//                                  ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                           ^^^^^^^^^^ definition local 29
//                                                                      display_name viewHolder
//                                                                      signature_documentation java @Nullable\nEpoxyViewHolder viewHolder
//                                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSelectedChanged().
//                                                                           ^^^^^^^^^^^ definition local 30
//                                                                                       display_name actionState
//                                                                                       signature_documentation java int actionState
//                                                                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSelectedChanged().
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
//                        display_name model
//                        signature_documentation java EpoxyModel<?> model
//                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSelectedChanged().
//                        kind Variable
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
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                ^^^^^^^^^^ reference local 29
//                                                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                                                                    ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#getParent#

      if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//        ^^^^^^^^^^^ reference local 30
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . ItemTouchHelper#
//                                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . ItemTouchHelper#ACTION_STATE_SWIPE#
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
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . ItemTouchHelper#
//                                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . ItemTouchHelper#ACTION_STATE_DRAG#
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
//                                          display_name markRecyclerViewHasSelection
//                                          signature_documentation java private void markRecyclerViewHasSelection(unresolved_type recyclerView)
//                                          kind Method
//                                          ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                       ^^^^^^^^^^^^ definition local 32
//                                                                    display_name recyclerView
//                                                                    signature_documentation java unresolved_type recyclerView
//                                                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#markRecyclerViewHasSelection().
    recyclerView.setTag(R.id.epoxy_touch_helper_selection_status, Boolean.TRUE);
//  ^^^^^^^^^^^^ reference local 32
//               ^^^^^^ reference semanticdb maven . . RecyclerView#setTag#
//                      ^ reference semanticdb maven . . R/
//                        ^^ reference semanticdb maven . . R/id#
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/id#epoxy_touch_helper_selection_status#
//                                                                ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Boolean#
//                                                                        ^^^^ reference semanticdb maven jdk 11 java/lang/Boolean#TRUE.
  }

  private boolean recyclerViewHasSelection(RecyclerView recyclerView) {
//                ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#recyclerViewHasSelection().
//                                         display_name recyclerViewHasSelection
//                                         signature_documentation java private boolean recyclerViewHasSelection(unresolved_type recyclerView)
//                                         kind Method
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                      ^^^^^^^^^^^^ definition local 33
//                                                                   display_name recyclerView
//                                                                   signature_documentation java unresolved_type recyclerView
//                                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#recyclerViewHasSelection().
    return recyclerView.getTag(R.id.epoxy_touch_helper_selection_status) != null;
//         ^^^^^^^^^^^^ reference local 33
//                      ^^^^^^ reference semanticdb maven . . RecyclerView#getTag#
//                             ^ reference semanticdb maven . . R/
//                               ^^ reference semanticdb maven . . R/id#
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/id#epoxy_touch_helper_selection_status#
  }

  private void clearRecyclerViewSelectionMarker(RecyclerView recyclerView) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearRecyclerViewSelectionMarker().
//                                              display_name clearRecyclerViewSelectionMarker
//                                              signature_documentation java private void clearRecyclerViewSelectionMarker(unresolved_type recyclerView)
//                                              kind Method
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                           ^^^^^^^^^^^^ definition local 34
//                                                                        display_name recyclerView
//                                                                        signature_documentation java unresolved_type recyclerView
//                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearRecyclerViewSelectionMarker().
    recyclerView.setTag(R.id.epoxy_touch_helper_selection_status, null);
//  ^^^^^^^^^^^^ reference local 34
//               ^^^^^^ reference semanticdb maven . . RecyclerView#setTag#
//                      ^ reference semanticdb maven . . R/
//                        ^^ reference semanticdb maven . . R/id#
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/id#epoxy_touch_helper_selection_status#
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onSwipeStarted(T model, View itemView, int adapterPosition) {
//            ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeStarted().
//                           display_name onSwipeStarted
//                           signature_documentation java @Override\npublic void onSwipeStarted(T model, unresolved_type itemView, int adapterPosition)
//                           kind Method
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeStarted().
//                           ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                             ^^^^^ definition local 35
//                                   display_name model
//                                   signature_documentation java T model
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeStarted().
//                                    ^^^^ reference semanticdb maven . . View#
//                                         ^^^^^^^^ definition local 36
//                                                  display_name itemView
//                                                  signature_documentation java unresolved_type itemView
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeStarted().
//                                                       ^^^^^^^^^^^^^^^ definition local 37
//                                                                       display_name adapterPosition
//                                                                       signature_documentation java int adapterPosition
//                                                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeStarted().

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onSwipeReleased(T model, View itemView) {
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeReleased().
//                            display_name onSwipeReleased
//                            signature_documentation java @Override\npublic void onSwipeReleased(T model, unresolved_type itemView)
//                            kind Method
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeReleased().
//                            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                              ^^^^^ definition local 38
//                                    display_name model
//                                    signature_documentation java T model
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeReleased().
//                                     ^^^^ reference semanticdb maven . . View#
//                                          ^^^^^^^^ definition local 39
//                                                   display_name itemView
//                                                   signature_documentation java unresolved_type itemView
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeReleased().

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onDragStarted(T model, View itemView, int adapterPosition) {
//            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragStarted().
//                          display_name onDragStarted
//                          signature_documentation java @Override\npublic void onDragStarted(T model, unresolved_type itemView, int adapterPosition)
//                          kind Method
//                          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onDragStarted().
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                            ^^^^^ definition local 40
//                                  display_name model
//                                  signature_documentation java T model
//                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragStarted().
//                                   ^^^^ reference semanticdb maven . . View#
//                                        ^^^^^^^^ definition local 41
//                                                 display_name itemView
//                                                 signature_documentation java unresolved_type itemView
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragStarted().
//                                                      ^^^^^^^^^^^^^^^ definition local 42
//                                                                      display_name adapterPosition
//                                                                      signature_documentation java int adapterPosition
//                                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragStarted().

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onDragReleased(T model, View itemView) {
//            ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragReleased().
//                           display_name onDragReleased
//                           signature_documentation java @Override\npublic void onDragReleased(T model, unresolved_type itemView)
//                           kind Method
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onDragReleased().
//                           ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                             ^^^^^ definition local 43
//                                   display_name model
//                                   signature_documentation java T model
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragReleased().
//                                    ^^^^ reference semanticdb maven . . View#
//                                         ^^^^^^^^ definition local 44
//                                                  display_name itemView
//                                                  signature_documentation java unresolved_type itemView
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragReleased().

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void clearView(final RecyclerView recyclerView, EpoxyViewHolder viewHolder) {
//               ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
//                         display_name clearView
//                         signature_documentation java @Override\nprotected void clearView(unresolved_type recyclerView, EpoxyViewHolder viewHolder)
//                         kind Method
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#clearView().
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView().
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView(+1).
//                               ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                            ^^^^^^^^^^^^ definition local 45
//                                                         display_name recyclerView
//                                                         signature_documentation java final unresolved_type recyclerView
//                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
//                                                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                          ^^^^^^^^^^ definition local 46
//                                                                                     display_name viewHolder
//                                                                                     signature_documentation java EpoxyViewHolder viewHolder
//                                                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
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
//               ^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#postDelayed#
//                               ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Runnable#
      @Override
//     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
      public void run() {
//                ^^^ definition local 48
//                    display_name run
//                    signature_documentation java @Override\npublic void run()
//                    enclosing_symbol local 47
//                    kind Method
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
//                      display_name clearView
//                      signature_documentation java @Override\npublic void clearView(T model, unresolved_type itemView)
//                      kind Method
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#clearView().
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView().
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView(+1).
//                      ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                        ^^^^^ definition local 49
//                              display_name model
//                              signature_documentation java T model
//                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView(+1).
//                               ^^^^ reference semanticdb maven . . View#
//                                    ^^^^^^^^ definition local 50
//                                             display_name itemView
//                                             signature_documentation java unresolved_type itemView
//                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView(+1).

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void onChildDraw(Canvas c, RecyclerView recyclerView, EpoxyViewHolder viewHolder,
//               ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                           display_name onChildDraw
//                           signature_documentation java @Override\nprotected void onChildDraw(unresolved_type c, unresolved_type recyclerView, EpoxyViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)
//                           kind Method
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw().
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw(+1).
//                           ^^^^^^ reference semanticdb maven . . Canvas#
//                                  ^ definition local 51
//                                    display_name c
//                                    signature_documentation java unresolved_type c
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                  ^^^^^^^^^^^^ definition local 52
//                                                               display_name recyclerView
//                                                               signature_documentation java unresolved_type recyclerView
//                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                ^^^^^^^^^^ definition local 53
//                                                                                           display_name viewHolder
//                                                                                           signature_documentation java EpoxyViewHolder viewHolder
//                                                                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
      float dX, float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local 54
//             display_name dX
//             signature_documentation java float dX
//             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                    ^^ definition local 55
//                       display_name dY
//                       signature_documentation java float dY
//                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                            ^^^^^^^^^^^ definition local 56
//                                        display_name actionState
//                                        signature_documentation java int actionState
//                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                                                 ^^^^^^^^^^^^^^^^^ definition local 57
//                                                                   display_name isCurrentlyActive
//                                                                   signature_documentation java boolean isCurrentlyActive
//                                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#super.
//        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw().
//                    ^ reference local 51
//                       ^^^^^^^^^^^^ reference local 52
//                                     ^^^^^^^^^^ reference local 53
//                                                 ^^ reference local 54
//                                                     ^^ reference local 55
//                                                         ^^^^^^^^^^^ reference local 56
//                                                                      ^^^^^^^^^^^^^^^^^ reference local 57

    EpoxyModel<?> model = viewHolder.getModel();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local 58
//                      display_name model
//                      signature_documentation java EpoxyModel<?> model
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                      kind Variable
//                        ^^^^^^^^^^ reference local 53
//                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
    if (!isTouchableModel(model)) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                        ^^^^^ reference local 58
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "A model was selected that is not a valid target: " + model.getClass());
//                                                              ^^^^^ reference local 58
//                                                                    ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
    }

    View itemView = viewHolder.itemView;
//  ^^^^ reference semanticdb maven . . View#
//       ^^^^^^^^ definition local 59
//                display_name itemView
//                signature_documentation java unresolved_type itemView
//                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                kind Variable
//                  ^^^^^^^^^^ reference local 53
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#

    float swipeProgress;
//        ^^^^^^^^^^^^^ definition local 60
//                      display_name swipeProgress
//                      signature_documentation java float swipeProgress
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                      kind Variable
    if (Math.abs(dX) > Math.abs(dY)) {
//      ^^^^ reference semanticdb maven jdk 11 java/lang/Math#
//           ^^^ reference semanticdb maven jdk 11 java/lang/Math#abs(+2).
//               ^^ reference local 54
//                     ^^^^ reference semanticdb maven jdk 11 java/lang/Math#
//                          ^^^ reference semanticdb maven jdk 11 java/lang/Math#abs(+2).
//                              ^^ reference local 55
      swipeProgress = dX / itemView.getWidth();
//    ^^^^^^^^^^^^^ reference local 60
//                    ^^ reference local 54
//                         ^^^^^^^^ reference local 59
//                                  ^^^^^^^^ reference semanticdb maven . . View#getWidth#
    } else {
      swipeProgress = dY / itemView.getHeight();
//    ^^^^^^^^^^^^^ reference local 60
//                    ^^ reference local 55
//                         ^^^^^^^^ reference local 59
//                                  ^^^^^^^^^ reference semanticdb maven . . View#getHeight#
    }

    // Clamp to 1/-1 in the case of side padding where the view can be swiped extra
    float clampedProgress = Math.max(-1f, Math.min(1f, swipeProgress));
//        ^^^^^^^^^^^^^^^ definition local 61
//                        display_name clampedProgress
//                        signature_documentation java float clampedProgress
//                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                        kind Variable
//                          ^^^^ reference semanticdb maven jdk 11 java/lang/Math#
//                               ^^^ reference semanticdb maven jdk 11 java/lang/Math#max(+2).
//                                        ^^^^ reference semanticdb maven jdk 11 java/lang/Math#
//                                             ^^^ reference semanticdb maven jdk 11 java/lang/Math#min(+2).
//                                                     ^^^^^^^^^^^^^ reference local 60

    //noinspection unchecked
    onSwipeProgressChanged((T) model, itemView, clampedProgress, c);
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeProgressChanged().
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                             ^^^^^ reference local 58
//                                    ^^^^^^^^ reference local 59
//                                              ^^^^^^^^^^^^^^^ reference local 61
//                                                               ^ reference local 51
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onSwipeProgressChanged(T model, View itemView, float swipeProgress,
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeProgressChanged().
//                                   display_name onSwipeProgressChanged
//                                   signature_documentation java @Override\npublic void onSwipeProgressChanged(T model, unresolved_type itemView, float swipeProgress, unresolved_type canvas)
//                                   kind Method
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeProgressChanged().
//                                   ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#[T]
//                                     ^^^^^ definition local 62
//                                           display_name model
//                                           signature_documentation java T model
//                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeProgressChanged().
//                                            ^^^^ reference semanticdb maven . . View#
//                                                 ^^^^^^^^ definition local 63
//                                                          display_name itemView
//                                                          signature_documentation java unresolved_type itemView
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeProgressChanged().
//                                                                 ^^^^^^^^^^^^^ definition local 64
//                                                                               display_name swipeProgress
//                                                                               signature_documentation java float swipeProgress
//                                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeProgressChanged().
      Canvas canvas) {
//    ^^^^^^ reference semanticdb maven . . Canvas#
//           ^^^^^^ definition local 65
//                  display_name canvas
//                  signature_documentation java unresolved_type canvas
//                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeProgressChanged().

  }
}
