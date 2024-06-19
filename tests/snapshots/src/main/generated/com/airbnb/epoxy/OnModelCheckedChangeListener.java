package com.airbnb.epoxy;

import android.widget.CompoundButton;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^^^ reference semanticdb maven . . android/widget/
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . android/widget/CompoundButton#

public interface OnModelCheckedChangeListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#
//                                            display_name OnModelCheckedChangeListener
//                                            signature_documentation java public interface OnModelCheckedChangeListener<T extends EpoxyModel<?>, V>
//                                            kind Interface
//                                            ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#[T]
//                                              display_name T
//                                              signature_documentation java T extends EpoxyModel<?>
//                                              kind TypeParameter
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                     ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#[V]
//                                                                       display_name V
//                                                                       signature_documentation java V
//                                                                       kind TypeParameter
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
//               signature_documentation java public abstract void onChecked(T model, V parentView, unresolved_type checkedView, boolean isChecked, int position)
//               kind AbstractMethod
//               documentation  Called when the view bound to the model is checked.\n\n @param model       The model that the view is bound to.\n @param parentView  The view bound to the model which received the click.\n @param checkedView The view that received the click. This is either a child of the parentView\n                    or the parentView itself\n @param isChecked   The new value for isChecked property.\n @param position    The position of the model in the adapter.\n
//               ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#[T]
//                 ^^^^^ definition local 0
//                       display_name model
//                       signature_documentation java T model
//                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#onChecked().
//                        ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#[V]
//                          ^^^^^^^^^^ definition local 1
//                                     display_name parentView
//                                     signature_documentation java V parentView
//                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#onChecked().
      CompoundButton checkedView, boolean isChecked, int position);
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . CompoundButton#
//                   ^^^^^^^^^^^ definition local 2
//                               display_name checkedView
//                               signature_documentation java unresolved_type checkedView
//                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#onChecked().
//                                        ^^^^^^^^^ definition local 3
//                                                  display_name isChecked
//                                                  signature_documentation java boolean isChecked
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#onChecked().
//                                                       ^^^^^^^^ definition local 4
//                                                                display_name position
//                                                                signature_documentation java int position
//                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#onChecked().
}
