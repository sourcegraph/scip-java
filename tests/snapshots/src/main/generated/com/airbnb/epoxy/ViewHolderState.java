
package com.airbnb.epoxy;

import android.os.Parcel;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^ reference semanticdb maven . . android/os/Parcel#
import android.os.Parcelable;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^^^^ reference semanticdb maven . . android/os/Parcelable#
import android.util.SparseArray;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/util/
//                  ^^^^^^^^^^^ reference semanticdb maven . . android/util/SparseArray#
import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

import com.airbnb.epoxy.ViewHolderState.ViewState;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#
//                                      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#
import com.airbnb.viewmodeladapter.R;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/viewmodeladapter/
//                                 ^ reference semanticdb maven . . com/airbnb/viewmodeladapter/R#

import java.util.Collection;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#

import androidx.collection.LongSparseArray;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/collection/
//                         ^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#

/**
 * Helper for {@link EpoxyAdapter} to store the state of Views in the adapter. This is useful for
 * saving changes due to user input, such as text input or selection, when a view is scrolled off
 * screen or if the adapter needs to be recreated.
 * <p/>
 * This saved state is separate from the state represented by a {@link EpoxyModel}, which should
 * represent the more permanent state of the data shown in the view. This class stores transient
 * state that is added to the View after it is bound to a {@link EpoxyModel}. For example, a {@link
 * EpoxyModel} may inflate and bind an EditText and then be responsible for styling it and attaching
 * listeners. If the user then inputs text, scrolls the view offscreen and then scrolls back, this
 * class will preserve the inputted text without the {@link EpoxyModel} needing to be aware of its
 * existence.
 * <p/>
 * This class relies on the adapter having stable ids, as the state of a view is mapped to the id of
 * the {@link EpoxyModel}.
 */
@SuppressWarnings("WeakerAccess")
//^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
class ViewHolderState extends LongSparseArray<ViewState> implements Parcelable {
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#
//                    display_name ViewHolderState
//                    signature_documentation java @SuppressWarnings("WeakerAccess")\nclass ViewHolderState
//                    documentation  Helper for {@link EpoxyAdapter} to store the state of Views in the adapter. This is useful for\n saving changes due to user input, such as text input or selection, when a view is scrolled off\n screen or if the adapter needs to be recreated.\n <p/>\n This saved state is separate from the state represented by a {@link EpoxyModel}, which should\n represent the more permanent state of the data shown in the view. This class stores transient\n state that is added to the View after it is bound to a {@link EpoxyModel}. For example, a {@link\n EpoxyModel} may inflate and bind an EditText and then be responsible for styling it and attaching\n listeners. If the user then inputs text, scrolls the view offscreen and then scrolls back, this\n class will preserve the inputted text without the {@link EpoxyModel} needing to be aware of its\n existence.\n <p/>\n This class relies on the adapter having stable ids, as the state of a view is mapped to the id of\n the {@link EpoxyModel}.\n
//                    relationship is_implementation semanticdb maven . . Parcelable#
//                    relationship is_implementation semanticdb maven jdk 11 java/lang/Cloneable#
//                    relationship is_implementation semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#
//                                            ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#
//                                                                  ^^^^^^^^^^ reference semanticdb maven . . Parcelable#
  ViewHolderState() {
//^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#`<init>`().
//                display_name <init>
//                signature_documentation java ViewHolderState()
  }

