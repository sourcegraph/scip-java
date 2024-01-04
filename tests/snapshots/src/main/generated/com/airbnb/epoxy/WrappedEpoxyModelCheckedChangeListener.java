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
//                                                  display_name WrappedEpoxyModelCheckedChangeListener
//                                                  signature_documentation java public class WrappedEpoxyModelCheckedChangeListener<T extends EpoxyModel<?>, V>
//                                                  documentation  Used in the generated models to transform normal checked change listener to model\n checked change.\n
//                                                  relationship is_implementation semanticdb maven . . OnCheckedChangeListener#
//                                                  ^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[T]
//                                                    display_name T
//                                                    signature_documentation java T extends EpoxyModel<?>
//                                                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                           ^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[V]
//                                                                             display_name V
//                                                                             signature_documentation java V
    implements OnCheckedChangeListener {
//             ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . OnCheckedChangeListener#

  private final OnModelCheckedChangeListener<T, V> originalCheckedChangeListener;
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#
//                                           ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[T]
//                                              ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[V]
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
//                                                                               display_name originalCheckedChangeListener
//                                                                               signature_documentation java private final OnModelCheckedChangeListener<T, V> originalCheckedChangeListener

  public WrappedEpoxyModelCheckedChangeListener(
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#`<init>`().
//                                              display_name <init>
//                                              signature_documentation java public WrappedEpoxyModelCheckedChangeListener(OnModelCheckedChangeListener<T, V> checkedListener)
      OnModelCheckedChangeListener<T, V> checkedListener
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelCheckedChangeListener#
//                                 ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[T]
//                                    ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#[V]
//                                       ^^^^^^^^^^^^^^^ definition local 0
//                                                       display_name checkedListener
//                                                       signature_documentation java OnModelCheckedChangeListener<T, V> checkedListener
//                                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#`<init>`().
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
//                             display_name onCheckedChanged
//                             signature_documentation java @Override\npublic void onCheckedChanged(unresolved_type button, boolean isChecked)
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . CompoundButton#
//                                            ^^^^^^ definition local 1
//                                                   display_name button
//                                                   signature_documentation java unresolved_type button
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#onCheckedChanged().
//                                                            ^^^^^^^^^ definition local 2
//                                                                      display_name isChecked
//                                                                      signature_documentation java boolean isChecked
//                                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#onCheckedChanged().
    EpoxyViewHolder epoxyHolder = ListenersUtils.getEpoxyHolderForChildView(button);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                  ^^^^^^^^^^^ definition local 3
//                              display_name epoxyHolder
//                              signature_documentation java EpoxyViewHolder epoxyHolder
//                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#onCheckedChanged().
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
//                            display_name adapterPosition
//                            signature_documentation java final int adapterPosition
//                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#onCheckedChanged().
//                              ^^^^^^^^^^^ reference local 3
//                                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getAdapterPosition#
    if (adapterPosition != RecyclerView.NO_POSITION) {
//      ^^^^^^^^^^^^^^^ reference local 4
//                         ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                      ^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#NO_POSITION#
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
//                      display_name equals
//                      signature_documentation java @Override\npublic boolean equals(Object o)
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                             ^ definition local 5
//                               display_name o
//                               signature_documentation java Object o
//                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#equals().
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
//           display_name that
//           signature_documentation java WrappedEpoxyModelCheckedChangeListener<?, ?> that
//           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#equals().
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
//                    display_name hashCode
//                    signature_documentation java @Override\npublic int hashCode()
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#hashCode().
    return originalCheckedChangeListener.hashCode();
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelCheckedChangeListener#originalCheckedChangeListener.
//                                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#hashCode().
  }
}
