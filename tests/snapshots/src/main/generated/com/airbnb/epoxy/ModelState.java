package com.airbnb.epoxy;

/** Helper to store relevant information about a model that we need to determine if it changed. */
class ModelState {
//    ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#
//               display_name ModelState
//               signature_documentation java class ModelState
//               documentation Helper to store relevant information about a model that we need to determine if it changed. 
//    ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#`<init>`().
//               display_name <init>
//               signature_documentation java ModelState()
  long id;
//     ^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#id.
//        display_name id
//        signature_documentation java long id
  int hashCode;
//    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#hashCode.
//             display_name hashCode
//             signature_documentation java int hashCode
  int position;
//    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#position.
//             display_name position
//             signature_documentation java int position
  EpoxyModel<?> model;
//^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#model.
//                    display_name model
//                    signature_documentation java EpoxyModel<?> model

  /**
   * A link to the item with the same id in the other list when diffing two lists. This will be null
   * if the item doesn't exist, in the case of insertions or removals. This is an optimization to
   * prevent having to look up the matching pair in a hash map every time.
   */
  ModelState pair;
//^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//           ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#pair.
//                display_name pair
//                signature_documentation java ModelState pair
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
//               display_name lastMoveOp
//               signature_documentation java int lastMoveOp
//               documentation  How many movement operations have been applied to this item in order to update its position. As\n we find more item movements we need to update the position of affected items in the list in\n order to correctly calculate the next movement. Instead of iterating through all items in the\n list every time a movement operation happens we keep track of how many of these operations have\n been applied to an item, and apply all new operations in order when we need to get this item's\n up to date position.\n

  static ModelState build(EpoxyModel<?> model, int position, boolean immutableModel) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//                  ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelState#build().
//                        display_name build
//                        signature_documentation java static ModelState build(EpoxyModel<?> model, int position, boolean immutableModel)
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^ definition local 0
//                                            display_name model
//                                            signature_documentation java EpoxyModel<?> model
//                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelState#build().
//                                                 ^^^^^^^^ definition local 1
//                                                          display_name position
//                                                          signature_documentation java int position
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelState#build().
//                                                                   ^^^^^^^^^^^^^^ definition local 2
//                                                                                  display_name immutableModel
//                                                                                  signature_documentation java boolean immutableModel
//                                                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelState#build().
    ModelState state = new ModelState();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelState#
//             ^^^^^ definition local 3
//                   display_name state
//                   signature_documentation java ModelState state
//                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelState#build().
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
//                  display_name pairWithSelf
//                  signature_documentation java void pairWithSelf()
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
//                       display_name toString
//                       signature_documentation java @Override\npublic String toString()
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
