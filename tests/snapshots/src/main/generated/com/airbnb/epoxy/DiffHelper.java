
package com.airbnb.epoxy;

import java.util.ArrayList;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^ reference java/util/ArrayList#
import java.util.HashMap;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^ reference java/util/HashMap#
import java.util.Iterator;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^ reference java/util/Iterator#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#
import java.util.Map;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^ reference java/util/Map#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView#

/**
 * Helper to track changes in the models list.
 */
class DiffHelper {
^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#
  private ArrayList<ModelState> oldStateList = new ArrayList<>();
//        ^^^^^^^^^ reference java/util/ArrayList#
//                  ^^^^^^^^^^ reference _root_/
//                              ^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#oldStateList.
//                                             ^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`(+1).
//                                                 ^^^^^^^^^ reference java/util/ArrayList#
  // Using a HashMap instead of a LongSparseArray to
  // have faster look up times at the expense of memory
  private Map<Long, ModelState> oldStateMap = new HashMap<>();
//        ^^^ reference java/util/Map#
//            ^^^^ reference java/lang/Long#
//                  ^^^^^^^^^^ reference _root_/
//                              ^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#oldStateMap.
//                                            ^^^^^^^^^^^^^^^ reference java/util/HashMap#`<init>`(+2).
//                                                ^^^^^^^ reference java/util/HashMap#
  private ArrayList<ModelState> currentStateList = new ArrayList<>();
//        ^^^^^^^^^ reference java/util/ArrayList#
//                  ^^^^^^^^^^ reference _root_/
//                              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#currentStateList.
//                                                 ^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`(+1).
//                                                     ^^^^^^^^^ reference java/util/ArrayList#
  private Map<Long, ModelState> currentStateMap = new HashMap<>();
//        ^^^ reference java/util/Map#
//            ^^^^ reference java/lang/Long#
//                  ^^^^^^^^^^ reference _root_/
//                              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#currentStateMap.
//                                                ^^^^^^^^^^^^^^^ reference java/util/HashMap#`<init>`(+2).
//                                                    ^^^^^^^ reference java/util/HashMap#
  private final BaseEpoxyAdapter adapter;
//              ^^^^^^^^^^^^^^^^ reference _root_/
//                               ^^^^^^^ definition com/airbnb/epoxy/DiffHelper#adapter.
  private final boolean immutableModels;
//                      ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#immutableModels.


  DiffHelper(BaseEpoxyAdapter adapter, boolean immutableModels) {
  ^^^^^^ definition com/airbnb/epoxy/DiffHelper#`<init>`().
//           ^^^^^^^^^^^^^^^^ reference _root_/
//                            ^^^^^^^ definition local0
//                                             ^^^^^^^^^^^^^^^ definition local1
    this.adapter = adapter;
//  ^^^^ reference com/airbnb/epoxy/DiffHelper#this.
//       ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                 ^^^^^^^ reference local0
    this.immutableModels = immutableModels;
//  ^^^^ reference com/airbnb/epoxy/DiffHelper#this.
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#immutableModels.
//                         ^^^^^^^^^^^^^^^ reference local1
    adapter.registerAdapterDataObserver(observer);
//  ^^^^^^^ reference local0
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference registerAdapterDataObserver#
//                                      ^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#observer.
  }

