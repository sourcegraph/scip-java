package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference android/
//             ^^ reference android/os/
//                ^^^^^^^ reference android/os/Handler#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#

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
//                    ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/TypedEpoxyController# public abstract class TypedEpoxyController<T> extends EpoxyController
//                                         ^ definition com/airbnb/epoxy/TypedEpoxyController#[T] T
//                                                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
  private T currentData;
//        ^ reference com/airbnb/epoxy/TypedEpoxyController#[T]
//          ^^^^^^^^^^^ definition com/airbnb/epoxy/TypedEpoxyController#currentData. private T currentData
  private boolean allowModelBuildRequests;
//                ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests. private boolean allowModelBuildRequests

  public TypedEpoxyController() {
//       ^^^^^^ definition com/airbnb/epoxy/TypedEpoxyController#`<init>`(). public <init>()
  }

  public TypedEpoxyController(Handler modelBuildingHandler, Handler diffingHandler) {
//       ^^^^^^ definition com/airbnb/epoxy/TypedEpoxyController#`<init>`(+1). public <init>(unresolved_type modelBuildingHandler, unresolved_type diffingHandler)
//                            ^^^^^^^ reference _root_/
//                                    ^^^^^^^^^^^^^^^^^^^^ definition local0 unresolved_type modelBuildingHandler
//                                                          ^^^^^^^ reference _root_/
//                                                                  ^^^^^^^^^^^^^^ definition local1 unresolved_type diffingHandler
    super(modelBuildingHandler, diffingHandler);
//  ^^^^^ reference com/airbnb/epoxy/EpoxyController#`<init>`(+1).
//        ^^^^^^^^^^^^^^^^^^^^ reference local0
//                              ^^^^^^^^^^^^^^ reference local1
  }

  public final void setData(T data) {
//                  ^^^^^^^ definition com/airbnb/epoxy/TypedEpoxyController#setData(). public final setData(T data)
//                          ^ reference com/airbnb/epoxy/TypedEpoxyController#[T]
//                            ^^^^ definition local2 T data
    currentData = data;
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#currentData.
//                ^^^^ reference local2
    allowModelBuildRequests = true;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
    requestModelBuild();
//  ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#requestModelBuild().
    allowModelBuildRequests = false;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public final void requestModelBuild() {
//                  ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/TypedEpoxyController#requestModelBuild(). public final requestModelBuild()
    if (!allowModelBuildRequests) {
//       ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
      throw new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 2:47
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
          "You cannot call `requestModelBuild` directly. Call `setData` instead to trigger a "
              + "model refresh with new data.");
    }
    super.requestModelBuild();
//  ^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#super.
//        ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#requestModelBuild().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void moveModel(int fromPosition, int toPosition) {
//            ^^^^^^^^^ definition com/airbnb/epoxy/TypedEpoxyController#moveModel(). public moveModel(int fromPosition, int toPosition)
//                          ^^^^^^^^^^^^ definition local3 int fromPosition
//                                            ^^^^^^^^^^ definition local4 int toPosition
    allowModelBuildRequests = true;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
    super.moveModel(fromPosition, toPosition);
//  ^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#super.
//        ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#moveModel().
//                  ^^^^^^^^^^^^ reference local3
//                                ^^^^^^^^^^ reference local4
    allowModelBuildRequests = false;
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void requestDelayedModelBuild(int delayMs) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/TypedEpoxyController#requestDelayedModelBuild(). public requestDelayedModelBuild(int delayMs)
//                                         ^^^^^^^ definition local5 int delayMs
    if (!allowModelBuildRequests) {
//       ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#allowModelBuildRequests.
      throw new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 2:47
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
          "You cannot call `requestModelBuild` directly. Call `setData` instead to trigger a "
              + "model refresh with new data.");
    }
    super.requestDelayedModelBuild(delayMs);
//  ^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#requestDelayedModelBuild().
//                                 ^^^^^^^ reference local5
  }

  @Nullable
// ^^^^^^^^ reference androidx/annotation/Nullable#
  public final T getCurrentData() {
//             ^ reference com/airbnb/epoxy/TypedEpoxyController#[T]
//               ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/TypedEpoxyController#getCurrentData(). public final T getCurrentData()
    return currentData;
//         ^^^^^^^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#currentData.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected final void buildModels() {
//                     ^^^^^^^^^^^ definition com/airbnb/epoxy/TypedEpoxyController#buildModels(). protected final buildModels()
    if (!isBuildingModels()) {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#isBuildingModels().
      throw new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 2:41
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
          "You cannot call `buildModels` directly. Call `setData` instead to trigger a model "
              + "refresh with new data.");
    }
    buildModels(currentData);
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#buildModels(+1).
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/TypedEpoxyController#currentData.
  }

  protected abstract void buildModels(T data);
//                        ^^^^^^^^^^^ definition com/airbnb/epoxy/TypedEpoxyController#buildModels(+1). protected abstract buildModels(T data)
//                                    ^ reference com/airbnb/epoxy/TypedEpoxyController#[T]
//                                      ^^^^ definition local6 T data
}
