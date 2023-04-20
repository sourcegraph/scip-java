package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^ reference semanticdb maven . . android/os/Handler#

import static com.airbnb.epoxy.EpoxyAsyncUtil.MAIN_THREAD_HANDLER;
//            ^^^ reference semanticdb maven . . com/
//                ^^^^^^ reference semanticdb maven . . com/airbnb/
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#
import static com.airbnb.epoxy.EpoxyAsyncUtil.getAsyncBackgroundHandler;
//            ^^^ reference semanticdb maven . . com/
//                ^^^^^^ reference semanticdb maven . . com/airbnb/
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#

/**
 * A subclass of {@link EpoxyController} that makes it easy to do model building and diffing in
 * the background.
 * <p>
 * See https://github.com/airbnb/epoxy/wiki/Epoxy-Controller#asynchronous-support
 */
public abstract class AsyncEpoxyController extends EpoxyController {
//                    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#
//                                         documentation ```java\npublic abstract class AsyncEpoxyController\n```
//                                         documentation  A subclass of {@link EpoxyController} that makes it easy to do model building and diffing in\n the background.\n <p>\n See https://github.com/airbnb/epoxy/wiki/Epoxy-Controller#asynchronous-support\n
//                                         relationship is_implementation semanticdb maven . . ``/ModelCollector#
//                                         relationship is_implementation semanticdb maven . . ``/StickyHeaderCallbacks#
//                                         relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#

  /**
   * A new instance that does model building and diffing asynchronously.
   */
  public AsyncEpoxyController() {
//       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#`<init>`().
//                            documentation ```java\npublic AsyncEpoxyController()\n```
//                            documentation  A new instance that does model building and diffing asynchronously.\n
    this(true);
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#`<init>`(+1).
  }

  /**
   * @param enableAsync True to do model building and diffing asynchronously, false to do them
   *                    both on the main thread.
   */
  public AsyncEpoxyController(boolean enableAsync) {
//       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#`<init>`(+1).
//                            documentation ```java\npublic AsyncEpoxyController(boolean enableAsync)\n```
//                            documentation  @param enableAsync True to do model building and diffing asynchronously, false to do them\n                    both on the main thread.\n
//                                    ^^^^^^^^^^^ definition local 0
//                                                documentation ```java\nboolean enableAsync\n```
    this(enableAsync, enableAsync);
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#`<init>`(+2).
//       ^^^^^^^^^^^ reference local 0
//                    ^^^^^^^^^^^ reference local 0
  }

  /**
   * Individually control whether model building and diffing are done async or on the main thread.
   */
  public AsyncEpoxyController(boolean enableAsyncModelBuilding, boolean enableAsyncDiffing) {
//       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#`<init>`(+2).
//                            documentation ```java\npublic AsyncEpoxyController(boolean enableAsyncModelBuilding, boolean enableAsyncDiffing)\n```
//                            documentation  Individually control whether model building and diffing are done async or on the main thread.\n
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 1
//                                                             documentation ```java\nboolean enableAsyncModelBuilding\n```
//                                                                      ^^^^^^^^^^^^^^^^^^ definition local 2
//                                                                                         documentation ```java\nboolean enableAsyncDiffing\n```
    super(getHandler(enableAsyncModelBuilding), getHandler(enableAsyncDiffing));
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#`<init>`(+1).
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#getHandler().
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 1
//                                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#getHandler().
//                                                         ^^^^^^^^^^^^^^^^^^ reference local 2
  }

  private static Handler getHandler(boolean enableAsync) {
//               ^^^^^^^ reference semanticdb maven . . _root_/
//                       ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#getHandler().
//                                  documentation ```java\nprivate static unresolved_type getHandler(boolean enableAsync)\n```
//                                          ^^^^^^^^^^^ definition local 3
//                                                      documentation ```java\nboolean enableAsync\n```
    return enableAsync ? getAsyncBackgroundHandler() : MAIN_THREAD_HANDLER;
//         ^^^^^^^^^^^ reference local 3
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#getAsyncBackgroundHandler().
//                                                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#MAIN_THREAD_HANDLER.
  }
}
