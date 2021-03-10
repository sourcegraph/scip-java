package com.airbnb.epoxy;

import com.airbnb.epoxy.UpdateOp.Type;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                               ^^^^ reference com/airbnb/epoxy/UpdateOp#Type#

import java.util.ArrayList;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^ reference java/util/ArrayList#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#

import static com.airbnb.epoxy.UpdateOp.ADD;
//            ^^^ reference com/
//                ^^^^^^ reference com/airbnb/
//                       ^^^^^ reference com/airbnb/epoxy/
//                             ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
import static com.airbnb.epoxy.UpdateOp.MOVE;
//            ^^^ reference com/
//                ^^^^^^ reference com/airbnb/
//                       ^^^^^ reference com/airbnb/epoxy/
//                             ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
import static com.airbnb.epoxy.UpdateOp.REMOVE;
//            ^^^ reference com/
//                ^^^^^^ reference com/airbnb/
//                       ^^^^^ reference com/airbnb/epoxy/
//                             ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
import static com.airbnb.epoxy.UpdateOp.UPDATE;
//            ^^^ reference com/
//                ^^^^^^ reference com/airbnb/
//                       ^^^^^ reference com/airbnb/epoxy/
//                             ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#

/** Helper class to collect changes in a diff, batching when possible. */
class UpdateOpHelper {
//    ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#
//    ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#`<init>`().
  final List<UpdateOp> opList = new ArrayList<>();
//      ^^^^ reference java/util/List#
//           ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                     ^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#opList.
//                              ^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`(+1).
//                                  ^^^^^^^^^ reference java/util/ArrayList#
  // We have to be careful to update all item positions in the list when we
  // do a MOVE. This adds some complexity.
  // To do this we keep track of all moves and apply them to an item when we
  // need the up to date position
  final List<UpdateOp> moves = new ArrayList<>();
//      ^^^^ reference java/util/List#
//           ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                     ^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#moves.
//                             ^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`(+1).
//                                 ^^^^^^^^^ reference java/util/ArrayList#
  private UpdateOp lastOp;
//        ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                 ^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#lastOp.
  private int numInsertions;
//            ^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#numInsertions.
  private int numInsertionBatches;
//            ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#numInsertionBatches.
  private int numRemovals;
//            ^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#numRemovals.
  private int numRemovalBatches;
//            ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#numRemovalBatches.

  void reset() {
//     ^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#reset().
    opList.clear();
//  ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#opList.
//         ^^^^^ reference java/util/List#clear().
    moves.clear();
//  ^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#moves.
//        ^^^^^ reference java/util/List#clear().
    lastOp = null;
//  ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
    numInsertions = 0;
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numInsertions.
    numInsertionBatches = 0;
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numInsertionBatches.
    numRemovals = 0;
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numRemovals.
    numRemovalBatches = 0;
//  ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numRemovalBatches.
  }

  void add(int indexToInsert) {
//     ^^^ definition com/airbnb/epoxy/UpdateOpHelper#add().
//             ^^^^^^^^^^^^^ definition local0
    add(indexToInsert, 1);
//  ^^^ reference com/airbnb/epoxy/UpdateOpHelper#add(+1).
//      ^^^^^^^^^^^^^ reference local0
  }

  void add(int startPosition, int itemCount) {
//     ^^^ definition com/airbnb/epoxy/UpdateOpHelper#add(+1).
//             ^^^^^^^^^^^^^ definition local1
//                                ^^^^^^^^^ definition local2
    numInsertions += itemCount;
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numInsertions.
//                   ^^^^^^^^^ reference local2

    // We can append to a previously ADD batch if the new items are added anywhere in the
    // range of the previous batch batch
    boolean batchWithLast = isLastOp(ADD)
//          ^^^^^^^^^^^^^ definition local3
//                          ^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#isLastOp().
//                                   ^^^ reference com/airbnb/epoxy/UpdateOp#ADD.
        && (lastOp.contains(startPosition) || lastOp.positionEnd() == startPosition);
//          ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                 ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#contains().
//                          ^^^^^^^^^^^^^ reference local1
//                                            ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                                                   ^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionEnd().
//                                                                    ^^^^^^^^^^^^^ reference local1

    if (batchWithLast) {
//      ^^^^^^^^^^^^^ reference local3
      addItemsToLastOperation(itemCount, null);
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#addItemsToLastOperation().
//                            ^^^^^^^^^ reference local2
    } else {
      numInsertionBatches++;
//    ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numInsertionBatches.
      addNewOperation(ADD, startPosition, itemCount);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#addNewOperation().
//                    ^^^ reference com/airbnb/epoxy/UpdateOp#ADD.
//                         ^^^^^^^^^^^^^ reference local1
//                                        ^^^^^^^^^ reference local2
    }
  }

