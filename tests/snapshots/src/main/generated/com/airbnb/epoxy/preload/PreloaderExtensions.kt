package com.airbnb.epoxy.preload
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/

import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import com.airbnb.epoxy.EpoxyController
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
import com.airbnb.epoxy.EpoxyModel
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
import com.airbnb.epoxy.utils.isDebuggable
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/utils/
//                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/utils/utilsKt#isDebuggable.

/**
 * Helper to create and add an [EpoxyPreloader] to this RecyclerView.
 *
 * If you are using [com.airbnb.epoxy.EpoxyRecyclerView], prefer[com.airbnb.epoxy.EpoxyRecyclerView.addPreloader]
 * instead.
 *
 * @param maxPreloadDistance How many items to prefetch ahead of the last bound item
 * @param errorHandler Called when the preloader encounters an exception. By default this throws only
 * if the app is not in a debuggle model
 * @param preloader Describes how view content for the EpoxyModel should be preloaded
 * @param requestHolderFactory Should create and return a new [PreloadRequestHolder] each time it is invoked
 */
fun <T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder> RecyclerView.addEpoxyPreloader(
//   ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[T]
//     documentation ```kt\n<T>\n```
//                      ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[U]
//                        documentation ```kt\n<U : com.airbnb.epoxy.preload.ViewMetadata?>\n```
//                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                         ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[P]
//                                           documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().
//                                                                                                  documentation ```kt\npublic fun <T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> [ERROR : RecyclerView].addEpoxyPreloader(epoxyController: [ERROR : EpoxyController], maxPreloadDistance: kotlin.Int = ..., errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */ = ..., preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>, requestHolderFactory: () -> P)\n```\n\n----\n\n\n Helper to create and add an [EpoxyPreloader] to this RecyclerView.\n\n If you are using [com.airbnb.epoxy.EpoxyRecyclerView], prefer[com.airbnb.epoxy.EpoxyRecyclerView.addPreloader]\n instead.\n\n @param maxPreloadDistance How many items to prefetch ahead of the last bound item\n @param errorHandler Called when the preloader encounters an exception. By default this throws only\n if the app is not in a debuggle model\n @param preloader Describes how view content for the EpoxyModel should be preloaded\n @param requestHolderFactory Should create and return a new [PreloadRequestHolder] each time it is invoked\n
    epoxyController: EpoxyController,
//  ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(epoxyController)
//                  documentation ```kt\nvalue-parameter epoxyController: [ERROR : EpoxyController]\n```
    maxPreloadDistance: Int = 3,
//  ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(maxPreloadDistance)
//                     documentation ```kt\nvalue-parameter maxPreloadDistance: kotlin.Int = ...\n```
//                      ^^^ reference semanticdb maven . . kotlin/Int#
    errorHandler: PreloadErrorHandler = { context, err -> if (!context.isDebuggable) throw err },
//  ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(errorHandler)
//               documentation ```kt\nvalue-parameter errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */ = ...\n```
//                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadErrorHandler#
//                                        ^^^^^^^ definition local 0
//                                                documentation ```kt\nvalue-parameter context: [ERROR : Context]\n```
//                                                 ^^^ definition local 1
//                                                     documentation ```kt\nvalue-parameter err: kotlin.RuntimeException /* = java.lang.RuntimeException */\n```
//                                                             ^^^^^^^ reference local 0
//                                                                                         ^^^ reference local 1
    preloader: EpoxyModelPreloader<T, U, P>,
//  ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(preloader)
//            documentation ```kt\nvalue-parameter preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>\n```
//             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                 ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[T]
//                                    ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[U]
//                                       ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[P]
    requestHolderFactory: () -> P
//  ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(requestHolderFactory)
//                       documentation ```kt\nvalue-parameter requestHolderFactory: () -> P\n```
//                              ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[P]
) {
    EpoxyPreloader.with(
        epoxyController,
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(epoxyController)
        requestHolderFactory,
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(requestHolderFactory)
        errorHandler,
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(errorHandler)
        maxPreloadDistance,
//      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(maxPreloadDistance)
        preloader
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(preloader)
    ).let {
        addOnScrollListener(it)
    }
}
