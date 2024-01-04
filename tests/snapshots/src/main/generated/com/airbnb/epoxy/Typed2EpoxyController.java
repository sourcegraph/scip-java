package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^ reference semanticdb maven . . android/os/Handler#

/**
 * This is a wrapper around {@link com.airbnb.epoxy.EpoxyController} to simplify how data is
 * accessed. Use this if the data required to build your models is represented by two objects.
 * <p>
 * To use this, create a subclass typed with your data object. Then, call {@link #setData}
 * whenever that data changes. This class will handle calling {@link #buildModels} with the
 * latest data.
 * <p>
 * You should NOT call {@link #requestModelBuild()} directly.
 *
 * @see TypedEpoxyController
 * @see Typed3EpoxyController
 * @see Typed4EpoxyController
 */
public abstract class Typed2EpoxyController<T, U> extends EpoxyController {
//                    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#
//                                          display_name Typed2EpoxyController
//                                          signature_documentation java public abstract class Typed2EpoxyController<T, U>
//                                          documentation  This is a wrapper around {@link com.airbnb.epoxy.EpoxyController} to simplify how data is\n accessed. Use this if the data required to build your models is represented by two objects.\n <p>\n To use this, create a subclass typed with your data object. Then, call {@link #setData}\n whenever that data changes. This class will handle calling {@link #buildModels} with the\n latest data.\n <p>\n You should NOT call {@link #requestModelBuild()} directly.\n\n @see TypedEpoxyController\n @see Typed3EpoxyController\n @see Typed4EpoxyController\n
//                                          relationship is_implementation semanticdb maven . . ModelCollector#
//                                          relationship is_implementation semanticdb maven . . StickyHeaderCallbacks#
//                                          relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                          ^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[T]
//                                            display_name T
//                                            signature_documentation java T
//                                             ^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[U]
//                                               display_name U
//                                               signature_documentation java U
//                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#

  private T data1;
//        ^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[T]
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#data1.
//                display_name data1
//                signature_documentation java private T data1
  private U data2;
//        ^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[U]
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#data2.
//                display_name data2
//                signature_documentation java private U data2
  private boolean allowModelBuildRequests;
//                ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#allowModelBuildRequests.
//                                        display_name allowModelBuildRequests
//                                        signature_documentation java private boolean allowModelBuildRequests

  public Typed2EpoxyController() {
//       ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#`<init>`().
//                             display_name <init>
//                             signature_documentation java public Typed2EpoxyController()
  }

  public Typed2EpoxyController(Handler modelBuildingHandler, Handler diffingHandler) {
//       ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#`<init>`(+1).
//                             display_name <init>
//                             signature_documentation java public Typed2EpoxyController(unresolved_type modelBuildingHandler, unresolved_type diffingHandler)
//                             ^^^^^^^ reference semanticdb maven . . Handler#
//                                     ^^^^^^^^^^^^^^^^^^^^ definition local 0
//                                                          display_name modelBuildingHandler
//                                                          signature_documentation java unresolved_type modelBuildingHandler
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#`<init>`(+1).
//                                                           ^^^^^^^ reference semanticdb maven . . Handler#
//                                                                   ^^^^^^^^^^^^^^ definition local 1
//                                                                                  display_name diffingHandler
//                                                                                  signature_documentation java unresolved_type diffingHandler
//                                                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#`<init>`(+1).
    super(modelBuildingHandler, diffingHandler);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#`<init>`(+1).
//        ^^^^^^^^^^^^^^^^^^^^ reference local 0
//                              ^^^^^^^^^^^^^^ reference local 1
  }

  /**
   * Call this with the latest data when you want models to be rebuilt. The data will be passed on
   * to {@link #buildModels(Object, Object)}
   */
  public void setData(T data1, U data2) {
//            ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#setData().
//                    display_name setData
//                    signature_documentation java public void setData(T data1, U data2)
//                    documentation  Call this with the latest data when you want models to be rebuilt. The data will be passed on\n to {@link #buildModels(Object, Object)}\n
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[T]
//                      ^^^^^ definition local 2
//                            display_name data1
//                            signature_documentation java T data1
//                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#setData().
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[U]
//                               ^^^^^ definition local 3
//                                     display_name data2
//                                     signature_documentation java U data2
//                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#setData().
    this.data1 = data1;
//       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#data1.
//               ^^^^^ reference local 2
    this.data2 = data2;
//       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#data2.
//               ^^^^^ reference local 3
    allowModelBuildRequests = true;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#allowModelBuildRequests.
    requestModelBuild();
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#requestModelBuild().
    allowModelBuildRequests = false;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#allowModelBuildRequests.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final void requestModelBuild() {
//                  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#requestModelBuild().
//                                    display_name requestModelBuild
//                                    signature_documentation java @Override\npublic final void requestModelBuild()
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
    if (!allowModelBuildRequests) {
//       ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#allowModelBuildRequests.
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "You cannot call `requestModelBuild` directly. Call `setData` instead to trigger a "
              + "model refresh with new data.");
    }
    super.requestModelBuild();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#super.
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void moveModel(int fromPosition, int toPosition) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#moveModel().
//                      display_name moveModel
//                      signature_documentation java @Override\npublic void moveModel(int fromPosition, int toPosition)
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#moveModel().
//                          ^^^^^^^^^^^^ definition local 4
//                                       display_name fromPosition
//                                       signature_documentation java int fromPosition
//                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#moveModel().
//                                            ^^^^^^^^^^ definition local 5
//                                                       display_name toPosition
//                                                       signature_documentation java int toPosition
//                                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#moveModel().
    allowModelBuildRequests = true;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#allowModelBuildRequests.
    super.moveModel(fromPosition, toPosition);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#moveModel().
//                  ^^^^^^^^^^^^ reference local 4
//                                ^^^^^^^^^^ reference local 5
    allowModelBuildRequests = false;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#allowModelBuildRequests.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void requestDelayedModelBuild(int delayMs) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#requestDelayedModelBuild().
//                                     display_name requestDelayedModelBuild
//                                     signature_documentation java @Override\npublic void requestDelayedModelBuild(int delayMs)
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
//                                         ^^^^^^^ definition local 6
//                                                 display_name delayMs
//                                                 signature_documentation java int delayMs
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#requestDelayedModelBuild().
    if (!allowModelBuildRequests) {
//       ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#allowModelBuildRequests.
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "You cannot call `requestModelBuild` directly. Call `setData` instead to trigger a "
              + "model refresh with new data.");
    }
    super.requestDelayedModelBuild(delayMs);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
//                                 ^^^^^^^ reference local 6
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected final void buildModels() {
//                     ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#buildModels().
//                                 display_name buildModels
//                                 signature_documentation java @Override\nprotected final void buildModels()
//                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#buildModels().
    if (!isBuildingModels()) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#isBuildingModels().
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "You cannot call `buildModels` directly. Call `setData` instead to trigger a model "
              + "refresh with new data.");
    }
    buildModels(data1, data2);
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#buildModels(+1).
//              ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#data1.
//                     ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#data2.
  }

  protected abstract void buildModels(T data1, U data2);
//                        ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#buildModels(+1).
//                                    display_name buildModels
//                                    signature_documentation java protected abstract void buildModels(T data1, U data2)
//                                    ^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[T]
//                                      ^^^^^ definition local 7
//                                            display_name data1
//                                            signature_documentation java T data1
//                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#buildModels(+1).
//                                             ^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[U]
//                                               ^^^^^ definition local 8
//                                                     display_name data2
//                                                     signature_documentation java U data2
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#buildModels(+1).
}
