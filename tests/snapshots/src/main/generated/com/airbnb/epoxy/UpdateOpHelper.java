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
//                   display_name UpdateOpHelper
//                   signature_documentation java class UpdateOpHelper
//                   documentation Helper class to collect changes in a diff, batching when possible. 
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#`<init>`().
//                   display_name <init>
//                   signature_documentation java UpdateOpHelper()
  final List<UpdateOp> opList = new ArrayList<>();
//      ^^^^ reference semanticdb maven jdk 11 java/util/List#
//           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#opList.
//                            display_name opList
//                            signature_documentation java final List<UpdateOp> opList
//                                  ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+1).
  // We have to be careful to update all item positions in the list when we
  // do a MOVE. This adds some complexity.
  // To do this we keep track of all moves and apply them to an item when we
  // need the up to date position
  final List<UpdateOp> moves = new ArrayList<>();
//      ^^^^ reference semanticdb maven jdk 11 java/util/List#
//           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                     ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#moves.
//                           display_name moves
//                           signature_documentation java final List<UpdateOp> moves
//                                 ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+1).
  private UpdateOp lastOp;
//        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                 ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                        display_name lastOp
//                        signature_documentation java private UpdateOp lastOp
  private int numInsertions;
//            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertions.
//                          display_name numInsertions
//                          signature_documentation java private int numInsertions
  private int numInsertionBatches;
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertionBatches.
//                                display_name numInsertionBatches
//                                signature_documentation java private int numInsertionBatches
  private int numRemovals;
