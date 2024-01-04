package com.airbnb.epoxy;

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#

/**
 * Thrown if a model is changed after it is added to an {@link com.airbnb.epoxy.EpoxyController}.
 */
class ImmutableModelException extends RuntimeException {
//    ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#
//                            display_name ImmutableModelException
//                            signature_documentation java class ImmutableModelException
//                            documentation  Thrown if a model is changed after it is added to an {@link com.airbnb.epoxy.EpoxyController}.\n
//                            relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//                            relationship is_implementation semanticdb maven jdk 11 java/lang/Exception#
//                            relationship is_implementation semanticdb maven jdk 11 java/lang/RuntimeException#
//                            relationship is_implementation semanticdb maven jdk 11 java/lang/Throwable#
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
  private static final String MODEL_CANNOT_BE_CHANGED_MESSAGE =
//                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#MODEL_CANNOT_BE_CHANGED_MESSAGE.
//                                                            display_name MODEL_CANNOT_BE_CHANGED_MESSAGE
//                                                            signature_documentation java private static final String MODEL_CANNOT_BE_CHANGED_MESSAGE
      "Epoxy attribute fields on a model cannot be changed once the model is added to a "
          + "controller. Check that these fields are not updated, or that the assigned objects "
          + "are not mutated, outside of the buildModels method. The only exception is if "
          + "the change is made inside an Interceptor callback. Consider using an interceptor"
          + " if you need to change a model after it is added to the controller and before it"
          + " is set on the adapter. If the model is already set on the adapter then you must"
          + " call `requestModelBuild` instead to recreate all models.";

  ImmutableModelException(EpoxyModel model, int modelPosition) {
//^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#`<init>`().
//                        display_name <init>
//                        signature_documentation java ImmutableModelException(EpoxyModel model, int modelPosition)
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local 0
//                                         display_name model
//                                         signature_documentation java EpoxyModel model
//                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#`<init>`().
//                                              ^^^^^^^^^^^^^ definition local 1
//                                                            display_name modelPosition
//                                                            signature_documentation java int modelPosition
//                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#`<init>`().
    this(model, "", modelPosition);
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#`<init>`(+1).
//       ^^^^^ reference local 0
//                  ^^^^^^^^^^^^^ reference local 1
  }

  ImmutableModelException(EpoxyModel model,
//^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#`<init>`(+1).
//                        display_name <init>
//                        signature_documentation java ImmutableModelException(EpoxyModel model, String descriptionOfWhenChangeHappened, int modelPosition)
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local 2
//                                         display_name model
//                                         signature_documentation java EpoxyModel model
//                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#`<init>`(+1).
      String descriptionOfWhenChangeHappened, int modelPosition) {
//    ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 3
//                                           display_name descriptionOfWhenChangeHappened
//                                           signature_documentation java String descriptionOfWhenChangeHappened
//                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#`<init>`(+1).
//                                                ^^^^^^^^^^^^^ definition local 4
//                                                              display_name modelPosition
//                                                              signature_documentation java int modelPosition
//                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#`<init>`(+1).
    super(buildMessage(model, descriptionOfWhenChangeHappened, modelPosition));
//  ^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#`<init>`(+1).
//        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#buildMessage().
//                     ^^^^^ reference local 2
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 3
//                                                             ^^^^^^^^^^^^^ reference local 4
  }

  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  private static String buildMessage(EpoxyModel model,
//               ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                      ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#buildMessage().
//                                   display_name buildMessage
//                                   signature_documentation java @NonNull\nprivate static String buildMessage(EpoxyModel model, String descriptionOfWhenChangeHappened, int modelPosition)
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^ definition local 5
//                                                    display_name model
//                                                    signature_documentation java EpoxyModel model
//                                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#buildMessage().
      String descriptionOfWhenChangeHappened, int modelPosition) {
//    ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 6
//                                           display_name descriptionOfWhenChangeHappened
//                                           signature_documentation java String descriptionOfWhenChangeHappened
//                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#buildMessage().
//                                                ^^^^^^^^^^^^^ definition local 7
//                                                              display_name modelPosition
//                                                              signature_documentation java int modelPosition
//                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#buildMessage().
    return new StringBuilder(descriptionOfWhenChangeHappened)
//             ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#`<init>`(+2).
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 6
        .append(" Position: ")
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append(+1).
        .append(modelPosition)
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append(+9).
//              ^^^^^^^^^^^^^ reference local 7
        .append(" Model: ")
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append(+1).
        .append(model.toString())
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append(+1).
//              ^^^^^ reference local 5
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#toString().
        .append("\n\n")
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append(+1).
        .append(MODEL_CANNOT_BE_CHANGED_MESSAGE)
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append(+1).
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#MODEL_CANNOT_BE_CHANGED_MESSAGE.
        .toString();
//       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#toString().
  }
}
