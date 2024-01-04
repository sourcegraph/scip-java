package com.airbnb.epoxy;

import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

/**
 * A helper class for {@link EpoxyController} to handle {@link
 * com.airbnb.epoxy.AutoModel} models. This is only implemented by the generated classes created the
 * annotation processor.
 */
public abstract class ControllerHelper<T extends EpoxyController> {
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelper#
//                                     display_name ControllerHelper
//                                     signature_documentation java public abstract class ControllerHelper<T extends EpoxyController>
//                                     documentation  A helper class for {@link EpoxyController} to handle {@link\n com.airbnb.epoxy.AutoModel} models. This is only implemented by the generated classes created the\n annotation processor.\n
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelper#`<init>`().
//                                     display_name <init>
//                                     signature_documentation java public ControllerHelper()
//                                     ^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelper#[T]
//                                       display_name T
//                                       signature_documentation java T extends EpoxyController
//                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
  public abstract void resetAutoModels();
//                     ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelper#resetAutoModels().
//                                     display_name resetAutoModels
//                                     signature_documentation java public abstract void resetAutoModels()
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/NoOpControllerHelper#resetAutoModels().

  protected void validateModelHashCodesHaveNotChanged(T controller) {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelper#validateModelHashCodesHaveNotChanged().
//                                                    display_name validateModelHashCodesHaveNotChanged
//                                                    signature_documentation java protected void validateModelHashCodesHaveNotChanged(T controller)
//                                                    ^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelper#[T]
//                                                      ^^^^^^^^^^ definition local 0
//                                                                 display_name controller
//                                                                 signature_documentation java T controller
//                                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelper#validateModelHashCodesHaveNotChanged().
    List<EpoxyModel<?>> currentModels = controller.getAdapter().getCopyOfModels();
//  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                      ^^^^^^^^^^^^^ definition local 1
//                                    display_name currentModels
//                                    signature_documentation java List<EpoxyModel<?>> currentModels
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelper#validateModelHashCodesHaveNotChanged().
//                                      ^^^^^^^^^^ reference local 0
//                                                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#getAdapter().
//                                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCopyOfModels().

    for (int i = 0; i < currentModels.size(); i++) {
//           ^ definition local 2
//             display_name i
//             signature_documentation java int i
//             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelper#validateModelHashCodesHaveNotChanged().
//                  ^ reference local 2
//                      ^^^^^^^^^^^^^ reference local 1
//                                    ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
//                                            ^ reference local 2
      EpoxyModel model = currentModels.get(i);
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//               ^^^^^ definition local 3
//                     display_name model
//                     signature_documentation java EpoxyModel model
//                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelper#validateModelHashCodesHaveNotChanged().
//                       ^^^^^^^^^^^^^ reference local 1
//                                     ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                         ^ reference local 2
      model.validateStateHasNotChangedSinceAdded(
//    ^^^^^ reference local 3
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#validateStateHasNotChangedSinceAdded().
          "Model has changed since it was added to the controller.", i);
//                                                                   ^ reference local 2
    }
  }

  protected void setControllerToStageTo(EpoxyModel<?> model, T controller) {
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelper#setControllerToStageTo().
//                                      display_name setControllerToStageTo
//                                      signature_documentation java protected void setControllerToStageTo(EpoxyModel<?> model, T controller)
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                    ^^^^^ definition local 4
//                                                          display_name model
//                                                          signature_documentation java EpoxyModel<?> model
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelper#setControllerToStageTo().
//                                                           ^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelper#[T]
//                                                             ^^^^^^^^^^ definition local 5
//                                                                        display_name controller
//                                                                        signature_documentation java T controller
//                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelper#setControllerToStageTo().
    model.controllerToStageTo = controller;
//  ^^^^^ reference local 4
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#controllerToStageTo.
//                              ^^^^^^^^^^ reference local 5
  }
}
