package com.airbnb.epoxy.preload
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.annotation.IdRes
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IdRes#
import androidx.annotation.Px
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
import androidx.recyclerview.widget.LinearLayoutManager
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import com.airbnb.epoxy.BaseEpoxyAdapter
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
import com.airbnb.epoxy.EpoxyAdapter
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
import com.airbnb.epoxy.EpoxyController
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
import com.airbnb.epoxy.EpoxyModel
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
import com.airbnb.epoxy.getModelForPositionInternal
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().
import kotlin.math.max
//     ^^^^^^ reference semanticdb maven . . kotlin/
//            ^^^^ reference semanticdb maven . . kotlin/math/
import kotlin.math.min
//     ^^^^^^ reference semanticdb maven . . kotlin/
//            ^^^^ reference semanticdb maven . . kotlin/math/

/**
 * A scroll listener that prefetches view content.
 *
 * To use this, create implementations of [EpoxyModelPreloader] for each EpoxyModel class that you want to preload.
 * Then, use the [EpoxyPreloader.with] methods to create an instance that preloads models of that type.
 * Finally, add the resulting scroll listener to your RecyclerView.
 *
 * If you are using [com.airbnb.epoxy.EpoxyRecyclerView] then use [com.airbnb.epoxy.EpoxyRecyclerView.addPreloader]
 * to setup the preloader as a listener.
 *
 * Otherwise there is a [RecyclerView.addEpoxyPreloader] extension for easy usage.
 */
