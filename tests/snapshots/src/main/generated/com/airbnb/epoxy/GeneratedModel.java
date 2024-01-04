package com.airbnb.epoxy;

/** Interface applied to generated models to allow the base adapter to interact with them. */
public interface GeneratedModel<T> {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/GeneratedModel#
//                              display_name GeneratedModel
//                              signature_documentation java public interface GeneratedModel<T>
//                              documentation Interface applied to generated models to allow the base adapter to interact with them. 
//                              ^ definition semanticdb maven . . com/airbnb/epoxy/GeneratedModel#[T]
//                                display_name T
//                                signature_documentation java T
  /**
   * Called on the generated model immediately before the main model onBind method has been called.
   * This let's the generated model handle binding setup of its own
   * <p>
   * The ViewHolder is needed to get the model's adapter position when clicked.
   */
  void handlePreBind(EpoxyViewHolder holder, T objectToBind, int position);
//     ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/GeneratedModel#handlePreBind().
//                   display_name handlePreBind
//                   signature_documentation java public abstract void handlePreBind(EpoxyViewHolder holder, T objectToBind, int position)
//                   documentation  Called on the generated model immediately before the main model onBind method has been called.\n This let's the generated model handle binding setup of its own\n <p>\n The ViewHolder is needed to get the model's adapter position when clicked.\n
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                   ^^^^^^ definition local 0
//                                          display_name holder
//                                          signature_documentation java EpoxyViewHolder holder
//                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/GeneratedModel#handlePreBind().
//                                           ^ reference semanticdb maven . . com/airbnb/epoxy/GeneratedModel#[T]
//                                             ^^^^^^^^^^^^ definition local 1
//                                                          display_name objectToBind
//                                                          signature_documentation java T objectToBind
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/GeneratedModel#handlePreBind().
//                                                               ^^^^^^^^ definition local 2
//                                                                        display_name position
//                                                                        signature_documentation java int position
//                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/GeneratedModel#handlePreBind().
  /**
   * Called on the generated model immediately after the main model onBind method has been called.
   * This let's the generated model handle binding of its own and dispatch calls to its onBind
   * listener.
   * <p>
   * We don't want to rely on the main onBind method to dispatch the onBind listener call because
   * there are two onBind methods (one for payloads and one for no payloads), and one can call into
   * the other. We don't want to dispatch two onBind listener calls in that case.
   */
  void handlePostBind(T objectToBind, int position);
//     ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/GeneratedModel#handlePostBind().
//                    display_name handlePostBind
//                    signature_documentation java public abstract void handlePostBind(T objectToBind, int position)
//                    documentation  Called on the generated model immediately after the main model onBind method has been called.\n This let's the generated model handle binding of its own and dispatch calls to its onBind\n listener.\n <p>\n We don't want to rely on the main onBind method to dispatch the onBind listener call because\n there are two onBind methods (one for payloads and one for no payloads), and one can call into\n the other. We don't want to dispatch two onBind listener calls in that case.\n
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/GeneratedModel#[T]
//                      ^^^^^^^^^^^^ definition local 3
//                                   display_name objectToBind
//                                   signature_documentation java T objectToBind
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/GeneratedModel#handlePostBind().
//                                        ^^^^^^^^ definition local 4
//                                                 display_name position
//                                                 signature_documentation java int position
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/GeneratedModel#handlePostBind().
}
