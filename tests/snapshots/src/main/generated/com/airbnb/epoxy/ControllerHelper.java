package com.airbnb.epoxy;

import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

/**
 * A helper class for {@link EpoxyController} to handle {@link
 * com.airbnb.epoxy.AutoModel} models. This is only implemented by the generated classes created the
 * annotation processor.
 */
public abstract class ControllerHelper<T extends EpoxyController> {
//              ^^^^^^ definition com/airbnb/epoxy/ControllerHelper#`<init>`().
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerHelper#
//                                               ^^^^^^^^^^^^^^^ reference _root_/
  public abstract void resetAutoModels();
//                     ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerHelper#resetAutoModels().

  protected void validateModelHashCodesHaveNotChanged(T controller) {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerHelper#validateModelHashCodesHaveNotChanged().
//                                                    ^ reference com/airbnb/epoxy/ControllerHelper#[T]
//                                                      ^^^^^^^^^^ definition local0
    List<EpoxyModel<?>> currentModels = controller.getAdapter().getCopyOfModels();
//  ^^^^ reference java/util/List#
//       ^^^^^^^^^^ reference _root_/
//                      ^^^^^^^^^^^^^ definition local1
//                                      ^^^^^^^^^^ reference local0
//                                                 ^^^^^^^^^^ reference getAdapter#
//                                                              ^^^^^^^^^^^^^^^ reference getAdapter#getCopyOfModels#

    for (int i = 0; i < currentModels.size(); i++) {
//           ^ definition local2
//                  ^ reference local2
//                      ^^^^^^^^^^^^^ reference local1
//                                    ^^^^ reference java/util/List#size().
//                                            ^ reference local2
      EpoxyModel model = currentModels.get(i);
//    ^^^^^^^^^^ reference _root_/
//               ^^^^^ definition local3
//                       ^^^^^^^^^^^^^ reference local1
//                                     ^^^ reference java/util/List#get().
//                                         ^ reference local2
      model.validateStateHasNotChangedSinceAdded(
//    ^^^^^ reference local3
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference validateStateHasNotChangedSinceAdded#
          "Model has changed since it was added to the controller.", i);
//                                                                   ^ reference local2
    }
  }

  protected void setControllerToStageTo(EpoxyModel<?> model, T controller) {
//               ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerHelper#setControllerToStageTo().
//                                      ^^^^^^^^^^ reference _root_/
//                                                    ^^^^^ definition local4
//                                                           ^ reference com/airbnb/epoxy/ControllerHelper#[T]
//                                                             ^^^^^^^^^^ definition local5
    model.controllerToStageTo = controller;
//  ^^^^^ reference local4
//        ^^^^^^^^^^^^^^^^^^^ reference `<any>`#controllerToStageTo#
//                              ^^^^^^^^^^ reference local5
  }
}
