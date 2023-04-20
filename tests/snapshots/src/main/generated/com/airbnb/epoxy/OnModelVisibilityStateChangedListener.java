package com.airbnb.epoxy;

import com.airbnb.epoxy.VisibilityState.Visibility;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#Visibility#

/** Used to register an onVisibilityChanged callback with a generated model. */
public interface OnModelVisibilityStateChangedListener<T extends EpoxyModel<V>, V> {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#
//                                                     documentation ```java\npublic interface OnModelVisibilityStateChangedListener<T extends EpoxyModel<V>, V>\n```
//                                                     documentation Used to register an onVisibilityChanged callback with a generated model. 
//                                                     ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[T]
//                                                       documentation ```java\nT extends EpoxyModel<V>\n```
//                                                               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                          ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[V]
//                                                                              ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[V]
//                                                                                documentation ```java\nV\n```

  /**
   * This will be called once the visibility changed.
   * <p>
   * @param model           The model being bound
   * @param view            The view that is being bound to the model
   * @param visibilityState The new visibility
   * <p>
   * @see VisibilityState
   */
  void onVisibilityStateChanged(T model, V view, @Visibility int visibilityState);
//     ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#onVisibilityStateChanged().
//                              documentation ```java\npublic abstract void onVisibilityStateChanged(T model, V view, int visibilityState)\n```
//                              documentation  This will be called once the visibility changed.\n <p>\n @param model           The model being bound\n @param view            The view that is being bound to the model\n @param visibilityState The new visibility\n <p>\n @see VisibilityState\n
//                              ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[T]
//                                ^^^^^ definition local 0
//                                      documentation ```java\nT model\n```
//                                       ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityStateChangedListener#[V]
//                                         ^^^^ definition local 1
//                                              documentation ```java\nV view\n```
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#Visibility#
//                                                               ^^^^^^^^^^^^^^^ definition local 2
//                                                                               documentation ```java\n@Visibility\nint visibilityState\n```
}
