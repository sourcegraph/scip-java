package com.airbnb.epoxy;

/** Used to register an onUnbind callback with a generated model. */
public interface OnModelUnboundListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#
//                                      display_name OnModelUnboundListener
//                                      signature_documentation java public interface OnModelUnboundListener<T extends EpoxyModel<?>, V>
//                                      kind Interface
//                                      documentation Used to register an onUnbind callback with a generated model. 
//                                      ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#[T]
//                                        display_name T
//                                        signature_documentation java T extends EpoxyModel<?>
//                                        kind TypeParameter
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                               ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#[V]
//                                                                 display_name V
//                                                                 signature_documentation java V
//                                                                 kind TypeParameter
  /**
   * This will be called immediately after a model is unbound from a view, with the view and model
   * that were unbound.
   */
  void onModelUnbound(T model, V view);
//     ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#onModelUnbound().
//                    display_name onModelUnbound
//                    signature_documentation java public abstract void onModelUnbound(T model, V view)
//                    kind AbstractMethod
//                    documentation  This will be called immediately after a model is unbound from a view, with the view and model\n that were unbound.\n
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#[T]
//                      ^^^^^ definition local 0
//                            display_name model
//                            signature_documentation java T model
//                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#onModelUnbound().
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#[V]
//                               ^^^^ definition local 1
//                                    display_name view
//                                    signature_documentation java V view
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelUnboundListener#onModelUnbound().
}
