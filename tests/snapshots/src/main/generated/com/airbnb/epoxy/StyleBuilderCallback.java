package com.airbnb.epoxy;

/**
 * Used for specifying dynamic styling for a view when creating a model. This is only used if the
 * view is set up to be styled with the Paris library.
 */
public interface StyleBuilderCallback<T> {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StyleBuilderCallback#
//                                    display_name StyleBuilderCallback
//                                    signature_documentation java public interface StyleBuilderCallback<T>
//                                    documentation  Used for specifying dynamic styling for a view when creating a model. This is only used if the\n view is set up to be styled with the Paris library.\n
//                                    ^ definition semanticdb maven . . com/airbnb/epoxy/StyleBuilderCallback#[T]
//                                      display_name T
//                                      signature_documentation java T
  void buildStyle(T builder);
//     ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StyleBuilderCallback#buildStyle().
//                display_name buildStyle
//                signature_documentation java public abstract void buildStyle(T builder)
//                ^ reference semanticdb maven . . com/airbnb/epoxy/StyleBuilderCallback#[T]
//                  ^^^^^^^ definition local 0
//                          display_name builder
//                          signature_documentation java T builder
}
