package com.airbnb.epoxy;

import com.airbnb.epoxy.VisibilityState.Visibility;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#Visibility#

/** Used to register an onVisibilityChanged callback with a generated model. */
public interface OnModelVisibilityStateChangedListener<T extends EpoxyModel<V>, V> {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnModelVisibilityStateChangedListener# public abstract interface OnModelVisibilityStateChangedListener<T extends EpoxyModel<V>, V>
//                                                     ^ definition com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[T] T extends EpoxyModel<V>
//                                                               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                          ^ reference com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[V]
//                                                                              ^ definition com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[V] V

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
//     ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnModelVisibilityStateChangedListener#onVisibilityStateChanged(). public abstract void onVisibilityStateChanged(T model, V view, int visibilityState)
//                              ^ reference com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[T]
//                                ^^^^^ definition local0 T model
//                                       ^ reference com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[V]
//                                         ^^^^ definition local1 V view
//                                                ^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#Visibility#
//                                                               ^^^^^^^^^^^^^^^ definition local2 @Visibility int visibilityState
}
