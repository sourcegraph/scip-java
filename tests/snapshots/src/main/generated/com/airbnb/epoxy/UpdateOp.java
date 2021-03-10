
package com.airbnb.epoxy;

import java.lang.annotation.Retention;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^ reference java/lang/annotation/Retention#
import java.lang.annotation.RetentionPolicy;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
import java.util.ArrayList;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^ reference java/util/ArrayList#

import androidx.annotation.IntDef;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^ reference androidx/annotation/IntDef#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#

/** Defines an operation that makes a change to the epoxy model list. */
class UpdateOp {
//    ^^^^^^^^ definition com/airbnb/epoxy/UpdateOp#

  @IntDef({ADD, REMOVE, UPDATE, MOVE})
// ^^^^^^ reference androidx/annotation/IntDef#
//         ^^^ reference com/airbnb/epoxy/UpdateOp#ADD.
//              ^^^^^^ reference com/airbnb/epoxy/UpdateOp#REMOVE.
//                      ^^^^^^ reference com/airbnb/epoxy/UpdateOp#UPDATE.
//                              ^^^^ reference com/airbnb/epoxy/UpdateOp#MOVE.
  @Retention(RetentionPolicy.SOURCE)
// ^^^^^^^^^ reference java/lang/annotation/Retention#
//           ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
//                           ^^^^^^ reference java/lang/annotation/RetentionPolicy#SOURCE.
  @interface Type {
//           ^^^^ definition com/airbnb/epoxy/UpdateOp#Type#
  }

  static final int ADD = 0;
//                 ^^^ definition com/airbnb/epoxy/UpdateOp#ADD.
  static final int REMOVE = 1;
//                 ^^^^^^ definition com/airbnb/epoxy/UpdateOp#REMOVE.
  static final int UPDATE = 2;
//                 ^^^^^^ definition com/airbnb/epoxy/UpdateOp#UPDATE.
  static final int MOVE = 3;
//                 ^^^^ definition com/airbnb/epoxy/UpdateOp#MOVE.

  @Type int type;
// ^^^^ reference com/airbnb/epoxy/UpdateOp#Type#
//          ^^^^ definition com/airbnb/epoxy/UpdateOp#type.
  int positionStart;
//    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOp#positionStart.
  /** Holds the target position if this is a MOVE */
  int itemCount;
//    ^^^^^^^^^ definition com/airbnb/epoxy/UpdateOp#itemCount.
  ArrayList<EpoxyModel<?>> payloads;
//^^^^^^^^^ reference java/util/ArrayList#
//          ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                         ^^^^^^^^ definition com/airbnb/epoxy/UpdateOp#payloads.

  private UpdateOp() {
//        ^^^^^^ definition com/airbnb/epoxy/UpdateOp#`<init>`().
  }

  static UpdateOp instance(@Type int type, int positionStart, int itemCount,
//       ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//                ^^^^^^^^ definition com/airbnb/epoxy/UpdateOp#instance().
//                          ^^^^ reference com/airbnb/epoxy/UpdateOp#Type#
//                                   ^^^^ definition local0
//                                             ^^^^^^^^^^^^^ definition local1
//                                                                ^^^^^^^^^ definition local2
      @Nullable EpoxyModel<?> payload) {
//     ^^^^^^^^ reference androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^ definition local3
    UpdateOp op = new UpdateOp();
//  ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#
//           ^^ definition local4
//                ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#`<init>`().
//                    ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#

    op.type = type;
//  ^^ reference local4
//     ^^^^ reference com/airbnb/epoxy/UpdateOp#type.
//            ^^^^ reference local0
    op.positionStart = positionStart;
//  ^^ reference local4
//     ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                     ^^^^^^^^^^^^^ reference local1
    op.itemCount = itemCount;
//  ^^ reference local4
//     ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
//                 ^^^^^^^^^ reference local2

    op.addPayload(payload);
//  ^^ reference local4
//     ^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#addPayload().
//                ^^^^^^^ reference local3

    return op;
//         ^^ reference local4
  }

  /** Returns the index one past the last item in the affected range. */
  int positionEnd() {
//    ^^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOp#positionEnd().
    return positionStart + itemCount;
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                         ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
  }

  boolean isAfter(int position) {
//        ^^^^^^^ definition com/airbnb/epoxy/UpdateOp#isAfter().
//                    ^^^^^^^^ definition local5
    return position < positionStart;
//         ^^^^^^^^ reference local5
//                    ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
  }

  boolean isBefore(int position) {
//        ^^^^^^^^ definition com/airbnb/epoxy/UpdateOp#isBefore().
//                     ^^^^^^^^ definition local6
    return position >= positionEnd();
//         ^^^^^^^^ reference local6
//                     ^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionEnd().
  }

  boolean contains(int position) {
//        ^^^^^^^^ definition com/airbnb/epoxy/UpdateOp#contains().
//                     ^^^^^^^^ definition local7
    return position >= positionStart && position < positionEnd();
//         ^^^^^^^^ reference local7
//                     ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
//                                      ^^^^^^^^ reference local7
//                                                 ^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionEnd().
  }

  void addPayload(@Nullable EpoxyModel<?> payload) {
//     ^^^^^^^^^^ definition com/airbnb/epoxy/UpdateOp#addPayload().
//                 ^^^^^^^^ reference androidx/annotation/Nullable#
//                          ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                        ^^^^^^^ definition local8
    if (payload == null) {
//      ^^^^^^^ reference local8
      return;
    }

    if (payloads == null) {
//      ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#payloads.
      // In most cases this won't be a batch update so we can expect just one payload
      payloads = new ArrayList<>(1);
//    ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#payloads.
//               ^^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`().
//                   ^^^^^^^^^ reference java/util/ArrayList#
    } else if (payloads.size() == 1) {
//             ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#payloads.
//                      ^^^^ reference java/util/ArrayList#size().
      // There are multiple payloads, but we don't know how big the batch will end up being.
      // To prevent resizing the list many times we bump it to a medium size
      payloads.ensureCapacity(10);
//    ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#payloads.
//             ^^^^^^^^^^^^^^ reference java/util/ArrayList#ensureCapacity().
    }

    payloads.add(payload);
//  ^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#payloads.
//           ^^^ reference java/util/ArrayList#add(+1).
//               ^^^^^^^ reference local8
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public String toString() {
//       ^^^^^^ reference java/lang/String#
//              ^^^^^^^^ definition com/airbnb/epoxy/UpdateOp#toString().
    return "UpdateOp{"
        + "type=" + type
//                  ^^^^ reference com/airbnb/epoxy/UpdateOp#type.
        + ", positionStart=" + positionStart
//                             ^^^^^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#positionStart.
        + ", itemCount=" + itemCount
//                         ^^^^^^^^^ reference com/airbnb/epoxy/UpdateOp#itemCount.
        + '}';
  }
}
