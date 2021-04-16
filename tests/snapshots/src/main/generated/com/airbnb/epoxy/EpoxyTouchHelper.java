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
//                    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper# public abstract class EpoxyTouchHelper
//                    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#`<init>`(). public EpoxyTouchHelper()

  /**
   * The entry point for setting up drag support.
   *
   * @param controller The EpoxyController with the models that will be dragged. The controller will
   *                   be updated for you when a model is dragged and moved by a user's touch
   *                   interaction.
   */
  public static DragBuilder initDragging(EpoxyController controller) {
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#
//                          ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#initDragging(). public static DragBuilder initDragging(EpoxyController controller)
//                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                                       ^^^^^^^^^^ definition local0 EpoxyController controller
    return new DragBuilder(controller);
//             ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#`<init>`().
//                         ^^^^^^^^^^ reference local0
  }

  public static class DragBuilder {
//                    ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder# public static class DragBuilder

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#controller. private final EpoxyController controller

    private DragBuilder(EpoxyController controller) {
//          ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#`<init>`(). private DragBuilder(EpoxyController controller)
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                      ^^^^^^^^^^ definition local1 EpoxyController controller
      this.controller = controller;
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
//                      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#withRecyclerView(). public DragBuilder2 withRecyclerView(unresolved_type recyclerView)
//                                       ^^^^^^^^^^^^ reference _root_/
//                                                    ^^^^^^^^^^^^ definition local2 unresolved_type recyclerView
      return new DragBuilder2(controller, recyclerView);
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#`<init>`().
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#controller.
//                                        ^^^^^^^^^^^^ reference local2
    }
  }

  public static class DragBuilder2 {
//                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2# public static class DragBuilder2

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#controller. private final EpoxyController controller
    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#recyclerView. private final unresolved_type recyclerView

    private DragBuilder2(EpoxyController controller, RecyclerView recyclerView) {
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#`<init>`(). private DragBuilder2(EpoxyController controller, unresolved_type recyclerView)
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                       ^^^^^^^^^^ definition local3 EpoxyController controller
//                                                   ^^^^^^^^^^^^ reference _root_/
//                                                                ^^^^^^^^^^^^ definition local4 unresolved_type recyclerView
      this.controller = controller;
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#controller.
//                      ^^^^^^^^^^ reference local3
      this.recyclerView = recyclerView;
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#recyclerView.
//                        ^^^^^^^^^^^^ reference local4
    }

    /** Enable dragging vertically, up and down. */
    public DragBuilder3 forVerticalList() {
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#forVerticalList(). public DragBuilder3 forVerticalList()
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
//                      ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#forHorizontalList(). public DragBuilder3 forHorizontalList()
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
//                      ^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#forGrid(). public DragBuilder3 forGrid()
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
//                      ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections(). public DragBuilder3 withDirections(int directionFlags)
//                                         ^^^^^^^^^^^^^^ definition local5 int directionFlags
      return new DragBuilder3(controller, recyclerView, makeMovementFlags(directionFlags, 0));
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#`<init>`().
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#controller.
//                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#recyclerView.
//                                                      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#makeMovementFlags#
//                                                                        ^^^^^^^^^^^^^^ reference local5
    }
  }

  public static class DragBuilder3 {
//                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3# public static class DragBuilder3

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller. private final EpoxyController controller
    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView. private final unresolved_type recyclerView
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags. private final int movementFlags

    private DragBuilder3(EpoxyController controller, RecyclerView recyclerView, int movementFlags) {
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#`<init>`(). private DragBuilder3(EpoxyController controller, unresolved_type recyclerView, int movementFlags)
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                       ^^^^^^^^^^ definition local6 EpoxyController controller
//                                                   ^^^^^^^^^^^^ reference _root_/
//                                                                ^^^^^^^^^^^^ definition local7 unresolved_type recyclerView
//                                                                                  ^^^^^^^^^^^^^ definition local8 int movementFlags
      this.controller = controller;
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
//                      ^^^^^^^^^^ reference local6
      this.recyclerView = recyclerView;
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
//                        ^^^^^^^^^^^^ reference local7
      this.movementFlags = movementFlags;
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.
//                         ^^^^^^^^^^^^^ reference local8
    }

    /**
     * Set the type of Epoxy model that is draggable. This approach works well if you only have one
     * draggable type.
     */
    public <U extends EpoxyModel> DragBuilder4<U> withTarget(Class<U> targetModelClass) {
//          ^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().[U] U extends EpoxyModel
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                                             ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().[U]
//                                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget(). public <U extends EpoxyModel> DragBuilder4<U> withTarget(Class<U> targetModelClass)
//                                                           ^^^^^ reference java/lang/Class#
//                                                                 ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().[U]
//                                                                    ^^^^^^^^^^^^^^^^ definition local9 Class<U> targetModelClass
      List<Class<? extends EpoxyModel>> targetClasses = new ArrayList<>(1);
//    ^^^^ reference java/util/List#
//         ^^^^^ reference java/lang/Class#
//                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^^^^^^^ definition local10 List<Class<? extends EpoxyModel>> targetClasses
//                                                          ^^^^^^^^^ reference java/util/ArrayList#`<init>`().
      targetClasses.add(targetModelClass);
//    ^^^^^^^^^^^^^ reference local10
//                  ^^^ reference java/util/List#add().
//                      ^^^^^^^^^^^^^^^^ reference local9

      return new DragBuilder4<>(controller, recyclerView, movementFlags, targetModelClass,
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#`<init>`().
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
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTargets(). public DragBuilder4<EpoxyModel> withTargets(Class<? extends EpoxyModel>[] targetModelClasses)
//                                              ^^^^^ reference java/lang/Class#
//                                                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                             ^^^^^^^^^^^^^^^^^^ definition local11 Class<? extends EpoxyModel>[] targetModelClasses
      return new DragBuilder4<>(controller, recyclerView, movementFlags, EpoxyModel.class,
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#`<init>`().
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
//                                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
//                                                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.
//                                                                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                  ^^^^^ reference com/airbnb/epoxy/EpoxyModel#class.
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
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#forAllModels(). public DragBuilder4<EpoxyModel> forAllModels()
      return withTarget(EpoxyModel.class);
//           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                 ^^^^^ reference com/airbnb/epoxy/EpoxyModel#class.
    }
  }

  public static class DragBuilder4<U extends EpoxyModel> {
//                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4# public static class DragBuilder4<U extends EpoxyModel>
//                                 ^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U] U extends EpoxyModel
//                                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#controller. private final EpoxyController controller
    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#recyclerView. private final unresolved_type recyclerView
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#movementFlags. private final int movementFlags
    private final Class<U> targetModelClass;
//                ^^^^^ reference java/lang/Class#
//                      ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                         ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClass. private final Class<U> targetModelClass
    private final List<Class<? extends EpoxyModel>> targetModelClasses;
//                ^^^^ reference java/util/List#
//                     ^^^^^ reference java/lang/Class#
//                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses. private final List<Class<? extends EpoxyModel>> targetModelClasses

    private DragBuilder4(EpoxyController controller,
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#`<init>`(). private DragBuilder4(EpoxyController controller, unresolved_type recyclerView, int movementFlags, Class<U> targetModelClass, List<Class<? extends EpoxyModel>> targetModelClasses)
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                       ^^^^^^^^^^ definition local12 EpoxyController controller
        RecyclerView recyclerView, int movementFlags,
//      ^^^^^^^^^^^^ reference _root_/
//                   ^^^^^^^^^^^^ definition local13 unresolved_type recyclerView
//                                     ^^^^^^^^^^^^^ definition local14 int movementFlags
        Class<U> targetModelClass, List<Class<? extends EpoxyModel>> targetModelClasses) {
//      ^^^^^ reference java/lang/Class#
//            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//               ^^^^^^^^^^^^^^^^ definition local15 Class<U> targetModelClass
//                                 ^^^^ reference java/util/List#
//                                      ^^^^^ reference java/lang/Class#
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                   ^^^^^^^^^^^^^^^^^^ definition local16 List<Class<? extends EpoxyModel>> targetModelClasses

      this.controller = controller;
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#controller.
//                      ^^^^^^^^^^ reference local12
      this.recyclerView = recyclerView;
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#recyclerView.
//                        ^^^^^^^^^^^^ reference local13
      this.movementFlags = movementFlags;
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#movementFlags.
//                         ^^^^^^^^^^^^^ reference local14
      this.targetModelClass = targetModelClass;
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClass.
//                            ^^^^^^^^^^^^^^^^ reference local15
      this.targetModelClasses = targetModelClasses;
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
//                         ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#andCallbacks(). public andCallbacks(DragCallbacks<U> callbacks)
//                                            ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#
//                                                          ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                             ^^^^^^^^^ definition local17 final DragCallbacks<U> callbacks
      ItemTouchHelper itemTouchHelper =
//    ^^^^^^^^^^^^^^^ reference _root_/
//                    ^^^^^^^^^^^^^^^ definition local18 unresolved_type itemTouchHelper
          new ItemTouchHelper(new EpoxyModelTouchCallback<U>(controller, targetModelClass) {
//            ^^^^^^^^^^^^^^^ reference `<init>`#
//                                ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#
//                                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#controller.
//                                                                       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClass.

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public int getMovementFlagsForModel(U model, int adapterPosition) {
//                     ^^^^^^^^^^^^^^^^^^^^^^^^ definition local21 @Override public int getMovementFlagsForModel(U model, int adapterPosition)
//                                              ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                ^^^^^ definition local27 U model
//                                                           ^^^^^^^^^^^^^^^ definition local28 int adapterPosition
              return movementFlags;
//                   ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#movementFlags.
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            protected boolean isTouchableModel(EpoxyModel<?> model) {
//                            ^^^^^^^^^^^^^^^^ definition local22 @Override protected boolean isTouchableModel(EpoxyModel<?> model)
//                                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^ definition local29 EpoxyModel<?> model
              boolean isTargetType = targetModelClasses.size() == 1
//                    ^^^^^^^^^^^^ definition local30 boolean isTargetType
//                                   ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses.
//                                                      ^^^^ reference java/util/List#size().
                  ? super.isTouchableModel(model)
//                  ^^^^^ reference local31
//                        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                                         ^^^^^ reference local29
                  : targetModelClasses.contains(model.getClass());
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses.
//                                     ^^^^^^^^ reference java/util/List#contains().
//                                              ^^^^^ reference local29
//                                                    ^^^^^^^^ reference java/lang/Object#getClass().

              //noinspection unchecked
              return isTargetType && callbacks.isDragEnabledForModel((U) model);
//                   ^^^^^^^^^^^^ reference local30
//                                   ^^^^^^^^^ reference local17
//                                             ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#isDragEnabledForModel().
//                                                                    ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                                       ^^^^^ reference local29
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onDragStarted(U model, View itemView, int adapterPosition) {
//                      ^^^^^^^^^^^^^ definition local23 @Override public void onDragStarted(U model, unresolved_type itemView, int adapterPosition)
//                                    ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                      ^^^^^ definition local32 U model
//                                             ^^^^ reference _root_/
//                                                  ^^^^^^^^ definition local33 unresolved_type itemView
//                                                                ^^^^^^^^^^^^^^^ definition local34 int adapterPosition
              callbacks.onDragStarted(model, itemView, adapterPosition);
//            ^^^^^^^^^ reference local17
//                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragStarted().
//                                    ^^^^^ reference local32
//                                           ^^^^^^^^ reference local33
//                                                     ^^^^^^^^^^^^^^^ reference local34
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onDragReleased(U model, View itemView) {
//                      ^^^^^^^^^^^^^^ definition local24 @Override public void onDragReleased(U model, unresolved_type itemView)
//                                     ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                       ^^^^^ definition local35 U model
//                                              ^^^^ reference _root_/
//                                                   ^^^^^^^^ definition local36 unresolved_type itemView
              callbacks.onDragReleased(model, itemView);
//            ^^^^^^^^^ reference local17
//                      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragReleased().
//                                     ^^^^^ reference local35
//                                            ^^^^^^^^ reference local36
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onModelMoved(int fromPosition, int toPosition, U modelBeingMoved,
//                      ^^^^^^^^^^^^ definition local25 @Override public void onModelMoved(int fromPosition, int toPosition, U modelBeingMoved, unresolved_type itemView)
//                                       ^^^^^^^^^^^^ definition local37 int fromPosition
//                                                         ^^^^^^^^^^ definition local38 int toPosition
//                                                                     ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                                       ^^^^^^^^^^^^^^^ definition local39 U modelBeingMoved
                View itemView) {
//              ^^^^ reference _root_/
//                   ^^^^^^^^ definition local40 unresolved_type itemView
              callbacks.onModelMoved(fromPosition, toPosition, modelBeingMoved, itemView);
//            ^^^^^^^^^ reference local17
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onModelMoved().
//                                   ^^^^^^^^^^^^ reference local37
//                                                 ^^^^^^^^^^ reference local38
//                                                             ^^^^^^^^^^^^^^^ reference local39
//                                                                              ^^^^^^^^ reference local40
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void clearView(U model, View itemView) {
//                      ^^^^^^^^^ definition local26 @Override public void clearView(U model, unresolved_type itemView)
//                                ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                  ^^^^^ definition local41 U model
//                                         ^^^^ reference _root_/
//                                              ^^^^^^^^ definition local42 unresolved_type itemView
              callbacks.clearView(model, itemView);
//            ^^^^^^^^^ reference local17
//                      ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#clearView().
//                                ^^^^^ reference local41
//                                       ^^^^^^^^ reference local42
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
//                             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks# public abstract static class DragCallbacks<T extends EpoxyModel> implements EpoxyDragCallback<T>
//                             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#`<init>`(). public DragCallbacks()
//                                           ^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T] T extends EpoxyModel
//                                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
      implements EpoxyDragCallback<T> {
//               ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyDragCallback#
//                                 ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onDragStarted(T model, View itemView, int adapterPosition) {
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragStarted(). @Override public void onDragStarted(T model, unresolved_type itemView, int adapterPosition)
//                            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                              ^^^^^ definition local43 T model
//                                     ^^^^ reference _root_/
//                                          ^^^^^^^^ definition local44 unresolved_type itemView
//                                                        ^^^^^^^^^^^^^^^ definition local45 int adapterPosition

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onDragReleased(T model, View itemView) {
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragReleased(). @Override public void onDragReleased(T model, unresolved_type itemView)
//                             ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                               ^^^^^ definition local46 T model
//                                      ^^^^ reference _root_/
//                                           ^^^^^^^^ definition local47 unresolved_type itemView

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public abstract void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved,
//                       ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onModelMoved(). @Override public abstract void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved, unresolved_type itemView)
//                                        ^^^^^^^^^^^^ definition local48 int fromPosition
//                                                          ^^^^^^^^^^ definition local49 int toPosition
//                                                                      ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                                                        ^^^^^^^^^^^^^^^ definition local50 T modelBeingMoved
        View itemView);
//      ^^^^ reference _root_/
//           ^^^^^^^^ definition local51 unresolved_type itemView

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void clearView(T model, View itemView) {
//              ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#clearView(). @Override public void clearView(T model, unresolved_type itemView)
//                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                          ^^^^^ definition local52 T model
//                                 ^^^^ reference _root_/
//                                      ^^^^^^^^ definition local53 unresolved_type itemView

    }

    /**
     * Whether the given model should be draggable.
     * <p>
     * True by default. You may override this to toggle draggability for a model.
     */
    public boolean isDragEnabledForModel(T model) {
//                 ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#isDragEnabledForModel(). public boolean isDragEnabledForModel(T model)
//                                       ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                         ^^^^^ definition local54 T model
      return true;
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public final int getMovementFlagsForModel(T model, int adapterPosition) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#getMovementFlagsForModel(). @Override public final int getMovementFlagsForModel(T model, int adapterPosition)
//                                            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                              ^^^^^ definition local55 T model
//                                                         ^^^^^^^^^^^^^^^ definition local56 int adapterPosition
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
//                           ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#initSwiping(). public static SwipeBuilder initSwiping(unresolved_type recyclerView)
//                                       ^^^^^^^^^^^^ reference _root_/
//                                                    ^^^^^^^^^^^^ definition local57 unresolved_type recyclerView
    return new SwipeBuilder(recyclerView);
//             ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#`<init>`().
//                          ^^^^^^^^^^^^ reference local57
  }

  public static class SwipeBuilder {
//                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder# public static class SwipeBuilder

    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#recyclerView. private final unresolved_type recyclerView

    private SwipeBuilder(RecyclerView recyclerView) {
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#`<init>`(). private SwipeBuilder(unresolved_type recyclerView)
//                       ^^^^^^^^^^^^ reference _root_/
//                                    ^^^^^^^^^^^^ definition local58 unresolved_type recyclerView
      this.recyclerView = recyclerView;
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#recyclerView.
//                        ^^^^^^^^^^^^ reference local58
    }

    /** Enable swiping right. */
    public SwipeBuilder2 right() {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#right(). public SwipeBuilder2 right()
      return withDirections(ItemTouchHelper.RIGHT);
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^^^^ reference RIGHT#
    }

    /** Enable swiping left. */
    public SwipeBuilder2 left() {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#left(). public SwipeBuilder2 left()
      return withDirections(ItemTouchHelper.LEFT);
//           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                          ^^^^^^^^^^^^^^^ reference _root_/
//                                          ^^^^ reference LEFT#
    }

    /** Enable swiping horizontally, left and right. */
    public SwipeBuilder2 leftAndRight() {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#leftAndRight(). public SwipeBuilder2 leftAndRight()
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
//                       ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections(). public SwipeBuilder2 withDirections(int directionFlags)
//                                          ^^^^^^^^^^^^^^ definition local59 int directionFlags
      return new SwipeBuilder2(recyclerView, makeMovementFlags(0, directionFlags));
//               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#`<init>`().
//                             ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#recyclerView.
//                                           ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#makeMovementFlags#
//                                                                ^^^^^^^^^^^^^^ reference local59
    }
  }

  public static class SwipeBuilder2 {
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2# public static class SwipeBuilder2

    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView. private final unresolved_type recyclerView
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags. private final int movementFlags

    private SwipeBuilder2(RecyclerView recyclerView,
//          ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#`<init>`(). private SwipeBuilder2(unresolved_type recyclerView, int movementFlags)
//                        ^^^^^^^^^^^^ reference _root_/
//                                     ^^^^^^^^^^^^ definition local60 unresolved_type recyclerView
        int movementFlags) {
//          ^^^^^^^^^^^^^ definition local61 int movementFlags
      this.recyclerView = recyclerView;
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                        ^^^^^^^^^^^^ reference local60
      this.movementFlags = movementFlags;
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                         ^^^^^^^^^^^^^ reference local61
    }

    /**
     * Set the type of Epoxy model that is swipable. Use this if you only have one
     * swipable type.
     */
    public <U extends EpoxyModel> SwipeBuilder3<U> withTarget(Class<U> targetModelClass) {
//          ^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().[U] U extends EpoxyModel
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                                              ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().[U]
//                                                 ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget(). public <U extends EpoxyModel> SwipeBuilder3<U> withTarget(Class<U> targetModelClass)
//                                                            ^^^^^ reference java/lang/Class#
//                                                                  ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().[U]
//                                                                     ^^^^^^^^^^^^^^^^ definition local62 Class<U> targetModelClass
      List<Class<? extends EpoxyModel>> targetClasses = new ArrayList<>(1);
//    ^^^^ reference java/util/List#
//         ^^^^^ reference java/lang/Class#
//                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^^^^^^^ definition local63 List<Class<? extends EpoxyModel>> targetClasses
//                                                          ^^^^^^^^^ reference java/util/ArrayList#`<init>`().
      targetClasses.add(targetModelClass);
//    ^^^^^^^^^^^^^ reference local63
//                  ^^^ reference java/util/List#add().
//                      ^^^^^^^^^^^^^^^^ reference local62

      return new SwipeBuilder3<>(recyclerView, movementFlags, targetModelClass,
//               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#`<init>`().
//                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                                             ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                                                            ^^^^^^^^^^^^^^^^ reference local62
          targetClasses);
//        ^^^^^^^^^^^^^ reference local63
    }

    /**
     * Specify which Epoxy model types are swipable. Use this if you have more than one type that
     * is swipable.
     * <p>
     * If you only have one swipable type you should use {@link #withTarget(Class)}
     */
    public SwipeBuilder3<EpoxyModel> withTargets(
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTargets(). public SwipeBuilder3<EpoxyModel> withTargets(Class<? extends EpoxyModel>[] targetModelClasses)
        Class<? extends EpoxyModel>... targetModelClasses) {
//      ^^^^^ reference java/lang/Class#
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                     ^^^^^^^^^^^^^^^^^^ definition local64 Class<? extends EpoxyModel>[] targetModelClasses
      return new SwipeBuilder3<>(recyclerView, movementFlags, EpoxyModel.class,
//               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#`<init>`().
//                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                                             ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                                                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                       ^^^^^ reference com/airbnb/epoxy/EpoxyModel#class.
          Arrays.asList(targetModelClasses));
//        ^^^^^^ reference java/util/Arrays#
//               ^^^^^^ reference java/util/Arrays#asList().
//                      ^^^^^^^^^^^^^^^^^^ reference local64
    }

    /**
     * Use this if all models in the controller should be swipable, and if there are multiple types
     * of models in the controller.
     * <p>
     * If you only have one model type you should use {@link #withTarget(Class)}
     */
    public SwipeBuilder3<EpoxyModel> forAllModels() {
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#forAllModels(). public SwipeBuilder3<EpoxyModel> forAllModels()
      return withTarget(EpoxyModel.class);
//           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                 ^^^^^ reference com/airbnb/epoxy/EpoxyModel#class.
    }
  }

  public static class SwipeBuilder3<U extends EpoxyModel> {
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3# public static class SwipeBuilder3<U extends EpoxyModel>
//                                  ^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U] U extends EpoxyModel
//                                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#

    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#recyclerView. private final unresolved_type recyclerView
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#movementFlags. private final int movementFlags
    private final Class<U> targetModelClass;
//                ^^^^^ reference java/lang/Class#
//                      ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                         ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClass. private final Class<U> targetModelClass
    private final List<Class<? extends EpoxyModel>> targetModelClasses;
//                ^^^^ reference java/util/List#
//                     ^^^^^ reference java/lang/Class#
//                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses. private final List<Class<? extends EpoxyModel>> targetModelClasses

    private SwipeBuilder3(
//          ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#`<init>`(). private SwipeBuilder3(unresolved_type recyclerView, int movementFlags, Class<U> targetModelClass, List<Class<? extends EpoxyModel>> targetModelClasses)
        RecyclerView recyclerView, int movementFlags,
//      ^^^^^^^^^^^^ reference _root_/
//                   ^^^^^^^^^^^^ definition local65 unresolved_type recyclerView
//                                     ^^^^^^^^^^^^^ definition local66 int movementFlags
        Class<U> targetModelClass, List<Class<? extends EpoxyModel>> targetModelClasses) {
//      ^^^^^ reference java/lang/Class#
//            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//               ^^^^^^^^^^^^^^^^ definition local67 Class<U> targetModelClass
//                                 ^^^^ reference java/util/List#
//                                      ^^^^^ reference java/lang/Class#
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                   ^^^^^^^^^^^^^^^^^^ definition local68 List<Class<? extends EpoxyModel>> targetModelClasses

      this.recyclerView = recyclerView;
//         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#recyclerView.
//                        ^^^^^^^^^^^^ reference local65
      this.movementFlags = movementFlags;
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#movementFlags.
//                         ^^^^^^^^^^^^^ reference local66
      this.targetModelClass = targetModelClass;
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClass.
//                            ^^^^^^^^^^^^^^^^ reference local67
      this.targetModelClasses = targetModelClasses;
//         ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.
//                              ^^^^^^^^^^^^^^^^^^ reference local68
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
//                         ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#andCallbacks(). public andCallbacks(SwipeCallbacks<U> callbacks)
//                                            ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#
//                                                           ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                              ^^^^^^^^^ definition local69 final SwipeCallbacks<U> callbacks
      ItemTouchHelper itemTouchHelper =
//    ^^^^^^^^^^^^^^^ reference _root_/
//                    ^^^^^^^^^^^^^^^ definition local70 unresolved_type itemTouchHelper
          new ItemTouchHelper(new EpoxyModelTouchCallback<U>(null, targetModelClass) {
//            ^^^^^^^^^^^^^^^ reference `<init>`#
//                                ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#
//                                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClass.

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public int getMovementFlagsForModel(U model, int adapterPosition) {
//                     ^^^^^^^^^^^^^^^^^^^^^^^^ definition local73 @Override public int getMovementFlagsForModel(U model, int adapterPosition)
//                                              ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                ^^^^^ definition local80 U model
//                                                           ^^^^^^^^^^^^^^^ definition local81 int adapterPosition
              return movementFlags;
//                   ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#movementFlags.
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            protected boolean isTouchableModel(EpoxyModel<?> model) {
//                            ^^^^^^^^^^^^^^^^ definition local74 @Override protected boolean isTouchableModel(EpoxyModel<?> model)
//                                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^ definition local82 EpoxyModel<?> model
              boolean isTargetType = targetModelClasses.size() == 1
//                    ^^^^^^^^^^^^ definition local83 boolean isTargetType
//                                   ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.
//                                                      ^^^^ reference java/util/List#size().
                  ? super.isTouchableModel(model)
//                  ^^^^^ reference local84
//                        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                                         ^^^^^ reference local82
                  : targetModelClasses.contains(model.getClass());
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.
//                                     ^^^^^^^^ reference java/util/List#contains().
//                                              ^^^^^ reference local82
//                                                    ^^^^^^^^ reference java/lang/Object#getClass().

              //noinspection unchecked
              return isTargetType && callbacks.isSwipeEnabledForModel((U) model);
//                   ^^^^^^^^^^^^ reference local83
//                                   ^^^^^^^^^ reference local69
//                                             ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#isSwipeEnabledForModel().
//                                                                     ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                                        ^^^^^ reference local82
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onSwipeStarted(U model, View itemView, int adapterPosition) {
//                      ^^^^^^^^^^^^^^ definition local75 @Override public void onSwipeStarted(U model, unresolved_type itemView, int adapterPosition)
//                                     ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                       ^^^^^ definition local85 U model
//                                              ^^^^ reference _root_/
//                                                   ^^^^^^^^ definition local86 unresolved_type itemView
//                                                                 ^^^^^^^^^^^^^^^ definition local87 int adapterPosition
              callbacks.onSwipeStarted(model, itemView, adapterPosition);
//            ^^^^^^^^^ reference local69
//                      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeStarted().
//                                     ^^^^^ reference local85
//                                            ^^^^^^^^ reference local86
//                                                      ^^^^^^^^^^^^^^^ reference local87
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onSwipeProgressChanged(U model, View itemView, float swipeProgress,
//                      ^^^^^^^^^^^^^^^^^^^^^^ definition local76 @Override public void onSwipeProgressChanged(U model, unresolved_type itemView, float swipeProgress, unresolved_type canvas)
//                                             ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                               ^^^^^ definition local88 U model
//                                                      ^^^^ reference _root_/
//                                                           ^^^^^^^^ definition local89 unresolved_type itemView
//                                                                           ^^^^^^^^^^^^^ definition local90 float swipeProgress
                Canvas canvas) {
//              ^^^^^^ reference _root_/
//                     ^^^^^^ definition local91 unresolved_type canvas
              callbacks.onSwipeProgressChanged(model, itemView, swipeProgress, canvas);
//            ^^^^^^^^^ reference local69
//                      ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeProgressChanged().
//                                             ^^^^^ reference local88
//                                                    ^^^^^^^^ reference local89
//                                                              ^^^^^^^^^^^^^ reference local90
//                                                                             ^^^^^^ reference local91
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onSwipeCompleted(U model, View itemView, int position, int direction) {
//                      ^^^^^^^^^^^^^^^^ definition local77 @Override public void onSwipeCompleted(U model, unresolved_type itemView, int position, int direction)
//                                       ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                         ^^^^^ definition local92 U model
//                                                ^^^^ reference _root_/
//                                                     ^^^^^^^^ definition local93 unresolved_type itemView
//                                                                   ^^^^^^^^ definition local94 int position
//                                                                                 ^^^^^^^^^ definition local95 int direction
              callbacks.onSwipeCompleted(model, itemView, position, direction);
//            ^^^^^^^^^ reference local69
//                      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeCompleted().
//                                       ^^^^^ reference local92
//                                              ^^^^^^^^ reference local93
//                                                        ^^^^^^^^ reference local94
//                                                                  ^^^^^^^^^ reference local95
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void onSwipeReleased(U model, View itemView) {
//                      ^^^^^^^^^^^^^^^ definition local78 @Override public void onSwipeReleased(U model, unresolved_type itemView)
//                                      ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                        ^^^^^ definition local96 U model
//                                               ^^^^ reference _root_/
//                                                    ^^^^^^^^ definition local97 unresolved_type itemView
              callbacks.onSwipeReleased(model, itemView);
//            ^^^^^^^^^ reference local69
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeReleased().
//                                      ^^^^^ reference local96
//                                             ^^^^^^^^ reference local97
            }

            @Override
//           ^^^^^^^^ reference java/lang/Override#
            public void clearView(U model, View itemView) {
//                      ^^^^^^^^^ definition local79 @Override public void clearView(U model, unresolved_type itemView)
//                                ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                  ^^^^^ definition local98 U model
//                                         ^^^^ reference _root_/
//                                              ^^^^^^^^ definition local99 unresolved_type itemView
              callbacks.clearView(model, itemView);
//            ^^^^^^^^^ reference local69
//                      ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#clearView().
//                                ^^^^^ reference local98
//                                       ^^^^^^^^ reference local99
            }
          });

      itemTouchHelper.attachToRecyclerView(recyclerView);
//    ^^^^^^^^^^^^^^^ reference local70
//                    ^^^^^^^^^^^^^^^^^^^^ reference attachToRecyclerView#
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#recyclerView.

      return itemTouchHelper;
//           ^^^^^^^^^^^^^^^ reference local70
    }
  }

  public abstract static class SwipeCallbacks<T extends EpoxyModel>
//                             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks# public abstract static class SwipeCallbacks<T extends EpoxyModel> implements EpoxySwipeCallback<T>
//                             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#`<init>`(). public SwipeCallbacks()
//                                            ^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T] T extends EpoxyModel
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
      implements EpoxySwipeCallback<T> {
//               ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxySwipeCallback#
//                                  ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onSwipeStarted(T model, View itemView, int adapterPosition) {
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeStarted(). @Override public void onSwipeStarted(T model, unresolved_type itemView, int adapterPosition)
//                             ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                               ^^^^^ definition local100 T model
//                                      ^^^^ reference _root_/
//                                           ^^^^^^^^ definition local101 unresolved_type itemView
//                                                         ^^^^^^^^^^^^^^^ definition local102 int adapterPosition

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onSwipeProgressChanged(T model, View itemView, float swipeProgress,
//              ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeProgressChanged(). @Override public void onSwipeProgressChanged(T model, unresolved_type itemView, float swipeProgress, unresolved_type canvas)
//                                     ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                       ^^^^^ definition local103 T model
//                                              ^^^^ reference _root_/
//                                                   ^^^^^^^^ definition local104 unresolved_type itemView
//                                                                   ^^^^^^^^^^^^^ definition local105 float swipeProgress
        Canvas canvas) {
//      ^^^^^^ reference _root_/
//             ^^^^^^ definition local106 unresolved_type canvas

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public abstract void onSwipeCompleted(T model, View itemView, int position, int direction);
//                       ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeCompleted(). @Override public abstract void onSwipeCompleted(T model, unresolved_type itemView, int position, int direction)
//                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                          ^^^^^ definition local107 T model
//                                                 ^^^^ reference _root_/
//                                                      ^^^^^^^^ definition local108 unresolved_type itemView
//                                                                    ^^^^^^^^ definition local109 int position
//                                                                                  ^^^^^^^^^ definition local110 int direction

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onSwipeReleased(T model, View itemView) {
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeReleased(). @Override public void onSwipeReleased(T model, unresolved_type itemView)
//                              ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                ^^^^^ definition local111 T model
//                                       ^^^^ reference _root_/
//                                            ^^^^^^^^ definition local112 unresolved_type itemView

    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void clearView(T model, View itemView) {
//              ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#clearView(). @Override public void clearView(T model, unresolved_type itemView)
//                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                          ^^^^^ definition local113 T model
//                                 ^^^^ reference _root_/
//                                      ^^^^^^^^ definition local114 unresolved_type itemView

    }

    /**
     * Whether the given model should be swipable.
     * <p>
     * True by default. You may override this to toggle swipabaility for a model.
     */
    public boolean isSwipeEnabledForModel(T model) {
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#isSwipeEnabledForModel(). public boolean isSwipeEnabledForModel(T model)
//                                        ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                          ^^^^^ definition local115 T model
      return true;
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public final int getMovementFlagsForModel(T model, int adapterPosition) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#getMovementFlagsForModel(). @Override public final int getMovementFlagsForModel(T model, int adapterPosition)
//                                            ^ reference com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                              ^^^^^ definition local116 T model
//                                                         ^^^^^^^^^^^^^^^ definition local117 int adapterPosition
      // Not used
      return 0;
    }
  }
}
