
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
//    ^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper# class DiffHelper
  private ArrayList<ModelState> oldStateList = new ArrayList<>();
//        ^^^^^^^^^ reference java/util/ArrayList#
//                  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                              ^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#oldStateList. private ArrayList<ModelState> oldStateList
//                                                 ^^^^^^^^^ reference java/util/ArrayList#`<init>`(+1).
  // Using a HashMap instead of a LongSparseArray to
  // have faster look up times at the expense of memory
  private Map<Long, ModelState> oldStateMap = new HashMap<>();
//        ^^^ reference java/util/Map#
//            ^^^^ reference java/lang/Long#
//                  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                              ^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#oldStateMap. private Map<Long, ModelState> oldStateMap
//                                                ^^^^^^^ reference java/util/HashMap#`<init>`(+2).
  private ArrayList<ModelState> currentStateList = new ArrayList<>();
//        ^^^^^^^^^ reference java/util/ArrayList#
//                  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#currentStateList. private ArrayList<ModelState> currentStateList
//                                                     ^^^^^^^^^ reference java/util/ArrayList#`<init>`(+1).
  private Map<Long, ModelState> currentStateMap = new HashMap<>();
//        ^^^ reference java/util/Map#
//            ^^^^ reference java/lang/Long#
//                  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#currentStateMap. private Map<Long, ModelState> currentStateMap
//                                                    ^^^^^^^ reference java/util/HashMap#`<init>`(+2).
  private final BaseEpoxyAdapter adapter;
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#
//                               ^^^^^^^ definition com/airbnb/epoxy/DiffHelper#adapter. private final BaseEpoxyAdapter adapter
  private final boolean immutableModels;
