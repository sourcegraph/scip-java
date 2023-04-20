package com.airbnb.epoxy;

import com.airbnb.epoxy.UpdateOp.Type;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                               ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#Type#

import java.util.ArrayList;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#

import static com.airbnb.epoxy.UpdateOp.ADD;
//            ^^^ reference semanticdb maven . . com/
//                ^^^^^^ reference semanticdb maven . . com/airbnb/
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
import static com.airbnb.epoxy.UpdateOp.MOVE;
//            ^^^ reference semanticdb maven . . com/
//                ^^^^^^ reference semanticdb maven . . com/airbnb/
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
import static com.airbnb.epoxy.UpdateOp.REMOVE;
//            ^^^ reference semanticdb maven . . com/
//                ^^^^^^ reference semanticdb maven . . com/airbnb/
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
import static com.airbnb.epoxy.UpdateOp.UPDATE;
//            ^^^ reference semanticdb maven . . com/
//                ^^^^^^ reference semanticdb maven . . com/airbnb/
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#

/** Helper class to collect changes in a diff, batching when possible. */
class UpdateOpHelper {
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#
//                   documentation ```java\nclass UpdateOpHelper\n```
//                   documentation Helper class to collect changes in a diff, batching when possible. 
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#`<init>`().
//                   documentation ```java\nUpdateOpHelper()\n```
  final List<UpdateOp> opList = new ArrayList<>();
//      ^^^^ reference semanticdb maven jdk 11 java/util/List#
//           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#opList.
//                            documentation ```java\nfinal List<UpdateOp> opList\n```
//                                  ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+1).
  // We have to be careful to update all item positions in the list when we
  // do a MOVE. This adds some complexity.
  // To do this we keep track of all moves and apply them to an item when we
  // need the up to date position
  final List<UpdateOp> moves = new ArrayList<>();
//      ^^^^ reference semanticdb maven jdk 11 java/util/List#
//           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                     ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#moves.
//                           documentation ```java\nfinal List<UpdateOp> moves\n```
//                                 ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+1).
  private UpdateOp lastOp;
//        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                 ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                        documentation ```java\nprivate UpdateOp lastOp\n```
  private int numInsertions;
//            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertions.
//                          documentation ```java\nprivate int numInsertions\n```
  private int numInsertionBatches;
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertionBatches.
//                                documentation ```java\nprivate int numInsertionBatches\n```
  private int numRemovals;
//            ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovals.
//                        documentation ```java\nprivate int numRemovals\n```
  private int numRemovalBatches;
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovalBatches.
//                              documentation ```java\nprivate int numRemovalBatches\n```

  void reset() {
//     ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#reset().
//           documentation ```java\nvoid reset()\n```
    opList.clear();
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#opList.
//         ^^^^^ reference semanticdb maven jdk 11 java/util/List#clear().
    moves.clear();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#moves.
//        ^^^^^ reference semanticdb maven jdk 11 java/util/List#clear().
    lastOp = null;
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
    numInsertions = 0;
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertions.
    numInsertionBatches = 0;
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertionBatches.
    numRemovals = 0;
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovals.
    numRemovalBatches = 0;
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovalBatches.
  }

  void add(int indexToInsert) {
//     ^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#add().
//         documentation ```java\nvoid add(int indexToInsert)\n```
//             ^^^^^^^^^^^^^ definition local 0
//                           documentation ```java\nint indexToInsert\n```
    add(indexToInsert, 1);
//  ^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#add(+1).
//      ^^^^^^^^^^^^^ reference local 0
  }

  void add(int startPosition, int itemCount) {
//     ^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#add(+1).
//         documentation ```java\nvoid add(int startPosition, int itemCount)\n```
//             ^^^^^^^^^^^^^ definition local 1
//                           documentation ```java\nint startPosition\n```
//                                ^^^^^^^^^ definition local 2
//                                          documentation ```java\nint itemCount\n```
    numInsertions += itemCount;
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertions.
//                   ^^^^^^^^^ reference local 2

    // We can append to a previously ADD batch if the new items are added anywhere in the
    // range of the previous batch batch
    boolean batchWithLast = isLastOp(ADD)
//          ^^^^^^^^^^^^^ definition local 3
//                        documentation ```java\nboolean batchWithLast\n```
//                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#isLastOp().
//                                   ^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#ADD.
        && (lastOp.contains(startPosition) || lastOp.positionEnd() == startPosition);
//          ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#contains().
//                          ^^^^^^^^^^^^^ reference local 1
//                                            ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                                                   ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionEnd().
//                                                                    ^^^^^^^^^^^^^ reference local 1

    if (batchWithLast) {
//      ^^^^^^^^^^^^^ reference local 3
      addItemsToLastOperation(itemCount, null);
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addItemsToLastOperation().
//                            ^^^^^^^^^ reference local 2
    } else {
      numInsertionBatches++;
//    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertionBatches.
      addNewOperation(ADD, startPosition, itemCount);
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addNewOperation().
//                    ^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#ADD.
//                         ^^^^^^^^^^^^^ reference local 1
//                                        ^^^^^^^^^ reference local 2
    }
  }

