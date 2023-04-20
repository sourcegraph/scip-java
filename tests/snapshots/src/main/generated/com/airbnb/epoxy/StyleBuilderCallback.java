package com.airbnb.epoxy;

/**
 * Used for specifying dynamic styling for a view when creating a model. This is only used if the
 * view is set up to be styled with the Paris library.
 */
public interface StyleBuilderCallback<T> {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StyleBuilderCallback#
//                                    documentation  Used for specifying dynamic styling for a view when creating a model. This is only used if the\n view is set up to be styled with the Paris library.\n
//                                    documentation ```java\npublic interface StyleBuilderCallback<T>\n```
//                                    ^ definition semanticdb maven . . com/airbnb/epoxy/StyleBuilderCallback#[T]
//                                      documentation ```java\nT\n```
  void buildStyle(T builder);
//     ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StyleBuilderCallback#buildStyle().
//                documentation ```java\npublic abstract void buildStyle(T builder)\n```
//                ^ reference semanticdb maven . . com/airbnb/epoxy/StyleBuilderCallback#[T]
//                  ^^^^^^^ definition local 0
//                          documentation ```java\nT builder\n```
}
