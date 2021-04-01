package com.airbnb.epoxy;

/** Used to register an onUnbind callback with a generated model. */
public interface OnModelUnboundListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnModelUnboundListener# public abstract interface OnModelUnboundListener<T extends EpoxyModel<?>, V>
//                                      ^ definition com/airbnb/epoxy/OnModelUnboundListener#[T] T extends EpoxyModel<?>
//                                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                               ^ definition com/airbnb/epoxy/OnModelUnboundListener#[V] V
  /**
   * This will be called immediately after a model is unbound from a view, with the view and model
   * that were unbound.
   */
  void onModelUnbound(T model, V view);
//     ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnModelUnboundListener#onModelUnbound(). public abstract void onModelUnbound(T model, V view)
//                    ^ reference com/airbnb/epoxy/OnModelUnboundListener#[T]
//                      ^^^^^ definition local0 T model
//                             ^ reference com/airbnb/epoxy/OnModelUnboundListener#[V]
//                               ^^^^ definition local1 V view
}
