
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
//             documentation ```java\nclass UpdateOp\n```
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
//                documentation ```java\n@IntDef({ADD, REMOVE, UPDATE, MOVE})\n@Retention(RetentionPolicy.SOURCE)\n@interface Type\n```
//                relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
  }

  static final int ADD = 0;
//                 ^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#ADD.
//                     documentation ```java\nstatic final int ADD\n```
  static final int REMOVE = 1;
//                 ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#REMOVE.
//                        documentation ```java\nstatic final int REMOVE\n```
  static final int UPDATE = 2;
//                 ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#UPDATE.
//                        documentation ```java\nstatic final int UPDATE\n```
  static final int MOVE = 3;
//                 ^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#MOVE.
//                      documentation ```java\nstatic final int MOVE\n```

  @Type int type;
// ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#Type#
//          ^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#type.
//               documentation ```java\n@Type\nint type\n```
  int positionStart;
//    ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                  documentation ```java\nint positionStart\n```
  /** Holds the target position if this is a MOVE */
  int itemCount;
//    ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.
//              documentation ```java\nint itemCount\n```
//              documentation Holds the target position if this is a MOVE 
  ArrayList<EpoxyModel<?>> payloads;
//^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                         ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#payloads.
//                                  documentation ```java\nArrayList<EpoxyModel<?>> payloads\n```

  private UpdateOp() {
//        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#`<init>`().
//                 documentation ```java\nprivate UpdateOp()\n```
  }

  static UpdateOp instance(@Type int type, int positionStart, int itemCount,
//       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//                ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#instance().
//                         documentation ```java\nstatic UpdateOp instance(int type, int positionStart, int itemCount, EpoxyModel<?> payload)\n```
//                          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#Type#
//                                   ^^^^ definition local 0
//                                        documentation ```java\n@Type\nint type\n```
//                                             ^^^^^^^^^^^^^ definition local 1
//                                                           documentation ```java\nint positionStart\n```
//                                                                ^^^^^^^^^ definition local 2
//                                                                          documentation ```java\nint itemCount\n```
      @Nullable EpoxyModel<?> payload) {
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^ definition local 3
//                                    documentation ```java\n@Nullable\nEpoxyModel<?> payload\n```
    UpdateOp op = new UpdateOp();
//  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#
//           ^^ definition local 4
//              documentation ```java\nUpdateOp op\n```
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
//                documentation ```java\nint positionEnd()\n```
//                documentation Returns the index one past the last item in the affected range. 
    return positionStart + itemCount;
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#itemCount.
  }

  boolean isAfter(int position) {
//        ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#isAfter().
//                documentation ```java\nboolean isAfter(int position)\n```
//                    ^^^^^^^^ definition local 5
//                             documentation ```java\nint position\n```
    return position < positionStart;
//         ^^^^^^^^ reference local 5
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
  }

  boolean isBefore(int position) {
//        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#isBefore().
//                 documentation ```java\nboolean isBefore(int position)\n```
//                     ^^^^^^^^ definition local 6
//                              documentation ```java\nint position\n```
    return position >= positionEnd();
//         ^^^^^^^^ reference local 6
//                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionEnd().
  }

  boolean contains(int position) {
//        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#contains().
//                 documentation ```java\nboolean contains(int position)\n```
//                     ^^^^^^^^ definition local 7
//                              documentation ```java\nint position\n```
    return position >= positionStart && position < positionEnd();
//         ^^^^^^^^ reference local 7
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionStart.
//                                      ^^^^^^^^ reference local 7
//                                                 ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UpdateOp#positionEnd().
  }

  void addPayload(@Nullable EpoxyModel<?> payload) {
//     ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UpdateOp#addPayload().
//                documentation ```java\nvoid addPayload(EpoxyModel<?> payload)\n```
//                 ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                        ^^^^^^^ definition local 8
//                                                documentation ```java\n@Nullable\nEpoxyModel<?> payload\n```
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
//                       documentation ```java\n@Override\npublic String toString()\n```
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
