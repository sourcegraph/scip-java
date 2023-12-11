package com.airbnb.epoxy;

/** Used to register an onUnbind callback with a generated model. */
public interface OnModelUnboundListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#
//                                      display_name OnModelUnboundListener
//                                      documentation ```java\npublic interface OnModelUnboundListener<T extends EpoxyModel<?>, V>\n```
//                                      documentation Used to register an onUnbind callback with a generated model. 
//                                      ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#[T]
//                                        display_name T
//                                        documentation ```java\nT extends EpoxyModel<?>\n```
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                               ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#[V]
//                                                                 display_name V
//                                                                 documentation ```java\nV\n```
  /**
   * This will be called immediately after a model is unbound from a view, with the view and model
   * that were unbound.
   */
  void onModelUnbound(T model, V view);
//     ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#onModelUnbound().
//                    display_name onModelUnbound
//                    documentation ```java\npublic abstract void onModelUnbound(T model, V view)\n```
//                    documentation  This will be called immediately after a model is unbound from a view, with the view and model\n that were unbound.\n
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#[T]
//                      ^^^^^ definition local 0
//                            display_name model
//                            documentation ```java\nT model\n```
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#[V]
//                               ^^^^ definition local 1
//                                    display_name view
//                                    documentation ```java\nV view\n```
}
