package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#
import android.view.ViewParent;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^^^^^^^ reference semanticdb maven . . android/view/ViewParent#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView#
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/
//                                               ^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/ViewHolder#

public class ListenersUtils {
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ListenersUtils#
//                          display_name ListenersUtils
//                          documentation ```java\npublic class ListenersUtils\n```
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ListenersUtils#`<init>`().
//                          display_name <init>
//                          documentation ```java\npublic ListenersUtils()\n```

  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  static EpoxyViewHolder getEpoxyHolderForChildView(View v) {
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ListenersUtils#getEpoxyHolderForChildView().
//                                                  display_name getEpoxyHolderForChildView
//                                                  documentation ```java\n@Nullable\nstatic EpoxyViewHolder getEpoxyHolderForChildView(unresolved_type v)\n```
//                                                  ^^^^ reference semanticdb maven . . View#
//                                                       ^ definition local 0
//                                                         display_name v
//                                                         documentation ```java\nunresolved_type v\n```
    RecyclerView recyclerView = findParentRecyclerView(v);
//  ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//               ^^^^^^^^^^^^ definition local 1
//                            display_name recyclerView
//                            documentation ```java\nunresolved_type recyclerView\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ListenersUtils#findParentRecyclerView().
//                                                     ^ reference local 0
    if (recyclerView == null) {
//      ^^^^^^^^^^^^ reference local 1
      return null;
    }

    ViewHolder viewHolder = recyclerView.findContainingViewHolder(v);
//  ^^^^^^^^^^ reference semanticdb maven . . ViewHolder#
//             ^^^^^^^^^^ definition local 2
//                        display_name viewHolder
//                        documentation ```java\nunresolved_type viewHolder\n```
//                          ^^^^^^^^^^^^ reference local 1
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#findContainingViewHolder#
//                                                                ^ reference local 0
    if (viewHolder == null) {
//      ^^^^^^^^^^ reference local 2
      return null;
    }

    if (!(viewHolder instanceof EpoxyViewHolder)) {
//        ^^^^^^^^^^ reference local 2
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
      return null;
    }

    return (EpoxyViewHolder) viewHolder;
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                           ^^^^^^^^^^ reference local 2
  }

  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  private static RecyclerView findParentRecyclerView(@Nullable View v) {
//               ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ListenersUtils#findParentRecyclerView().
//                                                   display_name findParentRecyclerView
//                                                   documentation ```java\n@Nullable\nprivate static unresolved_type findParentRecyclerView(unresolved_type v)\n```
//                                                    ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                             ^^^^ reference semanticdb maven . . View#
//                                                                  ^ definition local 3
//                                                                    display_name v
//                                                                    documentation ```java\n@Nullable\nunresolved_type v\n```
    if (v == null) {
//      ^ reference local 3
      return null;
    }

    ViewParent parent = v.getParent();
//  ^^^^^^^^^^ reference semanticdb maven . . ViewParent#
//             ^^^^^^ definition local 4
//                    display_name parent
//                    documentation ```java\nunresolved_type parent\n```
//                      ^ reference local 3
//                        ^^^^^^^^^ reference semanticdb maven . . View#getParent#
    if (parent instanceof RecyclerView) {
//      ^^^^^^ reference local 4
//                        ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
      return (RecyclerView) parent;
//            ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                          ^^^^^^ reference local 4
    }

    if (parent instanceof View) {
//      ^^^^^^ reference local 4
//                        ^^^^ reference semanticdb maven . . View#
      return findParentRecyclerView((View) parent);
//           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ListenersUtils#findParentRecyclerView().
//                                   ^^^^ reference semanticdb maven . . View#
//                                         ^^^^^^ reference local 4
    }

    return null;
  }
}
