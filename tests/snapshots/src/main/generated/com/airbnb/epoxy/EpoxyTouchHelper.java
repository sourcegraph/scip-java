package com.airbnb.epoxy;

import android.graphics.Canvas;
//     ^^^^^^^ reference android/
//             ^^^^^^^^ reference android/graphics/
//                      ^^^^^^ reference android/graphics/Canvas#
import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#

import java.util.ArrayList;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^ reference java/util/ArrayList#
import java.util.Arrays;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^ reference java/util/Arrays#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

import androidx.recyclerview.widget.ItemTouchHelper;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/ItemTouchHelper#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView#

import static androidx.recyclerview.widget.ItemTouchHelper.Callback.makeMovementFlags;
//            ^^^^^^^^ reference androidx/
//                     ^^^^^^^^^^^^ reference androidx/recyclerview/
//                                  ^^^^^^ reference androidx/recyclerview/widget/
//                                         ^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/ItemTouchHelper/
//                                                         ^^^^^^^^ reference androidx/recyclerview/widget/ItemTouchHelper/Callback#

/**
 * A simple way to set up drag or swipe interactions with Epoxy.
 * <p>
 * Drag events work with the EpoxyController and automatically update the controller and
 * RecyclerView when an item is moved. You just need to implement a callback to update your data to
 * reflect the change.
 * <p>
 * Both swipe and drag events implement a small lifecycle to help you style the views as they are
 * moved. You can register callbacks for the lifecycle events you care about.
 * <p>
 * If you want to set up multiple drag and swipe rules for the same RecyclerView, you can use this
 * class multiple times to specify different targets or swipe and drag directions and callbacks.
 * <p>
 * If you want more control over configuration and handling, you can opt to not use this class and
 * instead you can implement {@link EpoxyModelTouchCallback} directly with your own {@link
 * ItemTouchHelper}. That class provides an interface that makes it easier to work with Epoxy models
 * and simplifies touch callbacks.
 * <p>
 * If you want even more control you can implement {@link EpoxyTouchHelperCallback}. This is just a
 * light layer over the normal RecyclerView touch callbacks, but it converts all view holders to
 * Epoxy view holders to remove some boilerplate for you.
 */
public abstract class EpoxyTouchHelper {
//              ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#`<init>`().
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#

  /**
   * The entry point for setting up drag support.
   *
   * @param controller The EpoxyController with the models that will be dragged. The controller will
   *                   be updated for you when a model is dragged and moved by a user's touch
   *                   interaction.
   */
  public static DragBuilder initDragging(EpoxyController controller) {
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#
//                          ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#initDragging().
//                                       ^^^^^^^^^^^^^^^ reference _root_/
//                                                       ^^^^^^^^^^ definition local0
    return new DragBuilder(controller);
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#`<init>`().
//             ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#
//                         ^^^^^^^^^^ reference local0
  }

  public static class DragBuilder {
//              ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference _root_/
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#controller.

    private DragBuilder(EpoxyController controller) {
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#`<init>`().
//                      ^^^^^^^^^^^^^^^ reference _root_/
//                                      ^^^^^^^^^^ definition local1
      this.controller = controller;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#this.
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#controller.
//                      ^^^^^^^^^^ reference local1
    }

    /**
     * The recyclerview that the EpoxyController has its adapter added to. An {@link
     * androidx.recyclerview.widget.ItemTouchHelper} will be created and configured for you, and
     * attached to this RecyclerView.
     */
    public DragBuilder2 withRecyclerView(RecyclerView recyclerView) {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#
//                      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#withRecyclerView().
//                                       ^^^^^^^^^^^^ reference _root_/
//                                                    ^^^^^^^^^^^^ definition local2
      return new DragBuilder2(controller, recyclerView);
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#`<init>`().
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#controller.
//                                        ^^^^^^^^^^^^ reference local2
    }
  }

  public static class DragBuilder2 {
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference _root_/
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#controller.
    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#recyclerView.

    private DragBuilder2(EpoxyController controller, RecyclerView recyclerView) {
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#`<init>`().
//                       ^^^^^^^^^^^^^^^ reference _root_/
//                                       ^^^^^^^^^^ definition local3
//                                                   ^^^^^^^^^^^^ reference _root_/
//                                                                ^^^^^^^^^^^^ definition local4
      this.controller = controller;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#this.
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#controller.
//                      ^^^^^^^^^^ reference local3
      this.recyclerView = recyclerView;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#this.
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#recyclerView.
//                        ^^^^^^^^^^^^ reference local4
    }