  private final RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() {
//              ^^^^^^^^^^^^ reference RecyclerView/
//                           ^^^^^^^^^^^^^^^^^^^ reference RecyclerView/AdapterDataObserver#
//                                               ^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#observer.
//                                                              ^^^^^^^^^^^^ reference RecyclerView/
//                                                                           ^^^^^^^^^^^^^^^^^^^ reference RecyclerView/AdapterDataObserver#
    @Override
    public void onChanged() {
      throw new UnsupportedOperationException(
          "Diffing is enabled. You should use notifyModelsChanged instead of notifyDataSetChanged");
    }

    @Override
    public void onItemRangeChanged(int positionStart, int itemCount) {
      for (int i = positionStart; i < positionStart + itemCount; i++) {
        currentStateList.get(i).hashCode = adapter.getCurrentModels().get(i).hashCode();
      }
    }

    @Override
    public void onItemRangeInserted(int positionStart, int itemCount) {
      if (itemCount == 0) {
        // no-op
        return;
      }

      if (itemCount == 1 || positionStart == currentStateList.size()) {
        for (int i = positionStart; i < positionStart + itemCount; i++) {
          currentStateList.add(i, createStateForPosition(i));
        }
      } else {
        // Add in a batch since multiple insertions to the middle of the list are slow
        List<ModelState> newModels = new ArrayList<>(itemCount);
        for (int i = positionStart; i < positionStart + itemCount; i++) {
          newModels.add(createStateForPosition(i));
        }

        currentStateList.addAll(positionStart, newModels);
      }

      // Update positions of affected items
      int size = currentStateList.size();
      for (int i = positionStart + itemCount; i < size; i++) {
        currentStateList.get(i).position += itemCount;
      }
    }

    @Override
    public void onItemRangeRemoved(int positionStart, int itemCount) {
      if (itemCount == 0) {
        // no-op
        return;
      }

      List<ModelState> modelsToRemove =
          currentStateList.subList(positionStart, positionStart + itemCount);
      for (ModelState model : modelsToRemove) {
        currentStateMap.remove(model.id);
      }
      modelsToRemove.clear();

      // Update positions of affected items
      int size = currentStateList.size();
      for (int i = positionStart; i < size; i++) {
        currentStateList.get(i).position -= itemCount;
      }
    }

    @Override
    public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
      if (fromPosition == toPosition) {
        // no-op
        return;
      }

      if (itemCount != 1) {
        throw new IllegalArgumentException("Moving more than 1 item at a time is not "
            + "supported. Number of items moved: " + itemCount);
      }

      ModelState model = currentStateList.remove(fromPosition);
      model.position = toPosition;
      currentStateList.add(toPosition, model);

      if (fromPosition < toPosition) {
        // shift the affected items left
        for (int i = fromPosition; i < toPosition; i++) {
          currentStateList.get(i).position--;
        }
      } else {
        // shift the affected items right
        for (int i = toPosition + 1; i <= fromPosition; i++) {
          currentStateList.get(i).position++;
        }
      }
    }
  };

  /**
   * Set the current list of models. The diff callbacks will be notified of the changes between the
   * current list and the last list that was set.
   */
  void notifyModelChanges() {
//     ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#notifyModelChanges().
    UpdateOpHelper updateOpHelper = new UpdateOpHelper();
//  ^^^^^^^^^^^^^^ reference _root_/
//                 ^^^^^^^^^^^^^^ definition local2
//                                      ^^^^^^^^^^^^^^ reference _root_/

    buildDiff(updateOpHelper);
//  ^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#buildDiff().
//            ^^^^^^^^^^^^^^ reference local2

    // Send out the proper notify calls for the diff. We remove our
    // observer first so that we don't react to our own notify calls
    adapter.unregisterAdapterDataObserver(observer);
//  ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference unregisterAdapterDataObserver#
//                                        ^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#observer.
    notifyChanges(updateOpHelper);
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#notifyChanges().
//                ^^^^^^^^^^^^^^ reference local2
    adapter.registerAdapterDataObserver(observer);
//  ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference registerAdapterDataObserver#
//                                      ^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#observer.
  }

  private void notifyChanges(UpdateOpHelper opHelper) {
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#notifyChanges().
//                           ^^^^^^^^^^^^^^ reference _root_/
//                                          ^^^^^^^^ definition local3
    for (UpdateOp op : opHelper.opList) {
//       ^^^^^^^^ reference _root_/
//                ^^ definition local4
//                     ^^^^^^^^ reference local3
//                              ^^^^^^ reference opList#
      switch (op.type) {
//            ^^ reference local4
//               ^^^^ reference type#
        case UpdateOp.ADD:
//           ^^^^^^^^ reference _root_/
//                    ^^^ reference ADD#
          adapter.notifyItemRangeInserted(op.positionStart, op.itemCount);
//        ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                ^^^^^^^^^^^^^^^^^^^^^^^ reference notifyItemRangeInserted#
//                                        ^^ reference local4
//                                           ^^^^^^^^^^^^^ reference positionStart#
//                                                          ^^ reference local4
//                                                             ^^^^^^^^^ reference itemCount#
          break;
        case UpdateOp.MOVE:
//           ^^^^^^^^ reference _root_/
//                    ^^^^ reference MOVE#
          adapter.notifyItemMoved(op.positionStart, op.itemCount);
//        ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                ^^^^^^^^^^^^^^^ reference notifyItemMoved#
//                                ^^ reference local4
//                                   ^^^^^^^^^^^^^ reference positionStart#
//                                                  ^^ reference local4
//                                                     ^^^^^^^^^ reference itemCount#
          break;
        case UpdateOp.REMOVE:
//           ^^^^^^^^ reference _root_/
//                    ^^^^^^ reference REMOVE#
          adapter.notifyItemRangeRemoved(op.positionStart, op.itemCount);
//        ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                ^^^^^^^^^^^^^^^^^^^^^^ reference notifyItemRangeRemoved#
//                                       ^^ reference local4
//                                          ^^^^^^^^^^^^^ reference positionStart#
//                                                         ^^ reference local4
//                                                            ^^^^^^^^^ reference itemCount#
          break;
        case UpdateOp.UPDATE:
//           ^^^^^^^^ reference _root_/
//                    ^^^^^^ reference UPDATE#
          if (immutableModels && op.payloads != null) {
//            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#immutableModels.
//                               ^^ reference local4
//                                  ^^^^^^^^ reference payloads#
            adapter.notifyItemRangeChanged(op.positionStart, op.itemCount,
//          ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference notifyItemRangeChanged#
//                                         ^^ reference local4
//                                            ^^^^^^^^^^^^^ reference positionStart#
//                                                           ^^ reference local4
//                                                              ^^^^^^^^^ reference itemCount#
                new DiffPayload(op.payloads));
//                  ^^^^^^^^^^^ reference _root_/
//                              ^^ reference local4
//                                 ^^^^^^^^ reference payloads#
          } else {
            adapter.notifyItemRangeChanged(op.positionStart, op.itemCount);
//          ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference notifyItemRangeChanged#
//                                         ^^ reference local4
//                                            ^^^^^^^^^^^^^ reference positionStart#
//                                                           ^^ reference local4
//                                                              ^^^^^^^^^ reference itemCount#
          }
          break;
        default:
          throw new IllegalArgumentException("Unknown type: " + op.type);
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#`<init>`(+1).
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#
//                                                              ^^ reference local4
//                                                                 ^^^^ reference type#
      }
    }
  }

  /**
   * Create a list of operations that define the difference between {@link #oldStateList} and {@link
   * #currentStateList}.
   */
  private UpdateOpHelper buildDiff(UpdateOpHelper updateOpHelper) {
//        ^^^^^^^^^^^^^^ reference _root_/
//                       ^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#buildDiff().
//                                 ^^^^^^^^^^^^^^ reference _root_/
//                                                ^^^^^^^^^^^^^^ definition local5
    prepareStateForDiff();
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#prepareStateForDiff().

    // The general approach is to first search for removals, then additions, and lastly changes.
    // Focusing on one type of operation at a time makes it easy to coalesce batch changes.
    // When we identify an operation and add it to the
    // result list we update the positions of items in the oldStateList to reflect
    // the change, this way subsequent operations will use the correct, updated positions.
    collectRemovals(updateOpHelper);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#collectRemovals().
//                  ^^^^^^^^^^^^^^ reference local5

    // Only need to check for insertions if new list is bigger
    boolean hasInsertions =
//          ^^^^^^^^^^^^^ definition local6
        oldStateList.size() - updateOpHelper.getNumRemovals() != currentStateList.size();
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//                   ^^^^ reference java/util/ArrayList#size(+1).
//                            ^^^^^^^^^^^^^^ reference local5
//                                           ^^^^^^^^^^^^^^ reference getNumRemovals#
//                                                               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                                                                                ^^^^ reference java/util/ArrayList#size(+1).
    if (hasInsertions) {
//      ^^^^^^^^^^^^^ reference local6
      collectInsertions(updateOpHelper);
//    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#collectInsertions().
//                      ^^^^^^^^^^^^^^ reference local5
    }

    collectMoves(updateOpHelper);
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#collectMoves().
//               ^^^^^^^^^^^^^^ reference local5
    collectChanges(updateOpHelper);
//  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#collectChanges().
//                 ^^^^^^^^^^^^^^ reference local5

    resetOldState();
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#resetOldState().

    return updateOpHelper;
//         ^^^^^^^^^^^^^^ reference local5
  }

  private void resetOldState() {
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#resetOldState().
    oldStateList.clear();
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//               ^^^^^ reference java/util/ArrayList#clear().
    oldStateMap.clear();
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateMap.
//              ^^^^^ reference java/util/Map#clear().
  }

  private void prepareStateForDiff() {
//             ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#prepareStateForDiff().
    // We use a list of the models as well as a map by their id,
    // so we can easily find them by both position and id

    oldStateList.clear();
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//               ^^^^^ reference java/util/ArrayList#clear().
    oldStateMap.clear();
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateMap.
//              ^^^^^ reference java/util/Map#clear().

    // Swap the two lists so that we have a copy of the current state to calculate the next diff
    ArrayList<ModelState> tempList = oldStateList;
//  ^^^^^^^^^ reference java/util/ArrayList#
//            ^^^^^^^^^^ reference _root_/
//                        ^^^^^^^^ definition local7
//                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
    oldStateList = currentStateList;
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
    currentStateList = tempList;
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                     ^^^^^^^^ reference local7

    Map<Long, ModelState> tempMap = oldStateMap;
//  ^^^ reference java/util/Map#
//      ^^^^ reference java/lang/Long#
//            ^^^^^^^^^^ reference _root_/
//                        ^^^^^^^ definition local8
//                                  ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateMap.
    oldStateMap = currentStateMap;
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateMap.
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateMap.
    currentStateMap = tempMap;
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateMap.
//                    ^^^^^^^ reference local8

    // Remove all pairings in the old states so we can tell which of them were removed. The items
    // that still exist in the new list will be paired when we build the current list state below
    for (ModelState modelState : oldStateList) {
//       ^^^^^^^^^^ reference _root_/
//                  ^^^^^^^^^^ definition local9
//                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
      modelState.pair = null;
//    ^^^^^^^^^^ reference local9
//               ^^^^ reference pair#
    }

    int modelCount = adapter.getCurrentModels().size();
//      ^^^^^^^^^^ definition local10
//                   ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                           ^^^^^^^^^^^^^^^^ reference getCurrentModels#
//                                              ^^^^ reference getCurrentModels#size#
    currentStateList.ensureCapacity(modelCount);
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                   ^^^^^^^^^^^^^^ reference java/util/ArrayList#ensureCapacity().
//                                  ^^^^^^^^^^ reference local10

    for (int i = 0; i < modelCount; i++) {
//           ^ definition local11
//                  ^ reference local11
//                      ^^^^^^^^^^ reference local10
//                                  ^ reference local11
      currentStateList.add(createStateForPosition(i));
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                     ^^^ reference java/util/ArrayList#add().
//                         ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#createStateForPosition().
//                                                ^ reference local11
    }
  }

  private ModelState createStateForPosition(int position) {
//        ^^^^^^^^^^ reference _root_/
//                   ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#createStateForPosition().
//                                              ^^^^^^^^ definition local12
    EpoxyModel<?> model = adapter.getCurrentModels().get(position);
//  ^^^^^^^^^^ reference _root_/
//                ^^^^^ definition local13
//                        ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                                ^^^^^^^^^^^^^^^^ reference getCurrentModels#
//                                                   ^^^ reference getCurrentModels#get#
//                                                       ^^^^^^^^ reference local12
    model.addedToAdapter = true;
//  ^^^^^ reference local13
//        ^^^^^^^^^^^^^^ reference `<any>`#addedToAdapter#
    ModelState state = ModelState.build(model, position, immutableModels);
//  ^^^^^^^^^^ reference _root_/
//             ^^^^^ definition local14
//                     ^^^^^^^^^^ reference _root_/
//                                ^^^^^ reference build#
//                                      ^^^^^ reference local13
//                                             ^^^^^^^^ reference local12
//                                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#immutableModels.

    ModelState previousValue = currentStateMap.put(state.id, state);
//  ^^^^^^^^^^ reference _root_/
//             ^^^^^^^^^^^^^ definition local15
//                             ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateMap.
//                                             ^^^ reference java/util/Map#put().
//                                                 ^^^^^ reference local14
//                                                       ^^ reference id#
//                                                           ^^^^^ reference local14
    if (previousValue != null) {
//      ^^^^^^^^^^^^^ reference local15
      int previousPosition = previousValue.position;
//        ^^^^^^^^^^^^^^^^ definition local16
//                           ^^^^^^^^^^^^^ reference local15
//                                         ^^^^^^^^ reference position#
      EpoxyModel<?> previousModel = adapter.getCurrentModels().get(previousPosition);
//    ^^^^^^^^^^ reference _root_/
//                  ^^^^^^^^^^^^^ definition local17
//                                  ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                                          ^^^^^^^^^^^^^^^^ reference getCurrentModels#
//                                                             ^^^ reference getCurrentModels#get#
//                                                                 ^^^^^^^^^^^^^^^^ reference local16
      throw new IllegalStateException("Two models have the same ID. ID's must be unique!"
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 2:76
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
          + " Model at position " + position + ": " + model
//                                  ^^^^^^^^ reference local12
//                                                    ^^^^^ reference local13
          + " Model at position " + previousPosition + ": " + previousModel);
//                                  ^^^^^^^^^^^^^^^^ reference local16
//                                                            ^^^^^^^^^^^^^ reference local17
    }

    return state;
//         ^^^^^ reference local14
  }

  /**
   * Find all removal operations and add them to the result list. The general strategy here is to
   * walk through the {@link #oldStateList} and check for items that don't exist in the new list.
   * Walking through it in order makes it easy to batch adjacent removals.
   */
  private void collectRemovals(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#collectRemovals().
//                             ^^^^^^^^^^^^^^ reference _root_/
//                                            ^^^^^^ definition local18
    for (ModelState state : oldStateList) {
//       ^^^^^^^^^^ reference _root_/
//                  ^^^^^ definition local19
//                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
      // Update the position of the item to take into account previous removals,
      // so that future operations will reference the correct position
      state.position -= helper.getNumRemovals();
//    ^^^^^ reference local19
//          ^^^^^^^^ reference position#
//                      ^^^^^^ reference local18
//                             ^^^^^^^^^^^^^^ reference getNumRemovals#

      // This is our first time going through the list, so we
      // look up the item with the matching id in the new
      // list and hold a reference to it so that we can access it quickly in the future
      state.pair = currentStateMap.get(state.id);
//    ^^^^^ reference local19
//          ^^^^ reference pair#
//                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateMap.
//                                 ^^^ reference java/util/Map#get().
//                                     ^^^^^ reference local19
//                                           ^^ reference id#
      if (state.pair != null) {
//        ^^^^^ reference local19
//              ^^^^ reference pair#
        state.pair.pair = state;
//      ^^^^^ reference local19
//            ^^^^ reference pair#
//                 ^^^^ reference pair#pair#
//                        ^^^^^ reference local19
        continue;
      }

      helper.remove(state.position);
//    ^^^^^^ reference local18
//           ^^^^^^ reference remove#
//                  ^^^^^ reference local19
//                        ^^^^^^^^ reference position#
    }
  }

  /**
   * Find all insertion operations and add them to the result list. The general strategy here is to
   * walk through the {@link #currentStateList} and check for items that don't exist in the old
   * list. Walking through it in order makes it easy to batch adjacent insertions.
   */
  private void collectInsertions(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#collectInsertions().
//                               ^^^^^^^^^^^^^^ reference _root_/
//                                              ^^^^^^ definition local20
    Iterator<ModelState> oldItemIterator = oldStateList.iterator();
//  ^^^^^^^^ reference java/util/Iterator#
//           ^^^^^^^^^^ reference _root_/
//                       ^^^^^^^^^^^^^^^ definition local21
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//                                                      ^^^^^^^^ reference java/util/ArrayList#iterator().

    for (ModelState itemToInsert : currentStateList) {
//       ^^^^^^^^^^ reference _root_/
//                  ^^^^^^^^^^^^ definition local22
//                                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
      if (itemToInsert.pair != null) {
//        ^^^^^^^^^^^^ reference local22
//                     ^^^^ reference pair#
        // Update the position of the next item in the old list to take any insertions into account
        ModelState nextOldItem = getNextItemWithPair(oldItemIterator);
//      ^^^^^^^^^^ reference _root_/
//                 ^^^^^^^^^^^ definition local23
//                               ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                                   ^^^^^^^^^^^^^^^ reference local21
        if (nextOldItem != null) {
//          ^^^^^^^^^^^ reference local23
          nextOldItem.position += helper.getNumInsertions();
//        ^^^^^^^^^^^ reference local23
//                    ^^^^^^^^ reference position#
//                                ^^^^^^ reference local20
//                                       ^^^^^^^^^^^^^^^^ reference getNumInsertions#
        }
        continue;
      }

      helper.add(itemToInsert.position);
//    ^^^^^^ reference local20
//           ^^^ reference add#
//               ^^^^^^^^^^^^ reference local22
//                            ^^^^^^^^ reference position#
    }
  }

  /**
   * Check if any items have had their values changed, batching if possible.
   */
  private void collectChanges(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#collectChanges().
//                            ^^^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^ definition local24
    for (ModelState newItem : currentStateList) {
//       ^^^^^^^^^^ reference _root_/
//                  ^^^^^^^ definition local25
//                            ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
      ModelState previousItem = newItem.pair;
//    ^^^^^^^^^^ reference _root_/
//               ^^^^^^^^^^^^ definition local26
//                              ^^^^^^^ reference local25
//                                      ^^^^ reference pair#
      if (previousItem == null) {
//        ^^^^^^^^^^^^ reference local26
        continue;
      }

      // We use equals when we know the models are immutable and available, otherwise we have to
      // rely on the stored hashCode
      boolean modelChanged;
//            ^^^^^^^^^^^^ definition local27
      if (immutableModels) {
//        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#immutableModels.
        // Make sure that the old model hasn't changed, otherwise comparing it with the new one
        // won't be accurate.
        if (previousItem.model.isDebugValidationEnabled()) {
//          ^^^^^^^^^^^^ reference local26
//                       ^^^^^ reference model#
//                             ^^^^^^^^^^^^^^^^^^^^^^^^ reference model#isDebugValidationEnabled#
          previousItem.model
//        ^^^^^^^^^^^^ reference local26
//                     ^^^^^ reference model#
              .validateStateHasNotChangedSinceAdded("Model was changed before it could be diffed.",
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference model#validateStateHasNotChangedSinceAdded#
                  previousItem.position);
//                ^^^^^^^^^^^^ reference local26
//                             ^^^^^^^^ reference position#
        }

        modelChanged = !previousItem.model.equals(newItem.model);
//      ^^^^^^^^^^^^ reference local27
//                      ^^^^^^^^^^^^ reference local26
//                                   ^^^^^ reference model#
//                                         ^^^^^^ reference model#equals#
//                                                ^^^^^^^ reference local25
//                                                        ^^^^^ reference model#
      } else {
        modelChanged = previousItem.hashCode != newItem.hashCode;
//      ^^^^^^^^^^^^ reference local27
//                     ^^^^^^^^^^^^ reference local26
//                                  ^^^^^^^^ reference hashCode#
//                                              ^^^^^^^ reference local25
//                                                      ^^^^^^^^ reference hashCode#
      }

      if (modelChanged) {
//        ^^^^^^^^^^^^ reference local27
        helper.update(newItem.position, previousItem.model);
//      ^^^^^^ reference local24
//             ^^^^^^ reference update#
//                    ^^^^^^^ reference local25
//                            ^^^^^^^^ reference position#
//                                      ^^^^^^^^^^^^ reference local26
//                                                   ^^^^^ reference model#
      }
    }
  }

  /**
   * Check which items have had a position changed. Recyclerview does not support batching these.
   */
  private void collectMoves(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#collectMoves().
//                          ^^^^^^^^^^^^^^ reference _root_/
//                                         ^^^^^^ definition local28
    // This walks through both the new and old list simultaneous and checks for position changes.
    Iterator<ModelState> oldItemIterator = oldStateList.iterator();
//  ^^^^^^^^ reference java/util/Iterator#
//           ^^^^^^^^^^ reference _root_/
//                       ^^^^^^^^^^^^^^^ definition local29
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//                                                      ^^^^^^^^ reference java/util/ArrayList#iterator().
    ModelState nextOldItem = null;
//  ^^^^^^^^^^ reference _root_/
//             ^^^^^^^^^^^ definition local30

    for (ModelState newItem : currentStateList) {
//       ^^^^^^^^^^ reference _root_/
//                  ^^^^^^^ definition local31
//                            ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
      if (newItem.pair == null) {
//        ^^^^^^^ reference local31
//                ^^^^ reference pair#
        // This item was inserted. However, insertions are done at the item's final position, and
        // aren't smart about inserting at a different position to take future moves into account.
        // As the old state list is updated to reflect moves, it needs to also consider insertions
        // affected by those moves in order for the final change set to be correct
        if (helper.moves.isEmpty()) {
//          ^^^^^^ reference local28
//                 ^^^^^ reference moves#
//                       ^^^^^^^ reference moves#isEmpty#
          // There have been no moves, so the item is still at it's correct position
          continue;
        } else {
          // There have been moves, so the old list needs to take this inserted item
          // into account. The old list doesn't have this item inserted into it
          // (for optimization purposes), but we can create a pair for this item to
          // track its position in the old list and move it back to its final position if necessary
          newItem.pairWithSelf();
//        ^^^^^^^ reference local31
//                ^^^^^^^^^^^^ reference pairWithSelf#
        }
      }

      // We could iterate through only the new list and move each
      // item that is out of place, however in cases such as moving the first item
      // to the end, that strategy would do many moves to move all
      // items up one instead of doing one move to move the first item to the end.
      // To avoid this we compare the old item to the new item at
      // each index and move the one that is farthest from its correct position.
      // We only move on from a new item once its pair is placed in
      // the correct spot. Since we move from start to end, all new items we've
      // already iterated through are guaranteed to have their pair
      // be already in the right spot, which won't be affected by future MOVEs.
      if (nextOldItem == null) {
//        ^^^^^^^^^^^ reference local30
        nextOldItem = getNextItemWithPair(oldItemIterator);
//      ^^^^^^^^^^^ reference local30
//                    ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                        ^^^^^^^^^^^^^^^ reference local29

        // We've already iterated through all old items and moved each
        // item once. However, subsequent moves may have shifted an item out of
        // its correct space once it was already moved. We finish
        // iterating through all the new items to ensure everything is still correct
        if (nextOldItem == null) {
//          ^^^^^^^^^^^ reference local30
          nextOldItem = newItem.pair;
//        ^^^^^^^^^^^ reference local30
//                      ^^^^^^^ reference local31
//                              ^^^^ reference pair#
        }
      }

      while (nextOldItem != null) {
//           ^^^^^^^^^^^ reference local30
        // Make sure the positions are updated to the latest
        // move operations before we calculate the next move
        updateItemPosition(newItem.pair, helper.moves);
//      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#updateItemPosition().
//                         ^^^^^^^ reference local31
//                                 ^^^^ reference pair#
//                                       ^^^^^^ reference local28
//                                              ^^^^^ reference moves#
        updateItemPosition(nextOldItem, helper.moves);
//      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#updateItemPosition().
//                         ^^^^^^^^^^^ reference local30
//                                      ^^^^^^ reference local28
//                                             ^^^^^ reference moves#

        // The item is the same and its already in the correct place
        if (newItem.id == nextOldItem.id && newItem.position == nextOldItem.position) {
//          ^^^^^^^ reference local31
//                  ^^ reference id#
//                        ^^^^^^^^^^^ reference local30
//                                    ^^ reference id#
//                                          ^^^^^^^ reference local31
//                                                  ^^^^^^^^ reference position#
//                                                              ^^^^^^^^^^^ reference local30
//                                                                          ^^^^^^^^ reference position#
          nextOldItem = null;
//        ^^^^^^^^^^^ reference local30
          break;
        }

        int newItemDistance = newItem.pair.position - newItem.position;
//          ^^^^^^^^^^^^^^^ definition local32
//                            ^^^^^^^ reference local31
//                                    ^^^^ reference pair#
//                                         ^^^^^^^^ reference pair#position#
//                                                    ^^^^^^^ reference local31
//                                                            ^^^^^^^^ reference position#
        int oldItemDistance = nextOldItem.pair.position - nextOldItem.position;
//          ^^^^^^^^^^^^^^^ definition local33
//                            ^^^^^^^^^^^ reference local30
//                                        ^^^^ reference pair#
//                                             ^^^^^^^^ reference pair#position#
//                                                        ^^^^^^^^^^^ reference local30
//                                                                    ^^^^^^^^ reference position#

        // Both items are already in the correct position
        if (newItemDistance == 0 && oldItemDistance == 0) {
//          ^^^^^^^^^^^^^^^ reference local32
//                                  ^^^^^^^^^^^^^^^ reference local33
          nextOldItem = null;
//        ^^^^^^^^^^^ reference local30
          break;
        }

        if (oldItemDistance > newItemDistance) {
//          ^^^^^^^^^^^^^^^ reference local33
//                            ^^^^^^^^^^^^^^^ reference local32
          helper.move(nextOldItem.position, nextOldItem.pair.position);
//        ^^^^^^ reference local28
//               ^^^^ reference move#
//                    ^^^^^^^^^^^ reference local30
//                                ^^^^^^^^ reference position#
//                                          ^^^^^^^^^^^ reference local30
//                                                      ^^^^ reference pair#
//                                                           ^^^^^^^^ reference pair#position#

          nextOldItem.position = nextOldItem.pair.position;
//        ^^^^^^^^^^^ reference local30
//                    ^^^^^^^^ reference position#
//                               ^^^^^^^^^^^ reference local30
//                                           ^^^^ reference pair#
//                                                ^^^^^^^^ reference pair#position#
          nextOldItem.lastMoveOp = helper.getNumMoves();
//        ^^^^^^^^^^^ reference local30
//                    ^^^^^^^^^^ reference lastMoveOp#
//                                 ^^^^^^ reference local28
//                                        ^^^^^^^^^^^ reference getNumMoves#

          nextOldItem = getNextItemWithPair(oldItemIterator);
//        ^^^^^^^^^^^ reference local30
//                      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                          ^^^^^^^^^^^^^^^ reference local29
        } else {
          helper.move(newItem.pair.position, newItem.position);
//        ^^^^^^ reference local28
//               ^^^^ reference move#
//                    ^^^^^^^ reference local31
//                            ^^^^ reference pair#
//                                 ^^^^^^^^ reference pair#position#
//                                           ^^^^^^^ reference local31
//                                                   ^^^^^^^^ reference position#

          newItem.pair.position = newItem.position;
//        ^^^^^^^ reference local31
//                ^^^^ reference pair#
//                     ^^^^^^^^ reference pair#position#
//                                ^^^^^^^ reference local31
//                                        ^^^^^^^^ reference position#
          newItem.pair.lastMoveOp = helper.getNumMoves();
//        ^^^^^^^ reference local31
//                ^^^^ reference pair#
//                     ^^^^^^^^^^ reference pair#lastMoveOp#
//                                  ^^^^^^ reference local28
//                                         ^^^^^^^^^^^ reference getNumMoves#
          break;
        }
      }
    }
  }

  /**
   * Apply the movement operations to the given item to update its position. Only applies the
   * operations that have not been applied yet, and stores how many operations have been applied so
   * we know which ones to apply next time.
   */
  private void updateItemPosition(ModelState item, List<UpdateOp> moveOps) {
//             ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#updateItemPosition().
//                                ^^^^^^^^^^ reference _root_/
//                                           ^^^^ definition local34
//                                                 ^^^^ reference java/util/List#
//                                                      ^^^^^^^^ reference _root_/
//                                                                ^^^^^^^ definition local35
    int size = moveOps.size();
//      ^^^^ definition local36
//             ^^^^^^^ reference local35
//                     ^^^^ reference java/util/List#size().

    for (int i = item.lastMoveOp; i < size; i++) {
//           ^ definition local37
//               ^^^^ reference local34
//                    ^^^^^^^^^^ reference lastMoveOp#
//                                ^ reference local37
//                                    ^^^^ reference local36
//                                          ^ reference local37
      UpdateOp moveOp = moveOps.get(i);
//    ^^^^^^^^ reference _root_/
//             ^^^^^^ definition local38
//                      ^^^^^^^ reference local35
//                              ^^^ reference java/util/List#get().
//                                  ^ reference local37
      int fromPosition = moveOp.positionStart;
//        ^^^^^^^^^^^^ definition local39
//                       ^^^^^^ reference local38
//                              ^^^^^^^^^^^^^ reference positionStart#
      int toPosition = moveOp.itemCount;
//        ^^^^^^^^^^ definition local40
//                     ^^^^^^ reference local38
//                            ^^^^^^^^^ reference itemCount#

      if (item.position > fromPosition && item.position <= toPosition) {
//        ^^^^ reference local34
//             ^^^^^^^^ reference position#
//                        ^^^^^^^^^^^^ reference local39
//                                        ^^^^ reference local34
//                                             ^^^^^^^^ reference position#
//                                                         ^^^^^^^^^^ reference local40
        item.position--;
//      ^^^^ reference local34
//           ^^^^^^^^ reference position#
      } else if (item.position < fromPosition && item.position >= toPosition) {
//               ^^^^ reference local34
//                    ^^^^^^^^ reference position#
//                               ^^^^^^^^^^^^ reference local39
//                                               ^^^^ reference local34
//                                                    ^^^^^^^^ reference position#
//                                                                ^^^^^^^^^^ reference local40
        item.position++;
//      ^^^^ reference local34
//           ^^^^^^^^ reference position#
      }
    }

    item.lastMoveOp = size;
//  ^^^^ reference local34
//       ^^^^^^^^^^ reference lastMoveOp#
//                    ^^^^ reference local36
  }

  /**
   * Gets the next item in the list that has a pair, meaning it wasn't inserted or removed.
   */
  @Nullable
   ^^^^^^^^ reference androidx/annotation/Nullable#
  private ModelState getNextItemWithPair(Iterator<ModelState> iterator) {
//        ^^^^^^^^^^ reference _root_/
//                   ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                       ^^^^^^^^ reference java/util/Iterator#
//                                                ^^^^^^^^^^ reference _root_/
//                                                            ^^^^^^^^ definition local41
    ModelState nextItem = null;
//  ^^^^^^^^^^ reference _root_/
//             ^^^^^^^^ definition local42
    while (nextItem == null && iterator.hasNext()) {
//         ^^^^^^^^ reference local42
//                             ^^^^^^^^ reference local41
//                                      ^^^^^^^ reference java/util/Iterator#hasNext().
      nextItem = iterator.next();
//    ^^^^^^^^ reference local42
//               ^^^^^^^^ reference local41
//                        ^^^^ reference java/util/Iterator#next().

      if (nextItem.pair == null) {
//        ^^^^^^^^ reference local42
//                 ^^^^ reference pair#
        // Skip this one and go on to the next
        nextItem = null;
//      ^^^^^^^^ reference local42
      }
    }

    return nextItem;
//         ^^^^^^^^ reference local42
  }
}
