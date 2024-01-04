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
//                                                display_name OnModelVisibilityChangedListener
//                                                signature_documentation java public interface OnModelVisibilityChangedListener<T extends EpoxyModel<V>, V>
//                                                documentation Used to register an onVisibilityChanged callback with a generated model. 
//                                                ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#[T]
//                                                  display_name T
//                                                  signature_documentation java T extends EpoxyModel<V>
//                                                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                     ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#[V]
//                                                                         ^ definition semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#[V]
//                                                                           display_name V
//                                                                           signature_documentation java V

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
//                         display_name onVisibilityChanged
//                         signature_documentation java public abstract void onVisibilityChanged(T model, V view, float percentVisibleHeight, float percentVisibleWidth, int heightVisible, int widthVisible)
//                         documentation  This will be called once the view visible part changes.\n <p>\n OnModelVisibilityChangedListener should be used with particular care since they will be\n dispatched on every frame while scrolling. No heavy work should be done inside the\n implementation. Using {@link OnModelVisibilityStateChangedListener} is recommended whenever\n possible.\n <p>\n @param model                The model being bound\n @param view                 The view that is being bound to the model\n @param percentVisibleHeight The percentage of height visible (0-100)\n @param percentVisibleWidth  The percentage of width visible (0-100)\n @param heightVisible        The visible height in pixel\n @param widthVisible         The visible width in pixel\n
//                         ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#[T]
//                           ^^^^^ definition local 0
//                                 display_name model
//                                 signature_documentation java T model
//                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#onVisibilityChanged().
//                                  ^ reference semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#[V]
//                                    ^^^^ definition local 1
//                                         display_name view
//                                         signature_documentation java V view
//                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#onVisibilityChanged().
      @FloatRange(from = 0, to = 100) float percentVisibleHeight,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                          ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                          ^^^^^^^^^^^^^^^^^^^^ definition local 2
//                                                               display_name percentVisibleHeight
//                                                               signature_documentation java @FloatRange(from = 0, to = 100)\nfloat percentVisibleHeight
//                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#onVisibilityChanged().
      @FloatRange(from = 0, to = 100) float percentVisibleWidth,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                          ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                          ^^^^^^^^^^^^^^^^^^^ definition local 3
//                                                              display_name percentVisibleWidth
//                                                              signature_documentation java @FloatRange(from = 0, to = 100)\nfloat percentVisibleWidth
//                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#onVisibilityChanged().
      @Px int heightVisible, @Px int widthVisible);
//     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//            ^^^^^^^^^^^^^ definition local 4
//                          display_name heightVisible
//                          signature_documentation java @Px\nint heightVisible
//                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#onVisibilityChanged().
//                            ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                   ^^^^^^^^^^^^ definition local 5
//                                                display_name widthVisible
//                                                signature_documentation java @Px\nint widthVisible
//                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelVisibilityChangedListener#onVisibilityChanged().
}