    /** Enable dragging vertically, up and down. */
    public DragBuilder3 forVerticalList() {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#forVerticalList().
      return withDirections(ItemTouchHelper.UP | ItemTouchHelper.DOWN);
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^ reference UP#
//                                               ^^^^^^^^^^^^^^^ reference _root_/
//                                                               ^^^^ reference DOWN#
    }

    /** Enable dragging horizontally, left and right. */
    public DragBuilder3 forHorizontalList() {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#forHorizontalList().
      return withDirections(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^^^ reference LEFT#
//                                                 ^^^^^^^^^^^^^^^ reference _root_/
//                                                                 ^^^^^ reference RIGHT#
    }

    /** Enable dragging in all directions. */
    public DragBuilder3 forGrid() {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#forGrid().
      return withDirections(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^ reference UP#
//                                               ^^^^^^^^^^^^^^^ reference _root_/
//                                                               ^^^^ reference DOWN#
//                                                                      ^^^^^^^^^^^^^^^ reference _root_/
//                                                                                      ^^^^ reference LEFT#
          | ItemTouchHelper.RIGHT);
//          ^^^^^^^^^^^^^^^ reference _root_/
//                          ^^^^^ reference RIGHT#
    }

    /**
     * Set custom movement flags to dictate which drag directions should be allowed.
     * <p>
     * Can be any of {@link ItemTouchHelper#LEFT}, {@link ItemTouchHelper#RIGHT}, {@link
     * ItemTouchHelper#UP}, {@link ItemTouchHelper#DOWN}, {@link ItemTouchHelper#START}, {@link
     * ItemTouchHelper#END}
     * <p>
     * Flags can be OR'd together to allow multiple directions.
     */
    public DragBuilder3 withDirections(int directionFlags) {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections().
//                                         ^^^^^^^^^^^^^^ definition local5
      return new DragBuilder3(controller, recyclerView, makeMovementFlags(directionFlags, 0));
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#`<init>`().
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#controller.
//                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#recyclerView.
//                                                      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#makeMovementFlags#
//                                                                        ^^^^^^^^^^^^^^ reference local5
    }
  }

  public static class DragBuilder3 {
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference _root_/
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.

    private DragBuilder3(EpoxyController controller, RecyclerView recyclerView, int movementFlags) {
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#`<init>`().
//                       ^^^^^^^^^^^^^^^ reference _root_/
//                                       ^^^^^^^^^^ definition local6
//                                                   ^^^^^^^^^^^^ reference _root_/
//                                                                ^^^^^^^^^^^^ definition local7
//                                                                                  ^^^^^^^^^^^^^ definition local8
      this.controller = controller;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#this.
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
//                      ^^^^^^^^^^ reference local6
      this.recyclerView = recyclerView;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#this.
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
//                        ^^^^^^^^^^^^ reference local7
      this.movementFlags = movementFlags;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#this.
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.
//                         ^^^^^^^^^^^^^ reference local8
    }

    /**
     * Set the type of Epoxy model that is draggable. This approach works well if you only have one
     * draggable type.
     */
    public <U extends EpoxyModel> DragBuilder4<U> withTarget(Class<U> targetModelClass) {
//                    ^^^^^^^^^^ reference _root_/
//                                ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                                             ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().[U]
//                                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().
//                                                           ^^^^^ reference java/lang/Class#
//                                                                 ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().[U]
//                                                                    ^^^^^^^^^^^^^^^^ definition local9
      List<Class<? extends EpoxyModel>> targetClasses = new ArrayList<>(1);
//    ^^^^ reference java/util/List#
//         ^^^^^ reference java/lang/Class#
//                         ^^^^^^^^^^ reference _root_/
//                                      ^^^^^^^^^^^^^ definition local10
//                                                      ^^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`().
//                                                          ^^^^^^^^^ reference java/util/ArrayList#
      targetClasses.add(targetModelClass);
//    ^^^^^^^^^^^^^ reference local10
//                  ^^^ reference java/util/List#add().
//                      ^^^^^^^^^^^^^^^^ reference local9

      return new DragBuilder4<>(controller, recyclerView, movementFlags, targetModelClass,
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#`<init>`(). 1:24
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
//                                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
//                                                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.
//                                                                       ^^^^^^^^^^^^^^^^ reference local9
          targetClasses);
//        ^^^^^^^^^^^^^ reference local10
    }

