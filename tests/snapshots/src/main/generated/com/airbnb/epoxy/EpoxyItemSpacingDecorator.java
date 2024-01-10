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
//                                     display_name EpoxyItemSpacingDecorator
//                                     signature_documentation java public class EpoxyItemSpacingDecorator
//                                     kind Class
//                                     documentation  Modifies item spacing in a recycler view so that items are equally spaced no matter where they\n are on the grid. Only designed to work with standard linear or grid layout managers.\n
//                                     relationship is_implementation semanticdb maven . . RecyclerView/ItemDecoration#
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/
//                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/ItemDecoration#
  private int pxBetweenItems;
//            ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#pxBetweenItems.
//                           display_name pxBetweenItems
//                           signature_documentation java private int pxBetweenItems
//                           kind Field
  private boolean verticallyScrolling;
//                ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                                    display_name verticallyScrolling
//                                    signature_documentation java private boolean verticallyScrolling
//                                    kind Field
  private boolean horizontallyScrolling;
//                ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
//                                      display_name horizontallyScrolling
//                                      signature_documentation java private boolean horizontallyScrolling
//                                      kind Field
  private boolean firstItem;
//                ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#firstItem.
//                          display_name firstItem
//                          signature_documentation java private boolean firstItem
//                          kind Field
  private boolean lastItem;
//                ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#lastItem.
//                         display_name lastItem
//                         signature_documentation java private boolean lastItem
//                         kind Field
  private boolean grid;
//                ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
//                     display_name grid
//                     signature_documentation java private boolean grid
//                     kind Field

  private boolean isFirstItemInRow;
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isFirstItemInRow.
//                                 display_name isFirstItemInRow
//                                 signature_documentation java private boolean isFirstItemInRow
//                                 kind Field
  private boolean fillsLastSpan;
//                ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#fillsLastSpan.
//                              display_name fillsLastSpan
//                              signature_documentation java private boolean fillsLastSpan
//                              kind Field
  private boolean isInFirstRow;
//                ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow.
//                             display_name isInFirstRow
//                             signature_documentation java private boolean isInFirstRow
//                             kind Field
  private boolean isInLastRow;
//                ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow.
//                            display_name isInLastRow
//                            signature_documentation java private boolean isInLastRow
//                            kind Field

  public EpoxyItemSpacingDecorator() {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#`<init>`().
//                                 display_name <init>
//                                 signature_documentation java public EpoxyItemSpacingDecorator()
//                                 kind Constructor
    this(0);
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#`<init>`(+1).
  }

  public EpoxyItemSpacingDecorator(@Px int pxBetweenItems) {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#`<init>`(+1).
//                                 display_name <init>
//                                 signature_documentation java public EpoxyItemSpacingDecorator(int pxBetweenItems)
//                                 kind Constructor
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                         ^^^^^^^^^^^^^^ definition local 0
//                                                        display_name pxBetweenItems
//                                                        signature_documentation java @Px\nint pxBetweenItems
//                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#`<init>`(+1).
    setPxBetweenItems(pxBetweenItems);
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#setPxBetweenItems().
//                    ^^^^^^^^^^^^^^ reference local 0
  }

  public void setPxBetweenItems(@Px int pxBetweenItems) {
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#setPxBetweenItems().
//                              display_name setPxBetweenItems
//                              signature_documentation java public void setPxBetweenItems(int pxBetweenItems)
//                              kind Method
//                               ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                      ^^^^^^^^^^^^^^ definition local 1
//                                                     display_name pxBetweenItems
//                                                     signature_documentation java @Px\nint pxBetweenItems
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#setPxBetweenItems().
    this.pxBetweenItems = pxBetweenItems;
//       ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#pxBetweenItems.
//                        ^^^^^^^^^^^^^^ reference local 1
  }

  @Px
// ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
  public int getPxBetweenItems() {
//           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getPxBetweenItems().
//                             display_name getPxBetweenItems
//                             signature_documentation java @Px\npublic int getPxBetweenItems()
//                             kind Method
    return pxBetweenItems;
//         ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#pxBetweenItems.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
//            ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//                           display_name getItemOffsets
//                           signature_documentation java @Override\npublic void getItemOffsets(unresolved_type outRect, unresolved_type view, unresolved_type parent, unresolved_type state)
//                           kind Method
//                           ^^^^ reference semanticdb maven . . Rect#
//                                ^^^^^^^ definition local 2
//                                        display_name outRect
//                                        signature_documentation java unresolved_type outRect
//                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//                                         ^^^^ reference semanticdb maven . . View#
//                                              ^^^^ definition local 3
//                                                   display_name view
//                                                   signature_documentation java unresolved_type view
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//                                                    ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                                 ^^^^^^ definition local 4
//                                                                        display_name parent
//                                                                        signature_documentation java unresolved_type parent
//                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//                                                                         ^^^^^ reference semanticdb maven . . State#
//                                                                               ^^^^^ definition local 5
//                                                                                     display_name state
//                                                                                     signature_documentation java unresolved_type state
//                                                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
    // Zero everything out for the common case
    outRect.setEmpty();
//  ^^^^^^^ reference local 2
//          ^^^^^^^^ reference semanticdb maven . . Rect#setEmpty#

    int position = parent.getChildAdapterPosition(view);
//      ^^^^^^^^ definition local 6
//               display_name position
//               signature_documentation java int position
//               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//               kind Variable
//                 ^^^^^^ reference local 4
//                        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#getChildAdapterPosition#
//                                                ^^^^ reference local 3
    if (position == RecyclerView.NO_POSITION) {
//      ^^^^^^^^ reference local 6
//                  ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                               ^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#NO_POSITION#
      // View is not shown
      return;
    }

    RecyclerView.LayoutManager layout = parent.getLayoutManager();
//  ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/
//               ^^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/LayoutManager#
//                             ^^^^^^ definition local 7
//                                    display_name layout
//                                    signature_documentation java unresolved_type layout
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//                                    kind Variable
//                                      ^^^^^^ reference local 4
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#getLayoutManager#
    calculatePositionDetails(parent, position, layout);
//  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                           ^^^^^^ reference local 4
//                                   ^^^^^^^^ reference local 6
//                                             ^^^^^^ reference local 7

    boolean left = useLeftPadding();
//          ^^^^ definition local 8
//               display_name left
//               signature_documentation java boolean left
//               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//               kind Variable
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#useLeftPadding().
    boolean right = useRightPadding();
//          ^^^^^ definition local 9
//                display_name right
//                signature_documentation java boolean right
//                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//                kind Variable
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#useRightPadding().
    boolean top = useTopPadding();
//          ^^^ definition local 10
//              display_name top
//              signature_documentation java boolean top
//              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//              kind Variable
//                ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#useTopPadding().
    boolean bottom = useBottomPadding();
//          ^^^^^^ definition local 11
//                 display_name bottom
//                 signature_documentation java boolean bottom
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//                 kind Variable
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#useBottomPadding().

    if (shouldReverseLayout(layout, horizontallyScrolling)) {
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#shouldReverseLayout().
//                          ^^^^^^ reference local 7
//                                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
      if (horizontallyScrolling) {
//        ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#horizontallyScrolling.
        boolean temp = left;
//              ^^^^ definition local 12
//                   display_name temp
//                   signature_documentation java boolean temp
//                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//                   kind Variable
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
//                   display_name temp
//                   signature_documentation java boolean temp
//                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//                   kind Variable
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
//              display_name padding
//              signature_documentation java int padding
//              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#getItemOffsets().
//              kind Variable
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#pxBetweenItems.
    outRect.right = right ? padding : 0;
//  ^^^^^^^ reference local 2
//          ^^^^^ reference semanticdb maven . . Rect#right#
//                  ^^^^^ reference local 9
//                          ^^^^^^^ reference local 14
    outRect.left = left ? padding : 0;
//  ^^^^^^^ reference local 2
//          ^^^^ reference semanticdb maven . . Rect#left#
//                 ^^^^ reference local 8
//                        ^^^^^^^ reference local 14
    outRect.top = top ? padding : 0;
//  ^^^^^^^ reference local 2
//          ^^^ reference semanticdb maven . . Rect#top#
//                ^^^ reference local 10
//                      ^^^^^^^ reference local 14
    outRect.bottom = bottom ? padding : 0;
//  ^^^^^^^ reference local 2
//          ^^^^^^ reference semanticdb maven . . Rect#bottom#
//                   ^^^^^^ reference local 11
//                            ^^^^^^^ reference local 14
  }

  private void calculatePositionDetails(RecyclerView parent, int position, LayoutManager layout) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                                      display_name calculatePositionDetails
//                                      signature_documentation java private void calculatePositionDetails(unresolved_type parent, int position, unresolved_type layout)
//                                      kind Method
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                   ^^^^^^ definition local 15
//                                                          display_name parent
//                                                          signature_documentation java unresolved_type parent
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                                                               ^^^^^^^^ definition local 16
//                                                                        display_name position
//                                                                        signature_documentation java int position
//                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                                                                         ^^^^^^^^^^^^^ reference semanticdb maven . . LayoutManager#
//                                                                                       ^^^^^^ definition local 17
//                                                                                              display_name layout
//                                                                                              signature_documentation java unresolved_type layout
//                                                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
    int itemCount = parent.getAdapter().getItemCount();
//      ^^^^^^^^^ definition local 18
//                display_name itemCount
//                signature_documentation java int itemCount
//                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                kind Variable
//                  ^^^^^^ reference local 15
//                         ^^^^^^^^^^ reference semanticdb maven . . RecyclerView#getAdapter#
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#getAdapter#getItemCount#
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
//                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . LayoutManager#canScrollHorizontally#
    verticallyScrolling = layout.canScrollVertically();
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#verticallyScrolling.
//                        ^^^^^^ reference local 17
//                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . LayoutManager#canScrollVertically#
    grid = layout instanceof GridLayoutManager;
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
//         ^^^^^^ reference local 17
//                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . GridLayoutManager#

    if (grid) {
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#grid.
      GridLayoutManager grid = (GridLayoutManager) layout;
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . GridLayoutManager#
//                      ^^^^ definition local 19
//                           display_name grid
//                           signature_documentation java unresolved_type grid
//                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                           kind Variable
//                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . GridLayoutManager#
//                                                 ^^^^^^ reference local 17
      final SpanSizeLookup spanSizeLookup = grid.getSpanSizeLookup();
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . SpanSizeLookup#
//                         ^^^^^^^^^^^^^^ definition local 20
//                                        display_name spanSizeLookup
//                                        signature_documentation java final unresolved_type spanSizeLookup
//                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                                        kind Variable
//                                          ^^^^ reference local 19
//                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . GridLayoutManager#getSpanSizeLookup#
      int spanSize = spanSizeLookup.getSpanSize(position);
//        ^^^^^^^^ definition local 21
//                 display_name spanSize
//                 signature_documentation java int spanSize
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                 kind Variable
//                   ^^^^^^^^^^^^^^ reference local 20
//                                  ^^^^^^^^^^^ reference semanticdb maven . . SpanSizeLookup#getSpanSize#
//                                              ^^^^^^^^ reference local 16
      int spanCount = grid.getSpanCount();
//        ^^^^^^^^^ definition local 22
//                  display_name spanCount
//                  signature_documentation java int spanCount
//                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                  kind Variable
//                    ^^^^ reference local 19
//                         ^^^^^^^^^^^^ reference semanticdb maven . . GridLayoutManager#getSpanCount#
      int spanIndex = spanSizeLookup.getSpanIndex(position, spanCount);
//        ^^^^^^^^^ definition local 23
//                  display_name spanIndex
//                  signature_documentation java int spanIndex
//                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#calculatePositionDetails().
//                  kind Variable
//                    ^^^^^^^^^^^^^^ reference local 20
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . SpanSizeLookup#getSpanIndex#
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
//                                           display_name shouldReverseLayout
//                                           signature_documentation java private static boolean shouldReverseLayout(unresolved_type layout, boolean horizontallyScrolling)
//                                           kind StaticMethod
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . LayoutManager#
//                                                         ^^^^^^ definition local 24
//                                                                display_name layout
//                                                                signature_documentation java unresolved_type layout
//                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#shouldReverseLayout().
//                                                                         ^^^^^^^^^^^^^^^^^^^^^ definition local 25
//                                                                                               display_name horizontallyScrolling
//                                                                                               signature_documentation java boolean horizontallyScrolling
//                                                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#shouldReverseLayout().
    boolean reverseLayout =
//          ^^^^^^^^^^^^^ definition local 26
//                        display_name reverseLayout
//                        signature_documentation java boolean reverseLayout
//                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#shouldReverseLayout().
//                        kind Variable
        layout instanceof LinearLayoutManager && ((LinearLayoutManager) layout).getReverseLayout();
//      ^^^^^^ reference local 24
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . LinearLayoutManager#
//                                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . LinearLayoutManager#
//                                                                      ^^^^^^ reference local 24
//                                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . LinearLayoutManager#getReverseLayout#
    boolean rtl = layout.getLayoutDirection() == ViewCompat.LAYOUT_DIRECTION_RTL;
//          ^^^ definition local 27
//              display_name rtl
//              signature_documentation java boolean rtl
//              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#shouldReverseLayout().
//              kind Variable
//                ^^^^^^ reference local 24
//                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . LayoutManager#getLayoutDirection#
//                                               ^^^^^^^^^^ reference semanticdb maven . . ViewCompat#
//                                                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . ViewCompat#LAYOUT_DIRECTION_RTL#
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
//                                 display_name useBottomPadding
//                                 signature_documentation java private boolean useBottomPadding()
//                                 kind Method
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
//                              display_name useTopPadding
//                              signature_documentation java private boolean useTopPadding()
//                              kind Method
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
//                                display_name useRightPadding
//                                signature_documentation java private boolean useRightPadding()
//                                kind Method
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
//                               display_name useLeftPadding
//                               signature_documentation java private boolean useLeftPadding()
//                               kind Method
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
//                                    display_name isInFirstRow
//                                    signature_documentation java private static boolean isInFirstRow(int position, unresolved_type spanSizeLookup, int spanCount)
//                                    kind StaticMethod
//                                        ^^^^^^^^ definition local 28
//                                                 display_name position
//                                                 signature_documentation java int position
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow().
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . SpanSizeLookup#
//                                                                 ^^^^^^^^^^^^^^ definition local 29
//                                                                                display_name spanSizeLookup
//                                                                                signature_documentation java unresolved_type spanSizeLookup
//                                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow().
//                                                                                     ^^^^^^^^^ definition local 30
//                                                                                               display_name spanCount
//                                                                                               signature_documentation java int spanCount
//                                                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow().
    int totalSpan = 0;
//      ^^^^^^^^^ definition local 31
//                display_name totalSpan
//                signature_documentation java int totalSpan
//                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow().
//                kind Variable
    for (int i = 0; i <= position; i++) {
//           ^ definition local 32
//             display_name i
//             signature_documentation java int i
//             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInFirstRow().
//             kind Variable
//                  ^ reference local 32
//                       ^^^^^^^^ reference local 28
//                                 ^ reference local 32
      totalSpan += spanSizeLookup.getSpanSize(i);
//    ^^^^^^^^^ reference local 31
//                 ^^^^^^^^^^^^^^ reference local 29
//                                ^^^^^^^^^^^ reference semanticdb maven . . SpanSizeLookup#getSpanSize#
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
//                                   display_name isInLastRow
//                                   signature_documentation java private static boolean isInLastRow(int position, int itemCount, unresolved_type spanSizeLookup, int spanCount)
//                                   kind StaticMethod
//                                       ^^^^^^^^ definition local 33
//                                                display_name position
//                                                signature_documentation java int position
//                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow().
//                                                     ^^^^^^^^^ definition local 34
//                                                               display_name itemCount
//                                                               signature_documentation java int itemCount
//                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow().
//                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . SpanSizeLookup#
//                                                                               ^^^^^^^^^^^^^^ definition local 35
//                                                                                              display_name spanSizeLookup
//                                                                                              signature_documentation java unresolved_type spanSizeLookup
//                                                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow().
      int spanCount) {
//        ^^^^^^^^^ definition local 36
//                  display_name spanCount
//                  signature_documentation java int spanCount
//                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow().
    int totalSpan = 0;
//      ^^^^^^^^^ definition local 37
//                display_name totalSpan
//                signature_documentation java int totalSpan
//                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow().
//                kind Variable
    for (int i = itemCount - 1; i >= position; i--) {
//           ^ definition local 38
//             display_name i
//             signature_documentation java int i
//             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyItemSpacingDecorator#isInLastRow().
//             kind Variable
//               ^^^^^^^^^ reference local 34
//                              ^ reference local 38
//                                   ^^^^^^^^ reference local 33
//                                             ^ reference local 38
      totalSpan += spanSizeLookup.getSpanSize(i);
//    ^^^^^^^^^ reference local 37
//                 ^^^^^^^^^^^^^^ reference local 35
//                                ^^^^^^^^^^^ reference semanticdb maven . . SpanSizeLookup#getSpanSize#
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