class EpoxyPreloader<P : PreloadRequestHolder> private constructor(
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#
//                   display_name EpoxyPreloader
//                   documentation ```kt\npublic final class EpoxyPreloader<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```\n\n----\n\n\n A scroll listener that prefetches view content.\n\n To use this, create implementations of [EpoxyModelPreloader] for each EpoxyModel class that you want to preload.\n Then, use the [EpoxyPreloader.with] methods to create an instance that preloads models of that type.\n Finally, add the resulting scroll listener to your RecyclerView.\n\n If you are using [com.airbnb.epoxy.EpoxyRecyclerView] then use [com.airbnb.epoxy.EpoxyRecyclerView.addPreloader]\n to setup the preloader as a listener.\n\n Otherwise there is a [RecyclerView.addEpoxyPreloader] extension for easy usage.\n
//                   ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#[P]
//                     display_name P
//                     documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                     ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().
//                                                                 display_name EpoxyPreloader
//                                                                 documentation ```kt\nprivate constructor EpoxyPreloader<P : com.airbnb.epoxy.preload.PreloadRequestHolder>(adapter: [Error type: Unresolved type for BaseEpoxyAdapter], preloadTargetFactory: () -> P, errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */, maxItemsToPreload: kotlin.Int, modelPreloaders: kotlin.collections.List<com.airbnb.epoxy.preload.EpoxyModelPreloader<*, *, out P>>)\n```
    private val adapter: BaseEpoxyAdapter,
//              ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(adapter)
//                      display_name adapter
//                      documentation ```kt\nvalue-parameter adapter: [Error type: Unresolved type for BaseEpoxyAdapter]\n```
//              ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#adapter.
//                      display_name adapter
//                      documentation ```kt\nprivate final val adapter: [Error type: Unresolved type for BaseEpoxyAdapter]\n```
//              ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getAdapter().
//                      display_name adapter
//                      documentation ```kt\nprivate final val adapter: [Error type: Unresolved type for BaseEpoxyAdapter]\n```
    preloadTargetFactory: () -> P,
//  ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(preloadTargetFactory)
//                       display_name preloadTargetFactory
//                       documentation ```kt\nvalue-parameter preloadTargetFactory: () -> P\n```
//                              ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#[P]
    errorHandler: PreloadErrorHandler,
//  ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(errorHandler)
//               display_name errorHandler
//               documentation ```kt\nvalue-parameter errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadErrorHandler#
    private val maxItemsToPreload: Int,
//              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(maxItemsToPreload)
//                                display_name maxItemsToPreload
//                                documentation ```kt\nvalue-parameter maxItemsToPreload: kotlin.Int\n```
//              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getMaxItemsToPreload().
//                                display_name maxItemsToPreload
//                                documentation ```kt\nprivate final val maxItemsToPreload: kotlin.Int\n```
//              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#maxItemsToPreload.
//                                display_name maxItemsToPreload
//                                documentation ```kt\nprivate final val maxItemsToPreload: kotlin.Int\n```
//                                 ^^^ reference semanticdb maven . . kotlin/Int#
    modelPreloaders: List<EpoxyModelPreloader<*, *, out P>>
//  ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(modelPreloaders)
//                  display_name modelPreloaders
//                  documentation ```kt\nvalue-parameter modelPreloaders: kotlin.collections.List<com.airbnb.epoxy.preload.EpoxyModelPreloader<*, *, out P>>\n```
//                   ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                      ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#[P]
) : RecyclerView.OnScrollListener() {

    private var lastVisibleRange: IntRange = IntRange.EMPTY
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getLastVisibleRange().
//                               display_name lastVisibleRange
//                               documentation ```kt\nprivate final var lastVisibleRange: kotlin.ranges.IntRange\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#lastVisibleRange.
//                               display_name lastVisibleRange
//                               documentation ```kt\nprivate final var lastVisibleRange: kotlin.ranges.IntRange\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setLastVisibleRange().
//                               display_name lastVisibleRange
//                               documentation ```kt\nprivate final var lastVisibleRange: kotlin.ranges.IntRange\n```
//                                ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#
//                                           ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#Companion#
//                                                    ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#Companion#EMPTY.
//                                                    ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#Companion#getEMPTY().
    private var lastPreloadRange: IntProgression = IntRange.EMPTY
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getLastPreloadRange().
//                               display_name lastPreloadRange
//                               documentation ```kt\nprivate final var lastPreloadRange: kotlin.ranges.IntProgression\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#lastPreloadRange.
//                               display_name lastPreloadRange
//                               documentation ```kt\nprivate final var lastPreloadRange: kotlin.ranges.IntProgression\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setLastPreloadRange().
//                               display_name lastPreloadRange
//                               documentation ```kt\nprivate final var lastPreloadRange: kotlin.ranges.IntProgression\n```
//                                ^^^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntProgression#
//                                                 ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#Companion#
//                                                          ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#Companion#EMPTY.
//                                                          ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#Companion#getEMPTY().
    private var totalItemCount = -1
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getTotalItemCount().
//                             display_name totalItemCount
//                             documentation ```kt\nprivate final var totalItemCount: kotlin.Int\n```
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setTotalItemCount().
//                             display_name totalItemCount
//                             documentation ```kt\nprivate final var totalItemCount: kotlin.Int\n```
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#totalItemCount.
//                             display_name totalItemCount
//                             documentation ```kt\nprivate final var totalItemCount: kotlin.Int\n```
//                               ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
    private var scrollState: Int = RecyclerView.SCROLL_STATE_IDLE
//              ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getScrollState().
//                          display_name scrollState
//                          documentation ```kt\nprivate final var scrollState: kotlin.Int\n```
//              ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#scrollState.
//                          display_name scrollState
//                          documentation ```kt\nprivate final var scrollState: kotlin.Int\n```
//              ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setScrollState().
//                          display_name scrollState
//                          documentation ```kt\nprivate final var scrollState: kotlin.Int\n```
//                           ^^^ reference semanticdb maven . . kotlin/Int#

    private val modelPreloaders: Map<Class<out EpoxyModel<*>>, EpoxyModelPreloader<*, *, out P>> =
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getModelPreloaders().
//                              display_name modelPreloaders
//                              documentation ```kt\nprivate final val modelPreloaders: kotlin.collections.Map<java.lang.Class<out [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>>, com.airbnb.epoxy.preload.EpoxyModelPreloader<*, *, out P>>\n```
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#modelPreloaders.
//                              display_name modelPreloaders
//                              documentation ```kt\nprivate final val modelPreloaders: kotlin.collections.Map<java.lang.Class<out [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>>, com.airbnb.epoxy.preload.EpoxyModelPreloader<*, *, out P>>\n```
//                               ^^^ reference semanticdb maven . . kotlin/collections/Map#
//                                   ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                                                           ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#[P]
        modelPreloaders.associateBy { it.modelType }
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(modelPreloaders)
//                      ^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#associateBy(+18).
//                                    ^^ reference local 0
//                                       ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#getModelType().
//                                       ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#modelType.

    private val requestHolderFactory =
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getRequestHolderFactory().
//                                   display_name requestHolderFactory
//                                   documentation ```kt\nprivate final val requestHolderFactory: com.airbnb.epoxy.preload.PreloadTargetProvider<P>\n```
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#requestHolderFactory.
//                                   display_name requestHolderFactory
//                                   documentation ```kt\nprivate final val requestHolderFactory: com.airbnb.epoxy.preload.PreloadTargetProvider<P>\n```
        PreloadTargetProvider(maxItemsToPreload, preloadTargetFactory)
//      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#`<init>`().
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getMaxItemsToPreload().
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#maxItemsToPreload.
//                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(preloadTargetFactory)

    private val viewDataCache = PreloadableViewDataProvider(adapter, errorHandler)
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getViewDataCache().
//                            display_name viewDataCache
//                            documentation ```kt\nprivate final val viewDataCache: com.airbnb.epoxy.preload.PreloadableViewDataProvider\n```
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#viewDataCache.
//                            display_name viewDataCache
//                            documentation ```kt\nprivate final val viewDataCache: com.airbnb.epoxy.preload.PreloadableViewDataProvider\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#`<init>`().
//                                                          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#adapter.
//                                                          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getAdapter().
//                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(errorHandler)

    constructor(
//  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).
//              display_name EpoxyPreloader
//              documentation ```kt\npublic constructor EpoxyPreloader<P : com.airbnb.epoxy.preload.PreloadRequestHolder>(epoxyController: [Error type: Unresolved type for EpoxyController], requestHolderFactory: () -> P, errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */, maxItemsToPreload: kotlin.Int, modelPreloaders: kotlin.collections.List<com.airbnb.epoxy.preload.EpoxyModelPreloader<*, *, out P>>)\n```
        epoxyController: EpoxyController,
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(epoxyController)
//                      display_name epoxyController
//                      documentation ```kt\nvalue-parameter epoxyController: [Error type: Unresolved type for EpoxyController]\n```
        requestHolderFactory: () -> P,
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(requestHolderFactory)
//                           display_name requestHolderFactory
//                           documentation ```kt\nvalue-parameter requestHolderFactory: () -> P\n```
//                                  ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#[P]
        errorHandler: PreloadErrorHandler,
//      ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(errorHandler)
//                   display_name errorHandler
//                   documentation ```kt\nvalue-parameter errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadErrorHandler#
        maxItemsToPreload: Int,
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(maxItemsToPreload)
//                        display_name maxItemsToPreload
//                        documentation ```kt\nvalue-parameter maxItemsToPreload: kotlin.Int\n```
//                         ^^^ reference semanticdb maven . . kotlin/Int#
        modelPreloaders: List<EpoxyModelPreloader<*, *, out P>>
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(modelPreloaders)
//                      display_name modelPreloaders
//                      documentation ```kt\nvalue-parameter modelPreloaders: kotlin.collections.List<com.airbnb.epoxy.preload.EpoxyModelPreloader<*, *, out P>>\n```
//                       ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                          ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#[P]
    ) : this(
        epoxyController.adapter,
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(epoxyController)
        requestHolderFactory,
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(requestHolderFactory)
        errorHandler,
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(errorHandler)
        maxItemsToPreload,
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(maxItemsToPreload)
        modelPreloaders
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(modelPreloaders)
    )

    constructor(
//  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).
//              display_name EpoxyPreloader
//              documentation ```kt\npublic constructor EpoxyPreloader<P : com.airbnb.epoxy.preload.PreloadRequestHolder>(adapter: [Error type: Unresolved type for EpoxyAdapter], requestHolderFactory: () -> P, errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */, maxItemsToPreload: kotlin.Int, modelPreloaders: kotlin.collections.List<com.airbnb.epoxy.preload.EpoxyModelPreloader<*, *, out P>>)\n```
        adapter: EpoxyAdapter,
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(adapter)
//              display_name adapter
//              documentation ```kt\nvalue-parameter adapter: [Error type: Unresolved type for EpoxyAdapter]\n```
        requestHolderFactory: () -> P,
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(requestHolderFactory)
//                           display_name requestHolderFactory
//                           documentation ```kt\nvalue-parameter requestHolderFactory: () -> P\n```
//                                  ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#[P]
        errorHandler: PreloadErrorHandler,
//      ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(errorHandler)
//                   display_name errorHandler
//                   documentation ```kt\nvalue-parameter errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadErrorHandler#
        maxItemsToPreload: Int,
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(maxItemsToPreload)
//                        display_name maxItemsToPreload
//                        documentation ```kt\nvalue-parameter maxItemsToPreload: kotlin.Int\n```
//                         ^^^ reference semanticdb maven . . kotlin/Int#
        modelPreloaders: List<EpoxyModelPreloader<*, *, out P>>
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(modelPreloaders)
//                      display_name modelPreloaders
//                      documentation ```kt\nvalue-parameter modelPreloaders: kotlin.collections.List<com.airbnb.epoxy.preload.EpoxyModelPreloader<*, *, out P>>\n```
//                       ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                          ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#[P]
    ) : this(
        adapter as BaseEpoxyAdapter,
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(adapter)
        requestHolderFactory,
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(requestHolderFactory)
        errorHandler,
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(errorHandler)
        maxItemsToPreload,
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(maxItemsToPreload)
        modelPreloaders
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(modelPreloaders)
    )

    init {
        require(maxItemsToPreload > 0) {
//      ^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/PreconditionsKt#require(+1).
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getMaxItemsToPreload().
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#maxItemsToPreload.
//                                ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
            "maxItemsToPreload must be greater than 0. Was $maxItemsToPreload"
//                                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getMaxItemsToPreload().
//                                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#maxItemsToPreload.
        }
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrollStateChanged().
//                                    display_name onScrollStateChanged
//                                    documentation ```kt\npublic open fun onScrollStateChanged(recyclerView: [Error type: Unresolved type for RecyclerView], newState: kotlin.Int)\n```
//                                    ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrollStateChanged().(recyclerView)
//                                                 display_name recyclerView
//                                                 documentation ```kt\nvalue-parameter recyclerView: [Error type: Unresolved type for RecyclerView]\n```
//                                                                ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrollStateChanged().(newState)
//                                                                         display_name newState
//                                                                         documentation ```kt\nvalue-parameter newState: kotlin.Int\n```
//                                                                          ^^^ reference semanticdb maven . . kotlin/Int#
        scrollState = newState
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getScrollState().
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#scrollState.
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setScrollState().
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrollStateChanged().(newState)
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().
//                          display_name onScrolled
//                          documentation ```kt\npublic open fun onScrolled(recyclerView: [Error type: Unresolved type for RecyclerView], dx: kotlin.Int, dy: kotlin.Int)\n```
//                          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(recyclerView)
//                                       display_name recyclerView
//                                       documentation ```kt\nvalue-parameter recyclerView: [Error type: Unresolved type for RecyclerView]\n```
//                                                      ^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(dx)
//                                                         display_name dx
//                                                         documentation ```kt\nvalue-parameter dx: kotlin.Int\n```
//                                                          ^^^ reference semanticdb maven . . kotlin/Int#
//                                                               ^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(dy)
//                                                                  display_name dy
//                                                                  documentation ```kt\nvalue-parameter dy: kotlin.Int\n```
//                                                                   ^^^ reference semanticdb maven . . kotlin/Int#
        if (dx == 0 && dy == 0) {
//          ^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(dx)
//             ^^ reference semanticdb maven . . kotlin/Int#equals().
//                     ^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(dy)
//                        ^^ reference semanticdb maven . . kotlin/Int#equals().
            // Sometimes flings register a bunch of 0 dx/dy scroll events. To avoid redundant prefetching we just skip these
            // Additionally, the first RecyclerView layout notifies a scroll of 0, since that can be an important time for
            // performance (eg page load) we avoid prefetching at the same time.
            return
        }

        if (dx.isFling() || dy.isFling()) {
//          ^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(dx)
//             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#isFling().
//                          ^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(dy)
//                             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#isFling().
            // We avoid preloading during flings for two reasons
            // 1. Image requests are expensive and we don't want to drop frames on fling
            // 2. We'll likely scroll past the preloading item anyway
            return
        }

        // Update item count before anything else because validations depend on it
        totalItemCount = recyclerView.adapter?.itemCount ?: 0
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getTotalItemCount().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setTotalItemCount().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#totalItemCount.
//                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(recyclerView)

        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
//          ^^^^^^^^^^^^^ definition local 1
//                        display_name layoutManager
//                        documentation ```kt\nval layoutManager: [Error type: Unresolved type for LinearLayoutManager]\n```
//                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(recyclerView)
        val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()
//          ^^^^^^^^^^^^^^^^^^^^ definition local 2
//                               display_name firstVisiblePosition
//                               documentation ```kt\nval firstVisiblePosition: [Error type: Return type for function cannot be resolved]\n```
//                                 ^^^^^^^^^^^^^ reference local 1
        val lastVisiblePosition = layoutManager.findLastVisibleItemPosition()
//          ^^^^^^^^^^^^^^^^^^^ definition local 3
//                              display_name lastVisiblePosition
//                              documentation ```kt\nval lastVisiblePosition: [Error type: Return type for function cannot be resolved]\n```
//                                ^^^^^^^^^^^^^ reference local 1

        if (firstVisiblePosition.isInvalid() || lastVisiblePosition.isInvalid()) {
//          ^^^^^^^^^^^^^^^^^^^^ reference local 2
//                                              ^^^^^^^^^^^^^^^^^^^ reference local 3
            lastVisibleRange = IntRange.EMPTY
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getLastVisibleRange().
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#lastVisibleRange.
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setLastVisibleRange().
//                             ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#Companion#
//                                      ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#Companion#EMPTY.
//                                      ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#Companion#getEMPTY().
            lastPreloadRange = IntRange.EMPTY
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getLastPreloadRange().
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#lastPreloadRange.
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setLastPreloadRange().
//                             ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#Companion#
//                                      ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#Companion#EMPTY.
//                                      ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#Companion#getEMPTY().
            return
        }

        val visibleRange = IntRange(firstVisiblePosition, lastVisiblePosition)
//          ^^^^^^^^^^^^ definition local 4
//                       display_name visibleRange
//                       documentation ```kt\nval visibleRange: kotlin.ranges.IntRange\n```
//                         ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#`<init>`().
//                                  ^^^^^^^^^^^^^^^^^^^^ reference local 2
//                                                        ^^^^^^^^^^^^^^^^^^^ reference local 3
        if (visibleRange == lastVisibleRange) {
//          ^^^^^^^^^^^^ reference local 4
//                       ^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#equals().
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getLastVisibleRange().
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#lastVisibleRange.
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setLastVisibleRange().
            return
        }

        val isIncreasing =
//          ^^^^^^^^^^^^ definition local 5
//                       display_name isIncreasing
//                       documentation ```kt\nval isIncreasing: kotlin.Boolean\n```
            visibleRange.first > lastVisibleRange.first || visibleRange.last > lastVisibleRange.last
//          ^^^^^^^^^^^^ reference local 4
//                       ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#first.
//                       ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#getFirst().
//                             ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getLastVisibleRange().
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#lastVisibleRange.
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setLastVisibleRange().
//                                                ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#first.
//                                                ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#getFirst().
//                                                         ^^^^^^^^^^^^ reference local 4
//                                                                      ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#getLast().
//                                                                      ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#last.
//                                                                           ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getLastVisibleRange().
//                                                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#lastVisibleRange.
//                                                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setLastVisibleRange().
//                                                                                              ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#getLast().
//                                                                                              ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#last.

        val preloadRange =
//          ^^^^^^^^^^^^ definition local 6
//                       display_name preloadRange
//                       documentation ```kt\nval preloadRange: kotlin.ranges.IntProgression\n```
            calculatePreloadRange(firstVisiblePosition, lastVisiblePosition, isIncreasing)
//          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().
//                                ^^^^^^^^^^^^^^^^^^^^ reference local 2
//                                                      ^^^^^^^^^^^^^^^^^^^ reference local 3
//                                                                           ^^^^^^^^^^^^ reference local 5

        // Start preload for any items that weren't already preloaded
        preloadRange
//      ^^^^^^^^^^^^ reference local 6
            .subtract(lastPreloadRange)
//           ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#subtract(+9).
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getLastPreloadRange().
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#lastPreloadRange.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setLastPreloadRange().
            .forEach { preloadAdapterPosition(it) }
//           ^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#forEach(+10).
//                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#preloadAdapterPosition().
//                                            ^^ reference local 7

        lastVisibleRange = visibleRange
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getLastVisibleRange().
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#lastVisibleRange.
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setLastVisibleRange().
//                         ^^^^^^^^^^^^ reference local 4
        lastPreloadRange = preloadRange
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getLastPreloadRange().
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#lastPreloadRange.
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setLastPreloadRange().
//                         ^^^^^^^^^^^^ reference local 6
    }

    /**
     * @receiver The number of pixels scrolled.
     * @return True if this distance is large enough to be considered a fast fling.
     */
    private fun Int.isFling() = Math.abs(this) > FLING_THRESHOLD_PX
//              ^^^ reference semanticdb maven . . kotlin/Int#
//                  ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#isFling().
//                          display_name isFling
//                          documentation ```kt\nprivate final fun kotlin.Int.isFling(): kotlin.Boolean\n```\n\n----\n\n\n @receiver The number of pixels scrolled.\n @return True if this distance is large enough to be considered a fast fling.\n
//                              ^^^^ reference semanticdb maven jdk 11 java/lang/Math#
//                                   ^^^ reference semanticdb maven jdk 11 java/lang/Math#abs().
//                                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#isFling().
//                                             ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#FLING_THRESHOLD_PX.
//                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#getFLING_THRESHOLD_PX().

    private fun calculatePreloadRange(
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().
//                                    display_name calculatePreloadRange
//                                    documentation ```kt\nprivate final fun calculatePreloadRange(firstVisiblePosition: kotlin.Int, lastVisiblePosition: kotlin.Int, isIncreasing: kotlin.Boolean): kotlin.ranges.IntProgression\n```
        firstVisiblePosition: Int,
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(firstVisiblePosition)
//                           display_name firstVisiblePosition
//                           documentation ```kt\nvalue-parameter firstVisiblePosition: kotlin.Int\n```
//                            ^^^ reference semanticdb maven . . kotlin/Int#
        lastVisiblePosition: Int,
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(lastVisiblePosition)
//                          display_name lastVisiblePosition
//                          documentation ```kt\nvalue-parameter lastVisiblePosition: kotlin.Int\n```
//                           ^^^ reference semanticdb maven . . kotlin/Int#
        isIncreasing: Boolean
//      ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(isIncreasing)
//                   display_name isIncreasing
//                   documentation ```kt\nvalue-parameter isIncreasing: kotlin.Boolean\n```
//                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    ): IntProgression {
//     ^^^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntProgression#
        val from = if (isIncreasing) lastVisiblePosition + 1 else firstVisiblePosition - 1
//          ^^^^ definition local 8
//               display_name from
//               documentation ```kt\nval from: kotlin.Int\n```
//                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(isIncreasing)
//                                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(lastVisiblePosition)
//                                                       ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(firstVisiblePosition)
//                                                                                     ^ reference semanticdb maven . . kotlin/Int#minus(+3).
        val to = from + if (isIncreasing) maxItemsToPreload - 1 else 1 - maxItemsToPreload
//          ^^ definition local 9
//             display_name to
//             documentation ```kt\nval to: kotlin.Int\n```
//               ^^^^ reference local 8
//                    ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(isIncreasing)
//                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getMaxItemsToPreload().
//                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#maxItemsToPreload.
//                                                          ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                                     ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getMaxItemsToPreload().
//                                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#maxItemsToPreload.

        return IntProgression.fromClosedRange(
//             ^^^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntProgression#Companion#
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntProgression#Companion#fromClosedRange().
            rangeStart = from.clampToAdapterRange(),
//          ^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntProgression#Companion#fromClosedRange().(rangeStart)
//                       ^^^^ reference local 8
//                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#clampToAdapterRange().
            rangeEnd = to.clampToAdapterRange(),
//          ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntProgression#Companion#fromClosedRange().(rangeEnd)
//                     ^^ reference local 9
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#clampToAdapterRange().
            step = if (isIncreasing) 1 else -1
//          ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntProgression#Companion#fromClosedRange().(step)
//                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(isIncreasing)
//                                          ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
        )
    }

    /** Check if an item index is valid. It may not be if the adapter is empty, or if adapter changes have been dispatched since the last layout pass. */
    private fun Int.isInvalid() = this == RecyclerView.NO_POSITION || this >= totalItemCount
//              ^^^ reference semanticdb maven . . kotlin/Int#
//                  ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#isInvalid().
//                            display_name isInvalid
//                            documentation ```kt\nprivate final fun kotlin.Int.isInvalid(): kotlin.Boolean\n```\n\n----\n\n Check if an item index is valid. It may not be if the adapter is empty, or if adapter changes have been dispatched since the last layout pass.
//                                ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#isInvalid().
//                                     ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                                                    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#isInvalid().
//                                                                         ^^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getTotalItemCount().
//                                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setTotalItemCount().
//                                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#totalItemCount.

    private fun Int.clampToAdapterRange() = min(totalItemCount - 1, max(this, 0))
//              ^^^ reference semanticdb maven . . kotlin/Int#
//                  ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#clampToAdapterRange().
//                                      display_name clampToAdapterRange
//                                      documentation ```kt\nprivate final fun kotlin.Int.clampToAdapterRange(): kotlin.Int\n```
//                                          ^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/math/MathKt#min(+2).
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getTotalItemCount().
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#setTotalItemCount().
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#totalItemCount.
//                                                             ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                                  ^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/math/MathKt#max(+2).
//                                                                      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#clampToAdapterRange().

    private fun preloadAdapterPosition(position: Int) {
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#preloadAdapterPosition().
//                                     display_name preloadAdapterPosition
//                                     documentation ```kt\nprivate final fun preloadAdapterPosition(position: kotlin.Int)\n```
//                                     ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#preloadAdapterPosition().(position)
//                                              display_name position
//                                              documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                               ^^^ reference semanticdb maven . . kotlin/Int#
        @Suppress("UNCHECKED_CAST")
//       ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Suppress#`<init>`().
        val epoxyModel = adapter.getModelForPositionInternal(position) as? EpoxyModel<Any>
//          ^^^^^^^^^^ definition local 10
//                     display_name epoxyModel
//                     documentation ```kt\nval epoxyModel: kotlin.Nothing\n```
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#adapter.
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getAdapter().
//                                                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#preloadAdapterPosition().(position)
//                                                                                    ^^^ reference semanticdb maven . . kotlin/Any#
            ?: return

        @Suppress("UNCHECKED_CAST")
//       ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Suppress#`<init>`().
        val preloader =
//          ^^^^^^^^^ definition local 11
//                    display_name preloader
//                    documentation ```kt\nval preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<[Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>, com.airbnb.epoxy.preload.ViewMetadata?, P>\n```
            modelPreloaders[epoxyModel::class.java] as? EpoxyModelPreloader<EpoxyModel<*>, ViewMetadata?, P>
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getModelPreloaders().
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#modelPreloaders.
//                          ^^^^^^^^^^ reference local 10
//                                            ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/jvm/JvmClassMappingKt#java.
//                                                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                                                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                                                                                        ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#[P]
                ?: return

        viewDataCache
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getViewDataCache().
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#viewDataCache.
            .dataForModel(preloader, epoxyModel, position)
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().
//                        ^^^^^^^^^ reference local 11
//                                   ^^^^^^^^^^ reference local 10
//                                               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#preloadAdapterPosition().(position)
            .forEach { viewData ->
//           ^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#forEach(+10).
//                     ^^^^^^^^ definition local 12
//                              display_name viewData
//                              documentation ```kt\nvalue-parameter viewData: com.airbnb.epoxy.preload.ViewData<com.airbnb.epoxy.preload.ViewMetadata?>\n```
                val preloadTarget = requestHolderFactory.next()
//                  ^^^^^^^^^^^^^ definition local 13
//                                display_name preloadTarget
//                                documentation ```kt\nval preloadTarget: P\n```
//                                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getRequestHolderFactory().
//                                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#requestHolderFactory.
//                                                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#next().
                preloader.startPreload(epoxyModel, preloadTarget, viewData)
//              ^^^^^^^^^ reference local 11
//                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().
//                                     ^^^^^^^^^^ reference local 10
//                                                 ^^^^^^^^^^^^^ reference local 13
//                                                                ^^^^^^^^ reference local 12
            }
    }

    /**
     * Cancels all current preload requests in progress.
     */
    fun cancelPreloadRequests() {
//      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#cancelPreloadRequests().
//                            display_name cancelPreloadRequests
//                            documentation ```kt\npublic final fun cancelPreloadRequests()\n```\n\n----\n\n\n Cancels all current preload requests in progress.\n
        requestHolderFactory.clearAll()
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#getRequestHolderFactory().
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#requestHolderFactory.
//                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#clearAll().
    }

    companion object {
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion# 1:0
//                     display_name Companion
//                     documentation ```kt\npublic companion object\n```

        /**
         *
         * Represents a threshold for fast scrolling.
         * This is a bit arbitrary and was determined by looking at values while flinging vs slow scrolling.
         * Ideally it would be based on DP, but this is simpler.
         */
        private const val FLING_THRESHOLD_PX = 75
//                        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#FLING_THRESHOLD_PX.
//                                           display_name FLING_THRESHOLD_PX
//                                           documentation ```kt\nprivate const final val FLING_THRESHOLD_PX: kotlin.Int\n```\n\n----\n\n\n\n Represents a threshold for fast scrolling.\n This is a bit arbitrary and was determined by looking at values while flinging vs slow scrolling.\n Ideally it would be based on DP, but this is simpler.\n
//                        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#getFLING_THRESHOLD_PX().
//                                           display_name FLING_THRESHOLD_PX
//                                           documentation ```kt\nprivate const final val FLING_THRESHOLD_PX: kotlin.Int\n```\n\n----\n\n\n\n Represents a threshold for fast scrolling.\n This is a bit arbitrary and was determined by looking at values while flinging vs slow scrolling.\n Ideally it would be based on DP, but this is simpler.\n

        /**
         * Helper to create a preload scroll listener. Add the result to your RecyclerView.
         * for different models or content types.
         *
         * @param maxItemsToPreload How many items to prefetch ahead of the last bound item
         * @param errorHandler Called when the preloader encounters an exception. By default this throws only
         * if the app is not in a debuggle model
         * @param modelPreloader Describes how view content for the EpoxyModel should be preloaded
         * @param requestHolderFactory Should create and return a new [PreloadRequestHolder] each time it is invoked
         */
        fun <P : PreloadRequestHolder> with(
//           ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().[P]
//             display_name P
//             documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().
//                                          display_name with
//                                          documentation ```kt\npublic final fun <P : com.airbnb.epoxy.preload.PreloadRequestHolder> with(epoxyController: [Error type: Unresolved type for EpoxyController], requestHolderFactory: () -> P, errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */, maxItemsToPreload: kotlin.Int, modelPreloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<out [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>, out com.airbnb.epoxy.preload.ViewMetadata?, out P>): com.airbnb.epoxy.preload.EpoxyPreloader<P>\n```\n\n----\n\n\n Helper to create a preload scroll listener. Add the result to your RecyclerView.\n for different models or content types.\n\n @param maxItemsToPreload How many items to prefetch ahead of the last bound item\n @param errorHandler Called when the preloader encounters an exception. By default this throws only\n if the app is not in a debuggle model\n @param modelPreloader Describes how view content for the EpoxyModel should be preloaded\n @param requestHolderFactory Should create and return a new [PreloadRequestHolder] each time it is invoked\n
            epoxyController: EpoxyController,
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(epoxyController)
//                          display_name epoxyController
//                          documentation ```kt\nvalue-parameter epoxyController: [Error type: Unresolved type for EpoxyController]\n```
            requestHolderFactory: () -> P,
//          ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(requestHolderFactory)
//                               display_name requestHolderFactory
//                               documentation ```kt\nvalue-parameter requestHolderFactory: () -> P\n```
//                                      ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().[P]
            errorHandler: PreloadErrorHandler,
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(errorHandler)
//                       display_name errorHandler
//                       documentation ```kt\nvalue-parameter errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadErrorHandler#
            maxItemsToPreload: Int,
//          ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(maxItemsToPreload)
//                            display_name maxItemsToPreload
//                            documentation ```kt\nvalue-parameter maxItemsToPreload: kotlin.Int\n```
//                             ^^^ reference semanticdb maven . . kotlin/Int#
            modelPreloader: EpoxyModelPreloader<out EpoxyModel<*>, out ViewMetadata?, out P>
//          ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(modelPreloader)
//                         display_name modelPreloader
//                         documentation ```kt\nvalue-parameter modelPreloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<out [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>, out com.airbnb.epoxy.preload.ViewMetadata?, out P>\n```
//                          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                                                                        ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().[P]
        ): EpoxyPreloader<P> =
//         ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#
//                        ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().[P]
            with(
                epoxyController,
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(epoxyController)
                requestHolderFactory,
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(requestHolderFactory)
                errorHandler,
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(errorHandler)
                maxItemsToPreload,
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(maxItemsToPreload)
                listOf(modelPreloader)
//              ^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#listOf().
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(modelPreloader)
            )

        fun <P : PreloadRequestHolder> with(
//           ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).[P]
//             display_name P
//             documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).
//                                          display_name with
//                                          documentation ```kt\npublic final fun <P : com.airbnb.epoxy.preload.PreloadRequestHolder> with(epoxyController: [Error type: Unresolved type for EpoxyController], requestHolderFactory: () -> P, errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */, maxItemsToPreload: kotlin.Int, modelPreloaders: kotlin.collections.List<com.airbnb.epoxy.preload.EpoxyModelPreloader<out [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>, out com.airbnb.epoxy.preload.ViewMetadata?, out P>>): com.airbnb.epoxy.preload.EpoxyPreloader<P>\n```
            epoxyController: EpoxyController,
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(epoxyController)
//                          display_name epoxyController
//                          documentation ```kt\nvalue-parameter epoxyController: [Error type: Unresolved type for EpoxyController]\n```
            requestHolderFactory: () -> P,
//          ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(requestHolderFactory)
//                               display_name requestHolderFactory
//                               documentation ```kt\nvalue-parameter requestHolderFactory: () -> P\n```
//                                      ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).[P]
            errorHandler: PreloadErrorHandler,
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(errorHandler)
//                       display_name errorHandler
//                       documentation ```kt\nvalue-parameter errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadErrorHandler#
            maxItemsToPreload: Int,
//          ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(maxItemsToPreload)
//                            display_name maxItemsToPreload
//                            documentation ```kt\nvalue-parameter maxItemsToPreload: kotlin.Int\n```
//                             ^^^ reference semanticdb maven . . kotlin/Int#
            modelPreloaders: List<EpoxyModelPreloader<out EpoxyModel<*>, out ViewMetadata?, out P>>
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(modelPreloaders)
//                          display_name modelPreloaders
//                          documentation ```kt\nvalue-parameter modelPreloaders: kotlin.collections.List<com.airbnb.epoxy.preload.EpoxyModelPreloader<out [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>, out com.airbnb.epoxy.preload.ViewMetadata?, out P>>\n```
//                           ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                                                                              ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).[P]
        ): EpoxyPreloader<P> {
//         ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#
//                        ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).[P]

            return EpoxyPreloader(
                epoxyController,
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(epoxyController)
                requestHolderFactory,
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(requestHolderFactory)
                errorHandler,
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(errorHandler)
                maxItemsToPreload,
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(maxItemsToPreload)
                modelPreloaders
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(modelPreloaders)
            )
        }

        /** Helper to create a preload scroll listener. Add the result to your RecyclerView. */
        fun <P : PreloadRequestHolder> with(
//           ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).[P]
//             display_name P
//             documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).
//                                          display_name with
//                                          documentation ```kt\npublic final fun <P : com.airbnb.epoxy.preload.PreloadRequestHolder> with(epoxyAdapter: [Error type: Unresolved type for EpoxyAdapter], requestHolderFactory: () -> P, errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */, maxItemsToPreload: kotlin.Int, modelPreloaders: kotlin.collections.List<com.airbnb.epoxy.preload.EpoxyModelPreloader<out [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>, out com.airbnb.epoxy.preload.ViewMetadata?, out P>>): com.airbnb.epoxy.preload.EpoxyPreloader<P>\n```\n\n----\n\n Helper to create a preload scroll listener. Add the result to your RecyclerView.
            epoxyAdapter: EpoxyAdapter,
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(epoxyAdapter)
//                       display_name epoxyAdapter
//                       documentation ```kt\nvalue-parameter epoxyAdapter: [Error type: Unresolved type for EpoxyAdapter]\n```
            requestHolderFactory: () -> P,
//          ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(requestHolderFactory)
//                               display_name requestHolderFactory
//                               documentation ```kt\nvalue-parameter requestHolderFactory: () -> P\n```
//                                      ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).[P]
            errorHandler: PreloadErrorHandler,
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(errorHandler)
//                       display_name errorHandler
//                       documentation ```kt\nvalue-parameter errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadErrorHandler#
            maxItemsToPreload: Int,
//          ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(maxItemsToPreload)
//                            display_name maxItemsToPreload
//                            documentation ```kt\nvalue-parameter maxItemsToPreload: kotlin.Int\n```
//                             ^^^ reference semanticdb maven . . kotlin/Int#
            modelPreloaders: List<EpoxyModelPreloader<out EpoxyModel<*>, out ViewMetadata?, out P>>
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(modelPreloaders)
//                          display_name modelPreloaders
//                          documentation ```kt\nvalue-parameter modelPreloaders: kotlin.collections.List<com.airbnb.epoxy.preload.EpoxyModelPreloader<out [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>, out com.airbnb.epoxy.preload.ViewMetadata?, out P>>\n```
//                           ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                                                                              ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).[P]
        ): EpoxyPreloader<P> {
//         ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#
//                        ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).[P]

            return EpoxyPreloader(
                epoxyAdapter,
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(epoxyAdapter)
                requestHolderFactory,
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(requestHolderFactory)
                errorHandler,
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(errorHandler)
                maxItemsToPreload,
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(maxItemsToPreload)
                modelPreloaders
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(modelPreloaders)
            )
        }
    }
}

