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
//                                 display_name SimpleEpoxyController
//                                 signature_documentation java public class SimpleEpoxyController
//                                 documentation  A small wrapper around {@link com.airbnb.epoxy.EpoxyController} that lets you set a list of\n models directly.\n
//                                 relationship is_implementation semanticdb maven . . ModelCollector#
//                                 relationship is_implementation semanticdb maven . . StickyHeaderCallbacks#
//                                 relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//           ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#`<init>`().
//                                 display_name <init>
//                                 signature_documentation java public SimpleEpoxyController()
//                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
  private List<? extends EpoxyModel<?>> currentModels;
//        ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#currentModels.
//                                                    display_name currentModels
//                                                    signature_documentation java private List<? extends EpoxyModel<?>> currentModels
  private boolean insideSetModels;
//                ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#insideSetModels.
//                                display_name insideSetModels
//                                signature_documentation java private boolean insideSetModels

  /**
   * Set the models to add to this controller. Clears any previous models and adds this new list
   * .
   */
  public void setModels(List<? extends EpoxyModel<?>> models) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#setModels().
//                      display_name setModels
//                      signature_documentation java public void setModels(List<? extends EpoxyModel<?>> models)
//                      documentation  Set the models to add to this controller. Clears any previous models and adds this new list\n .\n
//                      ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                    ^^^^^^ definition local 0
//                                                           display_name models
//                                                           signature_documentation java List<? extends EpoxyModel<?>> models
//                                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyController#setModels().
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
//                                    display_name requestModelBuild
//                                    signature_documentation java @Override\npublic final void requestModelBuild()
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
//                                 display_name buildModels
//                                 signature_documentation java @Override\nprotected final void buildModels()
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
