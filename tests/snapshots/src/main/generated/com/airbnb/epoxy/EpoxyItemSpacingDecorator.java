package com.airbnb.epoxy;

import android.graphics.Rect;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^^^^^ reference semanticdb maven . . android/graphics/
//                      ^^^^ reference semanticdb maven . . android/graphics/Rect#
import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

import androidx.annotation.Px;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
import androidx.core.view.ViewCompat;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^ reference semanticdb maven . . androidx/core/
//                   ^^^^ reference semanticdb maven . . androidx/core/view/
//                        ^^^^^^^^^^ reference semanticdb maven . . androidx/core/view/ViewCompat#
import androidx.recyclerview.widget.GridLayoutManager;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/GridLayoutManager#
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/GridLayoutManager/
//                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/GridLayoutManager/SpanSizeLookup#
import androidx.recyclerview.widget.LinearLayoutManager;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/LinearLayoutManager#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView#
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/
//                                               ^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/LayoutManager#
import androidx.recyclerview.widget.RecyclerView.State;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/
//                                               ^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/State#

/**
 * Modifies item spacing in a recycler view so that items are equally spaced no matter where they
 * are on the grid. Only designed to work with standard linear or grid layout managers.
 */
public class EpoxyItemSpacingDecorator extends RecyclerView.ItemDecoration {
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#
//                                     documentation ```java\npublic class EpoxyItemSpacingDecorator\n```
//                                     documentation  Modifies item spacing in a recycler view so that items are equally spaced no matter where they\n are on the grid. Only designed to work with standard linear or grid layout managers.\n
//                                     relationship is_implementation semanticdb maven . . RecyclerView/ItemDecoration#
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/
//                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/ItemDecoration#
  private int pxBetweenItems;
//            ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#pxBetweenItems.
//                           documentation ```java\nprivate int pxBetweenItems\n```
  private boolean verticallyScrolling;
//                ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                    documentation ```java\nprivate boolean verticallyScrolling\n```
  private boolean horizontallyScrolling;
//                ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                      documentation ```java\nprivate boolean horizontallyScrolling\n```
  private boolean firstItem;
//                ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#firstItem.
//                          documentation ```java\nprivate boolean firstItem\n```
  private boolean lastItem;
//                ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#lastItem.
//                         documentation ```java\nprivate boolean lastItem\n```
  private boolean grid;
//                ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
//                     documentation ```java\nprivate boolean grid\n```

  private boolean isFirstItemInRow;
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isFirstItemInRow.
//                                 documentation ```java\nprivate boolean isFirstItemInRow\n```
  private boolean fillsLastSpan;
//                ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#fillsLastSpan.
//                              documentation ```java\nprivate boolean fillsLastSpan\n```
  private boolean isInFirstRow;
//                ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow.
//                             documentation ```java\nprivate boolean isInFirstRow\n```
  private boolean isInLastRow;
//                ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow.
//                            documentation ```java\nprivate boolean isInLastRow\n```

  public EpoxyItemSpacingDecorator() {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#`<init>`().
//                                 documentation ```java\npublic EpoxyItemSpacingDecorator()\n```
    this(0);
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#`<init>`(+1).
  }

  public EpoxyItemSpacingDecorator(@Px int pxBetweenItems) {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#`<init>`(+1).
//                                 documentation ```java\npublic EpoxyItemSpacingDecorator(int pxBetweenItems)\n```
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                         ^^^^^^^^^^^^^^ definition local 0
//                                                        documentation ```java\n@Px\nint pxBetweenItems\n```
    setPxBetweenItems(pxBetweenItems);
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#setPxBetweenItems().
//                    ^^^^^^^^^^^^^^ reference local 0
  }

  public void setPxBetweenItems(@Px int pxBetweenItems) {
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#setPxBetweenItems().
//                              documentation ```java\npublic void setPxBetweenItems(int pxBetweenItems)\n```
//                               ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                      ^^^^^^^^^^^^^^ definition local 1
//                                                     documentation ```java\n@Px\nint pxBetweenItems\n```
    this.pxBetweenItems = pxBetweenItems;
//       ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#pxBetweenItems.
//                        ^^^^^^^^^^^^^^ reference local 1
  }

