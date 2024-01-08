package com.airbnb.epoxy;

import java.util.Collections;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.annotation.VisibleForTesting;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/VisibleForTesting#
import androidx.collection.LongSparseArray;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/collection/
//                         ^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#

/**
 * A helper class for tracking changed models found by the {@link com.airbnb.epoxy.DiffHelper} to
 * be included as a payload in the
 * {@link androidx.recyclerview.widget.RecyclerView.Adapter#notifyItemChanged(int, Object)}
 * call.
 */
public class DiffPayload {
//           ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffPayload#
//                       display_name DiffPayload
//                       signature_documentation java public class DiffPayload
//                       kind Class
//                       documentation  A helper class for tracking changed models found by the {@link com.airbnb.epoxy.DiffHelper} to\n be included as a payload in the\n {@link androidx.recyclerview.widget.RecyclerView.Adapter#notifyItemChanged(int, Object)}\n call.\n
  private final EpoxyModel<?> singleModel;
//              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffPayload#singleModel.
//                                        display_name singleModel
//                                        signature_documentation java private final EpoxyModel<?> singleModel
//                                        kind Field
  private final LongSparseArray<EpoxyModel<?>> modelsById;
//              ^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffPayload#modelsById.
//                                                        display_name modelsById
//                                                        signature_documentation java private final LongSparseArray<EpoxyModel<?>> modelsById
//                                                        kind Field

  DiffPayload(List<? extends EpoxyModel<?>> models) {
//^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffPayload#`<init>`().
//            display_name <init>
//            signature_documentation java DiffPayload(List<? extends EpoxyModel<?>> models)
//            kind Constructor
//            ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^^ definition local 0
//                                                 display_name models
//                                                 signature_documentation java List<? extends EpoxyModel<?>> models
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#`<init>`().
    if (models.isEmpty()) {
//      ^^^^^^ reference local 0
//             ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
      throw new IllegalStateException("Models must not be empty");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }

    int modelCount = models.size();
//      ^^^^^^^^^^ definition local 1
//                 display_name modelCount
//                 signature_documentation java int modelCount
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#`<init>`().
//                   ^^^^^^ reference local 0
//                          ^^^^ reference semanticdb maven jdk 11 java/util/List#size().

    if (modelCount == 1) {
//      ^^^^^^^^^^ reference local 1
      // Optimize for the common case of only one model changed.
      singleModel = models.get(0);
//    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#singleModel.
//                  ^^^^^^ reference local 0
//                         ^^^ reference semanticdb maven jdk 11 java/util/List#get().
      modelsById = null;
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#modelsById.
    } else {
      singleModel = null;
//    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#singleModel.
      modelsById = new LongSparseArray<>(modelCount);
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#modelsById.
//                     ^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#`<init>`(+1).
//                                       ^^^^^^^^^^ reference local 1
      for (EpoxyModel<?> model : models) {
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                       ^^^^^ definition local 2
//                             display_name model
//                             signature_documentation java EpoxyModel<?> model
//                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#`<init>`().
//                               ^^^^^^ reference local 0
        modelsById.put(model.id(), model);
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#modelsById.
//                 ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#put().
//                     ^^^^^ reference local 2
//                           ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
//                                 ^^^^^ reference local 2
      }
    }
  }

  public DiffPayload(EpoxyModel<?> changedItem) {
//       ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffPayload#`<init>`(+1).
//                   display_name <init>
//                   signature_documentation java public DiffPayload(EpoxyModel<?> changedItem)
//                   kind Constructor
//                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                 ^^^^^^^^^^^ definition local 3
//                                             display_name changedItem
//                                             signature_documentation java EpoxyModel<?> changedItem
//                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#`<init>`(+1).
    this(Collections.singletonList(changedItem));
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#`<init>`().
//       ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                   ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#singletonList().
//                                 ^^^^^^^^^^^ reference local 3
  }

