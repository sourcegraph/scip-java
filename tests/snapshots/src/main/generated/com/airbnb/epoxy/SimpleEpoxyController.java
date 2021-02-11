package com.airbnb.epoxy;

import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

/**
 * A small wrapper around {@link com.airbnb.epoxy.EpoxyController} that lets you set a list of
 * models directly.
 */
public class SimpleEpoxyController extends EpoxyController {
//     ^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyController#`<init>`().
//     ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyController#
//                                         ^^^^^^^^^^^^^^^ reference _root_/
  private List<? extends EpoxyModel<?>> currentModels;
//        ^^^^ reference java/util/List#
//                       ^^^^^^^^^^ reference _root_/
//                                      ^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyController#currentModels.
  private boolean insideSetModels;
//                ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyController#insideSetModels.

  /**
   * Set the models to add to this controller. Clears any previous models and adds this new list
   * .
   */
  public void setModels(List<? extends EpoxyModel<?>> models) {
//            ^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyController#setModels().
//                      ^^^^ reference java/util/List#
//                                     ^^^^^^^^^^ reference _root_/
//                                                    ^^^^^^ definition local0
    currentModels = models;
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyController#currentModels.
//                  ^^^^^^ reference local0
    insideSetModels = true;
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyController#insideSetModels.
    requestModelBuild();
//  ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyController#requestModelBuild().
    insideSetModels = false;
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyController#insideSetModels.
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public final void requestModelBuild() {
//                  ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyController#requestModelBuild().
    if (!insideSetModels) {
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyController#insideSetModels.
      throw new IllegalEpoxyUsage(
//              ^^^^^^^^^^^^^^^^^ reference _root_/
          "You cannot call `requestModelBuild` directly. Call `setModels` instead.");
    }
    super.requestModelBuild();
//  ^^^^^ reference _root_/
//        ^^^^^^^^^^^^^^^^^ reference requestModelBuild#
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  protected final void buildModels() {
//                     ^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyController#buildModels().
    if (!isBuildingModels()) {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyController#isBuildingModels#
      throw new IllegalEpoxyUsage(
//              ^^^^^^^^^^^^^^^^^ reference _root_/
          "You cannot call `buildModels` directly. Call `setModels` instead.");
    }
    add(currentModels);
//  ^^^ reference com/airbnb/epoxy/SimpleEpoxyController#add#
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/SimpleEpoxyController#currentModels.
  }
}
