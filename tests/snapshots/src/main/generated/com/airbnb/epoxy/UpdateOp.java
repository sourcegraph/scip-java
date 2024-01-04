
package com.airbnb.epoxy;

import java.lang.annotation.Retention;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                          ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Retention#
import java.lang.annotation.RetentionPolicy;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/RetentionPolicy#
import java.util.ArrayList;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#

import androidx.annotation.IntDef;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntDef#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#

/** Defines an operation that makes a change to the epoxy model list. */
class UpdateOp {
//    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//             display_name UpdateOp
//             signature_documentation java class UpdateOp
//             documentation Defines an operation that makes a change to the epoxy model list. 

  @IntDef({ADD, REMOVE, UPDATE, MOVE})
// ^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntDef#
//         ^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#ADD.
//              ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#REMOVE.
//                      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#UPDATE.
//                              ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#MOVE.
  @Retention(RetentionPolicy.SOURCE)
// ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Retention#
//           ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/RetentionPolicy#
//                           ^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/RetentionPolicy#SOURCE.
  @interface Type {
//           ^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#Type#
//                display_name Type
//                signature_documentation java @IntDef({ADD, REMOVE, UPDATE, MOVE})\n@Retention(RetentionPolicy.SOURCE)\n@interface Type
//                relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
  }

  static final int ADD = 0;
//                 ^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#ADD.
//                     display_name ADD
//                     signature_documentation java static final int ADD
  static final int REMOVE = 1;
//                 ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#REMOVE.
//                        display_name REMOVE
//                        signature_documentation java static final int REMOVE
  static final int UPDATE = 2;
//                 ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#UPDATE.
//                        display_name UPDATE
//                        signature_documentation java static final int UPDATE
  static final int MOVE = 3;
//                 ^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#MOVE.
//                      display_name MOVE
//                      signature_documentation java static final int MOVE

  @Type int type;
// ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#Type#
//          ^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#type.
//               display_name type
//               signature_documentation java @Type\nint type
  int positionStart;
//    ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                  display_name positionStart
//                  signature_documentation java int positionStart
  /** Holds the target position if this is a MOVE */
  int itemCount;
//    ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.
//              display_name itemCount
//              signature_documentation java int itemCount
//              documentation Holds the target position if this is a MOVE 
  ArrayList<EpoxyModel<?>> payloads;
//^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                         ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#payloads.
//                                  display_name payloads
//                                  signature_documentation java ArrayList<EpoxyModel<?>> payloads

  private UpdateOp() {
//        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#`<init>`().
//                 display_name <init>
//                 signature_documentation java private UpdateOp()
  }

  static UpdateOp instance(@Type int type, int positionStart, int itemCount,
//       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#instance().
//                         display_name instance
//                         signature_documentation java static UpdateOp instance(int type, int positionStart, int itemCount, EpoxyModel<?> payload)
//                          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#Type#
//                                   ^^^^ definition local 0
//                                        display_name type
//                                        signature_documentation java @Type\nint type
//                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/UpdateOp#instance().
//                                             ^^^^^^^^^^^^^ definition local 1
//                                                           display_name positionStart
//                                                           signature_documentation java int positionStart
//                                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/UpdateOp#instance().
//                                                                ^^^^^^^^^ definition local 2
//                                                                          display_name itemCount
//                                                                          signature_documentation java int itemCount
//                                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/UpdateOp#instance().
      @Nullable EpoxyModel<?> payload) {
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^ definition local 3
//                                    display_name payload
//                                    signature_documentation java @Nullable\nEpoxyModel<?> payload
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/UpdateOp#instance().
    UpdateOp op = new UpdateOp();
//  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//           ^^ definition local 4
//              display_name op
//              signature_documentation java UpdateOp op
//              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/UpdateOp#instance().
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#`<init>`().

    op.type = type;
//  ^^ reference local 4
//     ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#type.
//            ^^^^ reference local 0
    op.positionStart = positionStart;
//  ^^ reference local 4
//     ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                     ^^^^^^^^^^^^^ reference local 1
    op.itemCount = itemCount;
//  ^^ reference local 4
//     ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.
//                 ^^^^^^^^^ reference local 2

    op.addPayload(payload);
//  ^^ reference local 4
//     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#addPayload().
//                ^^^^^^^ reference local 3

    return op;
//         ^^ reference local 4
  }

  /** Returns the index one past the last item in the affected range. */
  int positionEnd() {
//    ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionEnd().
//                display_name positionEnd
//                signature_documentation java int positionEnd()
//                documentation Returns the index one past the last item in the affected range. 
    return positionStart + itemCount;
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.
  }

  boolean isAfter(int position) {
//        ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#isAfter().
//                display_name isAfter
//                signature_documentation java boolean isAfter(int position)
//                    ^^^^^^^^ definition local 5
//                             display_name position
//                             signature_documentation java int position
//                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/UpdateOp#isAfter().
    return position < positionStart;
//         ^^^^^^^^ reference local 5
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
  }

  boolean isBefore(int position) {
//        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#isBefore().
//                 display_name isBefore
//                 signature_documentation java boolean isBefore(int position)
//                     ^^^^^^^^ definition local 6
//                              display_name position
//                              signature_documentation java int position
//                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/UpdateOp#isBefore().
    return position >= positionEnd();
//         ^^^^^^^^ reference local 6
//                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionEnd().
  }

  boolean contains(int position) {
//        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#contains().
//                 display_name contains
//                 signature_documentation java boolean contains(int position)
//                     ^^^^^^^^ definition local 7
//                              display_name position
//                              signature_documentation java int position
//                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/UpdateOp#contains().
    return position >= positionStart && position < positionEnd();
//         ^^^^^^^^ reference local 7
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                                      ^^^^^^^^ reference local 7
//                                                 ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionEnd().
  }

  void addPayload(@Nullable EpoxyModel<?> payload) {
//     ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#addPayload().
//                display_name addPayload
//                signature_documentation java void addPayload(EpoxyModel<?> payload)
//                 ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                        ^^^^^^^ definition local 8
//                                                display_name payload
//                                                signature_documentation java @Nullable\nEpoxyModel<?> payload
//                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/UpdateOp#addPayload().
    if (payload == null) {
//      ^^^^^^^ reference local 8
      return;
    }

    if (payloads == null) {
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#payloads.
      // In most cases this won't be a batch update so we can expect just one payload
      payloads = new ArrayList<>(1);
//    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#payloads.
//                   ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
    } else if (payloads.size() == 1) {
//             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#payloads.
//                      ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
      // There are multiple payloads, but we don't know how big the batch will end up being.
      // To prevent resizing the list many times we bump it to a medium size
      payloads.ensureCapacity(10);
//    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#payloads.
//             ^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#ensureCapacity().
    }

    payloads.add(payload);
//  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#payloads.
//           ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add().
//               ^^^^^^^ reference local 8
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public String toString() {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#toString().
//                       display_name toString
//                       signature_documentation java @Override\npublic String toString()
//                       relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#toString().
    return "UpdateOp{"
        + "type=" + type
//                  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#type.
        + ", positionStart=" + positionStart
//                             ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
        + ", itemCount=" + itemCount
//                         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.
        + '}';
  }
}
