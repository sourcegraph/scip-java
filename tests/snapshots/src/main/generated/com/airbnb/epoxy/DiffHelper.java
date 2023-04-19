
package com.airbnb.epoxy;

import java.util.ArrayList;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
import java.util.HashMap;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#
import java.util.Iterator;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#
import java.util.Map;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^ reference semanticdb maven jdk 11 java/util/Map#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView#

/**
 * Helper to track changes in the models list.
 */
class DiffHelper {
//    ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#
//               documentation ```java\nclass DiffHelper\n```
//               documentation  Helper to track changes in the models list.\n
  private ArrayList<ModelState> oldStateList = new ArrayList<>();
//        ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateList.
//                                           documentation ```java\nprivate ArrayList<ModelState> oldStateList\n```
//                                                 ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+1).
  // Using a HashMap instead of a LongSparseArray to
  // have faster look up times at the expense of memory
  private Map<Long, ModelState> oldStateMap = new HashMap<>();
//        ^^^ reference semanticdb maven jdk 11 java/util/Map#
//            ^^^^ reference semanticdb maven jdk 11 java/lang/Long#
//                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                              ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateMap.
//                                          documentation ```java\nprivate Map<Long, ModelState> oldStateMap\n```
//                                                ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#`<init>`(+2).
  private ArrayList<ModelState> currentStateList = new ArrayList<>();
//        ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateList.
//                                               documentation ```java\nprivate ArrayList<ModelState> currentStateList\n```
//                                                     ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+1).
  private Map<Long, ModelState> currentStateMap = new HashMap<>();
//        ^^^ reference semanticdb maven jdk 11 java/util/Map#
//            ^^^^ reference semanticdb maven jdk 11 java/lang/Long#
//                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateMap.
//                                              documentation ```java\nprivate Map<Long, ModelState> currentStateMap\n```
//                                                    ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#`<init>`(+2).
  private final BaseEpoxyAdapter adapter;
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#
//                               ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#adapter.
//                                       documentation ```java\nprivate final BaseEpoxyAdapter adapter\n```
  private final boolean immutableModels;
//                      ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#immutableModels.
//                                      documentation ```java\nprivate final boolean immutableModels\n```


  DiffHelper(BaseEpoxyAdapter adapter, boolean immutableModels) {
//^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#`<init>`().
//           documentation ```java\nDiffHelper(BaseEpoxyAdapter adapter, boolean immutableModels)\n```
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#
//                            ^^^^^^^ definition local 0
//                                    documentation ```java\nBaseEpoxyAdapter adapter\n```
//                                             ^^^^^^^^^^^^^^^ definition local 1
//                                                             documentation ```java\nboolean immutableModels\n```
    this.adapter = adapter;
//       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#adapter.
//                 ^^^^^^^ reference local 0
    this.immutableModels = immutableModels;
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#immutableModels.
//                         ^^^^^^^^^^^^^^^ reference local 1
    adapter.registerAdapterDataObserver(observer);
//  ^^^^^^^ reference local 0
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#registerAdapterDataObserver#
//                                      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#observer.
  }

  private final RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() {
//              ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/
//                           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/AdapterDataObserver#
//                                               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#observer.
//                                                        documentation ```java\nprivate final unresolved_type observer\n```
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
//     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#notifyModelChanges().
//                        documentation ```java\nvoid notifyModelChanges()\n```
//                        documentation  Set the current list of models. The diff callbacks will be notified of the changes between the\n current list and the last list that was set.\n
    UpdateOpHelper updateOpHelper = new UpdateOpHelper();
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#
//                 ^^^^^^^^^^^^^^ definition local 2
//                                documentation ```java\nUpdateOpHelper updateOpHelper\n```
//                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#`<init>`().

    buildDiff(updateOpHelper);
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#buildDiff().
//            ^^^^^^^^^^^^^^ reference local 2

    // Send out the proper notify calls for the diff. We remove our
    // observer first so that we don't react to our own notify calls
    adapter.unregisterAdapterDataObserver(observer);
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#unregisterAdapterDataObserver#
//                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#observer.
    notifyChanges(updateOpHelper);
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#notifyChanges().
//                ^^^^^^^^^^^^^^ reference local 2
    adapter.registerAdapterDataObserver(observer);
//  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#adapter.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#registerAdapterDataObserver#
//                                      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#observer.
  }