//                      ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#immutableModels. private final boolean immutableModels


  DiffHelper(BaseEpoxyAdapter adapter, boolean immutableModels) {
//^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#`<init>`(). DiffHelper(BaseEpoxyAdapter adapter, boolean immutableModels)
//           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#
//                            ^^^^^^^ definition local0 BaseEpoxyAdapter adapter
//                                             ^^^^^^^^^^^^^^^ definition local1 boolean immutableModels
    this.adapter = adapter;
//       ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                 ^^^^^^^ reference local0
    this.immutableModels = immutableModels;
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#immutableModels.
//                         ^^^^^^^^^^^^^^^ reference local1
    adapter.registerAdapterDataObserver(observer);
//  ^^^^^^^ reference local0
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#registerAdapterDataObserver#
//                                      ^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#observer.
  }

  private final RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() {
//              ^^^^^^^^^^^^ reference RecyclerView/
//                           ^^^^^^^^^^^^^^^^^^^ reference RecyclerView/AdapterDataObserver#
//                                               ^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#observer. private final unresolved_type observer
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
//     ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#notifyModelChanges(). void notifyModelChanges()
    UpdateOpHelper updateOpHelper = new UpdateOpHelper();
//  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#
//                 ^^^^^^^^^^^^^^ definition local2 UpdateOpHelper updateOpHelper
//                                      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#`<init>`().

    buildDiff(updateOpHelper);
//  ^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#buildDiff().
//            ^^^^^^^^^^^^^^ reference local2

    // Send out the proper notify calls for the diff. We remove our
    // observer first so that we don't react to our own notify calls
    adapter.unregisterAdapterDataObserver(observer);
//  ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#unregisterAdapterDataObserver#
//                                        ^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#observer.
    notifyChanges(updateOpHelper);
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#notifyChanges().
//                ^^^^^^^^^^^^^^ reference local2
    adapter.registerAdapterDataObserver(observer);
//  ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#registerAdapterDataObserver#
//                                      ^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#observer.
  }

  private void notifyChanges(UpdateOpHelper opHelper) {
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#notifyChanges(). private void notifyChanges(UpdateOpHelper opHelper)
//                           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#
//                                          ^^^^^^^^ definition local3 UpdateOpHelper opHelper
    for (UpdateOp op : opHelper.opList) {
//       ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                ^^ definition local4 UpdateOp op
//                     ^^^^^^^^ reference local3
//                              ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#opList.
      switch (op.type) {
//            ^^ reference local4
//               ^^^^ reference com/airbnb/epoxy/UpdateOp#type.
        case UpdateOp.ADD:
//           ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                    ^^^ reference com/airbnb/epoxy/UpdateOp#ADD.
          adapter.notifyItemRangeInserted(op.positionStart, op.itemCount);
//        ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemRangeInserted#
//                                        ^^ reference local4
//                                           ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                                          ^^ reference local4
//                                                             ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
          break;
        case UpdateOp.MOVE:
//           ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                    ^^^^ reference com/airbnb/epoxy/UpdateOp#MOVE.
          adapter.notifyItemMoved(op.positionStart, op.itemCount);
//        ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemMoved#
//                                ^^ reference local4
//                                   ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                                  ^^ reference local4
//                                                     ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
          break;
        case UpdateOp.REMOVE:
//           ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                    ^^^^^^ reference com/airbnb/epoxy/UpdateOp#REMOVE.
          adapter.notifyItemRangeRemoved(op.positionStart, op.itemCount);
//        ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemRangeRemoved#
//                                       ^^ reference local4
//                                          ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                                         ^^ reference local4
//                                                            ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
          break;
        case UpdateOp.UPDATE:
//           ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                    ^^^^^^ reference com/airbnb/epoxy/UpdateOp#UPDATE.
          if (immutableModels && op.payloads != null) {
//            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#immutableModels.
//                               ^^ reference local4
//                                  ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#payloads.
            adapter.notifyItemRangeChanged(op.positionStart, op.itemCount,
//          ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemRangeChanged#
//                                         ^^ reference local4
//                                            ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                                           ^^ reference local4
//                                                              ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
                new DiffPayload(op.payloads));
//                  ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#`<init>`().
//                              ^^ reference local4
//                                 ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#payloads.
          } else {
            adapter.notifyItemRangeChanged(op.positionStart, op.itemCount);
//          ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemRangeChanged#
//                                         ^^ reference local4
//                                            ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                                           ^^ reference local4
//                                                              ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
          }
          break;
        default:
          throw new IllegalArgumentException("Unknown type: " + op.type);
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#`<init>`(+1).
//                                                              ^^ reference local4
//                                                                 ^^^^ reference com/airbnb/epoxy/UpdateOp#type.
      }
    }
  }

  /**
   * Create a list of operations that define the difference between {@link #oldStateList} and {@link
   * #currentStateList}.
   */
  private UpdateOpHelper buildDiff(UpdateOpHelper updateOpHelper) {
//        ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#
//                       ^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#buildDiff(). private UpdateOpHelper buildDiff(UpdateOpHelper updateOpHelper)
//                                 ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#
//                                                ^^^^^^^^^^^^^^ definition local5 UpdateOpHelper updateOpHelper
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
//          ^^^^^^^^^^^^^ definition local6 boolean hasInsertions
        oldStateList.size() - updateOpHelper.getNumRemovals() != currentStateList.size();
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//                   ^^^^ reference java/util/ArrayList#size().
//                            ^^^^^^^^^^^^^^ reference local5
//                                           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#getNumRemovals().
//                                                               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                                                                                ^^^^ reference java/util/ArrayList#size().
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
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#resetOldState(). private void resetOldState()
    oldStateList.clear();
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//               ^^^^^ reference java/util/ArrayList#clear().
    oldStateMap.clear();
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateMap.
//              ^^^^^ reference java/util/Map#clear().
  }

  private void prepareStateForDiff() {
//             ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#prepareStateForDiff(). private void prepareStateForDiff()
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
//            ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                        ^^^^^^^^ definition local7 ArrayList<ModelState> tempList
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
//            ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                        ^^^^^^^ definition local8 Map<Long, ModelState> tempMap
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
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                  ^^^^^^^^^^ definition local9 ModelState modelState
//                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
      modelState.pair = null;
//    ^^^^^^^^^^ reference local9
//               ^^^^ reference com/airbnb/epoxy/ModelState#pair.
    }

    int modelCount = adapter.getCurrentModels().size();
