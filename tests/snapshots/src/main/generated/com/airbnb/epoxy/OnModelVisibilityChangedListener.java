package com.airbnb.epoxy;

import androidx.annotation.FloatRange;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
import androidx.annotation.Px;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#

/** Used to register an onVisibilityChanged callback with a generated model. */
public interface OnModelVisibilityChangedListener<T extends EpoxyModel<V>, V> {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#
//                                                documentation ```java\npublic interface OnModelVisibilityChangedListener<T extends EpoxyModel<V>, V>\n```
//                                                documentation Used to register an onVisibilityChanged callback with a generated model. 
//                                                ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#[T]
//                                                  documentation ```java\nT extends EpoxyModel<V>\n```
//                                                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                     ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#[V]
//                                                                         ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#[V]
//                                                                           documentation ```java\nV\n```

  /**
   * This will be called once the view visible part changes.
   * <p>
   * OnModelVisibilityChangedListener should be used with particular care since they will be
   * dispatched on every frame while scrolling. No heavy work should be done inside the
   * implementation. Using {@link OnModelVisibilityStateChangedListener} is recommended whenever
   * possible.
   * <p>
   * @param model                The model being bound
   * @param view                 The view that is being bound to the model
   * @param percentVisibleHeight The percentage of height visible (0-100)
   * @param percentVisibleWidth  The percentage of width visible (0-100)
   * @param heightVisible        The visible height in pixel
   * @param widthVisible         The visible width in pixel
   */
  void onVisibilityChanged(T model, V view,
//     ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#onVisibilityChanged().
//                         documentation ```java\npublic abstract void onVisibilityChanged(T model, V view, float percentVisibleHeight, float percentVisibleWidth, int heightVisible, int widthVisible)\n```
//                         documentation  This will be called once the view visible part changes.\n <p>\n OnModelVisibilityChangedListener should be used with particular care since they will be\n dispatched on every frame while scrolling. No heavy work should be done inside the\n implementation. Using {@link OnModelVisibilityStateChangedListener} is recommended whenever\n possible.\n <p>\n @param model                The model being bound\n @param view                 The view that is being bound to the model\n @param percentVisibleHeight The percentage of height visible (0-100)\n @param percentVisibleWidth  The percentage of width visible (0-100)\n @param heightVisible        The visible height in pixel\n @param widthVisible         The visible width in pixel\n
//                         ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#[T]
//                           ^^^^^ definition local 0
//                                 documentation ```java\nT model\n```
//                                  ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#[V]
//                                    ^^^^ definition local 1
//                                         documentation ```java\nV view\n```
      @FloatRange(from = 0, to = 100) float percentVisibleHeight,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                          ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                          ^^^^^^^^^^^^^^^^^^^^ definition local 2
//                                                               documentation ```java\n@FloatRange(from = 0, to = 100)\nfloat percentVisibleHeight\n```
      @FloatRange(from = 0, to = 100) float percentVisibleWidth,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                          ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                          ^^^^^^^^^^^^^^^^^^^ definition local 3
//                                                              documentation ```java\n@FloatRange(from = 0, to = 100)\nfloat percentVisibleWidth\n```
      @Px int heightVisible, @Px int widthVisible);
//     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//            ^^^^^^^^^^^^^ definition local 4
//                          documentation ```java\n@Px\nint heightVisible\n```
//                            ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                   ^^^^^^^^^^^^ definition local 5
//                                                documentation ```java\n@Px\nint widthVisible\n```
}