  private ViewHolderState(int size) {
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#`<init>`(+1).
//                        display_name <init>
//                        signature_documentation java private ViewHolderState(int size)
//                            ^^^^ definition local 0
//                                 display_name size
//                                 signature_documentation java int size
    super(size);
//  ^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#`<init>`(+1).
//        ^^^^ reference local 0
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int describeContents() {
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#describeContents().
//                            display_name describeContents
//                            signature_documentation java @Override\npublic int describeContents()
    return 0;
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void writeToParcel(Parcel dest, int flags) {
//            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#writeToParcel().
//                          display_name writeToParcel
//                          signature_documentation java @Override\npublic void writeToParcel(unresolved_type dest, int flags)
//                          ^^^^^^ reference semanticdb maven . . Parcel#
//                                 ^^^^ definition local 1
//                                      display_name dest
//                                      signature_documentation java unresolved_type dest
//                                           ^^^^^ definition local 2
//                                                 display_name flags
//                                                 signature_documentation java int flags
    final int size = size();
//            ^^^^ definition local 3
//                 display_name size
//                 signature_documentation java final int size
//                   ^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#size().
    dest.writeInt(size);
//  ^^^^ reference local 1
//       ^^^^^^^^ reference semanticdb maven . . Parcel#writeInt#
//                ^^^^ reference local 3
    for (int i = 0; i < size; i++) {
//           ^ definition local 4
//             display_name i
//             signature_documentation java int i
//                  ^ reference local 4
//                      ^^^^ reference local 3
//                            ^ reference local 4
      dest.writeLong(keyAt(i));
//    ^^^^ reference local 1
//         ^^^^^^^^^ reference semanticdb maven . . Parcel#writeLong#
//                   ^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#keyAt().
//                         ^ reference local 4
      dest.writeParcelable(valueAt(i), 0);
//    ^^^^ reference local 1
//         ^^^^^^^^^^^^^^^ reference semanticdb maven . . Parcel#writeParcelable#
//                         ^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#valueAt().
//                                 ^ reference local 4
    }
  }

  public static final Creator<ViewHolderState> CREATOR = new Creator<ViewHolderState>() {
//                    ^^^^^^^ reference semanticdb maven . . Creator#
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#
//                                             ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#CREATOR.
//                                                     display_name CREATOR
//                                                     signature_documentation java public static final unresolved_type CREATOR
//                                                           ^^^^^^^ reference semanticdb maven . . Creator#
//                                                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#

    public ViewHolderState[] newArray(int size) {
      return new ViewHolderState[size];
    }

    public ViewHolderState createFromParcel(Parcel source) {
      int size = source.readInt();
      ViewHolderState state = new ViewHolderState(size);

      for (int i = 0; i < size; i++) {
        long key = source.readLong();
        ViewState value = source.readParcelable(ViewState.class.getClassLoader());
        state.put(key, value);
      }

      return state;
    }
  };

  public boolean hasStateForHolder(EpoxyViewHolder holder) {
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#hasStateForHolder().
//                                 display_name hasStateForHolder
//                                 signature_documentation java public boolean hasStateForHolder(EpoxyViewHolder holder)
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^ definition local 5
//                                                        display_name holder
//                                                        signature_documentation java EpoxyViewHolder holder
    return get(holder.getItemId()) != null;
//         ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#get().
//             ^^^^^^ reference local 5
//                    ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getItemId#
  }

  public void save(Collection<EpoxyViewHolder> holders) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#save().
//                 display_name save
//                 signature_documentation java public void save(Collection<EpoxyViewHolder> holders)
//                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                             ^^^^^^^ definition local 6
//                                                     display_name holders
//                                                     signature_documentation java Collection<EpoxyViewHolder> holders
    for (EpoxyViewHolder holder : holders) {
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^^^^ definition local 7
//                              display_name holder
//                              signature_documentation java EpoxyViewHolder holder
//                                ^^^^^^^ reference local 6
      save(holder);
//    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#save(+1).
//         ^^^^^^ reference local 7
    }
  }

  /** Save the state of the view bound to the given holder. */
  public void save(EpoxyViewHolder holder) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#save(+1).
//                 display_name save
//                 signature_documentation java public void save(EpoxyViewHolder holder)
//                 documentation Save the state of the view bound to the given holder. 
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                 ^^^^^^ definition local 8
//                                        display_name holder
//                                        signature_documentation java EpoxyViewHolder holder
    if (!holder.getModel().shouldSaveViewState()) {
//       ^^^^^^ reference local 8
//              ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shouldSaveViewState().
      return;
    }

    // Reuse the previous sparse array if available. We shouldn't need to clear it since the
    // exact same view type is being saved to it, which
    // should have identical ids for all its views, and will just overwrite the previous state.
    ViewState state = get(holder.getItemId());
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#
//            ^^^^^ definition local 9
//                  display_name state
//                  signature_documentation java ViewState state
//                    ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#get().
//                        ^^^^^^ reference local 8
//                               ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getItemId#
    if (state == null) {
//      ^^^^^ reference local 9
      state = new ViewState();
//    ^^^^^ reference local 9
//                ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#`<init>`().
    }

    state.save(holder.itemView);
//  ^^^^^ reference local 9
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#save().
//             ^^^^^^ reference local 8
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
    put(holder.getItemId(), state);
//  ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#put().
//      ^^^^^^ reference local 8
//             ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getItemId#
//                          ^^^^^ reference local 9
  }

  /**
   * If a state was previously saved for this view holder via {@link #save} it will be restored
   * here.
   */
  public void restore(EpoxyViewHolder holder) {
//            ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#restore().
//                    display_name restore
//                    signature_documentation java public void restore(EpoxyViewHolder holder)
//                    documentation  If a state was previously saved for this view holder via {@link #save} it will be restored\n here.\n
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                    ^^^^^^ definition local 10
//                                           display_name holder
//                                           signature_documentation java EpoxyViewHolder holder
    if (!holder.getModel().shouldSaveViewState()) {
//       ^^^^^^ reference local 10
//              ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shouldSaveViewState().
      return;
    }

    ViewState state = get(holder.getItemId());
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#
//            ^^^^^ definition local 11
//                  display_name state
//                  signature_documentation java ViewState state
//                    ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#get().
//                        ^^^^^^ reference local 10
//                               ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getItemId#
    if (state != null) {
//      ^^^^^ reference local 11
      state.restore(holder.itemView);
//    ^^^^^ reference local 11
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#restore().
//                  ^^^^^^ reference local 10
//                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
    } else {
      // The first time a model is bound it won't have previous state. We need to make sure
      // the view is reset to its initial state to clear any changes from previously bound models
      holder.restoreInitialViewState();
//    ^^^^^^ reference local 10
//           ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#restoreInitialViewState().
    }
  }

