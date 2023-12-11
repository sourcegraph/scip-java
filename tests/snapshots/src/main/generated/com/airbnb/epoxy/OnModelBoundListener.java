package com.airbnb.epoxy;

/** Used to register an onBind callback with a generated model. */
public interface OnModelBoundListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#
//                                    display_name OnModelBoundListener
//                                    documentation ```java\npublic interface OnModelBoundListener<T extends EpoxyModel<?>, V>\n```
//                                    documentation Used to register an onBind callback with a generated model. 
//                                    ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#[T]
//                                      display_name T
//                                      documentation ```java\nT extends EpoxyModel<?>\n```
//                                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                             ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#[V]
//                                                               display_name V
//                                                               documentation ```java\nV\n```
  /**
   * This will be called immediately after a model was bound, with the model and view that were
   * bound together.
   *
   * @param model    The model being bound
   * @param view     The view that is being bound to the model
   * @param position The adapter position of the model
   */
  void onModelBound(T model, V view, int position);
//     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#onModelBound().
//                  display_name onModelBound
//                  documentation ```java\npublic abstract void onModelBound(T model, V view, int position)\n```
//                  documentation  This will be called immediately after a model was bound, with the model and view that were\n bound together.\n\n @param model    The model being bound\n @param view     The view that is being bound to the model\n @param position The adapter position of the model\n
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#[T]
//                    ^^^^^ definition local 0
//                          display_name model
//                          documentation ```java\nT model\n```
//                           ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#[V]
//                             ^^^^ definition local 1
//                                  display_name view
//                                  documentation ```java\nV view\n```
//                                       ^^^^^^^^ definition local 2
//                                                display_name position
//                                                documentation ```java\nint position\n```
}