class EpoxyPreloadException(errorMessage: String) : RuntimeException(errorMessage)
//    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloadException#
//                          display_name EpoxyPreloadException
//                          documentation ```kt\npublic final class EpoxyPreloadException : kotlin.RuntimeException /* = java.lang.RuntimeException */\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Throwable#
//                          relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Exception#
//                          relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/RuntimeException#
//    ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloadException#`<init>`().
//                          display_name EpoxyPreloadException
//                          documentation ```kt\npublic constructor EpoxyPreloadException(errorMessage: kotlin.String)\n```
//                          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloadException#`<init>`().(errorMessage)
//                                       display_name errorMessage
//                                       documentation ```kt\nvalue-parameter errorMessage: kotlin.String\n```
//                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/RuntimeException#`<init>`(+1).
//                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloadException#`<init>`().(errorMessage)

typealias PreloadErrorHandler = (Context, RuntimeException) -> Unit
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadErrorHandler#
//                            display_name PreloadErrorHandler
//                            documentation ```kt\npublic typealias PreloadErrorHandler = ([Error type: Unresolved type for Context], kotlin.RuntimeException) -> kotlin.Unit\n```
//                               ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloaderKt#`<no name provided>`.
//                                       display_name RuntimeException
//                                       documentation ```kt\nval `<no name provided>`: kotlin.RuntimeException\n```
//                                        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloaderKt#`<no name provided>`.
//                                                         display_name RuntimeException
//                                                         documentation ```kt\nval `<no name provided>`: kotlin.RuntimeException\n```
//                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/RuntimeException#
//                                                             ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Unit#

