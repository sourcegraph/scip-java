package com.airbnb.epoxy;

import com.airbnb.epoxy.VisibilityState.Visibility;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#Visibility#

/** Used to register an onVisibilityChanged callback with a generated model. */
public interface OnModelVisibilityStateChangedListener<T extends EpoxyModel<V>, V> {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#
//                                                     display_name OnModelVisibilityStateChangedListener
//                                                     signature_documentation java public interface OnModelVisibilityStateChangedListener<T extends EpoxyModel<V>, V>
//                                                     kind Interface
//                                                     documentation Used to register an onVisibilityChanged callback with a generated model. 
//                                                     ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[T]
//                                                       display_name T
//                                                       signature_documentation java T extends EpoxyModel<V>
//                                                       kind TypeParameter
//                                                               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                          ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[V]
//                                                                              ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[V]
//                                                                                display_name V
//                                                                                signature_documentation java V
//                                                                                kind TypeParameter

  /**
   * This will be called once the visibility changed.
   * <p>
   * @param model           The model being bound
   * @param view            The view that is being bound to the model
   * @param visibilityState The new visibility
   * <p>
   * @see VisibilityState
   */
  void onVisibilityStateChanged(T model, V view, @Visibility int visibilityState);
//     ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#onVisibilityStateChanged().
//                              display_name onVisibilityStateChanged
//                              signature_documentation java public abstract void onVisibilityStateChanged(T model, V view, int visibilityState)
//                              kind AbstractMethod
//                              documentation  This will be called once the visibility changed.\n <p>\n @param model           The model being bound\n @param view            The view that is being bound to the model\n @param visibilityState The new visibility\n <p>\n @see VisibilityState\n
//                              ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[T]
//                                ^^^^^ definition local 0
//                                      display_name model
//                                      signature_documentation java T model
//                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#onVisibilityStateChanged().
//                                       ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[V]
//                                         ^^^^ definition local 1
//                                              display_name view
//                                              signature_documentation java V view
//                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#onVisibilityStateChanged().
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#Visibility#
//                                                               ^^^^^^^^^^^^^^^ definition local 2
//                                                                               display_name visibilityState
//                                                                               signature_documentation java @Visibility\nint visibilityState
//                                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#onVisibilityStateChanged().
}
