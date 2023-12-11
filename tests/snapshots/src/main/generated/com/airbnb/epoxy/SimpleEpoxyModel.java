package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

import androidx.annotation.CallSuper;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
import androidx.annotation.LayoutRes;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#

/**
 * Helper class for cases where you don't need to do anything special when binding the view. This
 * allows you to just provide the layout instead of needing to create a separate {@link EpoxyModel}
 * subclass. This is useful for static layouts. You can also specify an onClick listener and the
 * span size.
 */
public class SimpleEpoxyModel extends EpoxyModel<View> {
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#
//                            display_name SimpleEpoxyModel
//                            documentation ```java\npublic class SimpleEpoxyModel\n```
//                            documentation  Helper class for cases where you don't need to do anything special when binding the view. This\n allows you to just provide the layout instead of needing to create a separate {@link EpoxyModel}\n subclass. This is useful for static layouts. You can also specify an onClick listener and the\n span size.\n
//                            relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^ reference semanticdb maven . . View#
  @LayoutRes private final int layoutRes;
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
//                             ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#layoutRes.
//                                       display_name layoutRes
//                                       documentation ```java\n@LayoutRes\nprivate final int layoutRes\n```
  private View.OnClickListener onClickListener;
//        ^^^^ reference semanticdb maven . . View/
//             ^^^^^^^^^^^^^^^ reference semanticdb maven . . View/OnClickListener#
//                             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
//                                             display_name onClickListener
//                                             documentation ```java\nprivate unresolved_type onClickListener\n```
  private int spanCount = 1;
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#spanCount.
//                      display_name spanCount
//                      documentation ```java\nprivate int spanCount\n```

  public SimpleEpoxyModel(@LayoutRes int layoutRes) {
//       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#`<init>`().
//                        display_name <init>
//                        documentation ```java\npublic SimpleEpoxyModel(int layoutRes)\n```
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
//                                       ^^^^^^^^^ definition local 0
//                                                 display_name layoutRes
//                                                 documentation ```java\n@LayoutRes\nint layoutRes\n```
    this.layoutRes = layoutRes;
//       ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#layoutRes.
//                   ^^^^^^^^^ reference local 0
  }

  public SimpleEpoxyModel onClick(View.OnClickListener listener) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#
//                        ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#onClick().
//                                display_name onClick
//                                documentation ```java\npublic SimpleEpoxyModel onClick(unresolved_type listener)\n```
//                                ^^^^ reference semanticdb maven . . View/
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . View/OnClickListener#
//                                                     ^^^^^^^^ definition local 1
//                                                              display_name listener
//                                                              documentation ```java\nunresolved_type listener\n```
    this.onClickListener = listener;
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
//                         ^^^^^^^^ reference local 1
    return this;
  }

  public SimpleEpoxyModel span(int span) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#
//                        ^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#span().
//                             display_name span
//                             documentation ```java\npublic SimpleEpoxyModel span(int span)\n```
//                                 ^^^^ definition local 2
//                                      display_name span
//                                      documentation ```java\nint span\n```
    spanCount = span;
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#spanCount.
//              ^^^^ reference local 2
    return this;
  }

  @CallSuper
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void bind(@NonNull View view) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#bind().
//                 display_name bind
//                 documentation ```java\n@CallSuper\n@Override\npublic void bind(unresolved_type view)\n```
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind().
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^^^^ reference semanticdb maven . . View#
//                               ^^^^ definition local 3
//                                    display_name view
//                                    documentation ```java\n@NonNull\nunresolved_type view\n```
    super.bind(view);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#super.
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind().
//             ^^^^ reference local 3
    view.setOnClickListener(onClickListener);
//  ^^^^ reference local 3
//       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . View#setOnClickListener#
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
    view.setClickable(onClickListener != null);
