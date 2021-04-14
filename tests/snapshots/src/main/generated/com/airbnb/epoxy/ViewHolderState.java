
package com.airbnb.epoxy;

import android.os.Parcel;
//     ^^^^^^^ reference android/
//             ^^ reference android/os/
//                ^^^^^^ reference android/os/Parcel#
import android.os.Parcelable;
//     ^^^^^^^ reference android/
//             ^^ reference android/os/
//                ^^^^^^^^^^ reference android/os/Parcelable#
import android.util.SparseArray;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/util/
//                  ^^^^^^^^^^^ reference android/util/SparseArray#
import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#

import com.airbnb.epoxy.ViewHolderState.ViewState;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#
//                                      ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
import com.airbnb.viewmodeladapter.R;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^^^^^^^^^^^^ reference com/airbnb/viewmodeladapter/
//                                 ^ reference com/airbnb/viewmodeladapter/R#

import java.util.Collection;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^ reference java/util/Collection#

import androidx.collection.LongSparseArray;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/collection/
//                         ^^^^^^^^^^^^^^^ reference androidx/collection/LongSparseArray#

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
//^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
class ViewHolderState extends LongSparseArray<ViewState> implements Parcelable {
//    ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewHolderState# class ViewHolderState extends LongSparseArray<ViewState> implements unresolved_type
//                            ^^^^^^^^^^^^^^^ reference androidx/collection/LongSparseArray#
//                                            ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//                                                                  ^^^^^^^^^^ reference _root_/
  ViewHolderState() {
//^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#`<init>`(). ViewHolderState()
  }

