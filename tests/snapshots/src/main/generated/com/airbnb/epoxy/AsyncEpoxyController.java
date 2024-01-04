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
//                                         display_name AsyncEpoxyController
//                                         signature_documentation java public abstract class AsyncEpoxyController
//                                         documentation  A subclass of {@link EpoxyController} that makes it easy to do model building and diffing in\n the background.\n <p>\n See https://github.com/airbnb/epoxy/wiki/Epoxy-Controller#asynchronous-support\n
//                                         relationship is_implementation semanticdb maven . . ModelCollector#
//                                         relationship is_implementation semanticdb maven . . StickyHeaderCallbacks#
//                                         relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#

  /**
   * A new instance that does model building and diffing asynchronously.
   */
  public AsyncEpoxyController() {
//       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#`<init>`().
//                            display_name <init>
//                            signature_documentation java public AsyncEpoxyController()
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
//                            display_name <init>
//                            signature_documentation java public AsyncEpoxyController(boolean enableAsync)
//                            documentation  @param enableAsync True to do model building and diffing asynchronously, false to do them\n                    both on the main thread.\n
//                                    ^^^^^^^^^^^ definition local 0
//                                                display_name enableAsync
//                                                signature_documentation java boolean enableAsync
//                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#`<init>`(+1).
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
//                            display_name <init>
//                            signature_documentation java public AsyncEpoxyController(boolean enableAsyncModelBuilding, boolean enableAsyncDiffing)
//                            documentation  Individually control whether model building and diffing are done async or on the main thread.\n
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 1
//                                                             display_name enableAsyncModelBuilding
//                                                             signature_documentation java boolean enableAsyncModelBuilding
//                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#`<init>`(+2).
//                                                                      ^^^^^^^^^^^^^^^^^^ definition local 2
//                                                                                         display_name enableAsyncDiffing
//                                                                                         signature_documentation java boolean enableAsyncDiffing
//                                                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#`<init>`(+2).
    super(getHandler(enableAsyncModelBuilding), getHandler(enableAsyncDiffing));
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#`<init>`(+1).
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#getHandler().
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 1
//                                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#getHandler().
//                                                         ^^^^^^^^^^^^^^^^^^ reference local 2
  }

  private static Handler getHandler(boolean enableAsync) {
//               ^^^^^^^ reference semanticdb maven . . Handler#
//                       ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#getHandler().
//                                  display_name getHandler
//                                  signature_documentation java private static unresolved_type getHandler(boolean enableAsync)
//                                          ^^^^^^^^^^^ definition local 3
//                                                      display_name enableAsync
//                                                      signature_documentation java boolean enableAsync
//                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyController#getHandler().
    return enableAsync ? getAsyncBackgroundHandler() : MAIN_THREAD_HANDLER;
//         ^^^^^^^^^^^ reference local 3
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#getAsyncBackgroundHandler().
//                                                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAsyncUtil#MAIN_THREAD_HANDLER.
  }
}
