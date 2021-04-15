package com.airbnb.epoxy;

import android.graphics.Canvas;
//     ^^^^^^^ reference android/
//             ^^^^^^^^ reference android/graphics/
//                      ^^^^^^ reference android/graphics/Canvas#

import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

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
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView/
//                                               ^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView/ViewHolder#

/**
 * A wrapper around {@link androidx.recyclerview.widget.ItemTouchHelper.Callback} to cast all
 * view holders to {@link com.airbnb.epoxy.EpoxyViewHolder} for simpler use with Epoxy.
 */
public abstract class EpoxyTouchHelperCallback extends ItemTouchHelper.Callback {
//                    ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback# public abstract class EpoxyTouchHelperCallback extends unresolved_type
//                    ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#`<init>`(). public EpoxyTouchHelperCallback()
//                                                     ^^^^^^^^^^^^^^^ reference ItemTouchHelper/
//                                                                     ^^^^^^^^ reference ItemTouchHelper/Callback#

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
//                 ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags(). @Override public final int getMovementFlags(unresolved_type recyclerView, unresolved_type viewHolder)
//                                  ^^^^^^^^^^^^ reference _root_/
//                                               ^^^^^^^^^^^^ definition local0 unresolved_type recyclerView
//                                                             ^^^^^^^^^^ reference _root_/
//                                                                        ^^^^^^^^^^ definition local1 unresolved_type viewHolder
    return getMovementFlags(recyclerView, (EpoxyViewHolder) viewHolder);
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags().
//                          ^^^^^^^^^^^^ reference local0
//                                         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ reference local1
  }

  /**
   * @see #getMovementFlags(RecyclerView, ViewHolder)
   */
  protected abstract int getMovementFlags(RecyclerView recyclerView, EpoxyViewHolder viewHolder);
//                       ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags(+1). protected abstract int getMovementFlags(unresolved_type recyclerView, EpoxyViewHolder viewHolder)
//                                        ^^^^^^^^^^^^ reference _root_/
//                                                     ^^^^^^^^^^^^ definition local2 unresolved_type recyclerView
//                                                                   ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                   ^^^^^^^^^^ definition local3 EpoxyViewHolder viewHolder

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target) {
//                     ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove(). @Override public final boolean onMove(unresolved_type recyclerView, unresolved_type viewHolder, unresolved_type target)
//                            ^^^^^^^^^^^^ reference _root_/
//                                         ^^^^^^^^^^^^ definition local4 unresolved_type recyclerView
//                                                       ^^^^^^^^^^ reference _root_/
//                                                                  ^^^^^^^^^^ definition local5 unresolved_type viewHolder
//                                                                              ^^^^^^^^^^ reference _root_/
//                                                                                         ^^^^^^ definition local6 unresolved_type target
    return onMove(recyclerView, (EpoxyViewHolder) viewHolder, (EpoxyViewHolder) target);
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove().
//                ^^^^^^^^^^^^ reference local4
//                               ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                ^^^^^^^^^^ reference local5
//                                                             ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                              ^^^^^^ reference local6
  }

  /**
   * @see #onMove(RecyclerView, ViewHolder, ViewHolder)
   */
  protected abstract boolean onMove(RecyclerView recyclerView, EpoxyViewHolder viewHolder,
//                           ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove(+1). protected abstract boolean onMove(unresolved_type recyclerView, EpoxyViewHolder viewHolder, EpoxyViewHolder target)
//                                  ^^^^^^^^^^^^ reference _root_/
//                                               ^^^^^^^^^^^^ definition local7 unresolved_type recyclerView
//                                                             ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                             ^^^^^^^^^^ definition local8 EpoxyViewHolder viewHolder
      EpoxyViewHolder target);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local9 EpoxyViewHolder target

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final void onSwiped(ViewHolder viewHolder, int direction) {
//                  ^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onSwiped(). @Override public final void onSwiped(unresolved_type viewHolder, int direction)
//                           ^^^^^^^^^^ reference _root_/
//                                      ^^^^^^^^^^ definition local10 unresolved_type viewHolder
//                                                      ^^^^^^^^^ definition local11 int direction
    onSwiped((EpoxyViewHolder) viewHolder, direction);
//  ^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#onSwiped().
//            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                             ^^^^^^^^^^ reference local10
//                                         ^^^^^^^^^ reference local11
  }

  /**
   * @see #onSwiped(ViewHolder, int)
   */
  protected abstract void onSwiped(EpoxyViewHolder viewHolder, int direction);
