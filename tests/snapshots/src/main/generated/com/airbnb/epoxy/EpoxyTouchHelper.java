package com.airbnb.epoxy;

import android.graphics.Canvas;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^^^^^ reference semanticdb maven . . android/graphics/
//                      ^^^^^^ reference semanticdb maven . . android/graphics/Canvas#
import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

import java.util.ArrayList;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
import java.util.Arrays;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

import androidx.recyclerview.widget.ItemTouchHelper;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/ItemTouchHelper#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView#

import static androidx.recyclerview.widget.ItemTouchHelper.Callback.makeMovementFlags;
//            ^^^^^^^^ reference semanticdb maven . . androidx/
//                     ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                                  ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/ItemTouchHelper/
//                                                         ^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/ItemTouchHelper/Callback#

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
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#
//                                     documentation ```java\npublic abstract class EpoxyTouchHelper\n```
//                                     documentation  A simple way to set up drag or swipe interactions with Epoxy.\n <p>\n Drag events work with the EpoxyController and automatically update the controller and\n RecyclerView when an item is moved. You just need to implement a callback to update your data to\n reflect the change.\n <p>\n Both swipe and drag events implement a small lifecycle to help you style the views as they are\n moved. You can register callbacks for the lifecycle events you care about.\n <p>\n If you want to set up multiple drag and swipe rules for the same RecyclerView, you can use this\n class multiple times to specify different targets or swipe and drag directions and callbacks.\n <p>\n If you want more control over configuration and handling, you can opt to not use this class and\n instead you can implement {@link EpoxyModelTouchCallback} directly with your own {@link\n ItemTouchHelper}. That class provides an interface that makes it easier to work with Epoxy models\n and simplifies touch callbacks.\n <p>\n If you want even more control you can implement {@link EpoxyTouchHelperCallback}. This is just a\n light layer over the normal RecyclerView touch callbacks, but it converts all view holders to\n Epoxy view holders to remove some boilerplate for you.\n
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#`<init>`().
//                                     documentation ```java\npublic EpoxyTouchHelper()\n```

  /**
   * The entry point for setting up drag support.
   *
   * @param controller The EpoxyController with the models that will be dragged. The controller will
   *                   be updated for you when a model is dragged and moved by a user's touch
   *                   interaction.
   */
  public static DragBuilder initDragging(EpoxyController controller) {
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#
//                          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#initDragging().
//                                       documentation ```java\npublic static DragBuilder initDragging(EpoxyController controller)\n```
//                                       documentation  The entry point for setting up drag support.\n\n @param controller The EpoxyController with the models that will be dragged. The controller will\n                   be updated for you when a model is dragged and moved by a user's touch\n                   interaction.\n
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                       ^^^^^^^^^^ definition local 0
//                                                                  documentation ```java\nEpoxyController controller\n```
    return new DragBuilder(controller);
//             ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#`<init>`().
//                         ^^^^^^^^^^ reference local 0
  }

  public static class DragBuilder {
//                    ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#
//                                documentation ```java\npublic static class DragBuilder\n```

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#controller.
//                                           documentation ```java\nprivate final EpoxyController controller\n```

    private DragBuilder(EpoxyController controller) {
//          ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#`<init>`().
//                      documentation ```java\nprivate DragBuilder(EpoxyController controller)\n```
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                      ^^^^^^^^^^ definition local 1
//                                                 documentation ```java\nEpoxyController controller\n```
      this.controller = controller;
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#controller.
//                      ^^^^^^^^^^ reference local 1
    }

    /**
     * The recyclerview that the EpoxyController has its adapter added to. An {@link
     * androidx.recyclerview.widget.ItemTouchHelper} will be created and configured for you, and
     * attached to this RecyclerView.
     */
    public DragBuilder2 withRecyclerView(RecyclerView recyclerView) {
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#
//                      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#withRecyclerView().
//                                       documentation ```java\npublic DragBuilder2 withRecyclerView(unresolved_type recyclerView)\n```
//                                       documentation  The recyclerview that the EpoxyController has its adapter added to. An {@link\n androidx.recyclerview.widget.ItemTouchHelper} will be created and configured for you, and\n attached to this RecyclerView.\n
//                                       ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                    ^^^^^^^^^^^^ definition local 2
//                                                                 documentation ```java\nunresolved_type recyclerView\n```
      return new DragBuilder2(controller, recyclerView);
//               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#`<init>`().
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder#controller.
//                                        ^^^^^^^^^^^^ reference local 2
    }
  }

  public static class DragBuilder2 {
//                    ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#
//                                 documentation ```java\npublic static class DragBuilder2\n```

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#controller.
//                                           documentation ```java\nprivate final EpoxyController controller\n```
    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                             ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#recyclerView.
//                                          documentation ```java\nprivate final unresolved_type recyclerView\n```

    private DragBuilder2(EpoxyController controller, RecyclerView recyclerView) {
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#`<init>`().
//                       documentation ```java\nprivate DragBuilder2(EpoxyController controller, unresolved_type recyclerView)\n```
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                       ^^^^^^^^^^ definition local 3
//                                                  documentation ```java\nEpoxyController controller\n```
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                                ^^^^^^^^^^^^ definition local 4
//                                                                             documentation ```java\nunresolved_type recyclerView\n```
      this.controller = controller;
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#controller.
//                      ^^^^^^^^^^ reference local 3
      this.recyclerView = recyclerView;
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#recyclerView.
//                        ^^^^^^^^^^^^ reference local 4
    }

    /** Enable dragging vertically, up and down. */
    public DragBuilder3 forVerticalList() {
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#forVerticalList().
//                                      documentation ```java\npublic DragBuilder3 forVerticalList()\n```
//                                      documentation Enable dragging vertically, up and down. 
      return withDirections(ItemTouchHelper.UP | ItemTouchHelper.DOWN);
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections().
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                          ^^ reference semanticdb maven . . UP#
//                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                               ^^^^ reference semanticdb maven . . DOWN#
    }

    /** Enable dragging horizontally, left and right. */
    public DragBuilder3 forHorizontalList() {
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#forHorizontalList().
//                                        documentation ```java\npublic DragBuilder3 forHorizontalList()\n```
//                                        documentation Enable dragging horizontally, left and right. 
      return withDirections(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections().
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                          ^^^^ reference semanticdb maven . . LEFT#
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                                 ^^^^^ reference semanticdb maven . . RIGHT#
    }

    /** Enable dragging in all directions. */
    public DragBuilder3 forGrid() {
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#forGrid().
//                              documentation ```java\npublic DragBuilder3 forGrid()\n```
//                              documentation Enable dragging in all directions. 
      return withDirections(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections().
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                          ^^ reference semanticdb maven . . UP#
//                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                               ^^^^ reference semanticdb maven . . DOWN#
//                                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                                                      ^^^^ reference semanticdb maven . . LEFT#
          | ItemTouchHelper.RIGHT);
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                          ^^^^^ reference semanticdb maven . . RIGHT#
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
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                      ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#withDirections().
//                                     documentation ```java\npublic DragBuilder3 withDirections(int directionFlags)\n```
//                                     documentation  Set custom movement flags to dictate which drag directions should be allowed.\n <p>\n Can be any of {@link ItemTouchHelper#LEFT}, {@link ItemTouchHelper#RIGHT}, {@link\n ItemTouchHelper#UP}, {@link ItemTouchHelper#DOWN}, {@link ItemTouchHelper#START}, {@link\n ItemTouchHelper#END}\n <p>\n Flags can be OR'd together to allow multiple directions.\n
//                                         ^^^^^^^^^^^^^^ definition local 5
//                                                        documentation ```java\nint directionFlags\n```
      return new DragBuilder3(controller, recyclerView, makeMovementFlags(directionFlags, 0));
//               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#`<init>`().
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#controller.
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#recyclerView.
//                                                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder2#makeMovementFlags#
//                                                                        ^^^^^^^^^^^^^^ reference local 5
    }
  }

  public static class DragBuilder3 {
//                    ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#
//                                 documentation ```java\npublic static class DragBuilder3\n```

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
//                                           documentation ```java\nprivate final EpoxyController controller\n```
    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                             ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
//                                          documentation ```java\nprivate final unresolved_type recyclerView\n```
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.
//                                  documentation ```java\nprivate final int movementFlags\n```

    private DragBuilder3(EpoxyController controller, RecyclerView recyclerView, int movementFlags) {
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#`<init>`().
//                       documentation ```java\nprivate DragBuilder3(EpoxyController controller, unresolved_type recyclerView, int movementFlags)\n```
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                       ^^^^^^^^^^ definition local 6
//                                                  documentation ```java\nEpoxyController controller\n```
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                                ^^^^^^^^^^^^ definition local 7
//                                                                             documentation ```java\nunresolved_type recyclerView\n```
//                                                                                  ^^^^^^^^^^^^^ definition local 8
//                                                                                                documentation ```java\nint movementFlags\n```
      this.controller = controller;
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
//                      ^^^^^^^^^^ reference local 6
      this.recyclerView = recyclerView;
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
//                        ^^^^^^^^^^^^ reference local 7
      this.movementFlags = movementFlags;
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.
//                         ^^^^^^^^^^^^^ reference local 8
    }

    /**
     * Set the type of Epoxy model that is draggable. This approach works well if you only have one
     * draggable type.
     */
    public <U extends EpoxyModel> DragBuilder4<U> withTarget(Class<U> targetModelClass) {
//          ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().[U]
//            documentation ```java\nU extends EpoxyModel\n```
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                                             ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().[U]
//                                                ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().
//                                                           documentation ```java\npublic <U extends EpoxyModel> DragBuilder4<U> withTarget(Class<U> targetModelClass)\n```
//                                                           documentation  Set the type of Epoxy model that is draggable. This approach works well if you only have one\n draggable type.\n
//                                                           ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                                 ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().[U]
//                                                                    ^^^^^^^^^^^^^^^^ definition local 9
//                                                                                     documentation ```java\nClass<U> targetModelClass\n```
      List<Class<? extends EpoxyModel>> targetClasses = new ArrayList<>(1);
//    ^^^^ reference semanticdb maven jdk 11 java/util/List#
//         ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^^^^^^^ definition local 10
//                                                    documentation ```java\nList<Class<? extends EpoxyModel>> targetClasses\n```
//                                                          ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
      targetClasses.add(targetModelClass);
//    ^^^^^^^^^^^^^ reference local 10
//                  ^^^ reference semanticdb maven jdk 11 java/util/List#add().
//                      ^^^^^^^^^^^^^^^^ reference local 9

      return new DragBuilder4<>(controller, recyclerView, movementFlags, targetModelClass,
//               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#`<init>`().
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
//                                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
//                                                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.
//                                                                       ^^^^^^^^^^^^^^^^ reference local 9
          targetClasses);
//        ^^^^^^^^^^^^^ reference local 10
    }

    /**
     * Specify which Epoxy model types are draggable. Use this if you have more than one type that
     * is draggable.
     * <p>
     * If you only have one draggable type you should use {@link #withTarget(Class)}
     */
    public DragBuilder4<EpoxyModel> withTargets(Class<? extends EpoxyModel>... targetModelClasses) {
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTargets().
//                                              documentation ```java\npublic DragBuilder4<EpoxyModel> withTargets(Class<? extends EpoxyModel>[] targetModelClasses)\n```
//                                              documentation  Specify which Epoxy model types are draggable. Use this if you have more than one type that\n is draggable.\n <p>\n If you only have one draggable type you should use {@link #withTarget(Class)}\n
//                                              ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                             ^^^^^^^^^^^^^^^^^^ definition local 11
//                                                                                                documentation ```java\nClass<? extends EpoxyModel>[] targetModelClasses\n```
      return new DragBuilder4<>(controller, recyclerView, movementFlags, EpoxyModel.class,
//               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#`<init>`().
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#controller.
//                                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#recyclerView.
//                                                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#movementFlags.
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#class.
          Arrays.asList(targetModelClasses));
//        ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#asList().
//                      ^^^^^^^^^^^^^^^^^^ reference local 11
    }

    /**
     * Use this if all models in the controller should be draggable, and if there are multiple types
     * of models in the controller.
     * <p>
     * If you only have one model type you should use {@link #withTarget(Class)}
     */
    public DragBuilder4<EpoxyModel> forAllModels() {
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#forAllModels().
//                                               documentation ```java\npublic DragBuilder4<EpoxyModel> forAllModels()\n```
//                                               documentation  Use this if all models in the controller should be draggable, and if there are multiple types\n of models in the controller.\n <p>\n If you only have one model type you should use {@link #withTarget(Class)}\n
      return withTarget(EpoxyModel.class);
//           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder3#withTarget().
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#class.
    }
  }

  public static class DragBuilder4<U extends EpoxyModel> {
//                    ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#
//                                 documentation ```java\npublic static class DragBuilder4<U extends EpoxyModel>\n```
//                                 ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                   documentation ```java\nU extends EpoxyModel\n```
//                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#

    private final EpoxyController controller;
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#controller.
//                                           documentation ```java\nprivate final EpoxyController controller\n```
    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                             ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#recyclerView.
//                                          documentation ```java\nprivate final unresolved_type recyclerView\n```
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#movementFlags.
//                                  documentation ```java\nprivate final int movementFlags\n```
    private final Class<U> targetModelClass;
//                ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                      ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                         ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClass.
//                                          documentation ```java\nprivate final Class<U> targetModelClass\n```
    private final List<Class<? extends EpoxyModel>> targetModelClasses;
//                ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                     ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses.
//                                                                     documentation ```java\nprivate final List<Class<? extends EpoxyModel>> targetModelClasses\n```

    private DragBuilder4(EpoxyController controller,
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#`<init>`().
//                       documentation ```java\nprivate DragBuilder4(EpoxyController controller, unresolved_type recyclerView, int movementFlags, Class<U> targetModelClass, List<Class<? extends EpoxyModel>> targetModelClasses)\n```
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                       ^^^^^^^^^^ definition local 12
//                                                  documentation ```java\nEpoxyController controller\n```
        RecyclerView recyclerView, int movementFlags,
//      ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                   ^^^^^^^^^^^^ definition local 13
//                                documentation ```java\nunresolved_type recyclerView\n```
//                                     ^^^^^^^^^^^^^ definition local 14
//                                                   documentation ```java\nint movementFlags\n```
        Class<U> targetModelClass, List<Class<? extends EpoxyModel>> targetModelClasses) {
//      ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//               ^^^^^^^^^^^^^^^^ definition local 15
//                                documentation ```java\nClass<U> targetModelClass\n```
//                                 ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                      ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                   ^^^^^^^^^^^^^^^^^^ definition local 16
//                                                                                      documentation ```java\nList<Class<? extends EpoxyModel>> targetModelClasses\n```

      this.controller = controller;
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#controller.
//                      ^^^^^^^^^^ reference local 12
      this.recyclerView = recyclerView;
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#recyclerView.
//                        ^^^^^^^^^^^^ reference local 13
      this.movementFlags = movementFlags;
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#movementFlags.
//                         ^^^^^^^^^^^^^ reference local 14
      this.targetModelClass = targetModelClass;
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClass.
//                            ^^^^^^^^^^^^^^^^ reference local 15
      this.targetModelClasses = targetModelClasses;
//         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses.
//                              ^^^^^^^^^^^^^^^^^^ reference local 16
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
//         ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                         ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#andCallbacks().
//                                      documentation ```java\npublic unresolved_type andCallbacks(DragCallbacks<U> callbacks)\n```
//                                      documentation  Set callbacks to handle drag actions and lifecycle events.\n <p>\n You MUST implement {@link DragCallbacks#onModelMoved(int, int, EpoxyModel,\n View)} to update your data to reflect an item move.\n <p>\n You can optionally implement the other callbacks to modify the view being dragged. This is\n useful if you want to change things like the view background, size, color, etc\n\n @return An {@link ItemTouchHelper} instance that has been initialized and attached to a\n recyclerview. The touch helper has already been fully set up and can be ignored, but you may\n want to hold a reference to it if you need to later detach the recyclerview to disable touch\n events via setting null on {@link ItemTouchHelper#attachToRecyclerView(RecyclerView)}\n
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#
//                                                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                             ^^^^^^^^^ definition local 17
//                                                                       documentation ```java\nfinal DragCallbacks<U> callbacks\n```
      ItemTouchHelper itemTouchHelper =
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                    ^^^^^^^^^^^^^^^ definition local 18
//                                    documentation ```java\nunresolved_type itemTouchHelper\n```
          new ItemTouchHelper(new EpoxyModelTouchCallback<U>(controller, targetModelClass) {
//                                ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#
//                                                        ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#controller.
//                                                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClass.

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            public int getMovementFlagsForModel(U model, int adapterPosition) {
//                     ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 21
//                                              documentation ```java\n@Override\npublic int getMovementFlagsForModel(U model, int adapterPosition)\n```
//                                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#getMovementFlagsForModel().
//                                              ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                ^^^^^ definition local 27
//                                                      documentation ```java\nU model\n```
//                                                           ^^^^^^^^^^^^^^^ definition local 28
//                                                                           documentation ```java\nint adapterPosition\n```
              return movementFlags;
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#movementFlags.
            }

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            protected boolean isTouchableModel(EpoxyModel<?> model) {
//                            ^^^^^^^^^^^^^^^^ definition local 22
//                                             documentation ```java\n@Override\nprotected boolean isTouchableModel(EpoxyModel<?> model)\n```
//                                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^ definition local 29
//                                                                 documentation ```java\nEpoxyModel<?> model\n```
              boolean isTargetType = targetModelClasses.size() == 1
//                    ^^^^^^^^^^^^ definition local 30
//                                 documentation ```java\nboolean isTargetType\n```
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses.
//                                                      ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
                  ? super.isTouchableModel(model)
//                  ^^^^^ reference local 31
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                                         ^^^^^ reference local 29
                  : targetModelClasses.contains(model.getClass());
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#targetModelClasses.
//                                     ^^^^^^^^ reference semanticdb maven jdk 11 java/util/List#contains().
//                                              ^^^^^ reference local 29
//                                                    ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().

              //noinspection unchecked
              return isTargetType && callbacks.isDragEnabledForModel((U) model);
//                   ^^^^^^^^^^^^ reference local 30
//                                   ^^^^^^^^^ reference local 17
//                                             ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#isDragEnabledForModel().
//                                                                    ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                                       ^^^^^ reference local 29
            }

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            public void onDragStarted(U model, View itemView, int adapterPosition) {
//                      ^^^^^^^^^^^^^ definition local 23
//                                    documentation ```java\n@Override\npublic void onDragStarted(U model, unresolved_type itemView, int adapterPosition)\n```
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onDragStarted().
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragStarted().
//                                    ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                      ^^^^^ definition local 32
//                                            documentation ```java\nU model\n```
//                                             ^^^^ reference semanticdb maven . . _root_/
//                                                  ^^^^^^^^ definition local 33
//                                                           documentation ```java\nunresolved_type itemView\n```
//                                                                ^^^^^^^^^^^^^^^ definition local 34
//                                                                                documentation ```java\nint adapterPosition\n```
              callbacks.onDragStarted(model, itemView, adapterPosition);
//            ^^^^^^^^^ reference local 17
//                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragStarted().
//                                    ^^^^^ reference local 32
//                                           ^^^^^^^^ reference local 33
//                                                     ^^^^^^^^^^^^^^^ reference local 34
            }

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            public void onDragReleased(U model, View itemView) {
//                      ^^^^^^^^^^^^^^ definition local 24
//                                     documentation ```java\n@Override\npublic void onDragReleased(U model, unresolved_type itemView)\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onDragReleased().
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onDragReleased().
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                       ^^^^^ definition local 35
//                                             documentation ```java\nU model\n```
//                                              ^^^^ reference semanticdb maven . . _root_/
//                                                   ^^^^^^^^ definition local 36
//                                                            documentation ```java\nunresolved_type itemView\n```
              callbacks.onDragReleased(model, itemView);
//            ^^^^^^^^^ reference local 17
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragReleased().
//                                     ^^^^^ reference local 35
//                                            ^^^^^^^^ reference local 36
            }

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            public void onModelMoved(int fromPosition, int toPosition, U modelBeingMoved,
//                      ^^^^^^^^^^^^ definition local 25
//                                   documentation ```java\n@Override\npublic void onModelMoved(int fromPosition, int toPosition, U modelBeingMoved, unresolved_type itemView)\n```
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onModelMoved().
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onModelMoved().
//                                       ^^^^^^^^^^^^ definition local 37
//                                                    documentation ```java\nint fromPosition\n```
//                                                         ^^^^^^^^^^ definition local 38
//                                                                    documentation ```java\nint toPosition\n```
//                                                                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                                                       ^^^^^^^^^^^^^^^ definition local 39
//                                                                                       documentation ```java\nU modelBeingMoved\n```
                View itemView) {
//              ^^^^ reference semanticdb maven . . _root_/
//                   ^^^^^^^^ definition local 40
//                            documentation ```java\nunresolved_type itemView\n```
              callbacks.onModelMoved(fromPosition, toPosition, modelBeingMoved, itemView);
//            ^^^^^^^^^ reference local 17
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onModelMoved().
//                                   ^^^^^^^^^^^^ reference local 37
//                                                 ^^^^^^^^^^ reference local 38
//                                                             ^^^^^^^^^^^^^^^ reference local 39
//                                                                              ^^^^^^^^ reference local 40
            }

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            public void clearView(U model, View itemView) {
//                      ^^^^^^^^^ definition local 26
//                                documentation ```java\n@Override\npublic void clearView(U model, unresolved_type itemView)\n```
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#clearView().
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView(+1).
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView().
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView(+1).
//                                ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#[U]
//                                  ^^^^^ definition local 41
//                                        documentation ```java\nU model\n```
//                                         ^^^^ reference semanticdb maven . . _root_/
//                                              ^^^^^^^^ definition local 42
//                                                       documentation ```java\nunresolved_type itemView\n```
              callbacks.clearView(model, itemView);
//            ^^^^^^^^^ reference local 17
//                      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#clearView().
//                                ^^^^^ reference local 41
//                                       ^^^^^^^^ reference local 42
            }
          });

      itemTouchHelper.attachToRecyclerView(recyclerView);
//    ^^^^^^^^^^^^^^^ reference local 18
//                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . attachToRecyclerView#
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragBuilder4#recyclerView.

      return itemTouchHelper;
//           ^^^^^^^^^^^^^^^ reference local 18
    }
  }

  public abstract static class DragCallbacks<T extends EpoxyModel>
//                             ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#
//                                           documentation ```java\npublic abstract static class DragCallbacks<T extends EpoxyModel>\n```
//                                           relationship is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#
//                                           relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#
//                             ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#`<init>`().
//                                           documentation ```java\npublic DragCallbacks()\n```
//                                           ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                             documentation ```java\nT extends EpoxyModel\n```
//                                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
      implements EpoxyDragCallback<T> {
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#
//                                 ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void onDragStarted(T model, View itemView, int adapterPosition) {
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragStarted().
//                            documentation ```java\n@Override\npublic void onDragStarted(T model, unresolved_type itemView, int adapterPosition)\n```
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onDragStarted().
//                            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                              ^^^^^ definition local 43
//                                    documentation ```java\nT model\n```
//                                     ^^^^ reference semanticdb maven . . _root_/
//                                          ^^^^^^^^ definition local 44
//                                                   documentation ```java\nunresolved_type itemView\n```
//                                                        ^^^^^^^^^^^^^^^ definition local 45
//                                                                        documentation ```java\nint adapterPosition\n```

    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void onDragReleased(T model, View itemView) {
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onDragReleased().
//                             documentation ```java\n@Override\npublic void onDragReleased(T model, unresolved_type itemView)\n```
//                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onDragReleased().
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                               ^^^^^ definition local 46
//                                     documentation ```java\nT model\n```
//                                      ^^^^ reference semanticdb maven . . _root_/
//                                           ^^^^^^^^ definition local 47
//                                                    documentation ```java\nunresolved_type itemView\n```

    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public abstract void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved,
//                       ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#onModelMoved().
//                                    documentation ```java\n@Override\npublic abstract void onModelMoved(int fromPosition, int toPosition, T modelBeingMoved, unresolved_type itemView)\n```
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#onModelMoved().
//                                        ^^^^^^^^^^^^ definition local 48
//                                                     documentation ```java\nint fromPosition\n```
//                                                          ^^^^^^^^^^ definition local 49
//                                                                     documentation ```java\nint toPosition\n```
//                                                                      ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                                                        ^^^^^^^^^^^^^^^ definition local 50
//                                                                                        documentation ```java\nT modelBeingMoved\n```
        View itemView);
//      ^^^^ reference semanticdb maven . . _root_/
//           ^^^^^^^^ definition local 51
//                    documentation ```java\nunresolved_type itemView\n```

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void clearView(T model, View itemView) {
//              ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#clearView().
//                        documentation ```java\n@Override\npublic void clearView(T model, unresolved_type itemView)\n```
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#clearView().
//                        ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                          ^^^^^ definition local 52
//                                documentation ```java\nT model\n```
//                                 ^^^^ reference semanticdb maven . . _root_/
//                                      ^^^^^^^^ definition local 53
//                                               documentation ```java\nunresolved_type itemView\n```

    }

    /**
     * Whether the given model should be draggable.
     * <p>
     * True by default. You may override this to toggle draggability for a model.
     */
    public boolean isDragEnabledForModel(T model) {
//                 ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#isDragEnabledForModel().
//                                       documentation ```java\npublic boolean isDragEnabledForModel(T model)\n```
//                                       documentation  Whether the given model should be draggable.\n <p>\n True by default. You may override this to toggle draggability for a model.\n
//                                       ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                         ^^^^^ definition local 54
//                                               documentation ```java\nT model\n```
      return true;
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public final int getMovementFlagsForModel(T model, int adapterPosition) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#getMovementFlagsForModel().
//                                            documentation ```java\n@Override\npublic final int getMovementFlagsForModel(T model, int adapterPosition)\n```
//                                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#getMovementFlagsForModel().
//                                            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#[T]
//                                              ^^^^^ definition local 55
//                                                    documentation ```java\nT model\n```
//                                                         ^^^^^^^^^^^^^^^ definition local 56
//                                                                         documentation ```java\nint adapterPosition\n```
      // No-Op this is not used
      return 0;
    }
  }

  /**
   * The entry point for setting up swipe support for a RecyclerView. The RecyclerView must be set
   * with an Epoxy adapter or controller.
   */
  public static SwipeBuilder initSwiping(RecyclerView recyclerView) {
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#
//                           ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#initSwiping().
//                                       documentation ```java\npublic static SwipeBuilder initSwiping(unresolved_type recyclerView)\n```
//                                       documentation  The entry point for setting up swipe support for a RecyclerView. The RecyclerView must be set\n with an Epoxy adapter or controller.\n
//                                       ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                    ^^^^^^^^^^^^ definition local 57
//                                                                 documentation ```java\nunresolved_type recyclerView\n```
    return new SwipeBuilder(recyclerView);
//             ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#`<init>`().
//                          ^^^^^^^^^^^^ reference local 57
  }

  public static class SwipeBuilder {
//                    ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#
//                                 documentation ```java\npublic static class SwipeBuilder\n```

    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                             ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#recyclerView.
//                                          documentation ```java\nprivate final unresolved_type recyclerView\n```

    private SwipeBuilder(RecyclerView recyclerView) {
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#`<init>`().
//                       documentation ```java\nprivate SwipeBuilder(unresolved_type recyclerView)\n```
//                       ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                    ^^^^^^^^^^^^ definition local 58
//                                                 documentation ```java\nunresolved_type recyclerView\n```
      this.recyclerView = recyclerView;
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#recyclerView.
//                        ^^^^^^^^^^^^ reference local 58
    }

    /** Enable swiping right. */
    public SwipeBuilder2 right() {
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#right().
//                             documentation ```java\npublic SwipeBuilder2 right()\n```
//                             documentation Enable swiping right. 
      return withDirections(ItemTouchHelper.RIGHT);
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                          ^^^^^ reference semanticdb maven . . RIGHT#
    }

    /** Enable swiping left. */
    public SwipeBuilder2 left() {
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#left().
//                            documentation ```java\npublic SwipeBuilder2 left()\n```
//                            documentation Enable swiping left. 
      return withDirections(ItemTouchHelper.LEFT);
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                          ^^^^ reference semanticdb maven . . LEFT#
    }

    /** Enable swiping horizontally, left and right. */
    public SwipeBuilder2 leftAndRight() {
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#leftAndRight().
//                                    documentation ```java\npublic SwipeBuilder2 leftAndRight()\n```
//                                    documentation Enable swiping horizontally, left and right. 
      return withDirections(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                          ^^^^ reference semanticdb maven . . LEFT#
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                                 ^^^^^ reference semanticdb maven . . RIGHT#
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
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#withDirections().
//                                      documentation ```java\npublic SwipeBuilder2 withDirections(int directionFlags)\n```
//                                      documentation  Set custom movement flags to dictate which swipe directions should be allowed.\n <p>\n Can be any of {@link ItemTouchHelper#LEFT}, {@link ItemTouchHelper#RIGHT}, {@link\n ItemTouchHelper#UP}, {@link ItemTouchHelper#DOWN}, {@link ItemTouchHelper#START}, {@link\n ItemTouchHelper#END}\n <p>\n Flags can be OR'd together to allow multiple directions.\n
//                                          ^^^^^^^^^^^^^^ definition local 59
//                                                         documentation ```java\nint directionFlags\n```
      return new SwipeBuilder2(recyclerView, makeMovementFlags(0, directionFlags));
//               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#`<init>`().
//                             ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#recyclerView.
//                                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder#makeMovementFlags#
//                                                                ^^^^^^^^^^^^^^ reference local 59
    }
  }

  public static class SwipeBuilder2 {
//                    ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#
//                                  documentation ```java\npublic static class SwipeBuilder2\n```

    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                             ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                                          documentation ```java\nprivate final unresolved_type recyclerView\n```
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                                  documentation ```java\nprivate final int movementFlags\n```

    private SwipeBuilder2(RecyclerView recyclerView,
//          ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#`<init>`().
//                        documentation ```java\nprivate SwipeBuilder2(unresolved_type recyclerView, int movementFlags)\n```
//                        ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                     ^^^^^^^^^^^^ definition local 60
//                                                  documentation ```java\nunresolved_type recyclerView\n```
        int movementFlags) {
//          ^^^^^^^^^^^^^ definition local 61
//                        documentation ```java\nint movementFlags\n```
      this.recyclerView = recyclerView;
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                        ^^^^^^^^^^^^ reference local 60
      this.movementFlags = movementFlags;
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                         ^^^^^^^^^^^^^ reference local 61
    }

    /**
     * Set the type of Epoxy model that is swipable. Use this if you only have one
     * swipable type.
     */
    public <U extends EpoxyModel> SwipeBuilder3<U> withTarget(Class<U> targetModelClass) {
//          ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().[U]
//            documentation ```java\nU extends EpoxyModel\n```
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                                              ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().[U]
//                                                 ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().
//                                                            documentation ```java\npublic <U extends EpoxyModel> SwipeBuilder3<U> withTarget(Class<U> targetModelClass)\n```
//                                                            documentation  Set the type of Epoxy model that is swipable. Use this if you only have one\n swipable type.\n
//                                                            ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().[U]
//                                                                     ^^^^^^^^^^^^^^^^ definition local 62
//                                                                                      documentation ```java\nClass<U> targetModelClass\n```
      List<Class<? extends EpoxyModel>> targetClasses = new ArrayList<>(1);
//    ^^^^ reference semanticdb maven jdk 11 java/util/List#
//         ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^^^^^^^ definition local 63
//                                                    documentation ```java\nList<Class<? extends EpoxyModel>> targetClasses\n```
//                                                          ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
      targetClasses.add(targetModelClass);
//    ^^^^^^^^^^^^^ reference local 63
//                  ^^^ reference semanticdb maven jdk 11 java/util/List#add().
//                      ^^^^^^^^^^^^^^^^ reference local 62

      return new SwipeBuilder3<>(recyclerView, movementFlags, targetModelClass,
//               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#`<init>`().
//                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                                                            ^^^^^^^^^^^^^^^^ reference local 62
          targetClasses);
//        ^^^^^^^^^^^^^ reference local 63
    }

    /**
     * Specify which Epoxy model types are swipable. Use this if you have more than one type that
     * is swipable.
     * <p>
     * If you only have one swipable type you should use {@link #withTarget(Class)}
     */
    public SwipeBuilder3<EpoxyModel> withTargets(
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTargets().
//                                               documentation ```java\npublic SwipeBuilder3<EpoxyModel> withTargets(Class<? extends EpoxyModel>[] targetModelClasses)\n```
//                                               documentation  Specify which Epoxy model types are swipable. Use this if you have more than one type that\n is swipable.\n <p>\n If you only have one swipable type you should use {@link #withTarget(Class)}\n
        Class<? extends EpoxyModel>... targetModelClasses) {
//      ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                     ^^^^^^^^^^^^^^^^^^ definition local 64
//                                                        documentation ```java\nClass<? extends EpoxyModel>[] targetModelClasses\n```
      return new SwipeBuilder3<>(recyclerView, movementFlags, EpoxyModel.class,
//               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#`<init>`().
//                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#recyclerView.
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#movementFlags.
//                                                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#class.
          Arrays.asList(targetModelClasses));
//        ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#asList().
//                      ^^^^^^^^^^^^^^^^^^ reference local 64
    }

    /**
     * Use this if all models in the controller should be swipable, and if there are multiple types
     * of models in the controller.
     * <p>
     * If you only have one model type you should use {@link #withTarget(Class)}
     */
    public SwipeBuilder3<EpoxyModel> forAllModels() {
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#forAllModels().
//                                                documentation ```java\npublic SwipeBuilder3<EpoxyModel> forAllModels()\n```
//                                                documentation  Use this if all models in the controller should be swipable, and if there are multiple types\n of models in the controller.\n <p>\n If you only have one model type you should use {@link #withTarget(Class)}\n
      return withTarget(EpoxyModel.class);
//           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder2#withTarget().
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#class.
    }
  }

  public static class SwipeBuilder3<U extends EpoxyModel> {
//                    ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#
//                                  documentation ```java\npublic static class SwipeBuilder3<U extends EpoxyModel>\n```
//                                  ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                    documentation ```java\nU extends EpoxyModel\n```
//                                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#

    private final RecyclerView recyclerView;
//                ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                             ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#recyclerView.
//                                          documentation ```java\nprivate final unresolved_type recyclerView\n```
    private final int movementFlags;
//                    ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#movementFlags.
//                                  documentation ```java\nprivate final int movementFlags\n```
    private final Class<U> targetModelClass;
//                ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                      ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                         ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClass.
//                                          documentation ```java\nprivate final Class<U> targetModelClass\n```
    private final List<Class<? extends EpoxyModel>> targetModelClasses;
//                ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                     ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.
//                                                                     documentation ```java\nprivate final List<Class<? extends EpoxyModel>> targetModelClasses\n```

    private SwipeBuilder3(
//          ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#`<init>`().
//                        documentation ```java\nprivate SwipeBuilder3(unresolved_type recyclerView, int movementFlags, Class<U> targetModelClass, List<Class<? extends EpoxyModel>> targetModelClasses)\n```
        RecyclerView recyclerView, int movementFlags,
//      ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                   ^^^^^^^^^^^^ definition local 65
//                                documentation ```java\nunresolved_type recyclerView\n```
//                                     ^^^^^^^^^^^^^ definition local 66
//                                                   documentation ```java\nint movementFlags\n```
        Class<U> targetModelClass, List<Class<? extends EpoxyModel>> targetModelClasses) {
//      ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//               ^^^^^^^^^^^^^^^^ definition local 67
//                                documentation ```java\nClass<U> targetModelClass\n```
//                                 ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                      ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                   ^^^^^^^^^^^^^^^^^^ definition local 68
//                                                                                      documentation ```java\nList<Class<? extends EpoxyModel>> targetModelClasses\n```

      this.recyclerView = recyclerView;
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#recyclerView.
//                        ^^^^^^^^^^^^ reference local 65
      this.movementFlags = movementFlags;
//         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#movementFlags.
//                         ^^^^^^^^^^^^^ reference local 66
      this.targetModelClass = targetModelClass;
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClass.
//                            ^^^^^^^^^^^^^^^^ reference local 67
      this.targetModelClasses = targetModelClasses;
//         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.
//                              ^^^^^^^^^^^^^^^^^^ reference local 68
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
//         ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                         ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#andCallbacks().
//                                      documentation ```java\npublic unresolved_type andCallbacks(SwipeCallbacks<U> callbacks)\n```
//                                      documentation  Set callbacks to handle swipe actions and lifecycle events.\n <p>\n You MUST implement {@link SwipeCallbacks#onSwipeCompleted(EpoxyModel, View, int, int)} to\n remove the swiped item from your data and request a model build.\n <p>\n You can optionally implement the other callbacks to modify the view as it is being swiped.\n\n @return An {@link ItemTouchHelper} instance that has been initialized and attached to a\n recyclerview. The touch helper has already been fully set up and can be ignored, but you may\n want to hold a reference to it if you need to later detach the recyclerview to disable touch\n events via setting null on {@link ItemTouchHelper#attachToRecyclerView(RecyclerView)}\n
//                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#
//                                                           ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                              ^^^^^^^^^ definition local 69
//                                                                        documentation ```java\nfinal SwipeCallbacks<U> callbacks\n```
      ItemTouchHelper itemTouchHelper =
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                    ^^^^^^^^^^^^^^^ definition local 70
//                                    documentation ```java\nunresolved_type itemTouchHelper\n```
          new ItemTouchHelper(new EpoxyModelTouchCallback<U>(null, targetModelClass) {
//                                ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#
//                                                        ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClass.

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            public int getMovementFlagsForModel(U model, int adapterPosition) {
//                     ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 73
//                                              documentation ```java\n@Override\npublic int getMovementFlagsForModel(U model, int adapterPosition)\n```
//                                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#getMovementFlagsForModel().
//                                              ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                ^^^^^ definition local 80
//                                                      documentation ```java\nU model\n```
//                                                           ^^^^^^^^^^^^^^^ definition local 81
//                                                                           documentation ```java\nint adapterPosition\n```
              return movementFlags;
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#movementFlags.
            }

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            protected boolean isTouchableModel(EpoxyModel<?> model) {
//                            ^^^^^^^^^^^^^^^^ definition local 74
//                                             documentation ```java\n@Override\nprotected boolean isTouchableModel(EpoxyModel<?> model)\n```
//                                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^ definition local 82
//                                                                 documentation ```java\nEpoxyModel<?> model\n```
              boolean isTargetType = targetModelClasses.size() == 1
//                    ^^^^^^^^^^^^ definition local 83
//                                 documentation ```java\nboolean isTargetType\n```
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.
//                                                      ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
                  ? super.isTouchableModel(model)
//                  ^^^^^ reference local 84
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#isTouchableModel().
//                                         ^^^^^ reference local 82
                  : targetModelClasses.contains(model.getClass());
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#targetModelClasses.
//                                     ^^^^^^^^ reference semanticdb maven jdk 11 java/util/List#contains().
//                                              ^^^^^ reference local 82
//                                                    ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().

              //noinspection unchecked
              return isTargetType && callbacks.isSwipeEnabledForModel((U) model);
//                   ^^^^^^^^^^^^ reference local 83
//                                   ^^^^^^^^^ reference local 69
//                                             ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#isSwipeEnabledForModel().
//                                                                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                                                        ^^^^^ reference local 82
            }

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            public void onSwipeStarted(U model, View itemView, int adapterPosition) {
//                      ^^^^^^^^^^^^^^ definition local 75
//                                     documentation ```java\n@Override\npublic void onSwipeStarted(U model, unresolved_type itemView, int adapterPosition)\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeStarted().
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeStarted().
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                       ^^^^^ definition local 85
//                                             documentation ```java\nU model\n```
//                                              ^^^^ reference semanticdb maven . . _root_/
//                                                   ^^^^^^^^ definition local 86
//                                                            documentation ```java\nunresolved_type itemView\n```
//                                                                 ^^^^^^^^^^^^^^^ definition local 87
//                                                                                 documentation ```java\nint adapterPosition\n```
              callbacks.onSwipeStarted(model, itemView, adapterPosition);
//            ^^^^^^^^^ reference local 69
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeStarted().
//                                     ^^^^^ reference local 85
//                                            ^^^^^^^^ reference local 86
//                                                      ^^^^^^^^^^^^^^^ reference local 87
            }

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            public void onSwipeProgressChanged(U model, View itemView, float swipeProgress,
//                      ^^^^^^^^^^^^^^^^^^^^^^ definition local 76
//                                             documentation ```java\n@Override\npublic void onSwipeProgressChanged(U model, unresolved_type itemView, float swipeProgress, unresolved_type canvas)\n```
//                                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeProgressChanged().
//                                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeProgressChanged().
//                                             ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                               ^^^^^ definition local 88
//                                                     documentation ```java\nU model\n```
//                                                      ^^^^ reference semanticdb maven . . _root_/
//                                                           ^^^^^^^^ definition local 89
//                                                                    documentation ```java\nunresolved_type itemView\n```
//                                                                           ^^^^^^^^^^^^^ definition local 90
//                                                                                         documentation ```java\nfloat swipeProgress\n```
                Canvas canvas) {
//              ^^^^^^ reference semanticdb maven . . _root_/
//                     ^^^^^^ definition local 91
//                            documentation ```java\nunresolved_type canvas\n```
              callbacks.onSwipeProgressChanged(model, itemView, swipeProgress, canvas);
//            ^^^^^^^^^ reference local 69
//                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeProgressChanged().
//                                             ^^^^^ reference local 88
//                                                    ^^^^^^^^ reference local 89
//                                                              ^^^^^^^^^^^^^ reference local 90
//                                                                             ^^^^^^ reference local 91
            }

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            public void onSwipeCompleted(U model, View itemView, int position, int direction) {
//                      ^^^^^^^^^^^^^^^^ definition local 77
//                                       documentation ```java\n@Override\npublic void onSwipeCompleted(U model, unresolved_type itemView, int position, int direction)\n```
//                                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeCompleted().
//                                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeCompleted().
//                                       ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                         ^^^^^ definition local 92
//                                               documentation ```java\nU model\n```
//                                                ^^^^ reference semanticdb maven . . _root_/
//                                                     ^^^^^^^^ definition local 93
//                                                              documentation ```java\nunresolved_type itemView\n```
//                                                                   ^^^^^^^^ definition local 94
//                                                                            documentation ```java\nint position\n```
//                                                                                 ^^^^^^^^^ definition local 95
//                                                                                           documentation ```java\nint direction\n```
              callbacks.onSwipeCompleted(model, itemView, position, direction);
//            ^^^^^^^^^ reference local 69
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeCompleted().
//                                       ^^^^^ reference local 92
//                                              ^^^^^^^^ reference local 93
//                                                        ^^^^^^^^ reference local 94
//                                                                  ^^^^^^^^^ reference local 95
            }

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            public void onSwipeReleased(U model, View itemView) {
//                      ^^^^^^^^^^^^^^^ definition local 78
//                                      documentation ```java\n@Override\npublic void onSwipeReleased(U model, unresolved_type itemView)\n```
//                                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeReleased().
//                                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeReleased().
//                                      ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                        ^^^^^ definition local 96
//                                              documentation ```java\nU model\n```
//                                               ^^^^ reference semanticdb maven . . _root_/
//                                                    ^^^^^^^^ definition local 97
//                                                             documentation ```java\nunresolved_type itemView\n```
              callbacks.onSwipeReleased(model, itemView);
//            ^^^^^^^^^ reference local 69
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeReleased().
//                                      ^^^^^ reference local 96
//                                             ^^^^^^^^ reference local 97
            }

            @Override
//           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
            public void clearView(U model, View itemView) {
//                      ^^^^^^^^^ definition local 79
//                                documentation ```java\n@Override\npublic void clearView(U model, unresolved_type itemView)\n```
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#clearView().
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView(+1).
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView().
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelperCallback#clearView(+1).
//                                ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#[U]
//                                  ^^^^^ definition local 98
//                                        documentation ```java\nU model\n```
//                                         ^^^^ reference semanticdb maven . . _root_/
//                                              ^^^^^^^^ definition local 99
//                                                       documentation ```java\nunresolved_type itemView\n```
              callbacks.clearView(model, itemView);
//            ^^^^^^^^^ reference local 69
//                      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#clearView().
//                                ^^^^^ reference local 98
//                                       ^^^^^^^^ reference local 99
            }
          });

      itemTouchHelper.attachToRecyclerView(recyclerView);
//    ^^^^^^^^^^^^^^^ reference local 70
//                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . attachToRecyclerView#
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeBuilder3#recyclerView.

      return itemTouchHelper;
//           ^^^^^^^^^^^^^^^ reference local 70
    }
  }

  public abstract static class SwipeCallbacks<T extends EpoxyModel>
//                             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#
//                                            documentation ```java\npublic abstract static class SwipeCallbacks<T extends EpoxyModel>\n```
//                                            relationship is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#
//                                            relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#
//                             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#`<init>`().
//                                            documentation ```java\npublic SwipeCallbacks()\n```
//                                            ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                              documentation ```java\nT extends EpoxyModel\n```
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
      implements EpoxySwipeCallback<T> {
//               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#
//                                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void onSwipeStarted(T model, View itemView, int adapterPosition) {
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeStarted().
//                             documentation ```java\n@Override\npublic void onSwipeStarted(T model, unresolved_type itemView, int adapterPosition)\n```
//                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeStarted().
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                               ^^^^^ definition local 100
//                                     documentation ```java\nT model\n```
//                                      ^^^^ reference semanticdb maven . . _root_/
//                                           ^^^^^^^^ definition local 101
//                                                    documentation ```java\nunresolved_type itemView\n```
//                                                         ^^^^^^^^^^^^^^^ definition local 102
//                                                                         documentation ```java\nint adapterPosition\n```

    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void onSwipeProgressChanged(T model, View itemView, float swipeProgress,
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeProgressChanged().
//                                     documentation ```java\n@Override\npublic void onSwipeProgressChanged(T model, unresolved_type itemView, float swipeProgress, unresolved_type canvas)\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeProgressChanged().
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                       ^^^^^ definition local 103
//                                             documentation ```java\nT model\n```
//                                              ^^^^ reference semanticdb maven . . _root_/
//                                                   ^^^^^^^^ definition local 104
//                                                            documentation ```java\nunresolved_type itemView\n```
//                                                                   ^^^^^^^^^^^^^ definition local 105
//                                                                                 documentation ```java\nfloat swipeProgress\n```
        Canvas canvas) {
//      ^^^^^^ reference semanticdb maven . . _root_/
//             ^^^^^^ definition local 106
//                    documentation ```java\nunresolved_type canvas\n```

    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public abstract void onSwipeCompleted(T model, View itemView, int position, int direction);
//                       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeCompleted().
//                                        documentation ```java\n@Override\npublic abstract void onSwipeCompleted(T model, unresolved_type itemView, int position, int direction)\n```
//                                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeCompleted().
//                                        ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                          ^^^^^ definition local 107
//                                                documentation ```java\nT model\n```
//                                                 ^^^^ reference semanticdb maven . . _root_/
//                                                      ^^^^^^^^ definition local 108
//                                                               documentation ```java\nunresolved_type itemView\n```
//                                                                    ^^^^^^^^ definition local 109
//                                                                             documentation ```java\nint position\n```
//                                                                                  ^^^^^^^^^ definition local 110
//                                                                                            documentation ```java\nint direction\n```

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void onSwipeReleased(T model, View itemView) {
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeReleased().
//                              documentation ```java\n@Override\npublic void onSwipeReleased(T model, unresolved_type itemView)\n```
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeReleased().
//                              ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                ^^^^^ definition local 111
//                                      documentation ```java\nT model\n```
//                                       ^^^^ reference semanticdb maven . . _root_/
//                                            ^^^^^^^^ definition local 112
//                                                     documentation ```java\nunresolved_type itemView\n```

    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void clearView(T model, View itemView) {
//              ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#clearView().
//                        documentation ```java\n@Override\npublic void clearView(T model, unresolved_type itemView)\n```
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#clearView().
//                        ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                          ^^^^^ definition local 113
//                                documentation ```java\nT model\n```
//                                 ^^^^ reference semanticdb maven . . _root_/
//                                      ^^^^^^^^ definition local 114
//                                               documentation ```java\nunresolved_type itemView\n```

    }

    /**
     * Whether the given model should be swipable.
     * <p>
     * True by default. You may override this to toggle swipabaility for a model.
     */
    public boolean isSwipeEnabledForModel(T model) {
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#isSwipeEnabledForModel().
//                                        documentation ```java\npublic boolean isSwipeEnabledForModel(T model)\n```
//                                        documentation  Whether the given model should be swipable.\n <p>\n True by default. You may override this to toggle swipabaility for a model.\n
//                                        ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                          ^^^^^ definition local 115
//                                                documentation ```java\nT model\n```
      return true;
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public final int getMovementFlagsForModel(T model, int adapterPosition) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#getMovementFlagsForModel().
//                                            documentation ```java\n@Override\npublic final int getMovementFlagsForModel(T model, int adapterPosition)\n```
//                                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#getMovementFlagsForModel().
//                                            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#[T]
//                                              ^^^^^ definition local 116
//                                                    documentation ```java\nT model\n```
//                                                         ^^^^^^^^^^^^^^^ definition local 117
//                                                                         documentation ```java\nint adapterPosition\n```
      // Not used
      return 0;
    }
  }
}