  private void notifyChanges(UpdateOpHelper opHelper) {
//             ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#notifyChanges().
//                           documentation ```java\nprivate void notifyChanges(UpdateOpHelper opHelper)\n```
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#
//                                          ^^^^^^^^ definition local 3
//                                                   documentation ```java\nUpdateOpHelper opHelper\n```
    for (UpdateOp op : opHelper.opList) {
//       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                ^^ definition local 4
//                   documentation ```java\nUpdateOp op\n```
//                     ^^^^^^^^ reference local 3
//                              ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#opList.
      switch (op.type) {
//            ^^ reference local 4
//               ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#type.
        case UpdateOp.ADD:
//           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                    ^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#ADD.
          adapter.notifyItemRangeInserted(op.positionStart, op.itemCount);
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#adapter.
//                ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemRangeInserted#
//                                        ^^ reference local 4
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                                                          ^^ reference local 4
//                                                             ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.
          break;
        case UpdateOp.MOVE:
//           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#MOVE.
          adapter.notifyItemMoved(op.positionStart, op.itemCount);
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#adapter.
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemMoved#
//                                ^^ reference local 4
//                                   ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                                                  ^^ reference local 4
//                                                     ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.
          break;
        case UpdateOp.REMOVE:
//           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#REMOVE.
          adapter.notifyItemRangeRemoved(op.positionStart, op.itemCount);
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#adapter.
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemRangeRemoved#
//                                       ^^ reference local 4
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                                                         ^^ reference local 4
//                                                            ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.
          break;
        case UpdateOp.UPDATE:
//           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#UPDATE.
          if (immutableModels && op.payloads != null) {
//            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#immutableModels.
//                               ^^ reference local 4
//                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#payloads.
            adapter.notifyItemRangeChanged(op.positionStart, op.itemCount,
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#adapter.
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemRangeChanged#
//                                         ^^ reference local 4
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                                                           ^^ reference local 4
//                                                              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.
                new DiffPayload(op.payloads));
//                  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#`<init>`().
//                              ^^ reference local 4
//                                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#payloads.
          } else {
            adapter.notifyItemRangeChanged(op.positionStart, op.itemCount);
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#adapter.
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#notifyItemRangeChanged#
//                                         ^^ reference local 4
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                                                           ^^ reference local 4
//                                                              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.
          }
          break;
        default:
          throw new IllegalArgumentException("Unknown type: " + op.type);
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalArgumentException#`<init>`(+1).
//                                                              ^^ reference local 4
//                                                                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#type.
      }
    }
  }

