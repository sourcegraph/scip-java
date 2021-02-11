package com.airbnb.epoxy;

/**
 * A {@link ControllerHelper} implementation for adapters with no {@link
 * com.airbnb.epoxy.AutoModel} usage.
 */
class NoOpControllerHelper extends ControllerHelper<EpoxyController> {
^^^^^^ definition com/airbnb/epoxy/NoOpControllerHelper#`<init>`().
^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/NoOpControllerHelper#
//                                 ^^^^^^^^^^^^^^^^ reference _root_/
//                                                  ^^^^^^^^^^^^^^^ reference _root_/

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void resetAutoModels() {
//            ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/NoOpControllerHelper#resetAutoModels().
    // No - Op
  }
}