    /**
     * Specify which Epoxy model types are draggable. Use this if you have more than one type that
     * is draggable.
     * <p>
     * If you only have one draggable type you should use {@link #withTarget(Class)}
     */
    public DragBuilder4<EpoxyModel> withTargets(Class<? extends EpoxyModel>... targetModelClasses) {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                      ^^^^^^^^^^ reference _root_/
//                                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTargets().
//                                              ^^^^^ reference java/lang/Class#
//                                                              ^^^^^^^^^^ reference _root_/
//                                                                             ^^^^^^^^^^^^^^^^^^ definition local11
      return new DragBuilder4<>(controller, recyclerView, movementFlags, EpoxyModel.class,
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#`<init>`(). 1:44
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
//                                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
//                                                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.
//                                                                       ^^^^^^^^^^ reference _root_/
//                                                                                  ^^^^^ reference class#
          Arrays.asList(targetModelClasses));
//        ^^^^^^ reference java/util/Arrays#
//               ^^^^^^ reference java/util/Arrays#asList().
//                      ^^^^^^^^^^^^^^^^^^ reference local11
    }

    /**
     * Use this if all models in the controller should be draggable, and if there are multiple types
     * of models in the controller.
     * <p>
     * If you only have one model type you should use {@link #withTarget(Class)}
     */
    public DragBuilder4<EpoxyModel> forAllModels() {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                      ^^^^^^^^^^ reference _root_/
//                                  ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#forAllModels().
      return withTarget(EpoxyModel.class);
//           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().
//                      ^^^^^^^^^^ reference _root_/
//                                 ^^^^^ reference class#
    }
  }

  public static class DragBuilder4<U extends EpoxyModel> {
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                                           ^^^^^^^^^^ reference _root_/

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference _root_/
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#controller.
    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#recyclerView.
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#movementFlags.
    private final Class<U> targetModelClass;
//                ^^^^^ reference java/lang/Class#
//                      ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                         ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClass.
    private final List<Class<? extends EpoxyModel>> targetModelClasses;
//                ^^^^ reference java/util/List#
//                     ^^^^^ reference java/lang/Class#
//                                     ^^^^^^^^^^ reference _root_/
//                                                  ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses.

    private DragBuilder4(EpoxyController controller,
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#`<init>`().
//                       ^^^^^^^^^^^^^^^ reference _root_/
//                                       ^^^^^^^^^^ definition local12
        RecyclerView recyclerView, int movementFlags,
//      ^^^^^^^^^^^^ reference _root_/
//                   ^^^^^^^^^^^^ definition local13
//                                     ^^^^^^^^^^^^^ definition local14
        Class<U> targetModelClass, List<Class<? extends EpoxyModel>> targetModelClasses) {
//      ^^^^^ reference java/lang/Class#
//            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//               ^^^^^^^^^^^^^^^^ definition local15
//                                 ^^^^ reference java/util/List#
//                                      ^^^^^ reference java/lang/Class#
//                                                      ^^^^^^^^^^ reference _root_/
//                                                                   ^^^^^^^^^^^^^^^^^^ definition local16

      this.controller = controller;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#this.
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#controller.
//                      ^^^^^^^^^^ reference local12
      this.recyclerView = recyclerView;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#this.
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#recyclerView.
//                        ^^^^^^^^^^^^ reference local13
      this.movementFlags = movementFlags;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#this.
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#movementFlags.
//                         ^^^^^^^^^^^^^ reference local14
      this.targetModelClass = targetModelClass;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#this.
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClass.
//                            ^^^^^^^^^^^^^^^^ reference local15
      this.targetModelClasses = targetModelClasses;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#this.
//         ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses.
//                              ^^^^^^^^^^^^^^^^^^ reference local16
    }

