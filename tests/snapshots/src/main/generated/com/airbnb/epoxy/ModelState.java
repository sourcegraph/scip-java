package com.airbnb.epoxy;

/** Helper to store relevant information about a model that we need to determine if it changed. */
class ModelState {
^^^^^^ definition com/airbnb/epoxy/ModelState#`<init>`().
^^^^^^^^^^ definition com/airbnb/epoxy/ModelState#
  long id;
//     ^^ definition com/airbnb/epoxy/ModelState#id.
  int hashCode;
//    ^^^^^^^^ definition com/airbnb/epoxy/ModelState#hashCode.
  int position;
//    ^^^^^^^^ definition com/airbnb/epoxy/ModelState#position.
  EpoxyModel<?> model;
  ^^^^^^^^^^ reference _root_/
//              ^^^^^ definition com/airbnb/epoxy/ModelState#model.

  /**
   * A link to the item with the same id in the other list when diffing two lists. This will be null
   * if the item doesn't exist, in the case of insertions or removals. This is an optimization to
   * prevent having to look up the matching pair in a hash map every time.
   */
  ModelState pair;
  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//           ^^^^ definition com/airbnb/epoxy/ModelState#pair.

  /**
   * How many movement operations have been applied to this item in order to update its position. As
   * we find more item movements we need to update the position of affected items in the list in
   * order to correctly calculate the next movement. Instead of iterating through all items in the
   * list every time a movement operation happens we keep track of how many of these operations have
   * been applied to an item, and apply all new operations in order when we need to get this item's
   * up to date position.
   */
  int lastMoveOp;
//    ^^^^^^^^^^ definition com/airbnb/epoxy/ModelState#lastMoveOp.

  static ModelState build(EpoxyModel<?> model, int position, boolean immutableModel) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//                  ^^^^^ definition com/airbnb/epoxy/ModelState#build().
//                        ^^^^^^^^^^ reference _root_/
//                                      ^^^^^ definition local0
//                                                 ^^^^^^^^ definition local1
//                                                                   ^^^^^^^^^^^^^^ definition local2
    ModelState state = new ModelState();
//  ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
//             ^^^^^ definition local3
//                     ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#`<init>`().
//                         ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#

    state.lastMoveOp = 0;
//  ^^^^^ reference local3
//        ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#lastMoveOp.
    state.pair = null;
//  ^^^^^ reference local3
//        ^^^^ reference com/airbnb/epoxy/ModelState#pair.
    state.id = model.id();
//  ^^^^^ reference local3
//        ^^ reference com/airbnb/epoxy/ModelState#id.
//             ^^^^^ reference local0
//                   ^^ reference `<any>`#id#
    state.position = position;
//  ^^^^^ reference local3
//        ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                   ^^^^^^^^ reference local1

    if (immutableModel) {
//      ^^^^^^^^^^^^^^ reference local2
      state.model = model;
//    ^^^^^ reference local3
//          ^^^^^ reference com/airbnb/epoxy/ModelState#model.
//                  ^^^^^ reference local0
    } else {
      state.hashCode = model.hashCode();
//    ^^^^^ reference local3
//          ^^^^^^^^ reference com/airbnb/epoxy/ModelState#hashCode.
//                     ^^^^^ reference local0
//                           ^^^^^^^^ reference `<any>`#hashCode#
    }

    return state;
//         ^^^^^ reference local3
  }

  /**
   * Used for an item inserted into the new list when we need to track moves that effect the
   * inserted item in the old list.
   */
  void pairWithSelf() {
//     ^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelState#pairWithSelf().
    if (pair != null) {
//      ^^^^ reference com/airbnb/epoxy/ModelState#pair.
      throw new IllegalStateException("Already paired.");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }

    pair = new ModelState();
//  ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#`<init>`().
//             ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#
    pair.lastMoveOp = 0;
//  ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//       ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#lastMoveOp.
    pair.id = id;
//  ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//       ^^ reference com/airbnb/epoxy/ModelState#id.
//            ^^ reference com/airbnb/epoxy/ModelState#id.
    pair.position = position;
//  ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//       ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
//                  ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
    pair.hashCode = hashCode;
//  ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//       ^^^^^^^^ reference com/airbnb/epoxy/ModelState#hashCode.
//                  ^^^^^^^^ reference com/airbnb/epoxy/ModelState#hashCode.
    pair.pair = this;
//  ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//       ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//              ^^^^ reference com/airbnb/epoxy/ModelState#this.
    pair.model = model;
//  ^^^^ reference com/airbnb/epoxy/ModelState#pair.
//       ^^^^^ reference com/airbnb/epoxy/ModelState#model.
//               ^^^^^ reference com/airbnb/epoxy/ModelState#model.
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public String toString() {
//       ^^^^^^ reference java/lang/String#
//              ^^^^^^^^ definition com/airbnb/epoxy/ModelState#toString().
    return "ModelState{"
        + "id=" + id
//                ^^ reference com/airbnb/epoxy/ModelState#id.
        + ", model=" + model
//                     ^^^^^ reference com/airbnb/epoxy/ModelState#model.
        + ", hashCode=" + hashCode
//                        ^^^^^^^^ reference com/airbnb/epoxy/ModelState#hashCode.
        + ", position=" + position
//                        ^^^^^^^^ reference com/airbnb/epoxy/ModelState#position.
        + ", pair=" + pair
//                    ^^^^ reference com/airbnb/epoxy/ModelState#pair.
        + ", lastMoveOp=" + lastMoveOp
//                          ^^^^^^^^^^ reference com/airbnb/epoxy/ModelState#lastMoveOp.
        + '}';
  }
}
