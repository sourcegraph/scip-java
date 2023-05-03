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
//                                         documentation ```java\npublic abstract class EpoxyModelWithHolder<T extends EpoxyHolder>\n```
//                                         documentation  A version of {@link com.airbnb.epoxy.EpoxyModel} that allows you to use a view holder pattern\n instead of a specific view when binding to your model.\n
//                                         relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                         ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                           documentation ```java\nT extends EpoxyHolder\n```
//                                                   ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                   ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]

  public EpoxyModelWithHolder() {
//       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#`<init>`().
//                            documentation ```java\npublic EpoxyModelWithHolder()\n```
  }

  public EpoxyModelWithHolder(long id) {
//       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#`<init>`(+1).
//                            documentation ```java\npublic EpoxyModelWithHolder(long id)\n```
//                                 ^^ definition local 0
//                                    documentation ```java\nlong id\n```
    super(id);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#`<init>`().
//        ^^ reference local 0
  }

  /** This should return a new instance of your {@link com.airbnb.epoxy.EpoxyHolder} class. */
  protected abstract T createNewHolder(@NonNull ViewParent parent);
//                   ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                     ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#createNewHolder().
//                                     documentation ```java\nprotected abstract T createNewHolder(unresolved_type parent)\n```
//                                     documentation This should return a new instance of your {@link com.airbnb.epoxy.EpoxyHolder} class. 
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#createNewHolder().
//                                      ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                              ^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                         ^^^^^^ definition local 1
//                                                                documentation ```java\n@NonNull\nunresolved_type parent\n```

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void bind(@NonNull T holder) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind().
//                 documentation ```java\n@Override\npublic void bind(T holder)\n```
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind().
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind().
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                            ^^^^^^ definition local 2
//                                   documentation ```java\n@NonNull\nT holder\n```
    super.bind(holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind().
//             ^^^^^^ reference local 2
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void bind(@NonNull T holder, @NonNull List<Object> payloads) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind(+1).
//                 documentation ```java\n@Override\npublic void bind(T holder, List<Object> payloads)\n```
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind(+1).
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind(+1).
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                            ^^^^^^ definition local 3
//                                   documentation ```java\n@NonNull\nT holder\n```
//                                     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                             ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                          ^^^^^^^^ definition local 4
//                                                                   documentation ```java\n@NonNull\nList<Object> payloads\n```
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
//                 documentation ```java\n@Override\npublic void bind(T holder, EpoxyModel<?> previouslyBoundModel)\n```
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind(+2).
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind(+2).
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                            ^^^^^^ definition local 5
//                                   documentation ```java\n@NonNull\nT holder\n```
//                                     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^^^^^^^^^^^^^^^^ definition local 6
//                                                                                documentation ```java\n@NonNull\nEpoxyModel<?> previouslyBoundModel\n```
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
//                   documentation ```java\n@Override\npublic void unbind(T holder)\n```
//                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#unbind().
//                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#unbind().
//                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                              ^^^^^^ definition local 7
//                                     documentation ```java\n@NonNull\nT holder\n```
    super.unbind(holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#unbind().
//               ^^^^^^ reference local 7
  }


  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onVisibilityStateChanged(@Visibility int visibilityState, @NonNull T holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityStateChanged().
//                                     documentation ```java\n@Override\npublic void onVisibilityStateChanged(int visibilityState, T holder)\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onVisibilityStateChanged().
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#Visibility#
//                                                     ^^^^^^^^^^^^^^^ definition local 8
//                                                                     documentation ```java\n@Visibility\nint visibilityState\n```
//                                                                       ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                                               ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                                                                 ^^^^^^ definition local 9
//                                                                                        documentation ```java\n@NonNull\nT holder\n```
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
//                                documentation ```java\n@Override\npublic void onVisibilityChanged(float percentVisibleHeight, float percentVisibleWidth, int visibleHeight, int visibleWidth, T holder)\n```
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onVisibilityChanged().
      @FloatRange(from = 0, to = 100) float percentVisibleHeight,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                          ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                          ^^^^^^^^^^^^^^^^^^^^ definition local 10
//                                                               documentation ```java\n@FloatRange(from = 0, to = 100)\nfloat percentVisibleHeight\n```
      @FloatRange(from = 0, to = 100) float percentVisibleWidth,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                          ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                          ^^^^^^^^^^^^^^^^^^^ definition local 11
//                                                              documentation ```java\n@FloatRange(from = 0, to = 100)\nfloat percentVisibleWidth\n```
      @Px int visibleHeight, @Px int visibleWidth,
//     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//            ^^^^^^^^^^^^^ definition local 12
//                          documentation ```java\n@Px\nint visibleHeight\n```
//                            ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                   ^^^^^^^^^^^^ definition local 13
//                                                documentation ```java\n@Px\nint visibleWidth\n```
      @NonNull T holder) {
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//               ^^^^^^ definition local 14
//                      documentation ```java\n@NonNull\nT holder\n```
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
//                                     documentation ```java\n@Override\npublic boolean onFailedToRecycleView(T holder)\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onFailedToRecycleView().
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                       ^^^^^^ definition local 15
//                                              documentation ```java\nT holder\n```
    return super.onFailedToRecycleView(holder);
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//               ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onFailedToRecycleView().
//                                     ^^^^^^ reference local 15
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewAttachedToWindow(T holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onViewAttachedToWindow().
//                                   documentation ```java\n@Override\npublic void onViewAttachedToWindow(T holder)\n```
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#onViewAttachedToWindow().
//                                   ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                     ^^^^^^ definition local 16
//                                            documentation ```java\nT holder\n```
    super.onViewAttachedToWindow(holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                               ^^^^^^ reference local 16
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewDetachedFromWindow(T holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onViewDetachedFromWindow().
//                                     documentation ```java\n@Override\npublic void onViewDetachedFromWindow(T holder)\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#onViewDetachedFromWindow().
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                       ^^^^^^ definition local 17
//                                              documentation ```java\nT holder\n```
    super.onViewDetachedFromWindow(holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                 ^^^^^^ reference local 17
  }
}
