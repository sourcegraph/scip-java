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
//                                documentation ```java\npublic abstract class EpoxyHolder\n```
//                                documentation  Used in conjunction with {@link com.airbnb.epoxy.EpoxyModelWithHolder} to provide a view holder\n pattern when binding to a model.\n

  public EpoxyHolder(@NonNull ViewParent parent) {
//       ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#`<init>`().
//                   documentation ```java\npublic EpoxyHolder(unresolved_type parent)\n```
//                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                            ^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                       ^^^^^^ definition local 0
//                                              documentation ```java\n@NonNull\nunresolved_type parent\n```
    this();
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#`<init>`(+1).
  }

  public EpoxyHolder() {
//       ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#`<init>`(+1).
//                   documentation ```java\npublic EpoxyHolder()\n```
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
//                                 documentation ```java\nprotected abstract void bindView(unresolved_type itemView)\n```
//                                 documentation  Called when this holder is created, with the view that it should hold. You can use this\n opportunity to find views by id, and do any other initialization you need. This is called only\n once for the lifetime of the class.\n\n @param itemView A view inflated from the layout provided by\n {@link EpoxyModelWithHolder#getLayout()}\n
//                                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                          ^^^^ reference semanticdb maven . . _root_/
//                                               ^^^^^^^^ definition local 1
//                                                        documentation ```java\n@NonNull\nunresolved_type itemView\n```
}