  /**
   * A wrapper around a sparse array as a helper to save the state of a view. This also adds
   * parcelable support.
   */
  public static class ViewState extends SparseArray<Parcelable> implements Parcelable {
//                    ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#
//                              display_name ViewState
//                              signature_documentation java public static class ViewState
//                              documentation  A wrapper around a sparse array as a helper to save the state of a view. This also adds\n parcelable support.\n
//                              relationship is_implementation semanticdb maven . . Parcelable#
//                              relationship is_implementation semanticdb maven . . SparseArray#
//                                      ^^^^^^^^^^^ reference semanticdb maven . . SparseArray#
//                                                  ^^^^^^^^^^ reference semanticdb maven . . Parcelable#
//                                                                         ^^^^^^^^^^ reference semanticdb maven . . Parcelable#

    ViewState() {
//  ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#`<init>`().
//            display_name <init>
//            signature_documentation java ViewState()
    }

    private ViewState(int size, int[] keys, Parcelable[] values) {
//          ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#`<init>`(+1).
//                    display_name <init>
//                    signature_documentation java private ViewState(int size, int[] keys, unresolved_type[] values)
//                        ^^^^ definition local 12
//                             display_name size
//                             signature_documentation java int size
//                                    ^^^^ definition local 13
//                                         display_name keys
//                                         signature_documentation java int[] keys
//                                          ^^^^^^^^^^ reference semanticdb maven . . Parcelable#
//                                                       ^^^^^^ definition local 14
//                                                              display_name values
//                                                              signature_documentation java unresolved_type[] values
      super(size);
//          ^^^^ reference local 12
      for (int i = 0; i < size; ++i) {
//             ^ definition local 15
//               display_name i
//               signature_documentation java int i
//                    ^ reference local 15
//                        ^^^^ reference local 12
//                                ^ reference local 15
        put(keys[i], values[i]);
//      ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#put().
//          ^^^^ reference local 13
//               ^ reference local 15
//                   ^^^^^^ reference local 14
//                          ^ reference local 15
      }
    }

    public void save(View view) {
//              ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#save().
//                   display_name save
//                   signature_documentation java public void save(unresolved_type view)
//                   ^^^^ reference semanticdb maven . . View#
//                        ^^^^ definition local 16
//                             display_name view
//                             signature_documentation java unresolved_type view
      int originalId = view.getId();
//        ^^^^^^^^^^ definition local 17
//                   display_name originalId
//                   signature_documentation java int originalId
//                     ^^^^ reference local 16
//                          ^^^^^ reference semanticdb maven . . View#getId#
      setIdIfNoneExists(view);
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#setIdIfNoneExists().
//                      ^^^^ reference local 16

      view.saveHierarchyState(this);
//    ^^^^ reference local 16
//         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . View#saveHierarchyState#
      view.setId(originalId);
//    ^^^^ reference local 16
//         ^^^^^ reference semanticdb maven . . View#setId#
//               ^^^^^^^^^^ reference local 17
    }

    public void restore(View view) {
//              ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#restore().
//                      display_name restore
//                      signature_documentation java public void restore(unresolved_type view)
//                      ^^^^ reference semanticdb maven . . View#
//                           ^^^^ definition local 18
//                                display_name view
//                                signature_documentation java unresolved_type view
      int originalId = view.getId();
//        ^^^^^^^^^^ definition local 19
//                   display_name originalId
//                   signature_documentation java int originalId
//                     ^^^^ reference local 18
//                          ^^^^^ reference semanticdb maven . . View#getId#
      setIdIfNoneExists(view);
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#setIdIfNoneExists().
//                      ^^^^ reference local 18

      view.restoreHierarchyState(this);
//    ^^^^ reference local 18
//         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . View#restoreHierarchyState#
      view.setId(originalId);
//    ^^^^ reference local 18
//         ^^^^^ reference semanticdb maven . . View#setId#
//               ^^^^^^^^^^ reference local 19
    }