  /**
   * Create a list of operations that define the difference between {@link #oldStateList} and {@link
   * #currentStateList}.
   */
  private UpdateOpHelper buildDiff(UpdateOpHelper updateOpHelper) {
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#
//                       ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#buildDiff().
//                                 documentation ```java\nprivate UpdateOpHelper buildDiff(UpdateOpHelper updateOpHelper)\n```
//                                 documentation  Create a list of operations that define the difference between {@link #oldStateList} and {@link\n #currentStateList}.\n
//                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#
//                                                ^^^^^^^^^^^^^^ definition local 5
//                                                               documentation ```java\nUpdateOpHelper updateOpHelper\n```
    prepareStateForDiff();
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#prepareStateForDiff().

    // The general approach is to first search for removals, then additions, and lastly changes.
    // Focusing on one type of operation at a time makes it easy to coalesce batch changes.
    // When we identify an operation and add it to the
    // result list we update the positions of items in the oldStateList to reflect
    // the change, this way subsequent operations will use the correct, updated positions.
    collectRemovals(updateOpHelper);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#collectRemovals().
//                  ^^^^^^^^^^^^^^ reference local 5

    // Only need to check for insertions if new list is bigger
    boolean hasInsertions =
//          ^^^^^^^^^^^^^ definition local 6
//                        documentation ```java\nboolean hasInsertions\n```
        oldStateList.size() - updateOpHelper.getNumRemovals() != currentStateList.size();
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateList.
//                   ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
//                            ^^^^^^^^^^^^^^ reference local 5
//                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumRemovals().
//                                                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateList.
//                                                                                ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
    if (hasInsertions) {
//      ^^^^^^^^^^^^^ reference local 6
      collectInsertions(updateOpHelper);
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#collectInsertions().
//                      ^^^^^^^^^^^^^^ reference local 5
    }

    collectMoves(updateOpHelper);
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#collectMoves().
//               ^^^^^^^^^^^^^^ reference local 5
    collectChanges(updateOpHelper);
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#collectChanges().
//                 ^^^^^^^^^^^^^^ reference local 5

    resetOldState();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#resetOldState().

    return updateOpHelper;
//         ^^^^^^^^^^^^^^ reference local 5
  }

  private void resetOldState() {
//             ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#resetOldState().
//                           documentation ```java\nprivate void resetOldState()\n```
    oldStateList.clear();
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateList.
//               ^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#clear().
    oldStateMap.clear();
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateMap.
//              ^^^^^ reference semanticdb maven jdk 11 java/util/Map#clear().
  }

  private void prepareStateForDiff() {
//             ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#prepareStateForDiff().
//                                 documentation ```java\nprivate void prepareStateForDiff()\n```
    // We use a list of the models as well as a map by their id,
    // so we can easily find them by both position and id

    oldStateList.clear();
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateList.
//               ^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#clear().
    oldStateMap.clear();
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateMap.
//              ^^^^^ reference semanticdb maven jdk 11 java/util/Map#clear().

    // Swap the two lists so that we have a copy of the current state to calculate the next diff
    ArrayList<ModelState> tempList = oldStateList;
//  ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                        ^^^^^^^^ definition local 7
//                                 documentation ```java\nArrayList<ModelState> tempList\n```
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateList.
    oldStateList = currentStateList;
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateList.
//                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateList.
    currentStateList = tempList;
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateList.
//                     ^^^^^^^^ reference local 7

    Map<Long, ModelState> tempMap = oldStateMap;
//  ^^^ reference semanticdb maven jdk 11 java/util/Map#
//      ^^^^ reference semanticdb maven jdk 11 java/lang/Long#
//            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                        ^^^^^^^ definition local 8
//                                documentation ```java\nMap<Long, ModelState> tempMap\n```
//                                  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateMap.
    oldStateMap = currentStateMap;
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateMap.
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateMap.
    currentStateMap = tempMap;
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateMap.
//                    ^^^^^^^ reference local 8

    // Remove all pairings in the old states so we can tell which of them were removed. The items
    // that still exist in the new list will be paired when we build the current list state below
    for (ModelState modelState : oldStateList) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                  ^^^^^^^^^^ definition local 9
//                             documentation ```java\nModelState modelState\n```
//                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateList.
      modelState.pair = null;
//    ^^^^^^^^^^ reference local 9
//               ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
    }

    int modelCount = adapter.getCurrentModels().size();
//      ^^^^^^^^^^ definition local 10
//                 documentation ```java\nint modelCount\n```
//                   ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#adapter.
//                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                              ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    currentStateList.ensureCapacity(modelCount);
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateList.
//                   ^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#ensureCapacity().
//                                  ^^^^^^^^^^ reference local 10

