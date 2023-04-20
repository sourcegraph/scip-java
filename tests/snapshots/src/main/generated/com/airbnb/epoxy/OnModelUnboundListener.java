package com.airbnb.epoxy;

/** Used to register an onUnbind callback with a generated model. */
public interface OnModelUnboundListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#
//                                      documentation ```java\npublic interface OnModelUnboundListener<T extends EpoxyModel<?>, V>\n```
//                                      documentation Used to register an onUnbind callback with a generated model. 
//                                      ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#[T]
//                                        documentation ```java\nT extends EpoxyModel<?>\n```
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                               ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#[V]
//                                                                 documentation ```java\nV\n```
  /**
   * This will be called immediately after a model is unbound from a view, with the view and model
   * that were unbound.
   */
  void onModelUnbound(T model, V view);
//     ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#onModelUnbound().
//                    documentation ```java\npublic abstract void onModelUnbound(T model, V view)\n```
//                    documentation  This will be called immediately after a model is unbound from a view, with the view and model\n that were unbound.\n
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#[T]
//                      ^^^^^ definition local 0
//                            documentation ```java\nT model\n```
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#[V]
//                               ^^^^ definition local 1
//                                    documentation ```java\nV view\n```
}
