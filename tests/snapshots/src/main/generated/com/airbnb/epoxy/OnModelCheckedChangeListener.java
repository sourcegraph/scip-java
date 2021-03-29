package com.airbnb.epoxy;

import android.widget.CompoundButton;
//     ^^^^^^^ reference android/
//             ^^^^^^ reference android/widget/
//                    ^^^^^^^^^^^^^^ reference android/widget/CompoundButton#

public interface OnModelCheckedChangeListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnModelCheckedChangeListener# public abstract interface OnModelCheckedChangeListener<T extends EpoxyModel<?>, V>
//                                            ^ definition com/airbnb/epoxy/OnModelCheckedChangeListener#[T] T extends EpoxyModel<?>
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                     ^ definition com/airbnb/epoxy/OnModelCheckedChangeListener#[V] V
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
//     ^^^^^^^^^ definition com/airbnb/epoxy/OnModelCheckedChangeListener#onChecked(). public abstract onChecked(T model, V parentView, unresolved_type checkedView, boolean isChecked, int position)
//               ^ reference com/airbnb/epoxy/OnModelCheckedChangeListener#[T]
//                 ^^^^^ definition local0 T model
//                        ^ reference com/airbnb/epoxy/OnModelCheckedChangeListener#[V]
//                          ^^^^^^^^^^ definition local1 V parentView
      CompoundButton checkedView, boolean isChecked, int position);
//    ^^^^^^^^^^^^^^ reference _root_/
//                   ^^^^^^^^^^^ definition local2 unresolved_type checkedView
//                                        ^^^^^^^^^ definition local3 boolean isChecked
//                                                       ^^^^^^^^ definition local4 int position
}
