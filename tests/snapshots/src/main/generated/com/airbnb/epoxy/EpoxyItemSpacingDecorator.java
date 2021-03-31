package com.airbnb.epoxy;

import android.graphics.Rect;
//     ^^^^^^^ reference android/
//             ^^^^^^^^ reference android/graphics/
//                      ^^^^ reference android/graphics/Rect#
import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#

import androidx.annotation.Px;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^ reference androidx/annotation/Px#
import androidx.core.view.ViewCompat;
//     ^^^^^^^^ reference androidx/
//              ^^^^ reference androidx/core/
//                   ^^^^ reference androidx/core/view/
//                        ^^^^^^^^^^ reference androidx/core/view/ViewCompat#
import androidx.recyclerview.widget.GridLayoutManager;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/GridLayoutManager#
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/GridLayoutManager/
//                                                    ^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/GridLayoutManager/SpanSizeLookup#
import androidx.recyclerview.widget.LinearLayoutManager;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/LinearLayoutManager#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView#
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView/
//                                               ^^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView/LayoutManager#
import androidx.recyclerview.widget.RecyclerView.State;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView/
//                                               ^^^^^ reference androidx/recyclerview/widget/RecyclerView/State#

/**
 * Modifies item spacing in a recycler view so that items are equally spaced no matter where they
 * are on the grid. Only designed to work with standard linear or grid layout managers.
 */
public class EpoxyItemSpacingDecorator extends RecyclerView.ItemDecoration {
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator# public class EpoxyItemSpacingDecorator extends unresolved_type
//                                             ^^^^^^^^^^^^ reference RecyclerView/
//                                                          ^^^^^^^^^^^^^^ reference RecyclerView/ItemDecoration#
  private int pxBetweenItems;
//            ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#pxBetweenItems. private int pxBetweenItems
  private boolean verticallyScrolling;
//                ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling. private boolean verticallyScrolling
  private boolean horizontallyScrolling;
//                ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling. private boolean horizontallyScrolling
  private boolean firstItem;
//                ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#firstItem. private boolean firstItem
  private boolean lastItem;
//                ^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#lastItem. private boolean lastItem
  private boolean grid;
//                ^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid. private boolean grid

  private boolean isFirstItemInRow;
//                ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#isFirstItemInRow. private boolean isFirstItemInRow
  private boolean fillsLastSpan;
//                ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#fillsLastSpan. private boolean fillsLastSpan
  private boolean isInFirstRow;
//                ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow. private boolean isInFirstRow
  private boolean isInLastRow;
//                ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow. private boolean isInLastRow

  public EpoxyItemSpacingDecorator() {
//       ^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#`<init>`(). public EpoxyItemSpacingDecorator()
    this(0);
//  ^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#`<init>`(+1).
  }

  public EpoxyItemSpacingDecorator(@Px int pxBetweenItems) {
//       ^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#`<init>`(+1). public EpoxyItemSpacingDecorator(int pxBetweenItems)
//                                  ^^ reference androidx/annotation/Px#
//                                         ^^^^^^^^^^^^^^ definition local0 int pxBetweenItems
    setPxBetweenItems(pxBetweenItems);
//  ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#setPxBetweenItems().
//                    ^^^^^^^^^^^^^^ reference local0
  }

  public void setPxBetweenItems(@Px int pxBetweenItems) {
//            ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#setPxBetweenItems(). public void setPxBetweenItems(int pxBetweenItems)
//                               ^^ reference androidx/annotation/Px#
//                                      ^^^^^^^^^^^^^^ definition local1 int pxBetweenItems
    this.pxBetweenItems = pxBetweenItems;
//  ^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#
//       ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#pxBetweenItems.
//                        ^^^^^^^^^^^^^^ reference local1
  }

