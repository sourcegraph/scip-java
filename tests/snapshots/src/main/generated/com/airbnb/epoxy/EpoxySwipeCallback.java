package com.airbnb.epoxy;

import android.graphics.Canvas;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^^^^^ reference semanticdb maven . . android/graphics/
//                      ^^^^^^ reference semanticdb maven . . android/graphics/Canvas#
import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

import androidx.recyclerview.widget.ItemTouchHelper;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/ItemTouchHelper#

/**
 * For use with {@link EpoxyModelTouchCallback}
 */
public interface EpoxySwipeCallback<T extends EpoxyModel> extends BaseEpoxyTouchCallback<T> {
//               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#
//                                  documentation ```java\npublic interface EpoxySwipeCallback<T extends EpoxyModel>\n```
//                                  documentation  For use with {@link EpoxyModelTouchCallback}\n
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#
//                                  ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#[T]
//                                    documentation ```java\nT extends EpoxyModel\n```
//                                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyTouchCallback#
//                                                                                       ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#[T]

  /**
   * Called when the view switches from an idle state to a swiped state, as the user begins a swipe
   * interaction with it. You can use this callback to modify the view to indicate it is being
   * swiped.
   * <p>
   * This is the first callback made in the lifecycle of a swipe event.
   *
   * @param model           The model representing the view that is being swiped
   * @param itemView        The view that is being swiped
   * @param adapterPosition The adapter position of the model
   */
  void onSwipeStarted(T model, View itemView, int adapterPosition);
//     ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeStarted().
//                    documentation ```java\npublic abstract void onSwipeStarted(T model, unresolved_type itemView, int adapterPosition)\n```
//                    documentation  Called when the view switches from an idle state to a swiped state, as the user begins a swipe\n interaction with it. You can use this callback to modify the view to indicate it is being\n swiped.\n <p>\n This is the first callback made in the lifecycle of a swipe event.\n\n @param model           The model representing the view that is being swiped\n @param itemView        The view that is being swiped\n @param adapterPosition The adapter position of the model\n
//                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeStarted().
//                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeStarted().
//                    ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#[T]
//                      ^^^^^ definition local 0
//                            documentation ```java\nT model\n```
//                             ^^^^ reference semanticdb maven . . _root_/
//                                  ^^^^^^^^ definition local 1
//                                           documentation ```java\nunresolved_type itemView\n```
//                                                ^^^^^^^^^^^^^^^ definition local 2
//                                                                documentation ```java\nint adapterPosition\n```

  /**
   * Once a view has begun swiping with {@link #onSwipeStarted(EpoxyModel, View, int)} it will
   * receive this callback as the swipe distance changes. This can be called multiple times as the
   * swipe interaction progresses.
   *
   * @param model         The model representing the view that is being swiped
   * @param itemView      The view that is being swiped
   * @param swipeProgress A float from -1 to 1 representing the percentage that the view has been
   *                      swiped relative to its width. This will be positive if the view is being
   *                      swiped to the right and negative if it is swiped to the left. For
   *                      example,
   * @param canvas        The canvas on which RecyclerView is drawing its children. You can draw to
   *                      this to support custom swipe animations.
   */
  void onSwipeProgressChanged(T model, View itemView, float swipeProgress,
//     ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeProgressChanged().
//                            documentation ```java\npublic abstract void onSwipeProgressChanged(T model, unresolved_type itemView, float swipeProgress, unresolved_type canvas)\n```
//                            documentation  Once a view has begun swiping with {@link #onSwipeStarted(EpoxyModel, View, int)} it will\n receive this callback as the swipe distance changes. This can be called multiple times as the\n swipe interaction progresses.\n\n @param model         The model representing the view that is being swiped\n @param itemView      The view that is being swiped\n @param swipeProgress A float from -1 to 1 representing the percentage that the view has been\n                      swiped relative to its width. This will be positive if the view is being\n                      swiped to the right and negative if it is swiped to the left. For\n                      example,\n @param canvas        The canvas on which RecyclerView is drawing its children. You can draw to\n                      this to support custom swipe animations.\n
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeProgressChanged().
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeProgressChanged().
//                            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#[T]
//                              ^^^^^ definition local 3
//                                    documentation ```java\nT model\n```
//                                     ^^^^ reference semanticdb maven . . _root_/
//                                          ^^^^^^^^ definition local 4
//                                                   documentation ```java\nunresolved_type itemView\n```
//                                                          ^^^^^^^^^^^^^ definition local 5
//                                                                        documentation ```java\nfloat swipeProgress\n```
      Canvas canvas);
//    ^^^^^^ reference semanticdb maven . . _root_/
//           ^^^^^^ definition local 6
//                  documentation ```java\nunresolved_type canvas\n```