//            ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovals.
//                        display_name numRemovals
//                        signature_documentation java private int numRemovals
  private int numRemovalBatches;
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovalBatches.
//                              display_name numRemovalBatches
//                              signature_documentation java private int numRemovalBatches

  void reset() {
//     ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#reset().
//           display_name reset
//           signature_documentation java void reset()
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
//         display_name add
//         signature_documentation java void add(int indexToInsert)
//             ^^^^^^^^^^^^^ definition local 0
//                           display_name indexToInsert
//                           signature_documentation java int indexToInsert
    add(indexToInsert, 1);
//  ^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#add(+1).
//      ^^^^^^^^^^^^^ reference local 0
  }

  void add(int startPosition, int itemCount) {
//     ^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#add(+1).
//         display_name add
//         signature_documentation java void add(int startPosition, int itemCount)
//             ^^^^^^^^^^^^^ definition local 1
//                           display_name startPosition
//                           signature_documentation java int startPosition
//                                ^^^^^^^^^ definition local 2
//                                          display_name itemCount
//                                          signature_documentation java int itemCount
    numInsertions += itemCount;
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertions.
//                   ^^^^^^^^^ reference local 2

    // We can append to a previously ADD batch if the new items are added anywhere in the
    // range of the previous batch batch
    boolean batchWithLast = isLastOp(ADD)
//          ^^^^^^^^^^^^^ definition local 3
//                        display_name batchWithLast
//                        signature_documentation java boolean batchWithLast
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
//            display_name update
//            signature_documentation java void update(int indexToChange)
//                ^^^^^^^^^^^^^ definition local 4
//                              display_name indexToChange
//                              signature_documentation java int indexToChange
    update(indexToChange, null);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#update(+1).
//         ^^^^^^^^^^^^^ reference local 4
  }

  void update(final int indexToChange, EpoxyModel<?> payload) {
//     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#update(+1).
//            display_name update
//            signature_documentation java void update(int indexToChange, EpoxyModel<?> payload)
//                      ^^^^^^^^^^^^^ definition local 5
//                                    display_name indexToChange
//                                    signature_documentation java final int indexToChange
//                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                   ^^^^^^^ definition local 6
//                                                           display_name payload
//                                                           signature_documentation java EpoxyModel<?> payload
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
//            display_name remove
//            signature_documentation java void remove(int indexToRemove)
//                ^^^^^^^^^^^^^ definition local 7
//                              display_name indexToRemove
//                              signature_documentation java int indexToRemove
    remove(indexToRemove, 1);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#remove(+1).
//         ^^^^^^^^^^^^^ reference local 7
  }

  void remove(int startPosition, int itemCount) {
//     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#remove(+1).
//            display_name remove
//            signature_documentation java void remove(int startPosition, int itemCount)
//                ^^^^^^^^^^^^^ definition local 8
//                              display_name startPosition
//                              signature_documentation java int startPosition
//                                   ^^^^^^^^^ definition local 9
//                                             display_name itemCount
//                                             signature_documentation java int itemCount
    numRemovals += itemCount;
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovals.
//                 ^^^^^^^^^ reference local 9

    boolean batchWithLast = false;
//          ^^^^^^^^^^^^^ definition local 10
//                        display_name batchWithLast
//                        signature_documentation java boolean batchWithLast
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
//                         display_name isLastOp
//                         signature_documentation java private boolean isLastOp(int updateType)
//                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                                   ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#Type#
//                                            ^^^^^^^^^^ definition local 11
//                                                       display_name updateType
//                                                       signature_documentation java @Type\nint updateType
    return lastOp != null && lastOp.type == updateType;
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
//                                  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#type.
//                                          ^^^^^^^^^^ reference local 11
  }

  private void addNewOperation(@Type int type, int position, int itemCount) {
//             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addNewOperation().
//                             display_name addNewOperation
//                             signature_documentation java private void addNewOperation(int type, int position, int itemCount)
//                              ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#Type#
//                                       ^^^^ definition local 12
//                                            display_name type
//                                            signature_documentation java @Type\nint type
//                                                 ^^^^^^^^ definition local 13
//                                                          display_name position
//                                                          signature_documentation java int position
//                                                               ^^^^^^^^^ definition local 14
//                                                                         display_name itemCount
//                                                                         signature_documentation java int itemCount
    addNewOperation(type, position, itemCount, null);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addNewOperation(+1).
//                  ^^^^ reference local 12
//                        ^^^^^^^^ reference local 13
//                                  ^^^^^^^^^ reference local 14
  }

  private void addNewOperation(@Type int type, int position, int itemCount,
//             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#addNewOperation(+1).
//                             display_name addNewOperation
//                             signature_documentation java private void addNewOperation(int type, int position, int itemCount, EpoxyModel<?> payload)
//                              ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#Type#
//                                       ^^^^ definition local 15
//                                            display_name type
//                                            signature_documentation java @Type\nint type
//                                                 ^^^^^^^^ definition local 16
//                                                          display_name position
//                                                          signature_documentation java int position
//                                                               ^^^^^^^^^ definition local 17
//                                                                         display_name itemCount
//                                                                         signature_documentation java int itemCount
      @Nullable EpoxyModel<?> payload) {
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^ definition local 18
//                                    display_name payload
//                                    signature_documentation java @Nullable\nEpoxyModel<?> payload
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
//                                     display_name addItemsToLastOperation
//                                     signature_documentation java private void addItemsToLastOperation(int numItemsToAdd, EpoxyModel<?> payload)
//                                         ^^^^^^^^^^^^^ definition local 19
//                                                       display_name numItemsToAdd
//                                                       signature_documentation java int numItemsToAdd
//                                                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                      ^^^^^^^ definition local 20
//                                                                              display_name payload
//                                                                              signature_documentation java EpoxyModel<?> payload
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
//          display_name move
//          signature_documentation java void move(int from, int to)
//              ^^^^ definition local 21
//                   display_name from
//                   signature_documentation java int from
//                        ^^ definition local 22
//                           display_name to
//                           signature_documentation java int to
    // We can't batch moves
    lastOp = null;
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#lastOp.
    UpdateOp op = UpdateOp.instance(MOVE, from, to, null);
//  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//           ^^ definition local 23
//              display_name op
//              signature_documentation java UpdateOp op
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
//                   display_name getNumRemovals
//                   signature_documentation java int getNumRemovals()
    return numRemovals;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovals.
  }

  boolean hasRemovals() {
//        ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#hasRemovals().
//                    display_name hasRemovals
//                    signature_documentation java boolean hasRemovals()
    return numRemovals > 0;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovals.
  }

  int getNumInsertions() {
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumInsertions().
//                     display_name getNumInsertions
//                     signature_documentation java int getNumInsertions()
    return numInsertions;
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertions.
  }

  boolean hasInsertions() {
//        ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#hasInsertions().
//                      display_name hasInsertions
//                      signature_documentation java boolean hasInsertions()
    return numInsertions > 0;
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertions.
  }

  int getNumMoves() {
//    ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumMoves().
//                display_name getNumMoves
//                signature_documentation java int getNumMoves()
    return moves.size();
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#moves.
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
  }

  int getNumInsertionBatches() {
//    ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumInsertionBatches().
//                           display_name getNumInsertionBatches
//                           signature_documentation java int getNumInsertionBatches()
    return numInsertionBatches;
//         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numInsertionBatches.
  }

  int getNumRemovalBatches() {
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumRemovalBatches().
//                         display_name getNumRemovalBatches
//                         signature_documentation java int getNumRemovalBatches()
    return numRemovalBatches;
//         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#numRemovalBatches.
  }
}