  private ViewHolderState(int size) {
//        ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#`<init>`(+1). private ViewHolderState(int size)
//                            ^^^^ definition local0 int size
    super(size);
//  ^^^^^ reference androidx/collection/LongSparseArray#`<init>`(+1).
//        ^^^^ reference local0
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public int describeContents() {
//           ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#describeContents(). public int describeContents()
    return 0;
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void writeToParcel(Parcel dest, int flags) {
//            ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#writeToParcel(). public void writeToParcel(unresolved_type dest, int flags)
//                          ^^^^^^ reference _root_/
//                                 ^^^^ definition local1 unresolved_type dest
//                                           ^^^^^ definition local2 int flags
    final int size = size();
//            ^^^^ definition local3 final int size
//                   ^^^^ reference androidx/collection/LongSparseArray#size().
    dest.writeInt(size);
//  ^^^^ reference local1
//       ^^^^^^^^ reference writeInt#
//                ^^^^ reference local3
    for (int i = 0; i < size; i++) {
//           ^ definition local4 int i
//                  ^ reference local4
//                      ^^^^ reference local3
//                            ^ reference local4
      dest.writeLong(keyAt(i));
//    ^^^^ reference local1
//         ^^^^^^^^^ reference writeLong#
//                   ^^^^^ reference androidx/collection/LongSparseArray#keyAt().
//                         ^ reference local4
      dest.writeParcelable(valueAt(i), 0);
//    ^^^^ reference local1
//         ^^^^^^^^^^^^^^^ reference writeParcelable#
//                         ^^^^^^^ reference androidx/collection/LongSparseArray#valueAt().
//                                 ^ reference local4
    }
  }

  public static final Creator<ViewHolderState> CREATOR = new Creator<ViewHolderState>() {
//                    ^^^^^^^ reference _root_/
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#
//                                             ^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#CREATOR. public static final unresolved_type CREATOR
//                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference `<any>`#`<init>`# 18:3
//                                                           ^^^^^^^ reference _root_/
//                                                           ^^^^^^^ reference _root_/
//                                                                   ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#
//                                                                   ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#

    public ViewHolderState[] newArray(int size) {
//         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#
//                           ^^^^^^^^ definition local6 public ViewHolderState[] newArray(int size)
//                                        ^^^^ definition local8 int size
      return new ViewHolderState[size];
//               ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#
//                               ^^^^ reference local8
    }

    public ViewHolderState createFromParcel(Parcel source) {
//         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#
//                         ^^^^^^^^^^^^^^^^ definition local7 public ViewHolderState createFromParcel(unresolved_type source)
//                                          ^^^^^^ reference _root_/
//                                                 ^^^^^^ definition local9 unresolved_type source
      int size = source.readInt();
//        ^^^^ definition local10 int size
//               ^^^^^^ reference local9
//                      ^^^^^^^ reference readInt#
      ViewHolderState state = new ViewHolderState(size);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#
//                    ^^^^^ definition local11 ViewHolderState state
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#`<init>`(+1).
//                                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#
//                                                ^^^^ reference local10

      for (int i = 0; i < size; i++) {
//             ^ definition local12 int i
//                    ^ reference local12
//                        ^^^^ reference local10
//                              ^ reference local12
        long key = source.readLong();
//           ^^^ definition local13 long key
//                 ^^^^^^ reference local9
//                        ^^^^^^^^ reference readLong#
        ViewState value = source.readParcelable(ViewState.class.getClassLoader());
//      ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//                ^^^^^ definition local14 ViewState value
//                        ^^^^^^ reference local9
//                               ^^^^^^^^^^^^^^ reference readParcelable#
//                                              ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//                                                        ^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#class.
//                                                              ^^^^^^^^^^^^^^ reference java/lang/Class#getClassLoader().
        state.put(key, value);
//      ^^^^^ reference local11
//            ^^^ reference androidx/collection/LongSparseArray#put().
//                ^^^ reference local13
//                     ^^^^^ reference local14
      }

      return state;
//           ^^^^^ reference local11
    }
  };

  public boolean hasStateForHolder(EpoxyViewHolder holder) {
//               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#hasStateForHolder(). public boolean hasStateForHolder(EpoxyViewHolder holder)
//                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^ definition local15 EpoxyViewHolder holder
    return get(holder.getItemId()) != null;
//         ^^^ reference androidx/collection/LongSparseArray#get().
//             ^^^^^^ reference local15
//                    ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getItemId#
  }

  public void save(Collection<EpoxyViewHolder> holders) {
//            ^^^^ definition com/airbnb/epoxy/ViewHolderState#save(). public void save(Collection<EpoxyViewHolder> holders)
//                 ^^^^^^^^^^ reference java/util/Collection#
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                             ^^^^^^^ definition local16 Collection<EpoxyViewHolder> holders
    for (EpoxyViewHolder holder : holders) {
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^^^^ definition local17 EpoxyViewHolder holder
//                                ^^^^^^^ reference local16
      save(holder);
//    ^^^^ reference com/airbnb/epoxy/ViewHolderState#save(+1).
//         ^^^^^^ reference local17
    }
  }

  /** Save the state of the view bound to the given holder. */
  public void save(EpoxyViewHolder holder) {
//            ^^^^ definition com/airbnb/epoxy/ViewHolderState#save(+1). public void save(EpoxyViewHolder holder)
//                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                 ^^^^^^ definition local18 EpoxyViewHolder holder
    if (!holder.getModel().shouldSaveViewState()) {
//       ^^^^^^ reference local18
//              ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                         ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#shouldSaveViewState().
      return;
    }

    // Reuse the previous sparse array if available. We shouldn't need to clear it since the
    // exact same view type is being saved to it, which
    // should have identical ids for all its views, and will just overwrite the previous state.
    ViewState state = get(holder.getItemId());
//  ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//            ^^^^^ definition local19 ViewState state
//                    ^^^ reference androidx/collection/LongSparseArray#get().
//                        ^^^^^^ reference local18
//                               ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getItemId#
    if (state == null) {
//      ^^^^^ reference local19
      state = new ViewState();
//    ^^^^^ reference local19
//            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#`<init>`().
//                ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
    }

    state.save(holder.itemView);
//  ^^^^^ reference local19
//        ^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#save().
//             ^^^^^^ reference local18
//                    ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
    put(holder.getItemId(), state);
//  ^^^ reference androidx/collection/LongSparseArray#put().
//      ^^^^^^ reference local18
//             ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getItemId#
//                          ^^^^^ reference local19
  }

  /**
   * If a state was previously saved for this view holder via {@link #save} it will be restored
   * here.
   */
  public void restore(EpoxyViewHolder holder) {
//            ^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#restore(). public void restore(EpoxyViewHolder holder)
//                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                    ^^^^^^ definition local20 EpoxyViewHolder holder
    if (!holder.getModel().shouldSaveViewState()) {
//       ^^^^^^ reference local20
//              ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                         ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#shouldSaveViewState().
      return;
    }

    ViewState state = get(holder.getItemId());
//  ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//            ^^^^^ definition local21 ViewState state
//                    ^^^ reference androidx/collection/LongSparseArray#get().
//                        ^^^^^^ reference local20
//                               ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getItemId#
    if (state != null) {
//      ^^^^^ reference local21
      state.restore(holder.itemView);
//    ^^^^^ reference local21
//          ^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#restore().
//                  ^^^^^^ reference local20
//                         ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
    } else {
      // The first time a model is bound it won't have previous state. We need to make sure
      // the view is reset to its initial state to clear any changes from previously bound models
      holder.restoreInitialViewState();
//    ^^^^^^ reference local20
//           ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#restoreInitialViewState().
    }
  }

  /**
   * A wrapper around a sparse array as a helper to save the state of a view. This also adds
   * parcelable support.
   */
  public static class ViewState extends SparseArray<Parcelable> implements Parcelable {
//                    ^^^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#ViewState# public static class ViewState extends unresolved_type implements unresolved_type
//                                      ^^^^^^^^^^^ reference _root_/
//                                                  ^^^^^^^^^^ reference _root_/
//                                                                         ^^^^^^^^^^ reference _root_/

    ViewState() {
//  ^^^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#ViewState#`<init>`(). ViewState()
    }

    private ViewState(int size, int[] keys, Parcelable[] values) {
//          ^^^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#ViewState#`<init>`(+1). private ViewState(int size, int[] keys, unresolved_type[] values)
//                        ^^^^ definition local22 int size
//                                    ^^^^ definition local23 int[] keys
//                                          ^^^^^^^^^^ reference _root_/
//                                                       ^^^^^^ definition local24 unresolved_type[] values
      super(size);
//          ^^^^ reference local22
      for (int i = 0; i < size; ++i) {
//             ^ definition local25 int i
//                    ^ reference local25
//                        ^^^^ reference local22
//                                ^ reference local25
        put(keys[i], values[i]);
//      ^^^ reference androidx/collection/LongSparseArray#put().
//          ^^^^ reference local23
//               ^ reference local25
//                   ^^^^^^ reference local24
//                          ^ reference local25
      }
    }

    public void save(View view) {
//              ^^^^ definition com/airbnb/epoxy/ViewHolderState#ViewState#save(). public void save(unresolved_type view)
//                   ^^^^ reference _root_/
//                        ^^^^ definition local26 unresolved_type view
      int originalId = view.getId();
//        ^^^^^^^^^^ definition local27 int originalId
//                     ^^^^ reference local26
//                          ^^^^^ reference getId#
      setIdIfNoneExists(view);
//    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#setIdIfNoneExists().
//                      ^^^^ reference local26

      view.saveHierarchyState(this);
//    ^^^^ reference local26
//         ^^^^^^^^^^^^^^^^^^ reference saveHierarchyState#
//                            ^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
      view.setId(originalId);
//    ^^^^ reference local26
//         ^^^^^ reference setId#
//               ^^^^^^^^^^ reference local27
    }

    public void restore(View view) {
//              ^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#ViewState#restore(). public void restore(unresolved_type view)
//                      ^^^^ reference _root_/
//                           ^^^^ definition local28 unresolved_type view
      int originalId = view.getId();
//        ^^^^^^^^^^ definition local29 int originalId
//                     ^^^^ reference local28
//                          ^^^^^ reference getId#
      setIdIfNoneExists(view);
//    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#setIdIfNoneExists().
//                      ^^^^ reference local28

      view.restoreHierarchyState(this);
//    ^^^^ reference local28
//         ^^^^^^^^^^^^^^^^^^^^^ reference restoreHierarchyState#
//                               ^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
      view.setId(originalId);
//    ^^^^ reference local28
//         ^^^^^ reference setId#
//               ^^^^^^^^^^ reference local29
    }

    /**
     * If a view hasn't had an id set we need to set a temporary one in order to save state, since a
     * view won't save its state unless it has an id. The view's id is also the key into the sparse
     * array for its saved state, so the temporary one we choose just needs to be consistent between
     * saving and restoring state.
     */
    private void setIdIfNoneExists(View view) {
//               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#ViewState#setIdIfNoneExists(). private void setIdIfNoneExists(unresolved_type view)
//                                 ^^^^ reference _root_/
//                                      ^^^^ definition local30 unresolved_type view
      if (view.getId() == View.NO_ID) {
//        ^^^^ reference local30
//             ^^^^^ reference getId#
//                        ^^^^ reference _root_/
//                             ^^^^^ reference NO_ID#
        view.setId(R.id.view_model_state_saving_id);
//      ^^^^ reference local30
//           ^^^^^ reference setId#
//                 ^ reference R/
//                   ^^ reference R/id#
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference R/id#view_model_state_saving_id#
      }
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public int describeContents() {
//             ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#ViewState#describeContents(). public int describeContents()
      return 0;
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void writeToParcel(Parcel parcel, int flags) {
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#ViewState#writeToParcel(). public void writeToParcel(unresolved_type parcel, int flags)
//                            ^^^^^^ reference _root_/
//                                   ^^^^^^ definition local31 unresolved_type parcel
//                                               ^^^^^ definition local32 int flags
      int size = size();
//        ^^^^ definition local33 int size
//               ^^^^ reference androidx/collection/LongSparseArray#size().
      int[] keys = new int[size];
//          ^^^^ definition local34 int[] keys
//                         ^^^^ reference local33
      Parcelable[] values = new Parcelable[size];
//    ^^^^^^^^^^ reference _root_/
//                 ^^^^^^ definition local35 unresolved_type[] values
//                              ^^^^^^^^^^ reference _root_/
//                                         ^^^^ reference local33
      for (int i = 0; i < size; ++i) {
//             ^ definition local36 int i
//                    ^ reference local36
//                        ^^^^ reference local33
//                                ^ reference local36
        keys[i] = keyAt(i);
//      ^^^^ reference local34
//           ^ reference local36
//                ^^^^^ reference androidx/collection/LongSparseArray#keyAt().
//                      ^ reference local36
        values[i] = valueAt(i);
//      ^^^^^^ reference local35
//             ^ reference local36
//                  ^^^^^^^ reference androidx/collection/LongSparseArray#valueAt().
//                          ^ reference local36
      }
      parcel.writeInt(size);
//    ^^^^^^ reference local31
//           ^^^^^^^^ reference writeInt#
//                    ^^^^ reference local33
      parcel.writeIntArray(keys);
//    ^^^^^^ reference local31
//           ^^^^^^^^^^^^^ reference writeIntArray#
//                         ^^^^ reference local34
      parcel.writeParcelableArray(values, flags);
//    ^^^^^^ reference local31
//           ^^^^^^^^^^^^^^^^^^^^ reference writeParcelableArray#
//                                ^^^^^^ reference local35
//                                        ^^^^^ reference local32
    }

    public static final Creator<ViewState> CREATOR =
//                      ^^^^^^^ reference _root_/
//                              ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//                                         ^^^^^^^ definition com/airbnb/epoxy/ViewHolderState#ViewState#CREATOR. public static final unresolved_type CREATOR
        new Parcelable.ClassLoaderCreator<ViewState>() {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference `<any>`#`<init>`# 19:9
//          ^^^^^^^^^^ reference Parcelable/
//          ^^^^^^^^^^ reference Parcelable/
//                     ^^^^^^^^^^^^^^^^^^ reference Parcelable/ClassLoaderCreator#
//                     ^^^^^^^^^^^^^^^^^^ reference Parcelable/ClassLoaderCreator#
//                                        ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//                                        ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
          @Override
//         ^^^^^^^^ reference java/lang/Override#
          public ViewState createFromParcel(Parcel source, ClassLoader loader) {
//               ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//                         ^^^^^^^^^^^^^^^^ definition local38 public ViewState createFromParcel(unresolved_type source, ClassLoader loader)
//                                          ^^^^^^ reference _root_/
//                                                 ^^^^^^ definition local41 unresolved_type source
//                                                         ^^^^^^^^^^^ reference java/lang/ClassLoader#
//                                                                     ^^^^^^ definition local42 ClassLoader loader
            int size = source.readInt();
//              ^^^^ definition local43 int size
//                     ^^^^^^ reference local41
//                            ^^^^^^^ reference readInt#
            int[] keys = new int[size];
//                ^^^^ definition local44 int[] keys
//                               ^^^^ reference local43
            source.readIntArray(keys);
//          ^^^^^^ reference local41
//                 ^^^^^^^^^^^^ reference readIntArray#
//                              ^^^^ reference local44
            Parcelable[] values = source.readParcelableArray(loader);
//          ^^^^^^^^^^ reference _root_/
//                       ^^^^^^ definition local45 unresolved_type[] values
//                                ^^^^^^ reference local41
//                                       ^^^^^^^^^^^^^^^^^^^ reference readParcelableArray#
//                                                           ^^^^^^ reference local42
            return new ViewState(size, keys, values);
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#`<init>`(+1).
//                     ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//                               ^^^^ reference local43
//                                     ^^^^ reference local44
//                                           ^^^^^^ reference local45
          }

          @Override
//         ^^^^^^^^ reference java/lang/Override#
          public ViewState createFromParcel(Parcel source) {
//               ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//                         ^^^^^^^^^^^^^^^^ definition local39 public ViewState createFromParcel(unresolved_type source)
//                                          ^^^^^^ reference _root_/
//                                                 ^^^^^^ definition local46 unresolved_type source
            return createFromParcel(source, null);
//                 ^^^^^^^^^^^^^^^^ reference local38
//                                  ^^^^^^ reference local46
          }

          @Override
//         ^^^^^^^^ reference java/lang/Override#
          public ViewState[] newArray(int size) {
//               ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//                           ^^^^^^^^ definition local40 public ViewState[] newArray(int size)
//                                        ^^^^ definition local47 int size
            return new ViewState[size];
//                     ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//                               ^^^^ reference local47
          }
        };
  }
}
