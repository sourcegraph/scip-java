package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

/** Used to register a click listener on a generated model. */
public interface OnModelClickListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#
//                                    documentation ```java\npublic interface OnModelClickListener<T extends EpoxyModel<?>, V>\n```
//                                    documentation Used to register a click listener on a generated model. 
//                                    ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#[T]
//                                      documentation ```java\nT extends EpoxyModel<?>\n```
//                                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                             ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#[V]
//                                                               documentation ```java\nV\n```
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
//     ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#onClick().
//             documentation ```java\npublic abstract void onClick(T model, V parentView, unresolved_type clickedView, int position)\n```
//             documentation  Called when the view bound to the model is clicked.\n\n @param model       The model that the view is bound to.\n @param parentView  The view bound to the model which received the click.\n @param clickedView The view that received the click. This is either a child of the parentView\n                    or the parentView itself\n @param position    The position of the model in the adapter.\n
//             ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#[T]
//               ^^^^^ definition local 0
//                     documentation ```java\nT model\n```
//                      ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#[V]
//                        ^^^^^^^^^^ definition local 1
//                                   documentation ```java\nV parentView\n```
//                                    ^^^^ reference semanticdb maven . . _root_/
//                                         ^^^^^^^^^^^ definition local 2
//                                                     documentation ```java\nunresolved_type clickedView\n```
//                                                          ^^^^^^^^ definition local 3
//                                                                   documentation ```java\nint position\n```
}