    /**
     * Set callbacks to handle drag actions and lifecycle events.
     * <p>
     * You MUST implement {@link DragCallbacks#onModelMoved(int, int, EpoxyModel,
     * View)} to update your data to reflect an item move.
     * <p>
     * You can optionally implement the other callbacks to modify the view being dragged. This is
     * useful if you want to change things like the view background, size, color, etc
     *
     * @return An {@link ItemTouchHelper} instance that has been initialized and attached to a
     * recyclerview. The touch helper has already been fully set up and can be ignored, but you may
     * want to hold a reference to it if you need to later detach the recyclerview to disable touch
     * events via setting null on {@link ItemTouchHelper#attachToRecyclerView(RecyclerView)}
     */
    public ItemTouchHelper andCallbacks(final DragCallbacks<U> callbacks) {
//         ^^^^^^^^^^^^^^^ reference _root_/
//                         ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#andCallbacks().
//                                            ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#
//                                                          ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                             ^^^^^^^^^ definition local17
      ItemTouchHelper itemTouchHelper =
//    ^^^^^^^^^^^^^^^ reference _root_/
//                    ^^^^^^^^^^^^^^^ definition local18
          new ItemTouchHelper(new EpoxyModelTouchCallback<U>(controller, targetModelClass) {
//            ^^^^^^^^^^^^^^^ reference _root_/
//                                ^^^^^^^^^^^^^^^^^^^^^^^ reference _root_/
//                                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#controller.
//                                                                       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClass.

            @Override
            public int getMovementFlagsForModel(U model, int adapterPosition) {
              return movementFlags;
            }

            @Override
            protected boolean isTouchableModel(EpoxyModel<?> model) {
              boolean isTargetType = targetModelClasses.size() == 1
                  ? super.isTouchableModel(model)
                  : targetModelClasses.contains(model.getClass());

              //noinspection unchecked
              return isTargetType && callbacks.isDragEnabledForModel((U) model);
            }

            @Override
            public void onDragStarted(U model, View itemView, int adapterPosition) {
              callbacks.onDragStarted(model, itemView, adapterPosition);
            }

            @Override
            public void onDragReleased(U model, View itemView) {
              callbacks.onDragReleased(model, itemView);
            }

            @Override
            public void onModelMoved(int fromPosition, int toPosition, U modelBeingMoved,
                View itemView) {
              callbacks.onModelMoved(fromPosition, toPosition, modelBeingMoved, itemView);
            }

            @Override
            public void clearView(U model, View itemView) {
              callbacks.clearView(model, itemView);
            }
          });

      itemTouchHelper.attachToRecyclerView(recyclerView);
//    ^^^^^^^^^^^^^^^ reference local18
//                    ^^^^^^^^^^^^^^^^^^^^ reference attachToRecyclerView#
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#recyclerView.

      return itemTouchHelper;
//           ^^^^^^^^^^^^^^^ reference local18
    }
  }

  public abstract static class DragCallbacks<T extends EpoxyModel>
//                       ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#`<init>`().
//                       ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#
//                                                     ^^^^^^^^^^ reference _root_/
      implements EpoxyDragCallback<T> {
//               ^^^^^^^^^^^^^^^^^ reference _root_/
//                                 ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onDragStarted(T model, View itemView, int adapterPosition) {
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragStarted().
//                            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                              ^^^^^ definition local19
//                                     ^^^^ reference _root_/
//                                          ^^^^^^^^ definition local20
//                                                        ^^^^^^^^^^^^^^^ definition local21

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onDragReleased(T model, View itemView) {
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragReleased().
//                             ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                               ^^^^^ definition local22
//                                      ^^^^ reference _root_/
//                                           ^^^^^^^^ definition local23

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public abstract void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved,
//                       ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onModelMoved().
//                                        ^^^^^^^^^^^^ definition local24
//                                                          ^^^^^^^^^^ definition local25
//                                                                      ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                                                        ^^^^^^^^^^^^^^^ definition local26
        View itemView);
//      ^^^^ reference _root_/
//           ^^^^^^^^ definition local27

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void clearView(T model, View itemView) {
//              ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#clearView().
//                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                          ^^^^^ definition local28
//                                 ^^^^ reference _root_/
//                                      ^^^^^^^^ definition local29

    }

    /**
     * Whether the given model should be draggable.
     * <p>
     * True by default. You may override this to toggle draggability for a model.
     */
    public boolean isDragEnabledForModel(T model) {
//                 ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#isDragEnabledForModel().
//                                       ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                         ^^^^^ definition local30
      return true;
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public final int getMovementFlagsForModel(T model, int adapterPosition) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#getMovementFlagsForModel().
//                                            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                              ^^^^^ definition local31
//                                                         ^^^^^^^^^^^^^^^ definition local32
      // No-Op this is not used
      return 0;
    }
  }

