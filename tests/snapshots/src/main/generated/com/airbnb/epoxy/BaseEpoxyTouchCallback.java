package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

interface BaseEpoxyTouchCallback<T extends EpoxyModel> {
//        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#
//                               documentation ```java\ninterface BaseEpoxyTouchCallback<T extends EpoxyModel>\n```
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyDragCallback#
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#
//                               ^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#[T]
//                                 documentation ```java\nT extends EpoxyModel\n```
//                                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#

  /**
   * Should return a composite flag which defines the enabled move directions in each state
   * (idle, swiping, dragging) for the given model.
   * <p>
   * Return 0 to disable movement for the model.
   *
   * @param model           The model being targeted for movement.
   * @param adapterPosition The current adapter position of the targeted model
   * @see androidx.recyclerview.widget.ItemTouchHelper.Callback#getMovementFlags
   */
  int getMovementFlagsForModel(T model, int adapterPosition);
//    ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#getMovementFlagsForModel().
//                             documentation ```java\npublic abstract int getMovementFlagsForModel(T model, int adapterPosition)\n```
//                             documentation  Should return a composite flag which defines the enabled move directions in each state\n (idle, swiping, dragging) for the given model.\n <p>\n Return 0 to disable movement for the model.\n\n @param model           The model being targeted for movement.\n @param adapterPosition The current adapter position of the targeted model\n @see androidx.recyclerview.widget.ItemTouchHelper.Callback#getMovementFlags\n
//                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#getMovementFlagsForModel().
//                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#getMovementFlagsForModel().
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#[T]
//                               ^^^^^ definition local 0
//                                     documentation ```java\nT model\n```
//                                          ^^^^^^^^^^^^^^^ definition local 1
//                                                          documentation ```java\nint adapterPosition\n```

  /**
   * Called when the user interaction with a view is over and the view has
   * completed its animation. This is a good place to clear all changes on the view that were done
   * in other previous touch callbacks (such as on touch start, change, release, etc).
   * <p>
   * This is the last callback in the lifecycle of a touch event.
   *
   * @param model    The model whose view is being cleared.
   * @param itemView The view being cleared.
   */
  void clearView(T model, View itemView);
//     ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#clearView().
//               documentation ```java\npublic abstract void clearView(T model, unresolved_type itemView)\n```
//               documentation  Called when the user interaction with a view is over and the view has\n completed its animation. This is a good place to clear all changes on the view that were done\n in other previous touch callbacks (such as on touch start, change, release, etc).\n <p>\n This is the last callback in the lifecycle of a touch event.\n\n @param model    The model whose view is being cleared.\n @param itemView The view being cleared.\n
//               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView().
//               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#clearView(+1).
//               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#DragCallbacks#clearView().
//               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#clearView().
//               ^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#[T]
//                 ^^^^^ definition local 2
//                       documentation ```java\nT model\n```
//                        ^^^^ reference semanticdb maven . . _root_/
//                             ^^^^^^^^ definition local 3
//                                      documentation ```java\nunresolved_type itemView\n```
}