  void update(int indexToChange) {
//     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#update().
//            documentation ```java\nvoid update(int indexToChange)\n```
//                ^^^^^^^^^^^^^ definition local 4
//                              documentation ```java\nint indexToChange\n```
    update(indexToChange, null);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#update(+1).
//         ^^^^^^^^^^^^^ reference local 4
  }

  void update(final int indexToChange, EpoxyModel<?> payload) {
//     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#update(+1).
//            documentation ```java\nvoid update(int indexToChange, EpoxyModel<?> payload)\n```
//                      ^^^^^^^^^^^^^ definition local 5
//                                    documentation ```java\nfinal int indexToChange\n```
//                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                   ^^^^^^^ definition local 6
//                                                           documentation ```java\nEpoxyModel<?> payload\n```
    if (isLastOp(UPDATE)) {
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#isLastOp().
//               ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#UPDATE.
      if (lastOp.positionStart == indexToChange + 1) {
//        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                                ^^^^^^^^^^^^^ reference local 5
        // Change another item at the start of the batch range
        addItemsToLastOperation(1, payload);
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addItemsToLastOperation().
//                                 ^^^^^^^ reference local 6
        lastOp.positionStart = indexToChange;
//      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                             ^^^^^^^^^^^^^ reference local 5
      } else if (lastOp.positionEnd() == indexToChange) {
//               ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionEnd().
//                                       ^^^^^^^^^^^^^ reference local 5
        // Add another item at the end of the batch range
        addItemsToLastOperation(1, payload);
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addItemsToLastOperation().
//                                 ^^^^^^^ reference local 6
      } else if (lastOp.contains(indexToChange)) {
//               ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#contains().
//                               ^^^^^^^^^^^^^ reference local 5
        // This item is already included in the existing batch range, so we don't add any items
        // to the batch count, but we still need to add the new payload
        addItemsToLastOperation(0, payload);
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addItemsToLastOperation().
//                                 ^^^^^^^ reference local 6
      } else {
        // The item can't be batched with the previous update operation
        addNewOperation(UPDATE, indexToChange, 1, payload);
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addNewOperation(+1).
//                      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#UPDATE.
//                              ^^^^^^^^^^^^^ reference local 5
//                                                ^^^^^^^ reference local 6
      }
    } else {
      addNewOperation(UPDATE, indexToChange, 1, payload);
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addNewOperation(+1).
//                    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#UPDATE.
//                            ^^^^^^^^^^^^^ reference local 5
//                                              ^^^^^^^ reference local 6
    }
  }

  void remove(int indexToRemove) {
//     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#remove().
//            documentation ```java\nvoid remove(int indexToRemove)\n```
//                ^^^^^^^^^^^^^ definition local 7
//                              documentation ```java\nint indexToRemove\n```
    remove(indexToRemove, 1);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#remove(+1).
//         ^^^^^^^^^^^^^ reference local 7
  }

  void remove(int startPosition, int itemCount) {
//     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#remove(+1).
//            documentation ```java\nvoid remove(int startPosition, int itemCount)\n```
//                ^^^^^^^^^^^^^ definition local 8
//                              documentation ```java\nint startPosition\n```
//                                   ^^^^^^^^^ definition local 9
//                                             documentation ```java\nint itemCount\n```
    numRemovals += itemCount;
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovals.
//                 ^^^^^^^^^ reference local 9

    boolean batchWithLast = false;
//          ^^^^^^^^^^^^^ definition local 10
//                        documentation ```java\nboolean batchWithLast\n```
    if (isLastOp(REMOVE)) {
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#isLastOp().
//               ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#REMOVE.
      if (lastOp.positionStart == startPosition) {
//        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                                ^^^^^^^^^^^^^ reference local 8
        // Remove additional items at the end of the batch range
        batchWithLast = true;
//      ^^^^^^^^^^^^^ reference local 10
      } else if (lastOp.isAfter(startPosition)
//               ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#isAfter().
//                              ^^^^^^^^^^^^^ reference local 8
          && startPosition + itemCount >= lastOp.positionStart) {
//           ^^^^^^^^^^^^^ reference local 8
//                           ^^^^^^^^^ reference local 9
//                                        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                                               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
        // Removes additional items at the start and (possibly) end of the batch
        lastOp.positionStart = startPosition;
//      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//             ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                             ^^^^^^^^^^^^^ reference local 8
        batchWithLast = true;
//      ^^^^^^^^^^^^^ reference local 10
      }
    }

    if (batchWithLast) {
//      ^^^^^^^^^^^^^ reference local 10
      addItemsToLastOperation(itemCount, null);
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addItemsToLastOperation().
//                            ^^^^^^^^^ reference local 9
    } else {
      numRemovalBatches++;
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovalBatches.
      addNewOperation(REMOVE, startPosition, itemCount);
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addNewOperation().
//                    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#REMOVE.
//                            ^^^^^^^^^^^^^ reference local 8
//                                           ^^^^^^^^^ reference local 9
    }
  }

