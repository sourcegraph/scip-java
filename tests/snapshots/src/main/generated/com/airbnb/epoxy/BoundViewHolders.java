
package com.airbnb.epoxy;

import java.util.Iterator;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^ reference java/util/Iterator#
import java.util.NoSuchElementException;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^^^^^^^^^^^^ reference java/util/NoSuchElementException#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#
import androidx.collection.LongSparseArray;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/collection/
//                         ^^^^^^^^^^^^^^^ reference androidx/collection/LongSparseArray#

/** Helper class for keeping track of {@link EpoxyViewHolder}s that are currently bound. */
@SuppressWarnings("WeakerAccess")
 ^^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
public class BoundViewHolders implements Iterable<EpoxyViewHolder> {
//     ^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#`<init>`().
//     ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#
//                                       ^^^^^^^^ reference java/lang/Iterable#
//                                                ^^^^^^^^^^^^^^^ reference _root_/
  private final LongSparseArray<EpoxyViewHolder> holders = new LongSparseArray<>();
//              ^^^^^^^^^^^^^^^ reference androidx/collection/LongSparseArray#
//                              ^^^^^^^^^^^^^^^ reference _root_/
//                                               ^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#holders.
//                                                         ^^^^^^^^^^^^^^^^^^^^^^^ reference androidx/collection/LongSparseArray#`<init>`().
//                                                             ^^^^^^^^^^^^^^^ reference androidx/collection/LongSparseArray#

  @Nullable
   ^^^^^^^^ reference androidx/annotation/Nullable#
  public EpoxyViewHolder get(EpoxyViewHolder holder) {
//       ^^^^^^^^^^^^^^^ reference _root_/
//                       ^^^ definition com/airbnb/epoxy/BoundViewHolders#get().
//                           ^^^^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^ definition local0
    return holders.get(holder.getItemId());
//         ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//                 ^^^ reference androidx/collection/LongSparseArray#get().
//                     ^^^^^^ reference local0
//                            ^^^^^^^^^ reference getItemId#
  }

  public void put(EpoxyViewHolder holder) {
//            ^^^ definition com/airbnb/epoxy/BoundViewHolders#put().
//                ^^^^^^^^^^^^^^^ reference _root_/
//                                ^^^^^^ definition local1
    holders.put(holder.getItemId(), holder);
//  ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//          ^^^ reference androidx/collection/LongSparseArray#put().
//              ^^^^^^ reference local1
//                     ^^^^^^^^^ reference getItemId#
//                                  ^^^^^^ reference local1
  }

  public void remove(EpoxyViewHolder holder) {
//            ^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#remove().
//                   ^^^^^^^^^^^^^^^ reference _root_/
//                                   ^^^^^^ definition local2
    holders.remove(holder.getItemId());
//  ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//          ^^^^^^ reference androidx/collection/LongSparseArray#remove().
//                 ^^^^^^ reference local2
//                        ^^^^^^^^^ reference getItemId#
  }

  public int size() {
//           ^^^^ definition com/airbnb/epoxy/BoundViewHolders#size().
    return holders.size();
//         ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//                 ^^^^ reference androidx/collection/LongSparseArray#size().
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public Iterator<EpoxyViewHolder> iterator() {
//       ^^^^^^^^ reference java/util/Iterator#
//                ^^^^^^^^^^^^^^^ reference _root_/
//                                 ^^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#iterator().
    return new HolderIterator();
//         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#HolderIterator#`<init>`().
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#HolderIterator#
  }

  @Nullable
   ^^^^^^^^ reference androidx/annotation/Nullable#
  public EpoxyViewHolder getHolderForModel(EpoxyModel<?> model) {
//       ^^^^^^^^^^^^^^^ reference _root_/
//                       ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#getHolderForModel().
//                                         ^^^^^^^^^^ reference _root_/
//                                                       ^^^^^ definition local3
    return holders.get(model.id());
//         ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//                 ^^^ reference androidx/collection/LongSparseArray#get().
//                     ^^^^^ reference local3
//                           ^^ reference `<any>`#id#
  }

  private class HolderIterator implements Iterator<EpoxyViewHolder> {
//        ^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#HolderIterator#`<init>`().
//        ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#HolderIterator#
//                                        ^^^^^^^^ reference java/util/Iterator#
//                                                 ^^^^^^^^^^^^^^^ reference _root_/
    private int position = 0;
//              ^^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#HolderIterator#position.

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public boolean hasNext() {
//                 ^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#HolderIterator#hasNext().
      return position < holders.size();
//           ^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#HolderIterator#position.
//                      ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//                              ^^^^ reference androidx/collection/LongSparseArray#size().
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public EpoxyViewHolder next() {
//         ^^^^^^^^^^^^^^^ reference _root_/
//                         ^^^^ definition com/airbnb/epoxy/BoundViewHolders#HolderIterator#next().
      if (!hasNext()) {
//         ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#HolderIterator#hasNext().
        throw new NoSuchElementException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/NoSuchElementException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^ reference java/util/NoSuchElementException#
      }
      return holders.valueAt(position++);
//           ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//                   ^^^^^^^ reference androidx/collection/LongSparseArray#valueAt().
//                           ^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#HolderIterator#position.
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void remove() {
//              ^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#HolderIterator#remove().
      throw new UnsupportedOperationException();
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/UnsupportedOperationException#`<init>`().
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/UnsupportedOperationException#
    }
  }
}
