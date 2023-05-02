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
//                                     documentation ```java\npublic abstract class ControllerHelper<T extends EpoxyController>\n```
//                                     documentation  A helper class for {@link EpoxyController} to handle {@link\n com.airbnb.epoxy.AutoModel} models. This is only implemented by the generated classes created the\n annotation processor.\n
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelper#`<init>`().
//                                     documentation ```java\npublic ControllerHelper()\n```
//                                     ^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelper#[T]
//                                       documentation ```java\nT extends EpoxyController\n```
//                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
  public abstract void resetAutoModels();
//                     ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelper#resetAutoModels().
//                                     documentation ```java\npublic abstract void resetAutoModels()\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/NoOpControllerHelper#resetAutoModels().

  protected void validateModelHashCodesHaveNotChanged(T controller) {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelper#validateModelHashCodesHaveNotChanged().
//                                                    documentation ```java\nprotected void validateModelHashCodesHaveNotChanged(T controller)\n```
//                                                    ^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelper#[T]
//                                                      ^^^^^^^^^^ definition local 0
//                                                                 documentation ```java\nT controller\n```
    List<EpoxyModel<?>> currentModels = controller.getAdapter().getCopyOfModels();
//  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                      ^^^^^^^^^^^^^ definition local 1
//                                    documentation ```java\nList<EpoxyModel<?>> currentModels\n```
//                                      ^^^^^^^^^^ reference local 0
//                                                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#getAdapter().
//                                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCopyOfModels().

    for (int i = 0; i < currentModels.size(); i++) {
//           ^ definition local 2
//             documentation ```java\nint i\n```
//                  ^ reference local 2
//                      ^^^^^^^^^^^^^ reference local 1
//                                    ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
//                                            ^ reference local 2
      EpoxyModel model = currentModels.get(i);
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//               ^^^^^ definition local 3
//                     documentation ```java\nEpoxyModel model\n```
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
//                                      documentation ```java\nprotected void setControllerToStageTo(EpoxyModel<?> model, T controller)\n```
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                    ^^^^^ definition local 4
//                                                          documentation ```java\nEpoxyModel<?> model\n```
//                                                           ^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelper#[T]
//                                                             ^^^^^^^^^^ definition local 5
//                                                                        documentation ```java\nT controller\n```
    model.controllerToStageTo = controller;
//  ^^^^^ reference local 4
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#controllerToStageTo.
//                              ^^^^^^^^^^ reference local 5
  }
}