/**
 * Data about an image view to be preloaded. This data is used to construct a Glide image request.
 *
 * @param metadata Any custom, additional data that the [EpoxyModelPreloader] chooses to provide that may be necessary to create the image request.
 */
class ViewData<out U : ViewMetadata?>(
//    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#
//             display_name ViewData
//             documentation ```kt\npublic final class ViewData<out U : com.airbnb.epoxy.preload.ViewMetadata?>\n```\n\n----\n\n\n Data about an image view to be preloaded. This data is used to construct a Glide image request.\n\n @param metadata Any custom, additional data that the [EpoxyModelPreloader] chooses to provide that may be necessary to create the image request.\n
//    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#`<init>`().
//             display_name ViewData
//             documentation ```kt\npublic constructor ViewData<out U : com.airbnb.epoxy.preload.ViewMetadata?>(viewId: kotlin.Int, width: kotlin.Int, height: kotlin.Int, metadata: U)\n```
//                 ^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#[U]
//                   display_name U
//                   documentation ```kt\n<out U : com.airbnb.epoxy.preload.ViewMetadata?>\n```
//                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
    @IdRes val viewId: Int,
//   ^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IdRes#`<init>`().
//             ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#`<init>`().(viewId)
//                    display_name viewId
//                    documentation ```kt\nvalue-parameter viewId: kotlin.Int\n```
//             ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#getViewId().
//                    display_name viewId
//                    documentation ```kt\npublic final val viewId: kotlin.Int\n```
//             ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#viewId.
//                    display_name viewId
//                    documentation ```kt\npublic final val viewId: kotlin.Int\n```
//                     ^^^ reference semanticdb maven . . kotlin/Int#
    @Px val width: Int,
//   ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#`<init>`().
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#`<init>`().(width)
//                display_name width
//                documentation ```kt\nvalue-parameter width: kotlin.Int\n```
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#getWidth().
//                display_name width
//                documentation ```kt\npublic final val width: kotlin.Int\n```
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#width.
//                display_name width
//                documentation ```kt\npublic final val width: kotlin.Int\n```
//                 ^^^ reference semanticdb maven . . kotlin/Int#
    @Px val height: Int,
//   ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#`<init>`().
//          ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#`<init>`().(height)
//                 display_name height
//                 documentation ```kt\nvalue-parameter height: kotlin.Int\n```
//          ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#getHeight().
//                 display_name height
//                 documentation ```kt\npublic final val height: kotlin.Int\n```
//          ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#height.
//                 display_name height
//                 documentation ```kt\npublic final val height: kotlin.Int\n```
//                  ^^^ reference semanticdb maven . . kotlin/Int#
    val metadata: U
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#`<init>`().(metadata)
//               display_name metadata
//               documentation ```kt\nvalue-parameter metadata: U\n```
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#getMetadata().
//               display_name metadata
//               documentation ```kt\npublic final val metadata: U\n```
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewData#metadata.
//               display_name metadata
//               documentation ```kt\npublic final val metadata: U\n```
//                ^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewData#[U]
)

