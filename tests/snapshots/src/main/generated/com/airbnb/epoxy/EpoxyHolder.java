package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#
import android.view.ViewParent;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^^^^^^^ reference android/view/ViewParent#

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#

/**
 * Used in conjunction with {@link com.airbnb.epoxy.EpoxyModelWithHolder} to provide a view holder
 * pattern when binding to a model.
 */
public abstract class EpoxyHolder {
//                    ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyHolder# public abstract class EpoxyHolder

  public EpoxyHolder(@NonNull ViewParent parent) {
//       ^^^^^^ definition com/airbnb/epoxy/EpoxyHolder#`<init>`(). public EpoxyHolder(unresolved_type parent)
//                    ^^^^^^^ reference androidx/annotation/NonNull#
//                            ^^^^^^^^^^ reference _root_/
//                                       ^^^^^^ definition local0 @NonNull unresolved_type parent
    this();
//  ^^^^ reference com/airbnb/epoxy/EpoxyHolder#`<init>`(+1).
  }

  public EpoxyHolder() {
//       ^^^^^^ definition com/airbnb/epoxy/EpoxyHolder#`<init>`(+1). public EpoxyHolder()
  }

  /**
   * Called when this holder is created, with the view that it should hold. You can use this
   * opportunity to find views by id, and do any other initialization you need. This is called only
   * once for the lifetime of the class.
   *
   * @param itemView A view inflated from the layout provided by
   * {@link EpoxyModelWithHolder#getLayout()}
   */
  protected abstract void bindView(@NonNull View itemView);
//                        ^^^^^^^^ definition com/airbnb/epoxy/EpoxyHolder#bindView(). protected abstract void bindView(unresolved_type itemView)
//                                  ^^^^^^^ reference androidx/annotation/NonNull#
//                                          ^^^^ reference _root_/
//                                               ^^^^^^^^ definition local1 @NonNull unresolved_type itemView
}
