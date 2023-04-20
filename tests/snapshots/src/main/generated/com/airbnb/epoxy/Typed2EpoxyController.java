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
//                                          documentation ```java\npublic abstract class Typed2EpoxyController<T, U>\n```
//                                          documentation  This is a wrapper around {@link com.airbnb.epoxy.EpoxyController} to simplify how data is\n accessed. Use this if the data required to build your models is represented by two objects.\n <p>\n To use this, create a subclass typed with your data object. Then, call {@link #setData}\n whenever that data changes. This class will handle calling {@link #buildModels} with the\n latest data.\n <p>\n You should NOT call {@link #requestModelBuild()} directly.\n\n @see TypedEpoxyController\n @see Typed3EpoxyController\n @see Typed4EpoxyController\n
//                                          relationship is_implementation semanticdb maven . . ``/ModelCollector#
//                                          relationship is_implementation semanticdb maven . . ``/StickyHeaderCallbacks#
//                                          relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                          ^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[T]
//                                            documentation ```java\nT\n```
//                                             ^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[U]
//                                               documentation ```java\nU\n```
//                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#

  private T data1;
//        ^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[T]
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#data1.
//                documentation ```java\nprivate T data1\n```
  private U data2;
//        ^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[U]
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#data2.
//                documentation ```java\nprivate U data2\n```
  private boolean allowModelBuildRequests;
//                ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#allowModelBuildRequests.
//                                        documentation ```java\nprivate boolean allowModelBuildRequests\n```

  public Typed2EpoxyController() {
//       ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#`<init>`().
//                             documentation ```java\npublic Typed2EpoxyController()\n```
  }

  public Typed2EpoxyController(Handler modelBuildingHandler, Handler diffingHandler) {
//       ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#`<init>`(+1).
//                             documentation ```java\npublic Typed2EpoxyController(unresolved_type modelBuildingHandler, unresolved_type diffingHandler)\n```
//                             ^^^^^^^ reference semanticdb maven . . _root_/
//                                     ^^^^^^^^^^^^^^^^^^^^ definition local 0
//                                                          documentation ```java\nunresolved_type modelBuildingHandler\n```
//                                                           ^^^^^^^ reference semanticdb maven . . _root_/
//                                                                   ^^^^^^^^^^^^^^ definition local 1
//                                                                                  documentation ```java\nunresolved_type diffingHandler\n```
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
//                    documentation ```java\npublic void setData(T data1, U data2)\n```
//                    documentation  Call this with the latest data when you want models to be rebuilt. The data will be passed on\n to {@link #buildModels(Object, Object)}\n
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[T]
//                      ^^^^^ definition local 2
//                            documentation ```java\nT data1\n```
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[U]
//                               ^^^^^ definition local 3
//                                     documentation ```java\nU data2\n```
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
//                                    documentation ```java\n@Override\npublic final void requestModelBuild()\n```
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
//                      documentation ```java\n@Override\npublic void moveModel(int fromPosition, int toPosition)\n```
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#moveModel().
//                          ^^^^^^^^^^^^ definition local 4
//                                       documentation ```java\nint fromPosition\n```
//                                            ^^^^^^^^^^ definition local 5
//                                                       documentation ```java\nint toPosition\n```
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
//                                     documentation ```java\n@Override\npublic void requestDelayedModelBuild(int delayMs)\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
//                                         ^^^^^^^ definition local 6
//                                                 documentation ```java\nint delayMs\n```
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
//                                 documentation ```java\n@Override\nprotected final void buildModels()\n```
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
//                                    documentation ```java\nprotected abstract void buildModels(T data1, U data2)\n```
//                                    ^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[T]
//                                      ^^^^^ definition local 7
//                                            documentation ```java\nT data1\n```
//                                             ^ reference semanticdb maven . . com/airbnb/epoxy/Typed2EpoxyController#[U]
//                                               ^^^^^ definition local 8
//                                                     documentation ```java\nU data2\n```
}