  /**
   * Looks through the payloads list and returns the first model found with the given model id. This
   * assumes that the payloads list will only contain objects of type {@link DiffPayload}, and will
   * throw if an unexpected type is found.
   */
  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  public static EpoxyModel<?> getModelFromPayload(List<Object> payloads, long modelId) {
//              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffPayload#getModelFromPayload().
//                                                display_name getModelFromPayload
//                                                signature_documentation java @Nullable\npublic static EpoxyModel<?> getModelFromPayload(List<Object> payloads, long modelId)
//                                                kind StaticMethod
//                                                documentation  Looks through the payloads list and returns the first model found with the given model id. This\n assumes that the payloads list will only contain objects of type {@link DiffPayload}, and will\n throw if an unexpected type is found.\n
//                                                ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                             ^^^^^^^^ definition local 4
//                                                                      display_name payloads
//                                                                      signature_documentation java List<Object> payloads
//                                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#getModelFromPayload().
//                                                                            ^^^^^^^ definition local 5
//                                                                                    display_name modelId
//                                                                                    signature_documentation java long modelId
//                                                                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#getModelFromPayload().
    if (payloads.isEmpty()) {
//      ^^^^^^^^ reference local 4
//               ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
      return null;
    }

    for (Object payload : payloads) {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//              ^^^^^^^ definition local 6
//                      display_name payload
//                      signature_documentation java Object payload
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#getModelFromPayload().
//                        ^^^^^^^^ reference local 4
      DiffPayload diffPayload = (DiffPayload) payload;
//    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#
//                ^^^^^^^^^^^ definition local 7
//                            display_name diffPayload
//                            signature_documentation java DiffPayload diffPayload
//                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#getModelFromPayload().
//                               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#
//                                            ^^^^^^^ reference local 6

      if (diffPayload.singleModel != null) {
//        ^^^^^^^^^^^ reference local 7
//                    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#singleModel.
        if (diffPayload.singleModel.id() == modelId) {
//          ^^^^^^^^^^^ reference local 7
//                      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#singleModel.
//                                  ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
//                                          ^^^^^^^ reference local 5
          return diffPayload.singleModel;
//               ^^^^^^^^^^^ reference local 7
//                           ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#singleModel.
        }
      } else {
        EpoxyModel<?> modelForId = diffPayload.modelsById.get(modelId);
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                    ^^^^^^^^^^ definition local 8
//                               display_name modelForId
//                               signature_documentation java EpoxyModel<?> modelForId
//                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#getModelFromPayload().
//                                 ^^^^^^^^^^^ reference local 7
//                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#modelsById.
//                                                        ^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#get().
//                                                            ^^^^^^^ reference local 5
        if (modelForId != null) {
//          ^^^^^^^^^^ reference local 8
          return modelForId;
//               ^^^^^^^^^^ reference local 8
        }
      }
    }

    return null;
  }

  @VisibleForTesting
// ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/VisibleForTesting#
  boolean equalsForTesting(DiffPayload that) {
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/DiffPayload#equalsForTesting().
//                         display_name equalsForTesting
//                         signature_documentation java @VisibleForTesting\nboolean equalsForTesting(DiffPayload that)
//                         kind Method
//                         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#
//                                     ^^^^ definition local 9
//                                          display_name that
//                                          signature_documentation java DiffPayload that
//                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#equalsForTesting().
    if (singleModel != null) {
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#singleModel.
      return that.singleModel == singleModel;
//           ^^^^ reference local 9
//                ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#singleModel.
//                               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#singleModel.
    }

    int thisSize = modelsById.size();
//      ^^^^^^^^ definition local 10
//               display_name thisSize
//               signature_documentation java int thisSize
//               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#equalsForTesting().
//                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#modelsById.
//                            ^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#size().
    int thatSize = that.modelsById.size();
//      ^^^^^^^^ definition local 11
//               display_name thatSize
//               signature_documentation java int thatSize
//               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#equalsForTesting().
//                 ^^^^ reference local 9
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#modelsById.
//                                 ^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#size().

    if (thisSize != thatSize) {
//      ^^^^^^^^ reference local 10
//                  ^^^^^^^^ reference local 11
      return false;
    }

    for (int i = 0; i < thisSize; i++) {
//           ^ definition local 12
//             display_name i
//             signature_documentation java int i
//             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#equalsForTesting().
//                  ^ reference local 12
//                      ^^^^^^^^ reference local 10
//                                ^ reference local 12
      long thisKey = modelsById.keyAt(i);
//         ^^^^^^^ definition local 13
//                 display_name thisKey
//                 signature_documentation java long thisKey
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#equalsForTesting().
//                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#modelsById.
//                              ^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#keyAt().
//                                    ^ reference local 12
      long thatKey = that.modelsById.keyAt(i);
//         ^^^^^^^ definition local 14
//                 display_name thatKey
//                 signature_documentation java long thatKey
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#equalsForTesting().
//                   ^^^^ reference local 9
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#modelsById.
//                                   ^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#keyAt().
//                                         ^ reference local 12

      if (thisKey != thatKey) {
//        ^^^^^^^ reference local 13
//                   ^^^^^^^ reference local 14
        return false;
      }

      EpoxyModel<?> thisModel = modelsById.valueAt(i);
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^^^^^ definition local 15
//                            display_name thisModel
//                            signature_documentation java EpoxyModel<?> thisModel
//                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#equalsForTesting().
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#modelsById.
//                                         ^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#valueAt().
//                                                 ^ reference local 12
      EpoxyModel<?> thatModel = that.modelsById.valueAt(i);
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^^^^^ definition local 16
//                            display_name thatModel
//                            signature_documentation java EpoxyModel<?> thatModel
//                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/DiffPayload#equalsForTesting().
//                              ^^^^ reference local 9
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#modelsById.
//                                              ^^^^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#valueAt().
//                                                      ^ reference local 12
      if (thisModel != thatModel) {
//        ^^^^^^^^^ reference local 15
//                     ^^^^^^^^^ reference local 16
        return false;
      }
    }

    return true;
  }
}