  @Px
// ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
  public int getPxBetweenItems() {
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getPxBetweenItems().
//                             documentation ```java\n@Px\npublic int getPxBetweenItems()\n```
    return pxBetweenItems;
//         ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#pxBetweenItems.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
//            ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//                           documentation ```java\n@Override\npublic void getItemOffsets(unresolved_type outRect, unresolved_type view, unresolved_type parent, unresolved_type state)\n```
//                           ^^^^ reference semanticdb maven . . _root_/
//                                ^^^^^^^ definition local 2
//                                        documentation ```java\nunresolved_type outRect\n```
//                                         ^^^^ reference semanticdb maven . . _root_/
//                                              ^^^^ definition local 3
//                                                   documentation ```java\nunresolved_type view\n```
//                                                    ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                                 ^^^^^^ definition local 4
//                                                                        documentation ```java\nunresolved_type parent\n```
//                                                                         ^^^^^ reference semanticdb maven . . _root_/
//                                                                               ^^^^^ definition local 5
//                                                                                     documentation ```java\nunresolved_type state\n```
    // Zero everything out for the common case
    outRect.setEmpty();
//  ^^^^^^^ reference local 2
//          ^^^^^^^^ reference semanticdb maven . . setEmpty#

    int position = parent.getChildAdapterPosition(view);
//      ^^^^^^^^ definition local 6
//               documentation ```java\nint position\n```
//                 ^^^^^^ reference local 4
//                        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . getChildAdapterPosition#
//                                                ^^^^ reference local 3
    if (position == RecyclerView.NO_POSITION) {
//      ^^^^^^^^ reference local 6
//                  ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                               ^^^^^^^^^^^ reference semanticdb maven . . NO_POSITION#
      // View is not shown
      return;
    }

    RecyclerView.LayoutManager layout = parent.getLayoutManager();
//  ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/
//               ^^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/LayoutManager#
//                             ^^^^^^ definition local 7
//                                    documentation ```java\nunresolved_type layout\n```
//                                      ^^^^^^ reference local 4
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . getLayoutManager#
    calculatePositionDetails(parent, position, layout);
//  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                           ^^^^^^ reference local 4
//                                   ^^^^^^^^ reference local 6
//                                             ^^^^^^ reference local 7

    boolean left = useLeftPadding();
//          ^^^^ definition local 8
//               documentation ```java\nboolean left\n```
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#useLeftPadding().
    boolean right = useRightPadding();
//          ^^^^^ definition local 9
//                documentation ```java\nboolean right\n```
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#useRightPadding().
    boolean top = useTopPadding();
//          ^^^ definition local 10
//              documentation ```java\nboolean top\n```
//                ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#useTopPadding().
    boolean bottom = useBottomPadding();
//          ^^^^^^ definition local 11
//                 documentation ```java\nboolean bottom\n```
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#useBottomPadding().

    if (shouldReverseLayout(layout, horizontallyScrolling)) {
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#shouldReverseLayout().
//                          ^^^^^^ reference local 7
//                                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
      if (horizontallyScrolling) {
//        ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
        boolean temp = left;
//              ^^^^ definition local 12
//                   documentation ```java\nboolean temp\n```
//                     ^^^^ reference local 8
        left = right;
//      ^^^^ reference local 8
//             ^^^^^ reference local 9
        right = temp;
//      ^^^^^ reference local 9
//              ^^^^ reference local 12
      } else {
        boolean temp = top;
//              ^^^^ definition local 13
//                   documentation ```java\nboolean temp\n```
//                     ^^^ reference local 10
        top = bottom;
//      ^^^ reference local 10
//            ^^^^^^ reference local 11
        bottom = temp;
//      ^^^^^^ reference local 11
//               ^^^^ reference local 13
      }
    }

    // Divided by two because it is applied to the left side of one item and the right of another
    // to add up to the total desired space
    int padding = pxBetweenItems / 2;
//      ^^^^^^^ definition local 14
//              documentation ```java\nint padding\n```
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#pxBetweenItems.
    outRect.right = right ? padding : 0;
//  ^^^^^^^ reference local 2
//          ^^^^^ reference semanticdb maven . . right#
//                  ^^^^^ reference local 9
//                          ^^^^^^^ reference local 14
    outRect.left = left ? padding : 0;
//  ^^^^^^^ reference local 2
//          ^^^^ reference semanticdb maven . . left#
//                 ^^^^ reference local 8
//                        ^^^^^^^ reference local 14
    outRect.top = top ? padding : 0;
//  ^^^^^^^ reference local 2
//          ^^^ reference semanticdb maven . . top#
//                ^^^ reference local 10
//                      ^^^^^^^ reference local 14
    outRect.bottom = bottom ? padding : 0;
//  ^^^^^^^ reference local 2
//          ^^^^^^ reference semanticdb maven . . bottom#
//                   ^^^^^^ reference local 11
//                            ^^^^^^^ reference local 14
  }