  /**
   * Called when the user has released their touch on the view. If the displacement passed the swipe
   * threshold then {@link #onSwipeCompleted(EpoxyModel, View, int, int)} will be called after this
   * and the view will be animated off screen. Otherwise the view will animate back to its original
   * position.
   *
   * @param model    The model representing the view that was being swiped
   * @param itemView The view that was being swiped
   */
  void onSwipeReleased(T model, View itemView);
//     ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeReleased().
//                     documentation ```java\npublic abstract void onSwipeReleased(T model, unresolved_type itemView)\n```
//                     documentation  Called when the user has released their touch on the view. If the displacement passed the swipe\n threshold then {@link #onSwipeCompleted(EpoxyModel, View, int, int)} will be called after this\n and the view will be animated off screen. Otherwise the view will animate back to its original\n position.\n\n @param model    The model representing the view that was being swiped\n @param itemView The view that was being swiped\n
//                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeReleased().
//                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeReleased().
//                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#[T]
//                       ^^^^^ definition local 7
//                             documentation ```java\nT model\n```
//                              ^^^^ reference semanticdb maven . . _root_/
//                                   ^^^^^^^^ definition local 8
//                                            documentation ```java\nunresolved_type itemView\n```

  /**
   * Called after {@link #onSwipeReleased(EpoxyModel, View)} if the swipe surpassed the threshold to
   * be considered a full swipe. The view will now be animated off screen.
   * <p>
   * You MUST use this callback to remove this item from your backing data and request a model
   * update.
   * <p>
   * {@link #clearView(EpoxyModel, View)} will be called after this.
   *
   * @param model     The model representing the view that was being swiped
   * @param itemView  The view that was being swiped
   * @param position  The adapter position of the model
   * @param direction The direction that the view was swiped. Can be any of {@link
   *                  ItemTouchHelper#LEFT}, {@link ItemTouchHelper#RIGHT}, {@link
   *                  ItemTouchHelper#UP}, {@link ItemTouchHelper#DOWN} depending on what swipe
   *                  directions were enabled.
   */
  void onSwipeCompleted(T model, View itemView, int position, int direction);
//     ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#onSwipeCompleted().
//                      documentation ```java\npublic abstract void onSwipeCompleted(T model, unresolved_type itemView, int position, int direction)\n```
//                      documentation  Called after {@link #onSwipeReleased(EpoxyModel, View)} if the swipe surpassed the threshold to\n be considered a full swipe. The view will now be animated off screen.\n <p>\n You MUST use this callback to remove this item from your backing data and request a model\n update.\n <p>\n {@link #clearView(EpoxyModel, View)} will be called after this.\n\n @param model     The model representing the view that was being swiped\n @param itemView  The view that was being swiped\n @param position  The adapter position of the model\n @param direction The direction that the view was swiped. Can be any of {@link\n                  ItemTouchHelper#LEFT}, {@link ItemTouchHelper#RIGHT}, {@link\n                  ItemTouchHelper#UP}, {@link ItemTouchHelper#DOWN} depending on what swipe\n                  directions were enabled.\n
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelTouchCallback#onSwipeCompleted().
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyTouchHelper#SwipeCallbacks#onSwipeCompleted().
//                      ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxySwipeCallback#[T]
//                        ^^^^^ definition local 9
//                              documentation ```java\nT model\n```
//                               ^^^^ reference semanticdb maven . . _root_/
//                                    ^^^^^^^^ definition local 10
//                                             documentation ```java\nunresolved_type itemView\n```
//                                                  ^^^^^^^^ definition local 11
//                                                           documentation ```java\nint position\n```
//                                                                ^^^^^^^^^ definition local 12
//                                                                          documentation ```java\nint direction\n```
}
