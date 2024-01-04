package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

/** Used to register a click listener on a generated model. */
public interface OnModelClickListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#
//                                    display_name OnModelClickListener
//                                    signature_documentation java public interface OnModelClickListener<T extends EpoxyModel<?>, V>
//                                    documentation Used to register a click listener on a generated model. 
//                                    ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#[T]
//                                      display_name T
//                                      signature_documentation java T extends EpoxyModel<?>
//                                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                             ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#[V]
//                                                               display_name V
//                                                               signature_documentation java V
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
//             display_name onClick
//             signature_documentation java public abstract void onClick(T model, V parentView, unresolved_type clickedView, int position)
//             documentation  Called when the view bound to the model is clicked.\n\n @param model       The model that the view is bound to.\n @param parentView  The view bound to the model which received the click.\n @param clickedView The view that received the click. This is either a child of the parentView\n                    or the parentView itself\n @param position    The position of the model in the adapter.\n
//             ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#[T]
//               ^^^^^ definition local 0
//                     display_name model
//                     signature_documentation java T model
//                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#onClick().
//                      ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#[V]
//                        ^^^^^^^^^^ definition local 1
//                                   display_name parentView
//                                   signature_documentation java V parentView
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#onClick().
//                                    ^^^^ reference semanticdb maven . . View#
//                                         ^^^^^^^^^^^ definition local 2
//                                                     display_name clickedView
//                                                     signature_documentation java unresolved_type clickedView
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#onClick().
//                                                          ^^^^^^^^ definition local 3
//                                                                   display_name position
//                                                                   signature_documentation java int position
//                                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelClickListener#onClick().
}
