package com.airbnb.epoxy;

import android.widget.CompoundButton;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^^^ reference semanticdb maven . . android/widget/
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . android/widget/CompoundButton#
import android.widget.CompoundButton.OnCheckedChangeListener;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^^^ reference semanticdb maven . . android/widget/
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . android/widget/CompoundButton/
//                                   ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . android/widget/CompoundButton/OnCheckedChangeListener#

import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView#

/**
 * Used in the generated models to transform normal checked change listener to model
 * checked change.
 */
public class WrappedEpoxyModelCheckedChangeListener<T extends EpoxyModel<?>, V>
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#
//                                                  documentation ```java\npublic class WrappedEpoxyModelCheckedChangeListener<T extends EpoxyModel<?>, V>\n```
//                                                  documentation  Used in the generated models to transform normal checked change listener to model\n checked change.\n
//                                                  relationship is_implementation semanticdb maven . . ``/OnCheckedChangeListener#
//                                                  ^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[T]
//                                                    documentation ```java\nT extends EpoxyModel<?>\n```
//                                                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                           ^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[V]
//                                                                             documentation ```java\nV\n```
    implements OnCheckedChangeListener {
//             ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/

  private final OnModelCheckedChangeListener<T, V> originalCheckedChangeListener;
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#
//                                           ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[T]
//                                              ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[V]
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
//                                                                               documentation ```java\nprivate final OnModelCheckedChangeListener<T, V> originalCheckedChangeListener\n```

  public WrappedEpoxyModelCheckedChangeListener(
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#`<init>`().
//                                              documentation ```java\npublic WrappedEpoxyModelCheckedChangeListener(OnModelCheckedChangeListener<T, V> checkedListener)\n```
      OnModelCheckedChangeListener<T, V> checkedListener
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#
//                                 ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[T]
//                                    ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[V]
//                                       ^^^^^^^^^^^^^^^ definition local 0
//                                                       documentation ```java\nOnModelCheckedChangeListener<T, V> checkedListener\n```
  ) {
    if (checkedListener == null) {
//      ^^^^^^^^^^^^^^^ reference local 0
      throw new IllegalArgumentException("Checked change listener cannot be null");
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalArgumentException#`<init>`(+1).
    }

    this.originalCheckedChangeListener = checkedListener;
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
//                                       ^^^^^^^^^^^^^^^ reference local 0
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onCheckedChanged(CompoundButton button, boolean isChecked) {
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#onCheckedChanged().
//                             documentation ```java\n@Override\npublic void onCheckedChanged(unresolved_type button, boolean isChecked)\n```
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                            ^^^^^^ definition local 1
//                                                   documentation ```java\nunresolved_type button\n```
//                                                            ^^^^^^^^^ definition local 2
//                                                                      documentation ```java\nboolean isChecked\n```
    EpoxyViewHolder epoxyHolder = ListenersUtils.getEpoxyHolderForChildView(button);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                  ^^^^^^^^^^^ definition local 3
//                              documentation ```java\nEpoxyViewHolder epoxyHolder\n```
//                                ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ListenersUtils#
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ListenersUtils#getEpoxyHolderForChildView().
//                                                                          ^^^^^^ reference local 1
    if (epoxyHolder == null) {
//      ^^^^^^^^^^^ reference local 3
      // Initial binding can trigger the checked changed listener when the checked value is set.
      // The view is not attached at this point so the holder can't be looked up, and in any case
      // it is generally better to not trigger a callback for the binding anyway, since it isn't
      // a user action.
      //
      // https://github.com/airbnb/epoxy/issues/797
      return;
    }

    final int adapterPosition = epoxyHolder.getAdapterPosition();
//            ^^^^^^^^^^^^^^^ definition local 4
//                            documentation ```java\nfinal int adapterPosition\n```
//                              ^^^^^^^^^^^ reference local 3
//                                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
    if (adapterPosition != RecyclerView.NO_POSITION) {
//      ^^^^^^^^^^^^^^^ reference local 4
//                         ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                      ^^^^^^^^^^^ reference semanticdb maven . . NO_POSITION#
      originalCheckedChangeListener
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
          .onChecked((T) epoxyHolder.getModel(), (V) epoxyHolder.objectToBind(), button,
//         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#onChecked().
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[T]
//                       ^^^^^^^^^^^ reference local 3
//                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                                ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[V]
//                                                   ^^^^^^^^^^^ reference local 3
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
//                                                                               ^^^^^^ reference local 1
          isChecked, adapterPosition);
//        ^^^^^^^^^ reference local 2
//                   ^^^^^^^^^^^^^^^ reference local 4
    }
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean equals(Object o) {
//               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#equals().
//                      documentation ```java\n@Override\npublic boolean equals(Object o)\n```
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                             ^ definition local 5
//                               documentation ```java\nObject o\n```
    if (this == o) {
//              ^ reference local 5
      return true;
    }
    if (!(o instanceof WrappedEpoxyModelCheckedChangeListener)) {
//        ^ reference local 5
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#
      return false;
    }

    WrappedEpoxyModelCheckedChangeListener<?, ?>
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#
        that = (WrappedEpoxyModelCheckedChangeListener<?, ?>) o;
//      ^^^^ definition local 6
//           documentation ```java\nWrappedEpoxyModelCheckedChangeListener<?, ?> that\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#
//                                                            ^ reference local 5

    return originalCheckedChangeListener.equals(that.originalCheckedChangeListener);
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
//                                       ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#equals().
//                                              ^^^^ reference local 6
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int hashCode() {
//           ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#hashCode().
//                    documentation ```java\n@Override\npublic int hashCode()\n```
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#hashCode().
    return originalCheckedChangeListener.hashCode();
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
//                                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#hashCode().
  }
}
