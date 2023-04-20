
package com.airbnb.epoxy;

import android.widget.Space;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^^^ reference semanticdb maven . . android/widget/
//                    ^^^^^ reference semanticdb maven . . android/widget/Space#

import com.airbnb.viewmodeladapter.R;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/viewmodeladapter/
//                                 ^ reference semanticdb maven . . com/airbnb/viewmodeladapter/R#

/**
 * Used by the {@link EpoxyAdapter} as a placeholder for when {@link EpoxyModel#isShown()} is false.
 * Using a zero height and width {@link Space} view, as well as 0 span size, to exclude itself from
 * view.
 */
class HiddenEpoxyModel extends EpoxyModel<Space> {
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#
//                     documentation ```java\nclass HiddenEpoxyModel\n```
//                     documentation  Used by the {@link EpoxyAdapter} as a placeholder for when {@link EpoxyModel#isShown()} is false.\n Using a zero height and width {@link Space} view, as well as 0 span size, to exclude itself from\n view.\n
//                     relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#`<init>`().
//                     documentation ```java\nHiddenEpoxyModel()\n```
//                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                        ^^^^^ reference semanticdb maven . . _root_/
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getDefaultLayout() {
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#getDefaultLayout().
//                            documentation ```java\n@Override\npublic int getDefaultLayout()\n```
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getDefaultLayout().
    return R.layout.view_holder_empty_view;
//         ^ reference semanticdb maven . . R/
//           ^^^^^^ reference semanticdb maven . . R/layout#
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/layout#view_holder_empty_view#
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getSpanSize(int spanCount, int position, int itemCount) {
//           ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#getSpanSize().
//                       documentation ```java\n@Override\npublic int getSpanSize(int spanCount, int position, int itemCount)\n```
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getSpanSize().
//                           ^^^^^^^^^ definition local 0
//                                     documentation ```java\nint spanCount\n```
//                                          ^^^^^^^^ definition local 1
//                                                   documentation ```java\nint position\n```
//                                                        ^^^^^^^^^ definition local 2
//                                                                  documentation ```java\nint itemCount\n```
    return 0;
  }
}
