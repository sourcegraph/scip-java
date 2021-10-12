package com.airbnb.epoxy.preload
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/
//                       ^^^^^^^ reference com/airbnb/epoxy/preload/

import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference androidx/
import com.airbnb.epoxy.EpoxyController
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
import com.airbnb.epoxy.EpoxyModel
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
import com.airbnb.epoxy.utils.isDebuggable
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^ reference com/airbnb/epoxy/utils/
//                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/utils/utilsKt#isDebuggable.

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
//   ^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[T]
//                      ^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[U]
//                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                         ^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[P]
//                                             ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                                ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().
    epoxyController: EpoxyController,
//  ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(epoxyController)
    maxPreloadDistance: Int = 3,
//  ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(maxPreloadDistance)
//                      ^^^ reference kotlin/Int#
    errorHandler: PreloadErrorHandler = { context, err -> if (!context.isDebuggable) throw err },
//  ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(errorHandler)
//                ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadErrorHandler#
//                                        ^^^^^^^ definition local0
//                                                 ^^^ definition local1
//                                                             ^^^^^^^ reference local0
//                                                                                         ^^^ reference local1
    preloader: EpoxyModelPreloader<T, U, P>,
//  ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(preloader)
//             ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                 ^ reference com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[T]
//                                    ^ reference com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[U]
//                                       ^ reference com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[P]
    requestHolderFactory: () -> P
//  ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(requestHolderFactory)
//                              ^ reference com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[P]
) {
    EpoxyPreloader.with(
        epoxyController,
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(epoxyController)
        requestHolderFactory,
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(requestHolderFactory)
        errorHandler,
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(errorHandler)
        maxPreloadDistance,
//      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(maxPreloadDistance)
        preloader
//      ^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(preloader)
    ).let {
        addOnScrollListener(it)
    }
}