  /**
   * The entry point for setting up swipe support for a RecyclerView. The RecyclerView must be set
   * with an Epoxy adapter or controller.
   */
  public static SwipeBuilder initSwiping(RecyclerView recyclerView) {
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#
//                           ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#initSwiping().
//                                       ^^^^^^^^^^^^ reference _root_/
//                                                    ^^^^^^^^^^^^ definition local33
    return new SwipeBuilder(recyclerView);
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#`<init>`().
//             ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#
//                          ^^^^^^^^^^^^ reference local33
  }

  public static class SwipeBuilder {
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#

    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#recyclerView.

    private SwipeBuilder(RecyclerView recyclerView) {
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#`<init>`().
//                       ^^^^^^^^^^^^ reference _root_/
//                                    ^^^^^^^^^^^^ definition local34
      this.recyclerView = recyclerView;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#this.
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#recyclerView.
//                        ^^^^^^^^^^^^ reference local34
    }

    /** Enable swiping right. */
    public SwipeBuilder2 right() {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#right().
      return withDirections(ItemTouchHelper.RIGHT);
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^^^^ reference RIGHT#
    }

    /** Enable swiping left. */
    public SwipeBuilder2 left() {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#left().
      return withDirections(ItemTouchHelper.LEFT);
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^^^ reference LEFT#
    }

    /** Enable swiping horizontally, left and right. */
    public SwipeBuilder2 leftAndRight() {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#leftAndRight().
      return withDirections(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^^^ reference LEFT#
//                                                 ^^^^^^^^^^^^^^^ reference _root_/
//                                                                 ^^^^^ reference RIGHT#
    }

    /**
     * Set custom movement flags to dictate which swipe directions should be allowed.
     * <p>
     * Can be any of {@link ItemTouchHelper#LEFT}, {@link ItemTouchHelper#RIGHT}, {@link
     * ItemTouchHelper#UP}, {@link ItemTouchHelper#DOWN}, {@link ItemTouchHelper#START}, {@link
     * ItemTouchHelper#END}
     * <p>
     * Flags can be OR'd together to allow multiple directions.
     */
    public SwipeBuilder2 withDirections(int directionFlags) {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                                          ^^^^^^^^^^^^^^ definition local35
      return new SwipeBuilder2(recyclerView, makeMovementFlags(0, directionFlags));
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#`<init>`().
//               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                             ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#recyclerView.
//                                           ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#makeMovementFlags#
//                                                                ^^^^^^^^^^^^^^ reference local35
    }
  }

  public static class SwipeBuilder2 {
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#

    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.

    private SwipeBuilder2(RecyclerView recyclerView,
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#`<init>`().
//                        ^^^^^^^^^^^^ reference _root_/
//                                     ^^^^^^^^^^^^ definition local36
        int movementFlags) {
//          ^^^^^^^^^^^^^ definition local37
      this.recyclerView = recyclerView;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#this.
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                        ^^^^^^^^^^^^ reference local36
      this.movementFlags = movementFlags;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#this.
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                         ^^^^^^^^^^^^^ reference local37
    }

    /**
     * Set the type of Epoxy model that is swipable. Use this if you only have one
     * swipable type.
     */
    public <U extends EpoxyModel> SwipeBuilder3<U> withTarget(Class<U> targetModelClass) {
//                    ^^^^^^^^^^ reference _root_/
//                                ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                                              ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().[U]
//                                                 ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().
//                                                            ^^^^^ reference java/lang/Class#
//                                                                  ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().[U]
//                                                                     ^^^^^^^^^^^^^^^^ definition local38
      List<Class<? extends EpoxyModel>> targetClasses = new ArrayList<>(1);
//    ^^^^ reference java/util/List#
//         ^^^^^ reference java/lang/Class#
//                         ^^^^^^^^^^ reference _root_/
//                                      ^^^^^^^^^^^^^ definition local39
//                                                      ^^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`().
//                                                          ^^^^^^^^^ reference java/util/ArrayList#
      targetClasses.add(targetModelClass);
//    ^^^^^^^^^^^^^ reference local39
//                  ^^^ reference java/util/List#add().
//                      ^^^^^^^^^^^^^^^^ reference local38

      return new SwipeBuilder3<>(recyclerView, movementFlags, targetModelClass,
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#`<init>`(). 1:24
//               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                                             ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                                                            ^^^^^^^^^^^^^^^^ reference local38
          targetClasses);
//        ^^^^^^^^^^^^^ reference local39
    }

