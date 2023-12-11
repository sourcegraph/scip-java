package com.airbnb.epoxy;

import android.graphics.Canvas;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^^^^^ reference semanticdb maven . . android/graphics/
//                      ^^^^^^ reference semanticdb maven . . android/graphics/Canvas#

import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

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
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/
//                                               ^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/ViewHolder#

/**
 * A wrapper around {@link androidx.recyclerview.widget.ItemTouchHelper.Callback} to cast all
 * view holders to {@link com.airbnb.epoxy.EpoxyViewHolder} for simpler use with Epoxy.
 */
public abstract class EpoxyTouchHelperCallback extends ItemTouchHelper.Callback {
//                    ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#
//                                             display_name EpoxyTouchHelperCallback
//                                             signature_documentation java public abstract class EpoxyTouchHelperCallback
//                                             documentation  A wrapper around {@link androidx.recyclerview.widget.ItemTouchHelper.Callback} to cast all\n view holders to {@link com.airbnb.epoxy.EpoxyViewHolder} for simpler use with Epoxy.\n
//                                             relationship is_implementation semanticdb maven . . ItemTouchHelper/Callback#
//                    ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#`<init>`().
//                                             display_name <init>
//                                             signature_documentation java public EpoxyTouchHelperCallback()
//                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . ItemTouchHelper/
//                                                                     ^^^^^^^^ reference semanticdb maven . . ItemTouchHelper/Callback#

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags().
//                                  display_name getMovementFlags
//                                  signature_documentation java @Override\npublic final int getMovementFlags(unresolved_type recyclerView, unresolved_type viewHolder)
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#getMovementFlags().
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                               ^^^^^^^^^^^^ definition local 0
//                                                            display_name recyclerView
//                                                            signature_documentation java unresolved_type recyclerView
//                                                             ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                        ^^^^^^^^^^ definition local 1
//                                                                                   display_name viewHolder
//                                                                                   signature_documentation java unresolved_type viewHolder
    return getMovementFlags(recyclerView, (EpoxyViewHolder) viewHolder);
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags().
//                          ^^^^^^^^^^^^ reference local 0
//                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ reference local 1
  }

  /**
   * @see #getMovementFlags(RecyclerView, ViewHolder)
   */
  protected abstract int getMovementFlags(RecyclerView recyclerView, EpoxyViewHolder viewHolder);
//                       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags(+1).
//                                        display_name getMovementFlags
//                                        signature_documentation java protected abstract int getMovementFlags(unresolved_type recyclerView, EpoxyViewHolder viewHolder)
//                                        documentation  @see #getMovementFlags(RecyclerView, ViewHolder)\n
//                                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#getMovementFlags().
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                     ^^^^^^^^^^^^ definition local 2
//                                                                  display_name recyclerView
//                                                                  signature_documentation java unresolved_type recyclerView
//                                                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                   ^^^^^^^^^^ definition local 3
//                                                                                              display_name viewHolder
//                                                                                              signature_documentation java EpoxyViewHolder viewHolder

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target) {
//                     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove().
//                            display_name onMove
//                            signature_documentation java @Override\npublic final boolean onMove(unresolved_type recyclerView, unresolved_type viewHolder, unresolved_type target)
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onMove().
//                            ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                         ^^^^^^^^^^^^ definition local 4
//                                                      display_name recyclerView
//                                                      signature_documentation java unresolved_type recyclerView
//                                                       ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                  ^^^^^^^^^^ definition local 5
//                                                                             display_name viewHolder
//                                                                             signature_documentation java unresolved_type viewHolder
//                                                                              ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                                         ^^^^^^ definition local 6
//                                                                                                display_name target
//                                                                                                signature_documentation java unresolved_type target
    return onMove(recyclerView, (EpoxyViewHolder) viewHolder, (EpoxyViewHolder) target);
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove().
//                ^^^^^^^^^^^^ reference local 4
//                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                ^^^^^^^^^^ reference local 5
//                                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                              ^^^^^^ reference local 6
  }

  /**
   * @see #onMove(RecyclerView, ViewHolder, ViewHolder)
   */
  protected abstract boolean onMove(RecyclerView recyclerView, EpoxyViewHolder viewHolder,
//                           ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove(+1).
//                                  display_name onMove
//                                  signature_documentation java protected abstract boolean onMove(unresolved_type recyclerView, EpoxyViewHolder viewHolder, EpoxyViewHolder target)
//                                  documentation  @see #onMove(RecyclerView, ViewHolder, ViewHolder)\n
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onMove().
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                               ^^^^^^^^^^^^ definition local 7
//                                                            display_name recyclerView
//                                                            signature_documentation java unresolved_type recyclerView
//                                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                             ^^^^^^^^^^ definition local 8
//                                                                                        display_name viewHolder
//                                                                                        signature_documentation java EpoxyViewHolder viewHolder
      EpoxyViewHolder target);
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local 9
//                           display_name target
//                           signature_documentation java EpoxyViewHolder target

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final void onSwiped(ViewHolder viewHolder, int direction) {
//                  ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onSwiped().
//                           display_name onSwiped
//                           signature_documentation java @Override\npublic final void onSwiped(unresolved_type viewHolder, int direction)
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwiped().
//                           ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                      ^^^^^^^^^^ definition local 10
//                                                 display_name viewHolder
//                                                 signature_documentation java unresolved_type viewHolder
//                                                      ^^^^^^^^^ definition local 11
//                                                                display_name direction
//                                                                signature_documentation java int direction
    onSwiped((EpoxyViewHolder) viewHolder, direction);
//  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onSwiped().
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                             ^^^^^^^^^^ reference local 10
//                                         ^^^^^^^^^ reference local 11
  }

  /**
   * @see #onSwiped(ViewHolder, int)
   */
  protected abstract void onSwiped(EpoxyViewHolder viewHolder, int direction);