interface ViewMetadata {
//        ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                     display_name ViewMetadata
//                     documentation ```kt\npublic interface ViewMetadata\n```
//                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/preload/ImageViewMetadata#
    companion object {
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#Companion# 1:0
//                     display_name Companion
//                     documentation ```kt\npublic companion object\n```
        fun getDefault(view: View): ViewMetadata? {
//          ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#Companion#getDefault().
//                     display_name getDefault
//                     documentation ```kt\npublic final fun getDefault(view: [Error type: Unresolved type for View]): com.airbnb.epoxy.preload.ViewMetadata?\n```
//                     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#Companion#getDefault().(view)
//                          display_name view
//                          documentation ```kt\nvalue-parameter view: [Error type: Unresolved type for View]\n```
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
            return when (view) {
//                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#Companion#getDefault().(view)
                is ImageView -> ImageViewMetadata(view.scaleType)
//                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ImageViewMetadata#`<init>`().
//                                                ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#Companion#getDefault().(view)
                else -> null
            }
        }
    }
}

/**
 * Default implementation of [ViewMetadata] for an ImageView.
 * This data can help the preload request know how to configure itself.
 */
open class ImageViewMetadata(
//         ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ImageViewMetadata#
//                           display_name ImageViewMetadata
//                           documentation ```kt\npublic open class ImageViewMetadata : com.airbnb.epoxy.preload.ViewMetadata\n```\n\n----\n\n\n Default implementation of [ViewMetadata] for an ImageView.\n This data can help the preload request know how to configure itself.\n
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//         ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ImageViewMetadata#`<init>`().
//                           display_name ImageViewMetadata
//                           documentation ```kt\npublic constructor ImageViewMetadata(scaleType: [Error type: Unresolved type for ImageView.ScaleType])\n```
    val scaleType: ImageView.ScaleType
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ImageViewMetadata#`<init>`().(scaleType)
//                display_name scaleType
//                documentation ```kt\nvalue-parameter scaleType: [Error type: Unresolved type for ImageView.ScaleType]\n```
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ImageViewMetadata#getScaleType().
//                display_name scaleType
//                documentation ```kt\npublic final val scaleType: [Error type: Unresolved type for ImageView.ScaleType]\n```
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/ImageViewMetadata#scaleType.
//                display_name scaleType
//                documentation ```kt\npublic final val scaleType: [Error type: Unresolved type for ImageView.ScaleType]\n```
) : ViewMetadata
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