    /**
     * If a view hasn't had an id set we need to set a temporary one in order to save state, since a
     * view won't save its state unless it has an id. The view's id is also the key into the sparse
     * array for its saved state, so the temporary one we choose just needs to be consistent between
     * saving and restoring state.
     */
    private void setIdIfNoneExists(View view) {
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#setIdIfNoneExists().
//                                 display_name setIdIfNoneExists
//                                 signature_documentation java private void setIdIfNoneExists(unresolved_type view)
//                                 documentation  If a view hasn't had an id set we need to set a temporary one in order to save state, since a\n view won't save its state unless it has an id. The view's id is also the key into the sparse\n array for its saved state, so the temporary one we choose just needs to be consistent between\n saving and restoring state.\n
//                                 ^^^^ reference semanticdb maven . . View#
//                                      ^^^^ definition local 20
//                                           display_name view
//                                           signature_documentation java unresolved_type view
      if (view.getId() == View.NO_ID) {
//        ^^^^ reference local 20
//             ^^^^^ reference semanticdb maven . . View#getId#
//                        ^^^^ reference semanticdb maven . . View#
//                             ^^^^^ reference semanticdb maven . . View#NO_ID#
        view.setId(R.id.view_model_state_saving_id);
//      ^^^^ reference local 20
//           ^^^^^ reference semanticdb maven . . View#setId#
//                 ^ reference semanticdb maven . . R/
//                   ^^ reference semanticdb maven . . R/id#
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/id#view_model_state_saving_id#
      }
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public int describeContents() {
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#describeContents().
//                              display_name describeContents
//                              signature_documentation java @Override\npublic int describeContents()
      return 0;
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void writeToParcel(Parcel parcel, int flags) {
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#writeToParcel().
//                            display_name writeToParcel
//                            signature_documentation java @Override\npublic void writeToParcel(unresolved_type parcel, int flags)
//                            ^^^^^^ reference semanticdb maven . . Parcel#
//                                   ^^^^^^ definition local 21
//                                          display_name parcel
//                                          signature_documentation java unresolved_type parcel
//                                               ^^^^^ definition local 22
//                                                     display_name flags
//                                                     signature_documentation java int flags
      int size = size();
//        ^^^^ definition local 23
//             display_name size
//             signature_documentation java int size
//               ^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#size().
      int[] keys = new int[size];
//          ^^^^ definition local 24
//               display_name keys
//               signature_documentation java int[] keys
//                         ^^^^ reference local 23
      Parcelable[] values = new Parcelable[size];
//    ^^^^^^^^^^ reference semanticdb maven . . Parcelable#
//                 ^^^^^^ definition local 25
//                        display_name values
//                        signature_documentation java unresolved_type[] values
//                              ^^^^^^^^^^ reference semanticdb maven . . Parcelable#
//                                         ^^^^ reference local 23
      for (int i = 0; i < size; ++i) {
//             ^ definition local 26
//               display_name i
//               signature_documentation java int i
//                    ^ reference local 26
//                        ^^^^ reference local 23
//                                ^ reference local 26
        keys[i] = keyAt(i);
//      ^^^^ reference local 24
//           ^ reference local 26
//                ^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#keyAt().
//                      ^ reference local 26
        values[i] = valueAt(i);
//      ^^^^^^ reference local 25
//             ^ reference local 26
//                  ^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#valueAt().
//                          ^ reference local 26
      }
      parcel.writeInt(size);
//    ^^^^^^ reference local 21
//           ^^^^^^^^ reference semanticdb maven . . Parcel#writeInt#
//                    ^^^^ reference local 23
      parcel.writeIntArray(keys);
//    ^^^^^^ reference local 21
//           ^^^^^^^^^^^^^ reference semanticdb maven . . Parcel#writeIntArray#
//                         ^^^^ reference local 24
      parcel.writeParcelableArray(values, flags);
//    ^^^^^^ reference local 21
//           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . Parcel#writeParcelableArray#
//                                ^^^^^^ reference local 25
//                                        ^^^^^ reference local 22
    }

    public static final Creator<ViewState> CREATOR =
//                      ^^^^^^^ reference semanticdb maven . . Creator#
//                              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#
//                                         ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#CREATOR.
//                                                 display_name CREATOR
//                                                 signature_documentation java public static final unresolved_type CREATOR
        new Parcelable.ClassLoaderCreator<ViewState>() {
//          ^^^^^^^^^^ reference semanticdb maven . . Parcelable/
//                     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . Parcelable/ClassLoaderCreator#
//                                        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#
          @Override
          public ViewState createFromParcel(Parcel source, ClassLoader loader) {
            int size = source.readInt();
            int[] keys = new int[size];
            source.readIntArray(keys);
            Parcelable[] values = source.readParcelableArray(loader);
            return new ViewState(size, keys, values);
          }

          @Override
          public ViewState createFromParcel(Parcel source) {
            return createFromParcel(source, null);
          }

          @Override
          public ViewState[] newArray(int size) {
            return new ViewState[size];
          }
        };
  }
}
