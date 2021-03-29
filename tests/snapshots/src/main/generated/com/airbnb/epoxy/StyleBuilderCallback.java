package com.airbnb.epoxy;

/**
 * Used for specifying dynamic styling for a view when creating a model. This is only used if the
 * view is set up to be styled with the Paris library.
 */
public interface StyleBuilderCallback<T> {
//               ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/StyleBuilderCallback# public abstract interface StyleBuilderCallback<T>
//                                    ^ definition com/airbnb/epoxy/StyleBuilderCallback#[T] T
  void buildStyle(T builder);
//     ^^^^^^^^^^ definition com/airbnb/epoxy/StyleBuilderCallback#buildStyle(). public abstract buildStyle(T builder)
//                ^ reference com/airbnb/epoxy/StyleBuilderCallback#[T]
//                  ^^^^^^^ definition local0 T builder
}