  private boolean isLastOp(@UpdateOp.Type int updateType) {
//                ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#isLastOp().
//                         documentation ```java\nprivate boolean isLastOp(int updateType)\n```
//                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                                   ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#Type#
//                                            ^^^^^^^^^^ definition local 11
//                                                       documentation ```java\n@Type\nint updateType\n```
    return lastOp != null && lastOp.type == updateType;
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                                  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#type.
//                                          ^^^^^^^^^^ reference local 11
  }

  private void addNewOperation(@Type int type, int position, int itemCount) {
//             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addNewOperation().
//                             documentation ```java\nprivate void addNewOperation(int type, int position, int itemCount)\n```
//                              ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#Type#
//                                       ^^^^ definition local 12
//                                            documentation ```java\n@Type\nint type\n```
//                                                 ^^^^^^^^ definition local 13
//                                                          documentation ```java\nint position\n```
//                                                               ^^^^^^^^^ definition local 14
//                                                                         documentation ```java\nint itemCount\n```
    addNewOperation(type, position, itemCount, null);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addNewOperation(+1).
//                  ^^^^ reference local 12
//                        ^^^^^^^^ reference local 13
//                                  ^^^^^^^^^ reference local 14
  }

  private void addNewOperation(@Type int type, int position, int itemCount,
//             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addNewOperation(+1).
//                             documentation ```java\nprivate void addNewOperation(int type, int position, int itemCount, EpoxyModel<?> payload)\n```
//                              ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#Type#
//                                       ^^^^ definition local 15
//                                            documentation ```java\n@Type\nint type\n```
//                                                 ^^^^^^^^ definition local 16
//                                                          documentation ```java\nint position\n```
//                                                               ^^^^^^^^^ definition local 17
//                                                                         documentation ```java\nint itemCount\n```
      @Nullable EpoxyModel<?> payload) {
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^ definition local 18
//                                    documentation ```java\n@Nullable\nEpoxyModel<?> payload\n```
    lastOp = UpdateOp.instance(type, position, itemCount, payload);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#instance().
//                             ^^^^ reference local 15
//                                   ^^^^^^^^ reference local 16
//                                             ^^^^^^^^^ reference local 17
//                                                        ^^^^^^^ reference local 18
    opList.add(lastOp);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#opList.
//         ^^^ reference semanticdb maven jdk 11 java/util/List#add().
//             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
  }

  private void addItemsToLastOperation(int numItemsToAdd, EpoxyModel<?> payload) {
//             ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addItemsToLastOperation().
//                                     documentation ```java\nprivate void addItemsToLastOperation(int numItemsToAdd, EpoxyModel<?> payload)\n```
//                                         ^^^^^^^^^^^^^ definition local 19
//                                                       documentation ```java\nint numItemsToAdd\n```
//                                                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                      ^^^^^^^ definition local 20
//                                                                              documentation ```java\nEpoxyModel<?> payload\n```
    lastOp.itemCount += numItemsToAdd;
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.
//                      ^^^^^^^^^^^^^ reference local 19
    lastOp.addPayload(payload);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#addPayload().
//                    ^^^^^^^ reference local 20
  }

  void move(int from, int to) {
//     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#move().
//          documentation ```java\nvoid move(int from, int to)\n```
//              ^^^^ definition local 21
//                   documentation ```java\nint from\n```
//                        ^^ definition local 22
//                           documentation ```java\nint to\n```
    // We can't batch moves
    lastOp = null;
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
    UpdateOp op = UpdateOp.instance(MOVE, from, to, null);
//  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//           ^^ definition local 23
//              documentation ```java\nUpdateOp op\n```
//                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#instance().
//                                  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#MOVE.
//                                        ^^^^ reference local 21
//                                              ^^ reference local 22
    opList.add(op);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#opList.
//         ^^^ reference semanticdb maven jdk 11 java/util/List#add().
//             ^^ reference local 23
    moves.add(op);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#moves.
//        ^^^ reference semanticdb maven jdk 11 java/util/List#add().
//            ^^ reference local 23
  }

  int getNumRemovals() {
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumRemovals().
//                   documentation ```java\nint getNumRemovals()\n```
    return numRemovals;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovals.
  }

  boolean hasRemovals() {
//        ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#hasRemovals().
//                    documentation ```java\nboolean hasRemovals()\n```
    return numRemovals > 0;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovals.
  }

  int getNumInsertions() {
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumInsertions().
//                     documentation ```java\nint getNumInsertions()\n```
    return numInsertions;
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertions.
  }

  boolean hasInsertions() {
//        ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#hasInsertions().
//                      documentation ```java\nboolean hasInsertions()\n```
    return numInsertions > 0;
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertions.
  }

  int getNumMoves() {
//    ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumMoves().
//                documentation ```java\nint getNumMoves()\n```
    return moves.size();
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#moves.
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
  }

  int getNumInsertionBatches() {
//    ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumInsertionBatches().
//                           documentation ```java\nint getNumInsertionBatches()\n```
    return numInsertionBatches;
//         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertionBatches.
  }

  int getNumRemovalBatches() {
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumRemovalBatches().
//                         documentation ```java\nint getNumRemovalBatches()\n```
    return numRemovalBatches;
//         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovalBatches.
  }
}
