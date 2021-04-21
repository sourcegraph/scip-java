package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#

/** Used to register a click listener on a generated model. */
public interface OnModelClickListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnModelClickListener# public interface OnModelClickListener<T extends EpoxyModel<?>, V>
//                                    ^ definition com/airbnb/epoxy/OnModelClickListener#[T] T extends EpoxyModel<?>
//                                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                             ^ definition com/airbnb/epoxy/OnModelClickListener#[V] V
  /**
   * Called when the view bound to the model is clicked.
   *
   * @param model       The model that the view is bound to.
   * @param parentView  The view bound to the model which received the click.
   * @param clickedView The view that received the click. This is either a child of the parentView
   *                    or the parentView itself
   * @param position    The position of the model in the adapter.
   */
  void onClick(T model, V parentView, View clickedView, int position);
//     ^^^^^^^ definition com/airbnb/epoxy/OnModelClickListener#onClick(). public void onClick(T model, V parentView, unresolved_type clickedView, int position)
//             ^ reference com/airbnb/epoxy/OnModelClickListener#[T]
//               ^^^^^ definition local0 T model
//                      ^ reference com/airbnb/epoxy/OnModelClickListener#[V]
//                        ^^^^^^^^^^ definition local1 V parentView
//                                    ^^^^ reference _root_/
//                                         ^^^^^^^^^^^ definition local2 unresolved_type clickedView
//                                                          ^^^^^^^^ definition local3 int position
}
