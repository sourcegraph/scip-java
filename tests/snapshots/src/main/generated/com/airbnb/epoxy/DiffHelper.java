
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
//                                                              ^^^^^^^^^^^^ reference RecyclerView/
//                                                                           ^^^^^^^^^^^^^^^^^^^ reference RecyclerView/AdapterDataObserver#
    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onChanged() {
//              ^^^^^^^^^ definition local3 @Override public void onChanged()
      throw new UnsupportedOperationException(
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/UnsupportedOperationException#`<init>`(+1).
          "Diffing is enabled. You should use notifyModelsChanged instead of notifyDataSetChanged");
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onItemRangeChanged(int positionStart, int itemCount) {
//              ^^^^^^^^^^^^^^^^^^ definition local4 @Override public void onItemRangeChanged(int positionStart, int itemCount)
//                                     ^^^^^^^^^^^^^ definition local8 int positionStart
//                                                        ^^^^^^^^^ definition local9 int itemCount
      for (int i = positionStart; i < positionStart + itemCount; i++) {
//             ^ definition local10 int i
//                 ^^^^^^^^^^^^^ reference local8
//                                ^ reference local10
//                                    ^^^^^^^^^^^^^ reference local8
//                                                    ^^^^^^^^^ reference local9
//                                                               ^ reference local10
        currentStateList.get(i).hashCode = adapter.getCurrentModels().get(i).hashCode();
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                       ^^^ reference java/util/ArrayList#get().
//                           ^ reference local10
//                              ^^^^^^^^ reference com/airbnb/epoxy/ModelState#hashCode.
//                                         ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                                                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                                                    ^^^ reference java/util/List#get().
//                                                                        ^ reference local10
//                                                                           ^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#hashCode().
      }
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onItemRangeInserted(int positionStart, int itemCount) {
//              ^^^^^^^^^^^^^^^^^^^ definition local5 @Override public void onItemRangeInserted(int positionStart, int itemCount)
//                                      ^^^^^^^^^^^^^ definition local11 int positionStart
//                                                         ^^^^^^^^^ definition local12 int itemCount
      if (itemCount == 0) {
//        ^^^^^^^^^ reference local12
        // no-op
        return;
      }

      if (itemCount == 1 || positionStart == currentStateList.size()) {
//        ^^^^^^^^^ reference local12
//                          ^^^^^^^^^^^^^ reference local11
//                                           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                                                            ^^^^ reference java/util/ArrayList#size().
        for (int i = positionStart; i < positionStart + itemCount; i++) {
//               ^ definition local13 int i
//                   ^^^^^^^^^^^^^ reference local11
//                                  ^ reference local13
//                                      ^^^^^^^^^^^^^ reference local11
//                                                      ^^^^^^^^^ reference local12
//                                                                 ^ reference local13
          currentStateList.add(i, createStateForPosition(i));
//        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                         ^^^ reference java/util/ArrayList#add(+2).
//                             ^ reference local13
//                                ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#createStateForPosition().
//                                                       ^ reference local13
        }
      } else {
        // Add in a batch since multiple insertions to the middle of the list are slow
        List<ModelState> newModels = new ArrayList<>(itemCount);
//      ^^^^ reference java/util/List#
//           ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                       ^^^^^^^^^ definition local14 List<ModelState> newModels
//                                       ^^^^^^^^^ reference java/util/ArrayList#`<init>`().
//                                                   ^^^^^^^^^ reference local12
        for (int i = positionStart; i < positionStart + itemCount; i++) {
//               ^ definition local15 int i
//                   ^^^^^^^^^^^^^ reference local11
//                                  ^ reference local15
//                                      ^^^^^^^^^^^^^ reference local11
//                                                      ^^^^^^^^^ reference local12
//                                                                 ^ reference local15
          newModels.add(createStateForPosition(i));
//        ^^^^^^^^^ reference local14
//                  ^^^ reference java/util/List#add().
//                      ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#createStateForPosition().
//                                             ^ reference local15
        }

        currentStateList.addAll(positionStart, newModels);
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                       ^^^^^^ reference java/util/ArrayList#addAll(+1).
//                              ^^^^^^^^^^^^^ reference local11
//                                             ^^^^^^^^^ reference local14
      }

      // Update positions of affected items
      int size = currentStateList.size();
//        ^^^^ definition local16 int size
//               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                                ^^^^ reference java/util/ArrayList#size().
      for (int i = positionStart + itemCount; i < size; i++) {
//             ^ definition local17 int i
//                 ^^^^^^^^^^^^^ reference local11
//                                 ^^^^^^^^^ reference local12
//                                            ^ reference local17
//                                                ^^^^ reference local16
//                                                      ^ reference local17
        currentStateList.get(i).position += itemCount;
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                       ^^^ reference java/util/ArrayList#get().
//                           ^ reference local17
//                              ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                          ^^^^^^^^^ reference local12
      }
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onItemRangeRemoved(int positionStart, int itemCount) {
//              ^^^^^^^^^^^^^^^^^^ definition local6 @Override public void onItemRangeRemoved(int positionStart, int itemCount)
//                                     ^^^^^^^^^^^^^ definition local18 int positionStart
//                                                        ^^^^^^^^^ definition local19 int itemCount
      if (itemCount == 0) {
//        ^^^^^^^^^ reference local19
        // no-op
        return;
      }

      List<ModelState> modelsToRemove =
//    ^^^^ reference java/util/List#
//         ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                     ^^^^^^^^^^^^^^ definition local20 List<ModelState> modelsToRemove
          currentStateList.subList(positionStart, positionStart + itemCount);
//        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                         ^^^^^^^ reference java/util/ArrayList#subList().
//                                 ^^^^^^^^^^^^^ reference local18
//                                                ^^^^^^^^^^^^^ reference local18
//                                                                ^^^^^^^^^ reference local19
      for (ModelState model : modelsToRemove) {
//         ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                    ^^^^^ definition local21 ModelState model
//                            ^^^^^^^^^^^^^^ reference local20
        currentStateMap.remove(model.id);
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateMap.
//                      ^^^^^^ reference java/util/Map#remove().
//                             ^^^^^ reference local21
//                                   ^^ reference com/airbnb/epoxy/ModelState#id.
      }
      modelsToRemove.clear();
//    ^^^^^^^^^^^^^^ reference local20
//                   ^^^^^ reference java/util/List#clear().

      // Update positions of affected items
      int size = currentStateList.size();
//        ^^^^ definition local22 int size
//               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                                ^^^^ reference java/util/ArrayList#size().
      for (int i = positionStart; i < size; i++) {
//             ^ definition local23 int i
//                 ^^^^^^^^^^^^^ reference local18
//                                ^ reference local23
//                                    ^^^^ reference local22
//                                          ^ reference local23
        currentStateList.get(i).position -= itemCount;
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                       ^^^ reference java/util/ArrayList#get().
//                           ^ reference local23
//                              ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                          ^^^^^^^^^ reference local19
      }
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
//              ^^^^^^^^^^^^^^^^ definition local7 @Override public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount)
//                                   ^^^^^^^^^^^^ definition local24 int fromPosition
//                                                     ^^^^^^^^^^ definition local25 int toPosition
//                                                                     ^^^^^^^^^ definition local26 int itemCount
      if (fromPosition == toPosition) {
//        ^^^^^^^^^^^^ reference local24
//                        ^^^^^^^^^^ reference local25
        // no-op
        return;
      }

      if (itemCount != 1) {
//        ^^^^^^^^^ reference local26
        throw new IllegalArgumentException("Moving more than 1 item at a time is not "
//                ^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#`<init>`(+1).
            + "supported. Number of items moved: " + itemCount);
//                                                   ^^^^^^^^^ reference local26
      }

      ModelState model = currentStateList.remove(fromPosition);
//    ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//               ^^^^^ definition local27 ModelState model
//                       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                                        ^^^^^^ reference java/util/ArrayList#remove().
//                                               ^^^^^^^^^^^^ reference local24
      model.position = toPosition;
//    ^^^^^ reference local27
//          ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                     ^^^^^^^^^^ reference local25
      currentStateList.add(toPosition, model);
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                     ^^^ reference java/util/ArrayList#add(+2).
//                         ^^^^^^^^^^ reference local25
//                                     ^^^^^ reference local27

      if (fromPosition < toPosition) {
//        ^^^^^^^^^^^^ reference local24
//                       ^^^^^^^^^^ reference local25
        // shift the affected items left
        for (int i = fromPosition; i < toPosition; i++) {
//               ^ definition local28 int i
//                   ^^^^^^^^^^^^ reference local24
//                                 ^ reference local28
//                                     ^^^^^^^^^^ reference local25
//                                                 ^ reference local28
          currentStateList.get(i).position--;
//        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                         ^^^ reference java/util/ArrayList#get().
//                             ^ reference local28
//                                ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
        }
      } else {
        // shift the affected items right
        for (int i = toPosition + 1; i <= fromPosition; i++) {
//               ^ definition local29 int i
//                   ^^^^^^^^^^ reference local25
//                                   ^ reference local29
//                                        ^^^^^^^^^^^^ reference local24
//                                                      ^ reference local29
          currentStateList.get(i).position++;
//        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                         ^^^ reference java/util/ArrayList#get().
//                             ^ reference local29
//                                ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
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
//                 ^^^^^^^^^^^^^^ definition local30 UpdateOpHelper updateOpHelper
//                                      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#`<init>`().

    buildDiff(updateOpHelper);
//  ^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#buildDiff().
//            ^^^^^^^^^^^^^^ reference local30

    // Send out the proper notify calls for the diff. We remove our
    // observer first so that we don't react to our own notify calls
    adapter.unregisterAdapterDataObserver(observer);
//  ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#unregisterAdapterDataObserver#
//                                        ^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#observer.
    notifyChanges(updateOpHelper);
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#notifyChanges().
//                ^^^^^^^^^^^^^^ reference local30
    adapter.registerAdapterDataObserver(observer);
//  ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#registerAdapterDataObserver#
//                                      ^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#observer.
  }

  private void notifyChanges(UpdateOpHelper opHelper) {
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#notifyChanges(). private void notifyChanges(UpdateOpHelper opHelper)
//                           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#
//                                          ^^^^^^^^ definition local31 UpdateOpHelper opHelper
    for (UpdateOp op : opHelper.opList) {
//       ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                ^^ definition local32 UpdateOp op
//                     ^^^^^^^^ reference local31
//                              ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#opList.
      switch (op.type) {
//            ^^ reference local32
//               ^^^^ reference com/airbnb/epoxy/UpdateOp#type.
        case UpdateOp.ADD:
//           ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                    ^^^ reference com/airbnb/epoxy/UpdateOp#ADD.
          adapter.notifyItemRangeInserted(op.positionStart, op.itemCount);
//        ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemRangeInserted#
//                                        ^^ reference local32
//                                           ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                                          ^^ reference local32
//                                                             ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
          break;
        case UpdateOp.MOVE:
//           ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                    ^^^^ reference com/airbnb/epoxy/UpdateOp#MOVE.
          adapter.notifyItemMoved(op.positionStart, op.itemCount);
//        ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemMoved#
//                                ^^ reference local32
//                                   ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                                  ^^ reference local32
//                                                     ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
          break;
        case UpdateOp.REMOVE:
//           ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                    ^^^^^^ reference com/airbnb/epoxy/UpdateOp#REMOVE.
          adapter.notifyItemRangeRemoved(op.positionStart, op.itemCount);
//        ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemRangeRemoved#
//                                       ^^ reference local32
//                                          ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                                         ^^ reference local32
//                                                            ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
          break;
        case UpdateOp.UPDATE:
//           ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                    ^^^^^^ reference com/airbnb/epoxy/UpdateOp#UPDATE.
          if (immutableModels && op.payloads != null) {
//            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#immutableModels.
//                               ^^ reference local32
//                                  ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#payloads.
            adapter.notifyItemRangeChanged(op.positionStart, op.itemCount,
//          ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemRangeChanged#
//                                         ^^ reference local32
//                                            ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                                           ^^ reference local32
//                                                              ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
                new DiffPayload(op.payloads));
//                  ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#`<init>`().
//                              ^^ reference local32
//                                 ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#payloads.
          } else {
            adapter.notifyItemRangeChanged(op.positionStart, op.itemCount);
//          ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemRangeChanged#
//                                         ^^ reference local32
//                                            ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                                           ^^ reference local32
//                                                              ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
          }
          break;
        default:
          throw new IllegalArgumentException("Unknown type: " + op.type);
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#`<init>`(+1).
//                                                              ^^ reference local32
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
//                                                ^^^^^^^^^^^^^^ definition local33 UpdateOpHelper updateOpHelper
    prepareStateForDiff();
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#prepareStateForDiff().

    // The general approach is to first search for removals, then additions, and lastly changes.
    // Focusing on one type of operation at a time makes it easy to coalesce batch changes.
    // When we identify an operation and add it to the
    // result list we update the positions of items in the oldStateList to reflect
    // the change, this way subsequent operations will use the correct, updated positions.
    collectRemovals(updateOpHelper);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#collectRemovals().
//                  ^^^^^^^^^^^^^^ reference local33

    // Only need to check for insertions if new list is bigger
    boolean hasInsertions =
//          ^^^^^^^^^^^^^ definition local34 boolean hasInsertions
        oldStateList.size() - updateOpHelper.getNumRemovals() != currentStateList.size();
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//                   ^^^^ reference java/util/ArrayList#size().
//                            ^^^^^^^^^^^^^^ reference local33
//                                           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#getNumRemovals().
//                                                               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                                                                                ^^^^ reference java/util/ArrayList#size().
    if (hasInsertions) {
//      ^^^^^^^^^^^^^ reference local34
      collectInsertions(updateOpHelper);
//    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#collectInsertions().
//                      ^^^^^^^^^^^^^^ reference local33
    }

    collectMoves(updateOpHelper);
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#collectMoves().
//               ^^^^^^^^^^^^^^ reference local33
    collectChanges(updateOpHelper);
//  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#collectChanges().
//                 ^^^^^^^^^^^^^^ reference local33

    resetOldState();
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#resetOldState().

    return updateOpHelper;
//         ^^^^^^^^^^^^^^ reference local33
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
//                        ^^^^^^^^ definition local35 ArrayList<ModelState> tempList
//                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
    oldStateList = currentStateList;
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
    currentStateList = tempList;
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                     ^^^^^^^^ reference local35

    Map<Long, ModelState> tempMap = oldStateMap;
//  ^^^ reference java/util/Map#
//      ^^^^ reference java/lang/Long#
//            ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                        ^^^^^^^ definition local36 Map<Long, ModelState> tempMap
//                                  ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateMap.
    oldStateMap = currentStateMap;
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateMap.
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateMap.
    currentStateMap = tempMap;
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateMap.
//                    ^^^^^^^ reference local36

    // Remove all pairings in the old states so we can tell which of them were removed. The items
    // that still exist in the new list will be paired when we build the current list state below
    for (ModelState modelState : oldStateList) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                  ^^^^^^^^^^ definition local37 ModelState modelState
//                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
      modelState.pair = null;
//    ^^^^^^^^^^ reference local37
//               ^^^^ reference com/airbnb/epoxy/ModelState#pair.
    }

    int modelCount = adapter.getCurrentModels().size();
//      ^^^^^^^^^^ definition local38 int modelCount
//                   ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                              ^^^^ reference java/util/List#size().
    currentStateList.ensureCapacity(modelCount);
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                   ^^^^^^^^^^^^^^ reference java/util/ArrayList#ensureCapacity().
//                                  ^^^^^^^^^^ reference local38

    for (int i = 0; i < modelCount; i++) {
//           ^ definition local39 int i
//                  ^ reference local39
//                      ^^^^^^^^^^ reference local38
//                                  ^ reference local39
      currentStateList.add(createStateForPosition(i));
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
//                     ^^^ reference java/util/ArrayList#add(+1).
//                         ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#createStateForPosition().
//                                                ^ reference local39
    }
  }

  private ModelState createStateForPosition(int position) {
//        ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                   ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#createStateForPosition(). private ModelState createStateForPosition(int position)
//                                              ^^^^^^^^ definition local40 int position
    EpoxyModel<?> model = adapter.getCurrentModels().get(position);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local41 EpoxyModel<?> model
//                        ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                                   ^^^ reference java/util/List#get().
//                                                       ^^^^^^^^ reference local40
    model.addedToAdapter = true;
//  ^^^^^ reference local41
//        ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#addedToAdapter.
    ModelState state = ModelState.build(model, position, immutableModels);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//             ^^^^^ definition local42 ModelState state
//                     ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                                ^^^^^ reference com/airbnb/epoxy/ModelState#build().
//                                      ^^^^^ reference local41
//                                             ^^^^^^^^ reference local40
//                                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#immutableModels.

    ModelState previousValue = currentStateMap.put(state.id, state);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//             ^^^^^^^^^^^^^ definition local43 ModelState previousValue
//                             ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateMap.
//                                             ^^^ reference java/util/Map#put().
//                                                 ^^^^^ reference local42
//                                                       ^^ reference com/airbnb/epoxy/ModelState#id.
//                                                           ^^^^^ reference local42
    if (previousValue != null) {
//      ^^^^^^^^^^^^^ reference local43
      int previousPosition = previousValue.position;
//        ^^^^^^^^^^^^^^^^ definition local44 int previousPosition
//                           ^^^^^^^^^^^^^ reference local43
//                                         ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
      EpoxyModel<?> previousModel = adapter.getCurrentModels().get(previousPosition);
//    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^^^^^^^^^ definition local45 EpoxyModel<?> previousModel
//                                  ^^^^^^^ reference com/airbnb/epoxy/DiffHelper#adapter.
//                                          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                                             ^^^ reference java/util/List#get().
//                                                                 ^^^^^^^^^^^^^^^^ reference local44
      throw new IllegalStateException("Two models have the same ID. ID's must be unique!"
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
          + " Model at position " + position + ": " + model
//                                  ^^^^^^^^ reference local40
//                                                    ^^^^^ reference local41
          + " Model at position " + previousPosition + ": " + previousModel);
//                                  ^^^^^^^^^^^^^^^^ reference local44
//                                                            ^^^^^^^^^^^^^ reference local45
    }

    return state;
//         ^^^^^ reference local42
  }

  /**
   * Find all removal operations and add them to the result list. The general strategy here is to
   * walk through the {@link #oldStateList} and check for items that don't exist in the new list.
   * Walking through it in order makes it easy to batch adjacent removals.
   */
  private void collectRemovals(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#collectRemovals(). private void collectRemovals(UpdateOpHelper helper)
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#
//                                            ^^^^^^ definition local46 UpdateOpHelper helper
    for (ModelState state : oldStateList) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                  ^^^^^ definition local47 ModelState state
//                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
      // Update the position of the item to take into account previous removals,
      // so that future operations will reference the correct position
      state.position -= helper.getNumRemovals();
//    ^^^^^ reference local47
//          ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                      ^^^^^^ reference local46
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#getNumRemovals().

      // This is our first time going through the list, so we
      // look up the item with the matching id in the new
      // list and hold a reference to it so that we can access it quickly in the future
      state.pair = currentStateMap.get(state.id);
//    ^^^^^ reference local47
//          ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateMap.
//                                 ^^^ reference java/util/Map#get().
//                                     ^^^^^ reference local47
//                                           ^^ reference com/airbnb/epoxy/ModelState#id.
      if (state.pair != null) {
//        ^^^^^ reference local47
//              ^^^^ reference com/airbnb/epoxy/ModelState#pair.
        state.pair.pair = state;
//      ^^^^^ reference local47
//            ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                 ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                        ^^^^^ reference local47
        continue;
      }

      helper.remove(state.position);
//    ^^^^^^ reference local46
//           ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#remove().
//                  ^^^^^ reference local47
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
//                                              ^^^^^^ definition local48 UpdateOpHelper helper
    Iterator<ModelState> oldItemIterator = oldStateList.iterator();
//  ^^^^^^^^ reference java/util/Iterator#
//           ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                       ^^^^^^^^^^^^^^^ definition local49 Iterator<ModelState> oldItemIterator
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//                                                      ^^^^^^^^ reference java/util/ArrayList#iterator().

    for (ModelState itemToInsert : currentStateList) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                  ^^^^^^^^^^^^ definition local50 ModelState itemToInsert
//                                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
      if (itemToInsert.pair != null) {
//        ^^^^^^^^^^^^ reference local50
//                     ^^^^ reference com/airbnb/epoxy/ModelState#pair.
        // Update the position of the next item in the old list to take any insertions into account
        ModelState nextOldItem = getNextItemWithPair(oldItemIterator);
//      ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                 ^^^^^^^^^^^ definition local51 ModelState nextOldItem
//                               ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                                   ^^^^^^^^^^^^^^^ reference local49
        if (nextOldItem != null) {
//          ^^^^^^^^^^^ reference local51
          nextOldItem.position += helper.getNumInsertions();
//        ^^^^^^^^^^^ reference local51
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                ^^^^^^ reference local48
//                                       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#getNumInsertions().
        }
        continue;
      }

      helper.add(itemToInsert.position);
//    ^^^^^^ reference local48
//           ^^^ reference com/airbnb/epoxy/UpdateOpHelper#add().
//               ^^^^^^^^^^^^ reference local50
//                            ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
    }
  }

  /**
   * Check if any items have had their values changed, batching if possible.
   */
  private void collectChanges(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffHelper#collectChanges(). private void collectChanges(UpdateOpHelper helper)
//                            ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#
//                                           ^^^^^^ definition local52 UpdateOpHelper helper
    for (ModelState newItem : currentStateList) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                  ^^^^^^^ definition local53 ModelState newItem
//                            ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
      ModelState previousItem = newItem.pair;
//    ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//               ^^^^^^^^^^^^ definition local54 ModelState previousItem
//                              ^^^^^^^ reference local53
//                                      ^^^^ reference com/airbnb/epoxy/ModelState#pair.
      if (previousItem == null) {
//        ^^^^^^^^^^^^ reference local54
        continue;
      }

      // We use equals when we know the models are immutable and available, otherwise we have to
      // rely on the stored hashCode
      boolean modelChanged;
//            ^^^^^^^^^^^^ definition local55 boolean modelChanged
      if (immutableModels) {
//        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#immutableModels.
        // Make sure that the old model hasn't changed, otherwise comparing it with the new one
        // won't be accurate.
        if (previousItem.model.isDebugValidationEnabled()) {
//          ^^^^^^^^^^^^ reference local54
//                       ^^^^^ reference com/airbnb/epoxy/ModelState#model.
//                             ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#isDebugValidationEnabled().
          previousItem.model
//        ^^^^^^^^^^^^ reference local54
//                     ^^^^^ reference com/airbnb/epoxy/ModelState#model.
              .validateStateHasNotChangedSinceAdded("Model was changed before it could be diffed.",
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#validateStateHasNotChangedSinceAdded().
                  previousItem.position);
//                ^^^^^^^^^^^^ reference local54
//                             ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
        }

        modelChanged = !previousItem.model.equals(newItem.model);
//      ^^^^^^^^^^^^ reference local55
//                      ^^^^^^^^^^^^ reference local54
//                                   ^^^^^ reference com/airbnb/epoxy/ModelState#model.
//                                         ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#equals().
//                                                ^^^^^^^ reference local53
//                                                        ^^^^^ reference com/airbnb/epoxy/ModelState#model.
      } else {
        modelChanged = previousItem.hashCode != newItem.hashCode;
//      ^^^^^^^^^^^^ reference local55
//                     ^^^^^^^^^^^^ reference local54
//                                  ^^^^^^^^ reference com/airbnb/epoxy/ModelState#hashCode.
//                                              ^^^^^^^ reference local53
//                                                      ^^^^^^^^ reference com/airbnb/epoxy/ModelState#hashCode.
      }

      if (modelChanged) {
//        ^^^^^^^^^^^^ reference local55
        helper.update(newItem.position, previousItem.model);
//      ^^^^^^ reference local52
//             ^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#update(+1).
//                    ^^^^^^^ reference local53
//                            ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                      ^^^^^^^^^^^^ reference local54
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
//                                         ^^^^^^ definition local56 UpdateOpHelper helper
    // This walks through both the new and old list simultaneous and checks for position changes.
    Iterator<ModelState> oldItemIterator = oldStateList.iterator();
//  ^^^^^^^^ reference java/util/Iterator#
//           ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                       ^^^^^^^^^^^^^^^ definition local57 Iterator<ModelState> oldItemIterator
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#oldStateList.
//                                                      ^^^^^^^^ reference java/util/ArrayList#iterator().
    ModelState nextOldItem = null;
//  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//             ^^^^^^^^^^^ definition local58 ModelState nextOldItem

    for (ModelState newItem : currentStateList) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                  ^^^^^^^ definition local59 ModelState newItem
//                            ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#currentStateList.
      if (newItem.pair == null) {
//        ^^^^^^^ reference local59
//                ^^^^ reference com/airbnb/epoxy/ModelState#pair.
        // This item was inserted. However, insertions are done at the item's final position, and
        // aren't smart about inserting at a different position to take future moves into account.
        // As the old state list is updated to reflect moves, it needs to also consider insertions
        // affected by those moves in order for the final change set to be correct
        if (helper.moves.isEmpty()) {
//          ^^^^^^ reference local56
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
//        ^^^^^^^ reference local59
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
//        ^^^^^^^^^^^ reference local58
        nextOldItem = getNextItemWithPair(oldItemIterator);
//      ^^^^^^^^^^^ reference local58
//                    ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                        ^^^^^^^^^^^^^^^ reference local57

        // We've already iterated through all old items and moved each
        // item once. However, subsequent moves may have shifted an item out of
        // its correct space once it was already moved. We finish
        // iterating through all the new items to ensure everything is still correct
        if (nextOldItem == null) {
//          ^^^^^^^^^^^ reference local58
          nextOldItem = newItem.pair;
//        ^^^^^^^^^^^ reference local58
//                      ^^^^^^^ reference local59
//                              ^^^^ reference com/airbnb/epoxy/ModelState#pair.
        }
      }

      while (nextOldItem != null) {
//           ^^^^^^^^^^^ reference local58
        // Make sure the positions are updated to the latest
        // move operations before we calculate the next move
        updateItemPosition(newItem.pair, helper.moves);
//      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#updateItemPosition().
//                         ^^^^^^^ reference local59
//                                 ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                                       ^^^^^^ reference local56
//                                              ^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#moves.
        updateItemPosition(nextOldItem, helper.moves);
//      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#updateItemPosition().
//                         ^^^^^^^^^^^ reference local58
//                                      ^^^^^^ reference local56
//                                             ^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#moves.

        // The item is the same and its already in the correct place
        if (newItem.id == nextOldItem.id && newItem.position == nextOldItem.position) {
//          ^^^^^^^ reference local59
//                  ^^ reference com/airbnb/epoxy/ModelState#id.
//                        ^^^^^^^^^^^ reference local58
//                                    ^^ reference com/airbnb/epoxy/ModelState#id.
//                                          ^^^^^^^ reference local59
//                                                  ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                                              ^^^^^^^^^^^ reference local58
//                                                                          ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
          nextOldItem = null;
//        ^^^^^^^^^^^ reference local58
          break;
        }

        int newItemDistance = newItem.pair.position - newItem.position;
//          ^^^^^^^^^^^^^^^ definition local60 int newItemDistance
//                            ^^^^^^^ reference local59
//                                    ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                                         ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                                    ^^^^^^^ reference local59
//                                                            ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
        int oldItemDistance = nextOldItem.pair.position - nextOldItem.position;
//          ^^^^^^^^^^^^^^^ definition local61 int oldItemDistance
//                            ^^^^^^^^^^^ reference local58
//                                        ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                                             ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                                        ^^^^^^^^^^^ reference local58
//                                                                    ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.

        // Both items are already in the correct position
        if (newItemDistance == 0 && oldItemDistance == 0) {
//          ^^^^^^^^^^^^^^^ reference local60
//                                  ^^^^^^^^^^^^^^^ reference local61
          nextOldItem = null;
//        ^^^^^^^^^^^ reference local58
          break;
        }

        if (oldItemDistance > newItemDistance) {
//          ^^^^^^^^^^^^^^^ reference local61
//                            ^^^^^^^^^^^^^^^ reference local60
          helper.move(nextOldItem.position, nextOldItem.pair.position);
//        ^^^^^^ reference local56
//               ^^^^ reference com/airbnb/epoxy/UpdateOpHelper#move().
//                    ^^^^^^^^^^^ reference local58
//                                ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                          ^^^^^^^^^^^ reference local58
//                                                      ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                                                           ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.

          nextOldItem.position = nextOldItem.pair.position;
//        ^^^^^^^^^^^ reference local58
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                               ^^^^^^^^^^^ reference local58
//                                           ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                                                ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
          nextOldItem.lastMoveOp = helper.getNumMoves();
//        ^^^^^^^^^^^ reference local58
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#lastMoveOp.
//                                 ^^^^^^ reference local56
//                                        ^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOpHelper#getNumMoves().

          nextOldItem = getNextItemWithPair(oldItemIterator);
//        ^^^^^^^^^^^ reference local58
//                      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                          ^^^^^^^^^^^^^^^ reference local57
        } else {
          helper.move(newItem.pair.position, newItem.position);
//        ^^^^^^ reference local56
//               ^^^^ reference com/airbnb/epoxy/UpdateOpHelper#move().
//                    ^^^^^^^ reference local59
//                            ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                                 ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                           ^^^^^^^ reference local59
//                                                   ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.

          newItem.pair.position = newItem.position;
//        ^^^^^^^ reference local59
//                ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                     ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                ^^^^^^^ reference local59
//                                        ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
          newItem.pair.lastMoveOp = helper.getNumMoves();
//        ^^^^^^^ reference local59
//                ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//                     ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#lastMoveOp.
//                                  ^^^^^^ reference local56
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
//                                           ^^^^ definition local62 ModelState item
//                                                 ^^^^ reference java/util/List#
//                                                      ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                                                                ^^^^^^^ definition local63 List<UpdateOp> moveOps
    int size = moveOps.size();
//      ^^^^ definition local64 int size
//             ^^^^^^^ reference local63
//                     ^^^^ reference java/util/List#size().

    for (int i = item.lastMoveOp; i < size; i++) {
//           ^ definition local65 int i
//               ^^^^ reference local62
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#lastMoveOp.
//                                ^ reference local65
//                                    ^^^^ reference local64
//                                          ^ reference local65
      UpdateOp moveOp = moveOps.get(i);
//    ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//             ^^^^^^ definition local66 UpdateOp moveOp
//                      ^^^^^^^ reference local63
//                              ^^^ reference java/util/List#get().
//                                  ^ reference local65
      int fromPosition = moveOp.positionStart;
//        ^^^^^^^^^^^^ definition local67 int fromPosition
//                       ^^^^^^ reference local66
//                              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
      int toPosition = moveOp.itemCount;
//        ^^^^^^^^^^ definition local68 int toPosition
//                     ^^^^^^ reference local66
//                            ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.

      if (item.position > fromPosition && item.position <= toPosition) {
//        ^^^^ reference local62
//             ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                        ^^^^^^^^^^^^ reference local67
//                                        ^^^^ reference local62
//                                             ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                                         ^^^^^^^^^^ reference local68
        item.position--;
//      ^^^^ reference local62
//           ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
      } else if (item.position < fromPosition && item.position >= toPosition) {
//               ^^^^ reference local62
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                               ^^^^^^^^^^^^ reference local67
//                                               ^^^^ reference local62
//                                                    ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                                                                ^^^^^^^^^^ reference local68
        item.position++;
//      ^^^^ reference local62
//           ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
      }
    }

    item.lastMoveOp = size;
//  ^^^^ reference local62
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#lastMoveOp.
//                    ^^^^ reference local64
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
//                                                            ^^^^^^^^ definition local69 Iterator<ModelState> iterator
    ModelState nextItem = null;
//  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//             ^^^^^^^^ definition local70 ModelState nextItem
    while (nextItem == null && iterator.hasNext()) {
//         ^^^^^^^^ reference local70
//                             ^^^^^^^^ reference local69
//                                      ^^^^^^^ reference java/util/Iterator#hasNext().
      nextItem = iterator.next();
//    ^^^^^^^^ reference local70
//               ^^^^^^^^ reference local69
//                        ^^^^ reference java/util/Iterator#next().

      if (nextItem.pair == null) {
//        ^^^^^^^^ reference local70
//                 ^^^^ reference com/airbnb/epoxy/ModelState#pair.
        // Skip this one and go on to the next
        nextItem = null;
//      ^^^^^^^^ reference local70
      }
    }

    return nextItem;
//         ^^^^^^^^ reference local70
  }
}
