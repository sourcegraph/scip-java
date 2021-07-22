package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#

import androidx.annotation.CallSuper;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^ reference androidx/annotation/CallSuper#
import androidx.annotation.LayoutRes;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^ reference androidx/annotation/LayoutRes#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#

/**
 * Helper class for cases where you don't need to do anything special when binding the view. This
 * allows you to just provide the layout instead of needing to create a separate {@link EpoxyModel}
 * subclass. This is useful for static layouts. You can also specify an onClick listener and the
 * span size.
 */
public class SimpleEpoxyModel extends EpoxyModel<View> {
//           ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel# public class SimpleEpoxyModel
//                                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^ reference _root_/
  @LayoutRes private final int layoutRes;
// ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//                             ^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel#layoutRes. @LayoutRes private final int layoutRes
  private View.OnClickListener onClickListener;
//        ^^^^ reference View/
//             ^^^^^^^^^^^^^^^ reference View/OnClickListener#
//                             ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel#onClickListener. private unresolved_type onClickListener
  private int spanCount = 1;
//            ^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel#spanCount. private int spanCount

  public SimpleEpoxyModel(@LayoutRes int layoutRes) {
//       ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel#`<init>`(). public SimpleEpoxyModel(int layoutRes)
//                         ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//                                       ^^^^^^^^^ definition local0 @LayoutRes int layoutRes
    this.layoutRes = layoutRes;
//       ^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#layoutRes.
//                   ^^^^^^^^^ reference local0
  }

  public SimpleEpoxyModel onClick(View.OnClickListener listener) {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#
//                        ^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel#onClick(). public SimpleEpoxyModel onClick(unresolved_type listener)
//                                ^^^^ reference View/
//                                     ^^^^^^^^^^^^^^^ reference View/OnClickListener#
//                                                     ^^^^^^^^ definition local1 unresolved_type listener
    this.onClickListener = listener;
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
//                         ^^^^^^^^ reference local1
    return this;
  }

  public SimpleEpoxyModel span(int span) {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#
//                        ^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel#span(). public SimpleEpoxyModel span(int span)
//                                 ^^^^ definition local2 int span
    spanCount = span;
//  ^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#spanCount.
//              ^^^^ reference local2
    return this;
  }

  @CallSuper
// ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull View view) {
//            ^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel#bind(). @CallSuper @Override public void bind(unresolved_type view)
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^^^^ reference _root_/
//                               ^^^^ definition local3 @NonNull unresolved_type view
    super.bind(view);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#super.
//        ^^^^ reference com/airbnb/epoxy/EpoxyModel#bind().
//             ^^^^ reference local3
    view.setOnClickListener(onClickListener);
//  ^^^^ reference local3
//       ^^^^^^^^^^^^^^^^^^ reference setOnClickListener#
//                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
    view.setClickable(onClickListener != null);
//  ^^^^ reference local3
//       ^^^^^^^^^^^^ reference setClickable#
//                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
  }

  @CallSuper
// ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void unbind(@NonNull View view) {
//            ^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel#unbind(). @CallSuper @Override public void unbind(unresolved_type view)
//                    ^^^^^^^ reference androidx/annotation/NonNull#
//                            ^^^^ reference _root_/
//                                 ^^^^ definition local4 @NonNull unresolved_type view
    super.unbind(view);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#super.
//        ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#unbind().
//               ^^^^ reference local4
    view.setOnClickListener(null);
//  ^^^^ reference local4
//       ^^^^^^^^^^^^^^^^^^ reference setOnClickListener#
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected int getDefaultLayout() {
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel#getDefaultLayout(). @Override protected int getDefaultLayout()
    return layoutRes;
//         ^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#layoutRes.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public int getSpanSize(int totalSpanCount, int position, int itemCount) {
//           ^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel#getSpanSize(). @Override public int getSpanSize(int totalSpanCount, int position, int itemCount)
//                           ^^^^^^^^^^^^^^ definition local5 int totalSpanCount
//                                               ^^^^^^^^ definition local6 int position
//                                                             ^^^^^^^^^ definition local7 int itemCount
    return spanCount;
//         ^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#spanCount.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public boolean equals(Object o) {
//               ^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel#equals(). @Override public boolean equals(Object o)
//                      ^^^^^^ reference java/lang/Object#
//                             ^ definition local8 Object o
    if (this == o) {
//              ^ reference local8
      return true;
    }
    if (!(o instanceof SimpleEpoxyModel)) {
//        ^ reference local8
//                     ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#
      return false;
    }
    if (!super.equals(o)) {
//       ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#super.
//             ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#equals().
//                    ^ reference local8
      return false;
    }

    SimpleEpoxyModel that = (SimpleEpoxyModel) o;
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#
//                   ^^^^ definition local9 SimpleEpoxyModel that
//                           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#
//                                             ^ reference local8

    if (layoutRes != that.layoutRes) {
//      ^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#layoutRes.
//                   ^^^^ reference local9
//                        ^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#layoutRes.
      return false;
    }
    if (spanCount != that.spanCount) {
//      ^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#spanCount.
//                   ^^^^ reference local9
//                        ^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#spanCount.
      return false;
    }
    return onClickListener != null ? onClickListener.equals(that.onClickListener)
//         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
//                                   ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
//                                                   ^^^^^^ reference View/OnClickListener#equals#
//                                                          ^^^^ reference local9
//                                                               ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
        : that.onClickListener == null;
//        ^^^^ reference local9
//             ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public int hashCode() {
//           ^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyModel#hashCode(). @Override public int hashCode()
    int result = super.hashCode();
//      ^^^^^^ definition local10 int result
//               ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#super.
//                     ^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#hashCode().
    result = 31 * result + layoutRes;
//  ^^^^^^ reference local10
//                ^^^^^^ reference local10
//                         ^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#layoutRes.
    result = 31 * result + (onClickListener != null ? onClickListener.hashCode() : 0);
//  ^^^^^^ reference local10
//                ^^^^^^ reference local10
//                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
//                                                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
//                                                                    ^^^^^^^^ reference View/OnClickListener#hashCode#
    result = 31 * result + spanCount;
//  ^^^^^^ reference local10
//                ^^^^^^ reference local10
//                         ^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyModel#spanCount.
    return result;
//         ^^^^^^ reference local10
  }
}
