package com.airbnb.epoxy;

import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

/**
 * A small wrapper around {@link com.airbnb.epoxy.EpoxyController} that lets you set a list of
 * models directly.
 */
public class SimpleEpoxyController extends EpoxyController {
//           ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#
//                                 documentation ```java\npublic class SimpleEpoxyController\n```
//                                 documentation  A small wrapper around {@link com.airbnb.epoxy.EpoxyController} that lets you set a list of\n models directly.\n
//                                 relationship is_implementation semanticdb maven . . ``/ModelCollector#
//                                 relationship is_implementation semanticdb maven . . ``/StickyHeaderCallbacks#
//                                 relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//           ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#`<init>`().
//                                 documentation ```java\npublic SimpleEpoxyController()\n```
//                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
  private List<? extends EpoxyModel<?>> currentModels;
//        ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#currentModels.
//                                                    documentation ```java\nprivate List<? extends EpoxyModel<?>> currentModels\n```
  private boolean insideSetModels;
//                ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#insideSetModels.
//                                documentation ```java\nprivate boolean insideSetModels\n```

  /**
   * Set the models to add to this controller. Clears any previous models and adds this new list
   * .
   */
  public void setModels(List<? extends EpoxyModel<?>> models) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#setModels().
//                      documentation ```java\npublic void setModels(List<? extends EpoxyModel<?>> models)\n```
//                      documentation  Set the models to add to this controller. Clears any previous models and adds this new list\n .\n
//                      ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                    ^^^^^^ definition local 0
//                                                           documentation ```java\nList<? extends EpoxyModel<?>> models\n```
    currentModels = models;
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#currentModels.
//                  ^^^^^^ reference local 0
    insideSetModels = true;
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#insideSetModels.
    requestModelBuild();
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#requestModelBuild().
    insideSetModels = false;
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#insideSetModels.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final void requestModelBuild() {
//                  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#requestModelBuild().
//                                    documentation ```java\n@Override\npublic final void requestModelBuild()\n```
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
    if (!insideSetModels) {
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#insideSetModels.
      throw new IllegalEpoxyUsage(
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
          "You cannot call `requestModelBuild` directly. Call `setModels` instead.");
    }
    super.requestModelBuild();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#super.
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected final void buildModels() {
//                     ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#buildModels().
//                                 documentation ```java\n@Override\nprotected final void buildModels()\n```
//                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#buildModels().
    if (!isBuildingModels()) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#isBuildingModels().
      throw new IllegalEpoxyUsage(
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
          "You cannot call `buildModels` directly. Call `setModels` instead.");
    }
    add(currentModels);
//  ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#add(+2).
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#currentModels.
  }
}
