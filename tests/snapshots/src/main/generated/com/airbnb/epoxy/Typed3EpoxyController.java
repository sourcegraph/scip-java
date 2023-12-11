package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^ reference semanticdb maven . . android/os/Handler#

/**
 * This is a wrapper around {@link com.airbnb.epoxy.EpoxyController} to simplify how data is
 * accessed. Use this if the data required to build your models is represented by three objects.
 * <p>
 * To use this, create a subclass typed with your data object. Then, call {@link #setData}
 * whenever that data changes. This class will handle calling {@link #buildModels} with the
 * latest data.
 * <p>
 * You should NOT call {@link #requestModelBuild()} directly.
 *
 * @see TypedEpoxyController
 * @see Typed2EpoxyController
 * @see Typed4EpoxyController
 */
public abstract class Typed3EpoxyController<T, U, V> extends EpoxyController {
//                    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#
//                                          display_name Typed3EpoxyController
//                                          signature_documentation java public abstract class Typed3EpoxyController<T, U, V>
//                                          documentation  This is a wrapper around {@link com.airbnb.epoxy.EpoxyController} to simplify how data is\n accessed. Use this if the data required to build your models is represented by three objects.\n <p>\n To use this, create a subclass typed with your data object. Then, call {@link #setData}\n whenever that data changes. This class will handle calling {@link #buildModels} with the\n latest data.\n <p>\n You should NOT call {@link #requestModelBuild()} directly.\n\n @see TypedEpoxyController\n @see Typed2EpoxyController\n @see Typed4EpoxyController\n
//                                          relationship is_implementation semanticdb maven . . ModelCollector#
//                                          relationship is_implementation semanticdb maven . . StickyHeaderCallbacks#
//                                          relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                          ^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#[T]
//                                            display_name T
//                                            signature_documentation java T
//                                             ^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#[U]
//                                               display_name U
//                                               signature_documentation java U
//                                                ^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#[V]
//                                                  display_name V
//                                                  signature_documentation java V
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#

  private T data1;
//        ^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#[T]
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#data1.
//                display_name data1
//                signature_documentation java private T data1
  private U data2;
//        ^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#[U]
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#data2.
//                display_name data2
//                signature_documentation java private U data2
  private V data3;
//        ^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#[V]
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#data3.
//                display_name data3
//                signature_documentation java private V data3
  private boolean allowModelBuildRequests;
//                ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#allowModelBuildRequests.
//                                        display_name allowModelBuildRequests
//                                        signature_documentation java private boolean allowModelBuildRequests

  public Typed3EpoxyController() {
//       ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#`<init>`().
//                             display_name <init>
//                             signature_documentation java public Typed3EpoxyController()
  }

  public Typed3EpoxyController(Handler modelBuildingHandler, Handler diffingHandler) {
//       ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#`<init>`(+1).
//                             display_name <init>
//                             signature_documentation java public Typed3EpoxyController(unresolved_type modelBuildingHandler, unresolved_type diffingHandler)
//                             ^^^^^^^ reference semanticdb maven . . Handler#
//                                     ^^^^^^^^^^^^^^^^^^^^ definition local 0
//                                                          display_name modelBuildingHandler
//                                                          signature_documentation java unresolved_type modelBuildingHandler
//                                                           ^^^^^^^ reference semanticdb maven . . Handler#
//                                                                   ^^^^^^^^^^^^^^ definition local 1
//                                                                                  display_name diffingHandler
//                                                                                  signature_documentation java unresolved_type diffingHandler
    super(modelBuildingHandler, diffingHandler);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#`<init>`(+1).
//        ^^^^^^^^^^^^^^^^^^^^ reference local 0
//                              ^^^^^^^^^^^^^^ reference local 1
  }