//      ^^^^^^^^^^ definition local10 int modelCount
//                   ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                              ^^^^ reference java/util/List#size().
    currentStateList.ensureCapacity(modelCount);
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                   ^^^^^^^^^^^^^^ reference java/util/ArrayList#ensureCapacity().
//                                  ^^^^^^^^^^ reference local10

    for (int i = 0; i < modelCount; i++) {
//           ^ definition local11 int i
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
//        ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                   ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#createStateForPosition(). private ModelState createStateForPosition(int position)
//                                              ^^^^^^^^ definition local12 int position
    EpoxyModel<?> model = adapter.getCurrentModels().get(position);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local13 EpoxyModel<?> model
//                        ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                                   ^^^ reference java/util/List#get().
//                                                       ^^^^^^^^ reference local12
    model.addedToAdapter = true;
//  ^^^^^ reference local13
//        ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#addedToAdapter.
    ModelState state = ModelState.build(model, position, immutableModels);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//             ^^^^^ definition local14 ModelState state
//                     ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                                ^^^^^ reference com/airbnb/epoxy/ModelState#build().
//                                      ^^^^^ reference local13
//                                             ^^^^^^^^ reference local12
//                                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#immutableModels.

    ModelState previousValue = currentStateMap.put(state.id, state);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//             ^^^^^^^^^^^^^ definition local15 ModelState previousValue
//                             ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateMap.
//                                             ^^^ reference java/util/Map#put().
//                                                 ^^^^^ reference local14
//                                                       ^^ reference com/airbnb/epoxy/ModelState#id.
//                                                           ^^^^^ reference local14
    if (previousValue != null) {
//      ^^^^^^^^^^^^^ reference local15
      int previousPosition = previousValue.position;
//        ^^^^^^^^^^^^^^^^ definition local16 int previousPosition
//                           ^^^^^^^^^^^^^ reference local15
//                                         ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
      EpoxyModel<?> previousModel = adapter.getCurrentModels().get(previousPosition);
//    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^^^^^^^^^ definition local17 EpoxyModel<?> previousModel
//                                  ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                                          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                                             ^^^ reference java/util/List#get().
//                                                                 ^^^^^^^^^^^^^^^^ reference local16
      throw new IllegalStateException("Two models have the same ID. ID's must be unique!"
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
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
//             ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#collectRemovals(). private void collectRemovals(UpdateOpHelper helper)
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#
//                                            ^^^^^^ definition local18 UpdateOpHelper helper
    for (ModelState state : oldStateList) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                  ^^^^^ definition local19 ModelState state
//                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
      // Update the position of the item to take into account previous removals,
      // so that future operations will reference the correct position
      state.position -= helper.getNumRemovals();
//    ^^^^^ reference local19
//          ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                      ^^^^^^ reference local18
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#getNumRemovals().

      // This is our first time going through the list, so we
      // look up the item with the matching id in the new
      // list and hold a reference to it so that we can access it quickly in the future
      state.pair = currentStateMap.get(state.id);
//    ^^^^^ reference local19
//          ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateMap.
//                                 ^^^ reference java/util/Map#get().
//                                     ^^^^^ reference local19
//                                           ^^ reference com/airbnb/epoxy/ModelState#id.
      if (state.pair != null) {
//        ^^^^^ reference local19
//              ^^^^ reference com/airbnb/epoxy/ModelState#pair.
        state.pair.pair = state;
//      ^^^^^ reference local19
//            ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                 ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                        ^^^^^ reference local19
        continue;
      }

      helper.remove(state.position);
//    ^^^^^^ reference local18
//           ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#remove().
//                  ^^^^^ reference local19
//                        ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
    }
  }

  /**
   * Find all insertion operations and add them to the result list. The general strategy here is to
   * walk through the {@link #currentStateList} and check for items that don't exist in the old
   * list. Walking through it in order makes it easy to batch adjacent insertions.
   */
  private void collectInsertions(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#collectInsertions(). private void collectInsertions(UpdateOpHelper helper)
//                               ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#
//                                              ^^^^^^ definition local20 UpdateOpHelper helper
    Iterator<ModelState> oldItemIterator = oldStateList.iterator();
//  ^^^^^^^^ reference java/util/Iterator#
//           ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                       ^^^^^^^^^^^^^^^ definition local21 Iterator<ModelState> oldItemIterator
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//                                                      ^^^^^^^^ reference java/util/ArrayList#iterator().

    for (ModelState itemToInsert : currentStateList) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                  ^^^^^^^^^^^^ definition local22 ModelState itemToInsert
//                                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
      if (itemToInsert.pair != null) {
//        ^^^^^^^^^^^^ reference local22
//                     ^^^^ reference com/airbnb/epoxy/ModelState#pair.
        // Update the position of the next item in the old list to take any insertions into account
        ModelState nextOldItem = getNextItemWithPair(oldItemIterator);
//      ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                 ^^^^^^^^^^^ definition local23 ModelState nextOldItem
//                               ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                                   ^^^^^^^^^^^^^^^ reference local21
        if (nextOldItem != null) {
//          ^^^^^^^^^^^ reference local23
          nextOldItem.position += helper.getNumInsertions();
//        ^^^^^^^^^^^ reference local23
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                ^^^^^^ reference local20
//                                       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#getNumInsertions().
        }
        continue;
      }

      helper.add(itemToInsert.position);
//    ^^^^^^ reference local20
//           ^^^ reference com/airbnb/epoxy/UpdateOpHelper#add().
//               ^^^^^^^^^^^^ reference local22
//                            ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
    }
  }

  /**
   * Check if any items have had their values changed, batching if possible.
   */
  private void collectChanges(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#collectChanges(). private void collectChanges(UpdateOpHelper helper)
//                            ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#
//                                           ^^^^^^ definition local24 UpdateOpHelper helper
    for (ModelState newItem : currentStateList) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                  ^^^^^^^ definition local25 ModelState newItem
//                            ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
      ModelState previousItem = newItem.pair;
//    ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//               ^^^^^^^^^^^^ definition local26 ModelState previousItem
//                              ^^^^^^^ reference local25
//                                      ^^^^ reference com/airbnb/epoxy/ModelState#pair.
      if (previousItem == null) {
//        ^^^^^^^^^^^^ reference local26
        continue;
      }

      // We use equals when we know the models are immutable and available, otherwise we have to
      // rely on the stored hashCode
      boolean modelChanged;
//            ^^^^^^^^^^^^ definition local27 boolean modelChanged
      if (immutableModels) {
//        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#immutableModels.
        // Make sure that the old model hasn't changed, otherwise comparing it with the new one
        // won't be accurate.
        if (previousItem.model.isDebugValidationEnabled()) {
//          ^^^^^^^^^^^^ reference local26
//                       ^^^^^ reference com/airbnb/epoxy/ModelState#model.
//                             ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#isDebugValidationEnabled().
          previousItem.model
//        ^^^^^^^^^^^^ reference local26
//                     ^^^^^ reference com/airbnb/epoxy/ModelState#model.
              .validateStateHasNotChangedSinceAdded("Model was changed before it could be diffed.",
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#validateStateHasNotChangedSinceAdded().
                  previousItem.position);
//                ^^^^^^^^^^^^ reference local26
//                             ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
        }

        modelChanged = !previousItem.model.equals(newItem.model);
//      ^^^^^^^^^^^^ reference local27
//                      ^^^^^^^^^^^^ reference local26
//                                   ^^^^^ reference com/airbnb/epoxy/ModelState#model.
//                                         ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#equals().
//                                                ^^^^^^^ reference local25
//                                                        ^^^^^ reference com/airbnb/epoxy/ModelState#model.
      } else {
        modelChanged = previousItem.hashCode != newItem.hashCode;
//      ^^^^^^^^^^^^ reference local27
//                     ^^^^^^^^^^^^ reference local26
//                                  ^^^^^^^^ reference com/airbnb/epoxy/ModelState#hashCode.
//                                              ^^^^^^^ reference local25
//                                                      ^^^^^^^^ reference com/airbnb/epoxy/ModelState#hashCode.
      }

      if (modelChanged) {
//        ^^^^^^^^^^^^ reference local27
        helper.update(newItem.position, previousItem.model);
//      ^^^^^^ reference local24
//             ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#update(+1).
//                    ^^^^^^^ reference local25
//                            ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                      ^^^^^^^^^^^^ reference local26
//                                                   ^^^^^ reference com/airbnb/epoxy/ModelState#model.
      }
    }
  }

  /**
   * Check which items have had a position changed. Recyclerview does not support batching these.
   */
  private void collectMoves(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#collectMoves(). private void collectMoves(UpdateOpHelper helper)
//                          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#
//                                         ^^^^^^ definition local28 UpdateOpHelper helper
    // This walks through both the new and old list simultaneous and checks for position changes.
    Iterator<ModelState> oldItemIterator = oldStateList.iterator();
//  ^^^^^^^^ reference java/util/Iterator#
//           ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                       ^^^^^^^^^^^^^^^ definition local29 Iterator<ModelState> oldItemIterator
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//                                                      ^^^^^^^^ reference java/util/ArrayList#iterator().
    ModelState nextOldItem = null;
//  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//             ^^^^^^^^^^^ definition local30 ModelState nextOldItem

    for (ModelState newItem : currentStateList) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                  ^^^^^^^ definition local31 ModelState newItem
//                            ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
      if (newItem.pair == null) {
//        ^^^^^^^ reference local31
//                ^^^^ reference com/airbnb/epoxy/ModelState#pair.
        // This item was inserted. However, insertions are done at the item's final position, and
        // aren't smart about inserting at a different position to take future moves into account.
        // As the old state list is updated to reflect moves, it needs to also consider insertions
        // affected by those moves in order for the final change set to be correct
        if (helper.moves.isEmpty()) {
//          ^^^^^^ reference local28
//                 ^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#moves.
//                       ^^^^^^^ reference java/util/List#isEmpty().
          // There have been no moves, so the item is still at it's correct position
          continue;
        } else {
          // There have been moves, so the old list needs to take this inserted item
          // into account. The old list doesn't have this item inserted into it
          // (for optimization purposes), but we can create a pair for this item to
          // track its position in the old list and move it back to its final position if necessary
          newItem.pairWithSelf();
//        ^^^^^^^ reference local31
//                ^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#pairWithSelf().
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
//                              ^^^^ reference com/airbnb/epoxy/ModelState#pair.
        }
      }

      while (nextOldItem != null) {
//           ^^^^^^^^^^^ reference local30
        // Make sure the positions are updated to the latest
        // move operations before we calculate the next move
        updateItemPosition(newItem.pair, helper.moves);
//      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#updateItemPosition().
//                         ^^^^^^^ reference local31
//                                 ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                                       ^^^^^^ reference local28
//                                              ^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#moves.
        updateItemPosition(nextOldItem, helper.moves);
//      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#updateItemPosition().
//                         ^^^^^^^^^^^ reference local30
//                                      ^^^^^^ reference local28
//                                             ^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#moves.

        // The item is the same and its already in the correct place
        if (newItem.id == nextOldItem.id && newItem.position == nextOldItem.position) {
//          ^^^^^^^ reference local31
//                  ^^ reference com/airbnb/epoxy/ModelState#id.
//                        ^^^^^^^^^^^ reference local30
//                                    ^^ reference com/airbnb/epoxy/ModelState#id.
//                                          ^^^^^^^ reference local31
//                                                  ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                                              ^^^^^^^^^^^ reference local30
//                                                                          ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
          nextOldItem = null;
//        ^^^^^^^^^^^ reference local30
          break;
        }

        int newItemDistance = newItem.pair.position - newItem.position;
//          ^^^^^^^^^^^^^^^ definition local32 int newItemDistance
//                            ^^^^^^^ reference local31
//                                    ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                                         ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                                    ^^^^^^^ reference local31
//                                                            ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
        int oldItemDistance = nextOldItem.pair.position - nextOldItem.position;
//          ^^^^^^^^^^^^^^^ definition local33 int oldItemDistance
//                            ^^^^^^^^^^^ reference local30
//                                        ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                                             ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                                        ^^^^^^^^^^^ reference local30
//                                                                    ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.

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
//               ^^^^ reference com/airbnb/epoxy/UpdateOpHelper#move().
//                    ^^^^^^^^^^^ reference local30
//                                ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                          ^^^^^^^^^^^ reference local30
//                                                      ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                                                           ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.

          nextOldItem.position = nextOldItem.pair.position;
//        ^^^^^^^^^^^ reference local30
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                               ^^^^^^^^^^^ reference local30
//                                           ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                                                ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
          nextOldItem.lastMoveOp = helper.getNumMoves();
//        ^^^^^^^^^^^ reference local30
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#lastMoveOp.
//                                 ^^^^^^ reference local28
//                                        ^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#getNumMoves().

          nextOldItem = getNextItemWithPair(oldItemIterator);
//        ^^^^^^^^^^^ reference local30
//                      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                          ^^^^^^^^^^^^^^^ reference local29
        } else {
          helper.move(newItem.pair.position, newItem.position);
//        ^^^^^^ reference local28
//               ^^^^ reference com/airbnb/epoxy/UpdateOpHelper#move().
//                    ^^^^^^^ reference local31
//                            ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                                 ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                           ^^^^^^^ reference local31
//                                                   ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.

          newItem.pair.position = newItem.position;
//        ^^^^^^^ reference local31
//                ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                     ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                ^^^^^^^ reference local31
//                                        ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
          newItem.pair.lastMoveOp = helper.getNumMoves();
//        ^^^^^^^ reference local31
//                ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                     ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#lastMoveOp.
//                                  ^^^^^^ reference local28
//                                         ^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#getNumMoves().
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
//             ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#updateItemPosition(). private void updateItemPosition(ModelState item, List<UpdateOp> moveOps)
//                                ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                                           ^^^^ definition local34 ModelState item
//                                                 ^^^^ reference java/util/List#
//                                                      ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                                                                ^^^^^^^ definition local35 List<UpdateOp> moveOps
    int size = moveOps.size();
//      ^^^^ definition local36 int size
//             ^^^^^^^ reference local35
//                     ^^^^ reference java/util/List#size().

    for (int i = item.lastMoveOp; i < size; i++) {
//           ^ definition local37 int i
//               ^^^^ reference local34
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#lastMoveOp.
//                                ^ reference local37
//                                    ^^^^ reference local36
//                                          ^ reference local37
      UpdateOp moveOp = moveOps.get(i);
//    ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//             ^^^^^^ definition local38 UpdateOp moveOp
//                      ^^^^^^^ reference local35
//                              ^^^ reference java/util/List#get().
//                                  ^ reference local37
      int fromPosition = moveOp.positionStart;
//        ^^^^^^^^^^^^ definition local39 int fromPosition
//                       ^^^^^^ reference local38
//                              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
      int toPosition = moveOp.itemCount;
//        ^^^^^^^^^^ definition local40 int toPosition
//                     ^^^^^^ reference local38
//                            ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.

      if (item.position > fromPosition && item.position <= toPosition) {
//        ^^^^ reference local34
//             ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                        ^^^^^^^^^^^^ reference local39
//                                        ^^^^ reference local34
//                                             ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                                         ^^^^^^^^^^ reference local40
        item.position--;
//      ^^^^ reference local34
//           ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
      } else if (item.position < fromPosition && item.position >= toPosition) {
//               ^^^^ reference local34
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                               ^^^^^^^^^^^^ reference local39
//                                               ^^^^ reference local34
//                                                    ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                                                ^^^^^^^^^^ reference local40
        item.position++;
//      ^^^^ reference local34
//           ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
      }
    }

    item.lastMoveOp = size;
//  ^^^^ reference local34
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#lastMoveOp.
//                    ^^^^ reference local36
  }

  /**
   * Gets the next item in the list that has a pair, meaning it wasn't inserted or removed.
   */
  @Nullable
// ^^^^^^^^ reference androidx/annotation/Nullable#
  private ModelState getNextItemWithPair(Iterator<ModelState> iterator) {
//        ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                   ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#getNextItemWithPair(). @Nullable private ModelState getNextItemWithPair(Iterator<ModelState> iterator)
//                                       ^^^^^^^^ reference java/util/Iterator#
//                                                ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                                                            ^^^^^^^^ definition local41 Iterator<ModelState> iterator
    ModelState nextItem = null;
//  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//             ^^^^^^^^ definition local42 ModelState nextItem
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
//                 ^^^^ reference com/airbnb/epoxy/ModelState#pair.
        // Skip this one and go on to the next
        nextItem = null;
//      ^^^^^^^^ reference local42
      }
    }

    return nextItem;
//         ^^^^^^^^ reference local42
  }
}
