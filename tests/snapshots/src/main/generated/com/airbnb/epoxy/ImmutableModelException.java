package com.airbnb.epoxy;

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#

/**
 * Thrown if a model is changed after it is added to an {@link com.airbnb.epoxy.EpoxyController}.
 */
class ImmutableModelException extends RuntimeException {
//    ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ImmutableModelException# class ImmutableModelException extends RuntimeException
//                                    ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
  private static final String MODEL_CANNOT_BE_CHANGED_MESSAGE =
//                     ^^^^^^ reference java/lang/String#
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ImmutableModelException#MODEL_CANNOT_BE_CHANGED_MESSAGE. private static final String MODEL_CANNOT_BE_CHANGED_MESSAGE
      "Epoxy attribute fields on a model cannot be changed once the model is added to a "
          + "controller. Check that these fields are not updated, or that the assigned objects "
          + "are not mutated, outside of the buildModels method. The only exception is if "
          + "the change is made inside an Interceptor callback. Consider using an interceptor"
          + " if you need to change a model after it is added to the controller and before it"
          + " is set on the adapter. If the model is already set on the adapter then you must"
          + " call `requestModelBuild` instead to recreate all models.";

  ImmutableModelException(EpoxyModel model, int modelPosition) {
//^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ImmutableModelException#`<init>`(). ImmutableModelException(EpoxyModel model, int modelPosition)
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local0 EpoxyModel model
//                                              ^^^^^^^^^^^^^ definition local1 int modelPosition
    this(model, "", modelPosition);
//  ^^^^ reference com/airbnb/epoxy/ImmutableModelException#`<init>`(+1).
//       ^^^^^ reference local0
//                  ^^^^^^^^^^^^^ reference local1
  }

  ImmutableModelException(EpoxyModel model,
//^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ImmutableModelException#`<init>`(+1). ImmutableModelException(EpoxyModel model, String descriptionOfWhenChangeHappened, int modelPosition)
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local2 EpoxyModel model
      String descriptionOfWhenChangeHappened, int modelPosition) {
//    ^^^^^^ reference java/lang/String#
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local3 String descriptionOfWhenChangeHappened
//                                                ^^^^^^^^^^^^^ definition local4 int modelPosition
    super(buildMessage(model, descriptionOfWhenChangeHappened, modelPosition));
//  ^^^^^ reference java/lang/RuntimeException#`<init>`(+1).
//        ^^^^^^^^^^^^ reference com/airbnb/epoxy/ImmutableModelException#buildMessage().
//                     ^^^^^ reference local2
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local3
//                                                             ^^^^^^^^^^^^^ reference local4
  }

  @NonNull
// ^^^^^^^ reference androidx/annotation/NonNull#
  private static String buildMessage(EpoxyModel model,
//               ^^^^^^ reference java/lang/String#
//                      ^^^^^^^^^^^^ definition com/airbnb/epoxy/ImmutableModelException#buildMessage(). private static String buildMessage(EpoxyModel model, String descriptionOfWhenChangeHappened, int modelPosition)
//                                   ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^ definition local5 EpoxyModel model
      String descriptionOfWhenChangeHappened, int modelPosition) {
//    ^^^^^^ reference java/lang/String#
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local6 String descriptionOfWhenChangeHappened
//                                                ^^^^^^^^^^^^^ definition local7 int modelPosition
    return new StringBuilder(descriptionOfWhenChangeHappened)
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/StringBuilder#`<init>`(+2).
//             ^^^^^^^^^^^^^ reference java/lang/StringBuilder#
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local6
        .append(" Position: ")
//       ^^^^^^ reference java/lang/StringBuilder#append(+1).
        .append(modelPosition)
//       ^^^^^^ reference java/lang/StringBuilder#append(+9).
//              ^^^^^^^^^^^^^ reference local7
        .append(" Model: ")
//       ^^^^^^ reference java/lang/StringBuilder#append(+1).
        .append(model.toString())
//       ^^^^^^ reference java/lang/StringBuilder#append(+1).
//              ^^^^^ reference local5
//                    ^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#toString().
        .append("\n\n")
//       ^^^^^^ reference java/lang/StringBuilder#append(+1).
        .append(MODEL_CANNOT_BE_CHANGED_MESSAGE)
//       ^^^^^^ reference java/lang/StringBuilder#append(+1).
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ImmutableModelException#MODEL_CANNOT_BE_CHANGED_MESSAGE.
        .toString();
//       ^^^^^^^^ reference java/lang/StringBuilder#toString().
  }
}