    /**
     * Specify which Epoxy model types are swipable. Use this if you have more than one type that
     * is swipable.
     * <p>
     * If you only have one swipable type you should use {@link #withTarget(Class)}
     */
    public SwipeBuilder3<EpoxyModel> withTargets(
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                       ^^^^^^^^^^ reference _root_/
//                                   ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTargets().
        Class<? extends EpoxyModel>... targetModelClasses) {
//      ^^^^^ reference java/lang/Class#
//                      ^^^^^^^^^^ reference _root_/
//                                     ^^^^^^^^^^^^^^^^^^ definition local40
      return new SwipeBuilder3<>(recyclerView, movementFlags, EpoxyModel.class,
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#`<init>`(). 1:44
//               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                                             ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                                                            ^^^^^^^^^^ reference _root_/
//                                                                       ^^^^^ reference class#
          Arrays.asList(targetModelClasses));
//        ^^^^^^ reference java/util/Arrays#
//               ^^^^^^ reference java/util/Arrays#asList().
//                      ^^^^^^^^^^^^^^^^^^ reference local40
    }

    /**
     * Use this if all models in the controller should be swipable, and if there are multiple types
     * of models in the controller.
     * <p>
     * If you only have one model type you should use {@link #withTarget(Class)}
     */
    public SwipeBuilder3<EpoxyModel> forAllModels() {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                       ^^^^^^^^^^ reference _root_/
//                                   ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#forAllModels().
      return withTarget(EpoxyModel.class);
//           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().
//                      ^^^^^^^^^^ reference _root_/
//                                 ^^^^^ reference class#
    }
  }

  public static class SwipeBuilder3<U extends EpoxyModel> {
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                                            ^^^^^^^^^^ reference _root_/

    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#recyclerView.
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#movementFlags.
    private final Class<U> targetModelClass;
//                ^^^^^ reference java/lang/Class#
//                      ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                         ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClass.
    private final List<Class<? extends EpoxyModel>> targetModelClasses;
//                ^^^^ reference java/util/List#
//                     ^^^^^ reference java/lang/Class#
//                                     ^^^^^^^^^^ reference _root_/
//                                                  ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.

    private SwipeBuilder3(
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#`<init>`().
        RecyclerView recyclerView, int movementFlags,
//      ^^^^^^^^^^^^ reference _root_/
//                   ^^^^^^^^^^^^ definition local41
//                                     ^^^^^^^^^^^^^ definition local42
        Class<U> targetModelClass, List<Class<? extends EpoxyModel>> targetModelClasses) {
//      ^^^^^ reference java/lang/Class#
//            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//               ^^^^^^^^^^^^^^^^ definition local43
//                                 ^^^^ reference java/util/List#
//                                      ^^^^^ reference java/lang/Class#
//                                                      ^^^^^^^^^^ reference _root_/
//                                                                   ^^^^^^^^^^^^^^^^^^ definition local44

      this.recyclerView = recyclerView;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#this.
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#recyclerView.
//                        ^^^^^^^^^^^^ reference local41
      this.movementFlags = movementFlags;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#this.
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#movementFlags.
//                         ^^^^^^^^^^^^^ reference local42
      this.targetModelClass = targetModelClass;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#this.
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClass.
//                            ^^^^^^^^^^^^^^^^ reference local43
      this.targetModelClasses = targetModelClasses;
//    ^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#this.
//         ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.
//                              ^^^^^^^^^^^^^^^^^^ reference local44
    }

