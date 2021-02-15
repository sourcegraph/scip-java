
package com.airbnb.epoxy;

import android.widget.Space;
//     ^^^^^^^ reference android/
//             ^^^^^^ reference android/widget/
//                    ^^^^^ reference android/widget/Space#

import com.airbnb.viewmodeladapter.R;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^^^^^^^^^^^^ reference com/airbnb/viewmodeladapter/
//                                 ^ reference com/airbnb/viewmodeladapter/R#

/**
 * Used by the {@link EpoxyAdapter} as a placeholder for when {@link EpoxyModel#isShown()} is false.
 * Using a zero height and width {@link Space} view, as well as 0 span size, to exclude itself from
 * view.
 */
class HiddenEpoxyModel extends EpoxyModel<Space> {
^^^^^^ definition com/airbnb/epoxy/HiddenEpoxyModel#`<init>`().
^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HiddenEpoxyModel#
//                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                        ^^^^^ reference _root_/
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public int getDefaultLayout() {
//           ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HiddenEpoxyModel#getDefaultLayout().
    return R.layout.view_holder_empty_view;
//         ^ reference R/
//           ^^^^^^ reference R/layout#
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference R/layout#view_holder_empty_view#
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public int getSpanSize(int spanCount, int position, int itemCount) {
//           ^^^^^^^^^^^ definition com/airbnb/epoxy/HiddenEpoxyModel#getSpanSize().
//                           ^^^^^^^^^ definition local0
//                                          ^^^^^^^^ definition local1
//                                                        ^^^^^^^^^ definition local2
    return 0;
  }
}