  private void calculatePositionDetails(RecyclerView parent, int position, LayoutManager layout) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                                      documentation ```java\nprivate void calculatePositionDetails(unresolved_type parent, int position, unresolved_type layout)\n```
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                   ^^^^^^ definition local 15
//                                                          documentation ```java\nunresolved_type parent\n```
//                                                               ^^^^^^^^ definition local 16
//                                                                        documentation ```java\nint position\n```
//                                                                         ^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                                                       ^^^^^^ definition local 17
//                                                                                              documentation ```java\nunresolved_type layout\n```
    int itemCount = parent.getAdapter().getItemCount();
//      ^^^^^^^^^ definition local 18
//                documentation ```java\nint itemCount\n```
//                  ^^^^^^ reference local 15
//                         ^^^^^^^^^^ reference semanticdb maven . . getAdapter#
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . getAdapter#getItemCount#
    firstItem = position == 0;
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#firstItem.
//              ^^^^^^^^ reference local 16
    lastItem = position == itemCount - 1;
//  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#lastItem.
//             ^^^^^^^^ reference local 16
//                         ^^^^^^^^^ reference local 18
    horizontallyScrolling = layout.canScrollHorizontally();
//  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                          ^^^^^^ reference local 17
//                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . canScrollHorizontally#
    verticallyScrolling = layout.canScrollVertically();
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                        ^^^^^^ reference local 17
//                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . canScrollVertically#
    grid = layout instanceof GridLayoutManager;
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
//         ^^^^^^ reference local 17
//                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/

