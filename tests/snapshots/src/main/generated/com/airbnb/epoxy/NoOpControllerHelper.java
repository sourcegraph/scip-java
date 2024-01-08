package com.airbnb.epoxy;

/**
 * A {@link ControllerHelper} implementation for adapters with no {@link
 * com.airbnb.epoxy.AutoModel} usage.
 */
class NoOpControllerHelper extends ControllerHelper<EpoxyController> {
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NoOpControllerHelper#
//                         display_name NoOpControllerHelper
//                         signature_documentation java class NoOpControllerHelper
//                         kind Class
//                         documentation  A {@link ControllerHelper} implementation for adapters with no {@link\n com.airbnb.epoxy.AutoModel} usage.\n
//                         relationship is_implementation semanticdb maven . . com/airbnb/epoxy/ControllerHelper#
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NoOpControllerHelper#`<init>`().
//                         display_name <init>
//                         signature_documentation java NoOpControllerHelper()
//                         kind Constructor
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelper#
//                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void resetAutoModels() {
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NoOpControllerHelper#resetAutoModels().
//                            display_name resetAutoModels
//                            signature_documentation java @Override\npublic void resetAutoModels()
//                            kind Method
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/ControllerHelper#resetAutoModels().
    // No - Op
  }
}
