package com.airbnb.epoxy;

/** Used to register an onBind callback with a generated model. */
public interface OnModelBoundListener<T extends EpoxyModel<?>, V> {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#
//                                    display_name OnModelBoundListener
//                                    signature_documentation java public interface OnModelBoundListener<T extends EpoxyModel<?>, V>
//                                    kind Interface
//                                    documentation Used to register an onBind callback with a generated model. 
//                                    ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#[T]
//                                      display_name T
//                                      signature_documentation java T extends EpoxyModel<?>
//                                      kind TypeParameter
//                                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                             ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#[V]
//                                                               display_name V
//                                                               signature_documentation java V
//                                                               kind TypeParameter
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
//                  signature_documentation java public abstract void onModelBound(T model, V view, int position)
//                  kind AbstractMethod
//                  documentation  This will be called immediately after a model was bound, with the model and view that were\n bound together.\n\n @param model    The model being bound\n @param view     The view that is being bound to the model\n @param position The adapter position of the model\n
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#[T]
//                    ^^^^^ definition local 0
//                          display_name model
//                          signature_documentation java T model
//                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#onModelBound().
//                           ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#[V]
//                             ^^^^ definition local 1
//                                  display_name view
//                                  signature_documentation java V view
//                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#onModelBound().
//                                       ^^^^^^^^ definition local 2
//                                                display_name position
//                                                signature_documentation java int position
//                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelBoundListener#onModelBound().
}
