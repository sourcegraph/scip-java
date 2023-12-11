package com.airbnb.epoxy;

import android.widget.CompoundButton;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^^^ reference semanticdb maven . . android/widget/
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . android/widget/CompoundButton#

public interface OnModelCheckedChangeListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#
//                                            display_name OnModelCheckedChangeListener
//                                            documentation ```java\npublic interface OnModelCheckedChangeListener<T extends EpoxyModel<?>, V>\n```
//                                            ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#[T]
//                                              display_name T
//                                              documentation ```java\nT extends EpoxyModel<?>\n```
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                     ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#[V]
//                                                                       display_name V
//                                                                       documentation ```java\nV\n```
  /**
   * Called when the view bound to the model is checked.
   *
   * @param model       The model that the view is bound to.
   * @param parentView  The view bound to the model which received the click.
   * @param checkedView The view that received the click. This is either a child of the parentView
   *                    or the parentView itself
   * @param isChecked   The new value for isChecked property.
   * @param position    The position of the model in the adapter.
   */
  void onChecked(T model, V parentView,
//     ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#onChecked().
//               display_name onChecked
//               documentation ```java\npublic abstract void onChecked(T model, V parentView, unresolved_type checkedView, boolean isChecked, int position)\n```
//               documentation  Called when the view bound to the model is checked.\n\n @param model       The model that the view is bound to.\n @param parentView  The view bound to the model which received the click.\n @param checkedView The view that received the click. This is either a child of the parentView\n                    or the parentView itself\n @param isChecked   The new value for isChecked property.\n @param position    The position of the model in the adapter.\n
//               ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#[T]
//                 ^^^^^ definition local 0
//                       display_name model
//                       documentation ```java\nT model\n```
//                        ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#[V]
//                          ^^^^^^^^^^ definition local 1
//                                     display_name parentView
//                                     documentation ```java\nV parentView\n```
      CompoundButton checkedView, boolean isChecked, int position);
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . CompoundButton#
//                   ^^^^^^^^^^^ definition local 2
//                               display_name checkedView
//                               documentation ```java\nunresolved_type checkedView\n```
//                                        ^^^^^^^^^ definition local 3
//                                                  display_name isChecked
//                                                  documentation ```java\nboolean isChecked\n```
//                                                       ^^^^^^^^ definition local 4
//                                                                display_name position
//                                                                documentation ```java\nint position\n```
}
