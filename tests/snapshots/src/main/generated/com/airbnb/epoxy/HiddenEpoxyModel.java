
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
//                     display_name HiddenEpoxyModel
//                     signature_documentation java class HiddenEpoxyModel
//                     documentation  Used by the {@link EpoxyAdapter} as a placeholder for when {@link EpoxyModel#isShown()} is false.\n Using a zero height and width {@link Space} view, as well as 0 span size, to exclude itself from\n view.\n
//                     relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#`<init>`().
//                     display_name <init>
//                     signature_documentation java HiddenEpoxyModel()
//                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                        ^^^^^ reference semanticdb maven . . Space#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getDefaultLayout() {
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#getDefaultLayout().
//                            display_name getDefaultLayout
//                            signature_documentation java @Override\npublic int getDefaultLayout()
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
//                       display_name getSpanSize
//                       signature_documentation java @Override\npublic int getSpanSize(int spanCount, int position, int itemCount)
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getSpanSize().
//                           ^^^^^^^^^ definition local 0
//                                     display_name spanCount
//                                     signature_documentation java int spanCount
//                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#getSpanSize().
//                                          ^^^^^^^^ definition local 1
//                                                   display_name position
//                                                   signature_documentation java int position
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#getSpanSize().
//                                                        ^^^^^^^^^ definition local 2
//                                                                  display_name itemCount
//                                                                  signature_documentation java int itemCount
//                                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#getSpanSize().
    return 0;
  }
}
