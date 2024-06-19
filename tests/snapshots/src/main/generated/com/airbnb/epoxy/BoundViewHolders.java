
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
//                            display_name BoundViewHolders
//                            signature_documentation java @SuppressWarnings("WeakerAccess")\npublic class BoundViewHolders
//                            kind Class
//                            documentation Helper class for keeping track of {@link EpoxyViewHolder}s that are currently bound. 
//                            relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#`<init>`().
//                            display_name <init>
//                            signature_documentation java public BoundViewHolders()
//                            kind Constructor
//                                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
  private final LongSparseArray<EpoxyViewHolder> holders = new LongSparseArray<>();
//              ^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                               ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//                                                       display_name holders
//                                                       signature_documentation java private final LongSparseArray<EpoxyViewHolder> holders
//                                                       kind Field
//                                                             ^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#`<init>`().

  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  public EpoxyViewHolder get(EpoxyViewHolder holder) {
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#get().
//                           display_name get
//                           signature_documentation java @Nullable\npublic EpoxyViewHolder get(EpoxyViewHolder holder)
//                           kind Method
//                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                           ^^^^^^ definition local 0
//                                                  display_name holder
//                                                  signature_documentation java EpoxyViewHolder holder
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#get().
    return holders.get(holder.getItemId());
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//                 ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#get().
//                     ^^^^^^ reference local 0
//                            ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getItemId#
  }

  public void put(EpoxyViewHolder holder) {
//            ^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#put().
//                display_name put
//                signature_documentation java public void put(EpoxyViewHolder holder)
//                kind Method
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                ^^^^^^ definition local 1
//                                       display_name holder
//                                       signature_documentation java EpoxyViewHolder holder
//                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#put().
    holders.put(holder.getItemId(), holder);
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//          ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#put().
//              ^^^^^^ reference local 1
//                     ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getItemId#
//                                  ^^^^^^ reference local 1
  }

  public void remove(EpoxyViewHolder holder) {
//            ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#remove().
//                   display_name remove
//                   signature_documentation java public void remove(EpoxyViewHolder holder)
//                   kind Method
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                   ^^^^^^ definition local 2
//                                          display_name holder
//                                          signature_documentation java EpoxyViewHolder holder
//                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#remove().
    holders.remove(holder.getItemId());
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//          ^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#remove().
//                 ^^^^^^ reference local 2
//                        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getItemId#
  }

  public int size() {
//           ^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#size().
//                display_name size
//                signature_documentation java public int size()
//                kind Method
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
//                                          display_name iterator
//                                          signature_documentation java @Override\npublic Iterator<EpoxyViewHolder> iterator()
//                                          kind Method
//                                          relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Iterable#iterator().
    return new HolderIterator();
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#`<init>`().
  }

  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  public EpoxyViewHolder getHolderForModel(EpoxyModel<?> model) {
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#getHolderForModel().
//                                         display_name getHolderForModel
//                                         signature_documentation java @Nullable\npublic EpoxyViewHolder getHolderForModel(EpoxyModel<?> model)
//                                         kind Method
//                                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                       ^^^^^ definition local 3
//                                                             display_name model
//                                                             signature_documentation java EpoxyModel<?> model
//                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#getHolderForModel().
    return holders.get(model.id());
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#holders.
//                 ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#get().
//                     ^^^^^ reference local 3
//                           ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
  }

  private class HolderIterator implements Iterator<EpoxyViewHolder> {
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#
//                             display_name HolderIterator
//                             signature_documentation java private class HolderIterator
//                             kind Class
//                             relationship is_implementation semanticdb maven jdk 11 java/util/Iterator#
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#`<init>`().
//                             display_name <init>
//                             signature_documentation java private HolderIterator()
//                             kind Constructor
//                                        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
    private int position = 0;
//              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#position.
//                       display_name position
//                       signature_documentation java private int position
//                       kind Field

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public boolean hasNext() {
//                 ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#HolderIterator#hasNext().
//                         display_name hasNext
//                         signature_documentation java @Override\npublic boolean hasNext()
//                         kind Method
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
//                              display_name next
//                              signature_documentation java @Override\npublic EpoxyViewHolder next()
//                              kind Method
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
//                     display_name remove
//                     signature_documentation java @Override\npublic void remove()
//                     kind Method
//                     relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Iterator#remove().
      throw new UnsupportedOperationException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/UnsupportedOperationException#`<init>`().
    }
  }
}