    for (int i = 0; i < modelCount; i++) {
//           ^ definition local 11
//             documentation ```java\nint i\n```
//                  ^ reference local 11
//                      ^^^^^^^^^^ reference local 10
//                                  ^ reference local 11
      currentStateList.add(createStateForPosition(i));
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateList.
//                     ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add().
//                         ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#createStateForPosition().
//                                                ^ reference local 11
    }
  }

  private ModelState createStateForPosition(int position) {
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                   ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#createStateForPosition().
//                                          documentation ```java\nprivate ModelState createStateForPosition(int position)\n```
//                                              ^^^^^^^^ definition local 12
//                                                       documentation ```java\nint position\n```
    EpoxyModel<?> model = adapter.getCurrentModels().get(position);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local 13
//                      documentation ```java\nEpoxyModel<?> model\n```
//                        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#adapter.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                                   ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                                       ^^^^^^^^ reference local 12
    model.addedToAdapter = true;
//  ^^^^^ reference local 13
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#addedToAdapter.
    ModelState state = ModelState.build(model, position, immutableModels);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//             ^^^^^ definition local 14
//                   documentation ```java\nModelState state\n```
//                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#build().
//                                      ^^^^^ reference local 13
//                                             ^^^^^^^^ reference local 12
//                                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#immutableModels.

    ModelState previousValue = currentStateMap.put(state.id, state);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//             ^^^^^^^^^^^^^ definition local 15
//                           documentation ```java\nModelState previousValue\n```
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateMap.
//                                             ^^^ reference semanticdb maven jdk 11 java/util/Map#put().
//                                                 ^^^^^ reference local 14
//                                                       ^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#id.
//                                                           ^^^^^ reference local 14
    if (previousValue != null) {
//      ^^^^^^^^^^^^^ reference local 15
      int previousPosition = previousValue.position;
//        ^^^^^^^^^^^^^^^^ definition local 16
//                         documentation ```java\nint previousPosition\n```
//                           ^^^^^^^^^^^^^ reference local 15
//                                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
      EpoxyModel<?> previousModel = adapter.getCurrentModels().get(previousPosition);
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^^^^^^^^^ definition local 17
//                                documentation ```java\nEpoxyModel<?> previousModel\n```
//                                  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#adapter.
//                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                                             ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                                                 ^^^^^^^^^^^^^^^^ reference local 16
      throw new IllegalStateException("Two models have the same ID. ID's must be unique!"
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          + " Model at position " + position + ": " + model
//                                  ^^^^^^^^ reference local 12
//                                                    ^^^^^ reference local 13
          + " Model at position " + previousPosition + ": " + previousModel);
//                                  ^^^^^^^^^^^^^^^^ reference local 16
//                                                            ^^^^^^^^^^^^^ reference local 17
    }

    return state;
//         ^^^^^ reference local 14
  }

  /**
   * Find all removal operations and add them to the result list. The general strategy here is to
   * walk through the {@link #oldStateList} and check for items that don't exist in the new list.
   * Walking through it in order makes it easy to batch adjacent removals.
   */
  private void collectRemovals(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#collectRemovals().
//                             documentation ```java\nprivate void collectRemovals(UpdateOpHelper helper)\n```
//                             documentation  Find all removal operations and add them to the result list. The general strategy here is to\n walk through the {@link #oldStateList} and check for items that don't exist in the new list.\n Walking through it in order makes it easy to batch adjacent removals.\n
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#
//                                            ^^^^^^ definition local 18
//                                                   documentation ```java\nUpdateOpHelper helper\n```
    for (ModelState state : oldStateList) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                  ^^^^^ definition local 19
//                        documentation ```java\nModelState state\n```
//                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateList.
      // Update the position of the item to take into account previous removals,
      // so that future operations will reference the correct position
      state.position -= helper.getNumRemovals();
//    ^^^^^ reference local 19
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                      ^^^^^^ reference local 18
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumRemovals().

      // This is our first time going through the list, so we
      // look up the item with the matching id in the new
      // list and hold a reference to it so that we can access it quickly in the future
      state.pair = currentStateMap.get(state.id);
//    ^^^^^ reference local 19
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateMap.
//                                 ^^^ reference semanticdb maven jdk 11 java/util/Map#get().
//                                     ^^^^^ reference local 19
//                                           ^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#id.
      if (state.pair != null) {
//        ^^^^^ reference local 19
//              ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
        state.pair.pair = state;
//      ^^^^^ reference local 19
//            ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                        ^^^^^ reference local 19
        continue;
      }

      helper.remove(state.position);
//    ^^^^^^ reference local 18
//           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#remove().
//                  ^^^^^ reference local 19
//                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
    }
  }

  /**
   * Find all insertion operations and add them to the result list. The general strategy here is to
   * walk through the {@link #currentStateList} and check for items that don't exist in the old
   * list. Walking through it in order makes it easy to batch adjacent insertions.
   */
  private void collectInsertions(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#collectInsertions().
//                               documentation ```java\nprivate void collectInsertions(UpdateOpHelper helper)\n```
//                               documentation  Find all insertion operations and add them to the result list. The general strategy here is to\n walk through the {@link #currentStateList} and check for items that don't exist in the old\n list. Walking through it in order makes it easy to batch adjacent insertions.\n
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#
//                                              ^^^^^^ definition local 20
//                                                     documentation ```java\nUpdateOpHelper helper\n```
    Iterator<ModelState> oldItemIterator = oldStateList.iterator();
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                       ^^^^^^^^^^^^^^^ definition local 21
//                                       documentation ```java\nIterator<ModelState> oldItemIterator\n```
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateList.
//                                                      ^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#iterator().

    for (ModelState itemToInsert : currentStateList) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                  ^^^^^^^^^^^^ definition local 22
//                               documentation ```java\nModelState itemToInsert\n```
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateList.
      if (itemToInsert.pair != null) {
//        ^^^^^^^^^^^^ reference local 22
//                     ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
        // Update the position of the next item in the old list to take any insertions into account
        ModelState nextOldItem = getNextItemWithPair(oldItemIterator);
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                 ^^^^^^^^^^^ definition local 23
//                             documentation ```java\nModelState nextOldItem\n```
//                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                                   ^^^^^^^^^^^^^^^ reference local 21
        if (nextOldItem != null) {
//          ^^^^^^^^^^^ reference local 23
          nextOldItem.position += helper.getNumInsertions();
//        ^^^^^^^^^^^ reference local 23
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                                ^^^^^^ reference local 20
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumInsertions().
        }
        continue;
      }

      helper.add(itemToInsert.position);
//    ^^^^^^ reference local 20
//           ^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#add().
//               ^^^^^^^^^^^^ reference local 22
//                            ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
    }
  }

  /**
   * Check if any items have had their values changed, batching if possible.
   */
  private void collectChanges(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#collectChanges().
//                            documentation ```java\nprivate void collectChanges(UpdateOpHelper helper)\n```
//                            documentation  Check if any items have had their values changed, batching if possible.\n
//                            ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#
//                                           ^^^^^^ definition local 24
//                                                  documentation ```java\nUpdateOpHelper helper\n```
    for (ModelState newItem : currentStateList) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                  ^^^^^^^ definition local 25
//                          documentation ```java\nModelState newItem\n```
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateList.
      ModelState previousItem = newItem.pair;
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//               ^^^^^^^^^^^^ definition local 26
//                            documentation ```java\nModelState previousItem\n```
//                              ^^^^^^^ reference local 25
//                                      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
      if (previousItem == null) {
//        ^^^^^^^^^^^^ reference local 26
        continue;
      }

      // We use equals when we know the models are immutable and available, otherwise we have to
      // rely on the stored hashCode
      boolean modelChanged;
//            ^^^^^^^^^^^^ definition local 27
//                         documentation ```java\nboolean modelChanged\n```
      if (immutableModels) {
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#immutableModels.
        // Make sure that the old model hasn't changed, otherwise comparing it with the new one
        // won't be accurate.
        if (previousItem.model.isDebugValidationEnabled()) {
//          ^^^^^^^^^^^^ reference local 26
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#model.
//                             ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#isDebugValidationEnabled().
          previousItem.model
//        ^^^^^^^^^^^^ reference local 26
//                     ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#model.
              .validateStateHasNotChangedSinceAdded("Model was changed before it could be diffed.",
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#validateStateHasNotChangedSinceAdded().
                  previousItem.position);
//                ^^^^^^^^^^^^ reference local 26
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
        }

        modelChanged = !previousItem.model.equals(newItem.model);
//      ^^^^^^^^^^^^ reference local 27
//                      ^^^^^^^^^^^^ reference local 26
//                                   ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#model.
//                                         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#equals().
//                                                ^^^^^^^ reference local 25
//                                                        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#model.
      } else {
        modelChanged = previousItem.hashCode != newItem.hashCode;
//      ^^^^^^^^^^^^ reference local 27
//                     ^^^^^^^^^^^^ reference local 26
//                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#hashCode.
//                                              ^^^^^^^ reference local 25
//                                                      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#hashCode.
      }

      if (modelChanged) {
//        ^^^^^^^^^^^^ reference local 27
        helper.update(newItem.position, previousItem.model);
//      ^^^^^^ reference local 24
//             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#update(+1).
//                    ^^^^^^^ reference local 25
//                            ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                                      ^^^^^^^^^^^^ reference local 26
//                                                   ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#model.
      }
    }
  }

  /**
   * Check which items have had a position changed. Recyclerview does not support batching these.
   */
  private void collectMoves(UpdateOpHelper helper) {
//             ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#collectMoves().
//                          documentation ```java\nprivate void collectMoves(UpdateOpHelper helper)\n```
//                          documentation  Check which items have had a position changed. Recyclerview does not support batching these.\n
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#
//                                         ^^^^^^ definition local 28
//                                                documentation ```java\nUpdateOpHelper helper\n```
    // This walks through both the new and old list simultaneous and checks for position changes.
    Iterator<ModelState> oldItemIterator = oldStateList.iterator();
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                       ^^^^^^^^^^^^^^^ definition local 29
//                                       documentation ```java\nIterator<ModelState> oldItemIterator\n```
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#oldStateList.
//                                                      ^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#iterator().
    ModelState nextOldItem = null;
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//             ^^^^^^^^^^^ definition local 30
//                         documentation ```java\nModelState nextOldItem\n```

    for (ModelState newItem : currentStateList) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                  ^^^^^^^ definition local 31
//                          documentation ```java\nModelState newItem\n```
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#currentStateList.
      if (newItem.pair == null) {
//        ^^^^^^^ reference local 31
//                ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
        // This item was inserted. However, insertions are done at the item's final position, and
        // aren't smart about inserting at a different position to take future moves into account.
        // As the old state list is updated to reflect moves, it needs to also consider insertions
        // affected by those moves in order for the final change set to be correct
        if (helper.moves.isEmpty()) {
//          ^^^^^^ reference local 28
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#moves.
//                       ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
          // There have been no moves, so the item is still at it's correct position
          continue;
        } else {
          // There have been moves, so the old list needs to take this inserted item
          // into account. The old list doesn't have this item inserted into it
          // (for optimization purposes), but we can create a pair for this item to
          // track its position in the old list and move it back to its final position if necessary
          newItem.pairWithSelf();
//        ^^^^^^^ reference local 31
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pairWithSelf().
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
//        ^^^^^^^^^^^ reference local 30
        nextOldItem = getNextItemWithPair(oldItemIterator);
//      ^^^^^^^^^^^ reference local 30
//                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                        ^^^^^^^^^^^^^^^ reference local 29

        // We've already iterated through all old items and moved each
        // item once. However, subsequent moves may have shifted an item out of
        // its correct space once it was already moved. We finish
        // iterating through all the new items to ensure everything is still correct
        if (nextOldItem == null) {
//          ^^^^^^^^^^^ reference local 30
          nextOldItem = newItem.pair;
//        ^^^^^^^^^^^ reference local 30
//                      ^^^^^^^ reference local 31
//                              ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
        }
      }

      while (nextOldItem != null) {
//           ^^^^^^^^^^^ reference local 30
        // Make sure the positions are updated to the latest
        // move operations before we calculate the next move
        updateItemPosition(newItem.pair, helper.moves);
//      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#updateItemPosition().
//                         ^^^^^^^ reference local 31
//                                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                                       ^^^^^^ reference local 28
//                                              ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#moves.
        updateItemPosition(nextOldItem, helper.moves);
//      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#updateItemPosition().
//                         ^^^^^^^^^^^ reference local 30
//                                      ^^^^^^ reference local 28
//                                             ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#moves.

        // The item is the same and its already in the correct place
        if (newItem.id == nextOldItem.id && newItem.position == nextOldItem.position) {
//          ^^^^^^^ reference local 31
//                  ^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#id.
//                        ^^^^^^^^^^^ reference local 30
//                                    ^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#id.
//                                          ^^^^^^^ reference local 31
//                                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                                                              ^^^^^^^^^^^ reference local 30
//                                                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
          nextOldItem = null;
//        ^^^^^^^^^^^ reference local 30
          break;
        }

        int newItemDistance = newItem.pair.position - newItem.position;
//          ^^^^^^^^^^^^^^^ definition local 32
//                          documentation ```java\nint newItemDistance\n```
//                            ^^^^^^^ reference local 31
//                                    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                                                    ^^^^^^^ reference local 31
//                                                            ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
        int oldItemDistance = nextOldItem.pair.position - nextOldItem.position;
//          ^^^^^^^^^^^^^^^ definition local 33
//                          documentation ```java\nint oldItemDistance\n```
//                            ^^^^^^^^^^^ reference local 30
//                                        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                                                        ^^^^^^^^^^^ reference local 30
//                                                                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.

        // Both items are already in the correct position
        if (newItemDistance == 0 && oldItemDistance == 0) {
//          ^^^^^^^^^^^^^^^ reference local 32
//                                  ^^^^^^^^^^^^^^^ reference local 33
          nextOldItem = null;
//        ^^^^^^^^^^^ reference local 30
          break;
        }

        if (oldItemDistance > newItemDistance) {
//          ^^^^^^^^^^^^^^^ reference local 33
//                            ^^^^^^^^^^^^^^^ reference local 32
          helper.move(nextOldItem.position, nextOldItem.pair.position);
//        ^^^^^^ reference local 28
//               ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#move().
//                    ^^^^^^^^^^^ reference local 30
//                                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                                          ^^^^^^^^^^^ reference local 30
//                                                      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                                                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.

          nextOldItem.position = nextOldItem.pair.position;
//        ^^^^^^^^^^^ reference local 30
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                               ^^^^^^^^^^^ reference local 30
//                                           ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                                                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
          nextOldItem.lastMoveOp = helper.getNumMoves();
//        ^^^^^^^^^^^ reference local 30
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#lastMoveOp.
//                                 ^^^^^^ reference local 28
//                                        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumMoves().

          nextOldItem = getNextItemWithPair(oldItemIterator);
//        ^^^^^^^^^^^ reference local 30
//                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                          ^^^^^^^^^^^^^^^ reference local 29
        } else {
          helper.move(newItem.pair.position, newItem.position);
//        ^^^^^^ reference local 28
//               ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#move().
//                    ^^^^^^^ reference local 31
//                            ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                                           ^^^^^^^ reference local 31
//                                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.

          newItem.pair.position = newItem.position;
//        ^^^^^^^ reference local 31
//                ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                                ^^^^^^^ reference local 31
//                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
          newItem.pair.lastMoveOp = helper.getNumMoves();
//        ^^^^^^^ reference local 31
//                ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#lastMoveOp.
//                                  ^^^^^^ reference local 28
//                                         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOpHelper#getNumMoves().
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
//             ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#updateItemPosition().
//                                documentation ```java\nprivate void updateItemPosition(ModelState item, List<UpdateOp> moveOps)\n```
//                                documentation  Apply the movement operations to the given item to update its position. Only applies the\n operations that have not been applied yet, and stores how many operations have been applied so\n we know which ones to apply next time.\n
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                                           ^^^^ definition local 34
//                                                documentation ```java\nModelState item\n```
//                                                 ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                                                                ^^^^^^^ definition local 35
//                                                                        documentation ```java\nList<UpdateOp> moveOps\n```
    int size = moveOps.size();
//      ^^^^ definition local 36
//           documentation ```java\nint size\n```
//             ^^^^^^^ reference local 35
//                     ^^^^ reference semanticdb maven jdk 11 java/util/List#size().

    for (int i = item.lastMoveOp; i < size; i++) {
//           ^ definition local 37
//             documentation ```java\nint i\n```
//               ^^^^ reference local 34
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#lastMoveOp.
//                                ^ reference local 37
//                                    ^^^^ reference local 36
//                                          ^ reference local 37
      UpdateOp moveOp = moveOps.get(i);
//    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//             ^^^^^^ definition local 38
//                    documentation ```java\nUpdateOp moveOp\n```
//                      ^^^^^^^ reference local 35
//                              ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                  ^ reference local 37
      int fromPosition = moveOp.positionStart;
//        ^^^^^^^^^^^^ definition local 39
//                     documentation ```java\nint fromPosition\n```
//                       ^^^^^^ reference local 38
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
      int toPosition = moveOp.itemCount;
//        ^^^^^^^^^^ definition local 40
//                   documentation ```java\nint toPosition\n```
//                     ^^^^^^ reference local 38
//                            ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.

      if (item.position > fromPosition && item.position <= toPosition) {
//        ^^^^ reference local 34
//             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                        ^^^^^^^^^^^^ reference local 39
//                                        ^^^^ reference local 34
//                                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                                                         ^^^^^^^^^^ reference local 40
        item.position--;
//      ^^^^ reference local 34
//           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
      } else if (item.position < fromPosition && item.position >= toPosition) {
//               ^^^^ reference local 34
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                               ^^^^^^^^^^^^ reference local 39
//                                               ^^^^ reference local 34
//                                                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                                                                ^^^^^^^^^^ reference local 40
        item.position++;
//      ^^^^ reference local 34
//           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
      }
    }

    item.lastMoveOp = size;
//  ^^^^ reference local 34
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#lastMoveOp.
//                    ^^^^ reference local 36
  }

  /**
   * Gets the next item in the list that has a pair, meaning it wasn't inserted or removed.
   */
  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  private ModelState getNextItemWithPair(Iterator<ModelState> iterator) {
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                   ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffHelper#getNextItemWithPair().
//                                       documentation ```java\n@Nullable\nprivate ModelState getNextItemWithPair(Iterator<ModelState> iterator)\n```
//                                       documentation  Gets the next item in the list that has a pair, meaning it wasn't inserted or removed.\n
//                                       ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                                                            ^^^^^^^^ definition local 41
//                                                                     documentation ```java\nIterator<ModelState> iterator\n```
    ModelState nextItem = null;
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//             ^^^^^^^^ definition local 42
//                      documentation ```java\nModelState nextItem\n```
    while (nextItem == null && iterator.hasNext()) {
//         ^^^^^^^^ reference local 42
//                             ^^^^^^^^ reference local 41
//                                      ^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#hasNext().
      nextItem = iterator.next();
//    ^^^^^^^^ reference local 42
//               ^^^^^^^^ reference local 41
//                        ^^^^ reference semanticdb maven jdk 11 java/util/Iterator#next().

      if (nextItem.pair == null) {
//        ^^^^^^^^ reference local 42
//                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
        // Skip this one and go on to the next
        nextItem = null;
//      ^^^^^^^^ reference local 42
      }
    }

    return nextItem;
//         ^^^^^^^^ reference local 42
  }
}