//  ^^^^ reference local 3
//       ^^^^^^^^^^^^ reference semanticdb maven . . View#setClickable#
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
  }

  @CallSuper
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void unbind(@NonNull View view) {
//            ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#unbind().
//                   display_name unbind
//                   documentation ```java\n@CallSuper\n@Override\npublic void unbind(unresolved_type view)\n```
//                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#unbind().
//                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                            ^^^^ reference semanticdb maven . . View#
//                                 ^^^^ definition local 4
//                                      display_name view
//                                      documentation ```java\n@NonNull\nunresolved_type view\n```
    super.unbind(view);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#super.
//        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#unbind().
//               ^^^^ reference local 4
    view.setOnClickListener(null);
//  ^^^^ reference local 4
//       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . View#setOnClickListener#
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected int getDefaultLayout() {
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#getDefaultLayout().
//                               display_name getDefaultLayout
//                               documentation ```java\n@Override\nprotected int getDefaultLayout()\n```
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getDefaultLayout().
    return layoutRes;
//         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#layoutRes.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getSpanSize(int totalSpanCount, int position, int itemCount) {
//           ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#getSpanSize().
//                       display_name getSpanSize
//                       documentation ```java\n@Override\npublic int getSpanSize(int totalSpanCount, int position, int itemCount)\n```
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getSpanSize().
//                           ^^^^^^^^^^^^^^ definition local 5
//                                          display_name totalSpanCount
//                                          documentation ```java\nint totalSpanCount\n```
//                                               ^^^^^^^^ definition local 6
//                                                        display_name position
//                                                        documentation ```java\nint position\n```
//                                                             ^^^^^^^^^ definition local 7
//                                                                       display_name itemCount
//                                                                       documentation ```java\nint itemCount\n```
    return spanCount;
//         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#spanCount.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean equals(Object o) {
//               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#equals().
//                      display_name equals
//                      documentation ```java\n@Override\npublic boolean equals(Object o)\n```
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#equals().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                             ^ definition local 8
//                               display_name o
//                               documentation ```java\nObject o\n```
    if (this == o) {
//              ^ reference local 8
      return true;
    }
    if (!(o instanceof SimpleEpoxyModel)) {
//        ^ reference local 8
//                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#
      return false;
    }
    if (!super.equals(o)) {
//       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#super.
//             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#equals().
//                    ^ reference local 8
      return false;
    }

    SimpleEpoxyModel that = (SimpleEpoxyModel) o;
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#
//                   ^^^^ definition local 9
//                        display_name that
//                        documentation ```java\nSimpleEpoxyModel that\n```
//                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#
//                                             ^ reference local 8

    if (layoutRes != that.layoutRes) {
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#layoutRes.
//                   ^^^^ reference local 9
//                        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#layoutRes.
      return false;
    }
    if (spanCount != that.spanCount) {
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#spanCount.
//                   ^^^^ reference local 9
//                        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#spanCount.
      return false;
    }
    return onClickListener != null ? onClickListener.equals(that.onClickListener)
//         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
//                                                   ^^^^^^ reference semanticdb maven . . View/OnClickListener#equals#
//                                                          ^^^^ reference local 9
//                                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
        : that.onClickListener == null;
//        ^^^^ reference local 9
//             ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int hashCode() {
//           ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#hashCode().
//                    display_name hashCode
//                    documentation ```java\n@Override\npublic int hashCode()\n```
//                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCode().
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#hashCode().
    int result = super.hashCode();
//      ^^^^^^ definition local 10
//             display_name result
//             documentation ```java\nint result\n```
//               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#super.
//                     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCode().
    result = 31 * result + layoutRes;
//  ^^^^^^ reference local 10
//                ^^^^^^ reference local 10
//                         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#layoutRes.
    result = 31 * result + (onClickListener != null ? onClickListener.hashCode() : 0);
//  ^^^^^^ reference local 10
//                ^^^^^^ reference local 10
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#onClickListener.
//                                                                    ^^^^^^^^ reference semanticdb maven . . View/OnClickListener#hashCode#
    result = 31 * result + spanCount;
//  ^^^^^^ reference local 10
//                ^^^^^^ reference local 10
//                         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#spanCount.
    return result;
//         ^^^^^^ reference local 10
  }
}
