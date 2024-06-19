package com.airbnb.epoxy;

import android.view.ViewParent;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^^^^^^^ reference semanticdb maven . . android/view/ViewParent#

import com.airbnb.epoxy.VisibilityState.Visibility;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#Visibility#

import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

import androidx.annotation.FloatRange;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
import androidx.annotation.Px;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#

/**
 * A version of {@link com.airbnb.epoxy.EpoxyModel} that allows you to use a view holder pattern
 * instead of a specific view when binding to your model.
 */
public abstract class EpoxyModelWithHolder<T extends EpoxyHolder> extends EpoxyModel<T> {
//                    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#
//                                         display_name EpoxyModelWithHolder
//                                         signature_documentation java public abstract class EpoxyModelWithHolder<T extends EpoxyHolder>
//                                         kind Class
//                                         documentation  A version of {@link com.airbnb.epoxy.EpoxyModel} that allows you to use a view holder pattern\n instead of a specific view when binding to your model.\n
//                                         relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                         ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                           display_name T
//                                           signature_documentation java T extends EpoxyHolder
//                                           kind TypeParameter
//                                                   ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                   ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]

  public EpoxyModelWithHolder() {
//       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#`<init>`().
//                            display_name <init>
//                            signature_documentation java public EpoxyModelWithHolder()
//                            kind Constructor
  }

  public EpoxyModelWithHolder(long id) {
//       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#`<init>`(+1).
//                            display_name <init>
//                            signature_documentation java public EpoxyModelWithHolder(long id)
//                            kind Constructor
//                                 ^^ definition local 0
//                                    display_name id
//                                    signature_documentation java long id
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#`<init>`(+1).
    super(id);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#`<init>`().
//        ^^ reference local 0
  }

