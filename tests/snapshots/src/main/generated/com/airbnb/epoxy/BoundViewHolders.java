
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
//^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
public class BoundViewHolders implements Iterable<EpoxyViewHolder> {
//           ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders# @SuppressWarnings("WeakerAccess") public class BoundViewHolders
//           ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#`<init>`(). public BoundViewHolders()
//                                       ^^^^^^^^ reference java/lang/Iterable#
//                                                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
  private final LongSparseArray<EpoxyViewHolder> holders = new LongSparseArray<>();
//              ^^^^^^^^^^^^^^^ reference androidx/collection/LongSparseArray#
//                              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                               ^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#holders. private final LongSparseArray<EpoxyViewHolder> holders
//                                                             ^^^^^^^^^^^^^^^ reference androidx/collection/LongSparseArray#`<init>`().

  @Nullable
// ^^^^^^^^ reference androidx/annotation/Nullable#
  public EpoxyViewHolder get(EpoxyViewHolder holder) {
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^ definition com/airbnb/epoxy/BoundViewHolders#get(). @Nullable public EpoxyViewHolder get(EpoxyViewHolder holder)
//                           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                           ^^^^^^ definition local0 EpoxyViewHolder holder
    return holders.get(holder.getItemId());
//         ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//                 ^^^ reference androidx/collection/LongSparseArray#get().
//                     ^^^^^^ reference local0
//                            ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getItemId#
  }

  public void put(EpoxyViewHolder holder) {
//            ^^^ definition com/airbnb/epoxy/BoundViewHolders#put(). public void put(EpoxyViewHolder holder)
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                ^^^^^^ definition local1 EpoxyViewHolder holder
    holders.put(holder.getItemId(), holder);
//  ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//          ^^^ reference androidx/collection/LongSparseArray#put().
//              ^^^^^^ reference local1
//                     ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getItemId#
//                                  ^^^^^^ reference local1
  }

  public void remove(EpoxyViewHolder holder) {
//            ^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#remove(). public void remove(EpoxyViewHolder holder)
//                   ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                   ^^^^^^ definition local2 EpoxyViewHolder holder
    holders.remove(holder.getItemId());
//  ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//          ^^^^^^ reference androidx/collection/LongSparseArray#remove().
//                 ^^^^^^ reference local2
//                        ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getItemId#
  }

  public int size() {
//           ^^^^ definition com/airbnb/epoxy/BoundViewHolders#size(). public int size()
    return holders.size();
//         ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//                 ^^^^ reference androidx/collection/LongSparseArray#size().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public Iterator<EpoxyViewHolder> iterator() {
//       ^^^^^^^^ reference java/util/Iterator#
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                 ^^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#iterator(). @Override public Iterator<EpoxyViewHolder> iterator()
    return new HolderIterator();
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#HolderIterator#`<init>`().
  }

  @Nullable
// ^^^^^^^^ reference androidx/annotation/Nullable#
  public EpoxyViewHolder getHolderForModel(EpoxyModel<?> model) {
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#getHolderForModel(). @Nullable public EpoxyViewHolder getHolderForModel(EpoxyModel<?> model)
//                                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                       ^^^^^ definition local3 EpoxyModel<?> model
    return holders.get(model.id());
//         ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//                 ^^^ reference androidx/collection/LongSparseArray#get().
//                     ^^^^^ reference local3
//                           ^^ reference com/airbnb/epoxy/EpoxyModel#id().
  }

  private class HolderIterator implements Iterator<EpoxyViewHolder> {
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#HolderIterator# private class HolderIterator
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#HolderIterator#`<init>`(). private HolderIterator()
//                                        ^^^^^^^^ reference java/util/Iterator#
//                                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
    private int position = 0;
//              ^^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#HolderIterator#position. private int position

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public boolean hasNext() {
//                 ^^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#HolderIterator#hasNext(). @Override public boolean hasNext()
      return position < holders.size();
//           ^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#HolderIterator#position.
//                      ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//                              ^^^^ reference androidx/collection/LongSparseArray#size().
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public EpoxyViewHolder next() {
//         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                         ^^^^ definition com/airbnb/epoxy/BoundViewHolders#HolderIterator#next(). @Override public EpoxyViewHolder next()
      if (!hasNext()) {
//         ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#HolderIterator#hasNext().
        throw new NoSuchElementException();
//                ^^^^^^^^^^^^^^^^^^^^^^ reference java/util/NoSuchElementException#`<init>`().
      }
      return holders.valueAt(position++);
//           ^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#holders.
//                   ^^^^^^^ reference androidx/collection/LongSparseArray#valueAt().
//                           ^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#HolderIterator#position.
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void remove() {
//              ^^^^^^ definition com/airbnb/epoxy/BoundViewHolders#HolderIterator#remove(). @Override public void remove()
      throw new UnsupportedOperationException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/UnsupportedOperationException#`<init>`().
    }
  }
}
