package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#
import android.view.ViewParent;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^^^^^^^ reference semanticdb maven . . android/view/ViewParent#

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#

/**
 * Used in conjunction with {@link com.airbnb.epoxy.EpoxyModelWithHolder} to provide a view holder
 * pattern when binding to a model.
 */
public abstract class EpoxyHolder {
//                    ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#
//                                display_name EpoxyHolder
//                                signature_documentation java public abstract class EpoxyHolder
//                                kind Class
//                                documentation  Used in conjunction with {@link com.airbnb.epoxy.EpoxyModelWithHolder} to provide a view holder\n pattern when binding to a model.\n

  public EpoxyHolder(@NonNull ViewParent parent) {
//       ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#`<init>`().
//                   display_name <init>
//                   signature_documentation java public EpoxyHolder(unresolved_type parent)
//                   kind Constructor
//                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                            ^^^^^^^^^^ reference semanticdb maven . . ViewParent#
//                                       ^^^^^^ definition local 0
//                                              display_name parent
//                                              signature_documentation java @NonNull\nunresolved_type parent
//                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#`<init>`().
    this();
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#`<init>`(+1).
  }

  public EpoxyHolder() {
//       ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#`<init>`(+1).
//                   display_name <init>
//                   signature_documentation java public EpoxyHolder()
//                   kind Constructor
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
//                        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#bindView().
//                                 display_name bindView
//                                 signature_documentation java protected abstract void bindView(unresolved_type itemView)
//                                 kind AbstractMethod
//                                 documentation  Called when this holder is created, with the view that it should hold. You can use this\n opportunity to find views by id, and do any other initialization you need. This is called only\n once for the lifetime of the class.\n\n @param itemView A view inflated from the layout provided by\n {@link EpoxyModelWithHolder#getLayout()}\n
//                                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                          ^^^^ reference semanticdb maven . . View#
//                                               ^^^^^^^^ definition local 1
//                                                        display_name itemView
//                                                        signature_documentation java @NonNull\nunresolved_type itemView
//                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#bindView().
}