  void update(int indexToChange) {
//     ^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#update().
//                ^^^^^^^^^^^^^ definition local4
    update(indexToChange, null);
//  ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#update(+1).
//         ^^^^^^^^^^^^^ reference local4
  }

  void update(final int indexToChange, EpoxyModel<?> payload) {
//     ^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#update(+1).
//                      ^^^^^^^^^^^^^ definition local5
//                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                   ^^^^^^^ definition local6
    if (isLastOp(UPDATE)) {
//      ^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#isLastOp().
//               ^^^^^^ reference com/airbnb/epoxy/UpdateOp#UPDATE.
      if (lastOp.positionStart == indexToChange + 1) {
//        ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                ^^^^^^^^^^^^^ reference local5
        // Change another item at the start of the batch range
        addItemsToLastOperation(1, payload);
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#addItemsToLastOperation().
//                                 ^^^^^^^ reference local6
        lastOp.positionStart = indexToChange;
//      ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//             ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                             ^^^^^^^^^^^^^ reference local5
      } else if (lastOp.positionEnd() == indexToChange) {
//               ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                      ^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionEnd().
//                                       ^^^^^^^^^^^^^ reference local5
        // Add another item at the end of the batch range
        addItemsToLastOperation(1, payload);
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#addItemsToLastOperation().
//                                 ^^^^^^^ reference local6
      } else if (lastOp.contains(indexToChange)) {
//               ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                      ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#contains().
//                               ^^^^^^^^^^^^^ reference local5
        // This item is already included in the existing batch range, so we don't add any items
        // to the batch count, but we still need to add the new payload
        addItemsToLastOperation(0, payload);
//      ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#addItemsToLastOperation().
//                                 ^^^^^^^ reference local6
      } else {
        // The item can't be batched with the previous update operation
        addNewOperation(UPDATE, indexToChange, 1, payload);
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#addNewOperation(+1).
//                      ^^^^^^ reference com/airbnb/epoxy/UpdateOp#UPDATE.
//                              ^^^^^^^^^^^^^ reference local5
//                                                ^^^^^^^ reference local6
      }
    } else {
      addNewOperation(UPDATE, indexToChange, 1, payload);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#addNewOperation(+1).
//                    ^^^^^^ reference com/airbnb/epoxy/UpdateOp#UPDATE.
//                            ^^^^^^^^^^^^^ reference local5
//                                              ^^^^^^^ reference local6
    }
  }

  void remove(int indexToRemove) {
//     ^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#remove().
//                ^^^^^^^^^^^^^ definition local7
    remove(indexToRemove, 1);
//  ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#remove(+1).
//         ^^^^^^^^^^^^^ reference local7
  }

  void remove(int startPosition, int itemCount) {
//     ^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#remove(+1).
//                ^^^^^^^^^^^^^ definition local8
//                                   ^^^^^^^^^ definition local9
    numRemovals += itemCount;
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numRemovals.
//                 ^^^^^^^^^ reference local9

    boolean batchWithLast = false;
//          ^^^^^^^^^^^^^ definition local10
    if (isLastOp(REMOVE)) {
//      ^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#isLastOp().
//               ^^^^^^ reference com/airbnb/epoxy/UpdateOp#REMOVE.
      if (lastOp.positionStart == startPosition) {
//        ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                ^^^^^^^^^^^^^ reference local8
        // Remove additional items at the end of the batch range
        batchWithLast = true;
//      ^^^^^^^^^^^^^ reference local10
      } else if (lastOp.isAfter(startPosition)
//               ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                      ^^^^^^^ reference com/airbnb/epoxy/UpdateOp#isAfter().
//                              ^^^^^^^^^^^^^ reference local8
          && startPosition + itemCount >= lastOp.positionStart) {
//           ^^^^^^^^^^^^^ reference local8
//                           ^^^^^^^^^ reference local9
//                                        ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                                               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
        // Removes additional items at the start and (possibly) end of the batch
        lastOp.positionStart = startPosition;
//      ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//             ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                             ^^^^^^^^^^^^^ reference local8
        batchWithLast = true;
//      ^^^^^^^^^^^^^ reference local10
      }
    }

    if (batchWithLast) {
//      ^^^^^^^^^^^^^ reference local10
      addItemsToLastOperation(itemCount, null);
//    ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#addItemsToLastOperation().
//                            ^^^^^^^^^ reference local9
    } else {
      numRemovalBatches++;
//    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numRemovalBatches.
      addNewOperation(REMOVE, startPosition, itemCount);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#addNewOperation().
//                    ^^^^^^ reference com/airbnb/epoxy/UpdateOp#REMOVE.
//                            ^^^^^^^^^^^^^ reference local8
//                                           ^^^^^^^^^ reference local9
    }
  }

