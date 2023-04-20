package com.airbnb.epoxy;

/** Helper to store relevant information about a model that we need to determine if it changed. */
class ModelState {
//    ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#
//               documentation ```java\nclass ModelState\n```
//               documentation Helper to store relevant information about a model that we need to determine if it changed. 
//    ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#`<init>`().
//               documentation ```java\nModelState()\n```
  long id;
//     ^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#id.
//        documentation ```java\nlong id\n```
  int hashCode;
//    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#hashCode.
//             documentation ```java\nint hashCode\n```
  int position;
//    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//             documentation ```java\nint position\n```
  EpoxyModel<?> model;
//^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#model.
//                    documentation ```java\nEpoxyModel<?> model\n```

  /**
   * A link to the item with the same id in the other list when diffing two lists. This will be null
   * if the item doesn't exist, in the case of insertions or removals. This is an optimization to
   * prevent having to look up the matching pair in a hash map every time.
   */
  ModelState pair;
//^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//           ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                documentation ```java\nModelState pair\n```
//                documentation  A link to the item with the same id in the other list when diffing two lists. This will be null\n if the item doesn't exist, in the case of insertions or removals. This is an optimization to\n prevent having to look up the matching pair in a hash map every time.\n

  /**
   * How many movement operations have been applied to this item in order to update its position. As
   * we find more item movements we need to update the position of affected items in the list in
   * order to correctly calculate the next movement. Instead of iterating through all items in the
   * list every time a movement operation happens we keep track of how many of these operations have
   * been applied to an item, and apply all new operations in order when we need to get this item's
   * up to date position.
   */
  int lastMoveOp;
//    ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#lastMoveOp.
//               documentation ```java\nint lastMoveOp\n```
//               documentation  How many movement operations have been applied to this item in order to update its position. As\n we find more item movements we need to update the position of affected items in the list in\n order to correctly calculate the next movement. Instead of iterating through all items in the\n list every time a movement operation happens we keep track of how many of these operations have\n been applied to an item, and apply all new operations in order when we need to get this item's\n up to date position.\n

  static ModelState build(EpoxyModel<?> model, int position, boolean immutableModel) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                  ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#build().
//                        documentation ```java\nstatic ModelState build(EpoxyModel<?> model, int position, boolean immutableModel)\n```
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^ definition local 0
//                                            documentation ```java\nEpoxyModel<?> model\n```
//                                                 ^^^^^^^^ definition local 1
//                                                          documentation ```java\nint position\n```
//                                                                   ^^^^^^^^^^^^^^ definition local 2
//                                                                                  documentation ```java\nboolean immutableModel\n```
    ModelState state = new ModelState();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//             ^^^^^ definition local 3
//                   documentation ```java\nModelState state\n```
//                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#`<init>`().

    state.lastMoveOp = 0;
//  ^^^^^ reference local 3
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#lastMoveOp.
    state.pair = null;
//  ^^^^^ reference local 3
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
    state.id = model.id();
//  ^^^^^ reference local 3
//        ^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#id.
//             ^^^^^ reference local 0
//                   ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
    state.position = position;
//  ^^^^^ reference local 3
//        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                   ^^^^^^^^ reference local 1

    if (immutableModel) {
//      ^^^^^^^^^^^^^^ reference local 2
      state.model = model;
//    ^^^^^ reference local 3
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#model.
//                  ^^^^^ reference local 0
    } else {
      state.hashCode = model.hashCode();
//    ^^^^^ reference local 3
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#hashCode.
//                     ^^^^^ reference local 0
//                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCode().
    }

    return state;
//         ^^^^^ reference local 3
  }

  /**
   * Used for an item inserted into the new list when we need to track moves that effect the
   * inserted item in the old list.
   */
  void pairWithSelf() {
//     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#pairWithSelf().
//                  documentation ```java\nvoid pairWithSelf()\n```
//                  documentation  Used for an item inserted into the new list when we need to track moves that effect the\n inserted item in the old list.\n
    if (pair != null) {
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
      throw new IllegalStateException("Already paired.");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }

    pair = new ModelState();
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#`<init>`().
    pair.lastMoveOp = 0;
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#lastMoveOp.
    pair.id = id;
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//       ^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#id.
//            ^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#id.
    pair.position = position;
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
    pair.hashCode = hashCode;
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#hashCode.
//                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#hashCode.
    pair.pair = this;
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
    pair.model = model;
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#model.
//               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#model.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public String toString() {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#toString().
//                       documentation ```java\n@Override\npublic String toString()\n```
//                       relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#toString().
    return "ModelState{"
        + "id=" + id
//                ^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#id.
        + ", model=" + model
//                     ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#model.
        + ", hashCode=" + hashCode
//                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#hashCode.
        + ", position=" + position
//                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#position.
        + ", pair=" + pair
//                    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
        + ", lastMoveOp=" + lastMoveOp
//                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#lastMoveOp.
        + '}';
  }
}