    if (grid) {
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
      GridLayoutManager grid = (GridLayoutManager) layout;
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                      ^^^^ definition local 19
//                           documentation ```java\nunresolved_type grid\n```
//                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                 ^^^^^^ reference local 17
      final SpanSizeLookup spanSizeLookup = grid.getSpanSizeLookup();
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                         ^^^^^^^^^^^^^^ definition local 20
//                                        documentation ```java\nfinal unresolved_type spanSizeLookup\n```
//                                          ^^^^ reference local 19
//                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . getSpanSizeLookup#
      int spanSize = spanSizeLookup.getSpanSize(position);
//        ^^^^^^^^ definition local 21
//                 documentation ```java\nint spanSize\n```
//                   ^^^^^^^^^^^^^^ reference local 20
//                                  ^^^^^^^^^^^ reference semanticdb maven . . getSpanSize#
//                                              ^^^^^^^^ reference local 16
      int spanCount = grid.getSpanCount();
//        ^^^^^^^^^ definition local 22
//                  documentation ```java\nint spanCount\n```
//                    ^^^^ reference local 19
//                         ^^^^^^^^^^^^ reference semanticdb maven . . getSpanCount#
      int spanIndex = spanSizeLookup.getSpanIndex(position, spanCount);
//        ^^^^^^^^^ definition local 23
//                  documentation ```java\nint spanIndex\n```
//                    ^^^^^^^^^^^^^^ reference local 20
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . getSpanIndex#
//                                                ^^^^^^^^ reference local 16
//                                                          ^^^^^^^^^ reference local 22
      isFirstItemInRow = spanIndex == 0;
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isFirstItemInRow.
//                       ^^^^^^^^^ reference local 23
      fillsLastSpan = spanIndex + spanSize == spanCount;
//    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#fillsLastSpan.
//                    ^^^^^^^^^ reference local 23
//                                ^^^^^^^^ reference local 21
//                                            ^^^^^^^^^ reference local 22
      isInFirstRow = isInFirstRow(position, spanSizeLookup, spanCount);
//    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow.
//                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow().
//                                ^^^^^^^^ reference local 16
//                                          ^^^^^^^^^^^^^^ reference local 20
//                                                          ^^^^^^^^^ reference local 22
      isInLastRow =
//    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow.
          !isInFirstRow && isInLastRow(position, itemCount, spanSizeLookup, spanCount);
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow.
//                         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow().
//                                     ^^^^^^^^ reference local 16
//                                               ^^^^^^^^^ reference local 18
//                                                          ^^^^^^^^^^^^^^ reference local 20
//                                                                          ^^^^^^^^^ reference local 22
    }
  }

  private static boolean shouldReverseLayout(LayoutManager layout, boolean horizontallyScrolling) {
//                       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#shouldReverseLayout().
//                                           documentation ```java\nprivate static boolean shouldReverseLayout(unresolved_type layout, boolean horizontallyScrolling)\n```
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                         ^^^^^^ definition local 24
//                                                                documentation ```java\nunresolved_type layout\n```
//                                                                         ^^^^^^^^^^^^^^^^^^^^^ definition local 25
//                                                                                               documentation ```java\nboolean horizontallyScrolling\n```
    boolean reverseLayout =
//          ^^^^^^^^^^^^^ definition local 26
//                        documentation ```java\nboolean reverseLayout\n```
        layout instanceof LinearLayoutManager && ((LinearLayoutManager) layout).getReverseLayout();
//      ^^^^^^ reference local 24
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                                      ^^^^^^ reference local 24
//                                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . getReverseLayout#
    boolean rtl = layout.getLayoutDirection() == ViewCompat.LAYOUT_DIRECTION_RTL;
//          ^^^ definition local 27
//              documentation ```java\nboolean rtl\n```
//                ^^^^^^ reference local 24
//                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . getLayoutDirection#
//                                               ^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . LAYOUT_DIRECTION_RTL#
    if (horizontallyScrolling && rtl) {
//      ^^^^^^^^^^^^^^^^^^^^^ reference local 25
//                               ^^^ reference local 27
      // This is how linearlayout checks if it should reverse layout in #resolveShouldLayoutReverse
      reverseLayout = !reverseLayout;
//    ^^^^^^^^^^^^^ reference local 26
//                     ^^^^^^^^^^^^^ reference local 26
    }

    return reverseLayout;
//         ^^^^^^^^^^^^^ reference local 26
  }

  private boolean useBottomPadding() {
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#useBottomPadding().
//                                 documentation ```java\nprivate boolean useBottomPadding()\n```
    if (grid) {
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
      return (horizontallyScrolling && !fillsLastSpan)
//            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#fillsLastSpan.
          || (verticallyScrolling && !isInLastRow);
//            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow.
    }

    return verticallyScrolling && !lastItem;
//         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#lastItem.
  }

  private boolean useTopPadding() {
//                ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#useTopPadding().
//                              documentation ```java\nprivate boolean useTopPadding()\n```
    if (grid) {
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
      return (horizontallyScrolling && !isFirstItemInRow)
//            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isFirstItemInRow.
          || (verticallyScrolling && !isInFirstRow);
//            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow.
    }

    return verticallyScrolling && !firstItem;
//         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                 ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#firstItem.
  }

  private boolean useRightPadding() {
//                ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#useRightPadding().
//                                documentation ```java\nprivate boolean useRightPadding()\n```
    if (grid) {
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
      return (horizontallyScrolling && !isInLastRow)
//            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow.
          || (verticallyScrolling && !fillsLastSpan);
//            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#fillsLastSpan.
    }

    return horizontallyScrolling && !lastItem;
//         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#lastItem.
  }

  private boolean useLeftPadding() {
//                ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#useLeftPadding().
//                               documentation ```java\nprivate boolean useLeftPadding()\n```
    if (grid) {
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
      return (horizontallyScrolling && !isInFirstRow)
//            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow.
          || (verticallyScrolling && !isFirstItemInRow);
//            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isFirstItemInRow.
    }

    return horizontallyScrolling && !firstItem;
//         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                   ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#firstItem.
  }

  private static boolean isInFirstRow(int position, SpanSizeLookup spanSizeLookup, int spanCount) {
//                       ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow().
//                                    documentation ```java\nprivate static boolean isInFirstRow(int position, unresolved_type spanSizeLookup, int spanCount)\n```
//                                        ^^^^^^^^ definition local 28
//                                                 documentation ```java\nint position\n```
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                                 ^^^^^^^^^^^^^^ definition local 29
//                                                                                documentation ```java\nunresolved_type spanSizeLookup\n```
//                                                                                     ^^^^^^^^^ definition local 30
//                                                                                               documentation ```java\nint spanCount\n```
    int totalSpan = 0;
//      ^^^^^^^^^ definition local 31
//                documentation ```java\nint totalSpan\n```
    for (int i = 0; i <= position; i++) {
//           ^ definition local 32
//             documentation ```java\nint i\n```
//                  ^ reference local 32
//                       ^^^^^^^^ reference local 28
//                                 ^ reference local 32
      totalSpan += spanSizeLookup.getSpanSize(i);
//    ^^^^^^^^^ reference local 31
//                 ^^^^^^^^^^^^^^ reference local 29
//                                ^^^^^^^^^^^ reference semanticdb maven . . getSpanSize#
//                                            ^ reference local 32
      if (totalSpan > spanCount) {
//        ^^^^^^^^^ reference local 31
//                    ^^^^^^^^^ reference local 30
        return false;
      }
    }

    return true;
  }

  private static boolean isInLastRow(int position, int itemCount, SpanSizeLookup spanSizeLookup,
//                       ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow().
//                                   documentation ```java\nprivate static boolean isInLastRow(int position, int itemCount, unresolved_type spanSizeLookup, int spanCount)\n```
//                                       ^^^^^^^^ definition local 33
//                                                documentation ```java\nint position\n```
//                                                     ^^^^^^^^^ definition local 34
//                                                               documentation ```java\nint itemCount\n```
//                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                                               ^^^^^^^^^^^^^^ definition local 35
//                                                                                              documentation ```java\nunresolved_type spanSizeLookup\n```
      int spanCount) {
//        ^^^^^^^^^ definition local 36
//                  documentation ```java\nint spanCount\n```
    int totalSpan = 0;
//      ^^^^^^^^^ definition local 37
//                documentation ```java\nint totalSpan\n```
    for (int i = itemCount - 1; i >= position; i--) {
//           ^ definition local 38
//             documentation ```java\nint i\n```
//               ^^^^^^^^^ reference local 34
//                              ^ reference local 38
//                                   ^^^^^^^^ reference local 33
//                                             ^ reference local 38
      totalSpan += spanSizeLookup.getSpanSize(i);
//    ^^^^^^^^^ reference local 37
//                 ^^^^^^^^^^^^^^ reference local 35
//                                ^^^^^^^^^^^ reference semanticdb maven . . getSpanSize#
//                                            ^ reference local 38
      if (totalSpan > spanCount) {
//        ^^^^^^^^^ reference local 37
//                    ^^^^^^^^^ reference local 36
        return false;
      }
    }

    return true;
  }
}