    /**
     * Set callbacks to handle swipe actions and lifecycle events.
     * <p>
     * You MUST implement {@link SwipeCallbacks#onSwipeCompleted(EpoxyModel, View, int, int)} to
     * remove the swiped item from your data and request a model build.
     * <p>
     * You can optionally implement the other callbacks to modify the view as it is being swiped.
     *
     * @return An {@link ItemTouchHelper} instance that has been initialized and attached to a
     * recyclerview. The touch helper has already been fully set up and can be ignored, but you may
     * want to hold a reference to it if you need to later detach the recyclerview to disable touch
     * events via setting null on {@link ItemTouchHelper#attachToRecyclerView(RecyclerView)}
     */
    public ItemTouchHelper andCallbacks(final SwipeCallbacks<U> callbacks) {
//         ^^^^^^^^^^^^^^^ reference _root_/
//                         ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#andCallbacks().
//                                            ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#
//                                                           ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                              ^^^^^^^^^ definition local45
      ItemTouchHelper itemTouchHelper =
//    ^^^^^^^^^^^^^^^ reference _root_/
//                    ^^^^^^^^^^^^^^^ definition local46
          new ItemTouchHelper(new EpoxyModelTouchCallback<U>(null, targetModelClass) {
//            ^^^^^^^^^^^^^^^ reference _root_/
//                                ^^^^^^^^^^^^^^^^^^^^^^^ reference _root_/
//                                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClass.

            @Override
            public int getMovementFlagsForModel(U model, int adapterPosition) {
              return movementFlags;
            }

            @Override
            protected boolean isTouchableModel(EpoxyModel<?> model) {
              boolean isTargetType = targetModelClasses.size() == 1
                  ? super.isTouchableModel(model)
                  : targetModelClasses.contains(model.getClass());

              //noinspection unchecked
              return isTargetType && callbacks.isSwipeEnabledForModel((U) model);
            }

            @Override
            public void onSwipeStarted(U model, View itemView, int adapterPosition) {
              callbacks.onSwipeStarted(model, itemView, adapterPosition);
            }

            @Override
            public void onSwipeProgressChanged(U model, View itemView, float swipeProgress,
                Canvas canvas) {
              callbacks.onSwipeProgressChanged(model, itemView, swipeProgress, canvas);
            }

            @Override
            public void onSwipeCompleted(U model, View itemView, int position, int direction) {
              callbacks.onSwipeCompleted(model, itemView, position, direction);
            }

            @Override
            public void onSwipeReleased(U model, View itemView) {
              callbacks.onSwipeReleased(model, itemView);
            }

            @Override
            public void clearView(U model, View itemView) {
              callbacks.clearView(model, itemView);
            }
          });

      itemTouchHelper.attachToRecyclerView(recyclerView);
//    ^^^^^^^^^^^^^^^ reference local46
//                    ^^^^^^^^^^^^^^^^^^^^ reference attachToRecyclerView#
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#recyclerView.

      return itemTouchHelper;
//           ^^^^^^^^^^^^^^^ reference local46
    }
  }

  public abstract static class SwipeCallbacks<T extends EpoxyModel>
//                       ^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#`<init>`().
//                       ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#
//                                                      ^^^^^^^^^^ reference _root_/
      implements EpoxySwipeCallback<T> {
//               ^^^^^^^^^^^^^^^^^^ reference _root_/
//                                  ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onSwipeStarted(T model, View itemView, int adapterPosition) {
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeStarted().
//                             ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                               ^^^^^ definition local47
//                                      ^^^^ reference _root_/
//                                           ^^^^^^^^ definition local48
//                                                         ^^^^^^^^^^^^^^^ definition local49

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onSwipeProgressChanged(T model, View itemView, float swipeProgress,
//              ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeProgressChanged().
//                                     ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                       ^^^^^ definition local50
//                                              ^^^^ reference _root_/
//                                                   ^^^^^^^^ definition local51
//                                                                   ^^^^^^^^^^^^^ definition local52
        Canvas canvas) {
//      ^^^^^^ reference _root_/
//             ^^^^^^ definition local53

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public abstract void onSwipeCompleted(T model, View itemView, int position, int direction);
//                       ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeCompleted().
//                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                          ^^^^^ definition local54
//                                                 ^^^^ reference _root_/
//                                                      ^^^^^^^^ definition local55
//                                                                    ^^^^^^^^ definition local56
//                                                                                  ^^^^^^^^^ definition local57

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onSwipeReleased(T model, View itemView) {
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeReleased().
//                              ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                ^^^^^ definition local58
//                                       ^^^^ reference _root_/
//                                            ^^^^^^^^ definition local59

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void clearView(T model, View itemView) {
//              ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#clearView().
//                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                          ^^^^^ definition local60
//                                 ^^^^ reference _root_/
//                                      ^^^^^^^^ definition local61

    }

    /**
     * Whether the given model should be swipable.
     * <p>
     * True by default. You may override this to toggle swipabaility for a model.
     */
    public boolean isSwipeEnabledForModel(T model) {
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#isSwipeEnabledForModel().
//                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                          ^^^^^ definition local62
      return true;
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public final int getMovementFlagsForModel(T model, int adapterPosition) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#getMovementFlagsForModel().
//                                            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                              ^^^^^ definition local63
//                                                         ^^^^^^^^^^^^^^^ definition local64
      // Not used
      return 0;
    }
  }
}