//                        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onSwiped(+-1).
//                                 display_name onSwiped
//                                 signature_documentation java protected abstract void onSwiped(EpoxyViewHolder viewHolder, int direction)
//                                 documentation  @see #onSwiped(ViewHolder, int)\n
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local 12
//                                                            display_name viewHolder
//                                                            signature_documentation java EpoxyViewHolder viewHolder
//                                                                 ^^^^^^^^^ definition local 13
//                                                                           display_name direction
//                                                                           signature_documentation java int direction

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final boolean canDropOver(RecyclerView recyclerView, ViewHolder current,
//                     ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver().
//                                 display_name canDropOver
//                                 signature_documentation java @Override\npublic final boolean canDropOver(unresolved_type recyclerView, unresolved_type current, unresolved_type target)
//                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#canDropOver().
//                                 ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                              ^^^^^^^^^^^^ definition local 14
//                                                           display_name recyclerView
//                                                           signature_documentation java unresolved_type recyclerView
//                                                            ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                       ^^^^^^^ definition local 15
//                                                                               display_name current
//                                                                               signature_documentation java unresolved_type current
      ViewHolder target) {
//    ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//               ^^^^^^ definition local 16
//                      display_name target
//                      signature_documentation java unresolved_type target
    return canDropOver(recyclerView, (EpoxyViewHolder) current, (EpoxyViewHolder) target);
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver().
//                     ^^^^^^^^^^^^ reference local 14
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^^ reference local 15
//                                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                ^^^^^^ reference local 16
  }

  /**
   * @see #canDropOver(RecyclerView, ViewHolder, ViewHolder)
   */
  protected boolean canDropOver(RecyclerView recyclerView, EpoxyViewHolder current,
//                  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver(+1).
//                              display_name canDropOver
//                              signature_documentation java protected boolean canDropOver(unresolved_type recyclerView, EpoxyViewHolder current, EpoxyViewHolder target)
//                              documentation  @see #canDropOver(RecyclerView, ViewHolder, ViewHolder)\n
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#canDropOver().
//                              ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                           ^^^^^^^^^^^^ definition local 17
//                                                        display_name recyclerView
//                                                        signature_documentation java unresolved_type recyclerView
//                                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                         ^^^^^^^ definition local 18
//                                                                                 display_name current
//                                                                                 signature_documentation java EpoxyViewHolder current
      EpoxyViewHolder target) {
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local 19
//                           display_name target
//                           signature_documentation java EpoxyViewHolder target
    return super.canDropOver(recyclerView, current, target);
//         ^^^^^ reference semanticdb maven . . super#
//               ^^^^^^^^^^^ reference semanticdb maven . . super#canDropOver#
//                           ^^^^^^^^^^^^ reference local 17
//                                         ^^^^^^^ reference local 18
//                                                  ^^^^^^ reference local 19
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final float getSwipeThreshold(ViewHolder viewHolder) {
//                   ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getSwipeThreshold().
//                                     display_name getSwipeThreshold
//                                     signature_documentation java @Override\npublic final float getSwipeThreshold(unresolved_type viewHolder)
//                                     ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                ^^^^^^^^^^ definition local 20
//                                                           display_name viewHolder
//                                                           signature_documentation java unresolved_type viewHolder
    return getSwipeThreshold((EpoxyViewHolder) viewHolder);
//         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getSwipeThreshold().
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                             ^^^^^^^^^^ reference local 20
  }

  /**
   * @see #getSwipeThreshold(ViewHolder)
   */
  protected float getSwipeThreshold(EpoxyViewHolder viewHolder) {
//                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getSwipeThreshold(+-1).
//                                  display_name getSwipeThreshold
//                                  signature_documentation java protected float getSwipeThreshold(EpoxyViewHolder viewHolder)
//                                  documentation  @see #getSwipeThreshold(ViewHolder)\n
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                  ^^^^^^^^^^ definition local 21
//                                                             display_name viewHolder
//                                                             signature_documentation java EpoxyViewHolder viewHolder
    return super.getSwipeThreshold(viewHolder);
//         ^^^^^ reference semanticdb maven . . super#
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . super#getSwipeThreshold#
//                                 ^^^^^^^^^^ reference local 21
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final float getMoveThreshold(ViewHolder viewHolder) {
//                   ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getMoveThreshold().
//                                    display_name getMoveThreshold
//                                    signature_documentation java @Override\npublic final float getMoveThreshold(unresolved_type viewHolder)
//                                    ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                               ^^^^^^^^^^ definition local 22
//                                                          display_name viewHolder
//                                                          signature_documentation java unresolved_type viewHolder
    return getMoveThreshold((EpoxyViewHolder) viewHolder);
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getMoveThreshold().
//                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                            ^^^^^^^^^^ reference local 22
  }

  /**
   * @see #getMoveThreshold(ViewHolder)
   */
  protected float getMoveThreshold(EpoxyViewHolder viewHolder) {
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getMoveThreshold(+-1).
//                                 display_name getMoveThreshold
//                                 signature_documentation java protected float getMoveThreshold(EpoxyViewHolder viewHolder)
//                                 documentation  @see #getMoveThreshold(ViewHolder)\n
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local 23
//                                                            display_name viewHolder
//                                                            signature_documentation java EpoxyViewHolder viewHolder
    return super.getMoveThreshold(viewHolder);
//         ^^^^^ reference semanticdb maven . . super#
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . super#getMoveThreshold#
//                                ^^^^^^^^^^ reference local 23
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final ViewHolder chooseDropTarget(ViewHolder selected, List dropTargets, int curX,
//             ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#chooseDropTarget().
//                                         display_name chooseDropTarget
//                                         signature_documentation java @Override\npublic final unresolved_type chooseDropTarget(unresolved_type selected, List dropTargets, int curX, int curY)
//                                         ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                    ^^^^^^^^ definition local 24
//                                                             display_name selected
//                                                             signature_documentation java unresolved_type selected
//                                                              ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                                   ^^^^^^^^^^^ definition local 25
//                                                                               display_name dropTargets
//                                                                               signature_documentation java List dropTargets
//                                                                                    ^^^^ definition local 26
//                                                                                         display_name curX
//                                                                                         signature_documentation java int curX
      int curY) {
//        ^^^^ definition local 27
//             display_name curY
//             signature_documentation java int curY
    //noinspection unchecked
    return chooseDropTarget((EpoxyViewHolder) selected, (List<EpoxyViewHolder>) dropTargets, curX,
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#chooseDropTarget(+1).
//                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                            ^^^^^^^^ reference local 24
//                                                       ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                              ^^^^^^^^^^^ reference local 25
//                                                                                           ^^^^ reference local 26
        curY);
//      ^^^^ reference local 27
  }

  /**
   * @see #chooseDropTarget(ViewHolder, List, int, int)
   */
  protected EpoxyViewHolder chooseDropTarget(EpoxyViewHolder selected,
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                          ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#chooseDropTarget(+1).
//                                           display_name chooseDropTarget
//                                           signature_documentation java protected EpoxyViewHolder chooseDropTarget(EpoxyViewHolder selected, List<EpoxyViewHolder> dropTargets, int curX, int curY)
//                                           documentation  @see #chooseDropTarget(ViewHolder, List, int, int)\n
//                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                           ^^^^^^^^ definition local 28
//                                                                    display_name selected
//                                                                    signature_documentation java EpoxyViewHolder selected
      List<EpoxyViewHolder> dropTargets, int curX, int curY) {
//    ^^^^ reference semanticdb maven jdk 11 java/util/List#
//         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                          ^^^^^^^^^^^ definition local 29
//                                      display_name dropTargets
//                                      signature_documentation java List<EpoxyViewHolder> dropTargets
//                                           ^^^^ definition local 30
//                                                display_name curX
//                                                signature_documentation java int curX
//                                                     ^^^^ definition local 31
//                                                          display_name curY
//                                                          signature_documentation java int curY

    //noinspection unchecked
    return (EpoxyViewHolder) super.chooseDropTarget(selected, (List) dropTargets, curX, curY);
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                           ^^^^^ reference semanticdb maven . . super#
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . super#chooseDropTarget#
//                                                  ^^^^^^^^ reference local 28
//                                                             ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                                   ^^^^^^^^^^^ reference local 29
//                                                                                ^^^^ reference local 30
//                                                                                      ^^^^ reference local 31
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final void onSelectedChanged(ViewHolder viewHolder, int actionState) {
//                  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onSelectedChanged().
//                                    display_name onSelectedChanged
//                                    signature_documentation java @Override\npublic final void onSelectedChanged(unresolved_type viewHolder, int actionState)
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSelectedChanged().
//                                    ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                               ^^^^^^^^^^ definition local 32
//                                                          display_name viewHolder
//                                                          signature_documentation java unresolved_type viewHolder
//                                                               ^^^^^^^^^^^ definition local 33
//                                                                           display_name actionState
//                                                                           signature_documentation java int actionState
    onSelectedChanged((EpoxyViewHolder) viewHolder, actionState);
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onSelectedChanged().
//                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                      ^^^^^^^^^^ reference local 32
//                                                  ^^^^^^^^^^^ reference local 33
  }

  /**
   * @see #onSelectedChanged(ViewHolder, int)
   */
  protected void onSelectedChanged(EpoxyViewHolder viewHolder, int actionState) {
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onSelectedChanged(+-1).
//                                 display_name onSelectedChanged
//                                 signature_documentation java protected void onSelectedChanged(EpoxyViewHolder viewHolder, int actionState)
//                                 documentation  @see #onSelectedChanged(ViewHolder, int)\n
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local 34
//                                                            display_name viewHolder
//                                                            signature_documentation java EpoxyViewHolder viewHolder
//                                                                 ^^^^^^^^^^^ definition local 35
//                                                                             display_name actionState
//                                                                             signature_documentation java int actionState
    super.onSelectedChanged(viewHolder, actionState);
//  ^^^^^ reference semanticdb maven . . super#
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . super#onSelectedChanged#
//                          ^^^^^^^^^^ reference local 34
//                                      ^^^^^^^^^^^ reference local 35
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final void onMoved(RecyclerView recyclerView, ViewHolder viewHolder, int fromPos,
//                  ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onMoved().
//                          display_name onMoved
//                          signature_documentation java @Override\npublic final void onMoved(unresolved_type recyclerView, unresolved_type viewHolder, int fromPos, unresolved_type target, int toPos, int x, int y)
//                          ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                       ^^^^^^^^^^^^ definition local 36
//                                                    display_name recyclerView
//                                                    signature_documentation java unresolved_type recyclerView
//                                                     ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                ^^^^^^^^^^ definition local 37
//                                                                           display_name viewHolder
//                                                                           signature_documentation java unresolved_type viewHolder
//                                                                                ^^^^^^^ definition local 38
//                                                                                        display_name fromPos
//                                                                                        signature_documentation java int fromPos
      ViewHolder target, int toPos, int x, int y) {
//    ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//               ^^^^^^ definition local 39
//                      display_name target
//                      signature_documentation java unresolved_type target
//                           ^^^^^ definition local 40
//                                 display_name toPos
//                                 signature_documentation java int toPos
//                                      ^ definition local 41
//                                        display_name x
//                                        signature_documentation java int x
//                                             ^ definition local 42
//                                               display_name y
//                                               signature_documentation java int y

    onMoved(recyclerView, (EpoxyViewHolder) viewHolder, fromPos, (EpoxyViewHolder) target, toPos, x,
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onMoved().
//          ^^^^^^^^^^^^ reference local 36
//                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                          ^^^^^^^^^^ reference local 37
//                                                      ^^^^^^^ reference local 38
//                                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                 ^^^^^^ reference local 39
//                                                                                         ^^^^^ reference local 40
//                                                                                                ^ reference local 41
        y);
//      ^ reference local 42
  }

  /**
   * @see #onMoved(RecyclerView, ViewHolder, int, ViewHolder, int, int, int)
   */
  protected void onMoved(RecyclerView recyclerView, EpoxyViewHolder viewHolder, int fromPos,
//               ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onMoved(+1).
//                       display_name onMoved
//                       signature_documentation java protected void onMoved(unresolved_type recyclerView, EpoxyViewHolder viewHolder, int fromPos, EpoxyViewHolder target, int toPos, int x, int y)
//                       documentation  @see #onMoved(RecyclerView, ViewHolder, int, ViewHolder, int, int, int)\n
//                       ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                    ^^^^^^^^^^^^ definition local 43
//                                                 display_name recyclerView
//                                                 signature_documentation java unresolved_type recyclerView
//                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                  ^^^^^^^^^^ definition local 44
//                                                                             display_name viewHolder
//                                                                             signature_documentation java EpoxyViewHolder viewHolder
//                                                                                  ^^^^^^^ definition local 45
//                                                                                          display_name fromPos
//                                                                                          signature_documentation java int fromPos
      EpoxyViewHolder target, int toPos, int x, int y) {
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local 46
//                           display_name target
//                           signature_documentation java EpoxyViewHolder target
//                                ^^^^^ definition local 47
//                                      display_name toPos
//                                      signature_documentation java int toPos
//                                           ^ definition local 48
//                                             display_name x
//                                             signature_documentation java int x
//                                                  ^ definition local 49
//                                                    display_name y
//                                                    signature_documentation java int y
    super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
//  ^^^^^ reference semanticdb maven . . super#
//        ^^^^^^^ reference semanticdb maven . . super#onMoved#
//                ^^^^^^^^^^^^ reference local 43
//                              ^^^^^^^^^^ reference local 44
//                                          ^^^^^^^ reference local 45
//                                                   ^^^^^^ reference local 46
//                                                           ^^^^^ reference local 47
//                                                                  ^ reference local 48
//                                                                     ^ reference local 49
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final void clearView(RecyclerView recyclerView, ViewHolder viewHolder) {
//                  ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView().
//                            display_name clearView
//                            signature_documentation java @Override\npublic final void clearView(unresolved_type recyclerView, unresolved_type viewHolder)
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView(+1).
//                            ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                         ^^^^^^^^^^^^ definition local 50
//                                                      display_name recyclerView
//                                                      signature_documentation java unresolved_type recyclerView
//                                                       ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                  ^^^^^^^^^^ definition local 51
//                                                                             display_name viewHolder
//                                                                             signature_documentation java unresolved_type viewHolder
    clearView(recyclerView, (EpoxyViewHolder) viewHolder);
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView().
//            ^^^^^^^^^^^^ reference local 50
//                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                            ^^^^^^^^^^ reference local 51
  }

  /**
   * @see #clearView(RecyclerView, ViewHolder)
   */
  protected void clearView(RecyclerView recyclerView, EpoxyViewHolder viewHolder) {
//               ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView(+1).
//                         display_name clearView
//                         signature_documentation java protected void clearView(unresolved_type recyclerView, EpoxyViewHolder viewHolder)
//                         documentation  @see #clearView(RecyclerView, ViewHolder)\n
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView(+1).
//                         ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                      ^^^^^^^^^^^^ definition local 52
//                                                   display_name recyclerView
//                                                   signature_documentation java unresolved_type recyclerView
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                    ^^^^^^^^^^ definition local 53
//                                                                               display_name viewHolder
//                                                                               signature_documentation java EpoxyViewHolder viewHolder
    super.clearView(recyclerView, viewHolder);
//  ^^^^^ reference semanticdb maven . . super#
//        ^^^^^^^^^ reference semanticdb maven . . super#clearView#
//                  ^^^^^^^^^^^^ reference local 52
//                                ^^^^^^^^^^ reference local 53
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final void onChildDraw(Canvas c, RecyclerView recyclerView, ViewHolder viewHolder,
//                  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw().
//                              display_name onChildDraw
//                              signature_documentation java @Override\npublic final void onChildDraw(unresolved_type c, unresolved_type recyclerView, unresolved_type viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                              ^^^^^^ reference semanticdb maven . . Canvas#
//                                     ^ definition local 54
//                                       display_name c
//                                       signature_documentation java unresolved_type c
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                     ^^^^^^^^^^^^ definition local 55
//                                                                  display_name recyclerView
//                                                                  signature_documentation java unresolved_type recyclerView
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                              ^^^^^^^^^^ definition local 56
//                                                                                         display_name viewHolder
//                                                                                         signature_documentation java unresolved_type viewHolder
      float dX,
//          ^^ definition local 57
//             display_name dX
//             signature_documentation java float dX
      float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local 58
//             display_name dY
//             signature_documentation java float dY
//                  ^^^^^^^^^^^ definition local 59
//                              display_name actionState
//                              signature_documentation java int actionState
//                                       ^^^^^^^^^^^^^^^^^ definition local 60
//                                                         display_name isCurrentlyActive
//                                                         signature_documentation java boolean isCurrentlyActive

    onChildDraw(c, recyclerView, (EpoxyViewHolder) viewHolder, dX, dY, actionState,
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw().
//              ^ reference local 54
//                 ^^^^^^^^^^^^ reference local 55
//                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ reference local 56
//                                                             ^^ reference local 57
//                                                                 ^^ reference local 58
//                                                                     ^^^^^^^^^^^ reference local 59
        isCurrentlyActive);
//      ^^^^^^^^^^^^^^^^^ reference local 60
  }

  /**
   * @see #onChildDraw(Canvas, RecyclerView, ViewHolder, float, float, int, boolean)
   */
  protected void onChildDraw(Canvas c, RecyclerView recyclerView, EpoxyViewHolder viewHolder,
//               ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw(+1).
//                           display_name onChildDraw
//                           signature_documentation java protected void onChildDraw(unresolved_type c, unresolved_type recyclerView, EpoxyViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)
//                           documentation  @see #onChildDraw(Canvas, RecyclerView, ViewHolder, float, float, int, boolean)\n
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                           ^^^^^^ reference semanticdb maven . . Canvas#
//                                  ^ definition local 61
//                                    display_name c
//                                    signature_documentation java unresolved_type c
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                  ^^^^^^^^^^^^ definition local 62
//                                                               display_name recyclerView
//                                                               signature_documentation java unresolved_type recyclerView
//                                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                ^^^^^^^^^^ definition local 63
//                                                                                           display_name viewHolder
//                                                                                           signature_documentation java EpoxyViewHolder viewHolder
      float dX, float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local 64
//             display_name dX
//             signature_documentation java float dX
//                    ^^ definition local 65
//                       display_name dY
//                       signature_documentation java float dY
//                            ^^^^^^^^^^^ definition local 66
//                                        display_name actionState
//                                        signature_documentation java int actionState
//                                                 ^^^^^^^^^^^^^^^^^ definition local 67
//                                                                   display_name isCurrentlyActive
//                                                                   signature_documentation java boolean isCurrentlyActive
    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//  ^^^^^ reference semanticdb maven . . super#
//        ^^^^^^^^^^^ reference semanticdb maven . . super#onChildDraw#
//                    ^ reference local 61
//                       ^^^^^^^^^^^^ reference local 62
//                                     ^^^^^^^^^^ reference local 63
//                                                 ^^ reference local 64
//                                                     ^^ reference local 65
//                                                         ^^^^^^^^^^^ reference local 66
//                                                                      ^^^^^^^^^^^^^^^^^ reference local 67
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final void onChildDrawOver(Canvas c, RecyclerView recyclerView, ViewHolder viewHolder,
//                  ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDrawOver().
//                                  display_name onChildDrawOver
//                                  signature_documentation java @Override\npublic final void onChildDrawOver(unresolved_type c, unresolved_type recyclerView, unresolved_type viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)
//                                  ^^^^^^ reference semanticdb maven . . Canvas#
//                                         ^ definition local 68
//                                           display_name c
//                                           signature_documentation java unresolved_type c
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                         ^^^^^^^^^^^^ definition local 69
//                                                                      display_name recyclerView
//                                                                      signature_documentation java unresolved_type recyclerView
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                                  ^^^^^^^^^^ definition local 70
//                                                                                             display_name viewHolder
//                                                                                             signature_documentation java unresolved_type viewHolder
      float dX,
//          ^^ definition local 71
//             display_name dX
//             signature_documentation java float dX
      float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local 72
//             display_name dY
//             signature_documentation java float dY
//                  ^^^^^^^^^^^ definition local 73
//                              display_name actionState
//                              signature_documentation java int actionState
//                                       ^^^^^^^^^^^^^^^^^ definition local 74
//                                                         display_name isCurrentlyActive
//                                                         signature_documentation java boolean isCurrentlyActive

    onChildDrawOver(c, recyclerView, (EpoxyViewHolder) viewHolder, dX, dY, actionState,
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDrawOver().
//                  ^ reference local 68
//                     ^^^^^^^^^^^^ reference local 69
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^^^^^ reference local 70
//                                                                 ^^ reference local 71
//                                                                     ^^ reference local 72
//                                                                         ^^^^^^^^^^^ reference local 73
        isCurrentlyActive);
//      ^^^^^^^^^^^^^^^^^ reference local 74
  }

  /**
   * @see #onChildDrawOver(Canvas, RecyclerView, ViewHolder, float, float, int, boolean)
   */
  protected void onChildDrawOver(Canvas c, RecyclerView recyclerView, EpoxyViewHolder viewHolder,
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDrawOver(+1).
//                               display_name onChildDrawOver
//                               signature_documentation java protected void onChildDrawOver(unresolved_type c, unresolved_type recyclerView, EpoxyViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)
//                               documentation  @see #onChildDrawOver(Canvas, RecyclerView, ViewHolder, float, float, int, boolean)\n
//                               ^^^^^^ reference semanticdb maven . . Canvas#
//                                      ^ definition local 75
//                                        display_name c
//                                        signature_documentation java unresolved_type c
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                      ^^^^^^^^^^^^ definition local 76
//                                                                   display_name recyclerView
//                                                                   signature_documentation java unresolved_type recyclerView
//                                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                    ^^^^^^^^^^ definition local 77
//                                                                                               display_name viewHolder
//                                                                                               signature_documentation java EpoxyViewHolder viewHolder
      float dX, float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local 78
//             display_name dX
//             signature_documentation java float dX
//                    ^^ definition local 79
//                       display_name dY
//                       signature_documentation java float dY
//                            ^^^^^^^^^^^ definition local 80
//                                        display_name actionState
//                                        signature_documentation java int actionState
//                                                 ^^^^^^^^^^^^^^^^^ definition local 81
//                                                                   display_name isCurrentlyActive
//                                                                   signature_documentation java boolean isCurrentlyActive

    super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//  ^^^^^ reference semanticdb maven . . super#
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . super#onChildDrawOver#
//                        ^ reference local 75
//                           ^^^^^^^^^^^^ reference local 76
//                                         ^^^^^^^^^^ reference local 77
//                                                     ^^ reference local 78
//                                                         ^^ reference local 79
//                                                             ^^^^^^^^^^^ reference local 80
//                                                                          ^^^^^^^^^^^^^^^^^ reference local 81
  }
}
