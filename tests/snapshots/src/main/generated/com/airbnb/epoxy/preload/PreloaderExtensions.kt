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
//   ^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[T]  <T>
//                      ^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[U]  <U : com.airbnb.epoxy.preload.ViewMetadata?>
//                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                         ^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[P]  <P : com.airbnb.epoxy.preload.PreloadRequestHolder>
//                                             ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                                ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().  public fun <T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> [ERROR : RecyclerView].addEpoxyPreloader(epoxyController: [ERROR : EpoxyController], maxPreloadDistance: kotlin.Int = ..., errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */ = ..., preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>, requestHolderFactory: () -> P)
    epoxyController: EpoxyController,
//  ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(epoxyController)  value-parameter epoxyController: [ERROR : EpoxyController]
    maxPreloadDistance: Int = 3,
//  ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(maxPreloadDistance)  value-parameter maxPreloadDistance: kotlin.Int = ...
//                      ^^^ reference kotlin/Int#
    errorHandler: PreloadErrorHandler = { context, err -> if (!context.isDebuggable) throw err },
//  ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(errorHandler)  value-parameter errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */ = ...
//                ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadErrorHandler#
//                                        ^^^^^^^ definition local0  value-parameter context: [ERROR : Context]
//                                                 ^^^ definition local1  value-parameter err: kotlin.RuntimeException /* = java.lang.RuntimeException */
//                                                             ^^^^^^^ reference local0
//                                                                                         ^^^ reference local1
    preloader: EpoxyModelPreloader<T, U, P>,
//  ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(preloader)  value-parameter preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>
//             ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                 ^ reference com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[T]
//                                    ^ reference com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[U]
//                                       ^ reference com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().[P]
    requestHolderFactory: () -> P
//  ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloaderExtensionsKt#addEpoxyPreloader().(requestHolderFactory)  value-parameter requestHolderFactory: () -> P
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
