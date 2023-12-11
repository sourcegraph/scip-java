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
//                                             documentation ```java\npublic abstract class EpoxyTouchHelperCallback\n```
//                                             documentation  A wrapper around {@link androidx.recyclerview.widget.ItemTouchHelper.Callback} to cast all\n view holders to {@link com.airbnb.epoxy.EpoxyViewHolder} for simpler use with Epoxy.\n
//                                             relationship is_implementation semanticdb maven . . ItemTouchHelper/Callback#
//                    ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#`<init>`().
//                                             display_name <init>
//                                             documentation ```java\npublic EpoxyTouchHelperCallback()\n```
//                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . ItemTouchHelper/
//                                                                     ^^^^^^^^ reference semanticdb maven . . ItemTouchHelper/Callback#

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
//                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#getMovementFlags().
//                                  display_name getMovementFlags
//                                  documentation ```java\n@Override\npublic final int getMovementFlags(unresolved_type recyclerView, unresolved_type viewHolder)\n```
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#getMovementFlags().
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                               ^^^^^^^^^^^^ definition local 0
//                                                            display_name recyclerView
//                                                            documentation ```java\nunresolved_type recyclerView\n```
//                                                             ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                        ^^^^^^^^^^ definition local 1
//                                                                                   display_name viewHolder
//                                                                                   documentation ```java\nunresolved_type viewHolder\n```
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
//                                        documentation ```java\nprotected abstract int getMovementFlags(unresolved_type recyclerView, EpoxyViewHolder viewHolder)\n```
//                                        documentation  @see #getMovementFlags(RecyclerView, ViewHolder)\n
//                                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#getMovementFlags().
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                     ^^^^^^^^^^^^ definition local 2
//                                                                  display_name recyclerView
//                                                                  documentation ```java\nunresolved_type recyclerView\n```
//                                                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                   ^^^^^^^^^^ definition local 3
//                                                                                              display_name viewHolder
//                                                                                              documentation ```java\nEpoxyViewHolder viewHolder\n```

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target) {
//                     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onMove().
//                            display_name onMove
//                            documentation ```java\n@Override\npublic final boolean onMove(unresolved_type recyclerView, unresolved_type viewHolder, unresolved_type target)\n```
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onMove().
//                            ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                         ^^^^^^^^^^^^ definition local 4
//                                                      display_name recyclerView
//                                                      documentation ```java\nunresolved_type recyclerView\n```
//                                                       ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                  ^^^^^^^^^^ definition local 5
//                                                                             display_name viewHolder
//                                                                             documentation ```java\nunresolved_type viewHolder\n```
//                                                                              ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                                         ^^^^^^ definition local 6
//                                                                                                display_name target
//                                                                                                documentation ```java\nunresolved_type target\n```
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
//                                  documentation ```java\nprotected abstract boolean onMove(unresolved_type recyclerView, EpoxyViewHolder viewHolder, EpoxyViewHolder target)\n```
//                                  documentation  @see #onMove(RecyclerView, ViewHolder, ViewHolder)\n
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onMove().
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                               ^^^^^^^^^^^^ definition local 7
//                                                            display_name recyclerView
//                                                            documentation ```java\nunresolved_type recyclerView\n```
//                                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                             ^^^^^^^^^^ definition local 8
//                                                                                        display_name viewHolder
//                                                                                        documentation ```java\nEpoxyViewHolder viewHolder\n```
      EpoxyViewHolder target);
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local 9
//                           display_name target
//                           documentation ```java\nEpoxyViewHolder target\n```

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final void onSwiped(ViewHolder viewHolder, int direction) {
//                  ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#onSwiped().
//                           display_name onSwiped
//                           documentation ```java\n@Override\npublic final void onSwiped(unresolved_type viewHolder, int direction)\n```
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwiped().
//                           ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                      ^^^^^^^^^^ definition local 10
//                                                 display_name viewHolder
//                                                 documentation ```java\nunresolved_type viewHolder\n```
//                                                      ^^^^^^^^^ definition local 11
//                                                                display_name direction
//                                                                documentation ```java\nint direction\n```
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
//                                 documentation ```java\nprotected abstract void onSwiped(EpoxyViewHolder viewHolder, int direction)\n```
//                                 documentation  @see #onSwiped(ViewHolder, int)\n
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local 12
//                                                            display_name viewHolder
//                                                            documentation ```java\nEpoxyViewHolder viewHolder\n```
//                                                                 ^^^^^^^^^ definition local 13
//                                                                           display_name direction
//                                                                           documentation ```java\nint direction\n```

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final boolean canDropOver(RecyclerView recyclerView, ViewHolder current,
//                     ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#canDropOver().
//                                 display_name canDropOver
//                                 documentation ```java\n@Override\npublic final boolean canDropOver(unresolved_type recyclerView, unresolved_type current, unresolved_type target)\n```
//                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#canDropOver().
//                                 ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                              ^^^^^^^^^^^^ definition local 14
//                                                           display_name recyclerView
//                                                           documentation ```java\nunresolved_type recyclerView\n```
//                                                            ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                       ^^^^^^^ definition local 15
//                                                                               display_name current
//                                                                               documentation ```java\nunresolved_type current\n```
      ViewHolder target) {
//    ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//               ^^^^^^ definition local 16
//                      display_name target
//                      documentation ```java\nunresolved_type target\n```
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
//                              documentation ```java\nprotected boolean canDropOver(unresolved_type recyclerView, EpoxyViewHolder current, EpoxyViewHolder target)\n```
//                              documentation  @see #canDropOver(RecyclerView, ViewHolder, ViewHolder)\n
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#canDropOver().
//                              ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                           ^^^^^^^^^^^^ definition local 17
//                                                        display_name recyclerView
//                                                        documentation ```java\nunresolved_type recyclerView\n```
//                                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                         ^^^^^^^ definition local 18
//                                                                                 display_name current
//                                                                                 documentation ```java\nEpoxyViewHolder current\n```
      EpoxyViewHolder target) {
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local 19
//                           display_name target
//                           documentation ```java\nEpoxyViewHolder target\n```
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
//                                     documentation ```java\n@Override\npublic final float getSwipeThreshold(unresolved_type viewHolder)\n```
//                                     ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                ^^^^^^^^^^ definition local 20
//                                                           display_name viewHolder
//                                                           documentation ```java\nunresolved_type viewHolder\n```
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
//                                  documentation ```java\nprotected float getSwipeThreshold(EpoxyViewHolder viewHolder)\n```
//                                  documentation  @see #getSwipeThreshold(ViewHolder)\n
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                  ^^^^^^^^^^ definition local 21
//                                                             display_name viewHolder
//                                                             documentation ```java\nEpoxyViewHolder viewHolder\n```
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
//                                    documentation ```java\n@Override\npublic final float getMoveThreshold(unresolved_type viewHolder)\n```
//                                    ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                               ^^^^^^^^^^ definition local 22
//                                                          display_name viewHolder
//                                                          documentation ```java\nunresolved_type viewHolder\n```
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
//                                 documentation ```java\nprotected float getMoveThreshold(EpoxyViewHolder viewHolder)\n```
//                                 documentation  @see #getMoveThreshold(ViewHolder)\n
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local 23
//                                                            display_name viewHolder
//                                                            documentation ```java\nEpoxyViewHolder viewHolder\n```
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
//                                         documentation ```java\n@Override\npublic final unresolved_type chooseDropTarget(unresolved_type selected, List dropTargets, int curX, int curY)\n```
//                                         ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                    ^^^^^^^^ definition local 24
//                                                             display_name selected
//                                                             documentation ```java\nunresolved_type selected\n```
//                                                              ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                                   ^^^^^^^^^^^ definition local 25
//                                                                               display_name dropTargets
//                                                                               documentation ```java\nList dropTargets\n```
//                                                                                    ^^^^ definition local 26
//                                                                                         display_name curX
//                                                                                         documentation ```java\nint curX\n```
      int curY) {
//        ^^^^ definition local 27
//             display_name curY
//             documentation ```java\nint curY\n```
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
//                                           documentation ```java\nprotected EpoxyViewHolder chooseDropTarget(EpoxyViewHolder selected, List<EpoxyViewHolder> dropTargets, int curX, int curY)\n```
//                                           documentation  @see #chooseDropTarget(ViewHolder, List, int, int)\n
//                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                           ^^^^^^^^ definition local 28
//                                                                    display_name selected
//                                                                    documentation ```java\nEpoxyViewHolder selected\n```
      List<EpoxyViewHolder> dropTargets, int curX, int curY) {
//    ^^^^ reference semanticdb maven jdk 11 java/util/List#
//         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                          ^^^^^^^^^^^ definition local 29
//                                      display_name dropTargets
//                                      documentation ```java\nList<EpoxyViewHolder> dropTargets\n```
//                                           ^^^^ definition local 30
//                                                display_name curX
//                                                documentation ```java\nint curX\n```
//                                                     ^^^^ definition local 31
//                                                          display_name curY
//                                                          documentation ```java\nint curY\n```

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
//                                    documentation ```java\n@Override\npublic final void onSelectedChanged(unresolved_type viewHolder, int actionState)\n```
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSelectedChanged().
//                                    ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                               ^^^^^^^^^^ definition local 32
//                                                          display_name viewHolder
//                                                          documentation ```java\nunresolved_type viewHolder\n```
//                                                               ^^^^^^^^^^^ definition local 33
//                                                                           display_name actionState
//                                                                           documentation ```java\nint actionState\n```
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
//                                 documentation ```java\nprotected void onSelectedChanged(EpoxyViewHolder viewHolder, int actionState)\n```
//                                 documentation  @see #onSelectedChanged(ViewHolder, int)\n
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local 34
//                                                            display_name viewHolder
//                                                            documentation ```java\nEpoxyViewHolder viewHolder\n```
//                                                                 ^^^^^^^^^^^ definition local 35
//                                                                             display_name actionState
//                                                                             documentation ```java\nint actionState\n```
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
//                          documentation ```java\n@Override\npublic final void onMoved(unresolved_type recyclerView, unresolved_type viewHolder, int fromPos, unresolved_type target, int toPos, int x, int y)\n```
//                          ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                       ^^^^^^^^^^^^ definition local 36
//                                                    display_name recyclerView
//                                                    documentation ```java\nunresolved_type recyclerView\n```
//                                                     ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                ^^^^^^^^^^ definition local 37
//                                                                           display_name viewHolder
//                                                                           documentation ```java\nunresolved_type viewHolder\n```
//                                                                                ^^^^^^^ definition local 38
//                                                                                        display_name fromPos
//                                                                                        documentation ```java\nint fromPos\n```
      ViewHolder target, int toPos, int x, int y) {
//    ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//               ^^^^^^ definition local 39
//                      display_name target
//                      documentation ```java\nunresolved_type target\n```
//                           ^^^^^ definition local 40
//                                 display_name toPos
//                                 documentation ```java\nint toPos\n```
//                                      ^ definition local 41
//                                        display_name x
//                                        documentation ```java\nint x\n```
//                                             ^ definition local 42
//                                               display_name y
//                                               documentation ```java\nint y\n```

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
//                       documentation ```java\nprotected void onMoved(unresolved_type recyclerView, EpoxyViewHolder viewHolder, int fromPos, EpoxyViewHolder target, int toPos, int x, int y)\n```
//                       documentation  @see #onMoved(RecyclerView, ViewHolder, int, ViewHolder, int, int, int)\n
//                       ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                    ^^^^^^^^^^^^ definition local 43
//                                                 display_name recyclerView
//                                                 documentation ```java\nunresolved_type recyclerView\n```
//                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                  ^^^^^^^^^^ definition local 44
//                                                                             display_name viewHolder
//                                                                             documentation ```java\nEpoxyViewHolder viewHolder\n```
//                                                                                  ^^^^^^^ definition local 45
//                                                                                          display_name fromPos
//                                                                                          documentation ```java\nint fromPos\n```
      EpoxyViewHolder target, int toPos, int x, int y) {
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                    ^^^^^^ definition local 46
//                           display_name target
//                           documentation ```java\nEpoxyViewHolder target\n```
//                                ^^^^^ definition local 47
//                                      display_name toPos
//                                      documentation ```java\nint toPos\n```
//                                           ^ definition local 48
//                                             display_name x
//                                             documentation ```java\nint x\n```
//                                                  ^ definition local 49
//                                                    display_name y
//                                                    documentation ```java\nint y\n```
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
//                            documentation ```java\n@Override\npublic final void clearView(unresolved_type recyclerView, unresolved_type viewHolder)\n```
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView(+1).
//                            ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                         ^^^^^^^^^^^^ definition local 50
//                                                      display_name recyclerView
//                                                      documentation ```java\nunresolved_type recyclerView\n```
//                                                       ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                  ^^^^^^^^^^ definition local 51
//                                                                             display_name viewHolder
//                                                                             documentation ```java\nunresolved_type viewHolder\n```
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
//                         documentation ```java\nprotected void clearView(unresolved_type recyclerView, EpoxyViewHolder viewHolder)\n```
//                         documentation  @see #clearView(RecyclerView, ViewHolder)\n
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView(+1).
//                         ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                      ^^^^^^^^^^^^ definition local 52
//                                                   display_name recyclerView
//                                                   documentation ```java\nunresolved_type recyclerView\n```
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                    ^^^^^^^^^^ definition local 53
//                                                                               display_name viewHolder
//                                                                               documentation ```java\nEpoxyViewHolder viewHolder\n```
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
//                              documentation ```java\n@Override\npublic final void onChildDraw(unresolved_type c, unresolved_type recyclerView, unresolved_type viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)\n```
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                              ^^^^^^ reference semanticdb maven . . Canvas#
//                                     ^ definition local 54
//                                       display_name c
//                                       documentation ```java\nunresolved_type c\n```
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                     ^^^^^^^^^^^^ definition local 55
//                                                                  display_name recyclerView
//                                                                  documentation ```java\nunresolved_type recyclerView\n```
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                              ^^^^^^^^^^ definition local 56
//                                                                                         display_name viewHolder
//                                                                                         documentation ```java\nunresolved_type viewHolder\n```
      float dX,
//          ^^ definition local 57
//             display_name dX
//             documentation ```java\nfloat dX\n```
      float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local 58
//             display_name dY
//             documentation ```java\nfloat dY\n```
//                  ^^^^^^^^^^^ definition local 59
//                              display_name actionState
//                              documentation ```java\nint actionState\n```
//                                       ^^^^^^^^^^^^^^^^^ definition local 60
//                                                         display_name isCurrentlyActive
//                                                         documentation ```java\nboolean isCurrentlyActive\n```

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
//                           documentation ```java\nprotected void onChildDraw(unresolved_type c, unresolved_type recyclerView, EpoxyViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)\n```
//                           documentation  @see #onChildDraw(Canvas, RecyclerView, ViewHolder, float, float, int, boolean)\n
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onChildDraw().
//                           ^^^^^^ reference semanticdb maven . . Canvas#
//                                  ^ definition local 61
//                                    display_name c
//                                    documentation ```java\nunresolved_type c\n```
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                  ^^^^^^^^^^^^ definition local 62
//                                                               display_name recyclerView
//                                                               documentation ```java\nunresolved_type recyclerView\n```
//                                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                ^^^^^^^^^^ definition local 63
//                                                                                           display_name viewHolder
//                                                                                           documentation ```java\nEpoxyViewHolder viewHolder\n```
      float dX, float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local 64
//             display_name dX
//             documentation ```java\nfloat dX\n```
//                    ^^ definition local 65
//                       display_name dY
//                       documentation ```java\nfloat dY\n```
//                            ^^^^^^^^^^^ definition local 66
//                                        display_name actionState
//                                        documentation ```java\nint actionState\n```
//                                                 ^^^^^^^^^^^^^^^^^ definition local 67
//                                                                   display_name isCurrentlyActive
//                                                                   documentation ```java\nboolean isCurrentlyActive\n```
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
//                                  documentation ```java\n@Override\npublic final void onChildDrawOver(unresolved_type c, unresolved_type recyclerView, unresolved_type viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)\n```
//                                  ^^^^^^ reference semanticdb maven . . Canvas#
//                                         ^ definition local 68
//                                           display_name c
//                                           documentation ```java\nunresolved_type c\n```
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                         ^^^^^^^^^^^^ definition local 69
//                                                                      display_name recyclerView
//                                                                      documentation ```java\nunresolved_type recyclerView\n```
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//                                                                                  ^^^^^^^^^^ definition local 70
//                                                                                             display_name viewHolder
//                                                                                             documentation ```java\nunresolved_type viewHolder\n```
      float dX,
//          ^^ definition local 71
//             display_name dX
//             documentation ```java\nfloat dX\n```
      float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local 72
//             display_name dY
//             documentation ```java\nfloat dY\n```
//                  ^^^^^^^^^^^ definition local 73
//                              display_name actionState
//                              documentation ```java\nint actionState\n```
//                                       ^^^^^^^^^^^^^^^^^ definition local 74
//                                                         display_name isCurrentlyActive
//                                                         documentation ```java\nboolean isCurrentlyActive\n```

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
//                               documentation ```java\nprotected void onChildDrawOver(unresolved_type c, unresolved_type recyclerView, EpoxyViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)\n```
//                               documentation  @see #onChildDrawOver(Canvas, RecyclerView, ViewHolder, float, float, int, boolean)\n
//                               ^^^^^^ reference semanticdb maven . . Canvas#
//                                      ^ definition local 75
//                                        display_name c
//                                        documentation ```java\nunresolved_type c\n```
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                      ^^^^^^^^^^^^ definition local 76
//                                                                   display_name recyclerView
//                                                                   documentation ```java\nunresolved_type recyclerView\n```
//                                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                                    ^^^^^^^^^^ definition local 77
//                                                                                               display_name viewHolder
//                                                                                               documentation ```java\nEpoxyViewHolder viewHolder\n```
      float dX, float dY, int actionState, boolean isCurrentlyActive) {
//          ^^ definition local 78
//             display_name dX
//             documentation ```java\nfloat dX\n```
//                    ^^ definition local 79
//                       display_name dY
//                       documentation ```java\nfloat dY\n```
//                            ^^^^^^^^^^^ definition local 80
//                                        display_name actionState
//                                        documentation ```java\nint actionState\n```
//                                                 ^^^^^^^^^^^^^^^^^ definition local 81
//                                                                   display_name isCurrentlyActive
//                                                                   documentation ```java\nboolean isCurrentlyActive\n```

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
