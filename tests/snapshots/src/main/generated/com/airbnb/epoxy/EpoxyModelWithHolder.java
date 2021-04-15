package com.airbnb.epoxy;

import android.view.ViewParent;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^^^^^^^ reference android/view/ViewParent#

import com.airbnb.epoxy.VisibilityState.Visibility;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#Visibility#

import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

import androidx.annotation.FloatRange;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^^ reference androidx/annotation/FloatRange#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#
import androidx.annotation.Px;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^ reference androidx/annotation/Px#

/**
 * A version of {@link com.airbnb.epoxy.EpoxyModel} that allows you to use a view holder pattern
 * instead of a specific view when binding to your model.
 */
public abstract class EpoxyModelWithHolder<T extends EpoxyHolder> extends EpoxyModel<T> {
//                    ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder# public abstract class EpoxyModelWithHolder<T extends EpoxyHolder> extends EpoxyModel<T>
//                                         ^ definition com/airbnb/epoxy/EpoxyModelWithHolder#[T] T extends EpoxyHolder
//                                                   ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyHolder#
//                                                                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                   ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]

  public EpoxyModelWithHolder() {
//       ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#`<init>`(). public EpoxyModelWithHolder()
  }

  public EpoxyModelWithHolder(long id) {
//       ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#`<init>`(+1). public EpoxyModelWithHolder(long id)
//                                 ^^ definition local0 long id
    super(id);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModel#`<init>`().
//        ^^ reference local0
  }

  /** This should return a new instance of your {@link com.airbnb.epoxy.EpoxyHolder} class. */
  protected abstract T createNewHolder(@NonNull ViewParent parent);
//                   ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                     ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#createNewHolder(). protected abstract T createNewHolder(unresolved_type parent)
//                                      ^^^^^^^ reference androidx/annotation/NonNull#
//                                              ^^^^^^^^^^ reference _root_/
//                                                         ^^^^^^ definition local1 @NonNull unresolved_type parent

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull T holder) {
//            ^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#bind(). @Override public void bind(T holder)
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                            ^^^^^^ definition local2 @NonNull T holder
    super.bind(holder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^ reference com/airbnb/epoxy/EpoxyModel#bind().
//             ^^^^^^ reference local2
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull T holder, @NonNull List<Object> payloads) {
//            ^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#bind(+1). @Override public void bind(T holder, List<Object> payloads)
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                            ^^^^^^ definition local3 @NonNull T holder
//                                     ^^^^^^^ reference androidx/annotation/NonNull#
//                                             ^^^^ reference java/util/List#
//                                                  ^^^^^^ reference java/lang/Object#
//                                                          ^^^^^^^^ definition local4 @NonNull List<Object> payloads
    super.bind(holder, payloads);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^ reference com/airbnb/epoxy/EpoxyModel#bind(+1).
//             ^^^^^^ reference local3
//                     ^^^^^^^^ reference local4
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull T holder, @NonNull EpoxyModel<?> previouslyBoundModel) {
//            ^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#bind(+2). @Override public void bind(T holder, EpoxyModel<?> previouslyBoundModel)
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                            ^^^^^^ definition local5 @NonNull T holder
//                                     ^^^^^^^ reference androidx/annotation/NonNull#
//                                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^^^^^^^^^^^^^^^^ definition local6 @NonNull EpoxyModel<?> previouslyBoundModel
    super.bind(holder, previouslyBoundModel);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^ reference com/airbnb/epoxy/EpoxyModel#bind(+2).
//             ^^^^^^ reference local5
//                     ^^^^^^^^^^^^^^^^^^^^ reference local6
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void unbind(@NonNull T holder) {
//            ^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#unbind(). @Override public void unbind(T holder)
//                    ^^^^^^^ reference androidx/annotation/NonNull#
//                            ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                              ^^^^^^ definition local7 @NonNull T holder
    super.unbind(holder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#unbind().
//               ^^^^^^ reference local7
  }


  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onVisibilityStateChanged(@Visibility int visibilityState, @NonNull T holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityStateChanged(). @Override public void onVisibilityStateChanged(int visibilityState, T holder)
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#Visibility#
//                                                     ^^^^^^^^^^^^^^^ definition local8 @Visibility int visibilityState
//                                                                       ^^^^^^^ reference androidx/annotation/NonNull#
//                                                                               ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                                                                 ^^^^^^ definition local9 @NonNull T holder
    super.onVisibilityStateChanged(visibilityState, holder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onVisibilityStateChanged().
//                                 ^^^^^^^^^^^^^^^ reference local8
//                                                  ^^^^^^ reference local9
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onVisibilityChanged(
//            ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityChanged(). @Override public void onVisibilityChanged(float percentVisibleHeight, float percentVisibleWidth, int visibleHeight, int visibleWidth, T holder)
      @FloatRange(from = 0, to = 100) float percentVisibleHeight,
//     ^^^^^^^^^^ reference androidx/annotation/FloatRange#
//                ^^^^ reference androidx/annotation/FloatRange#from().
//                          ^^ reference androidx/annotation/FloatRange#to().
//                                          ^^^^^^^^^^^^^^^^^^^^ definition local10 @FloatRange(from = 0, to = 100) float percentVisibleHeight
      @FloatRange(from = 0, to = 100) float percentVisibleWidth,
//     ^^^^^^^^^^ reference androidx/annotation/FloatRange#
//                ^^^^ reference androidx/annotation/FloatRange#from().
//                          ^^ reference androidx/annotation/FloatRange#to().
//                                          ^^^^^^^^^^^^^^^^^^^ definition local11 @FloatRange(from = 0, to = 100) float percentVisibleWidth
      @Px int visibleHeight, @Px int visibleWidth,
//     ^^ reference androidx/annotation/Px#
//            ^^^^^^^^^^^^^ definition local12 @Px int visibleHeight
//                            ^^ reference androidx/annotation/Px#
//                                   ^^^^^^^^^^^^ definition local13 @Px int visibleWidth
      @NonNull T holder) {
//     ^^^^^^^ reference androidx/annotation/NonNull#
//             ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//               ^^^^^^ definition local14 @NonNull T holder
    super.onVisibilityChanged(
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onVisibilityChanged().
        percentVisibleHeight, percentVisibleWidth,
//      ^^^^^^^^^^^^^^^^^^^^ reference local10
//                            ^^^^^^^^^^^^^^^^^^^ reference local11
        visibleHeight, visibleWidth,
//      ^^^^^^^^^^^^^ reference local12
//                     ^^^^^^^^^^^^ reference local13
        holder);
//      ^^^^^^ reference local14
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public boolean onFailedToRecycleView(T holder) {
//               ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#onFailedToRecycleView(). @Override public boolean onFailedToRecycleView(T holder)
//                                     ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                       ^^^^^^ definition local15 T holder
    return super.onFailedToRecycleView(holder);
//         ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//               ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onFailedToRecycleView().
//                                     ^^^^^^ reference local15
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onViewAttachedToWindow(T holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#onViewAttachedToWindow(). @Override public void onViewAttachedToWindow(T holder)
//                                   ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                     ^^^^^^ definition local16 T holder
    super.onViewAttachedToWindow(holder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                               ^^^^^^ reference local16
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onViewDetachedFromWindow(T holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelWithHolder#onViewDetachedFromWindow(). @Override public void onViewDetachedFromWindow(T holder)
//                                     ^ reference com/airbnb/epoxy/EpoxyModelWithHolder#[T]
//                                       ^^^^^^ definition local17 T holder
    super.onViewDetachedFromWindow(holder);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                 ^^^^^^ reference local17
  }
}