  private boolean isLastOp(@UpdateOp.Type int updateType) {
//                ^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#isLastOp().
//                          ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                                   ^^^^ reference com/airbnb/epoxy/UpdateOp#Type#
//                                            ^^^^^^^^^^ definition local11
    return lastOp != null && lastOp.type == updateType;
//         ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                           ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                                  ^^^^ reference com/airbnb/epoxy/UpdateOp#type.
//                                          ^^^^^^^^^^ reference local11
  }

  private void addNewOperation(@Type int type, int position, int itemCount) {
//             ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#addNewOperation().
//                              ^^^^ reference com/airbnb/epoxy/UpdateOp#Type#
//                                       ^^^^ definition local12
//                                                 ^^^^^^^^ definition local13
//                                                               ^^^^^^^^^ definition local14
    addNewOperation(type, position, itemCount, null);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#addNewOperation(+1).
//                  ^^^^ reference local12
//                        ^^^^^^^^ reference local13
//                                  ^^^^^^^^^ reference local14
  }

  private void addNewOperation(@Type int type, int position, int itemCount,
//             ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#addNewOperation(+1).
//                              ^^^^ reference com/airbnb/epoxy/UpdateOp#Type#
//                                       ^^^^ definition local15
//                                                 ^^^^^^^^ definition local16
//                                                               ^^^^^^^^^ definition local17
      @Nullable EpoxyModel<?> payload) {
//     ^^^^^^^^ reference androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^ definition local18
    lastOp = UpdateOp.instance(type, position, itemCount, payload);
//  ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//           ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                    ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#instance().
//                             ^^^^ reference local15
//                                   ^^^^^^^^ reference local16
//                                             ^^^^^^^^^ reference local17
//                                                        ^^^^^^^ reference local18
    opList.add(lastOp);
//  ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#opList.
//         ^^^ reference java/util/List#add().
//             ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
  }

  private void addItemsToLastOperation(int numItemsToAdd, EpoxyModel<?> payload) {
//             ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#addItemsToLastOperation().
//                                         ^^^^^^^^^^^^^ definition local19
//                                                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                      ^^^^^^^ definition local20
    lastOp.itemCount += numItemsToAdd;
//  ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//         ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
//                      ^^^^^^^^^^^^^ reference local19
    lastOp.addPayload(payload);
//  ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
//         ^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#addPayload().
//                    ^^^^^^^ reference local20
  }

  void move(int from, int to) {
//     ^^^^ definition com/airbnb/epoxy/UpdateOpHelper#move().
//              ^^^^ definition local21
//                        ^^ definition local22
    // We can't batch moves
    lastOp = null;
//  ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#lastOp.
    UpdateOp op = UpdateOp.instance(MOVE, from, to, null);
//  ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//           ^^ definition local23
//                ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                         ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#instance().
//                                  ^^^^ reference com/airbnb/epoxy/UpdateOp#MOVE.
//                                        ^^^^ reference local21
//                                              ^^ reference local22
    opList.add(op);
//  ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#opList.
//         ^^^ reference java/util/List#add().
//             ^^ reference local23
    moves.add(op);
//  ^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#moves.
//        ^^^ reference java/util/List#add().
//            ^^ reference local23
  }

  int getNumRemovals() {
//    ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#getNumRemovals().
    return numRemovals;
//         ^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numRemovals.
  }

  boolean hasRemovals() {
//        ^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#hasRemovals().
    return numRemovals > 0;
//         ^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numRemovals.
  }

  int getNumInsertions() {
//    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#getNumInsertions().
    return numInsertions;
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numInsertions.
  }

  boolean hasInsertions() {
//        ^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#hasInsertions().
    return numInsertions > 0;
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numInsertions.
  }

  int getNumMoves() {
//    ^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#getNumMoves().
    return moves.size();
//         ^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#moves.
//               ^^^^ reference java/util/List#size().
  }

  int getNumInsertionBatches() {
//    ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#getNumInsertionBatches().
    return numInsertionBatches;
//         ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numInsertionBatches.
  }

  int getNumRemovalBatches() {
//    ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOpHelper#getNumRemovalBatches().
    return numRemovalBatches;
//         ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#numRemovalBatches.
  }
}