//                        ^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onSwiped(+-1). protected abstract void onSwiped(EpoxyViewHolder viewHolder, int direction)
//                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local12 EpoxyViewHolder viewHolder
//                                                                 ^^^^^^^^^ definition local13 int direction

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final boolean canDropOver(RecyclerView recyclerView, ViewHolder current,
//                     ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver(). @Override public final boolean canDropOver(unresolved_type recyclerView, unresolved_type current, unresolved_type target)
//                                 ^^^^^^^^^^^^ reference _root_/
//                                              ^^^^^^^^^^^^ definition local14 unresolved_type recyclerView
//                                                            ^^^^^^^^^^ reference _root_/
//                                                                       ^^^^^^^ definition local15 unresolved_type current
      ViewHolder target) {
//    ^^^^^^^^^^ reference _root_/
//               ^^^^^^ definition local16 unresolved_type target
    return canDropOver(recyclerView, (EpoxyViewHolder) current, (EpoxyViewHolder) target);
//         ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver().
//                     ^^^^^^^^^^^^ reference local14
//                                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^^ reference local15
//                                                               ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                ^^^^^^ reference local16
  }

  /**
   * @see #canDropOver(RecyclerView, ViewHolder, ViewHolder)
   */
  protected boolean canDropOver(RecyclerView recyclerView, EpoxyViewHolder current,
//                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver(+1). protected boolean canDropOver(unresolved_type recyclerView, EpoxyViewHolder current, EpoxyViewHolder target)
//                              ^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^^^^^^^ definition local17 unresolved_type recyclerView
//                                                         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                         ^^^^^^^ definition local18 EpoxyViewHolder current
      EpoxyViewHolder target) {
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local19 EpoxyViewHolder target
    return super.canDropOver(recyclerView, current, target);
//         ^^^^^ reference _root_/
//               ^^^^^^^^^^^ reference canDropOver#
//                           ^^^^^^^^^^^^ reference local17
//                                         ^^^^^^^ reference local18
//                                                  ^^^^^^ reference local19
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final float getSwipeThreshold(ViewHolder viewHolder) {
//                   ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#getSwipeThreshold(). @Override public final float getSwipeThreshold(unresolved_type viewHolder)
//                                     ^^^^^^^^^^ reference _root_/
//                                                ^^^^^^^^^^ definition local20 unresolved_type viewHolder
    return getSwipeThreshold((EpoxyViewHolder) viewHolder);
//         ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#getSwipeThreshold().
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                             ^^^^^^^^^^ reference local20
  }

  /**
   * @see #getSwipeThreshold(ViewHolder)
   */
  protected float getSwipeThreshold(EpoxyViewHolder viewHolder) {
//                ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#getSwipeThreshold(+-1). protected float getSwipeThreshold(EpoxyViewHolder viewHolder)
//                                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                  ^^^^^^^^^^ definition local21 EpoxyViewHolder viewHolder
    return super.getSwipeThreshold(viewHolder);
//         ^^^^^ reference _root_/
//               ^^^^^^^^^^^^^^^^^ reference getSwipeThreshold#
//                                 ^^^^^^^^^^ reference local21
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final float getMoveThreshold(ViewHolder viewHolder) {
//                   ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#getMoveThreshold(). @Override public final float getMoveThreshold(unresolved_type viewHolder)
//                                    ^^^^^^^^^^ reference _root_/
//                                               ^^^^^^^^^^ definition local22 unresolved_type viewHolder
    return getMoveThreshold((EpoxyViewHolder) viewHolder);
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#getMoveThreshold().
//                           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                            ^^^^^^^^^^ reference local22
  }

  /**
   * @see #getMoveThreshold(ViewHolder)
   */
  protected float getMoveThreshold(EpoxyViewHolder viewHolder) {
//                ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#getMoveThreshold(+-1). protected float getMoveThreshold(EpoxyViewHolder viewHolder)
//                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local23 EpoxyViewHolder viewHolder
    return super.getMoveThreshold(viewHolder);
//         ^^^^^ reference _root_/
//               ^^^^^^^^^^^^^^^^ reference getMoveThreshold#
//                                ^^^^^^^^^^ reference local23
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final ViewHolder chooseDropTarget(ViewHolder selected, List dropTargets, int curX,
//             ^^^^^^^^^^ reference _root_/
//                        ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#chooseDropTarget(). @Override public final chooseDropTarget(unresolved_type selected, List dropTargets, int curX, int curY)
//                                         ^^^^^^^^^^ reference _root_/
//                                                    ^^^^^^^^ definition local24 unresolved_type selected
//                                                              ^^^^ reference java/util/List#
//                                                                   ^^^^^^^^^^^ definition local25 List dropTargets
//                                                                                    ^^^^ definition local26 int curX
      int curY) {
//        ^^^^ definition local27 int curY
    //noinspection unchecked
    return chooseDropTarget((EpoxyViewHolder) selected, (List<EpoxyViewHolder>) dropTargets, curX,
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#chooseDropTarget(+1).
//                           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                            ^^^^^^^^ reference local24
//                                                       ^^^^ reference java/util/List#
//                                                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                              ^^^^^^^^^^^ reference local25
//                                                                                           ^^^^ reference local26
        curY);
//      ^^^^ reference local27
  }

  /**
   * @see #chooseDropTarget(ViewHolder, List, int, int)
   */
  protected EpoxyViewHolder chooseDropTarget(EpoxyViewHolder selected,
//          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                          ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#chooseDropTarget(+1). protected EpoxyViewHolder chooseDropTarget(EpoxyViewHolder selected, List<EpoxyViewHolder> dropTargets, int curX, int curY)
//                                           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                           ^^^^^^^^ definition local28 EpoxyViewHolder selected
      List<EpoxyViewHolder> dropTargets, int curX, int curY) {
//    ^^^^ reference java/util/List#
//         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                          ^^^^^^^^^^^ definition local29 List<EpoxyViewHolder> dropTargets
//                                           ^^^^ definition local30 int curX
//                                                     ^^^^ definition local31 int curY

    //noinspection unchecked
    return (EpoxyViewHolder) super.chooseDropTarget(selected, (List) dropTargets, curX, curY);
//          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                           ^^^^^ reference _root_/
//                                 ^^^^^^^^^^^^^^^^ reference chooseDropTarget#
//                                                  ^^^^^^^^ reference local28
//                                                             ^^^^ reference java/util/List#
//                                                                   ^^^^^^^^^^^ reference local29
//                                                                                ^^^^ reference local30
//                                                                                      ^^^^ reference local31
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final void onSelectedChanged(ViewHolder viewHolder, int actionState) {
//                  ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onSelectedChanged(). @Override public final void onSelectedChanged(unresolved_type viewHolder, int actionState)
//                                    ^^^^^^^^^^ reference _root_/
//                                               ^^^^^^^^^^ definition local32 unresolved_type viewHolder
//                                                               ^^^^^^^^^^^ definition local33 int actionState
    onSelectedChanged((EpoxyViewHolder) viewHolder, actionState);
//  ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#onSelectedChanged().
//                     ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                      ^^^^^^^^^^ reference local32
//                                                  ^^^^^^^^^^^ reference local33
  }

  /**
   * @see #onSelectedChanged(ViewHolder, int)
   */
  protected void onSelectedChanged(EpoxyViewHolder viewHolder, int actionState) {
//               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onSelectedChanged(+-1). protected void onSelectedChanged(EpoxyViewHolder viewHolder, int actionState)
//                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local34 EpoxyViewHolder viewHolder
//                                                                 ^^^^^^^^^^^ definition local35 int actionState
    super.onSelectedChanged(viewHolder, actionState);
//  ^^^^^ reference _root_/
//        ^^^^^^^^^^^^^^^^^ reference onSelectedChanged#
//                          ^^^^^^^^^^ reference local34
//                                      ^^^^^^^^^^^ reference local35
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final void onMoved(RecyclerView recyclerView, ViewHolder viewHolder, int fromPos,
//                  ^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onMoved(). @Override public final void onMoved(unresolved_type recyclerView, unresolved_type viewHolder, int fromPos, unresolved_type target, int toPos, int x, int y)
//                          ^^^^^^^^^^^^ reference _root_/
//                                       ^^^^^^^^^^^^ definition local36 unresolved_type recyclerView
//                                                     ^^^^^^^^^^ reference _root_/
//                                                                ^^^^^^^^^^ definition local37 unresolved_type viewHolder
//                                                                                ^^^^^^^ definition local38 int fromPos
      ViewHolder target, int toPos, int x, int y) {
//    ^^^^^^^^^^ reference _root_/
//               ^^^^^^ definition local39 unresolved_type target
//                           ^^^^^ definition local40 int toPos
//                                      ^ definition local41 int x
//                                             ^ definition local42 int y

    onMoved(recyclerView, (EpoxyViewHolder) viewHolder, fromPos, (EpoxyViewHolder) target, toPos, x,
//  ^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#onMoved().
//          ^^^^^^^^^^^^ reference local36
//                         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                          ^^^^^^^^^^ reference local37
//                                                      ^^^^^^^ reference local38
//                                                                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                 ^^^^^^ reference local39
//                                                                                         ^^^^^ reference local40
//                                                                                                ^ reference local41
        y);
//      ^ reference local42
  }

  /**
   * @see #onMoved(RecyclerView, ViewHolder, int, ViewHolder, int, int, int)
   */
  protected void onMoved(RecyclerView recyclerView, EpoxyViewHolder viewHolder, int fromPos,
//               ^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onMoved(+1). protected void onMoved(unresolved_type recyclerView, EpoxyViewHolder viewHolder, int fromPos, EpoxyViewHolder target, int toPos, int x, int y)
//                       ^^^^^^^^^^^^ reference _root_/
//                                    ^^^^^^^^^^^^ definition local43 unresolved_type recyclerView
//                                                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                  ^^^^^^^^^^ definition local44 EpoxyViewHolder viewHolder
//                                                                                  ^^^^^^^ definition local45 int fromPos
      EpoxyViewHolder target, int toPos, int x, int y) {
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local46 EpoxyViewHolder target
//                                ^^^^^ definition local47 int toPos
//                                           ^ definition local48 int x
//                                                  ^ definition local49 int y
    super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
//  ^^^^^ reference _root_/
//        ^^^^^^^ reference onMoved#
//                ^^^^^^^^^^^^ reference local43
//                              ^^^^^^^^^^ reference local44
//                                          ^^^^^^^ reference local45
//                                                   ^^^^^^ reference local46
//                                                           ^^^^^ reference local47
//                                                                  ^ reference local48
//                                                                     ^ reference local49
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final void clearView(RecyclerView recyclerView, ViewHolder viewHolder) {
//                  ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView(). @Override public final void clearView(unresolved_type recyclerView, unresolved_type viewHolder)
//                            ^^^^^^^^^^^^ reference _root_/
//                                         ^^^^^^^^^^^^ definition local50 unresolved_type recyclerView
//                                                       ^^^^^^^^^^ reference _root_/
//                                                                  ^^^^^^^^^^ definition local51 unresolved_type viewHolder
    clearView(recyclerView, (EpoxyViewHolder) viewHolder);
//  ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView().
//            ^^^^^^^^^^^^ reference local50
//                           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                            ^^^^^^^^^^ reference local51
  }

  /**
   * @see #clearView(RecyclerView, ViewHolder)
   */
  protected void clearView(RecyclerView recyclerView, EpoxyViewHolder viewHolder) {
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView(+1). protected void clearView(unresolved_type recyclerView, EpoxyViewHolder viewHolder)
//                         ^^^^^^^^^^^^ reference _root_/
//                                      ^^^^^^^^^^^^ definition local52 unresolved_type recyclerView
//                                                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                    ^^^^^^^^^^ definition local53 EpoxyViewHolder viewHolder
    super.clearView(recyclerView, viewHolder);
//  ^^^^^ reference _root_/
//        ^^^^^^^^^ reference clearView#
//                  ^^^^^^^^^^^^ reference local52
//                                ^^^^^^^^^^ reference local53
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final void onChildDraw(Canvas c, RecyclerView recyclerView, ViewHolder viewHolder,
//                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw(). @Override public final void onChildDraw(unresolved_type c, unresolved_type recyclerView, unresolved_type viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)
//                              ^^^^^^ reference _root_/
//                                     ^ definition local54 unresolved_type c
//                                        ^^^^^^^^^^^^ reference _root_/
//                                                     ^^^^^^^^^^^^ definition local55 unresolved_type recyclerView
//                                                                   ^^^^^^^^^^ reference _root_/
//                                                                              ^^^^^^^^^^ definition local56 unresolved_type viewHolder
      float dX,
//          ^^ definition local57 float dX
      float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local58 float dY
//                  ^^^^^^^^^^^ definition local59 int actionState
//                                       ^^^^^^^^^^^^^^^^^ definition local60 boolean isCurrentlyActive

    onChildDraw(c, recyclerView, (EpoxyViewHolder) viewHolder, dX, dY, actionState,
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw().
//              ^ reference local54
//                 ^^^^^^^^^^^^ reference local55
//                                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ reference local56
//                                                             ^^ reference local57
//                                                                 ^^ reference local58
//                                                                     ^^^^^^^^^^^ reference local59
        isCurrentlyActive);
//      ^^^^^^^^^^^^^^^^^ reference local60
  }

  /**
   * @see #onChildDraw(Canvas, RecyclerView, ViewHolder, float, float, int, boolean)
   */
  protected void onChildDraw(Canvas c, RecyclerView recyclerView, EpoxyViewHolder viewHolder,
//               ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw(+1). protected void onChildDraw(unresolved_type c, unresolved_type recyclerView, EpoxyViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)
//                           ^^^^^^ reference _root_/
//                                  ^ definition local61 unresolved_type c
//                                     ^^^^^^^^^^^^ reference _root_/
//                                                  ^^^^^^^^^^^^ definition local62 unresolved_type recyclerView
//                                                                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                ^^^^^^^^^^ definition local63 EpoxyViewHolder viewHolder
      float dX, float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local64 float dX
//                    ^^ definition local65 float dY
//                            ^^^^^^^^^^^ definition local66 int actionState
//                                                 ^^^^^^^^^^^^^^^^^ definition local67 boolean isCurrentlyActive
    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//  ^^^^^ reference _root_/
//        ^^^^^^^^^^^ reference onChildDraw#
//                    ^ reference local61
//                       ^^^^^^^^^^^^ reference local62
//                                     ^^^^^^^^^^ reference local63
//                                                 ^^ reference local64
//                                                     ^^ reference local65
//                                                         ^^^^^^^^^^^ reference local66
//                                                                      ^^^^^^^^^^^^^^^^^ reference local67
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final void onChildDrawOver(Canvas c, RecyclerView recyclerView, ViewHolder viewHolder,
//                  ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDrawOver(). @Override public final void onChildDrawOver(unresolved_type c, unresolved_type recyclerView, unresolved_type viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)
//                                  ^^^^^^ reference _root_/
//                                         ^ definition local68 unresolved_type c
//                                            ^^^^^^^^^^^^ reference _root_/
//                                                         ^^^^^^^^^^^^ definition local69 unresolved_type recyclerView
//                                                                       ^^^^^^^^^^ reference _root_/
//                                                                                  ^^^^^^^^^^ definition local70 unresolved_type viewHolder
      float dX,
//          ^^ definition local71 float dX
      float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local72 float dY
//                  ^^^^^^^^^^^ definition local73 int actionState
//                                       ^^^^^^^^^^^^^^^^^ definition local74 boolean isCurrentlyActive

    onChildDrawOver(c, recyclerView, (EpoxyViewHolder) viewHolder, dX, dY, actionState,
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDrawOver().
//                  ^ reference local68
//                     ^^^^^^^^^^^^ reference local69
//                                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^^^^^ reference local70
//                                                                 ^^ reference local71
//                                                                     ^^ reference local72
//                                                                         ^^^^^^^^^^^ reference local73
        isCurrentlyActive);
//      ^^^^^^^^^^^^^^^^^ reference local74
  }

  /**
   * @see #onChildDrawOver(Canvas, RecyclerView, ViewHolder, float, float, int, boolean)
   */
  protected void onChildDrawOver(Canvas c, RecyclerView recyclerView, EpoxyViewHolder viewHolder,
//               ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDrawOver(+1). protected void onChildDrawOver(unresolved_type c, unresolved_type recyclerView, EpoxyViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)
//                               ^^^^^^ reference _root_/
//                                      ^ definition local75 unresolved_type c
//                                         ^^^^^^^^^^^^ reference _root_/
//                                                      ^^^^^^^^^^^^ definition local76 unresolved_type recyclerView
//                                                                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                    ^^^^^^^^^^ definition local77 EpoxyViewHolder viewHolder
      float dX, float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local78 float dX
//                    ^^ definition local79 float dY
//                            ^^^^^^^^^^^ definition local80 int actionState
//                                                 ^^^^^^^^^^^^^^^^^ definition local81 boolean isCurrentlyActive

    super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//  ^^^^^ reference _root_/
//        ^^^^^^^^^^^^^^^ reference onChildDrawOver#
//                        ^ reference local75
//                           ^^^^^^^^^^^^ reference local76
//                                         ^^^^^^^^^^ reference local77
//                                                     ^^ reference local78
//                                                         ^^ reference local79
//                                                             ^^^^^^^^^^^ reference local80
//                                                                          ^^^^^^^^^^^^^^^^^ reference local81
  }
}
