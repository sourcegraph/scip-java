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
//              ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#`<init>`().
//              ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#
//                                                     ^^^^^^^^^^^^^^^ reference ItemTouchHelper/
//                                                                     ^^^^^^^^ reference ItemTouchHelper/Callback#

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public final int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
//                 ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags().
//                                  ^^^^^^^^^^^^ reference _root_/
//                                               ^^^^^^^^^^^^ definition local0
//                                                             ^^^^^^^^^^ reference _root_/
//                                                                        ^^^^^^^^^^ definition local1
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
//                       ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags(+1).
//                                        ^^^^^^^^^^^^ reference _root_/
//                                                     ^^^^^^^^^^^^ definition local2
//                                                                   ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                   ^^^^^^^^^^ definition local3

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public final boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target) {
//                     ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove().
//                            ^^^^^^^^^^^^ reference _root_/
//                                         ^^^^^^^^^^^^ definition local4
//                                                       ^^^^^^^^^^ reference _root_/
//                                                                  ^^^^^^^^^^ definition local5
//                                                                              ^^^^^^^^^^ reference _root_/
//                                                                                         ^^^^^^ definition local6
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
//                           ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove(+1).
//                                  ^^^^^^^^^^^^ reference _root_/
//                                               ^^^^^^^^^^^^ definition local7
//                                                             ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                             ^^^^^^^^^^ definition local8
      EpoxyViewHolder target);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local9

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public final void onSwiped(ViewHolder viewHolder, int direction) {
//                  ^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onSwiped().
//                           ^^^^^^^^^^ reference _root_/
//                                      ^^^^^^^^^^ definition local10
//                                                      ^^^^^^^^^ definition local11
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
//                        ^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onSwiped(+-1).
//                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local12
//                                                                 ^^^^^^^^^ definition local13

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public final boolean canDropOver(RecyclerView recyclerView, ViewHolder current,
//                     ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver().
//                                 ^^^^^^^^^^^^ reference _root_/
//                                              ^^^^^^^^^^^^ definition local14
//                                                            ^^^^^^^^^^ reference _root_/
//                                                                       ^^^^^^^ definition local15
      ViewHolder target) {
//    ^^^^^^^^^^ reference _root_/
//               ^^^^^^ definition local16
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
//                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver(+1).
//                              ^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^^^^^^^ definition local17
//                                                         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                         ^^^^^^^ definition local18
      EpoxyViewHolder target) {
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local19
    return super.canDropOver(recyclerView, current, target);
//         ^^^^^ reference _root_/
//               ^^^^^^^^^^^ reference canDropOver#
//                           ^^^^^^^^^^^^ reference local17
//                                         ^^^^^^^ reference local18
//                                                  ^^^^^^ reference local19
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public final float getSwipeThreshold(ViewHolder viewHolder) {
//                   ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#getSwipeThreshold().
//                                     ^^^^^^^^^^ reference _root_/
//                                                ^^^^^^^^^^ definition local20
    return getSwipeThreshold((EpoxyViewHolder) viewHolder);
//         ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#getSwipeThreshold().
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                             ^^^^^^^^^^ reference local20
  }

  /**
   * @see #getSwipeThreshold(ViewHolder)
   */
  protected float getSwipeThreshold(EpoxyViewHolder viewHolder) {
//                ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#getSwipeThreshold(+-1).
//                                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                  ^^^^^^^^^^ definition local21
    return super.getSwipeThreshold(viewHolder);
//         ^^^^^ reference _root_/
//               ^^^^^^^^^^^^^^^^^ reference getSwipeThreshold#
//                                 ^^^^^^^^^^ reference local21
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public final float getMoveThreshold(ViewHolder viewHolder) {
//                   ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#getMoveThreshold().
//                                    ^^^^^^^^^^ reference _root_/
//                                               ^^^^^^^^^^ definition local22
    return getMoveThreshold((EpoxyViewHolder) viewHolder);
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelperCallback#getMoveThreshold().
//                           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                            ^^^^^^^^^^ reference local22
  }

  /**
   * @see #getMoveThreshold(ViewHolder)
   */
  protected float getMoveThreshold(EpoxyViewHolder viewHolder) {
//                ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#getMoveThreshold(+-1).
//                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local23
    return super.getMoveThreshold(viewHolder);
//         ^^^^^ reference _root_/
//               ^^^^^^^^^^^^^^^^ reference getMoveThreshold#
//                                ^^^^^^^^^^ reference local23
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public final ViewHolder chooseDropTarget(ViewHolder selected, List dropTargets, int curX,
//             ^^^^^^^^^^ reference _root_/
//                        ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#chooseDropTarget().
//                                         ^^^^^^^^^^ reference _root_/
//                                                    ^^^^^^^^ definition local24
//                                                              ^^^^ reference java/util/List#
//                                                                   ^^^^^^^^^^^ definition local25
//                                                                                    ^^^^ definition local26
      int curY) {
//        ^^^^ definition local27
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
//                          ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#chooseDropTarget(+1).
//                                           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                           ^^^^^^^^ definition local28
      List<EpoxyViewHolder> dropTargets, int curX, int curY) {
//    ^^^^ reference java/util/List#
//         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                          ^^^^^^^^^^^ definition local29
//                                           ^^^^ definition local30
//                                                     ^^^^ definition local31

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
   ^^^^^^^^ reference java/lang/Override#
  public final void onSelectedChanged(ViewHolder viewHolder, int actionState) {
//                  ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onSelectedChanged().
//                                    ^^^^^^^^^^ reference _root_/
//                                               ^^^^^^^^^^ definition local32
//                                                               ^^^^^^^^^^^ definition local33
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
//               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onSelectedChanged(+-1).
//                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local34
//                                                                 ^^^^^^^^^^^ definition local35
    super.onSelectedChanged(viewHolder, actionState);
//  ^^^^^ reference _root_/
//        ^^^^^^^^^^^^^^^^^ reference onSelectedChanged#
//                          ^^^^^^^^^^ reference local34
//                                      ^^^^^^^^^^^ reference local35
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public final void onMoved(RecyclerView recyclerView, ViewHolder viewHolder, int fromPos,
//                  ^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onMoved().
//                          ^^^^^^^^^^^^ reference _root_/
//                                       ^^^^^^^^^^^^ definition local36
//                                                     ^^^^^^^^^^ reference _root_/
//                                                                ^^^^^^^^^^ definition local37
//                                                                                ^^^^^^^ definition local38
      ViewHolder target, int toPos, int x, int y) {
//    ^^^^^^^^^^ reference _root_/
//               ^^^^^^ definition local39
//                           ^^^^^ definition local40
//                                      ^ definition local41
//                                             ^ definition local42

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
//               ^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onMoved(+1).
//                       ^^^^^^^^^^^^ reference _root_/
//                                    ^^^^^^^^^^^^ definition local43
//                                                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                  ^^^^^^^^^^ definition local44
//                                                                                  ^^^^^^^ definition local45
      EpoxyViewHolder target, int toPos, int x, int y) {
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local46
//                                ^^^^^ definition local47
//                                           ^ definition local48
//                                                  ^ definition local49
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
   ^^^^^^^^ reference java/lang/Override#
  public final void clearView(RecyclerView recyclerView, ViewHolder viewHolder) {
//                  ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView().
//                            ^^^^^^^^^^^^ reference _root_/
//                                         ^^^^^^^^^^^^ definition local50
//                                                       ^^^^^^^^^^ reference _root_/
//                                                                  ^^^^^^^^^^ definition local51
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
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView(+1).
//                         ^^^^^^^^^^^^ reference _root_/
//                                      ^^^^^^^^^^^^ definition local52
//                                                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                    ^^^^^^^^^^ definition local53
    super.clearView(recyclerView, viewHolder);
//  ^^^^^ reference _root_/
//        ^^^^^^^^^ reference clearView#
//                  ^^^^^^^^^^^^ reference local52
//                                ^^^^^^^^^^ reference local53
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public final void onChildDraw(Canvas c, RecyclerView recyclerView, ViewHolder viewHolder,
//                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw().
//                              ^^^^^^ reference _root_/
//                                     ^ definition local54
//                                        ^^^^^^^^^^^^ reference _root_/
//                                                     ^^^^^^^^^^^^ definition local55
//                                                                   ^^^^^^^^^^ reference _root_/
//                                                                              ^^^^^^^^^^ definition local56
      float dX,
//          ^^ definition local57
      float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local58
//                  ^^^^^^^^^^^ definition local59
//                                       ^^^^^^^^^^^^^^^^^ definition local60

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
//               ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDraw(+1).
//                           ^^^^^^ reference _root_/
//                                  ^ definition local61
//                                     ^^^^^^^^^^^^ reference _root_/
//                                                  ^^^^^^^^^^^^ definition local62
//                                                                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                ^^^^^^^^^^ definition local63
      float dX, float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local64
//                    ^^ definition local65
//                            ^^^^^^^^^^^ definition local66
//                                                 ^^^^^^^^^^^^^^^^^ definition local67
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
   ^^^^^^^^ reference java/lang/Override#
  public final void onChildDrawOver(Canvas c, RecyclerView recyclerView, ViewHolder viewHolder,
//                  ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDrawOver().
//                                  ^^^^^^ reference _root_/
//                                         ^ definition local68
//                                            ^^^^^^^^^^^^ reference _root_/
//                                                         ^^^^^^^^^^^^ definition local69
//                                                                       ^^^^^^^^^^ reference _root_/
//                                                                                  ^^^^^^^^^^ definition local70
      float dX,
//          ^^ definition local71
      float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local72
//                  ^^^^^^^^^^^ definition local73
//                                       ^^^^^^^^^^^^^^^^^ definition local74

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
//               ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelperCallback#onChildDrawOver(+1).
//                               ^^^^^^ reference _root_/
//                                      ^ definition local75
//                                         ^^^^^^^^^^^^ reference _root_/
//                                                      ^^^^^^^^^^^^ definition local76
//                                                                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                    ^^^^^^^^^^ definition local77
      float dX, float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local78
//                    ^^ definition local79
//                            ^^^^^^^^^^^ definition local80
//                                                 ^^^^^^^^^^^^^^^^^ definition local81

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
