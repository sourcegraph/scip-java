package com.airbnb.epoxy;

import java.util.Collections;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^ reference java/util/Collections#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#
import androidx.annotation.VisibleForTesting;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^^^^^^^^^ reference androidx/annotation/VisibleForTesting#
import androidx.collection.LongSparseArray;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/collection/
//                         ^^^^^^^^^^^^^^^ reference androidx/collection/LongSparseArray#

/**
 * A helper class for tracking changed models found by the {@link com.airbnb.epoxy.DiffHelper} to
 * be included as a payload in the
 * {@link androidx.recyclerview.widget.RecyclerView.Adapter#notifyItemChanged(int, Object)}
 * call.
 */
public class DiffPayload {
//     ^^^^^^^^^^^ definition com/airbnb/epoxy/DiffPayload#
  private final EpoxyModel<?> singleModel;
//              ^^^^^^^^^^ reference _root_/
//                            ^^^^^^^^^^^ definition com/airbnb/epoxy/DiffPayload#singleModel.
  private final LongSparseArray<EpoxyModel<?>> modelsById;
//              ^^^^^^^^^^^^^^^ reference androidx/collection/LongSparseArray#
//                              ^^^^^^^^^^ reference _root_/
//                                             ^^^^^^^^^^ definition com/airbnb/epoxy/DiffPayload#modelsById.

  DiffPayload(List<? extends EpoxyModel<?>> models) {
  ^^^^^^ definition com/airbnb/epoxy/DiffPayload#`<init>`().
//            ^^^^ reference java/util/List#
//                           ^^^^^^^^^^ reference _root_/
//                                          ^^^^^^ definition local0
    if (models.isEmpty()) {
//      ^^^^^^ reference local0
//             ^^^^^^^ reference java/util/List#isEmpty().
      throw new IllegalStateException("Models must not be empty");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }

    int modelCount = models.size();
//      ^^^^^^^^^^ definition local1
//                   ^^^^^^ reference local0
//                          ^^^^ reference java/util/List#size().

    if (modelCount == 1) {
//      ^^^^^^^^^^ reference local1
      // Optimize for the common case of only one model changed.
      singleModel = models.get(0);
//    ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#singleModel.
//                  ^^^^^^ reference local0
//                         ^^^ reference java/util/List#get().
      modelsById = null;
//    ^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#modelsById.
    } else {
      singleModel = null;
//    ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#singleModel.
      modelsById = new LongSparseArray<>(modelCount);
//    ^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#modelsById.
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference androidx/collection/LongSparseArray#`<init>`(+1).
//                     ^^^^^^^^^^^^^^^ reference androidx/collection/LongSparseArray#
//                                       ^^^^^^^^^^ reference local1
      for (EpoxyModel<?> model : models) {
//         ^^^^^^^^^^ reference _root_/
//                       ^^^^^ definition local2
//                               ^^^^^^ reference local0
        modelsById.put(model.id(), model);
//      ^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#modelsById.
//                 ^^^ reference androidx/collection/LongSparseArray#put().
//                     ^^^^^ reference local2
//                           ^^ reference `<any>`#id#
//                                 ^^^^^ reference local2
      }
    }
  }

  public DiffPayload(EpoxyModel<?> changedItem) {
//       ^^^^^^ definition com/airbnb/epoxy/DiffPayload#`<init>`(+1).
//                   ^^^^^^^^^^ reference _root_/
//                                 ^^^^^^^^^^^ definition local3
    this(Collections.singletonList(changedItem));
//  ^^^^ reference com/airbnb/epoxy/DiffPayload#`<init>`().
//       ^^^^^^^^^^^ reference java/util/Collections#
//                   ^^^^^^^^^^^^^ reference java/util/Collections#singletonList().
//                                 ^^^^^^^^^^^ reference local3
  }

