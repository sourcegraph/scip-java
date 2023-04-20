
package com.airbnb.epoxy;

import java.util.Iterator;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
import java.util.NoSuchElementException;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/NoSuchElementException#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.collection.LongSparseArray;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/collection/
//                         ^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#

/** Helper class for keeping track of {@link EpoxyViewHolder}s that are currently bound. */
@SuppressWarnings("WeakerAccess")
//^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
public class BoundViewHolders implements Iterable<EpoxyViewHolder> {
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#
//                            documentation ```java\n@SuppressWarnings("WeakerAccess")\npublic class BoundViewHolders\n```
//                            documentation Helper class for keeping track of {@link EpoxyViewHolder}s that are currently bound. 
//                            relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#`<init>`().
//                            documentation ```java\npublic BoundViewHolders()\n```
//                                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
  private final LongSparseArray<EpoxyViewHolder> holders = new LongSparseArray<>();
//              ^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                               ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//                                                       documentation ```java\nprivate final LongSparseArray<EpoxyViewHolder> holders\n```
//                                                             ^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#`<init>`().

  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  public EpoxyViewHolder get(EpoxyViewHolder holder) {
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#get().
//                           documentation ```java\n@Nullable\npublic EpoxyViewHolder get(EpoxyViewHolder holder)\n```
//                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                           ^^^^^^ definition local 0
//                                                  documentation ```java\nEpoxyViewHolder holder\n```
    return holders.get(holder.getItemId());
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//                 ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#get().
//                     ^^^^^^ reference local 0
//                            ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getItemId#
  }

  public void put(EpoxyViewHolder holder) {
//            ^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#put().
//                documentation ```java\npublic void put(EpoxyViewHolder holder)\n```
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                ^^^^^^ definition local 1
//                                       documentation ```java\nEpoxyViewHolder holder\n```
    holders.put(holder.getItemId(), holder);
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//          ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#put().
//              ^^^^^^ reference local 1
//                     ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getItemId#
//                                  ^^^^^^ reference local 1
  }

  public void remove(EpoxyViewHolder holder) {
//            ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#remove().
//                   documentation ```java\npublic void remove(EpoxyViewHolder holder)\n```
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                   ^^^^^^ definition local 2
//                                          documentation ```java\nEpoxyViewHolder holder\n```
    holders.remove(holder.getItemId());
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//          ^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#remove().
//                 ^^^^^^ reference local 2
//                        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getItemId#
  }

  public int size() {
//           ^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#size().
//                documentation ```java\npublic int size()\n```
    return holders.size();
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//                 ^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#size().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public Iterator<EpoxyViewHolder> iterator() {
//       ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                 ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#iterator().
//                                          documentation ```java\n@Override\npublic Iterator<EpoxyViewHolder> iterator()\n```
//                                          relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Iterable#iterator().
    return new HolderIterator();
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#`<init>`().
  }

  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  public EpoxyViewHolder getHolderForModel(EpoxyModel<?> model) {
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#getHolderForModel().
//                                         documentation ```java\n@Nullable\npublic EpoxyViewHolder getHolderForModel(EpoxyModel<?> model)\n```
//                                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                       ^^^^^ definition local 3
//                                                             documentation ```java\nEpoxyModel<?> model\n```
    return holders.get(model.id());
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//                 ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#get().
//                     ^^^^^ reference local 3
//                           ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
  }

  private class HolderIterator implements Iterator<EpoxyViewHolder> {
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#
//                             documentation ```java\nprivate class HolderIterator\n```
//                             relationship is_implementation semanticdb maven jdk 11 java/util/Iterator#
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#`<init>`().
//                             documentation ```java\nprivate HolderIterator()\n```
//                                        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
    private int position = 0;
//              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#position.
//                       documentation ```java\nprivate int position\n```

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public boolean hasNext() {
//                 ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#hasNext().
//                         documentation ```java\n@Override\npublic boolean hasNext()\n```
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Iterator#hasNext().
      return position < holders.size();
//           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#position.
//                      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//                              ^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#size().
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public EpoxyViewHolder next() {
//         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                         ^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#next().
//                              documentation ```java\n@Override\npublic EpoxyViewHolder next()\n```
//                              relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Iterator#next().
      if (!hasNext()) {
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#hasNext().
        throw new NoSuchElementException();
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/NoSuchElementException#`<init>`().
      }
      return holders.valueAt(position++);
//           ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//                   ^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#valueAt().
//                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#position.
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void remove() {
//              ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#remove().
//                     documentation ```java\n@Override\npublic void remove()\n```
//                     relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Iterator#remove().
      throw new UnsupportedOperationException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/UnsupportedOperationException#`<init>`().
    }
  }
}