  /** This should return a new instance of your {@link com.airbnb.epoxy.EpoxyHolder} class. */
  protected abstract T createNewHolder(@NonNull ViewParent parent);
//                   ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                     ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#createNewHolder().
//                                     display_name createNewHolder
//                                     signature_documentation java protected abstract T createNewHolder(unresolved_type parent)
//                                     kind AbstractMethod
//                                     documentation This should return a new instance of your {@link com.airbnb.epoxy.EpoxyHolder} class. 
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#createNewHolder().
//                                      ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                              ^^^^^^^^^^ reference semanticdb maven . . ViewParent#
//                                                         ^^^^^^ definition local 1
//                                                                display_name parent
//                                                                signature_documentation java @NonNull\nunresolved_type parent
//                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#createNewHolder().

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void bind(@NonNull T holder) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind().
//                 display_name bind
//                 signature_documentation java @Override\npublic void bind(T holder)
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind().
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind().
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                            ^^^^^^ definition local 2
//                                   display_name holder
//                                   signature_documentation java @NonNull\nT holder
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind().
    super.bind(holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind().
//             ^^^^^^ reference local 2
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void bind(@NonNull T holder, @NonNull List<Object> payloads) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind(+1).
//                 display_name bind
//                 signature_documentation java @Override\npublic void bind(T holder, List<Object> payloads)
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind(+1).
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind(+1).
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                            ^^^^^^ definition local 3
//                                   display_name holder
//                                   signature_documentation java @NonNull\nT holder
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind(+1).
//                                     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                             ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                          ^^^^^^^^ definition local 4
//                                                                   display_name payloads
//                                                                   signature_documentation java @NonNull\nList<Object> payloads
//                                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind(+1).
    super.bind(holder, payloads);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind(+1).
//             ^^^^^^ reference local 3
//                     ^^^^^^^^ reference local 4
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void bind(@NonNull T holder, @NonNull EpoxyModel<?> previouslyBoundModel) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind(+2).
//                 display_name bind
//                 signature_documentation java @Override\npublic void bind(T holder, EpoxyModel<?> previouslyBoundModel)
//                 kind Method
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind(+2).
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind(+2).
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                            ^^^^^^ definition local 5
//                                   display_name holder
//                                   signature_documentation java @NonNull\nT holder
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind(+2).
//                                     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^^^^^^^^^^^^^^^^ definition local 6
//                                                                                display_name previouslyBoundModel
//                                                                                signature_documentation java @NonNull\nEpoxyModel<?> previouslyBoundModel
//                                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind(+2).
    super.bind(holder, previouslyBoundModel);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind(+2).
//             ^^^^^^ reference local 5
//                     ^^^^^^^^^^^^^^^^^^^^ reference local 6
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void unbind(@NonNull T holder) {
//            ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#unbind().
//                   display_name unbind
//                   signature_documentation java @Override\npublic void unbind(T holder)
//                   kind Method
//                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#unbind().
//                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#unbind().
//                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                              ^^^^^^ definition local 7
//                                     display_name holder
//                                     signature_documentation java @NonNull\nT holder
//                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#unbind().
    super.unbind(holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#unbind().
//               ^^^^^^ reference local 7
  }


  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onVisibilityStateChanged(@Visibility int visibilityState, @NonNull T holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityStateChanged().
//                                     display_name onVisibilityStateChanged
//                                     signature_documentation java @Override\npublic void onVisibilityStateChanged(int visibilityState, T holder)
//                                     kind Method
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onVisibilityStateChanged().
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#Visibility#
//                                                     ^^^^^^^^^^^^^^^ definition local 8
//                                                                     display_name visibilityState
//                                                                     signature_documentation java @Visibility\nint visibilityState
//                                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityStateChanged().
//                                                                       ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                                               ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                                                                 ^^^^^^ definition local 9
//                                                                                        display_name holder
//                                                                                        signature_documentation java @NonNull\nT holder
//                                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityStateChanged().
    super.onVisibilityStateChanged(visibilityState, holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onVisibilityStateChanged().
//                                 ^^^^^^^^^^^^^^^ reference local 8
//                                                  ^^^^^^ reference local 9
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onVisibilityChanged(
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityChanged().
//                                display_name onVisibilityChanged
//                                signature_documentation java @Override\npublic void onVisibilityChanged(float percentVisibleHeight, float percentVisibleWidth, int visibleHeight, int visibleWidth, T holder)
//                                kind Method
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onVisibilityChanged().
      @FloatRange(from = 0, to = 100) float percentVisibleHeight,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                          ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                          ^^^^^^^^^^^^^^^^^^^^ definition local 10
//                                                               display_name percentVisibleHeight
//                                                               signature_documentation java @FloatRange(from = 0, to = 100)\nfloat percentVisibleHeight
//                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityChanged().
      @FloatRange(from = 0, to = 100) float percentVisibleWidth,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                          ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                          ^^^^^^^^^^^^^^^^^^^ definition local 11
//                                                              display_name percentVisibleWidth
//                                                              signature_documentation java @FloatRange(from = 0, to = 100)\nfloat percentVisibleWidth
//                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityChanged().
      @Px int visibleHeight, @Px int visibleWidth,
//     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//            ^^^^^^^^^^^^^ definition local 12
//                          display_name visibleHeight
//                          signature_documentation java @Px\nint visibleHeight
//                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityChanged().
//                            ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                   ^^^^^^^^^^^^ definition local 13
//                                                display_name visibleWidth
//                                                signature_documentation java @Px\nint visibleWidth
//                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityChanged().
      @NonNull T holder) {
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//               ^^^^^^ definition local 14
//                      display_name holder
//                      signature_documentation java @NonNull\nT holder
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityChanged().
    super.onVisibilityChanged(
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onVisibilityChanged().
        percentVisibleHeight, percentVisibleWidth,
//      ^^^^^^^^^^^^^^^^^^^^ reference local 10
//                            ^^^^^^^^^^^^^^^^^^^ reference local 11
        visibleHeight, visibleWidth,
//      ^^^^^^^^^^^^^ reference local 12
//                     ^^^^^^^^^^^^ reference local 13
        holder);
//      ^^^^^^ reference local 14
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean onFailedToRecycleView(T holder) {
//               ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onFailedToRecycleView().
//                                     display_name onFailedToRecycleView
//                                     signature_documentation java @Override\npublic boolean onFailedToRecycleView(T holder)
//                                     kind Method
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onFailedToRecycleView().
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                       ^^^^^^ definition local 15
//                                              display_name holder
//                                              signature_documentation java T holder
//                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onFailedToRecycleView().
    return super.onFailedToRecycleView(holder);
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//               ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onFailedToRecycleView().
//                                     ^^^^^^ reference local 15
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewAttachedToWindow(T holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onViewAttachedToWindow().
//                                   display_name onViewAttachedToWindow
//                                   signature_documentation java @Override\npublic void onViewAttachedToWindow(T holder)
//                                   kind Method
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#onViewAttachedToWindow().
//                                   ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                     ^^^^^^ definition local 16
//                                            display_name holder
//                                            signature_documentation java T holder
//                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onViewAttachedToWindow().
    super.onViewAttachedToWindow(holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                               ^^^^^^ reference local 16
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewDetachedFromWindow(T holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onViewDetachedFromWindow().
//                                     display_name onViewDetachedFromWindow
//                                     signature_documentation java @Override\npublic void onViewDetachedFromWindow(T holder)
//                                     kind Method
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#onViewDetachedFromWindow().
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                       ^^^^^^ definition local 17
//                                              display_name holder
//                                              signature_documentation java T holder
//                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onViewDetachedFromWindow().
    super.onViewDetachedFromWindow(holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                 ^^^^^^ reference local 17
  }
}
