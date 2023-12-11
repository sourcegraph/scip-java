package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^ reference semanticdb maven . . android/os/Handler#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#

/**
 * This is a wrapper around {@link com.airbnb.epoxy.EpoxyController} to simplify how data is
 * accessed. Use this if the data required to build your models is represented by a single object.
 * <p>
 * To use this, create a subclass typed with your data object. Then, call {@link #setData(Object)}
 * whenever that data changes. This class will handle calling {@link #buildModels(Object)} with the
 * latest data.
 * <p>
 * You should NOT call {@link #requestModelBuild()} directly.
 *
 * @see Typed2EpoxyController
 * @see Typed3EpoxyController
 * @see Typed4EpoxyController
 */
public abstract class TypedEpoxyController<T> extends EpoxyController {
//                    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#
//                                         display_name TypedEpoxyController
//                                         documentation ```java\npublic abstract class TypedEpoxyController<T>\n```
//                                         documentation  This is a wrapper around {@link com.airbnb.epoxy.EpoxyController} to simplify how data is\n accessed. Use this if the data required to build your models is represented by a single object.\n <p>\n To use this, create a subclass typed with your data object. Then, call {@link #setData(Object)}\n whenever that data changes. This class will handle calling {@link #buildModels(Object)} with the\n latest data.\n <p>\n You should NOT call {@link #requestModelBuild()} directly.\n\n @see Typed2EpoxyController\n @see Typed3EpoxyController\n @see Typed4EpoxyController\n
//                                         relationship is_implementation semanticdb maven . . ModelCollector#
//                                         relationship is_implementation semanticdb maven . . StickyHeaderCallbacks#
//                                         relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                         ^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#[T]
//                                           display_name T
//                                           documentation ```java\nT\n```
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
  private T currentData;
//        ^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#[T]
//          ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#currentData.
//                      display_name currentData
//                      documentation ```java\nprivate T currentData\n```
  private boolean allowModelBuildRequests;
//                ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
//                                        display_name allowModelBuildRequests
//                                        documentation ```java\nprivate boolean allowModelBuildRequests\n```

  public TypedEpoxyController() {
//       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#`<init>`().
//                            display_name <init>
//                            documentation ```java\npublic TypedEpoxyController()\n```
  }

  public TypedEpoxyController(Handler modelBuildingHandler, Handler diffingHandler) {
//       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#`<init>`(+1).
//                            display_name <init>
//                            documentation ```java\npublic TypedEpoxyController(unresolved_type modelBuildingHandler, unresolved_type diffingHandler)\n```
//                            ^^^^^^^ reference semanticdb maven . . Handler#
//                                    ^^^^^^^^^^^^^^^^^^^^ definition local 0
//                                                         display_name modelBuildingHandler
//                                                         documentation ```java\nunresolved_type modelBuildingHandler\n```
//                                                          ^^^^^^^ reference semanticdb maven . . Handler#
//                                                                  ^^^^^^^^^^^^^^ definition local 1
//                                                                                 display_name diffingHandler
//                                                                                 documentation ```java\nunresolved_type diffingHandler\n```
    super(modelBuildingHandler, diffingHandler);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#`<init>`(+1).
//        ^^^^^^^^^^^^^^^^^^^^ reference local 0
//                              ^^^^^^^^^^^^^^ reference local 1
  }

  public final void setData(T data) {
//                  ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#setData().
//                          display_name setData
//                          documentation ```java\npublic final void setData(T data)\n```
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#[T]
//                            ^^^^ definition local 2
//                                 display_name data
//                                 documentation ```java\nT data\n```
    currentData = data;
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#currentData.
//                ^^^^ reference local 2
    allowModelBuildRequests = true;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
    requestModelBuild();
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#requestModelBuild().
    allowModelBuildRequests = false;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public final void requestModelBuild() {
//                  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#requestModelBuild().
//                                    display_name requestModelBuild
//                                    documentation ```java\n@Override\npublic final void requestModelBuild()\n```
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
    if (!allowModelBuildRequests) {
//       ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "You cannot call `requestModelBuild` directly. Call `setData` instead to trigger a "
              + "model refresh with new data.");
    }
    super.requestModelBuild();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#super.
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void moveModel(int fromPosition, int toPosition) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#moveModel().
//                      display_name moveModel
//                      documentation ```java\n@Override\npublic void moveModel(int fromPosition, int toPosition)\n```
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#moveModel().
//                          ^^^^^^^^^^^^ definition local 3
//                                       display_name fromPosition
//                                       documentation ```java\nint fromPosition\n```
//                                            ^^^^^^^^^^ definition local 4
//                                                       display_name toPosition
//                                                       documentation ```java\nint toPosition\n```
    allowModelBuildRequests = true;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
    super.moveModel(fromPosition, toPosition);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#moveModel().
//                  ^^^^^^^^^^^^ reference local 3
//                                ^^^^^^^^^^ reference local 4
    allowModelBuildRequests = false;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void requestDelayedModelBuild(int delayMs) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#requestDelayedModelBuild().
//                                     display_name requestDelayedModelBuild
//                                     documentation ```java\n@Override\npublic void requestDelayedModelBuild(int delayMs)\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
//                                         ^^^^^^^ definition local 5
//                                                 display_name delayMs
//                                                 documentation ```java\nint delayMs\n```
    if (!allowModelBuildRequests) {
//       ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "You cannot call `requestModelBuild` directly. Call `setData` instead to trigger a "
              + "model refresh with new data.");
    }
    super.requestDelayedModelBuild(delayMs);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
//                                 ^^^^^^^ reference local 5
  }

  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  public final T getCurrentData() {
//             ^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#[T]
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#getCurrentData().
//                              display_name getCurrentData
//                              documentation ```java\n@Nullable\npublic final T getCurrentData()\n```
    return currentData;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#currentData.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected final void buildModels() {
//                     ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#buildModels().
//                                 display_name buildModels
//                                 documentation ```java\n@Override\nprotected final void buildModels()\n```
//                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#buildModels().
    if (!isBuildingModels()) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#isBuildingModels().
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "You cannot call `buildModels` directly. Call `setData` instead to trigger a model "
              + "refresh with new data.");
    }
    buildModels(currentData);
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#buildModels(+1).
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#currentData.
  }

  protected abstract void buildModels(T data);
//                        ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#buildModels(+1).
//                                    display_name buildModels
//                                    documentation ```java\nprotected abstract void buildModels(T data)\n```
//                                    ^ reference semanticdb maven . . com/airbnb/epoxy/TypedEpoxyController#[T]
//                                      ^^^^ definition local 6
//                                           display_name data
//                                           documentation ```java\nT data\n```
}
