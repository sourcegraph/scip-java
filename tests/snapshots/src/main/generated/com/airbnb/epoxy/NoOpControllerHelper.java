package com.airbnb.epoxy;

/**
 * A {@link ControllerHelper} implementation for adapters with no {@link
 * com.airbnb.epoxy.AutoModel} usage.
 */
class NoOpControllerHelper extends ControllerHelper<EpoxyController> {
//    ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/NoOpControllerHelper# class NoOpControllerHelper extends ControllerHelper<EpoxyController>
//    ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/NoOpControllerHelper#`<init>`(). void <init>()
//                                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerHelper#
//                                                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void resetAutoModels() {
//            ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/NoOpControllerHelper#resetAutoModels(). public void resetAutoModels()
    // No - Op
  }
}