  /**
   * Looks through the payloads list and returns the first model found with the given model id. This
   * assumes that the payloads list will only contain objects of type {@link DiffPayload}, and will
   * throw if an unexpected type is found.
   */
  @Nullable
   ^^^^^^^^ reference androidx/annotation/Nullable#
  public static EpoxyModel<?> getModelFromPayload(List<Object> payloads, long modelId) {
//              ^^^^^^^^^^ reference _root_/
//                            ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffPayload#getModelFromPayload().
//                                                ^^^^ reference java/util/List#
//                                                     ^^^^^^ reference java/lang/Object#
//                                                             ^^^^^^^^ definition local4
//                                                                            ^^^^^^^ definition local5
    if (payloads.isEmpty()) {
//      ^^^^^^^^ reference local4
//               ^^^^^^^ reference java/util/List#isEmpty().
      return null;
    }

    for (Object payload : payloads) {
//       ^^^^^^ reference java/lang/Object#
//              ^^^^^^^ definition local6
//                        ^^^^^^^^ reference local4
      DiffPayload diffPayload = (DiffPayload) payload;
//    ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#
//                ^^^^^^^^^^^ definition local7
//                               ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#
//                                            ^^^^^^^ reference local6

      if (diffPayload.singleModel != null) {
//        ^^^^^^^^^^^ reference local7
//                    ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#singleModel.
        if (diffPayload.singleModel.id() == modelId) {
//          ^^^^^^^^^^^ reference local7
//                      ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#singleModel.
//                                  ^^ reference `<any>`#id#
//                                          ^^^^^^^ reference local5
          return diffPayload.singleModel;
//               ^^^^^^^^^^^ reference local7
//                           ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#singleModel.
        }
      } else {
        EpoxyModel<?> modelForId = diffPayload.modelsById.get(modelId);
//      ^^^^^^^^^^ reference _root_/
//                    ^^^^^^^^^^ definition local8
//                                 ^^^^^^^^^^^ reference local7
//                                             ^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#modelsById.
//                                                        ^^^ reference androidx/collection/LongSparseArray#get().
//                                                            ^^^^^^^ reference local5
        if (modelForId != null) {
//          ^^^^^^^^^^ reference local8
          return modelForId;
//               ^^^^^^^^^^ reference local8
        }
      }
    }

    return null;
  }

  @VisibleForTesting
   ^^^^^^^^^^^^^^^^^ reference androidx/annotation/VisibleForTesting#
  boolean equalsForTesting(DiffPayload that) {
//        ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/DiffPayload#equalsForTesting().
//                         ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#
//                                     ^^^^ definition local9
    if (singleModel != null) {
//      ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#singleModel.
      return that.singleModel == singleModel;
//           ^^^^ reference local9
//                ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#singleModel.
//                               ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#singleModel.
    }

    int thisSize = modelsById.size();
//      ^^^^^^^^ definition local10
//                 ^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#modelsById.
//                            ^^^^ reference androidx/collection/LongSparseArray#size().
    int thatSize = that.modelsById.size();
//      ^^^^^^^^ definition local11
//                 ^^^^ reference local9
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#modelsById.
//                                 ^^^^ reference androidx/collection/LongSparseArray#size().

    if (thisSize != thatSize) {
//      ^^^^^^^^ reference local10
//                  ^^^^^^^^ reference local11
      return false;
    }

    for (int i = 0; i < thisSize; i++) {
//           ^ definition local12
//                  ^ reference local12
//                      ^^^^^^^^ reference local10
//                                ^ reference local12
      long thisKey = modelsById.keyAt(i);
//         ^^^^^^^ definition local13
//                   ^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#modelsById.
//                              ^^^^^ reference androidx/collection/LongSparseArray#keyAt().
//                                    ^ reference local12
      long thatKey = that.modelsById.keyAt(i);
//         ^^^^^^^ definition local14
//                   ^^^^ reference local9
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#modelsById.
//                                   ^^^^^ reference androidx/collection/LongSparseArray#keyAt().
//                                         ^ reference local12

      if (thisKey != thatKey) {
//        ^^^^^^^ reference local13
//                   ^^^^^^^ reference local14
        return false;
      }

      EpoxyModel<?> thisModel = modelsById.valueAt(i);
//    ^^^^^^^^^^ reference _root_/
//                  ^^^^^^^^^ definition local15
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#modelsById.
//                                         ^^^^^^^ reference androidx/collection/LongSparseArray#valueAt().
//                                                 ^ reference local12
      EpoxyModel<?> thatModel = that.modelsById.valueAt(i);
//    ^^^^^^^^^^ reference _root_/
//                  ^^^^^^^^^ definition local16
//                              ^^^^ reference local9
//                                   ^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#modelsById.
//                                              ^^^^^^^ reference androidx/collection/LongSparseArray#valueAt().
//                                                      ^ reference local12
      if (thisModel != thatModel) {
//        ^^^^^^^^^ reference local15
//                     ^^^^^^^^^ reference local16
        return false;
      }
    }

    return true;
  }
}