  @Px
// ^^ reference androidx/annotation/Px#
  public int getPxBetweenItems() {
//           ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#getPxBetweenItems(). public int getPxBetweenItems()
    return pxBetweenItems;
//         ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#pxBetweenItems.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
//            ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets(). public void getItemOffsets(unresolved_type outRect, unresolved_type view, unresolved_type parent, unresolved_type state)
//                           ^^^^ reference _root_/
//                                ^^^^^^^ definition local2 unresolved_type outRect
//                                         ^^^^ reference _root_/
//                                              ^^^^ definition local3 unresolved_type view
//                                                    ^^^^^^^^^^^^ reference _root_/
//                                                                 ^^^^^^ definition local4 unresolved_type parent
//                                                                         ^^^^^ reference _root_/
//                                                                               ^^^^^ definition local5 unresolved_type state
    // Zero everything out for the common case
    outRect.setEmpty();
//  ^^^^^^^ reference local2
//          ^^^^^^^^ reference setEmpty#

    int position = parent.getChildAdapterPosition(view);
//      ^^^^^^^^ definition local6 int position
//                 ^^^^^^ reference local4
//                        ^^^^^^^^^^^^^^^^^^^^^^^ reference getChildAdapterPosition#
//                                                ^^^^ reference local3
    if (position == RecyclerView.NO_POSITION) {
//      ^^^^^^^^ reference local6
//                  ^^^^^^^^^^^^ reference _root_/
//                               ^^^^^^^^^^^ reference NO_POSITION#
      // View is not shown
      return;
    }

    RecyclerView.LayoutManager layout = parent.getLayoutManager();
//  ^^^^^^^^^^^^ reference RecyclerView/
//               ^^^^^^^^^^^^^ reference RecyclerView/LayoutManager#
//                             ^^^^^^ definition local7 unresolved_type layout
//                                      ^^^^^^ reference local4
//                                             ^^^^^^^^^^^^^^^^ reference getLayoutManager#
    calculatePositionDetails(parent, position, layout);
//  ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                           ^^^^^^ reference local4
//                                   ^^^^^^^^ reference local6
//                                             ^^^^^^ reference local7

    boolean left = useLeftPadding();
//          ^^^^ definition local8 boolean left
//                 ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#useLeftPadding().
    boolean right = useRightPadding();
//          ^^^^^ definition local9 boolean right
//                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#useRightPadding().
    boolean top = useTopPadding();
//          ^^^ definition local10 boolean top
//                ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#useTopPadding().
    boolean bottom = useBottomPadding();
//          ^^^^^^ definition local11 boolean bottom
//                   ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#useBottomPadding().

    if (shouldReverseLayout(layout, horizontallyScrolling)) {
//      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#shouldReverseLayout().
//                          ^^^^^^ reference local7
//                                  ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
      if (horizontallyScrolling) {
//        ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
        boolean temp = left;
//              ^^^^ definition local12 boolean temp
//                     ^^^^ reference local8
        left = right;
//      ^^^^ reference local8
//             ^^^^^ reference local9
        right = temp;
//      ^^^^^ reference local9
//              ^^^^ reference local12
      } else {
        boolean temp = top;
//              ^^^^ definition local13 boolean temp
//                     ^^^ reference local10
        top = bottom;
//      ^^^ reference local10
//            ^^^^^^ reference local11
        bottom = temp;
//      ^^^^^^ reference local11
//               ^^^^ reference local13
      }
    }

    // Divided by two because it is applied to the left side of one item and the right of another
    // to add up to the total desired space
    int padding = pxBetweenItems / 2;
//      ^^^^^^^ definition local14 int padding
//                ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#pxBetweenItems.
    outRect.right = right ? padding : 0;
//  ^^^^^^^ reference local2
//          ^^^^^ reference right#
//                  ^^^^^ reference local9
//                          ^^^^^^^ reference local14
    outRect.left = left ? padding : 0;
//  ^^^^^^^ reference local2
//          ^^^^ reference left#
//                 ^^^^ reference local8
//                        ^^^^^^^ reference local14
    outRect.top = top ? padding : 0;
//  ^^^^^^^ reference local2
//          ^^^ reference top#
//                ^^^ reference local10
//                      ^^^^^^^ reference local14
    outRect.bottom = bottom ? padding : 0;
//  ^^^^^^^ reference local2
//          ^^^^^^ reference bottom#
//                   ^^^^^^ reference local11
//                            ^^^^^^^ reference local14
  }

  private void calculatePositionDetails(RecyclerView parent, int position, LayoutManager layout) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails(). private void calculatePositionDetails(unresolved_type parent, int position, unresolved_type layout)
//                                      ^^^^^^^^^^^^ reference _root_/
//                                                   ^^^^^^ definition local15 unresolved_type parent
//                                                               ^^^^^^^^ definition local16 int position
//                                                                         ^^^^^^^^^^^^^ reference _root_/
//                                                                                       ^^^^^^ definition local17 unresolved_type layout
    int itemCount = parent.getAdapter().getItemCount();
//      ^^^^^^^^^ definition local18 int itemCount
//                  ^^^^^^ reference local15
//                         ^^^^^^^^^^ reference getAdapter#
//                                      ^^^^^^^^^^^^ reference getAdapter#getItemCount#
    firstItem = position == 0;
//  ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#firstItem.
//              ^^^^^^^^ reference local16
    lastItem = position == itemCount - 1;
//  ^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#lastItem.
//             ^^^^^^^^ reference local16
//                         ^^^^^^^^^ reference local18
    horizontallyScrolling = layout.canScrollHorizontally();
//  ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                          ^^^^^^ reference local17
//                                 ^^^^^^^^^^^^^^^^^^^^^ reference canScrollHorizontally#
    verticallyScrolling = layout.canScrollVertically();
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                        ^^^^^^ reference local17
//                               ^^^^^^^^^^^^^^^^^^^ reference canScrollVertically#
    grid = layout instanceof GridLayoutManager;
//  ^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
//         ^^^^^^ reference local17
//                           ^^^^^^^^^^^^^^^^^ reference _root_/