  /**
   * Call this with the latest data when you want models to be rebuilt. The data will be passed on
   * to {@link #buildModels(Object, Object, Object)}
   */
  public void setData(T data1, U data2, V data3) {
//            ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#setData().
//                    display_name setData
//                    signature_documentation java public void setData(T data1, U data2, V data3)
//                    documentation  Call this with the latest data when you want models to be rebuilt. The data will be passed on\n to {@link #buildModels(Object, Object, Object)}\n
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#[T]
//                      ^^^^^ definition local 2
//                            display_name data1
//                            signature_documentation java T data1
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#[U]
//                               ^^^^^ definition local 3
//                                     display_name data2
//                                     signature_documentation java U data2
//                                      ^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#[V]
//                                        ^^^^^ definition local 4
//                                              display_name data3
//                                              signature_documentation java V data3
    this.data1 = data1;
//       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#data1.
//               ^^^^^ reference local 2
    this.data2 = data2;
//       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#data2.
//               ^^^^^ reference local 3
    this.data3 = data3;
//       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#data3.
//               ^^^^^ reference local 4
    allowModelBuildRequests = true;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#allowModelBuildRequests.
    requestModelBuild();
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#requestModelBuild().
    allowModelBuildRequests = false;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#allowModelBuildRequests.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final void requestModelBuild() {
//                  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#requestModelBuild().
//                                    display_name requestModelBuild
//                                    signature_documentation java @Override\npublic final void requestModelBuild()
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
    if (!allowModelBuildRequests) {
//       ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#allowModelBuildRequests.
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "You cannot call `requestModelBuild` directly. Call `setData` instead to trigger a "
              + "model refresh with new data.");
    }
    super.requestModelBuild();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#super.
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void moveModel(int fromPosition, int toPosition) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#moveModel().
//                      display_name moveModel
//                      signature_documentation java @Override\npublic void moveModel(int fromPosition, int toPosition)
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#moveModel().
//                          ^^^^^^^^^^^^ definition local 5
//                                       display_name fromPosition
//                                       signature_documentation java int fromPosition
//                                            ^^^^^^^^^^ definition local 6
//                                                       display_name toPosition
//                                                       signature_documentation java int toPosition
    allowModelBuildRequests = true;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#allowModelBuildRequests.
    super.moveModel(fromPosition, toPosition);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#moveModel().
//                  ^^^^^^^^^^^^ reference local 5
//                                ^^^^^^^^^^ reference local 6
    allowModelBuildRequests = false;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#allowModelBuildRequests.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void requestDelayedModelBuild(int delayMs) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#requestDelayedModelBuild().
//                                     display_name requestDelayedModelBuild
//                                     signature_documentation java @Override\npublic void requestDelayedModelBuild(int delayMs)
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
//                                         ^^^^^^^ definition local 7
//                                                 display_name delayMs
//                                                 signature_documentation java int delayMs
    if (!allowModelBuildRequests) {
//       ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#allowModelBuildRequests.
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "You cannot call `requestModelBuild` directly. Call `setData` instead to trigger a "
              + "model refresh with new data.");
    }
    super.requestDelayedModelBuild(delayMs);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
//                                 ^^^^^^^ reference local 7
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected final void buildModels() {
//                     ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#buildModels().
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
    buildModels(data1, data2, data3);
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#buildModels(+1).
//              ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#data1.
//                     ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#data2.
//                            ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#data3.
  }

  protected abstract void buildModels(T data1, U data2, V data3);
//                        ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#buildModels(+1).
//                                    display_name buildModels
//                                    signature_documentation java protected abstract void buildModels(T data1, U data2, V data3)
//                                    ^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#[T]
//                                      ^^^^^ definition local 8
//                                            display_name data1
//                                            signature_documentation java T data1
//                                             ^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#[U]
//                                               ^^^^^ definition local 9
//                                                     display_name data2
//                                                     signature_documentation java U data2
//                                                      ^ reference semanticdb maven . . com/airbnb/epoxy/Typed3EpoxyController#[V]
//                                                        ^^^^^ definition local 10
//                                                              display_name data3
//                                                              signature_documentation java V data3
}
