package com.airbnb.epoxy;

/**
 * Used for specifying dynamic styling for a view when creating a model. This is only used if the
 * view is set up to be styled with the Paris library.
 */
public interface StyleBuilderCallback<T> {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StyleBuilderCallback#
//                                    display_name StyleBuilderCallback
//                                    documentation ```java\npublic interface StyleBuilderCallback<T>\n```
//                                    documentation  Used for specifying dynamic styling for a view when creating a model. This is only used if the\n view is set up to be styled with the Paris library.\n
//                                    ^ definition semanticdb maven . . com/airbnb/epoxy/StyleBuilderCallback#[T]
//                                      display_name T
//                                      documentation ```java\nT\n```
  void buildStyle(T builder);
//     ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StyleBuilderCallback#buildStyle().
//                display_name buildStyle
//                documentation ```java\npublic abstract void buildStyle(T builder)\n```
//                ^ reference semanticdb maven . . com/airbnb/epoxy/StyleBuilderCallback#[T]
//                  ^^^^^^^ definition local 0
//                          display_name builder
//                          documentation ```java\nT builder\n```
}