    if (grid) {
//      ^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
      GridLayoutManager grid = (GridLayoutManager) layout;
//    ^^^^^^^^^^^^^^^^^ reference _root_/
//                      ^^^^ definition local19 unresolved_type grid
//                              ^^^^^^^^^^^^^^^^^ reference _root_/
//                                                 ^^^^^^ reference local17
      final SpanSizeLookup spanSizeLookup = grid.getSpanSizeLookup();
//          ^^^^^^^^^^^^^^ reference _root_/
//                         ^^^^^^^^^^^^^^ definition local20 final unresolved_type spanSizeLookup
//                                          ^^^^ reference local19
//                                               ^^^^^^^^^^^^^^^^^ reference getSpanSizeLookup#
      int spanSize = spanSizeLookup.getSpanSize(position);
//        ^^^^^^^^ definition local21 int spanSize
//                   ^^^^^^^^^^^^^^ reference local20
//                                  ^^^^^^^^^^^ reference getSpanSize#
//                                              ^^^^^^^^ reference local16
      int spanCount = grid.getSpanCount();
//        ^^^^^^^^^ definition local22 int spanCount
//                    ^^^^ reference local19
//                         ^^^^^^^^^^^^ reference getSpanCount#
      int spanIndex = spanSizeLookup.getSpanIndex(position, spanCount);
//        ^^^^^^^^^ definition local23 int spanIndex
//                    ^^^^^^^^^^^^^^ reference local20
//                                   ^^^^^^^^^^^^ reference getSpanIndex#
//                                                ^^^^^^^^ reference local16
//                                                          ^^^^^^^^^ reference local22
      isFirstItemInRow = spanIndex == 0;
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#isFirstItemInRow.
//                       ^^^^^^^^^ reference local23
      fillsLastSpan = spanIndex + spanSize == spanCount;
//    ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#fillsLastSpan.
//                    ^^^^^^^^^ reference local23
//                                ^^^^^^^^ reference local21
//                                            ^^^^^^^^^ reference local22
      isInFirstRow = isInFirstRow(position, spanSizeLookup, spanCount);
//    ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow.
//                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow().
//                                ^^^^^^^^ reference local16
//                                          ^^^^^^^^^^^^^^ reference local20
//                                                          ^^^^^^^^^ reference local22
      isInLastRow =
//    ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow.
          !isInFirstRow && isInLastRow(position, itemCount, spanSizeLookup, spanCount);
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow.
//                         ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow().
//                                     ^^^^^^^^ reference local16
//                                               ^^^^^^^^^ reference local18
//                                                          ^^^^^^^^^^^^^^ reference local20
//                                                                          ^^^^^^^^^ reference local22
    }
  }

  private static boolean shouldReverseLayout(LayoutManager layout, boolean horizontallyScrolling) {
//                       ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#shouldReverseLayout(). private static boolean shouldReverseLayout(unresolved_type layout, boolean horizontallyScrolling)
//                                           ^^^^^^^^^^^^^ reference _root_/
//                                                         ^^^^^^ definition local24 unresolved_type layout
//                                                                         ^^^^^^^^^^^^^^^^^^^^^ definition local25 boolean horizontallyScrolling
    boolean reverseLayout =
//          ^^^^^^^^^^^^^ definition local26 boolean reverseLayout
        layout instanceof LinearLayoutManager && ((LinearLayoutManager) layout).getReverseLayout();
//      ^^^^^^ reference local24
//                        ^^^^^^^^^^^^^^^^^^^ reference _root_/
//                                                 ^^^^^^^^^^^^^^^^^^^ reference _root_/
//                                                                      ^^^^^^ reference local24
//                                                                              ^^^^^^^^^^^^^^^^ reference getReverseLayout#
    boolean rtl = layout.getLayoutDirection() == ViewCompat.LAYOUT_DIRECTION_RTL;
//          ^^^ definition local27 boolean rtl
//                ^^^^^^ reference local24
//                       ^^^^^^^^^^^^^^^^^^ reference getLayoutDirection#
//                                               ^^^^^^^^^^ reference _root_/
//                                                          ^^^^^^^^^^^^^^^^^^^^ reference LAYOUT_DIRECTION_RTL#
    if (horizontallyScrolling && rtl) {
//      ^^^^^^^^^^^^^^^^^^^^^ reference local25
//                               ^^^ reference local27
      // This is how linearlayout checks if it should reverse layout in #resolveShouldLayoutReverse
      reverseLayout = !reverseLayout;
//    ^^^^^^^^^^^^^ reference local26
//                     ^^^^^^^^^^^^^ reference local26
    }

    return reverseLayout;
//         ^^^^^^^^^^^^^ reference local26
  }

  private boolean useBottomPadding() {
//                ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#useBottomPadding(). private boolean useBottomPadding()
    if (grid) {
//      ^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
      return (horizontallyScrolling && !fillsLastSpan)
//            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#fillsLastSpan.
          || (verticallyScrolling && !isInLastRow);
//            ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                    ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow.
    }

    return verticallyScrolling && !lastItem;
//         ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                 ^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#lastItem.
  }

  private boolean useTopPadding() {
//                ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#useTopPadding(). private boolean useTopPadding()
    if (grid) {
//      ^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
      return (horizontallyScrolling && !isFirstItemInRow)
//            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#isFirstItemInRow.
          || (verticallyScrolling && !isInFirstRow);
//            ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                    ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow.
    }

    return verticallyScrolling && !firstItem;
//         ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                 ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#firstItem.
  }

  private boolean useRightPadding() {
//                ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#useRightPadding(). private boolean useRightPadding()
    if (grid) {
//      ^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
      return (horizontallyScrolling && !isInLastRow)
//            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                      ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow.
          || (verticallyScrolling && !fillsLastSpan);
//            ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                    ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#fillsLastSpan.
    }

    return horizontallyScrolling && !lastItem;
//         ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                   ^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#lastItem.
  }

  private boolean useLeftPadding() {
//                ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#useLeftPadding(). private boolean useLeftPadding()
    if (grid) {
//      ^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
      return (horizontallyScrolling && !isInFirstRow)
//            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow.
          || (verticallyScrolling && !isFirstItemInRow);
//            ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#isFirstItemInRow.
    }

    return horizontallyScrolling && !firstItem;
//         ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                   ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyItemSpacingDecorator#firstItem.
  }

  private static boolean isInFirstRow(int position, SpanSizeLookup spanSizeLookup, int spanCount) {
//                       ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow(). private static boolean isInFirstRow(int position, unresolved_type spanSizeLookup, int spanCount)
//                                        ^^^^^^^^ definition local28 int position
//                                                  ^^^^^^^^^^^^^^ reference _root_/
//                                                                 ^^^^^^^^^^^^^^ definition local29 unresolved_type spanSizeLookup
//                                                                                     ^^^^^^^^^ definition local30 int spanCount
    int totalSpan = 0;
//      ^^^^^^^^^ definition local31 int totalSpan
    for (int i = 0; i <= position; i++) {
//           ^ definition local32 int i
//                  ^ reference local32
//                       ^^^^^^^^ reference local28
//                                 ^ reference local32
      totalSpan += spanSizeLookup.getSpanSize(i);
//    ^^^^^^^^^ reference local31
//                 ^^^^^^^^^^^^^^ reference local29
//                                ^^^^^^^^^^^ reference getSpanSize#
//                                            ^ reference local32
      if (totalSpan > spanCount) {
//        ^^^^^^^^^ reference local31
//                    ^^^^^^^^^ reference local30
        return false;
      }
    }

    return true;
  }

  private static boolean isInLastRow(int position, int itemCount, SpanSizeLookup spanSizeLookup,
//                       ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow(). private static boolean isInLastRow(int position, int itemCount, unresolved_type spanSizeLookup, int spanCount)
//                                       ^^^^^^^^ definition local33 int position
//                                                     ^^^^^^^^^ definition local34 int itemCount
//                                                                ^^^^^^^^^^^^^^ reference _root_/
//                                                                               ^^^^^^^^^^^^^^ definition local35 unresolved_type spanSizeLookup
      int spanCount) {
//        ^^^^^^^^^ definition local36 int spanCount
    int totalSpan = 0;
//      ^^^^^^^^^ definition local37 int totalSpan
    for (int i = itemCount - 1; i >= position; i--) {
//           ^ definition local38 int i
//               ^^^^^^^^^ reference local34
//                              ^ reference local38
//                                   ^^^^^^^^ reference local33
//                                             ^ reference local38
      totalSpan += spanSizeLookup.getSpanSize(i);
//    ^^^^^^^^^ reference local37
//                 ^^^^^^^^^^^^^^ reference local35
//                                ^^^^^^^^^^^ reference getSpanSize#
//                                            ^ reference local38
      if (totalSpan > spanCount) {
//        ^^^^^^^^^ reference local37
//                    ^^^^^^^^^ reference local36
        return false;
      }
    }

    return true;
  }
}
